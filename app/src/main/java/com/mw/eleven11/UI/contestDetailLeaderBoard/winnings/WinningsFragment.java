package com.mw.eleven11.UI.contestDetailLeaderBoard.winnings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.winnings.WinnersRankBean;
import com.mw.eleven11.UI.winnings.WinningsAdapter;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.beanOutput.ContestDetailOutput;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.ItemOffsetDecoration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WinningsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WinningsFragment extends BaseFragment {

    private ContestDetailOutput.DataBean contestDetail;

    @BindView(R.id.customTextViewFreeRank)
    CustomTextView customTextViewFreeRank;

    @BindView(R.id.customTextViewInfo)
    CustomTextView customTextViewInfo;

    @BindView(R.id.linearLayoutFreeContestInfoRoot)
    View linearLayoutFreeContestInfoRoot;

    @BindView(R.id.linearLayoutPaidWinnignRoot)
    View linearLayoutPaidWinnignRoot;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @BindView(R.id.note)
    CustomTextView note;

    public static WinningsFragment newInstance(ContestDetailOutput.DataBean contestDetail) {
        WinningsFragment fragment = new WinningsFragment();
        Bundle args = new Bundle();
        args.putSerializable("contestDetail", contestDetail);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            contestDetail = (ContestDetailOutput.DataBean) getArguments().get("contestDetail");
        }
    }


    @Override
    public int getLayout() {
        return R.layout.fragment_winnings;
    }

    @Override
    public void init() {
        setData();
    }

    private void setData() {


        boolean isPaid = contestDetail.getIsPaid().equals("Yes");
        boolean isSmartPool = contestDetail.getSmartPool().equals("Yes");
        boolean isInfinitePool = contestDetail.getContestSize().equals("Unlimited");
        int noOfWinners = Integer.parseInt(contestDetail.getNoOfWinners().trim());

        if (!isPaid) {
            linearLayoutFreeContestInfoRoot.setVisibility(View.VISIBLE);
            if (isInfinitePool) {
                if (noOfWinners > 1) {
                    customTextViewFreeRank.setText("Rank 1-" + noOfWinners);
                } else if (noOfWinners == 1) {
                    customTextViewFreeRank.setText("Rank 1");
                } else {
                    customTextViewFreeRank.setText("Rank " + contestDetail.getWinningRatio() + "%");
                }
            } else {
                if (noOfWinners > 1) {
                    customTextViewFreeRank.setText("Rank 1-" + noOfWinners);
                } else {
                    customTextViewFreeRank.setText("Rank 1");
                }
            }
        } else {
            if (isInfinitePool && noOfWinners == 0) {
                linearLayoutFreeContestInfoRoot.setVisibility(View.VISIBLE);
                customTextViewFreeRank.setText("Rank - Top " + contestDetail.getWinningRatio() + "% Teams");
                customTextViewInfo.setText("Prize Pool - "+contestDetail.getWinUpTo()+"X Winnings");
            } else {
                linearLayoutPaidWinnignRoot.setVisibility(View.VISIBLE);
                List<WinnersRankBean> rankList = new ArrayList<>();
                for (int i = 0; i < contestDetail.getCustomizeWinning().size(); i++) {
                    ContestDetailOutput.DataBean.CustomizeWinningBean customizeWinningBean = contestDetail.getCustomizeWinning().get(i);
                    WinnersRankBean mWinnersRankBean = new WinnersRankBean();
                    mWinnersRankBean.setFrom(customizeWinningBean.getFrom());
                    mWinnersRankBean.setTo(customizeWinningBean.getTo());
                    if (contestDetail.getSmartPool().equalsIgnoreCase("Yes")) {
                        mWinnersRankBean.setProductName(customizeWinningBean.getProductName());
                        mWinnersRankBean.setProductUrl(customizeWinningBean.getProductUrl());
                    } else {
                        mWinnersRankBean.setPercent(customizeWinningBean.getPercent());
                        mWinnersRankBean.setWinningAmount(customizeWinningBean.getWinningAmount());
                    }
                    rankList.add(i, mWinnersRankBean);
                }
                recyclerView.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset));
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(new WinningsAdapter(R.layout.list_item_winnings,
                        null,
                        rankList,
                        null,
                        contestDetail.getWinningType()));
            }
        }
    }
}