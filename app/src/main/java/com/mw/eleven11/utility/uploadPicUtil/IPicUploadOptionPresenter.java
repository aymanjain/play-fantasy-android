package com.mw.eleven11.utility.uploadPicUtil;

import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by hp on 05-08-2017.
 */

public interface IPicUploadOptionPresenter {
    void actionChooseGallery();

    void actionChooseCamera();

    void checkPermission(int type);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);
}
