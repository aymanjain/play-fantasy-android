package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResponseAllContest {

    /**
     * code : 200
     * response : [{"id":"364","match_type":"0","contest_name":"foot","total_winning_amount":"0","contest_size":"2","team_entry_fee":"0.00","chip":"0","number_of_winners":"2","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"EWGPZK84","display_join_amount":0,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1 - 2","prize":"0","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2,"total_my_join_team":0},{"id":"385","match_type":"1","contest_name":"Win Rs.300","total_winning_amount":"300","contest_size":"20","team_entry_fee":"18.00","chip":"0","number_of_winners":"20","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JELIPM61","display_join_amount":18,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"150","prize_percentage":"50.00"},{"rank":"2 - 20","prize":"7","prize_percentage":"50.00"}],"total_join_team":1,"spots_left":19,"total_my_join_team":0}]
     * total_contests : 2
     * total_joined_contests : 0
     * total_created_team : 0
     * status : 1
     * message : Contest found successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("total_contests")
    private int totalContests;
    @SerializedName("total_joined_contests")
    private int totalJoinedContests;
    @SerializedName("total_created_team")
    private int totalCreatedTeam;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("response")
    private List<ResponseBean> response;

    public static List<ResponseAllContest> arrayResponseAllContestFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ResponseAllContest>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotalContests() {
        return totalContests;
    }

    public void setTotalContests(int totalContests) {
        this.totalContests = totalContests;
    }

    public int getTotalJoinedContests() {
        return totalJoinedContests;
    }

    public void setTotalJoinedContests(int totalJoinedContests) {
        this.totalJoinedContests = totalJoinedContests;
    }

    public int getTotalCreatedTeam() {
        return totalCreatedTeam;
    }

    public void setTotalCreatedTeam(int totalCreatedTeam) {
        this.totalCreatedTeam = totalCreatedTeam;
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

    public List<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseBean> response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * id : 364
         * match_type : 0
         * contest_name : foot
         * total_winning_amount : 0
         * contest_size : 2
         * team_entry_fee : 0.00
         * chip : 0
         * number_of_winners : 2
         * is_multientry : 0
         * confirm_contest : 1
         * mega_contest : 0
         * user_invite_code : EWGPZK84
         * display_join_amount : 0
         * tournament_code :
         * contest_type : 1
         * is_user_joined : 0
         * winners_rank : [{"rank":"1 - 2","prize":"0","prize_percentage":"100.00"}]
         * total_join_team : 0
         * spots_left : 2
         * total_my_join_team : 0
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
        @SerializedName("chip")
        private String chip;
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
        @SerializedName("display_join_amount")
        private int displayJoinAmount;
        @SerializedName("tournament_code")
        private String tournamentCode;
        @SerializedName("contest_type")
        private String contestType;
        @SerializedName("is_user_joined")
        private int isUserJoined;
        @SerializedName("total_join_team")
        private int totalJoinTeam;
        @SerializedName("spots_left")
        private int spotsLeft;
        @SerializedName("total_my_join_team")
        private int totalMyJoinTeam;
        @SerializedName("winners_rank")
        private List<WinnersRankBean> winnersRank;

        public static List<ResponseBean> arrayResponseBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ResponseBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

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

        public String getChip() {
            return chip;
        }

        public void setChip(String chip) {
            this.chip = chip;
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

        public int getDisplayJoinAmount() {
            return displayJoinAmount;
        }

        public void setDisplayJoinAmount(int displayJoinAmount) {
            this.displayJoinAmount = displayJoinAmount;
        }

        public String getTournamentCode() {
            return tournamentCode;
        }

        public void setTournamentCode(String tournamentCode) {
            this.tournamentCode = tournamentCode;
        }

        public String getContestType() {
            return contestType;
        }

        public void setContestType(String contestType) {
            this.contestType = contestType;
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

        public int getSpotsLeft() {
            return spotsLeft;
        }

        public void setSpotsLeft(int spotsLeft) {
            this.spotsLeft = spotsLeft;
        }

        public int getTotalMyJoinTeam() {
            return totalMyJoinTeam;
        }

        public void setTotalMyJoinTeam(int totalMyJoinTeam) {
            this.totalMyJoinTeam = totalMyJoinTeam;
        }

        public List<WinnersRankBean> getWinnersRank() {
            return winnersRank;
        }

        public void setWinnersRank(List<WinnersRankBean> winnersRank) {
            this.winnersRank = winnersRank;
        }

        public static class WinnersRankBean {
            /**
             * rank : 1 - 2
             * prize : 0
             * prize_percentage : 100.00
             */

            @SerializedName("rank")
            private String rank;
            @SerializedName("prize")
            private String prize;
            @SerializedName("prize_percentage")
            private String prizePercentage;

            public static List<WinnersRankBean> arrayWinnersRankBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<WinnersRankBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

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

            public String getPrizePercentage() {
                return prizePercentage;
            }

            public void setPrizePercentage(String prizePercentage) {
                this.prizePercentage = prizePercentage;
            }
        }
    }
}
