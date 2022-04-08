package com.mw.eleven11.UI.bankVerify;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.UploadImageInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;

import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;


import retrofit2.Call;

/**
 *
 */

public class VerifyBankPresenterImpl implements IVerifyBankPresenter {

    VerifyBankView view;
    IUserInteractor iUserInteractor;
    Call<LoginResponseOut> responseLoginCall;

    public VerifyBankPresenterImpl(VerifyBankView view, IUserInteractor iUserInteractor) {
        this.view = view;
        this.iUserInteractor = iUserInteractor;
    }

    public void actionLoginCancel() {
        if (responseLoginCall != null && !responseLoginCall.isExecuted())
            responseLoginCall.cancel();
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
                    if (view.getContext() != null) {
                        view.onHideLoading();
                        view.onProfileSuccess(responseLogin);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    if (view.getContext() != null) {
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

  /*  @Override
    public void actionVerifyBankBtn(String loginSessionKey, String name, String accountNumber, String ifscCode, String state, String country, String accountFile, String bankName, String branchName) {
        if (!NetworkUtils.isNetworkConnected(view.getContext())) {
            view.hideLoading();
            view.verifyPanFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            view.showLoading();
            iUserInteractor.verifyBank(loginSessionKey, name, accountNumber, ifscCode, state, country, accountFile, bankName, branchName, new IUserInteractor.OnResponseListener() {
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
*/
    @Override
    public void actionCountriesBtn(String userLoginSessionKey) {
        if (!NetworkUtils.isNetworkConnected(view.getContext())) {
            view.onHideLoading();
            view.onCountriesFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            view.onShowLoading();
          /*  iUserInteractor.countries(userLoginSessionKey, new IUserInteractor.OnCountryResponseListener() {
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
