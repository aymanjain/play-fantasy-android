package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResponseContest {


    /**
     * code : 200
     * response : {"limit":5,"hot_contest_total":8,"champions_contest_total":2,"head_contest_total":2,"winners_contest_total":2,"more_contest_total":2,"pratice_contest_total":2,"total_all_contest":17,"hot_contest":[{"id":"709","match_type":"1","fixture_contest_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"CCGOPH46","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"10000","prize_percentage":"100.00"},{"rank":"2 - 3","prize":"5000","prize_percentage":"100.00"},{"rank":"4 - 5","prize":"4000","prize_percentage":"100.00"},{"rank":"6 - 10","prize":"3000","prize_percentage":"100.00"},{"rank":"11 - 20","prize":"2000","prize_percentage":"100.00"},{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}],"total_join_team":1,"spots_left":1},{"id":"710","match_type":"1","fixture_contest_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"722","match_type":"1","fixture_contest_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"723","match_type":"1","fixture_contest_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"724","match_type":"1","fixture_contest_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}],"contest_for_champions":[{"id":"711","match_type":"1","fixture_contest_type":"2","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"712","match_type":"1","fixture_contest_type":"2","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}],"head_to_head":[{"id":"713","match_type":"1","fixture_contest_type":"3","contest_name":"Win Rs.1     00","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"714","match_type":"1","fixture_contest_type":"3","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}],"winner_takes_all":[{"id":"715","match_type":"1","fixture_contest_type":"4","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"716","match_type":"1","fixture_contest_type":"4","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}],"more_contest":[{"id":"717","match_type":"1","fixture_contest_type":"5","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"718","match_type":"1","fixture_contest_type":"5","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}],"practice_contest":[{"id":"717","match_type":"1","fixture_contest_type":"5","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"718","match_type":"1","fixture_contest_type":"5","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}],"mega_contest":[{"id":"727","match_type":"1","fixture_contest_type":"0","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multient     ry":"0","confirm_contest":"1","mega_contest":"1","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}],"mega_contest_total":1}
     * status : 1
     * message : Contest found successfully
     */

    private int code;
    private ResponseBean response;
    private int status;
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
         * limit : 5
         * hot_contest_total : 8
         * champions_contest_total : 2
         * head_contest_total : 2
         * winners_contest_total : 2
         * more_contest_total : 2
         * pratice_contest_total : 2
         * total_all_contest : 17
         * hot_contest : [{"id":"709","match_type":"1","fixture_contest_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"CCGOPH46","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"10000","prize_percentage":"100.00"},{"rank":"2 - 3","prize":"5000","prize_percentage":"100.00"},{"rank":"4 - 5","prize":"4000","prize_percentage":"100.00"},{"rank":"6 - 10","prize":"3000","prize_percentage":"100.00"},{"rank":"11 - 20","prize":"2000","prize_percentage":"100.00"},{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}],"total_join_team":1,"spots_left":1},{"id":"710","match_type":"1","fixture_contest_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"722","match_type":"1","fixture_contest_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"723","match_type":"1","fixture_contest_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"724","match_type":"1","fixture_contest_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}]
         * contest_for_champions : [{"id":"711","match_type":"1","fixture_contest_type":"2","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"712","match_type":"1","fixture_contest_type":"2","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}]
         * head_to_head : [{"id":"713","match_type":"1","fixture_contest_type":"3","contest_name":"Win Rs.1     00","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"714","match_type":"1","fixture_contest_type":"3","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}]
         * winner_takes_all : [{"id":"715","match_type":"1","fixture_contest_type":"4","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"716","match_type":"1","fixture_contest_type":"4","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}]
         * more_contest : [{"id":"717","match_type":"1","fixture_contest_type":"5","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"718","match_type":"1","fixture_contest_type":"5","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}]
         * practice_contest : [{"id":"717","match_type":"1","fixture_contest_type":"5","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2},{"id":"718","match_type":"1","fixture_contest_type":"5","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"0","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"1","prize":"100","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}]
         * mega_contest : [{"id":"727","match_type":"1","fixture_contest_type":"0","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multient     ry":"0","confirm_contest":"1","mega_contest":"1","user_invite_code":"JMGZWZ31","display_join_amount":55,"tournament_code":"","contest_type":"1","is_user_joined":0,"winners_rank":[{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}],"total_join_team":0,"spots_left":2}]
         * mega_contest_total : 1
         */

        private int limit;
        private int hot_contest_total;
        private int champions_contest_total;
        private int head_contest_total;
        private int winners_contest_total;
        private int more_contest_total;
        private int pratice_contest_total;
        private int total_all_contest;
        private int mega_contest_total;

        private int total_joined_contest;
        private int total_created_team;
        @SerializedName("winners_rank")
        private List<WinnersRankBean> winnersRank;

        public List<WinnersRankBean> getWinnersRank() {
            return winnersRank;
        }

        public void setWinnersRank(List<WinnersRankBean> winnersRank) {
            this.winnersRank = winnersRank;
        }

        public int getTotal_joined_contest() {
            return total_joined_contest;
        }

        public void setTotal_joined_contest(int total_joined_contest) {
            this.total_joined_contest = total_joined_contest;
        }

        public int getTotal_created_team() {
            return total_created_team;
        }

        public void setTotal_created_team(int total_created_team) {
            this.total_created_team = total_created_team;
        }

        private List<HotContestBean> hot_contest;
        private List<HotContestBean> contest_for_champions;
        private List<HotContestBean> head_to_head;
        private List<HotContestBean> winner_takes_all;
        private List<HotContestBean> more_contest;
        private List<HotContestBean> practice_contest;
        private List<HotContestBean> mega_contest;

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getHot_contest_total() {
            return hot_contest_total;
        }

        public void setHot_contest_total(int hot_contest_total) {
            this.hot_contest_total = hot_contest_total;
        }

        public int getChampions_contest_total() {
            return champions_contest_total;
        }

        public void setChampions_contest_total(int champions_contest_total) {
            this.champions_contest_total = champions_contest_total;
        }

        public int getHead_contest_total() {
            return head_contest_total;
        }

        public void setHead_contest_total(int head_contest_total) {
            this.head_contest_total = head_contest_total;
        }

        public int getWinners_contest_total() {
            return winners_contest_total;
        }

        public void setWinners_contest_total(int winners_contest_total) {
            this.winners_contest_total = winners_contest_total;
        }

        public int getMore_contest_total() {
            return more_contest_total;
        }

        public void setMore_contest_total(int more_contest_total) {
            this.more_contest_total = more_contest_total;
        }

        public int getPratice_contest_total() {
            return pratice_contest_total;
        }

        public void setPratice_contest_total(int pratice_contest_total) {
            this.pratice_contest_total = pratice_contest_total;
        }

        public int getTotal_all_contest() {
            return total_all_contest;
        }

        public void setTotal_all_contest(int total_all_contest) {
            this.total_all_contest = total_all_contest;
        }

        public int getMega_contest_total() {
            return mega_contest_total;
        }

        public void setMega_contest_total(int mega_contest_total) {
            this.mega_contest_total = mega_contest_total;
        }

        public List<HotContestBean> getHot_contest() {
            return hot_contest;
        }

        public void setHot_contest(List<HotContestBean> hot_contest) {
            this.hot_contest = hot_contest;
        }

        public List<HotContestBean> getContest_for_champions() {
            return contest_for_champions;
        }

        public void setContest_for_champions(List<HotContestBean> contest_for_champions) {
            this.contest_for_champions = contest_for_champions;
        }

        public List<HotContestBean> getHead_to_head() {
            return head_to_head;
        }

        public void setHead_to_head(List<HotContestBean> head_to_head) {
            this.head_to_head = head_to_head;
        }

        public List<HotContestBean> getWinner_takes_all() {
            return winner_takes_all;
        }

        public void setWinner_takes_all(List<HotContestBean> winner_takes_all) {
            this.winner_takes_all = winner_takes_all;
        }

        public List<HotContestBean> getMore_contest() {
            return more_contest;
        }

        public void setMore_contest(List<HotContestBean> more_contest) {
            this.more_contest = more_contest;
        }

        public List<HotContestBean> getPractice_contest() {
            return practice_contest;
        }

        public void setPractice_contest(List<HotContestBean> practice_contest) {
            this.practice_contest = practice_contest;
        }

        public List<HotContestBean> getMega_contest() {
            return mega_contest;
        }

        public void setMega_contest(List<HotContestBean> mega_contest) {
            this.mega_contest = mega_contest;
        }

        public static class HotContestBean {
            /**
             * id : 709
             * match_type : 1
             * fixture_contest_type : 1
             * contest_name : Win Rs.100
             * total_winning_amount : 100
             * contest_size : 2
             * team_entry_fee : 55.00
             * chip : 0
             * number_of_winners : 1
             * is_multientry : 0
             * confirm_contest : 1
             * mega_contest : 0
             * user_invite_code : CCGOPH46
             * display_join_amount : 55
             * tournament_code :
             * contest_type : 1
             * is_user_joined : 0
             * winners_rank : [{"rank":"1","prize":"10000","prize_percentage":"100.00"},{"rank":"2 - 3","prize":"5000","prize_percentage":"100.00"},{"rank":"4 - 5","prize":"4000","prize_percentage":"100.00"},{"rank":"6 - 10","prize":"3000","prize_percentage":"100.00"},{"rank":"11 - 20","prize":"2000","prize_percentage":"100.00"},{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}]
             * total_join_team : 1
             * spots_left : 1
             */

            private String id;
            private String match_type;
            private String fixture_contest_type;
            private String contest_name;
            private String total_winning_amount;
            private String contest_size;
            private String team_entry_fee;
            private String chip;
            private String number_of_winners;
            private String is_multientry;
            private String confirm_contest;
            private String mega_contest;
            private String user_invite_code;
            private int display_join_amount;
            private String tournament_code;
            private String contest_type;
            private int is_user_joined;
            private int total_join_team;
            private int spots_left;
            private List<WinnersRankBean> winners_rank;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMatch_type() {
                return match_type;
            }

            public void setMatch_type(String match_type) {
                this.match_type = match_type;
            }

            public String getFixture_contest_type() {
                return fixture_contest_type;
            }

            public void setFixture_contest_type(String fixture_contest_type) {
                this.fixture_contest_type = fixture_contest_type;
            }

            public String getContest_name() {
                return contest_name;
            }

            public void setContest_name(String contest_name) {
                this.contest_name = contest_name;
            }

            public String getTotal_winning_amount() {
                return total_winning_amount;
            }

            public void setTotal_winning_amount(String total_winning_amount) {
                this.total_winning_amount = total_winning_amount;
            }

            public String getContest_size() {
                return contest_size;
            }

            public void setContest_size(String contest_size) {
                this.contest_size = contest_size;
            }

            public String getTeam_entry_fee() {
                return team_entry_fee;
            }

            public void setTeam_entry_fee(String team_entry_fee) {
                this.team_entry_fee = team_entry_fee;
            }

            public String getChip() {
                return chip;
            }

            public void setChip(String chip) {
                this.chip = chip;
            }

            public String getNumber_of_winners() {
                return number_of_winners;
            }

            public void setNumber_of_winners(String number_of_winners) {
                this.number_of_winners = number_of_winners;
            }

            public String getIs_multientry() {
                return is_multientry;
            }

            public void setIs_multientry(String is_multientry) {
                this.is_multientry = is_multientry;
            }

            public String getConfirm_contest() {
                return confirm_contest;
            }

            public void setConfirm_contest(String confirm_contest) {
                this.confirm_contest = confirm_contest;
            }

            public String getMega_contest() {
                return mega_contest;
            }

            public void setMega_contest(String mega_contest) {
                this.mega_contest = mega_contest;
            }

            public String getUser_invite_code() {
                return user_invite_code;
            }

            public void setUser_invite_code(String user_invite_code) {
                this.user_invite_code = user_invite_code;
            }

            public int getDisplay_join_amount() {
                return display_join_amount;
            }

            public void setDisplay_join_amount(int display_join_amount) {
                this.display_join_amount = display_join_amount;
            }

            public String getTournament_code() {
                return tournament_code;
            }

            public void setTournament_code(String tournament_code) {
                this.tournament_code = tournament_code;
            }

            public String getContest_type() {
                return contest_type;
            }

            public void setContest_type(String contest_type) {
                this.contest_type = contest_type;
            }

            public int getIs_user_joined() {
                return is_user_joined;
            }

            public void setIs_user_joined(int is_user_joined) {
                this.is_user_joined = is_user_joined;
            }

            public int getTotal_join_team() {
                return total_join_team;
            }

            public void setTotal_join_team(int total_join_team) {
                this.total_join_team = total_join_team;
            }

            public int getSpots_left() {
                return spots_left;
            }

            public void setSpots_left(int spots_left) {
                this.spots_left = spots_left;
            }

            public List<WinnersRankBean> getWinners_rank() {
                return winners_rank;
            }

            public void setWinners_rank(List<WinnersRankBean> winners_rank) {
                this.winners_rank = winners_rank;
            }

            public static class WinnersRankBean {
                /**
                 * rank : 1
                 * prize : 10000
                 * prize_percentage : 100.00
                 */

                private String rank;
                private String prize;
                private String prize_percentage;

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

                public String getPrize_percentage() {
                    return prize_percentage;
                }

                public void setPrize_percentage(String prize_percentage) {
                    this.prize_percentage = prize_percentage;
                }
            }
        }

        public static class ContestForChampionsBean {
            /**
             * id : 711
             * match_type : 1
             * fixture_contest_type : 2
             * contest_name : Win Rs.100
             * total_winning_amount : 100
             * contest_size : 2
             * team_entry_fee : 55.00
             * chip : 0
             * number_of_winners : 1
             * is_multientry : 0
             * confirm_contest : 1
             * mega_contest : 0
             * user_invite_code : JMGZWZ31
             * display_join_amount : 55
             * tournament_code :
             * contest_type : 1
             * is_user_joined : 0
             * winners_rank : [{"rank":"1","prize":"100","prize_percentage":"100.00"}]
             * total_join_team : 0
             * spots_left : 2
             */

            private String id;
            private String match_type;
            private String fixture_contest_type;
            private String contest_name;
            private String total_winning_amount;
            private String contest_size;
            private String team_entry_fee;
            private String chip;
            private String number_of_winners;
            private String is_multientry;
            private String confirm_contest;
            private String mega_contest;
            private String user_invite_code;
            private int display_join_amount;
            private String tournament_code;
            private String contest_type;
            private int is_user_joined;
            private int total_join_team;
            private int spots_left;
            private List<WinnersRankBeanX> winners_rank;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMatch_type() {
                return match_type;
            }

            public void setMatch_type(String match_type) {
                this.match_type = match_type;
            }

            public String getFixture_contest_type() {
                return fixture_contest_type;
            }

            public void setFixture_contest_type(String fixture_contest_type) {
                this.fixture_contest_type = fixture_contest_type;
            }

            public String getContest_name() {
                return contest_name;
            }

            public void setContest_name(String contest_name) {
                this.contest_name = contest_name;
            }

            public String getTotal_winning_amount() {
                return total_winning_amount;
            }

            public void setTotal_winning_amount(String total_winning_amount) {
                this.total_winning_amount = total_winning_amount;
            }

            public String getContest_size() {
                return contest_size;
            }

            public void setContest_size(String contest_size) {
                this.contest_size = contest_size;
            }

            public String getTeam_entry_fee() {
                return team_entry_fee;
            }

            public void setTeam_entry_fee(String team_entry_fee) {
                this.team_entry_fee = team_entry_fee;
            }

            public String getChip() {
                return chip;
            }

            public void setChip(String chip) {
                this.chip = chip;
            }

            public String getNumber_of_winners() {
                return number_of_winners;
            }

            public void setNumber_of_winners(String number_of_winners) {
                this.number_of_winners = number_of_winners;
            }

            public String getIs_multientry() {
                return is_multientry;
            }

            public void setIs_multientry(String is_multientry) {
                this.is_multientry = is_multientry;
            }

            public String getConfirm_contest() {
                return confirm_contest;
            }

            public void setConfirm_contest(String confirm_contest) {
                this.confirm_contest = confirm_contest;
            }

            public String getMega_contest() {
                return mega_contest;
            }

            public void setMega_contest(String mega_contest) {
                this.mega_contest = mega_contest;
            }

            public String getUser_invite_code() {
                return user_invite_code;
            }

            public void setUser_invite_code(String user_invite_code) {
                this.user_invite_code = user_invite_code;
            }

            public int getDisplay_join_amount() {
                return display_join_amount;
            }

            public void setDisplay_join_amount(int display_join_amount) {
                this.display_join_amount = display_join_amount;
            }

            public String getTournament_code() {
                return tournament_code;
            }

            public void setTournament_code(String tournament_code) {
                this.tournament_code = tournament_code;
            }

            public String getContest_type() {
                return contest_type;
            }

            public void setContest_type(String contest_type) {
                this.contest_type = contest_type;
            }

            public int getIs_user_joined() {
                return is_user_joined;
            }

            public void setIs_user_joined(int is_user_joined) {
                this.is_user_joined = is_user_joined;
            }

            public int getTotal_join_team() {
                return total_join_team;
            }

            public void setTotal_join_team(int total_join_team) {
                this.total_join_team = total_join_team;
            }

            public int getSpots_left() {
                return spots_left;
            }

            public void setSpots_left(int spots_left) {
                this.spots_left = spots_left;
            }

            public List<WinnersRankBeanX> getWinners_rank() {
                return winners_rank;
            }

            public void setWinners_rank(List<WinnersRankBeanX> winners_rank) {
                this.winners_rank = winners_rank;
            }

            public static class WinnersRankBeanX {
                /**
                 * rank : 1
                 * prize : 100
                 * prize_percentage : 100.00
                 */

                private String rank;
                private String prize;
                private String prize_percentage;

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

                public String getPrize_percentage() {
                    return prize_percentage;
                }

                public void setPrize_percentage(String prize_percentage) {
                    this.prize_percentage = prize_percentage;
                }
            }
        }

        public static class HeadToHeadBean {
            /**
             * id : 713
             * match_type : 1
             * fixture_contest_type : 3
             * contest_name : Win Rs.1     00
             * total_winning_amount : 100
             * contest_size : 2
             * team_entry_fee : 55.00
             * chip : 0
             * number_of_winners : 1
             * is_multientry : 0
             * confirm_contest : 1
             * mega_contest : 0
             * user_invite_code : JMGZWZ31
             * display_join_amount : 55
             * tournament_code :
             * contest_type : 1
             * is_user_joined : 0
             * winners_rank : [{"rank":"1","prize":"100","prize_percentage":"100.00"}]
             * total_join_team : 0
             * spots_left : 2
             */

            private String id;
            private String match_type;
            private String fixture_contest_type;
            private String contest_name;
            private String total_winning_amount;
            private String contest_size;
            private String team_entry_fee;
            private String chip;
            private String number_of_winners;
            private String is_multientry;
            private String confirm_contest;
            private String mega_contest;
            private String user_invite_code;
            private int display_join_amount;
            private String tournament_code;
            private String contest_type;
            private int is_user_joined;
            private int total_join_team;
            private int spots_left;
            private List<WinnersRankBeanXX> winners_rank;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMatch_type() {
                return match_type;
            }

            public void setMatch_type(String match_type) {
                this.match_type = match_type;
            }

            public String getFixture_contest_type() {
                return fixture_contest_type;
            }

            public void setFixture_contest_type(String fixture_contest_type) {
                this.fixture_contest_type = fixture_contest_type;
            }

            public String getContest_name() {
                return contest_name;
            }

            public void setContest_name(String contest_name) {
                this.contest_name = contest_name;
            }

            public String getTotal_winning_amount() {
                return total_winning_amount;
            }

            public void setTotal_winning_amount(String total_winning_amount) {
                this.total_winning_amount = total_winning_amount;
            }

            public String getContest_size() {
                return contest_size;
            }

            public void setContest_size(String contest_size) {
                this.contest_size = contest_size;
            }

            public String getTeam_entry_fee() {
                return team_entry_fee;
            }

            public void setTeam_entry_fee(String team_entry_fee) {
                this.team_entry_fee = team_entry_fee;
            }

            public String getChip() {
                return chip;
            }

            public void setChip(String chip) {
                this.chip = chip;
            }

            public String getNumber_of_winners() {
                return number_of_winners;
            }

            public void setNumber_of_winners(String number_of_winners) {
                this.number_of_winners = number_of_winners;
            }

            public String getIs_multientry() {
                return is_multientry;
            }

            public void setIs_multientry(String is_multientry) {
                this.is_multientry = is_multientry;
            }

            public String getConfirm_contest() {
                return confirm_contest;
            }

            public void setConfirm_contest(String confirm_contest) {
                this.confirm_contest = confirm_contest;
            }

            public String getMega_contest() {
                return mega_contest;
            }

            public void setMega_contest(String mega_contest) {
                this.mega_contest = mega_contest;
            }

            public String getUser_invite_code() {
                return user_invite_code;
            }

            public void setUser_invite_code(String user_invite_code) {
                this.user_invite_code = user_invite_code;
            }

            public int getDisplay_join_amount() {
                return display_join_amount;
            }

            public void setDisplay_join_amount(int display_join_amount) {
                this.display_join_amount = display_join_amount;
            }

            public String getTournament_code() {
                return tournament_code;
            }

            public void setTournament_code(String tournament_code) {
                this.tournament_code = tournament_code;
            }

            public String getContest_type() {
                return contest_type;
            }

            public void setContest_type(String contest_type) {
                this.contest_type = contest_type;
            }

            public int getIs_user_joined() {
                return is_user_joined;
            }

            public void setIs_user_joined(int is_user_joined) {
                this.is_user_joined = is_user_joined;
            }

            public int getTotal_join_team() {
                return total_join_team;
            }

            public void setTotal_join_team(int total_join_team) {
                this.total_join_team = total_join_team;
            }

            public int getSpots_left() {
                return spots_left;
            }

            public void setSpots_left(int spots_left) {
                this.spots_left = spots_left;
            }

            public List<WinnersRankBeanXX> getWinners_rank() {
                return winners_rank;
            }

            public void setWinners_rank(List<WinnersRankBeanXX> winners_rank) {
                this.winners_rank = winners_rank;
            }

            public static class WinnersRankBeanXX {
                /**
                 * rank : 1
                 * prize : 100
                 * prize_percentage : 100.00
                 */

                private String rank;
                private String prize;
                private String prize_percentage;

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

                public String getPrize_percentage() {
                    return prize_percentage;
                }

                public void setPrize_percentage(String prize_percentage) {
                    this.prize_percentage = prize_percentage;
                }
            }
        }

        public static class WinnerTakesAllBean {
            /**
             * id : 715
             * match_type : 1
             * fixture_contest_type : 4
             * contest_name : Win Rs.100
             * total_winning_amount : 100
             * contest_size : 2
             * team_entry_fee : 55.00
             * chip : 0
             * number_of_winners : 1
             * is_multientry : 0
             * confirm_contest : 1
             * mega_contest : 0
             * user_invite_code : JMGZWZ31
             * display_join_amount : 55
             * tournament_code :
             * contest_type : 1
             * is_user_joined : 0
             * winners_rank : [{"rank":"1","prize":"100","prize_percentage":"100.00"}]
             * total_join_team : 0
             * spots_left : 2
             */

            private String id;
            private String match_type;
            private String fixture_contest_type;
            private String contest_name;
            private String total_winning_amount;
            private String contest_size;
            private String team_entry_fee;
            private String chip;
            private String number_of_winners;
            private String is_multientry;
            private String confirm_contest;
            private String mega_contest;
            private String user_invite_code;
            private int display_join_amount;
            private String tournament_code;
            private String contest_type;
            private int is_user_joined;
            private int total_join_team;
            private int spots_left;
            private List<WinnersRankBeanXXX> winners_rank;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMatch_type() {
                return match_type;
            }

            public void setMatch_type(String match_type) {
                this.match_type = match_type;
            }

            public String getFixture_contest_type() {
                return fixture_contest_type;
            }

            public void setFixture_contest_type(String fixture_contest_type) {
                this.fixture_contest_type = fixture_contest_type;
            }

            public String getContest_name() {
                return contest_name;
            }

            public void setContest_name(String contest_name) {
                this.contest_name = contest_name;
            }

            public String getTotal_winning_amount() {
                return total_winning_amount;
            }

            public void setTotal_winning_amount(String total_winning_amount) {
                this.total_winning_amount = total_winning_amount;
            }

            public String getContest_size() {
                return contest_size;
            }

            public void setContest_size(String contest_size) {
                this.contest_size = contest_size;
            }

            public String getTeam_entry_fee() {
                return team_entry_fee;
            }

            public void setTeam_entry_fee(String team_entry_fee) {
                this.team_entry_fee = team_entry_fee;
            }

            public String getChip() {
                return chip;
            }

            public void setChip(String chip) {
                this.chip = chip;
            }

            public String getNumber_of_winners() {
                return number_of_winners;
            }

            public void setNumber_of_winners(String number_of_winners) {
                this.number_of_winners = number_of_winners;
            }

            public String getIs_multientry() {
                return is_multientry;
            }

            public void setIs_multientry(String is_multientry) {
                this.is_multientry = is_multientry;
            }

            public String getConfirm_contest() {
                return confirm_contest;
            }

            public void setConfirm_contest(String confirm_contest) {
                this.confirm_contest = confirm_contest;
            }

            public String getMega_contest() {
                return mega_contest;
            }

            public void setMega_contest(String mega_contest) {
                this.mega_contest = mega_contest;
            }

            public String getUser_invite_code() {
                return user_invite_code;
            }

            public void setUser_invite_code(String user_invite_code) {
                this.user_invite_code = user_invite_code;
            }

            public int getDisplay_join_amount() {
                return display_join_amount;
            }

            public void setDisplay_join_amount(int display_join_amount) {
                this.display_join_amount = display_join_amount;
            }

            public String getTournament_code() {
                return tournament_code;
            }

            public void setTournament_code(String tournament_code) {
                this.tournament_code = tournament_code;
            }

            public String getContest_type() {
                return contest_type;
            }

            public void setContest_type(String contest_type) {
                this.contest_type = contest_type;
            }

            public int getIs_user_joined() {
                return is_user_joined;
            }

            public void setIs_user_joined(int is_user_joined) {
                this.is_user_joined = is_user_joined;
            }

            public int getTotal_join_team() {
                return total_join_team;
            }

            public void setTotal_join_team(int total_join_team) {
                this.total_join_team = total_join_team;
            }

            public int getSpots_left() {
                return spots_left;
            }

            public void setSpots_left(int spots_left) {
                this.spots_left = spots_left;
            }

            public List<WinnersRankBeanXXX> getWinners_rank() {
                return winners_rank;
            }

            public void setWinners_rank(List<WinnersRankBeanXXX> winners_rank) {
                this.winners_rank = winners_rank;
            }

            public static class WinnersRankBeanXXX {
                /**
                 * rank : 1
                 * prize : 100
                 * prize_percentage : 100.00
                 */

                private String rank;
                private String prize;
                private String prize_percentage;

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

                public String getPrize_percentage() {
                    return prize_percentage;
                }

                public void setPrize_percentage(String prize_percentage) {
                    this.prize_percentage = prize_percentage;
                }
            }
        }

        public static class MoreContestBean {
            /**
             * id : 717
             * match_type : 1
             * fixture_contest_type : 5
             * contest_name : Win Rs.100
             * total_winning_amount : 100
             * contest_size : 2
             * team_entry_fee : 55.00
             * chip : 0
             * number_of_winners : 1
             * is_multientry : 0
             * confirm_contest : 1
             * mega_contest : 0
             * user_invite_code : JMGZWZ31
             * display_join_amount : 55
             * tournament_code :
             * contest_type : 1
             * is_user_joined : 0
             * winners_rank : [{"rank":"1","prize":"100","prize_percentage":"100.00"}]
             * total_join_team : 0
             * spots_left : 2
             */

            private String id;
            private String match_type;
            private String fixture_contest_type;
            private String contest_name;
            private String total_winning_amount;
            private String contest_size;
            private String team_entry_fee;
            private String chip;
            private String number_of_winners;
            private String is_multientry;
            private String confirm_contest;
            private String mega_contest;
            private String user_invite_code;
            private int display_join_amount;
            private String tournament_code;
            private String contest_type;
            private int is_user_joined;
            private int total_join_team;
            private int spots_left;
            private List<WinnersRankBeanXXXX> winners_rank;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMatch_type() {
                return match_type;
            }

            public void setMatch_type(String match_type) {
                this.match_type = match_type;
            }

            public String getFixture_contest_type() {
                return fixture_contest_type;
            }

            public void setFixture_contest_type(String fixture_contest_type) {
                this.fixture_contest_type = fixture_contest_type;
            }

            public String getContest_name() {
                return contest_name;
            }

            public void setContest_name(String contest_name) {
                this.contest_name = contest_name;
            }

            public String getTotal_winning_amount() {
                return total_winning_amount;
            }

            public void setTotal_winning_amount(String total_winning_amount) {
                this.total_winning_amount = total_winning_amount;
            }

            public String getContest_size() {
                return contest_size;
            }

            public void setContest_size(String contest_size) {
                this.contest_size = contest_size;
            }

            public String getTeam_entry_fee() {
                return team_entry_fee;
            }

            public void setTeam_entry_fee(String team_entry_fee) {
                this.team_entry_fee = team_entry_fee;
            }

            public String getChip() {
                return chip;
            }

            public void setChip(String chip) {
                this.chip = chip;
            }

            public String getNumber_of_winners() {
                return number_of_winners;
            }

            public void setNumber_of_winners(String number_of_winners) {
                this.number_of_winners = number_of_winners;
            }

            public String getIs_multientry() {
                return is_multientry;
            }

            public void setIs_multientry(String is_multientry) {
                this.is_multientry = is_multientry;
            }

            public String getConfirm_contest() {
                return confirm_contest;
            }

            public void setConfirm_contest(String confirm_contest) {
                this.confirm_contest = confirm_contest;
            }

            public String getMega_contest() {
                return mega_contest;
            }

            public void setMega_contest(String mega_contest) {
                this.mega_contest = mega_contest;
            }

            public String getUser_invite_code() {
                return user_invite_code;
            }

            public void setUser_invite_code(String user_invite_code) {
                this.user_invite_code = user_invite_code;
            }

            public int getDisplay_join_amount() {
                return display_join_amount;
            }

            public void setDisplay_join_amount(int display_join_amount) {
                this.display_join_amount = display_join_amount;
            }

            public String getTournament_code() {
                return tournament_code;
            }

            public void setTournament_code(String tournament_code) {
                this.tournament_code = tournament_code;
            }

            public String getContest_type() {
                return contest_type;
            }

            public void setContest_type(String contest_type) {
                this.contest_type = contest_type;
            }

            public int getIs_user_joined() {
                return is_user_joined;
            }

            public void setIs_user_joined(int is_user_joined) {
                this.is_user_joined = is_user_joined;
            }

            public int getTotal_join_team() {
                return total_join_team;
            }

            public void setTotal_join_team(int total_join_team) {
                this.total_join_team = total_join_team;
            }

            public int getSpots_left() {
                return spots_left;
            }

            public void setSpots_left(int spots_left) {
                this.spots_left = spots_left;
            }

            public List<WinnersRankBeanXXXX> getWinners_rank() {
                return winners_rank;
            }

            public void setWinners_rank(List<WinnersRankBeanXXXX> winners_rank) {
                this.winners_rank = winners_rank;
            }

            public static class WinnersRankBeanXXXX {
                /**
                 * rank : 1
                 * prize : 100
                 * prize_percentage : 100.00
                 */

                private String rank;
                private String prize;
                private String prize_percentage;

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

                public String getPrize_percentage() {
                    return prize_percentage;
                }

                public void setPrize_percentage(String prize_percentage) {
                    this.prize_percentage = prize_percentage;
                }
            }
        }

        public static class PracticeContestBean {
            /**
             * id : 717
             * match_type : 1
             * fixture_contest_type : 5
             * contest_name : Win Rs.100
             * total_winning_amount : 100
             * contest_size : 2
             * team_entry_fee : 55.00
             * chip : 0
             * number_of_winners : 1
             * is_multientry : 0
             * confirm_contest : 1
             * mega_contest : 0
             * user_invite_code : JMGZWZ31
             * display_join_amount : 55
             * tournament_code :
             * contest_type : 1
             * is_user_joined : 0
             * winners_rank : [{"rank":"1","prize":"100","prize_percentage":"100.00"}]
             * total_join_team : 0
             * spots_left : 2
             */

            private String id;
            private String match_type;
            private String fixture_contest_type;
            private String contest_name;
            private String total_winning_amount;
            private String contest_size;
            private String team_entry_fee;
            private String chip;
            private String number_of_winners;
            private String is_multientry;
            private String confirm_contest;
            private String mega_contest;
            private String user_invite_code;
            private int display_join_amount;
            private String tournament_code;
            private String contest_type;
            private int is_user_joined;
            private int total_join_team;
            private int spots_left;


            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMatch_type() {
                return match_type;
            }

            public void setMatch_type(String match_type) {
                this.match_type = match_type;
            }

            public String getFixture_contest_type() {
                return fixture_contest_type;
            }

            public void setFixture_contest_type(String fixture_contest_type) {
                this.fixture_contest_type = fixture_contest_type;
            }

            public String getContest_name() {
                return contest_name;
            }

            public void setContest_name(String contest_name) {
                this.contest_name = contest_name;
            }

            public String getTotal_winning_amount() {
                return total_winning_amount;
            }

            public void setTotal_winning_amount(String total_winning_amount) {
                this.total_winning_amount = total_winning_amount;
            }

            public String getContest_size() {
                return contest_size;
            }

            public void setContest_size(String contest_size) {
                this.contest_size = contest_size;
            }

            public String getTeam_entry_fee() {
                return team_entry_fee;
            }

            public void setTeam_entry_fee(String team_entry_fee) {
                this.team_entry_fee = team_entry_fee;
            }

            public String getChip() {
                return chip;
            }

            public void setChip(String chip) {
                this.chip = chip;
            }

            public String getNumber_of_winners() {
                return number_of_winners;
            }

            public void setNumber_of_winners(String number_of_winners) {
                this.number_of_winners = number_of_winners;
            }

            public String getIs_multientry() {
                return is_multientry;
            }

            public void setIs_multientry(String is_multientry) {
                this.is_multientry = is_multientry;
            }

            public String getConfirm_contest() {
                return confirm_contest;
            }

            public void setConfirm_contest(String confirm_contest) {
                this.confirm_contest = confirm_contest;
            }

            public String getMega_contest() {
                return mega_contest;
            }

            public void setMega_contest(String mega_contest) {
                this.mega_contest = mega_contest;
            }

            public String getUser_invite_code() {
                return user_invite_code;
            }

            public void setUser_invite_code(String user_invite_code) {
                this.user_invite_code = user_invite_code;
            }

            public int getDisplay_join_amount() {
                return display_join_amount;
            }

            public void setDisplay_join_amount(int display_join_amount) {
                this.display_join_amount = display_join_amount;
            }

            public String getTournament_code() {
                return tournament_code;
            }

            public void setTournament_code(String tournament_code) {
                this.tournament_code = tournament_code;
            }

            public String getContest_type() {
                return contest_type;
            }

            public void setContest_type(String contest_type) {
                this.contest_type = contest_type;
            }

            public int getIs_user_joined() {
                return is_user_joined;
            }

            public void setIs_user_joined(int is_user_joined) {
                this.is_user_joined = is_user_joined;
            }

            public int getTotal_join_team() {
                return total_join_team;
            }

            public void setTotal_join_team(int total_join_team) {
                this.total_join_team = total_join_team;
            }

            public int getSpots_left() {
                return spots_left;
            }

            public void setSpots_left(int spots_left) {
                this.spots_left = spots_left;
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

        public static class MegaContestBean {
            /**
             * id : 727
             * match_type : 1
             * fixture_contest_type : 0
             * contest_name : Win Rs.100
             * total_winning_amount : 100
             * contest_size : 2
             * team_entry_fee : 55.00
             * chip : 0
             * number_of_winners : 1
             * is_multient     ry : 0
             * confirm_contest : 1
             * mega_contest : 1
             * user_invite_code : JMGZWZ31
             * display_join_amount : 55
             * tournament_code :
             * contest_type : 1
             * is_user_joined : 0
             * winners_rank : [{"rank":"21 - 40","prize":"1000","prize_percentage":"100.00"}]
             * total_join_team : 0
             * spots_left : 2
             */

            private String id;
            private String match_type;
            private String fixture_contest_type;
            private String contest_name;
            private String total_winning_amount;
            private String contest_size;
            private String team_entry_fee;
            private String chip;
            private String number_of_winners;
            @SerializedName("is_multient     ry")
            private String _$Is_multientRy230; // FIXME check this code
            private String confirm_contest;
            private String mega_contest;
            private String user_invite_code;
            private int display_join_amount;
            private String tournament_code;
            private String contest_type;
            private int is_user_joined;
            private int total_join_team;
            private int spots_left;
            private List<WinnersRankBeanXXXXXX> winners_rank;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMatch_type() {
                return match_type;
            }

            public void setMatch_type(String match_type) {
                this.match_type = match_type;
            }

            public String getFixture_contest_type() {
                return fixture_contest_type;
            }

            public void setFixture_contest_type(String fixture_contest_type) {
                this.fixture_contest_type = fixture_contest_type;
            }

            public String getContest_name() {
                return contest_name;
            }

            public void setContest_name(String contest_name) {
                this.contest_name = contest_name;
            }

            public String getTotal_winning_amount() {
                return total_winning_amount;
            }

            public void setTotal_winning_amount(String total_winning_amount) {
                this.total_winning_amount = total_winning_amount;
            }

            public String getContest_size() {
                return contest_size;
            }

            public void setContest_size(String contest_size) {
                this.contest_size = contest_size;
            }

            public String getTeam_entry_fee() {
                return team_entry_fee;
            }

            public void setTeam_entry_fee(String team_entry_fee) {
                this.team_entry_fee = team_entry_fee;
            }

            public String getChip() {
                return chip;
            }

            public void setChip(String chip) {
                this.chip = chip;
            }

            public String getNumber_of_winners() {
                return number_of_winners;
            }

            public void setNumber_of_winners(String number_of_winners) {
                this.number_of_winners = number_of_winners;
            }

            public String get_$Is_multientRy230() {
                return _$Is_multientRy230;
            }

            public void set_$Is_multientRy230(String _$Is_multientRy230) {
                this._$Is_multientRy230 = _$Is_multientRy230;
            }

            public String getConfirm_contest() {
                return confirm_contest;
            }

            public void setConfirm_contest(String confirm_contest) {
                this.confirm_contest = confirm_contest;
            }

            public String getMega_contest() {
                return mega_contest;
            }

            public void setMega_contest(String mega_contest) {
                this.mega_contest = mega_contest;
            }

            public String getUser_invite_code() {
                return user_invite_code;
            }

            public void setUser_invite_code(String user_invite_code) {
                this.user_invite_code = user_invite_code;
            }

            public int getDisplay_join_amount() {
                return display_join_amount;
            }

            public void setDisplay_join_amount(int display_join_amount) {
                this.display_join_amount = display_join_amount;
            }

            public String getTournament_code() {
                return tournament_code;
            }

            public void setTournament_code(String tournament_code) {
                this.tournament_code = tournament_code;
            }

            public String getContest_type() {
                return contest_type;
            }

            public void setContest_type(String contest_type) {
                this.contest_type = contest_type;
            }

            public int getIs_user_joined() {
                return is_user_joined;
            }

            public void setIs_user_joined(int is_user_joined) {
                this.is_user_joined = is_user_joined;
            }

            public int getTotal_join_team() {
                return total_join_team;
            }

            public void setTotal_join_team(int total_join_team) {
                this.total_join_team = total_join_team;
            }

            public int getSpots_left() {
                return spots_left;
            }

            public void setSpots_left(int spots_left) {
                this.spots_left = spots_left;
            }

            public List<WinnersRankBeanXXXXXX> getWinners_rank() {
                return winners_rank;
            }

            public void setWinners_rank(List<WinnersRankBeanXXXXXX> winners_rank) {
                this.winners_rank = winners_rank;
            }

            public static class WinnersRankBeanXXXXXX {
                /**
                 * rank : 21 - 40
                 * prize : 1000
                 * prize_percentage : 100.00
                 */

                private String rank;
                private String prize;
                private String prize_percentage;

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

                public String getPrize_percentage() {
                    return prize_percentage;
                }

                public void setPrize_percentage(String prize_percentage) {
                    this.prize_percentage = prize_percentage;
                }
            }
        }
    }
}