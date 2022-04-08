package com.mw.eleven11.UI.leaderboardRanking;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mw.eleven11.R;
import com.mw.eleven11.customView.CustomTextView;



public class RankingViewHolder extends RecyclerView.ViewHolder {

    SimpleDraweeView mSimpleDraweeView;
    CustomTextView mCustomTextViewTeamCode;
    CustomTextView mCustomTextViewPoints;
    CustomTextView mCustomTextViewRank;
    RelativeLayout mRelativeLayout;

    public RankingViewHolder(View itemView) {
        super(itemView);

        mSimpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.sdv);
        mCustomTextViewTeamCode = (CustomTextView) itemView.findViewById(R.id.ctv_team_code);
        mCustomTextViewPoints = (CustomTextView) itemView.findViewById(R.id.ctv_points);
        mCustomTextViewRank = (CustomTextView) itemView.findViewById(R.id.ctv_rank);
        mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.rl_root);

    }
}
