package com.mw.eleven11.UI.myContest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mw.eleven11.UI.myMatches.MyMatchesFragment;
import com.mw.eleven11.base.BaseFragment;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.homeFragment.HomeCricketPresenterImpl;
import com.mw.eleven11.UI.homeFragment.HomeFragmentView;
import com.mw.eleven11.UI.homeFragment.MultipleImageAdapter;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BasePagerAdapter;

import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.ResponseBanner;
import com.mw.eleven11.beanOutput.VersonBean;
import com.mw.eleven11.customView.CircleIndicator;
import com.mw.eleven11.customView.CustomTextView;

import com.mw.eleven11.utility.AppUtils;

public class MyContestListing extends BaseFragment implements HomeFragmentView {

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout mCoordinatorLayout;
    @BindString(R.string.fixtures)
    String fixtures;
    @BindString(R.string.live)
    String live;
    @BindString(R.string.results)
    String results;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.pager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    CircleIndicator circleIndicator;

    @BindView(R.id.tab_sportSelector)
    TabLayout tab_sportSelector;

    int gameType = 1;
    private int mPosition = 0;

    private HomeCricketPresenterImpl mMyProfileParentPresenterImpl;
    public BasePagerAdapter mViewPagerAdapter;

    com.mw.eleven11.base.Loader loader;
    Context mContext;

    @BindView(R.id.recycler_view_tournament_list)
    RecyclerView recyclerViewSeriesList;

    @BindView(R.id.sportSelector)
    CustomTextView sportSelector;

    @OnClick(R.id.sportSelector)
    public void onSportSelect() {
        int[] location = new int[2];
        sportSelector.getLocationOnScreen(location);
        Point p = new Point();
        p.x = location[0];
        p.y = location[1];
        // showPopup(getActivity(),p);
    }

    @Override
    public int getLayout() {
        return R.layout.my_contest_fragment;
    }

    @Override
    public void init() {

        if (isAttached()) {
            mContext = getActivity();

            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager()
                    .getDefaultDisplay()
                    .getMetrics(displayMetrics);

            int height = displayMetrics.heightPixels;
            int width = displayMetrics.widthPixels;

            if (tab_sportSelector.getTabCount() == 0) {
                tab_sportSelector.addTab(tab_sportSelector.newTab().setIcon(R.drawable.ic_cricket_home_blue));
                tab_sportSelector.addTab(tab_sportSelector.newTab().setIcon(R.drawable.ic_football_home_blue));

                LinearLayout view = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.selector_item_tab, null);
                ImageView tabIcon = view.findViewById(R.id.tabIcon);
                CustomTextView snackbar_tv = view.findViewById(R.id.snackbar_tv);
                snackbar_tv.setText("Cricket");
                snackbar_tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/Roboto-Bold.ttf"));
                tabIcon.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_cricket_home_blue));
                tab_sportSelector.getTabAt(0).setCustomView(view);

                LinearLayout view1 = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.selector_item_tab, null);
                ImageView tabIcon1 = view1.findViewById(R.id.tabIcon);
                CustomTextView snackbar_tv1 = view1.findViewById(R.id.snackbar_tv);
                snackbar_tv1.setText("Football");
                snackbar_tv1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/Roboto-Bold.ttf"));
                tabIcon1.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_football_home_blue));
                tab_sportSelector.getTabAt(1).setCustomView(view1);

                AppUtils.wrapTabIndicatorToTitle(tab_sportSelector, 100, 100);
                tabset();
            }

            if (AppSession.getInstance() != null) {
                //gameType = AppSession.getInstance().getGameType();

                if (gameType == 1) {
                            tab_sportSelector.getTabAt(0).select();
//                            tab_sportSelector.getTabAt(0).setIcon(R.drawable.ic_type_yellow_crik);

                    LinearLayout layout = (LinearLayout) tab_sportSelector.getTabAt(0).getCustomView();
                    ImageView tabIcon = layout.findViewById(R.id.tabIcon);
                    tabIcon.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_cricket_home_blue));
                    LinearLayout layout1 = (LinearLayout) tab_sportSelector.getTabAt(1).getCustomView();
                    ImageView tabIcon1 = layout1.findViewById(R.id.tabIcon);
                    tabIcon1.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_football_home_blue));

                } else if (gameType == 2) {
                            tab_sportSelector.getTabAt(1).select();
//                            tab_sportSelector.getTabAt(1).setIcon(R.drawable.ic_type_yellow_foot);

                    LinearLayout layout = (LinearLayout) tab_sportSelector.getTabAt(1).getCustomView();
                    ImageView tabIcon = layout.findViewById(R.id.tabIcon);
                    tabIcon.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_football_home_blue));
                    LinearLayout layout1 = (LinearLayout) tab_sportSelector.getTabAt(0).getCustomView();
                    ImageView tabIcon1 = layout1.findViewById(R.id.tabIcon);
                    tabIcon1.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_cricket_home_blue));


                } else if (gameType == 3) {
                    sportSelector.setText(AppUtils.getStrFromRes(R.string.kabaddi));
                }
            }

            //initiate loader
            loader = new com.mw.eleven11.base.Loader(getCurrentView());
            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // mMyProfileParentPresenterImpl.actionBannersList(AppSession.getInstance().getLoginSession().getResponse().getLogin_session_key());
                }
            });
            mMyProfileParentPresenterImpl = new HomeCricketPresenterImpl(this, new UserInteractor());
            showLoading();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //view profile calling
                    // mMyProfileParentPresenterImpl.actionBannersList(AppSession.getInstance().getLoginSession().getResponse().getLogin_session_key());
                    /*  FIXTURE,LIVE,COMPLETED*/
                    mViewPagerAdapter = new BasePagerAdapter(getChildFragmentManager());

                    mViewPagerAdapter.addFrag(MyMatchesFragment.getInstance("", "FIXTURE", gameType, 1), fixtures, 0);
                    mViewPagerAdapter.addFrag(MyMatchesFragment.getInstance("", "LIVE", gameType, 1), live, 1);
                    mViewPagerAdapter.addFrag(MyMatchesFragment.getInstance("", "COMPLETED", gameType, 1), results, 2);
                    //FIXTURE,LIVE,COMPLETED
                    mViewPager.setAdapter(mViewPagerAdapter);

                    mTabLayout.setupWithViewPager(mViewPager);

                    // Do something after 2s = 5000ms
                    mViewPager.setCurrentItem(mPosition);
                    AppUtils.applyFontedMyContestTab(getActivity(), mViewPager, mTabLayout);
                }
            }, 500);

            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    mPosition = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }

     //   AppUtils.applyFontedMyContestTab(getActivity(), mViewPager, mTabLayout);
    }


    private void tabset() {
        tab_sportSelector.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()) {
                    case 0:
                        if (AppSession.getInstance().getGameType() != 1) {
                            AppSession.getInstance().setGameType(1);
//                            tab.setIcon(R.drawable.ic_type_yellow_criket);
//                            for (int i = 0; i <tab_sportSelector.getTabCount() ; i++) {
//                                if (i == tab.getPosition()){
//                                    tab_sportSelector.getTabAt(i).setIcon(R.drawable.ic_type_yellow_crik);
//                                }else {
//                                    tab_sportSelector.getTabAt(i).setIcon(R.drawable.ic_type_foot);
//
//                                }
//
//                            }
                        }
                        gameType = 1;
                        break;
                    case 1:
                        if (AppSession.getInstance().getGameType() != 2) {
                            AppSession.getInstance().setGameType(2);
//                            tab.setIcon(R.drawable.ic_type_yellow_foot);
//                            for (int i = 0; i <tab_sportSelector.getTabCount() ; i++) {
//                                if (i == tab.getPosition()){
//                                    tab_sportSelector.getTabAt(i).setIcon(R.drawable.ic_type_yellow_foot);
//                                }else {
//                                    tab_sportSelector.getTabAt(i).setIcon(R.drawable.ic_type_crik);
//
//                                }
//
//                            }
                        }
                        gameType = 2;
                        break;

                }

                init();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean isAttached() {
        return isAdded() && getActivity() != null;
    }


    @Override
    public void hideLoading() {

        if (isAdded() && getActivity() != null) {
            loader.hide();
        }
    }

    @Override
    public void showLoading() {
        if (isAdded() && getActivity() != null) {
            loader.start();
        }
    }


    @Override
    public void onShowSnackBar(String message) {
        AppUtils.showSnackBar(getActivity(), mCoordinatorLayout, message);
    }

    @Override
    public void onVersonSuccess(VersonBean versionBean) {

    }

    @Override
    public void onNotificationCountSuccess(LoginResponseOut mLoginResponseOut) {

    }

    @Override
    public void onNotificationCountFailure(String errMsg) {

    }

    @Override
    public void onVersonFailed(String message) {

    }

    @Override
    public void onVersonError(String message) {

    }


    @Override
    public void onBannerNotFound(String error) {

        if (isAdded() && getActivity() != null) {
            loader.setNotFoundImage(getContext().getResources().getDrawable(R.drawable.not_found_img));
            loader.dataNotFound(error);
        }
    }

    @Override
    public void onBannerFailure(String error) {

        if (isAdded() && getActivity() != null) {
            loader.error(error);
        }
    }


    @Override
    public void onBannerSuccess(ResponseBanner responseBanner) {

        if (isAdded() && getActivity() != null) {
            loader.hide();
            setPagerAdapter(responseBanner.getData().getRecords());
        }
    }

    private void setPagerAdapter(List<ResponseBanner.DataBean.RecordsBean> beans) {
        MultipleImageAdapter multipleImageAdapter = new MultipleImageAdapter(mContext, beans);
        viewPager.setAdapter(multipleImageAdapter);
        circleIndicator.setViewPager(viewPager);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        ((HomeNavigation) getActivity()).changeNavigationSelction(1);
    }


}
