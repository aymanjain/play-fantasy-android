package com.mw.eleven11.UI.addMoney;


import com.mw.eleven11.beanInput.PromoCodeInput;
import com.mw.eleven11.beanInput.PromoCodeListInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface IAddMoneyPresenter {


    void actionPayUMoneyResponseBtn(String loginSessionKey, String response);

    void promoCodeBtn(PromoCodeInput promoCodeInput);

    void actionPromoCodeList(PromoCodeListInput mPromoCodeListInput);

}
