package com.mw.eleven11.UI.playerPoints;

public interface PlayerPointsPresenter {

    //cricket
    void actionOverAllLeaderboard(String loginSessionKey, String series_id, String match_id, String team_id);

    ///football
    void football_livePlayerStatus(String loginSessionKey, String series_id, String match_id, String team_id);

    void actionPlayerStatus(String loginSessionKey, String series_id, String match_id, String team_id);

    void actionPointsBreakup(String loginSessionKey, String series_id, String match_id, String player_id);


    //kabaddi
    void kabaddiPointsBreakup(String loginSessionKey, String series_id, String match_id, String player_id);

    ///football
    void kabaddi_livePlayerStatus(String loginSessionKey, String series_id, String match_id, String team_id);

    void footballPointsBreakup(String loginSessionKey, String series_id, String match_id, String player_id);

}
