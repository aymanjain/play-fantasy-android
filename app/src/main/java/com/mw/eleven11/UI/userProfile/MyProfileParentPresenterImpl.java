package com.mw.eleven11.UI.userProfile;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;


import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class MyProfileParentPresenterImpl implements IMyProfileParentPresenter {

    MyProfileParentView mMyProfileParentView;
    IUserInteractor mImyProfileParentInteractor;

    public MyProfileParentPresenterImpl(MyProfileParentView mMyProfileParentView, IUserInteractor mImyProfileParentInteractor) {
        this.mMyProfileParentView = mMyProfileParentView;
        this.mImyProfileParentInteractor = mImyProfileParentInteractor;
    }

    Call<LoginResponseOut> responseLoginCall;

    public void actionLoginCancel() {
        if (responseLoginCall != null && !responseLoginCall.isExecuted())
            responseLoginCall.cancel();
    }

    @Override
    public void actionViewProfile(LoginInput mLoginInput) {
        actionLoginCancel();
        if (!NetworkUtils.isNetworkConnected(mMyProfileParentView.getContext())) {
            mMyProfileParentView.hideLoading();
            mMyProfileParentView.onProfileFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mMyProfileParentView.showLoading();
            responseLoginCall = mImyProfileParentInteractor.viewProfile(mLoginInput, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut responseLogin) {
                    if (mMyProfileParentView.isAttached()) {
                        mMyProfileParentView.onProfileSuccess(responseLogin);
                    }

                }

                @Override
                public void onError(String errorMsg) {
                    if (mMyProfileParentView.isAttached()) {
                        mMyProfileParentView.onProfileFailure(errorMsg);
                    }
                }

            });
        }
    }

    @Override
    public void actionUploadUserImage(String userLoginSessionKey, final String filePath) {

    }
}
