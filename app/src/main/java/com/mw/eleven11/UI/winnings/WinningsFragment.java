package com.mw.eleven11.UI.winnings;

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

import com.mw.eleven11.R;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;


/**
 * Created by Obaro on 01/08/2016.
 */
public class WinningsFragment extends BottomSheetDialogFragment {

    View root;
    WinnersCallback updateable;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.total_winningAmount)
    CustomTextView total_winningAmount;


    @BindView(R.id.total_winning)
    CustomTextView total_winning;

    @BindView(R.id.note)
    CustomTextView note;
    WinningsAdapter adapter;
    List<WinnersRankBean> beans;
    private Unbinder unbinder;
    private BottomSheetBehavior mBehavior;
    private OnItemClickListener.OnItemClickCallback onPayItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {

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

    public void setUpdateable(WinnersCallback updateable) {
        this.updateable = updateable;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = new BottomSheetDialog(updateable.getContext(), R.style.BottomSheetDialog);
        root = View.inflate(getContext(), R.layout.winnings_fragment, null);
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

        root = inflater.inflate(R.layout.winnings_fragment, container);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mBehavior.setPeekHeight(450);
        setView();
        beans = updateable.getBean();

        if (beans != null) {
            if (updateable.getTotalWiningAmount()!=null) {
                total_winning.setVisibility(View.VISIBLE);
                total_winningAmount.setVisibility(View.VISIBLE);
                note.setVisibility(View.VISIBLE);

                if (updateable.getWinningType()!= null&&updateable.getWinningType().equalsIgnoreCase("Free Join Contest")){
                    total_winningAmount.setText(  "Bonus " + updateable.getTotalWiningAmount());
                }else {
                    total_winningAmount.setText(AppUtils.getStrFromRes(R.string.price_unit) + "" + updateable.getTotalWiningAmount());

                }
//                total_winningAmount.setText(AppUtils.get StrFromRes(R.string.price_unit) + updateable.getTotalWiningAmount());
            }else {
                total_winning.setVisibility(View.GONE);
                total_winningAmount.setVisibility(View.GONE);
                note.setVisibility(View.GONE);
            }
            adapter = new WinningsAdapter(R.layout.list_item_winnings, updateable.getContext(), beans, onPayItemClickCallback,updateable.getWinningType());
            recyclerView.setAdapter(adapter);

        }
    }

    private void setView() {
        //set layout manager into recyclerView
        recyclerView.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
    }

}
