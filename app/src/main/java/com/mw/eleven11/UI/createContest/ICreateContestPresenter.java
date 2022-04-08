package com.mw.eleven11.UI.createContest;



import com.mw.eleven11.beanInput.CreateContestInput;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.WinnerBreakupInput;


/**
 * Created by hp on 06-07-2017.
 */

public interface ICreateContestPresenter {
    void actionCreateContestBtn(CreateContestInput createContestOutput);

    void winning_breakup(WinnerBreakupInput mWinnerBreakupInput);

    void actionViewProfile(LoginInput mLoginInput);


}
