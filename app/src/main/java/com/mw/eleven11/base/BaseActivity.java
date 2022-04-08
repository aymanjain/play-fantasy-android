package com.mw.eleven11.base;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.mw.eleven11.R;
import com.mw.eleven11.utility.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_UPDATE_PROFILE = 1234;
    public static final int REQUEST_CODE_UPDATE_MOOD = 1235;
    public static final int REQUEST_CODE_CREATE_TEAM = 1236;
    public static final int REQUEST_CODE_CREATE_CONTESTS = 1237;
    public static final int REQUEST_CODE_MY_TEAM = 1238;
    public static final int REQUEST_CODE_JOIN_CONTESTS = 1239;
    public static final int REQUEST_CODE_UPDATE_Wallet = 1247;
    public static final int REQUEST_CODE_SWITCH_TEAM = 1240;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        init();
    }

    public abstract int getLayout();

    public abstract void init();

    @Override
    protected void onResume() {
        super.onResume();
        ViewUtils.hideKeyboardOnStartActivity(this);
    }

    public void setFragment(final Fragment fragment, final String title) {


        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Bundle bundle = getIntent().getExtras();
                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    // Creating a fragment transaction
                    FragmentTransaction ft = fragmentManager.beginTransaction().addToBackStack(title);
                    // Adding a fragment to the fragment transaction
                    ft.replace(R.id.container, fragment, title);
                    // Committing the transaction
                    ft.commit();
                }
            }, 100);
            
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }

    }


    public boolean checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            int receiveSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
            int readSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
            List<String> listPermissionsNeeded = new ArrayList<>();
            if (receiveSMS != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(Manifest.permission.RECEIVE_SMS);
            }
            if (readSMS != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(Manifest.permission.READ_SMS);
            }
            if (!listPermissionsNeeded.isEmpty()) {
                ActivityCompat.requestPermissions(this,
                        listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
                return false;
            }
            return true;
        }
        return true;

    }


   /* public void replaceFragment(final Fragment fragment, final String fragmentName) {
        try {
            // Getting reference to the FragmentManager
            FragmentManager fragmentManager = getSupportFragmentManager();
            // Creating a fragment transaction
            FragmentTransaction ft = fragmentManager.beginTransaction();
            // Adding a fragment to the fragment transaction
            ft.replace(R.id.frame_container, fragment, fragmentName);
            // Committing the transaction
            ft.commit();
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
    }*/

   /*
    public void setFragment1(final Fragment fragment, final String title)
    {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentManager fragmentManager = getSupportFragmentManager();
                // Creating a fragment transaction
                FragmentTransaction ft = fragmentManager.beginTransaction().addToBackStack(title);
                // Adding a fragment to the fragment transaction
                ft.replace(R.id.container, fragment, title);
                // Committing the transaction
                ft.commit();
            }
        }, 100);
    }
    public void setFragment(final Fragment fragment, final String title)
    {

        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Bundle bundle = getIntent().getExtras();
                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    // Creating a fragment transaction
                    FragmentTransaction ft = fragmentManager.beginTransaction().addToBackStack(title);
                    // Adding a fragment to the fragment transaction
                    ft.replace(R.id.container, fragment, title);
                    // Committing the transaction
                    ft.commit();
                }
            }, 100);
        }catch (Exception e){
            e.printStackTrace();
            finish();
        }

    }

    public void setChieldFragment(final Fragment fragment, final String title)
    {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = getIntent().getExtras();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getSupportFragmentManager();
                // Creating a fragment transaction
                FragmentTransaction ft = fragmentManager.beginTransaction().addToBackStack(title);
                // Adding a fragment to the fragment transaction
                ft.replace(R.id.container, fragment, title);
                // Committing the transaction
                ft.commit();
            }
        }, 100);
    }*/

}
