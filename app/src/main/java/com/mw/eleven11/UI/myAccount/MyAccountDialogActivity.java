package com.mw.eleven11.UI.myAccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.addMoney.AddMoneyActivity;
import com.mw.eleven11.UI.verifyAccount.VerifyAccountActivity;
import com.mw.eleven11.UI.withdrawAmount.WithdrawAmountDialogActivity;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.WalletInput;
import com.mw.eleven11.beanOutput.WalletOutputBean;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;

import butterknife.BindView;
import butterknife.OnClick;

public class MyAccountDialogActivity extends BaseActivity implements MyAccountParentView {

    public static boolean isRefresh = true;
    @BindView(R.id.totalBalance)
    CustomTextView totalBalance;
    @BindView(R.id.totalAmmount)
    CustomTextView totalAmmount;
    @BindView(R.id.addcash)
    CustomTextView addcash;
    @BindView(R.id.unutilized)
    CustomTextView unutilized;
    @BindView(R.id.unutilizedAmount)
    CustomTextView unutilizedAmount;
    @BindView(R.id.amountToExpire)
    CustomTextView amountToExpire;
    @BindView(R.id.expireAmount)
    CustomTextView expireAmount;
    @BindView(R.id.winnings)
    CustomTextView winnings;
    @BindView(R.id.winningsAmount)
    CustomTextView winningsAmount;
    @BindView(R.id.withdraw)
    CustomTextView withdraw;
    @BindView(R.id.cashBonus)
    CustomTextView cashBonus;
    @BindView(R.id.cashBonusAmount)
    CustomTextView cashBonusAmount;
    @BindView(R.id.bonusToExpire)
    CustomTextView bonusToExpire;
    @BindView(R.id.bonusToExpireAmount)
    CustomTextView bonusToExpireAmount;
    @BindView(R.id.entryFeeInfo)
    CustomTextView entryFeeInfo;
    @BindView(R.id.recentTrasactions)
    CustomTextView recentTrasactions;
    @BindView(R.id.withDrawalInProgress)
    CustomTextView withDrawalInProgress;
    @BindView(R.id.managePayment)
    CustomTextView managePayment;
    @BindView(R.id.addRemoveCard)
    CustomTextView addRemoveCard;
    @BindView(R.id.unutilizedInfo)
    ImageView unutilizedInfo;
    @BindView(R.id.winningInfo)
    ImageView winningInfo;
    @BindView(R.id.bonusInfo)
    ImageView bonusInfo;
    @BindView(R.id.recentTransaction)
    CardView recentTransaction;

    @BindView(R.id.rl_root)
    LinearLayout rl_root;

    /*  @Nullable
      @BindView(R.id.swipeContainer)
      SwipeRefreshLayout swipeRefreshLayout;*/
    Loader loader;
    Context mContext;
    WalletOutputBean myAccount;
    Double winningamt = 0.0;
    private MyAccountParentPresenterImpl mMyAccountParentPresenterImpl;
    private ProgressDialog mProgressDialog;

    public static void start(Context context, boolean fromAuction) {
        Intent starter = new Intent(context, MyAccountDialogActivity.class);
        starter.putExtra("fromAuction", fromAuction);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @OnClick(R.id.recentTransaction)
    void onRecentTransaction() {
        //TransactionActivity.start(mContext);
    }

    @OnClick(R.id.unutilizedInfo)
    public void onUnutilizedClick() {
        AppUtils.showPopup(this,
                unutilizedInfo, rl_root,
                AppUtils.getStrFromRes(R.string.expireInfo));
    }

    @OnClick(R.id.winningInfo)
    public void onWinningClick() {
        AppUtils.showPopup(this, winningInfo, rl_root, AppUtils.getStrFromRes(R.string.winningInfo));
    }

    @OnClick(R.id.bonusInfo)
    public void onBonusClick() {

        AppUtils.showPopup(this, bonusInfo, rl_root, AppUtils.getStrFromRes(R.string.bonusInfo));
    }

    @OnClick(R.id.back)
    public void onBackClick() {

        onBackPressed();

    }

    @OnClick(R.id.addcash)
    void onClickAddCash() {

        AddMoneyActivity.start(this);
        finish();
    }

    @OnClick(R.id.withdraw)
    void onClickWithdrawal() {


        if (myAccount != null) {

            if ((
                    myAccount.getData().getEmailStatus().equals("Verified")
                            && myAccount.getData().getPhoneStatus().equals("Verified")
                            && myAccount.getData().getPanStatus().equals("Verified"))
                    && (myAccount.getData().getBankStatus().equals("Verified") || myAccount.getData().getAadharStatus().equals("Verified"))
            ) {

                if (winningamt == 0) {
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.Sorry_Insufficient_winning_amount));
                    return;
                } else {
                    WithdrawAmountDialogActivity.start(mContext);
                }

            } else {
                VerifyAccountActivity.start(mContext);
            }
        }

        /*if (myAccount != null) {



            if(winningamt<200){
                onShowSnackBar("Winning amount should be greater than Rs.200 ");
                return;
            }else {
                if (isAccountVerified(myAccount)){
                    WithdrawAmountDialogActivity.start(mContext);
                    finish();
                } else {
                    // VerifyAccountActivity.start(mContext);
                }
            }

        }*/

    }

    @OnClick(R.id.iv_cross)
    public void cross(View view) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayout() {
        return R.layout.dialog_my_account;

    }

    @Override
    public void init() {

        if (isAttached()) {
            mContext = this;

            //view profile calling
            mMyAccountParentPresenterImpl = new MyAccountParentPresenterImpl(this, new UserInteractor());

            //initiate loader
            loader = new Loader(this);
            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* mMyAccountParentPresenterImpl.actionViewAccount(AppSession.getInstance().
                            getLoginSession().getResponse().getLoginSessionKey());*/

                    callTask();
                }
            });

          /*  // Setup refresh listener which triggers new data loading
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    isRefresh = true;
                    callTask();
                }
            });
            // Configure the refreshing colors
            swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                    R.color.colorPrimary,
                    R.color.secondary_tab_color);*/

            isRefresh = true;

        }
    }


    boolean isAccountVerified(WalletOutputBean loginResponseOut) {
        boolean isVerified = false;

        if (loginResponseOut.getData().getPhoneStatus().equals(Constant.Verified)) {
            isVerified = true;
        } else {
            onShowSnackBar(AppUtils.getStrFromRes(R.string.verify_your_mobile));

            return false;

        }

        if (loginResponseOut.getData().getPanStatus().equals(Constant.Verified)) {
            isVerified = true;
        } else {
            onShowSnackBar(AppUtils.getStrFromRes(R.string.verify_your_pan_card));

            return false;

        }
        if (loginResponseOut.getData().getBankStatus().equals(Constant.Verified)) {
            isVerified = true;
        } else {
            onShowSnackBar(AppUtils.getStrFromRes(R.string.verify_your_bank));

            return false;

        }

        return isVerified;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (isRefresh)
            callTask();
    }

    private void callTask() {
        if (mMyAccountParentPresenterImpl != null) {
            isRefresh = false;

            WalletInput mWalletInput = new WalletInput();
            mWalletInput.setTransactionMode(Constant.WalletAmount);
            mWalletInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            mWalletInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
            mWalletInput.setParams(Constant.WALLET_PARAMS);

            mMyAccountParentPresenterImpl.actionViewAccount(mWalletInput);

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMyAccountParentPresenterImpl != null)
            mMyAccountParentPresenterImpl.actionLoginCancel();
    }

    @Override
    public void hideLoading() {


        loader.hide();

        /*if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);*/

    }

    @Override
    public void showLoading() {

        loader.start();
      /*  if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);*/

    }

    @Override
    public void onShowSnackBar(String message) {
        AppUtils.showToast(this, message);
    }

    @Override
    public boolean isAttached() {
        return true;
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void onAccountFailure(String error) {

        loader.error(error);

    }

    @Override
    public void onAccountSuccess(WalletOutputBean responseAccount) {


        loader.hide();
        this.myAccount = responseAccount;

        winningamt = Double.valueOf(responseAccount.getData().getWinningAmount());


        if ((
                myAccount.getData().getEmailStatus().equals("Verified")
                        && myAccount.getData().getPhoneStatus().equals("Verified")
                        && myAccount.getData().getPanStatus().equals("Verified"))
                && (myAccount.getData().getBankStatus().equals("Verified") || myAccount.getData().getAadharStatus().equals("Verified"))
        ) {
            if (winningamt == 0) {
                withdraw.setTextColor(getResources().getColor(R.color.warm_grey));
                withdraw.setBackground(getResources().getDrawable(R.drawable.shedow_blue_background));
                withdraw.setText(R.string.WITHDRAW);
            } else {
                withdraw.setTextColor(getResources().getColor(R.color.white));
                withdraw.setBackground(getResources().getDrawable(R.drawable.shedow_yellow_background));
                withdraw.setText(R.string.WITHDRAW);
            }
        } else {
            withdraw.setTextColor(getResources().getColor(R.color.white));
            withdraw.setBackground(getResources().getDrawable(R.drawable.shedow_yellow_background));
            withdraw.setText(R.string.VERIFY);
        }

        /*if(winningamt>200){
            withdraw.setBackground(getResources().getDrawable(R.drawable.bg_auc_btn));
            withdraw.setTextColor(getResources().getColor(R.color.black));
        }else {
            withdraw.setBackground(getResources().getDrawable(R.drawable.shedow_blue_background));
        }*/

        totalAmmount.setText(AppUtils.getStrFromRes(R.string.price_unit) + responseAccount.getData().getTotalCash());
        winningsAmount.setText(AppUtils.getStrFromRes(R.string.price_unit) + responseAccount.getData().getWinningAmount());
        unutilizedAmount.setText(AppUtils.getStrFromRes(R.string.price_unit) + responseAccount.getData().getWalletAmount());

        winningsAmount.setText(AppUtils.getStrFromRes(R.string.price_unit) + responseAccount.getData().getWinningAmount());
        expireAmount.setText(AppUtils.getStrFromRes(R.string.price_unit) + responseAccount.getData().getCashBonus());
        bonusToExpireAmount.setText(AppUtils.getStrFromRes(R.string.price_unit) + responseAccount.getData().getCashBonus());

        cashBonusAmount.setText(AppUtils.getStrFromRes(R.string.price_unit) + responseAccount.getData().getCashBonus());

       /* if (responseAccount.getResponse().getVerifyAccount().equals("PENDING")) {

        } else {

        }*/

    }

    @Override
    public void onShowLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void onHideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();

    }

}
