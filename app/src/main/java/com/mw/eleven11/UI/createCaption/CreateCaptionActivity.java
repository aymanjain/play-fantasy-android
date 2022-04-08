package com.mw.eleven11.UI.createCaption;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.MenuItem;

import com.mw.eleven11.R;
import com.mw.eleven11.base.BaseActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class CreateCaptionActivity extends BaseActivity {

    @BindString(R.string.create_c_vc)
    String title;
    /* Butter Knife : view mapping */
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
   /* @BindView(R.id.toolbar)
    Toolbar mToolbar;*/
  /*  @BindView(R.id.title)
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

    @OnClick(R.id.back)
    void onBack(){
        finish();
    }
    @Override
    public void init() {
      //  setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // mCustomTextViewTitle.setText(title);
        mContext = this;
        setFragment(CreateCaptionFragment.getInstance(getIntent().getExtras()), "CreateCaptionFragment");
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

    }
}
