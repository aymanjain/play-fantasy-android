package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobiweb on 13/3/18.
 */

public class ResponsePayTmDetails {


    /**
     * ResponseCode : 200
     * Message : Success.
     * Data : {"MerchantID":"ZYoOYz71086222607993","OrderID":326452,"CustomerID":"CUST344184","IndustryTypeID":"Retail","ChannelID":"WAP","Amount":200,"Website":"APPSTAGING","CallbackURL":"https://securegw-stage.paytm.in/paytmchecksum/paytmCallback.jsp","TransactionURL":"https://securegw-stage.paytm.in/theia/processTransaction","CheckSumHash":"nE8jR91fJmF3ehEhPcZMmqsapNYEnMqHe29cqp/VOmFjA1T9OWsbb7wa0RDRCX1VGGQGr49OgsyB+SKgwlrrNiLpOWTUCg0GRQS6hg701q4="}
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
         * MerchantID : ZYoOYz71086222607993
         * OrderID : 326452
         * CustomerID : CUST344184
         * IndustryTypeID : Retail
         * ChannelID : WAP
         * Amount : 200
         * Website : APPSTAGING
         * CallbackURL : https://securegw-stage.paytm.in/paytmchecksum/paytmCallback.jsp
         * TransactionURL : https://securegw-stage.paytm.in/theia/processTransaction
         * CheckSumHash : nE8jR91fJmF3ehEhPcZMmqsapNYEnMqHe29cqp/VOmFjA1T9OWsbb7wa0RDRCX1VGGQGr49OgsyB+SKgwlrrNiLpOWTUCg0GRQS6hg701q4=
         */

        @SerializedName("MerchantID")
        private String MerchantID;
        @SerializedName("OrderID")
        private int OrderID;
        @SerializedName("CustomerID")
        private String CustomerID;
        @SerializedName("IndustryTypeID")
        private String IndustryTypeID;
        @SerializedName("ChannelID")
        private String ChannelID;
        @SerializedName("Amount")
        private int Amount;
        @SerializedName("Website")
        private String Website;
        @SerializedName("CallbackURL")
        private String CallbackURL;
        @SerializedName("TransactionURL")
        private String TransactionURL;
        @SerializedName("CheckSumHash")
        private String CheckSumHash;

        public String getMerchantID() {
            return MerchantID;
        }

        public void setMerchantID(String MerchantID) {
            this.MerchantID = MerchantID;
        }

        public int getOrderID() {
            return OrderID;
        }

        public void setOrderID(int OrderID) {
            this.OrderID = OrderID;
        }

        public String getCustomerID() {
            return CustomerID;
        }

        public void setCustomerID(String CustomerID) {
            this.CustomerID = CustomerID;
        }

        public String getIndustryTypeID() {
            return IndustryTypeID;
        }

        public void setIndustryTypeID(String IndustryTypeID) {
            this.IndustryTypeID = IndustryTypeID;
        }

        public String getChannelID() {
            return ChannelID;
        }

        public void setChannelID(String ChannelID) {
            this.ChannelID = ChannelID;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public String getWebsite() {
            return Website;
        }

        public void setWebsite(String Website) {
            this.Website = Website;
        }

        public String getCallbackURL() {
            return CallbackURL;
        }

        public void setCallbackURL(String CallbackURL) {
            this.CallbackURL = CallbackURL;
        }

        public String getTransactionURL() {
            return TransactionURL;
        }

        public void setTransactionURL(String TransactionURL) {
            this.TransactionURL = TransactionURL;
        }

        public String getCheckSumHash() {
            return CheckSumHash;
        }

        public void setCheckSumHash(String CheckSumHash) {
            this.CheckSumHash = CheckSumHash;
        }
    }
}
