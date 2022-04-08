package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class WalletInput {


    /**
     * TransactionMode : WalletAmount
     * SessionKey : deda8965-2e9a-6743-522e-8e6f7cb1d861
     * UserGUID : 8f49fc82-b3df-db93-98a4-97a6093c4cc1
     * Params : Amount,CurrencyPaymentGateway,TransactionType,TransactionID,Status,Narration,OpeningBalance,ClosingBalance,EntryDate,WalletDetails
     */

    @SerializedName("TransactionMode")
    private String TransactionMode;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("UserGUID")
    private String UserGUID;
    @SerializedName("Params")
    private String Params;

    public String getTransactionMode() {
        return TransactionMode;
    }

    public void setTransactionMode(String TransactionMode) {
        this.TransactionMode = TransactionMode;
    }

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

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }
}
