package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class VerifyMobileInput {


    /**
     * SessionKey : 7db9ebb9-9e4b-b334-4ae4-b16549b5e153
     * PhoneNumber : 9993590597
     */

    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("PhoneNumber")
    private String PhoneNumber;




    @SerializedName("Email")
    private String email;


    @SerializedName("Keyword")
    private String Keyword;

    @SerializedName("OTP")
    private String OTP;

    @SerializedName("Source")
    private String Source;

    @SerializedName("DeviceType")
    private String DeviceType;


    @SerializedName("RequestType")
    private String RequestType;

    @SerializedName("g-recaptcha-response")
    private String response;


    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String deviceType) {
        DeviceType = deviceType;
    }

    public String getKeyword() {
        return Keyword;
    }

    public void setKeyword(String keyword) {
        Keyword = keyword;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getRequestType() {
        return RequestType;
    }

    public void setRequestType(String requestType) {
        RequestType = requestType;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
