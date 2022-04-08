package com.mw.eleven11.UI.panVerify;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
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
import com.mw.eleven11.dialog.DatePickerDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.ActivityUtils;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;
import com.mw.eleven11.utility.uploadPicUtil.PicUploadBaseActivity;
import com.mw.eleven11.utility.uploadPicUtil.UCropperUtil;
import com.rey.material.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;


public class VerifyPanFragment extends BaseFragment implements VerifyPanView {

    Loader loader;

    @BindView(R.id.iv_mobile)
    ImageView iv_mobile;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.edt_first_name)
    CustomEditText mCustomEditTextFirstName;
    @BindView(R.id.edt_pan)
    CustomEditText mCustomEditTextPan;

    /* Butter Knife : view mapping */
    @BindView(R.id.ctv_why)
    CustomTextView mCustomTextViewWhy;
    @BindView(R.id.ctv_save)
    CustomTextView mCustomTextViewSave;
    @BindView(R.id.ctv_dob)
    CustomTextView mCustomTextViewDob;
    @BindView(R.id.cs_country)
    CustomSpinner customSpinnerCountry;
    @BindView(R.id.cs_state)
    CustomSpinner customSpinnerState;
    @BindView(R.id.civ_pan)
    CustomImageView mCustomImageViewPan;
    @BindView(R.id.ctv_pan_no)
    CustomTextView mCustomTextViewPanNumber;
    @BindView(R.id.ctv_pan_message)
    CustomTextView mCustomTextViewPanMessage;
    @BindView(R.id.scrollPan)
    NestedScrollView scrollPan;
    @BindView(R.id.ll_pan)
    LinearLayout llPan;
    @BindView(R.id.card_item_pan_verified)
    CardView cardViewPan;
    @BindView(R.id.card_item_pan_warning)
    CardView panWarning;
    AlertDialog alertExitDialog;
    String panCardFile = "";
    Calendar calendarDob = Calendar.getInstance();
    LoginResponseOut responseLogin;
    private Context mContext;
    private VerifyPanPresenterImpl mUpdateProfilePresenterImpl;
    private ProgressDialog mProgressDialog;
    private DatePickerDialog datePickerDialog;
    private boolean isStateInitialise = false;

    public static VerifyPanFragment getInstance() {
        VerifyPanFragment profileFragment = new VerifyPanFragment();
        return profileFragment;
    }

    @OnClick(R.id.civ_panRoot)
    public void pan(View view) {
        ((PicUploadBaseActivity) getActivity()).showPicUploadOptions(UCropperUtil.DYNAMIC, 3, 2);
    }

    @OnClick(R.id.ctv_why)
    public void why(View view) {
        if (alertExitDialog == null)
            alertExitDialog = new AlertDialog(getContext(), AppUtils.getStrFromRes(R.string.why_pan), AppUtils.getStrFromRes(R.string.okay), "", new AlertDialog.OnBtnClickListener() {
                @Override
                public void onYesClick() {

                }

                @Override
                public void onNoClick() {

                }
            });
        alertExitDialog.show();
    }

    @OnClick(R.id.ctv_dob)
    public void dob(View view) {
        initDateDialog();
        datePickerDialog.show();

    }

    private void initDateDialog() {
        if (datePickerDialog == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -16);
            datePickerDialog = new DatePickerDialog(mContext, calendarDob, AppUtils.getStrFromRes(R.string.please_select_date), new DatePickerDialog.OnClickListener() {
                @Override
                public void onDateSet(String dob) {
                    mCustomTextViewDob.setText(dob);
                }

                @Override
                public void onStandardDateFormat(String date) {

                }
            });
            calendar.add(Calendar.MINUTE, 1);
            datePickerDialog.setMaxDate(calendar);
        }
    }

    @OnClick(R.id.ctv_save)
    public void save(View view) {

        String loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();
        String name = mCustomEditTextFirstName.getText().toString().trim();
        String dateOfBirth = "";
        if (datePickerDialog != null)
            dateOfBirth = datePickerDialog.getStandardDateOnly();

        String state = customSpinnerState.getSelectedValue();
        String country = customSpinnerCountry.getSelectedValue();
        String panNumber = mCustomEditTextPan.getText().toString().trim();

        UploadImageInput uploadImageInput = new UploadImageInput();

        uploadImageInput.setFilePath(panCardFile);
        uploadImageInput.setSection("PAN");
        uploadImageInput.setSessionKey(loginSessionKey);

      /*  {	"FullName": "Suhail Khan",
                "DOB": "HDFC",
                "PanCardNumber": "65656456456",
                "CountryCode": "2018-10-21",
                "State": "HFF689798",
        }*/

        JSONObject captionJSON = new JSONObject();
        try {
            captionJSON.put("FullName", name);
            captionJSON.put("DOB", dateOfBirth);
            captionJSON.put("PanCardNumber", panNumber);
            captionJSON.put("CountryCode", "IN");
            captionJSON.put("State", state);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        uploadImageInput.setMediaCaption(captionJSON.toString());

        mUpdateProfilePresenterImpl.uploadImage(uploadImageInput);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUpdateProfilePresenterImpl != null) mUpdateProfilePresenterImpl.actionLoginCancel();
        if (mUpdateProfilePresenterImpl != null) mUpdateProfilePresenterImpl.actionCountryCancel();
    }

    @Override
    public int getLayout() {
        return R.layout.verify_pan;
    }

    @Override
    public void init() {
        loader = new Loader(getCurrentView());
        ActivityUtils.performActionOnDone(mCustomEditTextPan, mCustomTextViewSave);//handle action done event of keyboard
        mContext = getActivity();
        mUpdateProfilePresenterImpl = new VerifyPanPresenterImpl(this, new UserInteractor());
        customSpinnerState.setVisibility(View.VISIBLE);
        ViewUtils.setUnderline(mCustomTextViewWhy);

        loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callViewProfile();
            }
        });
        //view profile calling

        setStateFromGson();
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
                    && responseLogin.getData().getEmailStatus().equals(Constant.Verified)) {
                panWarning.setVisibility(View.GONE);

                if (responseLogin.getData().getPanStatus().equals(Constant.Verified)) {
                    //verified
                    cardViewPan.setVisibility(View.VISIBLE);
                    scrollPan.setVisibility(View.INVISIBLE);
                    iv_mobile.setImageResource(R.drawable.ic_id);


                } else if (responseLogin.getData().getPanStatus().equals(Constant.Pending)) {
                    //pending
                    cardViewPan.setVisibility(View.VISIBLE);
                    scrollPan.setVisibility(View.INVISIBLE);
                    //mCustomTextViewPanNumber.setText(responseLogin.getResponse().getPan_card().getPan_number());
                    mCustomTextViewPanMessage.setText(AppUtils.getStrFromRes(R.string.your_pan_number_request_is_in_pending));
                    iv_mobile.setImageResource(R.drawable.ic_id_pending);

                } else if (responseLogin.getData().getPanStatus().equals(Constant.Rejected)) {
                    //canceled
                    cardViewPan.setVisibility(View.GONE);
                    scrollPan.setVisibility(View.VISIBLE);

                    try {
                        JSONObject panJson = new JSONObject(responseLogin.getData().getMediaPAN().getMediaCaption());

                        setFullName(panJson.getString("FullName"));
                        setDoB(panJson.getString("DOB"));
                        setPan(panJson.getString("PanCardNumber"));
                        setCountry(panJson.getString("CountryCode"));
                        setState(panJson.getString("State"));


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    ViewUtils.setImageUrl(mCustomImageViewPan, responseLogin.getData().getMediaPAN().getMediaThumbURL());


                    // mUpdateProfilePresenterImpl.actionStatesBtn(AppSession.getInstance().getLoginSession().getData().getSessionKey(), "101");
                } else {
                    cardViewPan.setVisibility(View.GONE);
                    scrollPan.setVisibility(View.VISIBLE);
                    //noy applied
                    // mUpdateProfilePresenterImpl.actionStatesBtn(AppSession.getInstance().getLoginSession().getData().getSessionKey(), "101");
                }
            } else {
                cardViewPan.setVisibility(View.GONE);
                panWarning.setVisibility(View.VISIBLE);
                scrollPan.setVisibility(View.GONE);
            }

        }
    }

    @Override
    public void setFullName(@NonNull String value) {
        if (!TextUtils.isEmpty(value)) {
            mCustomEditTextFirstName.setText(value);
        }
    }

    @Override
    public void setCountry(@NonNull String country) {
        customSpinnerCountry.setValue(country);
    }

    @Override
    public void setState(@NonNull String state) {
        customSpinnerState.setValue(state);
    }

    @Override
    public void setDoB(@NonNull String value) {
        if (!TextUtils.isEmpty(value)) {
            calendarDob.setTime(TimeUtils.getDateByFormat(value));
            initDateDialog();
            mCustomTextViewDob.setText(datePickerDialog.getShowDate());
        }
    }

    public void setPan(@NonNull String value) {
        if (!TextUtils.isEmpty(value)) {
            mCustomEditTextPan.setText(value);
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
            /*if (!isStateInitialise && responseLogin != null && !TextUtils.isEmpty(responseLogin.getResponse().getState())) {
                isStateInitialise = true;
                customSpinnerState.setValue(responseLogin.getResponse().getState());
            } else {
                customSpinnerState.setValue("");
            }*/
        }

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
    public void onStatesFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void onHideLoading() {
        if (isAdded())
            loader.hide();
    }

    @Override
    public void onShowLoading() {
        if (isAdded())
            loader.start();
    }

    @Override
    public void onCountriesFailure(String error) {
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
                        // mUpdateProfilePresenterImpl.actionStatesBtn(AppSession.getInstance().getLoginSession().getData().getSessionKey(), customSpinnerCountry.getSelectedValue());

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

    public void panPicture(String path) {
        panCardFile = path;
        ViewUtils.setImagePath(mCustomImageViewPan, path);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUpdateProfilePresenterImpl.responseLoginCall != null) {
            if (!mUpdateProfilePresenterImpl.responseLoginCall.isCanceled()) {
                mUpdateProfilePresenterImpl.responseLoginCall.cancel();
            }
            mUpdateProfilePresenterImpl.responseLoginCall = null;
        }
    }


}
