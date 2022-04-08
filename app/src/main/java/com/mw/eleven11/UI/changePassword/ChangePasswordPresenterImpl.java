package com.mw.eleven11.UI.changePassword;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.ChangePasswordInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;


public class ChangePasswordPresenterImpl implements ChangePasswordPresenter {

    ChangePasswordView mChangePasswordView;
    IUserInteractor mIUserInteractor;

    public ChangePasswordPresenterImpl(ChangePasswordView mChangePasswordView, IUserInteractor mIUserInteractor) {
        this.mChangePasswordView = mChangePasswordView;
        this.mIUserInteractor = mIUserInteractor;
    }

    @Override
    public void submitAction(final ChangePasswordInput mChangePasswordInput) {
        if (!NetworkUtils.isNetworkConnected(mChangePasswordView.getContext())) {
            mChangePasswordView.hideLoading();
            mChangePasswordView.loginFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mChangePasswordView.showLoading();
            mIUserInteractor.changePassword(mChangePasswordInput, new IUserInteractor.OnResponseListener() {
                        @Override
                        public void onSuccess(LoginResponseOut responseLogin) {
                            if (responseLogin != null) {
                                mChangePasswordView.loginSuccess(responseLogin);
                            } else {
                                mChangePasswordView.hideLoading();
                                mChangePasswordView.loginFailure(Constant.NULL_DATA_MESSAGE);
                            }
                        }

                        @Override
                        public void onError(String errorMsg) {
                            mChangePasswordView.hideLoading();
                            mChangePasswordView.loginFailure(errorMsg);
                        }

                    });
        }

    }
}
