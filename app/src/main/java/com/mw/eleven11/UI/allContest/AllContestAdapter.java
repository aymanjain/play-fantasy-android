package com.mw.eleven11.UI.allContest;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.inviteContest.InviteContestActivity;
import com.mw.eleven11.beanOutput.AllContestOutPut;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.customView.RobotoRegularTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.OnItemClickListener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

public class AllContestAdapter extends RecyclerView.Adapter<AllContestAdapter.MyViewHolder> {

    List<AllContestOutPut.DataBean.RecordsBean> responseBeen = new ArrayList<>();
    int layoutId = 0;
    OnItemClickListener.OnItemClickCallback onWinnerClickCallBack, onItemClickCallback, onJoinClickCallBack;
    private Context mContext;
    String matchTeamVS = "";

    public AllContestAdapter(int layoutId, Context mContext, List<AllContestOutPut.DataBean.RecordsBean> responseBeen,
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

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_contest_item_new, parent, false));

    }

    @Override
    public int getItemViewType(int position) {

        return 0;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.bonus_infoRoot.setVisibility(View.GONE);
        if (!responseBeen.get(position).getCashBonusContribution().trim().equals("")) {
            final Float percent = Float.parseFloat(responseBeen.get(position).getCashBonusContribution().trim());
            if (percent != 0) {
//                holder.bonus_info.setText("Use "+percent+"% Cash Bonus");
                holder.bonus_info.setText("Upto " + percent + "%");
                holder.bonus_infoRoot.setVisibility(View.VISIBLE);
                holder.bonus_infoRoot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToolTip(v, "You can use max " + percent + "% Cash Bonus");
                    }
                });
            }
        }

        if (responseBeen.get(position).getWinnerPercentage() != null
                && !responseBeen.get(position).getWinnerPercentage().isEmpty()) {
            holder.tv_info_percantage.setText(responseBeen.get(position).getWinnerPercentage() + "%");
            String noOfWinner = responseBeen.get(position).getNoOfWinners();
            holder.bonus_inforoot_percantage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToolTip(v, noOfWinner+" "+"teams win in this contest");
                }
            });
        } else {
            holder.tv_info_percantage.setText("0"+ "%");
            String noOfWinner = responseBeen.get(position).getNoOfWinners();
            holder.bonus_inforoot_percantage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToolTip(v, noOfWinner+" "+"teams win in this contest");
                }
            });
        }

        if (responseBeen.get(position).getContestType().equalsIgnoreCase("Infinity Pool")) {
            if (responseBeen.get(position).getWinningAmount().equalsIgnoreCase("0")) {
                BigDecimal decimal = new BigDecimal(responseBeen.get(position).getWinUpTo()).stripTrailingZeros();

                holder.total_winnings_amount.setText(decimal.toPlainString() + "x Winning");
            } else {
                if (responseBeen.get(position).getWinningType() != null && responseBeen.get(position).getWinningType().equalsIgnoreCase("Free Join Contest")) {
                    holder.total_winnings_amount.setText("Bonus " + responseBeen.get(position).getWinningAmount());
                } else {
                    holder.total_winnings_amount.setText(AppUtils.getStrFromRes(R.string.price_unit) + "" + responseBeen.get(position).getWinningAmount());

                }

            }
        } else if (responseBeen.get(position).getUnfilledWinningPercent().equals("GuranteedPool") || responseBeen.get(position).getSmartPool().equals("Yes")) {
            if (responseBeen.get(position).getWinningType() != null && responseBeen.get(position).getWinningType().equalsIgnoreCase("Free Join Contest")) {
                holder.total_winnings_amount.setText("Bonus " + responseBeen.get(position).getWinningAmount());
            } else {
                holder.total_winnings_amount.setText(AppUtils.getStrFromRes(R.string.price_unit) + "" + responseBeen.get(position).getWinningAmount());

            }

        } else {
            if (!responseBeen.get(position).getWinningAmount().equals("0")) {
                if (responseBeen.get(position).getWinningType() != null && responseBeen.get(position).getWinningType().equalsIgnoreCase("Free Join Contest")) {
                    holder.total_winnings_amount.setText("Bonus " + responseBeen.get(position).getWinningAmount());
                } else {
                    holder.total_winnings_amount.setText(AppUtils.getStrFromRes(R.string.price_unit) + "" + responseBeen.get(position).getWinningAmount());

                }
            } else {
                holder.total_winnings_amount.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                holder.total_winnings_amount.setText(AppUtils.getStrFromRes(R.string.practice_contest));
                holder.total_winnings.setText(AppUtils.getStrFromRes(R.string.practice_contest_des));
            }
        }

//        if (!responseBeen.get(position).getWinningAmount().equals("0")) {
//            holder.total_winnings_amount.setText(AppUtils.getStrFromRes(R.string.price_unit)+""+responseBeen.get(position).getWinningAmount());
//        } else {
//            holder.total_winnings_amount.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
//            holder.total_winnings_amount.setText(AppUtils.getStrFromRes(R.string.practice_contest));
//
//        }


        if (responseBeen.get(position).getEntryFee().equalsIgnoreCase("0")) {
            holder.entry_fee_amount.setText(AppUtils.getStrFromRes(R.string.free));
        } else {
            holder.entry_fee_amount.setText(AppUtils.getStrFromRes(R.string.price_unit) + "" + responseBeen.get(position).getEntryFee());
        }
        holder.winners_count.setText(responseBeen.get(position).getNoOfWinners());

//        holder.spotLeftCount.setText(AppUtils.getStrFromRes(R.string.only) + " " +
//                (Integer.valueOf(responseBeen.get(position).getContestSize()) -
//                        Integer.valueOf(responseBeen.get(position).getTotalJoined())) + " " + AppUtils.getStrFromRes(R.string.spotLeft));


//        holder.teamsCount.setText(responseBeen.get(position).getContestSize() + " " + AppUtils.getStrFromRes(R.string.teams));


        holder.winners_count.setOnClickListener(new OnItemClickListener(position, onWinnerClickCallBack));

        holder.hi_main_card.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));


        holder.joinButton.setOnClickListener(new OnItemClickListener(position, onJoinClickCallBack));

//        holder.seekBar.setMax(Integer.valueOf(responseBeen.get(position).getContestSize()));
        //holder.seekBar.setProgress(Integer.valueOf(responseBeen.get(position).getContestSize())-responseBeen.get(position).getSpots_left());

//        holder.seekBar.setProgress(Integer.valueOf(responseBeen.get(position).getTotalJoined()));

        holder.seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        if (!responseBeen.get(position).getNoOfWinners().equals("1")) {

            if (!responseBeen.get(position).getNoOfWinners().equals("0")) {
                holder.winners_count.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_down_arrow, 0);
                holder.winners_count.setCompoundDrawablePadding(10);

                holder.winners_count.setOnClickListener(new OnItemClickListener(position, onWinnerClickCallBack));
            }
        }


        /*if (responseBeen.get(position).getEntryType().equals("Multiple")) {
            holder.multi.setVisibility(View.VISIBLE);
        } else {
            holder.multi.setVisibility(View.GONE);
        }*/

        if (responseBeen.get(position).getEntryType().equals("Multiple")) {
            holder.multi.setText("Upto 6");
            holder.multiIndicator.setText("M");
        } else {
            holder.multi.setText("Single");
            holder.multiIndicator.setText("S");
        }

        holder.multiRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToolTip(v,
                        responseBeen.get(position).getEntryType().equals("Multiple") ?
                                "You can join this contest with 6 teams" :
                                "You can join this contest with 1 team");
            }
        });


       /* if (responseBeen.get(position).getIsConfirm() != null && responseBeen.get(position).getIsConfirm().equals("Yes")) {
            holder.confirm.setVisibility(View.VISIBLE);
        } else {
            holder.confirm.setVisibility(View.GONE);
        }*/

        if (responseBeen.get(position).getGuaranteeSeat() != null && responseBeen.get(position).getGuaranteeSeat().equals("Yes")) {
            holder.confirm.setVisibility(View.VISIBLE);
        } else {
            holder.confirm.setVisibility(View.GONE);
        }
        holder.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToolTip(v, "Guaranteed league is confirmed. It will go on irrespective of number of entries.");
            }
        });

        if (responseBeen.get(position).getFirstRankPrize() != null && !responseBeen.get(position).getFirstRankPrize().trim().isEmpty()) {
            holder.firstPrize.setText(responseBeen.get(position).getFirstRankPrize().trim());
        } else {
            holder.firstPrize.setText("Glory awaits!");
        }

        holder.firstPrize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (responseBeen.get(position).getFirstRankPrize() != null && !responseBeen.get(position).getFirstRankPrize().trim().isEmpty()) {
                    showToolTip(v, "1st Prize = " + responseBeen.get(position).getFirstRankPrize().trim());
                } else {
                    showToolTip(v, "1st Prize = Glory");
                }

            }
        });


        if (responseBeen.get(position).getContestSize().equals("Unlimited")) {
            holder.spotLeftCount.setVisibility(View.VISIBLE);
            holder.spotLeftCount.setText("Total joined : " + responseBeen.get(position).getTotalJoined());
            holder.teamsCount.setText(AppUtils.getStrFromRes(R.string.infinity));
            holder.seekBar.setProgress(Integer.valueOf(responseBeen.get(position).getTotalJoined()));

//            holder.seekBar.setVisibility(View.GONE);
            holder.winners_count.setText(responseBeen.get(position).getWinningRatio() + "%");

            if (Integer.parseInt(responseBeen.get(position).getTotalJoined()) >= 2) {
                holder.winners_count.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_down_arrow, 0);
                holder.winners_count.setOnClickListener(new OnItemClickListener(position, onWinnerClickCallBack));

            } else {
                holder.winners_count.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            holder.spotLeftCount.setVisibility(View.VISIBLE);
            holder.winners_count.setEnabled(true);
            holder.spotLeftCount.setText(AppUtils.getStrFromRes(R.string.only) + " " +
                    (Integer.valueOf(responseBeen.get(position).getContestSize()) -
                            Integer.valueOf(responseBeen.get(position).getTotalJoined())) + " " + AppUtils.getStrFromRes(R.string.spotLeft));
            holder.teamsCount.setText(responseBeen.get(position).getContestSize() + " " + AppUtils.getStrFromRes(R.string.spot));
            holder.seekBar.setVisibility(View.VISIBLE);
            holder.seekBar.setMax(Integer.valueOf(responseBeen.get(position).getContestSize()));
            holder.seekBar.setProgress(Integer.valueOf(responseBeen.get(position).getTotalJoined()));
        }

        if (responseBeen.get(position).getIsJoined().equals("Yes")) {

            if (responseBeen.get(position).getContestSize().equals("Unlimited")) {
                if (responseBeen.get(position).getEntryType().equals("Multiple")) {
                    holder.joinButton.setText(AppUtils.getStrFromRes(R.string.joinplus));
                } else if (responseBeen.get(position).getEntryType().equals("Single")) {
                    holder.joinButton.setText(AppUtils.getStrFromRes(R.string.invite));
                    holder.joinButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            InviteContestActivity.start(mContext, responseBeen.get(position).getUserInvitationCode(), matchTeamVS);
                        }
                    });
                }
            } else {
                int spotLeft = Integer.valueOf(responseBeen.get(position).getContestSize()) - Integer.valueOf(responseBeen.get(position).getTotalJoined());

                if (spotLeft != 0 && responseBeen.get(position).getEntryType().equals("Multiple")) {
                    holder.joinButton.setText(AppUtils.getStrFromRes(R.string.joinplus));
                } else if (spotLeft == 0) {
                    holder.joinButton.setText(AppUtils.getStrFromRes(R.string.joined));
                    holder.joinButton.setEnabled(false);
                } else if (spotLeft != 0 && responseBeen.get(position).getEntryType().equals("Single")) {
                    holder.joinButton.setText(AppUtils.getStrFromRes(R.string.invite));
                    holder.joinButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            InviteContestActivity.start(mContext, responseBeen.get(position).getUserInvitationCode(), matchTeamVS);
                        }
                    });
                }
            }
        } else {
            //holder.joinButton.setText(AppUtils.getStrFromRes(R.string.joinCaps));
            holder.entry_fee.setVisibility(View.VISIBLE);
            holder.joinButton.setText("₹"+responseBeen.get(position).getEntryFee());
        }
        if (responseBeen.get(position).getContestSize().equalsIgnoreCase(responseBeen.get(position).getTotalJoined())) {
            holder.joinButton.setVisibility(View.GONE);
        } else {
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

    public void addAllItem(List<AllContestOutPut.DataBean.RecordsBean> beanList) {
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void addItem(AllContestOutPut.DataBean.RecordsBean bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }

    public String getContestGUID(int position) {


        return responseBeen.get(position).getContestGUID();
    }

    public AllContestOutPut.DataBean.RecordsBean getItem(int position) {


        return responseBeen.get(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.firstPrize)
        RobotoRegularTextView firstPrize;

        @BindView(R.id.total_winnings)
        RobotoRegularTextView total_winnings;

        @BindView(R.id.total_winnings_amount)
        RobotoRegularTextView total_winnings_amount;

        @BindView(R.id.winners_count)
        RobotoRegularTextView winners_count;

        @BindView(R.id.entry_fee_amount)
        RobotoRegularTextView entry_fee_amount;

        @BindView(R.id.hi_main_card)
        View hi_main_card;



        @BindView(R.id.multiRoot)
        View multiRoot;

        @BindView(R.id.multi)
        RobotoRegularTextView multi;

        @BindView(R.id.multiIndicator)
        RobotoRegularTextView multiIndicator;

        @BindView(R.id.confirm)
        View confirm;

        @BindView(R.id.bonus_info)
        RobotoRegularTextView bonus_info;


        @BindView(R.id.spotLeftCount)
        RobotoRegularTextView spotLeftCount;

        @BindView(R.id.teamsCount)
        RobotoRegularTextView teamsCount;

        @BindView(R.id.joinButton)
        RobotoRegularTextView joinButton;

        @BindView(R.id.seekBar)
        ProgressBar seekBar;


        @BindView(R.id.bonus_infoRoot)
        View bonus_infoRoot;

        @BindView(R.id.tv_info_percantage)
        RobotoRegularTextView tv_info_percantage;

        @BindView(R.id.bonus_inforoot_percantage)
        View bonus_inforoot_percantage;

        @BindView(R.id.entry_fee)
        RobotoRegularTextView entry_fee;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }



    }

    private void showToolTip(View view, String message) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int[] location = new int[2];
        view.getLocationOnScreen(location);

        new SimpleTooltip.Builder(mContext)
                .anchorView(view)
                .text(message)
                .gravity(height - location[1] > 100 ? Gravity.BOTTOM : Gravity.TOP)
                .animated(false)
                .transparentOverlay(true)
                .build()
                .show();
    }

}
