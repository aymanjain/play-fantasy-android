package com.mw.eleven11.UI.bankVerify;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.UploadImageInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.ResponseCountries;
import com.mw.eleven11.beanOutput.StatesBean;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomSpinner;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.ActivityUtils;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.ViewUtils;
import com.mw.eleven11.utility.uploadPicUtil.PicUploadBaseActivity;
import com.mw.eleven11.utility.uploadPicUtil.UCropperUtil;
import com.rey.material.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;


public class VerifyBankFragment extends BaseFragment implements VerifyBankView {


    @BindView(R.id.iv_bank)
    ImageView iv_bank;

    Loader loader;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.edt_first_name)
    CustomEditText mCustomEditTextFirstName;
    @BindView(R.id.edt_account)
    CustomEditText mCustomEditTextAccount;

    /* Butter Knife : view mapping */
    @BindView(R.id.edt_account_ifsc)
    CustomEditText mCustomEditTextAccountIFSC;
    @BindView(R.id.edt_bank_name)
    CustomEditText mCustomEditViewBankName;
    @BindView(R.id.edt_branch_name)
    CustomEditText mCustomEditViewBranchName;
    @BindView(R.id.ctv_why)
    CustomTextView mCustomTextViewWhy;
    @BindView(R.id.ctv_save)
    CustomTextView mCustomTextViewSave;
    @BindView(R.id.cs_country)
    CustomSpinner customSpinnerCountry;
    @BindView(R.id.cs_state)
    CustomSpinner customSpinnerState;
    @BindView(R.id.civ_bank)
    CustomImageView mCustomImageViewBank;
    @BindView(R.id.ctv_account_no)
    CustomTextView mCustomTextViewAccountNumber;
    @BindView(R.id.ctv_bank_message)
    CustomTextView mCustomTextViewBankMessage;
    @BindView(R.id.scrollBank)
    NestedScrollView scrollBank;
    @BindView(R.id.ll_bank)
    LinearLayout llBank;
    @BindView(R.id.card_item_bank_verified)
    CardView cardViewVerified;
    @BindView(R.id.card_item_bank_warning)
    CardView cardItemBankWarning;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;
    String bankFile = "";
    AlertDialog alertExitDialog;
    LoginResponseOut responseLogin;
    private Context mContext;
    private VerifyBankPresenterImpl mUpdateProfilePresenterImpl;
    private ProgressDialog mProgressDialog;
    private boolean isStateInitialise = false;

    public static VerifyBankFragment getInstance() {
        VerifyBankFragment profileFragment = new VerifyBankFragment();
        return profileFragment;
    }

    @OnClick(R.id.civ_bankRoot)
    public void pan(View view) {
        ((PicUploadBaseActivity) getActivity()).showPicUploadOptions(UCropperUtil.DYNAMIC, 3, 2);
    }

    @OnClick(R.id.ctv_save)
    public void save(View view) {

        String loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();
        String name = mCustomEditTextFirstName.getText().toString().trim();
        String accountNumber = mCustomEditTextAccount.getText().toString().trim();
        String accountIFSC = mCustomEditTextAccountIFSC.getText().toString().trim();
        String state = customSpinnerState.getSelectedValue();
        String country = customSpinnerCountry.getSelectedValue();
        String bankName = mCustomEditViewBankName.getText().toString().trim();
        String branchName = mCustomEditViewBranchName.getText().toString().trim();

        UploadImageInput uploadImageInput = new UploadImageInput();

        uploadImageInput.setFilePath(bankFile);
        uploadImageInput.setSection("BankDetail");
        uploadImageInput.setSessionKey(loginSessionKey);

      /*  {
	"FullName": "Suhail Khan",
	"Bank": "HDFC",
	"AccountNumber": "65656456456",
	"BirthDate": "2018-10-21",
	"IFSCCode": "HFF689798",
	"BranchName": "Palasia",
	"Country": "In",
	"State": "MP"

}*/

        JSONObject captionJSON = new JSONObject();
        try {
            captionJSON.put("FullName", name);
            captionJSON.put("Bank", bankName);
            captionJSON.put("AccountNumber", accountNumber);
            captionJSON.put("IFSCCode", accountIFSC);
            captionJSON.put("BranchName", branchName);
            captionJSON.put("BranchName", branchName);

            captionJSON.put("CountryCode", "IN");
            captionJSON.put("State", state);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        uploadImageInput.setMediaCaption(captionJSON.toString());

        mUpdateProfilePresenterImpl.uploadImage(uploadImageInput);


    }

    @OnClick(R.id.ctv_why)
    public void why(View view) {
        if (alertExitDialog == null)
            alertExitDialog = new AlertDialog(getContext(), AppUtils.getStrFromRes(R.string.why_bank), AppUtils.getStrFromRes(R.string.okay), "", new AlertDialog.OnBtnClickListener() {
                @Override
                public void onYesClick() {

                }

                @Override
                public void onNoClick() {

                }
            });
        alertExitDialog.show();
    }

    @Override
    public int getLayout() {
        return R.layout.verify_bank;
    }

    @Override
    public void init() {
        loader = new Loader(getCurrentView());
        ActivityUtils.performActionOnDone(mCustomEditTextAccount, mCustomTextViewSave);//handle action done event of keyboard
        mContext = getActivity();
        mUpdateProfilePresenterImpl = new VerifyBankPresenterImpl(this, new UserInteractor());
        customSpinnerState.setVisibility(View.VISIBLE);
        ViewUtils.setUnderline(mCustomTextViewWhy);

        loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callViewProfile();
            }
        });

        // Setup refresh listener which triggers new data loading
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //view profile calling
                callViewProfile();

            }
        });
        // Configure the refreshing colors
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark,
                R.color.colorPrimary,
                R.color.secondary_tab_color);

        //view profile calling
        callViewProfile();

        setStateFromGson();

    }

    void callViewProfile() {
        LoginInput mLoginInput = new LoginInput();
        mLoginInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mLoginInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
        mLoginInput.setParams(Constant.GET_PROFILE_PARAMS);
        mUpdateProfilePresenterImpl.actionViewProfile(mLoginInput);
    }

    void setStateFromGson() {
        try {
            Gson gson = new Gson();
            String jsonStates = AppUtils.AssetJSONFile("states.json", mContext);

            Log.d("jsonStatesS", jsonStates);
            StatesBean mStatesBean = gson.fromJson(jsonStates, StatesBean.class);

            customSpinnerState.setJsonResource(mStatesBean);

        } catch (IOException e) {
            e.printStackTrace();
        }
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
        hideLoading();
        if (isAdded() && getActivity() != null) {
            loader.hide();
            this.responseLogin = responseLogin;
            if (responseLogin.getData().getPhoneStatus().equals(Constant.Verified)
                    && responseLogin.getData().getEmailStatus().equals(Constant.Verified)

                    && responseLogin.getData().getPanStatus().equals(Constant.Verified)) {
                cardItemBankWarning.setVisibility(View.GONE);
                if (responseLogin.getData().getBankStatus().equals(Constant.Verified)) {
                    //verified
                    cardViewVerified.setVisibility(View.VISIBLE);
                    scrollBank.setVisibility(View.INVISIBLE);
                    mCustomTextViewBankMessage.setText(AppUtils.getStrFromRes(R.string.your_bank_details_is_verified));
                    iv_bank.setImageResource(R.drawable.ic_kyc);
                } else if (responseLogin.getData().getBankStatus().equals(Constant.Pending)) {
                    //pending
                    cardViewVerified.setVisibility(View.VISIBLE);
                    scrollBank.setVisibility(View.INVISIBLE);
                    mCustomTextViewBankMessage.setText(AppUtils.getStrFromRes(R.string.your_bank_details_is_in_pending));
                    iv_bank.setImageResource(R.drawable.ic_kyc_pending);
                } else if (responseLogin.getData().getBankStatus().equals(Constant.Rejected)) {
                    //canceled
                    cardViewVerified.setVisibility(View.GONE);
                    scrollBank.setVisibility(View.VISIBLE);

                    try {
                        JSONObject jsonObject = new JSONObject(responseLogin.getData().getMediaBANK().getMediaCaption());
                        setAccount(jsonObject.getString("AccountNumber"));
                        setIfsc(jsonObject.getString("IFSCCode"));
                        setName(jsonObject.getString("FullName"));
                        setBankName(jsonObject.getString("Bank"));
                        setBranchName(jsonObject.getString("BranchName"));
                        setCountry(jsonObject.getString("CountryCode"));
                        setState(jsonObject.getString("State"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    cardViewVerified.setVisibility(View.GONE);
                    scrollBank.setVisibility(View.VISIBLE);
                }
            } else {
                cardViewVerified.setVisibility(View.GONE);
                cardItemBankWarning.setVisibility(View.VISIBLE);
                scrollBank.setVisibility(View.GONE);
            }

        }
    }

    public void setCountry(@NonNull String country) {
        customSpinnerCountry.setValue(country);
    }

    public void setState(@NonNull String state) {
        customSpinnerState.setValue(state);
    }

    public void setAccount(@NonNull String value) {
        if (!TextUtils.isEmpty(value)) {
            mCustomEditTextAccount.setText(value);
        }
    }

    public void setIfsc(@NonNull String value) {
        if (!TextUtils.isEmpty(value)) {
            mCustomEditTextAccountIFSC.setText(value);
        }
    }

    public void setName(@NonNull String value) {
        if (!TextUtils.isEmpty(value)) {
            mCustomEditTextFirstName.setText(value);
        }
    }

    public void setBankName(@NonNull String value) {
        if (!TextUtils.isEmpty(value)) {
            mCustomEditViewBankName.setText(value);
        }
    }

    public void setBranchName(@NonNull String value) {
        if (!TextUtils.isEmpty(value)) {
            mCustomEditViewBranchName.setText(value);
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
    public void verifyPanSuccess(final LoginResponseOut responseLogin) {
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, responseLogin.getMessage());
        init();
    }

    @Override
    public void verifyPanFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void onStatesSuccess(final ResponseCountries responseStates) {
        if (isAdded()) {
            customSpinnerState.setVisibility(View.VISIBLE);
            ArrayList<HashMap<String, String>> values = new ArrayList<>();
            HashMap<String, String> item1 = new HashMap<>();
            item1.put("value", "");
            item1.put("title", AppUtils.getStrFromRes(R.string.select_state));
            values.add(item1);
            for (ResponseCountries.ResponseBean keyword : responseStates.getResponse()) {
                HashMap<String, String> item = new HashMap<>();
                item.put("value", keyword.getId() + "");
                item.put("title", keyword.getName());
                values.add(item);
            }
            customSpinnerState.setCustomResource(new ArrayList<HashMap<String, String>>(values));
           /* if (!isStateInitialise && responseLogin != null && !TextUtils.isEmpty(responseLogin.getResponse().getState())) {
                isStateInitialise = true;
                customSpinnerState.setValue(responseLogin.getResponse().getState());
            } else {
                customSpinnerState.setValue("");
            }*/
        }

    }

    @Override
    public void onStatesFailure(String errMsg) {
        if (isAdded())
            hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void onHideLoading() {
        if (isAdded())
            loader.hide();
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onShowLoading() {
        if (isAdded())
            loader.start();
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onCountriesFailure(String error) {
        if (isAdded())
            loader.error(error);
    }

    @Override
    public void onCountriesSuccess(ResponseCountries responseCountries) {

        if (isAdded()) {
            loader.hide();
            ArrayList<HashMap<String, String>> values = new ArrayList<>();
            HashMap<String, String> item1 = new HashMap<>();
            item1.put("value", "");
            item1.put("title", AppUtils.getStrFromRes(R.string.select_country));
            values.add(item1);
            for (ResponseCountries.ResponseBean keyword : responseCountries.getResponse()) {
                HashMap<String, String> item = new HashMap<>();
                item.put("value", keyword.getId() + "");
                item.put("title", keyword.getName());
                values.add(item);
            }

            customSpinnerCountry.setCustomResource(new ArrayList<HashMap<String, String>>(values), R.layout.item_spinner_header, R.layout.item_spinner);


            customSpinnerCountry.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
                @Override
                public void onItemSelected(Spinner parent, View view, int position, long id) {
                    customSpinnerState.setVisibility(View.GONE);
                    if (position > 0) {
                        //mUpdateProfilePresenterImpl.actionStatesBtn(AppSession.getInstance().getLoginSession().getResponse().getLoginSessionKey(), customSpinnerCountry.getSelectedValue());
                    }
                }
            });
        }

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

    public void bankPicture(String path) {
        bankFile = path;
        ViewUtils.setImagePath(mCustomImageViewBank, path);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
