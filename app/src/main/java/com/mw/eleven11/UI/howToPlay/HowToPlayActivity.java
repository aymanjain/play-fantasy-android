package com.mw.eleven11.UI.howToPlay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.outsideEvents.OutSideEvent;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;

import butterknife.BindView;
import butterknife.OnClick;

public class HowToPlayActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivBck, ivBanner1, ivBanner2, ivBanner3, ivBanner4, ivBanner5, ivBanner6, ivBanner7, ivBanner8, ivBanner9, ivBanner10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
        inIt();
    }

    private void inIt() {
        ivBck = findViewById(R.id.ivBck);
        ivBck.setOnClickListener(this);
        ivBanner1 = findViewById(R.id.ivBanner1);
        ivBanner1.setOnClickListener(this);
        ivBanner2 = findViewById(R.id.ivBanner2);
        ivBanner2.setOnClickListener(this);
        ivBanner3 = findViewById(R.id.ivBanner3);
        ivBanner3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == ivBck) {
            onBackPressed();
        } else if (view == ivBanner1) {

        } else if (view == ivBanner2) {
            OutSideEvent.start(this, AppUtils.getStrFromRes(R.string.how_to_play), Constant.HOW_TO_PLAY_URL);
        } else if (view == ivBanner3) {
            OutSideEvent.start(this, AppUtils.getStrFromRes(R.string.how_to_play_football), Constant.HOW_TO_PLAY_URL_FOOTBALL);
        }
    }
}