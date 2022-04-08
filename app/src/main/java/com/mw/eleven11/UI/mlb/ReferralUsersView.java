package com.mw.eleven11.UI.mlb;

import android.content.Context;

import com.mw.eleven11.beanOutput.DefaultRespose;
import com.mw.eleven11.beanOutput.ReferralUsersResponse;

public interface ReferralUsersView {

    void showLoading();

    void hideLoading();

    void onLoadingSuccess(ReferralUsersResponse mReferralUsersResponse);

    void onLoadingError(String value);

    Context getContext();

    void onReferEarnSuccess(DefaultRespose mDefaultRespose);

    void onReferEarnError(String value);


}
