package com.mw.eleven11.UI.mobileAndEmailVerify;


import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.VerifyMobileInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface IVerifyMobileEmailPresenter {

    void actionViewProfile(LoginInput mLoginInput);

    void actionSendEmailCodeBtn(VerifyMobileInput mobileInput);

    void actionSendMobileOtpBtn(VerifyMobileInput mobileInput);


}
