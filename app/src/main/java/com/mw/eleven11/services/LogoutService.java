package com.mw.eleven11.services;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;

import com.mw.eleven11.AppController;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.UI.loginRagisterModule.LoginScreen;
import com.mw.eleven11.base.SessionExpireDialogActivity;
import com.mw.eleven11.utility.AppUtils;

/**
 *
 */

public class LogoutService extends Service {
    String TAG = getClass().getSimpleName();
    String message = "";

    public AppController application;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            application = (AppController) getApplication();
            /* CHECK USER LOGIN INFORMATION */
            if (AppSession.getInstance().getLoginSession() != null) {


                if (intent != null && intent.hasExtra("message")) {
                    message = intent.getStringExtra("message");
                }
                if (isNetworkAvailable()) {
         /*           new UserInteractor().logout(AppSession.getInstance().getLoginSession().getResponse().getUserId(), DeviceUtils.getDeviceId(getBaseContext()), new IUserInteractor.OnResponseListener() {
                        @Override
                        public void onError(String errorMsg) {
                            logout();
                        }

                        @Override
                        public void onSuccess(ResponseLogin user) {
                            logout();
                        }
                    });*/
                } else {
                    logout();
                }

            } else {
                AppUtils.stopLogoutService(getBaseContext());
            }
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            } else {
                AppUtils.startLogoutService(getBaseContext(), message, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Service.START_NOT_STICKY;
    }

    private void logout() {
        AppUtils.stopLogoutService(getBaseContext());
        if (AppSession.getInstance().getLoginSession() != null) {
            if (!SessionExpireDialogActivity.isOpen) {
                // Clear all notification
                NotificationManager nMgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nMgr.cancelAll();

                AppSession.getInstance().clearSession();
                Intent starter = new Intent(getBaseContext(), LoginScreen.class);
                starter.putExtra("sessionExpiry", true);
                starter.putExtra("message", message);
                starter.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                if (Build.VERSION.SDK_INT >= 11) {
                    starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                } else {
                    starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                startActivity(starter);
                SessionExpireDialogActivity.isOpen = true;
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    /* method for checking Network availability */
    public boolean isNetworkAvailable() {

        try {
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error r) {
            r.printStackTrace();
        }
        return false;
    }
}
