package com.mw.eleven11.UI.versionUpdate;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.MenuItem;

import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.ServiceWrapper;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanOutput.Download;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.download.DownloadServiceHttpUrl;
import com.mw.eleven11.utility.ApkUtils;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.FileUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.OnClick;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateVersionDialogCompalsoryActivity extends BaseActivity implements UpdateVersionView {

    private Context mContext;

    private ProgressDialog mProgressDialog;

    /* Butter Knife : view mapping */

    String downloadLink="";

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.ctv_cancel)
    CustomTextView mCustomEditTextCancel;

    @BindView(R.id.ctv_save)
    CustomTextView mCustomTextViewSave;

    @BindView(R.id.ctv_message)
    CustomTextView ctvMessage;
    private String androidAppFeatures;


    @OnClick(R.id.ctv_save)
    public void save(android.view.View view) {

        if (!TextUtils.isEmpty(downloadLink)) {
            if (downloadLink.startsWith(AppConfiguration.MAIN_URL)) {
                downloadFile();
            } else {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(downloadLink));
                startActivity(i);
            }
        }
    }



    @OnClick(R.id.iv_cross)
    public void cancel(android.view.View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    @OnClick(R.id.ctv_cancel)
    public void cancel_update(android.view.View view) {
        finish();
    }
    /* Butter Knife : view mapping */

    public static void start(Context context, String androidAppFeatures, String downloadLink) {
        Intent starter = new Intent(context, UpdateVersionDialogCompalsoryActivity.class);
        starter.putExtra("downloadLink",downloadLink);
        starter.putExtra("androidAppFeatures",androidAppFeatures);
        ((Activity) context).startActivityForResult(starter,REQUEST_CODE_UPDATE_Wallet);
        ((Activity) context).overridePendingTransition( R.anim.dialog_open, R.anim.dialog_close );
    }

    @Override
    public int getLayout() {
        return R.layout.dialog_update_version_compalsory;
    }

    @Override
    public void init() {
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        mContext = this;
        setActivityBackground();
        if (getIntent()!=null && getIntent().hasExtra("downloadLink"))
            downloadLink=getIntent().getStringExtra("downloadLink");

        if (getIntent()!=null && getIntent().hasExtra("androidAppFeatures"))
            androidAppFeatures=getIntent().getStringExtra("androidAppFeatures");


        ctvMessage.setText(Html.fromHtml(androidAppFeatures));
        registerReceiver();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    @Override
    public void showLoading() {
        if (mProgressDialog==null) mProgressDialog= new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog!=null) mProgressDialog.dismiss();

    }
    @Override
    public void updateSuccess(final LoginResponseOut responseLogin) {
        hideLoading();
        alertExitDialog = new AlertDialog(UpdateVersionDialogCompalsoryActivity.this, responseLogin.getMessage(), AppUtils.getStrFromRes(R.string.okay),  "", new AlertDialog.OnBtnClickListener() {
            @Override
            public void onYesClick() {
                setResult(RESULT_OK);
                finishActivity();
            }

            @Override
            public void onNoClick() {

            }
        });
        alertExitDialog.show();
    }
    @Override
    public void updateFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

   AlertDialog alertExitDialog;

    @Override
    public void onBackPressed() {

    }

    @Override
    public void showSnackBar(@NonNull String message) {
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, message);
    }

    @Override
    public void setActivityBackground() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void finishActivity() {
        finish();
    }

    public void downloadFile() {
        if (checkPermission()) {
            downloadZipFile(downloadLink);
        } else {
            requestPermission();
        }
    }
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, DownloadServiceHttpUrl.PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case DownloadServiceHttpUrl.PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    downloadFile();
                } else {
                    AppUtils.showToast(mContext,"Permission Denied, Please allow to proceed !");
                }
                break;
        }
    }
    @Override
    protected void onDestroy() {
        if (broadcastReceiver != null)
            LocalBroadcastManager.getInstance(mContext).unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }


    DownloadZipFileTask downloadZipFileTask;

    private void downloadZipFile(String fileUrl) {

       final Download download = new Download();
        download.setProgress(0);
        download.setStatus(Download.DownloadStatus.START);
        sendIntent(download);

        Call<ResponseBody> call = ServiceWrapper.getInstance().downloadFileByUrlCall(fileUrl);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d("App", "Got the body for the file");
                    onShowSnackBar( "Downloading...");
                    downloadZipFileTask = new DownloadZipFileTask(UpdateVersionDialogCompalsoryActivity.this);
                    downloadZipFileTask.execute(response.body());
                } else {
                    onShowSnackBar("Connection failed " + response.errorBody());
                    download.setProgress(0);
                    download.setStatus(Download.DownloadStatus.ERROR);
                    sendIntent(download);
                }
            }



            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                download.setProgress(0);
                download.setStatus(Download.DownloadStatus.ERROR);
                sendIntent(download);
            }
        });
    }

    private class DownloadZipFileTask extends AsyncTask<ResponseBody, Pair<Integer, Long>, File> {
        Activity activity;
        private DownloadZipFileTask(Activity activity){
            this.activity=activity;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Download download = new Download();
            download.setProgress(0);
            download.setStatus(Download.DownloadStatus.START);
            sendIntent(download);

        }

        @Override
        protected File doInBackground(ResponseBody... urls) {
            //Copy you logic to calculate progress and call
            return  saveToDisk(urls[0]);
        }

        @Override
        protected void onPostExecute(File result) {
            Download download = new Download();
            if (result!=null && result.exists() && activity!=null){
                download.setProgress(100);
                download.setFilePath(result.getAbsolutePath());
                download.setStatus(Download.DownloadStatus.COMPLETED);
                sendIntent(download);
            }else {
                download.setProgress(0);
                download.setStatus(Download.DownloadStatus.ERROR);
                sendIntent(download);
            }

        }
    }
    private static final String TAG = "Download file";

    private File saveToDisk(ResponseBody body) {
        Download download = new Download();
        try {
            File destinationFile = FileUtil.createApkFile();

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                inputStream = body.byteStream();
                outputStream = new FileOutputStream(destinationFile);
                byte data[] = new byte[4096];
                int count;
                int progress = 0;
                long fileSize = body.contentLength();
                Log.d(TAG, "File Size=" + fileSize);
                while ((count = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, count);
                    progress += count;
                    Log.d(TAG, "Progress: " + progress + "/" + fileSize + " >>>> " + (float) progress / fileSize);

                    download.setProgress(0);
                    download.setStatus(Download.DownloadStatus.DOWNLOADING);
                    sendIntent(download);
                }

                outputStream.flush();
                Log.d(TAG, destinationFile.getParent());
                return destinationFile;
            } catch (IOException e) {
                e.printStackTrace();
                Log.d(TAG, "Failed to save the file!");
                return null;
            } finally {
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "Failed to save the file!");
            return null;
        }
    }

    private void sendIntent(Download download) {
        Intent intent = new Intent(DownloadServiceHttpUrl.MESSAGE_PROGRESS);
        intent.putExtra("download", download);
        LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
    }

    private void registerReceiver() {
        LocalBroadcastManager bManager = LocalBroadcastManager.getInstance(UpdateVersionDialogCompalsoryActivity.this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadServiceHttpUrl.MESSAGE_PROGRESS);
        bManager.registerReceiver(broadcastReceiver, intentFilter);

    }

    android.app.ProgressDialog bar;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(DownloadServiceHttpUrl.MESSAGE_PROGRESS)) {

                Download download = intent.getParcelableExtra("download");

                if (download.getStatus() == Download.DownloadStatus.START) {

                    if (bar != null && bar.isShowing())
                        bar.dismiss();
                    bar = new android.app.ProgressDialog(UpdateVersionDialogCompalsoryActivity.this);
                    bar.setCancelable(false);
                    bar.setMessage("Downloading...");
                    bar.setIndeterminate(true);
                    bar.setCanceledOnTouchOutside(false);
                    bar.show();

                } else if (download.getStatus() == Download.DownloadStatus.DOWNLOADING) {
                    bar.setIndeterminate(false);
                    bar.setMax(100);
                    bar.setProgress(download.getProgress());
                    String msg = "";
                    if (download.getProgress() > 99) {
                        msg = "Finishing... ";
                    } else {
                        msg = "Downloading... " + download.getProgress() + "%";
                    }
                   // bar.setMessage(msg);

                } else if (download.getStatus() == Download.DownloadStatus.COMPLETED) {
                    if (bar != null && bar.isShowing())
                        bar.dismiss();

                    try {

                        ApkUtils.installAPk(mContext,new File(download.getFilePath()));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                } else if (download.getStatus() == Download.DownloadStatus.ERROR) {
                    if (bar != null && bar.isShowing())
                        bar.dismiss();
                }
            }
        }
    };



    private  void onShowSnackBar(String message){
        AppUtils.showToast(getApplicationContext(),message);
    }
}
