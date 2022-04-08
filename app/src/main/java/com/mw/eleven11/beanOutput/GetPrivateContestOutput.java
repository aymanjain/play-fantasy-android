package com.mw.eleven11.beanOutput;

import java.io.Serializable;
import java.util.List;

public class GetPrivateContestOutput {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"ContestGUID":"aa9e8b3c-78ce-29e5-deb1-06fd0f1d2567","ContestName":"test6","SeriesID":"3480","IsPaid":"Yes","WinningAmount":"1700","ContestSize":"2","EntryFee":"1000","NoOfWinners":"1","EntryType":"Single","TotalJoined":"1","CustomizeWinning":[{"Rank":"1","From":"1","To":"1","Percent":"100","WinningAmount":"1700"}],"TotalAmountReceived":"1000","TotalWinningAmount":"0.00"}
     */

    private int ResponseCode;
    private String Message;
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
         * ContestGUID : aa9e8b3c-78ce-29e5-deb1-06fd0f1d2567
         * ContestName : test6
         * SeriesID : 3480
         * IsPaid : Yes
         * WinningAmount : 1700
         * ContestSize : 2
         * EntryFee : 1000
         * NoOfWinners : 1
         * EntryType : Single
         * TotalJoined : 1
         * CustomizeWinning : [{"Rank":"1","From":"1","To":"1","Percent":"100","WinningAmount":"1700"}]
         * TotalAmountReceived : 1000
         * TotalWinningAmount : 0.00
         */

        private String ContestGUID;
        private String ContestName;
        private String SeriesID;
        private String RoundID;
        private String MatchGUID;
        private String IsPaid;
        private String WinningAmount;
        private String ContestSize;
        private String EntryFee;
        private String NoOfWinners;
        private String EntryType;
        private String TotalJoined;
        private String TotalAmountReceived;
        private String TotalWinningAmount;
        private String CashBonusContribution;
        private String SeriesGUID;
        private DraftPlayerSelectionCriteria DraftPlayerSelectionCriteria;
        private List<CustomizeWinningBean> CustomizeWinning;


        public String getMatchGUID() {
            return MatchGUID;
        }

        public void setMatchGUID(String matchGUID) {
            MatchGUID = matchGUID;
        }

        public DataBean.DraftPlayerSelectionCriteria getDraftPlayerSelectionCriteria() {
            return DraftPlayerSelectionCriteria;
        }

        public void setDraftPlayerSelectionCriteria(DataBean.DraftPlayerSelectionCriteria draftPlayerSelectionCriteria) {
            DraftPlayerSelectionCriteria = draftPlayerSelectionCriteria;
        }

        public String getRoundID() {
            return RoundID;
        }

        public void setRoundID(String roundID) {
            RoundID = roundID;
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

        public String getSeriesID() {
            return SeriesID;
        }

        public void setSeriesID(String SeriesID) {
            this.SeriesID = SeriesID;
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

        public String getTotalJoined() {
            return TotalJoined;
        }

        public void setTotalJoined(String TotalJoined) {
            this.TotalJoined = TotalJoined;
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

        public List<CustomizeWinningBean> getCustomizeWinning() {
            return CustomizeWinning;
        }

        public void setCustomizeWinning(List<CustomizeWinningBean> CustomizeWinning) {
            this.CustomizeWinning = CustomizeWinning;
        }

        public String getCashBonusContribution() {
            return CashBonusContribution;
        }

        public void setCashBonusContribution(String cashBonusContribution) {
            CashBonusContribution = cashBonusContribution;
        }

        public String getSeriesGUID() {
            return SeriesGUID;
        }

        public void setSeriesGUID(String seriesGUID) {
            SeriesGUID = seriesGUID;
        }

        public static class CustomizeWinningBean {
            /**
             * Rank : 1
             * From : 1
             * To : 1
             * Percent : 100
             * WinningAmount : 1700
             */

            private String Rank;
            private String From;
            private String To;
            private String Percent;
            private String WinningAmount;

            public String getRank() {
                return Rank;
            }

            public void setRank(String Rank) {
                this.Rank = Rank;
            }

            public String getFrom() {
                return From;
            }

            public void setFrom(String From) {
                this.From = From;
            }

            public String getTo() {
                return To;
            }

            public void setTo(String To) {
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


        public static class DraftPlayerSelectionCriteria implements Serializable {

            /**
             * Wk : 1
             * Bat : 2
             * Ar : 3
             * Bowl : 4
             */

            private int Wk;
            private int Bat;
            private int Ar;
            private int Bowl;

            public int getWk() {
                return Wk;
            }

            public void setWk(int Wk) {
                this.Wk = Wk;
            }

            public int getBat() {
                return Bat;
            }

            public void setBat(int Bat) {
                this.Bat = Bat;
            }

            public int getAr() {
                return Ar;
            }

            public void setAr(int Ar) {
                this.Ar = Ar;
            }

            public int getBowl() {
                return Bowl;
            }

            public void setBowl(int Bowl) {
                this.Bowl = Bowl;
            }
        }
    }
}
