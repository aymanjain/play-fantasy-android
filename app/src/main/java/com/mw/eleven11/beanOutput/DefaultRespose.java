package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

public class DefaultRespose {


    /**
     * ResponseCode : 500
     * Message : Sorry, but this email address is unavailable.
     * Data : []
     */

    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("Message")
    private String Message;
    @SerializedName("CaptchaEnable")
    private String CaptchaEnable;
    @SerializedName("Data")
    private Object Data;

    public int getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(int ResponseCode) {
        this.ResponseCode = ResponseCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object Data) {
        this.Data = Data;
    }

    public String getCaptchaEnable() {
        return CaptchaEnable;
    }

    public void setCaptchaEnable(String captchaEnable) {
        CaptchaEnable = captchaEnable;
    }
}
