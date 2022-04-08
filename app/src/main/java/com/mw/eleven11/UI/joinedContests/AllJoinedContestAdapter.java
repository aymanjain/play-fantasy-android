package com.mw.eleven11.UI.joinedContests;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.inviteContest.InviteContestActivity;
import com.mw.eleven11.beanOutput.JoinedContestOutput;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllJoinedContestAdapter extends RecyclerView.Adapter<AllJoinedContestAdapter.MyViewHolder> {

    List<JoinedContestOutput.DataBean.RecordsBean> responseBeen = new ArrayList<>();
    int layoutId = 0;
    OnItemClickListener.OnItemClickCallback onWinnerClickCallBack, onItemClickCallback, onJoinClickCallBack;
    private Context mContext;
    String matchTeamVS = "";


    public AllJoinedContestAdapter(int layoutId, Context mContext, List<JoinedContestOutput.DataBean.RecordsBean> responseBeen,
                                   OnItemClickListener.OnItemClickCallback onWinnerClickCallBack,
                                   OnItemClickListener.OnItemClickCallback onItemClickCallback,
                                   OnItemClickListener.OnItemClickCallback onJoinClickCallBack,
                                   String matchTeamVS) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.onJoinClickCallBack = onJoinClickCallBack;
        this.onWinnerClickCallBack = onWinnerClickCallBack;
        this.onItemClickCallback = onItemClickCallback;
        this.matchTeamVS = matchTeamVS;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_contest_item, parent, false));

    }

    @Override
    public int getItemViewType(int position) {

        return 0;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if (!responseBeen.get(position).getWinningAmount().equals("0")) {
            holder.total_winnings_amount.setText(AppUtils.getStrFromRes(R.string.price_unit)+""+responseBeen.get(position).getWinningAmount());
        } else {
            holder.total_winnings_amount.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            holder.total_winnings_amount.setText(AppUtils.getStrFromRes(R.string.practice_contest));

        }

        holder.entry_fee_amount.setText(AppUtils.getStrFromRes(R.string.price_unit)+""+responseBeen.get(position).getEntryFee());
        holder.winners_count.setText(responseBeen.get(position).getNoOfWinners());

        holder.spotLeftCount.setText(AppUtils.getStrFromRes(R.string.only) + " " +
                (Integer.valueOf(responseBeen.get(position).getContestSize()) -
                        Integer.valueOf(responseBeen.get(position).getTotalJoined())) + " " + AppUtils.getStrFromRes(R.string.spotLeft));


        holder.teamsCount.setText(responseBeen.get(position).getContestSize() + " " + AppUtils.getStrFromRes(R.string.teams));


        holder.winners_count.setOnClickListener(new OnItemClickListener(position, onWinnerClickCallBack));

        holder.hi_main_card.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));


        holder.joinButton.setOnClickListener(new OnItemClickListener(position, onJoinClickCallBack));

        holder.seekBar.setMax(Integer.valueOf(responseBeen.get(position).getContestSize()));
        //holder.seekBar.setProgress(Integer.valueOf(responseBeen.get(position).getContestSize())-responseBeen.get(position).getSpots_left());

        holder.seekBar.setProgress(Integer.valueOf(responseBeen.get(position).getTotalJoined()));

        holder.seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        if(!responseBeen.get(position).getNoOfWinners().equals("1")){

            if(!responseBeen.get(position).getNoOfWinners().equals("0")) {
                holder.winners_count.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_down_arrow, 0);
                holder.winners_count.setCompoundDrawablePadding(10);

                holder.winners_count.setOnClickListener(new OnItemClickListener(position, onWinnerClickCallBack));
            }
        }

        if (true) {
            int spotLeft = Integer.valueOf(responseBeen.get(position).getContestSize()) -Integer.valueOf( responseBeen.get(position).getUserTotalJoinedInMatch());

            if (spotLeft != 0 && responseBeen.get(position).getEntryType().equals("Multiple")) {
                holder.joinButton.setText(AppUtils.getStrFromRes(R.string.joinplus));
            } else if (spotLeft == 0) {
                holder.joinButton.setText(AppUtils.getStrFromRes(R.string.joined));
            } else if (spotLeft != 0 && responseBeen.get(position).getEntryType().equals("Single")) {
                holder.joinButton.setText(AppUtils.getStrFromRes(R.string.invite));
                holder.joinButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        InviteContestActivity.start(mContext, responseBeen.get(position).getUserInvitationCode(),matchTeamVS);
                    }
                });
            }
        }

        if(!responseBeen.get(position).getStatus().equals(Constant.Pending)){
            holder.joinButton.setVisibility(View.GONE);
        }
        if (responseBeen.get(position).getContestSize().equals(responseBeen.get(position).getTotalJoined())){
            holder.joinButton.setVisibility(View.GONE);

        }else {
            holder.joinButton.setVisibility(View.VISIBLE);

        }
    }


    @Override
    public int getItemCount() {
        return responseBeen.size();
    }

    public void clear() {
        if (responseBeen == null) return;
        responseBeen.clear();
        notifyDataSetChanged();
    }

    public void addAllItem(List<JoinedContestOutput.DataBean.RecordsBean> beanList) {
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void addItem(JoinedContestOutput.DataBean.RecordsBean bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }

    public String getContestGUID(int position) {


        return responseBeen.get(position).getContestGUID();
    }

    public JoinedContestOutput.DataBean.RecordsBean getItem(int position) {


        return responseBeen.get(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.total_winnings_amount)
        CustomTextView total_winnings_amount;

        @BindView(R.id.winners_count)
        CustomTextView winners_count;

        @BindView(R.id.entry_fee_amount)
        CustomTextView entry_fee_amount;

        @BindView(R.id.hi_main_card)
        LinearLayout hi_main_card;


        @BindView(R.id.spotLeftCount)
        CustomTextView spotLeftCount;

        @BindView(R.id.teamsCount)
        CustomTextView teamsCount;

        @BindView(R.id.joinButton)
        CustomTextView joinButton;

        @BindView(R.id.seekBar)
        ProgressBar seekBar;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }

}
