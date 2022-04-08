package com.mw.eleven11.fcm;

import android.content.Context;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;

public interface View {

    void showLoading();

    void hideLoading();

    void onMatchSuccess(MatchDetailOutPut responseLogin);

    void onMatchFailure(String errMsg);

    Context getContext();
}
