package com.mw.eleven11.UI.stockTrade;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mw.eleven11.R;
import com.mw.eleven11.UI.stockTrade.adapter.StockTradeAdapter;
import com.mw.eleven11.UI.stockTrade.fragment.CompletedFragment;
import com.mw.eleven11.UI.stockTrade.fragment.LiveFragment;
import com.mw.eleven11.UI.stockTrade.fragment.UpcomingFragment;

import java.util.ArrayList;
import java.util.List;

public class StockTradeFragment extends Fragment implements TabLayout.OnTabSelectedListener {
    //String[] data = {"Amazing 4", "Golden 5", "Great 3","GoTO 5","Hello","Playtel"};
    View root;
    StockTradeAdapter adapter;
    RecyclerView recyStock;
    ArrayList<String> data = new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_upcoming,
            R.drawable.ic_live,
            R.drawable.ic_complete};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_stock_trade, container, false);

        inIt();
        return root;
    }

    private void inIt() {
        // recyStock = root.findViewById(R.id.recStock);
        viewPager = root.findViewById(R.id.stockViewPager);
        setupViewPager(viewPager);

        tabLayout = root.findViewById(R.id.stock_TabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming"));
        tabLayout.addTab(tabLayout.newTab().setText("Live"));
        tabLayout.addTab(tabLayout.newTab().setText("Completed"));
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //viewPager.setOffscreenPageLimit(3);

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        //  populateRecyclerView();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFrag(new UpcomingFragment(), "Upcoming");
        adapter.addFrag(new LiveFragment(), "Live");
        adapter.addFrag(new CompletedFragment(), "Completed");
        viewPager.setAdapter(adapter);
    }

    //setIcon(tabIcons[0])
    private void setupTabIcons() {
        tabLayout.getTabAt(0);
        tabLayout.getTabAt(1);
        tabLayout.getTabAt(2);
//        TextView tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
//        tabOne.setText("Upcoming");
//        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_upcoming, 0, 0);
//        tabLayout.getTabAt(0).setCustomView(tabOne);
//
//        TextView tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
//        tabTwo.setText("Live");
//        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_live, 0, 0);
//        tabLayout.getTabAt(1).setCustomView(tabTwo);
//
//        TextView tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
//        tabThree.setText("Completed");
//        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_complete, 0, 0);
//        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

//    private void populateRecyclerView() {
//        data.add("Amazing 4");
//        data.add("Golden 5");
//        data.add("Great 5");
//        data.add("GoTO 4");
//        data.add("Playtel ");
//        adapter = new StockTradeAdapter(data, getActivity());
//        recyStock.setAdapter(adapter);
//    }

    static class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}