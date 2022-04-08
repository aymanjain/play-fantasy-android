package com.mw.eleven11.UI.withdrawAmount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.ServiceWrapper;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.WithdrawInput;
import com.mw.eleven11.beanOutput.PaytmWithdrawOutput;
import com.mw.eleven11.customView.CustomPinView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.Constant;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaytmWithdrawOtp extends BaseActivity {

    @BindView(R.id.pinView)
    CustomPinView pinView;
    @BindView(R.id.ctv_enterOTP)
    CustomTextView ctv_enterOTP;
    @BindView(R.id.ctv_checkForOTP)
    CustomTextView ctv_checkForOTP;
    private String mMobile ="";
    private Integer withdrawalID;
    private String amount = "";
    String otp = "";


    @OnClick(R.id.ctv_confirm_code)
    public void confirmCode(View view) {

        otp = pinView.getText().toString();
        String deviceType = Constant.DEVICE_TYPE;

        submitOtp();
    }

    private void submitOtp() {
        WithdrawInput withdrawInput= new WithdrawInput();
        withdrawInput.setWithdrawalID(withdrawalID);
        withdrawInput.setOTP(otp);
        withdrawInput.setPaymentGateway(Constant.PAYTM);
        withdrawInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        withdrawInput.setPaytmPhoneNumber(mMobile);
        withdrawInput.setAmount(Integer.parseInt(amount));
        Call<PaytmWithdrawOutput> call = ServiceWrapper.getInstance().withdrawal_confirm(withdrawInput);
        call.enqueue(new Callback<PaytmWithdrawOutput>() {
            @Override
            public void onResponse(Call<PaytmWithdrawOutput> call, Response<PaytmWithdrawOutput> response) {
                if (response.isSuccessful()){

                    if (response.body().getData().getPaytmResponse().getStatus().equals("SUCCESS")) {
                        Toast.makeText(PaytmWithdrawOtp.this, "Success", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(PaytmWithdrawOtp.this, "Try again later", Toast.LENGTH_SHORT).show();
                    }

                    finish();
                }
            }

            @Override
            public void onFailure(Call<PaytmWithdrawOutput> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(PaytmWithdrawOtp.this, "Try again later", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void start(Context context, String mobile, Integer withdrawalID, String amount) {
        Intent starter = new Intent(context, PaytmWithdrawOtp.class);
        starter.putExtra("mobile", mobile);
        starter.putExtra("withdrawalID", withdrawalID);
        starter.putExtra("amount", amount);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }


    @Override
    public int getLayout() {
        return R.layout.activity_paytm_withdraw_otp;
    }

    @Override
    public void init() {

        ctv_enterOTP.setVisibility(View.VISIBLE);
        ctv_checkForOTP.setVisibility(View.VISIBLE);
        ctv_enterOTP.setText(getResources().getString(R.string.enter_mobile_OTP));
        ctv_checkForOTP.setText(getResources().getString(R.string.check_inbox));

        if (getIntent()!=null){
            if (getIntent().hasExtra("mobile")){
                mMobile = getIntent().getStringExtra("mobile");
            }
            if (getIntent().hasExtra("withdrawalID")){
                withdrawalID = getIntent().getIntExtra("withdrawalID",0);
            }
            if (getIntent().hasExtra("amount")){
                amount = getIntent().getStringExtra("amount");
            }
        }


    }
}
