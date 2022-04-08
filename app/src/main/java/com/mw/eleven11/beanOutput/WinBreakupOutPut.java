package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WinBreakupOutPut {


    /**
     * ResponseCode : 200
     * Message : Winning Breakup successfully.
     * Data : [{"NoOfWinners":3,"Winners":[{"Rank":"1","From":"1","To":"1","Percent":"50","WinningAmount":"50"},{"Rank":"2","From":"2","To":"2","Percent":"30","WinningAmount":"30"},{"Rank":"3","From":"3","To":"3","Percent":"20","WinningAmount":"20"}]},{"NoOfWinners":2,"Winners":[{"Rank":"1","From":"1","To":"1","Percent":"70","WinningAmount":"70"},{"Rank":"2","From":"2","To":"2","Percent":"30","WinningAmount":"30"}]},{"NoOfWinners":1,"Winners":[{"Rank":"1","From":"1","To":"1","Percent":"100","WinningAmount":"100"}]}]
     */

    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("Message")
    private String Message;
    @SerializedName("Data")
    private List<DataBean> Data;

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

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * NoOfWinners : 3
         * Winners : [{"Rank":"1","From":"1","To":"1","Percent":"50","WinningAmount":"50"},{"Rank":"2","From":"2","To":"2","Percent":"30","WinningAmount":"30"},{"Rank":"3","From":"3","To":"3","Percent":"20","WinningAmount":"20"}]
         */

        @SerializedName("NoOfWinners")
        private int NoOfWinners;
        @SerializedName("Winners")
        private List<WinnersBean> Winners;

        public int getNoOfWinners() {
            return NoOfWinners;
        }

        public void setNoOfWinners(int NoOfWinners) {
            this.NoOfWinners = NoOfWinners;
        }

        public List<WinnersBean> getWinners() {
            return Winners;
        }

        public void setWinners(List<WinnersBean> Winners) {
            this.Winners = Winners;
        }

        public static class WinnersBean {
            /**
             * Rank : 1
             * From : 1
             * To : 1
             * Percent : 50
             * WinningAmount : 50
             */

            @SerializedName("Rank")
            private String Rank;
            @SerializedName("From")
            private String From;
            @SerializedName("To")
            private String To;
            @SerializedName("Percent")
            private String Percent;
            @SerializedName("WinningAmount")
            private String WinningAmount;

            public String getRank() {
                return Rank;
            }

            public void setRank(String Rank) {
                this.Rank = Rank;
            }

            public String getFrom() {
                return From;
            }

            public void setFrom(String From) {
                this.From = From;
            }

            public String getTo() {
                return To;
            }

            public void setTo(String To) {
                this.To = To;
            }

            public String getPercent() {
                return Percent;
            }

            public void setPercent(String Percent) {
                this.Percent = Percent;
            }

            public String getWinningAmount() {
                return WinningAmount;
            }

            public void setWinningAmount(String WinningAmount) {
                this.WinningAmount = WinningAmount;
            }
        }
    }
}
