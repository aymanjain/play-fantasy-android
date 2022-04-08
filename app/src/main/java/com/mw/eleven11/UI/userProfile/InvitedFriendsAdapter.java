package com.mw.eleven11.UI.userProfile;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.InvitedFriendsResponce;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */

public class InvitedFriendsAdapter extends RecyclerView.Adapter<InvitedFriendsAdapter.MyViewHolder> {

    private List<InvitedFriendsResponce.ResponseBean.InvitedFriendsBean> mInvitedFriends = new ArrayList<>();
    private Context mContext;
    OnItemClickListener.OnItemClickCallback onItemClickCallback;
    int layoutId = 0;


    public InvitedFriendsAdapter(int layoutId, Context mContext,
                                 List<InvitedFriendsResponce.ResponseBean.InvitedFriendsBean> mInvitedFriends,
                                 OnItemClickListener.OnItemClickCallback onItemClickCallback
    ) {
        this.mInvitedFriends = mInvitedFriends;
        this.layoutId = layoutId;
        this.mContext = mContext;

        this.onItemClickCallback = onItemClickCallback;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.invited_friends, parent, false));

    }

    @Override
    public int getItemViewType(int position) {

        return 0;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        holder.friends_image.getHierarchy().setFailureImage(R.drawable.ic_users);

        holder.friends_Name.setText(mInvitedFriends.get(position).getTeamCode());
        holder.friends_image.setImageURI(mInvitedFriends.get(position).getUserImage());

        holder.recivedAmount.setText("" + mInvitedFriends.get(position).getReceivedAmount());
        holder.totalAmount.setText("" + mInvitedFriends.get(position).getBonusAmount());
        holder.progress_view.setProgress(mInvitedFriends.get(position).getReceivedAmount());

        holder.mCardViewMainCard.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));

    }


    @Override
    public int getItemCount() {
        return mInvitedFriends.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.hi_main_card)
        @Nullable
        CardView mCardViewMainCard;


        @BindView(R.id.friendsJoined)
        CustomTextView friends_Name;

        @BindView(R.id.friends_image)
        SimpleDraweeView friends_image;

        @BindView(R.id.recivedAmount)
        CustomTextView recivedAmount;

        @BindView(R.id.totalAmount)
        CustomTextView totalAmount;

        @BindView(R.id.progress_view)
        ProgressBar progress_view;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public void addAllItem(List<InvitedFriendsResponce.ResponseBean.InvitedFriendsBean> beanList) {
        if (beanList == null || mInvitedFriends == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void addItem(InvitedFriendsResponce.ResponseBean.InvitedFriendsBean bean) {
        if (bean == null || mInvitedFriends == null) return;
        mInvitedFriends.add(bean);
        notifyItemInserted(mInvitedFriends.size() - 1);
    }


}
