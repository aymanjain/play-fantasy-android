package com.mw.eleven11.UI.allContest;

import com.mw.eleven11.beanInput.MatchContestInput;
import com.mw.eleven11.beanInput.MatchDetailInput;

public interface IAllContestPresenter {

    void matchContestList(MatchContestInput mMatchContestInput);

    void actionMatchdetail(MatchDetailInput mMatchDetailInput);
}
