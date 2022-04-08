package com.mw.eleven11.UI.previewTeam;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mw.eleven11.R;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.ViewUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 */

public class BottomPreviewAdapter extends RecyclerView.Adapter<BottomPreviewAdapter.MyViewHolder> {

    OnItemClickListener.OnItemClickCallback onItemClickCallback;
    int layoutId = 0;
    String pointLaval = "";
    String team1 = "";

    String teamGUID = "";

    private List<PlayerRecord> responseBeen = new ArrayList<>();

    private Context mContext;
    private String status;
    private String isPlayingOn = "no";

    public BottomPreviewAdapter(int layoutId, Context mContext,
                                List<PlayerRecord> responseBeen,
                                OnItemClickListener.OnItemClickCallback onItemClickCallback) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setTeam(String team1) {
        this.team1 = team1;
    }

    @Override
    public BottomPreviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BottomPreviewAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    public void setPointLaval(String value) {
        pointLaval = value;
    }


    public void setStatus(String value) {
        status = value;
    }

    public void setPlayingStatus(String value) {
        isPlayingOn = value;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if (holder.customTextViewName != null) {
            holder.customTextViewName.setText(ViewUtils.getPlayerName(responseBeen.get(position).getPlayerName()));


            if (isPlayingOn != null && isPlayingOn.equalsIgnoreCase("Yes")) {
                if (responseBeen.get(position).getIsPlaying().equals("Yes")) {
                    holder.v_playing_ind.setVisibility(View.VISIBLE);
                    holder.v_playing_ind.setBackground(mContext.getResources().getDrawable(R.drawable.circle_green));
                } else {
                    holder.v_playing_ind.setVisibility(View.VISIBLE);
                    holder.v_playing_ind.setBackground(mContext.getResources().getDrawable(R.drawable.circle_red));
                }
            } else {
                holder.v_playing_ind.setVisibility(View.GONE);
            }

            if (team1.equals(responseBeen.get(position).getTeamGUID())) {

                holder.customTextViewName.setTextColor(mContext.getResources().getColor(R.color.white));
                if (Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    holder.lyt_text.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.bg_local));
                } else {
                    holder.lyt_text.setBackground(mContext.getResources().getDrawable(R.drawable.bg_local));
                }
            } else {
                holder.customTextViewName.setTextColor(mContext.getResources().getColor(R.color.black));
                if (Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    holder.lyt_text.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.bg_visitor));
                } else {
                    holder.lyt_text.setBackground(mContext.getResources().getDrawable(R.drawable.bg_visitor));
                }
            }
        }

        if (holder.ctvPosition != null) {
            if (getPlayerPosition(position).equals(Constant.POSITION_CAPTAIN)) {
                holder.ctvPosition.setVisibility(View.VISIBLE);
                /*holder.ctvPosition.setBackgroundResource(team1.equals(responseBeen.get(position).
                        getTeamGUID())?R.drawable.circle_black_border_white:
                        R.drawable.circle_color_primary_border_white);*/
                holder.ctvPosition.setBackgroundResource(R.drawable.circle_color_primary_border_white);
                holder.ctvPosition.setText("C");
            } else if (getPlayerPosition(position).equals(Constant.POSITION_VICE_CAPTAIN)) {
                holder.ctvPosition.setVisibility(View.VISIBLE);
                holder.ctvPosition.setText("VC");
                holder.ctvPosition.setBackgroundResource(R.drawable.circle_black_border_white);
               /* holder.ctvPosition.setBackgroundResource(team1.equals(responseBeen.get(position).
                        getTeamGUID())?R.drawable.circle_black_border_white:
                        R.drawable.circle_color_primary_border_white);*/
            } else {
                holder.ctvPosition.setVisibility(View.INVISIBLE);
            }
        }

        if (holder.ctvCredits != null)
            if (status.equalsIgnoreCase("Pending")) {
                if (responseBeen.get(position).getPoints() != null) {
                    Double price = Double.valueOf(responseBeen.get(position).getPointCredits());
                    DecimalFormat format = new DecimalFormat("0.#");
                    holder.ctvCredits.setText(format.format(price) + " " + "Cr");
//
                }
            } else {
                if (responseBeen.get(position).getPoints() != null) {
                    Double price = Double.valueOf(responseBeen.get(position).getPoints());
                    DecimalFormat format = new DecimalFormat("0.#");
                    holder.ctvCredits.setText(format.format(price) + " " + pointLaval);
//
                }
            }


        if (holder.ivPlayer != null)
            ViewUtils.setImageUrl(holder.ivPlayer, responseBeen.get(position).getPlayerPic());
        if (holder.mCardViewMainCard != null) {
            holder.mCardViewMainCard.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));
        }

        if (holder.ivPlayer != null) {
            holder.ivPlayer.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));
        }
    }

    public String getPlayerId(int position) {
        return responseBeen.get(position).getPlayerGUID();
    }

    public PlayerRecord getPlayer(int position) {
        return responseBeen.get(position);
    }


    public String getPlayerPosition(int position) {
        return responseBeen.get(position).getPosition();
    }

    public PlayerRecord getItemData(int position) {
        if (responseBeen == null) return null;
        return responseBeen.get(position);
    }

    public void addItem(PlayerRecord bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }

    public void addAllItem(List<PlayerRecord> beanList) {
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void updateTeamData(List<PlayerRecord> beanList) {
        clear();
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void clear() {
        if (responseBeen == null) return;
        responseBeen.clear();
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return responseBeen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.hi_main_card)
        @Nullable
        CardView mCardViewMainCard;
        @BindView(R.id.iv_player)
        @Nullable
        CustomImageView ivPlayer;
        @BindView(R.id.v_playing_ind)
        @Nullable
        View v_playing_ind;
        @BindView(R.id.ctv_name)
        @Nullable
        CustomTextView customTextViewName;
        @BindView(R.id.ctv_position)
        @Nullable
        CustomTextView ctvPosition;
        @BindView(R.id.lyt_text)
        @Nullable
        LinearLayout lyt_text;
        @BindView(R.id.ctv_credits)
        @Nullable
        CustomTextView ctvCredits;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
