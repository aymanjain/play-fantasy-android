package com.mw.eleven11.beanOutput;

import java.util.List;

public class ResponsePlayerDetail {


    /**
     * code : 200
     * response : {"id":"126","player_id":"470","name":"Nasir Jamal","country":"af","born":"1993-12-21","playing_role":"BATSMAN","batting_style":"Right-hand bat","bowling_style":"Legbreak googly","player_pic":"http://funtush11.com/funtush/backend_asset/images/cricket-player.png","credit_points":"6.50","fantasy_stats":[{"selected_by":0,"match_id":"38764","points":"0","localteam":"NET","visitorteam":"NEP","match_date_time":"2018-08-03 09:00:00"}]}
     * status : 1
     * message : Player details found successfully
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
         * id : 126
         * player_id : 470
         * name : Nasir Jamal
         * country : af
         * born : 1993-12-21
         * playing_role : BATSMAN
         * batting_style : Right-hand bat
         * bowling_style : Legbreak googly
         * player_pic : http://funtush11.com/funtush/backend_asset/images/cricket-player.png
         * credit_points : 6.50
         * fantasy_stats : [{"selected_by":0,"match_id":"38764","points":"0","localteam":"NET","visitorteam":"NEP","match_date_time":"2018-08-03 09:00:00"}]
         */

        private String id;
        private String player_id;
        private String name;
        private String country;
        private String born;
        private String playing_role;
        private String batting_style;
        private String bowling_style;
        private String player_pic;
        private String credit_points;
        private List<FantasyStatsBean> fantasy_stats;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPlayer_id() {
            return player_id;
        }

        public void setPlayer_id(String player_id) {
            this.player_id = player_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getBorn() {
            return born;
        }

        public void setBorn(String born) {
            this.born = born;
        }

        public String getPlaying_role() {
            return playing_role;
        }

        public void setPlaying_role(String playing_role) {
            this.playing_role = playing_role;
        }

        public String getBatting_style() {
            return batting_style;
        }

        public void setBatting_style(String batting_style) {
            this.batting_style = batting_style;
        }

        public String getBowling_style() {
            return bowling_style;
        }

        public void setBowling_style(String bowling_style) {
            this.bowling_style = bowling_style;
        }

        public String getPlayer_pic() {
            return player_pic;
        }

        public void setPlayer_pic(String player_pic) {
            this.player_pic = player_pic;
        }

        public String getCredit_points() {
            return credit_points;
        }

        public void setCredit_points(String credit_points) {
            this.credit_points = credit_points;
        }

        public List<FantasyStatsBean> getFantasy_stats() {
            return fantasy_stats;
        }

        public void setFantasy_stats(List<FantasyStatsBean> fantasy_stats) {
            this.fantasy_stats = fantasy_stats;
        }

        public static class FantasyStatsBean {
            /**
             * selected_by : 0
             * match_id : 38764
             * points : 0
             * localteam : NET
             * visitorteam : NEP
             * match_date_time : 2018-08-03 09:00:00
             */

            private String selected_by;
            private String match_id;
            private String points;
            private String localteam;
            private String visitorteam;
            private String match_date_time;

            public String getSelected_by() {
                return selected_by;
            }

            public void setSelected_by(String selected_by) {
                this.selected_by = selected_by;
            }

            public String getMatch_id() {
                return match_id;
            }

            public void setMatch_id(String match_id) {
                this.match_id = match_id;
            }

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
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

            public String getMatch_date_time() {
                return match_date_time;
            }

            public void setMatch_date_time(String match_date_time) {
                this.match_date_time = match_date_time;
            }
        }
    }
}
