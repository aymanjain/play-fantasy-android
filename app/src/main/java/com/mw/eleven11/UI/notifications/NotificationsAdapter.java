package com.mw.eleven11.UI.notifications;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.NotificationsResponse;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 */

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.MyViewHolder> {

    OnItemClickListener.OnItemClickCallback onItemClickCallback, onCheckBoxClickCallback;
    int layoutId = 0;
    private List<NotificationsResponse.DataBean.RecordsBean> responseBeen = new ArrayList<>();
    private Context mContext;
    int flag = 0;
    int count = 0;
    boolean isSelected = false;
    private List<String> list = new ArrayList<>();

    public NotificationsAdapter(int layoutId, Context mContext, List<NotificationsResponse.DataBean.RecordsBean> responseBeen,
                                OnItemClickListener.OnItemClickCallback onItemClickCallback,
                                OnItemClickListener.OnItemClickCallback onCheckBoxClickCallback, int flag) {
        this.responseBeen = responseBeen;
        this.layoutId = layoutId;
        this.mContext = mContext;
        this.onItemClickCallback = onItemClickCallback;
        this.onCheckBoxClickCallback = onCheckBoxClickCallback;
        this.flag = flag;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = R.layout.list_item_notifications;
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if (holder.mCardViewMainCard != null)
            holder.mCardViewMainCard.setOnClickListener(new OnItemClickListener(position, onItemClickCallback));

        holder.ctvMessage.setText(responseBeen.get(position).getNotificationText());
        holder.ctvDate.setText(responseBeen.get(position).getEntryDate());

        if (responseBeen.get(position).getStatusID().equals("2")) {
            holder.mCardViewMainCard.setBackgroundColor(mContext.getResources().getColor(R.color.divider_color));
            holder.ivLogo.setImageResource(R.drawable.ic_message_grey);
        } else {
            holder.mCardViewMainCard.setBackgroundColor(mContext.getResources().getColor(R.color.white));
            holder.ivLogo.setImageResource(R.drawable.ic_message);
        }


        selectCheckbox(holder ,position);


        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (responseBeen.get(position).isSelected()) {
                    responseBeen.get(position).setSelected(false);
                    if (list.contains(responseBeen.get(position).getNotificationID())){
                        list.remove(responseBeen.get(position).getNotificationID());
                    }
                }else{
                    responseBeen.get(position).setSelected(true);
                    if (!list.contains(responseBeen.get(position).getNotificationID())) {
                        list.add(responseBeen.get(position).getNotificationID());
                    }
                }
            }
        });
    }

    private void selectCheckbox(MyViewHolder holder, int position) {
        if (flag == 1) {
            holder.checkBox.setVisibility(View.VISIBLE);
            if (responseBeen.get(position).isSelected()){
                holder.checkBox.setChecked(true);
                 if (!list.contains(responseBeen.get(position).getNotificationID())) {
                    list.add(responseBeen.get(position).getNotificationID());
                }
            }else {
                holder.checkBox.setChecked(false);
             if (list.contains(responseBeen.get(position).getNotificationID())){
                    list.remove(responseBeen.get(position).getNotificationID());
                }
            }
        } else if (flag == 2) {
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.checkBox.setChecked(true);
              if (!list.contains(responseBeen.get(position).getNotificationID())) {
                    list.add(responseBeen.get(position).getNotificationID());
                }
        } else if (flag == 0){
            holder.checkBox.setVisibility(View.GONE);
        }else {
            holder.checkBox.setChecked(false);
            if (list.contains(responseBeen.get(position).getNotificationID())){
                list.remove(responseBeen.get(position).getNotificationID());
            }
        }
    }

    public List<String> countSelectedCheckedbox(){
        return list;
    }

    public NotificationsResponse.DataBean.RecordsBean getItemData(int position) {
        if (responseBeen == null) return null;
        return responseBeen.get(position);
    }

    public void addItem(NotificationsResponse.DataBean.RecordsBean bean) {
        if (bean == null || responseBeen == null) return;
        responseBeen.add(bean);
        notifyItemInserted(responseBeen.size() - 1);
    }

    public void addAllItem(List<NotificationsResponse.DataBean.RecordsBean> beanList) {
        if (beanList == null || responseBeen == null) return;

        for (int i = 0; i < beanList.size(); i++) {
            addItem(beanList.get(i));
        }
    }

    public String getMessage(int position) {
        if (responseBeen == null) return "";
        return responseBeen.get(position).getNotificationMessage();
    }

    public void clear() {
        if (responseBeen == null) return;
        responseBeen.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (responseBeen == null) return 0;
        return 0;
    }

    public String getNotificationID(int position) {
        if (responseBeen == null) return "";
        return responseBeen.get(position).getNotificationID();
    }

    @Override
    public int getItemCount() {
        return responseBeen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.hi_main_card)
        @Nullable
        CardView mCardViewMainCard;

        @BindView(R.id.ctvDate)
        @Nullable
        CustomTextView ctvDate;

        @BindView(R.id.ctvMessage)
        @Nullable
        CustomTextView ctvMessage;

        @BindView(R.id.ivLogo)
        @Nullable
        ImageView ivLogo;

        @BindView(R.id.checkbox)
        CheckBox checkBox;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }

}
