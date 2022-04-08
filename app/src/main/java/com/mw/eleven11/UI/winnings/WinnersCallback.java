package com.mw.eleven11.UI.winnings;

import android.content.Context;

import java.util.List;

/**
 * Created by mobiweb on 6/12/16.
 */
public interface WinnersCallback {
    public void close();

    public Context getContext();

    public List<WinnersRankBean> getBean();

    public String getTotalWiningAmount();
    public String getWinningType();
}