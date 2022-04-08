package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

public class VerifyMobileOutPut {


    /**
     * ResponseCode : 200
     * Message : Profile successfully updated.
     * Data : {"UserGUID":"03105c00-9d88-e3e1-0689-09aa73de769a","UserID":"341505","FullName":"Suhail khan","FirstName":"Suhail khan","LastName":"","Email":"suhail.mobiwebtech@gmail.com","ProfilePic":"http://mwdemoserver.com/515-/api/uploads/profile/picture/default.jpg","UserTypeID":"2","UserTypeName":"User"}
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
         * UserGUID : 03105c00-9d88-e3e1-0689-09aa73de769a
         * UserID : 341505
         * FullName : Suhail khan
         * FirstName : Suhail khan
         * LastName :
         * Email : suhail.mobiwebtech@gmail.com
         * ProfilePic : http://mwdemoserver.com/515-/api/uploads/profile/picture/default.jpg
         * UserTypeID : 2
         * UserTypeName : User
         */

        @SerializedName("UserGUID")
        private String UserGUID;
        @SerializedName("UserID")
        private String UserID;
        @SerializedName("FullName")
        private String FullName;
        @SerializedName("FirstName")
        private String FirstName;
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
}
