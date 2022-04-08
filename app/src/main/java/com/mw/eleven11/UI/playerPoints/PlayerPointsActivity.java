package com.mw.eleven11.UI.playerPoints;

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
import com.mw.eleven11.UI.createTeam.CreateTeamPresenterImpl;
import com.mw.eleven11.UI.createTeam.CreateTeamView;
import com.mw.eleven11.UI.previewTeam.PlayerPreviewActivity;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.PlayersInput;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;


public class PlayerPointsActivity extends BaseActivity implements CreateTeamView {

    int sortedBy = 2; //1 mean selected by and 2 mean points
    int order = 1;  //o mean ascending 1 mean descending order

    RecyclerView mRecyclerView;
    Context mContext;
    ProgressDialog mProgressDialog;
    //PlayerPointsPresenterImpl mPlayerPointsPresenter;
    PlayerPointsAdapter mPlayerPointsAdapter;

    String selected_by = "";
    List<PlayersOutput.DataBean.RecordsBean> responseBeanList;
    PlayersOutput.DataBean.RecordsBean livePlayerStatusData = new PlayersOutput.DataBean.RecordsBean();
    List<PlayersOutput.DataBean.RecordsBean> shortedResponce;
    //  ResponseLivePlayerStatus mLivePlayerStatus;
    PlayersOutput.DataBean.RecordsBean mPlayerPointsBreakup;
    @BindString(R.string.player_points)
    String title;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.relative_layout)
    RelativeLayout mRelativeLayout;

    @BindView(R.id.playerText)
    CustomTextView playerText;

    @BindView(R.id.points)
    CustomTextView mPoints;

    @BindView(R.id.selected_by)
    CustomTextView mSelectedBy;

    String seriesId, matchId;
    String teamId = "";
    private Loader loader;
    private CreateTeamPresenterImpl presenterImpl;
    private OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            livePlayerStatusData = responseBeanList.get(position);

            PlayerPreviewActivity.start(mContext, responseBeanList.get(position).getPlayerName(),
                    String.valueOf(responseBeanList.get(position).getPointCredits()), responseBeanList.get(position).getTotalPoints(),
                    responseBeanList.get(position).getPlayerBattingStyle(), responseBeanList.get(position).getPlayerBowlingStyle(),
                    responseBeanList.get(position).getPlayerCountry(), responseBeanList.get(position).getPlayerPic(), responseBeanList.get(position).getSeriesGUID(),
                    responseBeanList.get(position).getPlayerGUID(),
                    matchId, responseBeanList.get(position).getPlayerSelectedPercent(), statusId,
                    responseBeanList.get(position).getTeamNameShort(), responseBeanList.get(position).getPlayerRole());


            AppSession.getInstance().playerPoints = livePlayerStatusData;


//            if (livePlayerStatusData.getPointsData().size() != 0) {
//                Bundle b = new Bundle();
//                b.putSerializable("livePlayerStatusData", livePlayerStatusData);
//                b.putSerializable("playerData", mPlayerPointsBreakup);
//                BottomSheetPointsFragment dialogFragment = new BottomSheetPointsFragment();
//
//                dialogFragment.setUpdateable(new PlayerPointCallback() {
//                    @Override
//                    public void close() {
//
//                    }
//
//                    @Override
//                    public PlayersOutput.DataBean.RecordsBean getPlayer() {
//                        return livePlayerStatusData;
//                    }
//
//                    @Override
//                    public Context getContext() {
//                        return null;
//                    }
//                });
//
//                dialogFragment.setArguments(b);
//
//                dialogFragment.show(getSupportFragmentManager(), dialogFragment.getTag());
//            }

        }
    };
    private String statusId;

    public static void start(Context context, String seriesId, String matchId, String teamId, String statusId) {
        Intent starter = new Intent(context, PlayerPointsActivity.class);
        starter.putExtra("seriesId", seriesId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("teamId", teamId);
        starter.putExtra("statusId", statusId);

        context.startActivity(starter);
    }


    @OnClick(R.id.back)
    void onBackClick() {
        finish();
    }

    @OnClick(R.id.selected_by)
    void onSelectedBy() {

        playerText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        mPoints.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

        if (mSelectedBy.isSelected()) {
            mPlayerPointsAdapter.shotBySelectedpercentage(true);
            mSelectedBy.setSelected(false);

            mSelectedBy.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_up, 0);

        } else {

            mPlayerPointsAdapter.shotBySelectedpercentage(false);
            mSelectedBy.setSelected(true);
            mSelectedBy.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_down, 0);
        }
    }

    @OnClick(R.id.points)
    void onPoints() {

        playerText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        mSelectedBy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

        if (mPoints.isSelected()) {
            mPlayerPointsAdapter.shotByPoint(true);
            mPoints.setSelected(false);
            mPoints.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_up, 0);

        } else {
            mPlayerPointsAdapter.shotByPoint(false);
            mPoints.setSelected(true);
            mPoints.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_down, 0);
        }

    }

    @OnClick(R.id.playerText)
    void onPlayerSelected() {
        mPoints.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        mSelectedBy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

        if (playerText.isSelected()) {
            mPlayerPointsAdapter.shotByName(true);
            playerText.setSelected(false);

            playerText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_up, 0);

        } else {
            mPlayerPointsAdapter.shotByName(false);
            playerText.setSelected(true);

            playerText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_down, 0);
        }

    }

    @Override
    public int getLayout() {
        return R.layout.activity_player_points;
    }

    @Override
    public void init() {


        mPlayerPointsBreakup = new PlayersOutput.DataBean.RecordsBean();

        loader = new Loader(this);

        mContext = this;

        presenterImpl = new CreateTeamPresenterImpl(this, new UserInteractor());

        if (getIntent().hasExtra("matchId")) {

            matchId = getIntent().getStringExtra("matchId");
            seriesId = getIntent().getStringExtra("seriesId");
            statusId = getIntent().getStringExtra("statusId");
        }
        if (getIntent().hasExtra("teamId")) {
            teamId = getIntent().getStringExtra("teamId");
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        responseBeanList = new ArrayList<>();
        mPlayerPointsAdapter = new PlayerPointsAdapter(mContext, responseBeanList, onItemClickCallback);
        mRecyclerView.setAdapter(mPlayerPointsAdapter);

        callTask();

    }


    public void callTask() {


        PlayersInput mPlayersInput = new PlayersInput();
        mPlayersInput.setMatchGUID(matchId);
        mPlayersInput.setIsPlaying("Yes");
        mPlayersInput.setIsActive("Yes");
        mPlayersInput.setParams(Constant.PLAYER_STATE_PARAMS);
        mPlayersInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mPlayersInput.setCustomOrderBy("PointCredits");
        mPlayersInput.setSequence("DESC");
        presenterImpl.actionMatchPlayers(mPlayersInput);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
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
    public void onShowLoading() {
        loader.start();
    }

    @Override
    public void onHideLoading() {
        loader.hide();
    }

    @Override
    public void onLoadingSuccess(PlayersOutput responseMatches) {


        if (responseMatches != null) {
            responseBeanList = responseMatches.getData().getRecords();

            mPlayerPointsAdapter.addAllItem(responseBeanList);

            mPlayerPointsAdapter.shotByPoint(true);
            mPoints.setSelected(false);

        }

    }

    @Override
    public void onLoadingError(String value) {
        loader.error(value);
    }

    @Override
    public void onLoadingNotFound(String value) {
        loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.ic_gallery));
        loader.dataNotFound(value);
    }

    @Override
    public void onShowSnackBar(String message) {
        AppUtils.showToast(mContext, message);
    }

    @Override
    public boolean isLayoutAdded() {
        return true;
    }

    @Override
    public Context getContext() {
        return mContext;
    }


}
