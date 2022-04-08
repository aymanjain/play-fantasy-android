package com.mw.eleven11.UI.contestDetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.pointSystem.FootballPointSystemActivity;
import com.mw.eleven11.UI.pointSystem.PointSystemActivity;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.customView.CustomTextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class ContestDetail extends BaseActivity {

    private static final String TAG = "ContestLeaderBoard";
    @BindString(R.string.match_detail)
    String title;
    /* Butter Knife : view mapping */
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.title)
    CustomTextView mCustomTextViewTitle;
    ContestDetailFragment contestFragment;
    private Context mContext;



    public static void start(Context context, String matchGUID,String statusId) {
        Intent starter = new Intent(context, ContestDetail.class);
        starter.putExtra("matchGUID", matchGUID);

        starter.putExtra("statusId", statusId);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.contest_leader_board;
    }

    @OnClick(R.id.back)
    void onBackClick(){
        finish();
    }

   /* @OnClick(R.id.img_point)
    void onPointPreviewClick(){
       if (AppSession.getInstance().getGameType() == 1){
           PointSystemActivity.start(this);
       }else {
           FootballPointSystemActivity.start(this);
       }
    }*/


    @Override
    public void init() {
       /* setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        mCustomTextViewTitle.setText(title);
        mContext = this;
        contestFragment = ContestDetailFragment.getInstance(getIntent().getExtras());
        setFragment(contestFragment, "ContestDetailFragment");
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CREATE_TEAM && resultCode == RESULT_OK) {
            /*if (contestFragment != null) contestFragment.callTask();*/
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.refresh_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            /*if (contestFragment != null) contestFragment.callTask();*/
            return true;
        } else {
            finish();
            return true;
        }
    }}