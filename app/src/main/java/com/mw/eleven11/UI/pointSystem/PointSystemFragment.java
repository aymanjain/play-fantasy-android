package com.mw.eleven11.UI.pointSystem;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.beanInput.PointsSystem;
import com.mw.eleven11.beanOutput.PointsList;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;

import butterknife.BindView;
import butterknife.OnClick;


public class PointSystemFragment extends BaseFragment implements PointsFragmentView {

    @BindView(R.id.strike)
    View mViewStrikeRoot;

    @BindView(R.id.economy)
    View mViewEconomyRoot;

    @BindView(R.id.recycler_bat)
    RecyclerView recycler_bat;

    @BindView(R.id.recycler_bowl)
    RecyclerView recycler_bowl;

    @BindView(R.id.recycler_field)
    RecyclerView recycler_field;

    @BindView(R.id.recycler_strike)
    RecyclerView recycler_strike;

    @BindView(R.id.recycler_economy)
    RecyclerView recycler_economy;


    @BindView(R.id.bat_expand)
    ImageView bat_expand;

    @BindView(R.id.bowl_expand)
    ImageView bowl_expand;

    @BindView(R.id.field_expand)
    ImageView field_expand;

    @BindView(R.id.economy_expand)
    ImageView economy_expand;

    @BindView(R.id.strike_expand)
    ImageView strike_expand;


    @OnClick(R.id.fielding)
    void setField_expand() {
        if (recycler_field.getVisibility() == View.VISIBLE) {
            recycler_field.setVisibility(View.GONE);
            field_expand.setRotation(field_expand.getRotation() - 180);

        } else {
            recycler_field.setVisibility(View.VISIBLE);
            if (recycler_bowl.getVisibility() == View.VISIBLE) {
                recycler_bowl.setVisibility(View.GONE);
                bowl_expand.setRotation(bowl_expand.getRotation() - 180);
            } else if (recycler_bat.getVisibility() == View.VISIBLE) {
                recycler_bat.setVisibility(View.GONE);
                bat_expand.setRotation(bat_expand.getRotation() - 180);
            } else if (recycler_strike.getVisibility() == View.VISIBLE) {
                recycler_strike.setVisibility(View.GONE);
                strike_expand.setRotation(strike_expand.getRotation() - 180);
            } else if (recycler_economy.getVisibility() == View.VISIBLE) {
                recycler_economy.setVisibility(View.GONE);
                economy_expand.setRotation(economy_expand.getRotation() - 180);
            }
            field_expand.setRotation(field_expand.getRotation() + 180);

        }
    }

    @OnClick(R.id.bowling)
    void bowl_expand() {
        if (recycler_bowl.getVisibility() == View.VISIBLE) {
            recycler_bowl.setVisibility(View.GONE);
            bowl_expand.setRotation(bowl_expand.getRotation() - 180);
        } else {

            if (recycler_field.getVisibility() == View.VISIBLE) {
                recycler_field.setVisibility(View.GONE);
                field_expand.setRotation(field_expand.getRotation() - 180);
            } else if (recycler_bat.getVisibility() == View.VISIBLE) {
                recycler_bat.setVisibility(View.GONE);
                bat_expand.setRotation(bat_expand.getRotation() - 180);
            } else if (recycler_strike.getVisibility() == View.VISIBLE) {
                recycler_strike.setVisibility(View.GONE);
                strike_expand.setRotation(strike_expand.getRotation() - 180);
            } else if (recycler_economy.getVisibility() == View.VISIBLE) {
                recycler_economy.setVisibility(View.GONE);
                economy_expand.setRotation(economy_expand.getRotation() - 180);
            }
            recycler_bowl.setVisibility(View.VISIBLE);
            bowl_expand.setRotation(bowl_expand.getRotation() + 180);


        }
    }

    @OnClick(R.id.batting)
    void bat_expand() {
        if (recycler_bat.getVisibility() == View.VISIBLE) {
            recycler_bat.setVisibility(View.GONE);
            bat_expand.setRotation(bat_expand.getRotation() - 180);
        } else {

            if (recycler_field.getVisibility() == View.VISIBLE) {
                recycler_field.setVisibility(View.GONE);
                field_expand.setRotation(field_expand.getRotation() - 180);
            } else if (recycler_bowl.getVisibility() == View.VISIBLE) {
                recycler_bowl.setVisibility(View.GONE);
                bowl_expand.setRotation(bowl_expand.getRotation() - 180);
            } else if (recycler_strike.getVisibility() == View.VISIBLE) {
                recycler_strike.setVisibility(View.GONE);
                strike_expand.setRotation(strike_expand.getRotation() - 180);
            } else if (recycler_economy.getVisibility() == View.VISIBLE) {
                recycler_economy.setVisibility(View.GONE);
                economy_expand.setRotation(economy_expand.getRotation() - 180);
            }
            recycler_bat.setVisibility(View.VISIBLE);
            bat_expand.setRotation(bat_expand.getRotation() + 180);

        }
    }

    @OnClick(R.id.strike)
    void strike_expand() {
        if (recycler_strike.getVisibility() == View.VISIBLE) {
            recycler_strike.setVisibility(View.GONE);
            strike_expand.setRotation(strike_expand.getRotation() - 180);
        } else {

            if (recycler_field.getVisibility() == View.VISIBLE) {
                recycler_field.setVisibility(View.GONE);
                field_expand.setRotation(field_expand.getRotation() - 180);
            } else if (recycler_bowl.getVisibility() == View.VISIBLE) {
                recycler_bowl.setVisibility(View.GONE);
                bowl_expand.setRotation(bowl_expand.getRotation() - 180);
            } else if (recycler_bat.getVisibility() == View.VISIBLE) {
                recycler_bat.setVisibility(View.GONE);
                bat_expand.setRotation(bat_expand.getRotation() - 180);
            } else if (recycler_economy.getVisibility() == View.VISIBLE) {
                recycler_economy.setVisibility(View.GONE);
                economy_expand.setRotation(economy_expand.getRotation() - 180);
            }
            recycler_strike.setVisibility(View.VISIBLE);
            strike_expand.setRotation(strike_expand.getRotation() + 180);

        }
    }

    @OnClick(R.id.economy)
    void economy_expand() {
        if (recycler_economy.getVisibility() == View.VISIBLE) {
            recycler_economy.setVisibility(View.GONE);
            economy_expand.setRotation(economy_expand.getRotation() - 180);
        } else {

            if (recycler_field.getVisibility() == View.VISIBLE) {
                recycler_field.setVisibility(View.GONE);
                field_expand.setRotation(field_expand.getRotation() - 180);
            } else if (recycler_bowl.getVisibility() == View.VISIBLE) {
                recycler_bowl.setVisibility(View.GONE);
                bowl_expand.setRotation(bowl_expand.getRotation() - 180);
            } else if (recycler_bat.getVisibility() == View.VISIBLE) {
                recycler_bat.setVisibility(View.GONE);
                bat_expand.setRotation(bat_expand.getRotation() - 180);
            } else if (recycler_strike.getVisibility() == View.VISIBLE) {
                recycler_strike.setVisibility(View.GONE);
                strike_expand.setRotation(strike_expand.getRotation() - 180);
            }
            recycler_economy.setVisibility(View.VISIBLE);
            economy_expand.setRotation(economy_expand.getRotation() + 180);

        }
    }


    private Context mContext;
    private ProgressDialog mProgressDialog;
    private PointCricketPresenterImpl presenterImpl;
    private PointsAdapter adapter_bat;
    private LinearLayoutManager lm_bat,lm_field, lm_bowl,lm_strike,lm_economy;
    private PointsBowlAdapter bowl_adapter;
    private PointsFieldAdapter field_adapter;
    private PointAdapter mPointAdapterStrike,mPointAdapterEconomy;


    public static PointSystemFragment getInstance(String pointsTEST) {
        PointSystemFragment friendsFragment = new PointSystemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", pointsTEST);

        friendsFragment.setArguments(bundle);
        return friendsFragment;
    }


    @Override
    public int getLayout() {
        return R.layout.fragment_point_system;
    }

    @Override
    public void init() {
        mContext = getActivity();
        if (getArguments().getString("type").equals("PointsTEST")) {
            mViewStrikeRoot.setVisibility(View.GONE);
            mViewEconomyRoot.setVisibility(View.GONE);
        }
        recycler_bat.setVisibility(View.GONE);
        bat_expand.setRotation(bat_expand.getRotation() - 180);


        lm_bat = new LinearLayoutManager(getContext()) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // initSpruce();
            }
        };
        lm_bowl = new LinearLayoutManager(getContext()) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // initSpruce();
            }
        };
        lm_field = new LinearLayoutManager(getContext()) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // initSpruce();
            }
        };
        lm_strike = new LinearLayoutManager(getContext()) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // initSpruce();
            }
        };

        lm_economy = new LinearLayoutManager(getContext()) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // initSpruce();
            }
        };
        recycler_bat.setLayoutManager(lm_bat);
        recycler_bowl.setLayoutManager(lm_bowl);
        recycler_field.setLayoutManager(lm_field);
        recycler_strike.setLayoutManager(lm_strike);
        recycler_economy.setLayoutManager(lm_economy);

        presenterImpl = new PointCricketPresenterImpl(this, new UserInteractor());

        mPointAdapterEconomy = new PointAdapter(mContext, getArguments().getString("type"));
        mPointAdapterStrike = new PointAdapter(mContext, getArguments().getString("type"));
        recycler_economy.setAdapter(mPointAdapterEconomy);
        recycler_strike.setAdapter(mPointAdapterStrike);

        adapter_bat = new PointsAdapter(mContext, getArguments().getString("type"));
        bowl_adapter = new PointsBowlAdapter(mContext, getArguments().getString("type"));
        field_adapter = new PointsFieldAdapter(mContext, getArguments().getString("type"));
        recycler_bat.setAdapter(adapter_bat);
        recycler_bowl.setAdapter(bowl_adapter);
        recycler_field.setAdapter(field_adapter);


        callApi();

    }

    private void callApi() {
        PointsSystem system = new PointsSystem();
        system.setPointCategory("Normal");
        system.setStatusID("1");
        system.setType(getArguments().getString("type"));
        presenterImpl.getPointList(system, "0");
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
        adapter_bat.addAllItem(responseMatches.getData().getBatting());
        bowl_adapter.addAllItem(responseMatches.getData().getBowling());
        field_adapter.addAllItem(responseMatches.getData().getFielding());

        mPointAdapterStrike.addAllItem(responseMatches.getData().getStrikeRate());
        mPointAdapterEconomy.addAllItem(responseMatches.getData().getEconomyRate());
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
    public Context getContext() {
        return mContext;
    }
}


