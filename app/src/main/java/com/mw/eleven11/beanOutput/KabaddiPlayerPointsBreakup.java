package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class KabaddiPlayerPointsBreakup implements Serializable {

    /**
     * code : 200
     * response : [{"actual":{"starting7":"4.00","substitute_apperance":"0.00","pusing_all_out":"0","getting_all_out":"0","raid_touch_point":"1","raid_bonus":"4","success_tackle":"1","unsuccess_raid":"1","super_tackles":"0","yellow_card":"0","red_card":"0","green_card":"1","total_point":"19.00"},"points":{"starting7":"4.00","substitute_apperance":"0.00","pusing_all_out":"0","getting_all_out":"0","raid_touch_point":"4","raid_bonus":"8","unsuccess_raid":"0","success_tackle":"0","super_tackles":"0","green_card":"2","yellow_card":"0","red_card":"0","total_point":"19.00"},"player_name":"Nilesh Salunke","player_id":"nil_salunke","credit_point":"15.00","player_pic":"https://www.funtush11.com/funtush/backend_asset/images/default-1481.png","total_point":"19.00"}]
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
         * actual : {"starting7":"4.00","substitute_apperance":"0.00","pusing_all_out":"0","getting_all_out":"0","raid_touch_point":"1","raid_bonus":"4","success_tackle":"1","unsuccess_raid":"1","super_tackles":"0","yellow_card":"0","red_card":"0","green_card":"1","total_point":"19.00"}
         * points : {"starting7":"4.00","substitute_apperance":"0.00","pusing_all_out":"0","getting_all_out":"0","raid_touch_point":"4","raid_bonus":"8","unsuccess_raid":"0","success_tackle":"0","super_tackles":"0","green_card":"2","yellow_card":"0","red_card":"0","total_point":"19.00"}
         * player_name : Nilesh Salunke
         * player_id : nil_salunke
         * credit_point : 15.00
         * player_pic : https://www.funtush11.com/funtush/backend_asset/images/default-1481.png
         * total_point : 19.00
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
             * starting7 : 4.00
             * substitute_apperance : 0.00
             * pusing_all_out : 0
             * getting_all_out : 0
             * raid_touch_point : 1
             * raid_bonus : 4
             * success_tackle : 1
             * unsuccess_raid : 1
             * super_tackles : 0
             * yellow_card : 0
             * red_card : 0
             * green_card : 1
             * total_point : 19.00
             */

            @SerializedName("starting7")
            private String starting7;
            @SerializedName("substitute_apperance")
            private String substituteApperance;
            @SerializedName("pusing_all_out")
            private String pusingAllOut;
            @SerializedName("getting_all_out")
            private String gettingAllOut;
            @SerializedName("raid_touch_point")
            private String raidTouchPoint;
            @SerializedName("raid_bonus")
            private String raidBonus;
            @SerializedName("success_tackle")
            private String successTackle;
            @SerializedName("unsuccess_raid")
            private String unsuccessRaid;
            @SerializedName("super_tackles")
            private String superTackles;
            @SerializedName("yellow_card")
            private String yellowCard;
            @SerializedName("red_card")
            private String redCard;
            @SerializedName("green_card")
            private String greenCard;
            @SerializedName("total_point")
            private String totalPoint;

            public String getStarting7() {
                return starting7;
            }

            public void setStarting7(String starting7) {
                this.starting7 = starting7;
            }

            public String getSubstituteApperance() {
                return substituteApperance;
            }

            public void setSubstituteApperance(String substituteApperance) {
                this.substituteApperance = substituteApperance;
            }

            public String getPusingAllOut() {
                return pusingAllOut;
            }

            public void setPusingAllOut(String pusingAllOut) {
                this.pusingAllOut = pusingAllOut;
            }

            public String getGettingAllOut() {
                return gettingAllOut;
            }

            public void setGettingAllOut(String gettingAllOut) {
                this.gettingAllOut = gettingAllOut;
            }

            public String getRaidTouchPoint() {
                return raidTouchPoint;
            }

            public void setRaidTouchPoint(String raidTouchPoint) {
                this.raidTouchPoint = raidTouchPoint;
            }

            public String getRaidBonus() {
                return raidBonus;
            }

            public void setRaidBonus(String raidBonus) {
                this.raidBonus = raidBonus;
            }

            public String getSuccessTackle() {
                return successTackle;
            }

            public void setSuccessTackle(String successTackle) {
                this.successTackle = successTackle;
            }

            public String getUnsuccessRaid() {
                return unsuccessRaid;
            }

            public void setUnsuccessRaid(String unsuccessRaid) {
                this.unsuccessRaid = unsuccessRaid;
            }

            public String getSuperTackles() {
                return superTackles;
            }

            public void setSuperTackles(String superTackles) {
                this.superTackles = superTackles;
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

            public String getGreenCard() {
                return greenCard;
            }

            public void setGreenCard(String greenCard) {
                this.greenCard = greenCard;
            }

            public String getTotalPoint() {
                return totalPoint;
            }

            public void setTotalPoint(String totalPoint) {
                this.totalPoint = totalPoint;
            }
        }

        public static class PointsBean {
            /**
             * starting7 : 4.00
             * substitute_apperance : 0.00
             * pusing_all_out : 0
             * getting_all_out : 0
             * raid_touch_point : 4
             * raid_bonus : 8
             * unsuccess_raid : 0
             * success_tackle : 0
             * super_tackles : 0
             * green_card : 2
             * yellow_card : 0
             * red_card : 0
             * total_point : 19.00
             */

            @SerializedName("starting7")
            private String starting7;
            @SerializedName("substitute_apperance")
            private String substituteApperance;
            @SerializedName("pusing_all_out")
            private String pusingAllOut;
            @SerializedName("getting_all_out")
            private String gettingAllOut;
            @SerializedName("raid_touch_point")
            private String raidTouchPoint;
            @SerializedName("raid_bonus")
            private String raidBonus;
            @SerializedName("unsuccess_raid")
            private String unsuccessRaid;
            @SerializedName("success_tackle")
            private String successTackle;
            @SerializedName("super_tackles")
            private String superTackles;
            @SerializedName("green_card")
            private String greenCard;
            @SerializedName("yellow_card")
            private String yellowCard;
            @SerializedName("red_card")
            private String redCard;
            @SerializedName("total_point")
            private String totalPoint;

            public String getStarting7() {
                return starting7;
            }

            public void setStarting7(String starting7) {
                this.starting7 = starting7;
            }

            public String getSubstituteApperance() {
                return substituteApperance;
            }

            public void setSubstituteApperance(String substituteApperance) {
                this.substituteApperance = substituteApperance;
            }

            public String getPusingAllOut() {
                return pusingAllOut;
            }

            public void setPusingAllOut(String pusingAllOut) {
                this.pusingAllOut = pusingAllOut;
            }

            public String getGettingAllOut() {
                return gettingAllOut;
            }

            public void setGettingAllOut(String gettingAllOut) {
                this.gettingAllOut = gettingAllOut;
            }

            public String getRaidTouchPoint() {
                return raidTouchPoint;
            }

            public void setRaidTouchPoint(String raidTouchPoint) {
                this.raidTouchPoint = raidTouchPoint;
            }

            public String getRaidBonus() {
                return raidBonus;
            }

            public void setRaidBonus(String raidBonus) {
                this.raidBonus = raidBonus;
            }

            public String getUnsuccessRaid() {
                return unsuccessRaid;
            }

            public void setUnsuccessRaid(String unsuccessRaid) {
                this.unsuccessRaid = unsuccessRaid;
            }

            public String getSuccessTackle() {
                return successTackle;
            }

            public void setSuccessTackle(String successTackle) {
                this.successTackle = successTackle;
            }

            public String getSuperTackles() {
                return superTackles;
            }

            public void setSuperTackles(String superTackles) {
                this.superTackles = superTackles;
            }

            public String getGreenCard() {
                return greenCard;
            }

            public void setGreenCard(String greenCard) {
                this.greenCard = greenCard;
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

            public String getTotalPoint() {
                return totalPoint;
            }

            public void setTotalPoint(String totalPoint) {
                this.totalPoint = totalPoint;
            }
        }
    }
}
