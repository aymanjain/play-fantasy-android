package com.mw.eleven11.UI.chooseMoney;

import android.app.Activity;
import android.content.Context;

/**
 * Created by hp on 06-07-2017.
 */

public interface ChooseMoneyCallback {
    void onPaymentComplete(String s);

    void getOrderId(String orderId);

    Context getContext();

    int getAmount();

    String  getCouponGUID();

    String getCode();

    Activity getActivity();

    void finishActivity();
}
