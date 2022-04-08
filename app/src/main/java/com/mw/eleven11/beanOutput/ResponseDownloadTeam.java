package com.mw.eleven11.beanOutput;

public class ResponseDownloadTeam {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"TeamsPdfFileURL":"http://.com/api/uploads/Contests/contest-teams-b9ad31ab-1205-1137-0185-54ad18856859.pdf"}
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
         * TeamsPdfFileURL : http://.com/api/uploads/Contests/contest-teams-b9ad31ab-1205-1137-0185-54ad18856859.pdf
         */

        private String TeamsPdfFileURL;

        public String getTeamsPdfFileURL() {
            return TeamsPdfFileURL;
        }

        public void setTeamsPdfFileURL(String TeamsPdfFileURL) {
            this.TeamsPdfFileURL = TeamsPdfFileURL;
        }
    }
}
