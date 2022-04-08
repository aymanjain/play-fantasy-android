package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class ReferEarnInput {

    @SerializedName("SessionKey")
    private String SessionKey;

    @SerializedName("PhoneNumber")
    private String PhoneNumber;

    @SerializedName("Email")
    private String Email;

    @SerializedName("ReferType")
    private String ReferType;

    @SerializedName("g-recaptcha-response")
    private String response;

    @SerializedName("RequestType")
    private String RequestType;


    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String sessionKey) {
        SessionKey = sessionKey;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getReferType() {
        return ReferType;
    }

    public void setReferType(String referType) {
        ReferType = referType;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getRequestType() {
        return RequestType;
    }

    public void setRequestType(String requestType) {
        RequestType = requestType;
    }
}
