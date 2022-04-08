package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EditPlayerInAssistantInput {

    /**
     * SeriesGUID : db856266-3f6a-bef6-239c-3f67f3e87019
     * SessionKey : 10036b4e-0832-4875-b2b3-356e4c4be633
     * ContestGUID : 7e786931-cb56-6676-3169-ee240ff29a4f
     * UserTeamType : Auction
     * IsPreTeam : Yes
     * UserTeamGUID : 47aed40e-ff56-d66b-b8ca-1a71a0d43afd
     * UserTeamName : PreAuctionTeam 1
     * UserTeamPlayers : [{"PlayerGUID":"e6257050-237d-a88e-2d46-4e5e07aa5440","PlayerPosition":"Player","PlayerName":"Shimron Hetmyer","PlayerID":"353347","BidCredit":"400000"}]
     */

  /*  @SerializedName("SeriesGUID")
    private String SeriesGUID;*/
    @SerializedName("RoundID")
    private String RoundID;


    @SerializedName("MatchGUID")
    private String MatchGUID;

    @SerializedName("SeriesID")
    private String SeriesID;

    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("ContestGUID")
    private String ContestGUID;
    @SerializedName("UserTeamType")
    private String UserTeamType;
    @SerializedName("IsPreTeam")
    private String IsPreTeam;
    @SerializedName("UserTeamGUID")
    private String UserTeamGUID;
    @SerializedName("UserTeamName")
    private String UserTeamName;
    private List<UserTeamPlayersBean> UserTeamPlayers;

    public String getRoundID() {
        return RoundID;
    }

    public void setRoundID(String roundID) {
        RoundID = roundID;
    }

    public String getSeriesID() {
        return SeriesID;
    }

    public void setSeriesID(String seriesID) {
        SeriesID = seriesID;
    }

    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String matchGUID) {
        MatchGUID = matchGUID;
    }


    /*
    public String getSeriesGUID() {
        return SeriesGUID;
    }

    public void setSeriesGUID(String SeriesGUID) {
        this.SeriesGUID = SeriesGUID;
    }*/

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getContestGUID() {
        return ContestGUID;
    }

    public void setContestGUID(String ContestGUID) {
        this.ContestGUID = ContestGUID;
    }

    public String getUserTeamType() {
        return UserTeamType;
    }

    public void setUserTeamType(String UserTeamType) {
        this.UserTeamType = UserTeamType;
    }

    public String getIsPreTeam() {
        return IsPreTeam;
    }

    public void setIsPreTeam(String IsPreTeam) {
        this.IsPreTeam = IsPreTeam;
    }

    public String getUserTeamGUID() {
        return UserTeamGUID;
    }

    public void setUserTeamGUID(String UserTeamGUID) {
        this.UserTeamGUID = UserTeamGUID;
    }

    public String getUserTeamName() {
        return UserTeamName;
    }

    public void setUserTeamName(String UserTeamName) {
        this.UserTeamName = UserTeamName;
    }

    public List<UserTeamPlayersBean> getUserTeamPlayers() {
        return UserTeamPlayers;
    }

    public void setUserTeamPlayers(List<UserTeamPlayersBean> UserTeamPlayers) {
        this.UserTeamPlayers = UserTeamPlayers;
    }

    public static class UserTeamPlayersBean {
        /**
         * PlayerGUID : e6257050-237d-a88e-2d46-4e5e07aa5440
         * PlayerPosition : Player
         * PlayerName : Shimron Hetmyer
         * PlayerID : 353347
         * BidCredit : 400000
         */

        @SerializedName("PlayerGUID")
        private String PlayerGUID;
        @SerializedName("PlayerPosition")
        private String PlayerPosition;
        @SerializedName("PlayerName")
        private String PlayerName;
        @SerializedName("PlayerID")
        private String PlayerID;
        @SerializedName("BidCredit")
        private String BidCredit;
        @SerializedName("PlayerRole")
        private String PlayerRole;
        @SerializedName("AuctionDraftAssistantPriority")
        private String AuctionDraftAssistantPriority;

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

        public void setPlayerName(String PlayerName) {
            this.PlayerName = PlayerName;
        }

        public String getPlayerID() {
            return PlayerID;
        }

        public void setPlayerID(String PlayerID) {
            this.PlayerID = PlayerID;
        }

        public String getBidCredit() {
            return BidCredit;
        }

        public void setBidCredit(String BidCredit) {
            this.BidCredit = BidCredit;
        }

        public String getPlayerRole() {
            return PlayerRole;
        }

        public void setPlayerRole(String playerRole) {
            PlayerRole = playerRole;
        }

        public String getAuctionDraftAssistantPriority() {
            return AuctionDraftAssistantPriority;
        }

        public void setAuctionDraftAssistantPriority(String auctionDraftAssistantPriority) {
            AuctionDraftAssistantPriority = auctionDraftAssistantPriority;
        }
    }
}
