package com.mw.eleven11.UI.facebook;

import android.content.Context;

/**
 * Created by hp on 06-07-2017.
 */

public interface FacebookView {
    void showLoading();

    void hideLoading();

    void facebookSuccess(String id, String firstName, String lastName, String email, String gender);

    void facebookFailure(String errMsg);

    void showSnackBar(String message);

    Context getContext();

    void finishActivity();
}
