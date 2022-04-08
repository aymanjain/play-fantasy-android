package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class RankingInput {


    /**
     * SessionKey : 87acf8de-0703-8b2d-148a-abd697217109
     * SeriesGUID : 3e468bac-7d10-8f15-e62e-790bdec7afc3
     * Params : TotalPoints,Username,ProfilePic
     */

    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("SeriesGUID")
    private String SeriesGUID;
    @SerializedName("Params")
    private String Params;

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

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }
}
