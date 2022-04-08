package com.mw.eleven11.UI.leaderboardRanking;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.beanOutput.RankingOutput;

import java.util.List;



public class RankingItemAdapter extends RecyclerView.Adapter<RankingViewHolder> {

    Context mContext;
    List<RankingOutput.DataBean.RecordsBean> leaderboardRankList;
    String series;
    String series_id;

    public RankingItemAdapter(Context mContext, List<RankingOutput.DataBean.RecordsBean> leaderboardRankList,
                              String series, String series_id) {
        this.mContext = mContext;
        this.leaderboardRankList = leaderboardRankList;
        this.series = series;
        this.series_id = series_id;
    }

    @Override
    public RankingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.leaderboard_ranking_item_adapter, parent, false);

        return new RankingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RankingViewHolder holder, final int position) {
        if (position == 0) {
            holder.mRelativeLayout.setBackgroundColor(mContext.getResources().getColor(R.color.blue));
        }
        if (position > 0) {
            holder.mCustomTextViewTeamCode.setTextColor(Color.BLACK);
            holder.mCustomTextViewPoints.setTextColor(Color.BLACK);
            holder.mCustomTextViewRank.setTextColor(Color.BLACK);
            if ((position % 2) == 0) {
                holder.mRelativeLayout.setBackgroundColor(mContext.getResources().getColor(R.color.white));
            } else
                holder.mRelativeLayout.setBackgroundColor(mContext.getResources().getColor(R.color.input_gray));
        }

       /* if (leaderboardRankList.get(position).getRank() == 1) {
            holder.mRelativeLayout.setBackgroundColor(mContext.getResources().getColor(R.color.lightYellow));
        }*/

        holder.mSimpleDraweeView.setImageURI(leaderboardRankList.get(position).getProfilePic());
        holder.mCustomTextViewTeamCode.setText(leaderboardRankList.get(position).getUsername());
        holder.mCustomTextViewPoints.setText(leaderboardRankList.get(position).getTotalPoints() + "");
        //holder.mCustomTextViewRank.setText(leaderboardRankList.get(position).getRank() + "");
       holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TeamStatusActivity.start(mContext, series, series_id,
                        leaderboardRankList.get(position).getUser_image(),
                        leaderboardRankList.get(position).getTeam_code(),
                        leaderboardRankList.get(position).getRank(),
                        leaderboardRankList.get(position).getTotalPoints());*/
            }
        });

        holder.mSimpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leaderboardRankList.get(position).getUserGUID().equals(AppSession.getInstance().
                        getLoginSession().getData().getUserGUID())) {
                    HomeNavigation.startHome(mContext, true);

                } else {
                   /* Intent intent = new Intent(mContext, PlayersPlayingHistory.class);
                    intent.putExtra("name", leaderboardRankList.get(position).getTeam_code());
                    intent.putExtra("userId", leaderboardRankList.get(position).getUser_id());
                    intent.putExtra("userImg", leaderboardRankList.get(position).getUser_image());
                    mContext.startActivity(intent);*/
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return leaderboardRankList.size();
    }
}
