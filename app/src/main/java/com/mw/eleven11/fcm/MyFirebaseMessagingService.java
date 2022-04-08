/**
 * Copyright 2016 Google Inc. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mw.eleven11.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.loginRagisterModule.LoginScreen;



public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyMessagingService";
    public static int notify = 0;
    public static final String BADGES_INTENT_FILTER = "com.app.eleven11.fcm.badges";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            try {
                String Message = remoteMessage.getData().get("message");
                String title = remoteMessage.getData().get("title");
                String badges = remoteMessage.getData().get("badges");
                String refrenceID = remoteMessage.getData().get("refrenceID");
                String redirect = remoteMessage.getData().get("redirect");
                sendNotification(title, Message, refrenceID, redirect);
                sendBadgesIntent(badges);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "Exception " + e.getMessage());
            }
        }
    }

    @Override
    public void onNewToken(String token) {
    }

    private void sendNotification(String title, String messageBody, String refrenceID, String redirect) {
        if (title == null || messageBody == null) return;
        Intent intent = null;
        if (AppSession.getInstance().getLoginSession() != null) {
            if (redirect.equalsIgnoreCase("Dfs")){
                intent = new Intent(this, HomeNavigation.class);
                AppSession.getInstance().setPlayMode(0);
                AppSession.getInstance().setGameType(1);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK
                );

            }else if (redirect.equalsIgnoreCase("FT-Dfs")){
                intent = new Intent(this, HomeNavigation.class);
                AppSession.getInstance().setPlayMode(0);
                AppSession.getInstance().setGameType(2);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK
                );


            }else if (redirect.equalsIgnoreCase("Auction")){
                intent = new Intent(this, HomeNavigation.class);
                AppSession.getInstance().setPlayMode(1);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK
                );

            }else if (redirect.equalsIgnoreCase("Gully")){
                intent = new Intent(this, HomeNavigation.class);
                AppSession.getInstance().setPlayMode(2);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK
                );

            }else {
                intent = new Intent(this, NotificationClickActivity.class);
                intent.putExtra("MatchGUID", refrenceID);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                );
            }
           /* if (refrenceID.equals("")) {
                intent = new Intent(this, NotificationsActivity.class);
                intent.putExtra("Flag",true);
            }else {
                intent = new Intent(this, MatchContestActivity.class);
                intent.putExtra("MatchGUID",refrenceID);
                intent.putExtra("StatusID","Pending");
                intent.putExtra("Flag",true);
   }*/
        } else {
            intent = new Intent(this, LoginScreen.class);
        }



        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0 /* Request code */,
                intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = getString(R.string.default_notification_channel_id);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), defaultSoundUri);
        r.play();

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        // .setSmallIcon(R.drawable.ic_trophy_home)
                        .setContentTitle(title)
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(messageBody))
                        .setContentIntent(pendingIntent);

        if (android.os.Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            notificationBuilder.setSmallIcon(R.drawable.star);
        } else {
            notificationBuilder.setSmallIcon(R.drawable.ic_trophy_home);
        }

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Eleven11 application alert",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(notify++ /* ID of notification */, notificationBuilder.build());
    }

    private void sendBadgesIntent(String badges) {
        AppSession.getInstance().setBadges(badges);
        Intent intent = new Intent(MyFirebaseMessagingService.BADGES_INTENT_FILTER);
        intent.putExtra("badges", badges);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }
}