package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JoinedContestOutput {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"TotalRecords":1,"Records":[{"ContestGUID":"94751fc5-6f01-0e28-9654-9c703a2b9f4c","ContestName":"SuperSmash10-19","CustomizeWinning":[{"From":1,"To":1,"Percent":"70","WinningAmount":"70.0"},{"From":2,"To":2,"Percent":"30","WinningAmount":"30.0"}],"UserInvitationCode":"5WRth9","Privacy":"No","IsPaid":"Yes","WinningAmount":"100","ContestSize":"2","EntryFee":"55","NoOfWinners":"2","EntryType":"Multiple","Status":"Pending","SeriesName":"Super Smash 2018-19","MatchNo":"14th Match","MatchStartDateTime":"2019-01-10 11:40:00 11:40 AM","TeamNameLocal":"Central Stags","TeamNameVisitor":"Otago Volts","TeamNameShortLocal":"CS","TeamNameShortVisitor":"OV","TeamFlagLocal":"http://mwdemoserver.com/515-/api/uploads/TeamFlag/ac030a25-54e0-2a43-576f-5986a5ab95e2.jpg","TeamFlagVisitor":"http://mwdemoserver.com/515-MyMatch11/api/uploads/TeamFlag/dcfee45c-afde-7ee6-4968-e1ccd11e02b7.gif","MatchLocation":"McLean Park, Napier, New Zealand","MatchGUID":"0f46b082-6837-6380-295f-14a9a004da73","UserTotalJoinedInMatch":"1","UserWinningAmount":"0.00","CurrentDateTime":"2019-01-10 01:07:58 ","MatchDate":"2019-01-10","MatchTime":"11:40:00"}],"Statics":{"NormalContest":"0","ReverseContest":"0","JoinedContest":"1","TotalTeams":"1","H2HContests":"1"}}
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
         * TotalRecords : 1
         * Records : [{"ContestGUID":"94751fc5-6f01-0e28-9654-9c703a2b9f4c","ContestName":"SuperSmash10-19","CustomizeWinning":[{"From":1,"To":1,"Percent":"70","WinningAmount":"70.0"},{"From":2,"To":2,"Percent":"30","WinningAmount":"30.0"}],"UserInvitationCode":"5WRth9","Privacy":"No","IsPaid":"Yes","WinningAmount":"100","ContestSize":"2","EntryFee":"55","NoOfWinners":"2","EntryType":"Multiple","Status":"Pending","SeriesName":"Super Smash 2018-19","MatchNo":"14th Match","MatchStartDateTime":"2019-01-10 11:40:00 11:40 AM","TeamNameLocal":"Central Stags","TeamNameVisitor":"Otago Volts","TeamNameShortLocal":"CS","TeamNameShortVisitor":"OV","TeamFlagLocal":"http://mwdemoserver.com/515-/api/uploads/TeamFlag/ac030a25-54e0-2a43-576f-5986a5ab95e2.jpg","TeamFlagVisitor":"http://mwdemoserver.com/515-MyMatch11/api/uploads/TeamFlag/dcfee45c-afde-7ee6-4968-e1ccd11e02b7.gif","MatchLocation":"McLean Park, Napier, New Zealand","MatchGUID":"0f46b082-6837-6380-295f-14a9a004da73","UserTotalJoinedInMatch":"1","UserWinningAmount":"0.00","CurrentDateTime":"2019-01-10 01:07:58 ","MatchDate":"2019-01-10","MatchTime":"11:40:00"}]
         * Statics : {"NormalContest":"0","ReverseContest":"0","JoinedContest":"1","TotalTeams":"1","H2HContests":"1"}
         */

        @SerializedName("TotalRecords")
        private int TotalRecords;
        @SerializedName("Statics")
        private StaticsBean Statics;
        @SerializedName("Records")
        private List<RecordsBean> Records;

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int TotalRecords) {
            this.TotalRecords = TotalRecords;
        }

        public StaticsBean getStatics() {
            return Statics;
        }

        public void setStatics(StaticsBean Statics) {
            this.Statics = Statics;
        }

        public List<RecordsBean> getRecords() {
            return Records;
        }

        public void setRecords(List<RecordsBean> Records) {
            this.Records = Records;
        }

        public static class StaticsBean {
            /**
             * NormalContest : 0
             * ReverseContest : 0
             * JoinedContest : 1
             * TotalTeams : 1
             * H2HContests : 1
             */

            @SerializedName("NormalContest")
            private String NormalContest;
            @SerializedName("ReverseContest")
            private String ReverseContest;
            @SerializedName("JoinedContest")
            private String JoinedContest;
            @SerializedName("TotalTeams")
            private String TotalTeams;
            @SerializedName("H2HContests")
            private String H2HContests;

            public String getNormalContest() {
                return NormalContest;
            }

            public void setNormalContest(String NormalContest) {
                this.NormalContest = NormalContest;
            }

            public String getReverseContest() {
                return ReverseContest;
            }

            public void setReverseContest(String ReverseContest) {
                this.ReverseContest = ReverseContest;
            }

            public String getJoinedContest() {
                return JoinedContest;
            }

            public void setJoinedContest(String JoinedContest) {
                this.JoinedContest = JoinedContest;
            }

            public String getTotalTeams() {
                return TotalTeams;
            }

            public void setTotalTeams(String TotalTeams) {
                this.TotalTeams = TotalTeams;
            }

            public String getH2HContests() {
                return H2HContests;
            }

            public void setH2HContests(String H2HContests) {
                this.H2HContests = H2HContests;
            }
        }

        public static class RecordsBean {
            /**
             * ContestGUID : 94751fc5-6f01-0e28-9654-9c703a2b9f4c
             * ContestName : SuperSmash10-19
             * CustomizeWinning : [{"From":1,"To":1,"Percent":"70","WinningAmount":"70.0"},{"From":2,"To":2,"Percent":"30","WinningAmount":"30.0"}]
             * UserInvitationCode : 5WRth9
             * Privacy : No
             * IsPaid : Yes
             * WinningAmount : 100
             * ContestSize : 2
             * EntryFee : 55
             * NoOfWinners : 2
             * EntryType : Multiple
             * Status : Pending
             * SeriesName : Super Smash 2018-19
             * MatchNo : 14th Match
             * MatchStartDateTime : 2019-01-10 11:40:00 11:40 AM
             * TeamNameLocal : Central Stags
             * TeamNameVisitor : Otago Volts
             * TeamNameShortLocal : CS
             * TeamNameShortVisitor : OV
             * TeamFlagLocal : http://mwdemoserver.com/515-/api/uploads/TeamFlag/ac030a25-54e0-2a43-576f-5986a5ab95e2.jpg
             * TeamFlagVisitor : http://mwdemoserver.com/515-/api/uploads/TeamFlag/dcfee45c-afde-7ee6-4968-e1ccd11e02b7.gif
             * MatchLocation : McLean Park, Napier, New Zealand
             * MatchGUID : 0f46b082-6837-6380-295f-14a9a004da73
             * UserTotalJoinedInMatch : 1
             * UserWinningAmount : 0.00
             * CurrentDateTime : 2019-01-10 01:07:58
             * MatchDate : 2019-01-10
             * MatchTime : 11:40:00
             * "Status": "Pending",
             *         "ContestType": "Normal",
             *         "TotalPoints": "0.00",
             *         "UserRank": "",
             *         "UserTeamName": " Team 1",
             */



            @SerializedName("ContestType")
            private String ContestType;

            @SerializedName("TotalPoints")
            private String TotalPoints;
            @SerializedName("UserRank")
            private String UserRank;

            @SerializedName("UserTeamName")
            private String UserTeamName;

            @SerializedName("ContestGUID")
            private String ContestGUID;
            @SerializedName("ContestName")
            private String ContestName;
            @SerializedName("UserInvitationCode")
            private String UserInvitationCode;
            @SerializedName("Privacy")
            private String Privacy;
            @SerializedName("IsPaid")
            private String IsPaid;
            @SerializedName("WinningAmount")
            private String WinningAmount;
            @SerializedName("ContestSize")
            private String ContestSize;
            @SerializedName("EntryFee")
            private String EntryFee;
            @SerializedName("NoOfWinners")
            private String NoOfWinners;
            @SerializedName("EntryType")
            private String EntryType;
            @SerializedName("Status")
            private String Status;
            @SerializedName("SeriesName")
            private String SeriesName;
            @SerializedName("MatchNo")
            private String MatchNo;
            @SerializedName("MatchStartDateTime")
            private String MatchStartDateTime;
            @SerializedName("TeamNameLocal")
            private String TeamNameLocal;
            @SerializedName("TeamNameVisitor")
            private String TeamNameVisitor;
            @SerializedName("TeamNameShortLocal")
            private String TeamNameShortLocal;
            @SerializedName("TeamNameShortVisitor")
            private String TeamNameShortVisitor;
            @SerializedName("TeamFlagLocal")
            private String TeamFlagLocal;
            @SerializedName("TeamFlagVisitor")
            private String TeamFlagVisitor;
            @SerializedName("MatchLocation")
            private String MatchLocation;
            @SerializedName("MatchGUID")
            private String MatchGUID;
            @SerializedName("UserTotalJoinedInMatch")
            private String UserTotalJoinedInMatch;
            @SerializedName("UserWinningAmount")
            private String UserWinningAmount;
            @SerializedName("CurrentDateTime")
            private String CurrentDateTime;
            @SerializedName("MatchDate")
            private String MatchDate;
            @SerializedName("MatchTime")
            private String MatchTime;
            @SerializedName("TotalJoined")
            private String TotalJoined;
            @SerializedName("UnfilledWinningPercent")
            private String UnfilledWinningPercent;
            @SerializedName("IsPlayingXINotificationSent")
            private String IsPlayingXINotificationSent;

            @SerializedName("SmartPoolWinning")
            private String SmartPoolWinning;
            @SerializedName("SmartPool")
            private String SmartPool;
            @SerializedName("CustomizeWinning")
            private List<CustomizeWinningBean> CustomizeWinning;

            @SerializedName("CashBonusContribution")
            private String CashBonusContribution;

            @SerializedName("WinningType")
            private String WinningType;

            public String getCashBonusContribution() {
                return CashBonusContribution;
            }

            public void setCashBonusContribution(String cashBonusContribution) {
                CashBonusContribution = cashBonusContribution;
            }

            public String getTotalJoined() {
                return TotalJoined;
            }

            public void setTotalJoined(String totalJoined) {
                TotalJoined = totalJoined;
            }

            public String getContestType() {
                return ContestType;
            }

            public void setContestType(String contestType) {
                ContestType = contestType;
            }

            public String getTotalPoints() {
                return TotalPoints;
            }

            public void setTotalPoints(String totalPoints) {
                TotalPoints = totalPoints;
            }

            public String getUserRank() {
                return UserRank;
            }

            public void setUserRank(String userRank) {
                UserRank = userRank;
            }

            public String getUserTeamName() {
                return UserTeamName;
            }

            public void setUserTeamName(String userTeamName) {
                UserTeamName = userTeamName;
            }

            public String getContestGUID() {
                return ContestGUID;
            }

            public void setContestGUID(String ContestGUID) {
                this.ContestGUID = ContestGUID;
            }

            public String getContestName() {
                return ContestName;
            }

            public void setContestName(String ContestName) {
                this.ContestName = ContestName;
            }

            public String getUserInvitationCode() {
                return UserInvitationCode;
            }

            public void setUserInvitationCode(String UserInvitationCode) {
                this.UserInvitationCode = UserInvitationCode;
            }

            public String getPrivacy() {
                return Privacy;
            }

            public void setPrivacy(String Privacy) {
                this.Privacy = Privacy;
            }

            public String getIsPaid() {
                return IsPaid;
            }

            public void setIsPaid(String IsPaid) {
                this.IsPaid = IsPaid;
            }

            public String getWinningAmount() {
                return WinningAmount;
            }

            public void setWinningAmount(String WinningAmount) {
                this.WinningAmount = WinningAmount;
            }

            public String getContestSize() {
                return ContestSize;
            }

            public void setContestSize(String ContestSize) {
                this.ContestSize = ContestSize;
            }

            public String getEntryFee() {
                return EntryFee;
            }

            public void setEntryFee(String EntryFee) {
                this.EntryFee = EntryFee;
            }

            public String getNoOfWinners() {
                return NoOfWinners;
            }

            public void setNoOfWinners(String NoOfWinners) {
                this.NoOfWinners = NoOfWinners;
            }

            public String getEntryType() {
                return EntryType;
            }

            public void setEntryType(String EntryType) {
                this.EntryType = EntryType;
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

            public String getMatchGUID() {
                return MatchGUID;
            }

            public void setMatchGUID(String MatchGUID) {
                this.MatchGUID = MatchGUID;
            }

            public String getUserTotalJoinedInMatch() {
                return UserTotalJoinedInMatch;
            }

            public void setUserTotalJoinedInMatch(String UserTotalJoinedInMatch) {
                this.UserTotalJoinedInMatch = UserTotalJoinedInMatch;
            }

            public String getUserWinningAmount() {
                return UserWinningAmount;
            }

            public void setUserWinningAmount(String UserWinningAmount) {
                this.UserWinningAmount = UserWinningAmount;
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

            public List<CustomizeWinningBean> getCustomizeWinning() {
                return CustomizeWinning;
            }

            public void setCustomizeWinning(List<CustomizeWinningBean> CustomizeWinning) {
                this.CustomizeWinning = CustomizeWinning;
            }

            public String getUnfilledWinningPercent() {
                return UnfilledWinningPercent;
            }

            public void setUnfilledWinningPercent(String unfilledWinningPercent) {
                UnfilledWinningPercent = unfilledWinningPercent;
            }

            public String getSmartPoolWinning() {
                return SmartPoolWinning;
            }

            public void setSmartPoolWinning(String smartPoolWinning) {
                SmartPoolWinning = smartPoolWinning;
            }

            public String getSmartPool() {
                return SmartPool;
            }

            public void setSmartPool(String smartPool) {
                SmartPool = smartPool;
            }

            public String getIsPlayingXINotificationSent() {
                return IsPlayingXINotificationSent;
            }

            public void setIsPlayingXINotificationSent(String isPlayingXINotificationSent) {
                IsPlayingXINotificationSent = isPlayingXINotificationSent;
            }

            public String getWinningType() {
                return WinningType;
            }

            public void setWinningType(String winningType) {
                WinningType = winningType;
            }

            public static class CustomizeWinningBean {
                /**
                 * From : 1
                 * To : 1
                 * Percent : 70
                 * WinningAmount : 70.0
                 */

                @SerializedName("From")
                private int From;
                @SerializedName("To")
                private int To;
                @SerializedName("Percent")
                private String Percent;
                @SerializedName("WinningAmount")
                private String WinningAmount;

                public int getFrom() {
                    return From;
                }

                public void setFrom(int From) {
                    this.From = From;
                }

                public int getTo() {
                    return To;
                }

                public void setTo(int To) {
                    this.To = To;
                }

                public String getPercent() {
                    return Percent;
                }

                public void setPercent(String Percent) {
                    this.Percent = Percent;
                }

                public String getWinningAmount() {
                    return WinningAmount;
                }

                public void setWinningAmount(String WinningAmount) {
                    this.WinningAmount = WinningAmount;
                }
            }
        }
    }
}