package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class GetContestBidHistoryInput {

   /* @SerializedName("SeriesGUID")
    private String SeriesGUID;*/

    @SerializedName("RoundID")
    private String RoundID;

    @SerializedName("ContestGUID")
    private String ContestGUID;


    @SerializedName("Params")
    private String Params;


    @SerializedName("PageNo")
    private int PageNo;


    @SerializedName("PageSize")
    private int PageSize;


    @SerializedName("PlayerGUID")
    private String PlayerGUID;

    public String getRoundID() {
        return RoundID;
    }

    public void setRoundID(String roundID) {
        RoundID = roundID;
    }


    /* public String getSeriesGUID() {
        return SeriesGUID;
    }

    public void setSeriesGUID(String seriesGUID) {
        SeriesGUID = seriesGUID;
    }*/

    public String getContestGUID() {
        return ContestGUID;
    }

    public void setContestGUID(String contestGUID) {
        ContestGUID = contestGUID;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String params) {
        Params = params;
    }

    public int getPageNo() {
        return PageNo;
    }

    public void setPageNo(int pageNo) {
        PageNo = pageNo;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public String getPlayerGUID() {
        return PlayerGUID;
    }

    public void setPlayerGUID(String playerGUID) {
        PlayerGUID = playerGUID;
    }
}
