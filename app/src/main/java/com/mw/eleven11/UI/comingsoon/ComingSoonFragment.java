package com.mw.eleven11.UI.comingsoon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.contestDetail.ContestDetail;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.joinedContests.AllJoinedContest;
import com.mw.eleven11.UI.loginRagisterModule.LoginScreen;
import com.mw.eleven11.UI.matchContest.MatchContestActivity;
import com.mw.eleven11.UI.matches.MatchSeriesAdapter;
import com.mw.eleven11.UI.matches.MatchesAdapter;
import com.mw.eleven11.UI.matches.MatchesFragment;
import com.mw.eleven11.UI.matches.MatchesPresenterImpl;
import com.mw.eleven11.UI.matches.MatchesView;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.base.LoaderScroller;
import com.mw.eleven11.beanInput.MatchListInput;
import com.mw.eleven11.beanOutput.CheckContestBean;
import com.mw.eleven11.beanOutput.MatchResponseOut;
import com.mw.eleven11.beanOutput.ResponseMatches;
import com.mw.eleven11.beanOutput.SeriesOutput;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.EndlessRecyclerViewScrollListenerFab;
import com.mw.eleven11.utility.ItemOffsetDecoration;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class ComingSoonFragment extends BaseFragment  {

    public static ComingSoonFragment getInstance() {
        ComingSoonFragment friendsFragment = new ComingSoonFragment();

        return friendsFragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public int getLayout() {
        return R.layout.coming_soon_fragment;
    }

    @Override
    public void init() {

    }

}
