package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NotificationBean {

    /**
     * code : 200
     * status : 1
     * response : [{"notification_id":"19993","message":"Bank wire request approved successfully","notification_type":"BANKWIRE","read_status":"NO","sent_time":"2018-10-05 12:25:40"},{"notification_id":"19572","message":"Pan Card successfully verified","notification_type":"VERIFICATION","read_status":"NO","sent_time":"2018-10-05 11:36:08"},{"notification_id":"19146","message":"Pan Card successfully verified","notification_type":"VERIFICATION","read_status":"NO","sent_time":"2018-10-05 10:25:06"},{"notification_id":"19145","message":"Pan Card successfully verified","notification_type":"VERIFICATION","read_status":"NO","sent_time":"2018-10-05 08:05:32"},{"notification_id":"7472","message":"Cash credit of 13.00 has been added to your cash wallet as a cancel contest refund amount","notification_type":"USER_CASH_REFUND","read_status":"YES","sent_time":"2018-09-28 12:00:03"},{"notification_id":"5806","message":"Congratulation! Cash credit of 15 has been added to your cash wallet as a game kabbadi contest winner","notification_type":"USER_CASH_WINNING","read_status":"YES","sent_time":"2018-09-28 00:30:02"},{"notification_id":"259","message":"Cash credit of 0.00 has been added to your cash bonus wallet as a cancel contest refund amount","notification_type":"USER_CASH_BONUS_REFUND","read_status":"YES","sent_time":"2018-09-07 10:05:01"},{"notification_id":"241","message":"Congratulation! Cash credit of 0 has been added to your cash bonus wallet as a game cricket contest winner","notification_type":"USER_CASH_WINNING","read_status":"YES","sent_time":"2018-08-24 15:00:01"},{"notification_id":"237","message":"Cash credit of 0.00 has been added to your cash bonus wallet as a cancel contest refund amount","notification_type":"USER_CASH_BONUS_REFUND","read_status":"YES","sent_time":"2018-08-22 13:05:01"},{"notification_id":"236","message":"Congratulation! Cash credit of 0 has been added to your cash bonus wallet as a game cricket contest winner","notification_type":"USER_CASH_WINNING","read_status":"YES","sent_time":"2018-08-22 11:30:01"},{"notification_id":"231","message":"Cash credit of 0.00 has been added to your cash bonus wallet as a cancel contest refund amount","notification_type":"USER_CASH_BONUS_REFUND","read_status":"YES","sent_time":"2018-08-22 08:35:01"},{"notification_id":"227","message":"Conguratilation! Cash credit of 50 has been added to your bonus cash wallet as a app download","notification_type":"USER_CASH_BONUS","read_status":"YES","sent_time":"2018-08-21 13:07:13"}]
     * total : 12
     * message : Notification successfully found
     */

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("total")
    private int total;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
         * notification_id : 19993
         * message : Bank wire request approved successfully
         * notification_type : BANKWIRE
         * read_status : NO
         * sent_time : 2018-10-05 12:25:40
         */

        @SerializedName("notification_id")
        private String notificationId;
        @SerializedName("message")
        private String message;
        @SerializedName("notification_type")
        private String notificationType;
        @SerializedName("read_status")
        private String readStatus;
        @SerializedName("sent_time")
        private String sentTime;

        public String getNotificationId() {
            return notificationId;
        }

        public void setNotificationId(String notificationId) {
            this.notificationId = notificationId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getNotificationType() {
            return notificationType;
        }

        public void setNotificationType(String notificationType) {
            this.notificationType = notificationType;
        }

        public String getReadStatus() {
            return readStatus;
        }

        public void setReadStatus(String readStatus) {
            this.readStatus = readStatus;
        }

        public String getSentTime() {
            return sentTime;
        }

        public void setSentTime(String sentTime) {
            this.sentTime = sentTime;
        }
    }
}
