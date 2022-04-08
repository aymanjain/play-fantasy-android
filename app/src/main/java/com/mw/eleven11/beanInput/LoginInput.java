package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginInput implements Serializable {


    /**
     * Keyword : alexma@mailinator.com
     * Password : 123456
     * Source : Direct
     * DeviceType : Native
     * DeviceGUID : 123456789
     * DeviceToken : abcxyz
     * IPAddress :
     * Latitude :
     * Longitude :
     */

    @SerializedName("Keyword")
    private String Keyword;
    @SerializedName("Password")
    private String Password;
    @SerializedName("Source")
    private String Source;
    @SerializedName("DeviceType")
    private String DeviceType;
    @SerializedName("DeviceGUID")
    private String DeviceGUID;
    @SerializedName("DeviceToken")
    private String DeviceToken;
    @SerializedName("IPAddress")
    private String IPAddress;
    @SerializedName("Latitude")
    private String Latitude;
    @SerializedName("Longitude")
    private String Longitude;



    @SerializedName("PhoneNumber")
    private String PhoneNumber;
    @SerializedName("IsActive")
    private String IsActive;

    @SerializedName("RequestType")
    private String RequestType;

    @SerializedName("g-recaptcha-response")
    private String response;

    @SerializedName("OTP")
    private String OTP;

    @SerializedName("Value")
    private String Value;

    @SerializedName("CashbonusExpiry")
    private String CashbonusExpiry;

    @SerializedName("UserGUID")
    private String UserGUID;

    @SerializedName("NotificationID")
    private String NotificationID;

    @SerializedName("ConfirmPassword")
    private String ConfirmPassword;


    @SerializedName("Params")
    private String Params;

    @SerializedName("SessionKey")
    private String SessionKey;


    @SerializedName("LoginType")
    private String LoginType;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getUserGUID() {
        return UserGUID;
    }

    public void setUserGUID(String userGUID) {
        UserGUID = userGUID;
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

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public String getKeyword() {
        return Keyword;
    }

    public void setKeyword(String Keyword) {
        this.Keyword = Keyword;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String DeviceType) {
        this.DeviceType = DeviceType;
    }

    public String getDeviceGUID() {
        return DeviceGUID;
    }

    public void setDeviceGUID(String DeviceGUID) {
        this.DeviceGUID = DeviceGUID;
    }

    public String getDeviceToken() {
        return DeviceToken;
    }

    public void setDeviceToken(String DeviceToken) {
        this.DeviceToken = DeviceToken;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getLoginType() {
        return LoginType;
    }

    public void setLoginType(String loginType) {
        LoginType = loginType;
    }

    public String getNotificationID() {
        return NotificationID;
    }

    public void setNotificationID(String notificationID) {
        NotificationID = notificationID;
    }

    public String getCashbonusExpiry() {
        return CashbonusExpiry;
    }

    public void setCashbonusExpiry(String cashbonusExpiry) {
        CashbonusExpiry = cashbonusExpiry;
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

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String isActive) {
        IsActive = isActive;
    }
}
