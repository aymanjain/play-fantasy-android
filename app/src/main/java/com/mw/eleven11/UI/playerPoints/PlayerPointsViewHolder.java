package com.mw.eleven11.UI.playerPoints;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mw.eleven11.R;
import com.mw.eleven11.customView.CustomTextView;



public class PlayerPointsViewHolder extends RecyclerView.ViewHolder {

    SimpleDraweeView mSimpleDraweeView;
    CustomTextView mCustomTextViewName;
    CustomTextView mCustomTextViewPoints;
    CustomTextView mCustomTextViewSelectedBy;
    CardView mRelativeLayout;
    ImageView mImageView;
    ImageView mImageViewTopPlayer;

    public PlayerPointsViewHolder(View itemView) {
        super(itemView);
        mRelativeLayout = (CardView) itemView.findViewById(R.id.rl_root);
        mSimpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.sdv);
        mCustomTextViewName = (CustomTextView) itemView.findViewById(R.id.ctv_player_name);
        mCustomTextViewPoints = (CustomTextView) itemView.findViewById(R.id.points);
        mCustomTextViewSelectedBy = (CustomTextView) itemView.findViewById(R.id.ctv_selected_by);
        mImageView = (ImageView) itemView.findViewById(R.id.iv_player);
        mImageViewTopPlayer = (ImageView) itemView.findViewById(R.id.iv_top_player);
    }
}
