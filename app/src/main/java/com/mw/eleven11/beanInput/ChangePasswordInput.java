package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class ChangePasswordInput {


    /**
     * SessionKey : 7c9a28f3-0e22-f690-12b8-94900b288b6a
     * CurrentPassword : khan@123
     * Password : 123456
     */

    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("CurrentPassword")
    private String CurrentPassword;
    @SerializedName("Password")
    private String Password;

    @SerializedName("ConfirmPassword")
    private String ConfirmPassword;

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getCurrentPassword() {
        return CurrentPassword;
    }

    public void setCurrentPassword(String CurrentPassword) {
        this.CurrentPassword = CurrentPassword;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
