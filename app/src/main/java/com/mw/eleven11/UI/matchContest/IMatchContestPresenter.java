package com.mw.eleven11.UI.matchContest;


import com.mw.eleven11.beanInput.MatchContestInput;
import com.mw.eleven11.beanInput.MatchDetailInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface IMatchContestPresenter {

    void actionMatchdetail(MatchDetailInput mMatchDetailInput);

    void matchContestList(MatchContestInput mMatchContestInput);


}
