package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class PaytmInput {


    /**
     * RequestSource : Web
     * PaymentGateway : PayUmoney
     * Amount : 100
     * FirstName : Sorav Garg
     * Email : sorav@mobiwebtech.in
     * PhoneNumber : 9074939905
     * CouponGUID :
     */

    @SerializedName("RequestSource")
    private String RequestSource;
    @SerializedName("PaymentGateway")
    private String PaymentGateway;
    @SerializedName("Amount")
    private String Amount;
    @SerializedName("FirstName")
    private String FirstName;
    @SerializedName("Email")
    private String Email;
    @SerializedName("PhoneNumber")
    private String PhoneNumber;
    @SerializedName("CouponGUID")
    private String CouponGUID;

    @SerializedName("Razor_payment_id")
    private String Razor_payment_id;

    @SerializedName("PaymentGatewayResponse")
    private String PaymentGatewayResponse;
    @SerializedName("PaymentGatewayStatus")
    private String PaymentGatewayStatus;
    @SerializedName("WalletID")
    private String WalletID;
    @SerializedName("SessionKey")
    private String SessionKey;

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String sessionKey) {
        SessionKey = sessionKey;
    }

    public String getPaymentGatewayResponse() {
        return PaymentGatewayResponse;
    }

    public void setPaymentGatewayResponse(String paymentGatewayResponse) {
        PaymentGatewayResponse = paymentGatewayResponse;
    }

    public String getPaymentGatewayStatus() {
        return PaymentGatewayStatus;
    }

    public void setPaymentGatewayStatus(String paymentGatewayStatus) {
        PaymentGatewayStatus = paymentGatewayStatus;
    }

    public String getWalletID() {
        return WalletID;
    }

    public void setWalletID(String walletID) {
        WalletID = walletID;
    }

    public String getRequestSource() {
        return RequestSource;
    }

    public void setRequestSource(String RequestSource) {
        this.RequestSource = RequestSource;
    }

    public String getPaymentGateway() {
        return PaymentGateway;
    }

    public void setPaymentGateway(String PaymentGateway) {
        this.PaymentGateway = PaymentGateway;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getCouponGUID() {
        return CouponGUID;
    }

    public void setCouponGUID(String CouponGUID) {
        this.CouponGUID = CouponGUID;
    }

    public String getRazor_payment_id() {
        return Razor_payment_id;
    }

    public void setRazor_payment_id(String razor_payment_id) {
        Razor_payment_id = razor_payment_id;
    }
}
