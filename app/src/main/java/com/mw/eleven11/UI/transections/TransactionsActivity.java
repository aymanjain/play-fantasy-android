package com.mw.eleven11.UI.transections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mw.eleven11.R;
import com.mw.eleven11.base.BaseActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class TransactionsActivity extends BaseActivity {

    private Context mContext;
    /* Butter Knife : view mapping */

    @BindString(R.string.recent_transactions)
    String title;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

//    @BindView(R.id.title)
//    CustomTextView mCustomTextViewTitle;

    public static void start(Context context) {
        Intent starter = new Intent(context, TransactionsActivity.class);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition( R.anim.dialog_open, R.anim.dialog_close );
    }


    @OnClick(R.id.back)
    public void onBackClick(){
        finish();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_fragment_activity;
    }
    @Override
    public void init() {
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   mCustomTextViewTitle.setText(title);
        mContext = this;
        setFragment(TransactionsFragment.getInstance("Transaction"), "TransactionsFragment");
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
