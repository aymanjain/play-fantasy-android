package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobiweb on 12/3/18.
 */

public class ResponsePayUMoneyDetails {


    /**
     * code : 200
     * response : {"action":"https://sandboxsecure.payu.in/_payment","key":"tLecKRdA","salt":"ebR2I8EP7Y","mid":6086548,"hash":"7c427747602c8298a608811b96dd65185306819c247ef0e3a746ba9fb3e41eedbd2c55ae77bdf69ed3f1bdeb8f68061aece176d1be4d92fcb07ff299fa66eb23","txnid":"a51313e9963d84b6aa61","amount":"1","email":"pintu.mobiwebtech@gmail.com","phone":"9977368049","firstname":"pk patil","productinfo":"ORDS69548972","surl":"http://avishkar.fantasy96.com/payment/PayUMoneyPayResponseSuccess","furl":"http://avishkar.fantasy96.com/payment/PayUMoneyPayResponseFailure","service_provider":"payu_paisa","debug":true}
     * status : 1
     * message : Pay to PayUMoney
     */

    @SerializedName("code")
    private int code;
    @SerializedName("response")
    private ResponseBean response;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
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

    public static class ResponseBean {
        /**
         * action : https://sandboxsecure.payu.in/_payment
         * key : tLecKRdA
         * salt : ebR2I8EP7Y
         * mid : 6086548
         * hash : 7c427747602c8298a608811b96dd65185306819c247ef0e3a746ba9fb3e41eedbd2c55ae77bdf69ed3f1bdeb8f68061aece176d1be4d92fcb07ff299fa66eb23
         * txnid : a51313e9963d84b6aa61
         * amount : 1
         * email : pintu.mobiwebtech@gmail.com
         * phone : 9977368049
         * firstname : pk patil
         * productinfo : ORDS69548972
         * surl : http://avishkar.fantasy96.com/payment/PayUMoneyPayResponseSuccess
         * furl : http://avishkar.fantasy96.com/payment/PayUMoneyPayResponseFailure
         * service_provider : payu_paisa
         * debug : true
         */

        @SerializedName("action")
        private String action;
        @SerializedName("key")
        private String key;
        @SerializedName("salt")
        private String salt;
        @SerializedName("mid")
        private int mid;
        @SerializedName("hash")
        private String hash;
        @SerializedName("txnid")
        private String txnid;
        @SerializedName("amount")
        private double amount;
        @SerializedName("email")
        private String email;
        @SerializedName("phone")
        private String phone;
        @SerializedName("firstname")
        private String firstname;
        @SerializedName("productinfo")
        private String productinfo;
        @SerializedName("surl")
        private String surl;
        @SerializedName("furl")
        private String furl;
        @SerializedName("service_provider")
        private String serviceProvider;
        @SerializedName("debug")
        private boolean debug;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getTxnid() {
            return txnid;
        }

        public void setTxnid(String txnid) {
            this.txnid = txnid;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getProductinfo() {
            return productinfo;
        }

        public void setProductinfo(String productinfo) {
            this.productinfo = productinfo;
        }

        public String getSurl() {
            return surl;
        }

        public void setSurl(String surl) {
            this.surl = surl;
        }

        public String getFurl() {
            return furl;
        }

        public void setFurl(String furl) {
            this.furl = furl;
        }

        public String getServiceProvider() {
            return serviceProvider;
        }

        public void setServiceProvider(String serviceProvider) {
            this.serviceProvider = serviceProvider;
        }

        public boolean isDebug() {
            return debug;
        }

        public void setDebug(boolean debug) {
            this.debug = debug;
        }
    }
}
