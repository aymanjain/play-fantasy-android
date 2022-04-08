package com.mw.eleven11.UI.notifications;

import android.content.Context;


import com.mw.eleven11.beanOutput.DefaultRespose;
import com.mw.eleven11.beanOutput.NotificationsResponse;
import com.mw.eleven11.beanOutput.ResponseLogin;


/**
 *
 *
 */

public interface NotificationsView {
    void showLoading();

    void hideLoading();

    void onShowLoading();

    void onHideLoading();

    void onReadSuccess(ResponseLogin mResponseLogin);

    void onReadError(String error);

    void onLoadingSuccess(NotificationsResponse response);

    void onLoadingError(String value);

    void onLoadingNotFound(String value);

    void onDeleteNotificationSuccess(DefaultRespose mResponseLogin);

    void onDeleteNotificationFailure(String error);

    void onShowScrollLoading();

    void onHideScrollLoading();

    void onScrollLoadingSuccess(NotificationsResponse response);

    void onScrollLoadingError(String value);

    void onScrollLoadingNotFound(String value);

    void onNotificationMarkReadSuccess(DefaultRespose respose);

    void onNotificationMarkReadFailure(String errMsg);

    void onShowSnackBar(String message);

    boolean isLayoutAdded();

    Context getContext();
}
