package com.mw.eleven11.download;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.mw.eleven11.AppController;
import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.Download;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.FileOpen;
import com.mw.eleven11.utility.FileUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;




public class DownloadServiceHttpUrl extends Service {

    public static final int PERMISSION_REQUEST_CODE = 1;
    public static final String MESSAGE_PROGRESS = "message_progress";
    private static final String TAG = DownloadServiceHttpUrl.class.getSimpleName();
    private static final Map<Integer, Bundle> downloadTasksMap = new ConcurrentHashMap<>();
    private PowerManager.WakeLock wakeLock;
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;
    private int totalFileSize;
    private NotificationCompat.Builder notificationBuilder;
    private NotificationManager notificationManager;

    public DownloadServiceHttpUrl() {
        super();
    }

    public static void startDownload(Activity activity, String fileUrl) {
        startDownload(activity, (int) new Date().getTime(), fileUrl);
    }

    public static void startDownload(Activity activity, int downloadId, String fileUrl) {
        Download download = new Download();
        download.setFileUrl(fileUrl);
        download.setDownloadId(downloadId);
        Intent intent = new Intent(activity, DownloadServiceHttpUrl.class);
        intent.putExtra("download", download);
        activity.startService(intent);
    }

    @Override
    public void onCreate() {
        // Get the HandlerThread's Looper and use it for our Handler
        PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, TAG);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        if (intent != null) {

            wakeLock.acquire();

            HandlerThread thread = new HandlerThread("ServiceStartArguments", HandlerThread.NORM_PRIORITY);
            thread.start();

            mServiceLooper = thread.getLooper();
            mServiceHandler = new ServiceHandler(mServiceLooper);
            Message msg = mServiceHandler.obtainMessage();
            msg.arg1 = startId;
            msg.setData(intent.getExtras());

            mServiceHandler.sendMessage(msg);
            // If we get killed, after returning from here, restart
        } else {
            stopSelf();
        }
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    private void initDownload(Download download) {

        try {
            download.setProgress(0);
            download.setStatus(Download.DownloadStatus.START);
            sendIntent(download);

            downloadFile(download);
        } catch (IOException e) {
            e.printStackTrace();
            AppUtils.showToast(getApplicationContext(), e.getMessage());
            onDownloadError(download);
        }
    }

    private void downloadFile(Download download) throws IOException {


        Log.i("getFilename", "getFilename:" + FileUtil.getFilename(download.getFileUrl()));
        File outputFile = FileUtil.createFile(FileUtil.getFilename(download.getFileUrl()));

        URL url = new URL(download.getFileUrl());
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestMethod("GET");
        c.setDoOutput(true);
        c.connect();

        InputStream bis = c.getInputStream();
        int fileSize = c.getContentLength();//size of apk

        int count;
        byte data[] = new byte[1024 * 4];

        OutputStream output = new FileOutputStream(outputFile);
        long total = 0;
        long startTime = System.currentTimeMillis();
        int timeCount = 1;
        while ((count = bis.read(data)) != -1) {

            total += count;
            totalFileSize = (int) (fileSize / (Math.pow(1, 2))) / 1000;
            double current = Math.round(total / (Math.pow(1, 2))) / 1000;

            int progress = (int) ((total * 100) / fileSize);

            long currentTime = System.currentTimeMillis() - startTime;

            download.setTotalFileSize(totalFileSize);
            download.setFilePath(outputFile.getAbsolutePath());


            if (currentTime > 1000 * timeCount) {

                download.setCurrentFileSize((int) current);
                download.setProgress(progress);
                download.setStatus(Download.DownloadStatus.DOWNLOADING);
                sendNotification(download);

                timeCount++;
            }

            output.write(data, 0, count);
        }
        onDownloadComplete(download, outputFile);
        output.flush();
        output.close();
        bis.close();

    }

    private void sendNotification(Download download) {

        sendIntent(download);
        notificationBuilder.setProgress(100, download.getProgress(), false).setContentTitle("Downloading");
        notificationBuilder.setContentText("Downloading file " + download.getCurrentFileSize() + "/" + totalFileSize + " KB");
        notificationManager.notify(download.getDownloadId(), notificationBuilder.build());
    }

    private void sendIntent(Download download) {

        Intent intent = new Intent(MESSAGE_PROGRESS);
        intent.putExtra("download", download);
        LocalBroadcastManager.getInstance(DownloadServiceHttpUrl.this).sendBroadcast(intent);
    }

    private void onDownloadComplete(Download download, File outputFile) throws IOException {

        download.setProgress(100);
        download.setStatus(Download.DownloadStatus.COMPLETED);
        download.setFilePath(outputFile.getAbsolutePath());
        sendIntent(download);

        notificationManager.cancel(download.getDownloadId());
        notificationBuilder.setProgress(0, 0, false);
        notificationBuilder.setContentText("Download Complete.");
        notificationManager.notify(download.getDownloadId(), notificationBuilder.build());

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        Intent intent = FileOpen.getOpenFileIntent(outputFile);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);


        notificationBuilder
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .setContentTitle(outputFile.getName());

        notificationManager.notify(download.getDownloadId(), notificationBuilder.build());

        downloadTasksMap.remove(download.getDownloadId());
        // when all the upload tasks are completed, release the wake lock and shut down the service
        if (downloadTasksMap.isEmpty()) {
            Log.i(TAG, "All tasks finished. UploadService is about to shutdown...");
            wakeLock.release();
            stopSelf();
        }
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {

    }

    private void onDownloadError(Download download) {


        download.setProgress(0);
        download.setStatus(Download.DownloadStatus.ERROR);
        sendIntent(download);

        notificationManager.cancel(download.getDownloadId());
        notificationBuilder.setProgress(0, 0, false);
        notificationBuilder.setContentText("Download Error.");

        notificationBuilder
                .setAutoCancel(true)
                .setContentTitle("Error");

        notificationManager.notify(download.getDownloadId(), notificationBuilder.build());

        downloadTasksMap.remove(download.getDownloadId());
        // when all the upload tasks are completed, release the wake lock and shut down the service
        if (downloadTasksMap.isEmpty()) {
            Log.i(TAG, "All tasks finished. UploadService is about to shutdown...");
            wakeLock.release();
            stopSelf();
        }
    }

    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            AppController x = (AppController) getApplicationContext();
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            notificationBuilder = new NotificationCompat.Builder(getApplicationContext())
                    .setSmallIcon(R.drawable.ic_download)
                    .setContentTitle("Downloading")
                    .setContentText("Please wait...")
                    .setAutoCancel(true);

            Download download = msg.getData().getParcelable("download");
            download.setDownloadId((int) new Date().getTime());


            downloadTasksMap.put(download.getDownloadId(), msg.getData());
            notificationManager.notify(download.getDownloadId(), notificationBuilder.build());


            initDownload(download);
        }
    }

}
