package com.mw.eleven11.UI.filter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.ResponseFilter;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 */

public class BottomFilterAdapter extends RecyclerView.Adapter<BottomFilterAdapter.MyViewHolder> {

    OnItemClickListener.OnItemClickCallback onItemClickCallback;
    int layoutId = 0;
    private List<ResponseFilter.Bean> responseBeen = new ArrayList<>();
    private Context mContext;
    private int mPosition = -1;

    public BottomFilterAdapter(int layoutId, Context mContext, List<ResponseFilter.Bean> responseBeen,
                               OnItemClickListener.OnItemClickCallback onItemClickCallback) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public BottomFilterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BottomFilterAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if (holder.ctvTitle != null)
            holder.ctvTitle.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));
        holder.setTitle();

    }

    public ResponseFilter.Bean getItemData(int position) {
        if (responseBeen == null) return null;
        return responseBeen.get(position);
    }

    public void addItem(ResponseFilter.Bean bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }

    public void addAllItem(List<ResponseFilter.Bean> beanList) {
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void selectSingleItem(int position) {

        if (responseBeen == null) return;
        for (int i = 0; i < responseBeen.size(); i++) {
            responseBeen.get(i).setSelected(false);
        }
        if (position == mPosition){
            mPosition =-1;
            responseBeen.get(position).setSelected(false);
        }else {
            mPosition = position;
            responseBeen.get(position).setSelected(true);
        }

        notifyDataSetChanged();

    }

    public void selectMultiItem(int position) {
        if (responseBeen == null) return;
        responseBeen.get(position).setSelected(!responseBeen.get(position).isSelected());
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

        @BindView(R.id.ctv_title)
        @Nullable
        TextView ctvTitle;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setTitle() {
            if (ctvTitle == null) return;
            ctvTitle.setText(responseBeen.get(getAdapterPosition()).getTitle());
            if (responseBeen.get(getAdapterPosition()).isSelected()) {
                ctvTitle.setBackground(mContext.getResources().getDrawable(R.drawable.border_green_bg_white));
            } else {
                ctvTitle.setBackground(mContext.getResources().getDrawable(R.drawable.filter_round_border));
            }
        }
    }
}
