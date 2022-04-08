package com.mw.eleven11.UI.createTeam.sorting;

import com.mw.eleven11.beanOutput.PlayersOutput;

import java.util.Comparator;

public class ViceCaptainSelectionSorterASC implements Comparator<PlayersOutput.DataBean.RecordsBean> {

    public int compare(PlayersOutput.DataBean.RecordsBean one, PlayersOutput.DataBean.RecordsBean another){
        int returnVal = 0;

        if(Float.valueOf(one.getPlayerSelectedViceCaptain()) < Float.valueOf(another.getPlayerSelectedViceCaptain())){
            returnVal =  -1;
        }else if(Float.valueOf(one.getPlayerSelectedViceCaptain()) > Float.valueOf(another.getPlayerSelectedViceCaptain())){
            returnVal =  1;
        }else if(Float.valueOf(one.getPlayerSelectedViceCaptain()) == Float.valueOf(another.getPlayerSelectedViceCaptain())){
            returnVal =  0;
        }
        return returnVal;
    }


}
