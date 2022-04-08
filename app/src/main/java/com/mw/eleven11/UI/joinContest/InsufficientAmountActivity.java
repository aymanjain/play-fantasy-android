package com.mw.eleven11.UI.joinContest;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.addMoney.AddMoneyActivity;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class InsufficientAmountActivity extends BaseActivity {


    String walletBalance = "";
    String joinAmt = "";
    String matchId = "";
    String statusId = "";
    String remainingAmt = "";
    Context mContext;

    @BindView(R.id.addMoney)
    CustomTextView addMoney;

    @BindView(R.id.contestfee)
    CustomTextView contestfee;

    @BindView(R.id.walletBal)
    CustomTextView walletBal;

    @OnClick(R.id.iv_cross)
    public void cross(View view) {
        finish();
    }

    @OnClick(R.id.add)
    void onAddMoneyClick(){
        AddMoneyActivity.start(mContext,matchId,statusId);
        finish();
    }

    public static void start(Context context, String walletAmt , String joiningAmt, String matchId , String statusId , String remainingAmt) {
        Intent starter = new Intent(context, InsufficientAmountActivity.class);
        starter.putExtra("walletAmt",walletAmt);
        starter.putExtra("joiningAmt",joiningAmt);
        starter.putExtra("matchId",matchId);
        starter.putExtra("statusId",statusId);
        starter.putExtra("remainingAmt",remainingAmt);
        context.startActivity(starter);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_insufficient_amount;
    }

    @Override
    public void init() {

        mContext = this;
        if (getIntent() != null) {
            walletBalance = getIntent().getStringExtra("walletAmt");
            joinAmt = getIntent().getStringExtra("joiningAmt");
            matchId = getIntent().getStringExtra("matchId");
            statusId = getIntent().getStringExtra("statusId");
            remainingAmt = getIntent().getStringExtra("remainingAmt");
        }

        walletBal.setText(AppUtils.getStrFromRes(R.string.price_unit) + walletBalance);
        contestfee.setText(AppUtils.getStrFromRes(R.string.price_unit) + joinAmt);

//        Float addAmt = Float.parseFloat(joinAmt)- Float.parseFloat(walletBalance);

        addMoney.setText(AppUtils.getStrFromRes(R.string.price_unit) + remainingAmt);



    }


    @Override
    protected void onResume() {
        super.onResume();

    }
}
