package com.mw.eleven11.beanInput;

public class UploadImageInput {

    String SessionKey;
    String FilePath;
    String Section;
    String MediaCaption;


    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String sessionKey) {
        SessionKey = sessionKey;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getMediaCaption() {
        return MediaCaption;
    }

    public void setMediaCaption(String mediaCaption) {
        MediaCaption = mediaCaption;
    }
}
