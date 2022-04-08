package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

public class JoinContestOutput {


    /**
     * ResponseCode : 200
     * Message : Contest joined successfully.
     * Data : {"WalletAmount":"10966.00","WinningAmount":"0.00","CashBonus":"40.00","TotalCash":"11006.00"}
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
         * WalletAmount : 10966.00
         * WinningAmount : 0.00
         * CashBonus : 40.00
         * TotalCash : 11006.00
         */

        @SerializedName("WalletAmount")
        private String WalletAmount;
        @SerializedName("WinningAmount")
        private String WinningAmount;
        @SerializedName("CashBonus")
        private String CashBonus;
        @SerializedName("TotalCash")
        private String TotalCash;

        public String getRemainingFee() {
            return RemainingFee;
        }

        public void setRemainingFee(String remainingFee) {
            RemainingFee = remainingFee;
        }

        @SerializedName("RemainingFee")
        private String RemainingFee;

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
