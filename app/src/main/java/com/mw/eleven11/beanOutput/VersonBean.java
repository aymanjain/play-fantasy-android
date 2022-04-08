package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

public class VersonBean {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"AndridAppUrl":"https://play.google.com/store?hl=en","AndroidAppVersion":"1","IsAndroidAppUpdateMandatory":"Yes"}
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
         * AndridAppUrl : https://play.google.com/store?hl=en
         * AndroidAppVersion : 1
         * IsAndroidAppUpdateMandatory : Yes
         */

        @SerializedName("AndridAppUrl")
        private String AndridAppUrl;
        @SerializedName("AndroidAppVersion")
        private String AndroidAppVersion;
        @SerializedName("AndroidAppFeatures")
        private String AndroidAppFeatures;
        @SerializedName("IsAndroidAppUpdateMandatory")
        private String IsAndroidAppUpdateMandatory;

        public String getAndridAppUrl() {
            return AndridAppUrl;
        }

        public void setAndridAppUrl(String AndridAppUrl) {
            this.AndridAppUrl = AndridAppUrl;
        }

        public String getAndroidAppVersion() {
            return AndroidAppVersion;
        }

        public void setAndroidAppVersion(String AndroidAppVersion) {
            this.AndroidAppVersion = AndroidAppVersion;
        }

        public String getIsAndroidAppUpdateMandatory() {
            return IsAndroidAppUpdateMandatory;
        }

        public void setIsAndroidAppUpdateMandatory(String IsAndroidAppUpdateMandatory) {
            this.IsAndroidAppUpdateMandatory = IsAndroidAppUpdateMandatory;
        }

        public String getAndroidAppFeatures() {
            return AndroidAppFeatures;
        }

        public void setAndroidAppFeatures(String androidAppFeatures) {
            AndroidAppFeatures = androidAppFeatures;
        }
    }
}
