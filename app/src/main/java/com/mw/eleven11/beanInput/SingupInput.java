package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SingupInput implements Serializable {


    /**
     * UserTypeID : 2
     * Email : avania@mailinator.com
     * Password : 123456
     * PhoneNumber :
     * ReferralCode :
     * Source : Direct
     * DeviceType : Native
     * DeviceGUID :
     * DeviceToken :
     */

    @SerializedName("UserTypeID")
    private int UserTypeID;
    @SerializedName("FirstName")
    private String FirstName;
    @SerializedName("Email")
    private String Email;
    @SerializedName("Password")
    private String Password;
    @SerializedName("PhoneNumber")
    private String PhoneNumber;
    @SerializedName("ReferralCode")
    private String ReferralCode;
    @SerializedName("Source")
    private String Source;
    @SerializedName("DeviceType")
    private String DeviceType;
    @SerializedName("DeviceGUID")
    private String DeviceGUID;
    @SerializedName("DeviceToken")
    private String DeviceToken;
    @SerializedName("SourceGUID")
    private String SourceGUID;
    @SerializedName("LoginType")
    private String LoginType;
    @SerializedName("RequestType")
    private String RequestType;

    @SerializedName("g-recaptcha-response")
    private String response;

    public String getSourceGUID() {
        return SourceGUID;
    }

    public void setSourceGUID(String sourceGUID) {
        SourceGUID = sourceGUID;
    }

    public int getUserTypeID() {
        return UserTypeID;
    }


    public void setUserTypeID(int UserTypeID) {
        this.UserTypeID = UserTypeID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getReferralCode() {
        return ReferralCode;
    }

    public void setReferralCode(String ReferralCode) {
        this.ReferralCode = ReferralCode;
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

    public String getLoginType() {
        return LoginType;
    }

    public void setLoginType(String loginType) {
        LoginType = loginType;
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
