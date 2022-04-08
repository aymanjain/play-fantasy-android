package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class DownloadTeamInput {


    /**
     * SessionKey : 734cd301-d2a4-e830-e968-c18533a71574
     * ContestGUID : b9ad31ab-1205-1137-0185-54ad18856859
     * MatchGUID : b705e8c6-bfa6-255e-846b-bdad6d0290b5
     */
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("ContestGUID")
    private String ContestGUID;
    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("SeriesID")
    private String SeriesID;
    @SerializedName("RoundID")
    private String RoundID;

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getContestGUID() {
        return ContestGUID;
    }

    public void setContestGUID(String ContestGUID) {
        this.ContestGUID = ContestGUID;
    }

    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String MatchGUID) {
        this.MatchGUID = MatchGUID;
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
