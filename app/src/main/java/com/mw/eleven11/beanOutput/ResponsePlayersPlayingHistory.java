package com.mw.eleven11.beanOutput;

import java.util.List;

public class ResponsePlayersPlayingHistory {


    /**
     * code : 200
     * response : {"playing_history":{"total_contest":0,"total_matches":0,"series":0,"total_wins":0},"recent_performance":[{"match_id":"38385","match_date_time":"2018-07-20 04:30:00","localteam":"SL","visitorteam":"SA","live_score_status":"Sri Lanka won by 199 runs","localteam_flag":"http://funtush11.com/funtush/backend_asset/images/india1.png","visitorteam_flag":"http://funtush11.com/funtush/backend_asset/images/india1.png","my_team":{"my_team_code":"SUHAI12654","my_team_name":"Team 1","my_total_points":"460.00"},"user_team":{"user_team_code":"PALAK64013","user_team_name":"","user_total_points":"0"}},{"match_id":"38764","match_date_time":"2018-08-03 09:00:00","localteam":"NET","visitorteam":"NEP","live_score_status":"Nepal won by 1 run","localteam_flag":"http://funtush11.com/funtush/backend_asset/images/india1.png","visitorteam_flag":"http://funtush11.com/funtush/backend_asset/images/india1.png","my_team":{"my_team_code":"SUHAI12654","my_team_name":"Team 1","my_total_points":"166.00"},"user_team":{"user_team_code":"PALAK64013","user_team_name":"","user_total_points":"0"}}]}
     * status : 1
     * message : Playing History found successfully
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
         * playing_history : {"total_contest":0,"total_matches":0,"series":0,"total_wins":0}
         * recent_performance : [{"match_id":"38385","match_date_time":"2018-07-20 04:30:00","localteam":"SL","visitorteam":"SA","live_score_status":"Sri Lanka won by 199 runs","localteam_flag":"http://funtush11.com/funtush/backend_asset/images/india1.png","visitorteam_flag":"http://funtush11.com/funtush/backend_asset/images/india1.png","my_team":{"my_team_code":"SUHAI12654","my_team_name":"Team 1","my_total_points":"460.00"},"user_team":{"user_team_code":"PALAK64013","user_team_name":"","user_total_points":"0"}},{"match_id":"38764","match_date_time":"2018-08-03 09:00:00","localteam":"NET","visitorteam":"NEP","live_score_status":"Nepal won by 1 run","localteam_flag":"http://funtush11.com/funtush/backend_asset/images/india1.png","visitorteam_flag":"http://funtush11.com/funtush/backend_asset/images/india1.png","my_team":{"my_team_code":"SUHAI12654","my_team_name":"Team 1","my_total_points":"166.00"},"user_team":{"user_team_code":"PALAK64013","user_team_name":"","user_total_points":"0"}}]
         */

        private PlayingHistoryBean playing_history;
        private List<RecentPerformanceBean> recent_performance;

        public PlayingHistoryBean getPlaying_history() {
            return playing_history;
        }

        public void setPlaying_history(PlayingHistoryBean playing_history) {
            this.playing_history = playing_history;
        }

        public List<RecentPerformanceBean> getRecent_performance() {
            return recent_performance;
        }

        public void setRecent_performance(List<RecentPerformanceBean> recent_performance) {
            this.recent_performance = recent_performance;
        }

        public static class PlayingHistoryBean {
            /**
             * total_contest : 0
             * total_matches : 0
             * series : 0
             * total_wins : 0
             */

            private int total_contest;
            private int total_matches;
            private int series;
            private int total_wins;

            public int getTotal_contest() {
                return total_contest;
            }

            public void setTotal_contest(int total_contest) {
                this.total_contest = total_contest;
            }

            public int getTotal_matches() {
                return total_matches;
            }

            public void setTotal_matches(int total_matches) {
                this.total_matches = total_matches;
            }

            public int getSeries() {
                return series;
            }

            public void setSeries(int series) {
                this.series = series;
            }

            public int getTotal_wins() {
                return total_wins;
            }

            public void setTotal_wins(int total_wins) {
                this.total_wins = total_wins;
            }
        }

        public static class RecentPerformanceBean {
            /**
             * match_id : 38385
             * match_date_time : 2018-07-20 04:30:00
             * localteam : SL
             * visitorteam : SA
             * live_score_status : Sri Lanka won by 199 runs
             * localteam_flag : http://funtush11.com/funtush/backend_asset/images/india1.png
             * visitorteam_flag : http://funtush11.com/funtush/backend_asset/images/india1.png
             * my_team : {"my_team_code":"SUHAI12654","my_team_name":"Team 1","my_total_points":"460.00"}
             * user_team : {"user_team_code":"PALAK64013","user_team_name":"","user_total_points":"0"}
             */

            private String match_id;
            private String match_date_time;
            private String localteam;
            private String visitorteam;
            private String live_score_status;
            private String localteam_flag;
            private String visitorteam_flag;
            private MyTeamBean my_team;
            private UserTeamBean user_team;

            public String getMatch_id() {
                return match_id;
            }

            public void setMatch_id(String match_id) {
                this.match_id = match_id;
            }

            public String getMatch_date_time() {
                return match_date_time;
            }

            public void setMatch_date_time(String match_date_time) {
                this.match_date_time = match_date_time;
            }

            public String getLocalteam() {
                return localteam;
            }

            public void setLocalteam(String localteam) {
                this.localteam = localteam;
            }

            public String getVisitorteam() {
                return visitorteam;
            }

            public void setVisitorteam(String visitorteam) {
                this.visitorteam = visitorteam;
            }

            public String getLive_score_status() {
                return live_score_status;
            }

            public void setLive_score_status(String live_score_status) {
                this.live_score_status = live_score_status;
            }

            public String getLocalteam_flag() {
                return localteam_flag;
            }

            public void setLocalteam_flag(String localteam_flag) {
                this.localteam_flag = localteam_flag;
            }

            public String getVisitorteam_flag() {
                return visitorteam_flag;
            }

            public void setVisitorteam_flag(String visitorteam_flag) {
                this.visitorteam_flag = visitorteam_flag;
            }

            public MyTeamBean getMy_team() {
                return my_team;
            }

            public void setMy_team(MyTeamBean my_team) {
                this.my_team = my_team;
            }

            public UserTeamBean getUser_team() {
                return user_team;
            }

            public void setUser_team(UserTeamBean user_team) {
                this.user_team = user_team;
            }

            public static class MyTeamBean {
                /**
                 * my_team_code : SUHAI12654
                 * my_team_name : Team 1
                 * my_total_points : 460.00
                 */

                private String my_team_code;
                private String my_team_name;
                private String my_total_points;

                public String getMy_team_code() {
                    return my_team_code;
                }

                public void setMy_team_code(String my_team_code) {
                    this.my_team_code = my_team_code;
                }

                public String getMy_team_name() {
                    return my_team_name;
                }

                public void setMy_team_name(String my_team_name) {
                    this.my_team_name = my_team_name;
                }

                public String getMy_total_points() {
                    return my_total_points;
                }

                public void setMy_total_points(String my_total_points) {
                    this.my_total_points = my_total_points;
                }
            }

            public static class UserTeamBean {
                /**
                 * user_team_code : PALAK64013
                 * user_team_name :
                 * user_total_points : 0
                 */

                private String user_team_code;
                private String user_team_name;
                private String user_total_points;

                public String getUser_team_code() {
                    return user_team_code;
                }

                public void setUser_team_code(String user_team_code) {
                    this.user_team_code = user_team_code;
                }

                public String getUser_team_name() {
                    return user_team_name;
                }

                public void setUser_team_name(String user_team_name) {
                    this.user_team_name = user_team_name;
                }

                public String getUser_total_points() {
                    return user_total_points;
                }

                public void setUser_total_points(String user_total_points) {
                    this.user_total_points = user_total_points;
                }
            }
        }
    }
}
