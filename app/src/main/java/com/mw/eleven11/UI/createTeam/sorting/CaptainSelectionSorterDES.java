package com.mw.eleven11.UI.createTeam.sorting;

import com.mw.eleven11.beanOutput.PlayersOutput;

import java.util.Comparator;

public class CaptainSelectionSorterDES implements Comparator<PlayersOutput.DataBean.RecordsBean> {

    public int compare(PlayersOutput.DataBean.RecordsBean another, PlayersOutput.DataBean.RecordsBean one){
        int returnVal = 0;

        if(Float.valueOf(one.getPlayerSelectedCaptain()) < Float.valueOf(another.getPlayerSelectedCaptain())){
            returnVal =  -1;
        }else if(Float.valueOf(one.getPlayerSelectedCaptain())> Float.valueOf(another.getPlayerSelectedCaptain())){
            returnVal =  1;
        }else if(Float.valueOf(one.getPlayerSelectedCaptain()) == Float.valueOf(another.getPlayerSelectedCaptain())){
            returnVal =  0;
        }
        return returnVal;
    }
}
