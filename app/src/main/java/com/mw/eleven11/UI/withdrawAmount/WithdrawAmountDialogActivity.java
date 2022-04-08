package com.mw.eleven11.UI.withdrawAmount;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;

import com.mw.eleven11.UI.myAccount.MyAccountParentPresenterImpl;
import com.mw.eleven11.UI.myAccount.MyAccountParentView;
import com.mw.eleven11.UI.verifyAccount.VerifyAccountActivity;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.WalletInput;
import com.mw.eleven11.beanInput.WithdrawInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.WalletOutputBean;
import com.mw.eleven11.beanOutput.WithDrawoutput;
import com.mw.eleven11.customView.CustomRadioButton;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.ActivityUtils;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;

import butterknife.BindView;
import butterknife.OnClick;


public class WithdrawAmountDialogActivity extends BaseActivity implements WithdrawAmountView, MyAccountParentView {

    @BindView(R.id.ll_mobile_no_root)
    LinearLayout mLinearLayoutMobileNoRoot;


    @OnClick(R.id.ctv_change_no)
    public void changeNo(android.view.View view) {
        VerifyAccountActivity.start(this);
    }


    @BindView(R.id.edt_mood)
    EditText mCustomEditTextMood;
    @BindView(R.id.ctv_save)
    CustomTextView mCustomTextViewSave;
    @BindView(R.id.rb_bank)
    CustomRadioButton rb_bank;
    @BindView(R.id.edt_phoneno)
    CustomTextView edt_phoneno;

    @BindView(R.id.winning_amt)
    CustomTextView winning_amt;
    @BindView(R.id.ctv_account_no)
    CustomTextView ctv_account_no;
    @BindView(R.id.bank_name)
    CustomTextView bank_name;
    @BindView(R.id.message)
    CustomTextView message;
    @BindView(R.id.lyt_text)
    RelativeLayout lyt_text;

    String phoneNo = "";
    String amount = "";

    /* Butter Knife : view mapping */
    AlertDialog alertExitDialog;
    private Context mContext;
    private WithdrawAmountPresenterImpl mMoodPresenterImpl;
    private ProgressDialog mProgressDialog;
    private LoginResponseOut mLoginResponseOut;
    private MyAccountParentPresenterImpl mMyAccountParentPresenterImpl;

    public static void start(Context context) {
        Intent starter = new Intent(context, WithdrawAmountDialogActivity.class);
        ((Activity) context).startActivityForResult(starter, REQUEST_CODE_UPDATE_Wallet);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }
    /* Butter Knife : view mapping */

    @OnClick(R.id.ctv_save)
    public void save(android.view.View view) {

        amount = mCustomEditTextMood.getText().toString().trim();
        WithdrawInput withdrawInput = new WithdrawInput();

        if (rb_bank.isChecked()) {
            withdrawInput.setPaymentGateway(Constant.BANK);
        } else {

            phoneNo = edt_phoneno.getText().toString().trim();
            if (TextUtils.isEmpty(phoneNo)) {
                showSnackBar("Enter Mobile Number");
                return;
            }

            withdrawInput.setPaymentGateway(Constant.PAYTM);
            withdrawInput.setPaytmPhoneNumber(phoneNo);

        }

        if (TextUtils.isEmpty(amount)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.please_enter_amount_));
            return;
        }
        try {
            Integer.parseInt(amount);
            if (Integer.parseInt(amount) <= 0) {
                showSnackBar(AppUtils.getStrFromRes(R.string.please_enter_valid_amount_));
                return;
            }
        } catch (NumberFormatException e) {
            showSnackBar(AppUtils.getStrFromRes(R.string.please_enter_valid_amount_));
            return;
        }
        if (rb_bank.isChecked()) {
            if (!isAccountVerified(mLoginResponseOut)) {
                return;
            }
        }


        withdrawInput.setAmount(Integer.parseInt(amount));
        withdrawInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        withdrawInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
        mMoodPresenterImpl.actionWithdrawAmountBtn(withdrawInput);


    }

    @OnClick(R.id.back)
    public void cancel(android.view.View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.dialog_withdraw_amount;
    }

    @Override
    public void init() {
        edt_phoneno.setEnabled(false);
        ActivityUtils.performActionOnDone(mCustomEditTextMood, mCustomTextViewSave);//handle action done event of keyboard
        mContext = this;
        setActivityBackground();
        mMoodPresenterImpl = new WithdrawAmountPresenterImpl(this, new UserInteractor());
        mMyAccountParentPresenterImpl = new MyAccountParentPresenterImpl(this, new UserInteractor());


        rb_bank.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mLinearLayoutMobileNoRoot.setVisibility(View.GONE);
                } else {
                    mLinearLayoutMobileNoRoot.setVisibility(View.VISIBLE);
                }
            }
        });

//      edt_phoneno.setText(AppSession.getInstance().getLoginSession().getData().getPhoneNumber());


    }


    @Override
    protected void onResume() {
        super.onResume();
        callTask();
        apiCallGetProfile();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();

    }

    @Override
    public void onAccountSuccess(WalletOutputBean mWalletOutputBean) {


        winning_amt.setText(AppUtils.getStrFromRes(R.string.price_unit) + mWalletOutputBean.getData().getWinningAmount());
        bank_name.setText(mWalletOutputBean.getData().getMediaBANK().getMediaCaption().getBank());
        ctv_account_no.setText("A/C " + mWalletOutputBean.getData().getMediaBANK().getMediaCaption().getAccountNumber() == null ? "" : mWalletOutputBean.getData().getMediaBANK().getMediaCaption().getAccountNumber());
        message.setText(mWalletOutputBean.getData().getMediaBANK().getMessage());
    }

    @Override
    public void onAccountFailure(String errMsg) {

    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onHideLoading() {

    }

    @Override
    public void onShowSnackBar(String message) {

    }

    @Override
    public boolean isAttached() {
        return true;
    }

    @Override
    public void withDrawSuccess(final WithDrawoutput responseLogin) {
        hideLoading();
        alertExitDialog = new AlertDialog(WithdrawAmountDialogActivity.this, responseLogin.getMessage(), AppUtils.getStrFromRes(R.string.okay), "", new AlertDialog.OnBtnClickListener() {
            @Override
            public void onYesClick() {
                if (rb_bank.isChecked()) {
                    setResult(RESULT_OK);
                    finishActivity();
                } else {
                    setResult(RESULT_OK);
                    finishActivity();
                    //PaytmWithdrawOtp.start(mContext,phoneNo,responseLogin.getData().getWithdrawalID(),amount);
                }

            }

            @Override
            public void onNoClick() {

            }
        });
        alertExitDialog.show();
    }

    @Override
    public void withDrawFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void showSnackBar(@NonNull String message) {
        AppUtils.showSnackBar(mContext, lyt_text, message);
    }

    @Override
    public void setActivityBackground() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void finishActivity() {
        finish();
    }


    private void callTask() {
        if (mMyAccountParentPresenterImpl != null) {

            WalletInput mWalletInput = new WalletInput();
            mWalletInput.setTransactionMode(Constant.WalletAmount);
            mWalletInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            mWalletInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
            mWalletInput.setParams(Constant.WALLET_PARAMS_M);

            mMyAccountParentPresenterImpl.actionViewAccount(mWalletInput);

        }
    }


    private void apiCallGetProfile() {
        hideLoading();
        if (!NetworkUtils.isNetworkConnected(this)) {
            alertExitDialog = new AlertDialog(mContext,
                    AppUtils.getStrFromRes(R.string.poorConnection),
                    AppUtils.getStrFromRes(R.string.try_again),
                    AppUtils.getStrFromRes(R.string.cancel),
                    new AlertDialog.OnBtnClickListener() {
                        @Override
                        public void onYesClick() {
                            alertExitDialog.hide();
                            apiCallGetProfile();
                        }

                        @Override
                        public void onNoClick() {
                            alertExitDialog.hide();
                            finish();

                        }
                    });
            alertExitDialog.show();
        } else {
            showLoading();
            LoginInput mLoginInput = new LoginInput();
            mLoginInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            mLoginInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
            mLoginInput.setParams(Constant.GET_PROFILE_PARAMS);
            UserInteractor userInteractor = new UserInteractor();
            userInteractor.viewProfile(mLoginInput, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut user) {
                    hideLoading();
                    mLoginResponseOut = user;
                    edt_phoneno.setText(user.getData().getPhoneNumber());
                }

                @Override
                public void onError(String errorMsg) {
                    hideLoading();
                    alertExitDialog = new AlertDialog(mContext,
                            errorMsg,
                            AppUtils.getStrFromRes(R.string.try_again),
                            AppUtils.getStrFromRes(R.string.cancel),
                            new AlertDialog.OnBtnClickListener() {
                                @Override
                                public void onYesClick() {
                                    alertExitDialog.hide();
                                    apiCallGetProfile();
                                }

                                @Override
                                public void onNoClick() {
                                    alertExitDialog.hide();
                                    finish();

                                }
                            });
                    alertExitDialog.show();
                }
            });
        }

    }


    boolean isAccountVerified(LoginResponseOut loginResponseOut) {
        boolean isVerified = false;

        if (loginResponseOut.getData().getPhoneStatus().equals(Constant.Verified)) {
            isVerified = true;
        } else {
            showSnackBar(AppUtils.getStrFromRes(R.string.verify_your_mobile));


            return false;

        }
        if (loginResponseOut.getData().getEmailStatus().equals(Constant.Verified)) {
            isVerified = true;
        } else {
            showSnackBar(AppUtils.getStrFromRes(R.string.verify_your_email));

            return false;

        }
        if (loginResponseOut.getData().getPanStatus().equals(Constant.Verified)) {
            isVerified = true;
        } else {
            showSnackBar(AppUtils.getStrFromRes(R.string.verify_your_pan_card));

            return false;

        }
        if (loginResponseOut.getData().getBankStatus().equals(Constant.Verified)) {
            isVerified = true;
        } else {
            showSnackBar(AppUtils.getStrFromRes(R.string.verify_your_bank));

            return false;

        }

        return isVerified;
    }


}
