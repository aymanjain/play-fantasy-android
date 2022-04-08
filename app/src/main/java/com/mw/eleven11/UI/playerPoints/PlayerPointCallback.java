package com.mw.eleven11.UI.playerPoints;

import android.content.Context;

import com.mw.eleven11.beanOutput.PlayersOutput;


/**
 * Created by mobiweb on 6/12/16.
 */
public interface PlayerPointCallback {
    public void close();



    public PlayersOutput.DataBean.RecordsBean  getPlayer();

    public Context getContext();
}
