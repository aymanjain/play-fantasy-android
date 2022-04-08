package com.mw.eleven11.UI.contestInviteCode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import butterknife.BindView;
import butterknife.OnClick;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;

import com.mw.eleven11.UI.contestDetailLeaderBoard.ContestLeaderPresenterImpl;
import com.mw.eleven11.UI.contestDetailLeaderBoard.ContestLeaderView;
import com.mw.eleven11.UI.createTeam.CreateTeamActivity;
import com.mw.eleven11.UI.myTeams.MyTeamsActivity;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;

import com.mw.eleven11.beanInput.ContestDetailInput;
import com.mw.eleven11.beanInput.GetPrivateContestInput;
import com.mw.eleven11.beanOutput.ContestDetailOutput;
import com.mw.eleven11.beanOutput.DreamTeamOutput;
import com.mw.eleven11.beanOutput.GetPrivateContestOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.ResponseDownloadTeam;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;

public class InviteCodes extends BaseActivity implements ContestLeaderView {
    public static final int DFS = 0;
    public static final int AUCTION = 1;
    private int flag;
    private String roundId;
    private ProgressDialog mProgressDialog;
    private UserInteractor mUserInteractor;

    private ContestLeaderPresenterImpl mContestLeaderPresenterImpl;

    Context mContext;
    private Loader loader;

    String teamCount="0";
    String inviteCodeString;

    public static void start(Context context, String roundId, int flag) {
        Intent starter = new Intent(context, InviteCodes.class);
        starter.putExtra("roundId", roundId);
        starter.putExtra("flag", flag);
        ((Activity) context).startActivityForResult(starter, 120);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context, String teamCount) {
        Intent starter = new Intent(context, InviteCodes.class);
        starter.putExtra("teamCount", teamCount);
        starter.putExtra("flag", DFS);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context, String teamCount, String inviteCode) {
        Intent starter = new Intent(context, InviteCodes.class);
        starter.putExtra("teamCount", teamCount);
        starter.putExtra("inviteCode", inviteCode);
        starter.putExtra("flag", DFS);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @OnClick(R.id.back)
    void onBackClick() {

        onBackPressed();
    }

    @BindView(R.id.inviteCode)
    CustomEditText inviteCode;

    @OnClick(R.id.joinContest)
    void onJoinClick() {

        // Toast.makeText(this, AppUtils.getStrFromRes(R.string.workInProgress), Toast.LENGTH_SHORT).show();

        if (inviteCode.getText().toString().trim().length() != 6) {
            // Toast.makeText(this, getString(R.string.enter_your_code8), Toast.LENGTH_SHORT).show();

            AppUtils.showToast(mContext, AppUtils.getStrFromRes(R.string.enter_your_code8));

            return;
        }

       /* presenterImpl.to_check_contest(AppSession.getInstance().getLoginSession().getResponse().
                        getLoginSessionKey(),
                inviteCode.getText().toString().trim());*/

        callContestDetail(inviteCode.getText().toString().trim());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayout() {

        return R.layout.activity_invite_codes;
    }

    @Override
    public void init() {
        mContext = this;
        mUserInteractor= new UserInteractor();
        loader = new Loader(this);
        mContestLeaderPresenterImpl = new ContestLeaderPresenterImpl(this, new UserInteractor());

        flag = getIntent().getExtras().getInt("flag");


        if (getIntent().hasExtra("roundId")) {
            roundId = getIntent().getStringExtra("roundId");
        }

        if(getIntent().hasExtra("teamCount")){
            teamCount= getIntent().getStringExtra("teamCount");
        }

        if(getIntent().hasExtra("inviteCode")){
            inviteCodeString= getIntent().getStringExtra("inviteCode");

            inviteCode.setText(inviteCodeString);
            callContestDetail(inviteCodeString);
        }

    }

    private void callContestDetail(String inviteCode){

        if (flag == 0) {
            ContestDetailInput mContestDetailInput= new ContestDetailInput();
            mContestDetailInput.setUserInvitationCode(inviteCode);
            mContestDetailInput.setParams(Constant.CONTEST_PARAM);
            mContestDetailInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            mContestLeaderPresenterImpl.getContest(mContestDetailInput);
        }
    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.dismiss();

        loader.hide();
    }

    @Override
    public void onMatchSuccess(MatchDetailOutPut responseLogin) {

    }

    @Override
    public void onMatchFailure(String errMsg) {

    }

    @Override
    public void onContestDetailSuccess(ContestDetailOutput mContestDetailOutput) {


       /* if(teamCount.equals("0")){

            CreateTeamActivityStart(mContext,
                    mContestDetailOutput.getData().getMatchGUID(),
                    mContestDetailOutput.getData().getContestGUID(),mContestDetailOutput.getData().getEntryFee());
        }else {
            MyTeamActivityStart(mContext, mContestDetailOutput.getData().getMatchGUID(),
                    mContestDetailOutput.getData().getContestGUID(), mContestDetailOutput.getData().getEntryFee(),
                    mContestDetailOutput.getData().getStatusID());
        }*/
        if (mContestDetailOutput.getData().getContestGUID()==null) {
            onShowSnackBar("Invalid code");
        }else {
            MyTeamActivityStart(mContext, mContestDetailOutput.getData().getMatchGUID(),
                    mContestDetailOutput.getData().getContestGUID(), mContestDetailOutput.getData().getEntryFee(),
                    mContestDetailOutput.getData().getStatusID(),mContestDetailOutput.getData().getUserInvitationCode());

            Log.d("mJoinedContestBean",mContestDetailOutput.getMessage());
            onShowSnackBar(mContestDetailOutput.getMessage());

        }





    }

    public void CreateTeamActivityStart(Context context, String matchGUID,String contestId,String joiningAmount) {
        Intent starter = new Intent(context, CreateTeamActivity.class);

        starter.putExtra("matchId", matchGUID);
        starter.putExtra("contestId", contestId);
        starter.putExtra("joiningAmount", joiningAmount);

        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }

    public void MyTeamActivityStart(Context context,  String matchId,  String contestId, String joiningAmount,String statusId,String userInviteCode) {
        Intent starter = new Intent(context, MyTeamsActivity.class);
        starter.putExtra("contestId", contestId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("statusId", statusId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("userInviteCode", userInviteCode);
        starter.putExtra("cashBonusContribution", "0");
        starter.putExtra("join", "1");


        startActivityForResult(starter, BaseActivity.REQUEST_CODE_JOIN_CONTESTS);
    }

    @Override
    public void onContestDetailFailure(String errMsg) {

    }

    @Override
    public void onDownloadTeamSuccess(ResponseDownloadTeam mResponseDownloadTeam) {

    }

    @Override
    public void onDownloadTeamFailure(String errMsg) {

    }

    @Override
    public void onDreamTeamSucess(DreamTeamOutput dreamTeamOutput) {

    }

    @Override
    public void onDreamTeamFailure(String errMsg) {

    }

    @Override
    public void dreamshowLoading() {

    }

    @Override
    public void dreamhideLoading() {

    }

    @Override
    public void onProfileSuccess(LoginResponseOut responseLogin) {

    }

    @Override
    public void onProfileFailure(String errMsg) {

    }

    @Override
    public void onShowSnackBar(String message) {

        AppUtils.showToast(mContext,message);
    }

    @Override
    public boolean isAttached() {
        return false;
    }

    @Override
    public Context getContext() {
        return mContext;
    }









}
