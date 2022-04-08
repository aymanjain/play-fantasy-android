package com.mw.eleven11.beanOutput;

public class PromoCodeResponse {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"CouponGUID":"3971d0e2-143a-8b31-6efe-4ea8e4ecc7df","CouponTitle":"gauravzone","CouponDescription":"gauravzone coupon for rs. 50/-","CouponCode":"gauravzone","CouponType":"Flat","CouponValue":"50","CouponValueLimit":"","CouponValidTillDate":"2019-06-30","Status":"Active"}
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
         * CouponGUID : 3971d0e2-143a-8b31-6efe-4ea8e4ecc7df
         * CouponTitle : gauravzone
         * CouponDescription : gauravzone coupon for rs. 50/-
         * CouponCode : gauravzone
         * CouponType : Flat
         * CouponValue : 50
         * CouponValueLimit :
         * CouponValidTillDate : 2019-06-30
         * Status : Active
         */

        private String CouponGUID;
        private String CouponTitle;
        private String CouponDescription;
        private String CouponCode;
        private String CouponType;
        private String CouponValue;
        private String CouponValueLimit;
        private String CouponValidTillDate;
        private String Status;

        public String getCouponGUID() {
            return CouponGUID;
        }

        public void setCouponGUID(String CouponGUID) {
            this.CouponGUID = CouponGUID;
        }

        public String getCouponTitle() {
            return CouponTitle;
        }

        public void setCouponTitle(String CouponTitle) {
            this.CouponTitle = CouponTitle;
        }

        public String getCouponDescription() {
            return CouponDescription;
        }

        public void setCouponDescription(String CouponDescription) {
            this.CouponDescription = CouponDescription;
        }

        public String getCouponCode() {
            return CouponCode;
        }

        public void setCouponCode(String CouponCode) {
            this.CouponCode = CouponCode;
        }

        public String getCouponType() {
            return CouponType;
        }

        public void setCouponType(String CouponType) {
            this.CouponType = CouponType;
        }

        public String getCouponValue() {
            return CouponValue;
        }

        public void setCouponValue(String CouponValue) {
            this.CouponValue = CouponValue;
        }

        public String getCouponValueLimit() {
            return CouponValueLimit;
        }

        public void setCouponValueLimit(String CouponValueLimit) {
            this.CouponValueLimit = CouponValueLimit;
        }

        public String getCouponValidTillDate() {
            return CouponValidTillDate;
        }

        public void setCouponValidTillDate(String CouponValidTillDate) {
            this.CouponValidTillDate = CouponValidTillDate;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }
    }
}
