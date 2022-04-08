package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobiweb on 21/3/18.
 */

public class ResponsePair {


    /**
     * key : T20s
     * value : 130
     */

    @SerializedName("key")
    private String key;
    @SerializedName("value")
    private String value;

    public ResponsePair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
