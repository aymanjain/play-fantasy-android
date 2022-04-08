package com.mw.eleven11.UI.winnerNumberSelection;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.WinBreakupOutPut;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 */

public class WinBreakupNumberAdapter extends RecyclerView.Adapter<WinBreakupNumberAdapter.MyViewHolder> {

    List<WinBreakupOutPut.DataBean.WinnersBean> responseBeen = new ArrayList<>();
    OnItemClickListener.OnItemClickCallback onItemClickCallback;
    int layoutId = 0;
    private Context mContext;

    public WinBreakupNumberAdapter(int layoutId, Context mContext, List<WinBreakupOutPut.DataBean.WinnersBean> responseBeen,
                                   OnItemClickListener.OnItemClickCallback onItemClickCallback) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public WinBreakupNumberAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WinBreakupNumberAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId,
                parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if (holder.ctvRank != null)
            //  holder.ctvRank.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));
            holder.setTitle();
        holder.setPay();
        holder.setAmmountInPercentage();

    }

    public WinBreakupOutPut.DataBean.WinnersBean getItemData(int position) {
        if (responseBeen == null) return null;
        return responseBeen.get(position);
    }

    public void addItem(WinBreakupOutPut.DataBean.WinnersBean bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }

    public void addAllItem(List<WinBreakupOutPut.DataBean.WinnersBean> beanList) {
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

        @BindView(R.id.ctv_rank)
        @Nullable
        TextView ctvRank;

        @BindView(R.id.ctv_pay)
        @Nullable
        TextView ctvPay;

        @BindView(R.id.amountPercentage)
        @Nullable
        TextView amountPercentage;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setTitle() {
            if (ctvRank == null) return;
            ctvRank.setText(AppUtils.getStrFromRes(R.string.rank) + ": " + responseBeen.get(getAdapterPosition()).getRank());
        }

        private void setPay() {
            if (ctvPay == null) return;
            ctvPay.setText(AppUtils.getStrFromRes(R.string.price_unit) + "" + responseBeen.get(getAdapterPosition()).getWinningAmount());
        }

        private void setAmmountInPercentage() {
            if (amountPercentage == null) return;
            amountPercentage.setText(responseBeen.get(getAdapterPosition()).getPercent() + "%");
        }
    }
}
