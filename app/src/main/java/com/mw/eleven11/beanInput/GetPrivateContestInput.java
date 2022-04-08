package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class GetPrivateContestInput {

    @SerializedName("SessionKey")
    private String SessionKey;


    @SerializedName("MatchGUID")
    private String MatchGUID;


    @SerializedName("Params")
    private String Params;

    @SerializedName("UserInvitationCode")
    private String UserInvitationCode;


    @SerializedName("RoundID")
    private String RoundID;


    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String matchGUID) {
        MatchGUID = matchGUID;
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

    public String getUserInvitationCode() {
        return UserInvitationCode;
    }

    public void setUserInvitationCode(String userInvitationCode) {
        UserInvitationCode = userInvitationCode;
    }

    public String getRoundID() {
        return RoundID;
    }

    public void setRoundID(String roundID) {
        RoundID = roundID;
    }
}
