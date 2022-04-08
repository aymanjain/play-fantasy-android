package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyTeamOutput {
    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"Statics":{"NormalContest":"0","ReverseContest":"0","JoinedContest":"0","TotalTeams":"0"},"TotalRecords":2,"Records":[{"UserTeamGUID":"f5f79ee4-deb2-c84e-f9f7-c993a8216c90","UserTeamName":" Team 2","UserTeamType":"Normal","UserTeamID":"341669","UserTeamPlayers":[{"PlayerGUID":"0a837f6e-26eb-1e6a-5570-0e0dfdec7d78","PlayerPosition":"Player","PlayerName":"Alyssa Healy","PlayerPic":"http://mwdemoserver.com/515-/api/uploads/PlayerPic/860a6b49-e887-c502-af78-11c99f9bfc78.png","PlayerCountry":"","PlayerRole":"WicketKeeper","Points":"0.00"},{"PlayerGUID":"79d1ecc2-cf40-e4cf-cfea-e84286daa272","PlayerPosition":"Player","PlayerName":"Heather Graham","PlayerPic":"http://mwdemoserver.com/515-/api/uploads/PlayerPic/f84482cd-6535-bb22-4a25-5d472f074108.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"c5b98ecd-aecd-dade-6c87-48a14fe2c839","PlayerPosition":"ViceCaptain","PlayerName":"Lauren Ebsary","PlayerPic":"http://mwdemoserver.com/515-/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"b2485620-6875-4ccf-0a27-de74367ae49f","PlayerPosition":"Player","PlayerName":"Mathilda Carmichael","PlayerPic":"http://mwdemoserver.com/515-/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"AllRounder","Points":"0.00"},{"PlayerGUID":"75f636fd-e2e2-1d00-1715-cec8ffee1f5a","PlayerPosition":"Captain","PlayerName":"Meg Lanning","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"9f0b2316-b48b-58ce-7eac-17ffc38e3b7f","PlayerPosition":"Player","PlayerName":"Nicole Bolton","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"d9d660b8-a38b-ab43-7538-e3a8f68d245f","PlayerPosition":"Player","PlayerName":"Piepa Cleary","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"b157e860-627e-de73-d578-214fee57e3f1","PlayerPosition":"Player","PlayerName":"Sarah Aley","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/181f8741-dfe5-b64b-70d0-d9b5924d3b52.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"decdacff-24d9-f8c6-08ef-1ee01c90ddaf","PlayerPosition":"Player","PlayerName":"Stella Campbell","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"0d9467d6-d35c-261b-b028-d56fca9310cf","PlayerPosition":"Player","PlayerName":"Tahlia Wilson","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/8aa69400-7150-7334-5579-423a027bab44.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"5b4daca5-f458-65d3-763b-fac013c669b5","PlayerPosition":"Player","PlayerName":"Taneale Peschel","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"AllRounder","Points":"0.00"}]},{"UserTeamGUID":"e54bdb8d-6e90-047e-f40e-1bfd889fae56","UserTeamName":" Team 1","UserTeamType":"Normal","UserTeamID":"341668","UserTeamPlayers":[{"PlayerGUID":"0a837f6e-26eb-1e6a-5570-0e0dfdec7d78","PlayerPosition":"Player","PlayerName":"Alyssa Healy","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/860a6b49-e887-c502-af78-11c99f9bfc78.png","PlayerCountry":"","PlayerRole":"WicketKeeper","Points":"0.00"},{"PlayerGUID":"79d1ecc2-cf40-e4cf-cfea-e84286daa272","PlayerPosition":"Player","PlayerName":"Heather Graham","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/f84482cd-6535-bb22-4a25-5d472f074108.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"c5b98ecd-aecd-dade-6c87-48a14fe2c839","PlayerPosition":"ViceCaptain","PlayerName":"Lauren Ebsary","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"b2485620-6875-4ccf-0a27-de74367ae49f","PlayerPosition":"Player","PlayerName":"Mathilda Carmichael","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"AllRounder","Points":"0.00"},{"PlayerGUID":"75f636fd-e2e2-1d00-1715-cec8ffee1f5a","PlayerPosition":"Captain","PlayerName":"Meg Lanning","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"9f0b2316-b48b-58ce-7eac-17ffc38e3b7f","PlayerPosition":"Player","PlayerName":"Nicole Bolton","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"d9d660b8-a38b-ab43-7538-e3a8f68d245f","PlayerPosition":"Player","PlayerName":"Piepa Cleary","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"b157e860-627e-de73-d578-214fee57e3f1","PlayerPosition":"Player","PlayerName":"Sarah Aley","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/181f8741-dfe5-b64b-70d0-d9b5924d3b52.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"decdacff-24d9-f8c6-08ef-1ee01c90ddaf","PlayerPosition":"Player","PlayerName":"Stella Campbell","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"0d9467d6-d35c-261b-b028-d56fca9310cf","PlayerPosition":"Player","PlayerName":"Tahlia Wilson","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/8aa69400-7150-7334-5579-423a027bab44.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"5b4daca5-f458-65d3-763b-fac013c669b5","PlayerPosition":"Player","PlayerName":"Taneale Peschel","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"AllRounder","Points":"0.00"}]}]}
     */

    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("Message")
    private String Message;
    @SerializedName("Data")
    private DataBean Data;

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

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * Statics : {"NormalContest":"0","ReverseContest":"0","JoinedContest":"0","TotalTeams":"0"}
         * TotalRecords : 2
         * Records : [{"UserTeamGUID":"f5f79ee4-deb2-c84e-f9f7-c993a8216c90","UserTeamName":" Team 2","UserTeamType":"Normal","UserTeamID":"341669","UserTeamPlayers":[{"PlayerGUID":"0a837f6e-26eb-1e6a-5570-0e0dfdec7d78","PlayerPosition":"Player","PlayerName":"Alyssa Healy","PlayerPic":"http://mwdemoserver.com/515-/api/uploads/PlayerPic/860a6b49-e887-c502-af78-11c99f9bfc78.png","PlayerCountry":"","PlayerRole":"WicketKeeper","Points":"0.00"},{"PlayerGUID":"79d1ecc2-cf40-e4cf-cfea-e84286daa272","PlayerPosition":"Player","PlayerName":"Heather Graham","PlayerPic":"http://mwdemoserver.com/515-/api/uploads/PlayerPic/f84482cd-6535-bb22-4a25-5d472f074108.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"c5b98ecd-aecd-dade-6c87-48a14fe2c839","PlayerPosition":"ViceCaptain","PlayerName":"Lauren Ebsary","PlayerPic":"http://mwdemoserver.com/515-/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"b2485620-6875-4ccf-0a27-de74367ae49f","PlayerPosition":"Player","PlayerName":"Mathilda Carmichael","PlayerPic":"http://mwdemoserver.com/515-/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"AllRounder","Points":"0.00"},{"PlayerGUID":"75f636fd-e2e2-1d00-1715-cec8ffee1f5a","PlayerPosition":"Captain","PlayerName":"Meg Lanning","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"9f0b2316-b48b-58ce-7eac-17ffc38e3b7f","PlayerPosition":"Player","PlayerName":"Nicole Bolton","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"d9d660b8-a38b-ab43-7538-e3a8f68d245f","PlayerPosition":"Player","PlayerName":"Piepa Cleary","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"b157e860-627e-de73-d578-214fee57e3f1","PlayerPosition":"Player","PlayerName":"Sarah Aley","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/181f8741-dfe5-b64b-70d0-d9b5924d3b52.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"decdacff-24d9-f8c6-08ef-1ee01c90ddaf","PlayerPosition":"Player","PlayerName":"Stella Campbell","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"0d9467d6-d35c-261b-b028-d56fca9310cf","PlayerPosition":"Player","PlayerName":"Tahlia Wilson","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/8aa69400-7150-7334-5579-423a027bab44.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"5b4daca5-f458-65d3-763b-fac013c669b5","PlayerPosition":"Player","PlayerName":"Taneale Peschel","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"AllRounder","Points":"0.00"}]},{"UserTeamGUID":"e54bdb8d-6e90-047e-f40e-1bfd889fae56","UserTeamName":" Team 1","UserTeamType":"Normal","UserTeamID":"341668","UserTeamPlayers":[{"PlayerGUID":"0a837f6e-26eb-1e6a-5570-0e0dfdec7d78","PlayerPosition":"Player","PlayerName":"Alyssa Healy","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/860a6b49-e887-c502-af78-11c99f9bfc78.png","PlayerCountry":"","PlayerRole":"WicketKeeper","Points":"0.00"},{"PlayerGUID":"79d1ecc2-cf40-e4cf-cfea-e84286daa272","PlayerPosition":"Player","PlayerName":"Heather Graham","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/f84482cd-6535-bb22-4a25-5d472f074108.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"c5b98ecd-aecd-dade-6c87-48a14fe2c839","PlayerPosition":"ViceCaptain","PlayerName":"Lauren Ebsary","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"b2485620-6875-4ccf-0a27-de74367ae49f","PlayerPosition":"Player","PlayerName":"Mathilda Carmichael","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"AllRounder","Points":"0.00"},{"PlayerGUID":"75f636fd-e2e2-1d00-1715-cec8ffee1f5a","PlayerPosition":"Captain","PlayerName":"Meg Lanning","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"9f0b2316-b48b-58ce-7eac-17ffc38e3b7f","PlayerPosition":"Player","PlayerName":"Nicole Bolton","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"d9d660b8-a38b-ab43-7538-e3a8f68d245f","PlayerPosition":"Player","PlayerName":"Piepa Cleary","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"b157e860-627e-de73-d578-214fee57e3f1","PlayerPosition":"Player","PlayerName":"Sarah Aley","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/181f8741-dfe5-b64b-70d0-d9b5924d3b52.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"decdacff-24d9-f8c6-08ef-1ee01c90ddaf","PlayerPosition":"Player","PlayerName":"Stella Campbell","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"0d9467d6-d35c-261b-b028-d56fca9310cf","PlayerPosition":"Player","PlayerName":"Tahlia Wilson","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/8aa69400-7150-7334-5579-423a027bab44.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"5b4daca5-f458-65d3-763b-fac013c669b5","PlayerPosition":"Player","PlayerName":"Taneale Peschel","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"AllRounder","Points":"0.00"}]}]
         */

        @SerializedName("Statics")
        private StaticsBean Statics;
        @SerializedName("TotalRecords")
        private int TotalRecords;
        @SerializedName("Records")
        private List<RecordsBean> Records;

        public StaticsBean getStatics() {
            return Statics;
        }

        public void setStatics(StaticsBean Statics) {
            this.Statics = Statics;
        }

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int TotalRecords) {
            this.TotalRecords = TotalRecords;
        }

        public List<RecordsBean> getRecords() {
            return Records;
        }

        public void setRecords(List<RecordsBean> Records) {
            this.Records = Records;
        }

        public static class StaticsBean {
            /**
             * NormalContest : 0
             * ReverseContest : 0
             * JoinedContest : 0
             * TotalTeams : 0
             */

            @SerializedName("NormalContest")
            private String NormalContest;
            @SerializedName("ReverseContest")
            private String ReverseContest;
            @SerializedName("JoinedContest")
            private String JoinedContest;
            @SerializedName("TotalTeams")
            private String TotalTeams;

            public String getNormalContest() {
                return NormalContest;
            }

            public void setNormalContest(String NormalContest) {
                this.NormalContest = NormalContest;
            }

            public String getReverseContest() {
                return ReverseContest;
            }

            public void setReverseContest(String ReverseContest) {
                this.ReverseContest = ReverseContest;
            }

            public String getJoinedContest() {
                return JoinedContest;
            }

            public void setJoinedContest(String JoinedContest) {
                this.JoinedContest = JoinedContest;
            }

            public String getTotalTeams() {
                return TotalTeams;
            }

            public void setTotalTeams(String TotalTeams) {
                this.TotalTeams = TotalTeams;
            }
        }

        public static class RecordsBean {
            /**
             * UserTeamGUID : f5f79ee4-deb2-c84e-f9f7-c993a8216c90
             * UserTeamName :  Team 2
             * UserTeamType : Normal
             * UserTeamID : 341669
             * UserTeamPlayers : [{"PlayerGUID":"0a837f6e-26eb-1e6a-5570-0e0dfdec7d78","PlayerPosition":"Player","PlayerName":"Alyssa Healy","PlayerPic":"http://mwdemoserver.com/515-/api/uploads/PlayerPic/860a6b49-e887-c502-af78-11c99f9bfc78.png","PlayerCountry":"","PlayerRole":"WicketKeeper","Points":"0.00"},{"PlayerGUID":"79d1ecc2-cf40-e4cf-cfea-e84286daa272","PlayerPosition":"Player","PlayerName":"Heather Graham","PlayerPic":"http://mwdemoserver.com/515-/api/uploads/PlayerPic/f84482cd-6535-bb22-4a25-5d472f074108.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"c5b98ecd-aecd-dade-6c87-48a14fe2c839","PlayerPosition":"ViceCaptain","PlayerName":"Lauren Ebsary","PlayerPic":"http://mwdemoserver.com/515-/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"b2485620-6875-4ccf-0a27-de74367ae49f","PlayerPosition":"Player","PlayerName":"Mathilda Carmichael","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"AllRounder","Points":"0.00"},{"PlayerGUID":"75f636fd-e2e2-1d00-1715-cec8ffee1f5a","PlayerPosition":"Captain","PlayerName":"Meg Lanning","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"9f0b2316-b48b-58ce-7eac-17ffc38e3b7f","PlayerPosition":"Player","PlayerName":"Nicole Bolton","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"d9d660b8-a38b-ab43-7538-e3a8f68d245f","PlayerPosition":"Player","PlayerName":"Piepa Cleary","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"b157e860-627e-de73-d578-214fee57e3f1","PlayerPosition":"Player","PlayerName":"Sarah Aley","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/181f8741-dfe5-b64b-70d0-d9b5924d3b52.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"decdacff-24d9-f8c6-08ef-1ee01c90ddaf","PlayerPosition":"Player","PlayerName":"Stella Campbell","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"Bowler","Points":"0.00"},{"PlayerGUID":"0d9467d6-d35c-261b-b028-d56fca9310cf","PlayerPosition":"Player","PlayerName":"Tahlia Wilson","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/8aa69400-7150-7334-5579-423a027bab44.png","PlayerCountry":"","PlayerRole":"Batsman","Points":"0.00"},{"PlayerGUID":"5b4daca5-f458-65d3-763b-fac013c669b5","PlayerPosition":"Player","PlayerName":"Taneale Peschel","PlayerPic":"http://mwdemoserver.com/515-MyMatch11/api/uploads/PlayerPic/player.png","PlayerCountry":"","PlayerRole":"AllRounder","Points":"0.00"}]
             */

            @SerializedName("is_user_joined_team")
            private int is_user_joined_team;

            @SerializedName("is_select")
            private boolean isSelect;

            @SerializedName("team_id")
            private String teamId = "";

            @SerializedName("UserTeamGUID")
            private String UserTeamGUID;
            @SerializedName("Playing11Announce")
            private String Playing11Announce;
            @SerializedName("UserTeamName")
            private String UserTeamName;
            @SerializedName("UserTeamType")
            private String UserTeamType;
            @SerializedName("UserTeamID")
            private String UserTeamID;

            public String getIsTeamJoined() {
                return IsTeamJoined;
            }

            public void setIsTeamJoined(String isTeamJoined) {
                IsTeamJoined = isTeamJoined;
            }

            @SerializedName("IsTeamJoined")
            private String IsTeamJoined;


            public int getIs_user_joined_team() {
                return is_user_joined_team;
            }

            public void setIs_user_joined_team(int is_user_joined_team) {
                this.is_user_joined_team = is_user_joined_team;
            }

            public boolean isSelect() {
                return isSelect;
            }

            public void setSelect(boolean select) {
                isSelect = select;
            }

            public String getTeamId() {
                return teamId;
            }

            public void setTeamId(String teamId) {
                this.teamId = teamId;
            }

            @SerializedName("UserTeamPlayers")



            private List<UserTeamPlayersBean> UserTeamPlayers;

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

            public String getUserTeamType() {
                return UserTeamType;
            }

            public void setUserTeamType(String UserTeamType) {
                this.UserTeamType = UserTeamType;
            }

            public String getUserTeamID() {
                return UserTeamID;
            }

            public void setUserTeamID(String UserTeamID) {
                this.UserTeamID = UserTeamID;
            }

            public List<UserTeamPlayersBean> getUserTeamPlayers() {
                return UserTeamPlayers;
            }

            public void setUserTeamPlayers(List<UserTeamPlayersBean> UserTeamPlayers) {
                this.UserTeamPlayers = UserTeamPlayers;
            }

            public String getPlaying11Announce() {
                return Playing11Announce;
            }

            public void setPlaying11Announce(String playing11Announce) {
                Playing11Announce = playing11Announce;
            }

            public static class UserTeamPlayersBean {
                /**
                 * PlayerGUID : 0a837f6e-26eb-1e6a-5570-0e0dfdec7d78
                 * PlayerPosition : Player
                 * PlayerName : Alyssa Healy
                 * PlayerPic : http://mwdemoserver.com/515-/api/uploads/PlayerPic/860a6b49-e887-c502-af78-11c99f9bfc78.png
                 * PlayerCountry :
                 * PlayerRole : WicketKeeper
                 * Points : 0.00
                 */

                @SerializedName("PlayerGUID")
                private String PlayerGUID;
                @SerializedName("PlayerPosition")
                private String PlayerPosition;
                @SerializedName("PlayerName")
                private String PlayerName;
                @SerializedName("PlayerPic")
                private String PlayerPic;
                @SerializedName("PlayerCountry")
                private String PlayerCountry;
                @SerializedName("PlayerRole")
                private String PlayerRole;
                @SerializedName("TeamNameShort")
                private String TeamNameShort;
                @SerializedName("PlayerSelectedPercent")
                private String PlayerSelectedPercent;

                public String getPlayerSelectedPercent() {
                    return PlayerSelectedPercent;
                }

                public void setPlayerSelectedPercent(String playerSelectedPercent) {
                    PlayerSelectedPercent = playerSelectedPercent;
                }

                public String getPlayerBattingStyle() {
                    return PlayerBattingStyle;
                }

                public void setPlayerBattingStyle(String playerBattingStyle) {
                    PlayerBattingStyle = playerBattingStyle;
                }

                public String getPlayerBowlingStyle() {
                    return PlayerBowlingStyle;
                }

                public void setPlayerBowlingStyle(String playerBowlingStyle) {
                    PlayerBowlingStyle = playerBowlingStyle;
                }

                public String getPointCredits() {
                    return PointCredits;
                }

                public void setPointCredits(String pointCredits) {
                    PointCredits = pointCredits;
                }

                @SerializedName("PlayerBattingStyle")
                private String PlayerBattingStyle;

                @SerializedName("PlayerBowlingStyle")
                private String PlayerBowlingStyle;

                @SerializedName("PointCredits")
                private String PointCredits;

                @SerializedName("Points")
                private String Points;

                @SerializedName("IsPlaying")
                private String IsPlaying;

                public String getPlayerSalary() {
                    return PlayerSalary;
                }

                public void setPlayerSalary(String playerSalary) {
                    PlayerSalary = playerSalary;
                }

                @SerializedName("PlayerSalary")
                private  String PlayerSalary;


                @SerializedName("TotalPointCredits")
                private  String TotalPointCredits;

                public String getTotalPointCredits() {
                    return TotalPointCredits;
                }

                public void setTotalPointCredits(String totalPointCredits) {
                    TotalPointCredits = totalPointCredits;
                }

                @SerializedName("TeamGUID")
                private String TeamGUID;

                public String getTeamGUID() {
                    return TeamGUID;
                }

                public void setTeamGUID(String teamGUID) {
                    TeamGUID = teamGUID;
                }

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

                public String getPlayerPic() {
                    return PlayerPic;
                }

                public void setPlayerPic(String PlayerPic) {
                    this.PlayerPic = PlayerPic;
                }

                public String getPlayerCountry() {
                    return PlayerCountry;
                }

                public void setPlayerCountry(String PlayerCountry) {
                    this.PlayerCountry = PlayerCountry;
                }

                public String getPlayerRole() {
                    return PlayerRole;
                }

                public void setPlayerRole(String PlayerRole) {
                    this.PlayerRole = PlayerRole;
                }

                public String getPoints() {
                    return Points;
                }

                public void setPoints(String Points) {
                    this.Points = Points;
                }

                public String getIsPlaying() {
                    return IsPlaying;
                }

                public void setIsPlaying(String isPlaying) {
                    IsPlaying = isPlaying;
                }

                public String getTeamNameShort() {
                    return TeamNameShort;
                }

                public void setTeamNameShort(String teamNameShort) {
                    TeamNameShort = teamNameShort;
                }
            }
        }
    }





}