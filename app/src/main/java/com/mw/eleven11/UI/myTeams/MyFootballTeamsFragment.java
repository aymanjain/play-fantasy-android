package com.mw.eleven11.UI.myTeams;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.createTeam.CreateTeamActivity;
import com.mw.eleven11.UI.joinContest.JoinContestActivity;
import com.mw.eleven11.UI.matchControlet.MatchDetailPresenterImpl;
import com.mw.eleven11.UI.matchControlet.MatchInfoView;
import com.mw.eleven11.UI.previewTeam.BottomSheetFootballTeamPreviewFragment;
import com.mw.eleven11.UI.previewTeam.PlayerPreviewCallback;
import com.mw.eleven11.UI.previewTeam.PlayerRecord;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanInput.MyTeamInput;
import com.mw.eleven11.beanInput.SwitchTeamInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.MyTeamOutput;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFootballTeamsFragment extends BaseFragment implements MyTeamsView, MatchInfoView {

    @BindView(R.id.customImageViewTeamFlagLocal)
    CustomImageView customImageViewTeamFlagLocal;

    @BindView(R.id.customImageViewTeamFlagVisitor)
    CustomImageView customImageViewTeamFlagVisitor;


    @BindView(R.id.customTextViewTeamNameLocal)
    CustomTextView customTextViewTeamNameLocal;

    @BindView(R.id.customTextViewTeamNameVisitor)
    CustomTextView customTextViewTeamNameVisitor;


    @BindView(R.id.customTextViewMatchStatus)
    CustomTextView customTextViewMatchStatus;


    public MyFootballTeamsAdapter adapter;
    @BindView(R.id.main_frag)
    RelativeLayout relativeLayoutMain;
    CountDownTimer countDownTimer;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    String seriesId = "", matchId = "", visitorteamId = "", SeriesGUID = "", localteamId = "", contestId = "", joiningAmount = "", chip = "", userInviteCode = "", teamName = "", teamId = "";
    boolean SWITCH = false;
    @BindView(R.id.ctv_next)
    CustomTextView ctvNext;
    @BindView(R.id.ll_create_contest)
    LinearLayout llCreateContest;
    @BindView(R.id.ctv_create_contests)
    TextView ctvCreateContests;
    @BindView(R.id.ctv_switch_team)
    TextView ctvSwitchTeam;
    @BindView(R.id.teamsVS)
    CustomTextView teamsVS;
    @BindView(R.id.ctv_full_time)
    CustomTextView ctv_timer;
    @BindView(R.id.ctv_create_team)
    CustomTextView ctvCreateTeam;
    @BindView(R.id.rl_bottom)
    RelativeLayout rl_bottom;

    int gametype;
    String statusId;
    private LinearLayoutManager layoutManager;
    private MyTeamsPresenterImpl presenterImpl;
    private MatchDetailPresenterImpl mMatchDetailPresenterImpl;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    List<MyTeamOutput.DataBean.RecordsBean> teamsRecord = new ArrayList<>();
    private Loader loader;
    private BroadcastReceiver updates_receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent i) {
            try {
                if (i.getAction().equals(MyFootballTeamsFragment.class.getSimpleName())) {
                    if (i.hasExtra("KEY")) {
                        if (i.getStringExtra("KEY").equals("updateCaptain")) {

                        } else if (i.getStringExtra("KEY").equals("updateViceCaptain")) {

                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, final int position) {

            ctvCreateContests.setBackgroundResource(R.drawable.button_solid_bg_theme_active);
            ctvCreateContests.setTextColor(getResources().getColor(R.color.white));
            ctvCreateContests.setEnabled(true);
            ctvCreateContests.setFocusable(true);

            adapter.setSelect(position);
        }
    };
    private OnItemClickListener.OnItemClickCallback onCloneItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

            MyTeamOutput.DataBean.RecordsBean teamRecord = adapter.getCloneData(position);

            CreateTeamActivityStart(mContext, seriesId, matchId, localteamId, visitorteamId,
                    new Gson().toJson(teamRecord),
                    teamName, 1);

            //  CreateTeamActivityStart(mContext, seriesId, matchId, localteamId, visitorteamId, new Gson().toJson(adapter.getCloneData(position)), teamName);
        }
    };
    private OnItemClickListener.OnItemClickCallback onEditItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            CreateTeamActivityStart(mContext, seriesId, matchId, localteamId, visitorteamId,
                    new Gson().toJson(adapter.getItemData(position)),
                    adapter.getTeamName(position), "Edit Team");

            // CreateTeamActivityStart(mContext, seriesId, matchId, localteamId, visitorteamId, new Gson().toJson(adapter.getItemData(position)), adapter.getTeamName(position));
        }
    };
    private OnItemClickListener.OnItemClickCallback onViewItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            List<PlayerRecord> recordList = new ArrayList<>();

            for (int i = 0; i < adapter.getCloneData(position).getUserTeamPlayers().size(); i++) {
                MyTeamOutput.DataBean.RecordsBean.UserTeamPlayersBean teamPlayer = adapter.getCloneData(position).getUserTeamPlayers().get(i);

                PlayerRecord playerRecord = new PlayerRecord();
                playerRecord.setPlayerGUID(teamPlayer.getPlayerGUID());
                playerRecord.setPlayerName(teamPlayer.getPlayerName());
                playerRecord.setPlayerRole(teamPlayer.getPlayerRole());
                playerRecord.setPlayerPic(teamPlayer.getPlayerPic());
                playerRecord.setIsPlaying(teamPlayer.getIsPlaying());
                playerRecord.setTeamGUID(teamPlayer.getTeamGUID());
                playerRecord.setTeamNameShort(teamPlayer.getTeamNameShort());
                playerRecord.setPoints(teamPlayer.getPlayerSalary());
                playerRecord.setPointCredits(teamPlayer.getPlayerSalary());
                playerRecord.setTotalPoints(teamPlayer.getTotalPointCredits());

                playerRecord.setPosition(teamPlayer.getPlayerPosition());
                playerRecord.setPlayerCountry(teamPlayer.getPlayerCountry());
                playerRecord.setPlayerBowlingStyle(teamPlayer.getPlayerBowlingStyle());
                playerRecord.setPlayerBattingStyle(teamPlayer.getPlayerBattingStyle());
                playerRecord.setPlayerSelectedPercent(teamPlayer.getPlayerSelectedPercent());

                playerRecord.setSeriesGUID(SeriesGUID);
                playerRecord.setLocalTeamName(adapter.getCloneData(position).getUserTeamPlayers().get(0).getTeamGUID());
                recordList.add(playerRecord);
            }

            showPreview(recordList, "0", adapter.getTeamName(position), adapter.getCloneData(position).getPlaying11Announce());
        }
    };
    private String join;

    public static MyFootballTeamsFragment getInstance(Bundle bundle) {
        MyFootballTeamsFragment friendsFragment = new MyFootballTeamsFragment();
        friendsFragment.setArguments(bundle);
        return friendsFragment;
    }

    @OnClick(R.id.ctv_next)
    public void next(View view) {
        CreateTeamActivityStart(mContext, seriesId, matchId, localteamId, visitorteamId, "", teamName, "Create Team");

        // CreateTeamActivityStart(mContext, seriesId, matchId, localteamId, visitorteamId, "", teamName);
    }

    @OnClick(R.id.ctv_create_team)
    public void createTeam(View view) {
        CreateTeamActivityStart(mContext, matchId, teamName);

        //CreateTeamActivityStart(mContext, seriesId, matchId, localteamId, visitorteamId, "", teamName);
    }

    @OnClick(R.id.ctv_create_contests)
    public void createContests(View view) {
        JoinContestActivityStart(mContext, matchId, adapter.getSelectTeamId(), contestId, joiningAmount, chip, userInviteCode);
    }

    @OnClick(R.id.ctv_switch_team)
    public void switchTeam(View view) {
        if (SWITCH) {
            callswitchTeam();

        }
    }

    ArrayList<String> listUserTeam = new ArrayList<>();
    ArrayList<String> listOldUserTeam = new ArrayList<>();

    void callswitchTeam() {

        listUserTeam.add(adapter.getSelectTeamId());
        listOldUserTeam.add(teamId);
        Gson gson = new Gson();
        String data = gson.toJson(listUserTeam);
        String old = gson.toJson(listOldUserTeam);

        SwitchTeamInput switchTeamInput = new SwitchTeamInput();
        switchTeamInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        switchTeamInput.setUserTeamGUID(data);
        switchTeamInput.setContestGUID(contestId);
        switchTeamInput.setOldUserTeamGUID(old);

        presenterImpl.actionSwitchBtn(switchTeamInput);
    }

    public void JoinContestActivityStart(Context context, String matchId, String teamId, String contestId, String joiningAmount, String chip, String userInviteCode) {
        Intent starter = new Intent(context, JoinContestActivity.class);
        starter.putExtra("contestId", contestId);
        starter.putExtra("teamId", teamId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("chip", chip);
        starter.putExtra("gametype", gametype);
        starter.putExtra("join", join);
        starter.putExtra("userInviteCode", userInviteCode);
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_JOIN_CONTESTS);
    }

    public void CreateTeamActivityStart(Context context, String seriesId, String matchId,
                                        String localteamId, String visitorteamId, String teamData, String teamName, String title) {
        Intent starter = new Intent(context, CreateTeamActivity.class);
        starter.putExtra("seriesId", seriesId);
        starter.putExtra("MatchGUID", matchId);
        starter.putExtra("localteamId", localteamId);
        starter.putExtra("visitorteamId", visitorteamId);
        starter.putExtra("teamData", teamData);
        starter.putExtra("teamName", teamName);
        starter.putExtra("join", join);
        starter.putExtra("title", title);
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }

    //actionTag
    //2= Edit
    //1= Clone
    public void CreateTeamActivityStart(Context context, String seriesId, String matchId,
                                        String localteamId, String visitorteamId, String teamData, String teamName, int actionTag) {
        Intent starter = new Intent(context, CreateTeamActivity.class);
        starter.putExtra("seriesId", seriesId);
        starter.putExtra("MatchGUID", matchId);
        starter.putExtra("localteamId", localteamId);
        starter.putExtra("visitorteamId", visitorteamId);
        starter.putExtra("teamData", teamData);
        starter.putExtra("join", join);
        starter.putExtra("teamName", teamName);
        starter.putExtra("actionTag", actionTag);
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }

    public void CreateTeamActivityStart(Context context, String matchId, String teamName) {
        Intent starter = new Intent(context, CreateTeamActivity.class);
        starter.putExtra("MatchGUID", matchId);
        starter.putExtra("teamName", teamName);
        starter.putExtra("join", join);
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("requestCode", "requestCode: " + BaseActivity.REQUEST_CODE_CREATE_TEAM);
        if (requestCode == BaseActivity.REQUEST_CODE_CREATE_TEAM && resultCode == getActivity().RESULT_OK) {
            callTask();
        } else if (requestCode == BaseActivity.REQUEST_CODE_JOIN_CONTESTS && resultCode == getActivity().RESULT_OK) {
            getActivity().setResult(Activity.RESULT_OK);
            getActivity().finish();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        SWITCH = false;
        if (getArguments() != null) {
            if (getArguments().containsKey("seriesId")) {
                seriesId = getArguments().getString("seriesId");
            }
            if (getArguments().containsKey("matchId")) {
                matchId = getArguments().getString("matchId");
            }
            if (getArguments().containsKey("visitorteamId")) {
                visitorteamId = getArguments().getString("visitorteamId");
            }
            if (getArguments().containsKey("localteamId")) {
                localteamId = getArguments().getString("localteamId");
            }
            if (getArguments().containsKey("contestId")) {
                contestId = getArguments().getString("contestId");
            }
            if (getArguments().containsKey("joiningAmount")) {
                joiningAmount = getArguments().getString("joiningAmount");
            }
            if (getArguments().containsKey("chip")) {
                chip = getArguments().getString("chip");
            }

            if (getArguments().containsKey("userInviteCode")) {
                userInviteCode = getArguments().getString("userInviteCode");
            }
            if (getArguments().containsKey("teamId")) {
                teamId = getArguments().getString("teamId");
            }

            if (getArguments().containsKey("SWITCH")) {
                SWITCH = getArguments().getBoolean("SWITCH");
            }
            if (getArguments().containsKey("gametype")) {
                gametype = getArguments().getInt("gametype");
            }

            if (getArguments().containsKey("statusId")) {
                statusId = getArguments().getString("statusId");
            }
            if (getArguments().containsKey("join")) {
                join = getArguments().getString("join");
            }

        }
        LocalBroadcastManager.getInstance(mContext).registerReceiver(updates_receiver, new IntentFilter(MyFootballTeamsFragment.class.getSimpleName()));

    }

    public void onDestroy() {
        super.onDestroy();

        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(updates_receiver);

        if (presenterImpl != null) presenterImpl.actionListingCancel();
    }

    @Override
    public int getLayout() {
        return R.layout.my_team_fragment;
    }

    @Override
    public void init() {
        mContext = getActivity();
        loader = new Loader(getCurrentView());

        mMatchDetailPresenterImpl = new MatchDetailPresenterImpl(this, new UserInteractor());

        //set layout manager into recyclerView

        ctvNext.setVisibility(View.VISIBLE);
        ctvCreateTeam.setVisibility(View.VISIBLE);

        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setNestedScrollingEnabled(true);
        layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        ctvSwitchTeam.setVisibility(View.GONE);


        if (loader.getTryAgainView() != null)
            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callTask();
                }
            });


        ctvCreateContests.setBackgroundResource(R.drawable.button_solid_bg_theme_inactive);
        ctvCreateContests.setTextColor(getResources().getColor(R.color.white));
        ctvCreateContests.setEnabled(false);
        ctvCreateContests.setFocusable(false);
        //ctvCreateContests.setBackgroundResource(R.color.secondary_tab_color);
        presenterImpl = new MyTeamsPresenterImpl(this, new UserInteractor());
        adapter = new MyFootballTeamsAdapter(TextUtils.isEmpty(contestId) ? R.layout.list_item_football_teams : R.layout.list_item_select_football_teams,
                getActivity(), teamsRecord, onItemClickCallback, onEditItemClickCallback,
                onViewItemClickCallback, onCloneItemClickCallback);
        mRecyclerView.setAdapter(adapter);
        ctvNext.setText(String.format(AppUtils.getStrFromRes(R.string.create_team_1), "1"));
        teamName = String.format(AppUtils.getStrFromRes(R.string.team_1), "1");
        callTask();
        if (TextUtils.isEmpty(contestId)) llCreateContest.setVisibility(View.GONE);
        if (!TextUtils.isEmpty(contestId) && SWITCH) {
            ctvCreateContests.setVisibility(View.GONE);
            ctvSwitchTeam.setVisibility(View.VISIBLE);
            ctvSwitchTeam.setBackgroundResource(R.drawable.button_solid_bg_theme_inactive);
            ctvSwitchTeam.setEnabled(false);
            ctvSwitchTeam.setFocusable(false);
        }
    }

    void callMatchDetail(String matchId) {

        MatchDetailInput mMatchDetailInput = new MatchDetailInput();
        mMatchDetailInput.setPrivacy("No");
        mMatchDetailInput.setMatchGUID(matchId);
        mMatchDetailInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchDetailInput.setStatus(Constant.Pending);
        mMatchDetailInput.setParams(Constant.MATCH_PARAMS);

        mMatchDetailPresenterImpl.actionMatchdetail(mMatchDetailInput);

    }

    public void callTask() {

        MyTeamInput myTeamInput = new MyTeamInput();

        myTeamInput.setMatchGUID(matchId);
        myTeamInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
        myTeamInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        // myTeamInput.setParams(Constant.USER_TEAM_PARAM);
        myTeamInput.setPageNo(0);
        myTeamInput.setContestGUID(contestId);

        if (contestId.equals("")) {
            myTeamInput.setParams(Constant.USER_TEAM_PARAM);
        } else myTeamInput.setParams(Constant.USER_TEAM_JOINED_PARAM);

        presenterImpl.actionTeamList(myTeamInput);

        //presenterImpl.football_TeamList(AppSession.getInstance().getLoginSession().getResponse().getLoginSessionKey(), AppSession.getInstance().getLoginSession().getResponse().getUserId(), matchId, contestId);
    }

    private void showPreview(final List<PlayerRecord> responseMatchPlayers, final String totalPoints, final String teamNameString, final String playing11Announce) {
        final BottomSheetFootballTeamPreviewFragment dialogFragment = new BottomSheetFootballTeamPreviewFragment();
        dialogFragment.setUpdateable(new PlayerPreviewCallback() {
            @Override
            public void close() {

            }

            @Override
            public void edit() {
                // CreateTeamActivityStart(mContext, seriesId, matchId, localteamId, visitorteamId, new Gson().toJson(bean), bean.getName());
            }

            @Override
            public void refresh() {

            }

            @Override
            public Context getContext() {
                return mContext;
            }

            @Override
            public String isPlaying11Avaible() {
                return playing11Announce;
            }

            @Override
            public String getTeamName() {
                if (TextUtils.isEmpty(teamName))
                    return "Team 1";
                else return teamNameString;
            }

            @Override
            public boolean isTeamPoints() {
                return false;
            }

            @Override
            public String totalPoints() {
                return totalPoints;
            }

            @Override
            public String getMatchID() {
                return matchId;
            }

            @Override
            public String getStatus() {
                return statusId;
            }

            @Override
            public List<PlayerRecord> getPlayers() {
                return responseMatchPlayers;
            }

        });
        dialogFragment.show(getChildFragmentManager(), dialogFragment.getTag());
        dialogFragment.setPointLaval(AppUtils.getStrFromRes(R.string.pts));

    }

    @Override
    public void onLoadingError(String value) {
        loader.error(value);
    }


    @Override
    public void onSwitchError(String value) {
        onShowSnackBar(value);
    }


    @Override
    public void onHideLoading() {
        loader.hide();

    }

    @Override
    public void onLoadingSuccess(MyTeamOutput response) {
        if (isLayoutAdded() && mRecyclerView != null) {
            adapter.clear();
            adapter.addAllItem(response.getData().getRecords());
            adapter.setSelect(teamId);
            ctvNext.setText(String.format(AppUtils.getStrFromRes(R.string.create_team_1), response.getData().getRecords().size() + 1));
            teamName = String.format(AppUtils.getStrFromRes(R.string.team_1), response.getData().getRecords().size() + 1);

            ctvSwitchTeam.setBackgroundResource(R.drawable.button_solid_bg_theme_active);
            ctvSwitchTeam.setEnabled(true);
            ctvSwitchTeam.setFocusable(true);

            if (response.getData().getRecords().size() >= 6) {
                ctvNext.setVisibility(View.GONE);
                ctvCreateTeam.setVisibility(View.GONE);

                rl_bottom.setVisibility(View.GONE);

            } else {
                ctvNext.setVisibility(View.VISIBLE);
                ctvCreateTeam.setVisibility(View.VISIBLE);
                rl_bottom.setVisibility(View.VISIBLE);

            }

            callMatchDetail(matchId);

        }
    }

    @Override
    public void onShowLoading() {
        loader.start();
    }

    @Override
    public void onLoadingNotFound(String value) {
        loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.ic_gallery));
        loader.dataNotFound(value);
    }

    @Override
    public void onSwitchSuccess(LoginResponseOut responseContest) {
        onShowSnackBar(responseContest.getMessage());
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
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
    public void onMatchSuccess(MatchDetailOutPut responseLogin) {
        hideLoading();
        adapter.localTeamGUID = responseLogin.getData().getTeamNameShortLocal();
        adapter.notifyDataSetChanged();
        ViewUtils.setImageUrl(customImageViewTeamFlagLocal, responseLogin.getData().getTeamFlagLocal());
        ViewUtils.setImageUrl(customImageViewTeamFlagVisitor, responseLogin.getData().getTeamFlagVisitor());
        customTextViewTeamNameLocal.setText(responseLogin.getData().getTeamNameShortLocal());
        customTextViewTeamNameVisitor.setText(responseLogin.getData().getTeamNameShortVisitor());


        teamsVS.setText(responseLogin.getData().getTeamNameShortLocal()
                + " " + AppUtils.getStrFromRes(R.string.VS)
                + " " + responseLogin.getData().getTeamNameShortVisitor());

        SeriesGUID = responseLogin.getData().getSeriesGUID();

        setMatchTimer(responseLogin);
    }

    @Override
    public void onShowSnackBar(@NonNull String message) {
        // Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        hideLoading();
        AppUtils.showToast(mContext, message);
    }

    @Override
    public void onMatchFailure(String errMsg) {
        hideLoading();
        AppUtils.showToast(mContext, errMsg);
    }


    void setMatchTimer(MatchDetailOutPut details) {


        customTextViewMatchStatus.setTextColor(mContext.getResources().getColor(R.color.red));
        try {
            if (TimeUtils.isThisDateValid(details.getData().getMatchStartDateTime(), "yyyy-MM-dd HH:mm:ss")) {
                final long diff = TimeUtils.getTimeDifference(details.getData().getMatchStartDateTime(),
                        details.getData().getCurrentDateTime());
                if (TimeUnit.MILLISECONDS.toHours(diff) > Constant.SHOW_TIME_LIMIT_HRS) {
                    customTextViewMatchStatus.setText(TimeUtils.getMatchDateOnly(details.getData().getMatchDate()));
                } else {
                    try {
                        if (countDownTimer != null) {
                            countDownTimer.cancel();
                        }
                        //need to implement counter
                        countDownTimer = new CountDownTimer(diff, TimeUnit.SECONDS.toMillis(1)) {
                            public void onTick(long millisUntilFinished) {
                                if (customTextViewMatchStatus != null) {
                                    customTextViewMatchStatus.setText(TimeUtils.getRemainsTime(millisUntilFinished));
                                } else {
                                    if (countDownTimer != null) {
                                        countDownTimer.cancel();
                                    }
                                }
                            }

                            public void onFinish() {
                                if (customTextViewMatchStatus != null) {
                                    customTextViewMatchStatus.setText(AppUtils.getStrFromRes(R.string.in_progress));

                                }
                            }
                        };
                        if (countDownTimer != null) {
                            countDownTimer.start();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                customTextViewMatchStatus.setText(TimeUtils.getMatchDateOnly(details.getData().getMatchDate()));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            customTextViewMatchStatus.setText(e1.getMessage());
        }
    }
}
