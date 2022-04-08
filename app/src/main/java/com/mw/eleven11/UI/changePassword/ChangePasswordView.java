package com.mw.eleven11.UI.changePassword;

import android.content.Context;

import com.mw.eleven11.beanOutput.LoginResponseOut;


public interface ChangePasswordView {

    void showLoading();

    void hideLoading();

    void loginSuccess(LoginResponseOut responseChangePassword);

    void loginFailure(String errMsg);

    void showSnackBar(String message);

    Context getContext();

}
