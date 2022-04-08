package com.mw.eleven11.UI.notifications;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.base.LoaderScroller;
import com.mw.eleven11.beanInput.NotificationDeleteInput;
import com.mw.eleven11.beanInput.NotificationInput;
import com.mw.eleven11.beanInput.NotificationMarkReadInput;
import com.mw.eleven11.beanOutput.DefaultRespose;
import com.mw.eleven11.beanOutput.NotificationsResponse;
import com.mw.eleven11.beanOutput.ResponseLogin;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.EndlessRecyclerViewScrollListenerFab;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class NotificationsFragment extends BaseFragment implements NotificationsView {

    public NotificationsAdapter adapter;
    @BindView(R.id.activity_date_frag)
    RelativeLayout relativeLayoutMain;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.selectAll)
    CheckBox selectAll;
    @BindView(R.id.ll_delete)
    LinearLayout ll_delete;
    private EndlessRecyclerViewScrollListenerFab scrollListener;
    private LinearLayoutManager layoutManager;
    NotificationsPresenterImpl presenterImpl;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Loader loader;
    private LoaderScroller loaderScroller;
    NotificationsActivity mNotifications;
    int flag = 1;
    private List<String> list = new ArrayList<>();

    List<NotificationsResponse.DataBean.RecordsBean> recordsBeans = new ArrayList<>();
    List<String> listIds = new ArrayList<>();

    public static NotificationsFragment getInstance(Bundle bundle) {
        NotificationsFragment friendsFragment = new NotificationsFragment();
        friendsFragment.setArguments(bundle);
        return friendsFragment;
    }

    @OnClick(R.id.ctv_delete)
    public void delete() {

        deleteSelectedNotification();
    }

    @Override
    public int getLayout() {
        return R.layout.notifications_list_fragment;
    }

    private OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            view.findViewById(R.id.hi_main_card).setBackgroundColor(getResources().getColor(R.color.divider_color));
            ImageView imageView = view.findViewById(R.id.ivLogo);
            imageView.setImageResource(R.drawable.ic_message_grey);
            NotificationMarkReadInput markReadInput = new NotificationMarkReadInput();
            markReadInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            markReadInput.setNotificationID(adapter.getNotificationID(position));
            presenterImpl.notificationRead(markReadInput);
            String message = adapter.getMessage(position);
            showPopup(message);
        }
    };

    private OnItemClickListener.OnItemClickCallback onCheckBoxClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
          //  selectAll.setChecked(false);
        }
    };


    @Override
    public void init() {
        mContext = getActivity();
        loader = new Loader(getCurrentView());
        loaderScroller = new LoaderScroller(getCurrentView());
        selectAll.setVisibility(View.GONE);
        ll_delete.setVisibility(View.GONE);
        flag = 0;
        //set layout manager into recyclerView

        mRecyclerView.setNestedScrollingEnabled(true);
        layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);

        // Setup refresh listener which triggers new data loading
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (adapter != null) adapter.clear();
                adapter.flag = 0;
                selectAll.setVisibility(View.GONE);
                ll_delete.setVisibility(View.GONE);
                callTask(1);
            }
        });
        // Configure the refreshing colors
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark,
                R.color.colorAccent,
                R.color.doneIconColor);


        scrollListener = new EndlessRecyclerViewScrollListenerFab(layoutManager) {
            @Override
            public void onLoadMore(int rPage, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                Log.i("loadNextDataFromApi", "loadNextDataFromApi " + rPage);
                callTask(rPage);
            }

            @Override
            public void onShowFab(boolean show) {

            }
        };

        // Adds the scroll listener to RecyclerView
        mRecyclerView.addOnScrollListener(scrollListener);
        scrollListener.resetState();
        if (loader.getTryAgainView() != null)
            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callTask(1);
                }
            });

        presenterImpl = new NotificationsPresenterImpl(this, new UserInteractor());
        adapter = new NotificationsAdapter(R.layout.list_item_no_notifications, getActivity(),
                recordsBeans, onItemClickCallback, onCheckBoxClickCallback, flag);
        mRecyclerView.setAdapter(adapter);

        callTask(1);

        selectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectAll.isChecked()) {
                    adapter.flag = 2;
                    adapter.notifyDataSetChanged();
                } else {
                    adapter.flag = 1;
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }

    public void deleteAllNotification() {
        if (!selectAll.isChecked()) {
            adapter.flag = 1;
            selectAll.setVisibility(View.VISIBLE);
            adapter.notifyDataSetChanged();
            ll_delete.setVisibility(View.VISIBLE);
        }
        // showPopup();
    }

    public void deleteSelectedNotification() {

        if (adapter.countSelectedCheckedbox().size() > 0) {
            Log.d("LIST", "list = " + adapter.countSelectedCheckedbox());

            NotificationDeleteInput mDeleteInput = new NotificationDeleteInput();
            mDeleteInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            if (selectAll.isChecked()) {
                mDeleteInput.setNotificationIDs(list);
            }else {
                mDeleteInput.setNotificationIDs(adapter.countSelectedCheckedbox());
            }

            presenterImpl.deleteNotification(mDeleteInput);

        } else {
            AppUtils.showToast(mContext,"Please select atleast one notification");
        }

        selectAll.setChecked(false);

    }

    public void showPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.delete_notifications)
                .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        NotificationDeleteInput mDeleteInput = new NotificationDeleteInput();
                        mDeleteInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
                        presenterImpl.deleteNotification(mDeleteInput);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void showPopup(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message)
                .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
               /* .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                })*/;
        // Create the AlertDialog object and return it

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void callTask(int pageNo) {
        NotificationInput notificationInput = new NotificationInput();
        notificationInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        notificationInput.setPageNo(pageNo);
        notificationInput.setPageSize(Constant.PAGE_LIMIT);
        presenterImpl.actionNotificationsList(notificationInput);
    }

    @Override
    public void onLoadingError(String value) {
        loader.error(value);
    }

    @Override
    public void onLoadingSuccess(NotificationsResponse response) {

        if (isLayoutAdded() && mRecyclerView != null) {

            adapter.clear();
            adapter.addAllItem(response.getData().getRecords());
            if (response.getData().getRecords() == null || response.getData().getRecords().size() == 0) {

                loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.ic_no_notification));
                loader.dataNotFound("No Notification Found");
                ((NotificationsActivity) getActivity()).hideDeleteMenu();

                //onShowSnackBar("No Notification Found");
                //Toast.makeText(mContext, "hi", Toast.LENGTH_SHORT).show();
            } else
                ((NotificationsActivity) getActivity()).showDeleteMenu();

         /*    sendBadgesIntent("0");

            presenterImpl.clear_badges(AppSession.getInstance().getLoginSession().getResponse().getLoginSessionKey());*/
        }
    }

    @Override
    public void onHideScrollLoading() {
        loaderScroller.hide();
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onShowScrollLoading() {
        loaderScroller.show();
    }


    @Override
    public void onScrollLoadingError(String value) {
        loaderScroller.error(value);
    }

    @Override
    public void onScrollLoadingSuccess(NotificationsResponse response) {
        adapter.addAllItem(response.getData().getRecords());
    }

    @Override
    public void onScrollLoadingNotFound(String value) {
        loaderScroller.hide();
    }

    @Override
    public void onNotificationMarkReadSuccess(DefaultRespose respose) {
        onHideLoading();
        hideLoading();
    }

    @Override
    public void onNotificationMarkReadFailure(String errMsg) {
        onHideLoading();
        hideLoading();
        onShowSnackBar(errMsg);
    }

    @Override
    public void onHideLoading() {
        loader.hide();
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onReadSuccess(ResponseLogin mResponseLogin) {
        hideLoading();
    }

    @Override
    public void onReadError(String error) {
        hideLoading();
    }

    @Override
    public void onShowLoading() {
        loader.hide();
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onLoadingNotFound(String value) {
        loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.ic_no_notification));
        loader.dataNotFound(value);
    }

    @Override
    public void onDeleteNotificationSuccess(DefaultRespose mResponseLogin) {
        onHideLoading();

        if (mResponseLogin.getResponseCode() == 200) {
            onShowSnackBar("Notification Deleted");
        }

        /*if (mResponseLogin != null) {
            adapter.clear();
            loader.dataNotFound("No Notification Found");
            loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.ic_no_notification));
            ((NotificationsActivity)getActivity()).hideDeleteMenu();
        }*/
        adapter.flag = 0;
        selectAll.setVisibility(View.GONE);
        ll_delete.setVisibility(View.GONE);
        callTask(1);
    }

    @Override
    public void onDeleteNotificationFailure(String error) {
        onHideLoading();
        onShowSnackBar(error);
    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public boolean isLayoutAdded() {
        return (isAdded() && getActivity() != null);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();
    }

    @Override
    public void onShowSnackBar(@NonNull String message) {
        // Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        AppUtils.showSnackBar(mContext, relativeLayoutMain, message);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mProgressDialog != null) mProgressDialog.dismiss();
    }
}
