package com.mw.eleven11.UI.loginRagisterModule;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.forgotPassword.ForgotPasswordActivity;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;

import com.mw.eleven11.beanOutput.RequestOtpForSigninOutput;
import com.mw.eleven11.customView.CustomPinView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.customView.PasswordInputEditText;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.ActivityUtils;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.DeviceUtils;
import com.mw.eleven11.utility.FirebaseUtils;
import com.mw.eleven11.utility.LanguageContextWrapper;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class PasswordScreen extends BaseActivity implements LoginView {

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    private Context mContext;
    private ProgressDialog mProgressDialog;

    private LoginPresenterImpl mLoginPresenterImpl;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinator_layout;

    /* Butter Knife : view mapping */
    @BindString(R.string.network_error)
    String mResStringNetworkError;

    @BindView(R.id.emailAddress)
    CustomTextView emailAddress;


    @BindView(R.id.otpSendTo)
    CustomTextView otpSendTo;

    @BindView(R.id.password)
    PasswordInputEditText passwordEt;

    @BindView(R.id.submit)
    CustomTextView submit;

    @BindView(R.id.resendCode_tv)
    CustomTextView resendCode_tv;

    @BindView(R.id.submitOtp)
    CustomTextView submitOtp;

    @BindView(R.id.pinView)
    CustomPinView pinView;

    @BindView(R.id.forgot_password)
    CustomTextView forgot_password;

    @BindView(R.id.mobileRl)
    LinearLayout mobileRl;
    @BindView(R.id.emailRl)
    LinearLayout emailRl;

    @BindView(R.id.loginUsingMobileNumber)
    CustomTextView loginUsingMobileNumber;

    @OnClick(R.id.forgot_password)
    void onForgot_password() {

        ForgotPasswordActivity.start(mContext);
    }

    @OnClick(R.id.back)
    void onBackClick() {

        finish();
    }

    @OnClick(R.id.loginUsingMobileNumber)
    void onloginUsingMobileNumberClick() {

        LoginScreen.start(mContext);
    }

    public static void start(Context context, String emailMobile, int tag) {
        Intent starter = new Intent(context, PasswordScreen.class);
        starter.putExtra("emailMobile", emailMobile);
        starter.putExtra("tag", tag);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @OnClick(R.id.submit)
    void onSubmitClick() {

        String emailAddress = getIntent().getStringExtra("emailMobile");
        String password = passwordEt.getText().toString().trim();


        signInService(emailAddress, password);
    }

    @OnClick(R.id.resendCode_tv)
    void onResendOtp() {
        String emailAddress = getIntent().getStringExtra("emailMobile");
        // String password = passwordEt.getText().toString().trim();
        String deviceId = DeviceUtils.getDeviceId(getContext());
        String signUpType = DeviceUtils.getSignUpType(getContext());
        String deviceToken = FirebaseInstanceId.getInstance().getToken();
        Log.i("deviceToken", "deviceToken:" + deviceToken);
        String deviceType = Constant.DEVICE_TYPE;

        LoginInput mLoginInput = new LoginInput();
      /*  mLoginInput.setEmail("");
        mLoginInput.setMobile(emailAddress);
        // mLoginInput.setPassword(password);
        mLoginInput.setDevice_id(deviceId);
        mLoginInput.setSignup_type(signUpType);
        mLoginInput.setDevice_type(deviceType);
        mLoginInput.setDevice_token(deviceToken);*/

        mLoginPresenterImpl.actionLoginBtn(mLoginInput);
    }

    @OnClick(R.id.submitOtp)
    void onSubmitOtpClick() {

       /* String emailAddress = getIntent().getStringExtra("emailMobile");
        String password = pinView.getText().toString();
        String deviceId = DeviceUtils.getDeviceId(getContext());
        String signUpType = DeviceUtils.getSignUpType(getContext());
        String deviceToken = FirebaseUtils.getToken();
        Log.i("deviceToken", "deviceToken:" + deviceToken);
        String deviceType = Constant.DEVICE_TYPE;

        LoginInput mLoginInput = new LoginInput();
        mLoginInput.setEmail(emailAddress);
        mLoginInput.setPassword(password);
        mLoginInput.setDevice_id(deviceId);
        mLoginInput.setSignup_type(signUpType);
        mLoginInput.setDevice_type(deviceType);
        mLoginInput.setDevice_token(deviceToken);
*/

        mLoginPresenterImpl.verifyOTP(pinView.getText().toString());
    }

    @Override
    public int getLayout() {
        return R.layout.activity_password_screen;
    }

    @Override
    public void init() {

        checkAndRequestPermissions();

        mContext = this;
        mLoginPresenterImpl = new LoginPresenterImpl(this, new UserInteractor());
        ActivityUtils.performActionOnDone(passwordEt, submit);//handle action done event of keyboard

        emailAddress.setText(getIntent().getStringExtra("emailMobile"));

        if (getIntent().getIntExtra("tag", 0) == 1) {
            mobileRl.setVisibility(View.VISIBLE);
            emailRl.setVisibility(View.GONE);
            forgot_password.setVisibility(View.GONE);

            resendCode_tv.setVisibility(View.VISIBLE);


            otpSendTo.setText(getString(R.string.otpSendTo) + " " + getIntent().getStringExtra("emailMobile"));
            loginUsingMobileNumber.setText(getString(R.string.loginUsingEmail));

            pinView.setAnimationEnable(true);// start animation when adding text
            pinView.requestFocus();
            ActivityUtils.performActionOnDone(pinView, submitOtp);//handle action done event of keyboard

            pinView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(pinView, InputMethodManager.SHOW_IMPLICIT);
                }
            });

            settimer();

        } else {
            emailRl.setVisibility(View.VISIBLE);
            mobileRl.setVisibility(View.GONE);
            forgot_password.setVisibility(View.VISIBLE);
            resendCode_tv.setVisibility(View.GONE);
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (mLoginPresenterImpl != null) {
            mLoginPresenterImpl.checkSocialLoginCancel();
            mLoginPresenterImpl.loginCancel();
        }

    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null)
            mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();

    }

    @Override
    public void onAccountAvailableForSignUp(String errorMsg) {
        hideLoading();
        AppUtils.showToast(mContext, errorMsg);
    }


    @Override
    public void loginSuccess(LoginResponseOut responseLogin) {
        hideLoading();
        AppUtils.showToast(mContext, responseLogin.getMessage());
        AppSession.getInstance().setLoginSession(responseLogin);
        HomeNavigation.start(mContext);


        //  Toast.makeText(mContext, responseLogin.getMessage(), Toast.LENGTH_SHORT).show();

        AppUtils.showToast(mContext, responseLogin.getMessage());

        if (getIntent().hasExtra(Constant.KEY_DATA)) {

            setResult(RESULT_OK, getIntent());

        } else {
            //GameOptionActivity.start(mContext);
        }


    }

    @Override
    public void otpRecevied(LoginResponseOut responseLogin) {

        hideLoading();
        showSnackBar(responseLogin.getMessage());
        settimer();
    }

    @Override
    public void loginNotVerify(LoginResponseOut responseLogin) {

        hideLoading();
        finishActivity();
    }

    @Override
    public void loginFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }


    @Override
    public void socialLoginSuccess(LoginResponseOut responseLogin) {

    }

    @Override
    public void socialLoginNotVerify(LoginResponseOut responseLogin) {
        // AppSession.getInstance().setLoginSession(responseLogin);
        hideLoading();
        finishActivity();
    }

    @Override
    public void socialLoginNotAvailable(LoginInput mLoginInput, String errMsg) {

    }

    @Override
    public void socialLoginFailure(String errMsg) {


    }


    @Override
    public void showSnackBar(@NonNull String message) {
        AppUtils.showSnackBar(mContext, coordinator_layout, message);
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
    public void loginOtpSuccess(RequestOtpForSigninOutput requestOtpForSigninOutput) {

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LanguageContextWrapper.wrap(newBase, AppSession.getInstance().getLanguage()));
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

    CountDownTimer countDownTimer;

    public void settimer() {
        resendCode_tv.setClickable(false);

        countDownTimer = new CountDownTimer(120000, 1000) {
            public void onTick(long millisUntilFinished) {

                resendCode_tv.setClickable(false);
                resendCode_tv.setText(AppUtils.getStrFromRes(R.string.resetCode) + "(" + millisUntilFinished / 1000 + ")");
                String text = "<font color='#FFFFFF'></font><font color='#FFFFFF'> Didn't receive the OTP? Request for new one in " + checkwithin1hour(millisUntilFinished) + "</font>";
                resendCode_tv.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
            }

            public void onFinish() {

                resendCode_tv.setText(AppUtils.getStrFromRes(R.string.resetCode));

                resendCode_tv.setClickable(true);
                String text = "<font color='#FFFFFF'> Didn't receive the OTP? Resend </font>";
                resendCode_tv.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
            }

        }.start();
    }

    /*private  boolean checkAndRequestPermissions() {
        int permissionSendMessage = ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS);
        int receiveSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        int readSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (receiveSMS != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.RECEIVE_MMS);
        }
        if (readSMS != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_SMS);
        }
        if (permissionSendMessage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.SEND_SMS);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),
                    REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }*/
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("otp")) {
                final String message = intent.getStringExtra("message");


                // Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

                AppUtils.showToast(mContext, message);

                Log.d("PasswordonReceive", "onReceive: " + message);

                // String arr[] = message.split(" ", 2);
                String lastWord = message.substring(message.lastIndexOf(" ") + 1);
                pinView.setText(lastWord);

                submitOtp.performClick();


            }
        }
    };

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

    private void signInService(String email, String password) {
        String deviceId = DeviceUtils.getDeviceId(getContext());
        String deviceToken = FirebaseUtils.getToken();
        String deviceType = Constant.DEVICE_TYPE;
        String signUpType = DeviceUtils.getSignUpType(getContext());


        LoginInput mLoginInput = new LoginInput();

        mLoginInput.setKeyword(email);
        mLoginInput.setPassword(password);
        mLoginInput.setSource(Constant.Direct);
        mLoginInput.setDeviceType(deviceType);
        mLoginInput.setDeviceGUID(deviceId);
        mLoginInput.setDeviceToken(deviceToken);


        mLoginPresenterImpl.actionLoginBtn(mLoginInput);
    }
}
