package com.mw.eleven11.UI.createCaption;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.createTeam.CreateTeamFragment;
import com.mw.eleven11.UI.createTeam.sorting.CaptainSelectionSorterASC;
import com.mw.eleven11.UI.createTeam.sorting.CaptainSelectionSorterDES;
import com.mw.eleven11.UI.createTeam.sorting.PointSorterASC;
import com.mw.eleven11.UI.createTeam.sorting.PointSorterDES;
import com.mw.eleven11.UI.createTeam.sorting.ViceCaptainSelectionSorterASC;
import com.mw.eleven11.UI.createTeam.sorting.ViceCaptainSelectionSorterDES;
import com.mw.eleven11.UI.joinContest.JoinContestActivity;
import com.mw.eleven11.UI.matchContest.MatchContestActivity;
import com.mw.eleven11.UI.matchControlet.MatchDetailPresenterImpl;
import com.mw.eleven11.UI.matchControlet.MatchInfoView;
import com.mw.eleven11.UI.previewTeam.PlayerPreviewActivity;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.beanInput.CreateTeamInput;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateCaptionFragment extends BaseFragment implements CreateCaptionView, MatchInfoView {



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


    public CreateCaptionAdapter adapter;
    @BindView(R.id.main_frag)
    RelativeLayout relativeLayoutMain;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    String seriesId = "", matchId = "", visitorteamId = "", localteamId = "", teamId = "", contestId = "",
            chip = "", joiningAmount = "", userInviteCode = "", NEED = "", teamName = "";
    @BindView(R.id.ctv_title)
    CustomTextView customTextViewTITLE;
    @BindView(R.id.ctv_description)
    CustomTextView customTextViewDESCRIPTION;
    @BindView(R.id.ctv_next)
    CustomTextView customTextViewNext;
    PlayersOutput.DataBean response;
    String loginSessionKey = "";
    String userId = "";


    @BindView(R.id.teamsVS)
    @Nullable
    CustomTextView teamsVS;
    @BindView(R.id.ctv_full_time)
    @Nullable
    CustomTextView customTextViewFullTime;

    private MatchDetailPresenterImpl matchDetailPresenter;
    private String cashBonusContribution = "";


    private LinearLayoutManager layoutManager;
    private CreateCaptionPresenterImpl presenterImpl;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private OnItemClickListener.OnItemClickCallback onCaptionItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, final int position) {
            adapter.setCaption(position);
            Intent intent = new Intent(CreateTeamFragment.class.getSimpleName());
            intent.putExtra("KEY", "updateCaptain");
            intent.putExtra("VALUE", adapter.getPlayerId(position));
            LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
            setNextButton();
        }
    };
    private OnItemClickListener.OnItemClickCallback onViceCaptionItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            adapter.setViceCaption(position);
            Intent intent = new Intent(CreateTeamFragment.class.getSimpleName());
            intent.putExtra("KEY", "updateViceCaptain");
            intent.putExtra("VALUE", adapter.getPlayerId(position));
            LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
            setNextButton();
        }
    };

    private OnItemClickListener.OnItemClickCallback onItemClickCallBack = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            PlayerPreviewActivity.start(mContext, adapter.getPlayer(position).getPlayerName(),
                    String.valueOf(adapter.getPlayer(position).getPointCredits()), adapter.getPlayer(position).getTotalPoints(),
                    adapter.getPlayer(position).getPlayerBattingStyle(), adapter.getPlayer(position).getPlayerBowlingStyle(),
                    adapter.getPlayer(position).getPlayerCountry(), adapter.getPlayer(position).getPlayerPic(), adapter.getPlayer(position).getSeriesGUID(),
                    adapter.getPlayer(position).getPlayerGUID(),
                    matchId, adapter.getPlayer(position).getPlayerSelectedPercent(), "Pending",
                    adapter.getPlayer(position).getTeamNameShort(), adapter.getPlayer(position).getPlayerRole());
//            PlayerActivity.start(getContext(),adapter.getPlayer(position), 1, matchId);
        }
    };
    private String join;

    public static CreateCaptionFragment getInstance(Bundle bundle) {
        CreateCaptionFragment friendsFragment = new CreateCaptionFragment();
        friendsFragment.setArguments(bundle);
        return friendsFragment;
    }

    @OnClick(R.id.ctv_next)
    public void saveTeam(View view) {

        if (teamId.equals("")) {
            List<CreateTeamInput.UserTeamPlayersBean> userTeamPlayerList = new ArrayList<>();
            for (int i = 0; i < adapter.getPlayers().size(); i++) {
                CreateTeamInput.UserTeamPlayersBean bean = new CreateTeamInput.UserTeamPlayersBean();
                bean.setPlayerGUID(adapter.getPlayers().get(i).getPlayerGUID());
                bean.setPlayerPosition(adapter.getPlayers().get(i).getPosition());

                bean.setPlayerName(adapter.getPlayers().get(i).getPlayerName());
                bean.setPlayerSalary(adapter.getPlayers().get(i).getPlayerSalary());
                bean.setPlayerPic(adapter.getPlayers().get(i).getPlayerPic());
                bean.setPlayerID(adapter.getPlayers().get(i).getPlayerID());
                userTeamPlayerList.add(bean);
                Log.d("Playerpostions", adapter.getPlayers().get(i).getPosition());
            }
            CreateTeamInput mCreateTeamInput = new CreateTeamInput();
            mCreateTeamInput.setMatchGUID(matchId);
            mCreateTeamInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            mCreateTeamInput.setUserTeamType("Normal");
            mCreateTeamInput.setUserTeamPlayers(userTeamPlayerList);
            presenterImpl.actionCreateTeam(mCreateTeamInput);

        } else {
            List<CreateTeamInput.UserTeamPlayersBean> userTeamPlayerList = new ArrayList<>();
            for (int i = 0; i < adapter.getPlayers().size(); i++) {
                CreateTeamInput.UserTeamPlayersBean bean = new CreateTeamInput.UserTeamPlayersBean();
                bean.setPlayerGUID(adapter.getPlayers().get(i).getPlayerGUID());
                bean.setPlayerPosition(adapter.getPlayers().get(i).getPosition());
                bean.setPlayerName(adapter.getPlayers().get(i).getPlayerName());
                bean.setPlayerPic(adapter.getPlayers().get(i).getPlayerPic());
                bean.setPlayerID(adapter.getPlayers().get(i).getPlayerID());
                bean.setPlayerPosition(adapter.getPlayers().get(i).getPosition());
                bean.setPlayerSalary(adapter.getPlayers().get(i).getPlayerSalary());
                userTeamPlayerList.add(bean);
                Log.d("Playerpostions", adapter.getPlayers().get(i).getPosition());
            }
            CreateTeamInput mCreateTeamInput = new CreateTeamInput();
            mCreateTeamInput.setMatchGUID(matchId);
            mCreateTeamInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            mCreateTeamInput.setUserTeamType("Normal");
            mCreateTeamInput.setUserTeamPlayers(userTeamPlayerList);
            mCreateTeamInput.setUserTeamGUID(teamId);
            mCreateTeamInput.setUserTeamName(teamName);

            presenterImpl.actionEditTeam(mCreateTeamInput);
        }

       /* if (!contestId.equals("0")) {
            if (TextUtils.isEmpty(teamId)) {
                switch (AppSession.getInstance().getGameType()) {

                    case 1:
                        presenterImpl.actionCreateTeam(loginSessionKey, userId, matchId, seriesId, adapter.getPlayers());
                        break;

                    case 2:
                        presenterImpl.football_CreateTeam(loginSessionKey, userId, matchId, seriesId, adapter.getPlayers());
                        break;
                    case 3:
                        presenterImpl.kabaddi_CreateTeam(loginSessionKey, userId, matchId, seriesId, adapter.getPlayers());
                        break;
                }


            } else {
                switch (AppSession.getInstance().getGameType()) {
                    case 1:
                        presenterImpl.actionEditTeam(loginSessionKey, userId, matchId, teamId, adapter.getPlayers());

                        break;
                    case 2:
                        presenterImpl.football_editTeam(loginSessionKey, userId, matchId, teamId, adapter.getPlayers());

                        break;
                    case 3:
                        presenterImpl.kabaddi_editTeam(loginSessionKey,
                                userId,
                                matchId, teamId, adapter.getPlayers());

                        break;
                }

            }
        } else {


            response.setResponse(adapter.getPlayers());

            AppSession.getInstance().setTeamSession(response);*/

        //((LetsPlayActivity) getActivity()).showFragment(JoinContestFragment.getInstance(getArguments()));


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
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
            if (getArguments().containsKey("teamId")) {
                teamId = getArguments().getString("teamId");
            }
            if (getArguments().containsKey("data")) {
                response = new Gson().fromJson(getArguments().getString("data"), PlayersOutput.DataBean.class);

                Log.d("dataResponce", AppUtils.gsonToJSON(response.getRecords()));
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
            if (getArguments().containsKey("NEED")) {
                NEED = getArguments().getString("NEED");
            }
            if (getArguments().containsKey("teamName")) {
                teamName = getArguments().getString("teamName");
            }
            if (getArguments().containsKey("cashBonusContribution")) {
                cashBonusContribution = getArguments().getString("cashBonusContribution");
            }

            if (getArguments().containsKey("join")) {
                join = getArguments().getString("join");
            }


        }

    }

    public void onDestroy() {
        super.onDestroy();
        if (presenterImpl != null) presenterImpl.actionListingCancel();
    }

    @Override
    public int getLayout() {
        return R.layout.create_captain_fragment;
    }

    @Override
    public void init() {
        mContext = getActivity();

        if (AppSession.getInstance().getLoginSession() != null) {
            loginSessionKey = AppSession.getInstance().getLoginSession().getData().getSessionKey();
            userId = AppSession.getInstance().getLoginSession().getData().getUserID();
        }

        matchDetailPresenter = new MatchDetailPresenterImpl(this, new UserInteractor());

        //set layout manager into recyclerView
       /* ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        mRecyclerView.addItemDecoration(itemDecoration);*/
        mRecyclerView.setNestedScrollingEnabled(true);
        layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        String text = "Choose CAPTAIN <font color='#DA473D'>(C)</font> & Vice CAPTAIN <font color='#DA473D'>(VC)</font>";
        customTextViewDESCRIPTION.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
        presenterImpl = new CreateCaptionPresenterImpl(this, new UserInteractor());
        if (response != null) {
            adapter = new CreateCaptionAdapter(getActivity(), response.getRecords(), onCaptionItemClickCallback, onViceCaptionItemClickCallback, onItemClickCallBack);
            mRecyclerView.setAdapter(adapter);
        }
        setNextButton();

        callMatchDetail();
    }

    void callMatchDetail() {
        MatchDetailInput mMatchDetailInput = new MatchDetailInput();
        mMatchDetailInput.setPrivacy("No");
        mMatchDetailInput.setMatchGUID(matchId);
        mMatchDetailInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchDetailInput.setStatus(Constant.Pending);
        mMatchDetailInput.setParams(Constant.MATCH_PARAMS);
        matchDetailPresenter.actionMatchdetail(mMatchDetailInput);
    }

    private void setNextButton() {

        Log.i("CaptionAndVoice", "isCaptionAndVoiceCaptionExist:" + adapter.isCaptionAndVoiceCaptionExist());

        if (adapter.isCaptionAndVoiceCaptionExist()) {
            customTextViewNext.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_solid_bg_theme_active));
            customTextViewNext.setEnabled(true);
        } else {
            customTextViewNext.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_solid_bg_theme_inactive));
            customTextViewNext.setEnabled(false);
        }
    }

    @Override
    public void onSaveError(String value) {
        // Toast.makeText(mContext, value, Toast.LENGTH_SHORT).show();

        AppUtils.showToast(mContext, value);
    }

    @Override
    public void onSaveSuccess(LoginResponseOut response) {

        hideLoading();

        if (!contestId.equals("0")) {
            teamId = response.getData().getUserTeamGUID() + "";

            if (!TextUtils.isEmpty(contestId)) {
                JoinContestActivityStart(mContext, matchId, teamId, contestId, joiningAmount, chip, userInviteCode, join);
            } else if (!TextUtils.isEmpty(NEED)) {
                if (NEED.equals("JOIN_CONTEST")) {
                    // CreateContestActivityStart(mContext, seriesId, matchId, teamId, localteamId, visitorteamId);
                }
            }

            Intent intent = new Intent(MatchContestActivity.class.getSimpleName());
            intent.putExtra("KEY", "REFRESH");
            LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);

            // Toast.makeText(mContext, response.getMessage(), Toast.LENGTH_SHORT).show();

            AppUtils.showToast(mContext, response.getMessage());
            getActivity().setResult(Activity.RESULT_OK);
            getActivity().finish();
        } else {

        }
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
    public void onMatchSuccess(MatchDetailOutPut mMatchDetailOutPut) {
        if (isAdded() && getActivity() != null) {


            ViewUtils.setImageUrl(customImageViewTeamFlagLocal, mMatchDetailOutPut.getData().getTeamFlagLocal());
            ViewUtils.setImageUrl(customImageViewTeamFlagVisitor, mMatchDetailOutPut.getData().getTeamFlagVisitor());
            customTextViewTeamNameLocal.setText(mMatchDetailOutPut.getData().getTeamNameShortLocal());
            customTextViewTeamNameVisitor.setText(mMatchDetailOutPut.getData().getTeamNameShortVisitor());
            adapter.localTeamGUID = mMatchDetailOutPut.getData().getTeamNameShortLocal();
            adapter.notifyDataSetChanged();

            teamsVS.setText(mMatchDetailOutPut.getData().getTeamNameShortLocal()
                    + " " + AppUtils.getStrFromRes(R.string.vs)
                    + " " + mMatchDetailOutPut.getData().getTeamNameShortVisitor());
            if (mMatchDetailOutPut.getData().getStatus() != null) {
                if (customTextViewFullTime != null) {
                    switch (mMatchDetailOutPut.getData().getStatus()) {
                        case Constant.Pending:
                            setTime(mMatchDetailOutPut.getData().getMatchStartDateTime(), mMatchDetailOutPut.getData().getMatchDate(),
                                    mMatchDetailOutPut.getData().getMatchTime(), mMatchDetailOutPut.getData().getCurrentDateTime());

                            break;
                        case Constant.Running:
                            customTextViewFullTime.setText(mMatchDetailOutPut.getData().getStatus());
                            customTextViewFullTime.setTextColor(getResources().getColor(R.color.yellow));

                            customTextViewMatchStatus.setText(getString(R.string.Running));
                            customTextViewMatchStatus.setTextColor(getResources().getColor(R.color.green));
                            break;
                        case Constant.Completed:
                            customTextViewFullTime.setText(mMatchDetailOutPut.getData().getStatus());
                            customTextViewFullTime.setTextColor(getResources().getColor(R.color.green));
                            customTextViewMatchStatus.setText(mMatchDetailOutPut.getData().getStatus());
                            customTextViewMatchStatus.setTextColor(getResources().getColor(R.color.green));
                            break;

                        default:
                            customTextViewFullTime.setText(mMatchDetailOutPut.getData().getStatus());
                            customTextViewMatchStatus.setText(mMatchDetailOutPut.getData().getStatus());
                            customTextViewMatchStatus.setTextColor(getResources().getColor(R.color.red));

                            break;
                    }
                }
            }
        }
    }

    CountDownTimer countDownTimer;

    public void setTime(String matchDateTime, final String matchDate, final String matchTime, String currentTime) {
        try {
            if (countDownTimer != null) countDownTimer.cancel();
            if (TimeUtils.isThisDateValid(matchDateTime, "yyyy-MM-dd HH:mm:ss")) {
                long remainingTime = TimeUtils.getTimeDifference(matchDateTime, currentTime);
                countDownTimer = new CountDownTimer(remainingTime, TimeUnit.SECONDS.toMillis(1)) {
                    public void onTick(long millisUntilFinished) {
                        if (customTextViewMatchStatus != null) {
                            customTextViewMatchStatus.setTextColor(mContext.getResources().getColor(R.color.red));
                            customTextViewMatchStatus.setText(TimeUtils.getRemainingMatchTime(millisUntilFinished));
                        }
                    }

                    public void onFinish() {
                        if (customTextViewMatchStatus != null) {
                            customTextViewMatchStatus.setTextColor(mContext.getResources().getColor(R.color.green));
                            customTextViewMatchStatus.setText(getString(R.string.Running));
                        }

                    }
                };
                if (countDownTimer != null) {
                    countDownTimer.start();
                }
            } else {
                customTextViewMatchStatus.setText(TimeUtils.getMatchDateOnly(matchDate));
            }
        } catch (Exception e1) {
            customTextViewMatchStatus.setText(e1.getMessage());
        }

    }
    @Override
    public void onMatchFailure(String errMsg) {

    }

    @Override
    public void onShowSnackBar(@NonNull String message) {
        // Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        AppUtils.showSnackBar(mContext, relativeLayoutMain, message);
    }

    public void JoinContestActivityStart(Context context, String matchId, String teamId, String contestId, String joiningAmount, String chip, String userInviteCode, String join) {
        Intent starter = new Intent(context, JoinContestActivity.class);
        starter.putExtra("contestId", contestId);
        starter.putExtra("teamId", teamId);
        starter.putExtra("matchId", matchId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("chip", chip);
        starter.putExtra("userInviteCode", userInviteCode);
        starter.putExtra("cashBonusContribution", cashBonusContribution);
        starter.putExtra("join", join);
        startActivityForResult(starter, BaseActivity.REQUEST_CODE_JOIN_CONTESTS);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("requestCode", "requestCode: " + BaseActivity.REQUEST_CODE_CREATE_TEAM);
        if (requestCode == BaseActivity.REQUEST_CODE_CREATE_TEAM && resultCode == getActivity().RESULT_OK) {
            getActivity().setResult(Activity.RESULT_OK);
            getActivity().finish();
        } else if (requestCode == BaseActivity.REQUEST_CODE_JOIN_CONTESTS && resultCode == getActivity().RESULT_OK) {
            getActivity().setResult(Activity.RESULT_OK);
            getActivity().finish();
        }
    }
}
