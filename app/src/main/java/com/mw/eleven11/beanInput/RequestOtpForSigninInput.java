package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class RequestOtpForSigninInput {


    /**
     * PhoneNumber : 7000189093
     * Source : Otp
     */

    private String PhoneNumber;
    private String Source;

    @SerializedName("g-recaptcha-response")
    private String response;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
