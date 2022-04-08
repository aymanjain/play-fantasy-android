package com.mw.eleven11.UI.forgotPassword;

import android.content.Context;

import com.mw.eleven11.beanOutput.ForgetPasswordOut;


/**
 * Created by hp on 06-07-2017.
 */

public interface ForgotPasswordView {
    void showLoading();

    void hideLoading();

    void forgotPasswordSuccess(ForgetPasswordOut responseLogin);

    void forgotPasswordFailure(String errMsg);

    void showSnackBar(String message);

    void setActivityBackground();

    Context getContext();

    void finishActivity();
}
