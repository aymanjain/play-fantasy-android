package com.mw.eleven11.UI.verifyOtp;


import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.RequestOtpForSigninInput;
import com.mw.eleven11.beanInput.VerifyMobileInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface IVerifyOTPPresenter {

    void reSendMobileOtp(VerifyMobileInput mobileInput);

    void verifyMobileOtp(VerifyMobileInput mobileInput);

    void actionSendMobileOtpBtn(VerifyMobileInput mobileInput);

    void verifyEmailOtp(VerifyMobileInput verifyMobileInput);

    void actionSendEmailCodeBtn(VerifyMobileInput mobileInput);

    void actionLoginBtn(LoginInput mLoginInput);

    void actionOtpLoginBtn(RequestOtpForSigninInput requestOtpForSigninInput);

}
