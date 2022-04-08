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
import com.mw.eleven11.UI.stockTrade.activity.PrizeBreakupActivity;
import com.mw.eleven11.UI.stockTrade.activity.StockTeamActivity;

import java.util.ArrayList;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private ArrayList<String> mData;
    private Context context;
    private LayoutInflater layoutInflater;


    public MatchesAdapter(ArrayList<String> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView gameName;
        CardView prizeBreakup, join;

        public ViewHolder(View view) {
            super(view);
            gameName = view.findViewById(R.id.tvHeader);
            prizeBreakup = view.findViewById(R.id.cvPrize);
            join = view.findViewById(R.id.cvJoin);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_metches_list_item_matches, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.gameName.setText(mData.get(position));
        holder.prizeBreakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PrizeBreakupActivity.class);
                context.startActivity(intent);
            }
        });
        holder.join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, StockTeamActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
