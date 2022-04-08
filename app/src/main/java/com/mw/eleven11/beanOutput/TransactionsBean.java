package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionsBean {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"TotalRecords":1,"Records":[{"WalletID":"326604","TransactionType":"Cr","Narration":"Signup Bonus","Amount":"70.00","TransactionID":"","WalletAmount":"0.00","WinningAmount":"0.00","CashBonus":"70.00","EntryDate":"2019-03-01 15:06:30 03:06 PM","CouponDetails":[]}]}
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
         * Records : [{"WalletID":"326604","TransactionType":"Cr","Narration":"Signup Bonus","Amount":"70.00","TransactionID":"","WalletAmount":"0.00","WinningAmount":"0.00","CashBonus":"70.00","EntryDate":"2019-03-01 15:06:30 03:06 PM","CouponDetails":[]}]
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
             * WalletID : 326604
             * TransactionType : Cr
             * Narration : Signup Bonus
             * Amount : 70.00
             * TransactionID :
             * WalletAmount : 0.00
             * WinningAmount : 0.00
             * CashBonus : 70.00
             * EntryDate : 2019-03-01 15:06:30 03:06 PM
             * CouponDetails : []
             */

            @SerializedName("show")
            private boolean show;
            @SerializedName("WalletID")
            private String WalletID;
            @SerializedName("TransactionType")
            private String TransactionType;
            @SerializedName("Narration")
            private String Narration;
            @SerializedName("Amount")
            private String Amount;
            @SerializedName("TransactionID")
            private String TransactionID;
            @SerializedName("WalletAmount")
            private String WalletAmount;
            @SerializedName("WinningAmount")
            private String WinningAmount;
            @SerializedName("CashBonus")
            private String CashBonus;
            @SerializedName("EntryDate")
            private String EntryDate;
            @SerializedName("CouponDetails")
            private List<?> CouponDetails;

            private String Status;
            @SerializedName("Status")

            public boolean isShow() {
                return show;
            }

            public void setShow(boolean show) {
                this.show = show;
            }

            public String getWalletID() {
                return WalletID;
            }

            public void setWalletID(String WalletID) {
                this.WalletID = WalletID;
            }

            public String getTransactionType() {
                return TransactionType;
            }

            public void setTransactionType(String TransactionType) {
                this.TransactionType = TransactionType;
            }

            public String getNarration() {
                return Narration;
            }

            public void setNarration(String Narration) {
                this.Narration = Narration;
            }

            public String getAmount() {
                return Amount;
            }

            public void setAmount(String Amount) {
                this.Amount = Amount;
            }

            public String getTransactionID() {
                return TransactionID;
            }

            public void setTransactionID(String TransactionID) {
                this.TransactionID = TransactionID;
            }

            public String getWalletAmount() {
                return WalletAmount;
            }

            public void setWalletAmount(String WalletAmount) {
                this.WalletAmount = WalletAmount;
            }

            public String getWinningAmount() {
                return WinningAmount;
            }

            public void setWinningAmount(String WinningAmount) {
                this.WinningAmount = WinningAmount;
            }

            public String getCashBonus() {
                return CashBonus;
            }

            public void setCashBonus(String CashBonus) {
                this.CashBonus = CashBonus;
            }

            public String getEntryDate() {
                return EntryDate;
            }

            public void setEntryDate(String EntryDate) {
                this.EntryDate = EntryDate;
            }

            public List<?> getCouponDetails() {
                return CouponDetails;
            }

            public void setCouponDetails(List<?> CouponDetails) {
                this.CouponDetails = CouponDetails;
            }

            public String getStatus() {
                return Status;
            }

            public void setStatus(String status) {
                Status = status;
            }
        }
    }
}
