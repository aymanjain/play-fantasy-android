package com.mw.eleven11.UI.myTeams;


import com.mw.eleven11.beanInput.MyTeamInput;
import com.mw.eleven11.beanInput.SwitchTeamInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface IMyTeamsPresenter {
    //cricket
    void actionTeamList(MyTeamInput myTeamInput);

    void actionSwitchBtn(SwitchTeamInput switchTeamInput);


}
