package com.mw.eleven11.utility;

import android.os.Environment;
import android.util.Patterns;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.mw.eleven11.AppController;
import com.mw.eleven11.R;

/**
 * Created by hp on 17-08-2017.
 */

public class FileUtil {

    public static void deleteRecursive(File fileOrDirectory) {

        if (fileOrDirectory != null && fileOrDirectory.isDirectory()) {
            String[] fileList = fileOrDirectory.list();
            for (int i = 0; i < fileList.length; i++) {
                File myFile = new File(fileOrDirectory, fileList[i]);
                myFile.delete();
            }
        }

    }

    /* method for checking valid email-id */
    public static boolean isValidUrl(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.WEB_URL.matcher(target).matches();
        }
    }

    public static String getFilename(String filepath) {
        if (filepath == null)
            return null;

        final String[] filepathParts = filepath.split("/");

        return filepathParts[filepathParts.length - 1];
    }

    public static boolean copyFile(File sourceFile, File destFile) {
        try {
            if (!sourceFile.exists()) {
                return false;
            }
            if (!destFile.exists()) {
                destFile.getParentFile().mkdirs();
                destFile.createNewFile();
            }
            FileChannel source = null;
            FileChannel destination = null;
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            if (destination != null && source != null) {
                destination.transferFrom(source, 0, source.size());
            }
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String getFilePath() {
        return Environment.getExternalStorageDirectory() + "/Android/data/" + AppController.getContext().getPackageName() + "/files/" + new Date().getTime() + ".jpg";

    }

    public static File createImageFile() throws IOException {
        final String imageFileName = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "pics");
        storageDir.mkdirs();
        return File.createTempFile(imageFileName, ".jpg", storageDir);
    }

    public static File createPdfFile() throws IOException {
        final String imageFileName = "TEAM_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "teams");
        if (folder.exists()) {
            folder.delete();
        }
        return File.createTempFile(imageFileName, ".pdf", folder);
    }

    public static File createApkFile() throws IOException {
        final String imageFileName = "APK_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        File folder = getPublicDirectory();
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return File.createTempFile(imageFileName, ".apk", folder);
    }

    public static File createFile(String fileName) throws IOException {
        File outputFile = new File(getPublicDirectory(), fileName);
        if (outputFile.exists()) {
            outputFile.delete();
        }
        outputFile.createNewFile();
        return outputFile;
    }

    public static File getPublicDirectory() {
        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + AppUtils.getStrFromRes(R.string.app_name));
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folder;
    }
}
