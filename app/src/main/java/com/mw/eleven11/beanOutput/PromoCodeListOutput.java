package com.mw.eleven11.beanOutput;

import java.util.List;

public class PromoCodeListOutput {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"Records":[{"CouponGUID":"eb3c2607-544c-3654-b8e7-912077b6b9ee","EntryDate":"2019-06-16 10:36:36","StatusID":"2","CouponTitle":"Test Coupon","CouponDescription":"Test. Please ignore","CouponCode":"TstVikas","CouponType":"Flat","CouponValue":"10","MiniumAmount":"1","MaximumAmount":"1","NumberOfUses":"5","CouponValueLimit":"","CouponValidTillDate":"2019-06-30","Status":"Active"},{"CouponGUID":"3971d0e2-143a-8b31-6efe-4ea8e4ecc7df","EntryDate":"2019-06-14 11:28:56","StatusID":"2","CouponTitle":"gauravzone","CouponDescription":"gauravzone coupon for rs. 50/-","CouponCode":"gauravzone","CouponType":"Flat","CouponValue":"50","MiniumAmount":"10","MaximumAmount":"1000","NumberOfUses":"","CouponValueLimit":"","CouponValidTillDate":"2019-07-09","Status":"Active"}],"TotalRecords":"2"}
     */

    private String ResponseCode;
    private String Message;
    private DataBean Data;

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String ResponseCode) {
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
         * Records : [{"CouponGUID":"eb3c2607-544c-3654-b8e7-912077b6b9ee","EntryDate":"2019-06-16 10:36:36","StatusID":"2","CouponTitle":"Test Coupon","CouponDescription":"Test. Please ignore","CouponCode":"TstVikas","CouponType":"Flat","CouponValue":"10","MiniumAmount":"1","MaximumAmount":"1","NumberOfUses":"5","CouponValueLimit":"","CouponValidTillDate":"2019-06-30","Status":"Active"},{"CouponGUID":"3971d0e2-143a-8b31-6efe-4ea8e4ecc7df","EntryDate":"2019-06-14 11:28:56","StatusID":"2","CouponTitle":"gauravzone","CouponDescription":"gauravzone coupon for rs. 50/-","CouponCode":"gauravzone","CouponType":"Flat","CouponValue":"50","MiniumAmount":"10","MaximumAmount":"1000","NumberOfUses":"","CouponValueLimit":"","CouponValidTillDate":"2019-07-09","Status":"Active"}]
         * TotalRecords : 2
         */

        private String TotalRecords;
        private List<RecordsBean> Records;

        public String getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(String TotalRecords) {
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
             * CouponGUID : eb3c2607-544c-3654-b8e7-912077b6b9ee
             * EntryDate : 2019-06-16 10:36:36
             * StatusID : 2
             * CouponTitle : Test Coupon
             * CouponDescription : Test. Please ignore
             * CouponCode : TstVikas
             * CouponType : Flat
             * CouponValue : 10
             * MiniumAmount : 1
             * MaximumAmount : 1
             * NumberOfUses : 5
             * CouponValueLimit :
             * CouponValidTillDate : 2019-06-30
             * Status : Active
             */

            private String CouponGUID;
            private String EntryDate;
            private String StatusID;
            private String CouponTitle;
            private String CouponDescription;
            private String CouponCode;
            private String CouponType;
            private String CouponValue;
            private String MiniumAmount;
            private String MaximumAmount;
            private String NumberOfUses;
            private String CouponValueLimit;
            private String CouponValidTillDate;
            private String Status;

            public String getCouponGUID() {
                return CouponGUID;
            }

            public void setCouponGUID(String CouponGUID) {
                this.CouponGUID = CouponGUID;
            }

            public String getEntryDate() {
                return EntryDate;
            }

            public void setEntryDate(String EntryDate) {
                this.EntryDate = EntryDate;
            }

            public String getStatusID() {
                return StatusID;
            }

            public void setStatusID(String StatusID) {
                this.StatusID = StatusID;
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

            public String getMiniumAmount() {
                return MiniumAmount;
            }

            public void setMiniumAmount(String MiniumAmount) {
                this.MiniumAmount = MiniumAmount;
            }

            public String getMaximumAmount() {
                return MaximumAmount;
            }

            public void setMaximumAmount(String MaximumAmount) {
                this.MaximumAmount = MaximumAmount;
            }

            public String getNumberOfUses() {
                return NumberOfUses;
            }

            public void setNumberOfUses(String NumberOfUses) {
                this.NumberOfUses = NumberOfUses;
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
}
