package com.mw.eleven11.UI.myTeams;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.MyTeamOutput;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */

public class MyFootballTeamsAdapter extends RecyclerView.Adapter<MyFootballTeamsAdapter.MyViewHolder> {

    OnItemClickListener.OnItemClickCallback onItemClickCallback, onEditItemClickCallback, onViewItemClickCallback, onCloneItemClickCallback;
    int layoutId = 0;
    String teamId = "", localTeamGUID = "";
    private List<MyTeamOutput.DataBean.RecordsBean> responseBeen = new ArrayList<>();
    private Context mContext;

    public MyFootballTeamsAdapter(int layoutId, Context mContext, List<MyTeamOutput.DataBean.RecordsBean> responseBeen,
                                  OnItemClickListener.OnItemClickCallback onItemClickCallback,
                                  OnItemClickListener.OnItemClickCallback onEditItemClickCallback,
                                  OnItemClickListener.OnItemClickCallback onViewItemClickCallback,
                                  OnItemClickListener.OnItemClickCallback onCloneItemClickCallback) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.onItemClickCallback = onItemClickCallback;
        this.onViewItemClickCallback = onViewItemClickCallback;
        this.onEditItemClickCallback = onEditItemClickCallback;
        this.onCloneItemClickCallback = onCloneItemClickCallback;
    }

    @Override
    public MyFootballTeamsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyFootballTeamsAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.setTeam();
        if (holder.ivCheck != null){
            holder.setMark();
            holder.ivCheck.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));
        }
        if (holder.cardViewRoot != null)
            holder.cardViewRoot.setOnClickListener(new OnItemClickListener(position, onViewItemClickCallback));
        if (holder.imageViewEdit != null)
            holder.imageViewEdit.setOnClickListener(new OnItemClickListener(position, onEditItemClickCallback));
        if (holder.imageViewCopy != null)
            holder.imageViewCopy.setOnClickListener(new OnItemClickListener(position, onCloneItemClickCallback));

        holder.customTextViewTeamName.setText(responseBeen.get(position).getUserTeamName());


    }


    public void setSelect(int position) {
        if (responseBeen == null) return;
        for (int i = 0; i < responseBeen.size(); i++) {
            responseBeen.get(i).setIs_user_joined_team(0);
        }
        responseBeen.get(position).setIs_user_joined_team(1);
        notifyDataSetChanged();
    }

    public void setSelect(String teamId) {
        this.teamId = teamId;
        if (responseBeen == null || TextUtils.isEmpty(teamId)) return;
        for (int i = 0; i < responseBeen.size(); i++) {
            if (responseBeen.get(i).getUserTeamGUID().equals(teamId))
                responseBeen.get(i).setIs_user_joined_team(1);
            else
                responseBeen.get(i).setIs_user_joined_team(0);
        }
        notifyDataSetChanged();
    }

    public String getSelectTeamId() {

        if (responseBeen == null) return "";
        for (int i = 0; i < responseBeen.size(); i++) {
            if (responseBeen.get(i).getIs_user_joined_team() == 1) {

                return responseBeen.get(i).getUserTeamGUID();

            }


        }
        return "";
    }

    public ArrayList<String> getSelectTeamIdList() {

        ArrayList<String> teamIds = new ArrayList<>();

        if (responseBeen == null) return teamIds;
        for (int i = 0; i < responseBeen.size(); i++) {
            if (responseBeen.get(i).getIs_user_joined_team() == 1) {


                teamIds.add(responseBeen.get(i).getUserTeamGUID());
            }


        }
        return teamIds;
    }

    public String getTeamName(int position) {
        if (responseBeen == null) return "";
        return responseBeen.get(position).getUserTeamName();
    }



    public MyTeamOutput.DataBean.RecordsBean getCloneData(int position) {
        if (responseBeen == null) return null;
        try {
            MyTeamOutput.DataBean.RecordsBean responseClone = (MyTeamOutput.DataBean.RecordsBean) responseBeen.get(position);
            responseClone.setUserTeamID("");
            return responseClone;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public MyTeamOutput.DataBean.RecordsBean getItemData(int position) {
        if (responseBeen == null) return null;
        return responseBeen.get(position);
    }

    public void addItem(MyTeamOutput.DataBean.RecordsBean bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }

    public void addAllItem(List<MyTeamOutput.DataBean.RecordsBean> beanList) {
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

        @BindView(R.id.customTextViewIndicatorCaptain)
        CustomTextView customTextViewIndicatorCaptain;

        @BindView(R.id.customTextViewIndicatorViceCaptain)
        CustomTextView customTextViewIndicatorViceCaptain;

        @BindView(R.id.cardViewRoot)
        CardView cardViewRoot;


        @BindView(R.id.customTextViewTeamName)
        CustomTextView customTextViewTeamName;

        @BindView(R.id.imageViewEdit)
        @Nullable
        ImageView imageViewEdit;


        @BindView(R.id.imageViewCopy)
        @Nullable
        ImageView imageViewCopy;


        @BindView(R.id.customTextViewTeamNameLocal)
        CustomTextView customTextViewTeamNameLocal;

        @BindView(R.id.customTextViewTeamNameVisitor)
        CustomTextView customTextViewTeamNameVisitor;


        @BindView(R.id.customTextViewTeamPlayerCountLocal)
        CustomTextView customTextViewTeamPlayerCountLocal;


        @BindView(R.id.customTextViewTeamPlayerCountVisitor)
        CustomTextView customTextViewTeamPlayerCountVisitor;


        @BindView(R.id.customTextViewCountWK)
        CustomTextView customTextViewCountWK;

        @BindView(R.id.customTextViewCountBAT)
        CustomTextView customTextViewCountBAT;

        @BindView(R.id.customTextViewCountAR)
        CustomTextView customTextViewCountAR;


        @BindView(R.id.customTextViewCountBOWL)
        CustomTextView customTextViewCountBOWL;


        @BindView(R.id.customTextViewCaptainName)
        CustomTextView customTextViewCaptainName;

        @BindView(R.id.customImageViewCaptainImage)
        CustomImageView customImageViewCaptainImage;


        @BindView(R.id.customTextViewViceCaptainName)
        CustomTextView customTextViewViceCaptainName;

        @BindView(R.id.customImageViewViceCaptainImage)
        CustomImageView customImageViewViceCaptainImage;


        @BindView(R.id.iv_check)
        @Nullable
        ImageView ivCheck;


        @BindView(R.id.ctv_already_added)
        @Nullable
        CustomTextView ctvAlreadyAdded;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void setMark() {
            if (ivCheck == null) return;
            if (responseBeen.get(getAdapterPosition()).getIsTeamJoined().equals("Yes")) {
                ivCheck.setImageResource(R.drawable.ic_mark);
            } else {
                ivCheck.setImageResource(R.drawable.circle_trans_border_white);
            }

            if (responseBeen.get(getAdapterPosition()).getIs_user_joined_team() == 1) {
                ivCheck.setImageResource(R.drawable.ic_mark);
            } else {
                ivCheck.setImageResource(R.drawable.circle_trans_border_white);
            }
            if (ctvAlreadyAdded != null && !TextUtils.isEmpty(teamId)) {
                if (teamId.equals(responseBeen.get(getAdapterPosition()).getUserTeamID())) {
                    ctvAlreadyAdded.setVisibility(View.VISIBLE);
                } else {
                    ctvAlreadyAdded.setVisibility(View.GONE);
                }
            } else {
                ctvAlreadyAdded.setVisibility(View.GONE);
            }
        }


        public void setTeam() {
            int localTeamPlayerCount = 0;
            int visitorTeamPlayerCount = 0;
            int wk = 0, bat = 0, ar = 0, bowl = 0;
            for (int i = 0; i < responseBeen.get(getAdapterPosition()).getUserTeamPlayers().size(); i++) {
                MyTeamOutput.DataBean.RecordsBean.UserTeamPlayersBean userTeam = new MyTeamOutput.DataBean.RecordsBean.UserTeamPlayersBean();

                userTeam = responseBeen.get(getAdapterPosition()).getUserTeamPlayers().get(i);
                if (userTeam.getTeamNameShort().equals(localTeamGUID)) {
                    localTeamPlayerCount++;
                    customTextViewTeamNameLocal.setText(userTeam.getTeamNameShort());

                } else {
                    visitorTeamPlayerCount++;
                    customTextViewTeamNameVisitor.setText(userTeam.getTeamNameShort());
                }

                if (userTeam.getPlayerPosition().equals(Constant.POSITION_CAPTAIN)) {
                    customTextViewCaptainName.setText(AppUtils.getPlayerShortName(userTeam.getPlayerName()));
                    ViewUtils.setImageUrl(customImageViewCaptainImage, userTeam.getPlayerPic());
                    customTextViewIndicatorCaptain.setBackgroundResource(userTeam.getTeamNameShort().equals(localTeamGUID)?R.drawable.circle_black_border_white:R.drawable.circle_color_primary_border_white);
                } else if (userTeam.getPlayerPosition().equals(Constant.POSITION_VICE_CAPTAIN)) {
                    customTextViewViceCaptainName.setText(AppUtils.getPlayerShortName(userTeam.getPlayerName()));
                    ViewUtils.setImageUrl(customImageViewViceCaptainImage, userTeam.getPlayerPic());
                    customTextViewIndicatorViceCaptain.setBackgroundResource(userTeam.getTeamNameShort().equals(localTeamGUID)?R.drawable.circle_black_border_white:R.drawable.circle_color_primary_border_white);
                }
                if (userTeam.getPlayerRole().equals(Constant.ROLE_GOALKEEPER)) {
                    wk++;
                } else if (userTeam.getPlayerRole().equals(Constant.ROLE_DEFENDER)) {
                    bat++;
                } else if (userTeam.getPlayerRole().equals(Constant.ROLE_MIDFIELDER)) {
                    ar++;
                } else if (userTeam.getPlayerRole().equals(Constant.ROLE_FORWARD)) {
                    bowl++;
                }
            }
            customTextViewCountBAT.setText(bat + "");
            customTextViewCountBOWL.setText(bowl + "");
            customTextViewCountAR.setText(ar + "");
            customTextViewCountWK.setText(wk + "");
            customTextViewTeamPlayerCountLocal.setText(localTeamPlayerCount + "");
            customTextViewTeamPlayerCountVisitor.setText(visitorTeamPlayerCount + "");
        }

    }

}
