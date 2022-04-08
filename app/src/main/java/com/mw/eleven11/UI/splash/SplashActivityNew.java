package com.mw.eleven11.UI.splash;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.loginRagisterModule.VerifyPhoneNumber;
import com.mw.eleven11.UI.startup.StartupActivity;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.DeviceUtility;

public class SplashActivityNew extends BaseActivity implements SplashView {

    private Context mContext;

    public static void start(Context context) {
        Intent starter = new Intent(context, SplashActivityNew.class);
        context.startActivity(starter);
    }

    public void showAlertDialogAndExitApp(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                });

        alertDialog.show();
    }


    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void init() {
        mContext = this;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = getString(R.string.default_notification_channel_id);
            String channelName = getString(R.string.default_notification_channel_id);
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(new NotificationChannel(channelId,
                    channelName, NotificationManager.IMPORTANCE_LOW));
        }
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {

                Object value = getIntent().getExtras().get(key);
                Log.d("Firebase", "Key: " + key + " Value: " + value);
            }
        }
        if (DeviceUtility.isDeviceRooted()) {
            showAlertDialogAndExitApp("This device is rooted. You can't use this app.");
        } else {
            new SplashImplementer(this).startThread(Constant.SPLASH_MILLISECOND_TIME);
        }
    }

    @Override
    public void isLogin() {
        HomeNavigation.start(mContext);
        finish();

    }

    @Override
    public void isLogout() {
        StartupActivity.start(mContext);
        finish();
    }

    @Override
    public void notVerify() {
        VerifyPhoneNumber.start(mContext);
        finish();

    }

    @Override
    public Context getContext() {
        return null;
    }
}
