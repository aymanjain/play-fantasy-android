package com.mw.eleven11.UI.player;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mw.eleven11.R;
import com.mw.eleven11.customView.CustomTextView;


public class PlayerViewHolder extends RecyclerView.ViewHolder {

    CustomTextView mCustomTextViewPoints;
    CustomTextView mCustomTextViewMatch;
    CustomTextView mCustomTextViewDate;
    CustomTextView mCustomTextViewSelectedBy;

    public PlayerViewHolder(View itemView) {
        super(itemView);
        mCustomTextViewMatch = (CustomTextView) itemView.findViewById(R.id.ctv_match);
        mCustomTextViewPoints = (CustomTextView) itemView.findViewById(R.id.ctv_points);
        mCustomTextViewDate = (CustomTextView) itemView.findViewById(R.id.ctv_date);
        mCustomTextViewSelectedBy = (CustomTextView) itemView.findViewById(R.id.ctv_selected_by);
    }
}
