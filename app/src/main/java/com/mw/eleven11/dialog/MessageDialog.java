package com.mw.eleven11.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.mw.eleven11.R;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageDialog {
    public static final int margin = 35;
    private Context context;
    private AlertDialog alert;
    private OnOkayBtnClickListener onOkayBtnClickListener;
    @BindView(R.id.dm_message)
    CustomTextView dm_message;

    @OnClick(R.id.dm_okay)
    void onOkayClick() {
        hide();
        if (onOkayBtnClickListener != null) {
            onOkayBtnClickListener.onClick();
        }
    }


    public MessageDialog(Context context, OnOkayBtnClickListener onOkayBtnClickListener) {
        this.context = context;
        this.onOkayBtnClickListener = onOkayBtnClickListener;
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        LayoutInflater _inflater = LayoutInflater.from(context);
        View g = _inflater.inflate(R.layout.dialog_message, null);
        ButterKnife.bind(this, g);
        builder.setView(g, margin, margin, margin, margin);
        alert = builder.create();
        alert.setCancelable(false);
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.getWindow().setWindowAnimations(R.style.AlertDialogTheme);
    }

    public void show() {
        if (alert != null) {
            alert.show();
            ViewUtils.hideKeyboard(context);
            alert.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        }
    }

    public void hide() {
        if (alert.isShowing()) {
            alert.dismiss();
            ViewUtils.hideKeyboard(context);
            alert.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }
    }


    public void setTitle(String message) {
        dm_message.setText(message);
    }

    public interface OnOkayBtnClickListener {
        void onClick();
    }

    public void setOnOkayBtnClickListener(OnOkayBtnClickListener onOkayBtnClickListener) {
        this.onOkayBtnClickListener = onOkayBtnClickListener;
    }
}