package com.mw.eleven11.UI.changePassword;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.ChangePasswordInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomInputEditText;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;

import butterknife.BindView;
import butterknife.OnClick;


public class ChangePasswordActivity extends BaseActivity implements ChangePasswordView {

    ChangePasswordInput mChangePasswordInput;
    ChangePasswordPresenterImpl mPresenter;
    @BindView(R.id.rl_root)
    RelativeLayout mRelativeLayout;
    @BindView(R.id.cet_old_pwd)
    CustomEditText mOldPassword;
    @BindView(R.id.cet_new_pwd)
    CustomEditText mNewPassword;
    @BindView(R.id.cet_confirm_pwd)
    CustomEditText mConfirmPassword;
    private Context mContext;
    private ProgressDialog mProgressDialog;

    @OnClick(R.id.back)
    public void cancel(android.view.View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ChangePasswordActivity.class);
        context.startActivity(starter);
    }

    @OnClick(R.id.back)
    public void onBackClick(){
        finish();
    }

    @OnClick(R.id.cet_change_pwd_btn)
    public void changePasswordBtnOnClick() {

        String oldPwd = mOldPassword.getText().toString().trim();
        String newPwd = mNewPassword.getText().toString().trim();
        String confirmPwd = mConfirmPassword.getText().toString().trim();

        mChangePasswordInput.setCurrentPassword(oldPwd);
        mChangePasswordInput.setPassword(newPwd);
        mChangePasswordInput.setConfirmPassword(confirmPwd);
        mChangePasswordInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());

        mPresenter.submitAction(mChangePasswordInput);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_change_password;
    }

    @Override
    public void init() {
        mChangePasswordInput = new ChangePasswordInput();
        mContext = this;
        mPresenter = new ChangePasswordPresenterImpl(this, new UserInteractor());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }


    @Override
    public void showLoading() {
        if (mProgressDialog == null)
            mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();

    }


    @Override
    public void loginSuccess(LoginResponseOut responseChangePassword) {
        hideLoading();
        //Toast.makeText(mContext, responseChangePassword.getMessage(), Toast.LENGTH_SHORT).show();

        AppUtils.showToast(mContext, responseChangePassword.getMessage());

        finish();

    }

    @Override
    public void loginFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void showSnackBar(String message) {
        AppUtils.showSnackBar(mContext, mRelativeLayout, message);

    }

    @Override
    public Context getContext() {
        return mContext;
    }

}
