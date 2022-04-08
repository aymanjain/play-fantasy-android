package com.mw.eleven11.UI.stockTrade.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mw.eleven11.R;

import java.util.ArrayList;

public class PrizeBreakupAdapter extends RecyclerView.Adapter<PrizeBreakupAdapter.ViewHolder> {

    private ArrayList<String> mData;
    private Context context;
    private LayoutInflater layoutInflater;


    public PrizeBreakupAdapter(ArrayList<String> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView gameName;

        public ViewHolder(View view) {
            super(view);
            gameName =  view.findViewById(R.id.tvRank1);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.prize_list_item_matches, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.gameName.setText(mData.get(position));



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
