package com.mw.eleven11.UI.createTeam;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.createTeam.sorting.CreaditSorterASC;
import com.mw.eleven11.UI.createTeam.sorting.CreaditSorterDES;
import com.mw.eleven11.UI.createTeam.sorting.PointSorterASC;
import com.mw.eleven11.UI.createTeam.sorting.PointSorterDES;
import com.mw.eleven11.UI.createTeam.sorting.SelectedSorterASC;
import com.mw.eleven11.UI.createTeam.sorting.SelectedSorterDEC;
import com.mw.eleven11.UI.createTeam.sorting.SortByNameASC;
import com.mw.eleven11.UI.createTeam.sorting.SortByNameDES;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.textdrawable.TextDrawable;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.ViewUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CreateTeamAdapter extends RecyclerView.Adapter<CreateTeamAdapter.MyViewHolder> {

    private final String whichClass;
    public float pointsRemaining;
    private OnItemClickListener.OnItemClickCallback onItemClickCallback, onViewItemClickCallback;
    int layoutId = 0;
    private List<PlayersOutput.DataBean.RecordsBean> responseBeen = new ArrayList<>();
    private Context mContext;
    int playingFlag = 0;
    int lastPlayingFlag = 0;
    String localTeamGUID;


    int wk_count;
    int bw_count;
    int bat_count;
    int ar_count;

    private boolean ROLE_ALLROUNDER, ROLE_BATSMAN, ROLE_BOWLER, ROLE_WICKETKEEPER;
    private int def_count, st_count, gk_count, mid_count;
    private boolean ROLE_MIDFIELDER, ROLE_GOALKEEPER, ROLE_FORWARD, ROLE_DEFENDER;


    public CreateTeamAdapter(int layoutId, Context mContext, List<PlayersOutput.DataBean.RecordsBean> responseBeen,
                             OnItemClickListener.OnItemClickCallback onItemClickCallback,
                             OnItemClickListener.OnItemClickCallback onViewItemClickCallback,
                             Integer playingFlag, String whichClass) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.onItemClickCallback = onItemClickCallback;
        this.onViewItemClickCallback = onViewItemClickCallback;
        this.playingFlag = playingFlag;
        this.whichClass = whichClass;

        for (PlayersOutput.DataBean.RecordsBean recordsBean : responseBeen) {
            if (recordsBean.getIsPlayedLastMatch().equals("Yes")) {
                lastPlayingFlag = 1;
            }
            if (recordsBean.getIsPlaying().equals("Yes")) {
                playingFlag = 1;
            }
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (holder.ctvCountry != null) {
            holder.ctvCountry.setText(responseBeen.get(position).getTeamNameShort());
            if (localTeamGUID == null) {
                holder.ctvCountry.setVisibility(View.GONE);
            } else {
                holder.ctvCountry.setVisibility(View.VISIBLE);
                if (responseBeen.get(position).getTeamNameShort().equals(localTeamGUID)) {
                    holder.ctvCountry.setBackgroundResource(R.drawable.blue_circle_shape);
                    holder.ctvCountry.setTextColor(mContext.getResources().getColor(R.color.white));
                } else {
                    holder.ctvCountry.setBackgroundResource(R.drawable.white_circle_shape);
                    holder.ctvCountry.setTextColor(mContext.getResources().getColor(R.color.white));
                }

                /*if (responseBeen.get(position).getTeamNameShort().equals(localTeamGUID)) {
                    holder.ctvCountry.setBackgroundResource(R.drawable.bg_local);
                    holder.ctvCountry.setTextColor(mContext.getResources().getColor(R.color.white));
                } else {
                    holder.ctvCountry.setBackgroundResource(R.drawable.bg_visitor);
                    holder.ctvCountry.setTextColor(mContext.getResources().getColor(R.color.black));
                }*/
            }

        }


        holder.ctv_selection.setText("Sel by " + responseBeen.get(position).getPlayerSelectedPercent() + "%");

        if (playingFlag == 1) {
            holder.ctv_is_playing.setVisibility(View.VISIBLE);
            if (responseBeen.get(position).getIsPlaying().equals("Yes")) {
                holder.ctv_is_playing.setText("Announced");
                holder.ctv_is_playing.setTextColor(mContext.getResources().getColor(R.color.green));
            } else {
                holder.ctv_is_playing.setText("");
                holder.ctv_is_playing.setTextColor(mContext.getResources().getColor(R.color.red));
            }
        } /*else {
            holder.ctv_is_playing.setVisibility(View.VISIBLE);
            if (!responseBeen.get(position).getIsPlayedLastMatch().equals("Yes")) {
                holder.ctv_is_playing.setText("Played last match");
                holder.ctv_is_playing.setTextColor(mContext.getResources().getColor(R.color.selected_blue));
            } else {
                holder.ctv_is_playing.setVisibility(View.GONE);
            }
        }*/ else {
            holder.ctv_is_playing.setVisibility(View.GONE);
        }

        if (holder.customTextViewName != null)
            holder.customTextViewName.setText(responseBeen.get(position).getPlayerName().trim());
        if (holder.ctvCredits != null) {
            holder.ctvCredits.setText(responseBeen.get(position).getPlayerSalary() + " ");
        }

        if (holder.ivPlayer != null) {

            if (TextUtils.isEmpty(responseBeen.get(position).getPlayerPic())) {

                TextDrawable drawable2 = TextDrawable.builder().beginConfig()
                        .fontSize(45)  //size in px
                        .bold()
                        .toUpperCase()
                        .endConfig()
                        .buildRound(AppUtils.getNameCharacters(responseBeen.get(position).getPlayerName()),
                                AppUtils.getRandomColor());
                if (drawable2 != null)
                    holder.ivPlayer.setImageDrawable(drawable2);


            } else {
                ViewUtils.setImageUrl(holder.ivPlayer, responseBeen.get(position).getPlayerPic());
            }

        }

        if (holder.ivCross != null)
            setCrossButton(holder.view_shadow, holder.ivCross, position);

        if (holder.mCardViewMainCard != null) {
            holder.mCardViewMainCard.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));

        }

        if (holder.ivPlayer != null) {
            holder.ivPlayer.setOnClickListener(new OnItemClickListener(position, onViewItemClickCallback));
        }


        holder.total_points.setText(responseBeen.get(position).getPointCredits() + "");


        if (whichClass.equalsIgnoreCase("Football")) {

            if (ROLE_GOALKEEPER) {
                if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_GOALKEEPER)) {
                    if (responseBeen.get(position).isSelected()) {
                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        if (gk_count == 1) {
                            holder.bluredRel.setVisibility(View.VISIBLE);
                        } else {
                            holder.bluredRel.setVisibility(View.GONE);
                        }
                    }
                }
            } else if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_GOALKEEPER)) {
                holder.bluredRel.setVisibility(View.GONE);
                if (pointsRemaining != 0.0) {
                    if (Float.parseFloat(responseBeen.get(position).getPlayerSalary().trim()) <= pointsRemaining) {
                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                        if (responseBeen.get(position).isSelected()) {
                            holder.bluredRel.setVisibility(View.GONE);
                        }
                    }
                }
            }


            if (ROLE_MIDFIELDER) {
                if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_MIDFIELDER)) {
                    if (responseBeen.get(position).isSelected()) {

                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                    }

                }
            } else if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_MIDFIELDER)) {
                holder.bluredRel.setVisibility(View.GONE);
                if (pointsRemaining != 0.0) {
                    if (Float.parseFloat(responseBeen.get(position).getPlayerSalary().trim()) <= pointsRemaining) {
                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                        if (responseBeen.get(position).isSelected()) {
                            holder.bluredRel.setVisibility(View.GONE);
                        }
                    }


                }

            }

            if (ROLE_DEFENDER) {
                if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_DEFENDER)) {
                    if (responseBeen.get(position).isSelected()) {

                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                    }

                }
            } else if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_DEFENDER)) {
                holder.bluredRel.setVisibility(View.GONE);
                if (pointsRemaining != 0.0) {
                    if (Float.parseFloat(responseBeen.get(position).getPlayerSalary().trim()) <= pointsRemaining) {
                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                        if (responseBeen.get(position).isSelected()) {
                            holder.bluredRel.setVisibility(View.GONE);
                        }
                    }


                }

            }
            if (ROLE_FORWARD) {
                if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_FORWARD)) {
                    if (responseBeen.get(position).isSelected()) {

                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                    }

                }
            } else if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_FORWARD)) {
                holder.bluredRel.setVisibility(View.GONE);
                if (pointsRemaining != 0.0) {
                    if (Float.parseFloat(responseBeen.get(position).getPlayerSalary().trim()) <= pointsRemaining) {
                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                        if (responseBeen.get(position).isSelected()) {
                            holder.bluredRel.setVisibility(View.GONE);
                        }
                    }
                }

            }

        }
        else {
            if (ROLE_WICKETKEEPER) {
                if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_WICKETKEEPER)) {
                    if (responseBeen.get(position).isSelected()) {


                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        if (wk_count == 1) {
                            holder.bluredRel.setVisibility(View.VISIBLE);
                        } else {
                            holder.bluredRel.setVisibility(View.GONE);
                        }

                    }

                }
            } else if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_WICKETKEEPER)) {
                holder.bluredRel.setVisibility(View.GONE);
                if (pointsRemaining != 0.0) {
                    if (Float.parseFloat(responseBeen.get(position).getPlayerSalary().trim()) <= pointsRemaining) {
                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                        if (responseBeen.get(position).isSelected()) {
                            holder.bluredRel.setVisibility(View.GONE);
                        }
                    }

                }

            }


            if (ROLE_ALLROUNDER) {
                if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_ALLROUNDER)) {
                    if (responseBeen.get(position).isSelected()) {

                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                    }

                } else {
                    // holder.bluredRel.setVisibility(View.GONE);
                }
            } else if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_ALLROUNDER)) {
                holder.bluredRel.setVisibility(View.GONE);
                if (pointsRemaining != 0.0) {
                    if (Float.parseFloat(responseBeen.get(position).getPlayerSalary().trim()) <= pointsRemaining) {
                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                        if (responseBeen.get(position).isSelected()) {
                            holder.bluredRel.setVisibility(View.GONE);
                        }
                    }


                }

            }

            if (ROLE_BATSMAN) {
                if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_BATSMAN)) {
                    if (responseBeen.get(position).isSelected()) {

                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                    }

                }
            } else if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_BATSMAN)) {
                holder.bluredRel.setVisibility(View.GONE);
                if (pointsRemaining != 0.0) {
                    if (Float.parseFloat(responseBeen.get(position).getPlayerSalary().trim()) <= pointsRemaining) {
                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                        if (responseBeen.get(position).isSelected()) {
                            holder.bluredRel.setVisibility(View.GONE);
                        }
                    }


                }

            }
            if (ROLE_BOWLER) {
                if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_BOWLER)) {
                    if (responseBeen.get(position).isSelected()) {

                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                    }

                } else {
                    //holder.bluredRel.setVisibility(View.GONE);
                }
            } else if (responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_BOWLER)) {
                holder.bluredRel.setVisibility(View.GONE);
                if (pointsRemaining != 0.0) {
                    if (Float.parseFloat(responseBeen.get(position).getPlayerSalary().trim()) <= pointsRemaining) {
                        holder.bluredRel.setVisibility(View.GONE);
                    } else {
                        holder.bluredRel.setVisibility(View.VISIBLE);
                        if (responseBeen.get(position).isSelected()) {
                            holder.bluredRel.setVisibility(View.GONE);
                        }
                    }
                }

            }
        }

/*
        if(ROLE_WICKETKEEPER){
            if(responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_WICKETKEEPER)){
                if(responseBeen.get(position).isSelected()){
                    holder.bluredRel.setVisibility(View.GONE);
                }else {
                    if(wk_count==1){
                        holder.bluredRel.setVisibility(View.VISIBLE);
                    }else {
                        holder.bluredRel.setVisibility(View.GONE);
                    }
                }
            }
        } else if(responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_WICKETKEEPER)){
            holder.bluredRel.setVisibility(View.GONE);

        }


        if(ROLE_ALLROUNDER){
            if(responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_ALLROUNDER)){
                if(responseBeen.get(position).isSelected()){

                    holder.bluredRel.setVisibility(View.GONE);
                }else {
                    holder.bluredRel.setVisibility(View.VISIBLE);
                }

            }else {
               // holder.bluredRel.setVisibility(View.GONE);
            }
        } else if(responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_ALLROUNDER)){
            holder.bluredRel.setVisibility(View.GONE);

        }

        if(ROLE_BATSMAN){
            if(responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_BATSMAN)){
                if(responseBeen.get(position).isSelected()){

                    holder.bluredRel.setVisibility(View.GONE);
                }else {
                    holder.bluredRel.setVisibility(View.VISIBLE);
                }

            }else {
               // holder.bluredRel.setVisibility(View.GONE);
            }
        }else if(responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_BATSMAN)){
            holder.bluredRel.setVisibility(View.GONE);

        }

        if(ROLE_BOWLER){
            if(responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_BOWLER)){
                if(responseBeen.get(position).isSelected()){

                    holder.bluredRel.setVisibility(View.GONE);
                }else {
                    holder.bluredRel.setVisibility(View.VISIBLE);
                }

            }else {
                //holder.bluredRel.setVisibility(View.GONE);
            }
        }else if(responseBeen.get(position).getPlayerRole().equals(Constant.ROLE_BOWLER)){
            holder.bluredRel.setVisibility(View.GONE);

        }*/
    }

    public String getPlayerId(int position) {
        return responseBeen.get(position).getPlayerGUID();
    }

    public PlayersOutput.DataBean.RecordsBean getPlayer(int position) {
        return responseBeen.get(position);
    }

    public String getPlayRole(int position) {
        return responseBeen.get(position).getPlayerRole();
    }

    /*public String getPoints(int position) {
        return responseBeen.get(position).getPoints();
    }*/

    public String getPoints(int position) {
        // return String.valueOf(responseBeen.get(position).getPointCredits()) ;
        return String.valueOf(responseBeen.get(position).getPlayerSalary());
    }

    public String getTeamId(int position) {
        return responseBeen.get(position).getTeamGUID();
    }

    public String getTeamName(int position) {
        return responseBeen.get(position).getTeamNameShort();
    }

    public boolean isSelected(int position) {
        return responseBeen.get(position).isSelected();
    }

    public void toggleSelected(int position) {
        responseBeen.get(position).setSelected(!responseBeen.get(position).isSelected());
    }

    public PlayersOutput.DataBean.RecordsBean getItemData(int position) {
        if (responseBeen == null) return null;
        return responseBeen.get(position);
    }

    public void addItem(PlayersOutput.DataBean.RecordsBean bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }

    public void addAllItem(List<PlayersOutput.DataBean.RecordsBean> beanList) {
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void updateTeamData(List<PlayersOutput.DataBean.RecordsBean> beanList) {
        clear();
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public int getSelectedCount() {
        if (responseBeen == null) return 0;
        int count = 0;
        for (int i = 0; i < responseBeen.size(); i++) {
            if (isSelected(i)) count++;
        }
        return count;
    }

    public void clear() {
        if (responseBeen == null) return;
        responseBeen.clear();
        notifyDataSetChanged();
    }

    public void setCrossButton(View view, ImageView ivCross, int position) {
        ivCross.setImageResource(isSelected(position) ? R.drawable.ic_remove_player : R.drawable.ic_add_player);
        //ivCross.setColorFilter(Color.parseColor(isSelected(position) ? "#ed0a0a" : "#00BA3C"), PorterDuff.Mode.SRC_IN);
        ivCross.setColorFilter(Color.parseColor(isSelected(position) ? "#00BA3C" : "#ed0a0a"), PorterDuff.Mode.SRC_IN);

        if (view != null) {
            if (isSelected(position)) {
                view.setVisibility(View.VISIBLE);
            } else {
                view.setVisibility(View.GONE);
            }
        }
    }

    void disableItems(boolean bool, String role, int count) {

        switch (role) {

            case Constant.ROLE_WICKETKEEPER:

                ROLE_WICKETKEEPER = bool;
                wk_count = count;

                break;
            case Constant.ROLE_BATSMAN:

                bat_count = count;
                ROLE_BATSMAN = bool;

                break;
            case Constant.ROLE_ALLROUNDER:

                ar_count = count;
                ROLE_ALLROUNDER = bool;

                break;
            case Constant.ROLE_BOWLER:

                bw_count = count;
                ROLE_BOWLER = bool;

                break;

            case Constant.ROLE_DEFENDER:

                def_count = count;
                ROLE_DEFENDER = bool;

                break;

            case Constant.ROLE_FORWARD:

                st_count = count;
                ROLE_FORWARD = bool;

                break;

            case Constant.ROLE_GOALKEEPER:

                gk_count = count;
                ROLE_GOALKEEPER = bool;

                break;

            case Constant.ROLE_MIDFIELDER:

                mid_count = count;
                ROLE_MIDFIELDER = bool;

                break;

        }

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return responseBeen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.hi_main_card)
        @Nullable
        View mCardViewMainCard;

        @BindView(R.id.view_shadow)
        @Nullable
        View view_shadow;

        @BindView(R.id.iv_player)
        @Nullable
        CustomImageView ivPlayer;

        @BindView(R.id.iv_cross)
        @Nullable
        ImageView ivCross;

        @BindView(R.id.ctv_name)
        @Nullable
        CustomTextView customTextViewName;

        @BindView(R.id.v_playing_ind)
        @Nullable
        View v_playing_ind;

        @BindView(R.id.ctv_is_playing)
        CustomTextView ctv_is_playing;

        @BindView(R.id.ctv_country)
        @Nullable
        CustomTextView ctvCountry;

        @BindView(R.id.ctv_credits)
        @Nullable
        CustomTextView ctvCredits;

        @BindView(R.id.total_points)
        @Nullable
        CustomTextView total_points;

        @BindView(R.id.bluredRel)
        RelativeLayout bluredRel;


        @BindView(R.id.ctv_selection)
        CustomTextView ctv_selection;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    void shotByName(boolean bool) {
        shotBySelection(bool);
       /* if (bool) {
            Collections.sort(responseBeen, new SortByNameDES());
        } else {
            Collections.sort(responseBeen, new SortByNameASC());
        }

        notifyDataSetChanged();*/
    }

    void shotByPoint(boolean bool) {

        if (bool) {
            Collections.sort(responseBeen, new PointSorterDES());
        } else {
            Collections.sort(responseBeen, new PointSorterASC());
        }

        notifyDataSetChanged();
    }

    void shotByCredit(boolean bool) {

        if (bool) {
            Collections.sort(responseBeen, new CreaditSorterDES());
        } else {
            Collections.sort(responseBeen, new CreaditSorterASC());
        }

        notifyDataSetChanged();
    }


    void shotBySelection(boolean bool) {

        if (bool) {
            Collections.sort(responseBeen, new SelectedSorterDEC());
        } else {
            Collections.sort(responseBeen, new SelectedSorterASC());
        }

        notifyDataSetChanged();
    }


}
