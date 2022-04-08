package com.mw.eleven11.UI.panVerify;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.UploadImageInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.ResponseCountries;

import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;


import retrofit2.Call;

/**
 *
 */

public class VerifyPanPresenterImpl implements IVerifyPanPresenter {

    VerifyPanView view;
    IUserInteractor iUserInteractor;
    Call<LoginResponseOut> responseLoginCall;
    Call<ResponseCountries> country;

    public VerifyPanPresenterImpl(VerifyPanView view, IUserInteractor iUserInteractor) {
        this.view = view;
        this.iUserInteractor = iUserInteractor;
    }

    public void actionLoginCancel() {
        if (responseLoginCall != null && !responseLoginCall.isExecuted())
            responseLoginCall.cancel();
    }

    public void actionCountryCancel() {
        if (country != null && !country.isExecuted())
            country.cancel();
    }

    @Override
    public void actionViewProfile(LoginInput loginInput) {
        actionLoginCancel();
        if (!NetworkUtils.isNetworkConnected(view.getContext())) {
            view.onHideLoading();
            view.onProfileFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            view.onShowLoading();
            responseLoginCall = iUserInteractor.viewProfile(loginInput, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut responseLogin) {
                    if (view.getContext() != null&&responseLoginCall!=null&&!responseLoginCall.isCanceled()) {
                        view.onHideLoading();
                        view.onProfileSuccess(responseLogin);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    if (view.getContext() != null&&responseLoginCall!=null&&!responseLoginCall.isCanceled()) {
                        view.onHideLoading();
                        view.onProfileFailure(errorMsg);
                    }
                }
            });
        }
    }

    @Override
    public void uploadImage(UploadImageInput uploadImageInput) {
        if (!NetworkUtils.isNetworkConnected(view.getContext())) {
            view.hideLoading();
            view.verifyPanFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            view.showLoading();
            iUserInteractor.uploadImage(uploadImageInput, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut responseLogin) {
                    if (responseLogin != null) {
                        view.hideLoading();
                        view.verifyPanSuccess(responseLogin);
                    } else {
                        view.hideLoading();
                        view.verifyPanFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    view.hideLoading();
                    view.verifyPanFailure(errorMsg);
                }

            });
        }
    }



    @Override
    public void actionCountriesBtn(String userLoginSessionKey) {
        actionCountryCancel();
        if (!NetworkUtils.isNetworkConnected(view.getContext())) {
            view.onHideLoading();
            view.onCountriesFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            view.onShowLoading();
            /*country = iUserInteractor.countries(userLoginSessionKey, new IUserInteractor.OnCountryResponseListener() {
                @Override
                public void onSuccess(ResponseCountries responseLogin) {
                    if (responseLogin != null) {
                        view.onHideLoading();
                        view.onCountriesSuccess(responseLogin);
                    } else {
                        view.onHideLoading();
                        view.onCountriesFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    view.onHideLoading();
                    view.onCountriesFailure(errorMsg);
                }

            });*/
        }
    }

    @Override
    public void actionStatesBtn(String userLoginSessionKey, String countryId) {
        if (!NetworkUtils.isNetworkConnected(view.getContext())) {
            view.hideLoading();
            view.onStatesFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            view.showLoading();
           /* iUserInteractor.states(userLoginSessionKey, countryId, new IUserInteractor.OnCountryResponseListener() {
                @Override
                public void onSuccess(ResponseCountries responseLogin) {
                    if (responseLogin != null) {
                        view.hideLoading();
                        view.onStatesSuccess(responseLogin);
                    } else {
                        view.hideLoading();
                        view.onStatesFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    view.hideLoading();
                    view.onStatesFailure(errorMsg);
                }

            });*/
        }
    }
}
