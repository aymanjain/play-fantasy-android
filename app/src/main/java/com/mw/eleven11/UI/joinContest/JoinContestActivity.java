package com.mw.eleven11.UI.joinContest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.addMoney.AddMoneyActivity;
import com.mw.eleven11.UI.matchContest.MatchContestActivity;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.JoinContestInput;
import com.mw.eleven11.beanInput.WalletInput;
import com.mw.eleven11.beanOutput.JoinContestOutput;
import com.mw.eleven11.beanOutput.WalletOutputBean;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class JoinContestActivity extends BaseActivity implements JoinContestView {

    /* Butter Knife : view mapping */

    Loader loader;
    @BindView(R.id.ctv_usable_balance)
    CustomTextView ctvUsableBalance;

    @BindView(R.id.ctv_avail_bonus)
    CustomTextView ctvUsableBonus;


    @BindView(R.id.edt_amount)
    CustomEditText edtAmount;


    @BindView(R.id.tv2_terms_of_use)
    CustomTextView mCustomTextViewTermsOfUse;

    @BindString(R.string.tc)
    String mResStringTermsMessage;


    @BindView(R.id.ctv_joining_amount)
    CustomTextView ctvContestFee;

    @Nullable
    @BindView(R.id.ctv_game_type)
    CustomTextView ctv_game_type;

    @BindView(R.id.ctv_bonus_contribution)
    CustomTextView ctv_bonus_contribution;

    @BindView(R.id.joinContestLin)
    LinearLayout joinContestLin;
    //AddCash Layout
    @BindView(R.id.addCashLin)
    LinearLayout addCashLin;

    @BindView(R.id.ammountBalance)
    CustomTextView ammountBalance;
    @BindView(R.id.winningsAmount)
    CustomTextView winningsAmount;
    @BindView(R.id.unutilizedCashAmount)
    CustomTextView unutilizedCashAmount;
    @BindView(R.id.bonusAmount)
    CustomTextView bonusAmount;
    @BindView(R.id.addcash)
    CustomTextView addcash;

    @BindView(R.id.message)
    CustomTextView ctvMessage;

    private boolean isForAuction = false;
    private boolean isForDraft = false;
    String joiningAmount = "",
            message = "",

    contestId = "",
            userTeamId = "",
            matchId = "",
            round_id = "",
            matchGUID = "",

    userInviteCode = "",

    payAmount = "0",
            series_id = "",
            cashBonusContribution = "";

    String matchTeamVS = "";

    WalletOutputBean responseAccount;
    /*TextWatcher watchChips = new TextWatcher() {

        @Override
        public void afterTextChanged(Editable arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onTextChanged(CharSequence s, int a, int b, int c) {
            // TODO Auto-generated method stub
            calculateFee(edtAmount.getText().toString().trim(), s.toString());
        }
    };*/
    AlertDialog alertExitDialog;
    private JoinContestPresenterImpl mMyProfileParentPresenterImpl;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private String statusId = "";
    private String join;


    @OnClick(R.id.addcash)
    public void addCash() {

        AddMoneyActivity.start(mContext);
        finish();

    }

    @OnClick(R.id.iv_cross)
    public void cross(View view) {
        finish();
    }

    @OnClick(R.id.ctv_join_contests)
    public void joinContest(View view) {


        if (isForAuction) {

        } else if (isForDraft) {


        } else {
            if (userTeamId.length() != 0) {

                JoinContestInput mJoinContestInput = new JoinContestInput();
                mJoinContestInput.setContestGUID(contestId);
                mJoinContestInput.setMatchGUID(matchId);
                mJoinContestInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
                mJoinContestInput.setUserTeamGUID(userTeamId);
                mJoinContestInput.setUserInviteCode(userInviteCode);
                mJoinContestInput.setJoin(join);


                mMyProfileParentPresenterImpl.actionJoinContest(mJoinContestInput);
/*
            switch (AppSession.getInstance().getGameType()) {

                case 1:

                    break;
                case 2:
                    mMyProfileParentPresenterImpl.football_JoinContestaw(AppSession.getInstance().getLoginSession().getResponse().getLoginSessionKey(), AppSession.getInstance().getLoginSession().getResponse().getUserId(), contestId, payAmount, userTeamId, matchId, payChip);
                    break;
                case 3:
                    mMyProfileParentPresenterImpl.kabaddi_JoinContest(AppSession.getInstance().getLoginSession().getResponse().getLoginSessionKey(), AppSession.getInstance().getLoginSession().getResponse().getUserId(), contestId, payAmount, userTeamId, matchId, payChip);
                    break;

            }*/
            } else {

           /* switch (AppSession.getInstance().getGameType()) {
                case 1:
                    mMyProfileParentPresenterImpl.create_team_cricket(AppSession.getInstance().getLoginSession().
                                    getResponse().getLoginSessionKey(), AppSession.getInstance().getLoginSession().getResponse().
                                    getUserId(), matchId, series_id, joiningAmount, contestId,
                            AppSession.getInstance().getTeamSession().getResponse());
                    break;
                case 2:
                    mMyProfileParentPresenterImpl.create_team_football(AppSession.getInstance().getLoginSession().
                                    getResponse().getLoginSessionKey(), AppSession.getInstance().getLoginSession().getResponse().
                                    getUserId(), matchId, series_id, joiningAmount, contestId,
                            AppSession.getInstance().getTeamSession().getResponse());
                    break;
                case 3:
                    mMyProfileParentPresenterImpl.create_team_kabaddi(AppSession.getInstance().getLoginSession().
                                    getResponse().getLoginSessionKey(), AppSession.getInstance().getLoginSession().getResponse().
                                    getUserId(), matchId, series_id, joiningAmount, contestId,
                            AppSession.getInstance().getTeamSession().getResponse());
                    break;
            }*/
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void init() {

        if (getIntent().hasExtra("isAuction") && getIntent().getExtras().getString("isAuction").equals("Yes")
                || getIntent().hasExtra("isDraft") && getIntent().getExtras().getString("isDraft").equals("Yes")) {

            if (AppSession.getInstance().getPlayMode() == 1) {
                ctv_game_type.setText("Auction");
            } else {
                ctv_game_type.setText("Gully Fantasy");
            }
        }
        if (getIntent() != null) {

            if (getIntent().hasExtra("isAuction") && getIntent().getExtras().getString("isAuction").equals("Yes")) {
                isForAuction = true;
                joinContestLin.setVisibility(View.VISIBLE);
                addCashLin.setVisibility(View.GONE);
                contestId = getIntent().getStringExtra("contestId");
                series_id = getIntent().getStringExtra("series_id");
                round_id = getIntent().getStringExtra("round_id");
                joiningAmount = getIntent().getStringExtra("joiningAmount");
                join = getIntent().getStringExtra("join");
                cashBonusContribution = getIntent().getStringExtra("cashBonusContribution");
                userInviteCode = getIntent().getStringExtra("userInviteCode");
            } else if (getIntent().hasExtra("isDraft") && getIntent().getExtras().getString("isDraft").equals("Yes")) {
                isForDraft = true;
                joinContestLin.setVisibility(View.VISIBLE);
                addCashLin.setVisibility(View.GONE);
                message = getIntent().getStringExtra("message");
                contestId = getIntent().getStringExtra("contestId");
                series_id = getIntent().getStringExtra("series_id");
                matchGUID = getIntent().getStringExtra("matchGUID");
                joiningAmount = getIntent().getStringExtra("joiningAmount");
                join = getIntent().getStringExtra("join");
                cashBonusContribution = getIntent().getStringExtra("cashBonusContribution");
                userInviteCode = getIntent().getStringExtra("userInviteCode");
            } else {
                if (getIntent().hasExtra("contestId")) {
                    joinContestLin.setVisibility(View.VISIBLE);
                    addCashLin.setVisibility(View.GONE);
                    contestId = getIntent().getStringExtra("contestId");
                    userTeamId = getIntent().getStringExtra("teamId");
                    matchId = getIntent().getStringExtra("matchId");
                    joiningAmount = getIntent().getStringExtra("joiningAmount");
                    cashBonusContribution = getIntent().getStringExtra("cashBonusContribution");
                    userInviteCode = getIntent().getStringExtra("userInviteCode");
                    series_id = getIntent().getStringExtra("series_id");
                    matchTeamVS = getIntent().getStringExtra("matchTeamVS");
                    join = getIntent().getStringExtra("join");
                } else {
                    joinContestLin.setVisibility(View.GONE);
                    addCashLin.setVisibility(View.VISIBLE);
                }
            }


        }

        if (message == null || message.trim().equals("")) {
            ctvMessage.setVisibility(View.GONE);
        } else {
            ctvMessage.setVisibility(View.VISIBLE);
            ctvMessage.setText(message);
        }

        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);

        ClickableSpan termsOfServicesClick = new ClickableSpan() {
            @Override
            public void onClick(View view) {

            }
        };

        mContext = this;
        //initiate loader
        loader = new Loader(this);
        loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAccountDetail();
            }
        });
        //view profile calling
        mMyProfileParentPresenterImpl = new JoinContestPresenterImpl(this, new UserInteractor());

        if (mMyProfileParentPresenterImpl != null)
            callAccountDetail();

    }

    void callAccountDetail() {


        WalletInput mWalletInput = new WalletInput();
        mWalletInput.setTransactionMode(Constant.WalletAmount);
        mWalletInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mWalletInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
        mWalletInput.setParams(Constant.WALLET_PARAMS);

        mMyProfileParentPresenterImpl.actionViewAccount(mWalletInput);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMyProfileParentPresenterImpl != null)
            mMyProfileParentPresenterImpl.actionLoginCancel();
    }

    @Override
    public int getLayout() {

        return  R.layout.join_contests;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_UPDATE_PROFILE && resultCode == Activity.RESULT_OK) {

        } else if (requestCode == REQUEST_CODE_UPDATE_MOOD && resultCode == Activity.RESULT_OK) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mMyProfileParentPresenterImpl != null)

                        callAccountDetail();


                }
            }, 2000);
        }
    }

    @Override
    public boolean isAttached() {
        return mContext == null ? false : true;
    }

    @Override
    public void hideLoading() {
        loader.hide();
    }

    @Override
    public void onAccountSuccess(WalletOutputBean mWalletOutputBean) {

        loader.hide();
        this.responseAccount = mWalletOutputBean;
        float usableAmount = Float.parseFloat(responseAccount.getData().getTotalCash());

        if (!contestId.equals("")) {
            edtAmount.setFocusable(false);
            edtAmount.setEnabled(false);

            double totalAmount = Double.parseDouble(responseAccount.getData().getWalletAmount()) + Double.parseDouble(responseAccount.getData().getWinningAmount());

            ctvUsableBalance.setText(" " + totalAmount);
            ctvUsableBonus.setText(" " + responseAccount.getData().getCashBonus());
            //ctvUsableChips.setText(responseAccount.getResponse().getChip().getTotalChip());


            Log.i("joiningAmount", "joiningAmount: " + joiningAmount);


            try {
                if (TextUtils.isEmpty(joiningAmount)) {
                    joiningAmount = "0";
                }


                float totalJoiningAmount = Float.parseFloat(joiningAmount);

                ctvContestFee.setText(" " + joiningAmount);
                if (cashBonusContribution.trim().equals("") || cashBonusContribution.equalsIgnoreCase("0")
                        || cashBonusContribution.equalsIgnoreCase("0.00")) {
                    ctv_bonus_contribution.setVisibility(View.GONE);
                } else {
                    ctv_bonus_contribution.setText(" (" + cashBonusContribution + "% Cash Bonus)");
                    ctv_bonus_contribution.setVisibility(View.VISIBLE);
                }


                if (totalJoiningAmount <= 0) {


                    payAmount = "0";
                    setValues();
                } else {


                    //ctvMaxChips.setText(Math.min(Integer.parseInt(responseAccount.getResponse().getChip().getTotalChip()), Integer.parseInt(chip)) + "");

                    /*if (Integer.parseInt(responseAccount.getResponse().getChip().getTotalChip()) >= Integer.parseInt(chip)) {
                        payChip = chip;
                        payAmount = joiningAmount;
                        setValues();

                    } else if (Integer.parseInt(responseAccount.getResponse().getChip().getTotalChip()) < Integer.parseInt(chip)) {
                        payAmount = Float.parseFloat(joiningAmount) + (Integer.parseInt(chip) - Integer.parseInt(responseAccount.getResponse().getChip().getTotalChip())) + "";
                        payChip = responseAccount.getResponse().getChip().getTotalChip();
                        setValues();
                    }*/

                    // edtChips.setFilters(new InputFilter[]{new CustomRangeInputFilter(0, Float.parseFloat(payChip))});


                }
            } catch (Exception e) {
                //mean chips not available
                e.printStackTrace();


                payAmount = joiningAmount;
                setValues();
            }
        } else {
            ammountBalance.setText(" " + usableAmount);
            winningsAmount.setText(responseAccount.getData().getWinningAmount());
            bonusAmount.setText(responseAccount.getData().getCashBonus());
            unutilizedCashAmount.setText(responseAccount.getData().getTotalCash());

        }
    }

    @Override
    public void showLoading() {
        loader.start();
    }

    @Override
    public void onShowSnackBar(String message) {
        AppUtils.showToast(this, message);
    }











    @Override
    public void onAccountFailure(String error) {
        loader.error(error);
    }

    @Override
    public void onJoinSuccess(JoinContestOutput responseLogin) {
        /*  Intent intent = new Intent(MatchContestActivity.class.getSimpleName());
        intent.putExtra("KEY", "REFRESH");
        LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);

        InviteContestActivity.start(mContext, userInviteCode, matchTeamVS);
        onShowSnackBar(responseLogin.getMessage());
        setResult(Activity.RESULT_OK);

        AppSession.getInstance().clearTeamSession();

        finish();

        //HomeNavigation.start(mContext, matchId, contestId);*/

        AppUtils.showToast(mContext, responseLogin.getMessage());

        if (responseLogin.getResponseCode() == 200) {
            Intent intent = new Intent(MatchContestActivity.class.getSimpleName());
            intent.putExtra("KEY", "REFRESH");
            LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);

          /*  InviteContestActivity.start(mContext, userInviteCode, matchTeamVS);
            onShowSnackBar(responseLogin.getMessage());
            setResult(Activity.RESULT_OK);*/

            AppSession.getInstance().clearTeamSession();

            MatchContestActivity.start(mContext, matchId, Constant.Pending);
            setResult(Activity.RESULT_OK);
            finish();
//            HomeNavigation.start(mContext, matchId, contestId);
        } else {

            InsufficientAmountActivity.start(mContext, responseAccount.getData().getWalletAmount(), joiningAmount, matchId, Constant.Pending, responseLogin.getData().getRemainingFee());
            finish();
        }
    }


    private void setValues() {
        edtAmount.setText(payAmount);

    }

    private float calculateFee(String amount, String chips) {
        float perTeem = 0;
        if (amount.length() > 0 && chips.length() > 0) {

            payAmount = (Float.parseFloat(joiningAmount) + "");
        } else {

            payAmount = (Float.parseFloat(joiningAmount) + "");
        }
        edtAmount.setText(payAmount);
        return perTeem;
    }

    @Override
    public void onJoinNotFound(String errMsg) {
        alertExitDialog = new AlertDialog(getContext(), errMsg, AppUtils.getStrFromRes(R.string.okay), AppUtils.getStrFromRes(R.string.cancel), new AlertDialog.OnBtnClickListener() {
            @Override
            public void onYesClick() {
                AddMoneyActivityStart(mContext);
            }

            @Override
            public void onNoClick() {

            }
        });
        alertExitDialog.show();

    }

    public void AddMoneyActivityStart(Context context) {
      /*  Intent starter = new Intent(context, AddMoneyActivity.class);
        startActivityForResult(starter, REQUEST_CODE_UPDATE_MOOD);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);*/
    }

    @Override
    public void onJoinFailure(String error) {
        onShowSnackBar(error);
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
