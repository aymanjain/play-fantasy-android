package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

public class ResponceSignup {


    /**
     * ResponseCode : 200
     * Message : Success
     */

    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("Message")
    private String Message;
    @SerializedName("Data")
    private DataBean Data;
    @SerializedName("CaptchaEnable")
    private String CaptchaEnable;

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

    public String getCaptchaEnable() {
        return CaptchaEnable;
    }

    public void setCaptchaEnable(String captchaEnable) {
        CaptchaEnable = captchaEnable;
    }

    public static class DataBean {
        /**
         * UserGUID : ee8381ef-ca7d-3a1e-79aa-83de5224b05c
         * UserID : 18024
         * FullName : Duhail
         * FirstName : Duhail
         * MiddleName :
         * LastName :
         * Email : suhail23.mobiwebtech@gmail.com
         * UserTypeID : 2
         * UserTypeName : User
         * SessionKey : 47a01320-039f-86f2-a220-64aba909fb94
         */

        @SerializedName("UserGUID")
        private String UserGUID;
        @SerializedName("UserID")
        private String UserID;
        @SerializedName("FullName")
        private String FullName;
        @SerializedName("FirstName")
        private String FirstName;
        @SerializedName("MiddleName")
        private String MiddleName;
        @SerializedName("LastName")
        private String LastName;
        @SerializedName("Email")
        private String Email;
        @SerializedName("ProfilePic")
        private String ProfilePic;
        @SerializedName("UserTypeID")
        private String UserTypeID;
        @SerializedName("UserTypeName")
        private String UserTypeName;
        @SerializedName("SessionKey")
        private String SessionKey;

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

        public String getMiddleName() {
            return MiddleName;
        }

        public void setMiddleName(String MiddleName) {
            this.MiddleName = MiddleName;
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

        public String getProfilePic() {
            return ProfilePic;
        }

        public void setProfilePic(String ProfilePic) {
            this.ProfilePic = ProfilePic;
        }

        public String getUserTypeID() {
            return UserTypeID;
        }

        public void setUserTypeID(String UserTypeID) {
            this.UserTypeID = UserTypeID;
        }

        public String getUserTypeName() {
            return UserTypeName;
        }

        public void setUserTypeName(String UserTypeName) {
            this.UserTypeName = UserTypeName;
        }

        public String getSessionKey() {
            return SessionKey;
        }

        public void setSessionKey(String SessionKey) {
            this.SessionKey = SessionKey;
        }
    }
}
