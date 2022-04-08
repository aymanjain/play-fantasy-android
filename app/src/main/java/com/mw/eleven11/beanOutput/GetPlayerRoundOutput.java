package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPlayerRoundOutput {

    @SerializedName("ResponseCode")
    @Expose
    private String responseCode;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private PlayerRoundData data;

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

    public PlayerRoundData getData() {
        return data;
    }

    public void setData(PlayerRoundData data) {
        this.data = data;
    }

    public class PlayerRoundData {
        @SerializedName("AllRounder")
        @Expose
        private int allRounder;
        @SerializedName("Bowler")
        @Expose
        private int bowler;
        @SerializedName("Batsman")
        @Expose
        private int batsman;
        @SerializedName("WicketKeeper")
        @Expose
        private int wicketKeeper;

        public int getAllRounder() {
            return allRounder;
        }

        public void setAllRounder(int allRounder) {
            this.allRounder = allRounder;
        }

        public int getBowler() {
            return bowler;
        }

        public void setBowler(int bowler) {
            this.bowler = bowler;
        }

        public int getBatsman() {
            return batsman;
        }

        public void setBatsman(int batsman) {
            this.batsman = batsman;
        }

        public int getWicketKeeper() {
            return wicketKeeper;
        }

        public void setWicketKeeper(int wicketKeeper) {
            this.wicketKeeper = wicketKeeper;
        }
    }
}
