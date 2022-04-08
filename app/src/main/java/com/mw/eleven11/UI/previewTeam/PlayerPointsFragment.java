package com.mw.eleven11.UI.previewTeam;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.playerPoints.PlayerSheetAdapter;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.beanInput.GetDraftPlayerPointInput;
import com.mw.eleven11.beanOutput.GetDraftPlayerPointOutput;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;

import java.util.ArrayList;

import butterknife.BindView;


public class PlayerPointsFragment extends BaseFragment {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;


    @BindView(R.id.stats_not_found)
    CustomTextView stats_not_found;


    PlayerSheetAdapter mPlayerSheetAdapter;
    private PlayersOutput.DataBean.RecordsBean livePlayerStatusData;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private GetDraftPlayerPointOutput mGetDraftPlayerPointOutput;
    private AlertDialog mAlertDialog;
    private ArrayList<GetDraftPlayerPointOutput.DataBean.RecordsBean.PointsDataBean> pointDataList = new ArrayList<>();
    private ArrayList<GetDraftPlayerPointOutput.DataBean.RecordsBean.PointsDataBean> pointsData;
    private String matchID, playerGUID, seriesID;


    public static PlayerPointsFragment newInstance(String seriesId, String playerID, String matchID) {
        PlayerPointsFragment fragment = new PlayerPointsFragment();
        Bundle args = new Bundle();
        args.putString("seriesId", seriesId);
        args.putString("playerID", playerID);
        args.putString("matchID", matchID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_player_points;
    }

    @Override
    public void init() {
        mContext = getActivity();
        mProgressDialog = new ProgressDialog(mContext);
        matchID = getArguments().getString("matchID");
        seriesID = getArguments().getString("seriesId");
        playerGUID = getArguments().getString("playerID");
        apiCallingGetDraftPlayerPoints();
    }


    private void apiCallingGetDraftPlayerPoints() {
        if (NetworkUtils.isConnected(mContext)) {
            mProgressDialog.show();
            GetDraftPlayerPointInput getDraftPlayerPointInput = new GetDraftPlayerPointInput();
            getDraftPlayerPointInput.setPlayerGUID(playerGUID);
            getDraftPlayerPointInput.setMatchGUID(matchID);
            getDraftPlayerPointInput.setSeriesID(seriesID);
            getDraftPlayerPointInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            getDraftPlayerPointInput.setParams("TeamFlagLocal,TeamFlagVisitor,MatchLocation,PlayerBattingStyle,PlayerBowlingStyle,PlayerID,PlayerRole,PlayerPic,PlayerCountry,MatchType,MatchNo,MatchDateTime,SeriesName,TeamGUID,PointsData,TotalPoints");
            new UserInteractor().getDraftPlayersPoint(getDraftPlayerPointInput, new IUserInteractor.OnGetDraftPlayersPointListener() {
                @Override
                public void onSuccess(GetDraftPlayerPointOutput getDraftPlayerPointOutput) {
                    mGetDraftPlayerPointOutput = getDraftPlayerPointOutput;
                    mProgressDialog.dismiss();

                    for (GetDraftPlayerPointOutput.DataBean.RecordsBean recordsBean : mGetDraftPlayerPointOutput.getData().getRecords()) {
                        pointDataList.addAll(recordsBean.getPointsData());
                    }

                    if (pointDataList.size() > 0) {
                        mRecyclerView.setVisibility(View.VISIBLE);
                        stats_not_found.setVisibility(View.GONE);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
                        mRecyclerView.setAdapter(new AllPointRecyclerAdapter(mContext, mGetDraftPlayerPointOutput, pointsData));
//                        double res = 0;
//                        for (GetDraftPlayerPointOutput.DataBean.RecordsBean.PointsDataBean pointsDataBean : pointDataList) {
//                            res += Double.parseDouble(pointsDataBean.getCalculatedPoints().trim());
//                        }
//                         mContext.setPlayerPoint(res + "");
                    } else {
//                         mContext).setPlayerPoint("0");
                        mRecyclerView.setVisibility(View.GONE);
                        stats_not_found.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    mProgressDialog.dismiss();
                    mAlertDialog = new AlertDialog(mContext,
                            errorMsg,
                            AppUtils.getStrFromRes(R.string.try_again),
                            AppUtils.getStrFromRes(R.string.cancel), new AlertDialog.OnBtnClickListener() {
                        @Override
                        public void onYesClick() {
                            mAlertDialog.hide();
                            apiCallingGetDraftPlayerPoints();
                        }

                        @Override
                        public void onNoClick() {
                            mAlertDialog.hide();
                        }
                    });
                    mAlertDialog.show();
                }
            });
        } else {
            mProgressDialog.dismiss();
            mAlertDialog = new AlertDialog(mContext, AppUtils.getStrFromRes(R.string.network_error),
                    AppUtils.getStrFromRes(R.string.try_again),
                    AppUtils.getStrFromRes(R.string.cancel), new AlertDialog.OnBtnClickListener() {
                @Override
                public void onYesClick() {
                    mAlertDialog.hide();
                    apiCallingGetDraftPlayerPoints();
                }

                @Override
                public void onNoClick() {
                    mAlertDialog.hide();

                }
            });
            mAlertDialog.show();
        }
    }
}