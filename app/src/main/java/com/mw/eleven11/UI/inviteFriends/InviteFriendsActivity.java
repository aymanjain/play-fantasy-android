package com.mw.eleven11.UI.inviteFriends;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;

import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.outsideEvents.OutSideEvent;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;

public class InviteFriendsActivity extends BaseActivity {


    public static void start(Context context) {
        Intent starter = new Intent(context, InviteFriendsActivity.class);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @OnClick(R.id.back)
    void onBackClick() {

        onBackPressed();
    }



    @BindView(R.id.invite_code)
    CustomTextView invite_code;

    @OnClick(R.id.howItWorks)
    void howItWorks() {
        OutSideEvent.start(this, "HOW_IT_WORKS", Constant.HOW_IT_WORKS_URL);
    }

   /* @OnClick(R.id.rulesOfFairPlay)
    void onRulesOfFairPlay() {
        OutSideEvent.start(this, "RULES_OF_FAIRPLAY", Constant.FAIR_PLAY_URL);
    }*/


    @OnClick(R.id.ll_invite_code_root)
    void copyCode() {
        String getstring = invite_code.getText().toString();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied Text", getstring);
        clipboard.setPrimaryClip(clip);
        AppUtils.showToast(this, "Copied to clipboard");

    }

    @OnClick(R.id.inviteFriendsMore)
    void onShareClick() {

        AppUtils.shareTextUrl(this, AppUtils.getStrFromRes(R.string.inviteFriendsMore),
                "Here's Rs.50 to play "+AppUtils.getStrFromRes(R.string.app_name)+" Cricket with me on "+AppUtils.getStrFromRes(R.string.app_name)+". Click "+ AppConfiguration.MAIN_URL+" to download the "+AppUtils.getStrFromRes(R.string.app_name)+" app and use my code " +
                        AppSession.getInstance().
                                getLoginSession().getData().getReferralCode() + " to register.",
                AppUtils.getStrFromRes(R.string.app_name));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_invite_friends;
    }

    @Override
    public void init() {

        invite_code.setText(AppSession.getInstance().
                getLoginSession().getData().getReferralCode());
    }
}
