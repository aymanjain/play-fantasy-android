package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class SeriesInput {
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("Params")
    private String Params;

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
}
