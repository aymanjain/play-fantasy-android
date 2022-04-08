package com.mw.eleven11.UI.verifyOtp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.VerifyMobileInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.RequestOtpForSigninOutput;
import com.mw.eleven11.customView.CustomPinView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.ActivityUtils;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class VerifyOTPActivity extends BaseActivity implements VerifyOTPView {

    @BindView(R.id.coordinator_layout)
    RelativeLayout mCoordinatorLayout;
    @BindView(R.id.pinView)
    CustomPinView pinView;
    @BindString(R.string.verify_otp)
    String title;

    boolean flag = false;
//    private String isVerify="";

    /* Butter Knife : view mapping */

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ctv_confirm_code)
    CustomTextView mCustomTextViewConfirmCode;
    @BindView(R.id.ctv_resend_code)
    CustomTextView ctv_resend_code;
    @BindView(R.id.ctv_enterOTP)
    CustomTextView mEnterOTP;
    @BindView(R.id.ctv_checkForOTP)
    CustomTextView mCheckForOTP;
    CountDownTimer countDownTimer;
    private Context mContext;
    private VerifyOTPPresenterImpl mVerifyOTPPresenterImpl;
    private ProgressDialog mProgressDialog;
    private String signUpType = "";
    private String name = "";
    private String userName = "";
    private String email = "";
    private String password = "";
    private String deviceType = "";
    private String deviceId = "";
    private String deviceToken = "";
    private String confm_pswd = "";
    private String mobile = "";
    private String dob = "";
    private String loginSessionKey = "";
    private String mobile_email_value = "";
    private String keyword;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("otp")) {
                final String message = intent.getStringExtra("message");

                //Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                AppUtils.showToast(context, message);
                Log.d("PasswordonReceive", "onReceive: " + message);

                // String arr[] = message.split(" ", 2);
                String lastWord = message.substring(message.lastIndexOf(" ") + 1);
                pinView.setText(lastWord);

                //mCustomTextViewConfirmCode.performClick();

            }
        }
    };

    /* Butter Knife : view mapping */

    public static void start(Context context, String loginSessionKey, String signUpType, String name, String userName, String email, String password,
                             String deviceType, String deviceId, String deviceToken, String confm_pswd, String mobile, String dob) {
        Intent starter = new Intent(context, VerifyOTPActivity.class);
        starter.putExtra("loginSessionKey", loginSessionKey);
        starter.putExtra("signUpType", signUpType);
        starter.putExtra("name", name);
        starter.putExtra("userName", userName);
        starter.putExtra("email", email);
        starter.putExtra("password", password);
        starter.putExtra("deviceType", deviceType);
        starter.putExtra("deviceId", deviceId);
        starter.putExtra("deviceToken", deviceToken);
        starter.putExtra("confm_pswd", confm_pswd);
        starter.putExtra("mobile", mobile);
        starter.putExtra("dob", dob);
        ((Activity) context).startActivityForResult(starter, BaseActivity.REQUEST_CODE_UPDATE_PROFILE);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context, String mobile, String signUpType) {
        Intent starter = new Intent(context, VerifyOTPActivity.class);

        starter.putExtra("signUpType", signUpType);
        starter.putExtra("mobile", mobile);

        ((Activity) context).startActivityForResult(starter, BaseActivity.REQUEST_CODE_UPDATE_PROFILE);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context, String mobile_email_value, String signUpType, String keyword, String flag) {
        Intent starter = new Intent(context, VerifyOTPActivity.class);

        starter.putExtra("signUpType", signUpType);
        starter.putExtra("mobile_email_value", mobile_email_value);
        starter.putExtra("keyword", keyword);
        starter.putExtra("flag", flag);


        ((Activity) context).startActivityForResult(starter, BaseActivity.REQUEST_CODE_UPDATE_PROFILE);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context, String mobile_email_value, boolean flag, String keyword) {
        Intent starter = new Intent(context, VerifyOTPActivity.class);

        starter.putExtra("flag", flag);
        starter.putExtra("mobile_email_value", mobile_email_value);
        starter.putExtra("keyword", keyword);

        ((Activity) context).startActivityForResult(starter, BaseActivity.REQUEST_CODE_UPDATE_PROFILE);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    /* public static void start(Context context,String mobile*//*,String isVerify*//*) {
        Intent starter = new Intent(context, VerifyOTPActivity.class);
        starter.putExtra("mobile",mobile);
//        starter.putExtra("isVerify",isVerify);
        ((Activity) context).startActivityForResult(starter,BaseActivity.REQUEST_CODE_UPDATE_PROFILE);
        ((Activity) context).overridePendingTransition( R.anim.dialog_open, R.anim.dialog_close );
    }*/

    /*@OnClick(R.id.ctv_confirm_code)
    public void confirmCode(View view) {
        String loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();
        String otp = pinView.getText().toString();

        VerifyMobileInput verifyMobileInput= new VerifyMobileInput();
        verifyMobileInput.setSessionKey(loginSessionKey);
        verifyMobileInput.setOTP(otp);

        mVerifyOTPPresenterImpl.verifyMobileOtp(verifyMobileInput);
    }
*/

    @OnClick(R.id.ctv_confirm_code)
    public void confirmCode(View view) {
        String loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();
        String otp = pinView.getText().toString();
        VerifyMobileInput verifyMobileInput = new VerifyMobileInput();
        verifyMobileInput.setSessionKey(loginSessionKey);
        verifyMobileInput.setOTP(otp);
        verifyMobileInput.setSource(Constant.Direct);
        verifyMobileInput.setDeviceType(Constant.ANDROID_PHONE);
        if (keyword.equals("Email")) {
            verifyMobileInput.setEmail(mobile_email_value);
            mVerifyOTPPresenterImpl.verifyEmailOtp(verifyMobileInput);
        } else {
            verifyMobileInput.setPhoneNumber(mobile_email_value);
            mVerifyOTPPresenterImpl.verifyMobileOtp(verifyMobileInput);
        }

    }


    @OnClick(R.id.ctv_resend_code)
    public void resendCode(View view) {

        pinView.setText("");

        String loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();

        if (keyword.equals("Email")) {
           /* VerifyMobileInput verifyMobileInput= new VerifyMobileInput();
            verifyMobileInput.setSessionKey(loginSessionKey);
            verifyMobileInput.setKeyword("Mobile");
            mVerifyOTPPresenterImpl.reSendMobileOtp(verifyMobileInput);
*/

            VerifyMobileInput mobileInput = new VerifyMobileInput();
            mobileInput.setSessionKey(loginSessionKey);
            mobileInput.setEmail(mobile_email_value);
            mobileInput.setSource(Constant.Direct);
            mobileInput.setDeviceType(Constant.ANDROID_PHONE);
            mVerifyOTPPresenterImpl.actionSendEmailCodeBtn(mobileInput);

        } else {

            /*VerifyMobileInput mobileInput= new VerifyMobileInput();
            mobileInput.setSessionKey(loginSessionKey);
            mobileInput.setPhoneNumber(mobile);
            mVerifyOTPPresenterImpl.actionSendMobileOtpBtn(mobileInput);*/

            VerifyMobileInput mobileInput = new VerifyMobileInput();
            mobileInput.setSessionKey(loginSessionKey);
            mobileInput.setPhoneNumber(mobile_email_value);
            mobileInput.setSource(Constant.Direct);
            mobileInput.setDeviceType(Constant.ANDROID_PHONE);
            mVerifyOTPPresenterImpl.actionSendMobileOtpBtn(mobileInput);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_verify_otp;
    }

    @Override
    public void init() {
        if (getIntent() != null) {

            mobile = getIntent().getStringExtra("mobile");
            keyword = getIntent().getStringExtra("keyword");

            signUpType = getIntent().getStringExtra("signUpType");
            name = getIntent().getStringExtra("name");
            userName = getIntent().getStringExtra("userName");
            email = getIntent().getStringExtra("email");
            password = getIntent().getStringExtra("password");
            deviceType = getIntent().getStringExtra("deviceType");
            deviceId = getIntent().getStringExtra("deviceId");
            deviceToken = getIntent().getStringExtra("deviceToken");
            confm_pswd = getIntent().getStringExtra("confm_pswd");
            mobile = getIntent().getStringExtra("mobile");
            dob = getIntent().getStringExtra("dob");
            flag = getIntent().getBooleanExtra("flag", false);
            loginSessionKey = getIntent().getStringExtra("loginSessionKey");

            mobile_email_value = getIntent().getStringExtra("mobile_email_value");

            //isVerify =getIntent().getStringExtra("isVerify");
        }
        mContext = this;

        if (keyword.equals("Email")) {
            mEnterOTP.setText(AppUtils.getStrFromRes(R.string.enter_email_OTP));
            mCheckForOTP.setText(AppUtils.getStrFromRes(R.string.check_email_inbox));
        } else {
            mEnterOTP.setText(AppUtils.getStrFromRes(R.string.enter_mobile_OTP));
            mCheckForOTP.setText(AppUtils.getStrFromRes(R.string.check_inbox));
        }

        setActivityBackground();
        mVerifyOTPPresenterImpl = new VerifyOTPPresenterImpl(this, new UserInteractor());
        pinView.setAnimationEnable(true);// start animation when adding text
        pinView.requestFocus();
        ActivityUtils.performActionOnDone(pinView, mCustomTextViewConfirmCode);//handle action done event of keyboard

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
    public void verifyAccountSuccess(LoginResponseOut responseLogin) {

        if (flag) {
//            AppSession.getInstance().setLoginSession(responseLogin);
            if (responseLogin.getCaptchaEnable().equalsIgnoreCase("Yes")) {

                captcha();
            } else {
                HomeNavigation.start(mContext);
                setResult(RESULT_OK);
                finishActivity();
            }
        } else {
            if (responseLogin.getCaptchaEnable().equalsIgnoreCase("Yes")) {
                captcha();
            } else {
                setResult(RESULT_OK);
                finishActivity();
            }
        }


    }

    @Override
    public void verifyAccountFailure(String errMsg) {

        // calling on verify account failure
        pinView.setText("");
        hideLoading();
        showSnackBar(errMsg);


    }

    @Override
    public void verifyEmailSuccess(LoginResponseOut responseLogin) {

        hideLoading();
        if (responseLogin.getCaptchaEnable().equalsIgnoreCase("Yes")) {
            captcha();
        } else {
            setResult(RESULT_OK);
            finishActivity();
        }
//        AppUtils.showSnackBar(mContext,mCoordinatorLayout,"OTP successfully sent to your email");
    }

    @Override
    public void verifyEmailFailure(String errMsg) {

        hideLoading();
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, errMsg);
    }

    @Override
    public void resendAccountVerificationCodeFailure(String errMsg) {

        // calling on resend verification code failure

        hideLoading();
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, errMsg);

    }

    @Override
    public void resendAccountVerificationCodeSuccess(LoginResponseOut responseLogin) {
        // calling on resend verification code success
        hideLoading();
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, responseLogin.getMessage());

    }

    @Override
    public void showSnackBar(@NonNull String message) {
        hideLoading();
        AppUtils.showToast(mContext, message);
    }

    @Override
    public void setActivityBackground() {
        // ActivityUtils.setActivityBackground(mContext, R.drawable.background);
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
    public void loginSuccess(LoginResponseOut responseLogin) {

    }

    @Override
    public void otpRecevied(LoginResponseOut responseLogin) {

    }

    @Override
    public void loginFailure(String errMsg) {

    }

    @Override
    public void loginNotVerify(LoginResponseOut responseLogin) {

    }

    @Override
    public void onAccountAvailableForSignUp(String errorMsg) {

    }

    @Override
    public void loginOtpSuccess(RequestOtpForSigninOutput requestOtpForSigninOutput) {

    }

    @Override
    public void loginOtpFailure(String ermsg) {

    }

    @Override
    public void onResume() {
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("otp"));
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
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

    public void settimer() {
        ctv_resend_code.setClickable(false);

        countDownTimer = new CountDownTimer(120000, 1000) {
            public void onTick(long millisUntilFinished) {

                ctv_resend_code.setClickable(false);
                ctv_resend_code.setText(AppUtils.getStrFromRes(R.string.resetCode) + "(" + millisUntilFinished / 1000 + ")");
                String text = "<font color='#FFFFFF'></font><font color='#FFFFFF'> Didn't receive OTP? Request new in " + checkwithin1hour(millisUntilFinished) + "</font>";
                ctv_resend_code.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
                ctv_resend_code.setBackgroundResource(R.drawable.button_solid_bg_theme_inactive);
            }

            public void onFinish() {

                ctv_resend_code.setText(AppUtils.getStrFromRes(R.string.resetCode));

                ctv_resend_code.setClickable(true);
                String text = "<font color='#FFFFFF'> Didn't receive OTP? Resend </font>";
                ctv_resend_code.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
                ctv_resend_code.setBackgroundResource(R.drawable.button_solid_bg_theme_active);
            }

        }.start();
    }


    public void captcha() {
        SafetyNet.getClient(this).verifyWithRecaptcha(AppConfiguration.SAFETY_NET_API_SITE_KEY)
                .addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                    @Override
                    public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {

                        if (!response.getTokenResult().isEmpty()) {

                            // Received captcha token
                            // This token still needs to be validated on the server
                            // using the SECRET key
                            verifyTokenOnServer(response.getTokenResult());
                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof ApiException) {
                            ApiException apiException = (ApiException) e;

                        } else {
                        }
                    }
                });
    }

    private void verifyTokenOnServer(String tokenResult) {
        String loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();
        String otp = pinView.getText().toString();
        VerifyMobileInput verifyMobileInput = new VerifyMobileInput();
        verifyMobileInput.setSessionKey(loginSessionKey);
        verifyMobileInput.setOTP(otp);
        verifyMobileInput.setSource(Constant.Direct);
        verifyMobileInput.setDeviceType(Constant.ANDROID_PHONE);
        verifyMobileInput.setRequestType("APP");
        verifyMobileInput.setResponse(tokenResult);

        if (keyword.equals("Email")) {
            mVerifyOTPPresenterImpl.verifyEmailOtp(verifyMobileInput);
        } else {
            mVerifyOTPPresenterImpl.verifyMobileOtp(verifyMobileInput);
        }

    }
}
