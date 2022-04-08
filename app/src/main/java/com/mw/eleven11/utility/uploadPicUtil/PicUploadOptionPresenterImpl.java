package com.mw.eleven11.utility.uploadPicUtil;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mw.eleven11.AppController;
import com.mw.eleven11.R;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.FileUtil;


/**
 * Created by hp on 05-08-2017.
 */

public class PicUploadOptionPresenterImpl implements IPicUploadOptionPresenter {

    private static final String TAG = "PicUploadOptionPresente";
    IPicUploadOptionView mIPicUploadOptionView;
    String picAbsolutePath = "";

    public PicUploadOptionPresenterImpl(IPicUploadOptionView mIPicUploadOptionView) {
        this.mIPicUploadOptionView = mIPicUploadOptionView;
    }

    @Override
    public void actionChooseGallery() {

    }

    @Override
    public void actionChooseCamera() {

    }

    @Override
    public void checkPermission(int type) {
        ((PicUploadBaseActivity) mIPicUploadOptionView.getMyContext()).hide();
        if (Build.VERSION.SDK_INT >= 23) {
            if (type == PicUploadOptionsFragment.SELECTION_CAMERA) {
                List<String> permissionsNeeded = new ArrayList<String>();
                final List<String> permissionsList = new ArrayList<String>();
                if (!addPermission(permissionsList, Manifest.permission.CAMERA))
                    permissionsNeeded.add(AppUtils.getStrFromRes(R.string.camera));
                if (!addPermission(permissionsList, Manifest.permission.WRITE_EXTERNAL_STORAGE))
                    permissionsNeeded.add(AppUtils.getStrFromRes(R.string.storage));
                if (permissionsList.size() > 0) {
                    if (permissionsNeeded.size() > 0) {
                        String message = AppUtils.getStrFromRes(R.string.grant_access_message) + " " + permissionsNeeded.get(0);
                        for (int i = 1; i < permissionsNeeded.size(); i++)
                            message = message + ", " + permissionsNeeded.get(i);
                        showMessageOKCancel(message,
                                new DialogInterface.OnClickListener() {
                                    @RequiresApi(api = Build.VERSION_CODES.M)
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ((Activity) mIPicUploadOptionView.getMyContext()).requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                                PicUploadOptionsFragment.REQUEST_CODE_ASK_MULTIPLE_CAMERA_STORAGE);
                                    }
                                });
                        return;
                    }
                }
            } else {
                List<String> permissionsNeeded = new ArrayList<String>();
                final List<String> permissionsList = new ArrayList<String>();
                if (!addPermission(permissionsList, Manifest.permission.WRITE_EXTERNAL_STORAGE))
                    permissionsNeeded.add(AppUtils.getStrFromRes(R.string.storage));
                if (permissionsList.size() > 0) {
                    if (permissionsNeeded.size() > 0) {
                        String message = AppUtils.getStrFromRes(R.string.grant_access_message) + " " + permissionsNeeded.get(0);
                        for (int i = 1; i < permissionsNeeded.size(); i++)
                            message = message + ", " + permissionsNeeded.get(i);
                        showMessageOKCancel(message,
                                new DialogInterface.OnClickListener() {
                                    @RequiresApi(api = Build.VERSION_CODES.M)
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ((Activity) mIPicUploadOptionView.getMyContext()).requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                                PicUploadOptionsFragment.REQUEST_CODE_ASK_MULTIPLE_STORAGE);
                                    }
                                });
                        return;
                    }
                }
            }
        }
        if (type == PicUploadOptionsFragment.SELECTION_CAMERA) {
            dispatchTakePictureIntent();
        } else if (type == PicUploadOptionsFragment.SELECTION_GALLERY) {
            dispatchChoosePictureIntent();
        } else {
            Toast.makeText(mIPicUploadOptionView.getMyContext(), AppUtils.getStrFromRes(R.string.exception_message), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PicUploadOptionsFragment.SELECTION_GALLERY || requestCode == PicUploadOptionsFragment.SELECTION_CAMERA || requestCode == UCrop.REQUEST_CROP) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d(TAG, "onActivityResult: Activity.RESULT_OK");
                if (requestCode == PicUploadOptionsFragment.SELECTION_CAMERA) {
                    startCropper(getPicAbsolutePath(), ((PicUploadOptionsFragment) mIPicUploadOptionView).getCropType(),
                            ((PicUploadOptionsFragment) mIPicUploadOptionView).getRatioX(),
                            ((PicUploadOptionsFragment) mIPicUploadOptionView).getRatioY());
                    setPicAbsolutePath("");
                } else if (requestCode == PicUploadOptionsFragment.SELECTION_GALLERY) {
                    startCropper(data.getData(),
                            ((PicUploadOptionsFragment) mIPicUploadOptionView).getCropType(),
                            ((PicUploadOptionsFragment) mIPicUploadOptionView).getRatioX(),
                            ((PicUploadOptionsFragment) mIPicUploadOptionView).getRatioY());
                    setPicAbsolutePath("");
                } else if (requestCode == UCrop.REQUEST_CROP) {
                    final Uri resultUri = UCrop.getOutput(data);
                    ((PicUploadBaseActivity) mIPicUploadOptionView.getMyContext()).onTakeOrChoosePicSussess(new File(resultUri.getPath()).getAbsolutePath());
                    setPicAbsolutePath("");
                } else {
                    Toast.makeText((mIPicUploadOptionView.getMyContext()), AppUtils.getStrFromRes(R.string.exception_message), Toast.LENGTH_SHORT).show();
                }

            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i(TAG, "onActivityResult: Activity.RESULT_CANCELED");
                setPicAbsolutePath("");
                Toast.makeText((mIPicUploadOptionView.getMyContext()), AppUtils.getStrFromRes(R.string.action_canceled), Toast.LENGTH_SHORT).show();
            } else {
                Log.i(TAG, "onActivityResult: resultCode==>" + resultCode);
                setPicAbsolutePath("");
                Toast.makeText((mIPicUploadOptionView.getMyContext()), AppUtils.getStrFromRes(R.string.exception_message), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PicUploadOptionsFragment.REQUEST_CODE_ASK_MULTIPLE_CAMERA_STORAGE: {
                Map<String, Integer> perms = new HashMap<String, Integer>();
                perms.put(Manifest.permission.CAMERA, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                if (perms.get(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    checkPermission(PicUploadOptionsFragment.SELECTION_CAMERA);
                } else {
                    Toast.makeText(mIPicUploadOptionView.getMyContext(), AppUtils.getStrFromRes(R.string.permission_denied), Toast.LENGTH_SHORT).show();
                }
                return;
            }

            case PicUploadOptionsFragment.REQUEST_CODE_ASK_MULTIPLE_STORAGE: {
                Map<String, Integer> perms = new HashMap<String, Integer>();
                perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                if (perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    checkPermission(PicUploadOptionsFragment.SELECTION_GALLERY);
                } else {
                    Toast.makeText(mIPicUploadOptionView.getMyContext(), AppUtils.getStrFromRes(R.string.permission_denied), Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean addPermission(List<String> permissionsList, String permission) {
        if (mIPicUploadOptionView.getMyContext().checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            return false;
        }
        return true;
    }

    private android.support.v7.app.AlertDialog alertDialog;

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mIPicUploadOptionView.getMyContext());

        alertDialogBuilder.setMessage(message)
                .setPositiveButton(AppUtils.getStrFromRes(R.string.okay), okListener)
                .setNegativeButton(AppUtils.getStrFromRes(R.string.cancel), null);

        alertDialog = alertDialogBuilder.create();
        alertDialog.getWindow().setWindowAnimations(R.style.AlertDialogTheme);
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                alertDialog.getButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE).setTextColor(AppController.getContext().getResources().getColor(R.color.colorPrimaryDark));
                alertDialog.getButton(android.support.v7.app.AlertDialog.BUTTON_NEGATIVE).setTextColor(AppController.getContext().getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        alertDialog.show();
    }

    private void dispatchTakePictureIntent() {
        setPicAbsolutePath("");
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensuring that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(mIPicUploadOptionView.getMyContext().getPackageManager()) != null) {
            //File where the photo should go
            try {
                File photoFile = FileUtil.createImageFile();
                if (photoFile != null) {
                    setPicAbsolutePath(photoFile.getAbsolutePath());
                    Uri photoURI = FileProvider.getUriForFile(mIPicUploadOptionView.getMyContext(), mIPicUploadOptionView.getMyContext().getString(R.string.file_provider_authority), photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    ((Activity) mIPicUploadOptionView.getMyContext()).startActivityForResult(takePictureIntent, PicUploadOptionsFragment.SELECTION_CAMERA);
                } else {
                    Toast.makeText(mIPicUploadOptionView.getMyContext(), AppUtils.getStrFromRes(R.string.exception_message), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(mIPicUploadOptionView.getMyContext(), AppUtils.getStrFromRes(R.string.exception_message), Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(mIPicUploadOptionView.getMyContext(), AppUtils.getStrFromRes(R.string.camera_not_avail), Toast.LENGTH_SHORT).show();
        }
    }


    private void dispatchChoosePictureIntent() {
        if (Build.VERSION.SDK_INT < 19) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            ((Activity) mIPicUploadOptionView.getMyContext()).startActivityForResult(intent, PicUploadOptionsFragment.SELECTION_GALLERY);
        } else {
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            ((Activity) mIPicUploadOptionView.getMyContext()).startActivityForResult(i, PicUploadOptionsFragment.SELECTION_GALLERY);
        }
    }

    public String getPicAbsolutePath() {
        return picAbsolutePath;
    }

    public void setPicAbsolutePath(String picAbsolutePath) {
        this.picAbsolutePath = picAbsolutePath;
    }

    public void startCropper(Uri uri, int cropType, float ratioX, float ratioY) {

        try {
            UCrop uCrop = UCrop.of(uri, Uri.fromFile(FileUtil.createImageFile()));
            uCrop = UCropperUtil.setAspectRation(uCrop, cropType, ratioX, ratioY);
            uCrop = UCropperUtil.setMyTheme(uCrop, mIPicUploadOptionView.getMyContext());
            uCrop = UCropperUtil.setCompressionFormat(uCrop, UCropperUtil.JPEG);
            uCrop.start((Activity) mIPicUploadOptionView.getMyContext());
        } catch (Exception e) {
            Toast.makeText(mIPicUploadOptionView.getMyContext(), AppUtils.getStrFromRes(R.string.exception_message), Toast.LENGTH_SHORT).show();
        }
    }


    public void startCropper(String filePath, int cropType, float ratioX, float ratioY) {
        try {
            UCrop uCrop = UCrop.of(Uri.fromFile(new File(filePath)), Uri.fromFile(FileUtil.createImageFile()));
            uCrop = UCropperUtil.setAspectRation(uCrop, cropType, ratioX, ratioY);
            uCrop = UCropperUtil.setMyTheme(uCrop, mIPicUploadOptionView.getMyContext());
            uCrop = UCropperUtil.setCompressionFormat(uCrop, UCropperUtil.JPEG);
            uCrop.start((Activity) mIPicUploadOptionView.getMyContext());
        } catch (Exception e) {
            Toast.makeText(mIPicUploadOptionView.getMyContext(), AppUtils.getStrFromRes(R.string.exception_message), Toast.LENGTH_SHORT).show();
        }
    }
}
