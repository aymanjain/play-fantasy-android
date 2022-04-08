package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeriesOutput {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"TotalRecords":17,"Records":[{"SeriesGUID":"f5c6cbec-d228-20a1-4b97-763ebef36dda","SeriesName":"Afghanistan vs Ireland 2019"},{"SeriesGUID":"364c9c17-8dca-a00a-894e-02bb67bd673b","SeriesName":"Australia Women vs New Zealand Women 2019"},{"SeriesGUID":"dfc1f879-d1db-1b21-478f-610238773eb0","SeriesName":"Bangladesh Premier League 2019"},{"SeriesGUID":"3e468bac-7d10-8f15-e62e-790bdec7afc3","SeriesName":"BIG BASH LEAGUE 2018-19"},{"SeriesGUID":"1fa99169-07e4-efc8-114c-f22cf64787bb","SeriesName":"India vs Australia 2019"},{"SeriesGUID":"287b6cd5-9d02-1388-3d8a-49fc2d8230cd","SeriesName":"India Women vs England Women 2019"},{"SeriesGUID":"effdf6e1-c1bb-c0db-4661-eef05c320317","SeriesName":"New Zealand vs Bangladesh 2019"},{"SeriesGUID":"4dccacb4-e413-137a-25ec-a9cd8bc71fd0","SeriesName":"New Zealand vs India 2019"},{"SeriesGUID":"9e5d595c-a5d9-7991-6c13-2b728de00e22","SeriesName":"New Zealand Women vs India Women 2019"},{"SeriesGUID":"4e1b0199-ae13-01c0-8c2d-a94cd8be0e03","SeriesName":"Oman Quad Series T20 2019"},{"SeriesGUID":"1fd502bb-3f76-6ac3-c30d-c1baf56abc27","SeriesName":"Pakistan Super League 2019"},{"SeriesGUID":"cc94e512-ed66-5388-21c3-cbd0f8753944","SeriesName":"Pakistan Women vs Westindies Women"},{"SeriesGUID":"215d4908-bd02-568e-2c01-f6367e16ff27","SeriesName":"South Africa vs Pakistan 2018"},{"SeriesGUID":"48afe70c-79b3-d79d-d70f-92e2153f48d5","SeriesName":"South Africa vs Sri Lanka 2019"},{"SeriesGUID":"d873937a-72e4-0320-1ff5-472b06c6c35a","SeriesName":"South Africa Women vs Sri Lanka Women 2019"},{"SeriesGUID":"74c44212-9b8f-2833-6b2a-77bae8b71c2f","SeriesName":"Super Smash 2018-19"},{"SeriesGUID":"896939f2-68a8-26fa-245e-be4cbaf492cc","SeriesName":"Windies vs England 2019"}]}
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
         * TotalRecords : 17
         * Records : [{"SeriesGUID":"f5c6cbec-d228-20a1-4b97-763ebef36dda","SeriesName":"Afghanistan vs Ireland 2019"},{"SeriesGUID":"364c9c17-8dca-a00a-894e-02bb67bd673b","SeriesName":"Australia Women vs New Zealand Women 2019"},{"SeriesGUID":"dfc1f879-d1db-1b21-478f-610238773eb0","SeriesName":"Bangladesh Premier League 2019"},{"SeriesGUID":"3e468bac-7d10-8f15-e62e-790bdec7afc3","SeriesName":"BIG BASH LEAGUE 2018-19"},{"SeriesGUID":"1fa99169-07e4-efc8-114c-f22cf64787bb","SeriesName":"India vs Australia 2019"},{"SeriesGUID":"287b6cd5-9d02-1388-3d8a-49fc2d8230cd","SeriesName":"India Women vs England Women 2019"},{"SeriesGUID":"effdf6e1-c1bb-c0db-4661-eef05c320317","SeriesName":"New Zealand vs Bangladesh 2019"},{"SeriesGUID":"4dccacb4-e413-137a-25ec-a9cd8bc71fd0","SeriesName":"New Zealand vs India 2019"},{"SeriesGUID":"9e5d595c-a5d9-7991-6c13-2b728de00e22","SeriesName":"New Zealand Women vs India Women 2019"},{"SeriesGUID":"4e1b0199-ae13-01c0-8c2d-a94cd8be0e03","SeriesName":"Oman Quad Series T20 2019"},{"SeriesGUID":"1fd502bb-3f76-6ac3-c30d-c1baf56abc27","SeriesName":"Pakistan Super League 2019"},{"SeriesGUID":"cc94e512-ed66-5388-21c3-cbd0f8753944","SeriesName":"Pakistan Women vs Westindies Women"},{"SeriesGUID":"215d4908-bd02-568e-2c01-f6367e16ff27","SeriesName":"South Africa vs Pakistan 2018"},{"SeriesGUID":"48afe70c-79b3-d79d-d70f-92e2153f48d5","SeriesName":"South Africa vs Sri Lanka 2019"},{"SeriesGUID":"d873937a-72e4-0320-1ff5-472b06c6c35a","SeriesName":"South Africa Women vs Sri Lanka Women 2019"},{"SeriesGUID":"74c44212-9b8f-2833-6b2a-77bae8b71c2f","SeriesName":"Super Smash 2018-19"},{"SeriesGUID":"896939f2-68a8-26fa-245e-be4cbaf492cc","SeriesName":"Windies vs England 2019"}]
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
             * SeriesGUID : f5c6cbec-d228-20a1-4b97-763ebef36dda
             * SeriesName : Afghanistan vs Ireland 2019
             */

            @SerializedName("SeriesGUID")
            private String SeriesGUID;
            @SerializedName("SeriesName")
            private String SeriesName;

            public String getSeriesGUID() {
                return SeriesGUID;
            }

            public void setSeriesGUID(String SeriesGUID) {
                this.SeriesGUID = SeriesGUID;
            }

            public String getSeriesName() {
                return SeriesName;
            }

            public void setSeriesName(String SeriesName) {
                this.SeriesName = SeriesName;
            }
        }
    }
}
