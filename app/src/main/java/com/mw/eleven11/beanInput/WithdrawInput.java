package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class WithdrawInput {


    /**
     * PaymentGateway : Bank
     * PaytmPhoneNumber :
     * Amount : 1
     * SessionKey : c0b86de4-a380-9120-4955-f938433c0fbd
     * UserGUID : b236dbe2-7806-b5eb-0d72-d245509e1adb
     */

    @SerializedName("PaymentGateway")
    private String PaymentGateway;
    @SerializedName("PaytmPhoneNumber")
    private String PaytmPhoneNumber;
    @SerializedName("Amount")
    private int Amount;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("UserGUID")
    private String UserGUID;

    @SerializedName("WithdrawalID")
    private Integer WithdrawalID;

    @SerializedName("OTP")
    private String OTP;


    public Integer getWithdrawalID() {
        return WithdrawalID;
    }

    public void setWithdrawalID(Integer withdrawalID) {
        WithdrawalID = withdrawalID;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public String getPaymentGateway() {
        return PaymentGateway;
    }

    public void setPaymentGateway(String PaymentGateway) {
        this.PaymentGateway = PaymentGateway;
    }

    public String getPaytmPhoneNumber() {
        return PaytmPhoneNumber;
    }

    public void setPaytmPhoneNumber(String PaytmPhoneNumber) {
        this.PaytmPhoneNumber = PaytmPhoneNumber;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
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
}
