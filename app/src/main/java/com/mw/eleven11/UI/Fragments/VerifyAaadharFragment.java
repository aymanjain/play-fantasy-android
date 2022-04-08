package com.mw.eleven11.UI.Fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.UploadImageInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomInputEditText;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;
import com.mw.eleven11.utility.ViewUtils;
import com.mw.eleven11.utility.uploadPicUtil.PicUploadBaseActivity;
import com.mw.eleven11.utility.uploadPicUtil.UCropperUtil;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerifyAaadharFragment extends BaseFragment {

    @BindView(R.id.sv_form_root)
    View mViewRootForm;

    @BindView(R.id.card_item_aadhar_verified)
    View mViewVerifiedRoot;

    @BindView(R.id.edt_aadhar_no)
    CustomInputEditText mCietAdharNo;


    @BindView(R.id.civ_front_img)
    CustomImageView mCivFront;

    @BindView(R.id.civ_back_img)
    CustomImageView mCivBack;

    @BindView(R.id.ctv_pan_message)
    CustomTextView mCustomTextViewPanMessage;

    @BindView(R.id.ctv_error_msg)
    CustomTextView mCustomTextViewErrorMessage;

    @BindView(R.id.card_item_bank_warning)
    CardView cardItemBankWarning;


    @OnClick(R.id.ctv_btn_sumit)
    void onSubmitBtnClick() {
        String aadharNo = mCietAdharNo.getText().toString().trim();
        if (aadharNo.isEmpty()) {
            AppUtils.showToast(getContext(), AppUtils.getStrFromRes(R.string.empty_aadhar));
        } else if (!isValidAadhar(aadharNo)) {
            AppUtils.showToast(getContext(), AppUtils.getStrFromRes(R.string.invalid_aadhar));
        } else if (frontImgPath == null || frontImgPath.trim().isEmpty()) {
            AppUtils.showToast(getContext(), AppUtils.getStrFromRes(R.string.upload_aadhar_front));
        } else if (backImgPath == null || backImgPath.trim().isEmpty()) {
            AppUtils.showToast(getContext(), AppUtils.getStrFromRes(R.string.upload_aadhar_back));
        } else if (!NetworkUtils.isConnected(getContext())) {
            AppUtils.showToast(getContext(), AppUtils.getStrFromRes(R.string.network_error));
        } else {

            String loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();

            UploadImageInput uploadImageInput = new UploadImageInput();

            uploadImageInput.setFilePath(frontImgPath);
            uploadImageInput.setSection("Aadhar");
            uploadImageInput.setSessionKey(loginSessionKey);

            JSONObject captionJSON = new JSONObject();
            try {
                captionJSON.put("AadharCardNumber", aadharNo);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            uploadImageInput.setMediaCaption(captionJSON.toString());

            apiCallUpdateAadharFront(uploadImageInput);

        }
    }

    @OnClick(R.id.ctv_label_why)
    void onWhyUploadBtnClick() {

    }

    @OnClick(R.id.fl_pic_front_root)
    void onFrontUploadBtnClick() {
        selectedPic = R.id.fl_pic_front_root;
        ((PicUploadBaseActivity) getActivity()).showPicUploadOptions(UCropperUtil.DYNAMIC, 3, 2);


    }

    @OnClick(R.id.fl_pic_back_root)
    void onBackUploadBtnClick() {
        selectedPic = R.id.fl_pic_back_root;
        ((PicUploadBaseActivity) getActivity()).showPicUploadOptions(UCropperUtil.DYNAMIC, 3, 2);
    }


    Loader loader;
    private LoginResponseOut.DataBean mDataBean;
    private String frontImgPath, backImgPath;
    private int selectedPic = -1;
    private AlertDialog mAlertDialog;
    private ProgressDialog mProgressDialog;

    public static VerifyAaadharFragment newInstance() {
        VerifyAaadharFragment fragment = new VerifyAaadharFragment();
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_verify_aaadhar;
    }

    @Override
    public void init() {
        mProgressDialog = new ProgressDialog(getContext());
        loader = new Loader(getCurrentView());
        loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiCallGetProfileDetails();
            }
        });
        apiCallGetProfileDetails();
    }


    private void apiCallGetProfileDetails() {
        onHideLoading();
        if (NetworkUtils.isConnected(getContext())) {
            onShowLoading();
            LoginInput mLoginInput = new LoginInput();
            mLoginInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            mLoginInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
            mLoginInput.setParams(Constant.GET_PROFILE_PARAMS);
            new UserInteractor().viewProfile(mLoginInput, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut user) {
                    onHideLoading();
                    mDataBean = user.getData();
                    try {
                        setData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    onHideLoading();
                    error(errorMsg);
                }
            });
        } else {
            onHideLoading();
            error(AppUtils.getStrFromRes(R.string.network_error));
        }

    }

    public void onShowLoading() {
        if (isAdded())
            loader.start();
    }

    public void onHideLoading() {
        if (isAdded())
            loader.hide();
    }

    public void error(String error) {
        if (isAdded() && getActivity() != null) {
            loader.error(error);
        }
    }


    private void setData() throws Exception {

        if (mDataBean.getPhoneStatus().equals(Constant.Verified)
                && mDataBean.getEmailStatus().equals(Constant.Verified)
                && mDataBean.getPanStatus().equals(Constant.Verified)) {
            cardItemBankWarning.setVisibility(View.GONE);
            switch (mDataBean.getAadharStatus()) {
                case "Not Submitted":
                    mViewRootForm.setVisibility(View.VISIBLE);
                    mViewVerifiedRoot.setVisibility(View.GONE);
                    mCustomTextViewErrorMessage.setVisibility(View.GONE);
                    break;
                case "Pending":
                    mViewRootForm.setVisibility(View.GONE);
                    mViewVerifiedRoot.setVisibility(View.VISIBLE);
                    mCustomTextViewErrorMessage.setVisibility(View.GONE);
                    mCustomTextViewPanMessage.setText(R.string.your_adhar_number_is_pending);
                    break;
                case "Verified":
                    mViewRootForm.setVisibility(View.GONE);
                    mViewVerifiedRoot.setVisibility(View.VISIBLE);
                    mCustomTextViewErrorMessage.setVisibility(View.GONE);
                    mCustomTextViewPanMessage.setText(R.string.your_adhar_number_is_verified);
                    break;
                case "Rejected":
                    mViewRootForm.setVisibility(View.VISIBLE);
                    mViewVerifiedRoot.setVisibility(View.GONE);
                    mCustomTextViewErrorMessage.setVisibility(View.VISIBLE);
                    try {
                        JSONObject jsonObject = new JSONObject(mDataBean.getMediaAadhar().getMediaCaption());
                        mCustomTextViewErrorMessage.setText(AppUtils.getStrFromRes(R.string.Last_Aadhaar_verification_request_rejected) + "\n" + jsonObject.getString("RejectReason"));
                        mCietAdharNo.setText(jsonObject.getString("AadharCardNumber"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        mCustomTextViewErrorMessage.setVisibility(View.GONE);
                    }
                    break;
            }

        } else {
            mViewRootForm.setVisibility(View.GONE);
            mViewVerifiedRoot.setVisibility(View.GONE);
            mCustomTextViewErrorMessage.setVisibility(View.GONE);
            cardItemBankWarning.setVisibility(View.VISIBLE);
        }


    }

    public void aadharPic(String path) {
        if (selectedPic == R.id.fl_pic_front_root) {
            frontImgPath = path;
            ViewUtils.setImagePath(mCivFront, path);
            mCivFront.setVisibility(View.VISIBLE);
        } else if (selectedPic == R.id.fl_pic_back_root) {
            backImgPath = path;
            ViewUtils.setImagePath(mCivBack, path);
            mCivBack.setVisibility(View.VISIBLE);
        }
        selectedPic = -1;
    }

    public boolean isValidAadhar(String aadhar) {
        if (aadhar.length() != 12) {
            return false;
        } else {
            try {
                Long.parseLong(aadhar);
                return true;
            } catch (Exception e) {
                return false;
            }

        }
    }


    private void apiCallUpdateAadharFront(final UploadImageInput uploadImageInput) {
        if (NetworkUtils.isConnected(getContext())) {
            mProgressDialog.show();
            new UserInteractor().uploadImage(uploadImageInput, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut user) {
                    uploadImageInput.setSection("AadharBack");
                    uploadImageInput.setFilePath(backImgPath);
                    apiCallUpdateAadharBack(uploadImageInput);
                }

                @Override
                public void onError(String errorMsg) {
                    mProgressDialog.dismiss();
                    AppUtils.showToast(getContext(), errorMsg);
                    Toast.makeText(getContext(), errorMsg, Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            mProgressDialog.dismiss();
            AppUtils.showToast(getContext(), AppUtils.getStrFromRes(R.string.network_error));
        }


    }

    private void apiCallUpdateAadharBack(UploadImageInput uploadImageInput) {
        if (NetworkUtils.isConnected(getContext())) {
            mProgressDialog.show();
            new UserInteractor().uploadImage(uploadImageInput, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut user) {
                    mProgressDialog.dismiss();
                    apiCallGetProfileDetails();
                    AppUtils.showToast(getContext(), user.getMessage());
                    Toast.makeText(getContext(), user.getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(String errorMsg) {
                    mProgressDialog.dismiss();
                    AppUtils.showToast(getContext(), errorMsg);
                }
            });
        } else {
            mProgressDialog.dismiss();
            AppUtils.showToast(getContext(), AppUtils.getStrFromRes(R.string.network_error));
        }


    }

}
