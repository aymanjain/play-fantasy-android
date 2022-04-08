package com.mw.eleven11.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.mw.eleven11.R;
import com.mw.eleven11.customView.CustomTextView;

import butterknife.BindView;
import butterknife.OnClick;


public class SessionExpireDialogActivity extends BaseActivity {

    @BindView(R.id.da_message)
    CustomTextView mCustomTextViewMessage;

    public static boolean isOpen = false;
    /* Butter Knife : view mapping */
    private Context mContext;

    public static void start(Context context, String message) {
        Intent starter = new Intent(context, SessionExpireDialogActivity.class);
        starter.putExtra("message", message);
        context.startActivity(starter);
    }

    /* Butter Knife : view mapping */
    @OnClick(R.id.da_yes)
    public void cancel(android.view.View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isOpen = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.dialog_session_alert;
    }

    @Override
    public void init() {
        isOpen = true;
        mContext = this;
        if (getIntent() != null) {
            if (getIntent().hasExtra("message")) {
                mCustomTextViewMessage.setText(getIntent().getStringExtra("message"));
            }
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
