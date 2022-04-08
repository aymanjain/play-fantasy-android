package com.mw.eleven11.UI.matchControlet;

import android.content.Context;

import com.mw.eleven11.beanOutput.MatchDetailOutPut;



/**
 *
 */

public interface MatchInfoView {

    void showLoading();

    void hideLoading();

    void onMatchSuccess(MatchDetailOutPut responseLogin);

    void onMatchFailure(String errMsg);

    Context getContext();



}
