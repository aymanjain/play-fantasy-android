package com.mw.eleven11.fcm;

import android.content.Context;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.matchContest.MatchContestActivity;
import com.mw.eleven11.UI.notifications.NotificationsActivity;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.dialog.ProgressDialog;

public class NotificationClickActivity extends BaseActivity implements View {


    private String MatchGUID = "";
    private Context mContext;
    PresenterImpl mMatchPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    public int getLayout() {
        return R.layout.activity_notification_click;
    }

    @Override
    public void init() {

        mContext = this;
        mProgressDialog = new ProgressDialog(mContext);
        mMatchPresenter = new PresenterImpl(this, new UserInteractor());

        if (getIntent().hasExtra("MatchGUID")) {
            MatchGUID = getIntent().getStringExtra("MatchGUID");
        }

        if (MatchGUID.equals("")) {
            NotificationsActivity.start(mContext);
            finish();
        } else {
            calltask(MatchGUID);
        }

    }

    private void calltask(String matchGUID) {

        MatchDetailInput mMatchDetailInput = new MatchDetailInput();
        mMatchDetailInput.setMatchGUID(MatchGUID);
        mMatchDetailInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchDetailInput.setParams("Status");
        mMatchPresenter.actionMatchdetail(mMatchDetailInput);
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onMatchSuccess(MatchDetailOutPut responseLogin) {

        hideLoading();
        if (responseLogin != null && responseLogin.getData() != null) {
            if (responseLogin.getData().getStatus() != null && responseLogin.getData().getStatus().equals("Pending")) {
                MatchContestActivity.start(mContext, MatchGUID, responseLogin.getData().getStatus(), true);
            } else if (responseLogin.getData().getStatus() != null && responseLogin.getData().getStatus().equals("Running")) {
                HomeNavigation.start(mContext, responseLogin.getData().getStatus());
            } else if (responseLogin.getData().getStatus() != null && responseLogin.getData().getStatus().equals("Completed")) {
                HomeNavigation.start(mContext, responseLogin.getData().getStatus());
            }
            finish();
        }
    }

    @Override
    public void onMatchFailure(String errMsg) {
        hideLoading();
        NotificationsActivity.start(mContext);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public Context getContext() {
        return mContext;
    }
}
