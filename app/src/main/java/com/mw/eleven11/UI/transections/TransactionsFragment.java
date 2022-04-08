package com.mw.eleven11.UI.transections;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.base.LoaderScroller;
import com.mw.eleven11.beanInput.TransactionInput;
import com.mw.eleven11.beanOutput.TransactionsBean;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.DatePickerDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.EndlessRecyclerViewScrollListenerFab;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransactionsFragment extends BaseFragment implements TransactionsView {

    private EndlessRecyclerViewScrollListenerFab scrollListener;
    private LinearLayoutManager layoutManager;
    public TransactionsAdapter adapter;
    private TransactionsPresenterImpl presenterImpl;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Loader loader;
    private LoaderScroller loaderScroller;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;


    @BindView(R.id.tv_from_date)
    CustomTextView tvFromDate;
    @BindView(R.id.tv_to_date)
    CustomTextView tvToDate;

    List< TransactionsBean.DataBean.RecordsBean> recordsBeans= new ArrayList<>();


    String type = "", fromDate="", toDate="", cashType="";

    public static TransactionsFragment getInstance( String type) {
        TransactionsFragment friendsFragment = new TransactionsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        friendsFragment.setArguments(bundle);
        return friendsFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        if (getArguments() != null) {
            if (getArguments().containsKey("type")) {
                type = getArguments().getString("type");
            }
        }
        LocalBroadcastManager.getInstance(mContext).registerReceiver(updates_receiver,
                new IntentFilter(TransactionsFragment.class.getName()));

    }

    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(updates_receiver);
        if (presenterImpl != null) presenterImpl.actionListingCancel();
    }

    private BroadcastReceiver updates_receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent i) {
            if (i.getAction().equals(TransactionsFragment.class.getName())) {
                if (i.hasExtra("notificationType")) {

                } else {
                    refreshCall();
                }
            }
        }
    };

    @Override
    public int getLayout() {
        return R.layout.transection_list_fragment;
    }

    @Override
    public void init() {
        mContext = getActivity();
        loader = new Loader(getCurrentView());
        loaderScroller = new LoaderScroller(getCurrentView());
        //set layout manager into recyclerView
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
       // mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setNestedScrollingEnabled(true);
        layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);



        // Setup refresh listener which triggers new data loading
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                refreshCall();
            }
        });
        // Configure the refreshing colors
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark,
                R.color.colorAccent,
                R.color.green);


        if (loader.getTryAgainView() != null)
            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    refreshCall();
                }
            });


        scrollListener = new EndlessRecyclerViewScrollListenerFab(layoutManager) {
            @Override
            public void onLoadMore(int rPage, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                Log.i("loadNextDataFromApi", "loadNextDataFromApi " + rPage);
                callTask();
            }

            @Override
            public void onShowFab(boolean show) {

            }
        };

        // Adds the scroll listener to RecyclerView
        mRecyclerView.addOnScrollListener(scrollListener);
        scrollListener.resetState();

        presenterImpl = new TransactionsPresenterImpl(this, new UserInteractor());
        //call task first time
        scrollListener.resetState();

        adapter = new TransactionsAdapter(type, R.layout.list_item_transaction, getActivity(),
                recordsBeans, onItemClickCallback, onEditItemClickCallback, onDeleteItemClickCallback);

        mRecyclerView.setAdapter(adapter);

        callTask();
    }

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    @OnClick(R.id.tv_from_date)
    public void fromDate(View view) {
        if (fromDatePickerDialog == null) {
            Calendar calendar = Calendar.getInstance();
            fromDatePickerDialog = new DatePickerDialog(mContext, calendar, AppUtils.getStrFromRes(R.string.please_select_date), new DatePickerDialog.OnClickListener() {
                @Override
                public void onDateSet(String date) {
                    tvFromDate.setText(date);
                    fromDate=fromDatePickerDialog.getStandardDateOnly();
                    if (toDatePickerDialog != null) {
                        if (toDatePickerDialog.getCalendar().getTimeInMillis()<fromDatePickerDialog.getCalendar().getTimeInMillis()) {
                            toDatePickerDialog.setCalendar((Calendar) fromDatePickerDialog.getCalendar().clone());
                            tvToDate.setText(toDatePickerDialog.getShowDate());
                            toDate=toDatePickerDialog.getStandardDateOnly();
                        }
                    }

                    refreshCall();
                }
                @Override
                public void onStandardDateFormat(String date) {

                }
            });
            fromDatePickerDialog.setMaxDate(Calendar.getInstance());
        }
        fromDatePickerDialog.show();
    }

    @OnClick(R.id.tv_to_date)
    public void toDate(View view) {

        if (fromDatePickerDialog == null) {
            onShowSnackBar(AppUtils.getStrFromRes(R.string.please_select_from_date_first));
            return;
        }
        Calendar calendar = (Calendar) fromDatePickerDialog.getCalendar().clone();
        toDatePickerDialog = new DatePickerDialog(mContext, calendar, AppUtils.getStrFromRes(R.string.please_select_date), new DatePickerDialog.OnClickListener() {
            @Override
            public void onDateSet(String date) {
                tvToDate.setText(date);
                toDate=toDatePickerDialog.getStandardDateOnly();

                refreshCall();
            }

            @Override
            public void onStandardDateFormat(String date) {

            }
        });
        calendar.add(Calendar.MINUTE, -1);
        toDatePickerDialog.setMinDate(calendar);
        toDatePickerDialog.setMaxDate(Calendar.getInstance());
        toDatePickerDialog.show();
    }
    public void refreshCall() {
        if (adapter != null) adapter.clear();
        scrollListener.resetState();
        callTask();
    }
    public void callTask() {

        TransactionInput transactionInput= new TransactionInput();
        transactionInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        transactionInput.setParams(Constant.TRANSACTION_PARAMS);
        transactionInput.setPageNo(Constant.PAGE_LIMIT);
        transactionInput.setPageSize(adapter.getItemCount());
        transactionInput.setTransactionMode("All");
        transactionInput.setSequence("DESC");

        presenterImpl.actionListing(transactionInput);
    }

    private OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

        }
    };
    private OnItemClickListener.OnItemClickCallback onEditItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

        }
    };
    private OnItemClickListener.OnItemClickCallback onDeleteItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

        }
    };

    @Override
    public void onLoadingError(String value) {
        loader.error(value);
    }

    @Override
    public void onLoadingSuccess(TransactionsBean response) {
        if (isLayoutAdded() && mRecyclerView != null) {
            adapter.addAllItem(response.getData().getRecords());
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
    public void onScrollLoadingSuccess(TransactionsBean response) {
        adapter.addAllItem(response.getData().getRecords());
    }

    @Override
    public void onScrollLoadingNotFound(String value) {
        loaderScroller.hide();
    }

    @Override
    public void onHideLoading() {
        loader.hide();

        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onShowLoading() {
        loader.hide();

        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onLoadingNotFound(String value) {
        loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.ic_transaction));
        loader.dataNotFound(value);
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
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
