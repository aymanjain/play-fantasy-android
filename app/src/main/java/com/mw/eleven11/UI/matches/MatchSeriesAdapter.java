package com.mw.eleven11.UI.matches;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.SeriesOutput;
import com.mw.eleven11.customView.CustomCheckBox;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MatchSeriesAdapter extends RecyclerView.Adapter<MatchSeriesAdapter.MyViewHolder> {

    private List<SeriesOutput.DataBean.RecordsBean> responseBeen = new ArrayList<>();
    private Context mContext;
    OnItemClickListener.OnItemClickCallback onItemClickCallback;
    int layoutId = 0;

    private List<SeriesOutput.DataBean.RecordsBean> selectedSeries = new ArrayList<>();

    public MatchSeriesAdapter(Context mContext, int layoutId,
                              List<SeriesOutput.DataBean.RecordsBean> responseBeen, OnItemClickListener.OnItemClickCallback onItemClickCallback
    ) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.onItemClickCallback = onItemClickCallback;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_series, parent, false));

    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        holder.seriesName.setText(responseBeen.get(position).getSeriesName());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    selectedSeries.add(responseBeen.get(position));
                } else {
                    selectedSeries.remove(responseBeen.get(position));
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return responseBeen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.hi_main_card)
        @Nullable
        LinearLayout mCardViewMainCard;


        @BindView(R.id.seriesName)
        CustomTextView seriesName;

        @BindView(R.id.checkBox)
        CustomCheckBox checkBox;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }

    public void clear() {
        if (responseBeen == null) return;
        responseBeen.clear();
        selectedSeries.clear();
        notifyDataSetChanged();
    }

    public void addAllItem(List<SeriesOutput.DataBean.RecordsBean> beanList) {
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void addItem(SeriesOutput.DataBean.RecordsBean bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }

    public String getSelectedItem() {

        String seriesId = "";

        for (int i = 0; i < selectedSeries.size(); i++) {

            if (seriesId.length() == 0) {
                seriesId = selectedSeries.get(i).getSeriesGUID();
            } else {
                seriesId = seriesId + "," + selectedSeries.get(i).getSeriesGUID();

            }
        }


        return seriesId;
    }

    public void resetItems() {

        String seriesId = "";
        selectedSeries.clear();


    }
}
