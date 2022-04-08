package com.mw.eleven11.beanOutput;

import java.util.List;

public class ResponseOverallLeaderboard {


    /**
     * code : 200
     * response : [{"user_id":"1","user_image":"http://159.65.147.114/fantasy11/uploads/users/1524058514_49091.png","team_code":"ADMIN00777","totalPoints":"2769.50","rank":1},{"user_id":"348","user_image":"http://159.65.147.114/fantasy11/http://159.65.147.114/fantasy11/uploads/users/1530955153_1491543652_man.png","team_code":"NISHA26565","totalPoints":0,"rank":2},{"user_id":"356","user_image":"http://159.65.147.114/fantasy11/backend_asset/images/default-148.png","team_code":"SUHAI12654","totalPoints":0,"rank":3},{"user_id":"351","user_image":"http://159.65.147.114/fantasy11/backend_asset/images/default-148.png","team_code":"TARUN52754","totalPoints":0,"rank":4}]
     * status : 1
     * message : Teams found successfully
     */

    private int code;
    private int status;
    private String message;
    private List<ResponseBean> response;

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
         * user_id : 1
         * user_image : http://159.65.147.114/fantasy11/uploads/users/1524058514_49091.png
         * team_code : ADMIN00777
         * totalPoints : 2769.50
         * rank : 1
         */

        private String user_id;
        private String user_image;
        private String team_code;
        private String totalPoints;
        private int rank;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
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

        public String getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(String totalPoints) {
            this.totalPoints = totalPoints;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }
}
