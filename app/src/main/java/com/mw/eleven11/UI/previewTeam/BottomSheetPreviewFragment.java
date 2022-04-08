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
public class BottomSheetPreviewFragment extends BottomSheetDialogFragment {

    private boolean canOpenDetailedScreen = false;
    View root;
    PlayerPreviewCallback callback;
    @BindView(R.id.ctv_team)
    CustomTextView ctvTeam;

    @BindView(R.id.bottamRel)
    RelativeLayout bottamRel;

    @BindView(R.id.totalPoints)
    CustomTextView totalPoints;

    @BindView(R.id.recycler_view_wicket_keeper)
    RecyclerView recyclerViewWK;
    @BindView(R.id.recycler_view_batsmen)
    RecyclerView recyclerViewBAT;
    @BindView(R.id.recycler_view_all_rounders)
    RecyclerView recyclerViewAR;
    @BindView(R.id.recycler_view_bowlers)
    RecyclerView recyclerViewBOW;
    BottomPreviewAdapter WKAdapter, BATAdapter, ARAdapter, BOWAdapter;
    @BindView(R.id.ctv_edit)
    ImageView ctvEdit;
    @BindView(R.id.ctv_refresh)
    ImageView ctvRefresh;
    String team1 = "";
    String pointLaval = "";
    boolean editable = true;
    boolean refresh = false;
    PlayersOutput.DataBean.RecordsBean livePlayerStatusData = new PlayersOutput.DataBean.RecordsBean();

    List<PlayerRecord> responseMatchPlayersWK = new ArrayList<>();
    List<PlayerRecord> responseMatchPlayersBAT = new ArrayList<>();
    List<PlayerRecord> responseMatchPlayersAR = new ArrayList<>();
    List<PlayerRecord> responseMatchPlayersBOWL = new ArrayList<>();
    List<PlayerRecord> response = new ArrayList<>();
    private Unbinder unbinder;
    private BottomSheetBehavior mBehavior;
    private OnItemClickListener.OnItemClickCallback onItemClickCallbackWK = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {


            PlayerPreviewActivity.start(getActivity(), responseMatchPlayersWK.get(position).getPlayerName(),
                    responseMatchPlayersWK.get(position).getPointCredits(), responseMatchPlayersWK.get(position).getTotalPoints(),
                    responseMatchPlayersWK.get(position).getPlayerBattingStyle(), responseMatchPlayersWK.get(position).getPlayerBowlingStyle(),
                    responseMatchPlayersWK.get(position).getPlayerCountry(), responseMatchPlayersWK.get(position).getPlayerPic(),
                    responseMatchPlayersWK.get(position).getSeriesGUID(), responseMatchPlayersWK.get(position).getPlayerGUID(),
                    callback.getMatchID(),responseMatchPlayersWK.get(position).getPlayerSelectedPercent(),callback.getStatus(),
                    responseMatchPlayersWK.get(position).getTeamNameShort(), responseMatchPlayersWK.get(position).getPlayerRole());


            if (callback.isTeamPoints()) {
                setPointsData(responseMatchPlayersWK.get(position));
            } else {
                AppSession.getInstance().playerPoints = null;
            }

        }
    };
    private OnItemClickListener.OnItemClickCallback onItemClickCallbackAR = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

            // if (canOpenDetailedScreen) {
            PlayerPreviewActivity.start(getActivity(), responseMatchPlayersAR.get(position).getPlayerName(),
                    responseMatchPlayersAR.get(position).getPointCredits(), responseMatchPlayersAR.get(position).getTotalPoints(),
                    responseMatchPlayersAR.get(position).getPlayerBattingStyle(), responseMatchPlayersAR.get(position).getPlayerBowlingStyle(),
                    responseMatchPlayersAR.get(position).getPlayerCountry(), responseMatchPlayersAR.get(position).getPlayerPic(),
                    responseMatchPlayersAR.get(position).getSeriesGUID(), responseMatchPlayersAR.get(position).getPlayerGUID(),
                    callback.getMatchID(),responseMatchPlayersAR.get(position).getPlayerSelectedPercent(),callback.getStatus(),
                    responseMatchPlayersAR.get(position).getTeamNameShort(), responseMatchPlayersAR.get(position).getPlayerRole());

            if (callback.isTeamPoints()) {

                setPointsData(responseMatchPlayersAR.get(position));
            } else {
                AppSession.getInstance().playerPoints = null;
            }

            // }
        }
    };
    private OnItemClickListener.OnItemClickCallback onItemClickCallbackBOWL = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

            if (AppSession.getInstance().getLoginSession() != null) {
                //  if (canOpenDetailedScreen) {
                PlayerPreviewActivity.start(getActivity(), responseMatchPlayersBOWL.get(position).getPlayerName(),
                        responseMatchPlayersBOWL.get(position).getPointCredits(), responseMatchPlayersBOWL.get(position).getTotalPoints(),
                        responseMatchPlayersBOWL.get(position).getPlayerBattingStyle(), responseMatchPlayersBOWL.get(position).getPlayerBowlingStyle(),
                        responseMatchPlayersBOWL.get(position).getPlayerCountry(), responseMatchPlayersBOWL.get(position).getPlayerPic(), responseMatchPlayersBOWL.get(position).getSeriesGUID(),
                        responseMatchPlayersBOWL.get(position).getPlayerGUID(),
                        callback.getMatchID(),responseMatchPlayersBOWL.get(position).getPlayerSelectedPercent(),callback.getStatus()
                ,responseMatchPlayersBOWL.get(position).getTeamNameShort(),responseMatchPlayersBOWL.get(position).getPlayerRole());
                if (callback.isTeamPoints()) {

                    setPointsData(responseMatchPlayersBOWL.get(position));
                } else {
                    AppSession.getInstance().playerPoints = null;
                }
                //  }
            }
        }
    };
    private OnItemClickListener.OnItemClickCallback onItemClickCallbackBAT = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            if (AppSession.getInstance().getLoginSession() != null) {
                //  if (canOpenDetailedScreen) {
                PlayerPreviewActivity.start(getActivity(), responseMatchPlayersBAT.get(position).getPlayerName(),
                        responseMatchPlayersBAT.get(position).getPointCredits(), responseMatchPlayersBAT.get(position).getTotalPoints(),
                        responseMatchPlayersBAT.get(position).getPlayerBattingStyle(), responseMatchPlayersBAT.get(position).getPlayerBowlingStyle(),
                        responseMatchPlayersBAT.get(position).getPlayerCountry(), responseMatchPlayersBAT.get(position).getPlayerPic(), responseMatchPlayersBAT.get(position).getSeriesGUID(),
                        responseMatchPlayersBAT.get(position).getPlayerGUID(),
                        callback.getMatchID(),responseMatchPlayersBAT.get(position).getPlayerSelectedPercent(),callback.getStatus(),
                        responseMatchPlayersBAT.get(position).getTeamNameShort(), responseMatchPlayersBAT.get(position).getPlayerRole());

                if (callback.isTeamPoints()) {

                    setPointsData(responseMatchPlayersBAT.get(position));
                } else {
                    AppSession.getInstance().playerPoints = null;
                }
                //  }
            }
        }
    };

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
        if (pointsData.getPointCredits()!= null){
            livePlayerStatusData.setPointCredits(Double.parseDouble(pointsData.getPointCredits()));
        }
        livePlayerStatusData.setMyPlayer(pointsData.getMyPlayer());
        livePlayerStatusData.setTopPlayer(pointsData.getTopPlayer());
        livePlayerStatusData.setPlayerSelectedPercent(pointsData.getPlayerSelectedPercent());
        if (pointsData.getPlayerSalary()!= null) {
            livePlayerStatusData.setPlayerSalary(String.valueOf(pointsData.getPlayerSalary()));
        }        livePlayerStatusData.setPlayerRole(pointsData.getPlayerRole());
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

    private ArrayList<PlayersOutput.DataBean.RecordsBean.PointsDataBean> pointsDataList = new ArrayList<>();

    public void setTeam(String team1) {
        this.team1 = team1;
    }

    @OnClick(R.id.ctv_edit)
    @Optional
    public void edit(View view) {
        if (callback != null) {
            callback.edit();
            dismiss();
        }
    }

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
        mBehavior.setState(BottomSheetBehavior.PEEK_HEIGHT_AUTO);
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
        BottomSheetDialog dialog = new BottomSheetDialog(getActivity(), R.style.BottomSheetDialog);


        root = View.inflate(getContext(), R.layout.players_preview_fragment, null);
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

                // In a previous life I used this method to get handles to the positive and negative buttons
                // of a dialog in order to change their Typeface. Good ol' days.

                BottomSheetDialog d = (BottomSheetDialog) dialog;

                // This is gotten directly from the source of BottomSheetDialog
                // in the wrapInBottomSheet() method
                FrameLayout bottomSheet = (FrameLayout) d.findViewById(android.support.design.R.id.design_bottom_sheet);

                // Right here!
                BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });


        return dialog;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.players_preview_fragment, container);
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
        recyclerViewWK.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset_very_less));
        if (responseMatchPlayersWK.size() > 0) {
            recyclerViewWK.setLayoutManager(new GridLayoutManager(getActivity(), responseMatchPlayersWK.size()));
            initTeam(responseMatchPlayersWK.get(0).getTeamGUID());
        }

        recyclerViewAR.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset_very_less));
        if (responseMatchPlayersAR.size() > 0) {
            recyclerViewAR.setLayoutManager(new GridLayoutManager(getActivity(), responseMatchPlayersAR.size()));
            initTeam(responseMatchPlayersAR.get(0).getTeamGUID());
        }

        recyclerViewBAT.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset_very_less));
        if (responseMatchPlayersBAT.size() > 0) {
            recyclerViewBAT.setLayoutManager(new GridLayoutManager(getActivity(), responseMatchPlayersBAT.size()));
            initTeam(responseMatchPlayersBAT.get(0).getTeamGUID());
        }

        recyclerViewBOW.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset_very_less));
        if (responseMatchPlayersBOWL.size() > 0) {
            recyclerViewBOW.setLayoutManager(new GridLayoutManager(getActivity(), responseMatchPlayersBOWL.size()));
            initTeam(responseMatchPlayersBOWL.get(0).getTeamGUID());
        }


    }

    private void initTeam(String team) {
        if (TextUtils.isEmpty(team1))
            team1 = team;
    }

    public void refreshPlayers() {
        responseMatchPlayersWK.clear();
        responseMatchPlayersBAT.clear();
        responseMatchPlayersAR.clear();
        responseMatchPlayersBOWL.clear();

        if (callback != null && callback.getPlayers() != null) {
            ctvTeam.setText(callback.getTeamName());
            for (int i = 0; i < callback.getPlayers().size(); i++) {
                initPlayers(callback.getPlayers().get(i));
            }
        }
        WKAdapter.notifyDataSetChanged();
        ARAdapter.notifyDataSetChanged();
        BOWAdapter.notifyDataSetChanged();
        BATAdapter.notifyDataSetChanged();
    }

    private void setPlayers() {

        responseMatchPlayersWK.clear();
        responseMatchPlayersBAT.clear();
        responseMatchPlayersAR.clear();
        responseMatchPlayersBOWL.clear();

        if (callback != null) {

            if (callback.totalPoints() != null || !callback.totalPoints().equals("0")) {
                totalPoints.setText(callback.totalPoints());
                bottamRel.setVisibility(View.VISIBLE);
            } else {
                bottamRel.setVisibility(View.GONE);
            }

            if (callback.getPlayers() != null) {
                ctvTeam.setText(callback.getTeamName());
                for (int i = 0; i < callback.getPlayers().size(); i++) {
                    if (callback.getPlayers().get(i) != null)
                        initPlayers(callback.getPlayers().get(i));
                }
            }
        }

        setView();

        WKAdapter = new BottomPreviewAdapter(R.layout.list_item_players_preview, getActivity(),
                responseMatchPlayersWK, onItemClickCallbackWK);
        WKAdapter.setPointLaval(pointLaval);
        WKAdapter.setTeam(team1);
        WKAdapter.setStatus(callback.getStatus());
        WKAdapter.setPlayingStatus(callback.isPlaying11Avaible());
        recyclerViewWK.setAdapter(WKAdapter);

        ARAdapter = new BottomPreviewAdapter(R.layout.list_item_players_preview, getActivity(),
                responseMatchPlayersAR, onItemClickCallbackAR);
        ARAdapter.setPointLaval(pointLaval);
        ARAdapter.setTeam(team1);
        ARAdapter.setStatus(callback.getStatus());
        ARAdapter.setPlayingStatus(callback.isPlaying11Avaible());
        recyclerViewAR.setAdapter(ARAdapter);

        BOWAdapter = new BottomPreviewAdapter(R.layout.list_item_players_preview, getActivity(),
                responseMatchPlayersBOWL, onItemClickCallbackBOWL);
        BOWAdapter.setPointLaval(pointLaval);
        BOWAdapter.setTeam(team1);
        BOWAdapter.setStatus(callback.getStatus());
        BOWAdapter.setPlayingStatus(callback.isPlaying11Avaible());
        recyclerViewBOW.setAdapter(BOWAdapter);

        BATAdapter = new BottomPreviewAdapter(R.layout.list_item_players_preview, getActivity(),
                responseMatchPlayersBAT, onItemClickCallbackBAT);
        BATAdapter.setPointLaval(pointLaval);
        BATAdapter.setTeam(team1);
        BATAdapter.setStatus(callback.getStatus());
        BATAdapter.setPlayingStatus(callback.isPlaying11Avaible());
        recyclerViewBAT.setAdapter(BATAdapter);
    }

    private void initPlayers(PlayerRecord bean) {
        switch (bean.getPlayerRole()) {
            case Constant.ROLE_WICKETKEEPER:
                responseMatchPlayersWK.add(bean);
                break;
            case Constant.ROLE_BATSMAN:
                responseMatchPlayersBAT.add(bean);
                break;
            case Constant.ROLE_ALLROUNDER:
                responseMatchPlayersAR.add(bean);
                break;
            case Constant.ROLE_BOWLER:
                responseMatchPlayersBOWL.add(bean);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
    }

    public void setCanOpenDetailedScreen(boolean canOpenDetailedScreen) {
        this.canOpenDetailedScreen = canOpenDetailedScreen;
    }
}
