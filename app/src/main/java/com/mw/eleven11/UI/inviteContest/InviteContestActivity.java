package com.mw.eleven11.UI.inviteContest;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class InviteContestActivity extends BaseActivity {

    @BindString(R.string.invite_your_contest)
    String title;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;

    String userInviteCode = "";
    String matchTeamVS = "";
    @BindView(R.id.ctv_code)
    CustomTextView ctvCode;
    private Context mContext;

    @OnClick(R.id.ctv_code)
    void copyCode(){
        String getstring = ctvCode.getText().toString();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied Text",getstring);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.back)
    void onBack(){
        finish();
    }

    public static void start(Context context, String userInviteCode, String matchTeamVS) {
        Intent starter = new Intent(context, InviteContestActivity.class);
        starter.putExtra("userInviteCode", userInviteCode);
        starter.putExtra("matchTeamVS",matchTeamVS);
        ((Activity) context).startActivityForResult(starter, REQUEST_CODE_UPDATE_PROFILE);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    /* Butter Knife : view mapping */

    @OnClick(R.id.ctv_invite)
    public void save(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        if (userInviteCode.equalsIgnoreCase("") || matchTeamVS.equals("")){
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Join my Contest (Code:" + AppSession.getInstance().UserInviteCode + ")" + "for league on " + AppUtils.getStrFromRes(R.string.app_name) + "");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Put your cricket knowledge to test and play with me on Eleven11." + "\n" + "Click "+ AppConfiguration.MAIN_URL+" to download the "
                    + AppUtils.getStrFromRes(R.string.app_name) + " app or login on portal and Use contest code " + Html.fromHtml("<b>" + AppSession.getInstance().UserInviteCode + " </b>") +
                    "to join my contest of " + AppSession.getInstance().MatchTeamVS);
        }else {
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Join my Contest (Code:" + userInviteCode + ")" + "for league on " + AppUtils.getStrFromRes(R.string.app_name) + "");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Put your cricket knowledge to test and play with me on Eleven11." + "\n" + "Click "+ AppConfiguration.MAIN_URL+" to download the "
                    + AppUtils.getStrFromRes(R.string.app_name) + " app or login on portal and Use contest code " + Html.fromHtml("<b>" + userInviteCode + " </b>") +
                    "to join my contest of " + matchTeamVS);
        }
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_invite_contest;
    }

    @Override
    public void init() {
        if (getIntent() != null) {
            if (getIntent().hasExtra("userInviteCode")) {
                userInviteCode = getIntent().getStringExtra("userInviteCode");
            }

            if (getIntent().hasExtra("matchTeamVS")) {
                matchTeamVS = getIntent().getStringExtra("matchTeamVS");
            }
        }
     /*   setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mCustomTextViewTitle.setText(title);*/
        mContext = this;
        if (userInviteCode.equalsIgnoreCase("")){
            ctvCode.setText(AppSession.getInstance().UserInviteCode);

        }else {
            ctvCode.setText(userInviteCode);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }


    public void showSnackBar(@NonNull String message) {
        AppUtils.showSnackBar(mContext, mCoordinatorLayout, message);
    }

}
