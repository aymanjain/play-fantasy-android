package com.mw.eleven11.UI.myAccount;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.WalletInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.WalletOutputBean;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;


import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class MyAccountParentPresenterImpl implements IMyAccountParentPresenter {

    MyAccountParentView mMyAccountParentView;
    IUserInteractor mImyAccountParentInteractor;
    Call<WalletOutputBean> responseLoginCall;
    Call<LoginResponseOut> responseProfileCall;

    public MyAccountParentPresenterImpl(MyAccountParentView mMyAccountParentView, IUserInteractor mImyAccountParentInteractor) {
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
                    if (mMyAccountParentView.isAttached()) {
                        mMyAccountParentView.hideLoading();
                        mMyAccountParentView.onAccountSuccess(mResponseAccount);
                    }

                }

                @Override
                public void onError(String errorMsg) {
                    if (mMyAccountParentView.isAttached()) {
                        mMyAccountParentView.hideLoading();
                        mMyAccountParentView.onAccountFailure(errorMsg);
                    }
                }

            });
        }
    }


}
