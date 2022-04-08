package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpinWheelOutput {

    @SerializedName("ResponseCode")
    @Expose
    private String responseCode;
    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("Data")
    @Expose
    private SpinData data = null;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SpinData getData() {
        return data;
    }

    public void setData(SpinData data) {
        this.data = data;
    }



    public class SpinWheelData {


        @SerializedName("PointsID")
        @Expose
        private String pointsID;
        @SerializedName("Points")
        @Expose
        private String points;
        @SerializedName("ColourCode")
        @Expose
        private String ColourCode;
        @SerializedName("Pick")
        @Expose
        private String pick;
        @SerializedName("Image")
        @Expose
        private String image;
        @SerializedName("Status")
        @Expose
        private String status;

        public String getPointsID() {
            return pointsID;
        }

        public void setPointsID(String pointsID) {
            this.pointsID = pointsID;
        }

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }

        public String getPick() {
            return pick;
        }

        public void setPick(String pick) {
            this.pick = pick;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getColourCode() {
            return ColourCode;
        }

        public void setColourCode(String colourCode) {
            ColourCode = colourCode;
        }
    }

    public class SpinData {

        @SerializedName("LuckyWheelActive")
        @Expose
        private String LuckyWheelActive;
        @SerializedName("LuckyWheelMessage")
        @Expose
        private String LuckyWheelMessage;
        @SerializedName("TotalRecords")
        @Expose
        private String totalRecords;
        @SerializedName("Records")
        @Expose
        private List<SpinWheelData> records = null;
        @SerializedName("IsPlay")
        @Expose
        private String isPlay;

        @SerializedName("RenewTime")
        @Expose
        private String RenewTime;

        public String getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(String totalRecords) {
            this.totalRecords = totalRecords;
        }

        public List<SpinWheelData> getRecords() {
            return records;
        }

        public void setRecords(List<SpinWheelData> records) {
            this.records = records;
        }

        public String getIsPlay() {
            return isPlay;
        }

        public void setIsPlay(String isPlay) {
            this.isPlay = isPlay;
        }

        public String getRenewTime() {
            return RenewTime;
        }

        public void setRenewTime(String renewTime) {
            RenewTime = renewTime;
        }

        public String getLuckyWheelActive() {
            return LuckyWheelActive;
        }

        public void setLuckyWheelActive(String luckyWheelActive) {
            LuckyWheelActive = luckyWheelActive;
        }

        public String getLuckyWheelMessage() {
            return LuckyWheelMessage;
        }

        public void setLuckyWheelMessage(String luckyWheelMessage) {
            LuckyWheelMessage = luckyWheelMessage;
        }
    }
}
