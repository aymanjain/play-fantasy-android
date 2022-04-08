package com.mw.eleven11.UI.player;

import android.content.Context;

import com.mw.eleven11.beanOutput.ResponsePlayerFantasyStats;

public interface PlayerActivityView {

    void showLoading();

    void hideLoading();

    void onPlayerStatsSuccess(ResponsePlayerFantasyStats responseLogin);

    void onPlayerStatsFailure(String errMsg);

    void showSnackBar(String message);

    Context getContext();
}
