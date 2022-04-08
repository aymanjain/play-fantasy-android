package com.mw.eleven11.UI.contestDetailLeaderBoard.stats;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.createTeam.CreateTeamPresenterImpl;
import com.mw.eleven11.UI.createTeam.CreateTeamView;
import com.mw.eleven11.UI.playerPoints.PlayerPointsAdapter;
import com.mw.eleven11.UI.previewTeam.PlayerPreviewActivity;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
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

import butterknife.BindView;
import butterknife.OnClick;


public class StatsFragment extends BaseFragment implements CreateTeamView {

    Context mContext;
    private Loader loader;
    private CreateTeamPresenterImpl presenterImpl;
    public List<PlayersOutput.DataBean.RecordsBean> responseBeanList;
    PlayerPointsAdapter mPlayerPointsAdapter;


    PlayersOutput.DataBean.RecordsBean livePlayerStatusData = new PlayersOutput.DataBean.RecordsBean();
    String matchId,statusId;



    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.points)
    CustomTextView mPoints;

    @BindView(R.id.playerText)
    CustomTextView playerText;

    @BindView(R.id.selected_by)
    CustomTextView mSelectedBy;


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

        }
    };






    public static StatsFragment newInstance(String matchId, String statusId) {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        args.putString("matchId", matchId);
        args.putString("statusId", statusId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            matchId = getArguments().getString("matchId");
            statusId = getArguments().getString("statusId");
        }
    }



    @Override
    public int getLayout() {
        return R.layout.fragment_stats;
    }

    @Override
    public void init() {
        mContext = getActivity();
        loader = new Loader(getCurrentView());
        presenterImpl = new CreateTeamPresenterImpl(this, new UserInteractor());

        mRecyclerView.setLayoutManager( new LinearLayoutManager(mContext));

        responseBeanList = new ArrayList<>();
        mPlayerPointsAdapter = new PlayerPointsAdapter(this, responseBeanList, onItemClickCallback);
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
    public void showLoading() {
        loader.start();
    }

    @Override
    public void hideLoading() {
        loader.hide();
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
        return (isAdded() && getActivity() != null);
    }
}