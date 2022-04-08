package com.mw.eleven11.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

import com.mw.eleven11.R;
import com.mw.eleven11.utility.ViewUtils;

public class AlertDialog {
    private Context context;
    private android.support.v7.app.AlertDialog alertDialog;

    public void show() {
        alertDialog.show();
        ViewUtils.hideKeyboard(context);
    }

    public void hide() {
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
            ViewUtils.hideKeyboard(context);
        }
    }

    public interface OnBtnClickListener {
        void onYesClick();

        void onNoClick();
    }

    public AlertDialog(final Context context, String mMessage, String yesBtnText, String noBtnText, final OnBtnClickListener onBtnClickListener) {

        this.context = context;
        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(context);

        // set title
        alertDialogBuilder.setTitle(context.getResources().getString(R.string.app_name));

        // set dialog message
        alertDialogBuilder.setMessage(mMessage).setCancelable(false);


        if (!TextUtils.isEmpty(yesBtnText)) {
            alertDialogBuilder.setPositiveButton(yesBtnText, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    hide();
                    if (onBtnClickListener != null) {
                        onBtnClickListener.onYesClick();
                    }
                }
            });
        }

        if (!TextUtils.isEmpty(noBtnText)) {
            alertDialogBuilder.setNegativeButton(noBtnText, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    hide();
                    if (onBtnClickListener != null) {
                        onBtnClickListener.onNoClick();
                    }
                }
            });
        }


        // create alert dialog
        alertDialog = alertDialogBuilder.create();
        alertDialog.getWindow().setWindowAnimations(R.style.AlertDialogTheme);
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                alertDialog.getButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE).setTextColor(context.getResources().getColor(R.color.header_background_home_page));
                alertDialog.getButton(android.support.v7.app.AlertDialog.BUTTON_NEGATIVE).setTextColor(context.getResources().getColor(R.color.header_background_home_page));
            }
        });
    }
}