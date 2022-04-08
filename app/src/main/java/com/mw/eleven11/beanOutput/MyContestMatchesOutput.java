package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyContestMatchesOutput {


    /**
     * ResponseCode : 200
     * Message : Success
     */
    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("Message")
    private String Message;
    @SerializedName("Data")
    private DataBean Data;

    public int getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(int ResponseCode) {
        this.ResponseCode = ResponseCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * TotalRecords : 6
         */
        @SerializedName("TotalRecords")
        private int TotalRecords;
        @SerializedName("Records")
        private List<RecordsBean> Records;

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int TotalRecords) {
            this.TotalRecords = TotalRecords;
        }

        public List<RecordsBean> getRecords() {
            return Records;
        }

        public void setRecords(List<RecordsBean> Records) {
            this.Records = Records;
        }

        public static class RecordsBean {
            /**
             * MatchGUID : 52ffeb09-6bb0-b735-7b65-683fc7d345b0
             * TeamNameLocal : Supernovas
             * TeamNameVisitor : Trailblazers
             * TeamNameShortLocal : SNV
             * TeamNameShortVisitor : TBZ
             * Status : Completed
             * SeriesName : Womens T20 Challenge 2019
             * MatchNo : 1st Match
             * MatchStartDateTime : 2019-05-06 19:30:00
             * TeamFlagLocal :
             * TeamFlagVisitor :
             * MatchLocation : Sawai Mansingh Stadium, Jaipur, India
             * CurrentDateTime : 2019-05-07 20:03:14
             * MatchDate : 2019-05-06
             * MatchTime : 19:30:00
             * MatchScoreDetails : {}
             */
            @SerializedName("MatchGUID")
            private String MatchGUID;
            @SerializedName("TeamNameLocal")
            private String TeamNameLocal;
            @SerializedName("TeamNameVisitor")
            private String TeamNameVisitor;
            @SerializedName("TeamNameShortLocal")
            private String TeamNameShortLocal;
            @SerializedName("TeamNameShortVisitor")
            private String TeamNameShortVisitor;
            @SerializedName("Status")
            private String Status;
            @SerializedName("SeriesName")
            private String SeriesName;
            @SerializedName("MatchNo")
            private String MatchNo;
            @SerializedName("MatchType")
            private String MatchType;
            @SerializedName("MatchStartDateTime")
            private String MatchStartDateTime;
            @SerializedName("TeamFlagLocal")
            private String TeamFlagLocal;
            @SerializedName("TeamFlagVisitor")
            private String TeamFlagVisitor;
            @SerializedName("MatchLocation")
            private String MatchLocation;
            @SerializedName("CurrentDateTime")
            private String CurrentDateTime;
            @SerializedName("MatchDate")
            private String MatchDate;
            @SerializedName("MatchTime")
            private String MatchTime;
            @SerializedName("MatchTypeByApi")
            private String MatchTypeByApi;
            @SerializedName("MatchScoreDetails")
            private MatchScoreDetailsBean MatchScoreDetails;
            @SerializedName("IsPlayingXINotificationSent")
            private String IsPlayingXINotificationSent;

            @SerializedName("MatchStartDateTimeUTC")
            private String MatchStartDateTimeUTC;

            @SerializedName("ContestAvailable")
            private String ContestAvailable;

            @SerializedName("TeamPlayersAvailable")
            private String TeamPlayersAvailable;


            public String getMatchStartDateTimeUTC() {
                return MatchStartDateTimeUTC;
            }

            public void setMatchStartDateTimeUTC(String matchStartDateTimeUTC) {
                MatchStartDateTimeUTC = matchStartDateTimeUTC;
            }

            public String getMyTotalJoinedContest() {
                return MyTotalJoinedContest;
            }

            public void setMyTotalJoinedContest(String myTotalJoinedContest) {
                MyTotalJoinedContest = myTotalJoinedContest;
            }

            @SerializedName("MyTotalJoinedContest")
            private String MyTotalJoinedContest;

            public String getMatchGUID() {
                return MatchGUID;
            }

            public void setMatchGUID(String MatchGUID) {
                this.MatchGUID = MatchGUID;
            }

            public String getTeamNameLocal() {
                return TeamNameLocal;
            }

            public void setTeamNameLocal(String TeamNameLocal) {
                this.TeamNameLocal = TeamNameLocal;
            }

            public String getTeamNameVisitor() {
                return TeamNameVisitor;
            }

            public void setTeamNameVisitor(String TeamNameVisitor) {
                this.TeamNameVisitor = TeamNameVisitor;
            }

            public String getTeamNameShortLocal() {
                return TeamNameShortLocal;
            }

            public void setTeamNameShortLocal(String TeamNameShortLocal) {
                this.TeamNameShortLocal = TeamNameShortLocal;
            }

            public String getTeamNameShortVisitor() {
                return TeamNameShortVisitor;
            }

            public void setTeamNameShortVisitor(String TeamNameShortVisitor) {
                this.TeamNameShortVisitor = TeamNameShortVisitor;
            }

            public String getStatus() {
                return Status;
            }

            public void setStatus(String Status) {
                this.Status = Status;
            }

            public String getSeriesName() {
                return SeriesName;
            }

            public void setSeriesName(String SeriesName) {
                this.SeriesName = SeriesName;
            }

            public String getMatchNo() {
                return MatchNo;
            }

            public void setMatchNo(String MatchNo) {
                this.MatchNo = MatchNo;
            }

            public String getMatchStartDateTime() {
                return MatchStartDateTime;
            }

            public void setMatchStartDateTime(String MatchStartDateTime) {
                this.MatchStartDateTime = MatchStartDateTime;
            }

            public String getTeamFlagLocal() {
                return TeamFlagLocal;
            }

            public void setTeamFlagLocal(String TeamFlagLocal) {
                this.TeamFlagLocal = TeamFlagLocal;
            }

            public String getTeamFlagVisitor() {
                return TeamFlagVisitor;
            }

            public void setTeamFlagVisitor(String TeamFlagVisitor) {
                this.TeamFlagVisitor = TeamFlagVisitor;
            }

            public String getMatchLocation() {
                return MatchLocation;
            }

            public void setMatchLocation(String MatchLocation) {
                this.MatchLocation = MatchLocation;
            }

            public String getCurrentDateTime() {
                return CurrentDateTime;
            }

            public void setCurrentDateTime(String CurrentDateTime) {
                this.CurrentDateTime = CurrentDateTime;
            }

            public String getMatchDate() {
                return MatchDate;
            }

            public void setMatchDate(String MatchDate) {
                this.MatchDate = MatchDate;
            }

            public String getMatchTime() {
                return MatchTime;
            }

            public void setMatchTime(String MatchTime) {
                this.MatchTime = MatchTime;
            }

            public MatchScoreDetailsBean getMatchScoreDetails() {
                return MatchScoreDetails;
            }

            public void setMatchScoreDetails(MatchScoreDetailsBean MatchScoreDetails) {
                this.MatchScoreDetails = MatchScoreDetails;
            }

            public String getMatchType() {
                return MatchType;
            }

            public void setMatchType(String matchType) {
                MatchType = matchType;
            }

            public String getIsPlayingXINotificationSent() {
                return IsPlayingXINotificationSent;
            }

            public void setIsPlayingXINotificationSent(String isPlayingXINotificationSent) {
                IsPlayingXINotificationSent = isPlayingXINotificationSent;
            }

            public String getMatchTypeByApi() {
                return MatchTypeByApi;
            }

            public void setMatchTypeByApi(String matchTypeByApi) {
                MatchTypeByApi = matchTypeByApi;
            }

            public String getContestAvailable() {
                return ContestAvailable;
            }

            public void setContestAvailable(String contestAvailable) {
                ContestAvailable = contestAvailable;
            }

            public String getTeamPlayersAvailable() {
                return TeamPlayersAvailable;
            }

            public void setTeamPlayersAvailable(String teamPlayersAvailable) {
                TeamPlayersAvailable = teamPlayersAvailable;
            }

            public static class MatchScoreDetailsBean {
            }
        }
    }
}
