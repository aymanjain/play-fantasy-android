package com.mw.eleven11.utility;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;


public class DeviceUtils {

    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getSignUpType(Context context) {
        return "APP";
    }

    public static int getDeviceScreenWidthInPixel() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getDeviceScreenHeightInPixel() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getDeviceSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

}
