package com.mw.eleven11.UI.joinedContests;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.allContest.AllContestPresenterImpl;
import com.mw.eleven11.UI.allContest.AllContestView;
import com.mw.eleven11.UI.contestDetailLeaderBoard.ContestLeaderBoard;
import com.mw.eleven11.UI.createTeam.CreateTeamActivity;
import com.mw.eleven11.UI.loginRagisterModule.LoginScreen;
import com.mw.eleven11.UI.myMatches.MyMatchesPresenterImpl;
import com.mw.eleven11.UI.myMatches.MyMatchesView;
import com.mw.eleven11.UI.winnings.WinnersCallback;
import com.mw.eleven11.UI.winnings.WinnersRankBean;
import com.mw.eleven11.UI.winnings.WinningsFragment;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.base.LoaderScroller;
import com.mw.eleven11.beanInput.JoinedContestInput;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanOutput.AllContestOutPut;
import com.mw.eleven11.beanOutput.JoinedContestOutput;
import com.mw.eleven11.beanOutput.MatchContestOutPut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.MyContestMatchesOutput;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.EndlessRecyclerViewScrollListenerFab;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AllJoinedFragment extends BaseFragment implements AllContestView,MyMatchesView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;


    private EndlessRecyclerViewScrollListenerFab scrollListener;
    private LinearLayoutManager layoutManager;

    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Loader loader;
    private LoaderScroller loaderScroller;

    String statusID= Constant.Pending;
    String matchGUID;

    public JoinedContestAdapter adapter;

    JoinedContestOutput allContest;

    private AllContestPresenterImpl mAllContestPresenterImpl;
    private MyMatchesPresenterImpl presenterImpl;

    List<JoinedContestOutput.DataBean.RecordsBean> all_contest;


    public static AllJoinedFragment getInstance(Bundle bundle) {
        AllJoinedFragment mAllJoinedFragment = new AllJoinedFragment();
        mAllJoinedFragment.setArguments(bundle);
        return mAllJoinedFragment;
    }

    public static void start(Context context, String match_id,String statusID) {
        Intent starter = new Intent(context, AllJoinedFragment.class);

        starter.putExtra("matchGUID", match_id);
        starter.putExtra("statusID", statusID);

        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    private OnItemClickListener.OnItemClickCallback onWinnerClickCallBack = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

            List<JoinedContestOutput.DataBean.RecordsBean.CustomizeWinningBean> customizeWin= adapter.getItem(position).getCustomizeWinning();
            List<WinnersRankBean> rankList = new ArrayList<>();
            for (int i = 0; i < customizeWin.size(); i++) {

                WinnersRankBean mWinnersRankBean = new WinnersRankBean();

                mWinnersRankBean.setFrom(customizeWin.get(i).getFrom());
                mWinnersRankBean.setTo(customizeWin.get(i).getTo());
                mWinnersRankBean.setPercent(customizeWin.get(i).getPercent());
                mWinnersRankBean.setWinningAmount(customizeWin.get(i).getWinningAmount());

                rankList.add(i, mWinnersRankBean);

            }

            showPreview(rankList, adapter.getItem(position).getWinningAmount());
        }
    };
    private OnItemClickListener.OnItemClickCallback onContestClickCallBack = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            if (adapter.getItem(position).getStatus().equals(Constant.Cancelled)) {
                onShowSnackBar("Contest cancelled!");
            }else{
                ContestLeaderBoard.start(mContext, matchGUID, adapter.getItem(position).getContestGUID(),statusID);

            }
        }
    };
    private OnItemClickListener.OnItemClickCallback onJoinClickCallBack = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

            if(allContest!=null) {
                if(allContest.getData().getStatics().getTotalTeams().equals("0")) {
                    CreateTeamActivityStart(mContext,
                            matchGUID,
                            adapter.getItem(position).getContestGUID(), adapter.getItem(position).getEntryFee(),adapter.getItem(position).getCashBonusContribution());
                }else {
                   /* MyTeamActivityStart(mContext,
                            matchGUID,
                            statusID,adapter.getItem(position).getContestGUID(),
                            adapter.getItem(position).getEntryFee(),
                            teamsVS.getText().toString());*/
                }
            }
        }
    };


    public void CreateTeamActivityStart(Context context, String MatchGUID, String contestId, String joiningAmount, String cashBonusContribution) {
        Intent starter = new Intent(context, CreateTeamActivity.class);

        starter.putExtra("MatchGUID", MatchGUID);
        starter.putExtra("contestId", contestId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("cashBonusContribution", cashBonusContribution);

        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }

    @Override
    public int getLayout() {
        return R.layout.joined_contest;
    }


    @Override
    public void init() {

        mContext = getActivity();
        loaderScroller = new LoaderScroller(getCurrentView());
        mAllContestPresenterImpl = new AllContestPresenterImpl(this, new UserInteractor());
        presenterImpl= new MyMatchesPresenterImpl(this, new UserInteractor());

        all_contest = new ArrayList<>();


        loader = new Loader(getCurrentView());
        loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //callMatchDetail(matchGUID, statusID);

            }
        });

        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(mContext, R.dimen.item_offset);
        //mRecyclerView.addItemDecoration(itemDecoration);
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
                callTask(statusID, 1);
            }
        });
        // Configure the refreshing colors
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark,
                R.color.colorPrimary,
                R.color.secondary_tab_color);

        if (loader.getTryAgainView() != null)
            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (scrollListener != null)
                        scrollListener.resetState();
                    callTask(statusID, 1);
                }
            });

        scrollListener = new EndlessRecyclerViewScrollListenerFab(layoutManager) {
            @Override
            public void onLoadMore(int rPage, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                Log.i("loadNextDataFromApi", "loadNextDataFromApi " + rPage);
                //callMatchDetail(matchGUID, statusID);
                callTask(statusID, rPage);
            }

            @Override
            public void onShowFab(boolean show) {

            }
        };

        // Adds the scroll listener to RecyclerView
        mRecyclerView.addOnScrollListener(scrollListener);
        scrollListener.resetState();

        adapter = new JoinedContestAdapter(R.layout.my_contest_item, mContext, all_contest,
                onWinnerClickCallBack, onContestClickCallBack, onJoinClickCallBack);
        mRecyclerView.setAdapter(adapter);

        if (getArguments().containsKey("matchGUID")) {

            matchGUID = getArguments().getString("matchGUID");
            statusID = getArguments().getString("statusID");

           // callMatchDetail(matchGUID, statusID);
            callTask(statusID, 1);
        }


    }

    public void callTask(String statusId, int PAGE_NO) {

        if (PAGE_NO == 1) {
            adapter.clear();
        }

        JoinedContestInput mMatchListInput = new JoinedContestInput();
        mMatchListInput.setPageNo(PAGE_NO);
        mMatchListInput.setPageSize(Constant.PAGE_LIMIT);
        mMatchListInput.setParams(Constant.JOINEDCONTEST_PARAM);
        mMatchListInput.setGetJoinedMatches("NO");
        mMatchListInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchListInput.setMatchGUID(matchGUID);
        mMatchListInput.setPrivacy("All");
        mMatchListInput.setMyJoinedContest("Yes");

        if (statusId.equals(Constant.Pending)) {
            mMatchListInput.setContestFull("No");
            mMatchListInput.setStatus(statusId);
        }else if (statusId.equals(Constant.Running) ){
            mMatchListInput.setOrderBy("StatusID");
            mMatchListInput.setSequence("ASC");
        }else if (statusId.equals(Constant.Completed)){
            mMatchListInput.setOrderBy("StatusID");
            mMatchListInput.setSequence("DESC");
        }

        presenterImpl.actionListing(mMatchListInput);

    }


    public void callMatchDetail(String matchGuid, String statusId) {

        MatchDetailInput mMatchDetailInput = new MatchDetailInput();
        mMatchDetailInput.setPrivacy("No");
        mMatchDetailInput.setMatchGUID(matchGuid);
        mMatchDetailInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchDetailInput.setStatus(statusId);
        mMatchDetailInput.setParams(Constant.MATCH_PARAMS);

        mAllContestPresenterImpl.actionMatchdetail(mMatchDetailInput);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        loader.hide();
    }

    @Override
    public void onShowLoading() {
        loader.start();
    }

    @Override
    public void onHideLoading() {
        loader.hide();

        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoadingSuccess(JoinedContestOutput mJoinedContestOutput) {
        if (isLayoutAdded() && mRecyclerView != null) {

            allContest= mJoinedContestOutput;
            adapter.addAllItem(mJoinedContestOutput.getData().getRecords());


            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoadingSuccess(AllContestOutPut mAllContestOutPut) {

    }

    @Override
    public void onLoadingError(String value) {
        loader.error(value);
    }

    @Override
    public void onLoadingNotFound(String value) {
        loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.not_found_img));
        loader.dataNotFound(value);
    }

    @Override
    public void onShowScrollLoading() {
        loaderScroller.show();
    }

    @Override
    public void onHideScrollLoading() {
        loaderScroller.hide();
    }

    @Override
    public void onScrollLoadingSuccess(JoinedContestOutput mJoinedContestOutput) {
        loaderScroller.hide();
        adapter.addAllItem(mJoinedContestOutput.getData().getRecords());
    }

    @Override
    public void onScrollLoadingSuccess(AllContestOutPut mAllContestOutPut) {


    }

    @Override
    public void onScrollLoadingError(String value) {

        loaderScroller.error(value);
    }

    @Override
    public void onScrollLoadingNotFound(String value) {
        loaderScroller.hide();
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onShowSnackBar(String message) {
        AppUtils.showToast(mContext, message);
    }

    @Override
    public boolean isLayoutAdded() {
        return true;
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void onClearLogout() {
        AppSession.getInstance().clearSession();
        LoginScreen.start(mContext);
    }

    @Override
    public void onMyContestLoadingSuccess(MyContestMatchesOutput mJoinedContestOutput) {

    }

    @Override
    public void onMyContestLoadingError(String value) {

    }

    @Override
    public void onMyContestLoadingNotFound(String value) {

    }

    @Override
    public void onMyContestScrollLoadingSuccess(MyContestMatchesOutput mJoinedContestOutput) {

    }

    @Override
    public void onMyContestScrollLoadingError(String value) {

    }

    @Override
    public void onMyContestScrollLoadingNotFound(String value) {

    }

    @Override
    public void onMatchContestSuccess(MatchContestOutPut responseLogin) {

    }

    @Override
    public void onMatchContestFailure(String errMsg) {

    }

    @Override
    public void onMatchSuccess(MatchDetailOutPut mMatchDetailOutPut) {

        hideLoading();

        callTask(statusID,1);


    }

    @Override
    public void onMatchFailure(String errMsg) {
        hideLoading();
        loader.error(errMsg);
    }
    CountDownTimer countDownTimer;
  /*  public void setTime(String matchDateTime, final String matchDate, final String matchTime, String currentTime) {
        ctv_timer.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_time, 0, 0, 0);
        try {
            if (countDownTimer != null) countDownTimer.cancel();
            if (ctv_timer != null) {

                long remainingTime = TimeUtils.getTimeDifference(matchDateTime,
                        currentTime);

                //ctv_timer.setPaintFlags(ctv_timer.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if (TimeUtils.isThisDateValid(matchDateTime, "yyyy-MM-dd HH:mm:ss")) {
                    if (TimeUnit.MILLISECONDS.toHours(remainingTime) > Constant.SHOW_TIME_LIMIT_HRS) {
                        ctv_timer.setText(TimeUtils.getMatchDateOnly(matchDate));
                    } else {
                        //need to implement counter
                        countDownTimer = new CountDownTimer(remainingTime, TimeUnit.SECONDS.toMillis(1)) {
                            public void onTick(long millisUntilFinished) {
                                if (ctv_timer != null)
                                    ctv_timer.setText(TimeUtils.getRemainsTime(millisUntilFinished));
                            }

                            public void onFinish() {
                                if (ctv_timer != null)
                                    ctv_timer.setText(TimeUtils.getDisplayFullDate1(matchDate, matchTime));
                            }
                        };
                        if (countDownTimer != null) {
                            countDownTimer.start();
                        }
                    }
                } else {
                    ctv_timer.setText(TimeUtils.getMatchDateOnly(matchDate));
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            ctv_timer.setText("N/A");
        }

    }*/
    private void showPreview(final List<WinnersRankBean> bean,
                             final String totalWinngingAmmount) {
        final WinningsFragment dialogFragment = new WinningsFragment();
        dialogFragment.setUpdateable(new WinnersCallback() {
            @Override
            public void close() {

            }

            @Override
            public Context getContext() {
                return mContext;
            }


            @Override
            public List<WinnersRankBean> getBean() {
                return bean;
            }

            @Override
            public String getTotalWiningAmount() {
                return totalWinngingAmmount;
            }

            @Override
            public String getWinningType() {
                return null;
            }
        });
        dialogFragment.show(getChildFragmentManager(), dialogFragment.getTag());

    }


}
