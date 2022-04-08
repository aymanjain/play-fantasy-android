package com.mw.eleven11.utility.uploadPicUtil;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.yalantis.ucrop.UCrop;

import com.mw.eleven11.R;


/**
 * Created by hp on 17-08-2017.
 */

public class UCropperUtil {

    public static final int IMAGE_SOURCE = 1;
    public static final int SQUARE = 2;
    public static final int DYNAMIC = 3;
    public static final int PNG = 4;
    public static final int JPEG = 5;

    public static UCrop setAspectRation(@NonNull UCrop uCrop, int type, float ratioX, float ratioY) {
        switch (type) {
            case IMAGE_SOURCE:
                uCrop = uCrop.useSourceImageAspectRatio();
                break;
            case SQUARE:
                uCrop = uCrop.withAspectRatio(1, 1);
                break;
            case DYNAMIC:
                if (ratioX > 0 && ratioY > 0) {
                    uCrop = uCrop.withAspectRatio(ratioX, ratioY);
                }
                break;
        }
        return uCrop;
    }

    public static UCrop setMaxSize(@NonNull UCrop uCrop, int maxWidth, int maxHeight) {
        if (maxWidth > 0 && maxHeight > 0) {
            uCrop = uCrop.withMaxResultSize(maxWidth, maxHeight);
        }
        return uCrop;
    }

    public static UCrop hideBottomControls(@NonNull UCrop uCrop) {
        UCrop.Options options = new UCrop.Options();
        options.setFreeStyleCropEnabled(false);
        return uCrop.withOptions(options);
    }

    public static UCrop setFreeStyleCrop(@NonNull UCrop uCrop) {
        UCrop.Options options = new UCrop.Options();
        options.setFreeStyleCropEnabled(true);
        return uCrop.withOptions(options);
    }

    public static UCrop setCompression(@NonNull UCrop uCrop, @IntRange(from = 0) int quality /*1-100*/) {
        UCrop.Options options = new UCrop.Options();
        options.setCompressionQuality(quality);
        return uCrop.withOptions(options);
    }

    public static UCrop setCompressionFormat(@NonNull UCrop uCrop, int type) {
        UCrop.Options options = new UCrop.Options();
        if (type == PNG)
            options.setCompressionFormat(Bitmap.CompressFormat.PNG);
        else if (type == JPEG)
            options.setCompressionFormat(Bitmap.CompressFormat.JPEG);

        return uCrop.withOptions(options);
    }


    public static UCrop setMyTheme(@NonNull UCrop uCrop, Context context) {
        UCrop.Options options = new UCrop.Options();
        options.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary));
        options.setStatusBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        options.setActiveWidgetColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        options.setToolbarWidgetColor(ContextCompat.getColor(context, R.color.white));
        return uCrop.withOptions(options);
    }


}
