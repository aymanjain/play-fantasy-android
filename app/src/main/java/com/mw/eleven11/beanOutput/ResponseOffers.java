package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseOffers {


    /**
     * code : 200
     * status : 1
     * response : [{"cash_type":"1","coupon_code":"BNUS100MNTH","total_use_user":"1","used_type":"1","coupon_type":"1","user_size":"10000","min_amount":"1","max_amount":"1000","amount":"0","percentage_in_amount":"100","start_date":"2018-11-29","end_date":"2018-12-29","message":"User Offer code BNUS100MNTH. First 10000 users will get up to 1000 Rs cash on add money into your wallet.","description":"Hurry! Offer valid from 29 Nov 2018 to 29 Dec 2018","subdescription":"Offer valid from 29 Nov 2018 to 29 Dec 2018.User will receive cash bonus in there wallet. Team and condition applied*."},{"cash_type":"1","coupon_code":"TESTYOG","total_use_user":"3","used_type":"3","coupon_type":"1","user_size":"3","min_amount":"1","max_amount":"1","amount":"0","percentage_in_amount":"10","start_date":"2018-11-28","end_date":"2018-11-29","message":"User Offer code TESTYOG. First 3 users will get up to 1 Rs cash on add money into your wallet.","description":"Hurry! Offer valid from 28 Nov 2018 to 29 Nov 2018","subdescription":"Offer valid from 28 Nov 2018 to 29 Nov 2018.User will receive cash bonus in there wallet. Team and condition applied*."},{"cash_type":"1","coupon_code":"WED01MNTH","total_use_user":"0","used_type":"4","coupon_type":"1","user_size":"10000","min_amount":"999","max_amount":"100000","amount":"0","percentage_in_amount":"25","start_date":"2018-12-19","end_date":"2018-12-19","message":"User Offer code WED01MNTH. First 10000 users will get up to 100000 Rs cash on add money into your wallet.","description":"Hurry! Offer valid from 19 Dec 2018 to 19 Dec 2018","subdescription":"Offer valid from 19 Dec 2018 to 19 Dec 2018.User will receive cash bonus in there wallet. Team and condition applied*."},{"cash_type":"1","coupon_code":"WED01MNTH","total_use_user":"0","used_type":"4","coupon_type":"1","user_size":"10000","min_amount":"999","max_amount":"100000","amount":"0","percentage_in_amount":"25","start_date":"2018-12-12","end_date":"2018-12-12","message":"User Offer code WED01MNTH. First 10000 users will get up to 100000 Rs cash on add money into your wallet.","description":"Hurry! Offer valid from 12 Dec 2018 to 12 Dec 2018","subdescription":"Offer valid from 12 Dec 2018 to 12 Dec 2018.User will receive cash bonus in there wallet. Team and condition applied*."},{"cash_type":"1","coupon_code":"WED01MNTH","total_use_user":"0","used_type":"4","coupon_type":"1","user_size":"10000","min_amount":"999","max_amount":"100000","amount":"0","percentage_in_amount":"25","start_date":"2018-12-05","end_date":"2018-12-05","message":"User Offer code WED01MNTH. First 10000 users will get up to 100000 Rs cash on add money into your wallet.","description":"Hurry! Offer valid from 05 Dec 2018 to 05 Dec 2018","subdescription":"Offer valid from 05 Dec 2018 to 05 Dec 2018.User will receive cash bonus in there wallet. Team and condition applied*."},{"cash_type":"2","coupon_code":"WIN500","total_use_user":"3","used_type":"4","coupon_type":"3","user_size":"10","min_amount":"0","max_amount":"0","amount":"500","percentage_in_amount":"0","start_date":"2018-11-26","end_date":"2018-11-30","message":"Register and apply offer code WIN500. First 10 users will get 500 Rs cash in there wallet.","description":"Hurry! Offer valid from 26 Nov 2018 to 30 Nov 2018","subdescription":"Offer valid from 26 Nov 2018 to 30 Nov 2018.User will receive cash bonus in there wallet. Team and condition applied*."},{"cash_type":"2","coupon_code":"HAPPY1","total_use_user":"4","used_type":"1","coupon_type":"2","user_size":"5","min_amount":"0","max_amount":"0","amount":"100","percentage_in_amount":"0","start_date":"2018-11-26","end_date":"2018-11-30","message":"Apply Offer code HAPPY1. First 5 users will get 100 Rs cash in there wallet.","description":"Hurry! Offer valid from 26 Nov 2018 to 30 Nov 2018","subdescription":"Offer valid from 26 Nov 2018 to 30 Nov 2018.User will receive cash bonus in there wallet. Team and condition applied*."},{"cash_type":"2","coupon_code":"GRAB11"," D: total_use_user":"7","used_type":"2","coupon_type":"1","user_size":"5","min_amount":"50","max_amount":"500","amount":"0","percentage_in_amount":"10","start_date":"2018-11-26","end_date":"2018-11-30","message":"User Offer code GRAB11. First 5 users will get up to 500 Rs cash on add money into your wallet.","description":"Hurry! Offer valid from 26 Nov 2018 to 30 Nov 2018","subdescription":"Offer valid from 26 Nov 2018 to 30 Nov 2018.User will receive cash bonus in there wallet. Team and condition applied*."},{"cash_type":"1","coupon_code":"TEST10","total_use_user":"1","used_type":"1","coupon_type":"0","user_size":"2","min_amount":"100","max_amount":"150","amount":"0","percentage_in_amount":"10","start_date":"2018-11-26","end_date":"2018-11-30","message":"First 2 lucky users will get up to 150 Rs cash in there wallet.","description":"Hurry! Offer valid from 26 Nov 2018 to 30 Nov 2018","subdescription":"Offer valid from 26 Nov 2018 to 30 Nov 2018.User will receive cash bonus in there wallet. Team and condition applied*."}]
     * message : Offers list found successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("response")
    private List<ResponseBean> response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public List<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseBean> response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * cash_type : 1
         * coupon_code : BNUS100MNTH
         * total_use_user : 1
         * used_type : 1
         * coupon_type : 1
         * user_size : 10000
         * min_amount : 1
         * max_amount : 1000
         * amount : 0
         * percentage_in_amount : 100
         * start_date : 2018-11-29
         * end_date : 2018-12-29
         * message : User Offer code BNUS100MNTH. First 10000 users will get up to 1000 Rs cash on add money into your wallet.
         * description : Hurry! Offer valid from 29 Nov 2018 to 29 Dec 2018
         * subdescription : Offer valid from 29 Nov 2018 to 29 Dec 2018.User will receive cash bonus in there wallet. Team and condition applied*.
         * D: total_use_user : 7
         */

        @SerializedName("cash_type")
        private String cashType;
        @SerializedName("coupon_code")
        private String couponCode;
        @SerializedName("total_use_user")
        private String totalUseUser;
        @SerializedName("used_type")
        private String usedType;
        @SerializedName("coupon_type")
        private String couponType;
        @SerializedName("user_size")
        private String userSize;
        @SerializedName("min_amount")
        private String minAmount;
        @SerializedName("max_amount")
        private String maxAmount;
        @SerializedName("amount")
        private String amount;
        @SerializedName("percentage_in_amount")
        private String percentageInAmount;
        @SerializedName("start_date")
        private String startDate;
        @SerializedName("end_date")
        private String endDate;
        @SerializedName("message")
        private String message;
        @SerializedName("description")
        private String description;
        @SerializedName("subdescription")
        private String subdescription;
        @SerializedName(" D: total_use_user")
        private String _$DTotalUseUser195; // FIXME check this code

        public String getCashType() {
            return cashType;
        }

        public void setCashType(String cashType) {
            this.cashType = cashType;
        }

        public String getCouponCode() {
            return couponCode;
        }

        public void setCouponCode(String couponCode) {
            this.couponCode = couponCode;
        }

        public String getTotalUseUser() {
            return totalUseUser;
        }

        public void setTotalUseUser(String totalUseUser) {
            this.totalUseUser = totalUseUser;
        }

        public String getUsedType() {
            return usedType;
        }

        public void setUsedType(String usedType) {
            this.usedType = usedType;
        }

        public String getCouponType() {
            return couponType;
        }

        public void setCouponType(String couponType) {
            this.couponType = couponType;
        }

        public String getUserSize() {
            return userSize;
        }

        public void setUserSize(String userSize) {
            this.userSize = userSize;
        }

        public String getMinAmount() {
            return minAmount;
        }

        public void setMinAmount(String minAmount) {
            this.minAmount = minAmount;
        }

        public String getMaxAmount() {
            return maxAmount;
        }

        public void setMaxAmount(String maxAmount) {
            this.maxAmount = maxAmount;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getPercentageInAmount() {
            return percentageInAmount;
        }

        public void setPercentageInAmount(String percentageInAmount) {
            this.percentageInAmount = percentageInAmount;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSubdescription() {
            return subdescription;
        }

        public void setSubdescription(String subdescription) {
            this.subdescription = subdescription;
        }

        public String get_$DTotalUseUser195() {
            return _$DTotalUseUser195;
        }

        public void set_$DTotalUseUser195(String _$DTotalUseUser195) {
            this._$DTotalUseUser195 = _$DTotalUseUser195;
        }
    }
}
