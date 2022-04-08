package com.mw.eleven11.UI.loginRagisterModule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.startup.StartupActivity;
import com.mw.eleven11.UI.verifyOtp.VerifyOTPActivity;
import com.mw.eleven11.appApi.ServiceWrapper;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.VerifyMobileInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.utility.AppUtils;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyPhoneNumber extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.edt_mobile)
    CustomEditText mCustomEditTextMobile;

    Context mContext;

    @OnClick(R.id.ctv_send_otp)
    public void sendOtp(View view) {
        String loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();
        String mobile = mCustomEditTextMobile.getText().toString().trim();
        VerifyMobileInput mobileInput = new VerifyMobileInput();
        mobileInput.setSessionKey(loginSessionKey);
        mobileInput.setPhoneNumber(mobile);
        Call<LoginResponseOut> responseLoginCallback = ServiceWrapper.getInstance().sendMobileUserOtp(mobileInput);
        responseLoginCallback.enqueue(new Callback<LoginResponseOut>() {
            @Override
            public void onResponse(Call<LoginResponseOut> call, Response<LoginResponseOut> response) {

                if (response.body().getData() != null) {
                    if (response.body().getResponseCode() == 200) {
                        AppUtils.showToast(mContext, response.body().getMessage());
                        String mobile = mCustomEditTextMobile.getText().toString().trim();
                        VerifyOTPActivity.start(mContext, mobile, true, "Mobile");
                        finish();
                    } else if (response.body().getResponseCode() == 500) {
                        AppUtils.showToast(mContext, response.body().getMessage());
                    } else {
                        AppUtils.showToast(mContext, response.body().getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponseOut> call, Throwable t) {
                AppUtils.showToast(mContext, t.getMessage());
            }
        });

    }

    @Override
    public void onBackPressed() {
        StartupActivity.start(mContext);
        finish();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, VerifyPhoneNumber.class);
        context.startActivity(starter);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_verify_phone_number;
    }

    @Override
    public void init() {
        mContext = this;
    }


    @OnClick(R.id.back)
    void onBackClick() {
        onBackPressed();
    }


}
