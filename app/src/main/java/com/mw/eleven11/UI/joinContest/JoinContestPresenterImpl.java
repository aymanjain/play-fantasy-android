package com.mw.eleven11.UI.joinContest;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.JoinContestInput;
import com.mw.eleven11.beanInput.WalletInput;

import com.mw.eleven11.beanOutput.JoinContestOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.WalletOutputBean;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;


import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class JoinContestPresenterImpl implements IJoinContestPresenter {

    JoinContestView mMyAccountParentView;
    IUserInteractor mImyAccountParentInteractor;
    Call<WalletOutputBean> responseLoginCall;
    Call<LoginResponseOut> responseLoginJoin;

    public JoinContestPresenterImpl(JoinContestView mMyAccountParentView, IUserInteractor mImyAccountParentInteractor) {
        this.mMyAccountParentView = mMyAccountParentView;
        this.mImyAccountParentInteractor = mImyAccountParentInteractor;
    }

    public void actionLoginCancel() {
        if (responseLoginCall != null && !responseLoginCall.isExecuted())
            responseLoginCall.cancel();
    }

    @Override
    public void actionViewAccount(WalletInput mWalletInput) {
        actionLoginCancel();
        if (!NetworkUtils.isNetworkConnected(mMyAccountParentView.getContext())) {
            mMyAccountParentView.hideLoading();
            mMyAccountParentView.onAccountFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mMyAccountParentView.showLoading();
            responseLoginCall = mImyAccountParentInteractor.viewAccount(mWalletInput, new IUserInteractor.OnResponseAccountListener() {
                @Override
                public void onSuccess(WalletOutputBean mResponseAccount) {
                    mMyAccountParentView.hideLoading();
                    if (mMyAccountParentView.isAttached()) {
                        mMyAccountParentView.hideLoading();
                        mMyAccountParentView.onAccountSuccess(mResponseAccount);
                    }

                }

                @Override
                public void onError(String errorMsg) {
                    mMyAccountParentView.hideLoading();
                    if (mMyAccountParentView.isAttached()) {
                        mMyAccountParentView.hideLoading();
                        mMyAccountParentView.onAccountFailure(errorMsg);
                    }
                }

            });
        }}

    @Override
    public void actionJoinContest(JoinContestInput mJoinContestInput) {
          if (!NetworkUtils.isNetworkConnected(mMyAccountParentView.getContext())) {
            mMyAccountParentView.onHideLoading();
            mMyAccountParentView.onJoinFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mMyAccountParentView.onShowLoading();
            mImyAccountParentInteractor.joinContest(mJoinContestInput, new IUserInteractor.OnResponseJoinListener() {
                @Override
                public void onSuccess(JoinContestOutput responseLogin) {
                    mMyAccountParentView.onHideLoading();
                    if (responseLogin != null) {
                        mMyAccountParentView.onJoinSuccess(responseLogin);
                    } else {

                        mMyAccountParentView.onJoinFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onNotFound(String error) {
                    mMyAccountParentView.onHideLoading();
                    mMyAccountParentView.onJoinNotFound(error);
                }

                @Override
                public void onError(String errorMsg) {
                    mMyAccountParentView.onHideLoading();
                    mMyAccountParentView.onJoinFailure(errorMsg);
                }

            });
        }
    }









    public void actionListingCancel() {
        if (responseLoginJoin != null && !responseLoginJoin.isExecuted())
            responseLoginJoin.cancel();
    }

}
