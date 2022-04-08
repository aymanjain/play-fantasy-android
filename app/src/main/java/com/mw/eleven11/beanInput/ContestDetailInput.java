package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class ContestDetailInput {


    /**
     * SessionKey : 2a4e6269-be39-1586-0cc5-3f3d2f4b27a8
     * MatchGUID : a72e22cd-934a-9be6-ac1a-7c7092e1ea65
     * ContestGUID : 0b609e29-f146-a5be-e6d0-040e9a1613c7
     * Params :  UserTeamName,TotalPoints,UserWinningAmount,FirstName,Username,UserGUID,UserTeamPlayers,UserTeamID,UserRank
     * OrderBy : UserRank
     * Sequence : ASC
     * PageNo : 1
     * PageSize : 20
     */

    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("ContestGUID")
    private String ContestGUID;
    @SerializedName("Params")
    private String Params;
    @SerializedName("OrderBy")
    private String OrderBy;
    @SerializedName("Sequence")
    private String Sequence;
    @SerializedName("PageNo")
    private int PageNo;
    @SerializedName("PageSize")
    private int PageSize;

    @SerializedName("UserInvitationCode")
    private String UserInvitationCode;

    public String getUserInvitationCode() {
        return UserInvitationCode;
    }

    public void setUserInvitationCode(String userInvitationCode) {
        UserInvitationCode = userInvitationCode;
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

    public String getContestGUID() {
        return ContestGUID;
    }

    public void setContestGUID(String ContestGUID) {
        this.ContestGUID = ContestGUID;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }

    public String getOrderBy() {
        return OrderBy;
    }

    public void setOrderBy(String OrderBy) {
        this.OrderBy = OrderBy;
    }

    public String getSequence() {
        return Sequence;
    }

    public void setSequence(String Sequence) {
        this.Sequence = Sequence;
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
}
