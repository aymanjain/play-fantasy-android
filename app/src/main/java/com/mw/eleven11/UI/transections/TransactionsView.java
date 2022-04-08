package com.mw.eleven11.UI.transections;

import android.content.Context;


import com.mw.eleven11.beanOutput.TransactionsBean;


/**
 * Created by pintu kumar patil on 13-09-2017.
 */

public interface TransactionsView {
    void showLoading();
    void hideLoading();
    void onShowLoading();
    void onHideLoading();
    void onLoadingSuccess(TransactionsBean responseMatches);
    void onLoadingError(String value);
    void onLoadingNotFound(String value);
    void onShowScrollLoading();
    void onHideScrollLoading();
    void onScrollLoadingSuccess(TransactionsBean responseMatches);
    void onScrollLoadingError(String value);
    void onScrollLoadingNotFound(String value);
    void onShowSnackBar(String message);
    boolean isLayoutAdded();
    Context getContext();
}
