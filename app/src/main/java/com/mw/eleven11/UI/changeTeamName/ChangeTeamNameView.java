package com.mw.eleven11.UI.changeTeamName;

import android.content.Context;

import com.mw.eleven11.beanOutput.ResponseUpdateProfile;



/**
 * Created by hp on 06-07-2017.
 */

public interface ChangeTeamNameView {
    void showLoading();

    void hideLoading();



    void showSnackBar(String message);

    void onUpdateSuccess(ResponseUpdateProfile updateProfile);

    void onUpdateFailure(String errMsg);

    Context getContext();
}
