package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubjectOutput {
    @SerializedName("ResponseCode")
    @Expose
    private String responseCode;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private List<SubjectData> data = null;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SubjectData> getData() {
        return data;
    }

    public void setData(List<SubjectData> data) {
        this.data = data;
    }

    public class SubjectData {

        @SerializedName("ID")
        @Expose
        private String iD;
        @SerializedName("Text")
        @Expose
        private String text;
        @SerializedName("EnteryDate")
        @Expose
        private String enteryDate;

        public String getID() {
            return iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getEnteryDate() {
            return enteryDate;
        }

        public void setEnteryDate(String enteryDate) {
            this.enteryDate = enteryDate;
        }
    }


}
