package com.mw.eleven11.UI.playerPoints;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class BottomSheetPointsFragment extends BottomSheetDialogFragment {

    PlayerPointCallback callback;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    PlayerSheetAdapter mPlayerSheetAdapter;

    View root;
    @BindView(R.id.sdv)
    SimpleDraweeView mSimpleDraweeView;
    @BindView(R.id.ctv_player_name)
    CustomTextView mCustomTextViewName;
    @BindView(R.id.ctv_selected_by)
    CustomTextView mCustomTextViewSelectedBy;
    @BindView(R.id.ctv_points)
    CustomTextView mCustomTextViewPoints;
    @BindView(R.id.ctv_credit)
    CustomTextView mCustomTextViewCredit;
    @BindView(R.id.points_starting11)
    CustomTextView mPointsStarting;
    @BindView(R.id.actual_starting11)
    CustomTextView mActualStarting;
    @BindView(R.id.points_runs)
    CustomTextView mPointsRuns;
    @BindView(R.id.actual_runs)
    CustomTextView mActualRuns;
    @BindView(R.id.points_s4)
    CustomTextView mPointsS4;
    @BindView(R.id.actual_s4)
    CustomTextView mActualS4;
    @BindView(R.id.points_s6)
    CustomTextView mPointsS6;
    @BindView(R.id.actual_s6)
    CustomTextView mActualS6;
    @BindView(R.id.points_50)
    CustomTextView mPoints50;
    @BindView(R.id.actual_50)
    CustomTextView mActual50;
    @BindView(R.id.points_wicket)
    CustomTextView mPointsWicket;
    @BindView(R.id.actual_wicket)
    CustomTextView mActualWickets;
    @BindView(R.id.points_maiden)
    CustomTextView mPointsMaiden;
    @BindView(R.id.actual_maiden)
    CustomTextView mActualMaiden;
    @BindView(R.id.points_catch)
    CustomTextView mPointsCatch;
    @BindView(R.id.actual_catch)
    CustomTextView mActualCatch;
    @BindView(R.id.points_run_out)
    CustomTextView mPointsRunOut;
    @BindView(R.id.actual_run_out)
    CustomTextView mActualRunOut;
    @BindView(R.id.points_duck)
    CustomTextView mPointsDuck;
    @BindView(R.id.actual_duck)
    CustomTextView mActualDuck;
    @BindView(R.id.points_wicket_bonus)
    CustomTextView mPointsWicketBonus;
    @BindView(R.id.actual_wicket_bonus)
    CustomTextView mActualWicketBonus;
    @BindView(R.id.points_strike_rate)
    CustomTextView mPointsStrikeRate;
    @BindView(R.id.actual_strike_rate)
    CustomTextView mActualStrikeRate;
    @BindView(R.id.points_economy_rate)
    CustomTextView mPointsEconomyRate;
    @BindView(R.id.actual_economy_rate)
    CustomTextView mActualEconomyRate;
    @BindView(R.id.ctv_my_player)
    CustomTextView ctv_my_player;
    @BindView(R.id.points_total)
    CustomTextView points_total;
    PlayersOutput.DataBean.RecordsBean playerData;
    //PlayersOutput.DataBean.RecordsBean livePlayerStatusData;
    private Unbinder unbinder;
    private BottomSheetBehavior mBehavior;


    private OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {


        }
    };

    @OnClick(R.id.ctv_close)
    public void closeOnClick() {
        dismiss();
    }

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.player_points_bottomsheet, container, false);
        unbinder = ButterKnife.bind(this, root);

        playerData = new PlayersOutput.DataBean.RecordsBean();
       // livePlayerStatusData = new PlayersOutput.DataBean.RecordsBean();

        playerData = (PlayersOutput.DataBean.RecordsBean) getArguments().getSerializable("playerData");

        //livePlayerStatusData = (PlayersOutput.DataBean.RecordsBean) getArguments().getSerializable("livePlayerStatusData");
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        playerData= callback.getPlayer();


        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);


        mPlayerSheetAdapter = new PlayerSheetAdapter(getActivity(), playerData.getPointsData());
        mRecyclerView.setAdapter(mPlayerSheetAdapter);

        if (playerData.getMyPlayer().equals("No")) {
            ctv_my_player.setText(AppUtils.getStrFromRes(R.string.notInTeam));
            ctv_my_player.setCompoundDrawablesWithIntrinsicBounds(R.drawable.your_player_blur, 0, 0, 0);
        } else {

            ctv_my_player.setText("In Team");
            ctv_my_player.setCompoundDrawablesWithIntrinsicBounds(R.drawable.your_player, 0, 0, 0);
        }

        if (playerData.getTopPlayer().equals("No")) {

            mCustomTextViewName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.top_player_blur, 0);
        } else {

            mCustomTextViewName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.top_player, 0);
        }

        mSimpleDraweeView.setImageURI(playerData.getPlayerPic());

        mCustomTextViewName.setText(playerData.getPlayerName());

        mCustomTextViewCredit.setText(playerData.getPlayerSalary() + "");
        mCustomTextViewPoints.setText(playerData.getPointCredits() + "");



       /*


        mPointsStarting.setText(playerData.getResponse().get(0).getPoints().getStarting11() + "");
        mPointsS4.setText(playerData.getResponse().get(0).getPoints().getBattingS4() + "");
        mPointsS6.setText(playerData.getResponse().get(0).getPoints().getBattingS6() + "");
        mActualStarting.setText(playerData.getResponse().get(0).getActual().getStarting11() + "");
        mPointsRuns.setText(playerData.getResponse().get(0).getPoints().getBattingRun() + "");
        mPointsWicket.setText(playerData.getResponse().get(0).getPoints().getBowlingWicket() + "");
        mPoints50.setText(playerData.getResponse().get(0).getPoints().getBatting50100() + "");
        mPointsMaiden.setText(playerData.getResponse().get(0).getPoints().getBowlingMaiden() + "");
        mPointsCatch.setText(playerData.getResponse().get(0).getPoints().getCatchX() + "");
        mPointsDuck.setText(playerData.getResponse().get(0).getPoints().getDuck() + "");
        mPointsStrikeRate.setText(playerData.getResponse().get(0).getPoints().getStrikeRate() + "");
        mPointsWicketBonus.setText(playerData.getResponse().get(0).getPoints().getWicketBonus() + "");
        mPointsEconomyRate.setText(playerData.getResponse().get(0).getPoints().getEconomyRate() + "");
        mPointsRunOut.setText(playerData.getResponse().get(0).getPoints().getRunOutStumping() + "");

        points_total.setText(playerData.getResponse().get(0).getPoints().getTotalPoint() + "");


        int sBattingRun = Integer.valueOf(playerData.getResponse().get(0).getActual().getBattingRun());
        int sBattingS4 = Integer.valueOf(playerData.getResponse().get(0).getActual().getBattingS4());

        int sBattingS6 = Integer.valueOf(playerData.getResponse().get(0).getActual().getBattingS6());
        int sBowlingWicket = Integer.valueOf(playerData.getResponse().get(0).getActual().getBowlingWicket());

        int sBatting50100 = Integer.valueOf(playerData.getResponse().get(0).getActual().getBatting50100());
        int sBowlingMaiden = Integer.valueOf(playerData.getResponse().get(0).getActual().getBowlingMaiden());

        int sCatchX = Integer.valueOf(playerData.getResponse().get(0).getActual().getCatchX());
        int sDuck = Integer.valueOf(playerData.getResponse().get(0).getActual().getDuck());

        int sWicketBonus = Integer.valueOf(playerData.getResponse().get(0).getActual().getWicketBonus());
        int sStrikeRate = Integer.valueOf(playerData.getResponse().get(0).getActual().getStrikeRate());

        int sEconomyRate = Integer.valueOf(playerData.getResponse().get(0).getActual().getEconomyRate());
        int sRunOutStumping = Integer.valueOf(playerData.getResponse().get(0).getActual().getRunOutStumping());


        int totalActual = sBattingRun + sBattingS4 + sBattingS6 + sBowlingWicket + sBatting50100 +
                sBowlingMaiden +
                sCatchX +
                sDuck +
                sWicketBonus +
                sStrikeRate +
                sEconomyRate +
                sRunOutStumping;
*/

        mCustomTextViewSelectedBy.setText(playerData.getPlayerSelectedPercent() + "%");

       /* mActualRuns.setText(playerData.getResponse().get(0).getActual().getBattingRun() + "");
        mActualS4.setText(playerData.getResponse().get(0).getActual().getBattingS4() + "");
        mActualS6.setText(playerData.getResponse().get(0).getActual().getBattingS6() + "");
        mActualWickets.setText(playerData.getResponse().get(0).getActual().getBowlingWicket() + "");
        mActual50.setText(playerData.getResponse().get(0).getActual().getBatting50100() + "");
        mActualMaiden.setText(playerData.getResponse().get(0).getActual().getBowlingMaiden() + "");
        mActualCatch.setText(playerData.getResponse().get(0).getActual().getCatchX() + "");
        mActualDuck.setText(playerData.getResponse().get(0).getActual().getDuck() + "");
        mActualWicketBonus.setText(playerData.getResponse().get(0).getActual().getWicketBonus() + "");
        mActualStrikeRate.setText(playerData.getResponse().get(0).getActual().getStrikeRate() + "");
        mActualEconomyRate.setText(playerData.getResponse().get(0).getActual().getEconomyRate() + "");
        mActualRunOut.setText(playerData.getResponse().get(0).getActual().getRunOutStumping() + "");*/


    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = new BottomSheetDialog(getActivity(), R.style.BottomSheetDialog);
        root = View.inflate(getContext(), R.layout.player_points_bottomsheet, null);
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
        return dialog;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
    }

    public void setUpdateable(PlayerPointCallback updateable) {
        this.callback = updateable;
    }
}
