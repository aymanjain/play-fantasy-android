package com.mw.eleven11.UI.chooseMoney;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.myAccount.MyAccountActivity;
import com.mw.eleven11.UI.payTm.PayTmPresenterImpl;
import com.mw.eleven11.UI.payTm.PayTmView;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.PaytmInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.ResponsePayTmDetails;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Set;


/**
 *
 */
public class ChooseMoneyPresenter implements PayTmView {
    public static final int REQUEST_CODE_PAYTM = 1299;
    public static final int REQUEST_CODE_PAYUMONEY = 1300;
    public static final int REQUEST_CODE_RAZORPAY = 1301;
    public static final String TAG = "ChooseMoneyPresenter : ";
    ChooseMoneyCallback mView;
    String amount="";
    int rqcode=0;
    String couponGuid;
    private  PayTmPresenterImpl mPayTmPresenterImpl;

    private ProgressDialog mProgressDialog;



    public ChooseMoneyPresenter(ChooseMoneyCallback mView) {
        this.mView = mView;
    }

    public void actionPaytmBtn(int requestCode) {

        mPayTmPresenterImpl = new PayTmPresenterImpl(this, new UserInteractor());
        amount = mView.getAmount()+"";
        rqcode = requestCode;
        couponGuid = mView.getCouponGUID();
        String firstname = AppSession.getInstance().getLoginSession().getData().getFirstName();
        String email = AppSession.getInstance().getLoginSession().getData().getEmail();
        String phone = "";


       callViewProfile();

    }

    void callViewProfile() {
        LoginInput mLoginInput = new LoginInput();
        mLoginInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mLoginInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
        mLoginInput.setParams(Constant.GET_PROFILE_PARAMS);
        mPayTmPresenterImpl.actionViewProfile(mLoginInput);
    }



    @Override
    public void showLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mView.getContext());
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();

    }

    @Override
    public void payTmDetailsSuccess(ResponsePayTmDetails responseLogin) {

        if(responseLogin.getData().getCheckSumHash()!=null){
            onStartTransaction(responseLogin);
        }else {

          /*  mView.getOrderId(String.valueOf(responseLogin.getData().getOrderID()));
            actionRazorPayBtn(mView.getActivity(),REQUEST_CODE_RAZORPAY ,
                    String.valueOf(responseLogin.getData().getOrderID()),
                    String.valueOf(AppSession.getInstance().getLoginSession().getData().getUserID()));*/
        }


    }

    @Override
    public void payTmDetailsFailure(String errMsg) {

        showSnackBar(errMsg);

    }

    @Override
    public void payTmResponseSuccess(LoginResponseOut responseLogin) {
        showSnackBar(responseLogin.getMessage());
        completed("Completed");
    }



    @Override
    public void payTmResponseFailure(String errMsg) {
        showSnackBar(errMsg);
    }

    @Override
    public void showSnackBar(String message) {
        AppUtils.showToast(mView.getContext(), message);
    }

    @Override
    public void onProfileSuccess(LoginResponseOut responseLogin) {

        if (!responseLogin.getData().getPhoneStatus().equals(Constant.Verified)) {
            showSnackBar(AppUtils.getStrFromRes(R.string.pleaceVerifyMobile));
            return;
        }

        if (!responseLogin.getData().getEmailStatus().equals(Constant.Verified)){

            showSnackBar(AppUtils.getStrFromRes(R.string.pleaceVerifyEmail));
            return;
        }

        PaytmInput paytmInput= new PaytmInput();
        paytmInput.setRequestSource(Constant.MOBILE);
        if(rqcode==REQUEST_CODE_PAYTM){
            paytmInput.setPaymentGateway(Constant.PAYTM);
        }else {
            paytmInput.setPaymentGateway(Constant.RAZORPAY);
        }

        paytmInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        paytmInput.setAmount(amount);
        paytmInput.setFirstName(AppSession.getInstance().getLoginSession().getData().getFirstName());
        paytmInput.setEmail(AppSession.getInstance().getLoginSession().getData().getEmail());
        paytmInput.setPhoneNumber( responseLogin.getData().getPhoneNumber());
        if (couponGuid!=null) {
            paytmInput.setCouponGUID(couponGuid);
        }

        mPayTmPresenterImpl.actionPayTmDetailsBtn(paytmInput);


    }

    @Override
    public void onProfileFailure(String errMsg) {

    }


    @Override
    public Context getContext() {
        return mView.getContext();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        completed("Completed");
    }


    private void completed(String message) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.onPaymentComplete("completed");
            }
        }, 200);
    }


    public void onStartTransaction(final ResponsePayTmDetails details) {
        //PaytmPGService Service = PaytmPGService.getProductionService();

        PaytmPGService Service = PaytmPGService.getStagingService();

        final HashMap<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("CALLBACK_URL", details.getData().getCallbackURL());
        paramMap.put("CHANNEL_ID", details.getData().getChannelID());
        paramMap.put("CUST_ID", details.getData().getCustomerID());
        paramMap.put("INDUSTRY_TYPE_ID", details.getData().getIndustryTypeID());
        paramMap.put("MID", details.getData().getMerchantID());
        paramMap.put("ORDER_ID", String.valueOf(details.getData().getOrderID()));
        paramMap.put("TXN_AMOUNT",String.valueOf( details.getData().getAmount()));
        paramMap.put("WEBSITE", details.getData().getWebsite());
        paramMap.put("CHECKSUMHASH", details.getData().getCheckSumHash());


        Log.d("CALLBACKURL", " CALLBACKURL: " + details.getData().getCallbackURL());
        PaytmOrder Order = new PaytmOrder(paramMap);

        Service.initialize(Order, null);

        Service.startPaymentTransaction(mView.getContext(), true, true,
                new PaytmPaymentTransactionCallback()
                {

                    @Override
                    public void someUIErrorOccurred(String inErrorMessage) {
                        // Some UI Error Occurred in Payment Gateway Activity.
                        // // This may be due to initialization of views in
                        // Payment Gateway Activity or may be due to //
                        // initialization of webview. // Error Message details
                        // the error occurred.


                    }

                    @Override
                    public void onTransactionResponse(Bundle inResponse) {
                        Log.d("LOG", "Payment Transaction : " + inResponse);
                        Log.d("PAYEleven11","inResponse:  "+inResponse);
                        JSONObject jsonResponce = new JSONObject();
                        Set<String> keys = inResponse.keySet();
                        try {
                            // json.put(key, bundle.get(key)); see edit below
                            for (String key : keys) {
                                jsonResponce.put(key, inResponse.get(key));

                                Log.d(key, inResponse.get(key) + "");
                            }
                            jsonResponce.put("CUST_ID", details.getData().getCustomerID());
                        } catch (JSONException e) {
                            //Handle exception here
                        }

                        String paymentGatwayStatus="";
                        if(inResponse.getString("STATUS").equals("TXN_FAILURE")){
                            paymentGatwayStatus="Failed";
                        }
                        if(inResponse.getString("STATUS").equals("TXN_SUCCESS")){
                            paymentGatwayStatus="Success";
                        }
                        Log.d("inResponse", "Payment Transaction : " + jsonResponce.toString());
                        MyAccountActivity.isRefresh = true;

                        PaytmInput paytmInput= new PaytmInput();
                        paytmInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
                        paytmInput.setPaymentGatewayResponse(jsonResponce.toString());
                        paytmInput.setPaymentGateway(Constant.PAYTM);
                        paytmInput.setPaymentGatewayStatus(paymentGatwayStatus);
                        paytmInput.setWalletID(String.valueOf(details.getData().getOrderID()));
                        mPayTmPresenterImpl.actionPayTmResponseBtn(paytmInput);

                    }

                    @Override
                    public void networkNotAvailable() {
                        // If network is not
                        // available, then this
                        // method gets called.
                        showSnackBar(AppUtils.getStrFromRes(R.string.network_error));
                        completed(AppUtils.getStrFromRes(R.string.network_error));
                    }

                    @Override
                    public void clientAuthenticationFailed(String inErrorMessage) {
                        // This method gets called if client authentication
                        // failed. // Failure may be due to following reasons //
                        // 1. Server error or downtime. // 2. Server unable to
                        // generate checksum or checksum response is not in
                        // proper format. // 3. Server failed to authenticate
                        // that client. That is value of payt_STATUS is 2. //
                        // Error Message describes the reason for failure.

                        showSnackBar(inErrorMessage);
                        completed(inErrorMessage);
                    }

                    @Override
                    public void onErrorLoadingWebPage(int iniErrorCode,
                                                      String inErrorMessage, String inFailingUrl) {
                        Log.d("PAYEleven11","iniErrorCode:  "+iniErrorCode);
                        Log.d("PAYEleven11","inErrorMessage: "+inErrorMessage);
                        Log.d("PAYEleven11","inFailingUrl: "+inFailingUrl);

                    }

                    // had to be added: NOTE
                    @Override
                    public void onBackPressedCancelTransaction() {
                        // TODO Auto-generated method stub
                        Log.d("iniErrorCode","onBackPressedCancelTransaction");
                    }

                    @Override
                    public void onTransactionCancel(String inErrorMessage, Bundle inResponse) {
                        Log.d("LOG", "Payment Transaction Failed " + inErrorMessage);
                        showSnackBar("Payment Transaction Canceled ");
                        completed("Completed");
                    }

                });
    }

    public void actionRazorPayBtn(Activity activity, int requestCode , String order_id, String user_id) {

        try {
           /* if (*//*AppSession.getInstance().getLoginSession().getResponse().getEmailVerify().equals("1") && *//*AppSession.getInstance().getLoginSession().getData().getPhoneStatus().equals(Constant.Verified)) {*/

                double amountInPaise= mView.getAmount()*100;
                String firstname = AppSession.getInstance().getLoginSession().getData().getFirstName();
                String email = AppSession.getInstance().getLoginSession().getData().getEmail();
                String phone = "";
                phone = AppSession.getInstance().getLoginSession().getData().getPhoneNumber();


                startPayment(activity, firstname, "Add Cash", "INR",
                        String.valueOf(amountInPaise), email, phone, order_id, user_id);
           /* }else {
                 showSnackBar(AppUtils.getStrFromRes(R.string.payment_verification_message));
            }*/
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void startPayment(final Activity activity, String name, String description, String currency,
                             String amount, String email, String contact, String order_id, String user_id) {
        /*
          You need to pass current activity in order to let Razorpay create CheckoutActivity
         */

        try {

            final Checkout co = new Checkout();

            JSONObject node= new JSONObject();
            node.put("OrderID", order_id);
            node.put("UserID", user_id);

            JSONObject options = new JSONObject();
            options.put("name", name);
            options.put("description", description);
            //You can omit the image option to fetch the image from dashboard
            //options.put("image", "https://rzp-mobile.s3.amazonaws.com/images/rzp.png");
            options.put("currency", currency);
            options.put("amount", amount);
            options.put("notes",node);

            JSONObject preFill = new JSONObject();
            preFill.put("email", email);
            preFill.put("contact", contact);
            options.put("prefill", preFill);

            co.open(activity, options);

        } catch (Exception e) {
            Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
            e.printStackTrace();
        }
    }
}
