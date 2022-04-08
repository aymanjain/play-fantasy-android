package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NotificationDeleteInput {


    /**
     * SessionKey : 9a99bc04-bb93-5b45-8eba-ceed3cbc4cf4
     * NotificationIDs : ["142313","102761"]
     */

    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("NotificationIDs")
    private List<String> NotificationIDs;

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public List<String> getNotificationIDs() {
        return NotificationIDs;
    }

    public void setNotificationIDs(List<String> NotificationIDs) {
        this.NotificationIDs = NotificationIDs;
    }
}
