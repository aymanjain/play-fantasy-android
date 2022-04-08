package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class MatchListInput {


    /**
     * PageNo : 1
     * PageSize : 10
     * Params : SeriesName,MatchType,MatchNo,MatchStartDateTime,MatchDate,MatchTime,CurrentDateTime,TeamNameLocal,TeamNameVisitor,TeamNameShortLocal,TeamNameShortVisitor,TeamFlagLocal,TeamFlagVisitor,MatchLocation,Status,StatusID,MatchScoreDetails,isJoinedContest
     * Status : Running
     */

    @SerializedName("PageNo")
    private int PageNo;

    @SerializedName("PageSize")
    private int PageSize;
    @SerializedName("Params")
    private String Params;
    @SerializedName("Status")
    private String Status;

    @SerializedName("OrderBy")
    private String OrderBy;

    @SerializedName("IsPlayerOrTimeAvl")
    private String IsPlayerOrTimeAvl;

    @SerializedName("IsPreSquad")
    private String IsPreSquad;


    @SerializedName("MatchStartDateTimeComplete")
    private String MatchStartDateTimeComplete;


    @SerializedName("Filter")
    private  String Filter;

    public String getFilter() {
        return Filter;
    }

    public void setFilter(String filter) {
        Filter = filter;
    }

    @SerializedName("Sequence")
    private String Sequence;


    public String getIsPlayerOrTimeAvl() {
        return IsPlayerOrTimeAvl;
    }

    public void setIsPlayerOrTimeAvl(String isPlayerOrTimeAvl) {
        IsPlayerOrTimeAvl = isPlayerOrTimeAvl;
    }

    public int getPageNo() {
        return PageNo;
    }

    public void setPageNo(int PageNo) {
        this.PageNo = PageNo;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int PageSize) {
        this.PageSize = PageSize;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getOrderBy() {
        return OrderBy;
    }

    public void setOrderBy(String orderBy) {
        OrderBy = orderBy;
    }

    public String getSequence() {
        return Sequence;
    }

    public void setSequence(String sequence) {
        Sequence = sequence;
    }

    public String getMatchStartDateTimeComplete() {
        return MatchStartDateTimeComplete;
    }

    public void setMatchStartDateTimeComplete(String matchStartDateTimeComplete) {
        MatchStartDateTimeComplete = matchStartDateTimeComplete;
    }

    public String getIsPreSquad() {
        return IsPreSquad;
    }

    public void setIsPreSquad(String isPreSquad) {
        IsPreSquad = isPreSquad;
    }
}
