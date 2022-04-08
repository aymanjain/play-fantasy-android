package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class JoinedContestInput {

    /**
     * SessionKey : 628bd1b5-355e-a4c5-68ff-ac9cfaadaa9c
     * MatchGUID :
     * Params : Privacy,IsPaid,WinningAmount,ContestSize,EntryFee,NoOfWinners,EntryType,Status,SeriesName,MatchNo,MatchStartDateTime,TeamNameLocal,TeamNameVisitor,TeamNameShortLocal,TeamNameShortVisitor,TeamFlagLocal,TeamFlagVisitor,MatchLocation,MatchGUID,JoinedCount,UserTotalJoinedInMatch,TeamNameShortLocal,TeamNameShortVisitor,UserWinningAmount
     * PageNo : 0
     * Status : Pending
     * getJoinedMatches : Yes
     */






    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("Params")
    private String Params;
    @SerializedName("PageNo")
    private int PageNo;

    @SerializedName("PageSize")
    private int PageSize;

    @SerializedName("Status")
    private String Status;
    @SerializedName("getJoinedMatches")
    private String getJoinedMatches;

    public String getContestFull() {
        return ContestFull;
    }

    public void setContestFull(String contestFull) {
        ContestFull = contestFull;
    }

    @SerializedName("ContestFull")
    private String ContestFull;

    @SerializedName("Privacy")
    private String Privacy;

    @SerializedName("MyJoinedContest")
    private String MyJoinedContest;

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

    @SerializedName("OrderBy")
    private String OrderBy;


    @SerializedName("Sequence")
    private String Sequence;



    public String getPrivacy() {
        return Privacy;
    }

    public void setPrivacy(String privacy) {
        Privacy = privacy;
    }

    public String getMyJoinedContest() {
        return MyJoinedContest;
    }

    public void setMyJoinedContest(String myJoinedContest) {
        MyJoinedContest = myJoinedContest;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String MatchGUID) {
        this.MatchGUID = MatchGUID;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }

    public int getPageNo() {
        return PageNo;
    }

    public void setPageNo(int PageNo) {
        this.PageNo = PageNo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getGetJoinedMatches() {
        return getJoinedMatches;
    }

    public void setGetJoinedMatches(String getJoinedMatches) {
        this.getJoinedMatches = getJoinedMatches;
    }
}
