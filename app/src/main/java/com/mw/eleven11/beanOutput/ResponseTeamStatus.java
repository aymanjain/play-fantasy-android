package com.mw.eleven11.beanOutput;

import java.util.List;

public class ResponseTeamStatus {

    /**
     * code : 200
     * totalMatches : 2
     * response : [{"user_id":"356","match_id":"38365","series_id":"111253","localteam":"ZIM","visitorteam":"PAK","user_image":"http://159.65.147.114/fantasy11/backend_asset/images/default-148.png","team_code":"SUHAI12654","totalPoints":0}]
     * status : 1
     * message : Team Stats found successfully
     */

    private int code;
    private int totalMatches;
    private int status;
    private String message;
    private List<ResponseBean> response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
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
         * user_id : 356
         * match_id : 38365
         * series_id : 111253
         * localteam : ZIM
         * visitorteam : PAK
         * user_image : http://159.65.147.114/fantasy11/backend_asset/images/default-148.png
         * team_code : SUHAI12654
         * totalPoints : 0
         */

        private String user_id;
        private String match_id;
        private String series_id;
        private String localteam;
        private String visitorteam;
        private String user_image;
        private String team_code;
        private String team_id;

        public String getTeam_id() {
            return team_id;
        }

        public void setTeam_id(String team_id) {
            this.team_id = team_id;
        }

        private int totalPoints;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getMatch_id() {
            return match_id;
        }

        public void setMatch_id(String match_id) {
            this.match_id = match_id;
        }

        public String getSeries_id() {
            return series_id;
        }

        public void setSeries_id(String series_id) {
            this.series_id = series_id;
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

        public String getUser_image() {
            return user_image;
        }

        public void setUser_image(String user_image) {
            this.user_image = user_image;
        }

        public String getTeam_code() {
            return team_code;
        }

        public void setTeam_code(String team_code) {
            this.team_code = team_code;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(int totalPoints) {
            this.totalPoints = totalPoints;
        }
    }
}
