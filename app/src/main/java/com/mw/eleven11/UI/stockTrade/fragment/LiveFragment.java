package com.mw.eleven11.UI.stockTrade.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.stockTrade.adapter.LiveAdapter;
import com.mw.eleven11.UI.stockTrade.adapter.MatchesAdapter;

import java.util.ArrayList;

public class LiveFragment extends Fragment {
    View root;
    RecyclerView recyMatches;
    ArrayList<String> data ;
    LiveAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_live, container, false);
        inIt();
        return root;
    }



    private void inIt() {
        recyMatches = root.findViewById(R.id.recyMatchesLive);
        data = new ArrayList<>();
        populateRecyclerView();
    }

    private void populateRecyclerView() {
        data.add("F4 COW DEC");
        data.add("Free Ka Champ");
        data.add("F4 COW DEC");
        data.add("F6 COW DEC");
        data.add("Free Ka Champ");
        adapter = new LiveAdapter(data, getContext());
        recyMatches.setAdapter(adapter);


    }

}