package com.mw.eleven11.UI.notifications;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.base.BaseActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class NotificationsActivity extends BaseActivity {

    @BindString(R.string.title_notifications)
    String title;
    /* Butter Knife : view mapping */
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.menu)
    ImageView mDelete;

    public NotificationsAdapter adapter;
    NotificationsFragment fragment;

    @OnClick(R.id.menu)
    public void onDeleteClick()
    {
        fragment.deleteAllNotification();
    }


    @OnClick(R.id.back)
    void onBackClick(){
        finish();
    }


    private Context mContext;
    boolean flag = false;

    public static void start(Context context) {
        Intent starter = new Intent(context, NotificationsActivity.class);
        starter.putExtra("type", "");
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }


    @Override
    public int getLayout() {
        return R.layout.activity_notification;
    }

    @Override
    public void init() {


        mContext = this;
        mDelete.setVisibility(View.GONE);

        flag = getIntent().getBooleanExtra("Flag",false);

        fragment = new NotificationsFragment();
        fragment=NotificationsFragment.getInstance(getIntent().getExtras());
        setFragment(fragment, "NotificationsFragment");
    }

    public void hideDeleteMenu(){
        mDelete.setVisibility(View.GONE);
    }

    public void showDeleteMenu(){
        mDelete.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (flag){
            HomeNavigation.start(mContext);
        }
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
