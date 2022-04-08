package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DemoBean {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"ContestGUID":"f66e9d8c-498a-2f58-c343-fbd1f088ea14","ContestName":"sol","Privacy":"Yes","TotalJoined":"1","IsPaid":"Yes","StatusID":"1","WinningAmount":"8","ContestSize":"6","EntryFee":"2","NoOfWinners":"5","EntryType":"Single","IsJoined":"Yes","Status":"Pending","ContestFormat":"League","ContestType":"Normal","CustomizeWinning":[{"From":1,"To":"5","Percent":100,"WinningAmount":"8"}],"UserInvitationCode":"EX4kaW","TeamNameLocal":"New Zealand","TeamNameVisitor":"Bangladesh","IsConfirm":"Yes","CashBonusContribution":"0.00","TeamNameShortLocal":"NZ","TeamNameShortVisitor":"BAN","MatchGUID":"5f0798b3-d317-8d5a-0bc6-6e4ff8c5edfe","MatchScoreDetails":{},"TotalAmountReceived":"2","TotalWinningAmount":"0.00","UserTeamDetails":[{"UserTeamGUID":"efc8556a-ac4a-6d7a-d7bf-ce04dceb4ee2","UserTeamName":" Team 1","UserTeamType":"Normal","UserTeamID":"344413","TotalPoints":"0.00"}],"Statics":{"NormalContest":"1","ReverseContest":"0","JoinedContest":"1","TotalTeams":"1","H2HContests":"0"}}
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
         * ContestGUID : f66e9d8c-498a-2f58-c343-fbd1f088ea14
         * ContestName : sol
         * Privacy : Yes
         * TotalJoined : 1
         * IsPaid : Yes
         * StatusID : 1
         * WinningAmount : 8
         * ContestSize : 6
         * EntryFee : 2
         * NoOfWinners : 5
         * EntryType : Single
         * IsJoined : Yes
         * Status : Pending
         * ContestFormat : League
         * ContestType : Normal
         * CustomizeWinning : [{"From":1,"To":"5","Percent":100,"WinningAmount":"8"}]
         * UserInvitationCode : EX4kaW
         * TeamNameLocal : New Zealand
         * TeamNameVisitor : Bangladesh
         * IsConfirm : Yes
         * CashBonusContribution : 0.00
         * TeamNameShortLocal : NZ
         * TeamNameShortVisitor : BAN
         * MatchGUID : 5f0798b3-d317-8d5a-0bc6-6e4ff8c5edfe
         * MatchScoreDetails : {}
         * TotalAmountReceived : 2
         * TotalWinningAmount : 0.00
         * UserTeamDetails : [{"UserTeamGUID":"efc8556a-ac4a-6d7a-d7bf-ce04dceb4ee2","UserTeamName":" Team 1","UserTeamType":"Normal","UserTeamID":"344413","TotalPoints":"0.00"}]
         * Statics : {"NormalContest":"1","ReverseContest":"0","JoinedContest":"1","TotalTeams":"1","H2HContests":"0"}
         */

        @SerializedName("ContestGUID")
        private String ContestGUID;
        @SerializedName("ContestName")
        private String ContestName;
        @SerializedName("Privacy")
        private String Privacy;
        @SerializedName("TotalJoined")
        private String TotalJoined;
        @SerializedName("IsPaid")
        private String IsPaid;
        @SerializedName("StatusID")
        private String StatusID;
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
        @SerializedName("IsJoined")
        private String IsJoined;
        @SerializedName("Status")
        private String Status;
        @SerializedName("ContestFormat")
        private String ContestFormat;
        @SerializedName("ContestType")
        private String ContestType;
        @SerializedName("UserInvitationCode")
        private String UserInvitationCode;
        @SerializedName("TeamNameLocal")
        private String TeamNameLocal;
        @SerializedName("TeamNameVisitor")
        private String TeamNameVisitor;
        @SerializedName("IsConfirm")
        private String IsConfirm;
        @SerializedName("CashBonusContribution")
        private String CashBonusContribution;
        @SerializedName("TeamNameShortLocal")
        private String TeamNameShortLocal;
        @SerializedName("TeamNameShortVisitor")
        private String TeamNameShortVisitor;
        @SerializedName("MatchGUID")
        private String MatchGUID;
        @SerializedName("MatchScoreDetails")
        private MatchScoreDetailsBean MatchScoreDetails;
        @SerializedName("TotalAmountReceived")
        private String TotalAmountReceived;
        @SerializedName("TotalWinningAmount")
        private String TotalWinningAmount;
        @SerializedName("Statics")
        private StaticsBean Statics;
        @SerializedName("CustomizeWinning")
        private List<CustomizeWinningBean> CustomizeWinning;
        @SerializedName("UserTeamDetails")
        private List<UserTeamDetailsBean> UserTeamDetails;

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

        public String getPrivacy() {
            return Privacy;
        }

        public void setPrivacy(String Privacy) {
            this.Privacy = Privacy;
        }

        public String getTotalJoined() {
            return TotalJoined;
        }

        public void setTotalJoined(String TotalJoined) {
            this.TotalJoined = TotalJoined;
        }

        public String getIsPaid() {
            return IsPaid;
        }

        public void setIsPaid(String IsPaid) {
            this.IsPaid = IsPaid;
        }

        public String getStatusID() {
            return StatusID;
        }

        public void setStatusID(String StatusID) {
            this.StatusID = StatusID;
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

        public String getIsJoined() {
            return IsJoined;
        }

        public void setIsJoined(String IsJoined) {
            this.IsJoined = IsJoined;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getContestFormat() {
            return ContestFormat;
        }

        public void setContestFormat(String ContestFormat) {
            this.ContestFormat = ContestFormat;
        }

        public String getContestType() {
            return ContestType;
        }

        public void setContestType(String ContestType) {
            this.ContestType = ContestType;
        }

        public String getUserInvitationCode() {
            return UserInvitationCode;
        }

        public void setUserInvitationCode(String UserInvitationCode) {
            this.UserInvitationCode = UserInvitationCode;
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

        public String getIsConfirm() {
            return IsConfirm;
        }

        public void setIsConfirm(String IsConfirm) {
            this.IsConfirm = IsConfirm;
        }

        public String getCashBonusContribution() {
            return CashBonusContribution;
        }

        public void setCashBonusContribution(String CashBonusContribution) {
            this.CashBonusContribution = CashBonusContribution;
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

        public String getMatchGUID() {
            return MatchGUID;
        }

        public void setMatchGUID(String MatchGUID) {
            this.MatchGUID = MatchGUID;
        }

        public MatchScoreDetailsBean getMatchScoreDetails() {
            return MatchScoreDetails;
        }

        public void setMatchScoreDetails(MatchScoreDetailsBean MatchScoreDetails) {
            this.MatchScoreDetails = MatchScoreDetails;
        }

        public String getTotalAmountReceived() {
            return TotalAmountReceived;
        }

        public void setTotalAmountReceived(String TotalAmountReceived) {
            this.TotalAmountReceived = TotalAmountReceived;
        }

        public String getTotalWinningAmount() {
            return TotalWinningAmount;
        }

        public void setTotalWinningAmount(String TotalWinningAmount) {
            this.TotalWinningAmount = TotalWinningAmount;
        }

        public StaticsBean getStatics() {
            return Statics;
        }

        public void setStatics(StaticsBean Statics) {
            this.Statics = Statics;
        }

        public List<CustomizeWinningBean> getCustomizeWinning() {
            return CustomizeWinning;
        }

        public void setCustomizeWinning(List<CustomizeWinningBean> CustomizeWinning) {
            this.CustomizeWinning = CustomizeWinning;
        }

        public List<UserTeamDetailsBean> getUserTeamDetails() {
            return UserTeamDetails;
        }

        public void setUserTeamDetails(List<UserTeamDetailsBean> UserTeamDetails) {
            this.UserTeamDetails = UserTeamDetails;
        }

        public static class MatchScoreDetailsBean {
        }

        public static class StaticsBean {
            /**
             * NormalContest : 1
             * ReverseContest : 0
             * JoinedContest : 1
             * TotalTeams : 1
             * H2HContests : 0
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

        public static class CustomizeWinningBean {
            /**
             * From : 1
             * To : 5
             * Percent : 100
             * WinningAmount : 8
             */

            @SerializedName("From")
            private int From;
            @SerializedName("To")
            private String To;
            @SerializedName("Percent")
            private int Percent;
            @SerializedName("WinningAmount")
            private String WinningAmount;

            public int getFrom() {
                return From;
            }

            public void setFrom(int From) {
                this.From = From;
            }

            public String getTo() {
                return To;
            }

            public void setTo(String To) {
                this.To = To;
            }

            public int getPercent() {
                return Percent;
            }

            public void setPercent(int Percent) {
                this.Percent = Percent;
            }

            public String getWinningAmount() {
                return WinningAmount;
            }

            public void setWinningAmount(String WinningAmount) {
                this.WinningAmount = WinningAmount;
            }
        }

        public static class UserTeamDetailsBean {
            /**
             * UserTeamGUID : efc8556a-ac4a-6d7a-d7bf-ce04dceb4ee2
             * UserTeamName :  Team 1
             * UserTeamType : Normal
             * UserTeamID : 344413
             * TotalPoints : 0.00
             */

            @SerializedName("UserTeamGUID")
            private String UserTeamGUID;
            @SerializedName("UserTeamName")
            private String UserTeamName;
            @SerializedName("UserTeamType")
            private String UserTeamType;
            @SerializedName("UserTeamID")
            private String UserTeamID;
            @SerializedName("TotalPoints")
            private String TotalPoints;

            public String getUserTeamGUID() {
                return UserTeamGUID;
            }

            public void setUserTeamGUID(String UserTeamGUID) {
                this.UserTeamGUID = UserTeamGUID;
            }

            public String getUserTeamName() {
                return UserTeamName;
            }

            public void setUserTeamName(String UserTeamName) {
                this.UserTeamName = UserTeamName;
            }

            public String getUserTeamType() {
                return UserTeamType;
            }

            public void setUserTeamType(String UserTeamType) {
                this.UserTeamType = UserTeamType;
            }

            public String getUserTeamID() {
                return UserTeamID;
            }

            public void setUserTeamID(String UserTeamID) {
                this.UserTeamID = UserTeamID;
            }

            public String getTotalPoints() {
                return TotalPoints;
            }

            public void setTotalPoints(String TotalPoints) {
                this.TotalPoints = TotalPoints;
            }
        }
    }
}