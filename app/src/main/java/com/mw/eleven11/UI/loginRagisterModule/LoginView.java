package com.mw.eleven11.UI.loginRagisterModule;

import android.content.Context;

import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.RequestOtpForSigninOutput;


public interface LoginView {
    void showLoading();

    void hideLoading();

    void onAccountAvailableForSignUp(String errorMsg);

    void loginSuccess(LoginResponseOut responseLogin);

    void otpRecevied(LoginResponseOut responseLogin);

    void loginFailure(String errMsg);

    void loginNotVerify(LoginResponseOut responseLogin);

    void socialLoginSuccess(LoginResponseOut responseLogin);

    void socialLoginFailure(String errMsg);

    void socialLoginNotVerify(LoginResponseOut responseLogin);

    void socialLoginNotAvailable(LoginInput mLoginInput, String errorMsg);

    void showSnackBar(String message);

    void setActivityBackground();

    Context getContext();

    void finishActivity();

    void loginOtpSuccess(RequestOtpForSigninOutput requestOtpForSigninOutput);
}
