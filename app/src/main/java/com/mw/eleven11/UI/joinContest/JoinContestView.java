package com.mw.eleven11.UI.joinContest;

import android.content.Context;

import com.mw.eleven11.beanOutput.JoinContestOutput;
import com.mw.eleven11.beanOutput.WalletOutputBean;



/**
 *
 */

public interface JoinContestView {
    void showLoading();

    void hideLoading();

    void onAccountSuccess(WalletOutputBean mWalletOutputBean);

    void onAccountFailure(String errMsg);

    void onJoinSuccess(JoinContestOutput responseLogin);

    void onJoinFailure(String errMsg);

    void onJoinNotFound(String errMsg);

    void onShowLoading();

    void onHideLoading();

    void onShowSnackBar(String message);





    boolean isAttached();

    Context getContext();
}
