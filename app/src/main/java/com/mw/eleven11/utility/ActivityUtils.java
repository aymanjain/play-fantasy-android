package com.mw.eleven11.utility;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.mw.eleven11.AppController;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomInputEditText;
import com.mw.eleven11.customView.CustomPinView;

import java.util.List;


public class ActivityUtils {


    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    public static void setActivityBackground(Context context, int resId) {
        ((Activity) context).getWindow().setBackgroundDrawableResource(resId);
    }

    public static void performActionOnDone(CustomEditText customEditText, final android.view.View view) {
        customEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //do something
                    view.performClick();
                }
                return false;
            }
        });

    }

    public static void performActionOnDone(CustomInputEditText customEditText, final android.view.View view) {
        customEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //do something
                    view.performClick();
                }
                return false;
            }
        });

    }

    public static void performActionOnDone(EditText customEditText, final android.view.View view) {
        customEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //do something
                    view.performClick();
                }
                return false;
            }
        });

    }

    public static void performActionOnDone(CustomPinView customPinView, final android.view.View view) {
        customPinView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //do something
                    view.performClick();
                }
                return false;
            }
        });
        customPinView.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void afterTextChanged(Editable s) {

                if (s != null && s.length() == 6) {
                    view.performClick();
                }
            }
        });
    }

    public static void performActionOnDone(TextInputEditText customEditText, final android.view.View view) {
        customEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //do something
                    view.performClick();
                }
                return false;
            }
        });

    }


    public boolean isActivityRunning() {
        ActivityManager activityManager = (ActivityManager) AppController.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> activitys = activityManager.getRunningTasks(Integer.MAX_VALUE);

        for (int i = 0; i < activitys.size(); i++) {
            if (activitys.get(i).topActivity.toString().equalsIgnoreCase("ComponentInfo{com.example.testapp/com.example.testapp.Your_Activity_Name}")) {
                return true;
            }
        }
        return false;
    }
}