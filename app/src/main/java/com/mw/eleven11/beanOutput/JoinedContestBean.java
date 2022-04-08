package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JoinedContestBean {


    /**
     * code : 200
     * response : [{"id":"719","user_invite_code":"JMGZWZ31","match_type":"0","contest_name":"Practice","total_winning_amount":"0","contest_size":"15","team_entry_fee":"0.00","chip":"0","number_of_winners":"5","fixture_contest_type":"6","is_multientry":"1","confirm_contest":"0","mega_contest":"0","user_team_id":"903","match_id":"38385","team_name":"Team 1","status":"0","match_team":"SL v/s SA","match_date_time":"2018-07-20 10:00","total_join_team":10,"spots_left":5,"join_in_team":[{"user_id":"362","team_id":"898","team_code":"TEST141052","team_name":"Team 1"},{"user_id":"348","team_id":"899","team_code":"NISHA26565","team_name":"Team 1"},{"user_id":"351","team_id":"940","team_code":"TARUN52754","team_name":"Team 1"},{"user_id":"351","team_id":"941","team_code":"TARUN52754","team_name":"Team 2"},{"user_id":"351","team_id":"942","team_code":"TARUN52754","team_name":"Team 3"},{"user_id":"351","team_id":"944","team_code":"TARUN52754","team_name":"Team 5"},{"user_id":"362","team_id":"939","team_code":"TEST141052","team_name":"Team 3"},{"user_id":"1","team_id":"903","team_code":"ADMIN00777","team_name":"Team 1"},{"user_id":"351","team_id":"943","team_code":"TARUN52754","team_name":"Team 4"},{"user_id":"351","team_id":"945","team_code":"TARUN52754","team_name":"Team 6"}],"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"my_rank":{"name":"The","profile_pic":"http://159.65.147.114/fantasy11/uploads/users/1524058514_49091.png","user_id":"1","team_code":"ADMIN00777","team_name":"Team 1","team_id":"903","points":"0","rank":"0","price":0}}]
     * status : 1
     * message : Contest found successfully
     */


    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("response")
    private List<ResponseBean> response;

    public static List<JoinedContestBean> arrayJoinedContestBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<JoinedContestBean>>() {
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
         * id : 719
         * user_invite_code : JMGZWZ31
         * match_type : 0
         * contest_name : Practice
         * total_winning_amount : 0
         * contest_size : 15
         * team_entry_fee : 0.00
         * chip : 0
         * number_of_winners : 5
         * fixture_contest_type : 6
         * is_multientry : 1
         * confirm_contest : 0
         * mega_contest : 0
         * user_team_id : 903
         * match_id : 38385
         * team_name : Team 1
         * status : 0
         * match_team : SL v/s SA
         * match_date_time : 2018-07-20 10:00
         * total_join_team : 10
         * spots_left : 5
         * join_in_team : [{"user_id":"362","team_id":"898","team_code":"TEST141052","team_name":"Team 1"},{"user_id":"348","team_id":"899","team_code":"NISHA26565","team_name":"Team 1"},{"user_id":"351","team_id":"940","team_code":"TARUN52754","team_name":"Team 1"},{"user_id":"351","team_id":"941","team_code":"TARUN52754","team_name":"Team 2"},{"user_id":"351","team_id":"942","team_code":"TARUN52754","team_name":"Team 3"},{"user_id":"351","team_id":"944","team_code":"TARUN52754","team_name":"Team 5"},{"user_id":"362","team_id":"939","team_code":"TEST141052","team_name":"Team 3"},{"user_id":"1","team_id":"903","team_code":"ADMIN00777","team_name":"Team 1"},{"user_id":"351","team_id":"943","team_code":"TARUN52754","team_name":"Team 4"},{"user_id":"351","team_id":"945","team_code":"TARUN52754","team_name":"Team 6"}]
         * winners_rank : [{"rank":"1","prize":"100","prize_percentage":"100.00"}]
         * my_rank : {"name":"The","profile_pic":"http://159.65.147.114/fantasy11/uploads/users/1524058514_49091.png","user_id":"1","team_code":"ADMIN00777","team_name":"Team 1","team_id":"903","points":"0","rank":"0","price":0}
         */

        @SerializedName("id")
        private String id;
        @SerializedName("user_invite_code")
        private String userInviteCode;
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
        @SerializedName("fixture_contest_type")
        private String fixtureContestType;
        @SerializedName("is_multientry")
        private String isMultientry;
        @SerializedName("confirm_contest")
        private String confirmContest;
        @SerializedName("mega_contest")
        private String megaContest;
        @SerializedName("user_team_id")
        private String userTeamId;
        @SerializedName("match_id")
        private String matchId;
        @SerializedName("team_name")
        private String teamName;

        @SerializedName("status")
        private String status;
        @SerializedName("match_team")
        private String matchTeam;
        @SerializedName("match_date_time")
        private String matchDateTime;
        @SerializedName("total_join_team")
        private int totalJoinTeam;
        @SerializedName("spots_left")
        private int spotsLeft;
        @SerializedName("my_rank")
        private MyRankBean myRank;
        @SerializedName("join_in_team")
        private List<JoinInTeamBean> joinInTeam;
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

        public String getUserInviteCode() {
            return userInviteCode;
        }

        public void setUserInviteCode(String userInviteCode) {
            this.userInviteCode = userInviteCode;
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

        public String getFixtureContestType() {
            return fixtureContestType;
        }

        public void setFixtureContestType(String fixtureContestType) {
            this.fixtureContestType = fixtureContestType;
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

        public String getUserTeamId() {
            return userTeamId;
        }

        public void setUserTeamId(String userTeamId) {
            this.userTeamId = userTeamId;
        }

        public String getMatchId() {
            return matchId;
        }

        public void setMatchId(String matchId) {
            this.matchId = matchId;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMatchTeam() {
            return matchTeam;
        }

        public void setMatchTeam(String matchTeam) {
            this.matchTeam = matchTeam;
        }

        public String getMatchDateTime() {
            return matchDateTime;
        }

        public void setMatchDateTime(String matchDateTime) {
            this.matchDateTime = matchDateTime;
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

        public MyRankBean getMyRank() {
            return myRank;
        }

        public void setMyRank(MyRankBean myRank) {
            this.myRank = myRank;
        }

        public List<JoinInTeamBean> getJoinInTeam() {
            return joinInTeam;
        }

        public void setJoinInTeam(List<JoinInTeamBean> joinInTeam) {
            this.joinInTeam = joinInTeam;
        }

        public List<WinnersRankBean> getWinnersRank() {
            return winnersRank;
        }

        public void setWinnersRank(List<WinnersRankBean> winnersRank) {
            this.winnersRank = winnersRank;
        }

        public static class MyRankBean {
            /**
             * name : The
             * profile_pic : http://159.65.147.114/fantasy11/uploads/users/1524058514_49091.png
             * user_id : 1
             * team_code : ADMIN00777
             * team_name : Team 1
             * team_id : 903
             * points : 0
             * rank : 0
             * price : 0
             */

            @SerializedName("name")
            private String name;
            @SerializedName("profile_pic")
            private String profilePic;
            @SerializedName("user_id")
            private String userId;
            @SerializedName("team_code")
            private String teamCode;
            @SerializedName("team_name")
            private String teamName;
            @SerializedName("team_id")
            private String teamId;
            @SerializedName("points")
            private String points;
            @SerializedName("rank")
            private String rank;
            @SerializedName("price")
            private int price;

            public static List<MyRankBean> arrayMyRankBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<MyRankBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getProfilePic() {
                return profilePic;
            }

            public void setProfilePic(String profilePic) {
                this.profilePic = profilePic;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getTeamCode() {
                return teamCode;
            }

            public void setTeamCode(String teamCode) {
                this.teamCode = teamCode;
            }

            public String getTeamName() {
                return teamName;
            }

            public void setTeamName(String teamName) {
                this.teamName = teamName;
            }

            public String getTeamId() {
                return teamId;
            }

            public void setTeamId(String teamId) {
                this.teamId = teamId;
            }

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }
        }

        public static class JoinInTeamBean {
            /**
             * user_id : 362
             * team_id : 898
             * team_code : TEST141052
             * team_name : Team 1
             */

            @SerializedName("user_id")
            private String userId;
            @SerializedName("team_id")
            private String teamId;
            @SerializedName("team_code")
            private String teamCode;
            @SerializedName("team_name")
            private String teamName;

            public static List<JoinInTeamBean> arrayJoinInTeamBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<JoinInTeamBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getTeamId() {
                return teamId;
            }

            public void setTeamId(String teamId) {
                this.teamId = teamId;
            }

            public String getTeamCode() {
                return teamCode;
            }

            public void setTeamCode(String teamCode) {
                this.teamCode = teamCode;
            }

            public String getTeamName() {
                return teamName;
            }

            public void setTeamName(String teamName) {
                this.teamName = teamName;
            }
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
