package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SinglePlayerData {

    @SerializedName("ResponseCode")
    @Expose
    private String responseCode;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private SinglePlayerDataBean data;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SinglePlayerDataBean getData() {
        return data;
    }

    public void setData(SinglePlayerDataBean data) {
        this.data = data;
    }

    public class SinglePlayerDataBean {

        @SerializedName("PlayerGUID")
        @Expose
        private String playerGUID;
        @SerializedName("PlayerName")
        @Expose
        private String playerName;
        @SerializedName("PlayerBattingStyle")
        @Expose
        private String playerBattingStyle;
        @SerializedName("PlayerBowlingStyle")
        @Expose
        private String playerBowlingStyle;
        @SerializedName("PlayerID")
        @Expose
        private String playerID;
        @SerializedName("PlayerRole")
        @Expose
        private String playerRole;
        @SerializedName("TeamNameShort")
        @Expose
        private String TeamNameShort;
        @SerializedName("PlayerPic")
        @Expose
        private String playerPic;
        @SerializedName("PlayerCountry")
        @Expose
        private String playerCountry;
        @SerializedName("MatchType")
        @Expose
        private String matchType;
        @SerializedName("TeamGUID")
        @Expose
        private String teamGUID;

        @SerializedName("TotalPoints")
        @Expose
        private String totalPoints;

        @SerializedName("PlayerSalary")
        @Expose
        private String playerSalary;
        @SerializedName("PointCredits")
        @Expose
        private String pointCredits;

        public String getPlayerGUID() {
            return playerGUID;
        }

        public void setPlayerGUID(String playerGUID) {
            this.playerGUID = playerGUID;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public String getPlayerBattingStyle() {
            return playerBattingStyle;
        }

        public void setPlayerBattingStyle(String playerBattingStyle) {
            this.playerBattingStyle = playerBattingStyle;
        }

        public String getPlayerBowlingStyle() {
            return playerBowlingStyle;
        }

        public void setPlayerBowlingStyle(String playerBowlingStyle) {
            this.playerBowlingStyle = playerBowlingStyle;
        }

        public String getPlayerID() {
            return playerID;
        }

        public void setPlayerID(String playerID) {
            this.playerID = playerID;
        }

        public String getPlayerRole() {
            return playerRole;
        }

        public void setPlayerRole(String playerRole) {
            this.playerRole = playerRole;
        }

        public String getPlayerPic() {
            return playerPic;
        }

        public void setPlayerPic(String playerPic) {
            this.playerPic = playerPic;
        }

        public String getPlayerCountry() {
            return playerCountry;
        }

        public void setPlayerCountry(String playerCountry) {
            this.playerCountry = playerCountry;
        }

        public String getMatchType() {
            return matchType;
        }

        public void setMatchType(String matchType) {
            this.matchType = matchType;
        }

        public String getTeamGUID() {
            return teamGUID;
        }

        public void setTeamGUID(String teamGUID) {
            this.teamGUID = teamGUID;
        }



        public String getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(String totalPoints) {
            this.totalPoints = totalPoints;
        }

        public String getPlayerSalary() {
            return playerSalary;
        }

        public void setPlayerSalary(String playerSalary) {
            this.playerSalary = playerSalary;
        }

        public String getPointCredits() {
            return pointCredits;
        }

        public void setPointCredits(String pointCredits) {
            this.pointCredits = pointCredits;
        }

        public String getTeamNameShort() {
            return TeamNameShort;
        }

        public void setTeamNameShort(String teamNameShort) {
            TeamNameShort = teamNameShort;
        }
    }
}
