package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResponsePlayerPointsBreakup implements Serializable {


    /**
     * code : 200
     * response : [{"points":{"starting11":"2.00","batting_run":"36.00","batting_s4":"2.50","batting_s6":"0.00","batting_50_100":"2.00","bowling_wicket":"0.00","bowling_maiden":"0.00","catch":"0.00","run_out_stumping":"0","duck":"0","wicket_bonus":"0","strike_rate":"0","economy_rate":"0","total_point":"42.50"},"actual":{"starting11":"2.00","batting_run":"72","batting_s4":"5","batting_s6":"0","batting_50_100":"1","bowling_wicket":"0","bowling_maiden":"0","catch":"0","run_out_stumping":"0","duck":"0","wicket_bonus":"0","strike_rate":"0","economy_rate":"0","total_point":"42.50"},"player_name":"Rahmat Shah","player_id":"44977","credit_point":"6.50","player_pic":"https://cricket.entitysport.com/assets/uploads/2016/03/rahmat-shah-120x120.jpg","total_point":"42.50"}]
     * status : 1
     * message : Player points found successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;


    @SerializedName("selected_by")
    private String selected_by;

    public String getSelected_by() {
        return selected_by;
    }

    public void setSelected_by(String selected_by) {
        this.selected_by = selected_by;
    }

    @SerializedName("response")
    private List<ResponseBean> response;

    public static List<ResponsePlayerPointsBreakup> arrayResponsePlayerPointsBreakupFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ResponsePlayerPointsBreakup>>() {
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

    public static class ResponseBean implements Serializable {
        /**
         * points : {"starting11":"2.00","batting_run":"36.00","batting_s4":"2.50","batting_s6":"0.00","batting_50_100":"2.00","bowling_wicket":"0.00","bowling_maiden":"0.00","catch":"0.00","run_out_stumping":"0","duck":"0","wicket_bonus":"0","strike_rate":"0","economy_rate":"0","total_point":"42.50"}
         * actual : {"starting11":"2.00","batting_run":"72","batting_s4":"5","batting_s6":"0","batting_50_100":"1","bowling_wicket":"0","bowling_maiden":"0","catch":"0","run_out_stumping":"0","duck":"0","wicket_bonus":"0","strike_rate":"0","economy_rate":"0","total_point":"42.50"}
         * player_name : Rahmat Shah
         * player_id : 44977
         * credit_point : 6.50
         * player_pic : https://cricket.entitysport.com/assets/uploads/2016/03/rahmat-shah-120x120.jpg
         * total_point : 42.50
         */

        @SerializedName("points")
        private PointsBean points;
        @SerializedName("actual")
        private ActualBean actual;
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

        public PointsBean getPoints() {
            return points;
        }

        public void setPoints(PointsBean points) {
            this.points = points;
        }

        public ActualBean getActual() {
            return actual;
        }

        public void setActual(ActualBean actual) {
            this.actual = actual;
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

        public static class PointsBean {
            /**
             * starting11 : 2.00
             * batting_run : 36.00
             * batting_s4 : 2.50
             * batting_s6 : 0.00
             * batting_50_100 : 2.00
             * bowling_wicket : 0.00
             * bowling_maiden : 0.00
             * catch : 0.00
             * run_out_stumping : 0
             * duck : 0
             * wicket_bonus : 0
             * strike_rate : 0
             * economy_rate : 0
             * total_point : 42.50
             */

            @SerializedName("starting11")
            private String starting11;
            @SerializedName("batting_run")
            private String battingRun;
            @SerializedName("batting_s4")
            private String battingS4;
            @SerializedName("batting_s6")
            private String battingS6;
            @SerializedName("batting_50_100")
            private String batting50100;
            @SerializedName("bowling_wicket")
            private String bowlingWicket;
            @SerializedName("bowling_maiden")
            private String bowlingMaiden;
            @SerializedName("catch")
            private String catchX;
            @SerializedName("run_out_stumping")
            private String runOutStumping;
            @SerializedName("duck")
            private String duck;
            @SerializedName("wicket_bonus")
            private String wicketBonus;
            @SerializedName("strike_rate")
            private String strikeRate;
            @SerializedName("economy_rate")
            private String economyRate;
            @SerializedName("total_point")
            private String totalPoint;

            public static List<PointsBean> arrayPointsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<PointsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getStarting11() {
                return starting11;
            }

            public void setStarting11(String starting11) {
                this.starting11 = starting11;
            }

            public String getBattingRun() {
                return battingRun;
            }

            public void setBattingRun(String battingRun) {
                this.battingRun = battingRun;
            }

            public String getBattingS4() {
                return battingS4;
            }

            public void setBattingS4(String battingS4) {
                this.battingS4 = battingS4;
            }

            public String getBattingS6() {
                return battingS6;
            }

            public void setBattingS6(String battingS6) {
                this.battingS6 = battingS6;
            }

            public String getBatting50100() {
                return batting50100;
            }

            public void setBatting50100(String batting50100) {
                this.batting50100 = batting50100;
            }

            public String getBowlingWicket() {
                return bowlingWicket;
            }

            public void setBowlingWicket(String bowlingWicket) {
                this.bowlingWicket = bowlingWicket;
            }

            public String getBowlingMaiden() {
                return bowlingMaiden;
            }

            public void setBowlingMaiden(String bowlingMaiden) {
                this.bowlingMaiden = bowlingMaiden;
            }

            public String getCatchX() {
                return catchX;
            }

            public void setCatchX(String catchX) {
                this.catchX = catchX;
            }

            public String getRunOutStumping() {
                return runOutStumping;
            }

            public void setRunOutStumping(String runOutStumping) {
                this.runOutStumping = runOutStumping;
            }

            public String getDuck() {
                return duck;
            }

            public void setDuck(String duck) {
                this.duck = duck;
            }

            public String getWicketBonus() {
                return wicketBonus;
            }

            public void setWicketBonus(String wicketBonus) {
                this.wicketBonus = wicketBonus;
            }

            public String getStrikeRate() {
                return strikeRate;
            }

            public void setStrikeRate(String strikeRate) {
                this.strikeRate = strikeRate;
            }

            public String getEconomyRate() {
                return economyRate;
            }

            public void setEconomyRate(String economyRate) {
                this.economyRate = economyRate;
            }

            public String getTotalPoint() {
                return totalPoint;
            }

            public void setTotalPoint(String totalPoint) {
                this.totalPoint = totalPoint;
            }
        }

        public static class ActualBean {
            /**
             * starting11 : 2.00
             * batting_run : 72
             * batting_s4 : 5
             * batting_s6 : 0
             * batting_50_100 : 1
             * bowling_wicket : 0
             * bowling_maiden : 0
             * catch : 0
             * run_out_stumping : 0
             * duck : 0
             * wicket_bonus : 0
             * strike_rate : 0
             * economy_rate : 0
             * total_point : 42.50
             */

            @SerializedName("starting11")
            private String starting11;
            @SerializedName("batting_run")
            private String battingRun;
            @SerializedName("batting_s4")
            private String battingS4;
            @SerializedName("batting_s6")
            private String battingS6;
            @SerializedName("batting_50_100")
            private String batting50100;
            @SerializedName("bowling_wicket")
            private String bowlingWicket;
            @SerializedName("bowling_maiden")
            private String bowlingMaiden;
            @SerializedName("catch")
            private String catchX;
            @SerializedName("run_out_stumping")
            private String runOutStumping;
            @SerializedName("duck")
            private String duck;
            @SerializedName("wicket_bonus")
            private String wicketBonus;
            @SerializedName("strike_rate")
            private String strikeRate;
            @SerializedName("economy_rate")
            private String economyRate;
            @SerializedName("total_point")
            private String totalPoint;

            public static List<ActualBean> arrayActualBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ActualBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getStarting11() {
                return starting11;
            }

            public void setStarting11(String starting11) {
                this.starting11 = starting11;
            }

            public String getBattingRun() {
                return battingRun;
            }

            public void setBattingRun(String battingRun) {
                this.battingRun = battingRun;
            }

            public String getBattingS4() {
                return battingS4;
            }

            public void setBattingS4(String battingS4) {
                this.battingS4 = battingS4;
            }

            public String getBattingS6() {
                return battingS6;
            }

            public void setBattingS6(String battingS6) {
                this.battingS6 = battingS6;
            }

            public String getBatting50100() {
                return batting50100;
            }

            public void setBatting50100(String batting50100) {
                this.batting50100 = batting50100;
            }

            public String getBowlingWicket() {
                return bowlingWicket;
            }

            public void setBowlingWicket(String bowlingWicket) {
                this.bowlingWicket = bowlingWicket;
            }

            public String getBowlingMaiden() {
                return bowlingMaiden;
            }

            public void setBowlingMaiden(String bowlingMaiden) {
                this.bowlingMaiden = bowlingMaiden;
            }

            public String getCatchX() {
                return catchX;
            }

            public void setCatchX(String catchX) {
                this.catchX = catchX;
            }

            public String getRunOutStumping() {
                return runOutStumping;
            }

            public void setRunOutStumping(String runOutStumping) {
                this.runOutStumping = runOutStumping;
            }

            public String getDuck() {
                return duck;
            }

            public void setDuck(String duck) {
                this.duck = duck;
            }

            public String getWicketBonus() {
                return wicketBonus;
            }

            public void setWicketBonus(String wicketBonus) {
                this.wicketBonus = wicketBonus;
            }

            public String getStrikeRate() {
                return strikeRate;
            }

            public void setStrikeRate(String strikeRate) {
                this.strikeRate = strikeRate;
            }

            public String getEconomyRate() {
                return economyRate;
            }

            public void setEconomyRate(String economyRate) {
                this.economyRate = economyRate;
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
