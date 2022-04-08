package com.mw.eleven11.UI.stockTrade.bottom_fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mw.eleven11.R;

public class BottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    View root;
    ImageView ivClear;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
        root.setBackgroundResource(R.drawable.bottom_dialog);
        inIt();
        return root;
    }
    private void inIt() {
        ivClear = root.findViewById(R.id.ivClear);
        ivClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }

        });
    }

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new BottomSheetDialog(requireContext(), android.R.style.Theme_Translucent_NoTitleBar); // To have transparent dialog window background.
    }

    @Override
    public void onClick(View view) {

    }
}