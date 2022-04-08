package com.mw.eleven11.beanInput;

public class PlayerFantasyStatsInput {


    /**
     * SessionKey : c3313909-7f56-4179-1c2d-0d56e7137b3e
     * SeriesGUID : cbfd393d-1628-962e-b3c9-3db5cf8b3f3b
     * PlayerGUID : 15b1a249-c0df-74a3-f6c8-2fb5b29f92d8
     * Params : MatchNo,MatchLocation,MatchStartDateTime,TeamNameShortLocal,TeamNameShortVisitor,TotalPoints,TotalTeams,PlayerSelectedPercent
     */

    private String SessionKey;
    private String SeriesGUID;
    private String RoundID;
    private String SeriesID;
    private String PlayerGUID;
    private String Params;
    private String MatchGUID;


    public String getRoundID() {
        return RoundID;
    }

    public void setRoundID(String roundID) {
        RoundID = roundID;
    }

    public String getSeriesID() {
        return SeriesID;
    }

    public void setSeriesID(String seriesID) {
        SeriesID = seriesID;
    }

    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String matchGUID) {
        MatchGUID = matchGUID;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getSeriesGUID() {
        return SeriesGUID;
    }

    public void setSeriesGUID(String SeriesGUID) {
        this.SeriesGUID = SeriesGUID;
    }

    public String getPlayerGUID() {
        return PlayerGUID;
    }

    public void setPlayerGUID(String PlayerGUID) {
        this.PlayerGUID = PlayerGUID;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }
}
