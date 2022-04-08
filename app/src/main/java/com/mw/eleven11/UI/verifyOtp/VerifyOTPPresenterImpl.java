package com.mw.eleven11.UI.verifyOtp;

import android.text.TextUtils;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.RequestOtpForSigninInput;
import com.mw.eleven11.beanInput.VerifyMobileInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;

import com.mw.eleven11.beanOutput.RequestOtpForSigninOutput;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.DataValidationUtils;
import com.mw.eleven11.utility.NetworkUtils;

/**
 *
 */

public class VerifyOTPPresenterImpl implements IVerifyOTPPresenter {

    VerifyOTPView mVerifyOTP;
    IUserInteractor mIUserInteractor;

    public VerifyOTPPresenterImpl(VerifyOTPView mVerifyOTP, IUserInteractor mIUserInteractor) {
        this.mVerifyOTP = mVerifyOTP;
        this.mIUserInteractor = mIUserInteractor;
    }


    @Override
    public void reSendMobileOtp(VerifyMobileInput mobileInput) {
        if (!NetworkUtils.isNetworkConnected(mVerifyOTP.getContext())) {
            mVerifyOTP.hideLoading();
            mVerifyOTP.resendAccountVerificationCodeFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mVerifyOTP.showLoading();
            mIUserInteractor.resendverify(mobileInput, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut responseLogin) {
                    if (responseLogin != null) {
                        mVerifyOTP.resendAccountVerificationCodeSuccess(responseLogin);
                    } else {
                        mVerifyOTP.hideLoading();
                        mVerifyOTP.resendAccountVerificationCodeFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    mVerifyOTP.hideLoading();
                    mVerifyOTP.resendAccountVerificationCodeFailure(errorMsg);
                }

            });
        }
    }

    @Override
    public void verifyMobileOtp(VerifyMobileInput mobileInput) {
        if (!NetworkUtils.isNetworkConnected(mVerifyOTP.getContext())) {
            mVerifyOTP.hideLoading();
            mVerifyOTP.verifyAccountFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mVerifyOTP.showLoading();
            mIUserInteractor.verifyPhoneNumber( mobileInput,new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut responseLogin) {
                    if (responseLogin != null) {
                        mVerifyOTP.hideLoading();
                        mVerifyOTP.verifyAccountSuccess(responseLogin);
                    } else {
                        mVerifyOTP.hideLoading();
                        mVerifyOTP.verifyAccountFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }
                @Override
                public void onError(String errorMsg) {
                    mVerifyOTP.hideLoading();
                    mVerifyOTP.verifyAccountFailure(errorMsg);
                }

            });
        }
    }

    @Override
    public void actionSendEmailCodeBtn(VerifyMobileInput mobileInput) {
        if (!NetworkUtils.isNetworkConnected(mVerifyOTP.getContext())) {
            mVerifyOTP.hideLoading();
            mVerifyOTP.verifyEmailFailure(AppUtils.getStrFromRes(R.string.network_error));
        }else if (mobileInput.getEmail().equals("")){
            mVerifyOTP.hideLoading();
            mVerifyOTP.verifyEmailFailure(AppUtils.getStrFromRes(R.string.empty_email));
        }else if (!DataValidationUtils.isValidEmail(mobileInput.getEmail())){
            mVerifyOTP.hideLoading();
            mVerifyOTP.verifyEmailFailure(AppUtils.getStrFromRes(R.string.invalid_email));
        } else {
            mVerifyOTP.showLoading();
            mIUserInteractor.sendMobileOtp(mobileInput, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut loginResponseOut) {
                    if (loginResponseOut != null) {
                        mVerifyOTP.hideLoading();
                        mVerifyOTP.verifyEmailSuccess(loginResponseOut);
                    } else {
                        mVerifyOTP.hideLoading();
                        mVerifyOTP.verifyEmailFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    mVerifyOTP.hideLoading();
                    mVerifyOTP.verifyEmailFailure(errorMsg);
                }

            });
        }
    }

    @Override
    public void actionLoginBtn(LoginInput mLoginInput) {
        if (!NetworkUtils.isNetworkConnected(mVerifyOTP.getContext())) {
            mVerifyOTP.hideLoading();
            mVerifyOTP.loginFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mVerifyOTP.showLoading();
            mIUserInteractor.login(mLoginInput, new IUserInteractor.OnLoginResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut responseLogin) {
                    mVerifyOTP.loginSuccess(responseLogin);
                }

                @Override
                public void onAccountNotVerify(LoginResponseOut user) {
                    mVerifyOTP.loginNotVerify(user);
                }

                @Override
                public void onOTPRecevied(LoginResponseOut user) {
                    mVerifyOTP.otpRecevied(user);
                }

                @Override
                public void onAccountAvailableForSignUp(String errorMsg) {

                    mVerifyOTP.onAccountAvailableForSignUp(errorMsg);

                }

                @Override
                public void onError(String errorMsg) {
                    mVerifyOTP.loginFailure(errorMsg);
                }
            });
        }

    }

    @Override
    public void actionOtpLoginBtn(RequestOtpForSigninInput requestOtpForSigninInput) {

        if (!NetworkUtils.isNetworkConnected(mVerifyOTP.getContext())) {
            mVerifyOTP.hideLoading();
            mVerifyOTP.loginFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mVerifyOTP.showLoading();
            mIUserInteractor.requestOtpForSigninCall(requestOtpForSigninInput, new IUserInteractor.OnRequestOtpForSigninListener() {
                @Override
                public void onSuccess(RequestOtpForSigninOutput requestOtpForSigninOutput) {
                    mVerifyOTP.loginOtpSuccess(requestOtpForSigninOutput);
                }

                @Override
                public void onError(String errorMsg) {
                    mVerifyOTP.loginFailure(errorMsg);
                }
            });
        }
    }
   /* @Override
    public void verifyEmailOtp(VerifyMobileInput verifyMobileInput) {
        if (!NetworkUtils.isNetworkConnected(mVerifyOTP.getContext())) {
            mVerifyOTP.hideLoading();
            mVerifyOTP.verifyAccountFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mVerifyOTP.showLoading();
            mIUserInteractor.verifyPhoneNumber( verifyMobileInput,new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut responseLogin) {
                    if (responseLogin != null) {
                        mVerifyOTP.hideLoading();
                        mVerifyOTP.verifyAccountSuccess(responseLogin);
                    } else {
                        mVerifyOTP.hideLoading();
                        mVerifyOTP.verifyAccountFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }
                @Override
                public void onError(String errorMsg) {
                    mVerifyOTP.hideLoading();
                    mVerifyOTP.verifyAccountFailure(errorMsg);
                }

            });
        }
    }
*/



    @Override
    public void actionSendMobileOtpBtn(VerifyMobileInput mobileInput) {
        if (!NetworkUtils.isNetworkConnected(mVerifyOTP.getContext())) {
            mVerifyOTP.hideLoading();
            mVerifyOTP.resendAccountVerificationCodeFailure(AppUtils.getStrFromRes(R.string.network_error));
        }else if (TextUtils.isEmpty(mobileInput.getPhoneNumber())) {
            mVerifyOTP.hideLoading();
            mVerifyOTP.resendAccountVerificationCodeFailure(AppUtils.getStrFromRes(R.string.empty_phone_number));
        } else if (!DataValidationUtils.checkMobile(mobileInput.getPhoneNumber())) {
            mVerifyOTP.hideLoading();
            mVerifyOTP.resendAccountVerificationCodeFailure(AppUtils.getStrFromRes(R.string.invalid_phone_number));
        } else {
            mVerifyOTP.showLoading();
            mIUserInteractor.sendMobileOtp(mobileInput, new IUserInteractor.OnResponseListener() {


                @Override
                public void onSuccess(LoginResponseOut loginResponseOut) {
                    if (loginResponseOut != null) {
                        mVerifyOTP.hideLoading();
                        mVerifyOTP.resendAccountVerificationCodeSuccess(loginResponseOut);
                    } else {
                        mVerifyOTP.hideLoading();
                        mVerifyOTP.resendAccountVerificationCodeFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    mVerifyOTP.hideLoading();
                    mVerifyOTP.resendAccountVerificationCodeFailure(errorMsg);
                }

            });
        }
    }



    @Override
    public void verifyEmailOtp(VerifyMobileInput verifyMobileInput) {
        if (!NetworkUtils.isNetworkConnected(mVerifyOTP.getContext())) {
            mVerifyOTP.hideLoading();
            mVerifyOTP.verifyAccountFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mVerifyOTP.showLoading();
            mIUserInteractor.verifyEmailAddress( verifyMobileInput,new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut responseLogin) {
                    if (responseLogin != null) {
                        mVerifyOTP.hideLoading();
                        mVerifyOTP.verifyAccountSuccess(responseLogin);
                    } else {
                        mVerifyOTP.hideLoading();
                        mVerifyOTP.verifyAccountFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }
                @Override
                public void onError(String errorMsg) {
                    mVerifyOTP.hideLoading();
                    mVerifyOTP.verifyAccountFailure(errorMsg);
                }

            });
        }
    }

}
