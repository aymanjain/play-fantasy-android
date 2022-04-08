package com.mw.eleven11.UI.stockTrade.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.stockTrade.activity.StockMatchesActivity;

import java.util.ArrayList;

public class StockTradeAdapter extends RecyclerView.Adapter<StockTradeAdapter.ViewHolder> {

    private ArrayList<String> mData;
    private Context context;
    private LayoutInflater layoutInflater;


    public StockTradeAdapter(ArrayList<String> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_list_item_matches, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.gameName.setText(mData.get(position));
        holder.playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, StockMatchesActivity.class);
                context.startActivity(intent);
            }
        });


    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView gameName;
        CardView playBtn;

        public ViewHolder(View view) {
            super(view);
            gameName = view.findViewById(R.id.tvHeader);
            playBtn = view.findViewById(R.id.cvPlay);

        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
