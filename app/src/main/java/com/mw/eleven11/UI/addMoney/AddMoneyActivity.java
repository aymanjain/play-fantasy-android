package com.mw.eleven11.UI.addMoney;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.chooseMoney.ChooseMoneyCallback;
import com.mw.eleven11.UI.chooseMoney.ChooseMoneyOptionsFragment;
import com.mw.eleven11.UI.matchContest.MatchContestActivity;
import com.mw.eleven11.UI.myAccount.MyAccountActivity;
import com.mw.eleven11.UI.myAccount.MyAccountDialogActivity;
import com.mw.eleven11.UI.payTm.PayTmPresenterImpl;
import com.mw.eleven11.UI.payTm.PayTmView;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.PaytmInput;
import com.mw.eleven11.beanInput.PromoCodeInput;
import com.mw.eleven11.beanInput.PromoCodeListInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.PromoCodeListOutput;
import com.mw.eleven11.beanOutput.PromoCodeResponse;
import com.mw.eleven11.beanOutput.ResponsePayTmDetails;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.ActivityUtils;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.OnItemClickListener;
import com.razorpay.PaymentResultListener;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class AddMoneyActivity extends BaseActivity implements AddMoneyView, PayTmView, ChooseMoneyCallback, PaymentResultListener {

    public static final String TAG = "AddMoneyActivity : ";
    AddMoneyPresenterImpl mPresenterImpl;
    ChooseMoneyOptionsFragment chooseMoneyOptionsFragment;
    private LinearLayoutManager layoutManager;
    @BindString(R.string.add_cash)
    String mResStringForgotPassword;
    /* Butter Knife : view mapping */

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.edt_amount)
    CustomEditText mCustomEditTextAmount;
    @BindView(R.id.title)
    CustomTextView mCustomTextViewTitle;
    @BindView(R.id.haveACode)
    CustomTextView haveACode;
    boolean isCodeValid = false;
    @BindView(R.id.ctv_add_cash)
    CustomTextView mCustomTextViewAddCash;
    @BindView(R.id.wireTransfer)
    CustomTextView wireTransfer;
    @BindView(R.id.ll_promocode)
    LinearLayout ll_promocode;


    @BindView(R.id.ctv_100)
    CustomTextView ctv_100;
    @BindView(R.id.ctv_200)
    CustomTextView ctv_200;
    @BindView(R.id.ctv_300)
    CustomTextView ctv_300;
    @BindView(R.id.promo_code)
    CustomEditText promo_code;
    @BindView(R.id.ll_promo_succses)
    LinearLayout ll_promo_succses;
    @BindView(R.id.couponCode_ctv)
    CustomTextView couponCode_ctv;
    @BindView(R.id.cashbonus_ctv)
    CustomTextView cashbonus_ctv;
    @BindView(R.id.promocode_list)
    RecyclerView mRecyclerView_promocode_list;

    String offerCode = "";
    int paybleAmount = 0;
    private Context mContext;
    private Loader loader;
    private ProgressDialog mProgressDialog;
    public PromoListAdapter mPromoListAdapter;
    List<PromoCodeListOutput.DataBean.RecordsBean> mRecordsBean;
    private String couponGUID = null;
    String walletId = "";
    String matchId="";
    String statusId="";
    private List<PromoCodeListOutput.DataBean.RecordsBean> mPromoList = new ArrayList<>();
    private String promoCode ="";


    public static void start(Context context, boolean fromAuction) {
        Intent starter = new Intent(context, AddMoneyActivity.class);
        starter.putExtra("fromAuction", fromAuction);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, AddMoneyActivity.class);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context, String offerCodeStr) {
        Intent starter = new Intent(context, AddMoneyActivity.class);
        starter.putExtra("offerCode", offerCodeStr);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    public static void start(Context context,String matchId,String statusId) {
        Intent starter = new Intent(context, AddMoneyActivity.class);
        starter.putExtra("matchId",matchId);
        starter.putExtra("statusId",statusId);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @OnClick(R.id.back)
    void onBackClick() {
        finish();
    }

    @OnClick(R.id.applypromo)
    void applyPromoCodeClick() {
        String amount = mCustomEditTextAmount.getText().toString().trim();
        String code = promoCode;

        if (TextUtils.isEmpty(amount)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.err_amount_empty));
            return;
        }

        if (TextUtils.isEmpty(code)) {
            showSnackBar("Enter Promo Code");
            return;
        }

        PromoCodeInput promoCodeInput = new PromoCodeInput();
        promoCodeInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        promoCodeInput.setAmount(amount);
        promoCodeInput.setCouponCode(code);

        mPresenterImpl.promoCodeBtn(promoCodeInput);

    }

    @OnClick(R.id.ctv_add_cash)
    public void AddCash(View view) {

       /* if(AppSession.getInstance().getLoginSession().getData().getPhoneStatus()!=null){
            if (!AppSession.getInstance().getLoginSession().getData().getPhoneStatus().equals(Constant.Verified)){

                VerifyAccountActivity.start(mContext);
                showSnackBar(AppUtils.getStrFromRes(R.string.verify_your_mobile));
                return;
            }
        }

        if (!AppSession.getInstance().getLoginSession().getData().getEmailStatus().equals(Constant.Verified)){

            VerifyAccountActivity.start(mContext);

            showSnackBar(AppUtils.getStrFromRes(R.string.verify_your_email));
            return;
        }*/

        String amount = mCustomEditTextAmount.getText().toString().trim();
        if (TextUtils.isEmpty(amount)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.err_amount_empty));
            return;
        }
        if (true){
            paybleAmount = Integer.valueOf(amount);
            chooseMoneyOptionsFragment = new ChooseMoneyOptionsFragment();
            chooseMoneyOptionsFragment.initCallback(this);
            chooseMoneyOptionsFragment.show(getSupportFragmentManager(), chooseMoneyOptionsFragment.getTag());
            chooseMoneyOptionsFragment.startPayment();
            //return;
        }

        /*if (TextUtils.isEmpty(AppSession.getInstance().getLoginSession().getData().getFirstName())) {

            AppUtils.showToast(mContext, AppUtils.getStrFromRes(R.string.empty_name));
            Intent starter = new Intent(getActivity(), PersonalDetailsActivity.class);
            startActivityForResult(starter, 111);

            return;
        }*/
        try {
            if (Double.parseDouble(amount) <= 0) {
                showSnackBar(AppUtils.getStrFromRes(R.string.err_amount_empty));
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            showSnackBar(AppUtils.getStrFromRes(R.string.err_amount_empty));
            return;
        }

      /*  if (true){
            Toast.makeText(mContext, R.string.in_progress, Toast.LENGTH_LONG).show();
            return;
        }*/

        /*paybleAmount = Integer.valueOf(amount);
        chooseMoneyOptionsFragment = new ChooseMoneyOptionsFragment();
        chooseMoneyOptionsFragment.initCallback(this);
        chooseMoneyOptionsFragment.show(getSupportFragmentManager(), chooseMoneyOptionsFragment.getTag());
        chooseMoneyOptionsFragment.startPayment();*/
        //mChangePasswordPresenterImpl.actionChangePasswordBtn(AppSession.getInstance().getLoginSession().getResponse().getLoginSessionKey(),amount,amount,amount);
    }

    @OnClick(R.id.wireTransfer)
    void onWireTransferClick() {

        //  WireTransferBanks.start(mContext, mCustomEditTextAmount.getText().toString(), offerCode);
    }

    @OnClick(R.id.ctv_100)
    public void add100(View view) {
        AddCash("200");

    }
    /* Butter Knife : view mapping */

    @OnClick(R.id.ctv_200)
    public void add200(View view) {
        AddCash("400");
    }

    @OnClick(R.id.ctv_300)
    public void add300(View view) {
        AddCash("600");
    }

    private void AddCash(String am) {
        mCustomEditTextAmount.setText(am);
       /* String amount = mCustomEditTextAmount.getText().toString().trim();
        if (TextUtils.isEmpty(amount)) {
            mCustomEditTextAmount.setText(am);
        } else {
            mCustomEditTextAmount.setText("" + (Integer.parseInt(amount) + Integer.parseInt(am)));
        }*/

    }

    @Override
    public int getLayout() {
        return R.layout.activity_add_money;
    }

    @Override
    public void init() {

        loader = new Loader(getActivity());

        mCustomTextViewTitle.setText(mResStringForgotPassword);
        ll_promocode.setVisibility(View.GONE);
        ll_promo_succses.setVisibility(View.GONE);

        ActivityUtils.performActionOnDone(mCustomEditTextAmount, mCustomTextViewAddCash);//handle action done event of keyboard
        mContext = this;
        //setActivityBackground();

        mRecordsBean = new ArrayList<>();
        mRecyclerView_promocode_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mPromoListAdapter = new PromoListAdapter(R.layout.promo_list_items, getActivity(), mRecordsBean,onWinnerClickCallBack );
        mRecyclerView_promocode_list.setAdapter(mPromoListAdapter);

        if (getIntent().hasExtra("offerCode")) {
            offerCode = getIntent().getStringExtra("offerCode");

            haveACode.setText(AppUtils.getStrFromRes(R.string.offer_code_applied));
            haveACode.setTextColor(ContextCompat.getColor(mContext, R.color.button_green));
            isCodeValid = true;
        }

        matchId = getIntent().getStringExtra("matchId");
        statusId = getIntent().getStringExtra("statusId");

        mPresenterImpl = new AddMoneyPresenterImpl(this, new UserInteractor());

        PromoCodeListInput promoCodeListInput = new PromoCodeListInput();
        promoCodeListInput.setPageNo(0);
        promoCodeListInput.setPageSize(10);
        promoCodeListInput.setStatus("Active");
        mPresenterImpl.actionPromoCodeList(promoCodeListInput);


        mCustomEditTextAmount.setDrawableClickListener(new CustomEditText.DrawableClickListener() {


            public void onClick(DrawablePosition target) {
                switch (target) {
                    case RIGHT:
                        //Do something here
                        mCustomEditTextAmount.setText("");
                        break;

                    default:
                        break;
                }
            }

        });


//        checkbox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (checkbox.isChecked()) {
//                    ll_promocode.setVisibility(View.VISIBLE);
//                } else {
//                    ll_promocode.setVisibility(View.GONE);
//                }
//            }
//        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    @Override
    public Activity getActivity() {
        return this;
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
    public void payTmDetailsSuccess(ResponsePayTmDetails responseLogin) {
        finishActivity();

    }

    @Override
    public void payTmDetailsFailure(String errMsg) {

    }

    @Override
    public void payTmResponseSuccess(LoginResponseOut responseLogin) {

        finishActivity();
    }

    @Override
    public void payTmResponseFailure(String errMsg) {

    }


    private OnItemClickListener.OnItemClickCallback onWinnerClickCallBack = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            promoCode = mPromoList.get(position).getCouponCode();
            applyPromoCodeClick();
        }

    };

    @Override
    public void showSnackBar(@NonNull String message) {
        AppUtils.showToast(mContext, message);
    }

    @Override
    public void promoCodeSuccess(PromoCodeResponse mPromoCodeResponse) {

        hideLoading();
        couponGUID = mPromoCodeResponse.getData().getCouponGUID();
        ll_promocode.setVisibility(View.GONE);
        ll_promo_succses.setVisibility(View.VISIBLE);
        mCustomEditTextAmount.setEnabled(false);
        ctv_100.setEnabled(false);
        ctv_200.setEnabled(false);
        ctv_300.setEnabled(false);
//        checkbox.setChecked(true);
//        checkbox.setEnabled(false);
        couponCode_ctv.setText("Coupon Code :   " + mPromoCodeResponse.getData().getCouponCode());

        if (mPromoCodeResponse.getData().getCouponType().equals("Percentage")) {

            double amt = Double.parseDouble(mCustomEditTextAmount.getText().toString().trim());
            double value = (amt * Double.parseDouble( mPromoCodeResponse.getData().getCouponValue())) / 100;
            cashbonus_ctv.setText("Cash Bonus :    " + value);
        }else {
            cashbonus_ctv.setText("Cash Bonus :    " + mPromoCodeResponse.getData().getCouponValue());
        }




    }

    @Override
    public void promoCodeFaliure(String message) {

        ll_promocode.setVisibility(View.GONE);
        ll_promo_succses.setVisibility(View.GONE);
//        checkbox.setChecked(false);
//        checkbox.setEnabled(true);
        hideLoading();
        showSnackBar(message);
    }

    @Override
    public void promocodeListSuccess(PromoCodeListOutput mPromoCodeListOutput) {

        if (mPromoCodeListOutput.getData().getRecords() != null) {
            mPromoList = mPromoCodeListOutput.getData().getRecords();
            mPromoListAdapter.addAllItem(mPromoCodeListOutput.getData().getRecords());
        }else {
            loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.not_found_img));
            loader.dataNotFound("No Offers Available");
        }

    }

    @Override
    public void promocodeListFailure(String msg) {

        showSnackBar(msg);
    }

    @Override
    public void onProfileSuccess(LoginResponseOut responseLogin) {

    }

    @Override
    public void onProfileFailure(String errMsg) {

    }

    @Override
    public void setActivityBackground() {
        //  ActivityUtils.setActivityBackground(mContext, R.drawable.app_bg);
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void finishActivity() {
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onPaymentComplete(String s) {
        try {
            if (chooseMoneyOptionsFragment != null) {
                chooseMoneyOptionsFragment.dismiss();
                chooseMoneyOptionsFragment = null;
                finishActivity();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getOrderId(String orderId) {

        walletId = orderId;
    }

    @Override
    public int getAmount() {
        return paybleAmount;
    }

    @Override
    public String getCouponGUID() {
        return couponGUID;
    }

    @Override
    public String getCode() {
        return offerCode;
    }

    @Override
    public void payUMoneyResponseSuccess(LoginResponseOut responseLogin) {
        showSnackBar(responseLogin.getMessage());
        finishActivity();
    }

    @Override
    public void payUMoneyResponseFailure(String errMsg) {
        showSnackBar(errMsg);
    }

    @Override
    public void changePasswordSuccess(LoginResponseOut responseLogin) {

    }

    @Override
    public void changePasswordFailure(String errMsg) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       /* if (requestCode == ValidateCodeActivity.REQUEST_CODE_VALIDATE && resultCode == Activity.RESULT_OK) {


            if (data.hasExtra("offerCode")) {
                offerCode = data.getStringExtra("offerCode");
            }

            haveACode.setText(AppUtils.getStrFromRes(R.string.offer_code_applied));
            haveACode.setTextColor(ContextCompat.getColor(mContext, R.color.button_green));
            isCodeValid = true;
        }*/
       /* if (chooseMoneyOptionsFragment != null)
            chooseMoneyOptionsFragment.onActivityResult(requestCode, resultCode, data);


        // Result Code is -1 send from Payumoney activity
        Log.i(TAG, "request code " + requestCode + " resultcode " + resultCode);
        MyAccountActivity.isRefresh = true;
        if (requestCode == PayUmoneyFlowManager.REQUEST_CODE_PAYMENT &&
                resultCode == Activity.RESULT_OK && data != null) {
            TransactionResponse transactionResponse = data.getParcelableExtra(PayUmoneyFlowManager.INTENT_EXTRA_TRANSACTION_RESPONSE);
            ResultModel resultModel = data.getParcelableExtra(PayUmoneyFlowManager.ARG_RESULT);

            // Check which object is non-null
            if (transactionResponse != null && transactionResponse.getPayuResponse() != null) {
                // Response from Payumoney
                String payuResponse = transactionResponse.getPayuResponse();
                Log.i(TAG, "" + "Payu's Data : " + payuResponse);
                if (transactionResponse.getTransactionStatus().equals(TransactionResponse.TransactionStatus.SUCCESSFUL)) {
                    //Success Transaction
                    showSnackBar("Success Transaction.");
                    finishActivity();
                } else {
                    //Failure Transaction
                    showSnackBar("Failure Transaction.");
                }
            } else if (resultModel != null && resultModel.getError() != null) {
                Log.d(TAG, "Error response : " + resultModel.getError().getTransactionResponse());
            } else {
                Log.d(TAG, "Both objects are null!");
                finishActivity();
            }
        }
*/

    }


    @Override
    public void onPaymentSuccess(String razorpayPaymentID) {

        try {
            Toast.makeText(getContext(), "Payment Successful ", Toast.LENGTH_SHORT).show();

           /* Log.d(TAG, "onPaymentSuccess: " + razorpayPaymentID);
            mRazorPayPresenterImpl.actionRazorPay(AppSession.getInstance().getLoginSession().getResponse().getLoginSessionKey(),
                    razorpayPaymentID, AppSession.getInstance().getLoginSession().getResponse().getUserId());*/

            confirmPayment(razorpayPaymentID, Constant.Success);
            onPaymentComplete("Payment Successful ");

            if (matchId != null && statusId != null) {
                if (!matchId.equals("") && !statusId.equals("")) {
                    MatchContestActivity.start(mContext, matchId, statusId);
                    finishActivity();
                }

            }else {


                MyAccountActivity.start(mContext);
                finishActivity();
            }

        } catch (Exception e) {
            Log.e(TAG, "Exception in onPaymentSuccess", e);
        }
    }

    @Override
    public void onPaymentError(int code, String response) {

        try {
            if (code == 0) {
                Toast.makeText(getContext(), "" + response, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "" + response, Toast.LENGTH_SHORT).show();
            }

            confirmPayment(String.valueOf(code), Constant.Failed);
            Log.i(TAG, "onPaymentError: " + response + ", code: " + code);
            onPaymentComplete("Payment Failed ");

        } catch (Exception e) {
            Log.e(TAG, "Exception in onPaymentError", e);
        }

    }

    void confirmPayment(String razorpayPaymentID, String status) {
        MyAccountActivity.isRefresh = true;

        PayTmPresenterImpl mPayTmPresenterImpl = new PayTmPresenterImpl(this, new UserInteractor());

        PaytmInput paytmInput = new PaytmInput();
        paytmInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());

        paytmInput.setPaymentGateway(Constant.RAZORPAY);
        paytmInput.setPaymentGatewayStatus(status);
        paytmInput.setWalletID(walletId);
        paytmInput.setAmount(String.valueOf(getAmount()));
        paytmInput.setRazor_payment_id(razorpayPaymentID);
        mPayTmPresenterImpl.actionPayTmResponseBtn(paytmInput);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
