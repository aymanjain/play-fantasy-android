package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class DreamTeamInput {


    /**
     * MatchGUID : f0b03810-449a-5e0a-890f-d94d277c9be9
     */

    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("ContestGUID")
    private String ContestGUID;
    @SerializedName("SeriesID")
    private String SeriesID;
    @SerializedName("RoundID")
    private String RoundID;



    public String getUserGUID() {
        return UserGUID;
    }

    public void setUserGUID(String userGUID) {
        UserGUID = userGUID;
    }

    @SerializedName("UserGUID")
    private String UserGUID;
    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String MatchGUID) {
        this.MatchGUID = MatchGUID;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getContestGUID() {
        return ContestGUID;
    }

    public void setContestGUID(String contestGUID) {
        ContestGUID = contestGUID;
    }

    public String getSeriesID() {
        return SeriesID;
    }

    public void setSeriesID(String seriesID) {
        SeriesID = seriesID;
    }

    public String getRoundID() {
        return RoundID;
    }

    public void setRoundID(String roundID) {
        RoundID = roundID;
    }
}
