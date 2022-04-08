package com.mw.eleven11.UI.winnings;

import com.google.gson.annotations.SerializedName;

public class WinnersRankBean {

    @SerializedName("From")
    private int From;
    @SerializedName("To")
    private int To;
    @SerializedName("Percent")
    private String Percent;
    @SerializedName("WinningAmount")
    private String WinningAmount;


    @SerializedName("ProductUrl")
    private String ProductUrl;


    @SerializedName("ProductName")
    private String ProductName;

    public int getFrom() {
        return From;
    }

    public void setFrom(int From) {
        this.From = From;
    }

    public int getTo() {
        return To;
    }

    public void setTo(int To) {
        this.To = To;
    }

    public String getPercent() {
        return Percent;
    }

    public void setPercent(String Percent) {
        this.Percent = Percent;
    }

    public String getWinningAmount() {
        return WinningAmount;
    }

    public void setWinningAmount(String WinningAmount) {
        this.WinningAmount = WinningAmount;
    }

    public String getProductUrl() {
        return ProductUrl;
    }

    public void setProductUrl(String productUrl) {
        ProductUrl = productUrl;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }
}

