package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiweb on 22/3/18.
 */

public class ResponseContestDetails {


    /**
     * code : 200
     * match_detail : {"match_id":"37880","series_id":"111127","match_date":"2018-07-14","match_time":"10:00","status":"open","match_type":"odi","match_num":"2nd ODI","localteam_id":"490","localteam":"ENG","localteam_image":"http://159.65.147.114/fantasy11/https://cricket.entitysport.com/assets/uploads/2016/01/england.png","visitorteam_image":"http://159.65.147.114/fantasy11/https://cricket.entitysport.com/assets/uploads/2016/01/india.png","localteam_first_inning":"0","localteam_second_inning":"0","visitorteam_first_inning":"0","visitorteam_second_inning":"0","live_score_status":"0","visitorteam_id":"25","visitorteam":"IND","isContest":"YES","match_date_time":"2018-07-14 10:00:00","match_status":"FIXTURE","currentTime":"2018-07-13 11:54:08"}
     * my_team : 0
     * my_joined_contest : 0
     * response : {"tournament_code":"","contest_type":"1","chip":"0","user_invite_code":"JMGZWZ31","id":"710","match_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_id":"","team_entry_fee":"1000.00","number_of_winners":"1","is_multientry":"1","confirm_contest":"1","mega_contest":"0","match_id":"37880","winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"isSettle":"0","is_user_joined":0,"total_join_team":0,"spots_left":2}
     * status : 1
     * message : Contest found successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("match_detail")
    private MatchDetailBean matchDetail;
    @SerializedName("my_team")
    private String myTeam;
    @SerializedName("my_joined_contest")
    private String myJoinedContest;
    @SerializedName("response")
    private ResponseBean response;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public static List<ResponseContestDetails> arrayResponseContestDetailsFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ResponseContestDetails>>() {
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

    public MatchDetailBean getMatchDetail() {
        return matchDetail;
    }

    public void setMatchDetail(MatchDetailBean matchDetail) {
        this.matchDetail = matchDetail;
    }

    public String getMyTeam() {
        return myTeam;
    }

    public void setMyTeam(String myTeam) {
        this.myTeam = myTeam;
    }

    public String getMyJoinedContest() {
        return myJoinedContest;
    }

    public void setMyJoinedContest(String myJoinedContest) {
        this.myJoinedContest = myJoinedContest;
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

    public static class MatchDetailBean {
        /**
         * match_id : 37880
         * series_id : 111127
         * match_date : 2018-07-14
         * match_time : 10:00
         * status : open
         * match_type : odi
         * match_num : 2nd ODI
         * localteam_id : 490
         * localteam : ENG
         * localteam_image : http://159.65.147.114/fantasy11/https://cricket.entitysport.com/assets/uploads/2016/01/england.png
         * visitorteam_image : http://159.65.147.114/fantasy11/https://cricket.entitysport.com/assets/uploads/2016/01/india.png
         * localteam_first_inning : 0
         * localteam_second_inning : 0
         * visitorteam_first_inning : 0
         * visitorteam_second_inning : 0
         * live_score_status : 0
         * visitorteam_id : 25
         * visitorteam : IND
         * isContest : YES
         * match_date_time : 2018-07-14 10:00:00
         * match_status : FIXTURE
         * currentTime : 2018-07-13 11:54:08
         */

        @SerializedName("match_id")
        private String matchId;
        @SerializedName("series_id")
        private String seriesId;
        @SerializedName("match_date")
        private String matchDate;
        @SerializedName("match_time")
        private String matchTime;
        @SerializedName("status")
        private String status;
        @SerializedName("match_type")
        private String matchType;
        @SerializedName("match_num")
        private String matchNum;
        @SerializedName("localteam_id")
        private String localteamId;
        @SerializedName("localteam")
        private String localteam;
        @SerializedName("localteam_image")
        private String localteamImage;
        @SerializedName("visitorteam_image")
        private String visitorteamImage;
        @SerializedName("localteam_first_inning")
        private String localteamFirstInning;
        @SerializedName("localteam_second_inning")
        private String localteamSecondInning;
        @SerializedName("visitorteam_first_inning")
        private String visitorteamFirstInning;
        @SerializedName("visitorteam_second_inning")
        private String visitorteamSecondInning;
        @SerializedName("live_score_status")
        private String liveScoreStatus;
        @SerializedName("visitorteam_id")
        private String visitorteamId;
        @SerializedName("visitorteam")
        private String visitorteam;
        @SerializedName("isContest")
        private String isContest;
        @SerializedName("match_date_time")
        private String matchDateTime;
        @SerializedName("match_status")
        private String matchStatus;
        @SerializedName("currentTime")
        private String currentTime;

        public static List<MatchDetailBean> arrayMatchDetailBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<MatchDetailBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getMatchId() {
            return matchId;
        }

        public void setMatchId(String matchId) {
            this.matchId = matchId;
        }

        public String getSeriesId() {
            return seriesId;
        }

        public void setSeriesId(String seriesId) {
            this.seriesId = seriesId;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMatchType() {
            return matchType;
        }

        public void setMatchType(String matchType) {
            this.matchType = matchType;
        }

        public String getMatchNum() {
            return matchNum;
        }

        public void setMatchNum(String matchNum) {
            this.matchNum = matchNum;
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

        public String getLocalteamImage() {
            return localteamImage;
        }

        public void setLocalteamImage(String localteamImage) {
            this.localteamImage = localteamImage;
        }

        public String getVisitorteamImage() {
            return visitorteamImage;
        }

        public void setVisitorteamImage(String visitorteamImage) {
            this.visitorteamImage = visitorteamImage;
        }

        public String getLocalteamFirstInning() {
            return localteamFirstInning;
        }

        public void setLocalteamFirstInning(String localteamFirstInning) {
            this.localteamFirstInning = localteamFirstInning;
        }

        public String getLocalteamSecondInning() {
            return localteamSecondInning;
        }

        public void setLocalteamSecondInning(String localteamSecondInning) {
            this.localteamSecondInning = localteamSecondInning;
        }

        public String getVisitorteamFirstInning() {
            return visitorteamFirstInning;
        }

        public void setVisitorteamFirstInning(String visitorteamFirstInning) {
            this.visitorteamFirstInning = visitorteamFirstInning;
        }

        public String getVisitorteamSecondInning() {
            return visitorteamSecondInning;
        }

        public void setVisitorteamSecondInning(String visitorteamSecondInning) {
            this.visitorteamSecondInning = visitorteamSecondInning;
        }

        public String getLiveScoreStatus() {
            return liveScoreStatus;
        }

        public void setLiveScoreStatus(String liveScoreStatus) {
            this.liveScoreStatus = liveScoreStatus;
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

        public String getIsContest() {
            return isContest;
        }

        public void setIsContest(String isContest) {
            this.isContest = isContest;
        }

        public String getMatchDateTime() {
            return matchDateTime;
        }

        public void setMatchDateTime(String matchDateTime) {
            this.matchDateTime = matchDateTime;
        }

        public String getMatchStatus() {
            return matchStatus;
        }

        public void setMatchStatus(String matchStatus) {
            this.matchStatus = matchStatus;
        }

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }
    }

    public static class ResponseBean {
        /**
         * tournament_code :
         * contest_type : 1
         * chip : 0
         * user_invite_code : JMGZWZ31
         * id : 710
         * match_type : 1
         * contest_name : Win Rs.100
         * total_winning_amount : 100
         * contest_size : 2
         * team_id :
         * team_entry_fee : 1000.00
         * number_of_winners : 1
         * is_multientry : 1
         * confirm_contest : 1
         * mega_contest : 0
         * match_id : 37880
         * winners_rank : [{"rank":"1","prize":"100","prize_percentage":"100.00"}]
         * isSettle : 0
         * is_user_joined : 0
         * total_join_team : 0
         * spots_left : 2
         */

        @SerializedName("tournament_code")
        private String tournamentCode;
        @SerializedName("contest_type")
        private String contestType;
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
        @SerializedName("team_id")
        private String teamId;
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
        @SerializedName("is_user_joined")
        private int isUserJoined;
        @SerializedName("total_join_team")
        private int totalJoinTeam;
        @SerializedName("spots_left")
        private int spotsLeft;
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

        public String getTeamId() {
            return teamId;
        }

        public void setTeamId(String teamId) {
            this.teamId = teamId;
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

        public List<WinnersRankBean> getWinnersRank() {
            return winnersRank;
        }

        public void setWinnersRank(List<WinnersRankBean> winnersRank) {
            this.winnersRank = winnersRank;
        }

        public static class WinnersRankBean {
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
