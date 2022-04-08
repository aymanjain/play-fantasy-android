package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

public class WithDrawoutput {


    /**
     * ResponseCode : 200
     * Message : Success.
     * Data : {"WithdrawalID":5,"WalletDetails":{"WalletAmount":"909.20","WinningAmount":"982.90","CashBonus":"16.40","TotalCash":"1908.50"}}
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
         * WithdrawalID : 5
         * WalletDetails : {"WalletAmount":"909.20","WinningAmount":"982.90","CashBonus":"16.40","TotalCash":"1908.50"}
         */

        @SerializedName("WithdrawalID")
        private int WithdrawalID;
        @SerializedName("WalletDetails")
        private WalletDetailsBean WalletDetails;

        public int getWithdrawalID() {
            return WithdrawalID;
        }

        public void setWithdrawalID(int WithdrawalID) {
            this.WithdrawalID = WithdrawalID;
        }

        public WalletDetailsBean getWalletDetails() {
            return WalletDetails;
        }

        public void setWalletDetails(WalletDetailsBean WalletDetails) {
            this.WalletDetails = WalletDetails;
        }

        public static class WalletDetailsBean {
            /**
             * WalletAmount : 909.20
             * WinningAmount : 982.90
             * CashBonus : 16.40
             * TotalCash : 1908.50
             */

            @SerializedName("WalletAmount")
            private String WalletAmount;
            @SerializedName("WinningAmount")
            private String WinningAmount;
            @SerializedName("CashBonus")
            private String CashBonus;
            @SerializedName("TotalCash")
            private String TotalCash;

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

            public String getTotalCash() {
                return TotalCash;
            }

            public void setTotalCash(String TotalCash) {
                this.TotalCash = TotalCash;
            }
        }
    }
}
