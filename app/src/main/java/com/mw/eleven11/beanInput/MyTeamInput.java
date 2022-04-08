package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class MyTeamInput {


    /**
     * MatchGUID : fa1063fb-5e79-bdc6-5f5c-8311ecae9994
     * UserGUID : 03105c00-9d88-e3e1-0689-09aa73de769a
     * SessionKey : f859a411-0a1d-aaee-e280-1edd480dfbd2
     * UserTeamType : Normal
     * Params : UserTeamGUID,UserTeamName
     * PageNo : 0
     */

    @SerializedName("OrderBy")
    private String OrderBy="UserTeamName";

    @SerializedName("Sequence")
    private String Sequence="ASC";

    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("UserTeamGUID")
    private String UserTeamGUID;
    @SerializedName("UserGUID")
    private String UserGUID;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("UserTeamType")
    private String UserTeamType ="Normal";
    @SerializedName("Params")
    private String Params;
    @SerializedName("PageNo")
    private int PageNo;



    @SerializedName("ContestGUID")
    private String ContestGUID;

    public String getOrderBy() {
        return OrderBy;
    }

    public void setOrderBy(String orderBy) {
        OrderBy = orderBy;
    }

    public String getContestGUID() {
        return ContestGUID;
    }

    public void setContestGUID(String contestGUID) {
        ContestGUID = contestGUID;
    }

    public String getSequence() {
        return Sequence;
    }

    public void setSequence(String sequence) {
        Sequence = sequence;
    }

    public int getPageNo() {
        return PageNo;
    }

    public void setPageNo(int pageNo) {
        PageNo = pageNo;
    }

    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String MatchGUID) {
        this.MatchGUID = MatchGUID;
    }

    public String getUserGUID() {
        return UserGUID;
    }

    public void setUserGUID(String UserGUID) {
        this.UserGUID = UserGUID;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getUserTeamType() {
        return UserTeamType;
    }

    public void setUserTeamType(String UserTeamType) {
        this.UserTeamType = UserTeamType;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }


    public String getUserTeamGUID() {
        return UserTeamGUID;
    }

    public void setUserTeamGUID(String userTeamGUID) {
        UserTeamGUID = userTeamGUID;
    }
}
