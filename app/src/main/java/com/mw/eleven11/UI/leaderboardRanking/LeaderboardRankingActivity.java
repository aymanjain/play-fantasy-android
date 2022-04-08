package com.mw.eleven11.UI.leaderboardRanking;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.RankingInput;
import com.mw.eleven11.beanInput.SeriesInput;
import com.mw.eleven11.beanOutput.RankingOutput;
import com.mw.eleven11.beanOutput.SeriesOutput;
import com.mw.eleven11.customView.CustomSpinner;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.rey.material.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;


public class LeaderboardRankingActivity extends BaseActivity implements LeaderboardRankingView {

    LeaderboardRankingPresenterImpl mLeaderboardRankingPresenter;
    RecyclerView mRecyclerView;
    RankingItemAdapter mRankingItemAdapter;
    @BindView(R.id.relative_layout)
    RelativeLayout mRelativeLayout;
    @BindView(R.id.spinner_series)
    CustomSpinner mCustomSpinnerMatchSeries;
    @BindString(R.string.leaderboard_ranking)
    String title;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.title)
    CustomTextView mCustomTextViewTitle;
    private ProgressDialog mProgressDialog;

    public static void start(Context context) {
        Intent starter = new Intent(context, LeaderboardRankingActivity.class);
        context.startActivity(starter);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_leaderboard_ranking;
    }

    @Override
    public void init() {

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_back);
        mCustomTextViewTitle.setText(title);

        mLeaderboardRankingPresenter = new LeaderboardRankingPresenterImpl(this, new UserInteractor());

        SeriesInput seriesInput= new SeriesInput();
        seriesInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mLeaderboardRankingPresenter.actionMatchSeries(seriesInput);


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mCustomSpinnerMatchSeries.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(Spinner parent, View view, int position, long id) {

                RankingInput rankingInput= new RankingInput();
                rankingInput.setParams(Constant.RANKING_PARAMS);
                rankingInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
                rankingInput.setSeriesGUID(mCustomSpinnerMatchSeries.getSelectedValue());
                mLeaderboardRankingPresenter.actionRanking(rankingInput);


            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(this);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();
    }

    @Override
    public void showSnackBar(String message) {
        hideLoading();
        AppUtils.showSnackBar(this, mRelativeLayout, message);
    }

    @Override
    public void onMatchSeriesSuccess(SeriesOutput responseMatchSeries) {
        hideLoading();
        ArrayList<HashMap<String, String>> values = new ArrayList<>();

        for (SeriesOutput.DataBean.RecordsBean keyword : responseMatchSeries.getData().getRecords()) {
            HashMap<String, String> item = new HashMap<>();
            item.put("value", keyword.getSeriesGUID() + "");
            item.put("title", keyword.getSeriesName());
            values.add(item);
        }
        mCustomSpinnerMatchSeries.setCustomResource(new ArrayList<HashMap<String, String>>(values));

    }

    @Override
    public void onMatchSeriesFailure(String errMsg) {
        hideLoading();
        showSnackBar(errMsg);
    }

    @Override
    public void onOverAllLeaderboardSuccess(RankingOutput responseOverallLeaderboard) {
        hideLoading();
        if (responseOverallLeaderboard != null) {
            List<RankingOutput.DataBean.RecordsBean> responseBeanList = responseOverallLeaderboard.getData().getRecords();
            if (responseBeanList != null) {
                mRankingItemAdapter = new RankingItemAdapter(this, responseBeanList,
                        mCustomSpinnerMatchSeries.getSelectedTitle(), mCustomSpinnerMatchSeries.getSelectedValue());


                mRecyclerView.setAdapter(mRankingItemAdapter);
            }
            mRankingItemAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onOverAllLeaderboardFailure(String errMsg) {
        hideLoading();
        mRecyclerView.setAdapter(null);
        showSnackBar(errMsg);
    }


}
