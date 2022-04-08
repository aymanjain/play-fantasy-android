package com.mw.eleven11.UI.personalDetails;

import android.content.Context;

import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.ResponseCountries;
import com.mw.eleven11.beanOutput.ResponseUpdateProfile;



public interface PersonalDetailsView {

    void showLoading();

    void hideLoading();

    void onProfileSuccess(LoginResponseOut responseLogin);

    void onProfileFailure(String errMsg);

    void onStatesSuccess(ResponseCountries responseCountries);

    void onStatesFailure(String errMsg);

    void showSnackBar(String message);

    void onUpdateSuccess(ResponseUpdateProfile updateProfile);

    void onUpdateFailure(String errMsg);

    Context getContext();
}
