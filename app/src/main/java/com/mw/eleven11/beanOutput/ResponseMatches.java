package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiweb on 26/2/18.
 */

public class ResponseMatches {

    /**
     * code : 200
     * response : [{"match_id":"13071928570","series_id":"3127","match_date":"2018-02-23","match_time":"22:00","status":"open","match_type":"Final","match_num":"Final","localteam_id":"2414","localteam":"Central Districts","visitorteam_id":"2476","visitorteam":"Auckland","isContest":"NO"}]
     * status : 1
     * message : Matches found successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("response")
    private List<ResponseBean> response = new ArrayList<>();

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
         * match_id : 13071928570
         * series_id : 3127
         * match_date : 2018-02-23
         * match_time : 22:00
         * status : open
         * match_type : Final
         * match_num : Final
         * localteam_id : 2414
         * localteam : Central Districts
         * visitorteam_id : 2476
         * visitorteam : Auckland
         * isContest : NO
         */

        @SerializedName("match_id")
        private String matchId;
        @SerializedName("series_id")
        private String seriesId;

        @SerializedName("series_name")
        private String series_name;

        @SerializedName("match_date")
        private String matchDate;
        @SerializedName("match_time")
        private String matchTime;
        @SerializedName("status")
        private String status;
        @SerializedName("match_type")
        private String matchType;
        @SerializedName("match_num")
        private String matchNum;
        @SerializedName("localteam_id")
        private String localteamId;
        @SerializedName("localteam")
        private String localteam;
        @SerializedName("visitorteam_id")
        private String visitorteamId;
        @SerializedName("visitorteam")
        private String visitorteam;
        @SerializedName("isContest")
        private String isContest;

        @SerializedName("localteam_image")
        private String localteamImage;
        @SerializedName("visitorteam_image")
        private String visitorteamImage;

        @SerializedName("totalJoinedContest")
        private int totalJoinedContest;

        @SerializedName("currentTime")
        private String currentTime;
        @SerializedName("play_status")
        private String playStatus = "";
        @SerializedName("match_date_time")
        private String matchDateTime = "";

        public String getSeries_name() {
            return series_name;
        }

        public void setSeries_name(String series_name) {
            this.series_name = series_name;
        }

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

        public String getLocalteamImage() {
            return localteamImage;
        }

        public void setLocalteamImage(String localteamImage) {
            this.localteamImage = localteamImage;
        }

        public String getVisitorteamImage() {
            return visitorteamImage;
        }

        public void setVisitorteamImage(String visitorteamImage) {
            this.visitorteamImage = visitorteamImage;
        }

        public int getTotalJoinedContest() {
            return totalJoinedContest;
        }

        public void setTotalJoinedContest(int totalJoinedContest) {
            this.totalJoinedContest = totalJoinedContest;
        }

        public String getMatchId() {
            return matchId;
        }

        public void setMatchId(String matchId) {
            this.matchId = matchId;
        }

        public String getSeriesId() {
            return seriesId;
        }

        public void setSeriesId(String seriesId) {
            this.seriesId = seriesId;
        }

        public String getMatchDate() {
            return matchDate;
        }

        public void setMatchDate(String matchDate) {
            this.matchDate = matchDate;
        }

        public String getMatchTime() {
            return matchTime;
        }

        public void setMatchTime(String matchTime) {
            this.matchTime = matchTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMatchType() {
            return matchType;
        }

        public void setMatchType(String matchType) {
            this.matchType = matchType;
        }

        public String getMatchNum() {
            return matchNum;
        }

        public void setMatchNum(String matchNum) {
            this.matchNum = matchNum;
        }

        public String getLocalteamId() {
            return localteamId;
        }

        public void setLocalteamId(String localteamId) {
            this.localteamId = localteamId;
        }

        public String getLocalteam() {
            return localteam;
        }

        public void setLocalteam(String localteam) {
            this.localteam = localteam;
        }

        public String getVisitorteamId() {
            return visitorteamId;
        }

        public void setVisitorteamId(String visitorteamId) {
            this.visitorteamId = visitorteamId;
        }

        public String getVisitorteam() {
            return visitorteam;
        }

        public void setVisitorteam(String visitorteam) {
            this.visitorteam = visitorteam;
        }

        public String getIsContest() {
            return isContest;
        }

        public void setIsContest(String isContest) {
            this.isContest = isContest;
        }

        public String getPlayStatus() {
            return playStatus;
        }

        public void setPlayStatus(String playStatus) {
            this.playStatus = playStatus;
        }

        public String getMatchDateTime() {
            return matchDateTime;
        }

        public void setMatchDateTime(String matchDateTime) {
            this.matchDateTime = matchDateTime;
        }
    }
}
