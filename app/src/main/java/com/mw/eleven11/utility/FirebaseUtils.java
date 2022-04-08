package com.mw.eleven11.utility;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by mobiweb on 28/9/18.
 */

public class FirebaseUtils {
    private static final String TOPIC_GLOBAL = "Updates";
    private static final String TAG = "FirebaseUtils";
    private static String token;

    public static void initFirebase() {
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC_GLOBAL);
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            return;
                        }
                        token = task.getResult().getToken();
                    }
                });

    }

    public static String getToken() {
        if (TextUtils.isEmpty(token)) initFirebase();
        return token;
    }
}
