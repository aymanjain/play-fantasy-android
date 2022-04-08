package com.mw.eleven11.UI.changeUserAvatar;

import android.content.Context;

import com.mw.eleven11.beanOutput.AvatarListOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.ResponseUpdateProfile;


/**
 *
 */

public interface UserAvatarView {
    void showLoading();

    void hideLoading();

    void showUpdateLoading();

    void hideUpdateLoading();

    void onSuccess(AvatarListOutput responseLogin);

    void onAvatarUpdated(LoginResponseOut responseLogin);
    void onUpdateSuccess(ResponseUpdateProfile updateProfile);

    void onError(String message);

    void onFailed(String message);

    void onShowSnackBar(String message);

    Context getContext();

    void finishActivity();
}
