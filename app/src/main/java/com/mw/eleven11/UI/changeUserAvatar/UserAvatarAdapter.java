package com.mw.eleven11.UI.changeUserAvatar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.AvatarListOutput;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



public class UserAvatarAdapter extends RecyclerView.Adapter<UserAvatarAdapter.MyViewHolder> {

    OnItemClickListener.OnItemClickCallback onItemClickCallback;
    int layoutId = 0;
    List<AvatarListOutput.DataBean.RecordsBean> favouriteTeam = new ArrayList<>();
    ArrayList<String> mTeamList = new ArrayList<>();
    private List<AvatarListOutput.DataBean.RecordsBean> mFavoriteTeams = new ArrayList<>();
    private Context mContext;
    private ArrayList<Integer> selectCheck = new ArrayList<>();


    public UserAvatarAdapter(ArrayList<String> mTeamList, int layoutId, Context mContext,
                             List<AvatarListOutput.DataBean.RecordsBean> mFavoriteTeams,
                             OnItemClickListener.OnItemClickCallback onItemClickCallback
    ) {
        this.mTeamList = mTeamList;
        this.mFavoriteTeams = mFavoriteTeams;
        this.layoutId = layoutId;
        this.mContext = mContext;

        this.onItemClickCallback = onItemClickCallback;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_avatar, parent, false));

    }

    @Override
    public int getItemViewType(int position) {

        return 0;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.flagIcon.setImageURI(mFavoriteTeams.get(position).getAvatarURL());
        if (selectCheck.size() != 0) {

            if (selectCheck.get(0) == position) {
                holder.viewSelector.setVisibility(View.VISIBLE);
            } else {
                holder.viewSelector.setVisibility(View.GONE);
            }
        }

        holder.mCardViewMainCard.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));

        holder.mCardViewMainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // holder.mCardViewMainCard.setBackground(mContext.getResources().getDrawable(R.drawable.border_team_fav_true));
                selectCheck.add(0, position);

                notifyDataSetChanged();

            }
        });

    }


    @Override
    public int getItemCount() {
        return mFavoriteTeams.size();
    }

    public void addAllItem(List<AvatarListOutput.DataBean.RecordsBean> beanList) {
        if (beanList == null || mFavoriteTeams == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void addItem(AvatarListOutput.DataBean.RecordsBean bean) {
        if (bean == null || mFavoriteTeams == null) return;
        mFavoriteTeams.add(bean);
        notifyItemInserted(mFavoriteTeams.size() - 1);
    }

    public AvatarListOutput.DataBean.RecordsBean selectedIcon() {
        AvatarListOutput.DataBean.RecordsBean item = null;

        if (selectCheck.size() != 0) {
            item = mFavoriteTeams.get(selectCheck.get(0));
        }

        return item;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.hi_main_card)
        @Nullable
        CardView mCardViewMainCard;

        @BindView(R.id.viewSelector)
        @Nullable
        View viewSelector;


        @BindView(R.id.avatar)
        SimpleDraweeView flagIcon;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }


}
