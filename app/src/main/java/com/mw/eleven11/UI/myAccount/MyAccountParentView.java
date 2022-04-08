package com.mw.eleven11.UI.myAccount;

import android.content.Context;

import com.mw.eleven11.beanOutput.WalletOutputBean;



/**
 *
 */

public interface MyAccountParentView {
    void showLoading();

    void hideLoading();

    void onAccountSuccess(WalletOutputBean mWalletOutputBean);

    void onAccountFailure(String errMsg);

    void onShowLoading();

    void onHideLoading();

    void onShowSnackBar(String message);

    boolean isAttached();

    Context getContext();
}
