package com.mw.eleven11.UI.matches;

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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.contestDetail.ContestDetail;

import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.joinedContests.AllJoinedContest;
import com.mw.eleven11.UI.loginRagisterModule.LoginScreen;
import com.mw.eleven11.UI.matchContest.MatchContestActivity;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.base.LoaderScroller;
import com.mw.eleven11.beanInput.MatchListInput;
import com.mw.eleven11.beanOutput.CheckContestBean;
import com.mw.eleven11.beanOutput.MatchResponseOut;
import com.mw.eleven11.beanOutput.SeriesOutput;
import com.mw.eleven11.beanOutput.ResponseMatches;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.EndlessRecyclerViewScrollListenerFab;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MatchesFragment extends BaseFragment implements MatchesView {

    private EndlessRecyclerViewScrollListenerFab scrollListener;
    private LinearLayoutManager layoutManager;

    public MatchesAdapter adapter;
    private List<MatchResponseOut.DataBean.RecordsBean> mRecordsBean = new ArrayList<>();


    private MatchesPresenterImpl presenterImpl;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Loader loader;
    private LoaderScroller loaderScroller;


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;
    String seriesId = "", type = "";
    int tag = 0;
    int upcomingMatchesTime = 0;
    int gametype = 0;

    String appLinkData = "";

    BottomSheetDialog mBottomSheetDialog;

    MatchSeriesAdapter mMatchSeriesAdapter;

    @BindView(R.id.series)
    CustomTextView series;

    @BindView(R.id.selectMatch)
    CustomTextView selectMatch;

    @BindView(R.id.no_matches)
    LinearLayout no_matches;

    @BindView(R.id.matches)
    LinearLayout matches;


    @OnClick(R.id.series)
    void onSeriesClick() {

        if (mBottomSheetDialog != null) {

            mBottomSheetDialog.show();
        }
    }

    List<ResponseMatches.ResponseBean> matchesList = new ArrayList<>();

    SeriesOutput mResponseMatchSeries;

    List<SeriesOutput.DataBean.RecordsBean> selectedSeries = new ArrayList<>();

    public static MatchesFragment getInstance(Bundle bundle) {
        MatchesFragment friendsFragment = new MatchesFragment();
        friendsFragment.setArguments(bundle);
        return friendsFragment;
    }

    public static MatchesFragment getInstance(String seriesId, String type, int gametype, String appLinkData, Bundle dataExtra) {
        MatchesFragment friendsFragment = new MatchesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("seriesId", seriesId);
        bundle.putString("type", type);
        bundle.putInt("gametype", gametype);
        bundle.putString("appLinkData", appLinkData);
        bundle.putBundle("dataExtra", dataExtra);

        friendsFragment.setArguments(bundle);
        return friendsFragment;
    }

    public static MatchesFragment getInstance(String seriesId, String type, int gametype, int tag) {
        MatchesFragment friendsFragment = new MatchesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("seriesId", seriesId);
        bundle.putString("type", type);
        bundle.putInt("gametype", gametype);
        bundle.putInt("tag", tag);
        friendsFragment.setArguments(bundle);

        return friendsFragment;
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
        LocalBroadcastManager.getInstance(mContext).registerReceiver(updates_receiver, new IntentFilter(MatchesFragment.class.getName()));

    }

    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(updates_receiver);
        if (presenterImpl != null) presenterImpl.actionListingCancel();
    }

    private BroadcastReceiver updates_receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent i) {
            if (i.getAction().equals(MatchesFragment.class.getName())) {
                if (i.hasExtra("notificationType")) {

                } else {
                   /* if (adapter != null) adapter.clear();
                    scrollListener.resetState();
                    callTask(gametype);*/
                }
            }
        }
    };

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
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset_very_less);
        mRecyclerView.addItemDecoration(itemDecoration);
//        mRecyclerView.setNestedScrollingEnabled(true);

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
                if (getArguments().getString("Status") == null) {
                    callTask(gametype, type, rPage);
                }
            }

            @Override
            public void onShowFab(boolean show) {

            }
        };

        // Adds the scroll listener to RecyclerView
        mRecyclerView.addOnScrollListener(scrollListener);
        scrollListener.resetState();

        presenterImpl = new MatchesPresenterImpl(this, new UserInteractor());
        //call task first time

        if (tag == 0) {
            adapter = new MatchesAdapter(type, R.layout.list_item_matches, getActivity(), gametype,
                    mRecordsBean,
                    onItemClickCallback, onEditItemClickCallback, onDeleteItemClickCallback,upcomingMatchesTime);
        }

        mRecyclerView.setAdapter(adapter);
        callTask(gametype, type, 1);
        //callSeries();
    }

    private void callSeries() {
        switch (AppSession.getInstance().getGameType()) {
            case 1:
                presenterImpl.actionMatchSeries(AppSession.getInstance().getLoginSession().getData().getSessionKey());
                break;

        }
    }


    public void callTask(int gametype, String type, int PAGE_NO) {

        String statusId = "1";

        MatchListInput mMatchListInput = new MatchListInput();
        mMatchListInput.setPageNo(PAGE_NO);
        mMatchListInput.setPageSize(Constant.PAGE_LIMIT);
        mMatchListInput.setParams(Constant.MATCH_PARAMS);
        mMatchListInput.setFilter("AddDays");

        switch (type) {
            case "FIXTURE":
                mMatchListInput.setParams(Constant.MATCH_PARAMS+",IsMegaContest");
                statusId = Constant.Pending;
                selectMatch.setVisibility(View.GONE);
                break;

            case "LIVE":
                statusId = Constant.Running;
                mMatchListInput.setFilter("Today");
                mMatchListInput.setOrderBy("MatchStartDateTime");
                mMatchListInput.setSequence("DESC");
                break;

            case "COMPLETED":
                statusId = Constant.Completed;
                mMatchListInput.setOrderBy("MatchStartDateTime");
                mMatchListInput.setSequence("DESC");
                mMatchListInput.setPageSize(Constant.PAGE_LIMIT15);
                mMatchListInput.setMatchStartDateTimeComplete(TimeUtils.getPast10DayDate());
                break;
        }
        mMatchListInput.setStatus(statusId);

        if (getArguments().get("Status") != null) {
            mMatchListInput.setStatus(Constant.Pending);
            mMatchListInput.setPageSize(3);
            mMatchListInput.setPageNo(1);
        }



        if (tag == 0) {

            switch (AppSession.getInstance().getGameType()) {
                case 1:
                    presenterImpl.actionListing(mMatchListInput);
                    break;
                case 2:
                    presenterImpl.actionListing(mMatchListInput);
                    break;
            }

        } else {
            if (tag == 1) {
                series.setVisibility(View.GONE);
                switch (AppSession.getInstance().getGameType()) {
                    case 1:
                        // presenterImpl.actionListing(mMatchListInput);
                        presenterImpl.actionListing(mMatchListInput);
                        break;

                    case 2:
                        presenterImpl.actionListing(mMatchListInput);
                        break;
                }
            }
        }
    }


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

            if (tag == 0) {

                if (type.equals("FIXTURE")) {

                    /*if (Integer.parseInt(adapter.getMatchItem(position).getContestsAvailable()) > 0) {
                        MatchContestActivity.start(mContext, adapter.getMatchItem(position).getMatchGUID(),
                                adapter.getMatchItem(position).getStatus());
                    } else {
                        AppUtils.showToast(mContext, "Contests for this match will open soon");
                    }*/

                    if ( adapter.getMatchItem(position).getContestAvailable().equalsIgnoreCase("Yes")&&
                            adapter.getMatchItem(position).getTeamPlayersAvailable().equalsIgnoreCase("Yes")) {
                        MatchContestActivity.start(mContext, adapter.getMatchItem(position).getMatchGUID(),
                                adapter.getMatchItem(position).getStatus());
                    }else {
                        AppUtils.showToast(mContext, "Contests for this match will open soon");
                    }

                } else if (type.equals("LIVE")) {
                    if (adapter.getMatchItem(position).getJoinedContests().equals("0")) {

                        ContestDetail.start(mContext, adapter.getMatchItem(position).getMatchGUID(), adapter.getMatchItem(position).getStatus());
                    } else {
                        /*AllJoinedContest.start(mContext,adapter.getMatchItem(position).getMatchGUID(),
                                adapter.getMatchItem(position).getStatus());*/
                        ContestDetail.start(mContext, adapter.getMatchItem(position).getMatchGUID(), adapter.getMatchItem(position).getStatus());
                    }
                } else if (type.equals("COMPLETED")) {

                    if (adapter.getMatchItem(position).getStatus().equals(Constant.Abandoned) || adapter.getMatchItem(position).getStatus().equals(Constant.Cancelled)) {
                        Toast.makeText(mContext, "This match is " + adapter.getMatchItem(position).getStatus(), Toast.LENGTH_SHORT).show();
                    } else {
                        if (adapter.getMatchItem(position).getJoinedContests().equals("0")) {

                            ContestDetail.start(mContext, adapter.getMatchItem(position).getMatchGUID(), adapter.getMatchItem(position).getStatus());

                        } else {
                            AllJoinedContest.start(mContext, adapter.getMatchItem(position).getMatchGUID(),
                                    adapter.getMatchItem(position).getStatus());
                        }
                    }
                }

               /* switch (type) {
                    case "FIXTURE":

                        MatchContestActivity.start(mContext, adapter.getMatchItem(position).getMatchGUID(),
                                adapter.getMatchItem(position).getStatus());

                      *//*  MatchContestActivity.start(mContext, "0f2e9793-eb73-9b81-e99b-0271f4b68558",
                                adapter.getMatchItem(position).getStatusID());*//*



                    case "LIVE":


                      if(adapter.getMatchItem(position).getJoinedContests().equals("0")){

                          ContestDetail.start(mContext,adapter.getMatchItem(position).getMatchGUID(), adapter.getMatchItem(position).getStatus());
                      }else {
                          AllJoinedContest.start(mContext,adapter.getMatchItem(position).getMatchGUID(),
                                  adapter.getMatchItem(position).getStatus());
                      }

                        break;

                    case "COMPLETED":

                        if(adapter.getMatchItem(position).getJoinedContests().equals("0")){

                        }else {
                            AllJoinedContest.start(mContext,adapter.getMatchItem(position).getMatchGUID(),
                                    adapter.getMatchItem(position).getStatus());
                        }
                        break;
                }
            } else {


                switch (type) {
                    case "FIXTURE":


                      *//*  ContestActivity.start(getActivity(), adapter.getMatcheDateTime(position),
                                adapter.getMatchesId(position), adapter.getRemainingTime(position),
                                adapter.getMatcheDate(position), adapter.getMatcheTime(position));*//*

                        //  JoinedContest.start(mContext, adapter.getMatchesId(position));
                        break;

                    case "LIVE":
                        //ContestDeatil.start(mContext, adapter.getMatchesId(position));
                        break;

                    case "COMPLETED":
                        //ContestDeatil.start(mContext, adapter.getMatchesId(position));
                        break;
                }

*/
            }

        }
    };

    @Override
    public void onLoadingError(String value) {
        loader.error(value);
    }

    @Override
    public void onLoadingSuccess(MatchResponseOut response) {
        if (isLayoutAdded() && mRecyclerView != null) {

            if (response.getData().getRecords() != null) {

                //  mRecordsBean = response.getData().getRecords();
                matches.setVisibility(View.VISIBLE);
                no_matches.setVisibility(View.GONE);
                adapter.clearData();
                adapter.addAllItem(response.getData().getRecords());
                adapter.upcomingMatchesTime = Integer.parseInt(response.getData().getUpcomingMatchesTime());

                Log.d("appLinkData", appLinkData);

                if (mBottomSheetDialog.isShowing()) {
                    mBottomSheetDialog.dismiss();
                }

                if (type.equals("FIXTURE")) {
                    if (adapter.getMatchItem(0).getBannerActive().equalsIgnoreCase("Yes")){
                        matches.setVisibility(View.GONE);
                        no_matches.setVisibility(View.VISIBLE);
                    }else {
                        matches.setVisibility(View.VISIBLE);
                        no_matches.setVisibility(View.GONE);
                    }
                }
            } else {
                onLoadingNotFound(AppUtils.getStrFromRes(R.string.contestNotFound));
                matches.setVisibility(View.GONE);
                no_matches.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onCheckContest(CheckContestBean mJoinedContestBean) {
        Log.d("mJoinedContestBean", mJoinedContestBean.getMessage());
        onShowSnackBar(mJoinedContestBean.getMessage());

        long remaingTime = TimeUtils.getTimeDifference(mJoinedContestBean.getResponse().getMatchDateTime(),
                mJoinedContestBean.getResponse().getCurrentTime());

      /*  ContestActivity.start(getActivity(), mJoinedContestBean.getResponse().getMatchDateTime(),
                mJoinedContestBean.getResponse().getMatchId(), remaingTime,
                mJoinedContestBean.getResponse().getMatchDate(),
                mJoinedContestBean.getResponse().getMatchTime(), mJoinedContestBean);*/

        AppSession.getInstance().setGameType(mJoinedContestBean.getResponse().getGameType());
        getArguments().remove("appLinkData");
        appLinkData = "";

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
    public void onScrollLoadingSuccess(MatchResponseOut response) {
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
        loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.not_found_img));
        loader.dataNotFound(value);

        loader.error(value);
        loader.getTryAgainView().setText(AppUtils.getStrFromRes(R.string.join_contest));

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
    public void onClearLogout() {
        AppSession.getInstance().clearSession();
        LoginScreen.start(mContext);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();
    }

    @Override
    public void onShowSnackBar(@NonNull String message) {
        AppUtils.showToast(mContext, message);
    }

    @Override
    public void onMatchSeriesSuccess(SeriesOutput responseMatchSeries) {

        if (isAdded()) {

            //init_modal_bottomsheet(responseMatchSeries);
        }

       /*mMatchSeriesAdapter.addAllItem(responseMatchSeries.getResponse());

       mMatchSeriesAdapter.notifyDataSetChanged();*/

        // init_modal_bottomsheet(responseMatchSeries);
    }

    @Override
    public void onMatchSeriesFailure(String errMsg) {

    }

    /*public void init_modal_bottomsheet(final SeriesOutput mMatchSeries) {

        View modalbottomsheet = getLayoutInflater().inflate(R.layout.modal_bottomsheet, null);


        mBottomSheetDialog.setContentView(modalbottomsheet);
        mBottomSheetDialog.setCanceledOnTouchOutside(true);
        mBottomSheetDialog.setCancelable(false);

        RecyclerView mSeriesRecyclerView = (RecyclerView) modalbottomsheet.findViewById(R.id.recycler_view_series);
        CustomTextView ctv_reset = (CustomTextView) modalbottomsheet.findViewById(R.id.ctv_reset);
        CustomTextView ctv_close = (CustomTextView) modalbottomsheet.findViewById(R.id.ctv_close);

        CustomTextView ctv_next = (CustomTextView) modalbottomsheet.findViewById(R.id.ctv_next);


        mSeriesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        mMatchSeriesAdapter = new MatchSeriesAdapter(getActivity(), R.layout.list_item_series, mMatchSeries.getResponse(), onSelectedSeriesCallback);

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

    }*/

}
