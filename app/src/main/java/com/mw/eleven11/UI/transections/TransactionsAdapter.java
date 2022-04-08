package com.mw.eleven11.UI.transections;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.TransactionsBean;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;


/**
 * Created by pintu kumar patil on 22-09-2017.
 */

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.MyViewHolder> {

    private List<TransactionsBean.DataBean.RecordsBean> responseBeen = new ArrayList<>();
    private Context mContext;
    OnItemClickListener.OnItemClickCallback onItemClickCallback, onEditItemClickCallback, onDeleteItemClickCallback;
    int layoutId = 0;
    String type;

    public TransactionsAdapter(String type, int layoutId, Context mContext, List<TransactionsBean.DataBean.RecordsBean> responseBeen,
                               OnItemClickListener.OnItemClickCallback onItemClickCallback,
                               OnItemClickListener.OnItemClickCallback onEditItemClickCallback,
                               OnItemClickListener.OnItemClickCallback onDeleteItemClickCallback) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.type = type;
        this.onItemClickCallback = onItemClickCallback;
        this.onEditItemClickCallback = onEditItemClickCallback;
        this.onDeleteItemClickCallback = onDeleteItemClickCallback;
    }

    @Override
    public TransactionsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = 0;

        switch (viewType) {
            case 0://for todays notification tag line
                layout = R.layout.list_item_transaction_tag;
                break;
            case 1://for older notification tag line
                layout = R.layout.list_item_transaction;
                break;
            default://for old notification found
                layout = R.layout.list_item_transaction;
                break;
        }

        return new TransactionsAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        if (getItemViewType(position) == 0) {
            if (holder.ctvTime != null)
                //holder.ctvTime.setText(TimeUtils.getTransactionDateOnly(responseBeen.get(position).getEntryDate()));
                holder.ctvTime.setText(responseBeen.get(position).getEntryDate());

        } else {
            holder.ctvStstus.setText(responseBeen.get(position).getStatus());
            switch (responseBeen.get(position).getStatus()) {
                case "Completed":
                    holder.ctvStstus.setTextColor(mContext.getResources().getColor(R.color.green));
                    break;
                case "Failed":
                    holder.ctvStstus.setTextColor(mContext.getResources().getColor(R.color.nav_icon));
                    break;
                case "Pending":
                    holder.ctvStstus.setTextColor(mContext.getResources().getColor(R.color.yellow));
                    break;
                case "Processing":
                    holder.ctvStstus.setTextColor(mContext.getResources().getColor(R.color.yellow));
                    break;
                default:
                    holder.ctvStstus.setTextColor(mContext.getResources().getColor(R.color.black));
                    break;

            }
            if (holder.ctvTransactionId != null) {
                if (responseBeen.get(position).getTransactionID().equals("0")) {
                    holder.ctvTransactionId.setText("N/A");
                } else {
                    holder.ctvTransactionId.setText(responseBeen.get(position).getTransactionID());
                }
            }
            if (holder.ctvTime != null)
                // holder.ctvTime.setText(TimeUtils.getTransactionFormat(responseBeen.get(position).getEntryDate()));
                holder.ctvTime.setText(responseBeen.get(position).getEntryDate());

            if (holder.ctvAmount != null) {
                if (responseBeen.get(position).getTransactionType().equals("Cr")) {
                    holder.ctvAmount.setTextColor(mContext.getResources().getColor(R.color.green));
                    holder.ctvMessage.setTextColor(mContext.getResources().getColor(R.color.green));
                    holder.ctvAmount.setText("+ " + AppUtils.getStrFromRes(R.string.price_unit) + " " + responseBeen.get(position).getAmount());
                } else {
                    holder.ctvAmount.setTextColor(mContext.getResources().getColor(R.color.nav_icon));
                    holder.ctvMessage.setTextColor(mContext.getResources().getColor(R.color.nav_icon));
                    holder.ctvAmount.setText("- " + AppUtils.getStrFromRes(R.string.price_unit) + " " + responseBeen.get(position).getAmount());
                }
            }

            if (holder.ctvMessage != null)
                holder.ctvMessage.setText(responseBeen.get(position).getNarration());


            if (holder.ctvDetailValue != null && holder.ctvDetail != null && holder.llBottomDetails != null) {
              /*  switch (responseBeen.get(position).getPayType()) {
                    case "JOINCONTEST":
                        holder.ctvDetail.setText(AppUtils.getStrFromRes(R.string.team_name));
                        holder.ctvDetailValue.setText(responseBeen.get(position).getTeamName());
                        holder.llBottomDetails.setVisibility(View.VISIBLE);
                        break;
                    case "REFUND":
                        holder.ctvDetail.setText(AppUtils.getStrFromRes(R.string.team_name));
                        holder.ctvDetailValue.setText(responseBeen.get(position).getTeamName());
                        holder.llBottomDetails.setVisibility(View.VISIBLE);
                        break;
                    default:
                        holder.llBottomDetails.setVisibility(View.GONE);*/


            }
        }


        if (holder.ll_details != null) {
            if (responseBeen.get(position).isShow()) {
                holder.ll_details.setVisibility(View.VISIBLE);
                //holder.ctvInfo.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.filter_up_arrow,0);
                holder.ctvInfo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_info, 0);
            } else {
                //holder.ctvInfo.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.filter_arrow_down,0);
                holder.ctvInfo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_info, 0);
                holder.ll_details.setVisibility(View.GONE);
            }
        }

        if (holder.mCardViewMainCard != null)
            holder.mCardViewMainCard.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));
    }


    @Override
    public int getItemViewType(int position) {
        if (responseBeen == null) return 0;
        return 3;
    }

    public TransactionsBean.DataBean.RecordsBean getItemData(int position) {
        if (responseBeen == null) return null;
        return responseBeen.get(position);
    }

    public void addItem(TransactionsBean.DataBean.RecordsBean bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }

    public void addDateView(String date) {
        TransactionsBean.DataBean.RecordsBean bean = new TransactionsBean.DataBean.RecordsBean();
       /* bean.setViewType(0);
        bean.setDatetime(date);*/
        addItem(bean);
    }

    public void addAllItem(List<TransactionsBean.DataBean.RecordsBean> beanList) {
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
           /* if (!isDateExist(beanList.get(i).getDatetime())){
                addDateView(beanList.get(i).getDatetime());
            }*/
            addItem(beanList.get(i));
        }
    }

    public boolean isDateExist(String date) {
        if (responseBeen == null) return false;
        for (int i = 0; i < responseBeen.size(); i++) {
          /* if (TimeUtils.isSameDay(date,responseBeen.get(i).getDatetime())){
               return true;
           }*/
        }
        return false;
    }

    public void toggle(int position) {
        responseBeen.get(position).setShow(!responseBeen.get(position).isShow());
        notifyItemChanged(position);
    }

    public void show(int position) {
        if (responseBeen == null) return;
        for (int i = 0; i < responseBeen.size(); i++) {
            responseBeen.get(i).setShow(false);
        }
        responseBeen.get(position).setShow(true);
        notifyDataSetChanged();
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

        @BindView(R.id.hi_main_card)
        @Nullable
        CardView mCardViewMainCard;

        @BindView(R.id.ll_details)
        @Nullable
        LinearLayout ll_details;


        @BindView(R.id.llBottomDetails)
        @Nullable
        LinearLayout llBottomDetails;


        @BindView(R.id.ctv_transaction_id)
        @Nullable
        CustomTextView ctvTransactionId;

        @BindView(R.id.ctv_amount)
        @Nullable
        CustomTextView ctvAmount;

        @BindView(R.id.ctv_info)
        @Nullable
        CustomTextView ctvInfo;

        @BindView(R.id.ctv_detail)
        @Nullable
        CustomTextView ctvDetail;

        @BindView(R.id.ctv_detail_value)
        @Nullable
        CustomTextView ctvDetailValue;

        @BindView(R.id.ctv_time)
        @Nullable
        CustomTextView ctvTime;

        @BindView(R.id.ctv_status)
        @Nullable
        CustomTextView ctvStstus;

        @BindView(R.id.ctv_message)
        @Nullable
        CustomTextView ctvMessage;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Optional
        @OnClick(R.id.hi_main_card)
        void option(View view) {
            onDeleteItemClickCallback.onItemClicked(view, getAdapterPosition());
        }

        @Optional
        @OnClick(R.id.rl_info)
        void info(View view) {
            if (responseBeen == null) return;
            if (responseBeen.get(getAdapterPosition()).isShow()) {
                toggle(getAdapterPosition());
            } else {
                show(getAdapterPosition());
            }
        }
    }
}
