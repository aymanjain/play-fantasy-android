package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class TransactionInput {


    /**
     * SessionKey : fcc637f3-829d-0b68-5241-c0748146230d
     * TransactionMode : All
     * OrderBy :
     * Sequence : DESC
     * Params : TransactionType,Narration, Amount,TransactionID,WalletAmount,WinningAmount,CashBonus,EntryDate
     */
    @SerializedName("PageNo")
    private int PageNo;
    @SerializedName("PageSize")
    private int PageSize;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("TransactionMode")
    private String TransactionMode;
    @SerializedName("OrderBy")
    private String OrderBy;
    @SerializedName("Sequence")
    private String Sequence;
    @SerializedName("Params")
    private String Params;

    public int getPageNo() {
        return PageNo;
    }

    public void setPageNo(int pageNo) {
        PageNo = pageNo;
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

    public String getTransactionMode() {
        return TransactionMode;
    }

    public void setTransactionMode(String TransactionMode) {
        this.TransactionMode = TransactionMode;
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

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }
}
