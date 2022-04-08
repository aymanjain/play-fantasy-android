package com.mw.eleven11.UI.winnerNumberSelection;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.WinBreakupOutPut;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;
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
public class WinBreakupFragment extends BottomSheetDialogFragment {

    View root;
    WinBreakupCallback updateable;
    @Nullable
    @BindView(R.id.chooseTotalWinner)
    CustomTextView choose_total_winner;
    @Nullable
    @BindView(R.id.linout)
    LinearLayout linout;
    WinBreakupNumberAdapter adapter;
    List<WinBreakupOutPut.DataBean> beans;
    private Unbinder unbinder;
    private BottomSheetBehavior mBehavior;
    private OnItemClickListener.OnItemClickCallback onPayItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

            Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
        }
    };
    private OnItemClickListener.OnItemClickCallback onClickItem = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

            dismiss();

            updateable.close(position);


        }
    };

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @OnClick(R.id.ctv_close)
    @Optional
    public void clear(View view) {
        dismiss();

    }

    public void setUpdateable(WinBreakupCallback updateable) {
        this.updateable = updateable;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = new BottomSheetDialog(updateable.getContext(), R.style.BottomSheetDialog);
        root = View.inflate(getContext(), R.layout.win_breakup_fragment, null);
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.win_breakup_fragment, container);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mBehavior.setPeekHeight(450);

        beans = updateable.getBean();

        Log.d("breakuPointdata", AppUtils.gsonToJSON(beans));

       /* if (beans!=null){
            total_winningAmount.setText(AppUtils.getStrFromRes(R.string.price_unit)+updateable.getTotalWiningAmount());
            //adapter = new WinBreakupNumberAdapter(R.layout.item_winning_number, updateable.getContext(), beans.get(0), onPayItemClickCallback);
            recyclerView.setAdapter(adapter);

        }*/

        for (int i = 0; i < beans.size(); i++) {
            LayoutInflater inflater = LayoutInflater.from(getContext());


            View inflatedLayout = inflater.inflate(R.layout.item_winbreakup, (ViewGroup) view, false);

            RecyclerView mRecyclerView = (RecyclerView) inflatedLayout.findViewById(R.id.recycler_view);
            RadioButton mRadioButton = (RadioButton) inflatedLayout.findViewById(R.id.winnersRedio);
            final CardView mCardView = (CardView) inflatedLayout.findViewById(R.id.cardView);


           // mRecyclerView.addItemDecoration(new ItemOffsetDecoration(getContext(), R.dimen.item_offset));
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            List<WinBreakupOutPut.DataBean.WinnersBean> mWinnersBeanList = new ArrayList<>();


            if (i == 0) {
                mRadioButton.setText(beans.get(i).getNoOfWinners() + " " + AppUtils.getStrFromRes(R.string.winners) + " " +
                        AppUtils.getStrFromRes(R.string.recommended));
            } else {
                mRadioButton.setText(beans.get(i).getNoOfWinners() + " " + AppUtils.getStrFromRes(R.string.winners));
            }


            mRecyclerView.setTag(String.valueOf(i));

            adapter = new WinBreakupNumberAdapter(R.layout.item_winning_number_new, getContext(), beans.get(i).getWinners(), onPayItemClickCallback);
            mRecyclerView.setAdapter(adapter);


            mRadioButton.setOnClickListener(new OnItemClickListener(i, onClickItem));

            mRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    mCardView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.border_green_bg_white));
                }
            });

            if (updateable.getIndex() == i) {
                mCardView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.border_green_bg_white));
                mRadioButton.setChecked(true);
            }


            linout.addView(inflatedLayout);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
    }

}
