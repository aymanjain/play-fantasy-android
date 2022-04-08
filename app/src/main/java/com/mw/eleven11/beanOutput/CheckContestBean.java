package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CheckContestBean implements Serializable {


    /**
     * code : 200
     * response : {"chip":"0","user_invite_code":"JMGZWZ31","id":"719","match_type":"0","contest_name":"Practice","total_winning_amount":"0","contest_size":"15","team_entry_fee":"0.00","number_of_winners":"5","is_multientry":"1","confirm_contest":"0","mega_contest":"0","match_id":"38385","winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"}],"isSettle":"0","series_id":"111270","game_type":1,"localteam_id":"21","localteam":"SL","visitorteam_id":"19","visitorteam":"SA","match_date_time":"2018-07-20 04:30:00","match_date":"2018-07-20","match_time":"04:30","currentTime":"2018-08-22 07:46:08","display_join_amount":0}
     * status : 1
     * message : Contest found successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("response")
    private ResponseBean response;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public static List<CheckContestBean> arrayCheckContestBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<CheckContestBean>>() {
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

    public static class ResponseBean implements Serializable {
        /**
         * chip : 0
         * user_invite_code : JMGZWZ31
         * id : 719
         * match_type : 0
         * contest_name : Practice
         * total_winning_amount : 0
         * contest_size : 15
         * team_entry_fee : 0.00
         * number_of_winners : 5
         * is_multientry : 1
         * confirm_contest : 0
         * mega_contest : 0
         * match_id : 38385
         * winners_rank : [{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"},{"rank":"1","prize":"100","prize_percentage":"100.00"}]
         * isSettle : 0
         * series_id : 111270
         * game_type : 1
         * localteam_id : 21
         * localteam : SL
         * visitorteam_id : 19
         * visitorteam : SA
         * match_date_time : 2018-07-20 04:30:00
         * match_date : 2018-07-20
         * match_time : 04:30
         * currentTime : 2018-08-22 07:46:08
         * display_join_amount : 0
         */

        @SerializedName("chip")
        private String chip;
        @SerializedName("user_invite_code")
        private String userInviteCode;
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
        @SerializedName("match_id")
        private String matchId;
        @SerializedName("isSettle")
        private String isSettle;
        @SerializedName("series_id")
        private String seriesId;
        @SerializedName("game_type")
        private int gameType;
        @SerializedName("localteam_id")
        private String localteamId;
        @SerializedName("localteam")
        private String localteam;
        @SerializedName("visitorteam_id")
        private String visitorteamId;
        @SerializedName("visitorteam")
        private String visitorteam;
        @SerializedName("match_date_time")
        private String matchDateTime;
        @SerializedName("match_date")
        private String matchDate;
        @SerializedName("match_time")
        private String matchTime;
        @SerializedName("currentTime")
        private String currentTime;
        @SerializedName("display_join_amount")
        private int displayJoinAmount;
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

        public String getChip() {
            return chip;
        }

        public void setChip(String chip) {
            this.chip = chip;
        }

        public String getUserInviteCode() {
            return userInviteCode;
        }

        public void setUserInviteCode(String userInviteCode) {
            this.userInviteCode = userInviteCode;
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

        public String getMatchId() {
            return matchId;
        }

        public void setMatchId(String matchId) {
            this.matchId = matchId;
        }

        public String getIsSettle() {
            return isSettle;
        }

        public void setIsSettle(String isSettle) {
            this.isSettle = isSettle;
        }

        public String getSeriesId() {
            return seriesId;
        }

        public void setSeriesId(String seriesId) {
            this.seriesId = seriesId;
        }

        public int getGameType() {
            return gameType;
        }

        public void setGameType(int gameType) {
            this.gameType = gameType;
        }

        public String getLocalteamId() {
            return localteamId;
        }

        public void setLocalteamId(String localteamId) {
            this.localteamId = localteamId;
        }

        public String getLocalteam() {
            return localteam;
        }

        public void setLocalteam(String localteam) {
            this.localteam = localteam;
        }

        public String getVisitorteamId() {
            return visitorteamId;
        }

        public void setVisitorteamId(String visitorteamId) {
            this.visitorteamId = visitorteamId;
        }

        public String getVisitorteam() {
            return visitorteam;
        }

        public void setVisitorteam(String visitorteam) {
            this.visitorteam = visitorteam;
        }

        public String getMatchDateTime() {
            return matchDateTime;
        }

        public void setMatchDateTime(String matchDateTime) {
            this.matchDateTime = matchDateTime;
        }

        public String getMatchDate() {
            return matchDate;
        }

        public void setMatchDate(String matchDate) {
            this.matchDate = matchDate;
        }

        public String getMatchTime() {
            return matchTime;
        }

        public void setMatchTime(String matchTime) {
            this.matchTime = matchTime;
        }

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

        public int getDisplayJoinAmount() {
            return displayJoinAmount;
        }

        public void setDisplayJoinAmount(int displayJoinAmount) {
            this.displayJoinAmount = displayJoinAmount;
        }

        public List<WinnersRankBean> getWinnersRank() {
            return winnersRank;
        }

        public void setWinnersRank(List<WinnersRankBean> winnersRank) {
            this.winnersRank = winnersRank;
        }

        public static class WinnersRankBean implements Serializable {
            /**
             * rank : 1
             * prize : 100
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
