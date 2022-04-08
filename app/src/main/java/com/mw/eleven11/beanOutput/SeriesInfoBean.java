package com.mw.eleven11.beanOutput;

import java.io.Serializable;

public class SeriesInfoBean implements Serializable {

    public static final int FIXTURE = 1, LIVE = 2, COMPLETED = 3;


    private String name;
    private int status;
    private String time;

    public SeriesInfoBean(String name, int status, String time) {
        this.name = name;
        this.status = status;
        this.time = time;
    }

    public static int getFIXTURE() {
        return FIXTURE;
    }

    public static int getLIVE() {
        return LIVE;
    }

    public static int getCOMPLETED() {
        return COMPLETED;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
