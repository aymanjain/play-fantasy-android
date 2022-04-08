package com.mw.eleven11.UI.previewTeam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.GetDraftPlayerPointOutput;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllPointRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private final ArrayList<GetDraftPlayerPointOutput.DataBean.RecordsBean.PointsDataBean> emptyList;
    private GetDraftPlayerPointOutput mGetDraftPlayerPointOutput;

    public AllPointRecyclerAdapter(Context context, GetDraftPlayerPointOutput mGetDraftPlayerPointOutput, ArrayList<GetDraftPlayerPointOutput.DataBean.RecordsBean.PointsDataBean> pointsData) {
        this.mContext = context;
        this.mGetDraftPlayerPointOutput = mGetDraftPlayerPointOutput;
        this.emptyList = pointsData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new PointsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_auction_player_points_items, viewGroup, false));
        } else {
            return new PointsViewHolderFootball(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_auction_player_points_items_foot, viewGroup, false));

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        if (getItemViewType(i) == 0) {

            PointsViewHolder pointsViewHolder = (PointsViewHolder) viewHolder;
            GetDraftPlayerPointOutput.DataBean.RecordsBean recordsBean = mGetDraftPlayerPointOutput.getData().getRecords().get(i);
            ViewUtils.setImageUrl(pointsViewHolder.mCustomImageViewTeam1, recordsBean.getTeamFlagLocal());
            ViewUtils.setImageUrl(pointsViewHolder.mCustomImageViewTeam2, recordsBean.getTeamFlagVisitor());
            pointsViewHolder.mCtvTeam1Name.setText(recordsBean.getTeamNameShortLocal());
            pointsViewHolder.mCtvTeam2Name.setText(recordsBean.getTeamNameShortVisitor());
            List<GetDraftPlayerPointOutput.DataBean.RecordsBean.PointsDataBean> pointsData = recordsBean.getPointsData();
            if (pointsData.size() != 0) {
                pointsViewHolder.ctv_sp.setText(pointsData.get(0).getCalculatedPoints());
                pointsViewHolder.ctv_ap.setText(pointsData.get(0).getDefinedPoints());
                pointsViewHolder.ctv_trsp.setText(pointsData.get(1).getCalculatedPoints());
                pointsViewHolder.ctv_trap.setText(pointsData.get(1).getDefinedPoints());
                pointsViewHolder.ctv_fsp.setText(pointsData.get(2).getCalculatedPoints());
                pointsViewHolder.ctv_fs_ap.setText(pointsData.get(2).getDefinedPoints());
                pointsViewHolder.ctv_ssp.setText(pointsData.get(3).getCalculatedPoints());
                pointsViewHolder.ctv_ss_ap.setText(pointsData.get(3).getDefinedPoints());
                pointsViewHolder.ctv_srbp.setText(pointsData.get(4).getCalculatedPoints());
                pointsViewHolder.ctv_srb_ap.setText(pointsData.get(4).getDefinedPoints());
                pointsViewHolder.ctv_bbp.setText(pointsData.get(5).getCalculatedPoints());
                pointsViewHolder.ctv_bb_ap.setText(pointsData.get(5).getDefinedPoints());
                pointsViewHolder.ctv_dp.setText(pointsData.get(6).getCalculatedPoints());
                pointsViewHolder.ctv_d_ap.setText(pointsData.get(6).getDefinedPoints());
                pointsViewHolder.ctv_wtp.setText(pointsData.get(7).getCalculatedPoints());
                pointsViewHolder.ctv_wt_ap.setText(pointsData.get(7).getDefinedPoints());
                pointsViewHolder.ctv_mobp.setText(pointsData.get(8).getCalculatedPoints());
                pointsViewHolder.ctv_mob_ap.setText(pointsData.get(8).getDefinedPoints());
                pointsViewHolder.ctv_ebp.setText(pointsData.get(9).getCalculatedPoints());
                pointsViewHolder.ctv_eb_ap.setText(pointsData.get(9).getDefinedPoints());
                pointsViewHolder.ctv_bow_bp.setText(pointsData.get(10).getCalculatedPoints());
                pointsViewHolder.ctv_bow_ap.setText(pointsData.get(10).getDefinedPoints());
                pointsViewHolder.ctv_trop.setText(pointsData.get(11).getCalculatedPoints());
                pointsViewHolder.ctv_tro_ap.setText(pointsData.get(11).getDefinedPoints());
                pointsViewHolder.ctv_stump_p.setText(pointsData.get(12).getCalculatedPoints());
                pointsViewHolder.ctv_stump_ap.setText(pointsData.get(12).getDefinedPoints());
                pointsViewHolder.ctv_cp.setText(pointsData.get(13).getCalculatedPoints());
                pointsViewHolder.ctv_cap.setText(pointsData.get(13).getDefinedPoints());
                if (pointsData.size() > 15) {
                    pointsViewHolder.ctv_dvp.setText(pointsData.get(14).getDefinedPoints());
                    pointsViewHolder.ctv_dbp.setText(pointsData.get(14).getCalculatedPoints());
                    pointsViewHolder.ctv_nbp.setText(pointsData.get(15).getDefinedPoints());
                    pointsViewHolder.ctv_np.setText(pointsData.get(15).getCalculatedPoints());
                    pointsViewHolder.ctv_wbp.setText(pointsData.get(16).getDefinedPoints());
                    pointsViewHolder.ctv_cwbp.setText(pointsData.get(16).getCalculatedPoints());
                }
            } else {
                pointsViewHolder.ctv_sp.setText("0");
                pointsViewHolder.ctv_trsp.setText("0");
                pointsViewHolder.ctv_fsp.setText("0");
                pointsViewHolder.ctv_ssp.setText("0");
                pointsViewHolder.ctv_srbp.setText("0");
                pointsViewHolder.ctv_bbp.setText("0");
                pointsViewHolder.ctv_dp.setText("0");
                pointsViewHolder.ctv_wtp.setText("0");
                pointsViewHolder.ctv_mobp.setText("0");
                pointsViewHolder.ctv_ebp.setText("0");
                pointsViewHolder.ctv_bow_bp.setText("0");
                pointsViewHolder.ctv_trop.setText("0");
                pointsViewHolder.ctv_stump_p.setText("0");
                pointsViewHolder.ctv_cp.setText("0");

                pointsViewHolder.ctv_ap.setText("0");
                pointsViewHolder.ctv_trap.setText("0");
                pointsViewHolder.ctv_fs_ap.setText("0");
                pointsViewHolder.ctv_ss_ap.setText("0");
                pointsViewHolder.ctv_srb_ap.setText("0");
                pointsViewHolder.ctv_bb_ap.setText("0");
                pointsViewHolder.ctv_d_ap.setText("0");
                pointsViewHolder.ctv_wt_ap.setText("0");
                pointsViewHolder.ctv_mob_ap.setText("0");
                pointsViewHolder.ctv_eb_ap.setText("0");
                pointsViewHolder.ctv_bow_ap.setText("0");
                pointsViewHolder.ctv_tro_ap.setText("0");
                pointsViewHolder.ctv_stump_ap.setText("0");
                pointsViewHolder.ctv_cap.setText("0");
                pointsViewHolder.ctv_dvp.setText("0");
                pointsViewHolder.ctv_dbp.setText("0");
                pointsViewHolder.ctv_wbp.setText("0");
                pointsViewHolder.ctv_cwbp.setText("0");
                pointsViewHolder.ctv_np.setText("0");
                pointsViewHolder.ctv_nbp.setText("0");
            }

        } else {
            PointsViewHolderFootball pointsViewHolder = (PointsViewHolderFootball) viewHolder;
            GetDraftPlayerPointOutput.DataBean.RecordsBean recordsBean = mGetDraftPlayerPointOutput.getData().getRecords().get(i);
            ViewUtils.setImageUrl(pointsViewHolder.mCustomImageViewTeam1, recordsBean.getTeamFlagLocal());
            ViewUtils.setImageUrl(pointsViewHolder.mCustomImageViewTeam2, recordsBean.getTeamFlagVisitor());
            pointsViewHolder.mCtvTeam1Name.setText(recordsBean.getTeamNameShortLocal());
            pointsViewHolder.mCtvTeam2Name.setText(recordsBean.getTeamNameShortVisitor());
            List<GetDraftPlayerPointOutput.DataBean.RecordsBean.PointsDataBean> pointsData = recordsBean.getPointsData();
            if (pointsData.size() != 0) {

                for (GetDraftPlayerPointOutput.DataBean.RecordsBean.PointsDataBean pointsDatum : pointsData) {

                    switch (pointsDatum.getPointsTypeGUID()) {
                        case "StatringXI":
                            // SB
                            pointsViewHolder.ctv_sp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "Played55More":
                            //PT
                            pointsViewHolder.ctv_played_more.setText("Played More");
                            pointsViewHolder.ctv_trsp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_trap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "Played55Less":
                            pointsViewHolder.ctv_played_more.setText("Played Less");
                            pointsViewHolder.ctv_trsp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_trap.setText(pointsDatum.getDefinedPoints());
                            break;

                        case "RedCard":
                            //RC
                            pointsViewHolder.ctv_fsp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_fs_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "YellowCard":
                            //YC
                            pointsViewHolder.ctv_ssp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_ss_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "Every2ShotsOnGoal":
                            //E2SG
                            pointsViewHolder.ctv_bbp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_bb_ap.setText(pointsDatum.getDefinedPoints());
                            break;

                        case "EveryGoalScoredForward":
                            //EG
                            pointsViewHolder.ctv_goal_type.setText("Every goal scored Forward");
                            pointsViewHolder.ctv_dp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_d_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "EveryGoalScoredGKDefender":
                            //EG
                            pointsViewHolder.ctv_goal_type.setText("Every goal scored GK/Defender");
                            pointsViewHolder.ctv_dp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_d_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "EveryGoalScoredMidfielder":
                            //EG
                            pointsViewHolder.ctv_goal_type.setText("Every goal scored Midfielder");
                            pointsViewHolder.ctv_dp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_d_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "EveryAssist":
                            //EGA
                            pointsViewHolder.ctv_wtp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_wt_ap.setText(pointsDatum.getDefinedPoints());
                            break;

                        case "Every10PassesCompleted":
                            //EPC10
                            pointsViewHolder.ctv_mobp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_mob_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "Every2GoalsConceded":
                            //GC
                            pointsViewHolder.ctv_ebp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_eb_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "EveryOwnGoal":
                            //OG
                            pointsViewHolder.ctv_bow_bp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_bow_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "EveryPenaltyMissed":
                            //PM
                            pointsViewHolder.ctv_trop.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_tro_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "Every3ShotsSavedGK":
                            //SS
                            pointsViewHolder.ctv_stump_p.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_stump_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "Every3TacklesMade":
                            //TM
                            pointsViewHolder.ctv_cp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_cap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "CleanSheetGKDefender":
                            //CT
                            pointsViewHolder.ctv_clean_sheet.setText("Clean sheet GK/Defender");
                            pointsViewHolder.ctv_srbp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_srb_ap.setText(pointsDatum.getDefinedPoints());
                        case "CleanSheetMidfielder":
                            //CT
                            pointsViewHolder.ctv_clean_sheet.setText("Clean sheet Midfielder");
                            pointsViewHolder.ctv_srbp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_srb_ap.setText(pointsDatum.getDefinedPoints());
                            break;
                        case "EveryPenaltySavedGK":
                            pointsViewHolder.ctv_dbp.setText(pointsDatum.getCalculatedPoints());
                            pointsViewHolder.ctv_dvp.setText(pointsDatum.getDefinedPoints());
                            break;

                    }
                }
            } else {
                pointsViewHolder.ctv_played_more.setText("Played More");

                pointsViewHolder.ctv_sp.setText("0");
                pointsViewHolder.ctv_trsp.setText("0");
                pointsViewHolder.ctv_fsp.setText("0");
                pointsViewHolder.ctv_ssp.setText("0");
                pointsViewHolder.ctv_srbp.setText("0");
                pointsViewHolder.ctv_bbp.setText("0");
                pointsViewHolder.ctv_dp.setText("0");
                pointsViewHolder.ctv_wtp.setText("0");
                pointsViewHolder.ctv_mobp.setText("0");
                pointsViewHolder.ctv_ebp.setText("0");
                pointsViewHolder.ctv_bow_bp.setText("0");
                pointsViewHolder.ctv_trop.setText("0");
                pointsViewHolder.ctv_stump_p.setText("0");
                pointsViewHolder.ctv_cp.setText("0");

                pointsViewHolder.ctv_ap.setText("0");
                pointsViewHolder.ctv_trap.setText("0");
                pointsViewHolder.ctv_fs_ap.setText("0");
                pointsViewHolder.ctv_ss_ap.setText("0");
                pointsViewHolder.ctv_srb_ap.setText("0");
                pointsViewHolder.ctv_bb_ap.setText("0");
                pointsViewHolder.ctv_d_ap.setText("0");
                pointsViewHolder.ctv_wt_ap.setText("0");
                pointsViewHolder.ctv_mob_ap.setText("0");
                pointsViewHolder.ctv_eb_ap.setText("0");
                pointsViewHolder.ctv_bow_ap.setText("0");
                pointsViewHolder.ctv_tro_ap.setText("0");
                pointsViewHolder.ctv_stump_ap.setText("0");
                pointsViewHolder.ctv_cap.setText("0");
                pointsViewHolder.ctv_dvp.setText("0");
                pointsViewHolder.ctv_dbp.setText("0");

            }
        }

    }

    @Override
    public int getItemCount() {
        return mGetDraftPlayerPointOutput.getData().getRecords().size();
    }

    @Override
    public int getItemViewType(int position) {
        if (AppSession.getInstance().getGameType() == 1) {
            return 0;
        } else {
            return 1;
        }
    }

    public class PointsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.civ_team1)
        CustomImageView mCustomImageViewTeam1;

        @BindView(R.id.civ_team2)
        CustomImageView mCustomImageViewTeam2;


        @BindView(R.id.ctv_team1)
        CustomTextView mCtvTeam1Name;


        @BindView(R.id.ctv_team2)
        CustomTextView mCtvTeam2Name;


        @BindView(R.id.ctv_sp)
        CustomTextView ctv_sp;

        @BindView(R.id.ctv_ap)
        CustomTextView ctv_ap;

        @BindView(R.id.ctv_trsp)
        CustomTextView ctv_trsp;

        @BindView(R.id.ctv_trap)
        CustomTextView ctv_trap;


        @BindView(R.id.ctv_fsp)
        CustomTextView ctv_fsp;

        @BindView(R.id.ctv_fs_ap)
        CustomTextView ctv_fs_ap;


        @BindView(R.id.ctv_ssp)
        CustomTextView ctv_ssp;

        @BindView(R.id.ctv_ss_ap)
        CustomTextView ctv_ss_ap;


        @BindView(R.id.ctv_srbp)
        CustomTextView ctv_srbp;

        @BindView(R.id.ctv_srb_ap)
        CustomTextView ctv_srb_ap;


        @BindView(R.id.ctv_bbp)
        CustomTextView ctv_bbp;

        @BindView(R.id.ctv_bb_ap)
        CustomTextView ctv_bb_ap;


        @BindView(R.id.ctv_dp)
        CustomTextView ctv_dp;

        @BindView(R.id.ctv_d_ap)
        CustomTextView ctv_d_ap;


        @BindView(R.id.ctv_wtp)
        CustomTextView ctv_wtp;

        @BindView(R.id.ctv_wt_ap)
        CustomTextView ctv_wt_ap;


        @BindView(R.id.ctv_mobp)
        CustomTextView ctv_mobp;


        @BindView(R.id.ctv_mob_ap)
        CustomTextView ctv_mob_ap;

        @BindView(R.id.ctv_ebp)
        CustomTextView ctv_ebp;

        @BindView(R.id.ctv_eb_ap)
        CustomTextView ctv_eb_ap;


        @BindView(R.id.ctv_bow_bp)
        CustomTextView ctv_bow_bp;

        @BindView(R.id.ctv_bow_ap)
        CustomTextView ctv_bow_ap;

        @BindView(R.id.ctv_trop)
        CustomTextView ctv_trop;


        @BindView(R.id.ctv_tro_ap)
        CustomTextView ctv_tro_ap;

        @BindView(R.id.ctv_stump_p)
        CustomTextView ctv_stump_p;

        @BindView(R.id.ctv_stump_ap)
        CustomTextView ctv_stump_ap;

        @BindView(R.id.ctv_cp)
        CustomTextView ctv_cp;

        @BindView(R.id.ctv_cap)
        CustomTextView ctv_cap;


        @BindView(R.id.ctv_dvp)
        CustomTextView ctv_dvp;

        @BindView(R.id.ctv_dbp)
        CustomTextView ctv_dbp;


        @BindView(R.id.ctv_nbp)
        CustomTextView ctv_nbp;

        @BindView(R.id.ctv_np)
        CustomTextView ctv_np;


        @BindView(R.id.ctv_wbp)
        CustomTextView ctv_wbp;

        @BindView(R.id.ctv_cwbp)
        CustomTextView ctv_cwbp;


        public PointsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class PointsViewHolderFootball extends RecyclerView.ViewHolder {

        @BindView(R.id.civ_team1)
        CustomImageView mCustomImageViewTeam1;

        @BindView(R.id.civ_team2)
        CustomImageView mCustomImageViewTeam2;


        @BindView(R.id.ctv_team1)
        CustomTextView mCtvTeam1Name;


        @BindView(R.id.ctv_team2)
        CustomTextView mCtvTeam2Name;

        @BindView(R.id.ctv_played_more)
        CustomTextView ctv_played_more;


        @BindView(R.id.ctv_sp)
        CustomTextView ctv_sp;

        @BindView(R.id.ctv_ap)
        CustomTextView ctv_ap;

        @BindView(R.id.ctv_trsp)
        CustomTextView ctv_trsp;

        @BindView(R.id.ctv_trap)
        CustomTextView ctv_trap;


        @BindView(R.id.ctv_fsp)
        CustomTextView ctv_fsp;

        @BindView(R.id.ctv_fs_ap)
        CustomTextView ctv_fs_ap;


        @BindView(R.id.ctv_ssp)
        CustomTextView ctv_ssp;

        @BindView(R.id.ctv_ss_ap)
        CustomTextView ctv_ss_ap;


        @BindView(R.id.ctv_srbp)
        CustomTextView ctv_srbp;

        @BindView(R.id.ctv_srb_ap)
        CustomTextView ctv_srb_ap;


        @BindView(R.id.ctv_bbp)
        CustomTextView ctv_bbp;

        @BindView(R.id.ctv_bb_ap)
        CustomTextView ctv_bb_ap;


        @BindView(R.id.ctv_dp)
        CustomTextView ctv_dp;

        @BindView(R.id.ctv_d_ap)
        CustomTextView ctv_d_ap;


        @BindView(R.id.ctv_wtp)
        CustomTextView ctv_wtp;

        @BindView(R.id.ctv_wt_ap)
        CustomTextView ctv_wt_ap;


        @BindView(R.id.ctv_mobp)
        CustomTextView ctv_mobp;


        @BindView(R.id.ctv_mob_ap)
        CustomTextView ctv_mob_ap;

        @BindView(R.id.ctv_ebp)
        CustomTextView ctv_ebp;

        @BindView(R.id.ctv_eb_ap)
        CustomTextView ctv_eb_ap;


        @BindView(R.id.ctv_bow_bp)
        CustomTextView ctv_bow_bp;

        @BindView(R.id.ctv_bow_ap)
        CustomTextView ctv_bow_ap;

        @BindView(R.id.ctv_trop)
        CustomTextView ctv_trop;


        @BindView(R.id.ctv_tro_ap)
        CustomTextView ctv_tro_ap;

        @BindView(R.id.ctv_stump_p)
        CustomTextView ctv_stump_p;

        @BindView(R.id.ctv_stump_ap)
        CustomTextView ctv_stump_ap;

        @BindView(R.id.ctv_cp)
        CustomTextView ctv_cp;

        @BindView(R.id.ctv_cap)
        CustomTextView ctv_cap;


        @BindView(R.id.ctv_dvp)
        CustomTextView ctv_dvp;

        @BindView(R.id.ctv_dbp)
        CustomTextView ctv_dbp;

        @BindView(R.id.ctv_goal_type)
        CustomTextView ctv_goal_type;

        @BindView(R.id.ctv_clean_sheet)
        CustomTextView ctv_clean_sheet;


        public PointsViewHolderFootball(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
