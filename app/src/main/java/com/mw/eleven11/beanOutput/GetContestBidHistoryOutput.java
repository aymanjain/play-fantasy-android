package com.mw.eleven11.beanOutput;

import java.util.List;

public class GetContestBidHistoryOutput {

    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"TotalRecords":4,"Records":[{"UserGUID":"7280e6d5-660f-6071-c31b-906858a53419","BidCredit":"300000","DateTime":"2019-05-17 16:46:40","FirstName":"Austin debich","ProfilePic":"http://128.199.239.204/520-draft/api/uploads/profile/picture/4.png"},{"UserGUID":"d4f418ea-135e-dca0-5c07-c013c49c919d","BidCredit":"200000","DateTime":"2019-05-17 16:46:28","FirstName":"Rahul pareta","ProfilePic":"http://128.199.239.204/520-draft/api/uploads/profile/picture/default.jpg"},{"UserGUID":"7280e6d5-660f-6071-c31b-906858a53419","BidCredit":"100000","DateTime":"2019-05-17 16:46:20","FirstName":"Austin debich","ProfilePic":"http://128.199.239.204/520-draft/api/uploads/profile/picture/4.png"},{"UserGUID":"d4f418ea-135e-dca0-5c07-c013c49c919d","BidCredit":"100000","DateTime":"2019-05-17 16:45:53","FirstName":"Rahul pareta","ProfilePic":"http://128.199.239.204/520-draft/api/uploads/profile/picture/default.jpg"}]}
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
         * TotalRecords : 4
         * Records : [{"UserGUID":"7280e6d5-660f-6071-c31b-906858a53419","BidCredit":"300000","DateTime":"2019-05-17 16:46:40","FirstName":"Austin debich","ProfilePic":"http://128.199.239.204/520-draft/api/uploads/profile/picture/4.png"},{"UserGUID":"d4f418ea-135e-dca0-5c07-c013c49c919d","BidCredit":"200000","DateTime":"2019-05-17 16:46:28","FirstName":"Rahul pareta","ProfilePic":"http://128.199.239.204/520-draft/api/uploads/profile/picture/default.jpg"},{"UserGUID":"7280e6d5-660f-6071-c31b-906858a53419","BidCredit":"100000","DateTime":"2019-05-17 16:46:20","FirstName":"Austin debich","ProfilePic":"http://128.199.239.204/520-draft/api/uploads/profile/picture/4.png"},{"UserGUID":"d4f418ea-135e-dca0-5c07-c013c49c919d","BidCredit":"100000","DateTime":"2019-05-17 16:45:53","FirstName":"Rahul pareta","ProfilePic":"http://128.199.239.204/520-draft/api/uploads/profile/picture/default.jpg"}]
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
             * UserGUID : 7280e6d5-660f-6071-c31b-906858a53419
             * BidCredit : 300000
             * DateTime : 2019-05-17 16:46:40
             * FirstName : Austin debich
             * ProfilePic : http://128.199.239.204/520-draft/api/uploads/profile/picture/4.png
             */

            private String UserGUID;
            private String BidCredit;
            private String DateTime;
            private String FirstName;
            private String ProfilePic;
            private String Username;

            public String getUsername() {
                return Username;
            }

            public void setUsername(String username) {
                Username = username;
            }

            public String getUserGUID() {
                return UserGUID;
            }

            public void setUserGUID(String UserGUID) {
                this.UserGUID = UserGUID;
            }

            public String getBidCredit() {
                return BidCredit;
            }

            public void setBidCredit(String BidCredit) {
                this.BidCredit = BidCredit;
            }

            public String getDateTime() {
                return DateTime;
            }

            public void setDateTime(String DateTime) {
                this.DateTime = DateTime;
            }

            public String getFirstName() {
                return FirstName;
            }

            public void setFirstName(String FirstName) {
                this.FirstName = FirstName;
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
