package com.mw.eleven11.UI.stockTrade.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.stockTrade.adapter.PrizeBreakupAdapter;

import java.util.ArrayList;

public class PrizeBreakupActivity extends AppCompatActivity {
    RecyclerView recyMatches;
    ArrayList<String> data = new ArrayList<>();
    PrizeBreakupAdapter adapter;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_breckup);
        inIt();
    }


    private void inIt() {
        recyMatches = findViewById(R.id.recyPrize);
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
        data.add("Rank 1");
        data.add("Rank 2");
        data.add("Rank 3");
        data.add("Rank 4");
        data.add("Rank 5");
        data.add("Rank 6 To Rank 10");
        data.add("Rank 11 To Rank 15");
        data.add("Rank 16 To Rank 50");
        data.add("Rank 101 To Rank 200");
        data.add("Rank 201 To Rank 400");
        data.add("Rank 401 To Rank 1000");
        data.add("Rank 1001 To Rank 10000");


        adapter = new PrizeBreakupAdapter(data, this);
        recyMatches.setAdapter(adapter);


    }
}