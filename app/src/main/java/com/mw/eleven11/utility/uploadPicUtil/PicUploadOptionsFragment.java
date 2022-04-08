package com.mw.eleven11.utility.uploadPicUtil;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;

import com.mw.eleven11.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PicUploadOptionsFragment extends BottomSheetDialogFragment implements IPicUploadOptionView {

    public static final int SELECTION_CAMERA = 1;
    public static final int SELECTION_GALLERY = 2;
    public static final int REQUEST_CODE_ASK_MULTIPLE_CAMERA_STORAGE = 3;
    public static final int REQUEST_CODE_ASK_MULTIPLE_STORAGE = 4;
    private PicUploadOptionPresenterImpl mPicUploadOptionPresenter;
    private Context mContext;
    private View mView;
    private int cropType;
    private float ratioX, ratioY;

    @OnClick(R.id.pud_gallery)
    void openGallery() {
        mPicUploadOptionPresenter.checkPermission(SELECTION_GALLERY);
    }

    @OnClick(R.id.pud_camera)
    void openCamera() {
        mPicUploadOptionPresenter.checkPermission(SELECTION_CAMERA);
    }


    public static PicUploadOptionsFragment getInstance(int cropType, float ratioX, float ratioY) {
        PicUploadOptionsFragment picUploadOptionsFragment = new PicUploadOptionsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("cropType", cropType);
        bundle.putFloat("ratioX", ratioX);
        bundle.putFloat("ratioY", ratioY);
        picUploadOptionsFragment.setArguments(bundle);
        return picUploadOptionsFragment;
    }

    public PicUploadOptionsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_pic_upload_options, container, false);
        cropType = getArguments().getInt("cropType");
        ratioX = getArguments().getFloat("ratioX");
        ratioY = getArguments().getFloat("ratioY");
        ButterKnife.bind(this, mView);
        mContext = getContext();
        mPicUploadOptionPresenter = new PicUploadOptionPresenterImpl(this);
        return mView;
    }


    @Override
    public void hide() {

    }

    @Override
    public Context getMyContext() {
        return mContext;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mPicUploadOptionPresenter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    public String onPath(String path) {
        return path;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPicUploadOptionPresenter.onActivityResult(requestCode, resultCode, data);
    }

    public int getCropType() {
        return cropType;
    }

    public float getRatioX() {
        return ratioX;
    }

    public float getRatioY() {
        return ratioY;
    }
}
