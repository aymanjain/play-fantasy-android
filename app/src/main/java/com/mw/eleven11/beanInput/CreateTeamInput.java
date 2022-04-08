package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateTeamInput {


    /**
     * MatchGUID : 9b4cc05e-ae0c-60ef-df04-a23f736ce4cd
     * UserTeamName : My Team
     * UserTeamType : Normal
     * SessionKey : 2a4e6269-be39-1586-0cc5-3f3d2f4b27a8
     * UserTeamPlayers : [{"PlayerGUID":"da80bde9-9a72-d251-40c0-ab15e1dd6b7a","PlayerPosition":"Captain"},{"PlayerGUID":"7c6ba35e-197c-d31b-09d4-33c85a0e1ce9","PlayerPosition":"Player"}]
     */

    @SerializedName("UserTeamGUID")
    private String UserTeamGUID;
    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("UserTeamName")
    private String UserTeamName;
    @SerializedName("UserTeamType")
    private String UserTeamType;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("UserTeamPlayers")
    private List<UserTeamPlayersBean> UserTeamPlayers;

    public String getUserTeamGUID() {
        return UserTeamGUID;
    }

    public void setUserTeamGUID(String userTeamGUID) {
        UserTeamGUID = userTeamGUID;
    }

    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String MatchGUID) {
        this.MatchGUID = MatchGUID;
    }

    public String getUserTeamName() {
        return UserTeamName;
    }

    public void setUserTeamName(String UserTeamName) {
        this.UserTeamName = UserTeamName;
    }

    public String getUserTeamType() {
        return UserTeamType;
    }

    public void setUserTeamType(String UserTeamType) {
        this.UserTeamType = UserTeamType;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public List<UserTeamPlayersBean> getUserTeamPlayers() {
        return UserTeamPlayers;
    }

    public void setUserTeamPlayers(List<UserTeamPlayersBean> UserTeamPlayers) {
        this.UserTeamPlayers = UserTeamPlayers;
    }

    public static class UserTeamPlayersBean {
        /**
         * PlayerGUID : da80bde9-9a72-d251-40c0-ab15e1dd6b7a
         * PlayerPosition : Captain
         */

        @SerializedName("PlayerGUID")
        private String PlayerGUID;
        @SerializedName("PlayerPosition")
        private String PlayerPosition;


        @SerializedName("PlayerName")
        private String PlayerName;

        @SerializedName("PlayerPic")
        private String PlayerPic;


        @SerializedName("PlayerSalary")
        private String PlayerSalary;


        @SerializedName("PlayerID")
        private String PlayerID;





        public String getPlayerGUID() {
            return PlayerGUID;
        }

        public void setPlayerGUID(String PlayerGUID) {
            this.PlayerGUID = PlayerGUID;
        }

        public String getPlayerPosition() {
            return PlayerPosition;
        }

        public void setPlayerPosition(String PlayerPosition) {
            this.PlayerPosition = PlayerPosition;
        }

        public String getPlayerName() {
            return PlayerName;
        }

        public void setPlayerName(String playerName) {
            PlayerName = playerName;
        }

        public String getPlayerPic() {
            return PlayerPic;
        }

        public void setPlayerPic(String playerPic) {
            PlayerPic = playerPic;
        }

        public String getPlayerSalary() {
            return PlayerSalary;
        }

        public void setPlayerSalary(String playerSalary) {
            PlayerSalary = playerSalary;
        }

        public String getPlayerID() {
            return PlayerID;
        }

        public void setPlayerID(String playerID) {
            PlayerID = playerID;
        }
    }
}
