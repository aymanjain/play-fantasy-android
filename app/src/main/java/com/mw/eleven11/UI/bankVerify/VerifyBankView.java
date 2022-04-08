package com.mw.eleven11.UI.bankVerify;

import android.content.Context;

import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.ResponseCountries;


/**
 * Created by hp on 06-07-2017.
 */

public interface VerifyBankView {
    void showLoading();

    void hideLoading();

    void verifyPanSuccess(LoginResponseOut responseLogin);

    void verifyPanFailure(String errMsg);

    void onProfileSuccess(LoginResponseOut responseLogin);

    void onProfileFailure(String errMsg);

    void onShowLoading();

    void onHideLoading();

    void onCountriesSuccess(ResponseCountries responseCountries);

    void onCountriesFailure(String errMsg);

    void onStatesSuccess(ResponseCountries responseCountries);

    void onStatesFailure(String errMsg);

    void showSnackBar(String message);

    Context getContext();
}
