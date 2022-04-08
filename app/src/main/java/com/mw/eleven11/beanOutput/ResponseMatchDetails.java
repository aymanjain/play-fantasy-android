package com.mw.eleven11.beanOutput;

import java.util.List;

/**
 * Created by mobiweb on 28/2/18.
 */

public class ResponseMatchDetails {


    /**
     * code : 200
     * mega_contest : {"id":"727","match_type":"1","contest_name":"Win Rs.100","total_winning_amount":"100","contest_size":"2","team_entry_fee":"55.00","chip":"0","number_of_winners":"1","is_multientry":"0","confirm_contest":"1","mega_contest":"1","contest_join_code":"JMGZWZ31","is_user_joined":0,"winners_rank":[{"rank":"21 - 40","prize":"1000"}],"total_join_team":0}
     * is_mega_contest : 1
     * response : {"match_id":"37879","series_id":"111127","match_date":"2018-07-12","match_time":"11:30","status":"open","match_type":"odi","match_num":"1st ODI","localteam_id":"490","localteam":"ENG","localteam_name":"England","localteam_image":"http://159.65.147.114/fantasy11/https://cricket.entitysport.com/assets/uploads/2016/01/england.png","visitorteam_image":"http://159.65.147.114/fantasy11/https://cricket.entitysport.com/assets/uploads/2016/01/india.png","localteam_first_inning":"0","localteam_second_inning":"0","visitorteam_first_inning":"0","visitorteam_second_inning":"0","live_score_status":"0","visitorteam_id":"25","visitorteam":"IND","visitorteam_name":"India","isContest":"YES","match_date_time":"2018-07-12 11:30:00","match_status":"FIXTURE","currentTime":"2018-07-12 08:26:27","play_status":"1","prediction_code":"VPUM2Z33"}
     * my_team : 0
     * my_joined_contest : 0
     * status : 1
     * message : Match found successfully
     */

    private int code;
    private MegaContestBean mega_contest;
    private int is_mega_contest;
    private ResponseBean response;
    private String my_team;
    private String my_joined_contest;
    private int status;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MegaContestBean getMega_contest() {
        return mega_contest;
    }

    public void setMega_contest(MegaContestBean mega_contest) {
        this.mega_contest = mega_contest;
    }

    public int getIs_mega_contest() {
        return is_mega_contest;
    }

    public void setIs_mega_contest(int is_mega_contest) {
        this.is_mega_contest = is_mega_contest;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public String getMy_team() {
        return my_team;
    }

    public void setMy_team(String my_team) {
        this.my_team = my_team;
    }

    public String getMy_joined_contest() {
        return my_joined_contest;
    }

    public void setMy_joined_contest(String my_joined_contest) {
        this.my_joined_contest = my_joined_contest;
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

    public static class MegaContestBean {
        /**
         * id : 727
         * match_type : 1
         * contest_name : Win Rs.100
         * total_winning_amount : 100
         * contest_size : 2
         * team_entry_fee : 55.00
         * chip : 0
         * number_of_winners : 1
         * is_multientry : 0
         * confirm_contest : 1
         * mega_contest : 1
         * contest_join_code : JMGZWZ31
         * is_user_joined : 0
         * winners_rank : [{"rank":"21 - 40","prize":"1000"}]
         * total_join_team : 0
         */

        private String id;
        private String match_type;
        private String contest_name;
        private String total_winning_amount;
        private String contest_size;
        private String team_entry_fee;
        private String chip;
        private String number_of_winners;
        private String is_multientry;
        private String confirm_contest;
        private String mega_contest;
        private String contest_join_code;
        private int is_user_joined;
        private int total_join_team;
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

        public String getContest_join_code() {
            return contest_join_code;
        }

        public void setContest_join_code(String contest_join_code) {
            this.contest_join_code = contest_join_code;
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

        public List<WinnersRankBean> getWinners_rank() {
            return winners_rank;
        }

        public void setWinners_rank(List<WinnersRankBean> winners_rank) {
            this.winners_rank = winners_rank;
        }

        public static class WinnersRankBean {
            /**
             * rank : 21 - 40
             * prize : 1000
             */

            private String rank;
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

    public static class ResponseBean {
        /**
         * match_id : 37879
         * series_id : 111127
         * match_date : 2018-07-12
         * match_time : 11:30
         * status : open
         * match_type : odi
         * match_num : 1st ODI
         * localteam_id : 490
         * localteam : ENG
         * localteam_name : England
         * localteam_image : http://159.65.147.114/fantasy11/https://cricket.entitysport.com/assets/uploads/2016/01/england.png
         * visitorteam_image : http://159.65.147.114/fantasy11/https://cricket.entitysport.com/assets/uploads/2016/01/india.png
         * localteam_first_inning : 0
         * localteam_second_inning : 0
         * visitorteam_first_inning : 0
         * visitorteam_second_inning : 0
         * live_score_status : 0
         * visitorteam_id : 25
         * visitorteam : IND
         * visitorteam_name : India
         * isContest : YES
         * match_date_time : 2018-07-12 11:30:00
         * match_status : FIXTURE
         * currentTime : 2018-07-12 08:26:27
         * play_status : 1
         * prediction_code : VPUM2Z33
         */

        private String match_id;
        private String series_id;
        private String match_date;
        private String match_time;
        private String status;
        private String match_type;
        private String match_num;
        private String localteam_id;
        private String localteam;
        private String localteam_name;
        private String localteam_image;
        private String visitorteam_image;
        private String localteam_first_inning;
        private String localteam_second_inning;
        private String visitorteam_first_inning;
        private String visitorteam_second_inning;
        private String live_score_status;
        private String visitorteam_id;
        private String visitorteam;
        private String visitorteam_name;
        private String isContest;
        private String match_date_time;
        private String match_status;
        private String currentTime;
        private String play_status;
        private String prediction_code;

        private String localteam_score;
        private String visitorteam_score;
        private String minutes;


        public String getMatch_id() {
            return match_id;
        }

        public void setMatch_id(String match_id) {
            this.match_id = match_id;
        }

        public String getLocalteam_score() {
            return localteam_score;
        }

        public void setLocalteam_score(String localteam_score) {
            this.localteam_score = localteam_score;
        }

        public String getVisitorteam_score() {
            return visitorteam_score;
        }

        public void setVisitorteam_score(String visitorteam_score) {
            this.visitorteam_score = visitorteam_score;
        }

        public String getMinutes() {
            return minutes;
        }

        public void setMinutes(String minutes) {
            this.minutes = minutes;
        }

        public String getSeries_id() {
            return series_id;
        }

        public void setSeries_id(String series_id) {
            this.series_id = series_id;
        }

        public String getMatch_date() {
            return match_date;
        }

        public void setMatch_date(String match_date) {
            this.match_date = match_date;
        }

        public String getMatch_time() {
            return match_time;
        }

        public void setMatch_time(String match_time) {
            this.match_time = match_time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMatch_type() {
            return match_type;
        }

        public void setMatch_type(String match_type) {
            this.match_type = match_type;
        }

        public String getMatch_num() {
            return match_num;
        }

        public void setMatch_num(String match_num) {
            this.match_num = match_num;
        }

        public String getLocalteam_id() {
            return localteam_id;
        }

        public void setLocalteam_id(String localteam_id) {
            this.localteam_id = localteam_id;
        }

        public String getLocalteam() {
            return localteam;
        }

        public void setLocalteam(String localteam) {
            this.localteam = localteam;
        }

        public String getLocalteam_name() {
            return localteam_name;
        }

        public void setLocalteam_name(String localteam_name) {
            this.localteam_name = localteam_name;
        }

        public String getLocalteam_image() {
            return localteam_image;
        }

        public void setLocalteam_image(String localteam_image) {
            this.localteam_image = localteam_image;
        }

        public String getVisitorteam_image() {
            return visitorteam_image;
        }

        public void setVisitorteam_image(String visitorteam_image) {
            this.visitorteam_image = visitorteam_image;
        }

        public String getLocalteam_first_inning() {
            return localteam_first_inning;
        }

        public void setLocalteam_first_inning(String localteam_first_inning) {
            this.localteam_first_inning = localteam_first_inning;
        }

        public String getLocalteam_second_inning() {
            return localteam_second_inning;
        }

        public void setLocalteam_second_inning(String localteam_second_inning) {
            this.localteam_second_inning = localteam_second_inning;
        }

        public String getVisitorteam_first_inning() {
            return visitorteam_first_inning;
        }

        public void setVisitorteam_first_inning(String visitorteam_first_inning) {
            this.visitorteam_first_inning = visitorteam_first_inning;
        }

        public String getVisitorteam_second_inning() {
            return visitorteam_second_inning;
        }

        public void setVisitorteam_second_inning(String visitorteam_second_inning) {
            this.visitorteam_second_inning = visitorteam_second_inning;
        }

        public String getLive_score_status() {
            return live_score_status;
        }

        public void setLive_score_status(String live_score_status) {
            this.live_score_status = live_score_status;
        }

        public String getVisitorteam_id() {
            return visitorteam_id;
        }

        public void setVisitorteam_id(String visitorteam_id) {
            this.visitorteam_id = visitorteam_id;
        }

        public String getVisitorteam() {
            return visitorteam;
        }

        public void setVisitorteam(String visitorteam) {
            this.visitorteam = visitorteam;
        }

        public String getVisitorteam_name() {
            return visitorteam_name;
        }

        public void setVisitorteam_name(String visitorteam_name) {
            this.visitorteam_name = visitorteam_name;
        }

        public String getIsContest() {
            return isContest;
        }

        public void setIsContest(String isContest) {
            this.isContest = isContest;
        }

        public String getMatch_date_time() {
            return match_date_time;
        }

        public void setMatch_date_time(String match_date_time) {
            this.match_date_time = match_date_time;
        }

        public String getMatch_status() {
            return match_status;
        }

        public void setMatch_status(String match_status) {
            this.match_status = match_status;
        }

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

        public String getPlay_status() {
            return play_status;
        }

        public void setPlay_status(String play_status) {
            this.play_status = play_status;
        }

        public String getPrediction_code() {
            return prediction_code;
        }

        public void setPrediction_code(String prediction_code) {
            this.prediction_code = prediction_code;
        }
    }
}
