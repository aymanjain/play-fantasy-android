package com.mw.eleven11.UI.contestDetailLeaderBoard;

import android.content.Context;

import com.mw.eleven11.beanOutput.ContestDetailOutput;
import com.mw.eleven11.beanOutput.DreamTeamOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.ResponseDownloadTeam;


/**
 *
 */

public interface ContestLeaderView {

    void showLoading();

    void hideLoading();



    void onMatchSuccess(MatchDetailOutPut responseLogin);

    void onMatchFailure(String errMsg);

    void onContestDetailSuccess(ContestDetailOutput mContestDetailOutput);

    void onContestDetailFailure(String errMsg);

    void onDownloadTeamSuccess(ResponseDownloadTeam mResponseDownloadTeam);

    void onDownloadTeamFailure(String errMsg);


    void onDreamTeamSucess(DreamTeamOutput dreamTeamOutput);
    void onDreamTeamFailure(String errMsg);

    void dreamshowLoading();

    void dreamhideLoading();

    void onProfileSuccess(LoginResponseOut responseLogin);

    void onProfileFailure(String errMsg);

    void onShowSnackBar(String message);

    boolean isAttached();

    Context getContext();


}
