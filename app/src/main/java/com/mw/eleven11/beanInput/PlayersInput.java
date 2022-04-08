package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class PlayersInput {


    /**
     * MatchGUID : fa1063fb-5e79-bdc6-5f5c-8311ecae9994
     * SessionKey : 2a4e6269-be39-1586-0cc5-3f3d2f4b27a8
     * Params : PlayerRole,PlayerPic,PlayerCountry,PlayerBornPlace,PlayerBattingStyle,PlayerBowlingStyle,MatchType,MatchNo,MatchDateTime,SeriesName,TeamGUID,PlayerBattingStats,PlayerBowlingStats,IsPlaying,PointsData,PlayerSalary,TeamNameShort
     */

    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("IsPlaying")
    private String IsPlaying;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("Params")
    private String Params;
    @SerializedName("IsActive")
    private String IsActive;

    @SerializedName("CustomOrderBy")
    private String CustomOrderBy;

    @SerializedName("RoundID")
    private String RoundID;

    @SerializedName("ContestGUID")
    private String ContestGUID;

    @SerializedName("SeriesGUID")
    private String SeriesGUID;

    @SerializedName("OrderBy")
    private String OrderBy;
    @SerializedName("Sequence")
    private String Sequence;
    @SerializedName("PlayerSalary")
    private String PlayerSalary;


    @SerializedName("UserGUID")
    private String UserGUID;


    public String getUserGUID() {
        return UserGUID;
    }

    public void setUserGUID(String UserGUID) {
        this.UserGUID = UserGUID;
    }

    public String getIsPlaying() {
        return IsPlaying;
    }

    public void setIsPlaying(String isPlaying) {
        IsPlaying = isPlaying;
    }

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

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }

    public String getCustomOrderBy() {
        return CustomOrderBy;
    }

    public void setCustomOrderBy(String customOrderBy) {
        CustomOrderBy = customOrderBy;
    }

    public String getSequence() {
        return Sequence;
    }

    public void setSequence(String sequence) {
        Sequence = sequence;
    }

    public String getContestGUID() {
        return ContestGUID;
    }

    public void setContestGUID(String contestGUID) {
        ContestGUID = contestGUID;
    }

    public String getRoundID() {
        return RoundID;
    }

    public void setRoundID(String roundID) {
        RoundID = roundID;
    }

    public String getSeriesGUID() {
        return SeriesGUID;
    }

    public void setSeriesGUID(String seriesGUID) {
        SeriesGUID = seriesGUID;
    }

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String isActive) {
        IsActive = isActive;
    }

    public String getOrderBy() {
        return OrderBy;
    }

    public void setOrderBy(String orderBy) {
        OrderBy = orderBy;
    }

    public String getPlayerSalary() {
        return PlayerSalary;
    }

    public void setPlayerSalary(String playerSalary) {
        PlayerSalary = playerSalary;
    }
}
