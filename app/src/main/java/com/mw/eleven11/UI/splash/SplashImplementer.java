package com.mw.eleven11.UI.splash;

import android.os.Handler;

import com.mw.eleven11.AppSession;


public class SplashImplementer implements SplashPresenter {


    @Override
    public void startThread(long time) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AppSession mAppSession = AppSession.getInstance();

                if (mAppSession.getLoginSession() == null) {
                    mSplashView.isLogout();
                } else {
                    if (AppSession.getInstance().getLoginSession().getResponseCode() == 200 && AppSession.getInstance().getLoginSession().getData().getPhoneStatus().equalsIgnoreCase("Pending")) {
                        mSplashView.notVerify();
                    } else if (AppSession.getInstance().getLoginSession().getResponseCode() == 200 /*&& !AppSession.getInstance().getLoginSession().getData().getPhoneNumber().equals("")*/) {
                        mSplashView.isLogin();
                    } else {
                        mSplashView.isLogout();
                    }
                }
            }
        }, time);
    }

    SplashView mSplashView;

    public SplashImplementer(SplashView mSplashView) {
        this.mSplashView = mSplashView;
    }
}
