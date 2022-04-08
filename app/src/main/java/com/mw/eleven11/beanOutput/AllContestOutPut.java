package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllContestOutPut {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"TotalRecords":4,"Records":[{"ContestGUID":"75e277a1-a7d0-30ec-7dd6-089cb74c6530","ContestName":"More Contest 1","Privacy":"No","TotalJoined":"0","IsPaid":"Yes","StatusID":"1","WinningAmount":"100","ContestSize":"2","EntryFee":"11","NoOfWinners":"1","EntryType":"Single","IsJoined":"No","Status":"Pending","ContestFormat":"Head to Head","ContestType":"More","CustomizeWinning":[{"From":1,"To":1,"Percent":"100","WinningAmount":"100.0"}],"UserInvitationCode":"jhHRWL","TeamNameLocal":"Hobart Hurricanes","TeamNameVisitor":"Adelaide Strikers","IsConfirm":"Yes","CashBonusContribution":"0.00","TeamNameShortLocal":"HBH","TeamNameShortVisitor":"ADS","MatchScoreDetails":{},"TotalAmountReceived":0,"TotalWinningAmount":0},{"ContestGUID":"b290e753-8cfd-d2a4-43f7-942780e82783","ContestName":"Hot","Privacy":"No","TotalJoined":"0","IsPaid":"Yes","StatusID":"1","WinningAmount":"100","ContestSize":"10","EntryFee":"11","NoOfWinners":"5","EntryType":"Single","IsJoined":"No","Status":"Pending","ContestFormat":"League","ContestType":"Champion","CustomizeWinning":[{"From":1,"To":1,"Percent":"75","WinningAmount":"75.0"},{"From":1,"To":1,"Percent":"25","WinningAmount":"25.0"}],"UserInvitationCode":"M4BX6f","TeamNameLocal":"Hobart Hurricanes","TeamNameVisitor":"Adelaide Strikers","IsConfirm":"Yes","CashBonusContribution":"0.00","TeamNameShortLocal":"HBH","TeamNameShortVisitor":"ADS","MatchScoreDetails":{},"TotalAmountReceived":0,"TotalWinningAmount":0},{"ContestGUID":"ea6e28b1-a848-ba34-742a-c865986f4faa","ContestName":"Champion","Privacy":"No","TotalJoined":"0","IsPaid":"Yes","StatusID":"1","WinningAmount":"100","ContestSize":"10","EntryFee":"11","NoOfWinners":"1","EntryType":"Single","IsJoined":"No","Status":"Pending","ContestFormat":"League","ContestType":"Practice","CustomizeWinning":[{"From":1,"To":1,"Percent":"100","WinningAmount":"100.0"}],"UserInvitationCode":"VKb5Ec","TeamNameLocal":"Hobart Hurricanes","TeamNameVisitor":"Adelaide Strikers","IsConfirm":"Yes","CashBonusContribution":"0.00","TeamNameShortLocal":"HBH","TeamNameShortVisitor":"ADS","MatchScoreDetails":{},"TotalAmountReceived":0,"TotalWinningAmount":0},{"ContestGUID":"db7e4380-3408-bf3b-e0a0-f322d28585e8","ContestName":"Practice","Privacy":"No","TotalJoined":"0","IsPaid":"No","StatusID":"1","WinningAmount":"0","ContestSize":"10","EntryFee":"0","NoOfWinners":"0","EntryType":"Single","IsJoined":"No","Status":"Pending","ContestFormat":"League","ContestType":"Practice","CustomizeWinning":[{"From":1,"To":1,"Percent":"100","WinningAmount":"0.00"}],"UserInvitationCode":"Z4frKh","TeamNameLocal":"Hobart Hurricanes","TeamNameVisitor":"Adelaide Strikers","IsConfirm":"Yes","CashBonusContribution":"0.00","TeamNameShortLocal":"HBH","TeamNameShortVisitor":"ADS","MatchScoreDetails":{},"TotalAmountReceived":0,"TotalWinningAmount":0}],"Statics":{"NormalContest":"0","ReverseContest":"0","JoinedContest":"0","TotalTeams":"0","H2HContests":"0"}}
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
         * TotalRecords : 4
         * Records : [{"ContestGUID":"75e277a1-a7d0-30ec-7dd6-089cb74c6530","ContestName":"More Contest 1","Privacy":"No","TotalJoined":"0","IsPaid":"Yes","StatusID":"1","WinningAmount":"100","ContestSize":"2","EntryFee":"11","NoOfWinners":"1","EntryType":"Single","IsJoined":"No","Status":"Pending","ContestFormat":"Head to Head","ContestType":"More","CustomizeWinning":[{"From":1,"To":1,"Percent":"100","WinningAmount":"100.0"}],"UserInvitationCode":"jhHRWL","TeamNameLocal":"Hobart Hurricanes","TeamNameVisitor":"Adelaide Strikers","IsConfirm":"Yes","CashBonusContribution":"0.00","TeamNameShortLocal":"HBH","TeamNameShortVisitor":"ADS","MatchScoreDetails":{},"TotalAmountReceived":0,"TotalWinningAmount":0},{"ContestGUID":"b290e753-8cfd-d2a4-43f7-942780e82783","ContestName":"Hot","Privacy":"No","TotalJoined":"0","IsPaid":"Yes","StatusID":"1","WinningAmount":"100","ContestSize":"10","EntryFee":"11","NoOfWinners":"5","EntryType":"Single","IsJoined":"No","Status":"Pending","ContestFormat":"League","ContestType":"Champion","CustomizeWinning":[{"From":1,"To":1,"Percent":"75","WinningAmount":"75.0"},{"From":1,"To":1,"Percent":"25","WinningAmount":"25.0"}],"UserInvitationCode":"M4BX6f","TeamNameLocal":"Hobart Hurricanes","TeamNameVisitor":"Adelaide Strikers","IsConfirm":"Yes","CashBonusContribution":"0.00","TeamNameShortLocal":"HBH","TeamNameShortVisitor":"ADS","MatchScoreDetails":{},"TotalAmountReceived":0,"TotalWinningAmount":0},{"ContestGUID":"ea6e28b1-a848-ba34-742a-c865986f4faa","ContestName":"Champion","Privacy":"No","TotalJoined":"0","IsPaid":"Yes","StatusID":"1","WinningAmount":"100","ContestSize":"10","EntryFee":"11","NoOfWinners":"1","EntryType":"Single","IsJoined":"No","Status":"Pending","ContestFormat":"League","ContestType":"Practice","CustomizeWinning":[{"From":1,"To":1,"Percent":"100","WinningAmount":"100.0"}],"UserInvitationCode":"VKb5Ec","TeamNameLocal":"Hobart Hurricanes","TeamNameVisitor":"Adelaide Strikers","IsConfirm":"Yes","CashBonusContribution":"0.00","TeamNameShortLocal":"HBH","TeamNameShortVisitor":"ADS","MatchScoreDetails":{},"TotalAmountReceived":0,"TotalWinningAmount":0},{"ContestGUID":"db7e4380-3408-bf3b-e0a0-f322d28585e8","ContestName":"Practice","Privacy":"No","TotalJoined":"0","IsPaid":"No","StatusID":"1","WinningAmount":"0","ContestSize":"10","EntryFee":"0","NoOfWinners":"0","EntryType":"Single","IsJoined":"No","Status":"Pending","ContestFormat":"League","ContestType":"Practice","CustomizeWinning":[{"From":1,"To":1,"Percent":"100","WinningAmount":"0.00"}],"UserInvitationCode":"Z4frKh","TeamNameLocal":"Hobart Hurricanes","TeamNameVisitor":"Adelaide Strikers","IsConfirm":"Yes","CashBonusContribution":"0.00","TeamNameShortLocal":"HBH","TeamNameShortVisitor":"ADS","MatchScoreDetails":{},"TotalAmountReceived":0,"TotalWinningAmount":0}]
         * Statics : {"NormalContest":"0","ReverseContest":"0","JoinedContest":"0","TotalTeams":"0","H2HContests":"0"}
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
             * JoinedContest : 0
             * TotalTeams : 0
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

        public static class RecordsBean {
            /**
             * ContestGUID : 75e277a1-a7d0-30ec-7dd6-089cb74c6530
             * ContestName : More Contest 1
             * Privacy : No
             * TotalJoined : 0
             * IsPaid : Yes
             * StatusID : 1
             * WinningAmount : 100
             * ContestSize : 2
             * EntryFee : 11
             * NoOfWinners : 1
             * EntryType : Single
             * IsJoined : No
             * Status : Pending
             * ContestFormat : Head to Head
             * ContestType : More
             * CustomizeWinning : [{"From":1,"To":1,"Percent":"100","WinningAmount":"100.0"}]
             * UserInvitationCode : jhHRWL
             * TeamNameLocal : Hobart Hurricanes
             * TeamNameVisitor : Adelaide Strikers
             * IsConfirm : Yes
             * CashBonusContribution : 0.00
             * TeamNameShortLocal : HBH
             * TeamNameShortVisitor : ADS
             * MatchScoreDetails : {}
             * TotalAmountReceived : 0
             * TotalWinningAmount : 0
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
            @SerializedName("GuaranteeSeat")
            private String GuaranteeSeat;
            @SerializedName("FirstRankPrize")
            private String FirstRankPrize;
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
            @SerializedName("MatchScoreDetails")
            private MatchScoreDetailsBean MatchScoreDetails;
            @SerializedName("TotalAmountReceived")
            private int TotalAmountReceived;
            @SerializedName("TotalWinningAmount")
            private int TotalWinningAmount;
            @SerializedName("UnfilledWinningPercent")
            private String UnfilledWinningPercent;
            @SerializedName("SmartPool")
            private String SmartPool;

            @SerializedName("WinUpTo")
            private String winUpTo;

            @SerializedName("WinningRatio")
            private String WinningRatio;


            @SerializedName("WinningType")
            private String WinningType;

            @SerializedName("WinnerPercentage")
            private String WinnerPercentage;

            public String getWinnerPercentage() {
                return WinnerPercentage;
            }

            public void setWinnerPercentage(String winnerPercentage) {
                WinnerPercentage = winnerPercentage;
            }


            @SerializedName("CustomizeWinning")
            private List<CustomizeWinningBean> CustomizeWinning;


            public String getGuaranteeSeat() {
                return GuaranteeSeat;
            }

            public void setGuaranteeSeat(String guaranteeSeat) {
                GuaranteeSeat = guaranteeSeat;
            }

            public String getFirstRankPrize() {
                return FirstRankPrize;
            }

            public void setFirstRankPrize(String firstRankPrize) {
                FirstRankPrize = firstRankPrize;
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

            public MatchScoreDetailsBean getMatchScoreDetails() {
                return MatchScoreDetails;
            }

            public void setMatchScoreDetails(MatchScoreDetailsBean MatchScoreDetails) {
                this.MatchScoreDetails = MatchScoreDetails;
            }

            public int getTotalAmountReceived() {
                return TotalAmountReceived;
            }

            public void setTotalAmountReceived(int TotalAmountReceived) {
                this.TotalAmountReceived = TotalAmountReceived;
            }

            public int getTotalWinningAmount() {
                return TotalWinningAmount;
            }

            public void setTotalWinningAmount(int TotalWinningAmount) {
                this.TotalWinningAmount = TotalWinningAmount;
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

            public String getSmartPool() {
                return SmartPool;
            }

            public void setSmartPool(String smartPool) {
                SmartPool = smartPool;
            }

            public String getWinUpTo() {
                return winUpTo;
            }

            public void setWinUpTo(String winUpTo) {
                this.winUpTo = winUpTo;
            }

            public String getWinningRatio() {
                return WinningRatio;
            }

            public void setWinningRatio(String winningRatio) {
                WinningRatio = winningRatio;
            }

            public String getWinningType() {
                return WinningType;
            }

            public void setWinningType(String winningType) {
                WinningType = winningType;
            }

            public static class MatchScoreDetailsBean {
            }

            public static class CustomizeWinningBean {
                /**
                 * From : 1
                 * To : 1
                 * Percent : 100
                 * WinningAmount : 100.0
                 */

                @SerializedName("From")
                private int From;
                @SerializedName("To")
                private int To;
                @SerializedName("Percent")
                private String Percent;
                @SerializedName("WinningAmount")
                private String WinningAmount;

                @SerializedName("ProductUrl")
                private String ProductUrl;


                @SerializedName("ProductName")
                private String ProductName;

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

                public String getProductUrl() {
                    return ProductUrl;
                }

                public void setProductUrl(String productUrl) {
                    ProductUrl = productUrl;
                }

                public String getProductName() {
                    return ProductName;
                }

                public void setProductName(String productName) {
                    ProductName = productName;
                }
            }
        }
    }
}