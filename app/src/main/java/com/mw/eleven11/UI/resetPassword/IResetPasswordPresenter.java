package com.mw.eleven11.UI.resetPassword;


import com.mw.eleven11.beanInput.LoginInput;


/**
 * Created by hp on 06-07-2017.
 */

public interface IResetPasswordPresenter {
    void resetPasswordBtn(LoginInput mLoginInput);

    void resendAccountVerificationCodeBtn(String email);
}
