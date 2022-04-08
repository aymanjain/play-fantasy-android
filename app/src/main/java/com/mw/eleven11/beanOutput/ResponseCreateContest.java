package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mobiweb on 9/3/18.
 */

public class ResponseCreateContest {


    /**
     * code : 200
     * response : {"id":"41","match_type":"1","contest_name":"Win Rs.500","total_winning_amount":"500","contest_size":"50","team_entry_fee":"11.50","number_of_winners":"50","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"ZQ1XOD71","chip":"0","is_user_joined":0,"winners_rank":[{"rank":"1 - 50","prize":"10"}],"total_join_team":0}
     * status : 1
     * message : Contest Created successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("response")
    private ResponseBean response;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
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

    public static class ResponseBean {
        /**
         * id : 41
         * match_type : 1
         * contest_name : Win Rs.500
         * total_winning_amount : 500
         * contest_size : 50
         * team_entry_fee : 11.50
         * number_of_winners : 50
         * is_multientry : 0
         * confirm_contest : 1
         * mega_contest : 0
         * user_invite_code : ZQ1XOD71
         * chip : 0
         * is_user_joined : 0
         * winners_rank : [{"rank":"1 - 50","prize":"10"}]
         * total_join_team : 0
         */

        @SerializedName("id")
        private String id;
        @SerializedName("match_type")
        private String matchType;
        @SerializedName("contest_name")
        private String contestName;
        @SerializedName("total_winning_amount")
        private String totalWinningAmount;
        @SerializedName("contest_size")
        private String contestSize;
        @SerializedName("team_entry_fee")
        private String teamEntryFee;
        @SerializedName("number_of_winners")
        private String numberOfWinners;
        @SerializedName("is_multientry")
        private String isMultientry;
        @SerializedName("confirm_contest")
        private String confirmContest;
        @SerializedName("mega_contest")
        private String megaContest;
        @SerializedName("user_invite_code")
        private String userInviteCode;
        @SerializedName("chip")
        private String chip = "";
        @SerializedName("is_user_joined")
        private int isUserJoined;
        @SerializedName("total_join_team")
        private int totalJoinTeam;
        @SerializedName("winners_rank")
        private List<WinnersRankBean> winnersRank;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMatchType() {
            return matchType;
        }

        public void setMatchType(String matchType) {
            this.matchType = matchType;
        }

        public String getContestName() {
            return contestName;
        }

        public void setContestName(String contestName) {
            this.contestName = contestName;
        }

        public String getTotalWinningAmount() {
            return totalWinningAmount;
        }

        public void setTotalWinningAmount(String totalWinningAmount) {
            this.totalWinningAmount = totalWinningAmount;
        }

        public String getContestSize() {
            return contestSize;
        }

        public void setContestSize(String contestSize) {
            this.contestSize = contestSize;
        }

        public String getTeamEntryFee() {
            return teamEntryFee;
        }

        public void setTeamEntryFee(String teamEntryFee) {
            this.teamEntryFee = teamEntryFee;
        }

        public String getNumberOfWinners() {
            return numberOfWinners;
        }

        public void setNumberOfWinners(String numberOfWinners) {
            this.numberOfWinners = numberOfWinners;
        }

        public String getIsMultientry() {
            return isMultientry;
        }

        public void setIsMultientry(String isMultientry) {
            this.isMultientry = isMultientry;
        }

        public String getConfirmContest() {
            return confirmContest;
        }

        public void setConfirmContest(String confirmContest) {
            this.confirmContest = confirmContest;
        }

        public String getMegaContest() {
            return megaContest;
        }

        public void setMegaContest(String megaContest) {
            this.megaContest = megaContest;
        }

        public String getUserInviteCode() {
            return userInviteCode;
        }

        public void setUserInviteCode(String userInviteCode) {
            this.userInviteCode = userInviteCode;
        }

        public String getChip() {
            return chip;
        }

        public void setChip(String chip) {
            this.chip = chip;
        }

        public int getIsUserJoined() {
            return isUserJoined;
        }

        public void setIsUserJoined(int isUserJoined) {
            this.isUserJoined = isUserJoined;
        }

        public int getTotalJoinTeam() {
            return totalJoinTeam;
        }

        public void setTotalJoinTeam(int totalJoinTeam) {
            this.totalJoinTeam = totalJoinTeam;
        }

        public List<WinnersRankBean> getWinnersRank() {
            return winnersRank;
        }

        public void setWinnersRank(List<WinnersRankBean> winnersRank) {
            this.winnersRank = winnersRank;
        }

        public static class WinnersRankBean {
            /**
             * rank : 1 - 50
             * prize : 10
             */

            @SerializedName("rank")
            private String rank;
            @SerializedName("prize")
            private String prize;

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getPrize() {
                return prize;
            }

            public void setPrize(String prize) {
                this.prize = prize;
            }
        }
    }
}
