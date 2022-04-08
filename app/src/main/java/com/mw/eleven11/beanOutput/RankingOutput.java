package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mobiweb on 14/3/18.
 */

public class RankingOutput {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"TotalRecords":1,"Records":[{"UserGUID":"b236dbe2-7806-b5eb-0d72-d245509e1adb","TotalPoints":"0.00","Username":"kmvrss","ProfilePic":"http://mwdemoserver.com/515-/api/uploads/profile/picture/default.jpg"}]}
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
         * TotalRecords : 1
         * Records : [{"UserGUID":"b236dbe2-7806-b5eb-0d72-d245509e1adb","TotalPoints":"0.00","Username":"kmvrss","ProfilePic":"http://mwdemoserver.com/515-/api/uploads/profile/picture/default.jpg"}]
         */

        @SerializedName("TotalRecords")
        private int TotalRecords;
        @SerializedName("Records")
        private List<RecordsBean> Records;

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int TotalRecords) {
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
             * UserGUID : b236dbe2-7806-b5eb-0d72-d245509e1adb
             * TotalPoints : 0.00
             * Username : kmvrss
             * ProfilePic : http://mwdemoserver.com/515-/api/uploads/profile/picture/default.jpg
             */

            @SerializedName("UserGUID")
            private String UserGUID;
            @SerializedName("TotalPoints")
            private String TotalPoints;
            @SerializedName("Username")
            private String Username;
            @SerializedName("ProfilePic")
            private String ProfilePic;

            public String getUserGUID() {
                return UserGUID;
            }

            public void setUserGUID(String UserGUID) {
                this.UserGUID = UserGUID;
            }

            public String getTotalPoints() {
                return TotalPoints;
            }

            public void setTotalPoints(String TotalPoints) {
                this.TotalPoints = TotalPoints;
            }

            public String getUsername() {
                return Username;
            }

            public void setUsername(String Username) {
                this.Username = Username;
            }

            public String getProfilePic() {
                return ProfilePic;
            }

            public void setProfilePic(String ProfilePic) {
                this.ProfilePic = ProfilePic;
            }
        }
    }
}
