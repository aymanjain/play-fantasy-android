package com.mw.eleven11.UI.favoriteTeam;


import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.FavoriteTeamInput;
import com.mw.eleven11.beanInput.MakeFavoriteTeamInput;
import com.mw.eleven11.beanOutput.DefaultRespose;
import com.mw.eleven11.beanOutput.ResponseFavoriteTeam;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;

import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class FavoriteTeamPresenterImpl implements FavoriteTeamPresenter {

    FavoriteTeamView mView;
    IUserInteractor mImyProfileParentInteractor;
    Call<ResponseFavoriteTeam> responseLoginCall;
    Call<DefaultRespose> resposeCall;

    public FavoriteTeamPresenterImpl(FavoriteTeamView mView, IUserInteractor mImyProfileParentInteractor) {
        this.mView = mView;
        this.mImyProfileParentInteractor = mImyProfileParentInteractor;
    }

    public void actionLoginCancel() {
        if (responseLoginCall != null && !responseLoginCall.isExecuted())
            responseLoginCall.cancel();
    }


    @Override
    public void actionfavoriteTeamList(FavoriteTeamInput mFavoriteTeamInput) {

        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            mView.hideLoading();
            mView.onFavoriteTeamFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mView.showLoading();
            responseLoginCall = mImyProfileParentInteractor.getFavoriteTeam(mFavoriteTeamInput, new IUserInteractor.OnGetFavoriteTeamListener() {
                @Override
                public void onSuccess(ResponseFavoriteTeam responseLogin) {

                    mView.onGetFavoriteTeamSuccess(responseLogin);
                }

                @Override
                public void onError(String errorMsg) {

                    mView.onFavoriteTeamFailure(errorMsg);

                }

            });
        }

    }

    @Override
    public void actionMakefavoriteTeamList(MakeFavoriteTeamInput mFavoriteTeamInput) {

        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            mView.hideLoading();
            mView.onMakeFavoriteTeamFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mView.showLoading();
            resposeCall = mImyProfileParentInteractor.makeFavoriteTeams(mFavoriteTeamInput, new IUserInteractor.OnMakeFavoriteTeamListener() {
                @Override
                public void onSuccess(DefaultRespose responseLogin) {

                    mView.onMakeFavoriteTeamSuccess(responseLogin);
                }

                @Override
                public void onError(String errorMsg) {

                    mView.onMakeFavoriteTeamFailure(errorMsg);

                }

            });
        }
    }
}
