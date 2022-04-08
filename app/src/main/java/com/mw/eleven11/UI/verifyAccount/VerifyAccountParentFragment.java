package com.mw.eleven11.UI.verifyAccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.mw.eleven11.R;

import com.mw.eleven11.UI.bankVerify.VerifyBankFragment;
import com.mw.eleven11.UI.fragment.BankNAadhaarVerifyParentFragment;
import com.mw.eleven11.UI.mobileAndEmailVerify.VerifyMobileEmailFragment;

import com.mw.eleven11.UI.panVerify.VerifyPanFragment;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.BasePagerAdapter;
import com.mw.eleven11.utility.AppUtils;

import butterknife.BindView;


public class VerifyAccountParentFragment extends BaseFragment {

    public BasePagerAdapter mViewPagerAdapter;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    public static VerifyAccountParentFragment getInstance(String type) {
        VerifyAccountParentFragment friendlyHomeFragment = new VerifyAccountParentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        friendlyHomeFragment.setArguments(bundle);
        return friendlyHomeFragment;
    }

    @Override
    public int getLayout() {
        return R.layout.custom_tabs_fragment;
    }

    @Override
    public void init() {
        setupListViewPager();
    }

    private void setupListViewPager() {
        mViewPagerAdapter = new BasePagerAdapter(getChildFragmentManager());
        mViewPagerAdapter.addFrag(VerifyMobileEmailFragment.getInstance(), AppUtils.getStrFromRes(R.string.mobile_and_email_step1), 0);
        mViewPagerAdapter.addFrag(VerifyPanFragment.getInstance(), AppUtils.getStrFromRes(R.string.pan_step2), 1);
        mViewPagerAdapter.addFrag(VerifyBankFragment.getInstance(), AppUtils.getStrFromRes(R.string.BANK_AADHAR_STEP_3), 2);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        AppUtils.applyFontedVerifyAccount(getActivity(), mViewPager, mTabLayout);
    }

    public void onPicture(String path) {
        if (mViewPagerAdapter != null && mViewPagerAdapter.getItem(mViewPager.getCurrentItem()) instanceof VerifyPanFragment) {
            ((VerifyPanFragment) mViewPagerAdapter.getItem(mViewPager.getCurrentItem())).panPicture(path);
        } else if (mViewPagerAdapter != null && mViewPagerAdapter.getItem(mViewPager.getCurrentItem()) instanceof VerifyBankFragment) {
            ((VerifyBankFragment) mViewPagerAdapter.getItem(mViewPager.getCurrentItem())).bankPicture(path);
        } else if (mViewPagerAdapter != null && mViewPagerAdapter.getItem(mViewPager.getCurrentItem()) instanceof BankNAadhaarVerifyParentFragment) {
            ((BankNAadhaarVerifyParentFragment) mViewPagerAdapter.getItem(mViewPager.getCurrentItem())).picPath(path);
        }/*else  if (mViewPagerAdapter!=null && mViewPagerAdapter.getItem(mViewPager.getCurrentItem()) instanceof VerifyAadharFragment){
            ((VerifyAadharFragment) mViewPagerAdapter.getItem(mViewPager.getCurrentItem())).aadharPicture(path);
        }*/
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       try {
            if (mViewPagerAdapter!=null && mViewPagerAdapter.getItem(mViewPager.getCurrentItem()) instanceof VerifyMobileEmailFragment){
                ((VerifyMobileEmailFragment) mViewPagerAdapter.getItem(mViewPager.getCurrentItem())).onActivityResult(requestCode, resultCode, data);
            }else   if (mViewPagerAdapter!=null && mViewPagerAdapter.getItem(mViewPager.getCurrentItem()) instanceof VerifyPanFragment){
                ((VerifyPanFragment) mViewPagerAdapter.getItem(mViewPager.getCurrentItem())).onActivityResult(requestCode, resultCode, data);
            }else /*  if (mViewPagerAdapter!=null && mViewPagerAdapter.getItem(mViewPager.getCurrentItem()) instanceof VerifyAadharFragment){
                ((VerifyAadharFragment) mViewPagerAdapter.getItem(mViewPager.getCurrentItem())).onActivityResult(requestCode, resultCode, data);
            }else*/   if (mViewPagerAdapter!=null && mViewPagerAdapter.getItem(mViewPager.getCurrentItem()) instanceof VerifyBankFragment){
                ((VerifyBankFragment) mViewPagerAdapter.getItem(mViewPager.getCurrentItem())).onActivityResult(requestCode, resultCode, data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}