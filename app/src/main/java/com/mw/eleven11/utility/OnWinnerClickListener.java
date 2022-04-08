package com.mw.eleven11.utility;

import android.view.View;

import com.mw.eleven11.beanOutput.MatchContestOutPut;

import java.util.List;



public class OnWinnerClickListener implements View.OnClickListener {
    List<MatchContestOutPut.DataBean.ResultsBean.RecordsBean> responseBeen;
    private int position;
    private OnWinnerClickCallback onWinnerClickCallback;

    public OnWinnerClickListener(int position, OnWinnerClickCallback onWinnerClickCallback,
                                 List<MatchContestOutPut.DataBean.ResultsBean.RecordsBean> responseBeen) {
        this.position = position;
        this.onWinnerClickCallback = onWinnerClickCallback;
        this.responseBeen = responseBeen;
    }


    @Override
    public void onClick(View view) {


        onWinnerClickCallback.onWinnerClicked(view, position, responseBeen);

    }


    public interface OnWinnerClickCallback {
        void onWinnerClicked(View view, int position, List<MatchContestOutPut.DataBean.ResultsBean.RecordsBean> responseBeen);

    }
}