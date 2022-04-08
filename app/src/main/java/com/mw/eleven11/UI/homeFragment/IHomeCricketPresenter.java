package com.mw.eleven11.UI.homeFragment;


import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.VersionInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface IHomeCricketPresenter {
    void actionBannersList(LoginInput mLoginInput);

    void appVerson(VersionInput versionInput);

    void actionNotificationCount(LoginInput mLoginInput);
}
