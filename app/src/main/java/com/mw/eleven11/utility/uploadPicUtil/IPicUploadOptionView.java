package com.mw.eleven11.utility.uploadPicUtil;

import android.content.Context;

/**
 * Created by hp on 05-08-2017.
 */

public interface IPicUploadOptionView {
    void hide();

    Context getMyContext();

    String onPath(String path);
}
