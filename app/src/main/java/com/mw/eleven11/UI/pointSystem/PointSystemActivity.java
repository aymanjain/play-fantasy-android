package com.mw.eleven11.UI.pointSystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.mw.eleven11.R;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.BasePagerAdapter;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;

import butterknife.BindView;

public class PointSystemActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.title)
    CustomTextView mCustomTextViewTitle;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private Context mContext;
    private BasePagerAdapter mViewPagerAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, PointSystemActivity.class);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_point_system;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    @Override
    public void init() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_back);
        mCustomTextViewTitle.setVisibility(View.GONE);
        //mCustomTextViewTitle.setText("Point System");
        mContext = this;


        mViewPagerAdapter = new BasePagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFrag(PointSystemFragment.getInstance("PointsT10"), "T10", 0);
        mViewPagerAdapter.addFrag(PointSystemFragment.getInstance("PointsT20"), "T20", 1);
        mViewPagerAdapter.addFrag(PointSystemFragment.getInstance("PointsODI"), "ODI", 2);
        mViewPagerAdapter.addFrag(PointSystemFragment.getInstance("PointsTEST"), "Test", 3);
//        mViewPagerAdapter.addFrag(MatchesFragment.getInstance("", "LIVE", gameType, appLinkData, getArguments()), live, 1);
//        mViewPagerAdapter.addFrag(MatchesFragment.getInstance("", "COMPLETED", gameType, appLinkData, getArguments()), results, 2);
        //FIXTURE,LIVE,COMPLETED
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        AppUtils.applyFontedTab(this, mViewPager, mTabLayout);

    }


}
