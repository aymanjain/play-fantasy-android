package com.mw.eleven11.UI.loginRagisterModule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
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
import com.mw.eleven11.UI.forgotPassword.ForgotPasswordActivity;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.verifyOtp.VerfiMobileOTP;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.RequestOtpForSigninInput;
import com.mw.eleven11.beanInput.SingupInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.RequestOtpForSigninOutput;
import com.mw.eleven11.beanOutput.ResponceSignup;

import com.mw.eleven11.beanOutput.ResponseReferralDetails;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomInputEditText;
import com.mw.eleven11.customView.CustomRadioButton;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.ActivityUtils;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.DataValidationUtils;
import com.mw.eleven11.utility.DeviceUtils;
import com.mw.eleven11.utility.FirebaseUtils;
import com.mw.eleven11.utility.LanguageContextWrapper;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class LoginScreen extends BaseActivity implements LoginView, FacebookView, SignUpView {

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    private static final String TAG = "LoginScreen";
    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient mGoogleSignInClient;
    private LoginPresenterImpl mLoginPresenterImpl;
    private FacebookPresenterImpl mFacebookPresenterImpl;
    private SignUpPresenterImpl mSignUpPresenterImpl;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    GoogleSignInAccount account;
    AlertDialog alertLogoutDialog;

    LoginInput mLoginInputData;

    /* Butter Knife : view mapping */
    @BindString(R.string.network_error)
    String mResStringNetworkError;

    @BindView(R.id.ll_password_root)
    View passwordRoot;

  /*  @BindView(R.id.view_divider_1)
    View view_divider_1;
*/
    @BindView(R.id.rb_normal)
    CustomRadioButton mCustomRadioButtonNormal;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinator_layout;

   /* @BindView(R.id.notaMemeber)
    CustomTextView notaMemeber;*/

    @BindView(R.id.next)
    CustomTextView next;

/*    @OnClick(R.id.notaMemeber)
    void onRegisterClick() {
        Register.start(mContext);
    }*/

    @OnClick(R.id.register)
    void onRegister() {
        Register.start(mContext);
    }


    @OnClick(R.id.back)
    void onBackClick() {

        finishActivity();
    }

    @OnClick(R.id.forgot_password)
    void onForgot_password() {

        ForgotPasswordActivity.start(mContext);
    }

    String source = "";
    String firstNameStr = "";
    String emailStr = "";
    String idStr = "";

    @OnClick(R.id.loginWithfacebook)
    void onloginWithfacebook() {
        mFacebookPresenterImpl.actionFacebookBtn();
    }

    @OnClick(R.id.loginWithGoogle)
    void onloginWithGoogle() {
        signInWithGoogle();
    }

    @OnClick(R.id.next)
    void onClickNext() {

     /*   if(!DataValidationUtils.isValidEmailMobile(emailMobile.getText().toString())){
            //showSnackBar(getString(R.string.empty_emailMobile));
            AppUtils.showToast(mContext,getString(R.string.empty_emailMobile));
            return;
        }else {
            submitForLogin(emailMobile.getText().toString());
        }

       */
        if (checkAndRequestPermissions()) {
            // carry on the normal flow, as the case of  permissions  granted.
            submitForLogin("");

        }
    }

    @BindView(R.id.emailMobile)
    CustomEditText emailMobile;

    @BindView(R.id.password)
    CustomEditText passwordEt;

    @BindView(R.id.pass_check)
    CheckBox pass_check;


    public void captcha(final int flag){
        SafetyNet.getClient(this).verifyWithRecaptcha(AppConfiguration.SAFETY_NET_API_SITE_KEY)
                .addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                    @Override
                    public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                        Log.d(TAG, "onSuccess");

                        if (!response.getTokenResult().isEmpty()) {

                            // Received captcha token
                            // This token still needs to be validated on the server
                            // using the SECRET key
                            verifyTokenOnServer(response.getTokenResult(), flag);
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




    private void verifyTokenOnServer(String tokenResult, int flag) {
        if (flag==1) {
            submitForLogin(tokenResult);
        }else {
            otpSignInService(emailMobile.getText().toString().trim(), tokenResult);
        }
    }


    void submitForLogin(String tokenResult) {
        String emailMobileText = emailMobile.getText().toString().trim();
        String password = passwordEt.getText().toString().trim();

        if (mCustomRadioButtonNormal.isChecked()) {
            if (emailMobileText.equals("")) {
                AppUtils.showToast(mContext, getString(R.string.empty_emailMobile));
                return;
            } else if (!DataValidationUtils.isValidEmailMobile(emailMobileText)) {
                //showSnackBar(getString(R.string.empty_emailMobile));
                AppUtils.showToast(mContext, getString(R.string.invalid_emailMobile));
                return;
            }
            if (TextUtils.isEmpty(password)) {
                //showSnackBar(getString(R.string.empty_emailMobile));
                AppUtils.showToast(mContext, getString(R.string.empty_password));
                return;
            }

            signInService(emailMobileText, password,tokenResult);

        } else {
            if (emailMobileText.isEmpty()) {
                AppUtils.showToast(mContext, getString(R.string.empty_phone_number));
            } else {
                otpSignInService(emailMobileText, null);
            }
        }

/*
        if (emailMobileText.contains("[a-zA-Z]+") == false && emailMobile.length() == 10) {

            PasswordScreen.start(mContext, emailMobile.getText().toString(), 0);


        } else {
            PasswordScreen.start(mContext, emailMobile.getText().toString(), 0);
        }*/
    }

  /*  void submitForLogin(String email){
        PasswordScreen.start(mContext,email,0);
    }*/


    @Override
    public int getLayout() {
        return R.layout.activity_login_screen;
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginScreen.class);

        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context, String data) {
        Intent starter = new Intent(context, LoginScreen.class);
        starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context, Bundle data) {
        Intent starter = new Intent(context, LoginScreen.class);
        starter.putExtra(Constant.KEY_DATA, data);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @Override
    public void init() {

        //AppUtils.setStatusBarGradiant(this);
        // getWindow().setBackgroundDrawableResource(R.drawable.background);
        getWindow().setBackgroundDrawableResource(R.color.offWhite);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mContext = this;

        ActivityUtils.performActionOnDone(emailMobile, next);//handle action done event of keyboard

        mFacebookPresenterImpl = new FacebookPresenterImpl(this);
        mLoginPresenterImpl = new LoginPresenterImpl(this, new UserInteractor());

        mSignUpPresenterImpl = new SignUpPresenterImpl(this, new UserInteractor());

        pass_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    passwordEt.setTransformationMethod(new HideReturnsTransformationMethod());
                } else {
                    passwordEt.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        mCustomRadioButtonNormal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    next.setText("Log In");
                   //emailMobile.setHint(R.string.hint_email_test);
                    passwordRoot.setVisibility(View.VISIBLE);
                  //  view_divider_1.setVisibility(View.VISIBLE);
                    emailMobile.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                } else {
                    next.setText("Next");
           // emailMobile.setHint("Mobile No");
                   // emailMobile.setHint("");
                  // emailMobile.setHint(R.string.mobile_No);
                    passwordRoot.setVisibility(View.GONE);
                  //  view_divider_1.setVisibility(View.GONE);
                    emailMobile.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_CLASS_PHONE);
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
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();

    }

    @Override
    public void onAccountAvailableForSignUp(String errorMsg) {
        // showSnackBar(errorMsg);
        if (account != null) {
            signUpService(account.getDisplayName(), account.getEmail(), account.getId(), source);

        } else {

            signUpService(firstNameStr, emailStr, idStr, Constant.Facebook);
        }
    }

    @Override
    public void signUpNotVerify(ResponceSignup mSignUpOutput) {
        showSnackBar(mSignUpOutput.getMessage());
        mGoogleSignInClient.signOut();
    }

    @Override
    public void signUpSuccess(ResponceSignup mSignUpOutput) {
        showSnackBar(mSignUpOutput.getMessage());

        Gson gson = new Gson();
        String responceString = AppUtils.gsonToJSON(mSignUpOutput);

        LoginResponseOut mLoginResponseOut = gson.fromJson(responceString, LoginResponseOut.class);
        AppSession.getInstance().setLoginSession(mLoginResponseOut);

        HomeNavigation.start(mContext);
        finishAffinity();
//        finishActivity();

    }

    @Override
    public void referralSuccess(ResponseReferralDetails mReferralDetails) {

    }

    @Override
    public void referralFailure(String errMsg) {

    }

    @Override
    public void signUpFailure(String errMsg) {
        showSnackBar(errMsg);
        mGoogleSignInClient.signOut();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mProgressDialog != null) mProgressDialog.dismiss();
    }

    @Override
    public void loginSuccess(LoginResponseOut responseLogin) {
        hideLoading();
        AppSession.getInstance().setLoginSession(responseLogin);
        showSnackBar(responseLogin.getMessage());

        if (responseLogin.getCaptchaEnable().equalsIgnoreCase("Yes")){
            captcha(1);
        }else {

            if (responseLogin.getData().getPhoneStatus().equalsIgnoreCase("Pending")) {
                VerifyPhoneNumber.start(mContext);
            } else {
                HomeNavigation.start(mContext);
            }
            finishAffinity();
        }

      /*  if (responseLogin.getData().getPhoneStatus().equals("Verified")) {
            SelectModeActivity.start(mContext);
            finishAffinity();
        }else {
         showPopup();
        }*/

    }

    private void showPopup() {
        if (alertLogoutDialog == null) {
            alertLogoutDialog = new AlertDialog(this,
                    "Please verify your mobile number.", AppUtils.getStrFromRes(R.string.okay), AppUtils.getStrFromRes(R.string.cancel), new AlertDialog.OnBtnClickListener() {
                @Override
                public void onYesClick() {
                    VerifyPhoneNumber.start(mContext);
                }

                @Override
                public void onNoClick() {

                }
            });
        }
        alertLogoutDialog.show();
    }

    @Override
    public void otpRecevied(LoginResponseOut responseLogin) {
        PasswordScreen.start(mContext, emailMobile.getText().toString(), 1);

        showSnackBar(responseLogin.getMessage());
    }

    @Override
    public void loginNotVerify(LoginResponseOut responseLogin) {
        mGoogleSignInClient.signOut();
        hideLoading();
        finishActivity();
        showSnackBar(responseLogin.getMessage());
    }

    @Override
    public void loginFailure(String errMsg) {
        mGoogleSignInClient.signOut();
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
        mLoginInputData.setDeviceToken(deviceToken);


        signInServiceFacebook(id, email);
    }


    @Override
    public void socialLoginSuccess(LoginResponseOut responseLogin) {

        //Toast.makeText(mContext, responseLogin.getMessage(), Toast.LENGTH_SHORT).show();

        AppUtils.showToast(mContext, responseLogin.getMessage());

        //  AppSession.getInstance().setLoginSession(responseLogin);

        hideLoading();

        if (getIntent().hasExtra("data")) {
            setResult(RESULT_OK, getIntent());

        } else {
            //GameOptionActivity.start(this);
        }

        finishActivity();

        showSnackBar(responseLogin.getMessage());
    }

    @Override
    public void socialLoginNotVerify(LoginResponseOut responseLogin) {
        //  AppSession.getInstance().setLoginSession(responseLogin);
        hideLoading();
        finishActivity();

        showSnackBar(responseLogin.getMessage());
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

        showSnackBar(errMsg);
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
        if (requestOtpForSigninOutput.getCaptchaEnable().equalsIgnoreCase("Yes")) {
            captcha(2);
        }else {
            VerfiMobileOTP.start(mContext, emailMobile.getText().toString().trim(), "",VerfiMobileOTP.LOGIN);
        }
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
    }

    // [START handleSignInResult]
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
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

                    submitForLogin("");
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    Log.d("REQUEST_ID_MULTIPLE", " permission denied, boo! Disable the\n" +
                            "                    // functionality that depends on this permission");


                    submitForLogin("");
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
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

        mSignUpPresenterImpl.actionSignUpBtn(mSingupInput);
    }

    private void signInService(String email, String password, String tokenResult) {
        String deviceId = DeviceUtils.getDeviceId(getContext());
        String deviceToken = FirebaseUtils.getToken();
        String deviceType = Constant.DEVICE_TYPE;

        LoginInput mLoginInput = new LoginInput();

        mLoginInput.setKeyword(email);
        mLoginInput.setPassword(password);
        mLoginInput.setSource(Constant.Direct);
        mLoginInput.setDeviceType(deviceType);
        mLoginInput.setDeviceGUID(deviceId);
        mLoginInput.setRequestType("APP");
        mLoginInput.setDeviceToken(deviceToken);
        if (!tokenResult.isEmpty()) {
            mLoginInput.setResponse(tokenResult);
        }

           if (TextUtils.isEmpty(mLoginInput.getKeyword())) {
                showSnackBar(AppUtils.getStrFromRes(R.string.empty_email));
            }else if (TextUtils.isEmpty(mLoginInput.getPassword())) {
               showSnackBar(AppUtils.getStrFromRes(R.string.empty_password));
            }else {
               mLoginPresenterImpl.actionLoginBtn(mLoginInput);
            }
    }


    private void otpSignInService(String mobile, String capchResponse) {
        RequestOtpForSigninInput requestOtpForSigninInput = new RequestOtpForSigninInput();
        requestOtpForSigninInput.setPhoneNumber(mobile);
        requestOtpForSigninInput.setSource("Otp");
        if (capchResponse!=null) {
            requestOtpForSigninInput.setResponse(capchResponse);
        }
        mLoginPresenterImpl.actionOtpLoginBtn(requestOtpForSigninInput);
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

        if (TextUtils.isEmpty(mLoginInput.getKeyword())) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_email));
        }else if (TextUtils.isEmpty(mLoginInput.getPassword())) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_password));
        }else {
            mLoginPresenterImpl.actionLoginBtn(mLoginInput);
        }

       // mLoginPresenterImpl.actionLoginBtn(mLoginInput);
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
        mLoginInput.setDeviceToken(deviceToken);

        if (TextUtils.isEmpty(mLoginInput.getKeyword())) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_email));
        }else if (TextUtils.isEmpty(mLoginInput.getPassword())) {
            showSnackBar(AppUtils.getStrFromRes(R.string.empty_password));
        }else {
            mLoginPresenterImpl.actionLoginBtn(mLoginInput);
        }
//        mLoginPresenterImpl.actionLoginBtn(mLoginInput);
    }
}
