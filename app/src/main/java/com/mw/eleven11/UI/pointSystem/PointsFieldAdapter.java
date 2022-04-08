package com.mw.eleven11.UI.pointSystem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.PointsList;
import com.mw.eleven11.customView.CustomTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 */

public class PointsFieldAdapter extends RecyclerView.Adapter<PointsFieldAdapter.MyViewHolder> {

    private final String type;
    private List<PointsList.PointsData.AllCricketPoints> responseBeen = new ArrayList<>();
    private Context mContext;
    int layoutId = 0;

    public PointsFieldAdapter(Context mContext, String type) {
        this.mContext = mContext;
        this.type = type;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_points, parent, false));

    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        RecyclerView.LayoutParams param = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
        if (type.equalsIgnoreCase("PointsT10") && responseBeen.get(position).getPointsT10().equalsIgnoreCase("0.0") ||
                type.equalsIgnoreCase("PointsT20") && responseBeen.get(position).getPointsT20().equalsIgnoreCase("0.0") ||
                type.equalsIgnoreCase("PointsODI") && responseBeen.get(position).getPointsODI().equalsIgnoreCase("0.0") ||
                type.equalsIgnoreCase("PointsTEST") && responseBeen.get(position).getPointsTEST().equalsIgnoreCase("0.0")
        ) {
            param.height = 0;
            param.width = 0;
            holder.itemView.setVisibility(View.GONE);

        } else {
            param.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            param.width = LinearLayout.LayoutParams.MATCH_PARENT;
            holder.itemView.setVisibility(View.VISIBLE);

        }
        holder.itemView.setLayoutParams(param);
        if (type.equalsIgnoreCase("PointsT10")) {


            if (responseBeen.get(position).getPointsT10().equalsIgnoreCase("0.0")) {
                holder.itemView.setVisibility(View.GONE);
            } else {
                holder.itemView.setVisibility(View.VISIBLE);
                if (responseBeen.get(position).getPointsT10().contains("-")) {
                    holder.player_point.setText(responseBeen.get(position).getPointsT10());
                    holder.player_point.setTextColor(mContext.getResources().getColor(R.color.red));
                } else {
                    holder.player_point.setText("+" + responseBeen.get(position).getPointsT10());
                    holder.player_point.setTextColor(mContext.getResources().getColor(R.color.green));
                }
            }


        } else if (type.equalsIgnoreCase("PointsT20")) {


            if (responseBeen.get(position).getPointsT20().equalsIgnoreCase("0.0")) {
                holder.itemView.setVisibility(View.GONE);
            } else {
                holder.itemView.setVisibility(View.VISIBLE);
                if (responseBeen.get(position).getPointsT20().contains("-")) {
                    holder.player_point.setText(responseBeen.get(position).getPointsT20());
                    holder.player_point.setTextColor(mContext.getResources().getColor(R.color.red));
                } else {
                    holder.player_point.setText("+" + responseBeen.get(position).getPointsT20());
                    holder.player_point.setTextColor(mContext.getResources().getColor(R.color.green));
                }
            }


        } else if (type.equalsIgnoreCase("PointsODI")) {
            if (responseBeen.get(position).getPointsODI().equalsIgnoreCase("0.0")) {
                holder.itemView.setVisibility(View.GONE);
            } else {
                holder.itemView.setVisibility(View.VISIBLE);

                if (responseBeen.get(position).getPointsODI().contains("-")) {
                    holder.player_point.setText(responseBeen.get(position).getPointsODI());
                    holder.player_point.setTextColor(mContext.getResources().getColor(R.color.red));
                } else {
                    holder.player_point.setText("+" + responseBeen.get(position).getPointsODI());
                    holder.player_point.setTextColor(mContext.getResources().getColor(R.color.green));
                }
            }


        } else if (type.equalsIgnoreCase("PointsTEST")) {
            if (responseBeen.get(position).getPointsTEST().equalsIgnoreCase("0.0")
                    || responseBeen.get(position).getPointsTypeDescprition().length() > 50) {
                holder.itemView.setVisibility(View.GONE);
            } else {
                holder.itemView.setVisibility(View.VISIBLE);

                if (responseBeen.get(position).getPointsTEST().contains("-")) {
                    holder.player_point.setText(responseBeen.get(position).getPointsTEST());
                    holder.player_point.setTextColor(mContext.getResources().getColor(R.color.red));
                } else {
                    holder.player_point.setText("+" + responseBeen.get(position).getPointsTEST());
                    holder.player_point.setTextColor(mContext.getResources().getColor(R.color.green));
                }
            }

        }
        holder.player_type.setText(responseBeen.get(position).getPointsTypeDescprition());


    }


    @Override
    public int getItemCount() {

        return responseBeen.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.player_type)
        CustomTextView player_type;


        @BindView(R.id.player_point)
        CustomTextView player_point;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }

    public void clear() {
        if (responseBeen == null) return;
        responseBeen.clear();
        notifyDataSetChanged();
    }

    public void addAllItem(List<PointsList.PointsData.AllCricketPoints> beanList) {
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void addItem(PointsList.PointsData.AllCricketPoints bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }


    public PointsList.PointsData.AllCricketPoints getMatchItem(int position) {
        return responseBeen.get(position);
    }

    public void clearData() {
        responseBeen.clear();
        notifyDataSetChanged();
    }


}
