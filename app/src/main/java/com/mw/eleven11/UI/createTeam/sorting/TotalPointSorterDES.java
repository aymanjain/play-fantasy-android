package com.mw.eleven11.UI.createTeam.sorting;

import com.mw.eleven11.beanOutput.PlayersOutput;

import java.util.Comparator;

public class TotalPointSorterDES implements Comparator<PlayersOutput.DataBean.RecordsBean> {

    public int compare(PlayersOutput.DataBean.RecordsBean another, PlayersOutput.DataBean.RecordsBean one){
        int returnVal = 0;

        if(Integer.parseInt(one.getTotalPoints()) < Integer.parseInt(another.getTotalPoints())){
            returnVal =  -1;
        }else if(Integer.parseInt(one.getTotalPoints()) > Integer.parseInt(another.getTotalPoints())){
            returnVal =  1;
        }else if(Integer.parseInt(one.getTotalPoints()) == Integer.parseInt(another.getTotalPoints())){
            returnVal =  0;
        }
        return returnVal;
    }

   
}
