package com.mw.eleven11.beanOutput;

public class RequestOtpForSigninOutput {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"UserGUID":"395d9de5-d9ef-10d7-dbaf-00a6a94625c3","UserID":"1582","FullName":"Niks","FirstName":"Niks","LastName":"","Email":"gs.picseditor@gmail.com","StatusID":"2","PhoneNumber":"7000189093"}
     */

    private int ResponseCode;
    private String Message;
    private String CaptchaEnable;
    private DataBean Data;


    public String getCaptchaEnable() {
        return CaptchaEnable;
    }

    public void setCaptchaEnable(String captchaEnable) {
        CaptchaEnable = captchaEnable;
    }

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
         * UserGUID : 395d9de5-d9ef-10d7-dbaf-00a6a94625c3
         * UserID : 1582
         * FullName : Niks
         * FirstName : Niks
         * LastName :
         * Email : gs.picseditor@gmail.com
         * StatusID : 2
         * PhoneNumber : 7000189093
         */

        private String UserGUID;
        private String UserID;
        private String FullName;
        private String FirstName;
        private String LastName;
        private String Email;
        private String StatusID;
        private String PhoneNumber;

        public String getUserGUID() {
            return UserGUID;
        }

        public void setUserGUID(String UserGUID) {
            this.UserGUID = UserGUID;
        }

        public String getUserID() {
            return UserID;
        }

        public void setUserID(String UserID) {
            this.UserID = UserID;
        }

        public String getFullName() {
            return FullName;
        }

        public void setFullName(String FullName) {
            this.FullName = FullName;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String FirstName) {
            this.FirstName = FirstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String LastName) {
            this.LastName = LastName;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getStatusID() {
            return StatusID;
        }

        public void setStatusID(String StatusID) {
            this.StatusID = StatusID;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String PhoneNumber) {
            this.PhoneNumber = PhoneNumber;
        }
    }
}
