package com.mw.eleven11.UI.player;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.PlayerFantasyStatsInput;
import com.mw.eleven11.beanOutput.ResponsePlayerFantasyStats;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;

import retrofit2.Call;

public class PlayerActivityPresenterImpl implements PlayerActivityPresenter {

    PlayerActivityView mPlayerActivityView;
    IUserInteractor mIUserInteractor;
    Call<ResponsePlayerFantasyStats> responsePlayerFantasyStats;

    public PlayerActivityPresenterImpl(PlayerActivityView mPlayerActivityView, IUserInteractor mIUserInteractor) {
        this.mPlayerActivityView = mPlayerActivityView;
        this.mIUserInteractor = mIUserInteractor;
    }

    public void actionLoginCancel() {
        if (responsePlayerFantasyStats != null && !responsePlayerFantasyStats.isExecuted())
            responsePlayerFantasyStats.cancel();
    }


    @Override
    public void actionPlayerStats(PlayerFantasyStatsInput mPlayerFantasyStatsInput) {

        if (!NetworkUtils.isNetworkConnected(mPlayerActivityView.getContext())) {
            mPlayerActivityView.hideLoading();
            mPlayerActivityView.onPlayerStatsFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mPlayerActivityView.showLoading();
            responsePlayerFantasyStats = mIUserInteractor.playerFantasyStats(mPlayerFantasyStatsInput, new IUserInteractor.OnPlayerFantasyStatsListener() {
                @Override
                public void onSuccess(ResponsePlayerFantasyStats responseLogin) {
                    mPlayerActivityView.hideLoading();
                    mPlayerActivityView.onPlayerStatsSuccess(responseLogin);
                }
                @Override
                public void onError(String errorMsg) {
                    mPlayerActivityView.hideLoading();
                    mPlayerActivityView.onPlayerStatsFailure(errorMsg);

                }

            });
        }


    }
}
