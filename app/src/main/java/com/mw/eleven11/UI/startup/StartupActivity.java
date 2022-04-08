package com.mw.eleven11.UI.startup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.loginRagisterModule.HaveCode;
import com.mw.eleven11.UI.loginRagisterModule.LoginScreen;
import com.mw.eleven11.UI.loginRagisterModule.Register;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.customView.RobotoRegularTextView;

import butterknife.BindView;
import butterknife.OnClick;

public class StartupActivity extends BaseActivity {

    Context mContext;


    @BindView(R.id.letsStart)
    RobotoRegularTextView letsStart;

    @BindView(R.id.alreadyUser)
    RobotoRegularTextView alreadyUser;

    @BindView(R.id.haveARefrralCode)
    RobotoRegularTextView haveARefrralCode;


    @OnClick(R.id.alreadyUser)
    void onAlreadyUser() {
        LoginScreen.start(mContext);
    }

    @OnClick(R.id.login)
    void onLogin() {
        LoginScreen.start(mContext);
    }

    @OnClick(R.id.register)
    void onRegister() {
        Register.start(mContext);
    }

    @OnClick(R.id.haveARefrralCode)
    void onHaveRefrralCode() {

        HaveCode.start(mContext);
    }

    @OnClick(R.id.letsStart)
    void onLetsStart() {

        //  Toast.makeText(mContext, "Work in progress...coming soon.", Toast.LENGTH_SHORT).show();

        // LetsPlayActivity.start(mContext);
    }

    /*@OnClick(R.id.beingAuser)
    void onBeingUser() {

        LoginScreen.start(mContext);
    }*/

    public static void start(Context context) {
/*        if (!AppSession.getInstance().isWalkThroughShown()) {
            WalkThroughActivity.start(context);
            return;
        }*/

        Intent starter = new Intent(context, StartupActivity.class);
        if (Build.VERSION.SDK_INT >= 11) {
            starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        } else {
            starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_startup;
    }

    @Override
    public void init() {

        mContext = this;
    }
}
