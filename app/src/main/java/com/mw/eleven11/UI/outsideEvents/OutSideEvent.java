package com.mw.eleven11.UI.outsideEvents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mw.eleven11.R;
import com.mw.eleven11.base.BaseActivity;


import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class OutSideEvent extends BaseActivity {

    @BindString(R.string.details)
    String details;
    @BindString(R.string.nav_about_us)
    String aboutUs;

    @BindString(R.string.nav_helpdesk)
    String helpdesk;

    @BindString(R.string.how_to_play)
    String how_to_play;

    @BindString(R.string.champions)
    String champions;
    @BindString(R.string.rulesOfFairPlay)
    String rulesOfFairPlay;

    @BindString(R.string.terms_and_conditions)
    String termsAndConditions;
    @BindString(R.string.privacy_policy)
    String privacyPolicy;

    @BindString(R.string.fantasyPointSystem)
    String fantasyPointSystem;

    @BindString(R.string.workWithUs)
    String workWithUs;

    @BindString(R.string.legality)
    String legality;

   /* @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.title)
    com.mw.eleven11.customView.CustomTextView mCustomTextViewTitle;*/

    @BindView(R.id.webView1)
    WebView webView;
    String url = "", type = "";


    @OnClick(R.id.back)
    public void onBackClick(){
        finish();
    }

    public static void start(Context context, String type, String url) {
        Intent starter = new Intent(context, OutSideEvent.class);
        starter.putExtra("url", url);
        starter.putExtra("type", type);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }


    @Override
    public int getLayout() {
        return R.layout.out_side_event;
    }

    @Override
    public void init() {

      /*  setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        Intent in = getIntent();
        if (in.hasExtra("type")) {
            type = in.getStringExtra("type");
        }
       /* if (TextUtils.isEmpty(type)){
            mCustomTextViewTitle.setText(details);
        }else if (type.equals("BANNER")){
            mCustomTextViewTitle.setText(details);
        }else if (type.equals("ABOUT_US")){
            mCustomTextViewTitle.setText(aboutUs);
        }else if (type.equals("HELP_DESK")){
            mCustomTextViewTitle.setText(helpdesk);
        }else if (type.equals("TERMS_CONDITIONS")){
            mCustomTextViewTitle.setText(termsAndConditions);
        }else if (type.equals("PRIVACY_POLICY")){
            mCustomTextViewTitle.setText(privacyPolicy);
        }else if (type.equals("POINT_SYSTEM")){
            mCustomTextViewTitle.setText(fantasyPointSystem);
        }else if (type.equals("WORK_WITH_US")){
            mCustomTextViewTitle.setText(workWithUs);
        }else if (type.equals("LEGALITY")){
            mCustomTextViewTitle.setText(legality);
        }else if (type.equals("HOW_TO_PLAY")){
            mCustomTextViewTitle.setText(how_to_play);
        }else if (type.equals("HOW_IT_WORKS")){
            mCustomTextViewTitle.setText(how_to_play);
        }else if (type.equals("LEVEL")){
            mCustomTextViewTitle.setText(champions);
        }else if (type.equals("RULES_OF_FAIRPLAY")){
            mCustomTextViewTitle.setText(rulesOfFairPlay);
        }*/
     //   mCustomTextViewTitle.setText(com.mw.eleven11.utility.AppUtils.getStrFromRes(R.string.app_name));

        if (in.hasExtra("url")) {
            url = in.getStringExtra("url");
        }
        if (!url.startsWith("http")) {
            url = "http://" + url;
        }

        Log.d("BASE_URL", "init: " + url);
        startWebView(url);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    private void startWebView(String url) {

        //Create new webview Client to show progress dialog
        //When opening a url or click on link

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        // Other webview options
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.getSettings().setBuiltInZoomControls(false);

        webView.setWebViewClient(new WebViewClient() {

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //Show loader on url load
            public void onLoadResource(WebView view, String url) {

            }

            public void onPageFinished(WebView view, String url) {

            }

        });

        // Javascript inabled on webview

        /* String summary = "<html><body>You scored <b>192</b> points.</body></html>";
         webview.loadData(summary, "text/html", null);*/


        //Load url in webview
        webView.loadUrl(url);
    }
}

