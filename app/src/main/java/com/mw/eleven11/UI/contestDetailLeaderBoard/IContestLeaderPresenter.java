package com.mw.eleven11.UI.contestDetailLeaderBoard;


import com.mw.eleven11.beanInput.ContestDetailInput;
import com.mw.eleven11.beanInput.DownloadTeamInput;
import com.mw.eleven11.beanInput.DreamTeamInput;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.MatchDetailInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface IContestLeaderPresenter {

    void actionMatchdetail(MatchDetailInput mMatchDetailInput);

    void getContest(ContestDetailInput mContestDetailInput);

    void actionDownloadTeam(DownloadTeamInput mDownloadTeamInput);

    void getDreamTeam(DreamTeamInput mDreamTeamInput);

    void actionViewProfile(LoginInput mLoginInput);

}
