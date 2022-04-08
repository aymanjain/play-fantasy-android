package com.mw.eleven11.UI.verifyOtp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.home.HomeNavigation;

import com.mw.eleven11.UI.loginRagisterModule.PasswordScreen;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.RequestOtpForSigninInput;
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

public class VerfiMobileOTP extends BaseActivity implements VerifyOTPView {


    public static final int REGISTER = 1;
    public static final int LOGIN = 2;
    private static final String TAG = VerfiMobileOTP.class.getName();
    @BindView(R.id.coordinator_layout)
    RelativeLayout mCoordinatorLayout;
    @BindView(R.id.pinView)
    CustomPinView pinView;
    @BindString(R.string.verify_otp)
    String title;
    @BindView(R.id.ctv_enterOTP)
    CustomTextView ctv_enterOTP;
    @BindView(R.id.ctv_checkForOTP)
    CustomTextView ctv_checkForOTP;
//    private String isVerify="";

    /* Butter Knife : view mapping */
    @BindView(R.id.title)
    CustomTextView mCustomTextViewTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ctv_confirm_code)
    CustomTextView mCustomTextViewConfirmCode;
    @BindView(R.id.ctv_resend_code)
    CustomTextView ctv_resend_code;
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
    private String keyword;
    private int flag;
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

                mCustomTextViewConfirmCode.performClick();

            }
        }
    };

    @OnClick(R.id.ctv_confirm_code)
    public void confirmCode(View view) {

        String otp = pinView.getText().toString();
        String deviceType = Constant.DEVICE_TYPE;

        if (flag == REGISTER) {
            VerifyMobileInput verifyMobileInput = new VerifyMobileInput();
            verifyMobileInput.setSessionKey(loginSessionKey);
            verifyMobileInput.setOTP(otp);
            verifyMobileInput.setDeviceType(deviceType);
            verifyMobileInput.setSource(Constant.Direct);
            verifyMobileInput.setPhoneNumber(mobile);
            mVerifyOTPPresenterImpl.verifyMobileOtp(verifyMobileInput);
        } else {
            LoginInput mLoginInput = new LoginInput();
            mLoginInput.setPhoneNumber(mobile);
            mLoginInput.setDeviceType(deviceType);
            mLoginInput.setSource("Otp");
            mLoginInput.setOTP(otp);

            mVerifyOTPPresenterImpl.actionLoginBtn(mLoginInput);
        }

    }

    @OnClick(R.id.ctv_resend_code)
    public void resendCode(View view) {

        if (flag == REGISTER) {
            pinView.setText("");
            VerifyMobileInput mobileInput = new VerifyMobileInput();
            mobileInput.setSessionKey(loginSessionKey);
            mobileInput.setPhoneNumber(mobile);
            mVerifyOTPPresenterImpl.actionSendMobileOtpBtn(mobileInput);
        } else {
            otpSignInService(mobile);
        }

    }

    private void otpSignInService(String mobile) {
        RequestOtpForSigninInput requestOtpForSigninInput = new RequestOtpForSigninInput();
        requestOtpForSigninInput.setPhoneNumber(mobile);
        requestOtpForSigninInput.setSource("Otp");
        mVerifyOTPPresenterImpl.actionOtpLoginBtn(requestOtpForSigninInput);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_verify_otp;
    }


    public static void start(Context context, String mobile, String SessionKey, int flag) {
        Intent starter = new Intent(context, VerfiMobileOTP.class);
        starter.putExtra("loginSessionKey", SessionKey);
        starter.putExtra("mobile", mobile);
        starter.putExtra("flag", flag);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @OnClick(R.id.back)
    void onBackClick() {
        onBackPressed();
    }


    @Override
    public void init() {
        /*  mCustomTextViewTitle.setText(title);*/
        ctv_enterOTP.setVisibility(View.VISIBLE);
        ctv_checkForOTP.setVisibility(View.VISIBLE);
        ctv_enterOTP.setText(getResources().getString(R.string.enter_mobile_OTP));
        ctv_checkForOTP.setText(getResources().getString(R.string.check_inbox));

        if (getIntent() != null) {
            flag = getIntent().getExtras().getInt("flag");
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
            loginSessionKey = getIntent().getStringExtra("loginSessionKey");

            //isVerify =getIntent().getStringExtra("isVerify");
        }
        mContext = this;
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

//        if (isVerify.equalsIgnoreCase("no")){

        // AppSession.getInstance().setLoginSession(responseLogin);

        finishActivity();

//        LoginScreen.start(mContext);

        AppSession.getInstance().setLoginSession(responseLogin);
        showSnackBar(responseLogin.getMessage());
        HomeNavigation.start(mContext);

        //responseLogin.getResponse().setIs_first_login(1);
        //AppSession.getInstance().getLoginSession().getResponse().setMobileVerify(responseLogin.getResponse().getMobileVerify());
        // ChooseGameActivity.start(mContext);

//        }else {
//            AppSession.getInstance().updateMobile(mobile);
//            AppUtils.showToast(mContext, responseLogin.getMessage());
//            setResult(RESULT_OK);
//        }


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

    }

    @Override
    public void verifyEmailFailure(String errMsg) {

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
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, AppUtils.getStrFromRes(R.string.mobileNoInfo));

        //finishActivity();
        settimer();
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
        hideLoading();

        if (responseLogin.getCaptchaEnable().equalsIgnoreCase("Yes")) {
            captcha();
        } else {
            HomeNavigation.start(mContext);

            finishAffinity();
        }
        AppSession.getInstance().setLoginSession(responseLogin);
        showSnackBar(responseLogin.getMessage());


    }


    public void captcha() {
        SafetyNet.getClient(this).verifyWithRecaptcha(AppConfiguration.SAFETY_NET_API_SITE_KEY)
                .addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                    @Override
                    public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                        Log.d(TAG, "onSuccess");

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
                            Log.d(TAG, "Error message: " +
                                    CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));
                        } else {
                            Log.d(TAG, "Unknown type of error: " + e.getMessage());
                        }
                    }
                });
    }

    private void verifyTokenOnServer(String tokenResult) {

        String otp = pinView.getText().toString();
        String deviceType = Constant.DEVICE_TYPE;
        LoginInput mLoginInput = new LoginInput();
        mLoginInput.setPhoneNumber(mobile);
        mLoginInput.setDeviceType(deviceType);
        mLoginInput.setSource("Otp");
        mLoginInput.setOTP(otp);
        mLoginInput.setRequestType("APP");
        if (!tokenResult.isEmpty()) {
            mLoginInput.setResponse(tokenResult);
        }
        mVerifyOTPPresenterImpl.actionLoginBtn(mLoginInput);
    }


    @Override
    public void otpRecevied(LoginResponseOut responseLogin) {
        PasswordScreen.start(mContext, mobile, 1);

        showSnackBar(responseLogin.getMessage());
    }

    @Override
    public void loginFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);

    }

    @Override
    public void loginNotVerify(LoginResponseOut responseLogin) {

        hideLoading();
        finishActivity();
        showSnackBar(responseLogin.getMessage());
    }

    @Override
    public void onAccountAvailableForSignUp(String errorMsg) {

    }

    @Override
    public void loginOtpSuccess(RequestOtpForSigninOutput requestOtpForSigninOutput) {
        showSnackBar("Otp send to your mobile number, Please check");
    }

    @Override
    public void loginOtpFailure(String ermsg) {
        showSnackBar(ermsg);
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
                ctv_resend_code.setBackgroundResource(R.drawable.button_color_gray);
                ctv_resend_code.setClickable(false);
                ctv_resend_code.setText(AppUtils.getStrFromRes(R.string.resetCode) + "(" + millisUntilFinished / 1000 + ")");

             /*   String text = "<font color='#FFFFFF'></font><font color='#FFFFFF'> Didn't receive the OTP? Request for new one in " + checkwithin1hour(millisUntilFinished) + "</font>";
                ctv_resend_code.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);*/
            }

            public void onFinish() {
                ctv_resend_code.setBackgroundResource(R.drawable.button_color_primary);
                ctv_resend_code.setText(AppUtils.getStrFromRes(R.string.resetCode));

                ctv_resend_code.setClickable(true);
               /* String text = "<font color='#FFFFFF'> Didn't receive the OTP? Resend </font>";
                ctv_resend_code.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);*/
            }

        }.start();
    }
}
