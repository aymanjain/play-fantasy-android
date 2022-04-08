package com.mw.eleven11.UI.previewTeam;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;


/**
 * Created by Obaro on 01/08/2016.
 */
public class BottomSheetFootballTeamPreviewFragment extends BottomSheetDialogFragment {

    View root;
    PlayerPreviewCallback callback;
    @BindView(R.id.ctv_team)
    CustomTextView ctvTeam;
    @BindView(R.id.recycler_view_goal_keeper)
    RecyclerView recyclerViewGK;
    @BindView(R.id.recycler_view_defenders)
    RecyclerView recycler_view_defenders;
    @BindView(R.id.recycler_view_all_rounders)
    RecyclerView recyclerViewAR;
    @BindView(R.id.recycler_view_bowlers)
    RecyclerView recyclerViewBOW;
    BottomPreviewAdapter GKAdapter, DEFAdapter, STAdapter, MIDAdapter;
    @BindView(R.id.ctv_edit)
    ImageView ctvEdit;
    @BindView(R.id.ctv_refresh)
    ImageView ctvRefresh;
    String pointLaval = "";
    boolean editable = true;
    boolean refresh = false;
    List<PlayerRecord> responseMatchPlayersGK = new ArrayList<>();
    List<PlayerRecord> responseMatchPlayersDEF = new ArrayList<>();
    List<PlayerRecord> responseMatchPlayersST = new ArrayList<>();
    List<PlayerRecord> responseMatchPlayersMID = new ArrayList<>();
    private Unbinder unbinder;
    private BottomSheetBehavior mBehavior;
    PlayersOutput.DataBean.RecordsBean livePlayerStatusData = new PlayersOutput.DataBean.RecordsBean();
    private ArrayList<PlayersOutput.DataBean.RecordsBean.PointsDataBean> pointsDataList = new ArrayList<>();
    private OnItemClickListener.OnItemClickCallback onItemClickCallbackWK = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {


            PlayerPreviewActivity.start(getActivity(), responseMatchPlayersGK.get(position).getPlayerName(),
                    responseMatchPlayersGK.get(position).getPointCredits(), responseMatchPlayersGK.get(position).getTotalPoints(),
                    responseMatchPlayersGK.get(position).getPlayerBattingStyle(), responseMatchPlayersGK.get(position).getPlayerBowlingStyle(),
                    responseMatchPlayersGK.get(position).getPlayerCountry(), responseMatchPlayersGK.get(position).getPlayerPic(),
                    responseMatchPlayersGK.get(position).getSeriesGUID(), responseMatchPlayersGK.get(position).getPlayerGUID(),
                    callback.getMatchID(), responseMatchPlayersGK.get(position).getPlayerSelectedPercent(), callback.getStatus(),
                    responseMatchPlayersGK.get(position).getTeamNameShort(), responseMatchPlayersGK.get(position).getPlayerRole());


            if (callback.isTeamPoints()) {
                setPointsData(responseMatchPlayersGK.get(position));
            } else {
                AppSession.getInstance().playerPoints = null;
            }

            //  PlayerActivity.start(callback.getContext(), GKAdapter.getPlayer(position), 2, callback.getMatchID());
        }
    };
    private OnItemClickListener.OnItemClickCallback onItemClickCallbackAR = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

            PlayerPreviewActivity.start(getActivity(), responseMatchPlayersMID.get(position).getPlayerName(),
                    responseMatchPlayersMID.get(position).getPointCredits(), responseMatchPlayersMID.get(position).getTotalPoints(),
                    responseMatchPlayersMID.get(position).getPlayerBattingStyle(), responseMatchPlayersMID.get(position).getPlayerBowlingStyle(),
                    responseMatchPlayersMID.get(position).getPlayerCountry(), responseMatchPlayersMID.get(position).getPlayerPic(),
                    responseMatchPlayersMID.get(position).getSeriesGUID(), responseMatchPlayersMID.get(position).getPlayerGUID(),
                    callback.getMatchID(), responseMatchPlayersMID.get(position).getPlayerSelectedPercent(), callback.getStatus(),
                    responseMatchPlayersMID.get(position).getTeamNameShort(), responseMatchPlayersMID.get(position).getPlayerRole());

            if (callback.isTeamPoints()) {

                setPointsData(responseMatchPlayersMID.get(position));
            } else {
                AppSession.getInstance().playerPoints = null;
            }

            //PlayerActivity.start(callback.getContext(), STAdapter.getPlayer(position), 2, callback.getMatchID());
        }
    };
    private OnItemClickListener.OnItemClickCallback onItemClickCallbackBOWL = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

            PlayerPreviewActivity.start(getActivity(), responseMatchPlayersST.get(position).getPlayerName(),
                    responseMatchPlayersST.get(position).getPointCredits(), responseMatchPlayersST.get(position).getTotalPoints(),
                    responseMatchPlayersST.get(position).getPlayerBattingStyle(), responseMatchPlayersST.get(position).getPlayerBowlingStyle(),
                    responseMatchPlayersST.get(position).getPlayerCountry(), responseMatchPlayersST.get(position).getPlayerPic(), responseMatchPlayersST.get(position).getSeriesGUID(),
                    responseMatchPlayersST.get(position).getPlayerGUID(),
                    callback.getMatchID(), responseMatchPlayersST.get(position).getPlayerSelectedPercent(), callback.getStatus(),
                    responseMatchPlayersST.get(position).getTeamNameShort(), responseMatchPlayersST.get(position).getPlayerRole());
            if (callback.isTeamPoints()) {

                setPointsData(responseMatchPlayersST.get(position));
            } else {
                AppSession.getInstance().playerPoints = null;
            }

            // PlayerActivity.start(callback.getContext(), MIDAdapter.getPlayer(position), 2, callback.getMatchID());
        }
    };
    private OnItemClickListener.OnItemClickCallback onItemClickCallbackBAT = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

            PlayerPreviewActivity.start(getActivity(), responseMatchPlayersDEF.get(position).getPlayerName(),
                    responseMatchPlayersDEF.get(position).getPointCredits(), responseMatchPlayersDEF.get(position).getTotalPoints(),
                    responseMatchPlayersDEF.get(position).getPlayerBattingStyle(), responseMatchPlayersDEF.get(position).getPlayerBowlingStyle(),
                    responseMatchPlayersDEF.get(position).getPlayerCountry(), responseMatchPlayersDEF.get(position).getPlayerPic(), responseMatchPlayersDEF.get(position).getSeriesGUID(),
                    responseMatchPlayersDEF.get(position).getPlayerGUID(),
                    callback.getMatchID(), responseMatchPlayersDEF.get(position).getPlayerSelectedPercent(), callback.getStatus(),
                    responseMatchPlayersDEF.get(position).getTeamNameShort(), responseMatchPlayersDEF.get(position).getPlayerRole());

            if (callback.isTeamPoints()) {

                setPointsData(responseMatchPlayersDEF.get(position));
            } else {
                AppSession.getInstance().playerPoints = null;
            }

            // PlayerActivity.start(callback.getContext(), DEFAdapter.getPlayer(position), 2, callback.getMatchID());
        }
    };
    private String team1 = "";

    @OnClick(R.id.ctv_edit)
    @Optional
    public void edit(View view) {
        if (callback != null) {
            callback.edit();
            dismiss();
        }
    }


    @BindView(R.id.bottamRel)
    RelativeLayout bottamRel;

    @BindView(R.id.totalPoints)
    CustomTextView totalPoints;

    @OnClick(R.id.ctv_refresh)
    @Optional
    public void refresh(View view) {
        if (callback != null) {
            callback.refresh();
        }
    }

    public void setEdit(boolean value) {
        editable = value;
    }

    public void setRefresh(boolean value) {
        refresh = value;
    }

    public void setPointLaval(String value) {
        pointLaval = value;
    }

    @OnClick(R.id.ctv_cross)
    @Optional
    public void cross(View view) {
        if (callback != null) {
            callback.close();
            dismiss();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @OnClick(R.id.ctv_reset)
    @Optional
    public void reset(View view) {
        AppSession.getInstance().clearFilterSession();
        setPlayers();
    }

    @OnClick(R.id.ctv_close)
    @Optional
    public void clear(View view) {
        dismiss();
    }

    public void setUpdateable(PlayerPreviewCallback updateable) {
        this.callback = updateable;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        BottomSheetDialog dialog = new BottomSheetDialog(callback.getContext(), R.style.BottomSheetDialog);
        root = View.inflate(getContext(), R.layout.football_players_preview_fragment, null);
        unbinder = ButterKnife.bind(this, root);
        dialog.setContentView(root);

        mBehavior = BottomSheetBehavior.from((View) root.getParent());
        mBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                BottomSheetDialog d = (BottomSheetDialog) dialog;
                FrameLayout bottomSheet = (FrameLayout) d.findViewById(android.support.design.R.id.design_bottom_sheet);
                BottomSheetBehavior.from(bottomSheet)
                        .setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.football_players_preview_fragment, container);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mBehavior.setPeekHeight(450);

        if (editable) {
            ctvEdit.setVisibility(View.GONE);
        } else {
            ctvEdit.setVisibility(View.GONE);
        }
        if (refresh) {
            ctvRefresh.setVisibility(View.VISIBLE);
        } else {
            ctvRefresh.setVisibility(View.GONE);
        }
        setPlayers();
    }

    private void setView() {
        //set layout manager into recyclerView
        recyclerViewGK.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset_very_less));
        if (responseMatchPlayersGK.size() > 0) {
            recyclerViewGK.setLayoutManager(new GridLayoutManager(getActivity(), responseMatchPlayersGK.size()));
            initTeam(responseMatchPlayersGK.get(0).getTeamGUID());
        }


        recyclerViewAR.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset_very_less));
        if (responseMatchPlayersST.size() > 0) {
            recyclerViewAR.setLayoutManager(new GridLayoutManager(getActivity(), responseMatchPlayersST.size()));
            initTeam(responseMatchPlayersST.get(0).getTeamGUID());
        }

        recycler_view_defenders.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset_very_less));
        if (responseMatchPlayersDEF.size() > 0) {
            recycler_view_defenders.setLayoutManager(new GridLayoutManager(getActivity(), responseMatchPlayersDEF.size()));
            initTeam(responseMatchPlayersDEF.get(0).getTeamGUID());
        }
        recyclerViewBOW.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset_very_less));
        if (responseMatchPlayersMID.size() > 0) {
            recyclerViewBOW.setLayoutManager(new GridLayoutManager(getActivity(), responseMatchPlayersMID.size()));
            initTeam(responseMatchPlayersDEF.get(0).getTeamGUID());
        }
    }


    private void initTeam(String team) {
        if (TextUtils.isEmpty(team1))
            team1 = team;
    }

    public void refreshPlayers() {
        responseMatchPlayersGK.clear();
        responseMatchPlayersDEF.clear();
        responseMatchPlayersST.clear();
        responseMatchPlayersMID.clear();

        if (callback.getPlayers() != null) {
            ctvTeam.setText(callback.getTeamName());
            for (int i = 0; i < callback.getPlayers().size(); i++) {
                initPlayers(callback.getPlayers().get(i));
            }
        }
        GKAdapter.notifyDataSetChanged();
        STAdapter.notifyDataSetChanged();
        MIDAdapter.notifyDataSetChanged();
        DEFAdapter.notifyDataSetChanged();
    }

    private void setPlayers() {
        responseMatchPlayersGK.clear();
        responseMatchPlayersDEF.clear();
        responseMatchPlayersST.clear();
        responseMatchPlayersMID.clear();

        if (callback.getPlayers() != null) {

            if (callback.totalPoints() != null || !callback.totalPoints().equalsIgnoreCase("0")) {
                totalPoints.setText(callback.totalPoints());
                bottamRel.setVisibility(View.VISIBLE);
            } else {
                bottamRel.setVisibility(View.GONE);
            }

            ctvTeam.setText(callback.getTeamName());
            for (int i = 0; i < callback.getPlayers().size(); i++) {
                initPlayers(callback.getPlayers().get(i));
            }
        }

        setView();

        GKAdapter = new BottomPreviewAdapter(R.layout.list_item_players_preview, callback.getContext(), responseMatchPlayersGK, onItemClickCallbackWK);
        GKAdapter.setPointLaval(pointLaval);
        GKAdapter.setTeam(team1);
        GKAdapter.setStatus(callback.getStatus());
        GKAdapter.setPlayingStatus(callback.isPlaying11Avaible());

        recyclerViewGK.setAdapter(GKAdapter);

        STAdapter = new BottomPreviewAdapter(R.layout.list_item_players_preview, callback.getContext(), responseMatchPlayersST, onItemClickCallbackBOWL);
        STAdapter.setPointLaval(pointLaval);
        STAdapter.setTeam(team1);
        STAdapter.setStatus(callback.getStatus());
        STAdapter.setPlayingStatus(callback.isPlaying11Avaible());

        recyclerViewAR.setAdapter(STAdapter);

        MIDAdapter = new BottomPreviewAdapter(R.layout.list_item_players_preview, callback.getContext(), responseMatchPlayersMID, onItemClickCallbackAR);
        MIDAdapter.setPointLaval(pointLaval);
        MIDAdapter.setTeam(team1);
        MIDAdapter.setStatus(callback.getStatus());
        MIDAdapter.setPlayingStatus(callback.isPlaying11Avaible());

        recyclerViewBOW.setAdapter(MIDAdapter);

        DEFAdapter = new BottomPreviewAdapter(R.layout.list_item_players_preview, callback.getContext(), responseMatchPlayersDEF, onItemClickCallbackBAT);
        DEFAdapter.setPointLaval(pointLaval);
        DEFAdapter.setTeam(team1);
        DEFAdapter.setStatus(callback.getStatus());
        DEFAdapter.setPlayingStatus(callback.isPlaying11Avaible());

        recycler_view_defenders.setAdapter(DEFAdapter);
    }

    private void initPlayers(PlayerRecord bean) {
        switch (bean.getPlayerRole()) {
            case Constant.ROLE_GOALKEEPER:
                responseMatchPlayersGK.add(bean);
                break;
            case Constant.ROLE_DEFENDER:
                responseMatchPlayersDEF.add(bean);
                break;
            case Constant.ROLE_FORWARD:
                responseMatchPlayersST.add(bean);
                break;
            case Constant.ROLE_MIDFIELDER:
                responseMatchPlayersMID.add(bean);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
    }

    private void setPointsData(PlayerRecord pointsData) {
        livePlayerStatusData.setIsCaptain(pointsData.getIsCaptain());
        livePlayerStatusData.setIsPlaying(pointsData.getIsPlaying());
        livePlayerStatusData.setIsViceCaptain(pointsData.getIsViceCaptain());

        livePlayerStatusData.setPlayerBattingStats(pointsData.getPlayerBattingStats());
        livePlayerStatusData.setPlayerBattingStyle(pointsData.getPlayerBattingStyle());
        livePlayerStatusData.setPlayerBowlingStats(pointsData.getPlayerBowlingStats());
        livePlayerStatusData.setPlayerBattingStyle(pointsData.getPlayerBowlingStyle());
        livePlayerStatusData.setPlayerCountry(pointsData.getPlayerCountry());
        livePlayerStatusData.setPlayerGUID(pointsData.getPlayerGUID());
        livePlayerStatusData.setTotalPoints(pointsData.getTotalPoints());
        livePlayerStatusData.setViewType(pointsData.getViewType());
        livePlayerStatusData.setTeamNameShort(pointsData.getTeamNameShort());
        livePlayerStatusData.setTeamGUID(pointsData.getTeamGUID());
        livePlayerStatusData.setTotalPointCredits(pointsData.getTotalPointCredits());
        livePlayerStatusData.setSeriesGUID(pointsData.getSeriesGUID());
        livePlayerStatusData.setMyPlayer("No");
        livePlayerStatusData.setTopPlayer("No");
        livePlayerStatusData.setPosition(pointsData.getPosition());
//        livePlayerStatusData.setPlayerSelectedPercent();
        livePlayerStatusData.setTotalPoints(pointsData.getTotalPoints());
        livePlayerStatusData.setPointCredits(Double.parseDouble(pointsData.getPointCredits()));
        livePlayerStatusData.setMyPlayer(pointsData.getMyPlayer());
        livePlayerStatusData.setTopPlayer(pointsData.getTopPlayer());
        livePlayerStatusData.setPlayerSelectedPercent(pointsData.getPlayerSelectedPercent());
        livePlayerStatusData.setPlayerSalary(String.valueOf(pointsData.getPlayerSalary()));
        livePlayerStatusData.setPlayerRole(pointsData.getPlayerRole());
        livePlayerStatusData.setPlayerPic(pointsData.getPlayerPic());
        livePlayerStatusData.setPlayerName(pointsData.getPlayerName());
        pointsDataList.clear();

        for (int i = 0; i < pointsData.getPointsData().size(); i++) {
            PlayersOutput.DataBean.RecordsBean.PointsDataBean dataBean = new PlayersOutput.DataBean.RecordsBean.PointsDataBean();
            dataBean.setCalculatedPoints(pointsData.getPointsData().get(i).getCalculatedPoints());
            dataBean.setDefinedPoints(pointsData.getPointsData().get(i).getDefinedPoints());
            dataBean.setPointsTypeGUID(pointsData.getPointsData().get(i).getPointsTypeGUID());
            dataBean.setScoreValue(pointsData.getPointsData().get(i).getScoreValue());
            pointsDataList.add(dataBean);
        }
        livePlayerStatusData.setPointsData(pointsDataList);


        AppSession.getInstance().playerPoints = livePlayerStatusData;
    }

}
