package com.mw.eleven11.UI.matchControlet;


import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;


import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class MatchDetailPresenterImpl implements IMatchDetailPresenter {

    MatchInfoView mMyAccountParentView;
    IUserInteractor mImyAccountParentInteractor;
    Call<MatchDetailOutPut> matchDetailCall;


    public MatchDetailPresenterImpl(MatchInfoView mView, IUserInteractor mInteractor) {
        this.mMyAccountParentView = mView;
        this.mImyAccountParentInteractor = mInteractor;
    }

    @Override
    public void actionMatchdetail(MatchDetailInput matchDetailInput) {

        if (!NetworkUtils.isNetworkConnected(mMyAccountParentView.getContext())) {
            mMyAccountParentView.hideLoading();
            mMyAccountParentView.onMatchFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mMyAccountParentView.showLoading();
            matchDetailCall = mImyAccountParentInteractor.matchDetail(matchDetailInput, new IUserInteractor.OnResponseMatchDetailsListener() {
                @Override
                public void onSuccess(MatchDetailOutPut responseLogin) {

                        mMyAccountParentView.onMatchSuccess(responseLogin);
                        mMyAccountParentView.hideLoading();

                }

                @Override
                public void onError(String errorMsg) {

                        mMyAccountParentView.onMatchFailure(errorMsg);
                        mMyAccountParentView.hideLoading();

                }

            });
        }
    }




}