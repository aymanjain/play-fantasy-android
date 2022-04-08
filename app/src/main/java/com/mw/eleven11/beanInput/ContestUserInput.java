package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class ContestUserInput {


    /**
     * ContestGUID : c70088ec-41ce-542a-528d-a578dc1ac8ac
     * MatchGUID : 1b5d013a-6407-6027-b25e-8b2156ced49b
     * OrderBy : UserRank
     * PageNo : 1
     * PageSize : 10
     * Params : UserTeamName,TotalPoints,UserWinningAmount,FirstName,Username,UserGUID,UserTeamPlayers,UserTeamID,UserRank,ProfilePic
     * Sequence : ASC
     * SessionKey : 2a4e6269-be39-1586-0cc5-3f3d2f4b27a8
     */

    @SerializedName("ContestGUID")
    private String ContestGUID;
    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("OrderBy")
    private String OrderBy;
    @SerializedName("PageNo")
    private int PageNo;
    @SerializedName("PageSize")
    private int PageSize;
    @SerializedName("Params")
    private String Params;
    @SerializedName("Sequence")
    private String Sequence;
    @SerializedName("SessionKey")
    private String SessionKey;

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

    public String getOrderBy() {
        return OrderBy;
    }

    public void setOrderBy(String OrderBy) {
        this.OrderBy = OrderBy;
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

    public String getSequence() {
        return Sequence;
    }

    public void setSequence(String Sequence) {
        this.Sequence = Sequence;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }
}