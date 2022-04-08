package com.mw.eleven11.UI.createContest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.createTeam.CreateTeamActivity;
import com.mw.eleven11.UI.matchControlet.MatchDetailPresenterImpl;
import com.mw.eleven11.UI.matchControlet.MatchInfoView;
import com.mw.eleven11.UI.myTeams.MyTeamsActivity;
import com.mw.eleven11.UI.winnerNumberSelection.WinnerNumberSelectionActivity;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.base.WinningRanks;
import com.mw.eleven11.beanInput.CreateContestInput;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanOutput.CreateContestOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.WinBreakupOutPut;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomInputEditText;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class CreateContestActivity extends BaseActivity implements CreateContestView, MatchInfoView {


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


    Loader loader;
    CountDownTimer countDownTimer;
    String isPrivacyNameDisplay = "";
    @BindString(R.string.create_your_contest)
    String title;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.teamsVS)
    CustomTextView teamsVS;
    @BindView(R.id.ctv_timer)
    CustomTextView ctv_timer;

    /* Butter Knife : view mapping */
    @BindView(R.id.edt_league_name)
    CustomInputEditText mCustomEditTextLeagueName;
    @BindView(R.id.edt_total_winnings_amount)
    CustomInputEditText mCustomEditTextTotalWinnings;
    @BindView(R.id.edt_contest_size)
    CustomInputEditText mCustomEditTextContestSize;


    @BindView(R.id.ctv_save)
    CustomTextView mCustomTextViewSave;
    @BindView(R.id.ctv_entry)
    CustomTextView mCustomTextViewEntry;
    @BindView(R.id.switchCompatOpenForAllFriends)
    com.rey.material.widget.Switch switchCompatOpenForAllFriends;
    String matchId = "", seriesId = "", visitorteamId = "", localteamId = "", teamId = "";
    int teamCount = 0;
    ArrayList<WinningRanks> milestone = new ArrayList<>();
    JSONArray winningRank;
    TextWatcher watchSize = new TextWatcher() {

        @Override
        public void afterTextChanged(Editable arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onTextChanged(CharSequence s, int a, int b, int c) {
            // TODO Auto-generated method stub
            calculateFee(s.toString(), mCustomEditTextTotalWinnings.getText().toString().trim());

        }
    };
    TextWatcher watchWinnings = new TextWatcher() {

        @Override
        public void afterTextChanged(Editable arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onTextChanged(CharSequence s, int a, int b, int c) {
            // TODO Auto-generated method stub
            calculateFee(mCustomEditTextContestSize.getText().toString().trim(), s.toString());

        }
    };
    //CreateWinnersAdapter adapter;
    private Context mContext;
    private CreateContestPresenterImpl mUpdateProfilePresenterImpl;
    private MatchDetailPresenterImpl mMatchDetailPresenterImpl;
    private ProgressDialog mProgressDialog;
    private OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            //  adapter.removeItem(position);
        }
    };
    private String statusId;

    {
        try {
            winningRank = new JSONArray("[]");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.ctv_save)
    public void save(View view) {

        String userLoginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();
        String userId = AppSession.getInstance().getLoginSession().getData().getUserGUID();
        String contestName = mCustomEditTextLeagueName.getText().toString().trim();
        String totalWinningAmount = mCustomEditTextTotalWinnings.getText().toString().trim();
        String contestSizes = mCustomEditTextContestSize.getText().toString().trim();
        String teamEntryFee = "" + new DecimalFormat("##.##").format(calculateFee(mCustomEditTextContestSize.getText().toString().trim(), mCustomEditTextTotalWinnings.getText().toString().trim()));

        String isMultientry = switchCompatOpenForAllFriends.isChecked() ? "Multiple" : "Single";

       /* String winningRank = adapter.getWinners();
        int selectedPerson=adapter.getTotalSelectedPerson();*/
        String customWinning = "1";
        String IsPaid;

        if (TextUtils.isEmpty(contestName)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_contest_name));

            return;
        }


        if (TextUtils.isEmpty(totalWinningAmount)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_total_winning_amount));

            return;
        }

        if (Integer.parseInt(totalWinningAmount) < 10) {
            showSnackBar("Total winning amount should be greater than 10");
            return;
        }

        if (Integer.parseInt(totalWinningAmount) > 10000) {
            showSnackBar("Total winning amount should be less than 10000");
            return;
        }

        if (TextUtils.isEmpty(contestSizes)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_contest_sizes));
            return;
        } else if (Integer.parseInt(contestSizes.trim().replace(" ", "")) < 2) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_contest_sizes_invalid));
            return;
        }


        if (Integer.parseInt(contestSizes) > 100) {
            showSnackBar("Contest Size should be less than 100");
            return;
        }


        if (Double.parseDouble(teamEntryFee) < 10) {
            showSnackBar("Entry fee must be greater than 10.");
            return;
        }


        if (Integer.parseInt(totalWinningAmount) == 0) {
            IsPaid = "No";
        } else {

            IsPaid = "Yes";
        }

        CreateContestInput createContestInput = new CreateContestInput();
        createContestInput.setSessionKey(userLoginSessionKey);
        createContestInput.setUserGUID(userId);
        createContestInput.setContestName(contestName);
        createContestInput.setWinningAmount(totalWinningAmount);
        createContestInput.setContestSize(contestSizes);
        createContestInput.setEntryFee(teamEntryFee);
        createContestInput.setContestType(Constant.ContestType);
        createContestInput.setPrivacy("Yes");
        createContestInput.setIsPaid(IsPaid);
        createContestInput.setShowJoinedContest("No");
        createContestInput.setEntryType(isMultientry);
        createContestInput.setMatchGUID(matchId);
        createContestInput.setSeriesGUID(seriesId);
        if (isMultientry.equalsIgnoreCase("Multiple")) {
            createContestInput.setUserJoinLimit("6");
        } else {
            createContestInput.setUserJoinLimit("1");
        }
        createContestInput.setCustomizeWinning("");
        createContestInput.setCashBonusContribution(0);
        createContestInput.setAdminPercent("10");
        createContestInput.setIsPrivacyNameDisplay(isPrivacyNameDisplay);

        if (Integer.parseInt(contestSizes.trim()) == 2) {
            createContestInput.setContestFormat("Head to Head");
            createContestInput.setNoOfWinners("1");
            mUpdateProfilePresenterImpl.actionCreateContestBtn(createContestInput);
        } else {
            ChooseWinnersNumberStart(mContext,
                    matchId,
                    totalWinningAmount,
                    contestSizes,
                    teamEntryFee,
                    contestName,
                    isMultientry, seriesId, localteamId, visitorteamId, teamCount, teamId, isPrivacyNameDisplay);
        }

    }

    public void ChooseWinnersNumberStart(Context context, String match_id, String total_winning_amount,
                                         String contest_sizes,
                                         String team_entry_fee,

                                         String contest_name,
                                         String is_multientry, String seriesId, String localteamId,
                                         String visitorteamId, int teamCount, String teamId, String isPrivacyNameDisplay) {
        Intent starter = new Intent(context, WinnerNumberSelectionActivity.class);
        starter.putExtra("match_id", match_id);
        starter.putExtra("contest_name", contest_name);
        starter.putExtra("total_winning_amount", total_winning_amount);
        starter.putExtra("contest_sizes", contest_sizes);
        starter.putExtra("team_entry_fee", team_entry_fee);
        starter.putExtra("teamCount", teamCount);
        starter.putExtra("statusId", statusId);
        starter.putExtra("is_multientry", is_multientry);
        starter.putExtra("seriesId", seriesId);
        starter.putExtra("localteamId", localteamId);
        starter.putExtra("visitorteamId", visitorteamId);
        starter.putExtra("isPrivacyNameDisplay", isPrivacyNameDisplay);
        starter.putExtra("teamId", teamId);


        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }

    public void CreateTeamActivityStart(Context context, String MatchGUID, String contestId, String joiningAmount) {

        Intent starter = new Intent(context, CreateTeamActivity.class);
        starter.putExtra("MatchGUID", MatchGUID);
        starter.putExtra("contestId", contestId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("join", "0");
        starter.putExtra("cashBonusContribution", "0");

        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_create_contest;
    }

    @OnClick(R.id.back)
    void onBackClick() {
        finish();
    }

    @Override
    public void init() {

        if (getIntent() != null) {
            if (getIntent().hasExtra("matchId")) {
                matchId = getIntent().getStringExtra("matchId");
            }
            if (getIntent().hasExtra("seriesId")) {
                seriesId = getIntent().getStringExtra("seriesId");
            }
            if (getIntent().hasExtra("visitorteamId")) {
                visitorteamId = getIntent().getStringExtra("visitorteamId");
            }
            if (getIntent().hasExtra("localteamId")) {
                localteamId = getIntent().getStringExtra("localteamId");
            }
            if (getIntent().hasExtra("teamId")) {
                teamId = getIntent().getStringExtra("teamId");
            }
            if (getIntent().hasExtra("statusId")) {
                statusId = getIntent().getStringExtra("statusId");
            }
            if (getIntent().hasExtra("teamCount")) {
                teamCount = getIntent().getIntExtra("teamCount", 0);
            }

        }
        loader = new Loader(this);




        mContext = this;
        setActivityBackground();
        mUpdateProfilePresenterImpl = new CreateContestPresenterImpl(this, new UserInteractor());
        mMatchDetailPresenterImpl = new MatchDetailPresenterImpl(this, new UserInteractor());
        ViewUtils.doColorSpanForFirstString(mCustomTextViewEntry, AppUtils.getStrFromRes(R.string.entry_fee_per_team), " " + AppUtils.getStrFromRes(R.string.price_unit) + "0.0");
        mCustomEditTextContestSize.addTextChangedListener(watchSize);
        mCustomEditTextTotalWinnings.addTextChangedListener(watchWinnings);


        callProfile();

        //set layout manager into recyclerView

       /* adapter = new CreateWinnersAdapter(R.layout.list_item_milestone, mContext, milestone, onItemClickCallback);
        mRecyclerView.setAdapter(adapter);*/


        if (getIntent().hasExtra("matchId")) {
            callMatchDetail(getIntent().getStringExtra("matchId"), Constant.Pending);
        }
    }

    public void callProfile() {
        LoginInput mLoginInput = new LoginInput();
        mLoginInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mLoginInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
        mLoginInput.setParams(Constant.GET_PROFILE_PARAMS);
        mUpdateProfilePresenterImpl.actionViewProfile(mLoginInput);
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

    private float calculateFee(String size, String winnings) {
        float perTeem = 0;
        if (size.length() > 0 && winnings.length() > 0) {
            float fee = (Float.parseFloat(winnings.toString()) / Float.parseFloat(size.toString()));
            float total = (fee * 10) / 100 + fee;
            perTeem = total;
            ViewUtils.doColorSpanForFirstString(mCustomTextViewEntry, AppUtils.getStrFromRes(R.string.entry_fee_per_team), " " + AppUtils.getStrFromRes(R.string.price_unit) + new DecimalFormat("##.##").format(perTeem));
            //   tvMaxWinners.setText(String.format(AppUtils.getStrFromRes(R.string.min_two_max_handrad_dn),size));

            //llNoWinners.setVisibility(View.VISIBLE);
        } else {
            ViewUtils.doColorSpanForFirstString(mCustomTextViewEntry, AppUtils.getStrFromRes(R.string.entry_fee_per_team), " " + AppUtils.getStrFromRes(R.string.price_unit) + "0.0");
            //  tvMaxWinners.setText(AppUtils.getStrFromRes(R.string.depends_on_contest_size));
            // llNoWinners.setVisibility(View.GONE);
        }
        return perTeem;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
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
    public void createContestSuccess(final CreateContestOutput responseLogin) {
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, responseLogin.getMessage());

        if (responseLogin.getTotalTeams() != null && responseLogin.getTotalTeams().equalsIgnoreCase("0")) {
            CreateTeamActivityStart(mContext, matchId, responseLogin.getData().getContestGUID().getContestGUID(), String.valueOf(responseLogin.getData().getContestGUID().getEntryFee()));
        } else {
            MyTeamActivityStartForJoin(mContext, seriesId,
                    matchId, localteamId,
                    visitorteamId,
                    responseLogin.getData().getContestGUID().getContestGUID(),
                    String.valueOf(responseLogin.getData().getContestGUID().getEntryFee()),
                    "", responseLogin.getData().getContestGUID().getUserInvitationCode());
        }

        setResult(RESULT_OK);
        finish();
    }

    public void MyTeamActivityStartForJoin(Context context, String seriesId, String matchId, String localteamId, String visitorteamId, String contestId, String joiningAmount, String chip, String userInviteCode) {
        Intent starter = new Intent(context, MyTeamsActivity.class);
        starter.putExtra("seriesId", seriesId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("localteamId", localteamId);
        starter.putExtra("visitorteamId", visitorteamId);
        starter.putExtra("contestId", contestId);
        starter.putExtra("statusId", statusId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("chip", chip);
        starter.putExtra("userInviteCode", userInviteCode);
        starter.putExtra("cashBonusContribution", "0");
        starter.putExtra("join", "0");

        startActivityForResult(starter, BaseActivity.REQUEST_CODE_JOIN_CONTESTS);
    }


    @Override
    public void createContestFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void winBreakupSuccess(WinBreakupOutPut responseLogin) {

    }

    @Override
    public void winBreakupFailure(String errMsg) {

    }

    @Override
    public void onProfileSuccess(LoginResponseOut responseLogin) {
        isPrivacyNameDisplay = responseLogin.getData().getIsPrivacyNameDisplay();
    }

    @Override
    public void onProfileFailure(String errMsg) {

        showSnackBar(errMsg);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BaseActivity.REQUEST_CODE_JOIN_CONTESTS && resultCode == RESULT_OK) {
            setResult(Activity.RESULT_OK);
            finish();
        }
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
    public void showSnackBar(@NonNull String message) {
        hideLoading();
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, message);
    }

    @Override
    public void setActivityBackground() {
        //  ActivityUtils.setActivityBackground(mContext, R.drawable.app_bg);
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
    public void onMatchFailure(String errMsg) {

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
