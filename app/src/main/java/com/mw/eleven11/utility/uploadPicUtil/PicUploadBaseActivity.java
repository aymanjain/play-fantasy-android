package com.mw.eleven11.utility.uploadPicUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mw.eleven11.base.BaseActivity;

public abstract class PicUploadBaseActivity extends BaseActivity {

    private PicUploadOptionsFragment mPicUploadOptionsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return 0;
    }


    public void showPicUploadOptions(int cropType, float ratioX, float ratioY) {
        mPicUploadOptionsFragment = PicUploadOptionsFragment.getInstance(cropType, ratioX, ratioY);
        mPicUploadOptionsFragment.show(getSupportFragmentManager(), "");
    }

    public void hide() {
        if (mPicUploadOptionsFragment != null) {
            mPicUploadOptionsFragment.dismiss();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (mPicUploadOptionsFragment != null)
            mPicUploadOptionsFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mPicUploadOptionsFragment != null)
            mPicUploadOptionsFragment.onActivityResult(requestCode, resultCode, data);
    }

    public abstract void onTakeOrChoosePicSussess(String picAbsolutePath);

}
