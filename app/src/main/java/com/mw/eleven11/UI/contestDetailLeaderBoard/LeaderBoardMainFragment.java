package com.mw.eleven11.UI.contestDetailLeaderBoard;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.contestDetailLeaderBoard.leaderBoard.LeaderBoardFragment;
import com.mw.eleven11.UI.contestDetailLeaderBoard.stats.StatsFragment;
import com.mw.eleven11.UI.createTeam.CreateTeamActivity;
import com.mw.eleven11.UI.inviteContest.InviteContestActivity;
import com.mw.eleven11.UI.inviteFriends.InviteFriendsActivity;
import com.mw.eleven11.UI.myTeams.MyTeamsActivity;
import com.mw.eleven11.UI.playerPoints.PlayerPointsActivity;
import com.mw.eleven11.UI.previewTeam.BottomSheetFootballTeamPreviewFragment;
import com.mw.eleven11.UI.previewTeam.BottomSheetPreviewFragment;
import com.mw.eleven11.UI.previewTeam.PlayerPreviewCallback;
import com.mw.eleven11.UI.previewTeam.PlayerRecord;
import com.mw.eleven11.UI.winnings.WinnersCallback;
import com.mw.eleven11.UI.winnings.WinnersRankBean;
import com.mw.eleven11.UI.winnings.WinningsFragment;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.BasePagerAdapter;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.ContestDetailInput;
import com.mw.eleven11.beanInput.DownloadTeamInput;
import com.mw.eleven11.beanInput.DreamTeamInput;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanOutput.ContestDetailOutput;
import com.mw.eleven11.beanOutput.Download;
import com.mw.eleven11.beanOutput.DreamTeamOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.ResponseDownloadTeam;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.download.DownloadServiceHttpUrl;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.FileOpen;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;


public class LeaderBoardMainFragment extends BaseFragment implements ContestLeaderView {


    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

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


    String matchGUID;
    String statusId;
    String contestGUID;
    String wininngAmmount = "";

    String matchTeamVS = "";
    private ProgressDialog mProgressDialog;

    ContestDetailOutput mContestDetailOutput;
    //MatchDetailOutPut details;

    public BasePagerAdapter mViewPagerAdapter;
    @BindString(R.string.fixtures)
    String fixtures;
    @BindString(R.string.live)
    String live;
    @BindString(R.string.results)
    String results;
    @BindView(R.id.viewPager)
    @Nullable
    ViewPager mViewPager;
    @BindView(R.id.fram)
    @Nullable
    FrameLayout frameLayout;
    @BindView(R.id.iv_team_1)
    @Nullable
    CustomImageView mCustomImageViewTeam1;
    @BindView(R.id.iv_team_2)
    @Nullable
    CustomImageView mCustomImageViewTeam2;

    @BindView(R.id.ctv_full_time)
    @Nullable
    CustomTextView customTextViewFullTime;
    @BindView(R.id.ctv_winning_amount)
    @Nullable
    CustomTextView customTextViewWinningAmount;
    @BindView(R.id.ctv_entry_fee)
    @Nullable
    CustomTextView customTextViewEntryFee;
    @BindView(R.id.confirmWinningTagRoot)
    @Nullable
    View confirmWinningTag;
    @BindView(R.id.joinMultipleTagRoot)
    @Nullable
    View joinMultipleTag;
    @BindView(R.id.rl_winnings)
    @Nullable
    CustomTextView rlWinnings;
    @BindView(R.id.winners)
    @Nullable
    CustomTextView winners;
    @BindView(R.id.teamName)
    @Nullable
    CustomTextView teamName;


    @BindView(R.id.contestTypeName)
    CustomTextView contestTypeName;


    @BindView(R.id.coordinatorLayout)
    @Nullable
    CoordinatorLayout coordinatorLayout;


    @BindView(R.id.progress_view)
    @Nullable
    ProgressBar progressBar;
    @BindView(R.id.ctv_join)
    @Nullable
    CustomTextView ctvJoin;
    @BindView(R.id.ctvSwitchTeam)
    @Nullable
    CustomTextView ctvSwitchTeam;


    @BindView(R.id.spotLeftCount)
    @Nullable
    CustomTextView spotLeftCount;
    @BindView(R.id.teamsCount)
    @Nullable
    CustomTextView teamsCount;
    @BindView(R.id.teamsVS)
    @Nullable
    CustomTextView teamsVS;
    @BindView(R.id.switchTeam_lin)
    @Nullable
    LinearLayout switchTeam_lin;
    @BindView(R.id.scorecard)
    @Nullable
    CardView scorecard;
    @BindView(R.id.linout)
    @Nullable
    LinearLayout linout;
    @BindView(R.id.dreamteamLin)
    @Nullable
    View dreamteamLin;
    @BindView(R.id.scoreData)
    @Nullable
    CustomTextView scoreData;
    @BindView(R.id.liveStatus)
    @Nullable
    CustomTextView liveStatus;

    @BindView(R.id.viewPlayerStates)
    @Nullable
    CustomTextView viewPlayerStates;

    @BindView(R.id.score1)
    @Nullable
    CustomTextView score1;

    @BindView(R.id.score2)
    @Nullable
    CustomTextView score2;


    @BindView(R.id.team1)
    @Nullable
    CustomTextView teamName1;

    @BindView(R.id.team2)
    @Nullable
    CustomTextView teamName2;

    @BindView(R.id.overs1)
    @Nullable
    CustomTextView overs1;

    @BindView(R.id.overs2)
    @Nullable
    CustomTextView overs2;
    private MatchDetailOutPut matchResponse;


    @OnClick(R.id.viewPlayerStates)
    void onPlayerStateClick() {

        PlayerPointsActivity.start(mContext, "", matchGUID, "", statusId);
    }

    @BindView(R.id.swipeContainer)
    @Nullable
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.view1)
    @Nullable
    View view1;
    //BottomSheetPreviewFragment dialogFragment;
    String type = "";
    //ResponseContestDetails mResponseContestDetails;
    String loginSessionKey = "";

    String isPrivacyNameDisplay = "";

    String seriesGUId = "";
    /*
        @OnClick(R.id.ll_view_players_points)
        @Optional
        public void score(View view) {
            if (details == null) return;
            if (details.getMatchDetail().getMatchStatus().equals("FIXTURE")) {
                onShowSnackBar(AppUtils.getStrFromRes(R.string.please_wait_match_not_started_yed));
            } else {
                //ScoreBoardActivity.start(mContext, details.getMatchDetail().getMatchId(), details.getMatchDetail().getSeriesId());
            }
        }*/
    Loader loader;
    Context mContext;

    String contestId = "";
    CountDownTimer countDownTimer;

    AlertDialog alertRefreshDialog;
    //LeaderBoardFragment leaderBoardFragment;
    android.app.ProgressDialog bar;


    private BroadcastReceiver updates_receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent i) {
            try {
                if (i.getAction().equals(LeaderBoardMainFragment.class.getSimpleName())) {
                    if (i.hasExtra("KEY")) {
                        if (i.getStringExtra("KEY").equals("REFRESH")) {
                            //callTask();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };


    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(DownloadServiceHttpUrl.MESSAGE_PROGRESS)) {

                Download download = intent.getParcelableExtra("download");

                if (download.getStatus() == Download.DownloadStatus.START) {

                    if (bar != null && bar.isShowing())
                        bar.dismiss();
                    bar = new android.app.ProgressDialog(getActivity());
                    bar.setCancelable(false);
                    bar.setMessage("Downloading...");
                    bar.setIndeterminate(true);
                    bar.setCanceledOnTouchOutside(false);
                    bar.show();

                } else if (download.getStatus() == Download.DownloadStatus.DOWNLOADING) {
                    bar.setIndeterminate(false);
                    bar.setMax(100);
                    bar.setProgress(download.getProgress());
                    String msg = "";
                    if (download.getProgress() > 99) {
                        msg = "Finishing... ";
                    } else {
                        msg = "Downloading... " + download.getProgress() + "%";
                    }
                    bar.setMessage(msg);

                } else if (download.getStatus() == Download.DownloadStatus.COMPLETED) {
                    if (bar != null && bar.isShowing())
                        bar.dismiss();


                    try {
                        //onShowSnackBar("File Download Complete");
                        FileOpen.openFile(mContext, new File(download.getFilePath()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        //onShowSnackBar(e.getMessage());
                    }

                } else if (download.getStatus() == Download.DownloadStatus.ERROR) {
                    if (bar != null && bar.isShowing())
                        bar.dismiss();
                }
            }
        }
    };


    public void setSwipeRefreshLayout(boolean refreshLayout) {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setEnabled(refreshLayout);
    }

    @OnClick(R.id.rl_winnings)
    @Optional
    public void winnings(View view) {
        if (mContestDetailOutput == null) return;


        List<WinnersRankBean> rankList = new ArrayList<>();

        for (int i = 0; i < mContestDetailOutput.getData().getCustomizeWinning().size(); i++) {

            ContestDetailOutput.DataBean.CustomizeWinningBean customizeWinningBean = mContestDetailOutput.getData().getCustomizeWinning().get(i);
            WinnersRankBean mWinnersRankBean = new WinnersRankBean();

            mWinnersRankBean.setFrom(customizeWinningBean.getFrom());
            mWinnersRankBean.setTo(customizeWinningBean.getTo());
            if (mContestDetailOutput.getData().getSmartPool().equalsIgnoreCase("Yes")) {
                mWinnersRankBean.setProductName(customizeWinningBean.getProductName());
                mWinnersRankBean.setProductUrl(customizeWinningBean.getProductUrl());
            } else {
                mWinnersRankBean.setPercent(customizeWinningBean.getPercent());
                mWinnersRankBean.setWinningAmount(customizeWinningBean.getWinningAmount());

            }

            rankList.add(i, mWinnersRankBean);


        }
        if (mContestDetailOutput.getData().getSmartPool().equalsIgnoreCase("Yes")) {
            showPreview(rankList, null, mContestDetailOutput.getData().getWinningType());
        } else {
            showPreview(rankList, wininngAmmount, mContestDetailOutput.getData().getWinningType());
        }


//        showPreview(rankList, wininngAmmount);
    }

    @OnClick(R.id.ctvSwitchTeam)
    @Optional
    public void switchTeam(View view) {
        if (mContestDetailOutput == null) return;

        if (mContestDetailOutput.getData().getIsJoined().equals("Yes")) {
            MyTeamActivityStart(mContext, matchGUID, contestGUID, mContestDetailOutput.getData().getEntryFee(),
                    mContestDetailOutput.getData().getUserTeamDetails().get(0).getUserTeamGUID());
        }

    }


    public void download() {

        if (statusId.equals("Pending")) {
            onShowSnackBar(AppUtils.getStrFromRes(R.string.view_team_fixture_msg));
        } else {
            DownloadTeamInput downloadTeamInput = new DownloadTeamInput();
            downloadTeamInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            downloadTeamInput.setContestGUID(contestGUID);
            downloadTeamInput.setMatchGUID(matchGUID);

            mContestLeaderPresenterImpl.actionDownloadTeam(downloadTeamInput);
        }


    }

    @OnClick(R.id.ctv_join)
    @Optional
    public void join(View view) {
        /*if (mContestDetailOutput == null) return;
        if (mContestDetailOutput.getData().getIsJoined().equals("0")) {
            if (mContestDetailOutput.getData().getStatics().getTotalTeams().equals("0")) {
                CreateTeamActivityStart(mContext,  matchId, contestId);
            } else {
                MyTeamActivityStart(mContext,matchGUID,contestGUID,mContestDetailOutput.getData().getEntryFee());
            }
        } else {
            if (mContestDetailOutput.getData().getEntryType().equals("Multiple")) {
                MyTeamActivityStart(mContext,matchGUID,contestGUID,mContestDetailOutput.getData().getEntryFee());
            } else {
              *//*  InviteContestActivity.start(mContext,
                        details.getResponse().getUserInviteCode());*//*
            }

        }*/


        if (mContestDetailOutput == null) return;
        if (mContestDetailOutput.getData().getStatics().getTotalTeams().equals("0")) {
            CreateTeamActivityStart(mContext,
                    matchGUID,
                    mContestDetailOutput.getData().getContestGUID(), mContestDetailOutput.getData().getEntryFee());
        } else {
            if (mContestDetailOutput.getData().getIsJoined().equals("No")) {
                MyTeamActivityStart(mContext, matchGUID, contestGUID, mContestDetailOutput.getData().getEntryFee());
            } else {

                if (mContestDetailOutput.getData().getEntryType().equals("Multiple")) {
                    MyTeamActivityStart(mContext, matchGUID, contestGUID, mContestDetailOutput.getData().getEntryFee());
                } else {
                    InviteContestActivity.start(mContext,
                            mContestDetailOutput.getData().getUserInvitationCode(), matchTeamVS);
                }

            }
        }

    }

   /* @OnClick(R.id.ctv_re_join)
    @Optional
    public void rejoin(View view) {
        if (details == null) return;
        if (details.getMyTeam().equals("0")) {
            CreateTeamActivityStart(mContext, details.getMatchDetail().getSeriesId(), matchId, details.getMatchDetail().getLocalteamId(), details.getMatchDetail().getVisitorteamId(), details.getResponse().getId(), details.getResponse().getTeamEntryFee(), details.getResponse().getUserInviteCode());
        } else {
            MyTeamActivityStart(mContext, details.getMatchDetail().getSeriesId(), matchId, details.getMatchDetail().getLocalteamId(), details.getMatchDetail().getVisitorteamId(), details.getResponse().getId(), details.getResponse().getTeamEntryFee(), details.getResponse().getUserInviteCode(), details.getResponse().getChip());
        }
    }*/

    @OnClick(R.id.dreamTeam)
    void onDreamTeamClick() {

       /* mMyProfileParentPresenterImpl.allPlayersScore(AppSession.getInstance().getLoginSession().
                        getResponse().getLogin_session_key(), mResponseContestDetails.getMatchDetail().getSeriesId(),
                mResponseContestDetails.getMatchDetail().getLocalteamId(),
                mResponseContestDetails.getMatchDetail().getVisitorteamId(), matchId);*/



      /*  mMyProfileParentPresenterImpl.allPlayersScore(AppSession.getInstance().getLoginSession().
                getResponse().getLogin_session_key(), "111251", "5", "13", "38368");*/


        callAllPlayesScore();
    }

    void callAllPlayesScore() {


        DreamTeamInput dreamTeamInput = new DreamTeamInput();
        dreamTeamInput.setMatchGUID(matchGUID);
        mContestLeaderPresenterImpl.getDreamTeam(dreamTeamInput);


    }

    @OnClick(R.id.tellYourFriends)
    void onTellYourFriend() {
        /*AppUtils.shareTextUrl(getActivity(), AppUtils.getStrFromRes(R.string.inviteFriendsMore),
                "JHJKGG45HGJH", AppUtils.getStrFromRes(R.string.app_name));*/
        InviteFriendsActivity.start(mContext);

    }

    public void CreateTeamActivityStart(Context context, String seriesId, String matchId, String localteamId, String visitorteamId, String contestId, String joiningAmount, String userInviteCode) {
        Intent starter = new Intent(context, CreateTeamActivity.class);
        starter.putExtra("seriesId", seriesId);
        starter.putExtra("MatchGUID", matchId);
        starter.putExtra("localteamId", localteamId);
        starter.putExtra("visitorteamId", visitorteamId);
        starter.putExtra("contestId", contestId);
        starter.putExtra("join", "0");
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("userInviteCode", userInviteCode);
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }

    public void CreateTeamActivityStart(Context context, String matchGUID, String contestId, String joiningAmount) {
        Intent starter = new Intent(context, CreateTeamActivity.class);

        starter.putExtra("MatchGUID", matchGUID);
        starter.putExtra("contestId", contestId);
        starter.putExtra("join", "0");
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("cashBonusContribution", mContestDetailOutput.getData().getCashBonusContribution());


        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }


    public void MyTeamActivityStart(Context context, String matchId, String contestId, String joiningAmount) {
        Intent starter = new Intent(context, MyTeamsActivity.class);
        starter.putExtra("contestId", contestId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("statusId", statusId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("join", "0");
        starter.putExtra("cashBonusContribution", mContestDetailOutput.getData().getCashBonusContribution());


        startActivityForResult(starter, BaseActivity.REQUEST_CODE_JOIN_CONTESTS);


    }

    public void MyTeamActivityStart(Context context, String matchId, String contestId, String joiningAmount, String teamId) {
        Intent starter = new Intent(context, MyTeamsActivity.class);
        starter.putExtra("contestId", contestId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("statusId", statusId);
        starter.putExtra("teamId", teamId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("SWITCH", true);
        starter.putExtra("join", "0");


        startActivityForResult(starter, BaseActivity.REQUEST_CODE_JOIN_CONTESTS);


    }

    /*  public void MyTeamActivitySwitch(Context context, String seriesId, String matchId, String localteamId, String visitorteamId, String contestId, String joiningAmount, String userInviteCode, String chip) {

          Intent starter = new Intent(context, MyTeamsActivity.class);
          starter.putExtra("seriesId", seriesId);
          starter.putExtra("matchId", matchId);
          starter.putExtra("localteamId", localteamId);
          starter.putExtra("visitorteamId", visitorteamId);
          starter.putExtra("contestId", contestId);
          starter.putExtra("joiningAmount", joiningAmount);
          starter.putExtra("userInviteCode", userInviteCode);
          starter.putExtra("chip", chip);
          starter.putExtra("SWITCH", true);
          starter.putExtra("teamId", details.getResponse().getTeamId());

          startActivityForResult(starter, BaseActivity.REQUEST_CODE_SWITCH_TEAM);
      }*/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("requestCode", "requestCode: " + BaseActivity.REQUEST_CODE_CREATE_TEAM);

        if (requestCode == BaseActivity.REQUEST_CODE_CREATE_TEAM && resultCode == getActivity().RESULT_OK) {
            callContestDetail();
        } else if (requestCode == BaseActivity.REQUEST_CODE_JOIN_CONTESTS && resultCode == getActivity().RESULT_OK) {
            callContestDetail();
        } else if (requestCode == BaseActivity.REQUEST_CODE_SWITCH_TEAM && resultCode == getActivity().RESULT_OK) {
            callContestDetail();
        }
    }


    private ContestLeaderPresenterImpl mContestLeaderPresenterImpl;


    public static LeaderBoardMainFragment getInstance(Bundle bundle) {
        LeaderBoardMainFragment profileFragment = new LeaderBoardMainFragment();
        profileFragment.setArguments(bundle);
        return profileFragment;
    }

    @Override
    public void init() {

        if (isAttached()) {
            if (AppSession.getInstance().getLoginSession() != null) {
                loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();

            }

            mContext = getActivity();
            if (coordinatorLayout != null) {
                coordinatorLayout.setVisibility(View.INVISIBLE);
            }


            registerReceiver();
            if (getArguments() != null) {
                if (getArguments().containsKey("matchGUID")) {
                    matchGUID = getArguments().getString("matchGUID");
                }
                if (getArguments().containsKey("contestId")) {
                    contestGUID = getArguments().getString("contestGUID");
                }
            }
            //initiate loader

            loader = new Loader(getCurrentView());

            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    callContestDetail();

                }
            });

            frameLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    setSwipeRefreshLayout(true);
                    return false;
                }
            });


            loader.start();

            if (swipeRefreshLayout != null) {
                // Setup refresh listener which triggers new data loading
                swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        // callTask();
                    }
                });
                // Configure the refreshing colors
                swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark,
                        R.color.colorAccent,
                        R.color.secondary_tab_color);

            }

            //view profile calling

            if (getArguments().containsKey("matchGUID")) {

                matchGUID = getArguments().getString("matchGUID");
                statusId = getArguments().getString("statusId");
                contestGUID = getArguments().getString("contestGUID");
            }
            mContestLeaderPresenterImpl = new ContestLeaderPresenterImpl(this, new UserInteractor());

            callProfile();

            callMatchDetail(matchGUID, statusId);

            callContestDetail();
            LocalBroadcastManager.getInstance(mContext).registerReceiver(updates_receiver, new IntentFilter(LeaderBoardMainFragment.class.getSimpleName()));


        }

    }

    public void callProfile() {
        LoginInput mLoginInput = new LoginInput();
        mLoginInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mLoginInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
        mLoginInput.setParams(Constant.GET_PROFILE_PARAMS);
        mContestLeaderPresenterImpl.actionViewProfile(mLoginInput);
    }

    public void callMatchDetail(String matchGuid, String statusId) {

        MatchDetailInput mMatchDetailInput = new MatchDetailInput();
        mMatchDetailInput.setPrivacy("No");
        mMatchDetailInput.setMatchGUID(matchGuid);
        mMatchDetailInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchDetailInput.setStatus(statusId);
        mMatchDetailInput.setParams(Constant.MATCH_PARAMS);

        mContestLeaderPresenterImpl.actionMatchdetail(mMatchDetailInput);

    }


    @Override
    public void onDestroy() {

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(updates_receiver);
        if (broadcastReceiver != null)
            LocalBroadcastManager.getInstance(mContext).unregisterReceiver(broadcastReceiver);
        if (mContestLeaderPresenterImpl != null)
            mContestLeaderPresenterImpl.actionLoginCancel();
        super.onDestroy();
    }

    @Override
    public int getLayout() {
        return R.layout.leader_board_main;
    }


    @Override
    public void showLoading() {
       /* if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();*/

        if (isAdded() && getActivity() != null) {
            loader.start();
        }

    }

    @Override
    public void onResume() {

        dreamhideLoading();
        super.onResume();
    }

    @Override
    public void hideLoading() {


        if (isAdded() && getActivity() != null) {
            loader.hide();
        }

    }

    @Override
    public void onMatchSuccess(MatchDetailOutPut mMatchDetailOutPut) {
        if (mMatchDetailOutPut.getData() != null) {
            matchResponse = mMatchDetailOutPut;
            if (isAdded() && getActivity() != null) {
                if (mMatchDetailOutPut.getData().getStatus() != null) {


                    ViewUtils.setImageUrl(customImageViewTeamFlagLocal, mMatchDetailOutPut.getData().getTeamFlagLocal());
                    ViewUtils.setImageUrl(customImageViewTeamFlagVisitor, mMatchDetailOutPut.getData().getTeamFlagVisitor());
                    customTextViewTeamNameLocal.setText(mMatchDetailOutPut.getData().getTeamNameShortLocal());
                    customTextViewTeamNameVisitor.setText(mMatchDetailOutPut.getData().getTeamNameShortVisitor());


                    matchTeamVS = mMatchDetailOutPut.getData().getTeamNameShortLocal() + " " + AppUtils.getStrFromRes(R.string.vs)
                            + " " + mMatchDetailOutPut.getData().getTeamNameShortVisitor();

                    teamsVS.setText(mMatchDetailOutPut.getData().getTeamNameShortLocal() + " " + AppUtils.getStrFromRes(R.string.vs)
                            + " " + mMatchDetailOutPut.getData().getTeamNameShortVisitor());

                    seriesGUId = mMatchDetailOutPut.getData().getSeriesGUID();

                    if (customTextViewFullTime != null) {
                        switch (mMatchDetailOutPut.getData().getStatus()) {
                            case Constant.Pending:
                                setTime(mMatchDetailOutPut.getData().getMatchStartDateTime(), mMatchDetailOutPut.getData().getMatchDate(),
                                        mMatchDetailOutPut.getData().getMatchTime(), mMatchDetailOutPut.getData().getCurrentDateTime());

                                break;
                            case Constant.Running:
                                customTextViewFullTime.setText(mMatchDetailOutPut.getData().getStatus());
                                customTextViewFullTime.setTextColor(getResources().getColor(R.color.green));

                                customTextViewMatchStatus.setText(getString(R.string.Running));
                                customTextViewMatchStatus.setTextColor(getResources().getColor(R.color.green));
                                break;
                            case Constant.Completed:
                                customTextViewFullTime.setText(mMatchDetailOutPut.getData().getStatus());
                                customTextViewFullTime.setTextColor(getResources().getColor(R.color.green));

                                customTextViewMatchStatus.setText(mMatchDetailOutPut.getData().getStatus());
                                customTextViewMatchStatus.setTextColor(getResources().getColor(R.color.green));
                                break;


                            default:
                                customTextViewFullTime.setText(mMatchDetailOutPut.getData().getStatus());
                                customTextViewMatchStatus.setText(mMatchDetailOutPut.getData().getStatus());
                                customTextViewMatchStatus.setTextColor(getResources().getColor(R.color.red));
                                break;
                        }


                    }

                    if (!mMatchDetailOutPut.getData().getStatus().equals(Constant.Pending)) {

                        if (mMatchDetailOutPut.getData().getMatchScoreDetails().getTeamScoreLocal() != null) {
                            setScoreBoard(mMatchDetailOutPut);
                        }

                    }
//                    String team1 = mMatchDetailOutPut.getData().getMatchScoreDetails().getTeamScoreLocal().getShortName();
//
//                    String team2 = mMatchDetailOutPut.getData().getMatchScoreDetails().getTeamScoreVisitor().getShortName();
//
//                    scoreData.setText(team1 + "   " + "()" + "     |    " + team2 + "   " + "()");

                }

            }
        }


    }

    void setScoreBoard(MatchDetailOutPut mMatchDetailOutPut) {
        if (!mMatchDetailOutPut.getData().getMatchScoreDetails().getStatusNote().trim().isEmpty()) {
            liveStatus.setText(mMatchDetailOutPut.getData().getMatchScoreDetails().getStatusNote());
        } else if (!mMatchDetailOutPut.getData().getMatchScoreDetails().getToss().trim().isEmpty()) {
            liveStatus.setText(mMatchDetailOutPut.getData().getMatchScoreDetails().getToss());
        } else if (!mMatchDetailOutPut.getData().getMatchScoreDetails().getMatchVenue().trim().isEmpty()) {
            liveStatus.setText("Venue - " + mMatchDetailOutPut.getData().getMatchScoreDetails().getMatchVenue());
        } else {
            liveStatus.setText("Yet to start!");
        }

        String team1 = mMatchDetailOutPut.getData().getMatchScoreDetails().getTeamScoreLocal().getShortName();

        String team2 = mMatchDetailOutPut.getData().getMatchScoreDetails().getTeamScoreVisitor().getShortName();

        String team1Score = mMatchDetailOutPut.getData().getMatchScoreDetails().getTeamScoreLocal().getScores().replace('/', '-');

        String team2Score = mMatchDetailOutPut.getData().getMatchScoreDetails().getTeamScoreVisitor().getScores().replace('/', '-');

        String teamOver1 = mMatchDetailOutPut.getData().getMatchScoreDetails().getTeamScoreLocal().getOvers();
        String teamOver2 = mMatchDetailOutPut.getData().getMatchScoreDetails().getTeamScoreVisitor().getOvers();


        // String team2Over = mMatchDetailOutPut.getData().getMatchScoreDetails().getTeamScoreVisitor().getOvers();


        teamName1.setText(team1);
        if (team1Score.equalsIgnoreCase("")) {
            score1.setText("NA");
        } else {
            score1.setText(team1Score);
        }

        teamName2.setText(team2);
        if (team1Score.equalsIgnoreCase("")) {
            score2.setText("NA");
        } else {
            score2.setText(team2Score);
        }

        if (AppSession.getInstance().getGameType() == 1) {
            if (teamOver2.equalsIgnoreCase("")) {
                overs2.setText("NA");
            } else {
                overs2.setText("(" + teamOver2 + ")");
            }
            if (teamOver1.equalsIgnoreCase("")) {
                overs1.setText("NA");
            } else {
                overs1.setText("(" + teamOver1 + ")");
            }

        } else {
            overs1.setVisibility(View.GONE);
            overs2.setVisibility(View.GONE);
        }


        if (teamName1.getText().toString().equalsIgnoreCase("") || teamName2.getText().toString().equalsIgnoreCase("")) {
            teamName1.setText(matchResponse.getData().getTeamNameShortLocal() + "()");
            teamName2.setText(matchResponse.getData().getTeamNameShortVisitor() + "()");
        }

       /*
        teamName1.setText(team1);
        score1.setText(team1Score);


        teamName2.setText(team2);
        score2.setText(team2Score);

        if (AppSession.getInstance().getGameType()==1){
            overs2.setText("("+teamOver2+")");
            overs1.setText("("+teamOver1+")");

        }else {
            overs1.setVisibility(View.GONE);
            overs2.setVisibility(View.GONE);
        }
*/

        //joinContestUpcoming.setText(" FOR "+team1+" vs "+team2);

    }

    private void callContestDetail() {

        ContestDetailInput mContestDetailInput = new ContestDetailInput();
        mContestDetailInput.setContestGUID(contestGUID);
        mContestDetailInput.setMatchGUID(matchGUID);
        mContestDetailInput.setSessionKey(loginSessionKey);
        mContestDetailInput.setParams(Constant.CONTEST_PARAM);

        mContestLeaderPresenterImpl.getContest(mContestDetailInput);

    }


    @Override
    public void onMatchFailure(String errMsg) {

        if (isAdded() && getActivity() != null) {
            loader.error(errMsg);
        }
    }

    @Override
    public void onContestDetailSuccess(ContestDetailOutput mContestDetail) {

        try {

            wininngAmmount = mContestDetail.getData().getWinningAmount();
            mContestDetailOutput = mContestDetail;
            loader.hide();


            if (mContestDetail.getData().getPrivacy().equalsIgnoreCase("yes") && mContestDetail.getData().getIsPrivacyNameDisplay().equals("Yes")) {
                contestTypeName.setText(mContestDetail.getData().getContestName());
                contestTypeName.setVisibility(View.VISIBLE);
            } else {
                contestTypeName.setVisibility(View.GONE);
            }

        /*teamsVS.setText(matchResponse.getData().getTeamNameShortLocal() + " " + AppUtils.getStrFromRes(R.string.vs)
                    + " " + matchResponse.getData().getTeamNameShortVisitor());*/

            if (coordinatorLayout != null) {
                coordinatorLayout.setVisibility(View.VISIBLE);
            }


            if (mContestDetail.getData().getIsJoined().equalsIgnoreCase("Yes")) {
                ctvJoin.setVisibility(View.GONE);
                switchTeam_lin.setVisibility(View.VISIBLE);
            } else {
                ctvJoin.setVisibility(View.VISIBLE);
                switchTeam_lin.setVisibility(View.GONE);
            }

            if (mContestDetail.getData().getIsJoined().equals("Yes")) {
                Collections.sort(mContestDetail.getData().getUserTeamDetails(), new Comparator<ContestDetailOutput.DataBean.UserTeamDetailsBean>() {
                    @Override
                    public int compare(ContestDetailOutput.DataBean.UserTeamDetailsBean userTeamDetailsBean, ContestDetailOutput.DataBean.UserTeamDetailsBean t1) {
                        return userTeamDetailsBean.getUserTeamName().compareTo(t1.getUserTeamName());
                    }
                });
                String tem = "Team ";
                for (int i = 1; i <= mContestDetail.getData().getUserTeamDetails().size(); i++) {
                    if (i == 1) {
                        tem += "1";
                    } else if (i == mContestDetail.getData().getUserTeamDetails().size()) {
                        tem += " & " + i;
                    } else {
                        tem += ", " + i;
                    }
                }
                teamName.setText(tem);
            }

            if (!mContestDetail.getData().getNoOfWinners().equals("1")) {
                if (!mContestDetail.getData().getNoOfWinners().equals("0")) {
                    rlWinnings.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_down_arrow, 0);
                    rlWinnings.setCompoundDrawablePadding(10);
                }
            }

            if (customTextViewFullTime != null) {
                switch (mContestDetail.getData().getStatusID()) {
                    case "1":

                        scorecard.setVisibility(View.GONE);
                        dreamteamLin.setVisibility(View.GONE);

                        if (mContestDetail.getData().getIsConfirm().equals("Yes")) {
                            confirmWinningTag.setVisibility(View.VISIBLE);
                        } else {
                            confirmWinningTag.setVisibility(View.GONE);
                        }
                        if (mContestDetail.getData().getEntryType().equals("Single")) {
                            //ctvReJoin.setVisibility(View.VISIBLE);
                            // ctvSwitchTeam.setVisibility(View.GONE);
                            joinMultipleTag.setVisibility(View.GONE);
                        } else {
                            joinMultipleTag.setVisibility(View.VISIBLE);
                        }

                        if (mContestDetail.getData().getCustomizeWinning() != null && mContestDetail.getData().getCustomizeWinning().size() > 0) {
                            rlWinnings.setVisibility(View.VISIBLE);
                            winners.setVisibility(View.VISIBLE);
                        } else {
                            rlWinnings.setVisibility(View.GONE);
                            winners.setVisibility(View.GONE);
                        }

                        if (mContestDetail.getData() != null) {

                            if (ctvJoin != null && /*ctvJoined != null &&*/ ctvSwitchTeam != null) {
                                ctvSwitchTeam.setVisibility(View.VISIBLE);
                                if (mContestDetail.getData().getContestSize().equals("Unlimited")) {

                                    if (progressBar != null) {
                                        if (mContestDetail.getData().getTotalJoined().equals("0")) {
                                            progressBar.setProgress(0);
                                        } else {
                                            progressBar.setProgress(Integer.parseInt(mContestDetail.getData().getTotalJoined()));
                                        }
                                    }
                                    if (progressBar != null) {
                                        if (mContestDetail.getData().getTotalJoined().equals("0")) {
                                            progressBar.setProgress(0);
                                        } else {
                                            progressBar.setProgress(Integer.parseInt(mContestDetail.getData().getTotalJoined()));
                                        }
                                    }
                                    ctvJoin.setVisibility(View.VISIBLE);
                                    rlWinnings.setVisibility(View.VISIBLE);
                                    ctvSwitchTeam.setVisibility(View.VISIBLE);
                                    spotLeftCount.setVisibility(View.VISIBLE);
                                    spotLeftCount.setText("Total Joined: " + mContestDetail.getData().getTotalJoined());
                                    rlWinnings.setText(mContestDetail.getData().getWinningRatio() + "%");

                                    if (Integer.parseInt(mContestDetail.getData().getTotalJoined()) >= 2) {
                                        rlWinnings.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_down_arrow, 0);
                                        rlWinnings.setEnabled(true);
                                    } else {
                                        rlWinnings.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                                        rlWinnings.setEnabled(false);
                                    }

                                    teamsCount.setText(mContestDetail.getData().getContestSize() + " " + AppUtils.getStrFromRes(R.string.spot));
                                    if (mContestDetail.getData().getIsJoined().equals("Yes")) {
                                        if (!mContestDetail.getData().getEntryType().equals("Single")) {
                                            ctvJoin.setText(AppUtils.getStrFromRes(R.string.joinplus));
                                        } else {
                                            ctvJoin.setText(AppUtils.getStrFromRes(R.string.invite));
                                        }
                                    } else {
                                        ctvJoin.setText(AppUtils.getStrFromRes(R.string.joinThisContest));
                                    }


                                } else {

                                    progressBar.setVisibility(View.VISIBLE);

                                    if (progressBar != null) {
                                        if (mContestDetail.getData().getTotalJoined().equals("0")) {
                                            progressBar.setProgress(0);
                                        } else {
                                            progressBar.setProgress(ViewUtils.getPercentage(Float.parseFloat(mContestDetail.getData().getTotalJoined()),
                                                    Integer.parseInt(mContestDetail.getData().getContestSize())));
                                        }
                                    }

                                    if (isFull(mContestDetail)) {
                                        ctvJoin.setVisibility(View.GONE);
                                        //ctvReJoin.setVisibility(View.GONE);
                                        //ctvJoined.setText(AppUtils.getStrFromRes(R.string.contest_full) + " (" + mContestDetail.getData().getContestSize() + " " + AppUtils.getStrFromRes(R.string.teams) + ")");

                                        //teamsNo.setText(mContestDetail.getData().getContestSize() + " " + AppUtils.getStrFromRes(R.string.teams));

                                    } else {
                                        ctvJoin.setVisibility(View.VISIBLE);
                                        //ctvReJoin.setVisibility(View.GONE);
                                      /*  ctvJoined.setText(mContestDetail.getData().getTotalJoined()
                                                + "/" + mContestDetail.getData().getContestSize() + " " + AppUtils.getStrFromRes(R.string.joined));*/

                                      /*  teamsNo.setText(AppUtils.getStrFromRes(R.string.team)
                                                + "" + mContestDetail.getData().getTotalJoined() + "/" +
                                                mContestDetail.getData().getContestSize() + " " +
                                                AppUtils.getStrFromRes(R.string.joined) + " ");*/

                                        if (mContestDetail.getData().getIsJoined().equals("Yes")) {

                                            if (!mContestDetail.getData().getEntryType().equals("Single")) {
                                                ctvJoin.setText(AppUtils.getStrFromRes(R.string.joinplus));
                                            } else {
                                                ctvJoin.setText(AppUtils.getStrFromRes(R.string.invite));
                                            }
                                            ctvSwitchTeam.setVisibility(View.VISIBLE);


                                        } else {
                                            joinMultipleTag.setVisibility(View.GONE);
                                            ctvJoin.setText(AppUtils.getStrFromRes(R.string.joinThisContest));
                                        }
                                    }
                                }
                            }


                            customTextViewFullTime.setTextColor(mContext.getResources().getColor(R.color.green));
                        }

                        break;
                    case "2":

                        scorecard.setVisibility(View.GONE);
                        dreamteamLin.setVisibility(View.GONE);
                        if (mContestDetail.getData().getCustomizeWinning() != null
                                && mContestDetail.getData().getCustomizeWinning().size() > 0) {
                            rlWinnings.setVisibility(View.VISIBLE);
                        } else {
                            rlWinnings.setVisibility(View.GONE);
                        }


                        if (ctvSwitchTeam != null)
                            ctvSwitchTeam.setVisibility(View.GONE);
                        ctvJoin.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        customTextViewFullTime.setTextColor(mContext.getResources().getColor(R.color.green));
                        customTextViewFullTime.setText(AppUtils.getStrFromRes(R.string.in_progress));

                        customTextViewFullTime.setText(mContestDetail.getData().getStatusID().equals("5") ? "Live  " :
                                mContestDetail.getData().getStatus());
                        teamsVS.setText(mContestDetail.getData().getTeamNameShortLocal() + " " + AppUtils.getStrFromRes(R.string.vs)
                                + " " + mContestDetail.getData().getTeamNameShortVisitor());

                        joinedContest(mContestDetail);

                        break;
                    case "5":

                        scorecard.setVisibility(View.VISIBLE);
                        dreamteamLin.setVisibility(View.VISIBLE);


                        if (mContestDetail.getData().getContestSize().equals("Unlimited")) {
                            rlWinnings.setVisibility(View.VISIBLE);
                            rlWinnings.setText(mContestDetail.getData().getWinningRatio() + "%");
                            if (Integer.parseInt(mContestDetail.getData().getTotalJoined()) >= 2) {
                                rlWinnings.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_down_arrow, 0);
                                rlWinnings.setEnabled(true);
                            } else {
                                rlWinnings.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                                rlWinnings.setEnabled(false);
                            }
                        } else {
                            if (mContestDetail.getData().getCustomizeWinning() != null
                                    && mContestDetail.getData().getCustomizeWinning().size() > 0) {
                                rlWinnings.setVisibility(View.VISIBLE);
                            } else {
                                rlWinnings.setVisibility(View.GONE);
                            }
                        }


                        if (ctvSwitchTeam != null)
                            ctvSwitchTeam.setVisibility(View.GONE);
                        ctvJoin.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        customTextViewFullTime.setTextColor(mContext.getResources().getColor(R.color.green));
                        customTextViewFullTime.setText(AppUtils.getStrFromRes(R.string.completed));

                        customTextViewFullTime.setText(mContestDetail.getData().getMatchScoreDetails().getStatusLive());
                        teamsVS.setText(mContestDetail.getData().getTeamNameShortLocal() + " " + AppUtils.getStrFromRes(R.string.vs)
                                + " " + mContestDetail.getData().getTeamNameShortVisitor());

                        joinedContest(mContestDetail);
                        break;
                }
            }
            if (mContestDetail.getData() != null) {
                if (customTextViewWinningAmount != null)

                    if (mContestDetail.getData().getContestType().equalsIgnoreCase("Infinity Pool")) {
                        if (mContestDetail.getData().getWinningAmount().equalsIgnoreCase("0")) {
                            BigDecimal decimal = new BigDecimal(mContestDetail.getData().getWinUpTo()).stripTrailingZeros();

                            customTextViewWinningAmount.setText(decimal.toPlainString() + "x Winning");
                        } else {
                            if (mContestDetail.getData().getWinningType() != null && mContestDetail.getData().getWinningType().equalsIgnoreCase("Free Join Contest")) {
                                customTextViewWinningAmount.setText("Bonus " + mContestDetail.getData().getWinningAmount());
                            } else {
                                customTextViewWinningAmount.setText(AppUtils.getStrFromRes(R.string.price_unit) + "" + mContestDetail.getData().getWinningAmount());

                            }


                        }
                    } else {
                        if (mContestDetail.getData().getWinningType() != null && mContestDetail.getData().getWinningType().equalsIgnoreCase("Free Join Contest")) {
                            customTextViewWinningAmount.setText("Bonus " + mContestDetail.getData().getWinningAmount());
                        } else {
                            customTextViewWinningAmount.setText(AppUtils.getStrFromRes(R.string.price_unit) + "" + mContestDetail.getData().getWinningAmount());

                        }

                    }
//                    customTextViewWinningAmount.setText(" " + mContestDetail.getData().getWinningAmount());
                if (!mContestDetail.getData().getContestSize().equals("Unlimited")) {
                    teamsCount.setText(mContestDetail.getData().getContestSize()
                            + " " + AppUtils.getStrFromRes(R.string.spot));
                    rlWinnings.setText(mContestDetail.getData().getNoOfWinners());
                    int spotLeft = Integer.valueOf(mContestDetail.getData().getContestSize()) - Integer.valueOf(mContestDetail.getData().getTotalJoined());
                    spotLeftCount.setText(AppUtils.getStrFromRes(R.string.only) + " " + spotLeft
                            + " " + AppUtils.getStrFromRes(R.string.spotLeft));
                } else {
                    teamsCount.setText(AppUtils.getStrFromRes(R.string.spot));
                    spotLeftCount.setText("Total joined : " + mContestDetail.getData().getTotalJoined());

                }


                if (customTextViewEntryFee != null) {
                    customTextViewEntryFee.setText(" " + mContestDetail.getData().getEntryFee());
                }

            }
            Bundle bundle = getArguments();
            if (bundle == null) bundle = new Bundle();

            bundle.putString("ContestGUID", mContestDetail.getData().getContestGUID());
            bundle.putString("MatchGUID", matchGUID);
            bundle.putString("StatusID", statusId);
            bundle.putString("seriesGUId", seriesGUId);
            bundle.putString("winningType", mContestDetail.getData().getWinningType());


            // if (leaderBoardFragment == null)
            setContests(bundle);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setContests(Bundle bundle) {
        mViewPagerAdapter = new BasePagerAdapter(getChildFragmentManager());
        switch (mContestDetailOutput.getData().getStatusID()) {
            case "1":
                //pending
                mViewPagerAdapter.addFrag(com.mw.eleven11.UI.contestDetailLeaderBoard.winnings.WinningsFragment.newInstance(mContestDetailOutput.getData()), "Winnings", 0);
                mViewPagerAdapter.addFrag(LeaderBoardFragment.getInstance(bundle), "Leaderboard", 1);
                break;
            default:
                mViewPagerAdapter.addFrag(com.mw.eleven11.UI.contestDetailLeaderBoard.winnings.WinningsFragment.newInstance(mContestDetailOutput.getData()), "Winnings", 0);
                mViewPagerAdapter.addFrag(LeaderBoardFragment.getInstance(bundle), "Leaderboard", 1);
                mViewPagerAdapter.addFrag(StatsFragment.newInstance(matchGUID, statusId), "Stats", 2);
                break;
        }


        if (mViewPager != null) {
            mViewPager.setVisibility(View.VISIBLE);
            mViewPager.setAdapter(mViewPagerAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
            AppUtils.applyFontedVerifyAccount(getActivity(), mViewPager, mTabLayout);
        }

    }

    @Override
    public void onContestDetailFailure(String errMsg) {
        hideLoading();
        onShowSnackBar(errMsg);
    }

    @Override
    public void onDownloadTeamSuccess(ResponseDownloadTeam mResponseDownloadTeam) {
        hideLoading();
        mProgressDialog.dismiss();
        if (mResponseDownloadTeam.getData().getTeamsPdfFileURL() != null) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mResponseDownloadTeam.getData().getTeamsPdfFileURL()));
            startActivity(browserIntent);
        } else {
            onShowSnackBar("No data found!");
        }
    }

    @Override
    public void onDownloadTeamFailure(String errMsg) {
        mProgressDialog.dismiss();
        hideLoading();
        onShowSnackBar(errMsg);
    }

    @Override
    public void onDreamTeamSucess(DreamTeamOutput dreamTeamOutput) {

        hideLoading();
        if (dreamTeamOutput.getData().getRecords() != null) {


            List<PlayerRecord> recordList = new ArrayList<>();

            for (int i = 0; i < dreamTeamOutput.getData().getRecords().size(); i++) {

                DreamTeamOutput.DataBean.RecordsBean recordsBean = dreamTeamOutput.getData().getRecords().get(i);
                PlayerRecord player = new PlayerRecord();
                player.setPlayerGUID(recordsBean.getPlayerGUID());
                player.setPlayerName(recordsBean.getPlayerName());
                player.setPlayerRole(recordsBean.getPlayerRole());
                player.setPlayerPic(recordsBean.getPlayerPic());
                player.setTeamNameShort(recordsBean.getTeamNameShort());


                player.setPoints(recordsBean.getTotalPoints());
                player.setPointCredits(recordsBean.getPlayerSalary());
                player.setTotalPoints(recordsBean.getTotalPointCredits());
                player.setPointsData(recordsBean.getPointsData());


                player.setPlayerBattingStyle(recordsBean.getPlayerBattingStyle());
                player.setPlayerBowlingStyle(recordsBean.getPlayerBattingStyle());
                player.setSeriesGUID(seriesGUId);
                player.setPlayerCountry(recordsBean.getPlayerCountry());
                player.setTeamGUID(recordsBean.getTeamGUID());
                player.setPosition(recordsBean.getPlayerPosition());
                player.setLocalTeamName(dreamTeamOutput.getData().getRecords().get(0).getTeamGUID());

                player.setPlayerSelectedPercent(recordsBean.getPlayerSelectedPercent());

                recordList.add(player);

            }
            switch (AppSession.getInstance().getGameType()) {
                case 1:
                    showPreviewcrik(recordList, String.valueOf(dreamTeamOutput.getData().getTotalPoints()));
                    break;
                case 2:
                    showPreviewfoot(recordList,
                            String.valueOf(dreamTeamOutput.getData().getTotalPoints()));
                    break;
            }
        } else {
            AppUtils.showToast(mContext, AppUtils.getStrFromRes(R.string.pageNotFound));
        }
    }

    @Override
    public void onDreamTeamFailure(String errMsg) {
        hideLoading();
    }

    @Override
    public void dreamshowLoading() {

        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void dreamhideLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.dismiss();
    }

    @Override
    public void onProfileSuccess(LoginResponseOut responseLogin) {


        isPrivacyNameDisplay = responseLogin.getData().getIsPrivacyNameDisplay();

        LoginResponseOut.DataBean data = AppSession.getInstance().getLoginSession().getData();
        data.setIsPrivacyNameDisplay(responseLogin.getData().getIsPrivacyNameDisplay());
        LoginResponseOut loginSession = AppSession.getInstance().getLoginSession();
        loginSession.setData(data);
        AppSession.getInstance().setLoginSession(loginSession);

    }

    @Override
    public void onProfileFailure(String errMsg) {

        onShowSnackBar(errMsg);
    }

    @Override
    public void onShowSnackBar(String message) {
        AppUtils.showToast(mContext, message);
    }

    @Override
    public boolean isAttached() {
        return isAdded() && getActivity() != null;
    }

    private void registerReceiver() {

        LocalBroadcastManager bManager = LocalBroadcastManager.getInstance(getActivity());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadServiceHttpUrl.MESSAGE_PROGRESS);
        bManager.registerReceiver(broadcastReceiver, intentFilter);

    }

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


    public boolean isFull(ContestDetailOutput mContestDetailOutput) {
        if (Integer.valueOf(mContestDetailOutput.getData().getTotalJoined())
                == Integer.parseInt(mContestDetailOutput.getData().getContestSize())) {
            return true;
        } else {
            return false;
        }
    }

    void joinedContest(ContestDetailOutput mMatchDetails) {
        scorecard.setVisibility(View.VISIBLE);
        switchTeam_lin.setVisibility(View.GONE);
        switchTeam_lin.setVisibility(View.GONE);
        linout.setVisibility(View.GONE);
        view1.setVisibility(View.GONE);


        // liveStatus.setText(mMatchDetails.getData().getMatchScoreDetails().getStatusLive());

        /*if (!matchResponse.getData().getMatchScoreDetails().getStatusNote().trim().isEmpty()){
            liveStatus.setText(matchResponse.getData().getMatchScoreDetails().getStatusNote());
        }else if (!matchResponse.getData().getMatchScoreDetails().getToss().trim().isEmpty()){
            liveStatus.setText(matchResponse.getData().getMatchScoreDetails().getToss());
        }else if (!matchResponse.getData().getMatchScoreDetails().getMatchVenue().trim().isEmpty()){
            liveStatus.setText("Venue - "+matchResponse.getData().getMatchScoreDetails().getMatchVenue());
        }else {
            liveStatus.setText("Yet to start!");
        }*/

        if (mMatchDetails.getData().getMatchScoreDetails().getInnings() != null) {
            if (AppSession.getInstance().getGameType() == 1) {

                String team1 = "", team2 = "", team1Score = "", team2Score = "";

                for (int i = 0; i < mMatchDetails.getData().getMatchScoreDetails().getInnings().size(); i++) {

                    ContestDetailOutput.DataBean.MatchScoreDetailsBean.InningsBean inningsBean = new ContestDetailOutput.DataBean.MatchScoreDetailsBean.InningsBean();

                    inningsBean = mMatchDetails.getData().getMatchScoreDetails().getInnings().get(i);

                    if (i == 0) {
                        team1 = inningsBean.getShortName();
                        team1Score = inningsBean.getScores();
                    }
                    if (i == 2) {
                        team2 = inningsBean.getShortName();
                        team2Score = inningsBean.getScores();
                    }
                }
                scoreData.setText(team1 + "   " + team1Score + "     |    " + team2 + "   " + team2Score);
            }
        }


    }

    void showPreview(final List<WinnersRankBean> bean, final String totalWinngingAmmount, final String winningType) {
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
        dialogFragment.show(getFragmentManager(), dialogFragment.getTag());

    }

    private void showPreviewcrik(final List<PlayerRecord> bean, final String totalPoint) {
        final BottomSheetPreviewFragment dialogFragment = new BottomSheetPreviewFragment();
        dialogFragment.setUpdateable(new PlayerPreviewCallback() {
            @Override
            public void close() {

            }

            @Override
            public void edit() {
                /*CreateTeamActivityStart(mContext, bean.getSeriesId(), matchId, localteamId,
                        visitorteamId, new Gson().toJson(bean), bean.getName());*/
            }

            @Override
            public void refresh() {

            }

            @Override
            public String getTeamName() {
                return AppUtils.getStrFromRes(R.string.dreamTeam);
            }

            @Override
            public boolean isTeamPoints() {
                return true;
            }

            @Override
            public String totalPoints() {
                return totalPoint;
            }

            @Override
            public String getMatchID() {
                return matchGUID;
            }

            @Override
            public String getStatus() {
                return statusId;
            }

            @Override
            public List<PlayerRecord> getPlayers() {
                return bean;
            }

            @Override
            public Context getContext() {
                return mContext;
            }

            @Override
            public String isPlaying11Avaible() {
                return "No";
            }
        });
        dialogFragment.show(getChildFragmentManager(), dialogFragment.getTag());
        dialogFragment.setPointLaval(AppUtils.getStrFromRes(R.string.pts));

    }


    private void showPreviewfoot(final List<PlayerRecord> responseMatchPlayers, final String totalPoint) {
        final BottomSheetFootballTeamPreviewFragment dialogFragment = new BottomSheetFootballTeamPreviewFragment();
        dialogFragment.setUpdateable(new PlayerPreviewCallback() {
            @Override
            public void close() {

            }

            @Override
            public void edit() {

            }

            @Override
            public void refresh() {

            }


            @Override
            public String getTeamName() {

                return AppUtils.getStrFromRes(R.string.dreamTeam);

            }

            @Override
            public boolean isTeamPoints() {
                return true;
            }

            @Override
            public String totalPoints() {
                return totalPoint;
            }

            @Override
            public String getMatchID() {
                return matchGUID;
            }

            @Override
            public String getStatus() {
                return statusId;
            }

            @Override
            public List<PlayerRecord> getPlayers() {
                return responseMatchPlayers;
            }

            @Override
            public Context getContext() {
                return mContext;
            }

            @Override
            public String isPlaying11Avaible() {
                return "No";
            }
        });
        dialogFragment.show(getChildFragmentManager(), dialogFragment.getTag());
        dialogFragment.setPointLaval(AppUtils.getStrFromRes(R.string.pts));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mContestLeaderPresenterImpl.matchContest != null) {
            if (!mContestLeaderPresenterImpl.matchContest.isCanceled()) {
                mContestLeaderPresenterImpl.matchContest.cancel();
            }
            mContestLeaderPresenterImpl.matchContest = null;
        }
    }
}
