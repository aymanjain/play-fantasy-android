package com.mw.eleven11.UI.createTeam;


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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.mw.eleven11.AppController;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.createCaption.CreateCaptionActivity;
import com.mw.eleven11.UI.matchControlet.MatchDetailPresenterImpl;
import com.mw.eleven11.UI.matchControlet.MatchInfoView;
import com.mw.eleven11.UI.previewTeam.BottomSheetPreviewFragment;
import com.mw.eleven11.UI.previewTeam.PlayerPreviewActivity;
import com.mw.eleven11.UI.previewTeam.PlayerPreviewCallback;
import com.mw.eleven11.UI.previewTeam.PlayerRecord;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanInput.PlayersInput;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.MyTeamOutput;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
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
public class
CreateTeamFragment extends BaseFragment implements CreateTeamView, MatchInfoView {

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

    private MatchDetailOutPut matchDetailOutPut;


    @BindView(R.id.customTextViewWK)
    CustomTextView customTextViewWK;

    @BindView(R.id.customTextViewBAT)
    CustomTextView customTextViewBAT;


    @BindView(R.id.customTextViewAR)
    CustomTextView customTextViewAR;


    @BindView(R.id.customTextViewBOWL)
    CustomTextView customTextViewBOWL;

    @BindView(R.id.indicatorWK)
    View indicatorWK;

    @BindView(R.id.indicatorBAT)
    View indicatorBAT;

    @BindView(R.id.indicatorAR)
    View indicatorAR;

    @BindView(R.id.indicatorBOWL)
    View indicatorBOWL;


    public CreateTeamAdapter adapter;
    public TeamPlayerAdapter adapterteam;
    @BindView(R.id.main_frag)
    RelativeLayout relativeLayoutMain;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    String seriesId = "", MatchGUID = "", SeriesGUID = "", visitorteamId = "", teamName = "", localteamId = "", teamId = "", contestId = "", chip = "", joiningAmount = "", userInviteCode = "", NEED = "";

    int actionTag = 0;

    int playingFlag = 0;

    String localTeamName = "";

    @BindView(R.id.recycler_view_player)
    RecyclerView mRecyclerViewPlayer;
    @BindView(R.id.civ_wk)
    CustomImageView customImageViewWK;
    @BindView(R.id.civ_bat)
    CustomImageView customImageViewBAT;
    @BindView(R.id.civ_ar)
    CustomImageView customImageViewAR;
    @BindView(R.id.civ_bowl)
    CustomImageView customImageViewBOWL;


    @BindView(R.id.ctv_title)
    CustomTextView customTextViewTITLE;
    @BindView(R.id.ctv_credit_left)
    CustomTextView customTextViewCreditLeft;
    @BindView(R.id.ctv_players)
    CustomTextView customTextViewPlayers;
    @BindView(R.id.ctv_next)
    CustomTextView customTextViewNext;


    @BindView(R.id.playerText)
    CustomTextView playerText;
    @BindView(R.id.pointsText)
    CustomTextView pointsText;
    @BindView(R.id.creditsText)
    CustomTextView creditsText;

    @BindView(R.id.teamsVS)
    @Nullable
    CustomTextView teamsVS;

    @BindView(R.id.ctv_full_time)
    @Nullable
    CustomTextView customTextViewFullTime;

    @BindView(R.id.WK)
    @Nullable
    CustomTextView WK;

    @BindView(R.id.BAT)
    @Nullable
    CustomTextView BAT;

    @BindView(R.id.AR)
    @Nullable
    CustomTextView AR;

    @BindView(R.id.BOWL)
    @Nullable
    CustomTextView BOWL;


    @BindView(R.id.ic_wk)
    ImageView ic_wk;

    @BindView(R.id.ic_bat)
    ImageView ic_bat;

    @BindView(R.id.ic_allrounder)
    ImageView ic_allrounder;

    @BindView(R.id.ic_bowl)
    ImageView ic_bowl;
    private String isPlaying = "no";
    private String visitorTeamName;
    private String join;


    private void prSortPlayer() {
        switch (orderBy) {
            case R.id.playerText:
                if (order.equals("D")) {
                    adapter.shotByName(true);
                } else {
                    adapter.shotByName(false);
                }
                break;
            case R.id.pointsText:
                if (order.equals("D")) {
                    adapter.shotByPoint(true);
                } else {
                    adapter.shotByPoint(false);
                }
                break;
            case R.id.creditsText:
                if (order.equals("D")) {
                    adapter.shotByCredit(true);
                } else {
                    adapter.shotByCredit(false);
                }
                break;
        }
    }

    @OnClick(R.id.playerText)
    void onInfoPlayerClick(View view) {


        playerText.setTextColor(getResources().getColor(R.color.white));
        pointsText.setTextColor(getResources().getColor(R.color.white));
        creditsText.setTextColor(getResources().getColor(R.color.white));

        pointsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        creditsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

        if (orderBy == view.getId()) {
            if (order.equals("A")) {
                order = "D";
            } else {
                order = "A";
            }
        } else {
            orderBy = view.getId();
            order = "D";
        }

        if (order.equals("D")) {
            adapter.shotByName(true);
            playerText.setSelected(false);
            playerText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_up, 0);
        } else {
            adapter.shotByName(false);
            playerText.setSelected(true);

            playerText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_down, 0);
        }

        /*if (playerText.isSelected()) {
            adapter.shotByName(true);
            playerText.setSelected(false);
            playerText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_up, 0);

        } else {
            adapter.shotByName(false);
            playerText.setSelected(true);

            playerText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_down, 0);
        }*/

    }

    @OnClick(R.id.pointsText)
    void onPointClick(View view) {

        playerText.setTextColor(getResources().getColor(R.color.white));
        pointsText.setTextColor(getResources().getColor(R.color.white));
        creditsText.setTextColor(getResources().getColor(R.color.white));

        playerText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        creditsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);


        if (orderBy == view.getId()) {
            if (order.equals("A")) {
                order = "D";
            } else {
                order = "A";
            }
        } else {
            orderBy = view.getId();
            order = "D";
        }

        if (order.equals("D")) {
            adapter.shotByPoint(true);
            pointsText.setSelected(false);
            pointsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_up, 0);
        } else {
            adapter.shotByPoint(false);
            pointsText.setSelected(true);
            pointsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_down, 0);
        }


       /* if (pointsText.isSelected()) {
            adapter.shotByPoint(true);
            pointsText.setSelected(false);
            pointsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_up, 0);

        } else {
            adapter.shotByPoint(false);
            pointsText.setSelected(true);
            pointsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_down, 0);
        }*/


    }

    @OnClick(R.id.creditsText)
    void onCreaditClick(View view) {

        playerText.setTextColor(getResources().getColor(R.color.white));
        pointsText.setTextColor(getResources().getColor(R.color.white));
        creditsText.setTextColor(getResources().getColor(R.color.white));

        playerText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        pointsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);


        if (orderBy == view.getId()) {
            if (order.equals("A")) {
                order = "D";
            } else {
                order = "A";
            }
        } else {
            orderBy = view.getId();
            order = "D";
        }

        if (order.equals("D")) {
            adapter.shotByCredit(true);
            creditsText.setSelected(false);
            creditsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_up, 0);
        } else {
            adapter.shotByCredit(false);
            creditsText.setSelected(true);
            creditsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_down, 0);
        }

      /*  if (creditsText.isSelected()) {
            adapter.shotByCredit(true);
            creditsText.setSelected(false);
            creditsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_up, 0);

        } else {
            adapter.shotByCredit(false);
            creditsText.setSelected(true);
            creditsText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_down, 0);
        }*/

    }

    boolean ROLE_AR, ROLE_BAT, ROLE_BOW, ROLE_WICK;

    int gametype;
    MyTeamOutput.DataBean.RecordsBean team = null;
    String teamType1 = "", teamType2 = "", team1 = "", team2 = "";
    List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayersWK = new ArrayList<>();
    List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayersBAT = new ArrayList<>();
    List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayersAR = new ArrayList<>();
    List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayersBOWL = new ArrayList<>();
    String SELECTED_ROLE = Constant.ROLE_WICKETKEEPER;
    private LinearLayoutManager layoutManager;
    private CreateTeamPresenterImpl presenterImpl;
    private MatchDetailPresenterImpl matchDetailPresenter;
    private Context mContext;
    //private ProgressDialog mProgressDialog;
    private Loader loader;
    private String tournamentCode = "";

    private String cashBonusContribution = "";
    private String order = "D";
    private int orderBy = R.id.creditsText;


    private BroadcastReceiver updates_receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent i) {
            try {
                if (i.getAction().equals(CreateTeamFragment.class.getSimpleName())) {
                    if (i.hasExtra("KEY")) {
                        if (i.getStringExtra("KEY").equals("updateCaptain")) {
                            setCaption(i.getStringExtra("VALUE"));
                        } else if (i.getStringExtra("KEY").equals("updateViceCaptain")) {
                            setViceCaption(i.getStringExtra("VALUE"));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private boolean animationView = false;
    private OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, final int position) {

            float pointCreadit = getTotalPlayersCredit();

            Log.d("pointCreadit", Float.parseFloat(adapter.getPoints(position)) + "");
            if (animationView) return;

          /*  if (!adapter.isSelected(position)) {
                if (getTotalSelectedPlayers() == 11) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.max_11_players_allowed));
                    return;
                } else if (getSelectedTeamMemberCount(adapter.getTeamId(position)) == 7) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.max_7_players_from_1_team));
                    return;

                } else if ((100 - getTotalPlayersCredit()) < Float.parseFloat(adapter.getPoints(position))) {
                    itemWarningAnimation(view);
                    onShowSnackBar(String.format(AppUtils.getStrFromRes(R.string.only_credit_left), 100 - getTotalPlayersCredit() + ""));
                    return;
                } else if (!canSelectMorePlayers(adapter.getPlayRole(position))) {

                    if (!adapter.getPlayRole(position).equals(Constant.ROLE_WICKETKEEPER) && getIndividualCount(Constant.ROLE_WICKETKEEPER) < 1) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_one_wicket_keeper));
                        return;
                    } else if (!adapter.getPlayRole(position).equals(Constant.ROLE_BATSMAN) && getIndividualCount(Constant.ROLE_BATSMAN) < 3) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_3_batsmen));
                        return;
                    } else if (!adapter.getPlayRole(position).equals(Constant.ROLE_ALLROUNDER) && getIndividualCount(Constant.ROLE_ALLROUNDER) < 0) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_one_all_rounders));
                        return;
                    } else if (!adapter.getPlayRole(position).equals(Constant.ROLE_BOWLER) && getIndividualCount(Constant.ROLE_BOWLER) < 3) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_3_bowlers));
                        return;
                    }
                } else if ((11 - getTotalSelectedPlayers()) <= (1 - getIndividualCount(Constant.ROLE_WICKETKEEPER))
                        && !adapter.getPlayRole(position).equals(Constant.ROLE_WICKETKEEPER)) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_one_wicket_keeper));
                    return;
                } else if ((11 - getTotalSelectedPlayers()) <= (1 - getIndividualCount(Constant.ROLE_ALLROUNDER))
                        && !adapter.getPlayRole(position).equals(Constant.ROLE_ALLROUNDER)) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_one_all_rounders));
                    return;
                } else if ((11 - getTotalSelectedPlayers()) <= (3 - getIndividualCount(Constant.ROLE_BATSMAN))
                        && !adapter.getPlayRole(position).equals(Constant.ROLE_BATSMAN)) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_3_batsmen));
                    return;
                } else if ((11 - getTotalSelectedPlayers()) <= (3 - getIndividualCount(Constant.ROLE_BOWLER))
                        && !adapter.getPlayRole(position).equals(Constant.ROLE_BOWLER)) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_3_bowlers));
                    return;
                }
            }


            switch (adapter.getPlayRole(position)) {
                case Constant.ROLE_WICKETKEEPER:
                    if (!adapter.isSelected(position) && adapter.getSelectedCount() >= 1) {

                       // adapter.setItemDisable(true);

                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.only_one_wicket_keeper_allowed));


                    } else {
                        //adapter.setItemDisable(false);
                        itemSelectedAnimation(view, position);

                    }
                    break;
                case Constant.ROLE_BATSMAN:
                    if (!adapter.isSelected(position) && adapter.getSelectedCount() >= 5) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.max_5_batsmen_allowed));
                    } else {
                        itemSelectedAnimation(view, position);
                    }
                    break;
                case Constant.ROLE_ALLROUNDER:
                    if (!adapter.isSelected(position) && adapter.getSelectedCount() >= 3) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.max_3_all_rounders_allowed));
                    } else {
                        itemSelectedAnimation(view, position);
                    }
                    break;
                case Constant.ROLE_BOWLER:
                    if (!adapter.isSelected(position) && adapter.getSelectedCount() >= 5) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.max_5_bowlers_allowed));
                    } else {
                        itemSelectedAnimation(view, position);
                    }
                    break;
            }
            Log.d("getTotalSelectedPlayers", "onItemClicked: "+getTotalSelectedPlayers());*/
            if (!adapter.isSelected(position)) {
                if (getTotalSelectedPlayers() == 11) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.max_11_players_allowed));
                    return;
                } else if (getSelectedTeamMemberCount(adapter.getTeamId(position)) == 7) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.max_7_players_from_1_team));
                    return;
                } else if (100 - getTotalPlayersCredit() < Float.parseFloat(adapter.getPoints(position))) {
                    itemWarningAnimation(view);
                    onShowSnackBar(String.format(AppUtils.getStrFromRes(R.string.only_credit_left), 100 - getTotalPlayersCredit() + ""));
                    return;
                } else if (!canSelectMorePlayers(adapter.getPlayRole(position))) {

                    if (!adapter.getPlayRole(position).equals(Constant.ROLE_WICKETKEEPER) && getIndividualCount(Constant.ROLE_WICKETKEEPER) < 1) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_one_wicket_keeper));
                        return;
                    } else if (!adapter.getPlayRole(position).equals(Constant.ROLE_BATSMAN) && getIndividualCount(Constant.ROLE_BATSMAN) < 3) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_3_batsmen));
                        return;
                    } else if (!adapter.getPlayRole(position).equals(Constant.ROLE_ALLROUNDER) && getIndividualCount(Constant.ROLE_ALLROUNDER) < 1) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_one_all_rounders));
                        return;
                    } else if (!adapter.getPlayRole(position).equals(Constant.ROLE_BOWLER) && getIndividualCount(Constant.ROLE_BOWLER) < 3) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_3_bowlers));
                        return;
                    }
                } else if ((11 - getTotalSelectedPlayers()) <= (1 - getIndividualCount(Constant.ROLE_WICKETKEEPER))
                        && !adapter.getPlayRole(position).equals(Constant.ROLE_WICKETKEEPER)) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_one_wicket_keeper));
                    return;
                } else if ((11 - getTotalSelectedPlayers()) <= (1 - getIndividualCount(Constant.ROLE_ALLROUNDER))
                        && !adapter.getPlayRole(position).equals(Constant.ROLE_ALLROUNDER)) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_one_all_rounders));
                    return;
                } else if ((11 - getTotalSelectedPlayers()) <= (3 - getIndividualCount(Constant.ROLE_BATSMAN))
                        && !adapter.getPlayRole(position).equals(Constant.ROLE_BATSMAN)) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_3_batsmen));
                    return;
                } else if ((11 - getTotalSelectedPlayers()) <= (3 - getIndividualCount(Constant.ROLE_BOWLER))
                        && !adapter.getPlayRole(position).equals(Constant.ROLE_BOWLER)) {
                    itemWarningAnimation(view);
                    onShowSnackBar(AppUtils.getStrFromRes(R.string.every_team_needs_atleast_3_bowlers));
                    return;
                }
            }


            switch (adapter.getPlayRole(position)) {
                case Constant.ROLE_WICKETKEEPER:
                    if (!adapter.isSelected(position) && adapter.getSelectedCount() >= 4) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.only_one_wicket_keeper_allowed));
                    } else {
                        itemSelectedAnimation(view, position);
                    }
                    break;
                case Constant.ROLE_BATSMAN:
                    if (!adapter.isSelected(position) && adapter.getSelectedCount() >= 6) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.max_5_batsmen_allowed));
                    } else {
                        itemSelectedAnimation(view, position);
                    }
                    break;
                case Constant.ROLE_ALLROUNDER:
                    if (!adapter.isSelected(position) && adapter.getSelectedCount() >= 4) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.max_3_all_rounders_allowed));
                    } else {
                        itemSelectedAnimation(view, position);
                    }
                    break;
                case Constant.ROLE_BOWLER:
                    if (!adapter.isSelected(position) && adapter.getSelectedCount() >= 6) {
                        itemWarningAnimation(view);
                        onShowSnackBar(AppUtils.getStrFromRes(R.string.max_5_bowlers_allowed));
                    } else {
                        itemSelectedAnimation(view, position);
                    }
                    break;
            }
        }
    };
    private OnItemClickListener.OnItemClickCallback onViewItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
//            PlayerActivity.start(mContext, adapter.getPlayer(position), gametype, MatchGUID);

            PlayerPreviewActivity.start(mContext, adapter.getPlayer(position).getPlayerName(),
                    String.valueOf(adapter.getPlayer(position).getPointCredits()), adapter.getPlayer(position).getTotalPoints(),
                    adapter.getPlayer(position).getPlayerBattingStyle(), adapter.getPlayer(position).getPlayerBowlingStyle(),
                    adapter.getPlayer(position).getPlayerCountry(), adapter.getPlayer(position).getPlayerPic(), adapter.getPlayer(position).getSeriesGUID(),
                    adapter.getPlayer(position).getPlayerGUID(),
                    MatchGUID, adapter.getPlayer(position).getPlayerSelectedPercent(), "Pending",
                    adapter.getPlayer(position).getTeamNameShort(), adapter.getPlayer(position).getPlayerRole());
        }
    };

    public static CreateTeamFragment getInstance(Bundle bundle) {
        CreateTeamFragment friendsFragment = new CreateTeamFragment();
        friendsFragment.setArguments(bundle);
        return friendsFragment;
    }

    @OnClick(R.id.ctv_next)
    public void next(View view) {

        PlayersOutput.DataBean response = new PlayersOutput.DataBean();
        List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayers = new ArrayList<>();
        addHeadingOfPlayers(responseMatchPlayers, AppUtils.getStrFromRes(R.string.wicket_keeper));
        responseMatchPlayers.addAll(getSelectedPlayersData(responseMatchPlayersWK));
        addHeadingOfPlayers(responseMatchPlayers, AppUtils.getStrFromRes(R.string.batsmen));
        responseMatchPlayers.addAll(getSelectedPlayersData(responseMatchPlayersBAT));
        addHeadingOfPlayers(responseMatchPlayers, AppUtils.getStrFromRes(R.string.all_rounders));
        responseMatchPlayers.addAll(getSelectedPlayersData(responseMatchPlayersAR));
        addHeadingOfPlayers(responseMatchPlayers, AppUtils.getStrFromRes(R.string.bowlers));
        responseMatchPlayers.addAll(getSelectedPlayersData(responseMatchPlayersBOWL));
        response.setRecords(responseMatchPlayers);

        Log.d("dataJson", AppUtils.gsonToJSON(response));

        if (actionTag == 1) {
            teamId = "";
        }

        CreateCaptionActivityStart(mContext, teamName, seriesId, MatchGUID, localteamId, visitorteamId, new Gson().toJson(response), teamId, tournamentCode, 1);
    }

    @OnClick(R.id.ctv_team_preview)
    public void teamPreview(View view) {
        if (getTotalSelectedPlayers() == 0) {
            onShowSnackBar(AppUtils.getStrFromRes(R.string.no_players_selected_yet));
        } else {


            /*List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayers = new ArrayList<>();
            addHeadingOfPlayers(responseMatchPlayers, AppUtils.getStrFromRes(R.string.wicket_keeper));
            responseMatchPlayers.addAll(getSelectedPlayersData(responseMatchPlayersGk));
            addHeadingOfPlayers(responseMatchPlayers, AppUtils.getStrFromRes(R.string.batsmen));
            responseMatchPlayers.addAll(getSelectedPlayersData(responseMatchPlayersDEF));
            addHeadingOfPlayers(responseMatchPlayers, AppUtils.getStrFromRes(R.string.all_rounders));
            responseMatchPlayers.addAll(getSelectedPlayersData(responseMatchPlayersMID));
            addHeadingOfPlayers(responseMatchPlayers, AppUtils.getStrFromRes(R.string.bowlers));
            responseMatchPlayers.addAll(getSelectedPlayersData(responseMatchPlayersSI));*/

            List<PlayerRecord> recordList = new ArrayList<>();

            recordList.addAll(getSelectedPlayersRecord(responseMatchPlayersWK));
            recordList.addAll(getSelectedPlayersRecord(responseMatchPlayersBAT));
            recordList.addAll(getSelectedPlayersRecord(responseMatchPlayersAR));
            recordList.addAll(getSelectedPlayersRecord(responseMatchPlayersBOWL));


            showPreview(recordList);
        }
    }


    private List<PlayerRecord> getSelectedPlayersRecord(List<PlayersOutput.DataBean.RecordsBean> response) {

        Log.d("getTotalPoints", AppUtils.gsonToJSON(response));
        List<PlayerRecord> responseMatchPlayers = new ArrayList<>();
        for (int i = 0; i < response.size(); i++) {

            if (response.get(i).isSelected()) {

                PlayerRecord player = new PlayerRecord();
                player.setPlayerGUID(response.get(i).getPlayerGUID());
                player.setPlayerName(response.get(i).getPlayerName());
                player.setPlayerRole(response.get(i).getPlayerRole());
                player.setPlayerPic(response.get(i).getPlayerPic());

                player.setPoints(response.get(i).getPlayerSalary());
                player.setPointCredits(String.valueOf(response.get(i).getPlayerSalary()));
                player.setTotalPoints(String.valueOf(response.get(i).getPointCredits()));

                player.setPlayerCountry(response.get(i).getPlayerCountry());
                player.setPlayerBattingStyle(response.get(i).getPlayerBattingStyle());
                player.setPlayerBowlingStyle(response.get(i).getPlayerBowlingStyle());
                player.setTeamGUID(response.get(i).getTeamGUID());
                player.setIsPlaying(response.get(i).getIsPlaying());
                player.setTeamNameShort(response.get(i).getTeamNameShort());
                player.setLocalTeamName(response.get(0).getTeamGUID());
                player.setSeriesGUID(response.get(i).getSeriesGUID());

                player.setPlayerSelectedPercent(response.get(i).getPlayerSelectedPercent());

                responseMatchPlayers.add(player);
            }
        }
        return responseMatchPlayers;
    }

    private void showPreview(final List<PlayerRecord> responseMatchPlayers) {
        final BottomSheetPreviewFragment dialogFragment = new BottomSheetPreviewFragment();
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
                String name = "";
                if (AppSession.getInstance().getLoginSession().getData().getUsername() != null) {
                    name = AppSession.getInstance().getLoginSession().getData().getUsername() + "'s\n";
                }

                if (TextUtils.isEmpty(teamName))
                    return name.concat("Team 1");
                else return name.concat(teamName);
            }

            @Override
            public boolean isTeamPoints() {
                return false;
            }

            @Override
            public String totalPoints() {
                return "0";
            }

            @Override
            public String getMatchID() {
                return MatchGUID;
            }

            @Override
            public String getStatus() {
                return "Pending";
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
                return isPlaying;
            }
        });
        dialogFragment.show(getChildFragmentManager(), dialogFragment.getTag());
        dialogFragment.setPointLaval("Cr");
    }

    public void CreateCaptionActivityStart(Context context, String teamName, String seriesId, String matchId, String localteamId,
                                           String visitorteamId, String data, String teamId,
                                           String tournamentCode, int gametype) {
        Intent starter = new Intent(context, CreateCaptionActivity.class);
        starter.putExtra("seriesId", seriesId);
        starter.putExtra("matchId", matchId);
        if (team != null) {
            starter.putExtra("teamName", team.getUserTeamName());
        }

        starter.putExtra("localteamId", localteamId);
        starter.putExtra("visitorteamId", visitorteamId);
        starter.putExtra("data", data);
        starter.putExtra("teamId", teamId);
        starter.putExtra("contestId", contestId);
        starter.putExtra("joiningAmount", joiningAmount);
        starter.putExtra("userInviteCode", userInviteCode);
        starter.putExtra("chip", chip);
        starter.putExtra("NEED", NEED);
        starter.putExtra("join", join);
        starter.putExtra("tournamentCode", tournamentCode);
        starter.putExtra("gametype", gametype);
        starter.putExtra("cashBonusContribution", cashBonusContribution);

        startActivityForResult(starter, BaseActivity.REQUEST_CODE_CREATE_TEAM);
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

    private void addHeadingOfPlayers(List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayers, String type) {
        PlayersOutput.DataBean.RecordsBean bean = new PlayersOutput.DataBean.RecordsBean();
        bean.setViewType(1);
        bean.setPlayerName(type);
        responseMatchPlayers.add(bean);
    }

    @OnClick(R.id.ll_wk)
    public void WK(View view) {
        customTextViewWK.setTextColor(getResources().getColor(R.color.primary_text));
        customTextViewBAT.setTextColor(getResources().getColor(R.color.secondary_text));
        customTextViewAR.setTextColor(getResources().getColor(R.color.secondary_text));
        customTextViewBOWL.setTextColor(getResources().getColor(R.color.secondary_text));
        indicatorWK.setVisibility(View.VISIBLE);
        indicatorBAT.setVisibility(View.INVISIBLE);
        indicatorAR.setVisibility(View.INVISIBLE);
        indicatorBOWL.setVisibility(View.INVISIBLE);


        SELECTED_ROLE = Constant.ROLE_WICKETKEEPER;
        viewSelected(Constant.ROLE_WICKETKEEPER);

        ic_wk.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_on));
        ic_bowl.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));
        ic_allrounder.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));
        ic_bat.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));

        ROLE_AR = false;
        ROLE_BAT = false;
        ROLE_BOW = false;
        ROLE_WICK = true;


        BOWL.setTextColor(getResources().getColor(R.color.black));
        AR.setTextColor(getResources().getColor(R.color.black));
        BAT.setTextColor(getResources().getColor(R.color.black));
        WK.setTextColor(getResources().getColor(R.color.createTeamSeector));


        if (!canSelectMorePlayers(Constant.ROLE_WICKETKEEPER)) {
            adapter.disableItems(true, Constant.ROLE_WICKETKEEPER, 1);
        } else {
            adapter.disableItems(false, Constant.ROLE_WICKETKEEPER, getIndividualCount(responseMatchPlayersWK));
        }

        prSortPlayer();

    }

    @OnClick(R.id.ll_bat)
    public void BAT(View view) {

        customTextViewWK.setTextColor(getResources().getColor(R.color.secondary_text));
        customTextViewBAT.setTextColor(getResources().getColor(R.color.primary_text));
        customTextViewAR.setTextColor(getResources().getColor(R.color.secondary_text));
        customTextViewBOWL.setTextColor(getResources().getColor(R.color.secondary_text));
        indicatorWK.setVisibility(View.INVISIBLE);
        indicatorBAT.setVisibility(View.VISIBLE);
        indicatorAR.setVisibility(View.INVISIBLE);
        indicatorBOWL.setVisibility(View.INVISIBLE);

        SELECTED_ROLE = Constant.ROLE_BATSMAN;
        viewSelected(Constant.ROLE_BATSMAN);


        ic_bat.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_on));
        ic_bowl.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));
        ic_allrounder.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));
        ic_wk.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));

        ROLE_AR = false;
        ROLE_BAT = true;
        ROLE_BOW = false;
        ROLE_WICK = false;

        BOWL.setTextColor(getResources().getColor(R.color.black));
        AR.setTextColor(getResources().getColor(R.color.black));
        BAT.setTextColor(getResources().getColor(R.color.createTeamSeector));
        WK.setTextColor(getResources().getColor(R.color.black));

        if (!canSelectMorePlayers(Constant.ROLE_BATSMAN)) {
            adapter.disableItems(true, Constant.ROLE_BATSMAN, 3);
        } else {
            adapter.disableItems(false, Constant.ROLE_BATSMAN, getIndividualCount(responseMatchPlayersBAT));
        }

        prSortPlayer();
    }

    @OnClick(R.id.ll_ar)
    public void AR(View view) {

        customTextViewWK.setTextColor(getResources().getColor(R.color.secondary_text));
        customTextViewBAT.setTextColor(getResources().getColor(R.color.secondary_text));
        customTextViewAR.setTextColor(getResources().getColor(R.color.primary_text));
        customTextViewBOWL.setTextColor(getResources().getColor(R.color.secondary_text));
        indicatorWK.setVisibility(View.INVISIBLE);
        indicatorBAT.setVisibility(View.INVISIBLE);
        indicatorAR.setVisibility(View.VISIBLE);
        indicatorBOWL.setVisibility(View.INVISIBLE);

        SELECTED_ROLE = Constant.ROLE_ALLROUNDER;
        viewSelected(Constant.ROLE_ALLROUNDER);

        ic_allrounder.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_on));
        ic_bowl.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));
        ic_wk.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));
        ic_bat.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));

        ROLE_AR = true;
        ROLE_BAT = false;
        ROLE_BOW = false;
        ROLE_WICK = false;

        BOWL.setTextColor(getResources().getColor(R.color.black));
        AR.setTextColor(getResources().getColor(R.color.createTeamSeector));
        BAT.setTextColor(getResources().getColor(R.color.black));
        WK.setTextColor(getResources().getColor(R.color.black));


        if (!canSelectMorePlayers(Constant.ROLE_ALLROUNDER)) {
            adapter.disableItems(true, Constant.ROLE_ALLROUNDER, 1);
        } else {
            adapter.disableItems(false, Constant.ROLE_ALLROUNDER, getIndividualCount(responseMatchPlayersAR));
        }

        prSortPlayer();
    }

    @OnClick(R.id.ll_bowl)
    public void BOWL(View view) {

        customTextViewWK.setTextColor(getResources().getColor(R.color.secondary_text));
        customTextViewBAT.setTextColor(getResources().getColor(R.color.secondary_text));
        customTextViewAR.setTextColor(getResources().getColor(R.color.secondary_text));
        customTextViewBOWL.setTextColor(getResources().getColor(R.color.primary_text));
        indicatorWK.setVisibility(View.INVISIBLE);
        indicatorBAT.setVisibility(View.INVISIBLE);
        indicatorAR.setVisibility(View.INVISIBLE);
        indicatorBOWL.setVisibility(View.VISIBLE);

        SELECTED_ROLE = Constant.ROLE_BOWLER;
        viewSelected(Constant.ROLE_BOWLER);

        ic_bowl.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_on));
        ic_allrounder.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));
        ic_wk.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));
        ic_bat.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_player_role_off));

        ROLE_AR = false;
        ROLE_BAT = false;
        ROLE_BOW = true;
        ROLE_WICK = false;

        BOWL.setTextColor(getResources().getColor(R.color.createTeamSeector));
        AR.setTextColor(getResources().getColor(R.color.black));
        BAT.setTextColor(getResources().getColor(R.color.black));
        WK.setTextColor(getResources().getColor(R.color.black));


        if (!canSelectMorePlayers(Constant.ROLE_BOWLER)) {
            adapter.disableItems(true, Constant.ROLE_BOWLER, 3);
        } else {
            adapter.disableItems(false, Constant.ROLE_BOWLER, getIndividualCount(responseMatchPlayersBOWL));
        }

        prSortPlayer();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        if (getArguments() != null) {

            if (getArguments().containsKey("actionTag")) {
                actionTag = getArguments().getInt("actionTag");
            }

            if (getArguments().containsKey("seriesId")) {
                seriesId = getArguments().getString("seriesId");
            }
            if (getArguments().containsKey("MatchGUID")) {
                MatchGUID = getArguments().getString("MatchGUID");
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
            if (getArguments().containsKey("NEED")) {
                NEED = getArguments().getString("NEED");
            }
            if (getArguments().containsKey("teamName")) {
                teamName = getArguments().getString("teamName");
            }
            if (getArguments().containsKey("tournamentCode")) {
                tournamentCode = getArguments().getString("tournamentCode");
            }

            if (getArguments().containsKey("teamData") && !TextUtils.isEmpty(getArguments().getString("teamData"))) {
                team = new Gson().fromJson(getArguments().getString("teamData"), MyTeamOutput.DataBean.RecordsBean.class);
            }

            if (getArguments().containsKey("cashBonusContribution")) {
                cashBonusContribution = getArguments().getString("cashBonusContribution");
            }

            if (getArguments().containsKey("join")) {
                join = getArguments().getString("join");

            }
        }
        LocalBroadcastManager.getInstance(mContext).registerReceiver(updates_receiver, new IntentFilter(CreateTeamFragment.class.getSimpleName()));

    }

    public void setCaption(String playerId) {
        setCaption(responseMatchPlayersWK, playerId);
        setCaption(responseMatchPlayersAR, playerId);
        setCaption(responseMatchPlayersBAT, playerId);
        setCaption(responseMatchPlayersBOWL, playerId);
    }

    public void setViceCaption(String playerId) {
        setViceCaption(responseMatchPlayersWK, playerId);
        setViceCaption(responseMatchPlayersAR, playerId);
        setViceCaption(responseMatchPlayersBAT, playerId);
        setViceCaption(responseMatchPlayersBOWL, playerId);
    }

    public void setCaption(List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayers, String playerId) {
        if (responseMatchPlayers == null) return;
        for (int i = 0; i < responseMatchPlayers.size(); i++) {
            if (responseMatchPlayers.get(i).isSelected()) {
                if (responseMatchPlayers.get(i).getTeamGUID().equals(playerId)) {
                    responseMatchPlayers.get(i).setPosition(Constant.POSITION_CAPTAIN);
                } else {
                    if (responseMatchPlayers.get(i).getPosition().equals(Constant.POSITION_CAPTAIN))
                        responseMatchPlayers.get(i).setPosition(Constant.POSITION_PLAYER);
                }

            }
        }
    }

    public void setViceCaption(List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayers, String playerId) {
        if (responseMatchPlayers == null) return;
        for (int i = 0; i < responseMatchPlayers.size(); i++) {
            if (responseMatchPlayers.get(i).isSelected()) {
                if (responseMatchPlayers.get(i).getPlayerGUID().equals(playerId)) {
                    responseMatchPlayers.get(i).setPosition(Constant.POSITION_VICE_CAPTAIN);
                } else {
                    if (responseMatchPlayers.get(i).getPosition().equals(Constant.POSITION_VICE_CAPTAIN))
                        responseMatchPlayers.get(i).setPosition(Constant.POSITION_PLAYER);
                }
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();

        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(updates_receiver);

        if (presenterImpl != null) presenterImpl.actionListingCancel();
    }

    @Override
    public int getLayout() {
        return R.layout.create_team_fragment;
    }

    @Override
    public void init() {
        mContext = getActivity();
        loader = new Loader(getCurrentView());
        //set layout manager into recyclerView

        ROLE_AR = false;
        ROLE_BAT = false;
        ROLE_BOW = false;
        ROLE_WICK = true;

        BOWL.setTextColor(getResources().getColor(R.color.black));
        AR.setTextColor(getResources().getColor(R.color.black));
        BAT.setTextColor(getResources().getColor(R.color.black));
        WK.setTextColor(getResources().getColor(R.color.createTeamSeector));


        matchDetailPresenter = new MatchDetailPresenterImpl(this, new UserInteractor());


       /* ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        mRecyclerView.addItemDecoration(itemDecoration);*/
        mRecyclerView.setNestedScrollingEnabled(true);
        layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerViewPlayer.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        adapterteam = new TeamPlayerAdapter(R.layout.team_player_adapter, this);
        mRecyclerViewPlayer.setAdapter(adapterteam);

        if (loader.getTryAgainView() != null)
            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callTask();
                }
            });

        List<PlayersOutput.DataBean.RecordsBean> recordsBeans = new ArrayList<>();
        presenterImpl = new CreateTeamPresenterImpl(this, new UserInteractor());

        callTask();

        callMatchDetail();

        adapter = new CreateTeamAdapter(R.layout.list_item_players, getActivity(),
                recordsBeans, onItemClickCallback, onViewItemClickCallback, playingFlag, "Cricket");
        mRecyclerView.setAdapter(adapter);
        animationView = false;

    }

    void callMatchDetail() {
        MatchDetailInput mMatchDetailInput = new MatchDetailInput();
        mMatchDetailInput.setPrivacy("No");
        mMatchDetailInput.setMatchGUID(MatchGUID);
        mMatchDetailInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mMatchDetailInput.setStatus(Constant.Pending);
        mMatchDetailInput.setParams(Constant.MATCH_PARAMS);
        matchDetailPresenter.actionMatchdetail(mMatchDetailInput);
    }

    public void callTask() {


        PlayersInput mPlayersInput = new PlayersInput();
        mPlayersInput.setMatchGUID(MatchGUID);
        mPlayersInput.setParams(Constant.PLAYERS_PARAM + ",PlayerSelectedViceCaptain,PlayerSelectedCaptain,IsPlayedLastMatch,PlayerSelectedPercent");
        mPlayersInput.setIsActive("Yes");
        mPlayersInput.setOrderBy("PlayerSalary");
        mPlayersInput.setSequence("DESC");
        mPlayersInput.setPlayerSalary("Yes");
        mPlayersInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        presenterImpl.actionMatchPlayers(mPlayersInput);

    }

    private void itemSelectedAnimation(final View view, final int position) {
        final ImageView ivCross = (ImageView) view.findViewById(R.id.iv_cross);
        final View view1 = view.findViewById(R.id.view_shadow);
        Animation startRotateAnimation = AnimationUtils.loadAnimation(AppController.getContext(),
                adapter.isSelected(position) ? R.anim.android_rotate_animation1 : R.anim.android_rotate_animation);
        startRotateAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                animationView = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                adapter.toggleSelected(position);
                adapter.setCrossButton(view1, ivCross, position);
                counterUpdate();
                animationView = false;
                adapter.pointsRemaining = (100 - getTotalPlayersCredit());


                if (ROLE_AR) {
                    if (!canSelectMorePlayers(Constant.ROLE_ALLROUNDER)) {
                        adapter.disableItems(true, Constant.ROLE_ALLROUNDER, 1);
                    } else {
                        adapter.disableItems(false, Constant.ROLE_ALLROUNDER, getIndividualCount(responseMatchPlayersAR));
                    }
                }

                if (ROLE_BAT) {
                    if (!canSelectMorePlayers(Constant.ROLE_BATSMAN)) {
                        adapter.disableItems(true, Constant.ROLE_BATSMAN, 3);
                    } else {
                        adapter.disableItems(false, Constant.ROLE_BATSMAN, getIndividualCount(responseMatchPlayersBAT));
                    }
                }

                if (ROLE_BOW) {
                    if (!canSelectMorePlayers(Constant.ROLE_BOWLER)) {
                        adapter.disableItems(true, Constant.ROLE_BOWLER, 3);
                    } else {
                        adapter.disableItems(false, Constant.ROLE_BOWLER, getIndividualCount(responseMatchPlayersBOWL));
                    }
                }

                if (ROLE_WICK) {
                    if (!canSelectMorePlayers(Constant.ROLE_WICKETKEEPER)) {
                        adapter.disableItems(true, Constant.ROLE_WICKETKEEPER, 1);
                    } else {
                        adapter.disableItems(false, Constant.ROLE_WICKETKEEPER, getIndividualCount(responseMatchPlayersWK));
                    }
                }

              /*  if(ROLE_AR){
                    if(getIndividualCount(responseMatchPlayersMID)==5){
                        adapter.disableItems(true,Constant.ROLE_ALLROUNDER,3);
                    }else {
                        adapter.disableItems(false,Constant.ROLE_ALLROUNDER,getIndividualCount(responseMatchPlayersMID));
                    }
                }

                if(ROLE_BAT){
                    if(getIndividualCount(responseMatchPlayersDEF)==5){
                        adapter.disableItems(true,Constant.ROLE_BATSMAN,5);
                    }else {
                        adapter.disableItems(false,Constant.ROLE_BATSMAN,getIndividualCount(responseMatchPlayersDEF));
                    }
                }

                if(ROLE_BOW){
                    if(getIndividualCount(responseMatchPlayersSI)==5){
                        adapter.disableItems(true,Constant.ROLE_BOWLER,5);
                    }else {
                        adapter.disableItems(false,Constant.ROLE_BOWLER,getIndividualCount(responseMatchPlayersSI));
                    }
                }

                if(ROLE_WICK){
                    if(getIndividualCount(responseMatchPlayersGk)==1){
                        adapter.disableItems(true,Constant.ROLE_WICKETKEEPER,1);
                    }else {
                        adapter.disableItems(false,Constant.ROLE_WICKETKEEPER,getIndividualCount(responseMatchPlayersGk));
                    }
                }*/

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ivCross.startAnimation(startRotateAnimation);
    }

    private void itemWarningAnimation(View view) {
       /* Animation startRotateAnimation = AnimationUtils.loadAnimation(AppController.getContext(), R.anim.android_vibration_animation);
        startRotateAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                animationView = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animationView = false;


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(startRotateAnimation);*/
    }

    @Override
    public void onLoadingError(String value) {
        loader.error(value);
    }

    @Override
    public void onLoadingSuccess(PlayersOutput response) {
        if (isLayoutAdded() && mRecyclerView != null) {
            isPlaying = response.getData().getPlaying11Announce();


            if (team != null) {
                updatePlayersData(response);
            }


            if (response.getData().getRecords().size() > 0) {
                for (int i = 0; i < response.getData().getRecords().size(); i++) {
                    if (i == 0) {
                        teamType1 = response.getData().getRecords().get(0).getTeamGUID();
                        team1 = response.getData().getRecords().get(0).getTeamNameShort();
                        seriesId = response.getData().getRecords().get(0).getSeriesGUID();
                    } else if (!response.getData().getRecords().get(0).getTeamGUID().
                            equals(response.getData().getRecords().get(i).getTeamGUID())) {
                        team2 = response.getData().getRecords().get(i).getTeamNameShort();
                        teamType2 = response.getData().getRecords().get(i).getTeamGUID();
                        seriesId = response.getData().getRecords().get(i).getSeriesGUID();
                    }

                }
            }
            initPlayersData(response);

            if (getTotalPlayersCredit() > 100) {
                customTextViewNext.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_solid_bg_theme_active));
                customTextViewNext.setEnabled(false);

                //customTextViewNext.setTextColor(getResources().getColor(R.color.grey_white));
            }
        }
    }

    @Override
    public void onHideLoading() {
        loader.hide();

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
    public void showLoading() {
       /* if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();*/
        loader.start();
    }

    @Override
    public boolean isLayoutAdded() {
        return (isAdded() && getActivity() != null);
    }

    @Override
    public void hideLoading() {

        /* if (mProgressDialog != null) mProgressDialog.dismiss();*/

        loader.hide();
    }

    @Override
    public void onMatchSuccess(MatchDetailOutPut mMatchDetailOutPut) {
        matchDetailOutPut = mMatchDetailOutPut;

        if (isAdded() && getActivity() != null) {
            loader.hide();

            ViewUtils.setImageUrl(customImageViewTeamFlagLocal, mMatchDetailOutPut.getData().getTeamFlagLocal());
            ViewUtils.setImageUrl(customImageViewTeamFlagVisitor, mMatchDetailOutPut.getData().getTeamFlagVisitor());
            customTextViewTeamNameLocal.setText(mMatchDetailOutPut.getData().getTeamNameShortLocal() + " (0)");
            customTextViewTeamNameVisitor.setText("(0) " + mMatchDetailOutPut.getData().getTeamNameShortVisitor());
            adapter.localTeamGUID = mMatchDetailOutPut.getData().getTeamNameShortLocal();
            adapter.notifyDataSetChanged();

            teamsVS.setText(mMatchDetailOutPut.getData().getTeamNameShortLocal()
                    + " " + AppUtils.getStrFromRes(R.string.vs)
                    + " " + mMatchDetailOutPut.getData().getTeamNameShortVisitor());

            localTeamName = mMatchDetailOutPut.getData().getTeamNameShortLocal();

            visitorTeamName = mMatchDetailOutPut.getData().getTeamNameShortVisitor();


            if (customTextViewFullTime != null || mMatchDetailOutPut.getData() != null) {
                if (mMatchDetailOutPut.getData().getStatus() != null) {
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

        if (isAdded() && getActivity() != null) {
            loader.error(errMsg);
        }
    }

    @Override
    public void onShowSnackBar(@NonNull String message) {
        // Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        AppUtils.showToast(mContext, message);
    }

    private List<PlayersOutput.DataBean.RecordsBean> getSelectedPlayersData(List<PlayersOutput.DataBean.RecordsBean> response) {
        List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayers = new ArrayList<>();
        for (int i = 0; i < response.size(); i++) {
            if (response.get(i).isSelected()) responseMatchPlayers.add(response.get(i));
        }
        return responseMatchPlayers;
    }

    private void updatePlayersData(PlayersOutput response) {
        if (team == null || response == null) return;

        teamId = team.getUserTeamGUID();
        for (int i = 0; i < team.getUserTeamPlayers().size(); i++) {
            for (int k = 0; k < response.getData().getRecords().size(); k++) {
                if (team.getUserTeamPlayers().get(i).getPlayerGUID().equals(response.getData().getRecords().get(k).getPlayerGUID())) {
                    response.getData().getRecords().get(k).setSelected(true);
                    response.getData().getRecords().get(k).setPosition(team.getUserTeamPlayers().get(i).getPlayerPosition());
                }
            }
        }
    }

    private void initPlayersData(PlayersOutput response) {
        for (int i = 0; i < response.getData().getRecords().size(); i++) {
            initPlayers(response.getData().getRecords().get(i));
        }

        counterUpdate();

        adapter.playingFlag = isPlaying.equals("Yes")?1:0;
        SELECTED_ROLE = Constant.ROLE_WICKETKEEPER;
        viewSelected(Constant.ROLE_WICKETKEEPER);
        adapter.shotByCredit(true);
    }

    private void initPlayers(PlayersOutput.DataBean.RecordsBean bean) {


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

    private void viewSelected(String type) {
        switch (type) {
            case Constant.ROLE_WICKETKEEPER:
                customTextViewTITLE.setText(AppUtils.getStrFromRes(R.string.pick_one_wc));
                adapter.updateTeamData(responseMatchPlayersWK);
                break;
            case Constant.ROLE_BATSMAN:
                customTextViewTITLE.setText(AppUtils.getStrFromRes(R.string.pick_three_five_bat));
                adapter.updateTeamData(responseMatchPlayersBAT);
                break;
            case Constant.ROLE_ALLROUNDER:
                customTextViewTITLE.setText(AppUtils.getStrFromRes(R.string.pick_one_three_all));
                adapter.updateTeamData(responseMatchPlayersAR);
                break;
            case Constant.ROLE_BOWLER:
                customTextViewTITLE.setText(AppUtils.getStrFromRes(R.string.pick_three_five_bowl));
                adapter.updateTeamData(responseMatchPlayersBOWL);
                break;
            default:

                break;
        }
        selectPlayerBackground(type);
        counterUpdate();
    }

    private void counterUpdate() {
        adapterteam.notifyDataSetChanged();


        customTextViewWK.setText("WK (" + getIndividualCount(Constant.ROLE_WICKETKEEPER) + ")");
        customTextViewBAT.setText("BAT (" + getIndividualCount(Constant.ROLE_BATSMAN) + ")");
        customTextViewAR.setText("AR (" + getIndividualCount(Constant.ROLE_ALLROUNDER) + ")");
        customTextViewBOWL.setText("BOWL (" + getIndividualCount(Constant.ROLE_BOWLER) + ")");

        customTextViewPlayers.setText(getTotalSelectedPlayers() + "/11");
        if (getTotalPlayersCredit() > 100) {
            customTextViewCreditLeft.setText("0" + "/100");
        } else {
            customTextViewCreditLeft.setText((100 - getTotalPlayersCredit()) + "/100");
        }


        if (localTeamName != null && localTeamName != "" && localTeamName.equalsIgnoreCase(team1)) {
            customTextViewTeamNameLocal.setText(matchDetailOutPut.getData().getTeamNameShortLocal() + " (" + getSelectedTeamMemberCount(teamType1) + ")");
        } else {
            customTextViewTeamNameLocal.setText(matchDetailOutPut.getData().getTeamNameShortLocal() + " (" + getSelectedTeamMemberCount(teamType2) + ")");

        }

        if (visitorTeamName != null && visitorTeamName != "" && visitorTeamName.equalsIgnoreCase(team2)) {
            customTextViewTeamNameVisitor.setText("(" + getSelectedTeamMemberCount(teamType2) + ") " + matchDetailOutPut.getData().getTeamNameShortVisitor());

        } else {
            customTextViewTeamNameVisitor.setText("(" + getSelectedTeamMemberCount(teamType1) + ") " + matchDetailOutPut.getData().getTeamNameShortVisitor());

        }

//        ctvTeam1Count.setText("" + getSelectedTeamMemberCount(teamType1));
//        ctvTeam2Count.setText("" + getSelectedTeamMemberCount(teamType2));

        if (getTotalSelectedPlayers() >= 11) {
            customTextViewNext.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_solid_bg_theme_active));
            //customTextViewNext.setTextColor(getResources().getColor(R.color.white));
            customTextViewNext.setEnabled(true);
            counter11Selected();
        } else {
            customTextViewNext.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_solid_bg_theme_inactive));
            customTextViewNext.setEnabled(false);
            //customTextViewNext.setTextColor(getResources().getColor(R.color.grey_white));


        }


    }

    private void counter11Selected() {


    }

    private void selectPlayerBackground(String type) {
        switch (type) {
            case Constant.ROLE_WICKETKEEPER:
                customImageViewWK.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_white_border_light));
                customImageViewBAT.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                customImageViewAR.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                customImageViewBOWL.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                break;
            case Constant.ROLE_BATSMAN:
                customImageViewWK.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                customImageViewBAT.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_white_border_light));
                customImageViewAR.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                customImageViewBOWL.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                break;
            case Constant.ROLE_ALLROUNDER:
                customImageViewWK.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                customImageViewBAT.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                customImageViewAR.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_white_border_light));
                customImageViewBOWL.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                break;
            case Constant.ROLE_BOWLER:
                customImageViewWK.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                customImageViewBAT.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                customImageViewAR.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_gray_border_gray));
                customImageViewBOWL.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_white_border_light));
                break;
        }
    }

    public int getTotalSelectedPlayers() {
        return getIndividualCount(responseMatchPlayersWK)
                + getIndividualCount(responseMatchPlayersBAT)
                + getIndividualCount(responseMatchPlayersAR)
                + getIndividualCount(responseMatchPlayersBOWL);
    }

    private int getNeedToSelectPlayers(String type) {
        int count = 0;
        if (!type.equals(Constant.ROLE_WICKETKEEPER) && getIndividualCount(responseMatchPlayersWK) < 1) {
            count = count + 1;
        }
        if (!type.equals(Constant.ROLE_BATSMAN) && getIndividualCount(responseMatchPlayersBAT) < 3) {
            count = count + (3 - getIndividualCount(responseMatchPlayersBAT));
        }
        if (!type.equals(Constant.ROLE_ALLROUNDER) && getIndividualCount(responseMatchPlayersAR) < 1) {
            count = count + 1;
        }
        if (!type.equals(Constant.ROLE_BOWLER) && getIndividualCount(responseMatchPlayersBOWL) < 3) {
            count = count + (3 - getIndividualCount(responseMatchPlayersBOWL));
        }
        return count;
    }

    private int getRemainsPlayersSelection() {
        return 11 - getTotalSelectedPlayers();
    }

    private boolean canSelectMorePlayers(String type) {
        return getRemainsPlayersSelection() - getNeedToSelectPlayers(type) > 0;
    }

    private int getIndividualCount(String type) {
        switch (type) {
            case Constant.ROLE_WICKETKEEPER:
                return getIndividualCount(responseMatchPlayersWK);
            case Constant.ROLE_BATSMAN:
                return getIndividualCount(responseMatchPlayersBAT);
            case Constant.ROLE_ALLROUNDER:
                return getIndividualCount(responseMatchPlayersAR);
            case Constant.ROLE_BOWLER:
                return getIndividualCount(responseMatchPlayersBOWL);
        }
        return 0;
    }

    public int getIndividualCount(List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayers) {
        if (responseMatchPlayers == null) return 0;
        int count = 0;
        for (int i = 0; i < responseMatchPlayers.size(); i++) {
            if (responseMatchPlayers.get(i).isSelected()) count++;
        }
        return count;
    }

    private int getSelectedTeamMemberCount(String type) {
        return getSelectedTeamMemberCount(responseMatchPlayersWK, type)
                + getSelectedTeamMemberCount(responseMatchPlayersBAT, type)
                + getSelectedTeamMemberCount(responseMatchPlayersAR, type)
                + getSelectedTeamMemberCount(responseMatchPlayersBOWL, type);
    }

    public int getSelectedTeamMemberCount(List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayers, String team) {
        if (responseMatchPlayers == null) return 0;
        int count = 0;
        for (int i = 0; i < responseMatchPlayers.size(); i++) {
            if (responseMatchPlayers.get(i).getTeamGUID().equals(team) && responseMatchPlayers.get(i).isSelected())
                count++;
        }
        return count;
    }

    private float getTotalPlayersCredit() {
        return getTotalPlayersCredit(responseMatchPlayersWK)
                + getTotalPlayersCredit(responseMatchPlayersBAT)
                + getTotalPlayersCredit(responseMatchPlayersAR)
                + getTotalPlayersCredit(responseMatchPlayersBOWL);
    }

    public float getTotalPlayersCredit(List<PlayersOutput.DataBean.RecordsBean> responseMatchPlayers) {
        if (responseMatchPlayers == null) return 0;
        float points = 0;
        for (int i = 0; i < responseMatchPlayers.size(); i++) {
            if (responseMatchPlayers.get(i).isSelected()) {
                try {

                    //Change-by-rp(18-03-2019)  points = points + (float)responseMatchPlayers.get(i).getPointCredits();
                    points = points + Float.parseFloat(responseMatchPlayers.get(i).getPlayerSalary().trim());
                    //points =0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return points;
    }

}
