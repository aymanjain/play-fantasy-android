package com.mw.eleven11.UI.joinedContests;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.allContest.AllContestPresenterImpl;
import com.mw.eleven11.UI.allContest.AllContestView;
import com.mw.eleven11.UI.contestDetailLeaderBoard.ContestLeaderBoard;
import com.mw.eleven11.UI.createTeam.CreateTeamActivity;
import com.mw.eleven11.UI.loginRagisterModule.LoginScreen;
import com.mw.eleven11.UI.matchContest.SingleContestAdapter;
import com.mw.eleven11.UI.myMatches.MyMatchesPresenterImpl;
import com.mw.eleven11.UI.myMatches.MyMatchesView;
import com.mw.eleven11.UI.myTeams.MyTeamsActivity;
import com.mw.eleven11.UI.winnings.WinnersCallback;
import com.mw.eleven11.UI.winnings.WinnersRankBean;
import com.mw.eleven11.UI.winnings.WinningsFragment;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.base.LoaderScroller;
import com.mw.eleven11.beanInput.JoinedContestInput;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanOutput.AllContestOutPut;
import com.mw.eleven11.beanOutput.JoinedContestOutput;
import com.mw.eleven11.beanOutput.MatchContestOutPut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.MyContestMatchesOutput;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.EndlessRecyclerViewScrollListenerFab;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnWinnerClickListener;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

public class AllJoinedContest extends BaseActivity implements AllContestView,MyMatchesView {

    @BindView(R.id.customImageViewTeamFlagLocal)
    CustomImageView customImageViewTeamFlagLocal;

    @BindView(R.id.customImageViewTeamFlagVisitor)
    CustomImageView customImageViewTeamFlagVisitor;


    @BindView(R.id.customTextViewTeamNameLocal)
    CustomTextView customTextViewTeamNameLocal;

    @BindView(R.id.customTextViewTeamNameVisitor)
    CustomTextView customTextViewTeamNameVisitor;


    @BindView(R.id.customTextViewMatchStatus)
    CustomTextView customTextViewMatchStatus;



    /* @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;*/
    @BindView(R.id.menu)
    ImageView menu;
    @BindView(R.id.title)
    CustomTextView title;
    @BindView(R.id.teamsVS)
    CustomTextView teamsVS;
    @BindView(R.id.ctv_full_time)
    CustomTextView ctv_timer;
   /* @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;*/

    @BindView(R.id.ll_main)
    LinearLayout mLinearLayout;

    @BindView(R.id.winnings)
    CustomTextView winnings;

    @BindView(R.id.teams)
    CustomTextView teams;

    @BindView(R.id.winners)
    CustomTextView winners;

    @BindView(R.id.entry)
    CustomTextView entry;

    @BindView(R.id.contestSection)
    LinearLayout contestSection;

    List<Integer> colorList;
    private static final Integer[] colorArray = {R.color.yellow,R.color.orange,R.color.red,
            R.color.brown_red, R.color.light_pink, R.color.green,
    };

    @OnClick(R.id.back)
    void onBackClick() {

        onBackPressed();
    }


    private EndlessRecyclerViewScrollListenerFab scrollListener;
    private LinearLayoutManager layoutManager;

    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Loader loader;
    private LoaderScroller loaderScroller;

    String statusID= Constant.Pending;
    String matchGUID;

    //public AllJoinedContestAdapter adapter;

    JoinedContestOutput allContest;
    String matchTeamVS = "";

    private AllContestPresenterImpl mAllContestPresenterImpl;
    private MyMatchesPresenterImpl presenterImpl;

    List<JoinedContestOutput.DataBean.RecordsBean> all_contest;




    public static void start(Context context, String match_id,String statusID) {
        Intent starter = new Intent(context, AllJoinedContest.class);

        starter.putExtra("matchGUID", match_id);
        starter.putExtra("statusID", statusID);

        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    private OnWinnerClickListener.OnWinnerClickCallback onWinnerClickCallBack = new OnWinnerClickListener.OnWinnerClickCallback() {
        @Override
        public void onWinnerClicked(View view, int position,
                                    List<MatchContestOutPut.DataBean.ResultsBean.RecordsBean> responseBeen) {

            /*List<JoinedContestOutput.DataBean.RecordsBean.CustomizeWinningBean> customizeWin= adapter.getItem(position).getCustomizeWinning();
            List<WinnersRankBean> rankList = new ArrayList<>();
            for (int i = 0; i < customizeWin.size(); i++) {

                WinnersRankBean mWinnersRankBean = new WinnersRankBean();

                mWinnersRankBean.setFrom(customizeWin.get(i).getFrom());
                mWinnersRankBean.setTo(customizeWin.get(i).getTo());
                mWinnersRankBean.setPercent(customizeWin.get(i).getPercent());
                mWinnersRankBean.setWinningAmount(customizeWin.get(i).getWinningAmount());

                rankList.add(i, mWinnersRankBean);

            }

            showPreview(rankList, adapter.getItem(position).getWinningAmount());*/

            List<MatchContestOutPut.DataBean.ResultsBean.RecordsBean.CustomizeWinningBean> customizeWin= responseBeen.get(position).getCustomizeWinning();
            List<WinnersRankBean> rankList = new ArrayList<>();
            for (int i = 0; i < customizeWin.size(); i++) {

                WinnersRankBean mWinnersRankBean = new WinnersRankBean();

                mWinnersRankBean.setFrom(customizeWin.get(i).getFrom());
                mWinnersRankBean.setTo(customizeWin.get(i).getTo());
//                mWinnersRankBean.setPercent(customizeWin.get(i).getPercent());
//                mWinnersRankBean.setWinningAmount(customizeWin.get(i).getWinningAmount());

                if (responseBeen.get(position).getSmartPool().equalsIgnoreCase("Yes")){
                    mWinnersRankBean.setProductName(customizeWin.get(i).getProductName());
                    mWinnersRankBean.setProductUrl(customizeWin.get(i).getProductUrl());
                }else {
                    mWinnersRankBean.setPercent(customizeWin.get(i).getPercent());
                    mWinnersRankBean.setWinningAmount(customizeWin.get(i).getWinningAmount());

                }


                rankList.add(i, mWinnersRankBean);


            }
            if (responseBeen.get(position).getSmartPool().equalsIgnoreCase("Yes")) {
                showPreview(rankList, null,responseBeen.get(position).getWinningType());
            }else {
                showPreview(rankList, responseBeen.get(position).getWinningAmount(),responseBeen.get(position).getWinningType());
            }
//            showPreview(rankList,responseBeen.get(position).getWinningAmount());
        }
    };

    private OnWinnerClickListener.OnWinnerClickCallback onContestClickCallBack =
            new OnWinnerClickListener.OnWinnerClickCallback() {
                @Override
                public void onWinnerClicked(View view, int position,
                                            List<MatchContestOutPut.DataBean.ResultsBean.RecordsBean> responseBeen) {

//            ContestLeaderBoard.start(mContext, matchGUID, adapter.getItem(position).getContestGUID(),statusID);
                    ContestLeaderBoard.start(mContext, matchGUID, responseBeen.get(position).getContestGUID(),statusID);
                }
    };

    private OnWinnerClickListener.OnWinnerClickCallback onJoinClickCallBack =
            new OnWinnerClickListener.OnWinnerClickCallback() {
                @Override
                public void onWinnerClicked(View view, int position,
                                            List<MatchContestOutPut.DataBean.ResultsBean.RecordsBean> responseBeen) {

           /* if(allContest!=null) {
                if(allContest.getData().getStatics().getTotalTeams().equals("0")) {
                    CreateTeamActivityStart(mContext,
                            matchGUID,
                            adapter.getItem(position).getContestGUID(), adapter.getItem(position).getEntryFee());
                }else {
                    MyTeamActivityStart(mContext,
                            matchGUID,
                            statusID,adapter.getItem(position).getContestGUID(),
                            adapter.getItem(position).getEntryFee(),
                            teamsVS.getText().toString(),
                            adapter.getItem(position).getCashBonusContribution());
                }
            }*/
        }
    };

    public void CreateTeamActivityStart(Context context, String MatchGUID) {
        Intent starter = new Intent(context, CreateTeamActivity.class);

        starter.putExtra("MatchGUID", MatchGUID);


        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }
    public void CreateTeamActivityStart(Context context, String MatchGUID,String contestId,String joiningAmount) {
        Intent starter = new Intent(context, CreateTeamActivity.class);

        starter.putExtra("MatchGUID", MatchGUID);
        starter.putExtra("contestId", contestId);
        starter.putExtra("joiningAmount", joiningAmount);

        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }
    public void MyTeamActivityStart(Context context,  String matchId, String statusId,String contestId,String joiningAmount, String teamsVSStr, String cashBonusContribution) {
        Intent starter = new Intent(context, MyTeamsActivity.class);
        starter.putExtra("contestId",contestId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("statusId", statusId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("teamsVSStr", teamsVSStr);
        starter.putExtra("join", "0");
        starter.putExtra("cashBonusContribution",cashBonusContribution );
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_MY_TEAM);
    }
    @Override
    public int getLayout() {
        return R.layout.activity_all_joined_contest;
    }

    @Override
    public void init() {

        mContext = this;
        loaderScroller = new LoaderScroller(this);
        mAllContestPresenterImpl = new AllContestPresenterImpl(this, new UserInteractor());
        presenterImpl= new MyMatchesPresenterImpl(this, new UserInteractor());

        all_contest = new ArrayList<>();

        mLinearLayout.setVisibility(View.GONE);

        loader = new Loader(this);

        loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callMatchDetail(matchGUID, statusID);

            }
        });

      /*  ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(mContext, R.dimen.item_offset);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setNestedScrollingEnabled(true);*/

        layoutManager = new LinearLayoutManager(getContext()) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // initSpruce();
            }
        };
      //  mRecyclerView.setLayoutManager(layoutManager);

        // Setup refresh listener which triggers new data loading
      /*  swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
//                if (adapter != null) adapter.clear();
                if (scrollListener != null)
                    scrollListener.resetState();
                callTask(statusID, 1);
            }
        });
        // Configure the refreshing colors
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark,
                R.color.colorPrimary,
                R.color.secondary_tab_color);
*/
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
                callTask(statusID,rPage);
            }

            @Override
            public void onShowFab(boolean show) {

            }
        };

      /*  // Adds the scroll listener to RecyclerView
        mRecyclerView.addOnScrollListener(scrollListener);
        scrollListener.resetState();*/

        if (getIntent().hasExtra("matchGUID")) {

            matchGUID = getIntent().getStringExtra("matchGUID");
            statusID = getIntent().getStringExtra("statusID");

            callMatchDetail(matchGUID, statusID);
        }

       /* adapter = new AllJoinedContestAdapter(R.layout.single_contest_item, mContext, all_contest,
                onWinnerClickCallBack, onContestClickCallBack, onJoinClickCallBack , matchTeamVS);
        mRecyclerView.setAdapter(adapter);*/


    }

    public void callTask(String statusId, int PAGE_NO) {

        if (PAGE_NO == 1) {
//            adapter.clear();
        }

        JoinedContestInput mMatchListInput = new JoinedContestInput();
        mMatchListInput.setPageNo(PAGE_NO);
        mMatchListInput.setPageSize(Constant.PAGE_LIMIT);
        mMatchListInput.setParams(Constant.JOINEDCONTESTS_PARAM);
        mMatchListInput.setGetJoinedMatches("NO");
        mMatchListInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchListInput.setStatus(statusId);
        mMatchListInput.setMatchGUID(matchGUID);
        mMatchListInput.setPrivacy("All");
        mMatchListInput.setMyJoinedContest("Yes");

      //  presenterImpl.actionListing(mMatchListInput);

        presenterImpl.matchContestList(mMatchListInput);


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

     /*   if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);*/
    }

    @Override
    public void onLoadingSuccess(JoinedContestOutput mJoinedContestOutput) {
      /*  if (isLayoutAdded() && mRecyclerView != null) {

            allContest= mJoinedContestOutput;
            adapter.addAllItem(mJoinedContestOutput.getData().getRecords());


            adapter.notifyDataSetChanged();
        }*/
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
        //adapter.addAllItem(mJoinedContestOutput.getData().getRecords());
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
      /*  if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);*/
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
        contestSection.removeAllViews();

        int totalContest=0;

        for (int i = 0; i <responseLogin.getData().getResults().size() ; i++) {

            if (responseLogin.getData().getResults().get(i).getTotalRecords() != 0) {

                LayoutInflater inflater = LayoutInflater.from(getContext());
                ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                        .findViewById(android.R.id.content)).getChildAt(0);

                View mView = inflater.inflate(R.layout.contest_section_item, viewGroup, false);

                RecyclerView mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycleViewContest);
                CustomTextView contestTypeName = (CustomTextView) mView.findViewById(R.id.contestTypeName);
                CustomTextView contestTypeTitle = (CustomTextView) mView.findViewById(R.id.contestTypeTitle);

                SimpleDraweeView contest_Icon = (SimpleDraweeView) mView.findViewById(R.id.contest_Icon);

                CustomTextView contest_count = (CustomTextView) mView.findViewById(R.id.contest_count);

                contestTypeName.setText(responseLogin.getData().getResults().get(i).getKey());
                contestTypeTitle.setText(responseLogin.getData().getResults().get(i).getTagLine());

                contest_count.setVisibility(View.GONE);

               /* int remainContest=
                        responseLogin.getData().getResults().get(i).getTotalRecords()-responseLogin.getData().getResults().get(i).getRecords().size();
                if(remainContest!=0){
                    contest_count.setText(remainContest+" "+AppUtils.getStrFromRes(R.string.more_contest));
                }else {
                    contest_count.setVisibility(View.GONE);
                }*/

                ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(mContext, R.dimen.item_offset);
                mRecyclerView.addItemDecoration(itemDecoration);
                mRecyclerView.setNestedScrollingEnabled(true);

                LinearLayoutManager layoutManager;

                layoutManager = new LinearLayoutManager(getContext()) {
                    @Override
                    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                        super.onLayoutChildren(recycler, state);
                        // initSpruce();
                    }
                };

                mRecyclerView.setLayoutManager(layoutManager);

                SingleContestAdapter adapter;
                colorList = new ArrayList<Integer>(Arrays.asList(colorArray));
                adapter = new SingleContestAdapter(R.layout.single_contest_item, mContext, responseLogin.getData().getResults().get(i).getRecords(),
                        onWinnerClickCallBack, onContestClickCallBack, onJoinClickCallBack ,matchTeamVS,colorList);
                mRecyclerView.setAdapter(adapter);
                contestSection.addView(mView);
                totalContest++;
            }
        }

        if(totalContest==0){
            loader.dataNotFound(AppUtils.getStrFromRes(R.string.contestNotFound));
        }
    }

    @Override
    public void onMatchContestFailure(String errMsg) {

    }

    @Override
    public void onMatchSuccess(MatchDetailOutPut mMatchDetailOutPut) {

        hideLoading();
        mLinearLayout.setVisibility(View.VISIBLE);

        ViewUtils.setImageUrl(customImageViewTeamFlagLocal, mMatchDetailOutPut.getData().getTeamFlagLocal());
        ViewUtils.setImageUrl(customImageViewTeamFlagVisitor, mMatchDetailOutPut.getData().getTeamFlagVisitor());
        customTextViewTeamNameLocal.setText(mMatchDetailOutPut.getData().getTeamNameShortLocal());
        customTextViewTeamNameVisitor.setText(mMatchDetailOutPut.getData().getTeamNameShortVisitor());



        matchTeamVS = mMatchDetailOutPut.getData().getTeamNameShortLocal()
                + " " + AppUtils.getStrFromRes(R.string.vs) + " " + mMatchDetailOutPut.getData().getTeamNameShortVisitor();

       /* if (adapter != null) {
            adapter.matchTeamVS = matchTeamVS;
        }*/

        teamsVS.setText(mMatchDetailOutPut.getData().getTeamNameShortLocal()
                + " " + AppUtils.getStrFromRes(R.string.vs) + " " + mMatchDetailOutPut.getData().getTeamNameShortVisitor());


if(mMatchDetailOutPut.getData().getStatus()!=null) {
    if (mMatchDetailOutPut.getData().getStatus().equals(Constant.Pending)) {
        setTime(mMatchDetailOutPut.getData().getMatchStartDateTime(), mMatchDetailOutPut.getData().getMatchDate(),
                mMatchDetailOutPut.getData().getMatchTime(), mMatchDetailOutPut.getData().getCurrentDateTime());
    } else if (mMatchDetailOutPut.getData().getStatus().equals(Constant.Running)) {
        ctv_timer.setText(mMatchDetailOutPut.getData().getStatus());
        ctv_timer.setTextColor(getResources().getColor(R.color.yellow));
        customTextViewMatchStatus.setText(getString(R.string.Running));
        customTextViewMatchStatus.setTextColor(getResources().getColor(R.color.green));
    } else if (mMatchDetailOutPut.getData().getStatus().equals(Constant.Completed)) {
        ctv_timer.setText(mMatchDetailOutPut.getData().getStatus());
        ctv_timer.setTextColor(getResources().getColor(R.color.green));
        customTextViewMatchStatus.setTextColor(getResources().getColor(R.color.green));
        customTextViewMatchStatus.setText(mMatchDetailOutPut.getData().getStatus());


    }
}
        callTask(statusID,1);
    }

    @Override
    public void onMatchFailure(String errMsg) {
        hideLoading();
        loader.error(errMsg);
    }


    CountDownTimer countDownTimer;
    public void setTime(String matchDateTime, final String matchDate, final String matchTime, String currentTime) {
        try {
            if (countDownTimer != null) countDownTimer.cancel();
            if (TimeUtils.isThisDateValid(matchDateTime, "yyyy-MM-dd HH:mm:ss")) {
                long remainingTime = TimeUtils.getTimeDifference(matchDateTime, currentTime);
                countDownTimer = new CountDownTimer(remainingTime, TimeUnit.SECONDS.toMillis(1)) {
                    public void onTick(long millisUntilFinished) {
                        if (customTextViewMatchStatus != null) {
                            customTextViewMatchStatus.setTextColor(mContext.getResources().getColor(R.color.red));
                            customTextViewMatchStatus.setText(TimeUtils.getRemainingMatchTime(millisUntilFinished));
                        }
                    }

                    public void onFinish() {
                        if (customTextViewMatchStatus != null) {
                            customTextViewMatchStatus.setTextColor(mContext.getResources().getColor(R.color.green));
                            customTextViewMatchStatus.setText(getString(R.string.Running));
                        }

                    }
                };
                if (countDownTimer != null) {
                    countDownTimer.start();
                }
            } else {
                customTextViewMatchStatus.setText(TimeUtils.getMatchDateOnly(matchDate));
            }
        } catch (Exception e1) {
            customTextViewMatchStatus.setText(e1.getMessage());
        }

    }
    private void showPreview(final List<WinnersRankBean> bean,
                             final String totalWinngingAmmount, final String winningType) {
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
                return winningType;
            }
        });
        dialogFragment.show(getSupportFragmentManager(), dialogFragment.getTag());

    }

}
