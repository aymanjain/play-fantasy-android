package com.mw.eleven11.beanOutput;

public class KabddiPlayerPointsBreakup {


    String event;
    String actual;
    String point;

    public KabddiPlayerPointsBreakup(String event, String actual, String point) {
        this.event = event;
        this.actual = actual;
        this.point = point;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
