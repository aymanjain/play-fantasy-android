package com.mw.eleven11.UI.previewTeam;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mw.eleven11.R;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.BasePagerAdapter;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class PlayerPreviewActivity extends BaseActivity {


    @BindView(R.id.sdv)
    SimpleDraweeView mSimpleDraweeView;

    @BindView(R.id.ctv_total)
    CustomTextView ctv_total;
    @BindView(R.id.teamName)
    CustomTextView teamName;


    /* @BindView(R.id.toolbar)
     Toolbar mToolbar;*/

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    public BasePagerAdapter mViewPagerAdapter;

    @BindView(R.id.ctv_player_name)
    CustomTextView mCustomTextViewNAme;

    String seriesId = "";
    String playerID = "";
    String matchID = "";
    String selectedPercent = "";
    String credit = "";
    String points = "";
    String bats = "";
    String bowls = "";
    String country = "";
    String status = "";

    private Context mContext;
    private Loader loader;

    String pic = "";
    String name = "";
    private PlayersOutput.DataBean.RecordsBean livePlayerStatusData;
    private String teamNameShort, playerRole;

    /*@OnClick(R.id.viewPlayerState)
    void setviewPlayerState() {
        livePlayerStatusData = AppSession.getInstance().playerPoints;
         *//*   mPlayerPointsBreakup = responsePlayerPointsBreakup;
            mPlayerPointsBreakup.setSelected_by(selected_by);*//*
        if (livePlayerStatusData.getPointsData().size() != 0) {
            Bundle b = new Bundle();
            b.putSerializable("livePlayerStatusData", livePlayerStatusData);
//            b.putSerializable("playerData",  mPlayerPointsBreakup);
            BottomSheetPointsFragment dialogFragment = new BottomSheetPointsFragment();
            dialogFragment.setUpdateable(new PlayerPointCallback() {
                @Override
                public void close() {
                }
                @Override
                public PlayersOutput.DataBean.RecordsBean getPlayer() {
                    return livePlayerStatusData;
                }
                @Override
                public Context getContext() {
                    return null;
                }
            });
            dialogFragment.setArguments(b);
            dialogFragment.show(getSupportFragmentManager(), dialogFragment.getTag());
        }else {
           // showSnackBar("Player Points not available");
        }
    }*/


    public static void start(Context context, String name, String credit, String points, String bats, String bowls,
                             String country, String pic, String seriesId, String playerID, String matchID, String selectedPercent,
                             String status, String teamNameShort, String playerRole) {
        Intent starter = new Intent(context, PlayerPreviewActivity.class);
        starter.putExtra("name", name);
        starter.putExtra("credit", credit);
        starter.putExtra("points", points);
        starter.putExtra("bats", bats);
        starter.putExtra("bowls", bowls);
        starter.putExtra("country", country);
        starter.putExtra("pic", pic);
        starter.putExtra("seriesId", seriesId);
        starter.putExtra("playerID", playerID);
        starter.putExtra("matchID", matchID);
        starter.putExtra("selectedPercent", selectedPercent);
        starter.putExtra("teamNameShort", teamNameShort);
        starter.putExtra("playerRole", playerRole);
        starter.putExtra("status", status);

        context.startActivity(starter);
    }

    @OnClick(R.id.back)
    void onbackclick() {
        finish();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_player_preview;
    }

    @Override
    public void init() {
        mContext = this;
//        loader = new Loader(this);

        name = getIntent().getStringExtra("name");
        credit = getIntent().getStringExtra("credit");
        points = getIntent().getStringExtra("points");
        bowls = getIntent().getStringExtra("bowls");
        bats = getIntent().getStringExtra("bats");
        country = getIntent().getStringExtra("country");
        pic = getIntent().getStringExtra("pic");
        seriesId = getIntent().getStringExtra("seriesId");
        playerID = getIntent().getStringExtra("playerID");
        matchID = getIntent().getStringExtra("matchID");
        selectedPercent = getIntent().getStringExtra("selectedPercent");
        status = getIntent().getStringExtra("status");
        playerRole = getIntent().getStringExtra("playerRole");
        teamNameShort = getIntent().getStringExtra("teamNameShort");


        mViewPagerAdapter = new BasePagerAdapter(getSupportFragmentManager());
        if (status.equals("Pending")) {
            mTabLayout.setVisibility(View.GONE);
        } else {
            mViewPagerAdapter.addFrag(PlayerPointsFragment.newInstance(seriesId, playerID, matchID), "PLayer Points", 1);
            mTabLayout.setVisibility(View.VISIBLE);
        }
        mViewPagerAdapter.addFrag(PlayerStatsFragment.newInstance(seriesId, playerID), "Player Stats", 0);

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

        AppUtils.applyFontedMyContestTab(this, mViewPager, mTabLayout);
        playerDetail();
    }


    public void playerDetail() {

        mSimpleDraweeView.setImageURI(pic);
        mCustomTextViewNAme.setText(name);

        ctv_total.setText(points);
        if (teamNameShort != null) {
            if (map.containsKey(playerRole)) {
                teamName.setText(teamNameShort.trim().replace(" ", "") + " - " + map.get(playerRole));
            } else {
                teamName.setText(teamNameShort.trim().replace(" ", "") + " - " + playerRole);
            }
        } else {
            teamName.setText(" " + " - " + playerRole);
        }


    }

    Map<String, Object> map = new HashMap<String, Object>() {{
        put("WicketKeeper", "WK");
        put("Batsman", "Bat");
        put("AllRounder", "AR");
        put("Bowler", "Bowl");

    }};

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }


}