package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatesBean {


    @SerializedName("state")
    private List<StateBean> state;

    public List<StateBean> getState() {
        return state;
    }

    public void setState(List<StateBean> state) {
        this.state = state;
    }

    public static class StateBean {
        /**
         * code : AN
         * name : Andaman and Nicobar Islands
         */

        @SerializedName("code")
        private String code;
        @SerializedName("name")
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
