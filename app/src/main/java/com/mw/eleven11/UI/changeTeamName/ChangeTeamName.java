package com.mw.eleven11.UI.changeTeamName;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.MenuItem;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.UpdateProfileInput;
import com.mw.eleven11.beanOutput.ResponseUpdateProfile;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomInputEditText;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.ActivityUtils;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.ViewUtils;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class ChangeTeamName extends BaseActivity implements ChangeTeamNameView {

    @BindString(R.string.selectYourTeamName)
    String selectYourTeamName;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.saveTeamName)
    CustomTextView saveTeamName;
    @BindView(R.id.teamNameEt)
    CustomEditText teamNameEt;

    ChangeTeamNamePresenterImpl mChangeTeamNamePresenterImpl;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private String blockCharacterSet = "~#^|$%&*!@";
    private InputFilter filter = new InputFilter() {

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            if (source != null && blockCharacterSet.contains(("" + source))) {
                return "";
            }
            return null;
        }
    };

    @OnClick(R.id.back)
    void onBackClick() {
        onBackPressed();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ChangeTeamName.class);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @OnClick(R.id.saveTeamName)
    void onSaveTeamName() {
        ViewUtils.hideKeyboard(this);
        String teamNameStr = teamNameEt.getText().toString();

        if (teamNameStr.length() <= 7) {

            showSnackBar(AppUtils.getStrFromRes(R.string.mininmum6Charecters));
            return;
        }

        UpdateProfileInput updateProfileInput= new UpdateProfileInput();
        updateProfileInput.setUsername(teamNameStr);
        updateProfileInput.setSessionKey(AppSession.getInstance().getLoginSession()
                .getData().getSessionKey());
        mChangeTeamNamePresenterImpl.actionUpdateProfile(updateProfileInput);

    }

    @Override
    public int getLayout() {
        return R.layout.change_team_name;
    }

    @Override
    public void init() {
        mContext = this;
        teamNameEt.setFilters(new InputFilter[]{filter});
        mChangeTeamNamePresenterImpl = new ChangeTeamNamePresenterImpl(this, new UserInteractor());
        ActivityUtils.performActionOnDone(teamNameEt, saveTeamName);
        if (getIntent().hasExtra("teamName")) {
            teamNameEt.setText(getIntent().getStringExtra("teamName"));
        }
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
    public void showSnackBar(String message) {
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, message);
    }

    @Override
    public void onUpdateSuccess(ResponseUpdateProfile updateProfile) {

        if (updateProfile != null) {

            AppUtils.showToast(mContext, updateProfile.getMessage());

            Intent in = new Intent();
            in.putExtra("changeName", teamNameEt.getText().toString());
            setResult(RESULT_OK, in);
            finish();
        }

    }

    @Override
    public void onUpdateFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }



    @Override
    public Context getContext() {
        return mContext;
    }


}
