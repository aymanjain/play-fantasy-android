package com.mw.eleven11.UI.createCaption;


import com.mw.eleven11.beanInput.CreateTeamInput;


/**
 * Created by hp on 06-07-2017.
 */

public interface ICreateCaptionPresenter {

    void actionCreateTeam(CreateTeamInput mCreateTeamInput);
    void actionEditTeam(CreateTeamInput mCreateTeamInput);

   /* //cricket
    void actionCreateTeam(String loginSessionKey, String userId, String matchId, String seriesId, List<ResponseMatchPlayers.ResponseBean> playerId);

    void actionEditTeam(String loginSessionKey, String userId, String matchId, String userTeamId, List<ResponseMatchPlayers.ResponseBean> playerId);

    //football
    void football_CreateTeam(String loginSessionKey, String userId, String matchId, String seriesId, List<ResponseMatchPlayers.ResponseBean> playerId);

    void football_editTeam(String loginSessionKey, String userId, String matchId, String userTeamId, List<ResponseMatchPlayers.ResponseBean> playerId);

    //kabaddi
    void kabaddi_CreateTeam(String loginSessionKey, String userId, String matchId, String seriesId, List<ResponseMatchPlayers.ResponseBean> playerId);

    void kabaddi_editTeam(String loginSessionKey, String userId, String matchId, String userTeamId, List<ResponseMatchPlayers.ResponseBean> playerId);
*/

}
