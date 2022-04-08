package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class WinnerBreakupInput {


    /**
     * SessionKey : 32079256-570a-523b-27b2-678eea57b263
     * UserGUID : 4c3d2e02-473d-1395-f123-5277b4875335
     * MatchGUID : 13551647-3913-eb6a-1716-6c8ca0850006
     * WinningAmount : 100
     * ContestSize : 3
     * EntryFee : 11
     * IsPaid : Yes
     */

    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("UserGUID")
    private String UserGUID;
    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("WinningAmount")
    private String WinningAmount;
    @SerializedName("ContestSize")
    private String ContestSize;
    @SerializedName("EntryFee")
    private String EntryFee;
    @SerializedName("IsPaid")
    private String IsPaid;

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getUserGUID() {
        return UserGUID;
    }

    public void setUserGUID(String UserGUID) {
        this.UserGUID = UserGUID;
    }

    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String MatchGUID) {
        this.MatchGUID = MatchGUID;
    }

    public String getWinningAmount() {
        return WinningAmount;
    }

    public void setWinningAmount(String WinningAmount) {
        this.WinningAmount = WinningAmount;
    }

    public String getContestSize() {
        return ContestSize;
    }

    public void setContestSize(String ContestSize) {
        this.ContestSize = ContestSize;
    }

    public String getEntryFee() {
        return EntryFee;
    }

    public void setEntryFee(String EntryFee) {
        this.EntryFee = EntryFee;
    }

    public String getIsPaid() {
        return IsPaid;
    }

    public void setIsPaid(String IsPaid) {
        this.IsPaid = IsPaid;
    }
}
