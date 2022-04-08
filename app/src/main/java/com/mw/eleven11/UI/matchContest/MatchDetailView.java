package com.mw.eleven11.UI.matchContest;

import android.content.Context;

import com.mw.eleven11.beanOutput.MatchContestOutPut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;


/**
 *
 */

public interface MatchDetailView {

    void showLoading();

    void hideLoading();

    void onMatchSuccess(MatchDetailOutPut responseLogin);

    void onMatchFailure(String errMsg);

    void onMatchContestSuccess(MatchContestOutPut responseLogin);

    void onMatchContestFailure(String errMsg);

    boolean isAttached();

    Context getContext();


}
