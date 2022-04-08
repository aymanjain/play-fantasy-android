package com.mw.eleven11.UI.loginRagisterModule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.outsideEvents.OutSideEvent;
import com.mw.eleven11.UI.verifyOtp.VerfiMobileOTP;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.SingupInput;
import com.mw.eleven11.beanOutput.ResponceSignup;


import com.mw.eleven11.beanOutput.ResponseReferralDetails;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomInputEditText;
import com.mw.eleven11.customView.CustomTextView;

import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.DataValidationUtils;
import com.mw.eleven11.utility.DeviceUtils;
import com.mw.eleven11.utility.FirebaseUtils;
import com.mw.eleven11.utility.LanguageContextWrapper;

import butterknife.BindView;
import butterknife.OnClick;

public class HaveCode extends BaseActivity implements SignUpView {


    private static final String TAG = HaveCode.class.getName();
    /*GLOBAL OBJECTS*/
    private Context mContext;
    private SignUpPresenterImpl mSignUpPresenterImpl;
    private ProgressDialog mProgressDialog;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    @BindView(R.id.alreadygaveAccount)
    CustomTextView alreadygaveAccount;

    @BindView(R.id.ctv_mobile_message)
    CustomTextView referraltextmessage;

    @BindView(R.id.enter_invite_code)
    CustomEditText enter_invite_code;

    @BindView(R.id.ll_referral)
    LinearLayout mLinearLayoutReferral;

    @BindView(R.id.mobileNo)
    CustomEditText mobileNo;

    @BindView(R.id.email)
    CustomEditText email;

    @BindView(R.id.password)
    CustomEditText password;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinator_layout;


    @BindView(R.id.pass_check)
    CheckBox pass_check;

    Loader mLoader;

    @OnClick(R.id.back)
    void onBackClick() {

        finish();
    }

    @OnClick(R.id.alreadygaveAccount)
    void onAlreadygaveAccount() {

        LoginScreen.start(mContext);
        finish();
    }

    @OnClick(R.id.iAgree)
    void onTermCondition() {

        OutSideEvent.start(this, "TERMS_CONDITIONS", Constant.TERMS_CONDITIONS_URL);
    }

    @OnClick(R.id.next)
    void onClickNext() {
        if (checkAndRequestPermissions()) {
            // carry on the normal flow, as the case of  permissions  granted.
            submitForNext("");

        }

    }

    void submitForNext(String tokenResult) {
        tokenResult = "DemoToken";
        mobileNumber = mobileNo.getText().toString().trim();
        emailText = email.getText().toString().trim();
        passwordText = password.getText().toString().trim();
        invite_code = enter_invite_code.getText().toString();
        deviceId = DeviceUtils.getDeviceId(getContext());
        signupType = DeviceUtils.getSignUpType(getContext());
        deviceToken = FirebaseUtils.getToken();
        deviceType = Constant.DEVICE_TYPE;



        if (TextUtils.isEmpty(invite_code)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_inviteCode));
        } else if (TextUtils.isEmpty(emailText)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_email));
        } else if (!DataValidationUtils.isValidEmail(emailText)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.invalid_email));
        } else if (TextUtils.isEmpty(passwordText)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_password));
        } else if (DataValidationUtils.isPasswordValid(passwordText.trim())) {
            showSnackBar(AppUtils.getStrFromRes(R.string.short_password));

        } else if (TextUtils.isEmpty(mobileNumber)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_phone_number));
        } else if (!DataValidationUtils.checkMobile(mobileNumber)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.invalid_phone_number));
        } else if (TextUtils.isEmpty(deviceId)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_device_id));
        } else if (TextUtils.isEmpty(deviceToken)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_device_token));
        } else {

           /* mSingupInput.setMobileNumber(mobileNumber);
            mSingupInput.setSignupType(signupType);
            mSingupInput.setDeviceType(deviceType);
            mSingupInput.setDeviceId(deviceId);
            mSingupInput.setDeviceToken(deviceToken);
            mSingupInput.setInvite_code(invite_code);
            mSingupInput.setOfferCode(offerCodeString);*/

            SingupInput mSingupInput = new SingupInput();

            mSingupInput.setUserTypeID(Constant.UserTypeID);
            // mSingupInput.setFirstName(firstName);
            mSingupInput.setEmail(emailText);
            mSingupInput.setReferralCode(invite_code);
            mSingupInput.setPassword(passwordText);
            mSingupInput.setPhoneNumber(mobileNumber);
            mSingupInput.setSource(Constant.Direct);
            mSingupInput.setDeviceType(deviceType);
            mSingupInput.setDeviceGUID(deviceId);
            mSingupInput.setDeviceToken(deviceToken);
            mSingupInput.setRequestType("APP");

            if (!tokenResult.isEmpty()) {
                mSingupInput.setResponse(tokenResult);
            }

            mSignUpPresenterImpl.actionSignUpBtn(mSingupInput);
        }
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, HaveCode.class);

        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    String mobileNumber;
    String emailText;
    String passwordText;
    String invite_code;
    String deviceId;
    String signupType;
    String deviceToken;
    String deviceType;


    @Override
    public int getLayout() {
        return R.layout.activity_have_code;
    }

    @Override
    public void init() {
        mContext = this;
        mLoader = new Loader(this);
        getWindow().setBackgroundDrawableResource(R.color.white);

        mSignUpPresenterImpl = new SignUpPresenterImpl(this, new UserInteractor());
        mLoader.start();
        mSignUpPresenterImpl.actionReferralBtn();

        pass_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){


                    password.setTransformationMethod(new HideReturnsTransformationMethod());
                }else {

                    password.setTransformationMethod(new PasswordTransformationMethod());

                }
            }
        });
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
        submitForNext(tokenResult);
    }

    AlertDialog alertExitDialog;

    @Override
    public void signUpSuccess(ResponceSignup mSignUpOutput) {
        hideLoading();

        showSnackBar(mSignUpOutput.getMessage());

        if (getIntent().hasExtra(Constant.KEY_DATA)) {

/*
            Intent starter = new Intent(mContext, PasswordScreen.class);
            starter.putExtra(Constant.KEY_DATA, "Done");
            starter.putExtra("emailMobile", mobileNo.getText().toString());
            starter.putExtra("tag", 1);
            startActivityForResult(starter,JoinContestFragment.LETS_PLAY );*/

        } else {
            LoginScreen.start(mContext);
            finishActivity();
        }


    }

    @Override
    public void referralSuccess(ResponseReferralDetails mReferralDetails) {
        hideloader();
       /* if (mReferralDetails.getData().getReferToBonus().equals("0")) {
            mLinearLayoutReferral.setVisibility(View.GONE);
        }else {
            referraltextmessage.setText("₹ "+mReferralDetails.getData().getReferToBonus() +" just a step away");
        }*/
        referraltextmessage.setText("₹ "+mReferralDetails.getData().getReferToBonus() +" just a step away");

    }

    @Override
    public void referralFailure(String errMsg) {

        mLoader.error(errMsg);
        hideloader();
        showSnackBar(errMsg);
    }

    @Override
    public void signUpNotVerify(ResponceSignup mSignUpOutput) {
        hideLoading();

        if (mSignUpOutput.getCaptchaEnable().equalsIgnoreCase("Yes")) {
            captcha();
        } else {
            VerfiMobileOTP.start(mContext, mobileNumber, mSignUpOutput.getData().getSessionKey(), VerfiMobileOTP.REGISTER);

        }
//        VerfiMobileOTP.start(mContext,mobileNumber,mSignUpOutput.getData().getSessionKey(), VerfiMobileOTP.REGISTER);
//        AppSession.getInstance().setLoginSession(responseLogin);
       /* if (alertExitDialog == null)
            alertExitDialog = new AlertDialog(HaveCode.this, mSignUpOutput.getMessage(), AppUtils.getStrFromRes(R.string.okay), "", new AlertDialog.OnBtnClickListener() {
                @Override
                public void onYesClick() {
                    // ResetPasswordActivity.start(getContext());
                    finishActivity();
                }

                @Override
                public void onNoClick() {

                }
            });
        alertExitDialog.show();*/


    }

    @Override
    public void signUpFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void showSnackBar(@NonNull String message) {
        AppUtils.showSnackBar(mContext, coordinator_layout, message);
    }

    @Override
    public void setActivityBackground() {
        // ActivityUtils.setActivityBackground(mContext, R.drawable.app_bg);
    }

    @Override
    public void showloader() {
        mLoader.start();
    }

    @Override
    public void hideloader() {
        mLoader.hide();
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
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LanguageContextWrapper.wrap(newBase, AppSession.getInstance().getLanguage()));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_ID_MULTIPLE_PERMISSIONS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Log.d("REQUEST_ID_MULTIPLE", "permission was granted, yay! Do the\n" +
                            "                    // contacts-related task you need to do.");
                    submitForNext("");
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    Log.d("REQUEST_ID_MULTIPLE", " permission denied, boo! Disable the\n" +
                            "                    // functionality that depends on this permission");

                    submitForNext("");
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*if (requestCode == JoinContestFragment.LETS_PLAY  && resultCode  ==RESULT_OK) {

            setResult(RESULT_OK,getIntent());
            finishActivity();
        }*/
    }

}
