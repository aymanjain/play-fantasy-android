package com.mw.eleven11.UI.mobileAndEmailVerify;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.verifyOtp.VerifyOTPActivity;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.VerifyMobileInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;

import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.ActivityUtils;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class VerifyMobileEmailFragment extends BaseFragment implements VerifyMobileEmailView {


    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;


    Loader loader;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.edt_email)
    CustomEditText mCustomEditTextEmail;
    @BindView(R.id.edt_mobile)
    CustomEditText mCustomEditTextMobile;


    /* Butter Knife : view mapping */
    @BindView(R.id.ctv_send_code)
    CustomTextView mCustomTextViewSendCode;
    @BindView(R.id.ctv_send_otp)
    CustomTextView mCustomTextViewSendOtp;
    @BindView(R.id.ctv_mobile_no)
    CustomTextView mCustomTextViewMobile;
    @BindView(R.id.ctv_email_no)
    CustomTextView mCustomTextViewEmail;
    @BindView(R.id.card_item_email_not_verified)
    CardView cardItemEmailNotVerified;
    @BindView(R.id.card_item_email_verified)
    CardView cardItemEmailVerified;
    @BindView(R.id.card_item_mobile_not_verified)
    CardView cardItemMobileNotVerified;
    @BindView(R.id.card_item_mobile_verified)
    CardView cardItemMobileVerified;
    private Context mContext;
    private VerifyMobileEmailPresenterImpl mUpdateProfilePresenterImpl;
    private ProgressDialog mProgressDialog;

    public static VerifyMobileEmailFragment getInstance() {
        VerifyMobileEmailFragment profileFragment = new VerifyMobileEmailFragment();
        return profileFragment;
    }

    @OnClick(R.id.ctv_send_code)
    public void sendCode(View view) {


        if (checkAndRequestPermissions()) {
            // carry on the normal flow, as the case of  permissions  granted.
            callForOTP();

        }

    }

    void callForOTP() {

        String email = mCustomEditTextEmail.getText().toString().trim();
        String loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();
        VerifyMobileInput mobileInput= new VerifyMobileInput();
        mobileInput.setSessionKey(loginSessionKey);
        mobileInput.setEmail(email);
        mUpdateProfilePresenterImpl.actionSendEmailCodeBtn(mobileInput);
    }

    @OnClick(R.id.ctv_send_otp)
    public void sendOtp(View view) {

        String loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();
        String mobile = mCustomEditTextMobile.getText().toString().trim();

        VerifyMobileInput mobileInput= new VerifyMobileInput();
        mobileInput.setSessionKey(loginSessionKey);
        mobileInput.setPhoneNumber(mobile);

        // AppSession.getInstance().getLoginSession().getData().setPhoneNumber(mobile);

        mUpdateProfilePresenterImpl.actionSendMobileOtpBtn(mobileInput);
    }


    @OnClick(R.id.changeNo)
    public void changeNo(View view) {
        mCustomEditTextMobile.setText("");
        cardItemMobileVerified.setVisibility(View.GONE);
        cardItemMobileNotVerified.setVisibility(View.VISIBLE);
    }

    @Override
    public int getLayout() {
        return R.layout.verify_email_mobile;
    }

    @Override
    public void init() {
        loader = new Loader(getCurrentView());
        ActivityUtils.performActionOnDone(mCustomEditTextEmail, mCustomTextViewSendCode);//handle action done event of keyboard
        ActivityUtils.performActionOnDone(mCustomEditTextMobile, mCustomTextViewSendOtp);//handle action done event of keyboard
        mContext = getActivity();
        mUpdateProfilePresenterImpl = new VerifyMobileEmailPresenterImpl(this, new UserInteractor());

        loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callViewProfile();
            }
        });


        callViewProfile();
    }

    void callViewProfile() {
        LoginInput mLoginInput = new LoginInput();
        mLoginInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mLoginInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
        mLoginInput.setParams(Constant.GET_PROFILE_PARAMS);
        mUpdateProfilePresenterImpl.actionViewProfile(mLoginInput);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUpdateProfilePresenterImpl != null) mUpdateProfilePresenterImpl.actionLoginCancel();
    }

    @Override
    public void onProfileFailure(String error) {
        if (isAdded() && getActivity() != null) {
            loader.error(error);
        }
    }

    @Override
    public void onProfileSuccess(LoginResponseOut responseLogin) {

        AppSession.getInstance().getLoginSession().getData().setPhoneNumber(responseLogin.getData().getPhoneNumber());

        if (isAdded() && getActivity() != null) {
            loader.hide();
            if (responseLogin.getData().getEmailStatus().equals(Constant.Verified)) {
                cardItemEmailVerified.setVisibility(View.VISIBLE);
                cardItemEmailNotVerified.setVisibility(View.GONE);
                mCustomTextViewEmail.setText(responseLogin.getData().getEmail());
            } else {
                mCustomEditTextEmail.setText(responseLogin.getData().getEmail() + "");
                cardItemEmailVerified.setVisibility(View.GONE);
                cardItemEmailNotVerified.setVisibility(View.VISIBLE);
            }

            if (responseLogin.getData().getPhoneStatus().equals(Constant.Verified)) {
                cardItemMobileVerified.setVisibility(View.VISIBLE);
                cardItemMobileNotVerified.setVisibility(View.GONE);
                mCustomTextViewMobile.setText(responseLogin.getData().getPhoneNumber());
            } else {
                mCustomEditTextMobile.setText(responseLogin.getData().getPhoneNumber());
                cardItemMobileVerified.setVisibility(View.GONE);
                cardItemMobileNotVerified.setVisibility(View.VISIBLE);
            }

        }
    }

    @Override
    public void setEmail(@NonNull String value) {
        if (!TextUtils.isEmpty(value)) {
            mCustomEditTextEmail.setText(value);
        }
    }

    @Override
    public void setMobile(@NonNull String value) {
        if (!TextUtils.isEmpty(value)) {
            mCustomEditTextEmail.setText(value);
        }
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
    public void verifyEmailSuccess(final LoginResponseOut responseLogin) {
        AppUtils.showToast(mContext, responseLogin.getMessage());
        String email = mCustomEditTextEmail.getText().toString().trim();
        VerifyOTPActivity.start(mContext, email, false,"Email");
    }

    @Override
    public void verifyEmailFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void verifyMobileSuccess(final LoginResponseOut responseLogin) {
        AppUtils.showToast(mContext, responseLogin.getMessage());
        String mobile = mCustomEditTextMobile.getText().toString().trim();

        VerifyOTPActivity.start(mContext, mobile, false,"Mobile");
    }

    @Override
    public void verifyMobileFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }


    @Override
    public void onHideLoading() {
        loader.hide();
    }

    @Override
    public void onShowLoading() {
        loader.start();
    }


    @Override
    public void showSnackBar(@NonNull String message) {
        hideLoading();
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, message);
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        init();
    }

    public boolean checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && getActivity().checkSelfPermission(Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            int receiveSMS = ContextCompat.checkSelfPermission(mContext, Manifest.permission.RECEIVE_SMS);
            int readSMS = ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_SMS);
            List<String> listPermissionsNeeded = new ArrayList<>();
            if (receiveSMS != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(Manifest.permission.RECEIVE_SMS);
            }
            if (readSMS != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(Manifest.permission.READ_SMS);
            }
            if (!listPermissionsNeeded.isEmpty()) {
                ActivityCompat.requestPermissions(getActivity(),
                        listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
                return false;
            }
            return true;
        }
        return true;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_ID_MULTIPLE_PERMISSIONS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Log.d("REQUEST_ID_MULTIPLE", "permission was granted, yay! Do the\n" +
                            "                    // contacts-related task you need to do.");
                    callForOTP();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    Log.d("REQUEST_ID_MULTIPLE", " permission denied, boo! Disable the\n" +
                            "                    // functionality that depends on this permission");

                    callForOTP();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUpdateProfilePresenterImpl.responseLoginCall!=null) {
            if (!mUpdateProfilePresenterImpl.responseLoginCall.isCanceled()) {
                mUpdateProfilePresenterImpl.responseLoginCall.cancel();
            }
            mUpdateProfilePresenterImpl.responseLoginCall=null;
        }
    }




}
