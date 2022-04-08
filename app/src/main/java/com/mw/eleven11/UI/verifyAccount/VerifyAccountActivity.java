package com.mw.eleven11.UI.verifyAccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.MenuItem;

import com.mw.eleven11.R;
import com.mw.eleven11.utility.uploadPicUtil.PicUploadBaseActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class VerifyAccountActivity extends PicUploadBaseActivity {

    @BindString(R.string.verify_your_account)
    String title;
    /* Butter Knife : view mapping */
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
   /* @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.title)
    CustomTextView mCustomTextViewTitle;*/
    VerifyAccountParentFragment verifyAccountParentFragment = VerifyAccountParentFragment.getInstance("");
    private Context mContext;

    public static void start(Context context) {
        Intent starter = new Intent(context, VerifyAccountActivity.class);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @Override
    public void onTakeOrChoosePicSussess(String picAbsolutePath) {
        verifyAccountParentFragment.onPicture(picAbsolutePath);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_verify_account;
    }

    @Override
    public void init() {
      /*  setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
       // mCustomTextViewTitle.setText(title);
        mContext = this;
        setFragment(verifyAccountParentFragment, "VerifyAccountParentFragment");
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

    @OnClick(R.id.back)
    public void onBAckClick(){
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (verifyAccountParentFragment != null)
            verifyAccountParentFragment.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_UPDATE_PROFILE && resultCode == Activity.RESULT_OK) {
        } else if (requestCode == REQUEST_CODE_UPDATE_MOOD && resultCode == Activity.RESULT_OK) {
        }
    }
}
