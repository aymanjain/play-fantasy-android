package com.mw.eleven11.UI.matchContest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.allContest.AllContest;
import com.mw.eleven11.UI.contestDetailLeaderBoard.ContestLeaderBoard;
import com.mw.eleven11.UI.contestInviteCode.InviteCodes;
import com.mw.eleven11.UI.createContest.CreateContestActivity;
import com.mw.eleven11.UI.createTeam.CreateTeamActivity;
import com.mw.eleven11.UI.filter.BottomSheetFilterFragment;
import com.mw.eleven11.UI.filter.ContestSearchResultFilters;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.inviteContest.InviteContestActivity;
import com.mw.eleven11.UI.joinedContests.AllJoinedContest;
import com.mw.eleven11.UI.myAccount.MyAccountDialogActivity;
import com.mw.eleven11.UI.myTeams.MyTeamsActivity;
import com.mw.eleven11.UI.winnings.WinnersCallback;
import com.mw.eleven11.UI.winnings.WinnersRankBean;
import com.mw.eleven11.UI.winnings.WinningsFragment;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.MatchContestInput;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanOutput.CheckContestBean;
import com.mw.eleven11.beanOutput.MatchContestOutPut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.customView.RobotoRegularTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.CircleTransform;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnWinnerClickListener;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;
import com.rey.material.util.ViewUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MatchContestActivity extends BaseActivity implements MatchDetailView {

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

    private String isMatchReal = "";

    List<Integer> colorList;
    private static final Integer[] colorArray = {R.color.yellow,R.color.orange,R.color.red,
            R.color.brown_red, R.color.light_pink, R.color.green,
    };

    public static void start(Context context, String matchGUID, String StatusID) {
        Intent starter = new Intent(context, MatchContestActivity.class);

        starter.putExtra("MatchGUID", matchGUID);
        starter.putExtra("StatusID", StatusID);


        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context, String matchGUID, String StatusID, Boolean flag) {
        Intent starter = new Intent(context, MatchContestActivity.class);

        starter.putExtra("MatchGUID", matchGUID);
        starter.putExtra("StatusID", StatusID);
        starter.putExtra("Flag", flag);

        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    Loader loader;
    Context mContext;

    String matchTeamVS = "";
    boolean flag = false;
    String teamCount = "0";
    // private ProgressDialog mProgressDialog;
    // gjgj

    CheckContestBean mCheckContestBean;


    CountDownTimer countDownTimer;

    MatchDetailOutPut matchDetail;
    MatchContestPresenterImpl mMatchContestPresenter;

    String StatusID;
    String MatchGUID;

    MatchContestOutPut matchContestOutPut;


    @BindView(R.id.contestSection)
    LinearLayout contestSection;

    @BindView(R.id.private_button)
    LinearLayout private_button;


    @BindView(R.id.contestContainer)
    LinearLayout contestContainer;

    @BindView(R.id.notFound)
    RelativeLayout notFound;

    @BindView(R.id.notFountMsg)
    CustomTextView notFountMsg;

    @BindView(R.id.joinButton)
    CustomTextView allContest;

    @BindView(R.id.contesRel)
    RelativeLayout contesRel;

    @BindView(R.id.saveLin)
    View saveLin;

    @BindView(R.id.saveRel)
    RelativeLayout saveRel;


    @BindView(R.id.teamsVS)
    CustomTextView teamsVS;

    @BindView(R.id.ctv_full_time)
    CustomTextView ctv_timer;

    @BindView(R.id.ctv_my_team)
    RobotoRegularTextView ctv_my_team;

    @BindView(R.id.ctv_join_contest)
    RobotoRegularTextView ctv_join_contest;





    @OnClick(R.id.gotContestCode)
    void clickOnContestCode() {

        InviteCodes.start(this, teamCount);
    }

    @OnClick(R.id.wallet)
    void onwalletClick() {
        //JoinContestActivityStart(mContext);
        MyAccountDialogActivity.start(mContext, false);

    }

    @OnClick(R.id.back)
    void onBackClick() {
        onBackPressed();
    }

    @OnClick(R.id.ll_join_contest)
    public void onClickJoinedContest() {
        if (matchDetail.getData().getMatchGUID() != null && !matchContestOutPut.getData().getStatics().getJoinedContest().equalsIgnoreCase("0")) {
            AllJoinedContest.start(mContext, matchDetail.getData().getMatchGUID(), matchDetail.getData().getStatus());
        } else {
            AppUtils.showToast(mContext, "You have not joined any contest.");
        }
    }

    @Override
    public void onBackPressed() {
        if (flag) {
            finish();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                }
            }, 1000);
            HomeNavigation.start(this);
        } else {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.ll_my_team)
    public void myTeam(View view) {
        if (matchDetail == null) return;
        MyTeamActivityStart(mContext,
                matchDetail.getData().getMatchGUID(),
                matchDetail.getData().getStatus(), "", "", teamsVS.getText().toString(), "");
    }

    @OnClick({R.id.allContest, R.id.joinButton})
    public void onClickAllContest() {
        AllContest.start(mContext, matchDetail.getData().getMatchGUID(), matchDetail.getData().getStatus());
    }

    @OnClick(R.id.menu)
    void onMenuFilterClick() {
        showFilter();
    }

    @OnClick(R.id.create_contest)
    void oncreate_contest() {

        if (matchDetail != null) {
            if (AppSession.getInstance().getGameType() == 1) {
                if (isMatchReal.equalsIgnoreCase("Virtual")) {
                    AppUtils.showToast(mContext, "You can not create private contest in Virtual Match.");
                } else {
                    CreateContestActivityStart(mContext, matchDetail.getData().getSeriesGUID(),
                            matchDetail.getData().getMatchGUID(),
                            matchDetail.getData().getTeamNameShortLocal(),
                            matchDetail.getData().getTeamNameShortVisitor());
                }
            } else {
                CreateContestActivityStart(mContext, matchDetail.getData().getSeriesGUID(),
                        matchDetail.getData().getMatchGUID(),
                        matchDetail.getData().getTeamNameShortLocal(),
                        matchDetail.getData().getTeamNameShortVisitor());
            }
        }

    }

    @OnClick(R.id.create_teaam1)
    void onCreateTeam() {
        CreateTeamActivityStart(mContext, MatchGUID);
        //CreateTeamActivityStart(mContext, "fa1063fb-5e79-bdc6-5f5c-8311ecae9994");
    }

    @BindView(R.id.title)
    RobotoRegularTextView title;

    public void CreateTeamActivityStart(Context context, String MatchGUID) {
        Intent starter = new Intent(context, CreateTeamActivity.class);
        starter.putExtra("MatchGUID", MatchGUID);
        starter.putExtra("join", "0");
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }

    public void CreateTeamActivityStart(Context context, String MatchGUID, String contestId, String joiningAmount, String cashBonusContribution) {

        Intent starter = new Intent(context, CreateTeamActivity.class);
        starter.putExtra("MatchGUID", MatchGUID);
        starter.putExtra("contestId", contestId);

        starter.putExtra("join", "0");
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("cashBonusContribution", cashBonusContribution);
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }


    private OnWinnerClickListener.OnWinnerClickCallback onWinnerClickCallBack = new OnWinnerClickListener.OnWinnerClickCallback() {
        @Override
        public void onWinnerClicked(View view, int position,
                                    List<MatchContestOutPut.DataBean.ResultsBean.RecordsBean> responseBeen) {

            List<MatchContestOutPut.DataBean.ResultsBean.RecordsBean.CustomizeWinningBean> customizeWin = responseBeen.get(position).getCustomizeWinning();
            List<WinnersRankBean> rankList = new ArrayList<>();
            for (int i = 0; i < customizeWin.size(); i++) {

                WinnersRankBean mWinnersRankBean = new WinnersRankBean();

                mWinnersRankBean.setFrom(customizeWin.get(i).getFrom());
                mWinnersRankBean.setTo(customizeWin.get(i).getTo());

                if (responseBeen.get(position).getSmartPool().equalsIgnoreCase("Yes")) {
                    mWinnersRankBean.setProductName(customizeWin.get(i).getProductName());
                    mWinnersRankBean.setProductUrl(customizeWin.get(i).getProductUrl());
                } else {
                    mWinnersRankBean.setPercent(customizeWin.get(i).getPercent());
                    mWinnersRankBean.setWinningAmount(customizeWin.get(i).getWinningAmount());

                }

                rankList.add(i, mWinnersRankBean);
            }
            if (responseBeen.get(position).getSmartPool().equalsIgnoreCase("Yes")) {
                showPreview(rankList, null, responseBeen.get(position).getWinningType());
            } else {
                showPreview(rankList, responseBeen.get(position).getWinningAmount(), responseBeen.get(position).getWinningType());
            }


        }
    };
    private OnWinnerClickListener.OnWinnerClickCallback onContestClickCallBack =
            new OnWinnerClickListener.OnWinnerClickCallback() {
                @Override
                public void onWinnerClicked(View view, int position,
                                            List<MatchContestOutPut.DataBean.ResultsBean.RecordsBean> responseBeen) {

                    //CashContest.start(mContext,matchID,responseBeen.get(position).getId());
                    ContestLeaderBoard.start(mContext, MatchGUID, responseBeen.get(position).getContestGUID(), StatusID);


                }
            };

    private OnWinnerClickListener.OnWinnerClickCallback onJoinClickCallBack =
            new OnWinnerClickListener.OnWinnerClickCallback() {
                @Override
                public void onWinnerClicked(View view, int position,
                                            List<MatchContestOutPut.DataBean.ResultsBean.RecordsBean> responseBeen) {

                    finish();
                    finishActivity(RESULT_OK);

                    if (responseBeen != null) {
                        AppSession.getInstance().UserInviteCode = responseBeen.get(position).getUserInvitationCode();
                        if (matchContestOutPut.getData().getStatics().getTotalTeams().equals("0")) {
                            CreateTeamActivityStart(mContext,
                                    matchDetail.getData().getMatchGUID(),
                                    responseBeen.get(position).getContestGUID(), responseBeen.get(position).getEntryFee(), responseBeen.get(position).getCashBonusContribution());
                        } else {
                            if (responseBeen.get(position).getIsJoined().equals("No")) {
                                MyTeamActivityStart(mContext,
                                        matchDetail.getData().getMatchGUID(),
                                        matchDetail.getData().getStatus(),
                                        responseBeen.get(position).getContestGUID(),
                                        responseBeen.get(position).getEntryFee(),
                                        teamsVS.getText().toString(),
                                        responseBeen.get(position).getCashBonusContribution());
                            } else {
                                if (responseBeen.get(position).getEntryType().equals("Multiple")) {
                                    MyTeamActivityStart(mContext,
                                            matchDetail.getData().getMatchGUID(),
                                            matchDetail.getData().getStatus(),
                                            responseBeen.get(position).getContestGUID(),
                                            responseBeen.get(position).getEntryFee(),
                                            teamsVS.getText().toString(),
                                            responseBeen.get(position).getCashBonusContribution());
                                } else {
                                    InviteContestActivity.start(mContext, responseBeen.get(position).getUserInvitationCode(), matchTeamVS);
                                }
                            }
                        }
                    }


                    /*
                     */
            /*CreateTeamActivityStart(mContext,"111127","37879","490",
                    "25","","","");*/

           /* MyTeamActivityStartForJoin(mContext, mResponseMatchDetails.getResponse().getSeries_id(),
                    matchID, mResponseMatchDetails.getResponse().getLocalteam_id(),
                    mResponseMatchDetails.getResponse().getVisitorteam_id(),
                    responseBeen.get(position).getId(),
                    String.valueOf(responseBeen.get(position).getDisplay_join_amount()),
                    responseBeen.get(position).getChip(), responseBeen.get(position).getUser_invite_code()
            );*/

            /*if (mResponseMatchDetails == null) return;
            if (responseBeen.get(position).getIs_user_joined() == 0) {
                if (mResponseMatchDetails.getMyTeam().equals("0")) {
                    CreateTeamActivityStart(mContext, matchDetails.getResponse().getSeriesId(), matchId, matchDetails.getResponse().getLocalteamId(), matchDetails.getResponse().getVisitorteamId(), adapter.getId(position), adapter.getTeamEntryFee(position),adapter.getChip(position), adapter.getUserInviteCode(position));
                } else {
                    MyTeamActivityStart(mContext, matchDetails.getResponse().getSeriesId(), matchId, matchDetails.getResponse().getLocalteamId(), matchDetails.getResponse().getVisitorteamId(), adapter.getId(position), adapter.getTeamEntryFee(position),adapter.getChip(position), adapter.getUserInviteCode(position));
                }
            } else {
                InviteContestActivity.start(mContext, adapter.getUserInviteCode(position));
            }*/

                }
            };

    public void CreateContestActivityStart(Context context, String seriesId,
                                           String matchId, String localteamId, String visitorteamId) {

        Intent starter = new Intent(context, CreateContestActivity.class);
        starter.putExtra("seriesId", seriesId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("statusId", matchDetail.getData().getStatus());

      /*  starter.putExtra("teamId", teamId);
        starter.putExtra("teamCount", teamCount);*/
        starter.putExtra("localteamId", localteamId);
        starter.putExtra("visitorteamId", visitorteamId);
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_CONTESTS);
    }

    /*public void MyTeamActivityStart(Context context, String seriesId, String matchId, String localteamId,
                                    String visitorteamId,String joiningAmount, String teamsVSStr) {
        Intent starter = new Intent(context, MyTeamsActivity.class);
        starter.putExtra("seriesId", seriesId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("localteamId", localteamId);
        starter.putExtra("visitorteamId", visitorteamId);
        starter.putExtra("teamsVSStr", teamsVSStr);
        starter.putExtra("joiningAmount", joiningAmount);
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_MY_TEAM);
    }*/

    public void MyTeamActivityStart(Context context, String matchId, String statusId, String contestId, String joiningAmount, String teamsVSStr, String cashBonusContribution) {
        Intent starter = new Intent(context, MyTeamsActivity.class);
        starter.putExtra("contestId", contestId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("statusId", statusId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("teamsVSStr", teamsVSStr);
        starter.putExtra("join", "0");
        starter.putExtra("cashBonusContribution", cashBonusContribution);
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_MY_TEAM);
    }


    @Override
    public int getLayout() {


        return R.layout.activity_match_contest;
    }

    @Override
    public void init() {

        mContext = this;
        matchDetail = new MatchDetailOutPut();
        mMatchContestPresenter = new MatchContestPresenterImpl(this, new UserInteractor());

        if (getIntent().hasExtra("MatchGUID")) {

            MatchGUID = getIntent().getStringExtra("MatchGUID");
            StatusID = getIntent().getStringExtra("StatusID");
            flag = getIntent().getBooleanExtra("Flag", false);
        }
        loader = new Loader(this);

        loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callMatchDetail(MatchGUID, StatusID);

            }
        });

        callMatchDetail(MatchGUID, StatusID);

        LocalBroadcastManager.getInstance(mContext).registerReceiver(updates_receiver,
                new IntentFilter(MatchContestActivity.class.getSimpleName()));

    }


    public void callMatchDetail(String matchGuid, String statusId) {

        MatchDetailInput mMatchDetailInput = new MatchDetailInput();
        mMatchDetailInput.setPrivacy("No");
        mMatchDetailInput.setMatchGUID(MatchGUID);
        mMatchDetailInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchDetailInput.setStatus(statusId);
        mMatchDetailInput.setParams(Constant.MATCH_PARAMS);
        mMatchContestPresenter.actionMatchdetail(mMatchDetailInput);
    }

    public void callMatchContest(String matchGuID, String statusId) {

        MatchContestInput mMatchContestInput = new MatchContestInput();
        mMatchContestInput.setPrivacy("No");
        mMatchContestInput.setContestList("Yes");
        mMatchContestInput.setMatchGUID(matchGuID);
        mMatchContestInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchContestInput.setStatus(statusId);
        mMatchContestInput.setPageNo(1);
        mMatchContestInput.setPageSize(3);
        mMatchContestInput.setOrderBy("TotalJoined");
        mMatchContestInput.setSequence("DESC");
        mMatchContestInput.setParams(Constant.CONTEST_PARAM);
        mMatchContestInput.setFilter("Normal");
        mMatchContestInput.setContestFull("No");
        mMatchContestPresenter.matchContestList(mMatchContestInput);
    }


    @Override
    public void showLoading() {
        loader.start();
    }

    @Override
    public void hideLoading() {
        loader.hide();
    }

    @Override
    public void onMatchSuccess(MatchDetailOutPut mMatchDetailOutPut) {

        hideLoading();

        matchDetail = mMatchDetailOutPut;

        //ViewUtils.setImageUrl(customImageViewTeamFlagLocal, matchDetail.getData().getTeamFlagLocal());
        //ViewUtils.load(matchDetail.getData().getTeamFlagLocal(),customImageViewTeamFlagLocal);
        ViewUtils.load(matchDetail.getData().getTeamFlagLocal(), customImageViewTeamFlagLocal, new CircleTransform());
        //iewUtils.setImageUrl(customImageViewTeamFlagVisitor, matchDetail.getData().getTeamFlagVisitor());
        ViewUtils.load(matchDetail.getData().getTeamFlagVisitor(),customImageViewTeamFlagVisitor);
        customTextViewTeamNameLocal.setText(matchDetail.getData().getTeamNameShortLocal());
        customTextViewTeamNameVisitor.setText(matchDetail.getData().getTeamNameShortVisitor());


        matchTeamVS = mMatchDetailOutPut.getData().getTeamNameShortLocal() + " " + AppUtils.getStrFromRes(R.string.vs) + " " + mMatchDetailOutPut.getData().getTeamNameShortVisitor();

        AppSession.getInstance().MatchTeamVS = matchTeamVS;

        teamsVS.setText(mMatchDetailOutPut.getData().getTeamNameShortLocal() + " " + AppUtils.getStrFromRes(R.string.vs) + " " + mMatchDetailOutPut.getData().getTeamNameShortVisitor());
        setTime(mMatchDetailOutPut.getData().getMatchStartDateTime(), mMatchDetailOutPut.getData().getMatchDate(),
                mMatchDetailOutPut.getData().getMatchTime(), mMatchDetailOutPut.getData().getCurrentDateTime());
//        AppSession.getInstance().UserInviteCode = mMatchDetailOutPut.getData().;

        callMatchContest(mMatchDetailOutPut.getData().getMatchGUID(), mMatchDetailOutPut.getData().getStatus());

    }

    @Override
    public void onMatchFailure(String errMsg) {

        loader.getTryAgainView();
        loader.dataNotFound(errMsg);
    }

    @Override
    public void onMatchContestSuccess(final MatchContestOutPut responseLogin) {
        hideLoading();

        contestSection.removeAllViews();
        int totalContest = 0;

        matchContestOutPut = new MatchContestOutPut();

        matchContestOutPut = responseLogin;

        teamCount = responseLogin.getData().getStatics().getTotalTeams();

        for (int i = 0; i < responseLogin.getData().getResults().size(); i++) {

            if (responseLogin.getData().getResults().get(i).getTotalRecords() != 0) {

                for (int j = 0; j < responseLogin.getData().getResults().get(i).getRecords().size(); j++) {
                    isMatchReal = responseLogin.getData().getResults().get(i).getRecords().get(j).getMatchTypeByApi();

                }

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

                int remainContest =
                        responseLogin.getData().getResults().get(i).getTotalRecords() - responseLogin.getData().getResults().get(i).getRecords().size();
                /*if (remainContest != 0) {
                    // contest_count.setText(remainContest+" "+AppUtils.getStrFromRes(R.string.more_contest));
                    contest_count.setText("View " + remainContest + " more");
                } else {
                    contest_count.setVisibility(View.GONE);
                }*/

                /*ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(mContext, R.dimen.item_offset);
                mRecyclerView.addItemDecoration(itemDecoration);*/
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
                adapter = new SingleContestAdapter(R.layout.single_contest_item, mContext,
                        responseLogin.getData().getResults().get(i).getRecords(),
                        onWinnerClickCallBack, onContestClickCallBack, onJoinClickCallBack, matchTeamVS,colorList);
                mRecyclerView.setAdapter(adapter);

                contestSection.addView(mView);
                totalContest++;


                final int finalI = i;
                contest_count.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AllContest.start(mContext, matchDetail.getData().getMatchGUID(), responseLogin.getData().getResults().get(finalI).getKey(), matchDetail.getData().getStatus());

                    }
                });
            }

        }
        if (AppSession.getInstance().getGameType() == 1) {
            if (isMatchReal.equalsIgnoreCase("Virtual")) {
                private_button.setVisibility(View.GONE);
            } else {
                private_button.setVisibility(View.VISIBLE);
            }
        }


        if (totalContest == 0) {

            /*loader.getTryAgainView();
            loader.dataNotFound(AppUtils.getStrFromRes(R.string.contestNotFound));


            loader.setNotFound(getContext().getResources().getDrawable(R.drawable.ic_trophy));
            loader.getTryAgainView().setText(getResources().getText(R.string.try_again));
            loader.getTryAgainView().setVisibility(View.VISIBLE);*/

            notFound.setVisibility(View.VISIBLE);
            contesRel.setVisibility(View.GONE);
        }

        if (responseLogin.getData().getStatics().getTotalTeams().equals("0")) {

            saveRel.setVisibility(View.VISIBLE);
            saveLin.setVisibility(View.GONE);

        } else {

            saveRel.setVisibility(View.GONE);
            saveLin.setVisibility(View.VISIBLE);

            ctv_my_team.setText(responseLogin.getData().getStatics().getTotalTeams());
            ctv_join_contest.setText(responseLogin.getData().getStatics().getJoinedContest());


        }

    }

    @Override
    public void onMatchContestFailure(String errMsg) {
        loader.getTryAgainView();
        loader.dataNotFound(errMsg);
        loader.setNotFoundImage(getResources().getDrawable(R.drawable.not_found_img));
    }

    @Override
    public boolean isAttached() {
        return true;
    }

    @Override
    public Context getContext() {
        return mContext;
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
        dialogFragment.show(getSupportFragmentManager(), dialogFragment.getTag());

    }

    private void showFilter() {
        final BottomSheetFilterFragment dialogFragment = new BottomSheetFilterFragment();
        dialogFragment.setUpdateable(new ContestSearchResultFilters() {
            @Override
            public void search() {
                /*Intent intent = new Intent(MatchContestActivity.class.getSimpleName());
                intent.putExtra("KEY", "REFRESH");
                LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);*/
                AllContest.start(mContext, matchDetail.getData().getMatchGUID(), matchDetail.getData().getStatus());
            }

            @Override
            public void reSetFilter() {

            }

            @Override
            public Context getContext() {
                return mContext;
            }
        });
        dialogFragment.show(getSupportFragmentManager(), dialogFragment.getTag());

    }


    private BroadcastReceiver updates_receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent i) {
            try {
                if (i.getAction().equals(MatchContestActivity.class.getSimpleName())) {
                    if (i.hasExtra("KEY")) {
                        if (i.getStringExtra("KEY").equals("REFRESH")) {
                            callMatchDetail(MatchGUID, StatusID);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

}
