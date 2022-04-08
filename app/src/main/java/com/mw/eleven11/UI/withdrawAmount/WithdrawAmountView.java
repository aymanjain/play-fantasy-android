package com.mw.eleven11.UI.withdrawAmount;

import android.content.Context;

import com.mw.eleven11.beanOutput.WithDrawoutput;



/**
 * Created by hp on 06-07-2017.
 */

public interface WithdrawAmountView {
    void showLoading();

    void hideLoading();

    void withDrawSuccess(WithDrawoutput mWithDrawoutput);

    void withDrawFailure(String errMsg);

    void showSnackBar(String message);

    void setActivityBackground();

    Context getContext();

    void finishActivity();
}
