package com.mw.eleven11.UI.userProfile;

import android.content.Context;

import com.mw.eleven11.beanOutput.LoginResponseOut;


/**
 *
 */

public interface MyProfileParentView {

    boolean isAttached();

    void showLoading();

    void hideLoading();

    void onProfileSuccess(LoginResponseOut responseLogin);

    void onProfileFailure(String errMsg);

    void onSetProfilePicture(String value);








    Context getContext();


}
