package com.mw.eleven11.beanOutput;

import java.io.Serializable;

public class ResponseUpdateProfile implements Serializable {
    /**
     * ResponseCode : 200
     * Message : Profile successfully updated.
     * Data : {"UserGUID":"73ae9b4b-0c3b-9da6-101c-2aade257cb0a","UserID":"1047","FullName":"Sorav garg","FirstName":"Sorav garg","LastName":"","Email":"soravgarg123@gmail.com","ProfilePic":"http://.com/api/uploads/profile/picture/4.png","UserTypeID":"2","UserTypeName":"User"}
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



    public static class DataBean implements Serializable{
        /**
         * UserGUID : 73ae9b4b-0c3b-9da6-101c-2aade257cb0a
         * UserID : 1047
         * FullName : Sorav garg
         * FirstName : Sorav garg
         * LastName :
         * Email : soravgarg123@gmail.com
         * ProfilePic : http://.com/api/uploads/profile/picture/4.png
         * UserTypeID : 2
         * UserTypeName : User
         */

        private String UserGUID;
        private String UserID;
        private String FullName;
        private String FirstName;
        private String LastName;
        private String Email;
        private String ProfilePic;
        private String UserTypeID;
        private String UserTypeName;

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
    }




    /* *//**
     * code : 200
     * status : 1
     * message : Profile updated successfully
     *//*

    private int code;
    private int status;
    private String message;

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
    }*/
}
