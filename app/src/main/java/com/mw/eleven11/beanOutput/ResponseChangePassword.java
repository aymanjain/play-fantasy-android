package com.mw.eleven11.beanOutput;

public class ResponseChangePassword {
    /**
     * code : 200
     * status : 1
     * message : The new password has been saved successfully
     */

    private int code;
    private int status;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
