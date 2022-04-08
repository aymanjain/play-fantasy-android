package com.mw.eleven11.UI.addMoney;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.PromoCodeListOutput;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PromoListAdapter extends RecyclerView.Adapter<PromoListAdapter.MyViewHolder> {


    private final OnItemClickListener.OnItemClickCallback applyCouponCallBack;
    private List<PromoCodeListOutput.DataBean.RecordsBean> responseBeen = new ArrayList<>();
    private Context mContext;
    int layoutId = 0;

    public PromoListAdapter( int layoutId, Context mContext, List<PromoCodeListOutput.DataBean.RecordsBean> responseBeen,
                             OnItemClickListener.OnItemClickCallback onWinnerClickCallBack) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.applyCouponCallBack = onWinnerClickCallBack;
    }


    @Override
    public PromoListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new PromoListAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.promo_list_items, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        if (responseBeen.get(i).getCouponType().equals("Flat")) {
            holder.coupon_title.setText(Html.fromHtml("<b>" + "Get " + responseBeen.get(i).getCouponType() + " Rs."+responseBeen.get(i).getCouponValue() + " bonus" + "</b>"));
        }else {
            holder.coupon_title.setText(Html.fromHtml("<b>" + "Get " +responseBeen.get(i).getCouponValue() + "% bonus" +  "</b>"));

        }

        holder.coupon_type.setText("Deposit between Rs."+ responseBeen.get(i).getMiniumAmount() + " to Rs." +responseBeen.get(i).getMaximumAmount());

        holder.coupon_code.setText(Html.fromHtml("CouponCode : " + "<b>" + responseBeen.get(i).getCouponCode() + "</b> "));

        if (responseBeen.get(i).getNumberOfUses().equals("")) {
            holder.coupon_use.setText("You can use this coupon unlimited times" );
        }else {
            holder.coupon_use.setText("You can use this coupon " + responseBeen.get(i).getNumberOfUses() + " times" );
        }

        holder.coupon_expire_date.setText("CouponValidTillDate : " + responseBeen.get(i).getCouponValidTillDate());

    }

    @Override
    public int getItemCount() {
        return responseBeen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            applypromo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    applyCouponCallBack.onItemClicked(v,getAdapterPosition());
                }
            });
        }

        @BindView(R.id.coupon_title)
        CustomTextView coupon_title;

        @BindView(R.id.coupon_type)
        CustomTextView coupon_type;

        @BindView(R.id.coupon_code)
        CustomTextView coupon_code;

        @BindView(R.id.coupon_use)
        CustomTextView coupon_use;

        @BindView(R.id.applypromo)
        CustomTextView applypromo;

        @BindView(R.id.coupon_expire_date)
        CustomTextView coupon_expire_date;
    }


    public void addAllItem(List<PromoCodeListOutput.DataBean.RecordsBean> beanList) {
        if (beanList == null || responseBeen == null) return;
        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public void addItem(PromoCodeListOutput.DataBean.RecordsBean bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }
}
