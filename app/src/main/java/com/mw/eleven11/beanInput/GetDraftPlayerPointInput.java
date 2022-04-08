package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class GetDraftPlayerPointInput {

    @SerializedName("RoundID")
    private String RoundID;

    @SerializedName("MatchGUID")
    private String MatchGUID;

    @SerializedName("SeriesID")
    private String SeriesID;


    /*@SerializedName("SeriesGUID")
    private String SeriesGUID;*/

    @SerializedName("PlayerGUID")
    private String PlayerGUID;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("Params")
    private String Params;

  /*  public String getSeriesGUID() {
        return SeriesGUID;
    }
    public void setSeriesGUID(String seriesGUID) {
        SeriesGUID = seriesGUID;
    }*/


    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String matchGUID) {
        MatchGUID = matchGUID;
    }

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

    public String getPlayerGUID() {
        return PlayerGUID;
    }

    public void setPlayerGUID(String playerGUID) {
        PlayerGUID = playerGUID;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String sessionKey) {
        SessionKey = sessionKey;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String params) {
        Params = params;
    }
}