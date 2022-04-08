
package com.mw.eleven11.UI.home;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.addMoney.AddMoneyActivity;
import com.mw.eleven11.UI.homeFragment.HomeFragment;
import com.mw.eleven11.UI.howToPlay.HowToPlayActivity;
import com.mw.eleven11.UI.inviteFriends.InviteFriendsActivity;
import com.mw.eleven11.UI.more.MoreFragment;
import com.mw.eleven11.UI.myAccount.MyAccountDialogActivity;
import com.mw.eleven11.UI.myAccount.MyAccountParentPresenterImpl;
import com.mw.eleven11.UI.myAccount.MyAccountParentView;
import com.mw.eleven11.UI.myContest.MyContestListing;
import com.mw.eleven11.UI.notifications.NotificationsActivity;
import com.mw.eleven11.UI.outsideEvents.OutSideEvent;
import com.mw.eleven11.UI.userProfile.MyProfileParentPresenterImpl;
import com.mw.eleven11.UI.userProfile.MyProfileParentView;
import com.mw.eleven11.UI.userProfile.UserProfileFragment;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.WalletInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.WalletOutputBean;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.BottomNavigationViewHelper;
import com.mw.eleven11.utility.CircleTransform;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeNavigation extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener , MyAccountParentView {
    private TextView mTextMessage, balance, tvVersionCode, tvHelpdesk, tvChatWithUs,tvUserName;
    private Button invite;
    private ImageView ivUserImage;
    private BottomNavigationView navigation;
    Boolean flag;
    String notificationStatus = "";
    String[] fragmentIndex = new String[4];
    private Context mContext;
    private UserInteractor mInteractor;
    private String notificationId;
    private MyProfileParentPresenterImpl mMyProfileParentPresenterImpl;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbarNav;
    private String amt;
    ImageView ivMe;
    WalletOutputBean myAccount;
    Double winningamt = 0.0;
    private MyAccountParentPresenterImpl mMyAccountParentPresenterImpl;

    private LoginResponseOut responseLogin;
//    CustomTextView notification_counter;
//    ImageView menu;

    public static void start(Context context) {
        Intent starter = new Intent(context, HomeNavigation.class);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.alert_open, R.anim.dialog_close);
    }

    public static void startHome(Context context, Boolean flag) {
        Intent starter = new Intent(context, HomeNavigation.class);
        starter.putExtra("Ranking", flag);
        context.startActivity(starter);
    }

    public static void start(Context context, String notificationStatus) {
        Intent starter = new Intent(context, HomeNavigation.class);
        starter.putExtra("notificationStatus", notificationStatus);
        context.startActivity(starter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Bundle b = new Bundle();

            if (getIntent().hasExtra("appLinkData")) {
                b.putString("appLinkData", getIntent().getStringExtra("appLinkData"));
                getIntent().removeExtra("appLinkData");
            }
            if (getIntent().hasExtra("contestId")) {
                b.putBundle("dataExtra", getIntent().getExtras());
            }
            if (getIntent().hasExtra("notificationStatus")) {
                b.putString("status", getIntent().getStringExtra("notificationStatus"));
            }
            fragmentIndex[0] = AppUtils.getStrFromRes(R.string.home);
            fragmentIndex[1] = AppUtils.getStrFromRes(R.string.myMatches);
            fragmentIndex[2] = AppUtils.getStrFromRes(R.string.profile);
            fragmentIndex[3] = AppUtils.getStrFromRes(R.string.more);
            int playMode = AppSession.getInstance().getPlayMode();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.home);
                    mTextMessage.setText(AppSession.getInstance().getLoginSession().getData().getEmail());
                    fragmentIndex[0] = AppUtils.getStrFromRes(R.string.home);
                    if (playMode == 0) {
                        setFragment(new HomeFragment(), AppUtils.getStrFromRes(R.string.home), b);
                    }
                    return true;
                case R.id.navigation_contest:
                    mTextMessage.setText(R.string.myMatches);
                    if (playMode == 0) {
                        setFragment(new MyContestListing(), AppUtils.getStrFromRes(R.string.contest), b);
                    }
                    fragmentIndex[1] = AppUtils.getStrFromRes(R.string.myContest);
                    return true;
                case R.id.navigation_me:
                    mTextMessage.setText(R.string.profile);
                    b = new Bundle();
                    setFragment(new UserProfileFragment(), AppUtils.getStrFromRes(R.string.fullProfile), b);
                    fragmentIndex[2] = AppUtils.getStrFromRes(R.string.me);

                    return true;
                case R.id.navigation_more:
                    mTextMessage.setText(R.string.more);
                    b = new Bundle();
                    setFragment(new MoreFragment(), AppUtils.getStrFromRes(R.string.more), b);
                    fragmentIndex[3] = AppUtils.getStrFromRes(R.string.more);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_navigation);
        mContext = this;

        mInteractor = new UserInteractor();

//        mMyProfileParentPresenterImpl = new MyProfileParentPresenterImpl(this, mInteractor);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        toolbarNav = findViewById(R.id.toolbarNav);
        View headerView = navigationView.getHeaderView(0);
        tvUserName = headerView.findViewById(R.id.tvName);
        ivUserImage =  headerView.findViewById(R.id.iv_imageView);

        tvVersionCode = navigationView.findViewById(R.id.tvVersionCode);
        tvVersionCode.setText(AppUtils.getVersionInfo() + "\n" + "App up to date");

        tvHelpdesk = navigationView.findViewById(R.id.tvHelpdesk);
        tvHelpdesk.setOnClickListener(this);
        tvChatWithUs = navigationView.findViewById(R.id.tvChatWithUs);
        tvChatWithUs.setOnClickListener(this);
        setUpToolBar();
        setupDrawer();

//        notification_counter = findViewById(R.id.notification_counter);
//        menu = findViewById(R.id.menu);
        //AppUtils.setStatusBarGradiant(this);
        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);

        // ATTENTION: This was auto-generated to handle app links.

        Bundle b = new Bundle();
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();

        Uri appLinkData = appLinkIntent.getData();
        if (appLinkData != null) {

            String[] separated = appLinkData.toString().split("ccode=");
            //   Toast.makeText(this, separated[1], Toast.LENGTH_SHORT).show();

            b.putString("appLinkData", separated[1]);
        }
        int playMode = AppSession.getInstance().getPlayMode();
        if (playMode == 0) {
            setFragment(new HomeFragment(), AppUtils.getStrFromRes(R.string.app_name), b);
        }

        flag = getIntent().getBooleanExtra("Ranking", false);
        if (flag) {
            navigation.setSelectedItemId(R.id.navigation_me);
            // setFragment(new UserProfileFragment(), AppUtils.getStrFromRes(R.string.app_name), b);
            flag = false;
        }

        if (getIntent().hasExtra("notificationStatus")) {
            notificationStatus = getIntent().getStringExtra("notificationStatus");
        }

      /*  ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbarNav,
                R.string.home_navigation_drawer_open, R.string.home_navigation_drawer_close);
//        drawerLayout.setDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        toggle.setHomeAsUpIndicator(R.drawable.ic_user);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
*/
        balance = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().findItem(R.id.nav_balance));
        invite = (Button) MenuItemCompat.getActionView(navigationView.getMenu().findItem(R.id.nav_earn));
        invite.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        callTask();
        //initializeCountDrawer(amt);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_home_navigation;
    }

    @Override
    public void init() {
        //view profile calling
        mMyAccountParentPresenterImpl = new MyAccountParentPresenterImpl(this, new UserInteractor());
        /*ResponseLogin.ResponseBean responce = new ResponseLogin.ResponseBean();
        responce=   AppSession.getInstance().getLoginSession().getResponse();
        AppSession.getInstance().getLoginSession();
        AppSession.getInstance().getLoginSession().getResponse();
        AppSession.getInstance().getLoginSession().getResponse().getLoginSessionKey();

        SharedPreferences sharedPreferences = getSharedPreferences("Preference" + this.getPackageName(), Context.MODE_PRIVATE);

       ResponseLogin responseLogin = new Gson().fromJson(sharedPreferences.
                getString(Constant.RESPONSE_LOGIN,
                        ""), ResponseLogin.class);

        AppSession.getInstance().setLoginSession(responseLogin);
        Log.d("setLoginSession",AppSession.getInstance().getLoginSession().getResponse().getLoginSessionKey());*/

        // jkhihkj

    }

    private void setFragment(final android.support.v4.app.Fragment fragment, final String fragmentName, final Bundle b) {
        try {
            if (fragment != null) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Getting reference to the FragmentManager
                            FragmentManager fragmentManager = getSupportFragmentManager();

                            // Creating a fragment transaction
                            android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();

                            // Adding a fragment to the fragment transaction
                            fragment.setArguments(b);
                            ft.replace(R.id.frame_container, fragment, fragmentName);

                            // clear back fragments
                            ft.addToBackStack(fragmentName);
                            // Committing the transaction
                            ft.commitAllowingStateLoss();
                            ft.commit();
                        } catch (IllegalStateException e) {
                            //e.printStackTrace();
                        }
                    }
                }, 200);
            } else {
                // error in creating fragment
                Log.e("UserProfileFragment", "Error in creating fragment");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else {
            fragmentManager.popBackStack();

             /* Fragment homeFrgment= fragmentManager.findFragmentByTag(AppUtils.getStrFromRes(R.string.home));
            Fragment myContestFragment= fragmentManager.findFragmentByTag(AppUtils.getStrFromRes(R.string.contest));
            Fragment userProfile= fragmentManager.findFragmentByTag(AppUtils.getStrFromRes(R.string.fullProfile));
            Fragment moreFragment= fragmentManager.findFragmentByTag(AppUtils.getStrFromRes(R.string.more));

            Menu menuItem = navigation.getMenu();

            if (homeFrgment != null && homeFrgment.isVisible()) {
                // add your code here


                menuItem.getItem(0).setChecked(true);

            }
            if (myContestFragment != null && myContestFragment.isVisible()) {
                // add your code here

                menuItem.getItem(1).setChecked(true);
            }
            if (userProfile != null && userProfile.isVisible()) {
                // add your code here
                menuItem.getItem(2).setChecked(true);

            }
            if (moreFragment != null && moreFragment.isVisible()) {
                // add your code here
                menuItem.getItem(3).setChecked(true);

            }*/

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 1001) {
            notificationId = data.getStringExtra("notificationID");
        }
    }


    public void changeNavigationSelction(int index) {
/*
            if((fragmentIndex!=null && index < fragmentIndex.length) ){

                Log.d("fragmentIndex", "--"+fragmentIndex.length+"--"+index+"--"+fragmentIndex[index]);

                if(fragmentIndex[index].equals(AppUtils.getStrFromRes(R.string.home))){
                    navigation.getMenu().getItem(0).setChecked(true);
                }
                if(fragmentIndex[index].equals(AppUtils.getStrFromRes(R.string.myContest))){
                    navigation.getMenu().getItem(1).setChecked(true);
                }
                if(fragmentIndex[index].equals(AppUtils.getStrFromRes(R.string.me))){
                    navigation.getMenu().getItem(2).setChecked(true);
                }
                if(fragmentIndex[index].equals(AppUtils.getStrFromRes(R.string.more))){
                    navigation.getMenu().getItem(3).setChecked(true);
                }


            }*/

        /*if(navigation.getMenu().size()>index & index!=0) {
            navigation.getMenu().getItem(index-1).setChecked(true);
        }*/
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_balance) {
            // Handle the camera action
        } else if (id == R.id.nav_earn) {

        }
        /*else if (id == R.id.nav_findPeople) {

        } */
        else if (id == R.id.nav_MyCoupons) {

        } else if (id == R.id.nav_HowToPlay) {
//            showDialog(this);
           // startActivity(new Intent(this, HowToPlayActivity.class));
        }/* else if (id == R.id.nav_share) {

        }*/ else if (id == R.id.nav_MyInfoSetting) {

        } else if (id == R.id.nav_More) {

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initializeCountDrawer(String amt,String userName,String proffilePick) {
        //Gravity property aligns the text
        balance.setGravity(Gravity.CENTER_VERTICAL);
        balance.setTypeface(null, Typeface.BOLD);
        balance.setTextColor(getResources().getColor(R.color.colorAccent));
        balance.setText("₹" + amt);

        invite.setTransformationMethod(null);
        invite.setGravity(Gravity.CENTER);
        invite.setTypeface(Typeface.createFromAsset(getAssets(), "font/play_regular.ttf"));
        invite.setTextColor(getResources().getColor(R.color.colorAccent));
        invite.setText("Invite");

        Drawable buttonDrawable = invite.getBackground();
        buttonDrawable = DrawableCompat.wrap(buttonDrawable);
        DrawableCompat.setTint(buttonDrawable, Color.TRANSPARENT);
        invite.setBackground(buttonDrawable);


        if (userName != null && !userName.isEmpty()) {
            tvUserName.setText(userName);
        }else {
            tvUserName.setText("Eleven11");
        }
        if (proffilePick != null && !proffilePick.isEmpty()) {
            ViewUtils.load(proffilePick, ivUserImage, new CircleTransform());
        }else {
            ivUserImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_account_circle_24));
        }
    }

    @Override
    public void onClick(View view) {
        if (view == tvHelpdesk) {
            OutSideEvent.start(this, "HELP_DESK", Constant.HELP_DESK_URL);
        } else if (view == tvChatWithUs) {
            OutSideEvent.start(this, "WORK_WITH_US", Constant.WORK_WITH_US);
        } else if (view == invite) {
            InviteFriendsActivity.start(this);
        }
    }


   /* public void showDialog(Activity activity) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_how_to_play);
        dialog.setTitle("How to Play...");

        // set the custom dialog components - text, image and button
        ImageView ivCricket = dialog.findViewById(R.id.ivCricket);
        ImageView ivFootball = dialog.findViewById(R.id.ivFootball);

        // if button is clicked, close the custom dialog
        ivCricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutSideEvent.start(HomeNavigation.this, AppUtils.getStrFromRes(R.string.how_to_play), Constant.HOW_TO_PLAY_URL);
                dialog.dismiss();
            }
        });
        ivFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutSideEvent.start(HomeNavigation.this, AppUtils.getStrFromRes(R.string.how_to_play_football), Constant.HOW_TO_PLAY_URL_FOOTBALL);
                dialog.dismiss();
            }
        });
        dialog.show();
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_wallet);
        if (menuItem != null)
            menuItem.setVisible(true);
        MenuItem menuItem1 = menu.findItem(R.id.action_notify);
        if (menuItem1 != null)
            menuItem1.setVisible(true);
        //setImageInToolBar(R.drawable.ic_header_home_logo_01);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_wallet) {
            MyAccountDialogActivity.start(mContext, false);
        } else if (item.getItemId() == R.id.action_notify) {
            Intent intent = new Intent(this, NotificationsActivity.class);
            startActivity(intent);
        }
        return false;
    }


    private void setUpToolBar() {
        //toolbarNav.setLogo(R.drawable.ic_header_home_logo_01);
        setSupportActionBar(toolbarNav);
        if (getSupportActionBar() != null) {
            //ic_hamburger_home_01
            getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_avta));
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
       /* ImageView imageButton = (ImageView) findViewById(R.id.navMe);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("manu","clicl");
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });*/
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbarNav, R.string.home_navigation_drawer_open,
                R.string.home_navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }

    public void setImageInToolBar(int resId) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbarNav.setLogo(resId);
        }
    }

    public void setTitleInToolBar(int resId) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            toolbarNav.setTitle(resId);
            toolbarNav.setLogo(null);
        }
    }

    public void setTitleInToolBar(CharSequence title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            toolbarNav.setTitle(title);
            toolbarNav.setLogo(null);
        }
    }

    private void setupDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Bundle bundle = new Bundle();
                switch (menuItem.getItemId()) {
                    case R.id.nav_balance:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        toolbarNav.setVisibility(View.VISIBLE);
                        MyAccountDialogActivity.start(mContext, false);
//                        HomeNavigation.this.setImageInToolBar(R.drawable.ic_header_home_logo_01);
                        break;
                    case R.id.nav_earn:
                        InviteFriendsActivity.start(HomeNavigation.this);
                        break;
                    case R.id.nav_MyCoupons:
                        AddMoneyActivity.start(mContext, false);
                        break;
                    case R.id.nav_HowToPlay:
                        OutSideEvent.start(mContext, AppUtils.getStrFromRes(R.string.how_to_play), Constant.HOW_TO_PLAY_URL);
                        break;
                    case R.id.nav_MyInfoSetting:
                        bundle = new Bundle();
                        HomeNavigation.this.setFragment(new UserProfileFragment(), AppUtils.getStrFromRes(R.string.fullProfile), bundle);
                        break;
                    case R.id.nav_More:
                        bundle = new Bundle();
                        HomeNavigation.this.setFragment(new MoreFragment(), AppUtils.getStrFromRes(R.string.more), bundle);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void callTask() {
        if (mMyAccountParentPresenterImpl != null) {
            WalletInput mWalletInput = new WalletInput();
            mWalletInput.setTransactionMode(Constant.WalletAmount);
            mWalletInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
            //mWalletInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
            mWalletInput.setParams(Constant.WALLET_PARAMS);
            mMyAccountParentPresenterImpl.actionViewAccount(mWalletInput);
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMyAccountParentPresenterImpl != null)
            mMyAccountParentPresenterImpl.actionLoginCancel();
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onShowSnackBar(String message) {
        AppUtils.showToast(this, message);
    }

    @Override
    public boolean isAttached() {
        return true;
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void onAccountFailure(String error) {

    }

    @Override
    public void onAccountSuccess(WalletOutputBean responseAccount) {

        this.myAccount = responseAccount;

        String amount = responseAccount.getData().getTotalCash();
        String userName  = responseAccount.getData().getUsername();
        String userProfilePick = responseAccount.getData().getProfilePic();
        initializeCountDrawer(amount,userName,userProfilePick);

        /*totalAmmount.setText(AppUtils.getStrFromRes(R.string.price_unit) +
                responseAccount.getData().getTotalCash());*/
    }

    @Override
    public void onShowLoading() {
        /*if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();*/
    }

    @Override
    public void onHideLoading() {
       // if (mProgressDialog != null) mProgressDialog.dismiss();

    }

}
