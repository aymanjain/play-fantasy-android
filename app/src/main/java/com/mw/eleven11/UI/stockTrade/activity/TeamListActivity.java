package com.mw.eleven11.UI.stockTrade.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.stockTrade.adapter.StockTeamListAdapter;
import com.mw.eleven11.UI.stockTrade.bottom_fragment.BottomSheetFragment;

import java.util.ArrayList;

public class TeamListActivity extends AppCompatActivity {
    RecyclerView recyStockTeam;
    ArrayList<String> data = new ArrayList<>();
    StockTeamListAdapter adapter;
    ImageView backBtn;
    RelativeLayout bottomSheetLayout;
    ImageView imageView;
    BottomSheetFragment bottomSheet;
    CardView btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        inIt();
    }

    private void inIt() {
        recyStockTeam = findViewById(R.id.recyTeamList);
        backBtn = findViewById(R.id.back);
        btnSubmit = findViewById(R.id.btnSubmit);
        bottomSheetLayout = findViewById(R.id.mainLayoutRelative);
        bottomSheet = new BottomSheetFragment();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheet.show(getSupportFragmentManager(), "ModalBottomSheet");
            }
        });

        populateRecyclerView();
    }

    private void populateRecyclerView() {
        data.add("Adani Enterprises");
        data.add("Ashok Leyland");
        data.add("Federal Bank");
        data.add("Canara Bank");

        adapter = new StockTeamListAdapter(data, this);
        recyStockTeam.setAdapter(adapter);


    }
}