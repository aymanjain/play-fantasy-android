package com.mw.eleven11.UI.myTeams;

import android.content.Context;

import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.MyTeamOutput;


/**
 *
 */

public interface MyTeamsView {
    void showLoading();

    void hideLoading();

    void onShowLoading();

    void onHideLoading();

    void onLoadingSuccess(MyTeamOutput responseTeams);

    void onLoadingError(String value);

    void onLoadingNotFound(String value);

    void onSwitchSuccess(LoginResponseOut responseContest);

    void onSwitchError(String value);

    void onShowSnackBar(String message);

    boolean isLayoutAdded();

    Context getContext();
}
