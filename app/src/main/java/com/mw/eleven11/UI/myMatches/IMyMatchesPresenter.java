package com.mw.eleven11.UI.myMatches;


import com.mw.eleven11.beanInput.JoinedContestInput;
import com.mw.eleven11.beanInput.MyContestMatchesInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface IMyMatchesPresenter {

    void actionListing(JoinedContestInput mJoinedContestInput);

    void myContestactionListing(MyContestMatchesInput mJoinedContestInput);

    void matchContestList(JoinedContestInput mJoinedContestInput);



}
