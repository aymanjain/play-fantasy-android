package com.mw.eleven11.beanOutput;

public class ResponseReferralDetails {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"ReferByBonus":"50","ReferToBonus":"100"}
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
         * ReferByBonus : 50
         * ReferToBonus : 100
         */

        private String ReferByBonus;
        private String ReferToBonus;

        public String getReferByBonus() {
            return ReferByBonus;
        }

        public void setReferByBonus(String ReferByBonus) {
            this.ReferByBonus = ReferByBonus;
        }

        public String getReferToBonus() {
            return ReferToBonus;
        }

        public void setReferToBonus(String ReferToBonus) {
            this.ReferToBonus = ReferToBonus;
        }
    }
}
