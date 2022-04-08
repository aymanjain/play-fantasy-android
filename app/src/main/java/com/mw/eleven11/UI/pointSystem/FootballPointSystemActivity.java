package com.mw.eleven11.UI.pointSystem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.PointsSystem;
import com.mw.eleven11.beanOutput.PointsList;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class FootballPointSystemActivity extends BaseActivity implements PointsFragmentView {

    @BindView(R.id.recycler_attack)
    RecyclerView mRecyclerView_attack;

    @BindView(R.id.attack_expand)
    ImageView attack_expand;


    @BindView(R.id.recycler_defense)
    RecyclerView mRecyclerView_defense;

    @BindView(R.id.defense_expand)
    ImageView defense_expand;


    @BindView(R.id.recycler_iv_penalties)
    RecyclerView mRecyclerView_penalties;

    @BindView(R.id.iv_penalties_expand)
    ImageView penalties_expand;


    @BindView(R.id.recycler_playingTime)
    RecyclerView recycler_playingTime;

    @BindView(R.id.attack_playingTime)
    ImageView attack_playingTime;


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.title)
    CustomTextView mCustomTextViewTitle;

    private Context mContext;
    private LinearLayoutManager lm_attack, lm_defence, lm_pentalties;
    private PointCricketPresenterImpl presenterImpl;
    private PointsAdapter adapterAttack, adapterDefense, adapterPentalties;
    private ProgressDialog mProgressDialog;
    private LinearLayoutManager lm_playTime;
    private PointsAdapter adapterPlaytime;

    @Override
    public int getLayout() {
        return R.layout.activity_football_point_system;
    }


    public static void start(Context context) {
        Intent starter = new Intent(context, FootballPointSystemActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }


    @OnClick(R.id.playingTime)
    void set_playingTime_expand() {
        if (recycler_playingTime.getVisibility() == View.VISIBLE) {
            recycler_playingTime.setVisibility(View.GONE);
            attack_playingTime.setRotation(attack_playingTime.getRotation() - 180);
        } else {
            if (recycler_playingTime.getVisibility() == View.VISIBLE) {
                recycler_playingTime.setVisibility(View.GONE);
                attack_playingTime.setRotation(attack_playingTime.getRotation() - 180);
            } else if (mRecyclerView_attack.getVisibility() == View.VISIBLE) {
                mRecyclerView_attack.setVisibility(View.GONE);
                attack_expand.setRotation(attack_expand.getRotation() - 180);
            } else if (mRecyclerView_defense.getVisibility() == View.VISIBLE) {
                mRecyclerView_defense.setVisibility(View.GONE);
                defense_expand.setRotation(defense_expand.getRotation() - 180);
            } else if (mRecyclerView_penalties.getVisibility() == View.VISIBLE) {
                mRecyclerView_penalties.setVisibility(View.GONE);
                penalties_expand.setRotation(penalties_expand.getRotation() - 180);
            }
            recycler_playingTime.setVisibility(View.VISIBLE);
            attack_playingTime.setRotation(attack_playingTime.getRotation() + 180);
        }
    }


    @OnClick(R.id.attack)
    void setAttack_expand() {
        if (mRecyclerView_attack.getVisibility() == View.VISIBLE) {
            mRecyclerView_attack.setVisibility(View.GONE);
            attack_expand.setRotation(attack_expand.getRotation() - 180);
        } else {
            if (recycler_playingTime.getVisibility() == View.VISIBLE) {
                recycler_playingTime.setVisibility(View.GONE);
                attack_playingTime.setRotation(attack_playingTime.getRotation() - 180);
            } else if (mRecyclerView_attack.getVisibility() == View.VISIBLE) {
                mRecyclerView_attack.setVisibility(View.GONE);
                attack_expand.setRotation(attack_expand.getRotation() - 180);
            } else if (mRecyclerView_defense.getVisibility() == View.VISIBLE) {
                mRecyclerView_defense.setVisibility(View.GONE);
                defense_expand.setRotation(defense_expand.getRotation() - 180);
            } else if (mRecyclerView_penalties.getVisibility() == View.VISIBLE) {
                mRecyclerView_penalties.setVisibility(View.GONE);
                penalties_expand.setRotation(penalties_expand.getRotation() - 180);
            }
            mRecyclerView_attack.setVisibility(View.VISIBLE);
            attack_expand.setRotation(attack_expand.getRotation() + 180);
        }
    }


    @OnClick(R.id.defense)
    void setDefense_expand() {
        if (mRecyclerView_defense.getVisibility() == View.VISIBLE) {
            mRecyclerView_defense.setVisibility(View.GONE);
            defense_expand.setRotation(defense_expand.getRotation() - 180);
        } else {
            if (recycler_playingTime.getVisibility() == View.VISIBLE) {
                recycler_playingTime.setVisibility(View.GONE);
                attack_playingTime.setRotation(attack_playingTime.getRotation() - 180);
            } else if (mRecyclerView_attack.getVisibility() == View.VISIBLE) {
                mRecyclerView_attack.setVisibility(View.GONE);
                attack_expand.setRotation(attack_expand.getRotation() - 180);
            } else if (mRecyclerView_defense.getVisibility() == View.VISIBLE) {
                mRecyclerView_defense.setVisibility(View.GONE);
                defense_expand.setRotation(defense_expand.getRotation() - 180);
            } else if (mRecyclerView_penalties.getVisibility() == View.VISIBLE) {
                mRecyclerView_penalties.setVisibility(View.GONE);
                penalties_expand.setRotation(penalties_expand.getRotation() - 180);
            }
            mRecyclerView_defense.setVisibility(View.VISIBLE);
            defense_expand.setRotation(defense_expand.getRotation() + 180);
        }
    }


    @OnClick(R.id.penalties)
    void setPenalties_expand() {
        if (mRecyclerView_penalties.getVisibility() == View.VISIBLE) {
            mRecyclerView_penalties.setVisibility(View.GONE);
            penalties_expand.setRotation(penalties_expand.getRotation() - 180);
        } else {
            if (recycler_playingTime.getVisibility() == View.VISIBLE) {
                recycler_playingTime.setVisibility(View.GONE);
                attack_playingTime.setRotation(attack_playingTime.getRotation() - 180);
            } else if (mRecyclerView_attack.getVisibility() == View.VISIBLE) {
                mRecyclerView_attack.setVisibility(View.GONE);
                attack_expand.setRotation(attack_expand.getRotation() - 180);
            } else if (mRecyclerView_defense.getVisibility() == View.VISIBLE) {
                mRecyclerView_defense.setVisibility(View.GONE);
                defense_expand.setRotation(defense_expand.getRotation() - 180);
            } else if (mRecyclerView_penalties.getVisibility() == View.VISIBLE) {
                mRecyclerView_penalties.setVisibility(View.GONE);
                penalties_expand.setRotation(penalties_expand.getRotation() - 180);
            }
            mRecyclerView_penalties.setVisibility(View.VISIBLE);
            penalties_expand.setRotation(penalties_expand.getRotation() + 180);
        }
    }


    @Override
    public void init() {
        mContext = this;


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_back);
        mCustomTextViewTitle.setVisibility(View.GONE);

        lm_attack = new LinearLayoutManager(this) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // initSpruce();
            }
        };

        lm_defence = new LinearLayoutManager(this) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // initSpruce();
            }
        };

        lm_pentalties = new LinearLayoutManager(this) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // initSpruce();
            }
        };

        lm_playTime = new LinearLayoutManager(this) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // initSpruce();
            }
        };

        mRecyclerView_attack.setLayoutManager(lm_attack);
        mRecyclerView_defense.setLayoutManager(lm_defence);
        mRecyclerView_penalties.setLayoutManager(lm_pentalties);
        recycler_playingTime.setLayoutManager(lm_playTime);
        presenterImpl = new PointCricketPresenterImpl(this, new UserInteractor());

        adapterAttack = new PointsAdapter(mContext, "football");
        adapterDefense = new PointsAdapter(mContext, "football");
        adapterPentalties = new PointsAdapter(mContext, "football");
        adapterPlaytime = new PointsAdapter(mContext, "football");

        mRecyclerView_attack.setAdapter(adapterAttack);
        mRecyclerView_defense.setAdapter(adapterDefense);
        mRecyclerView_penalties.setAdapter(adapterPentalties);
        recycler_playingTime.setAdapter(adapterPlaytime);

        callApi();
    }


    private void callApi() {
        PointsSystem system = new PointsSystem();

        presenterImpl.getPointList(system, "1");
    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) mProgressDialog.dismiss();

    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onHideLoading() {

    }

    @Override
    public void onLoadingSuccess(PointsList responseMatches) {
        hideLoading();
        adapterAttack.addAllItem(responseMatches.getData().getAttack());
        adapterDefense.addAllItem(responseMatches.getData().getDefense());
        adapterPentalties.addAllItem(responseMatches.getData().getCards());
        adapterPlaytime.addAllItem(responseMatches.getData().getPlayingTime());
    }

    @Override
    public void onLoadingError(String value) {
        hideLoading();
        onShowSnackBar(value);
    }

    @Override
    public void onLoadingNotFound(String value) {
        onShowSnackBar(value);
    }

    @Override
    public void onShowSnackBar(String message) {
        AppUtils.showToast(mContext, message);

    }

    @Override
    public boolean isLayoutAdded() {
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    @Override
    public Context getContext() {
        return mContext;
    }
}
