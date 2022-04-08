package com.mw.eleven11.beanOutput;

import java.util.List;

/**
 * Created by mobiweb on 4/5/18.
 */

public class NotificationsResponse {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"TotalRecords":2,"Records":[{"NotificationPatternGUID":"broadcast","UserGUID":"abcd","RefrenceGUID":"","NotificationText":"hi ","EntryDate":"2019-03-26 16:24:16","StatusID":"2","ProfilePic":""},{"NotificationPatternGUID":"broadcast","UserGUID":"abcd","RefrenceGUID":"","NotificationText":"hi ","EntryDate":"2019-03-26 16:24:16","StatusID":"2","ProfilePic":""}]}
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
         * TotalRecords : 2
         * Records : [{"NotificationPatternGUID":"broadcast","UserGUID":"abcd","RefrenceGUID":"","NotificationText":"hi ","EntryDate":"2019-03-26 16:24:16","StatusID":"2","ProfilePic":""},{"NotificationPatternGUID":"broadcast","UserGUID":"abcd","RefrenceGUID":"","NotificationText":"hi ","EntryDate":"2019-03-26 16:24:16","StatusID":"2","ProfilePic":""}]
         */

        private int TotalRecords;
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
             * NotificationPatternGUID : broadcast
             * UserGUID : abcd
             * RefrenceGUID :
             * NotificationText : hi
             * EntryDate : 2019-03-26 16:24:16
             * StatusID : 2
             * ProfilePic :
             */

            private String NotificationPatternGUID;
            private String UserGUID;
            private String RefrenceGUID;
            private String NotificationText;
            private String EntryDate;
            private String StatusID;
            private String ProfilePic;
            private String NotificationMessage;
            private boolean isSelected = false;

            public boolean isSelected() {
                return isSelected;
            }

            public void setSelected(boolean selected) {
                isSelected = selected;
            }

            public String getNotificationID() {
                return NotificationID;
            }

            public void setNotificationID(String notificationID) {
                NotificationID = notificationID;
            }

            private String NotificationID;

            public String getNotificationMessage() {
                return NotificationMessage;
            }

            public void setNotificationMessage(String notificationMessage) {
                NotificationMessage = notificationMessage;
            }

            public String getNotificationPatternGUID() {
                return NotificationPatternGUID;
            }

            public void setNotificationPatternGUID(String NotificationPatternGUID) {
                this.NotificationPatternGUID = NotificationPatternGUID;
            }

            public String getUserGUID() {
                return UserGUID;
            }

            public void setUserGUID(String UserGUID) {
                this.UserGUID = UserGUID;
            }

            public String getRefrenceGUID() {
                return RefrenceGUID;
            }

            public void setRefrenceGUID(String RefrenceGUID) {
                this.RefrenceGUID = RefrenceGUID;
            }

            public String getNotificationText() {
                return NotificationText;
            }

            public void setNotificationText(String NotificationText) {
                this.NotificationText = NotificationText;
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

            public String getProfilePic() {
                return ProfilePic;
            }

            public void setProfilePic(String ProfilePic) {
                this.ProfilePic = ProfilePic;
            }
        }
    }
}
