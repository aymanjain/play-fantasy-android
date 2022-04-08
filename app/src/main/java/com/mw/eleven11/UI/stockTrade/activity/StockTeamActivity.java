package com.mw.eleven11.UI.stockTrade.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.stockTrade.adapter.StockTeamAdapter;

import java.util.ArrayList;

public class StockTeamActivity extends AppCompatActivity {
    RecyclerView recyStockTeam;
    ArrayList<String> data = new ArrayList<>();
    StockTeamAdapter adapter;
    ImageView backBtn;
    CardView btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_team);
        inIt();
    }

    private void inIt() {
        recyStockTeam = findViewById(R.id.recyTeam);
        backBtn = findViewById(R.id.back);
        btnSubmit = findViewById(R.id.cvContinue);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        populateRecyclerView();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StockTeamActivity.this, TeamListActivity.class);
                startActivity(intent);
            }
        });
        populateRecyclerView();
    }

    private void populateRecyclerView() {
        data.add("Adani Enterprises");
        data.add("Ashok Leyland");
        data.add("Federal Bank");
        data.add("Canara Bank");
        data.add("Federal Bank");
        data.add("Canara Bank");
        data.add("Federal Bank");
        data.add("Canara Bank");
        adapter = new StockTeamAdapter(data, this);
        recyStockTeam.setAdapter(adapter);


    }
}