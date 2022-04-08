package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class JoinContestInput {


    /**
     * ContestGUID :
     * MatchGUID :
     * SessionKey :
     * UserTeamGUID :
     */

    @SerializedName("ContestGUID")
    private String ContestGUID;
    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("UserTeamGUID")
    private String UserTeamGUID;
    @SerializedName("join")
    private String join;

    @SerializedName("UserInvitationCode")
    private String UserInvitationCode;

    public String getUserInviteCode() {
        return UserInvitationCode;
    }

    public void setUserInviteCode(String userInviteCode) {
        this.UserInvitationCode = userInviteCode;
    }

    public String getContestGUID() {
        return ContestGUID;
    }

    public void setContestGUID(String ContestGUID) {
        this.ContestGUID = ContestGUID;
    }

    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String MatchGUID) {
        this.MatchGUID = MatchGUID;
    }

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

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }
}
