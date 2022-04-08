package com.mw.eleven11.UI.createTeam;

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


public class CreateTeamActivity extends BaseActivity {

    @BindString(R.string.create_team)
    String title;
    /* Butter Knife : view mapping */
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    /*@BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.title)
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
        /*setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
        //mCustomTextViewTitle.setText(title);
        mContext = this;

        if ((getIntent().getExtras()).getString("title") != null) {
            // mCustomTextViewTitle.setText(getIntent().getStringExtra("title"));
        }

        if (getIntent().getExtras().getInt("actionTag") == 1) {
            // mCustomTextViewTitle.setText("Clone Team");
        }

        int gameType = AppSession.getInstance().getGameType();

        if (gameType == 1) {
            setFragment(CreateTeamFragment.getInstance(getIntent().getExtras()), "CreateTeamFragment");
        } else if (gameType == 2) {
            setFragment(CreateFootballTeamFragment.getInstance(getIntent().getExtras()), "CreateTeamFragment");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
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

    @OnClick(R.id.back)
    public void backOnClick() {
        finish();
    }
}
