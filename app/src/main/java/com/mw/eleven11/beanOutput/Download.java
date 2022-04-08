package com.mw.eleven11.beanOutput;


import android.os.Parcel;
import android.os.Parcelable;

public class Download implements Parcelable {

    public Download() {

    }

    public enum DownloadStatus {
        START("START"),
        DOWNLOADING("DOWNLOADING"),
        ERROR("ERROR"),
        COMPLETED("COMPLETED");

        private String stringValue;

        DownloadStatus(String toString) {
            stringValue = toString;
        }

        @Override
        public String toString() {
            return stringValue;
        }
    }

    private int progress = 0;
    private int currentFileSize = 0;
    private int totalFileSize = 0;
    private String fileUrl = "", filePath = "";
    int downloadId = 0;
    Download.DownloadStatus status = DownloadStatus.START;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getCurrentFileSize() {
        return currentFileSize;
    }

    public void setCurrentFileSize(int currentFileSize) {
        this.currentFileSize = currentFileSize;
    }

    public int getTotalFileSize() {
        return totalFileSize;
    }

    public void setTotalFileSize(int totalFileSize) {
        this.totalFileSize = totalFileSize;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(int downloadId) {
        this.downloadId = downloadId;
    }

    public DownloadStatus getStatus() {
        return status;
    }

    public void setStatus(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(downloadId);
        dest.writeInt(progress);
        dest.writeInt(currentFileSize);
        dest.writeInt(totalFileSize);
        dest.writeString(filePath);
        dest.writeString(fileUrl);
        dest.writeString(status.toString());
    }

    private Download(Parcel in) {

        downloadId = in.readInt();
        progress = in.readInt();
        currentFileSize = in.readInt();
        totalFileSize = in.readInt();
        filePath = in.readString();
        fileUrl = in.readString();
        status = Download.DownloadStatus.valueOf(in.readString());
    }

    public static final Creator<Download> CREATOR = new Creator<Download>() {
        public Download createFromParcel(Parcel in) {
            return new Download(in);
        }

        public Download[] newArray(int size) {
            return new Download[size];
        }
    };
}
