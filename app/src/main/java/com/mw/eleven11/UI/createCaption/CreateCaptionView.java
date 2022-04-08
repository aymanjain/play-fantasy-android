package com.mw.eleven11.UI.createCaption;

import android.content.Context;

import com.mw.eleven11.beanOutput.LoginResponseOut;


/**
 *
 */

public interface CreateCaptionView {
    void showLoading();

    void hideLoading();

    void onSaveSuccess(LoginResponseOut responseLogin);

    void onSaveError(String value);

    void onShowSnackBar(String message);

    boolean isLayoutAdded();

    Context getContext();
}
