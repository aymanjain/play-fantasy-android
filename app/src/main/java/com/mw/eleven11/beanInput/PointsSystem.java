package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class PointsSystem {
    public String getStatusID() {
        return StatusID;
    }

    public void setStatusID(String statusID) {
        StatusID = statusID;
    }

    @SerializedName("StatusID")
    private String StatusID;

    public String getPointCategory() {
        return PointCategory;
    }

    public void setPointCategory(String pointCategory) {
        PointCategory = pointCategory;
    }

    @SerializedName("PointCategory")
    private String PointCategory;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @SerializedName("Type")
    private String Type;


}

