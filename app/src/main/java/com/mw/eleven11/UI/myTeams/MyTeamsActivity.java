package com.mw.eleven11.UI.myTeams;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.MenuItem;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.base.BaseActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class MyTeamsActivity extends BaseActivity {

    @BindString(R.string.my_team)
    String title;
    /* Butter Knife : view mapping */
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    /*@BindView(R.id.toolbar)
    Toolbar mToolbar;*/
   /* @BindView(R.id.title)
    CustomTextView mCustomTextViewTitle;*/
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_fragment_activity;
    }

    @Override
    public void init() {
        mContext = this;
        if (AppSession.getInstance().getGameType() == 1) {
            setFragment(MyTeamsFragment.getInstance(getIntent().getExtras()), "MyTeamsFragment");
        } else if (AppSession.getInstance().getGameType() == 2) {
            setFragment(MyFootballTeamsFragment.getInstance(getIntent().getExtras()), "MyTeamsFragment");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }


    @OnClick(R.id.back)
    void onBackclick(){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("onActivityResult", "onActivityResult TEAM:" + requestCode);
        if (requestCode == REQUEST_CODE_CREATE_TEAM && resultCode == RESULT_OK) {
            setResult(RESULT_OK);
            finish();
        } else if (requestCode == REQUEST_CODE_JOIN_CONTESTS && resultCode == RESULT_OK) {
            setResult(RESULT_OK);
            finish();
        }
    }
}
