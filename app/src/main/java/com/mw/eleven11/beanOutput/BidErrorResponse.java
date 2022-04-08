package com.mw.eleven11.beanOutput;

import java.util.List;

public class BidErrorResponse {

    /**
     * ContestGUID : efdccd68-c51f-5d83-4ae7-a139bf159479
     * responseData : {"ResponseCode":200,"Message":"Minimum Criteria for Batsman is fulfilled. Please select player for another position will you complete the minimum criteria of 11 Players","Data":{"Status":0,"Player":[],"User":{"FirstName":"Austin debich","UserGUID":"7280e6d5-660f-6071-c31b-906858a53419","UserID":"19266"},"DraftStatus":"Running","SeriesGUID":"4321d2c5-5ccc-bd73-a6d5-4d6a2132d2e6","ContestGUID":"efdccd68-c51f-5d83-4ae7-a139bf159479"}}
     * UserGUID : 7280e6d5-660f-6071-c31b-906858a53419
     * Message : Minimum Criteria for Batsman is fulfilled. Please select player for another position will you complete the minimum criteria of 11 Players
     */

    private String ContestGUID;
    //private ResponseDataBean responseData;
    private String UserGUID;
    private String Message;

    public String getContestGUID() {
        return ContestGUID;
    }

    public void setContestGUID(String ContestGUID) {
        this.ContestGUID = ContestGUID;
    }

   /* public ResponseDataBean getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseDataBean responseData) {
        this.responseData = responseData;
    }*/

    public String getUserGUID() {
        return UserGUID;
    }

    public void setUserGUID(String UserGUID) {
        this.UserGUID = UserGUID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public static class ResponseDataBean {
        /**
         * ResponseCode : 200
         * Message : Minimum Criteria for Batsman is fulfilled. Please select player for another position will you complete the minimum criteria of 11 Players
         * Data : {"Status":0,"Player":[],"User":{"FirstName":"Austin debich","UserGUID":"7280e6d5-660f-6071-c31b-906858a53419","UserID":"19266"},"DraftStatus":"Running","SeriesGUID":"4321d2c5-5ccc-bd73-a6d5-4d6a2132d2e6","ContestGUID":"efdccd68-c51f-5d83-4ae7-a139bf159479"}
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
             * Status : 0
             * Player : []
             * User : {"FirstName":"Austin debich","UserGUID":"7280e6d5-660f-6071-c31b-906858a53419","UserID":"19266"}
             * DraftStatus : Running
             * SeriesGUID : 4321d2c5-5ccc-bd73-a6d5-4d6a2132d2e6
             * ContestGUID : efdccd68-c51f-5d83-4ae7-a139bf159479
             */

            private int Status;
            private UserBean User;
            private String DraftStatus;
            private String SeriesGUID;
            private String ContestGUID;
            private List<?> Player;

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public UserBean getUser() {
                return User;
            }

            public void setUser(UserBean User) {
                this.User = User;
            }

            public String getDraftStatus() {
                return DraftStatus;
            }

            public void setDraftStatus(String DraftStatus) {
                this.DraftStatus = DraftStatus;
            }

            public String getSeriesGUID() {
                return SeriesGUID;
            }

            public void setSeriesGUID(String SeriesGUID) {
                this.SeriesGUID = SeriesGUID;
            }

            public String getContestGUID() {
                return ContestGUID;
            }

            public void setContestGUID(String ContestGUID) {
                this.ContestGUID = ContestGUID;
            }

            public List<?> getPlayer() {
                return Player;
            }

            public void setPlayer(List<?> Player) {
                this.Player = Player;
            }

            public static class UserBean {
                /**
                 * FirstName : Austin debich
                 * UserGUID : 7280e6d5-660f-6071-c31b-906858a53419
                 * UserID : 19266
                 */

                private String FirstName;
                private String UserGUID;
                private String UserID;

                public String getFirstName() {
                    return FirstName;
                }

                public void setFirstName(String FirstName) {
                    this.FirstName = FirstName;
                }

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
            }
        }
    }
}
