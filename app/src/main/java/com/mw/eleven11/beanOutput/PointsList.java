package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PointsList {
    @SerializedName("ResponseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private PointsData data;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PointsData getData() {
        return data;
    }

    public void setData(PointsData data) {
        this.data = data;
    }

    public class PointsData {

        @SerializedName("TotalRecords")
        @Expose
        private Integer totalRecords;
        @SerializedName("Batting")
        @Expose
        private List<AllCricketPoints> batting = null;
        @SerializedName("Bowling")
        @Expose
        private List<AllCricketPoints> bowling = null;
        @SerializedName("Fielding")
        @Expose
        private List<AllCricketPoints> fielding = null;

        @SerializedName("Records")
        @Expose
        private List<AllCricketPoints> Records = null;


        @SerializedName("PlayingTime")
        @Expose
        private List<AllCricketPoints> playingTime = null;


        @SerializedName("Attack")
        @Expose
        private List<AllCricketPoints> attack = null;



        @SerializedName("Defense")
        @Expose
        private List<AllCricketPoints> defense = null;



        @SerializedName("Cards")
        @Expose
        private List<AllCricketPoints> cards = null;



        @SerializedName("StrikeRate")
        @Expose
        private List<AllCricketPoints> strikeRate = null;

        @SerializedName("EconomyRate")
        @Expose
        private List<AllCricketPoints> economyRate = null;


        public List<AllCricketPoints> getAttack() {
            return attack;
        }

        public void setAttack(List<AllCricketPoints> attack) {
            this.attack = attack;
        }

        public List<AllCricketPoints> getDefense() {
            return defense;
        }

        public void setDefense(List<AllCricketPoints> defense) {
            this.defense = defense;
        }

        public List<AllCricketPoints> getCards() {
            return cards;
        }

        public void setCards(List<AllCricketPoints> cards) {
            this.cards = cards;
        }

        public List<AllCricketPoints> getStrikeRate() {
            return strikeRate;
        }

        public void setStrikeRate(List<AllCricketPoints> strikeRate) {
            this.strikeRate = strikeRate;
        }

        public List<AllCricketPoints> getEconomyRate() {
            return economyRate;
        }

        public void setEconomyRate(List<AllCricketPoints> economyRate) {
            this.economyRate = economyRate;
        }

        public Integer getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(Integer totalRecords) {
            this.totalRecords = totalRecords;
        }

        public List<AllCricketPoints> getBatting() {
            return batting;
        }

        public void setBatting(List<AllCricketPoints> batting) {
            this.batting = batting;
        }

        public List<AllCricketPoints> getBowling() {
            return bowling;
        }

        public void setBowling(List<AllCricketPoints> bowling) {
            this.bowling = bowling;
        }

        public List<AllCricketPoints> getFielding() {
            return fielding;
        }

        public void setFielding(List<AllCricketPoints> fielding) {
            this.fielding = fielding;
        }

        public List<AllCricketPoints> getRecords() {
            return Records;
        }

        public void setRecords(List<AllCricketPoints> records) {
            Records = records;
        }

        public List<AllCricketPoints> getPlayingTime() {
            return playingTime;
        }

        public void setPlayingTime(List<AllCricketPoints> playingTime) {
            this.playingTime = playingTime;
        }

        public class AllCricketPoints {

            @SerializedName("PointsT20")
            @Expose
            private String pointsT20;


            @SerializedName("PointsTEST")
            @Expose
            private String PointsTEST;


            @SerializedName("PointsODI")
            @Expose
            private String PointsODI;
            @SerializedName("PointsT10")
            @Expose
            private String PointsT10;
            @SerializedName("PointsTypeGUID")
            @Expose
            private String pointsTypeGUID;
            @SerializedName("PointsTypeDescprition")
            @Expose
            private String pointsTypeDescprition;
            @SerializedName("PointsTypeShortDescription")
            @Expose
            private String pointsTypeShortDescription;
            @SerializedName("PointsType")
            @Expose
            private String pointsType;
            @SerializedName("PointsInningType")
            @Expose
            private String pointsInningType;
            @SerializedName("PointsScoringField")
            @Expose
            private String pointsScoringField;
            @SerializedName("StatusID")
            @Expose
            private String statusID;

            @SerializedName("PointsValue")
            @Expose
            private String pointsValue;

            @SerializedName("Sort")
            @Expose
            private String sort;

            public String getPointsT20() {
                return pointsT20;
            }

            public String getPointsTEST() {
                return PointsTEST;
            }

            public void setPointsTEST(String pointsTEST) {
                PointsTEST = pointsTEST;
            }

            public String getPointsODI() {
                return PointsODI;
            }

            public void setPointsODI(String pointsODI) {
                PointsODI = pointsODI;
            }

            public void setPointsT20(String pointsT20) {
                this.pointsT20 = pointsT20;
            }

            public String getPointsTypeGUID() {
                return pointsTypeGUID;
            }

            public void setPointsTypeGUID(String pointsTypeGUID) {
                this.pointsTypeGUID = pointsTypeGUID;
            }

            public String getPointsTypeDescprition() {
                return pointsTypeDescprition;
            }

            public void setPointsTypeDescprition(String pointsTypeDescprition) {
                this.pointsTypeDescprition = pointsTypeDescprition;
            }

            public String getPointsTypeShortDescription() {
                return pointsTypeShortDescription;
            }

            public void setPointsTypeShortDescription(String pointsTypeShortDescription) {
                this.pointsTypeShortDescription = pointsTypeShortDescription;
            }

            public String getPointsType() {
                return pointsType;
            }

            public void setPointsType(String pointsType) {
                this.pointsType = pointsType;
            }

            public String getPointsInningType() {
                return pointsInningType;
            }

            public void setPointsInningType(String pointsInningType) {
                this.pointsInningType = pointsInningType;
            }

            public String getPointsScoringField() {
                return pointsScoringField;
            }

            public void setPointsScoringField(String pointsScoringField) {
                this.pointsScoringField = pointsScoringField;
            }

            public String getStatusID() {
                return statusID;
            }

            public void setStatusID(String statusID) {
                this.statusID = statusID;
            }

            public String getPointsValue() {
                return pointsValue;
            }

            public void setPointsValue(String pointsValue) {
                this.pointsValue = pointsValue;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getPointsT10() {
                return PointsT10;
            }

            public void setPointsT10(String pointsT10) {
                PointsT10 = pointsT10;
            }
        }
    }
}
