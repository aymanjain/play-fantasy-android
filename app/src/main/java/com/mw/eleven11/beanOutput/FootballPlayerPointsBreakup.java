package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FootballPlayerPointsBreakup implements Serializable {


    /**
     * code : 200
     * response : [{"actual":{"minutes_played":"61","goal_Scored":"0","assist":"0","shots_on_target":"0","pass_completed":"0","clean_sheet":"0","goals_saved":"0","penalty_saved":"0","tackles":"0","yellow_card":"0","red_card":"0","own_goal":"0","goal_conceded":"0","penalty_missed":"0","total_point":"15.00"},"points":{"minutes_played":"5","goal_Scored":"0","assist":"0","shots_on_target":"0","pass_completed":"0","clean_sheet":"0","goals_saved":"0","penalty_saved":"0","tackles":"0","yellow_card":"0","red_card":"0","own_goal":"0","goal_conceded":"0","penalty_missed":"0","total_point":"15.00"},"player_name":"Sinan Gumus","player_id":"1035593004712333320","credit_point":"8.00","player_pic":"https://www.funtush11.com/funtush/backend_asset/images/default-1481.png","total_point":"15.00"}]
     * status : 1
     * message : Player points found successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("response")
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

    public static class ResponseBean implements Serializable {
        /**
         * actual : {"minutes_played":"61","goal_Scored":"0","assist":"0","shots_on_target":"0","pass_completed":"0","clean_sheet":"0","goals_saved":"0","penalty_saved":"0","tackles":"0","yellow_card":"0","red_card":"0","own_goal":"0","goal_conceded":"0","penalty_missed":"0","total_point":"15.00"}
         * points : {"minutes_played":"5","goal_Scored":"0","assist":"0","shots_on_target":"0","pass_completed":"0","clean_sheet":"0","goals_saved":"0","penalty_saved":"0","tackles":"0","yellow_card":"0","red_card":"0","own_goal":"0","goal_conceded":"0","penalty_missed":"0","total_point":"15.00"}
         * player_name : Sinan Gumus
         * player_id : 1035593004712333320
         * credit_point : 8.00
         * player_pic : https://www.funtush11.com/funtush/backend_asset/images/default-1481.png
         * total_point : 15.00
         */

        @SerializedName("actual")
        private ActualBean actual;
        @SerializedName("points")
        private PointsBean points;
        @SerializedName("player_name")
        private String playerName;
        @SerializedName("player_id")
        private String playerId;
        @SerializedName("credit_point")
        private String creditPoint;
        @SerializedName("player_pic")
        private String playerPic;
        @SerializedName("total_point")
        private String totalPoint;

        public ActualBean getActual() {
            return actual;
        }

        public void setActual(ActualBean actual) {
            this.actual = actual;
        }

        public PointsBean getPoints() {
            return points;
        }

        public void setPoints(PointsBean points) {
            this.points = points;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public String getPlayerId() {
            return playerId;
        }

        public void setPlayerId(String playerId) {
            this.playerId = playerId;
        }

        public String getCreditPoint() {
            return creditPoint;
        }

        public void setCreditPoint(String creditPoint) {
            this.creditPoint = creditPoint;
        }

        public String getPlayerPic() {
            return playerPic;
        }

        public void setPlayerPic(String playerPic) {
            this.playerPic = playerPic;
        }

        public String getTotalPoint() {
            return totalPoint;
        }

        public void setTotalPoint(String totalPoint) {
            this.totalPoint = totalPoint;
        }

        public static class ActualBean {
            /**
             * minutes_played : 61
             * goal_Scored : 0
             * assist : 0
             * shots_on_target : 0
             * pass_completed : 0
             * clean_sheet : 0
             * goals_saved : 0
             * penalty_saved : 0
             * tackles : 0
             * yellow_card : 0
             * red_card : 0
             * own_goal : 0
             * goal_conceded : 0
             * penalty_missed : 0
             * total_point : 15.00
             */

            @SerializedName("minutes_played")
            private String minutesPlayed;
            @SerializedName("goal_Scored")
            private String goalScored;
            @SerializedName("assist")
            private String assist;
            @SerializedName("shots_on_target")
            private String shotsOnTarget;
            @SerializedName("pass_completed")
            private String passCompleted;
            @SerializedName("clean_sheet")
            private String cleanSheet;
            @SerializedName("goals_saved")
            private String goalsSaved;
            @SerializedName("penalty_saved")
            private String penaltySaved;
            @SerializedName("tackles")
            private String tackles;
            @SerializedName("yellow_card")
            private String yellowCard;
            @SerializedName("red_card")
            private String redCard;
            @SerializedName("own_goal")
            private String ownGoal;
            @SerializedName("goal_conceded")
            private String goalConceded;
            @SerializedName("penalty_missed")
            private String penaltyMissed;
            @SerializedName("total_point")
            private String totalPoint;

            public String getMinutesPlayed() {
                return minutesPlayed;
            }

            public void setMinutesPlayed(String minutesPlayed) {
                this.minutesPlayed = minutesPlayed;
            }

            public String getGoalScored() {
                return goalScored;
            }

            public void setGoalScored(String goalScored) {
                this.goalScored = goalScored;
            }

            public String getAssist() {
                return assist;
            }

            public void setAssist(String assist) {
                this.assist = assist;
            }

            public String getShotsOnTarget() {
                return shotsOnTarget;
            }

            public void setShotsOnTarget(String shotsOnTarget) {
                this.shotsOnTarget = shotsOnTarget;
            }

            public String getPassCompleted() {
                return passCompleted;
            }

            public void setPassCompleted(String passCompleted) {
                this.passCompleted = passCompleted;
            }

            public String getCleanSheet() {
                return cleanSheet;
            }

            public void setCleanSheet(String cleanSheet) {
                this.cleanSheet = cleanSheet;
            }

            public String getGoalsSaved() {
                return goalsSaved;
            }

            public void setGoalsSaved(String goalsSaved) {
                this.goalsSaved = goalsSaved;
            }

            public String getPenaltySaved() {
                return penaltySaved;
            }

            public void setPenaltySaved(String penaltySaved) {
                this.penaltySaved = penaltySaved;
            }

            public String getTackles() {
                return tackles;
            }

            public void setTackles(String tackles) {
                this.tackles = tackles;
            }

            public String getYellowCard() {
                return yellowCard;
            }

            public void setYellowCard(String yellowCard) {
                this.yellowCard = yellowCard;
            }

            public String getRedCard() {
                return redCard;
            }

            public void setRedCard(String redCard) {
                this.redCard = redCard;
            }

            public String getOwnGoal() {
                return ownGoal;
            }

            public void setOwnGoal(String ownGoal) {
                this.ownGoal = ownGoal;
            }

            public String getGoalConceded() {
                return goalConceded;
            }

            public void setGoalConceded(String goalConceded) {
                this.goalConceded = goalConceded;
            }

            public String getPenaltyMissed() {
                return penaltyMissed;
            }

            public void setPenaltyMissed(String penaltyMissed) {
                this.penaltyMissed = penaltyMissed;
            }

            public String getTotalPoint() {
                return totalPoint;
            }

            public void setTotalPoint(String totalPoint) {
                this.totalPoint = totalPoint;
            }
        }

        public static class PointsBean implements Serializable {
            /**
             * minutes_played : 5
             * goal_Scored : 0
             * assist : 0
             * shots_on_target : 0
             * pass_completed : 0
             * clean_sheet : 0
             * goals_saved : 0
             * penalty_saved : 0
             * tackles : 0
             * yellow_card : 0
             * red_card : 0
             * own_goal : 0
             * goal_conceded : 0
             * penalty_missed : 0
             * total_point : 15.00
             */

            @SerializedName("minutes_played")
            private String minutesPlayed;
            @SerializedName("goal_Scored")
            private String goalScored;
            @SerializedName("assist")
            private String assist;
            @SerializedName("shots_on_target")
            private String shotsOnTarget;
            @SerializedName("pass_completed")
            private String passCompleted;
            @SerializedName("clean_sheet")
            private String cleanSheet;
            @SerializedName("goals_saved")
            private String goalsSaved;
            @SerializedName("penalty_saved")
            private String penaltySaved;
            @SerializedName("tackles")
            private String tackles;
            @SerializedName("yellow_card")
            private String yellowCard;
            @SerializedName("red_card")
            private String redCard;
            @SerializedName("own_goal")
            private String ownGoal;
            @SerializedName("goal_conceded")
            private String goalConceded;
            @SerializedName("penalty_missed")
            private String penaltyMissed;
            @SerializedName("total_point")
            private String totalPoint;

            public String getMinutesPlayed() {
                return minutesPlayed;
            }

            public void setMinutesPlayed(String minutesPlayed) {
                this.minutesPlayed = minutesPlayed;
            }

            public String getGoalScored() {
                return goalScored;
            }

            public void setGoalScored(String goalScored) {
                this.goalScored = goalScored;
            }

            public String getAssist() {
                return assist;
            }

            public void setAssist(String assist) {
                this.assist = assist;
            }

            public String getShotsOnTarget() {
                return shotsOnTarget;
            }

            public void setShotsOnTarget(String shotsOnTarget) {
                this.shotsOnTarget = shotsOnTarget;
            }

            public String getPassCompleted() {
                return passCompleted;
            }

            public void setPassCompleted(String passCompleted) {
                this.passCompleted = passCompleted;
            }

            public String getCleanSheet() {
                return cleanSheet;
            }

            public void setCleanSheet(String cleanSheet) {
                this.cleanSheet = cleanSheet;
            }

            public String getGoalsSaved() {
                return goalsSaved;
            }

            public void setGoalsSaved(String goalsSaved) {
                this.goalsSaved = goalsSaved;
            }

            public String getPenaltySaved() {
                return penaltySaved;
            }

            public void setPenaltySaved(String penaltySaved) {
                this.penaltySaved = penaltySaved;
            }

            public String getTackles() {
                return tackles;
            }

            public void setTackles(String tackles) {
                this.tackles = tackles;
            }

            public String getYellowCard() {
                return yellowCard;
            }

            public void setYellowCard(String yellowCard) {
                this.yellowCard = yellowCard;
            }

            public String getRedCard() {
                return redCard;
            }

            public void setRedCard(String redCard) {
                this.redCard = redCard;
            }

            public String getOwnGoal() {
                return ownGoal;
            }

            public void setOwnGoal(String ownGoal) {
                this.ownGoal = ownGoal;
            }

            public String getGoalConceded() {
                return goalConceded;
            }

            public void setGoalConceded(String goalConceded) {
                this.goalConceded = goalConceded;
            }

            public String getPenaltyMissed() {
                return penaltyMissed;
            }

            public void setPenaltyMissed(String penaltyMissed) {
                this.penaltyMissed = penaltyMissed;
            }

            public String getTotalPoint() {
                return totalPoint;
            }

            public void setTotalPoint(String totalPoint) {
                this.totalPoint = totalPoint;
            }
        }
    }
}
