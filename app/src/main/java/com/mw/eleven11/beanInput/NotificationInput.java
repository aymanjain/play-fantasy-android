package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class NotificationInput {
    @SerializedName("PageNo")
    private int PageNo;
    @SerializedName("PageSize")
    private int PageSize;
    @SerializedName("SessionKey")
    private String SessionKey;

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

    public void setSessionKey(String sessionKey) {
        SessionKey = sessionKey;
    }
}
