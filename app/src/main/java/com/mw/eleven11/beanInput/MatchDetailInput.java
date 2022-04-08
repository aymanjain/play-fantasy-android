package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class MatchDetailInput {


    /**
     * Privacy : No
     * MatchGUID : e72ed74d-c79c-7c1d-0b3e-c6ce2f25d03e
     * SessionKey : 0e5a64b4-246e-74be-cc7f-4f2acaf7ecc5
     * StatusID : 1
     * Params : Privacy,IsPaid,WinningAmount,ContestSize,EntryFee,NoOfWinners,EntryType,IsJoined,Status,ContestFormat,ContestType,CustomizeWinning,TotalJoined,UserInvitationCode,TeamNameLocal,TeamNameVisitor,ShowJoinedContest
     */

    @SerializedName("Privacy")
    private String Privacy;
    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("Status")
    private String Status;
    @SerializedName("Params")
    private String Params;

    public String getPrivacy() {
        return Privacy;
    }

    public void setPrivacy(String Privacy) {
        this.Privacy = Privacy;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }
}


