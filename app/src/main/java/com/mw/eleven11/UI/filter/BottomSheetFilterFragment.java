package com.mw.eleven11.UI.filter;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.ResponseFilter;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;


/**
 * Created by Obaro on 01/08/2016.
 */
public class BottomSheetFilterFragment extends BottomSheetDialogFragment {

    View root;
    ContestSearchResultFilters updateable;
    @BindView(R.id.recycler_view_pay)
    RecyclerView recyclerViewPay;
    @BindView(R.id.recycler_view_win)
    RecyclerView recyclerViewWin;
    @BindView(R.id.recycler_view_size)
    RecyclerView recyclerViewSize;
    @BindView(R.id.recycler_contain_type)
    RecyclerView recycler_contain_type;
    BottomFilterAdapter payFilterAdapter, winFilterAdapter, containTypeFilterAdapter, sizeFilterAdapter;
    ResponseFilter filter = null;
    private Unbinder unbinder;
    private BottomSheetBehavior mBehavior;
    private OnItemClickListener.OnItemClickCallback onPayItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            payFilterAdapter.selectSingleItem(position);
        }
    };
    private OnItemClickListener.OnItemClickCallback onWinItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            winFilterAdapter.selectSingleItem(position);
        }
    };
    private OnItemClickListener.OnItemClickCallback onSizeItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            sizeFilterAdapter.selectSingleItem(position);
        }
    };
    private OnItemClickListener.OnItemClickCallback onContaineTypeItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            containTypeFilterAdapter.selectSingleItem(position);
        }
    };

    @OnClick(R.id.ctv_next)
    @Optional
    public void search(View view) {
        if (updateable != null) {
            if (isFilterSelected()) {
                AppSession.getInstance().setFilterSession(filter);
                updateable.search();
                dismiss();
            }else {
                Toast.makeText(getActivity(), "Select at-least one filter", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public boolean isFilterSelected() {
        for (int i = 0; i < filter.getPay().size(); i++) {
            if (filter.getPay().get(i).isSelected()) {
                return true;
            }
        }
        for (int i = 0; i < filter.getWin().size(); i++) {
            if (filter.getWin().get(i).isSelected()) {
                return true;
            }
        }

        for (int i = 0; i < filter.getContets_type().size(); i++) {
            if (filter.getContets_type().get(i).isSelected()) {
                return true;
            }
        }

        for (int i = 0; i < filter.getSize().size(); i++) {
            if (filter.getSize().get(i).isSelected()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @OnClick(R.id.ctv_reset)
    @Optional
    public void reset(View view) {
        AppSession.getInstance().clearFilterSession();
        setFilters();
        updateable.reSetFilter();
    }

    @OnClick(R.id.ctv_close)
    @Optional
    public void clear(View view) {
        dismiss();
    }

    public void setUpdateable(ContestSearchResultFilters updateable) {
        this.updateable = updateable;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        BottomSheetDialog dialog = new BottomSheetDialog(updateable.getContext(), R.style.BottomSheetDialog);
        root = View.inflate(getContext(), R.layout.contest_filter_fragment, null);
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

        root = inflater.inflate(R.layout.contest_filter_fragment, container);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mBehavior.setPeekHeight(450);
        setView();
        setFilters();
    }

    private void setView() {
        //set layout manager into recyclerView
        recyclerViewPay.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset));
        recyclerViewPay.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        recyclerViewWin.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset));
        recyclerViewWin.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        recycler_contain_type.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset));
        recycler_contain_type.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        recyclerViewSize.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.dimen.item_offset));
        recyclerViewSize.setLayoutManager(new GridLayoutManager(getActivity(), 2));


    }

    public void setFilters() {
        filter = AppSession.getInstance().getFilterSession();
        if (filter != null) {
            payFilterAdapter = new BottomFilterAdapter(R.layout.list_item_filter, updateable.getContext(), filter.getPay(), onPayItemClickCallback);
            recyclerViewPay.setAdapter(payFilterAdapter);

            winFilterAdapter = new BottomFilterAdapter(R.layout.list_item_filter, updateable.getContext(), filter.getWin(), onWinItemClickCallback);
            recyclerViewWin.setAdapter(winFilterAdapter);

            containTypeFilterAdapter = new BottomFilterAdapter(R.layout.list_item_filter, updateable.getContext(), filter.getContets_type(), onContaineTypeItemClickCallback);
            recycler_contain_type.setAdapter(containTypeFilterAdapter);

            sizeFilterAdapter = new BottomFilterAdapter(R.layout.list_item_filter, updateable.getContext(), filter.getSize(), onSizeItemClickCallback);
            recyclerViewSize.setAdapter(sizeFilterAdapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
    }

}
