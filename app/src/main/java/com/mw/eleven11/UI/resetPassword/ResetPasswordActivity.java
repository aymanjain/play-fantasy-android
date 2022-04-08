package com.mw.eleven11.UI.resetPassword;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.forgotPassword.ForgotPasswordPresenterImpl;
import com.mw.eleven11.UI.forgotPassword.ForgotPasswordView;
import com.mw.eleven11.UI.loginRagisterModule.LoginScreen;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanOutput.ForgetPasswordOut;
import com.mw.eleven11.beanOutput.ResponseLogin;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomPinView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.ActivityUtils;
import com.mw.eleven11.utility.AppUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.OnClick;


public class ResetPasswordActivity extends BaseActivity implements ResetPasswordView, ForgotPasswordView {

    public static final int EMAIL = 1;
    public static final int MOBILE = 2;
    private int flag;
    private Context mContext;
    private ResetPasswordPresenterImpl mVerifyOTPPresenterImpl;
    private ForgotPasswordPresenterImpl mForgotPasswordPresenterImpl;
    private ProgressDialog mProgressDialog;

    @OnClick(R.id.back)
    void onBackClick() {
        onBackPressed();
    }

    /* Butter Knife : view mapping */

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinator_layout;

    @BindView(R.id.pinView)
    CustomPinView pinView;

    @BindView(R.id.submit_tv)
    CustomTextView submit_tv;

    @BindView(R.id.ctv_msg)
    CustomTextView ctv_message;

    @BindView(R.id.password_et)
    CustomEditText password_et;


    @BindView(R.id.resendCode_tv)
    CustomTextView resendCode_tv;

    @BindView(R.id.confirm_password_et)
    CustomEditText confirm_password_et;
    String email = "";

    @OnClick(R.id.submit_tv)
    public void confirmCode(View view) {
        String password = password_et.getText().toString().trim();
        String confirmPassword = confirm_password_et.getText().toString().trim();
        String userTempCode = pinView.getText().toString();


        LoginInput mLoginInput = new LoginInput();

        mLoginInput.setOTP(userTempCode);
        mLoginInput.setPassword(password);
        mLoginInput.setConfirmPassword(confirmPassword);


        mVerifyOTPPresenterImpl.resetPasswordBtn(mLoginInput);

    }

    @OnClick(R.id.resendCode_tv)
    public void resendCode(View view) {
        // pinView.setText("");
        LoginInput mLoginInput = new LoginInput();
        mLoginInput.setKeyword(email);
        mForgotPasswordPresenterImpl.actionForgotPasswordBtn(mLoginInput);

    }
    /* Butter Knife : view mapping */

    public static void start(Context context, String email, int flag) {
        Intent starter = new Intent(context, ResetPasswordActivity.class);
        starter.putExtra("email", email);
        starter.putExtra("flag", flag);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_reset_password;
    }

    @Override
    public void init() {

        if (getIntent() != null) {
            email = getIntent().getStringExtra("email");
            flag = getIntent().getIntExtra("flag", 0);
        }
        if (flag == EMAIL) {
            ctv_message.setText("Please check your mail inbox for verification code.");
        } else if (flag == MOBILE) {
            ctv_message.setText("Please check your mobile inbox for verification code.");
        }
        mContext = this;
        // setActivityBackground();
        mVerifyOTPPresenterImpl = new ResetPasswordPresenterImpl(this, new UserInteractor());
        mForgotPasswordPresenterImpl = new ForgotPasswordPresenterImpl(this, new UserInteractor());

        pinView.setAnimationEnable(true);// start animation when adding text
        pinView.requestFocus();
        ActivityUtils.performActionOnDone(pinView, submit_tv);//handle action done event of keyboard

        pinView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(pinView, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        settimer();
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
    public void forgotPasswordSuccess(ForgetPasswordOut responseLogin) {
        hideLoading();
        showSnackBar(responseLogin.getMessage());
    }

    @Override
    public void forgotPasswordFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void verifyAccountSuccess(ForgetPasswordOut responseLogin) {

        // calling on verify account success
        //  AppSession.getInstance().setLoginSession(responseLogin);
        showSnackBar(responseLogin.getMessage());
        LoginScreen.start(getContext());
        finishActivity();
    }

    @Override
    public void verifyAccountFailure(String errMsg) {

        // calling on verify account failure
        //pinView.setText("");
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void resendAccountVerificationCodeFailure(String errMsg) {

        // calling on resend verification code failure
        hideLoading();
        AppUtils.showSnackBar(mContext, coordinator_layout, errMsg);

    }

    @Override
    public void resendAccountVerificationCodeSuccess(ResponseLogin responseLogin) {
        // calling on resend verification code success
        settimer();
        hideLoading();
        AppUtils.showSnackBar(mContext, coordinator_layout, responseLogin.getMessage());
    }

    @Override
    public void showSnackBar(@NonNull String message) {
        hideLoading();
        AppUtils.showToast(mContext, message);
    }

    @Override
    public void setActivityBackground() {
        ActivityUtils.setActivityBackground(mContext, R.drawable.background);
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void finishActivity() {
        finish();
    }

    public void settimer() {
        resendCode_tv.setClickable(false);

        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                resendCode_tv.setBackgroundResource(R.drawable.button_color_gray);
                resendCode_tv.setClickable(false);
                resendCode_tv.setText(AppUtils.getStrFromRes(R.string.resetCode) + "(" + millisUntilFinished / 1000 + ")");

            }

            public void onFinish() {
                resendCode_tv.setBackgroundResource(R.drawable.button_color_primary);
                resendCode_tv.setText(AppUtils.getStrFromRes(R.string.resetCode));
                resendCode_tv.setClickable(true);
            }

        }.start();
    }

    public String checkwithin1hour(long timedeffrence) {
        //milliseconds
        long different = timedeffrence;
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays,
                elapsedHours, elapsedMinutes, elapsedSeconds);
        NumberFormat f = new DecimalFormat("00");

        String remaingtime =
                String.valueOf(f.format(elapsedMinutes)) + ":" + String.valueOf(f.format(elapsedSeconds));
        return remaingtime;

    }
}
