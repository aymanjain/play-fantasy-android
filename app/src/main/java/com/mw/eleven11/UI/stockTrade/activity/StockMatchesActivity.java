package com.mw.eleven11.UI.stockTrade.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.stockTrade.adapter.MatchesAdapter;

import java.util.ArrayList;

public class StockMatchesActivity extends AppCompatActivity {
    RecyclerView recyMatches;
    ArrayList<String> data = new ArrayList<>();
    MatchesAdapter adapter;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_matches2);
        inIt();
    }

    private void inIt() {
        recyMatches = findViewById(R.id.recyMatches);
        backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        populateRecyclerView();
    }

    private void populateRecyclerView() {
        data.add("F4 COW DEC");
        data.add("Free Ka Champ");
        data.add("F4 COW DEC");
        data.add("F6 COW DEC");
        data.add("Free Ka Champ");
        adapter = new MatchesAdapter(data, this);
        recyMatches.setAdapter(adapter);


    }
}