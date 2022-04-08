package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mobiweb on 15/3/18.
 */

public class ResponseFilter {


    @SerializedName("pay")
    private List<Bean> pay;
    @SerializedName("win")
    private List<Bean> win;
    @SerializedName("size")
    private List<Bean> size;

    @SerializedName("contets_type")
    private List<Bean> contets_type;

    public List<Bean> getContets_type() {
        return contets_type;
    }

    public void setContets_type(List<Bean> contets_type) {
        this.contets_type = contets_type;
    }

    public List<Bean> getPay() {
        return pay;
    }

    public void setPay(List<Bean> pay) {
        this.pay = pay;
    }

    public List<Bean> getWin() {
        return win;
    }

    public void setWin(List<Bean> win) {
        this.win = win;
    }

    public List<Bean> getSize() {
        return size;
    }

    public void setSize(List<Bean> size) {
        this.size = size;
    }

    public class Bean {
        /**
         * title : ALL
         * value : all
         * selected : false
         */

        @SerializedName("title")
        private String title;
        @SerializedName("value")
        private String value;
        @SerializedName("selected")
        private boolean selected;

        @SerializedName("startFrom")
        private String startFrom;

        @SerializedName("endTo")
        private String endTo;

        public String getStartFrom() {
            return startFrom;
        }

        public void setStartFrom(String startFrom) {
            this.startFrom = startFrom;
        }

        public String getEndTo() {
            return endTo;
        }

        public void setEndTo(String endTo) {
            this.endTo = endTo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }
}
