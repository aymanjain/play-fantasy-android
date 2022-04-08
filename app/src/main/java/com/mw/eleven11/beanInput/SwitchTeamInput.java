package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class SwitchTeamInput {

    /**
     * SessionKey : 87acf8de-0703-8b2d-148a-abd697217109
     * UserTeamGUID : 6427c985-e0df-8b69-48b2-2f359121cecb
     * OldUserTeamGUID : 74b4ac65-5130-cb26-deea-75aa3bf705d6
     * ContestGUID : 7bd41179-049e-41ad-da6b-72d90b581be9
     */

    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("UserTeamGUID")
    private String UserTeamGUID;
    @SerializedName("OldUserTeamGUID")
    private String OldUserTeamGUID;
    @SerializedName("ContestGUID")
    private String ContestGUID;

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getUserTeamGUID() {
        return UserTeamGUID;
    }

    public void setUserTeamGUID(String UserTeamGUID) {
        this.UserTeamGUID = UserTeamGUID;
    }

    public String getOldUserTeamGUID() {
        return OldUserTeamGUID;
    }

    public void setOldUserTeamGUID(String OldUserTeamGUID) {
        this.OldUserTeamGUID = OldUserTeamGUID;
    }

    public String getContestGUID() {
        return ContestGUID;
    }

    public void setContestGUID(String ContestGUID) {
        this.ContestGUID = ContestGUID;
    }
}
