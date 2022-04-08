package com.mw.eleven11.UI.contestDetailLeaderBoard.leaderBoard;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.contestDetailLeaderBoard.LeaderBoardMainFragment;
import com.mw.eleven11.UI.previewTeam.BottomSheetFootballTeamPreviewFragment;
import com.mw.eleven11.UI.previewTeam.BottomSheetPreviewFragment;
import com.mw.eleven11.UI.previewTeam.PlayerPreviewCallback;
import com.mw.eleven11.UI.previewTeam.PlayerRecord;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.base.LoaderScroller;
import com.mw.eleven11.beanInput.ContestUserInput;
import com.mw.eleven11.beanInput.MyTeamInput;
import com.mw.eleven11.beanOutput.ContestUserOutput;
import com.mw.eleven11.beanOutput.DreamTeamOutput;
import com.mw.eleven11.beanOutput.ResponsePlayersScore;
import com.mw.eleven11.beanOutput.SingleTeamOutput;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.EndlessRecyclerViewScrollListenerL;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeaderBoardFragment extends BaseFragment implements LeaderBoardView {

    @BindView(R.id.teamsNo)
    @Nullable
    CustomTextView teamsNo;

    public LeaderBoardAdapter adapter;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    /*
        @BindView(R.id.swipeContainer)
        SwipeRefreshLayout swipeRefreshLayout;*/
    String contestGuid = "";
    String matchGuid = "";
    String statusId = "";
    String seriesGUId = "";
    LeaderBoardMainFragment parentFrag;


    @OnClick(R.id.ctv_download)
    void download(View view){
        ((LeaderBoardMainFragment)getParentFragment()).download();
    }

    private List<ContestUserOutput.DataBean.RecordsBean> responseBeen = new ArrayList<>();

    /* BottomSheetPreviewFragment dialogFragment;*/

    private EndlessRecyclerViewScrollListenerL scrollListener;
    private LinearLayoutManager layoutManager;
    private LeaderBoardPresenterImpl presenterImpl;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Loader loader;
    private LoaderScroller loaderScroller;
    private OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            currentData = adapter.getItemData(position);

            switch (statusId) {
                case Constant.Pending:
                    if (AppSession.getInstance().getLoginSession().getData().getUserGUID().equals(adapter.getUserGUID(position))) {
                        //showPreview(adapter.getItemData(position));
                        callApiUserTeam(adapter.getItemData(position).getUserTeamGUID(),adapter.getItemData(position).getUserGUID());

//                        showPreview(getSelectedPlayersRecord(adapter.getItemData(position).getUserTeamPlayers()),
//                                adapter.getItemData(position).getUsername(),
//                                adapter.getItemData(position).getUserTeamName(),
//                                adapter.getItemData(position).getTotalPoints());
                    } else {
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.please_wait_match_not_started_yed));
                    }
                    break;
                case Constant.Running:
                case Constant.Completed:
//                    showPreview(getSelectedPlayersRecord(adapter.getItemData(position).getUserTeamPlayers()),
//                            adapter.getItemData(position).getUsername(),
//                            adapter.getItemData(position).getUserTeamName(),
//                            adapter.getItemData(position).getTotalPoints());
                    callApiUserTeam(adapter.getItemData(position).getUserTeamGUID(), adapter.getItemData(position).getUserGUID());


                    break;

            }

        }
    };
    private ContestUserOutput.DataBean.RecordsBean currentData;
    private String winningType ;

    private void callApiUserTeam(String userTeamGUID, String userGUID) {
        MyTeamInput myTeamInput = new MyTeamInput();

        myTeamInput.setMatchGUID(matchGuid);
        myTeamInput.setUserGUID(userGUID);
        myTeamInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        myTeamInput.setContestGUID(contestGuid);
        myTeamInput.setUserTeamGUID(userTeamGUID);
        myTeamInput.setUserTeamType("Normal");
        myTeamInput.setParams("TeamNameShort,PlayerSelectedPercent,PlayerGUID,PlayerName,PlayerCountry,PlayerPosition,PlayerRole,UserTeamPlayers,UserRank,UserGUID");

        presenterImpl.getUsersTeam(myTeamInput);
    }

    private List<DreamTeamOutput.DataBean.RecordsBean.PointsDataBean> pointsDataList = new ArrayList<>();


    private List<PlayerRecord> getSelectedPlayersRecord(List<SingleTeamOutput.RecordsBean.UserTeamPlayersBean> response) {

        List<PlayerRecord> responseMatchPlayers = new ArrayList<>();
        responseMatchPlayers.clear();
        for (int i = 0; i < response.size(); i++) {


            PlayerRecord player = new PlayerRecord();
            player.setPlayerGUID(response.get(i).getPlayerGUID());
            player.setPlayerName(response.get(i).getPlayerName());
            player.setPlayerRole(response.get(i).getPlayerRole());
            player.setPlayerPic(response.get(i).getPlayerPic());
            player.setTeamNameShort(response.get(i).getTeamNameShort());

            player.setPoints(response.get(i).getPoints());
            player.setPointCredits(response.get(i).getPointCredits());
            player.setTotalPoints(response.get(i).getPointCredits());
            player.setIsPlaying(response.get(i).getIsPlaying());

            player.setPlayerBowlingStyle(response.get(i).getPlayerBowlingStyle());
            player.setPlayerBattingStyle(response.get(i).getPlayerBattingStyle());
            player.setLocalTeamName(response.get(0).getTeamGUID());
            player.setTeamGUID(response.get(i).getTeamGUID());
            player.setSeriesGUID(response.get(i).getSeriesGUID());
            player.setPlayerCountry(response.get(i).getPlayerCountry());
            player.setPosition(response.get(i).getPlayerPosition());
            player.setMyPlayer(response.get(i).getMyPlayer());
            player.setPlayerSelectedPercent(response.get(i).getPlayerSelectedPercent());
            player.setTopPlayer(response.get(i).getTopPlayer());/**/
            List<DreamTeamOutput.DataBean.RecordsBean.PointsDataBean> tem = new ArrayList<>();
            if (response.get(i).getPointsData() != null) {
                for (int j = 0; j < response.get(i).getPointsData().size(); j++) {
                    DreamTeamOutput.DataBean.RecordsBean.PointsDataBean dataBean = new DreamTeamOutput.DataBean.RecordsBean.PointsDataBean();
                    dataBean.setCalculatedPoints(response.get(i).getPointsData().get(j).getCalculatedPoints());
                    dataBean.setDefinedPoints(response.get(i).getPointsData().get(j).getDefinedPoints());
                    dataBean.setPointsTypeGUID(response.get(i).getPointsData().get(j).getPointsTypeGUID());
                    dataBean.setScoreValue(Double.parseDouble(response.get(i).getPointsData().get(j).getScoreValue()));
                    tem.add(dataBean);
                }
            }
            player.setPointsData(tem);
            player.setPlayerSalary(response.get(i).getPlayerSalary());
            responseMatchPlayers.add(player);

        }
        return responseMatchPlayers;
    }

    private OnItemClickListener.OnItemClickCallback onViewItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

        }
    };
    private OnItemClickListener.OnItemClickCallback onLeaderBoardItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

        }
    };

    public static LeaderBoardFragment getInstance(Bundle bundle) {
        LeaderBoardFragment friendsFragment = new LeaderBoardFragment();
        friendsFragment.setArguments(bundle);
        return friendsFragment;
    }

    public void onDestroy() {
        super.onDestroy();
        if (presenterImpl != null) presenterImpl.actionListingCancel();
    }

    @Override
    public int getLayout() {
        return R.layout.liderboard_list_fragment;
    }

    @Override
    public void init() {
        mContext = getActivity();
        if (getArguments() != null) {


            if (getArguments().containsKey("MatchGUID")) {
                matchGuid = getArguments().getString("MatchGUID");
            }
            if (getArguments().containsKey("ContestGUID")) {
                contestGuid = getArguments().getString("ContestGUID");
            }

            if (getArguments().containsKey("StatusID")) {
                statusId = getArguments().getString("StatusID");
            }

            if (getArguments().containsKey("seriesGUId")) {
                seriesGUId = getArguments().getString("seriesGUId");
            }

            if (getArguments().containsKey("winningType")) {
                winningType = getArguments().getString("winningType");
            }
        }
        loader = new Loader(getCurrentView());
        loaderScroller = new LoaderScroller(getCurrentView());
        //set layout manager into recyclerView
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset_1px);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setNestedScrollingEnabled(true);
        layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);

        if (loader.getTryAgainView() != null)
            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scrollListener.resetState();
                    callTask(contestGuid, matchGuid, Constant.LARBOARD_PARAM, Constant.UserRank, 1, Constant.PAGE_LIMIT);
                }
            });
        parentFrag = ((LeaderBoardMainFragment) LeaderBoardFragment.this.getParentFragment());

        scrollListener = new EndlessRecyclerViewScrollListenerL(layoutManager) {
            @Override
            public void onLoadMore(int rPage, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                Log.i("loadNextDataFromApi", "loadNextDataFromApi " + rPage);
                callTask(contestGuid, matchGuid, Constant.LARBOARD_PARAM, Constant.UserRank, rPage, Constant.PAGE_LIMIT);
            }

            @Override
            public void onShowFab(boolean show) {

            }

            @Override
            public void onNewScrolled(RecyclerView view, int dx, int dy) {
                if (parentFrag != null) {
                    parentFrag.setSwipeRefreshLayout(layoutManager.findFirstCompletelyVisibleItemPosition() == 0);
                }
            }
        };

        // Adds the scroll listener to RecyclerView
        mRecyclerView.addOnScrollListener(scrollListener);
        scrollListener.resetState();

        presenterImpl = new LeaderBoardPresenterImpl(this, new UserInteractor());
        //call task first time
        scrollListener.resetState();
        adapter = new LeaderBoardAdapter(R.layout.item_list_leaderboard, getActivity(),
                responseBeen, statusId, onItemClickCallback, onViewItemClickCallback, onLeaderBoardItemClickCallback,winningType);
        mRecyclerView.setAdapter(adapter);

        callTask(contestGuid, matchGuid, Constant.LARBOARD_PARAM, Constant.UserRank, 1, Constant.PAGE_LIMIT);
    }

    public void refresh() {
        if (adapter != null) adapter.clear();
        scrollListener.resetState();
        callTask(contestGuid, matchGuid, Constant.LARBOARD_PARAM, Constant.UserRank, 1, Constant.PAGE_LIMIT);
    }

    public void callTask(String contestGuid, String matchGuid, String params, String orderBy, int pageNo, int pageSize) {

        ContestUserInput mContestUserInput = new ContestUserInput();

        mContestUserInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mContestUserInput.setContestGUID(contestGuid);
        mContestUserInput.setMatchGUID(matchGuid);
        mContestUserInput.setParams(params);
        mContestUserInput.setSequence(Constant.ASC);
        mContestUserInput.setOrderBy(orderBy);
        mContestUserInput.setPageNo(pageNo);
        mContestUserInput.setPageSize(pageSize);

        presenterImpl.joinedUsers(mContestUserInput);
    }


    @Override
    public void onLoadingError(String value) {
        loader.error(value);
    }

    @Override
    public void onLoadingSuccess(ContestUserOutput response) {
        if (isLayoutAdded() && mRecyclerView != null) {
            adapter.addAllItem(response.getData().getRecords());
        }
    }

    @Override
    public void onHideScrollLoading() {
        loaderScroller.hide();
    }

    @Override
    public void onShowScrollLoading() {
        loaderScroller.show();
    }

    @Override
    public void onScrollLoadingError(String value) {
        loaderScroller.error(value);
    }

    @Override
    public void onScrollLoadingSuccess(ContestUserOutput response) {
        adapter.addAllItem(response.getData().getRecords());
    }

    @Override
    public void onScrollLoadingNotFound(String value) {
        loaderScroller.hide();
    }

    @Override
    public void onHideLoading() {
        if (loader != null)
            loader.hide();
    }

    @Override
    public void onShowLoading() {
        if (loader != null)
            loader.start();
    }

    @Override
    public void onLoadingNotFound(String value) {
        loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.not_found_img));
        loader.dataNotFound(value);
    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public boolean isLayoutAdded() {
        return (isAdded() && getActivity() != null);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();
    }

    @Override
    public void onShowSnackBar(@NonNull String message) {
        // Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        AppUtils.showToast(mContext, message);
    }

    @Override
    public void onTeamError(String value) {
        //Toast.makeText(mContext, value, Toast.LENGTH_SHORT).show();
        AppUtils.showToast(mContext, value);
    }

    @Override
    public void onTeamSuccess(SingleTeamOutput responseContest) {


        switch (AppSession.getInstance().getGameType()) {
            case 1:
                showPreview(getSelectedPlayersRecord(responseContest.getData().getUserTeamPlayers()),
                        currentData.getUsername(),
                        responseContest.getData().getUserTeamName(),
                        currentData.getTotalPoints(),responseContest.getData().getPlaying11Announce());
                break;
            case 2:
                showPreviewfoot(getSelectedPlayersRecord(responseContest.getData().getUserTeamPlayers()),
                        currentData.getUsername(),
                        responseContest.getData().getUserTeamName(),
                        currentData.getTotalPoints());
                break;
        }


    }

    private void showPreview(final List<PlayerRecord> bean, final String userName, final String userTeamName, final String totalPoint, final String playing11Announce) {
        final BottomSheetPreviewFragment dialogFragment = new BottomSheetPreviewFragment();
        dialogFragment.setUpdateable(new PlayerPreviewCallback() {
            @Override
            public void close() {

            }

            @Override
            public void edit() {
                /*CreateTeamActivityStart(mContext, bean.getSeriesId(), matchId, localteamId,
                        visitorteamId, new Gson().toJson(bean), bean.getName());*/
            }

            @Override
            public void refresh() {

            }

            @Override
            public String getTeamName() {
                String name = userName + "'s\n " + userTeamName;
                return name;
            }

            @Override
            public boolean isTeamPoints() {
                return true;
            }

            @Override
            public String totalPoints() {
                return totalPoint;
            }

            @Override
            public String getMatchID() {
                return matchGuid;
            }

            @Override
            public String getStatus() {
                return statusId;
            }

            @Override
            public List<PlayerRecord> getPlayers() {
                return bean;
            }

            @Override
            public Context getContext() {
                return mContext;
            }

            @Override
            public String isPlaying11Avaible() {
                return playing11Announce;
            }
        });
        dialogFragment.show(getChildFragmentManager(), dialogFragment.getTag());
        dialogFragment.setPointLaval(AppUtils.getStrFromRes(R.string.pts));

    }


    private void showPreviewfoot(final List<PlayerRecord> responseMatchPlayers, final String userName, final String userTeamName, final String totalPoint) {
        final BottomSheetFootballTeamPreviewFragment dialogFragment = new BottomSheetFootballTeamPreviewFragment();
        dialogFragment.setUpdateable(new PlayerPreviewCallback() {
            @Override
            public void close() {

            }

            @Override
            public void edit() {

            }

            @Override
            public void refresh() {

            }


            @Override
            public String getTeamName() {
                String name  = userName +"'s\n "+ userTeamName;
                return name;
            }

            @Override
            public boolean isTeamPoints() {
                return true;
            }

            @Override
            public String totalPoints() {
                return totalPoint;
            }

            @Override
            public String getMatchID() {
                return matchGuid;
            }

            @Override
            public String getStatus() {
                return statusId;
            }

            @Override
            public List<PlayerRecord> getPlayers() {
                return responseMatchPlayers;
            }

            @Override
            public Context getContext() {
                return mContext;
            }

            @Override
            public String isPlaying11Avaible() {
                return "No";
            }
        });
        dialogFragment.show(getChildFragmentManager(), dialogFragment.getTag());
        dialogFragment.setPointLaval(AppUtils.getStrFromRes(R.string.pts));
    }



    @Override
    public void onScoreError(String value) {
        AppUtils.showToast(mContext, value);
    }

    @Override
    public void onScoreSuccess(ResponsePlayersScore responseContest) {
       /* bean = responseContest.getResponse();

        switch (AppSession.getInstance().getGameType()) {
            case 1:
                showPreview();
                break;
            case 2:
                showPreviewFootbal();
                break;
            case 3:
                showPreviewKabaddi();
                break;
        }*/

    }

   /* private void showPreview() {
        try {
            if (dialogFragment != null && dialogFragment.isAdded()) {
                dialogFragment.refreshPlayers();
                return;
            }

            dialogFragment = new BottomSheetPreviewFragment();
            dialogFragment.setUpdateable(new PlayerPreviewCallback() {
                @Override
                public void close() {

                }

                @Override
                public void edit() {

                }

                @Override
                public void refresh() {
                    if (presenterImpl != null)

                        callPlayersScore(bean.getTeamId());

                }

                @Override
                public String getTeamName() {
                    return bean.getName();
                }

                @Override
                public String getMatchID() {
                    return matchId;
                }

                @Override
                public List<ResponseMatchPlayers.ResponseBean> getPlayers() {
                    return bean.getPlayers();
                }

                @Override
                public Context getContext() {
                    return mContext;
                }
            });
            dialogFragment.show(getChildFragmentManager(), dialogFragment.getTag());
            dialogFragment.setEdit(false);
            dialogFragment.setPointLaval("Pts");

            switch (status) {
                case "FIXTURE":
                    break;
                case "LIVE":
                    if (dialogFragment != null)
                        dialogFragment.setRefresh(true);
                    break;
                case "COMPLETED":

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void showPreviewFootbal() {
        try {
            if (footballDialogFragment != null && footballDialogFragment.isAdded()) {
                footballDialogFragment.refreshPlayers();
                return;
            }

            footballDialogFragment = new BottomSheetFootballTeamPreviewFragment();
            footballDialogFragment.setUpdateable(new PlayerPreviewCallback() {
                @Override
                public void close() {

                }

                @Override
                public void edit() {

                }

                @Override
                public void refresh() {
                    if (presenterImpl != null)

                        callPlayersScore(bean.getTeamId());

                }

                @Override
                public String getTeamName() {
                    return bean.getName();
                }

                @Override
                public String getMatchID() {
                    return matchId;
                }

                @Override
                public List<ResponseMatchPlayers.ResponseBean> getPlayers() {
                    return bean.getPlayers();
                }

                @Override
                public Context getContext() {
                    return mContext;
                }
            });
            footballDialogFragment.show(getChildFragmentManager(), footballDialogFragment.getTag());
            footballDialogFragment.setEdit(false);
            footballDialogFragment.setPointLaval("Pts");

            switch (status) {
                case "FIXTURE":
                    break;
                case "LIVE":
                    if (footballDialogFragment != null)
                        footballDialogFragment.setRefresh(true);
                    break;
                case "COMPLETED":

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void showPreviewKabaddi() {
        try {
            if (kabaddiDialogFragment != null && kabaddiDialogFragment.isAdded()) {
                kabaddiDialogFragment.refreshPlayers();
                return;
            }

            kabaddiDialogFragment = new BottomSheetKabaddiTeamPreviewFragment();
            kabaddiDialogFragment.setUpdateable(new PlayerPreviewCallback() {
                @Override
                public void close() {

                }

                @Override
                public void edit() {

                }

                @Override
                public void refresh() {
                    if (presenterImpl != null)

                        callPlayersScore(bean.getTeamId());

                }

                @Override
                public String getTeamName() {
                    return bean.getName();
                }

                @Override
                public String getMatchID() {
                    return matchId;
                }

                @Override
                public List<ResponseMatchPlayers.ResponseBean> getPlayers() {
                    return bean.getPlayers();
                }

                @Override
                public Context getContext() {
                    return mContext;
                }
            });
            kabaddiDialogFragment.show(getChildFragmentManager(), kabaddiDialogFragment.getTag());
            kabaddiDialogFragment.setEdit(false);
            kabaddiDialogFragment.setPointLaval("Pts");

            switch (status) {
                case "FIXTURE":
                    break;
                case "LIVE":
                    if (kabaddiDialogFragment != null)
                        kabaddiDialogFragment.setRefresh(true);
                    break;
                case "COMPLETED":

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
}
