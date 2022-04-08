package com.mw.eleven11.base;

/**
 * Created by mobiweb on 21/6/18.
 */

public class WinningRanks {

    int from = 0;
    int to = 0;
    int fromSelected = 0;
    int toSelected = 0;
    int percent = 0;
    int maxPercent = 0;
    double amount = 0;

    public WinningRanks(int from, int to, int maxPercent) {
        this.from = from;
        this.fromSelected = from;
        this.toSelected = from;
        this.to = to;
        this.maxPercent = maxPercent;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getFromSelected() {
        return fromSelected;
    }

    public void setFromSelected(int fromSelected) {
        this.fromSelected = fromSelected;
    }

    public int getToSelected() {
        return toSelected;
    }

    public void setToSelected(int toSelected) {
        this.toSelected = toSelected;
    }

    public int getMaxPercent() {
        return maxPercent;
    }

    public void setMaxPercent(int maxPercent) {
        this.maxPercent = maxPercent;
    }
}
