package com.mw.eleven11.UI.previewTeam;

import android.content.Context;

import java.util.List;



/**
 * Created by mobiweb on 6/12/16.
 */
public interface PlayerPreviewCallback {
    public void close();

    public void edit();

    public void refresh();

    public String getTeamName();

    public boolean isTeamPoints();

    public String totalPoints();

    public String getMatchID();

    public String getStatus();

    public List<PlayerRecord> getPlayers();

    public Context getContext();

    public String isPlaying11Avaible();
}
