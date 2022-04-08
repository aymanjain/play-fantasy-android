package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

public class ForgetPasswordOut {

    /**
     * ResponseCode : 200
     * Message : Please check your email for instructions.
     * Data : []
     */

    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("Message")
    private String Message;
//    @SerializedName("Data")
    //private List<?> Data;
    @SerializedName("CaptchaEnable")
    private String CaptchaEnable;


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

    public String getCaptchaEnable() {
        return CaptchaEnable;
    }

    public void setCaptchaEnable(String captchaEnable) {
        CaptchaEnable = captchaEnable;
    }

   /* public List<?> getData() {
        return Data;
    }

    public void setData(List<?> Data) {
        this.Data = Data;
    }*/
}
