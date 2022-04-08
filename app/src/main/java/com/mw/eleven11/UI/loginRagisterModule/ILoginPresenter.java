package com.mw.eleven11.UI.loginRagisterModule;

import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.RequestOtpForSigninInput;

/**
 *
 */

public interface ILoginPresenter {
    void actionLoginBtn(LoginInput mLoginInput);

    void actionSocialBtn(LoginInput mLoginInput);

    void verifyOTP(String OTP);

    void actionOtpLoginBtn(RequestOtpForSigninInput requestOtpForSigninInput);
}
