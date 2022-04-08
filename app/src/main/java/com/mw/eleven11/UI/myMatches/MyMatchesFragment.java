package com.mw.eleven11.UI.myMatches;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.contestDetail.ContestDetail;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.joinedContests.AllJoinedContest;
import com.mw.eleven11.UI.loginRagisterModule.LoginScreen;
import com.mw.eleven11.UI.matches.MatchSeriesAdapter;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.base.LoaderScroller;
import com.mw.eleven11.beanInput.MyContestMatchesInput;
import com.mw.eleven11.beanOutput.JoinedContestOutput;
import com.mw.eleven11.beanOutput.MatchContestOutPut;
import com.mw.eleven11.beanOutput.MyContestMatchesOutput;
import com.mw.eleven11.beanOutput.SeriesOutput;
import com.mw.eleven11.beanOutput.ResponseMatches;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.EndlessRecyclerViewScrollListenerFab;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyMatchesFragment extends BaseFragment implements MyMatchesView {
    public MyMatchesAdapter adapter;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;
    String seriesId = "", type = "";
    int tag = 0;
    int gametype = 0;
    String appLinkData = "";
    BottomSheetDialog mBottomSheetDialog;
    MatchSeriesAdapter mMatchSeriesAdapter;
    @BindView(R.id.series)
    CustomTextView series;
    @BindView(R.id.selectMatch)
    CustomTextView selectMatch;
    List<ResponseMatches.ResponseBean> matchesList = new ArrayList<>();
    SeriesOutput mResponseMatchSeries;
    List<SeriesOutput.DataBean.RecordsBean> selectedSeries = new ArrayList<>();
    private EndlessRecyclerViewScrollListenerFab scrollListener;
    private LinearLayoutManager layoutManager;
    //    private List<JoinedContestOutput.DataBean.RecordsBean> mRecordsBean = new ArrayList<>();
    private List<MyContestMatchesOutput.DataBean.RecordsBean> mRecordsBean = new ArrayList<>();
    private MyMatchesPresenterImpl presenterImpl;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Loader loader;
    private LoaderScroller loaderScroller;
    private BroadcastReceiver updates_receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent i) {
            if (i.getAction().equals(MyMatchesFragment.class.getName())) {
                if (i.hasExtra("notificationType")) {

                } else {
                    if (adapter != null) adapter.clear();
                    scrollListener.resetState();
                    callTask(gametype, type, 1);
                }
            }
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
    private OnItemClickListener.OnItemClickCallback onSelectedSeriesCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {


        }
    };
    private OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {


           /* AllJoinedContest.start(mContext,adapter.getMatchItem(position).getMatchGUID(),
                    adapter.getMatchItem(position).getStatus());*/

            if (type.equals("FIXTURE")) {
                AllJoinedContest.start(mContext, adapter.getMatchItem(position).getMatchGUID(),
                        adapter.getMatchItem(position).getStatus());
            } else if (type.equals("LIVE")) {
                ContestDetail.start(mContext, adapter.getMatchItem(position).getMatchGUID(),
                        adapter.getMatchItem(position).getStatus());
            } else if (type.equals("COMPLETED")) {

                if (adapter.getMatchItem(position).getStatus().equals("Abandoned") || adapter.getMatchItem(position).getStatus().equals(Constant.Cancelled)) {
                    Toast.makeText(mContext, "This match is " + adapter.getMatchItem(position).getStatus(), Toast.LENGTH_SHORT).show();
                } else {
                    ContestDetail.start(mContext, adapter.getMatchItem(position).getMatchGUID(),
                            adapter.getMatchItem(position).getStatus());
                }

            }


        }
    };

    public static MyMatchesFragment getInstance(String seriesId, String type, int gametype, String appLinkData, Bundle dataExtra) {
        MyMatchesFragment friendsFragment = new MyMatchesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("seriesId", seriesId);
        bundle.putString("type", type);
        bundle.putInt("gametype", gametype);
        bundle.putString("appLinkData", appLinkData);
        bundle.putBundle("dataExtra", dataExtra);

        friendsFragment.setArguments(bundle);
        return friendsFragment;
    }

    public static MyMatchesFragment getInstance(String seriesId, String type, int gametype, int tag) {
        MyMatchesFragment friendsFragment = new MyMatchesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("seriesId", seriesId);
        bundle.putString("type", type);
        bundle.putInt("gametype", gametype);
        bundle.putInt("tag", tag);
        friendsFragment.setArguments(bundle);

        return friendsFragment;
    }

    @OnClick(R.id.series)
    void onSeriesClick() {

        if (mBottomSheetDialog != null) {

            mBottomSheetDialog.show();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();

        mResponseMatchSeries = new SeriesOutput();
        mBottomSheetDialog = new BottomSheetDialog(getActivity());
        if (getArguments() != null) {

            if (getArguments().containsKey("seriesId")) {
                seriesId = getArguments().getString("seriesId");
            }
            if (getArguments().containsKey("type")) {
                type = getArguments().getString("type");
            }
            if (getArguments().containsKey("gametype")) {
                gametype = getArguments().getInt("gametype");
            }

            if (getArguments().containsKey("tag")) {
                tag = getArguments().getInt("tag");
            }
            if (getArguments().containsKey("appLinkData")) {
                appLinkData = getArguments().getString("appLinkData");
            }


            if (getArguments().containsKey("dataExtra")) {

                getArguments().getBundle("dataExtra").getString("matchId");

                /*ContestActivity.start(getActivity(),mJoinedContestBean.getResponse().getMatchDateTime(),
                        getArguments().getBundle("dataExtra").getString("matchId"),remaingTime,
                        mJoinedContestBean.getResponse().getMatchDate() ,
                        mJoinedContestBean.getResponse().getMatchTime(),mJoinedContestBean);*/

            }

        }
        LocalBroadcastManager.getInstance(mContext).registerReceiver(updates_receiver, new IntentFilter(MyMatchesFragment.class.getName()));

    }

    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(updates_receiver);
        if (presenterImpl != null) presenterImpl.actionListingCancel();
    }

    @Override
    public int getLayout() {
        return R.layout.matches_fragment;
    }

    @Override
    public void init() {
        mContext = getActivity();
        loader = new Loader(getCurrentView());
        loaderScroller = new LoaderScroller(getCurrentView());
        //set layout manager into recyclerView
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setNestedScrollingEnabled(true);

        layoutManager = new LinearLayoutManager(getContext()) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // initSpruce();
            }
        };
        mRecyclerView.setLayoutManager(layoutManager);

        // Setup refresh listener which triggers new data loading
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                if (adapter != null) adapter.clear();
                if (scrollListener != null)
                    scrollListener.resetState();
                callTask(gametype, type, 1);
            }
        });
        // Configure the refreshing colors
        swipeRefreshLayout.setColorSchemeResources(R.color.header_background_home_page,
                R.color.header_background_home_page,
                R.color.secondary_tab_color);

        if (loader.getTryAgainView() != null)
            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (scrollListener != null)
                        scrollListener.resetState();
                    callTask(gametype, type, 1);
                }
            });


        scrollListener = new EndlessRecyclerViewScrollListenerFab(layoutManager) {
            @Override
            public void onLoadMore(int rPage, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                Log.i("loadNextDataFromApi", "loadNextDataFromApi " + rPage);
                callTask(gametype, type, rPage);
            }

            @Override
            public void onShowFab(boolean show) {

            }
        };

        // Adds the scroll listener to RecyclerView
        mRecyclerView.addOnScrollListener(scrollListener);
        scrollListener.resetState();

        presenterImpl = new MyMatchesPresenterImpl(this, new UserInteractor());
        //call task first time

        adapter = new MyMatchesAdapter(tag, type, R.layout.list_item_matches, getActivity(), gametype,
                mRecordsBean,
                onItemClickCallback, onEditItemClickCallback, onDeleteItemClickCallback);


        mRecyclerView.setAdapter(adapter);
        callTask(gametype, type, 1);
    }

    public void callTask(int gametype, String type, int PAGE_NO) {

        String statusId = "1";

       /* JoinedContestInput mMatchListInput = new JoinedContestInput();
        mMatchListInput.setPageNo(PAGE_NO);
        mMatchListInput.setPageSize(Constant.PAGE_LIMIT);
        mMatchListInput.setParams(Constant.JOINEDCONTEST_PARAM);
        mMatchListInput.setGetJoinedMatches("Yes");
        mMatchListInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchListInput.setStatus(Constant.Pending);
        mMatchListInput.setPrivacy("All");
        mMatchListInput.setMyJoinedContest("Yes");

        switch (type) {
            case "FIXTURE":
                statusId = Constant.Pending;
                selectMatch.setVisibility(View.GONE);
                break;

            case "LIVE":

                statusId = Constant.Running;
                mMatchListInput.setOrderBy("MatchStartDateTime");
                mMatchListInput.setSequence("DESC");

                break;

            case "COMPLETED":

                statusId = Constant.Completed;
                mMatchListInput.setOrderBy("MatchStartDateTime");
                mMatchListInput.setSequence("DESC");
                break;
        }
        mMatchListInput.setStatus(statusId);

        presenterImpl.actionListing(mMatchListInput);*/

        MyContestMatchesInput myContestMatchesInput = new MyContestMatchesInput();

        myContestMatchesInput.setPageNo(PAGE_NO);
        myContestMatchesInput.setPageSize(Constant.PAGE_LIMIT);
        myContestMatchesInput.setParams(Constant.JOINEDCONTEST_PARAM);
        myContestMatchesInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        myContestMatchesInput.setStatus(Constant.Pending);
        myContestMatchesInput.setPrivacy("All");
        myContestMatchesInput.setMyJoinedContest("Yes");
        myContestMatchesInput.setFilter("MyJoinedMatch");

        switch (type) {
            case "FIXTURE":
                statusId = Constant.Pending;
                selectMatch.setVisibility(View.GONE);
                break;

            case "LIVE":
                statusId = Constant.Running;
                myContestMatchesInput.setOrderBy("MatchStartDateTime");
                myContestMatchesInput.setSequence("DESC");
                break;

            case "COMPLETED":
                statusId = Constant.Completed;
                myContestMatchesInput.setOrderBy("MatchStartDateTime");
                myContestMatchesInput.setSequence("DESC");
                break;
        }
        myContestMatchesInput.setStatus(statusId);

        presenterImpl.myContestactionListing(myContestMatchesInput);

    }

    @Override
    public void onLoadingError(String value) {
        loader.error(value);
    }

    @Override
    public void onLoadingSuccess(JoinedContestOutput response) {
        if (isLayoutAdded() && mRecyclerView != null) {
           /* adapter.clearData();
            adapter.addAllItem(response.getData().getRecords());
*/
            if (mBottomSheetDialog.isShowing()) {
                mBottomSheetDialog.dismiss();
            }
        }
    }

    @Override
    public void onHideScrollLoading() {
        loaderScroller.hide();
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
    public void onScrollLoadingSuccess(JoinedContestOutput response) {
        // adapter.addAllItem(response.getData().getRecords());
    }

    @Override
    public void onScrollLoadingNotFound(String value) {
        loaderScroller.hide();
        loader.error(value);
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
        if (gametype == 1) {
            loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.ic_cricket_match_contest_not_joined));
        } else if (gametype == 2) {
            loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.ic_football_match_contest_not_joined));
        } else {
            loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.not_found_img));
        }
        //loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.not_found_img));
        loader.dataNotFound(value);

        if (tag == 1) {
            loader.error(value);
            loader.getTryAgainView().setText(AppUtils.getStrFromRes(R.string.join_contest));
            switch (type) {
                case "FIXTURE":
                    loader.dataNotFound("You haven’t joined any upcoming contests. Join contests for any of the upcoming matches.");
                    loader.error("You haven’t joined any upcoming contests. Join contests for any of the upcoming matches.");
                    break;
                case "LIVE":
                    loader.dataNotFound("You haven't joined any contests that are live. Join contests for any of the upcoming matches.");
                    loader.error("You haven't joined any contests that are live. Join contests for any of the upcoming matches.");
                    break;
                case "COMPLETED":
                    loader.dataNotFound("You haven't joined any contests that completed recently. Join contests for any of the upcoming matches.");
                    loader.error("You haven't joined any contests that completed recently. Join contests for any of the upcoming matches.");
                    break;
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                loader.getTryAgainView().setBackground(getResources().getDrawable(R.drawable.greenstyle_button));
            } else {

            }
            loader.getTryAgainView().setPadding(ViewUtils.dpToPx(20), ViewUtils.dpToPx(10), ViewUtils.dpToPx(20), ViewUtils.dpToPx(10));
            if (loader.getTryAgainView() != null)


                loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (scrollListener != null)
                            scrollListener.resetState();

                        HomeNavigation.start(getActivity());


                    }
                });
        }

    }


    @Override
    public boolean isLayoutAdded() {
        return (isAdded() && getActivity() != null);
    }

    @Override
    public void onClearLogout() {
        AppSession.getInstance().clearSession();
        LoginScreen.start(mContext);
    }

    @Override
    public void onMyContestLoadingSuccess(MyContestMatchesOutput mJoinedContestOutput) {

        if (isLayoutAdded() && mRecyclerView != null) {

            //  mRecordsBean = mJoinedContestOutput.getData().getRecords();

            adapter.clearData();
            adapter.addAllItem(mJoinedContestOutput.getData().getRecords());

            if (mBottomSheetDialog.isShowing()) {
                mBottomSheetDialog.dismiss();
            }
        }
    }

    @Override
    public void onMyContestLoadingError(String value) {
        loader.error(value);
    }

    @Override
    public void onMyContestLoadingNotFound(String value) {
        if (gametype == 1) {
            loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.ic_cricket_match_contest_not_joined));
        } else if (gametype == 2) {
            loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.ic_football_match_contest_not_joined));
        } else {
            loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.not_found_img));
        }

        loader.dataNotFound(value);

        if (tag == 1) {
            loader.error(value);
            loader.getTryAgainView().setText(AppUtils.getStrFromRes(R.string.join_contest));

            switch (type) {
                case "FIXTURE":
                    loader.dataNotFound("You haven’t joined any upcoming contests. Join contests for any of the upcoming matches.");
                    loader.error("You haven’t joined any upcoming contests. Join contests for any of the upcoming matches.");
                    break;
                case "LIVE":
                    loader.dataNotFound("You haven't joined any contests that are live. Join contests for any of the upcoming matches.");
                    loader.error("You haven't joined any contests that are live. Join contests for any of the upcoming matches.");
                    break;
                case "COMPLETED":
                    loader.dataNotFound("You haven't joined any contests that completed recently. Join contests for any of the upcoming matches.");
                    loader.error("You haven't joined any contests that completed recently. Join contests for any of the upcoming matches.");
                    break;
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                loader.getTryAgainView().setBackground(getResources().getDrawable(R.drawable.greenstyle_button));
            } else {

            }
            loader.getTryAgainView().setPadding(ViewUtils.dpToPx(20), ViewUtils.dpToPx(10), ViewUtils.dpToPx(20), ViewUtils.dpToPx(10));
            if (loader.getTryAgainView() != null)


                loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (scrollListener != null)
                            scrollListener.resetState();

                        HomeNavigation.start(getActivity());

                    }
                });
        }
    }

    @Override
    public void onMyContestScrollLoadingSuccess(MyContestMatchesOutput mJoinedContestOutput) {

        //  mRecordsBean = mJoinedContestOutput.getData().getRecords();

        adapter.addAllItem(mJoinedContestOutput.getData().getRecords());
    }

    @Override
    public void onMyContestScrollLoadingError(String value) {
        loaderScroller.error(value);
    }

    @Override
    public void onMyContestScrollLoadingNotFound(String value) {
        loaderScroller.hide();
        loader.error(value);
    }

    @Override
    public void onMatchContestSuccess(MatchContestOutPut responseLogin) {

    }

    @Override
    public void onMatchContestFailure(String errMsg) {

    }


    @Override
    public void onShowSnackBar(@NonNull String message) {
        AppUtils.showToast(mContext, message);
    }


    public void init_modal_bottomsheet(final SeriesOutput mMatchSeries) {

        View modalbottomsheet = getLayoutInflater().inflate(R.layout.modal_bottomsheet, null);

        mBottomSheetDialog.setContentView(modalbottomsheet);
        mBottomSheetDialog.setCanceledOnTouchOutside(true);
        mBottomSheetDialog.setCancelable(false);

        RecyclerView mSeriesRecyclerView = (RecyclerView) modalbottomsheet.findViewById(R.id.recycler_view_series);
        CustomTextView ctv_reset = (CustomTextView) modalbottomsheet.findViewById(R.id.ctv_reset);
        CustomTextView ctv_close = (CustomTextView) modalbottomsheet.findViewById(R.id.ctv_close);

        CustomTextView ctv_next = (CustomTextView) modalbottomsheet.findViewById(R.id.ctv_next);


        mSeriesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        mMatchSeriesAdapter = new MatchSeriesAdapter(getActivity(), R.layout.list_item_series, mMatchSeries.getData().getRecords(), onSelectedSeriesCallback);

        mSeriesRecyclerView.setAdapter(mMatchSeriesAdapter);

        ctv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog.dismiss();

            }
        });

        ctv_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMatchSeriesAdapter.notifyDataSetChanged();


                mMatchSeriesAdapter.resetItems();

            }
        });


        ctv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                seriesId = mMatchSeriesAdapter.getSelectedItem();

                Log.d("seriesId", seriesId);

                adapter.clearData();


                callTask(gametype, type, 1);

                mBottomSheetDialog.dismiss();


            }
        });

    }

}
