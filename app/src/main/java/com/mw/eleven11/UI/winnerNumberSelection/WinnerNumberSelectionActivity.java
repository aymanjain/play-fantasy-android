package com.mw.eleven11.UI.winnerNumberSelection;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.createContest.CreateContestPresenterImpl;
import com.mw.eleven11.UI.createContest.CreateContestView;
import com.mw.eleven11.UI.createTeam.CreateTeamActivity;
import com.mw.eleven11.UI.matchControlet.MatchDetailPresenterImpl;
import com.mw.eleven11.UI.matchControlet.MatchInfoView;
import com.mw.eleven11.UI.myTeams.MyTeamsActivity;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.CreateContestInput;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanInput.WinnerBreakupInput;

import com.mw.eleven11.beanOutput.CreateContestOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.WinBreakupOutPut;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;


public class WinnerNumberSelectionActivity extends BaseActivity implements CreateContestView, MatchInfoView {

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


    WinBreakupNumberAdapter adapter;
    Loader loader;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    Context mContext;
    int position = 0;
    @BindView(R.id.teamsVS)
    CustomTextView teamsVS;
    @BindView(R.id.ctv_timer)
    CustomTextView ctv_timer;
    @BindView(R.id.contest_size)
    CustomTextView contest_size;
    @BindView(R.id.price_pool)
    CustomTextView price_pool;
    @BindView(R.id.entry_fee)
    CustomTextView entry_fee;
    @BindView(R.id.winners)
    CustomTextView winners;
    @BindView(R.id.choose_total_winner)
    CustomTextView choose_total_winner;
    @BindView(R.id.winnersRl)
    RelativeLayout winnersRl;
    @BindView(R.id.title)
    CustomTextView mCustomTextViewTitle;
    @BindView(R.id.matchDetail)
    LinearLayout matchDetail;





    Context context;
    String match_id = "", total_winning_amount = "";
    String contest_sizes = "";
    String team_entry_fee = "";
    String contest_name = "";
    String is_multientry = "";
    String seriesId = "";
    String localteamId = "";
    String visitorteamId = "";
    String teamId = "";
    String isPrivacyNameDisplay = "";
    String number_of_winners;
    JSONArray winning_ranks = new JSONArray();
    CountDownTimer countDownTimer;
    private String seriesDeadLineLocal;

    WinBreakupOutPut mWinBreakupBean;
    private MatchDetailPresenterImpl mMatchDetailPresenterImpl;
    List<WinBreakupOutPut.DataBean.WinnersBean> mWinnersBean = new ArrayList<>();
    int teamCount = 0;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    private CreateContestPresenterImpl mUpdateProfilePresenterImpl;
    private ProgressDialog mProgressDialog;
    private OnItemClickListener.OnItemClickCallback onPayItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

        }
    };
    private String roundID;
    private boolean isFromSnackDraft = false;
    private boolean isFromAuction = false;
    private String leagueStartTime;


    private IUserInteractor mInteractor;

    private int flag;
    /*
        private String total_round, wk, ar, bowl, bat;
    */

    private String statusId;


    @OnClick(R.id.back)
    void onBack() {
        finish();
    }

    @OnClick(R.id.ctv_save)
    public void save(View view) {

        if (flag == 1) {

            CreateContestInput createContestInput = new CreateContestInput();
            createContestInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            createContestInput.setContestName(contest_name);
            createContestInput.setWinningAmount(total_winning_amount);
            createContestInput.setContestSize(contest_sizes);
            createContestInput.setEntryFee(team_entry_fee);
            createContestInput.setContestFormat(Constant.ContestFormat);
            createContestInput.setContestType(Constant.ContestType);
            createContestInput.setPrivacy("Yes");
            createContestInput.setIsPaid("Yes");
            createContestInput.setIsConfirm("No");
            createContestInput.setShowJoinedContest("Yes");
            createContestInput.setLeagueJoinDateTime(leagueStartTime);
            createContestInput.setEntryType("Single");
            createContestInput.setMinimumUserJoined("1");
            createContestInput.setSeriesID(seriesId);
            createContestInput.setCustomizeWinning(winning_ranks.toString());
            createContestInput.setCashBonusContribution(0);
            createContestInput.setNoOfWinners(number_of_winners);
            createContestInput.setAdminPercent("15");
            createContestInput.setLeagueType("Auction");
            createContestInput.setRoundID(roundID);


        } else if (flag == 2) {

            CreateContestInput createContestInput = new CreateContestInput();
            createContestInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            createContestInput.setContestName(contest_name);
            createContestInput.setWinningAmount(total_winning_amount);
            createContestInput.setContestSize(contest_sizes);
            createContestInput.setEntryFee(team_entry_fee);
            createContestInput.setContestFormat(Constant.ContestFormat);
            createContestInput.setContestType(Constant.ContestType);
            createContestInput.setPrivacy("Yes");
            createContestInput.setIsPaid("Yes");
            createContestInput.setIsConfirm("No");
            createContestInput.setShowJoinedContest("Yes");
            createContestInput.setLeagueJoinDateTime(leagueStartTime);
            createContestInput.setEntryType("Single");
            createContestInput.setMinimumUserJoined("1");
            createContestInput.setSeriesID(seriesId);
            createContestInput.setCustomizeWinning(winning_ranks.toString());
            createContestInput.setCashBonusContribution(0);
            createContestInput.setNoOfWinners(number_of_winners);
            createContestInput.setAdminPercent("15");
            createContestInput.setLeagueType("Draft");
            createContestInput.setMatchGUID(roundID);
            createContestInput.setMatchStartDate(seriesDeadLineLocal);
            /*createContestInput.setDraftTeamPlayerLimit(total_round);*/
            CreateContestInput.DraftPlayerSelectionCriteria draftPlayerSelectionCriteria = new CreateContestInput.DraftPlayerSelectionCriteria();
            /*draftPlayerSelectionCriteria.setAllRounder(ar);
            draftPlayerSelectionCriteria.setBatsman(bat);
            draftPlayerSelectionCriteria.setBowler(bowl);
            draftPlayerSelectionCriteria.setWicketKeeper(wk);*/
            Gson gson = new Gson();
            createContestInput.setDraftPlayerSelectionCriteria(gson.toJson(draftPlayerSelectionCriteria));



        } else {


            CreateContestInput createContestInput = new CreateContestInput();
            createContestInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            createContestInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
            createContestInput.setContestName(contest_name);
            createContestInput.setWinningAmount(total_winning_amount);
            createContestInput.setContestSize(contest_sizes);
            createContestInput.setEntryFee(team_entry_fee);
            createContestInput.setContestFormat(Constant.ContestFormat);
            createContestInput.setContestType(Constant.ContestType);
            createContestInput.setPrivacy("Yes");
            createContestInput.setIsPaid("Yes");
            createContestInput.setShowJoinedContest("No");
            createContestInput.setEntryType(is_multientry);
            if (is_multientry.equalsIgnoreCase("Multiple")) {
                createContestInput.setUserJoinLimit("6");
            } else {
                createContestInput.setUserJoinLimit("1");
            }
            createContestInput.setMatchGUID(match_id);
            createContestInput.setSeriesGUID(seriesId);
            createContestInput.setCustomizeWinning(winning_ranks.toString());
            createContestInput.setCashBonusContribution(0);
            createContestInput.setNoOfWinners(number_of_winners);
            createContestInput.setApp("Yes");
            createContestInput.setAdminPercent("10");
            createContestInput.setIsPrivacyNameDisplay(isPrivacyNameDisplay);

            mUpdateProfilePresenterImpl.actionCreateContestBtn(createContestInput);


        }
    }

    @OnClick(R.id.winnersRl)
    public void onWinnerList() {

        showPreview(mWinBreakupBean.getData(), "0", position);
    }

    public void MyTeamActivityStartForJoin(Context context, String seriesId, String matchId,
                                           String localteamId, String visitorteamId,
                                           String contestId, String joiningAmount, String chip, String userInviteCode) {
        Intent starter = new Intent(context, MyTeamsActivity.class);
        starter.putExtra("seriesId", seriesId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("localteamId", localteamId);
        starter.putExtra("visitorteamId", visitorteamId);
        starter.putExtra("contestId", contestId);
        starter.putExtra("statusId", statusId);
        starter.putExtra("join", "0");
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("chip", chip);
        starter.putExtra("userInviteCode", userInviteCode);
        starter.putExtra("cashBonusContribution", "0");
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_JOIN_CONTESTS);
    }


    @Override
    public int getLayout() {
        return R.layout.activity_winner_number_selection;
    }

    @Override
    public void init() {

        mContext = this;
        mInteractor = new UserInteractor();

        mCustomTextViewTitle.setText(AppUtils.getStrFromRes(R.string.newContest));

        mWinBreakupBean = new WinBreakupOutPut();
        setView();

        loader = new Loader(this);

        if (getIntent().hasExtra("flag")) {
            flag = getIntent().getIntExtra("flag", 0);
        }


        if (getIntent().hasExtra("match_id")) {
            //matchDetail.setVisibility(View.VISIBLE);
            match_id = getIntent().getStringExtra("match_id");
            total_winning_amount = getIntent().getStringExtra("total_winning_amount");
            contest_sizes = getIntent().getStringExtra("contest_sizes");
            contest_name = getIntent().getStringExtra("contest_name");
            is_multientry = getIntent().getStringExtra("is_multientry");
            team_entry_fee = getIntent().getStringExtra("team_entry_fee");

            seriesId = getIntent().getStringExtra("seriesId");
            localteamId = getIntent().getStringExtra("localteamId");
            visitorteamId = getIntent().getStringExtra("visitorteamId");
            isPrivacyNameDisplay = getIntent().getStringExtra("isPrivacyNameDisplay");

            teamCount = getIntent().getIntExtra("teamCount", 0);

            contest_size.setText(contest_sizes);
            price_pool.setText(AppUtils.getStrFromRes(R.string.price_unit) + " " + total_winning_amount);
            entry_fee.setText(AppUtils.getStrFromRes(R.string.price_unit) + " " + team_entry_fee);

            if (getIntent().hasExtra("statusId")) {
                statusId = getIntent().getStringExtra("statusId");
            }

            if (getIntent().hasExtra("teamId")) {
                teamId = getIntent().getStringExtra("teamId");
            }
        } else {
            if (flag == 1) {

            } else if (flag == 2) {

            }

        }

        mUpdateProfilePresenterImpl = new CreateContestPresenterImpl(this, new UserInteractor());
        mMatchDetailPresenterImpl = new MatchDetailPresenterImpl(this, new UserInteractor());

        adapter = new WinBreakupNumberAdapter(R.layout.item_winning_number, mContext, mWinnersBean, onPayItemClickCallback);
        recyclerView.setAdapter(adapter);


        WinnerBreakupInput mWinnerBreakupInput = new WinnerBreakupInput();
        mWinnerBreakupInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        if (flag == 0) {
            mWinnerBreakupInput.setMatchGUID(match_id);
        }
        mWinnerBreakupInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
        mWinnerBreakupInput.setWinningAmount(total_winning_amount);
        mWinnerBreakupInput.setContestSize(contest_sizes);
        mWinnerBreakupInput.setEntryFee(team_entry_fee);
        mWinnerBreakupInput.setIsPaid("Yes");


        mUpdateProfilePresenterImpl.winning_breakup(mWinnerBreakupInput);
        if (getIntent().hasExtra("match_id")) {
            callMatchDetail(getIntent().getStringExtra("match_id"), Constant.Pending);
        }


    }


    void callMatchDetail(String matchId, String statusId) {

        MatchDetailInput mMatchDetailInput = new MatchDetailInput();
        mMatchDetailInput.setPrivacy("No");
        mMatchDetailInput.setMatchGUID(matchId);
        mMatchDetailInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchDetailInput.setStatus(statusId);
        mMatchDetailInput.setParams(Constant.MATCH_PARAMS);

        mMatchDetailPresenterImpl.actionMatchdetail(mMatchDetailInput);

    }

    private void setView() {
       // recyclerView.addItemDecoration(new ItemOffsetDecoration(mContext, R.dimen.item_offset));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();

    }


    @Override
    public void createContestSuccess(CreateContestOutput responseLogin) {
        hideLoading();

        AppUtils.showSnackBar(mContext, mCoordinatorLayout, responseLogin.getMessage());
        if (responseLogin.getTotalTeams() != null && responseLogin.getTotalTeams().equalsIgnoreCase("0")) {
            CreateTeamActivityStart(mContext, match_id, responseLogin.getData().getContestGUID().getContestGUID(), String.valueOf(responseLogin.getData().getContestGUID().getEntryFee()));

        } else {
            MyTeamActivityStartForJoin(mContext, seriesId,
                    match_id, localteamId,
                    visitorteamId,
                    responseLogin.getData().getContestGUID().getContestGUID(),
                    String.valueOf(responseLogin.getData().getContestGUID().getEntryFee()),
                    "", responseLogin.getData().getContestGUID().getUserInvitationCode()
            );
        }


        /*if (teamCount > 0) {
            //  JoinContestActivityStart(mContext, matchId, teamId, responseLogin.getResponse().getId(), responseLogin.getResponse().getTeamEntryFee(), responseLogin.getResponse().getUserInviteCode());


        } else {
            // MyTeamActivityStart(mContext, seriesId, matchId, localteamId, visitorteamId, responseLogin.getResponse().getId(), responseLogin.getResponse().getTeamEntryFee(), responseLogin.getResponse().getUserInviteCode(),responseLogin.getResponse().getChip());
            CreateTeamActivityStart(mContext, seriesId, match_id, localteamId, visitorteamId,
                    responseLogin.getData().getContestGUID().getContestGUID(),
                    String.valueOf(responseLogin.getData().getContestGUID().getEntryFee()),
                    responseLogin.getData().getContestGUID().getUserInvitationCode());
        }*/
        setResult(RESULT_OK);
        finish();
    }


    public void CreateTeamActivityStart(Context context, String MatchGUID, String contestId, String joiningAmount) {

        Intent starter = new Intent(context, CreateTeamActivity.class);
        starter.putExtra("MatchGUID", MatchGUID);
        starter.putExtra("contestId", contestId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("cashBonusContribution", "0");

        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }

    @Override
    public void createContestFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void winBreakupSuccess(WinBreakupOutPut responseLogin) {

        mWinBreakupBean = responseLogin;

        number_of_winners = String.valueOf(responseLogin.getData().get(position).getNoOfWinners());

        try {
            JSONArray jsonArray = new JSONArray(AppUtils.gsonToJSON(responseLogin.getData().get(position).getWinners()));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            winning_ranks = new JSONArray(AppUtils.gsonToJSON(responseLogin.getData().get(position).getWinners()));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("winning_ranks", winning_ranks.toString());

        mWinnersBean.addAll(responseLogin.getData().get(position).getWinners());

        winners.setText(responseLogin.getData().get(position).getNoOfWinners() + " " + AppUtils.getStrFromRes(R.string.winners));

        adapter.notifyDataSetChanged();
    }

    @Override
    public void winBreakupFailure(String errMsg) {

        showSnackBar(errMsg);
    }

    @Override
    public void onProfileSuccess(LoginResponseOut responseLogin) {

    }

    @Override
    public void onProfileFailure(String errMsg) {

    }

    @Override
    public void onHideLoading() {
        loader.hide();
    }

    @Override
    public void onShowLoading() {
        loader.start();
    }

    @Override
    public void showSnackBar(String message) {
        hideLoading();
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, message);
    }

    @Override
    public void setActivityBackground() {

    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    private void showPreview(final List<WinBreakupOutPut.DataBean> bean, final String totalWinngingAmmount, final int index) {
        final WinBreakupFragment dialogFragment = new WinBreakupFragment();
        dialogFragment.setUpdateable(new WinBreakupCallback() {
            @Override
            public void close(int pos) {
                adapter.clear();
                position = pos;
                number_of_winners = String.valueOf(mWinBreakupBean.getData().get(pos).getNoOfWinners());

                try {
                    winning_ranks = new JSONArray(AppUtils.gsonToJSON(mWinBreakupBean.getData().get(position).getWinners()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("winning_ranks", winning_ranks.toString());

                mWinnersBean.addAll(mWinBreakupBean.getData().get(pos).getWinners());

                winners.setText(mWinBreakupBean.getData().get(pos).getNoOfWinners() + " " + AppUtils.getStrFromRes(R.string.winners));

                adapter.notifyDataSetChanged();

            }

            @Override
            public Context getContext() {
                return mContext;
            }

            @Override
            public List<WinBreakupOutPut.DataBean> getBean() {
                return bean;
            }

            @Override
            public int getIndex() {
                return index;
            }
        });
        dialogFragment.show(getSupportFragmentManager(), dialogFragment.getTag());

    }





    @Override
    public void onMatchSuccess(MatchDetailOutPut responseLogin) {
        hideLoading();

        ViewUtils.setImageUrl(customImageViewTeamFlagLocal, responseLogin.getData().getTeamFlagLocal());
        ViewUtils.setImageUrl(customImageViewTeamFlagVisitor, responseLogin.getData().getTeamFlagVisitor());
        customTextViewTeamNameLocal.setText(responseLogin.getData().getTeamNameShortLocal());
        customTextViewTeamNameVisitor.setText(responseLogin.getData().getTeamNameShortVisitor());


        teamsVS.setText(responseLogin.getData().getTeamNameShortLocal()
                + " " + AppUtils.getStrFromRes(R.string.vs)
                + " " + responseLogin.getData().getTeamNameShortVisitor());

        setMatchTimer(responseLogin);
    }

    @Override
    public void onMatchFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);

    }

    void setMatchTimer(MatchDetailOutPut details) {


        try {
            if (countDownTimer != null) countDownTimer.cancel();
            if (TimeUtils.isThisDateValid(details.getData().getMatchStartDateTime(), "yyyy-MM-dd HH:mm:ss")) {
                long remainingTime = TimeUtils.getTimeDifference(details.getData().getMatchStartDateTime(), details.getData().getCurrentDateTime());
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
                customTextViewMatchStatus.setText(TimeUtils.getMatchDateOnly(details.getData().getMatchStartDateTime()));
            }
        } catch (Exception e1) {
            customTextViewMatchStatus.setText(e1.getMessage());
        }
    }


}
