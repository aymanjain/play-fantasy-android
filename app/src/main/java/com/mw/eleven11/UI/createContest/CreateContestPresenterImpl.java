package com.mw.eleven11.UI.createContest;


import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.CreateContestInput;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.WinnerBreakupInput;
import com.mw.eleven11.beanOutput.CreateContestOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.WinBreakupOutPut;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;

import retrofit2.Call;


/**
 *
 */

public class CreateContestPresenterImpl implements ICreateContestPresenter {

    CreateContestView view;
    IUserInteractor iUserInteractor;

    Call<LoginResponseOut> responseLoginCall;

    public CreateContestPresenterImpl(CreateContestView view, IUserInteractor iUserInteractor) {
        this.view = view;
        this.iUserInteractor = iUserInteractor;
    }

    @Override
    public void actionCreateContestBtn(CreateContestInput createContestInput) {
        if (!NetworkUtils.isNetworkConnected(view.getContext())) {
            view.hideLoading();
            view.createContestFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            view.showLoading();
            iUserInteractor.createContest(createContestInput, new IUserInteractor.OnResponseCreateContestListener() {
                        @Override
                        public void onSuccess(CreateContestOutput responseLogin) {
                            if (responseLogin != null) {
                                view.createContestSuccess(responseLogin);
                            } else {
                                view.hideLoading();
                                view.createContestFailure(Constant.NULL_DATA_MESSAGE);
                            }
                        }

                        @Override
                        public void onError(String errorMsg) {
                            view.hideLoading();
                            view.createContestFailure(errorMsg);
                        }

                    });
        }
    }

    @Override
    public void winning_breakup(WinnerBreakupInput mWinnerBreakupInput) {
        if (!NetworkUtils.isNetworkConnected(view.getContext())) {
            view.hideLoading();
            view.createContestFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            view.showLoading();
            iUserInteractor.winning_breakup(mWinnerBreakupInput, new IUserInteractor.OnResponseWinBreakUpListener() {
                @Override
                public void onSuccess(WinBreakupOutPut responseLogin) {
                    if (responseLogin != null) {
                        view.hideLoading();
                        view.winBreakupSuccess(responseLogin);
                    } else {
                        view.hideLoading();
                        view.winBreakupFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    view.hideLoading();
                    view.createContestFailure(errorMsg);
                }

            });
        }
    }

    @Override
    public void actionViewProfile(LoginInput mLoginInput) {
        if (!NetworkUtils.isNetworkConnected(view.getContext())) {
            view.hideLoading();
            view.onProfileFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            view.showLoading();
            responseLoginCall = iUserInteractor.viewProfile(mLoginInput, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut responseLogin) {

                    view.onProfileSuccess(responseLogin);


                }

                @Override
                public void onError(String errorMsg) {

                    view.onProfileFailure(errorMsg);

                }

            });
        }
    }


}
