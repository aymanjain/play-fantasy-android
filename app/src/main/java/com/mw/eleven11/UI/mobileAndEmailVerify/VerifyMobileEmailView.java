package com.mw.eleven11.UI.mobileAndEmailVerify;

import android.content.Context;

import com.mw.eleven11.beanOutput.LoginResponseOut;



/**
 * Created by hp on 06-07-2017.
 */

public interface VerifyMobileEmailView {
    void showLoading();

    void hideLoading();

    void verifyEmailSuccess(LoginResponseOut responseLogin);

    void verifyEmailFailure(String errMsg);

    void verifyMobileSuccess(LoginResponseOut responseLogin);

    void verifyMobileFailure(String errMsg);

    void onProfileSuccess(LoginResponseOut responseLogin);

    void onProfileFailure(String errMsg);

    void onShowLoading();

    void onHideLoading();

    void showSnackBar(String message);

    Context getContext();

    void setEmail(String value);

    void setMobile(String value);
}
