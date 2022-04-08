package com.mw.eleven11.UI.loginRagisterModule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.facebook.FacebookPresenterImpl;
import com.mw.eleven11.UI.facebook.FacebookView;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.outsideEvents.OutSideEvent;
import com.mw.eleven11.UI.verifyOtp.VerfiMobileOTP;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.SingupInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.RequestOtpForSigninOutput;
import com.mw.eleven11.beanOutput.ResponceSignup;


import com.mw.eleven11.beanOutput.ResponseReferralDetails;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomInputEditText;
import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.DataValidationUtils;
import com.mw.eleven11.utility.DeviceUtils;
import com.mw.eleven11.utility.FirebaseUtils;
import com.mw.eleven11.utility.LanguageContextWrapper;
import com.mw.eleven11.utility.PasswordValidator;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class Register extends BaseActivity implements FacebookView, LoginView, SignUpView {

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    private static final String TAG = "LoginScreen";
    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient mGoogleSignInClient;
    private LoginPresenterImpl mLoginPresenterImpl;
    private FacebookPresenterImpl mFacebookPresenterImpl;
    private Context mContext;
    private ProgressDialog mProgressDialog;

    private SignUpPresenterImpl mSignUpPresenterImpl;
    GoogleSignInAccount mGoogleSignInAccount;

    AlertDialog alertExitDialog;

    String source = "";
    String firstNameStr = "";
    String emailStr = "";
    String idStr = "";
    LoginInput mLoginInputData;

    PasswordValidator mPasswordValidator;


    /* Butter Knife : view mapping */
    @BindString(R.string.network_error)
    String mResStringNetworkError;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinator_layout;

    @OnClick(R.id.loginWithfacebook)
    void onloginWithfacebook() {
  /*      if (true){
            Toast.makeText(mContext, R.string.in_progress, Toast.LENGTH_LONG).show();
            return;
        }*/
        mFacebookPresenterImpl.actionFacebookBtn();
    }

    @OnClick(R.id.loginWithGoogle)
    void onloginWithGoogle() {

        signInWithGoogle();
    }


    public static void start(Context context) {
        Intent starter = new Intent(context, Register.class);

        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context, Bundle data) {
        Intent starter = new Intent(context, Register.class);
        starter.putExtra(Constant.KEY_DATA, data);
        context.startActivity(starter);

        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }


    @BindView(R.id.mobileNo)
    CustomEditText mobileNo;

    @BindView(R.id.email)
    CustomEditText email;

    @BindView(R.id.password)
    CustomEditText password;

    @BindView(R.id.pass_check)
    CheckBox pass_check;

    @OnClick(R.id.back)
    void onBackClick() {

        finish();
    }

    @OnClick(R.id.iAgree)
    void oniAgreeClick() {

        OutSideEvent.start(this, "TERMS_CONDITIONS", Constant.TERMS_CONDITIONS_URL);
    }

    // String firstName;
    String mobileNumber;
    String emailText;
    String passwordText;
    String invite_code;
    String deviceId;
    String signupType;
    String deviceToken;
    String deviceType;

    // String offerCodeString;


    @OnClick(R.id.next)
    void onClickNext() {
        if (checkAndRequestPermissions()) {
            // carry on the normal flow, as the case of  permissions  granted.
            submitForNext("");

        }
    }


    @OnClick(R.id.register)
    void onClickRegister() {

        LoginScreen.start(mContext);
        finishActivity();

    }

    @OnClick(R.id.haveAReferralCode)
    void onClickHaveARefrralCode() {
/*
        if (getIntent().hasExtra(Constant.KEY_DATA)) {
            Intent starter = new Intent(mContext, HaveCode.class);
            starter.putExtra(Constant.KEY_DATA, "Done");
            startActivityForResult(starter,JoinContestFragment.LETS_PLAY );
        }else {
            HaveCode.start(mContext);
        }*/
        HaveCode.start(mContext);


    }

    void submitForNext(String tokenResult) {
        tokenResult= "DemoToken";
        // firstName = name.getText().toString().trim();
        mobileNumber = mobileNo.getText().toString().trim();
        emailText = email.getText().toString().trim();
        passwordText = password.getText().toString().trim();

        deviceId = DeviceUtils.getDeviceId(getContext());
        signupType = DeviceUtils.getSignUpType(getContext());
        deviceToken = FirebaseUtils.getToken();
        deviceType = Constant.DEVICE_TYPE;

        // offerCodeString = offerCode.getText().toString();

        if (TextUtils.isEmpty(emailText)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_email));
        } else if (!DataValidationUtils.isValidEmail(emailText)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.invalid_email));
        } else if (TextUtils.isEmpty(passwordText)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_password));
        } else if (DataValidationUtils.isValidPassword(passwordText)) {
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

            SingupInput mSingupInput = new SingupInput();

            mSingupInput.setUserTypeID(Constant.UserTypeID);
            // mSingupInput.setFirstName(firstName);
            mSingupInput.setEmail(emailText);
            mSingupInput.setPassword(passwordText);
            mSingupInput.setPhoneNumber(mobileNumber);
            mSingupInput.setSource(Constant.Direct);
            mSingupInput.setDeviceType(deviceType);
            mSingupInput.setLoginType("Andorid");
            mSingupInput.setRequestType("APP");
            mSingupInput.setResponse(tokenResult);
            if (!tokenResult.isEmpty()) {
                mSingupInput.setResponse(tokenResult);
            }

            mSingupInput.setDeviceGUID(deviceId);
            mSingupInput.setDeviceToken(deviceToken);

            mSignUpPresenterImpl.actionSignUpBtn(mSingupInput);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.register_screen;
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

    @Override
    public void init() {
        //AppUtils.setStatusBarGradiant(this);
        //getWindow().setBackgroundDrawableResource(R.drawable.background);
        getWindow().setBackgroundDrawableResource(R.color.white);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestEmail()
                .build();

        mPasswordValidator = new PasswordValidator();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mContext = this;

        mSignUpPresenterImpl = new SignUpPresenterImpl(this, new UserInteractor());

        mFacebookPresenterImpl = new FacebookPresenterImpl(this);
        mLoginPresenterImpl = new LoginPresenterImpl(this, new UserInteractor());


        pass_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {


                    password.setTransformationMethod(new HideReturnsTransformationMethod());
                } else {

                    password.setTransformationMethod(new PasswordTransformationMethod());

                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
        showSnackBar(errorMsg);
        if (mGoogleSignInAccount != null) {

            signUpService(mGoogleSignInAccount.getDisplayName(), mGoogleSignInAccount.getEmail(), mGoogleSignInAccount.getId(), source);

        } else {

            signUpService(firstNameStr, emailStr, idStr, Constant.Facebook);
        }
    }

    @Override
    public void signUpNotVerify(ResponceSignup mSignUpOutput) {
        hideLoading();

        if (mSignUpOutput.getCaptchaEnable().equalsIgnoreCase("Yes")) {
            captcha();
        } else {
            VerfiMobileOTP.start(mContext, mobileNumber, mSignUpOutput.getData().getSessionKey(), VerfiMobileOTP.REGISTER);

        }


//        AppSession.getInstance().setLoginSession(responseLogin);
        /*if (alertExitDialog == null)
            alertExitDialog = new AlertDialog(Register.this, mSignUpOutput.getMessage(), AppUtils.getStrFromRes(R.string.okay), "", new AlertDialog.OnBtnClickListener() {
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
    public void signUpSuccess(ResponceSignup mSignUpOutput) {
        hideLoading();

        showSnackBar(mSignUpOutput.getMessage());

        Gson gson = new Gson();
        String responceString = AppUtils.gsonToJSON(mSignUpOutput);
        LoginResponseOut mLoginResponseOut = gson.fromJson(responceString, LoginResponseOut.class);

        AppSession.getInstance().setLoginSession(mLoginResponseOut);


        HomeNavigation.start(mContext);
        finishAffinity();


        if (getIntent().hasExtra(Constant.KEY_DATA)) {


           /* Intent starter = new Intent(mContext, PasswordScreen.class);
            starter.putExtra(Constant.KEY_DATA, "Done");
            starter.putExtra("emailMobile", mobileNo.getText().toString());
            starter.putExtra("tag", 1);
            startActivityForResult(starter,JoinContestFragment.LETS_PLAY );*/


        } else {
            // PasswordScreen.start(mContext,mobileNo.getText().toString(),1);
            // finishActivity();
        }

    }

    @Override
    public void referralSuccess(ResponseReferralDetails mReferralDetails) {

    }

    @Override
    public void referralFailure(String errMsg) {

    }

    @Override
    public void signUpFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void loginSuccess(LoginResponseOut responseLogin) {
        hideLoading();


        AppSession.getInstance().setLoginSession(responseLogin);

        HomeNavigation.start(mContext);
        finishActivity();
        //PasswordScreen.start(mContext,emailMobile.getText().toString(),1);
    }

    @Override
    public void otpRecevied(LoginResponseOut responseLogin) {
        //PasswordScreen.start(mContext,emailMobile.getText().toString(),1);
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
    public void facebookFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void facebookSuccess(String id, String firstName, String lastName, String email, String gender) {

        source = Constant.Facebook;

        String deviceId = DeviceUtils.getDeviceId(getContext());
        String deviceToken = FirebaseInstanceId.getInstance().getToken();
        String deviceType = Constant.DEVICE_TYPE;
        String signUpType = DeviceUtils.getSignUpType(getContext());
        firstNameStr = firstName;
        emailStr = email;
        idStr = id;

        mLoginInputData = new LoginInput();
       /* mLoginInput.setSocial_signup_type(AppUtils.getStrFromRes(R.string.FACEBOOK));
        mLoginInput.setName(firstName + " " + lastName);
        mLoginInput.setEmail(email);
        mLoginInput.setSocial_id(id);
        mLoginInput.setSignup_type(signUpType);
        mLoginInput.setDevice_type(deviceType);
        mLoginInput.setDevice_id(deviceId);
        mLoginInput.setDevice_token(deviceToken);*/

        mLoginInputData.setKeyword(email);
        mLoginInputData.setPassword(id);
        mLoginInputData.setSource(Constant.Google);
        mLoginInputData.setDeviceType(deviceType);
        mLoginInputData.setDeviceGUID(deviceId);
        mLoginInputData.setLoginType("Andorid");

        mLoginInputData.setDeviceToken(deviceToken);


        signInServiceFacebook(id, email);
    }


    @Override
    public void socialLoginSuccess(LoginResponseOut responseLogin) {
        // Toast.makeText(mContext, responseLogin.getMessage(), Toast.LENGTH_SHORT).show();

        AppUtils.showToast(mContext, responseLogin.getMessage());

        //AppSession.getInstance().setLoginSession(responseLogin);
        hideLoading();

        if (getIntent().hasExtra(Constant.KEY_DATA)) {

            setResult(RESULT_OK, getIntent());

        } else {
            //GameOptionActivity.start(this);

        }
        finishActivity();

    }

    @Override
    public void socialLoginNotVerify(LoginResponseOut responseLogin) {
        // AppSession.getInstance().setLoginSession(responseLogin);
        hideLoading();
        finishActivity();
    }

    @Override
    public void socialLoginNotAvailable(LoginInput mLoginInput, String errMsg) {
        hideLoading();
        showSnackBar(errMsg);

        Bundle bundle = new Bundle();
        /*bundle.putString("socialSignUpType", socialSignUpType);
        bundle.putString("name", name);
        bundle.putString("email", email);
        bundle.putString("socialId", socialId);
        bundle.putString("signUpType", signUpType);*/

        bundle.putSerializable("mLoginInput", mLoginInput);
        //  SocialSignUpActivity.start(mContext, bundle);
    }

    @Override
    public void socialLoginFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);

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
    public void showloader() {

    }

    @Override
    public void hideloader() {

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mFacebookPresenterImpl.callbackManager != null)
            mFacebookPresenterImpl.callbackManager.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }

       /* if (requestCode == JoinContestFragment.LETS_PLAY  && resultCode  ==RESULT_OK) {

            setResult(RESULT_OK,getIntent());
            finishActivity();
        }*/
    }

    // [START handleSignInResult]
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            mGoogleSignInAccount = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(mGoogleSignInAccount);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }
    // [END handleSignInResult]

    // [START signIn]
    private void signInWithGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void updateUI(@Nullable GoogleSignInAccount account) {
        if (account != null) {
            signInService(account);

            Log.v("GoogleSignInAccount", "getDisplayName:" + account.getDisplayName());
            Log.v("GoogleSignInAccount", "getPhotoUrl:" + account.getPhotoUrl());
            Log.v("GoogleSignInAccount", "getEmail:" + account.getEmail());
            Log.v("GoogleSignInAccount", "getFamilyName:" + account.getFamilyName());
            Log.v("GoogleSignInAccount", "getGivenName:" + account.getGivenName());
            Log.v("GoogleSignInAccount", "getAccount:" + account.getAccount().toString());
            Log.v("GoogleSignInAccount", "getId:" + account.getId());


        } else {

        }
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

        }
    }

    private void signUpService(String firstName, String email, String socialId, String source) {
        String deviceId = DeviceUtils.getDeviceId(getContext());
        String deviceToken = FirebaseUtils.getToken();
        String deviceType = Constant.DEVICE_TYPE;


        SingupInput mSingupInput = new SingupInput();

        mSingupInput.setUserTypeID(Constant.UserTypeID);
        mSingupInput.setFirstName(firstName);
        mSingupInput.setEmail(email);
        mSingupInput.setPassword(socialId);
        mSingupInput.setSource(source);

        mSingupInput.setDeviceType(deviceType);
        mSingupInput.setDeviceGUID(deviceId);
        mSingupInput.setDeviceToken(deviceToken);
        mSingupInput.setSourceGUID(socialId);
        mSingupInput.setLoginType("Andorid");

        mSignUpPresenterImpl.actionSignUpBtn(mSingupInput);
    }

    private void signInService(@Nullable GoogleSignInAccount account) {
        String deviceId = DeviceUtils.getDeviceId(getContext());
        String deviceToken = FirebaseUtils.getToken();
        String deviceType = Constant.DEVICE_TYPE;
        String signUpType = DeviceUtils.getSignUpType(getContext());

        source = Constant.Google;

        LoginInput mLoginInput = new LoginInput();

        mLoginInput.setKeyword(account.getEmail());
        mLoginInput.setPassword(account.getId());
        mLoginInput.setSource(Constant.Google);
        mLoginInput.setDeviceType(deviceType);
        mLoginInput.setDeviceGUID(deviceId);
        mLoginInput.setDeviceToken(deviceToken);
        mLoginInput.setLoginType("Andorid");

        mLoginPresenterImpl.actionLoginBtn(mLoginInput);
    }

    private void signInServiceFacebook(String id, String email) {
        String deviceId = DeviceUtils.getDeviceId(getContext());
        String deviceToken = FirebaseUtils.getToken();
        String deviceType = Constant.DEVICE_TYPE;
        String signUpType = DeviceUtils.getSignUpType(getContext());

        LoginInput mLoginInput = new LoginInput();

        mLoginInput.setKeyword(email);
        mLoginInput.setPassword(id);
        mLoginInput.setSource(Constant.Facebook);
        mLoginInput.setDeviceType(deviceType);
        mLoginInput.setDeviceGUID(deviceId);
        mLoginInput.setLoginType("Andorid");
        mLoginInput.setDeviceToken(deviceToken);

        mLoginPresenterImpl.actionLoginBtn(mLoginInput);
    }
}
