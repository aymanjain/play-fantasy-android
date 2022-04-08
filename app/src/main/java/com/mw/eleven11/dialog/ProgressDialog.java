package com.mw.eleven11.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.mw.eleven11.R;
import com.mw.eleven11.utility.ViewUtils;

import butterknife.ButterKnife;


public class ProgressDialog {

    Context context;
    AlertDialog alert;

    public ProgressDialog(Context context) {
        this.context = context;

    }

    public void show() {
        try {
            dismiss();
            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
            LayoutInflater _inflater = LayoutInflater.from(context);
            View g = _inflater.inflate(R.layout.dialog_loader, null);
            ButterKnife.bind(this, g);
            builder.setView(g, 0, 0, 0, 0);
            alert = builder.create();
            alert.setCancelable(false);
            alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alert.show();
            ViewUtils.hideKeyboard(context);
            alert.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void dismiss() {
        if (alert != null && alert.isShowing()) {
            alert.dismiss();
            ViewUtils.hideKeyboard(context);
            alert.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }
    }
}
