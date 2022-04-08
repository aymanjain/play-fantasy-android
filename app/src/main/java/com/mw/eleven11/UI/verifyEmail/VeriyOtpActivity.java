package com.mw.eleven11.UI.verifyEmail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.loginRagisterModule.LoginScreen;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.customView.CustomPinView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.ActivityUtils;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.DeviceUtils;
import com.mw.eleven11.utility.FirebaseUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.OnClick;

public class VeriyOtpActivity extends BaseActivity implements VerifyOtpView {

    private Context mContext;
    private VerifyOtpPresenterImpl mVerifyOTPPresenterImpl;
    private ProgressDialog mProgressDialog;

    String deviceToken;

    /* Butter Knife : view mapping */


    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinator_layout;

    @BindView(R.id.pinView)
    CustomPinView pinView;

    @BindView(R.id.submit_tv)
    CustomTextView submit_tv;


    @BindView(R.id.resendCode_tv)
    CustomTextView resendCode_tv;


    String email = "";

    @OnClick(R.id.submit_tv)
    public void confirmCode(View view) {

        String userTempCode = pinView.getText().toString();

        /*{
            "OTP": "563285",
                "Source": "Direct",
                "DeviceType": "Native",
                "DeviceGUID": "123456789",
                "DeviceToken": "abcxyz",
                "IPAddress": "",
                "Latitude": "",
                "Longitude": ""
        }*/

        if (TextUtils.isEmpty(userTempCode)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_otp));
            return;
        }
        LoginInput mLoginInput = new LoginInput();

        mLoginInput.setOTP(userTempCode);
        mLoginInput.setSource(Constant.Direct);
        mLoginInput.setDeviceType(Constant.DEVICE_TYPE);
        mLoginInput.setDeviceGUID(DeviceUtils.getDeviceId(getContext()));
        mLoginInput.setDeviceToken(deviceToken);


        mVerifyOTPPresenterImpl.verifyOTP(mLoginInput);

    }

    @OnClick(R.id.resendCode_tv)
    public void resendCode(View view) {
        // pinView.setText("");
        // mVerifyOTPPresenterImpl.resendAccountVerificationCodeBtn(email);

    }
    /* Butter Knife : view mapping */

    public static void start(Context context, String email) {
        Intent starter = new Intent(context, VeriyOtpActivity.class);
        starter.putExtra("email", email);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_veriy_otp;
    }

    @Override
    public void init() {


        if (getIntent() != null) {
            email = getIntent().getStringExtra("email");
        }
        deviceToken = FirebaseUtils.getToken();
        mContext = this;
        setActivityBackground();
        mVerifyOTPPresenterImpl = new VerifyOtpPresenterImpl(this, new UserInteractor());

        pinView.setAnimationEnable(true);// start animation when adding text
        pinView.requestFocus();
        // ActivityUtils.performActionOnDone(pinView,submit_tv);//handle action done event of keyboard

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
    public void showSnackBar(@NonNull String message) {
        hideLoading();
        AppUtils.showToast(mContext, message);
    }

    @Override
    public void onSuccess(LoginResponseOut message) {
        showSnackBar(message.getMessage());
        LoginScreen.start(getContext());
        finishActivity();
    }

    @Override
    public void onError(String message) {
        hideLoading();
        AppUtils.showSnackBar(mContext, coordinator_layout, message);
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

                resendCode_tv.setClickable(false);
                resendCode_tv.setText(AppUtils.getStrFromRes(R.string.resetCode) + "(" + millisUntilFinished / 1000 + ")");
                String text = "<font color='#FFFFFF'></font><font color='#FFFFFF'> Resend code in " + checkwithin1hour(millisUntilFinished) + "</font>";
                resendCode_tv.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
            }

            public void onFinish() {

                resendCode_tv.setText(AppUtils.getStrFromRes(R.string.resetCode));

                resendCode_tv.setClickable(true);
                String text = "<font color='#FFFFFF'> Resend Code</font>";
                resendCode_tv.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
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