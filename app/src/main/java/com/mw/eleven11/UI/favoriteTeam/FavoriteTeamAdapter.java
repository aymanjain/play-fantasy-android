package com.mw.eleven11.UI.favoriteTeam;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.ResponseFavoriteTeam;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 */

public class FavoriteTeamAdapter extends RecyclerView.Adapter<FavoriteTeamAdapter.MyViewHolder> {

    OnItemClickListener.OnItemClickCallback onItemClickCallback;
    int layoutId = 0;
    List<ResponseFavoriteTeam.DataBean.RecordsBean> favouriteTeam = new ArrayList<>();
    ArrayList<String> mTeamList = new ArrayList<>();
    ArrayList<String> mSelectedTeamList = new ArrayList<>();
    private List<ResponseFavoriteTeam.DataBean.RecordsBean> mFavoriteTeams;
    private Context mContext;

    public FavoriteTeamAdapter(List<ResponseFavoriteTeam.DataBean.RecordsBean> mFavoriteTeams, int layoutId, Context mContext,
                               OnItemClickListener.OnItemClickCallback onItemClickCallback
    ) {
        //this.mTeamList = mTeamList;
        this.mFavoriteTeams = mFavoriteTeams;
        this.layoutId = layoutId;
        this.mContext = mContext;

        this.onItemClickCallback = onItemClickCallback;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite_team, parent, false));

    }

    @Override
    public int getItemViewType(int position) {

        return 0;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        holder.flagIcon.getHierarchy().setFailureImage(R.drawable.ic_users);

        holder.countryName.setText(mFavoriteTeams.get(position).getCountryName());
        holder.flagIcon.setImageURI(mFavoriteTeams.get(position).getCountryFlag());


        holder.flagIcon.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);

        Log.d("FavoriteName", mFavoriteTeams.get(position).getCountryFlag());


        //holder.mCardViewMainCard.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));

       /* if (mTeamList.contains(mFavoriteTeams.get(position).getCountryName())) {
            favouriteTeam.add(mFavoriteTeams.get(position));
            mSelectedTeamList.add(mFavoriteTeams.get(position).getCountryName());
            holder.mCardViewMainCard.setSelected(true);
            holder.mCardViewMainCard.setBackground(mContext.getResources().getDrawable(R.drawable.border_team_fav_true));
        } else {
            holder.mCardViewMainCard.setSelected(false);
            favouriteTeam.remove(mFavoriteTeams.get(position));
            mSelectedTeamList.remove(mFavoriteTeams.get(position).getCountryName());
            holder.mCardViewMainCard.setBackground(mContext.getResources().getDrawable(R.drawable.border_team_fav_false));
        }
        */

        if (mFavoriteTeams.get(position).getIsUserFavourite().equals("Yes")) {
            favouriteTeam.add(mFavoriteTeams.get(position));
            holder.mCardViewMainCard.setSelected(true);
            holder.mCardViewMainCard.setBackground(mContext.getResources().getDrawable(R.drawable.border_team_fav_true));
            mSelectedTeamList.add(mFavoriteTeams.get(position).getCountryName());
        }else {
            holder.mCardViewMainCard.setSelected(false);
            mSelectedTeamList.remove(mFavoriteTeams.get(position).getCountryName());
            holder.mCardViewMainCard.setBackground(mContext.getResources().getDrawable(R.drawable.border_team_fav_false));
        }


        holder.mCardViewMainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.mCardViewMainCard.isSelected()) {

                    holder.mCardViewMainCard.setSelected(false);
                    favouriteTeam.remove(mFavoriteTeams.get(position));
                    mSelectedTeamList.remove(mFavoriteTeams.get(position).getCountryName());
                    holder.mCardViewMainCard.setBackground(mContext.getResources().getDrawable(R.drawable.border_team_fav_false));

                } else {
                    favouriteTeam.add(mFavoriteTeams.get(position));
                    mSelectedTeamList.add(mFavoriteTeams.get(position).getCountryName());
                    holder.mCardViewMainCard.setSelected(true);
                    holder.mCardViewMainCard.setBackground(mContext.getResources().getDrawable(R.drawable.border_team_fav_true));
                }

            }
        });

    }


    @Override
    public int getItemCount() {
        return mFavoriteTeams.size();
    }

    public void addAllItem(List<ResponseFavoriteTeam.DataBean.RecordsBean> beanList) {
        if (beanList == null || mFavoriteTeams == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void addItem(ResponseFavoriteTeam.DataBean.RecordsBean bean) {
        if (bean == null || mFavoriteTeams == null) return;
        mFavoriteTeams.add(bean);
        notifyItemInserted(mFavoriteTeams.size() - 1);
    }

    public List<ResponseFavoriteTeam.DataBean.RecordsBean> selectedTeam() {
        return favouriteTeam;
    }

    public ArrayList<String> selectedTeamList(){
        return mSelectedTeamList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.hi_main_card)
        @Nullable
        CardView mCardViewMainCard;


        @BindView(R.id.countryName)
        CustomTextView countryName;

        @BindView(R.id.flagIcon)
        SimpleDraweeView flagIcon;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }


}
