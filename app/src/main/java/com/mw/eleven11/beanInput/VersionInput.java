package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class VersionInput {


    /**
     * SessionKey : 4248771d-30f9-e7af-a31b-29165fcbf037
     * UserAppVersion : 1
     * DeviceType : AndroidPhone
     */

    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("UserAppVersion")
    private String UserAppVersion;
    @SerializedName("DeviceType")
    private String DeviceType;

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getUserAppVersion() {
        return UserAppVersion;
    }

    public void setUserAppVersion(String UserAppVersion) {
        this.UserAppVersion = UserAppVersion;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String DeviceType) {
        this.DeviceType = DeviceType;
    }
}
