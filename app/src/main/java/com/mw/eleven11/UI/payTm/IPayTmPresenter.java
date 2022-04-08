package com.mw.eleven11.UI.payTm;


import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.PaytmInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface IPayTmPresenter {
    void actionPayTmResponseBtn(PaytmInput paytmInput);
    void actionPayTmDetailsBtn(PaytmInput paytmInput);

    void actionViewProfile(LoginInput mLoginInput);

}
