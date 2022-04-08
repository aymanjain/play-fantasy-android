package com.mw.eleven11.UI.player;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;

import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.PlayerFantasyStatsInput;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.beanOutput.ResponsePlayerFantasyStats;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;


import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class PlayerActivity extends BaseActivity implements PlayerActivityView {


    int credit;
    Context mContext;
    ProgressDialog mProgressDialog;
    RecyclerView mRecyclerView;

    PlayerActivityPresenterImpl mPlayerActivityPresenter;

    String matchId = "";
    String seriesId = "";
    String playerId = "";

    float points;
    PlayersOutput.DataBean.RecordsBean mPlayerData;

    @BindView(R.id.name)
    CustomTextView mCustomTextViewName;
    @BindView(R.id.relative_layout)
    RelativeLayout mRelativeLayout;
    @BindView(R.id.stats_not_found)
    CustomTextView statsNotFound;
    @BindView(R.id.rl)
    RelativeLayout mRelativeLayoutStats;
    @BindView(R.id.matchwise_fantacy_stats)
    CustomTextView matchwiseFantacyStats;
    @BindView(R.id.table)
    LinearLayout table;
    /*   @BindView(R.id.toolbar)
       Toolbar mToolbar;*/
    @BindView(R.id.title)
    CustomTextView mCustomTextViewTitle;
    @BindView(R.id.sdv)
    SimpleDraweeView mSimpleDraweeView;
    @BindView(R.id.ctv_credit)
    CustomTextView mCredit;
    @BindView(R.id.ctv_points)
    CustomTextView mPoints;
    @BindView(R.id.ctv_bats)
    CustomTextView mBats;
    @BindView(R.id.ctv_bowls)
    CustomTextView mBowls;
    @BindView(R.id.ctv_nationality)
    CustomTextView mNationality;
    @BindView(R.id.ctv_birthday)
    CustomTextView mBirthday;
    @BindView(R.id.selected_sort)
    CustomTextView mSelectedBySort;
    @BindView(R.id.points_sort)
    CustomTextView mPointsSort;


    @BindView(R.id.test_bat_avg)
    CustomTextView test_bat_avg;
    @BindView(R.id.test_bat_str)
    CustomTextView test_bat_str;
    @BindView(R.id.test_bat_runs)
    CustomTextView test_bat_runs;
    @BindView(R.id.odi_bat_avg)
    CustomTextView odi_bat_avg;
    @BindView(R.id.odi_bat_str)
    CustomTextView odi_bat_str;
    @BindView(R.id.odi_bat_runs)
    CustomTextView odi_bat_runs;
    @BindView(R.id.t20_bat_avg)
    CustomTextView t20_bat_avg;
    @BindView(R.id.t20_bat_str)
    CustomTextView t20_bat_str;
    @BindView(R.id.t20_bat_runs)
    CustomTextView t20_bat_runs;

    @BindView(R.id.test_bowl_avg)
    CustomTextView test_bowl_avg;
    @BindView(R.id.test_bowl_er)
    CustomTextView test_bowl_er;
    @BindView(R.id.test_bowl_wk)
    CustomTextView test_bowl_wk;
    @BindView(R.id.odi_bowl_avg)
    CustomTextView odi_bowl_avg;
    @BindView(R.id.odi_bowl_er)
    CustomTextView odi_bowl_er;
    @BindView(R.id.odi_bowl_wk)
    CustomTextView odi_bowl_wk;
    @BindView(R.id.t20_bowl_avg)
    CustomTextView t20_bowl_avg;
    @BindView(R.id.t20_bowl_er)
    CustomTextView t20_bowl_er;
    @BindView(R.id.t20_bowl_wk)
    CustomTextView t20_bowl_wk;

    @BindView(R.id.odi_field_catches)
    CustomTextView odi_field_catches;
    @BindView(R.id.odi_field_st)
    CustomTextView odi_field_st;
    @BindView(R.id.t20_field_catches)
    CustomTextView t20_field_catches;
    @BindView(R.id.t20_field_st)
    CustomTextView t20_field_st;
    @BindView(R.id.test_field_catches)
    CustomTextView test_field_catches;
    @BindView(R.id.test_field_st)
    CustomTextView test_field_st;

    @BindView(R.id.ll_batting)
    LinearLayout ll_batting;
    @BindView(R.id.ll_bowling)
    LinearLayout ll_bowling;
    @BindView(R.id.ll_fielding)
    LinearLayout ll_fielding;

    @BindView(R.id.ctv_no_stats_batting_odi)
    CustomTextView ctv_no_stats_batting_odi;
    @BindView(R.id.ctv_no_stats_batting_t20)
    CustomTextView ctv_no_stats_batting_t20;
    @BindView(R.id.ctv_no_stats_batting_test)
    CustomTextView ctv_no_stats_batting_test;

    @BindView(R.id.ctv_no_stats_bowling_odi)
    CustomTextView ctv_no_stats_bowling_odi;
    @BindView(R.id.ctv_no_stats_bowling_t20)
    CustomTextView ctv_no_stats_bowling_t20;
    @BindView(R.id.ctv_no_stats_bowling_test)
    CustomTextView ctv_no_stats_bowling_test;

    @BindView(R.id.ctv_no_stats_fielding_odi)
    CustomTextView ctv_no_stats_fielding_odi;
    @BindView(R.id.ctv_no_stats_fielding_t20)
    CustomTextView ctv_no_stats_fielding_t20;
    @BindView(R.id.ctv_no_stats_fielding_test)
    CustomTextView ctv_no_stats_fielding_test;


    private Loader loader;
    PlayerAdapter mPlayerAdapter;

    public static void start(Context context, PlayersOutput.DataBean.RecordsBean playerData, int credit, String matchId) {
        Intent starter = new Intent(context, PlayerActivity.class);
        starter.putExtra("playerData", playerData);
        starter.putExtra("matchId", matchId);
        starter.putExtra("credit", credit);
        context.startActivity(starter);
    }

    @OnClick(R.id.add_to_my_team_btn)
    void addToMyTeamOnClick() {

    }

    @OnClick(R.id.back)
    void onBackClick() {
        finish();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_player;
    }

    @OnClick(R.id.selected_sort)
    public void SelectedSortOnclick() {
        if (mSelectedBySort.isSelected()) {
            mPlayerAdapter.shotBySelectedpercentage(true);
            mSelectedBySort.setSelected(false);
            mSelectedBySort.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_up, 0);

        } else {

            mPlayerAdapter.shotBySelectedpercentage(false);
            mSelectedBySort.setSelected(true);
            mSelectedBySort.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_down, 0);
        }
    }

    @OnClick(R.id.points_sort)
    public void pointsSortOnClick() {
        if (mPointsSort.isSelected()) {
            mPlayerAdapter.shotByPoint(true);
            mPointsSort.setSelected(false);
            mPointsSort.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_up, 0);

        } else {
            mPlayerAdapter.shotByPoint(false);
            mPointsSort.setSelected(true);
            mPointsSort.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_down, 0);
        }
    }


    @Override
    public void init() {

        mContext = this;
        loader = new Loader(this);
        mPlayerActivityPresenter = new PlayerActivityPresenterImpl(this, new UserInteractor());
        mPlayerData = new PlayersOutput.DataBean.RecordsBean();

        //playerId=getIntent().getStringExtra("playerId");
        if (getIntent().hasExtra("playerData")) {
            credit = getIntent().getIntExtra("credit", 0);
            mPlayerData = (PlayersOutput.DataBean.RecordsBean) getIntent().getSerializableExtra("playerData");
            matchId = getIntent().getStringExtra("matchId");

            playerDetail(mPlayerData);
        }


        ll_batting.setVisibility(View.GONE);
        ll_bowling.setVisibility(View.GONE);
        ll_fielding.setVisibility(View.GONE);


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);


        if (loader.getTryAgainView() != null)
            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

        seriesId = mPlayerData.getSeriesGUID();
        playerId = mPlayerData.getPlayerGUID();

        callPlayerFantasyStats();

    }

    private void callPlayerFantasyStats() {

        PlayerFantasyStatsInput mPlayerFantasyStatsInput = new PlayerFantasyStatsInput();
        mPlayerFantasyStatsInput.setPlayerGUID(playerId);
        mPlayerFantasyStatsInput.setSeriesGUID(seriesId);
        // mPlayerFantasyStatsInput.setMatchGUID(matchId);
        mPlayerFantasyStatsInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mPlayerFantasyStatsInput.setParams(Constant.PLAYER_FANTASY_STATS);

        mPlayerActivityPresenter.actionPlayerStats(mPlayerFantasyStatsInput);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }


    void playerDetail(PlayersOutput.DataBean.RecordsBean detail) {
        if (detail != null) {

            Log.d("playerDetail", AppUtils.gsonToJSON(detail));

            mSimpleDraweeView.setImageURI(detail.getPlayerPic());
            mCustomTextViewTitle.setText(detail.getPlayerName());
            mCustomTextViewName.setText(detail.getPlayerName());

            if (detail.getPlayerBattingStyle().equals("")) {
                mBats.setText("--");
            } else {
                mBats.setText(detail.getPlayerBattingStyle());
            }

            if (detail.getPlayerBowlingStyle().equals("")) {
                mBowls.setText("--");
            } else {
                mBowls.setText(detail.getPlayerBowlingStyle());
            }

            if (detail.getPlayerCountry().equals("")) {
                mNationality.setText("--");
            } else {
                mNationality.setText(detail.getPlayerCountry());
            }

            mBirthday.setText("--");
            mPoints.setText(detail.getTotalPointCredits() + "");

            mCredit.setText(detail.getPlayerSalary() + "");

        }
    }


    @Override
    public void showLoading() {

        loader.start();
        if (mProgressDialog == null)
            mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();

    }

    @Override
    public void hideLoading() {
        loader.hide();
        if (mProgressDialog != null) mProgressDialog.dismiss();

    }

    @Override
    public void onPlayerStatsSuccess(ResponsePlayerFantasyStats responseLogin) {
        hideLoading();
        if (responseLogin != null) {
            if (AppSession.getInstance().getGameType() == 1) {


                if (responseLogin.getData().getPlayerBattingStats().getODI() != null) {

                    if (responseLogin.getData().getPlayerBattingStats().getTest().getAverage() == 0.0 &&
                            responseLogin.getData().getPlayerBattingStats().getTest().getStrikeRate() == 0.0 &&
                            responseLogin.getData().getPlayerBattingStats().getTest().getRuns() == 0.0) {

                        ctv_no_stats_batting_test.setVisibility(View.VISIBLE);
                        test_bat_avg.setVisibility(View.GONE);
                        test_bat_str.setVisibility(View.GONE);
                        test_bat_runs.setVisibility(View.GONE);
                    } else {
                        ctv_no_stats_batting_test.setVisibility(View.GONE);
                        test_bat_avg.setVisibility(View.VISIBLE);
                        test_bat_str.setVisibility(View.VISIBLE);
                        test_bat_runs.setVisibility(View.VISIBLE);
                        test_bat_avg.setText(responseLogin.getData().getPlayerBattingStats().getTest().getAverage() + "");
                        test_bat_str.setText(responseLogin.getData().getPlayerBattingStats().getTest().getStrikeRate() + "");
                        test_bat_runs.setText(responseLogin.getData().getPlayerBattingStats().getTest().getRuns() + "");
                    }

                    if (responseLogin.getData().getPlayerBattingStats().getODI().getAverage() == 0.0 &&
                            responseLogin.getData().getPlayerBattingStats().getODI().getStrikeRate() == 0.0 &&
                            responseLogin.getData().getPlayerBattingStats().getODI().getRuns() == 0.0) {
                        ctv_no_stats_batting_odi.setVisibility(View.VISIBLE);
                        odi_bat_avg.setVisibility(View.GONE);
                        odi_bat_str.setVisibility(View.GONE);
                        odi_bat_runs.setVisibility(View.GONE);
                    } else {
                        ctv_no_stats_batting_odi.setVisibility(View.GONE);
                        odi_bat_avg.setVisibility(View.VISIBLE);
                        odi_bat_str.setVisibility(View.VISIBLE);
                        odi_bat_runs.setVisibility(View.VISIBLE);
                        odi_bat_avg.setText(responseLogin.getData().getPlayerBattingStats().getODI().getAverage() + "");
                        odi_bat_str.setText(responseLogin.getData().getPlayerBattingStats().getODI().getStrikeRate() + "");
                        odi_bat_runs.setText(responseLogin.getData().getPlayerBattingStats().getODI().getRuns() + "");
                    }

                    if (responseLogin.getData().getPlayerBattingStats().getT20().getAverage() == 0.0 &&
                            responseLogin.getData().getPlayerBattingStats().getT20().getStrikeRate() == 0.0 &&
                            responseLogin.getData().getPlayerBattingStats().getT20().getRuns() == 0.0) {

                        ctv_no_stats_batting_t20.setVisibility(View.VISIBLE);
                        t20_bat_avg.setVisibility(View.GONE);
                        t20_bat_str.setVisibility(View.GONE);
                        t20_bat_runs.setVisibility(View.GONE);
                    } else {
                        ctv_no_stats_batting_t20.setVisibility(View.GONE);
                        t20_bat_avg.setVisibility(View.VISIBLE);
                        t20_bat_str.setVisibility(View.VISIBLE);
                        t20_bat_runs.setVisibility(View.VISIBLE);
                        t20_bat_avg.setText(responseLogin.getData().getPlayerBattingStats().getT20().getAverage() + "");
                        t20_bat_str.setText(responseLogin.getData().getPlayerBattingStats().getT20().getStrikeRate() + "");
                        t20_bat_runs.setText(responseLogin.getData().getPlayerBattingStats().getT20().getRuns() + "");
                    }
                } else {
                    ctv_no_stats_batting_test.setVisibility(View.VISIBLE);
                    test_bat_avg.setVisibility(View.GONE);
                    test_bat_str.setVisibility(View.GONE);
                    test_bat_runs.setVisibility(View.GONE);

                    ctv_no_stats_batting_odi.setVisibility(View.VISIBLE);
                    odi_bat_avg.setVisibility(View.GONE);
                    odi_bat_str.setVisibility(View.GONE);
                    odi_bat_runs.setVisibility(View.GONE);

                    ctv_no_stats_batting_t20.setVisibility(View.VISIBLE);
                    t20_bat_avg.setVisibility(View.GONE);
                    t20_bat_str.setVisibility(View.GONE);
                    t20_bat_runs.setVisibility(View.GONE);
                }


                if (responseLogin.getData().getPlayerBowlingStats().getODI() != null) {
                    if (responseLogin.getData().getPlayerBowlingStats().getTest().getAverage() == 0.0 &&
                            responseLogin.getData().getPlayerBowlingStats().getTest().getStrikeRate() == 0.0 &&
                            responseLogin.getData().getPlayerBowlingStats().getTest().getRuns() == 0.0) {
                        ctv_no_stats_bowling_test.setVisibility(View.VISIBLE);
                        test_bowl_avg.setVisibility(View.GONE);
                        test_bowl_er.setVisibility(View.GONE);
                        test_bowl_wk.setVisibility(View.GONE);
                    } else {
                        ctv_no_stats_bowling_test.setVisibility(View.GONE);
                        test_bowl_avg.setVisibility(View.VISIBLE);
                        test_bowl_er.setVisibility(View.VISIBLE);
                        test_bowl_wk.setVisibility(View.VISIBLE);
                        test_bowl_avg.setText(responseLogin.getData().getPlayerBowlingStats().getTest().getAverage() + "");
                        test_bowl_er.setText(responseLogin.getData().getPlayerBowlingStats().getTest().getEconomy() + "");
                        test_bowl_wk.setText(responseLogin.getData().getPlayerBowlingStats().getTest().getWickets() + "");
                    }

                    if (responseLogin.getData().getPlayerBowlingStats().getODI().getAverage() == 0.0 &&
                            responseLogin.getData().getPlayerBowlingStats().getODI().getStrikeRate() == 0.0 &&
                            responseLogin.getData().getPlayerBowlingStats().getODI().getRuns() == 0.0) {
                        ctv_no_stats_bowling_odi.setVisibility(View.VISIBLE);
                        odi_bowl_avg.setVisibility(View.GONE);
                        odi_bowl_er.setVisibility(View.GONE);
                        odi_bowl_wk.setVisibility(View.GONE);
                    } else {
                        ctv_no_stats_bowling_odi.setVisibility(View.GONE);
                        odi_bowl_avg.setVisibility(View.VISIBLE);
                        odi_bowl_er.setVisibility(View.VISIBLE);
                        odi_bowl_wk.setVisibility(View.VISIBLE);
                        odi_bowl_avg.setText(responseLogin.getData().getPlayerBowlingStats().getODI().getAverage() + "");
                        odi_bowl_er.setText(responseLogin.getData().getPlayerBowlingStats().getODI().getEconomy() + "");
                        odi_bowl_wk.setText(responseLogin.getData().getPlayerBowlingStats().getODI().getWickets() + "");

                    }

                    if (responseLogin.getData().getPlayerBowlingStats().getT20().getAverage() == 0.0 &&
                            responseLogin.getData().getPlayerBowlingStats().getT20().getStrikeRate() == 0.0 &&
                            responseLogin.getData().getPlayerBowlingStats().getT20().getRuns() == 0.0) {
                        ctv_no_stats_bowling_t20.setVisibility(View.VISIBLE);
                        t20_bowl_avg.setVisibility(View.GONE);
                        t20_bowl_er.setVisibility(View.GONE);
                        t20_bowl_wk.setVisibility(View.GONE);
                    } else {
                        ctv_no_stats_bowling_t20.setVisibility(View.GONE);
                        t20_bowl_avg.setVisibility(View.VISIBLE);
                        t20_bowl_er.setVisibility(View.VISIBLE);
                        t20_bowl_wk.setVisibility(View.VISIBLE);
                        t20_bowl_avg.setText(responseLogin.getData().getPlayerBowlingStats().getT20().getAverage() + "");
                        t20_bowl_er.setText(responseLogin.getData().getPlayerBowlingStats().getT20().getEconomy() + "");
                        t20_bowl_wk.setText(responseLogin.getData().getPlayerBowlingStats().getT20().getWickets() + "");
                    }
                } else {
                    ctv_no_stats_bowling_test.setVisibility(View.VISIBLE);
                    test_bowl_avg.setVisibility(View.GONE);
                    test_bowl_er.setVisibility(View.GONE);
                    test_bowl_wk.setVisibility(View.GONE);
                    ctv_no_stats_bowling_odi.setVisibility(View.VISIBLE);
                    odi_bowl_avg.setVisibility(View.GONE);
                    odi_bowl_er.setVisibility(View.GONE);
                    odi_bowl_wk.setVisibility(View.GONE);
                    ctv_no_stats_bowling_t20.setVisibility(View.VISIBLE);
                    t20_bowl_avg.setVisibility(View.GONE);
                    t20_bowl_er.setVisibility(View.GONE);
                    t20_bowl_wk.setVisibility(View.GONE);
                }


                if (responseLogin.getData().getPlayerFieldingStats().getODI() != null) {
                    if (responseLogin.getData().getPlayerFieldingStats().getTest().getCatches() == 0.0 &&
                            responseLogin.getData().getPlayerFieldingStats().getTest().getStumpings() == 0.0) {
                        ctv_no_stats_fielding_test.setVisibility(View.VISIBLE);
                        test_field_catches.setVisibility(View.GONE);
                        test_field_st.setVisibility(View.GONE);
                    } else {
                        ctv_no_stats_fielding_test.setVisibility(View.GONE);
                        test_field_catches.setVisibility(View.VISIBLE);
                        test_field_st.setVisibility(View.VISIBLE);
                        test_field_catches.setText(responseLogin.getData().getPlayerFieldingStats().getTest().getCatches() + "");
                        test_field_st.setText(responseLogin.getData().getPlayerFieldingStats().getTest().getStumpings() + "");
                    }

                    if (responseLogin.getData().getPlayerFieldingStats().getODI().getCatches() == 0.0 &&
                            responseLogin.getData().getPlayerFieldingStats().getODI().getStumpings() == 0.0) {
                        ctv_no_stats_fielding_odi.setVisibility(View.VISIBLE);
                        odi_field_catches.setVisibility(View.GONE);
                        odi_field_st.setVisibility(View.GONE);
                    } else {
                        ctv_no_stats_fielding_odi.setVisibility(View.GONE);
                        odi_field_catches.setVisibility(View.VISIBLE);
                        odi_field_st.setVisibility(View.VISIBLE);
                        odi_field_catches.setText(responseLogin.getData().getPlayerFieldingStats().getODI().getCatches() + "");
                        odi_field_st.setText(responseLogin.getData().getPlayerFieldingStats().getODI().getStumpings() + "");
                    }

                    if (responseLogin.getData().getPlayerFieldingStats().getT20().getCatches() == 0.0 &&
                            responseLogin.getData().getPlayerFieldingStats().getT20().getStumpings() == 0.0) {
                        ctv_no_stats_fielding_t20.setVisibility(View.VISIBLE);
                        t20_field_catches.setVisibility(View.GONE);
                        t20_field_st.setVisibility(View.GONE);
                    } else {
                        ctv_no_stats_fielding_t20.setVisibility(View.GONE);
                        t20_field_catches.setVisibility(View.VISIBLE);
                        t20_field_st.setVisibility(View.VISIBLE);
                        t20_field_catches.setText(responseLogin.getData().getPlayerFieldingStats().getT20().getCatches() + "");
                        t20_field_st.setText(responseLogin.getData().getPlayerFieldingStats().getT20().getStumpings() + "");
                    }
                } else {
                    ctv_no_stats_fielding_test.setVisibility(View.VISIBLE);
                    test_field_catches.setVisibility(View.GONE);
                    test_field_st.setVisibility(View.GONE);
                    ctv_no_stats_fielding_odi.setVisibility(View.VISIBLE);
                    odi_field_catches.setVisibility(View.GONE);
                    odi_field_st.setVisibility(View.GONE);
                    ctv_no_stats_fielding_t20.setVisibility(View.VISIBLE);
                    t20_field_catches.setVisibility(View.GONE);
                    t20_field_st.setVisibility(View.GONE);
                }

                List<ResponsePlayerFantasyStats.DataBean.RecordsBean> responseBeanList = responseLogin.getData().getRecords();
                if (responseBeanList != null) {
                    mPlayerAdapter = new PlayerAdapter(mContext, responseBeanList);
                    mRecyclerView.setAdapter(mPlayerAdapter);
                } else {
                    mRelativeLayoutStats.setVisibility(View.INVISIBLE);
                    statsNotFound.setVisibility(View.VISIBLE);
                    //Toast.makeText(mContext, "Player Stats Data not found", Toast.LENGTH_SHORT).show();
                }

                if (!responseLogin.getData().getPlayerRole().equals("")) {
                    if (responseLogin.getData().getPlayerRole().equals("Batsman") || responseLogin.getData().getPlayerRole().equals("WicketKeeper")) {
                        ll_batting.setVisibility(View.VISIBLE);
                        ll_fielding.setVisibility(View.VISIBLE);
                        ll_bowling.setVisibility(View.GONE);
                    } else if (responseLogin.getData().getPlayerRole().equals("AllRounder")) {
                        ll_batting.setVisibility(View.VISIBLE);
                        ll_fielding.setVisibility(View.VISIBLE);
                        ll_bowling.setVisibility(View.VISIBLE);
                    } else if (responseLogin.getData().getPlayerRole().equals("Bowler")) {
                        ll_batting.setVisibility(View.GONE);
                        ll_fielding.setVisibility(View.VISIBLE);
                        ll_bowling.setVisibility(View.VISIBLE);
                    }

                } else {
                    if (responseLogin.getData().getPlayerRoleCompleted().equals("Batsman") || responseLogin.getData().getPlayerRoleCompleted().equals("WicketKeeper")) {
                        ll_batting.setVisibility(View.VISIBLE);
                        ll_fielding.setVisibility(View.VISIBLE);
                        ll_bowling.setVisibility(View.GONE);
                    } else if (responseLogin.getData().getPlayerRoleCompleted().equals("AllRounder")) {
                        ll_batting.setVisibility(View.VISIBLE);
                        ll_fielding.setVisibility(View.VISIBLE);
                        ll_bowling.setVisibility(View.VISIBLE);
                    } else if (responseLogin.getData().getPlayerRoleCompleted().equals("Bowler")) {
                        ll_batting.setVisibility(View.GONE);
                        ll_fielding.setVisibility(View.VISIBLE);
                        ll_bowling.setVisibility(View.VISIBLE);
                    }
                }


            } else {


                ll_batting.setVisibility(View.GONE);
                ll_bowling.setVisibility(View.GONE);
                ll_fielding.setVisibility(View.GONE);
                List<ResponsePlayerFantasyStats.DataBean.RecordsBean> responseBeanList = responseLogin.getData().getRecords();
                if (responseBeanList != null) {
                    mPlayerAdapter = new PlayerAdapter(mContext, responseBeanList);
                    mRecyclerView.setAdapter(mPlayerAdapter);
                } else {
                    mRelativeLayoutStats.setVisibility(View.INVISIBLE);
                    statsNotFound.setVisibility(View.VISIBLE);
                    //Toast.makeText(mContext, "Player Stats Data not found", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }

    @Override
    public void onPlayerStatsFailure(String errMsg) {

        hideLoading();
        showSnackBar(errMsg);

    }

    @Override
    public void showSnackBar(String message) {

        hideLoading();
        AppUtils.showSnackBar(this, mRelativeLayout, message);

    }

    @Override
    public Context getContext() {
        return mContext;
    }
}
