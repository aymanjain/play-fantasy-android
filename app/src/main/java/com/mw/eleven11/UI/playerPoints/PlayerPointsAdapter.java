package com.mw.eleven11.UI.playerPoints;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.contestDetailLeaderBoard.stats.StatsFragment;
import com.mw.eleven11.UI.createTeam.sorting.PointSorterASC;
import com.mw.eleven11.UI.createTeam.sorting.PointSorterDES;
import com.mw.eleven11.UI.createTeam.sorting.SelectedSorterASC;
import com.mw.eleven11.UI.createTeam.sorting.SelectedSorterDEC;
import com.mw.eleven11.UI.createTeam.sorting.SortByNameASC;
import com.mw.eleven11.UI.createTeam.sorting.SortByNameDES;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.Collections;
import java.util.List;



public class PlayerPointsAdapter extends RecyclerView.Adapter<PlayerPointsViewHolder> {

    Context mContext;
    StatsFragment statsFragment;
    List<PlayersOutput.DataBean.RecordsBean> responseBeanList;
    OnItemClickListener.OnItemClickCallback onItemClickCallback;

    public PlayerPointsAdapter(Context mContext, List<PlayersOutput.DataBean.RecordsBean> responseBeanList,
                               OnItemClickListener.OnItemClickCallback onItemClickCallback) {
        this.mContext = mContext;
        this.responseBeanList = responseBeanList;
        this.onItemClickCallback = onItemClickCallback;
    }

    public PlayerPointsAdapter(StatsFragment statsFragment, List<PlayersOutput.DataBean.RecordsBean> responseBeanList,
                               OnItemClickListener.OnItemClickCallback onItemClickCallback) {
        this.statsFragment = statsFragment;
        this.responseBeanList = responseBeanList;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public PlayerPointsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(statsFragment!=null?R.layout.player_state_item_small:R.layout.player_state_item, parent, false);

        return new PlayerPointsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlayerPointsViewHolder holder, int position) {
        if (responseBeanList.get(position).getMyPlayer().equals("No")) {
            holder.mImageView.setImageResource(R.drawable.ic_check_mark_new_inactive);
           // holder.mImageView.setVisibility(View.GONE);
        } else {
            holder.mImageView.setImageResource(R.drawable.ic_check_mark_new);
        }

        if (responseBeanList.get(position).getTopPlayer().equals("No")) {
            holder.mImageViewTopPlayer.setImageResource(R.drawable.ic_star_new_inactive);
            //holder.mImageViewTopPlayer.setVisibility(View.GONE);
        } else {
            holder.mImageViewTopPlayer.setImageResource(R.drawable.ic_star_new);
        }

        holder.mSimpleDraweeView.setImageURI(responseBeanList.get(position).getPlayerPic());
        holder.mCustomTextViewName.setText(responseBeanList.get(position).getPlayerName());
        holder.mCustomTextViewPoints.setText(""+responseBeanList.get(position).getPointCredits());
        holder.mCustomTextViewSelectedBy.setText(responseBeanList.get(position).getPlayerSelectedPercent() + "%");

        holder.mRelativeLayout.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));

    }

    public void addAllItem(List<PlayersOutput.DataBean.RecordsBean> beanList) {
        if (beanList == null || responseBeanList == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }
    public void addItem(PlayersOutput.DataBean.RecordsBean bean) {
        if (bean == null || responseBeanList == null) return;
        responseBeanList.add(bean);
        notifyItemInserted(responseBeanList.size() - 1);
    }

    @Override
    public int getItemCount() {
        return responseBeanList.size();
    }


    public void shotByName(boolean bool){

        if(bool){
            Collections.sort(responseBeanList, new SortByNameDES());
        }else {
            Collections.sort(responseBeanList, new SortByNameASC());
        }
        if (mContext==null) {
            statsFragment.responseBeanList=responseBeanList;

        }else {
            ((PlayerPointsActivity)mContext).responseBeanList=responseBeanList;
        }

        notifyDataSetChanged();
    }
    public void shotByPoint(boolean bool){

        if(bool){
            Collections.sort(responseBeanList, new PointSorterDES());
        }else {
            Collections.sort(responseBeanList, new PointSorterASC());
        }

        if (mContext==null) {
            statsFragment.responseBeanList=responseBeanList;

        }else {
            ((PlayerPointsActivity)mContext).responseBeanList=responseBeanList;
        }
        notifyDataSetChanged();
    }

    public void shotBySelectedpercentage(boolean bool){

        if(bool){
            Collections.sort(responseBeanList, new SelectedSorterDEC());
        }else {
            Collections.sort(responseBeanList, new SelectedSorterASC());
        }
        if (mContext==null) {
            statsFragment.responseBeanList=responseBeanList;

        }else {
            ((PlayerPointsActivity)mContext).responseBeanList=responseBeanList;
        }
        notifyDataSetChanged();
    }


}
