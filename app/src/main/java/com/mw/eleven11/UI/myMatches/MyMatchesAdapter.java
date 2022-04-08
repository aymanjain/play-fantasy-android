package com.mw.eleven11.UI.myMatches;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.MyContestMatchesOutput;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.customView.RobotoRegularTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 */

public class MyMatchesAdapter extends RecyclerView.Adapter<MyMatchesAdapter.MyViewHolder> {

    OnItemClickListener.OnItemClickCallback onItemClickCallback, onEditItemClickCallback, onDeleteItemClickCallback;
    int layoutId = 0;
    String type;
    int gametype;
    int tag = 0;
    private List<MyContestMatchesOutput.DataBean.RecordsBean> responseBeen = new ArrayList<>();
    private Context mContext;

  /*  public MyMatchesAdapter(String type, int layoutId, Context mContext, int gametype,
                            List<JoinedContestOutput.DataBean.RecordsBean,
                            OnItemClickListener.OnItemClickCallback onItemClickCallback,
                            OnItemClickListener.OnItemClickCallback onEditItemClickCallback,
                            OnItemClickListener.OnItemClickCallback onDeleteItemClickCallback) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.type = type;
        this.gametype = gametype;
        this.onItemClickCallback = onItemClickCallback;
        this.onEditItemClickCallback = onEditItemClickCallback;
        this.onDeleteItemClickCallback = onDeleteItemClickCallback;
    }*/

    public MyMatchesAdapter(int tag, String type, int layoutId, Context mContext,
                            int gametype, List<MyContestMatchesOutput.DataBean.RecordsBean> responseBeen,
                            OnItemClickListener.OnItemClickCallback onItemClickCallback,
                            OnItemClickListener.OnItemClickCallback onEditItemClickCallback,
                            OnItemClickListener.OnItemClickCallback onDeleteItemClickCallback) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.type = type;
        this.gametype = gametype;
        this.onItemClickCallback = onItemClickCallback;
        this.onEditItemClickCallback = onEditItemClickCallback;
        this.onDeleteItemClickCallback = onDeleteItemClickCallback;

        this.tag = tag;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_matches, parent, false));

    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(responseBeen.get(position).getTeamFlagLocal()) || TextUtils.isEmpty(responseBeen.get(position).getTeamFlagVisitor())) {
            return 0;
        } else {
            return 1;
        }

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.bluredRel.setVisibility(View.GONE);

        holder.mCustomImageViewTeam1.getHierarchy().setFailureImage(R.drawable.match_defult150);
        holder.mCustomImageViewTeam1.getHierarchy().setPlaceholderImage(R.drawable.match_defult150);

        holder.mCustomImageViewTeam2.getHierarchy().setFailureImage(R.drawable.match_defult150);
        holder.mCustomImageViewTeam2.getHierarchy().setPlaceholderImage(R.drawable.match_defult150);

        ViewUtils.setImageUrl(holder.mCustomImageViewTeam1, responseBeen.get(position).getTeamFlagLocal());
        ViewUtils.setImageUrl(holder.mCustomImageViewTeam2, responseBeen.get(position).getTeamFlagVisitor());

        holder.mCustomTextViewTeam1.setText(responseBeen.get(position).getTeamNameShortLocal());
        holder.mCustomTextViewTeam2.setText(responseBeen.get(position).getTeamNameShortVisitor());

        holder.mCustomTextViewTeam1Fn.setText(responseBeen.get(position).getTeamNameLocal());
        holder.mCustomTextViewTeam2Fn.setText(responseBeen.get(position).getTeamNameVisitor());

        /*String seriesName="";
        if(responseBeen.get(position).getSeriesName().split("\\s+").length>3){
            seriesName= responseBeen.get(position).getSeriesName().substring(0,3);
        }else {
            seriesName= responseBeen.get(position).getSeriesName();
        }*/

        holder.ctv_series_name.setText(responseBeen.get(position).getSeriesName());
        holder.ctv_match_type.setText(responseBeen.get(position).getMatchType());

        if (responseBeen.get(position).getStatus().equalsIgnoreCase("Reviewing")) {
            holder.ctv_timer.setText("Reviewing");
            holder.ctv_timer.setTextColor(mContext.getResources().getColor(R.color.doneIconColor));
        } else if (type.equals("FIXTURE")) {
//            holder.ctv_timer.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_time, 0, 0, 0);
            holder.setTime();
            holder.ctv_timer.setTextColor(mContext.getResources().getColor(R.color.red));

            if (responseBeen.get(position).getIsPlayingXINotificationSent().equals("Yes")) {
                holder.ctv_VS.setText("Playing 11 announced");
                holder.ctv_VS.setVisibility(View.VISIBLE);
            } else {
                holder.ctv_VS.setVisibility(View.GONE);
            }
            // holder.setTimeStatic();

        } else if (type.equals("LIVE")) {
            holder.ctv_timer.setText(AppUtils.getStrFromRes(R.string.in_progress));
            holder.ctv_timer.setTextColor(mContext.getResources().getColor(R.color.doneIconColor));
        } else if (type.equals("COMPLETED")) {

           /* holder.ctv_timer.setText(AppUtils.getStrFromRes(R.string.completed));
            holder.ctv_timer.setTextColor(mContext.getResources().getColor(R.color.doneIconColor));
*/
            holder.ctv_timer.setText(responseBeen.get(position).getStatus());
            if (responseBeen.get(position).getStatus().equals("Completed")) {
                holder.ctv_timer.setTextColor(mContext.getResources().getColor(R.color.doneIconColor));
            } else
                holder.ctv_timer.setTextColor(mContext.getResources().getColor(R.color.red));
        }

        holder.mCardViewMainCard.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));

        if (tag == 0) {
            holder.linout.setVisibility(View.GONE);
        } else {
            holder.linout.setVisibility(View.VISIBLE);
            holder.contest_joined.setText(responseBeen.get(position).getMyTotalJoinedContest()
                    + " " + AppUtils.getStrFromRes(R.string.contest_joined));
        }

        if (responseBeen.get(position).getMatchTypeByApi() != null) {
            holder.ctv_game_type.setVisibility(View.VISIBLE);
            if (responseBeen.get(position).getMatchTypeByApi().equalsIgnoreCase("Real")) {
                holder.ctv_game_type.setText("Real Tournament");
                holder.ctv_game_type.setVisibility(View.GONE);
            } else {
                holder.ctv_game_type.setVisibility(View.VISIBLE);
                holder.ctv_game_type.setText("Virtual Tournament");
            }
        } else {
            holder.ctv_game_type.setVisibility(View.GONE);
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

    public void addAllItem(List<MyContestMatchesOutput.DataBean.RecordsBean> beanList) {
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void addItem(MyContestMatchesOutput.DataBean.RecordsBean bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }

    public long getRemainingTime(int position) {
        return TimeUtils.getTimeDifference(responseBeen.get(position).getMatchStartDateTime(),
                responseBeen.get(position).getCurrentDateTime());
    }

    public MyContestMatchesOutput.DataBean.RecordsBean getMatchItem(int position) {
        return responseBeen.get(position);
    }
   /* public long getRemainingTime(int position) {
        return TimeUtils.getTimeDifference("2019-01-01 09:15:00 09:15 AM",
                "2018-12-29 20:43:13");
    }*/

    /*public String getMatchesId(int position) {
        return responseBeen.get(position).getMatchId();
    }

    public String getMatcheDate(int position) {
        return responseBeen.get(position).getMatchDate();
    }
    public String getMatcheTime(int position) {
        return responseBeen.get(position).getMatchTime();
    }
    public String getMatcheDateTime(int position) {
        return responseBeen.get(position).getMatchDateTime();
    }*/

    public void clearData() {
        responseBeen.clear();
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hi_main_card)
        @Nullable
        CardView mCardViewMainCard;

        @BindView(R.id.iv_team_1)
        @Nullable
        CustomImageView mCustomImageViewTeam1;

        @BindView(R.id.iv_team_2)
        @Nullable
        CustomImageView mCustomImageViewTeam2;

        @BindView(R.id.ctv_game_type)
        RobotoRegularTextView ctv_game_type;

        @BindView(R.id.ctv_name_1)
        RobotoRegularTextView mCustomTextViewTeam1;

        @BindView(R.id.ctv_name_2)
        RobotoRegularTextView mCustomTextViewTeam2;

        @BindView(R.id.ctv_name_1_fn)
        RobotoRegularTextView mCustomTextViewTeam1Fn;

        @BindView(R.id.ctv_name_2_fn)
        RobotoRegularTextView mCustomTextViewTeam2Fn;

        @BindView(R.id.ctv_timer)
        RobotoRegularTextView ctv_timer;

        @BindView(R.id.ctv_VS)
        RobotoRegularTextView ctv_VS;

        @BindView(R.id.contest_joined)
        RobotoRegularTextView contest_joined;

        @BindView(R.id.ctv_series_name)
        RobotoRegularTextView ctv_series_name;

        @BindView(R.id.ctv_match_type)
        RobotoRegularTextView ctv_match_type;

        @BindView(R.id.linout)
        LinearLayout linout;
        CountDownTimer countDownTimer;

        @BindView(R.id.bluredRel)
        RelativeLayout bluredRel;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setTime() {

            try {
                if (countDownTimer != null) countDownTimer.cancel();
                if (ctv_timer != null) {

                    // ctv_timer.setPaintFlags(ctv_timer.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                    if (responseBeen.get(getAdapterPosition()).getStatus().equals(Constant.Pending) &&
                            TimeUtils.isThisDateValid(responseBeen.get(getAdapterPosition()).getMatchStartDateTime(),
                                    "yyyy-MM-dd HH:mm:ss")) {
                        if (TimeUnit.MILLISECONDS.toHours(getRemainingTime(getAdapterPosition())) >
                                Constant.SHOW_TIME_LIMIT_HRS) {
                            ctv_timer.setText(TimeUtils.getRemainingTime(getRemainingTime(getAdapterPosition())));
                        } else {
                            //need to implement counter
                            countDownTimer = new CountDownTimer(getRemainingTime(getAdapterPosition()),
                                    TimeUnit.SECONDS.toMillis(1)) {
                                public void onTick(long millisUntilFinished) {
                                    if (ctv_timer != null)
                                        ctv_timer.setText(TimeUtils.getRemainsTime(millisUntilFinished));
                                }

                                public void onFinish() {
                                    if (ctv_timer != null)
                                        if (responseBeen.get(getAdapterPosition()).getMatchDate() != null) {
                                            ctv_timer.setText(AppUtils.getStrFromRes(R.string.Zero_s));
                                          /*  ctv_timer.setText(TimeUtils.getDisplayFullDate1(
                                                    responseBeen.get(getAdapterPosition()).getMatchDate(),
                                                    responseBeen.get(getAdapterPosition()).getMatchTime()));*/
                                        }
                                }
                            };
                            if (countDownTimer != null) {
                                countDownTimer.start();
                            }
                        }
                    } else {
                        ctv_timer.setText(TimeUtils.getMatchDateOnly(responseBeen.get(getAdapterPosition()).getMatchDate()));
                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                ctv_timer.setText("N/A");
            }

        }

        /*public void setTimeStatic() {

            try {
                if (countDownTimer != null) countDownTimer.cancel();
                if (ctv_timer != null) {

                    // ctv_timer.setPaintFlags(ctv_timer.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                    if (
                            TimeUtils.isThisDateValid("2019-01-01 09:15:00 09:15 AM",
                                    "yyyy-MM-dd HH:mm:ss")) {
                        if (TimeUnit.MILLISECONDS.toHours(getRemainingTime(getAdapterPosition())) >
                                Constant.SHOW_TIME_LIMIT_HRS) {
                            ctv_timer.setText(TimeUtils.getMatchDateOnly("2019-01-01"));
                        } else {
                            //need to implement counter
                            countDownTimer = new CountDownTimer(getRemainingTime(getAdapterPosition()),
                                    TimeUnit.SECONDS.toMillis(1)) {
                                public void onTick(long millisUntilFinished) {
                                    if (ctv_timer != null)
                                        ctv_timer.setText(TimeUtils.getRemainsTime(millisUntilFinished));
                                }

                                public void onFinish() {
                                    if (ctv_timer != null)
                                        if ("2019-01-01" != null) {
                                            ctv_timer.setText(TimeUtils.getDisplayFullDate1(
                                                    "2019-01-01",
                                                    "09:15:00"));
                                        }
                                }
                            };
                            if (countDownTimer != null) {
                                countDownTimer.start();
                            }
                        }
                    } else {
                        ctv_timer.setText(TimeUtils.getMatchDateOnly("2019-01-01"));
                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                ctv_timer.setText("N/A");
            }

        }*/
    }
}
