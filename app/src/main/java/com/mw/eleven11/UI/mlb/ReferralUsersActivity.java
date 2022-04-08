package com.mw.eleven11.UI.mlb;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.ReferEarnInput;
import com.mw.eleven11.beanOutput.DefaultRespose;
import com.mw.eleven11.beanOutput.ReferralUsersResponse;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ReferralUsersActivity extends BaseActivity implements ReferralUsersView {

    private static final String TAG = ReferralUsersActivity.class.getName();
    Context mContext;
    private ReferralUsersPresenterImpl mReferralUsersPresenter;
    private ProgressDialog mProgressDialog;


    @BindView(R.id.total_balance)
    CustomTextView total_balance;

    @BindView(R.id.level1)
    CustomTextView level1;

    @BindView(R.id.level1_referred)
    CustomTextView level1_referred;

    @BindView(R.id.level1_amt)
    CustomTextView level1_amt;

    @BindView(R.id.level2)
    CustomTextView level2;

    @BindView(R.id.level2_referred)
    CustomTextView level2_referred;

    @BindView(R.id.level2_amt)
    CustomTextView level2_amt;

    @BindView(R.id.level3)
    CustomTextView level3;

    @BindView(R.id.level3_referred)
    CustomTextView level3_referred;

    @BindView(R.id.level3_amt)
    CustomTextView level3_amt;

    @BindView(R.id.tv_reference_code)
    CustomTextView tv_reference_code;

    @BindView(R.id.ctv_SMS)
    CustomTextView ctv_SMS;

    @BindView(R.id.ctv_mail)
    CustomTextView ctv_mail;

    @BindView(R.id.cet_mobile_mail)
    CustomEditText cet_mobile_mail;

    @BindView(R.id.view_mail)
    View view_mail;

    @BindView(R.id.view_sms)
    View view_sms;

    String type = "Mobile";


    public static void start(Context context) {
        Intent starter = new Intent(context, ReferralUsersActivity.class);
        context.startActivity(starter);
        ((Activity) context).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @OnClick(R.id.ctv_invite)
    void onInviteClick() {

        invites("");

    }

    private void invites(String tokenResult) {
        ReferEarnInput mReferEarnInput = new ReferEarnInput();
        mReferEarnInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        if (!tokenResult.isEmpty()) {
            mReferEarnInput.setResponse(tokenResult);
        }

        mReferEarnInput.setRequestType("APP");
        if (type.equals("Mobile")) {
            if (cet_mobile_mail.getText().toString().equals("")) {
                AppUtils.showToast(mContext, "Please enter mobile number");
            } else {
                mReferEarnInput.setPhoneNumber(cet_mobile_mail.getText().toString().trim());
                mReferEarnInput.setReferType("Phone");
                mReferralUsersPresenter.getReferEarn(mReferEarnInput);
            }
        } else {
            if (cet_mobile_mail.getText().toString().equals("")) {
                AppUtils.showToast(mContext, "Please enter email");
            } else {
                mReferEarnInput.setEmail(cet_mobile_mail.getText().toString().trim());
                mReferEarnInput.setReferType("Email");
                mReferralUsersPresenter.getReferEarn(mReferEarnInput);
            }
        }
    }


    @OnClick(R.id.ctv_copy_code)
    void copyCode() {

        String getstring = AppSession.getInstance().getLoginSession().getData().getReferralCode();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied Text", getstring);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.back)
    void onBackClick() {
        onBackPressed();
    }


    @OnClick(R.id.whatsapp)
    void whatsapp() {
//        AppUtils.getStrFromRes(R.string.inviteFriendsMore),
//                        AppSession.getInstance().
//                                getLoginSession().getData().getReferralCode() + " to register.",
//                AppUtils.getStrFromRes(R.string.app_name)
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");
        whatsappIntent.putExtra(Intent.EXTRA_SUBJECT, AppUtils.getStrFromRes(R.string.app_name));
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Here's Rs.50 to play " +
                AppUtils.getStrFromRes(R.string.app_name) + " Cricket with me on " +
                AppUtils.getStrFromRes(R.string.app_name) + ". Click "+ AppConfiguration.MAIN_URL+" to download the " +
                AppUtils.getStrFromRes(R.string.app_name) + " app and use my code " +
                AppSession.getInstance().getLoginSession().getData().getReferralCode() + " to register.");
        try {
            startActivity(whatsappIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext, "Whatsapp have not been installed.", Toast.LENGTH_SHORT).show();
        }
    }


    @OnClick(R.id.facebook)
    void fackbook() {
        ShareDialog shareDialog;
        shareDialog = new ShareDialog(this);
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setQuote("Here's Rs.50 to play " +
                        AppUtils.getStrFromRes(R.string.app_name) + " Cricket with me on " +
                        AppUtils.getStrFromRes(R.string.app_name) + ". Click "+ AppConfiguration.MAIN_URL+" to download the " +
                        AppUtils.getStrFromRes(R.string.app_name) + " app and use my code " +
                        AppSession.getInstance().getLoginSession().getData().getReferralCode() + " to register.")
                .setContentUrl(Uri.parse(AppConfiguration.MAIN_URL))
                .build();
        shareDialog.show(content);
    }


    @OnClick(R.id.insta)
    void insta(){
        try {
            Intent shareOnAppIntent = new Intent();
            shareOnAppIntent .setAction(Intent.ACTION_SEND);
            shareOnAppIntent .putExtra(Intent.EXTRA_TEXT, "Here's Rs.50 to play "+
            AppUtils.getStrFromRes(R.string.app_name)+" Cricket with me on "+
                    AppUtils.getStrFromRes(R.string.app_name)+". Click "+ AppConfiguration.MAIN_URL+" to download the "+
                    AppUtils.getStrFromRes(R.string.app_name)+" app and use my code " +
                    AppSession.getInstance().getLoginSession().getData().getReferralCode() + " to register.");
            shareOnAppIntent .setType("text/plain");
            shareOnAppIntent .setPackage("com.instagram.android");
            startActivity(shareOnAppIntent );
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "APP is not installed", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.twitter)
    void twitter(){
        shareTwitter("Here's Rs.50 to play "+
                AppUtils.getStrFromRes(R.string.app_name)+" Cricket with me on "+
                AppUtils.getStrFromRes(R.string.app_name)+". Click "+ AppConfiguration.MAIN_URL+" to download the "+
                AppUtils.getStrFromRes(R.string.app_name)+" app and use my code " +
                AppSession.getInstance().getLoginSession().getData().getReferralCode() + " to register.");
    }



    private void shareTwitter(String message) {
        Intent tweetIntent = new Intent(Intent.ACTION_SEND);
        tweetIntent.putExtra(Intent.EXTRA_TEXT, message);
        tweetIntent.setType("text/plain");

        PackageManager packManager = getPackageManager();
        List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY);

        boolean resolved = false;
        for (ResolveInfo resolveInfo : resolvedInfoList) {
            if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                tweetIntent.setClassName(
                        resolveInfo.activityInfo.packageName,
                        resolveInfo.activityInfo.name);
                resolved = true;
                break;
            }
        }
        if (resolved) {
            startActivity(tweetIntent);
        } else {
            Intent i = new Intent();
            i.putExtra(Intent.EXTRA_TEXT, message);
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://twitter.com/intent/tweet?text=" + urlEncode(message)));
            startActivity(i);
            Toast.makeText(this, "Twitter app isn't found", Toast.LENGTH_LONG).show();
        }
    }

    private String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_mlb;
    }

    @Override
    public void init() {

        mContext = this;
        FacebookSdk.sdkInitialize(this);

        mReferralUsersPresenter = new ReferralUsersPresenterImpl(this, new UserInteractor());

        LoginInput mLoginInput = new LoginInput();
        mLoginInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
        mLoginInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());

        mReferralUsersPresenter.actionListing(mLoginInput);

        tv_reference_code.setText("Your invite code " + AppSession.getInstance().getLoginSession().getData().getReferralCode());


        ctv_SMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cet_mobile_mail.setHint("Enter Mobile Number");
                cet_mobile_mail.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_PHONE);
                view_sms.setBackgroundColor(getResources().getColor(R.color.yellow));
                view_mail.setBackgroundColor(getResources().getColor(R.color.greyDarkBg));
                type = "Mobile";

            }
        });

        ctv_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cet_mobile_mail.setHint("Enter Email Address");
                cet_mobile_mail.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                view_sms.setBackgroundColor(getResources().getColor(R.color.greyDarkBg));
                view_mail.setBackgroundColor(getResources().getColor(R.color.yellow));
                type = "Mail";
            }
        });


    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog == null) mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.dismiss();
    }

    @Override
    public void onLoadingSuccess(ReferralUsersResponse mReferralUsersResponse) {

        if (mReferralUsersResponse != null) {

            total_balance.setText("Total Balance " + AppUtils.getStrFromRes(R.string.price_unit) +
                    mReferralUsersResponse.getData().getResponse().getTotalReferralsDeposit());

            level1.setText("Level 1\n" + mReferralUsersResponse.getData().getResponse().getFirstPercentage() + "%");
            if (mReferralUsersResponse.getData().getResponse().getFirstLevel().equals("")) {
                level1_referred.setText("0");
            } else {
                level1_referred.setText(mReferralUsersResponse.getData().getResponse().getFirstLevel());
            }

            level1_amt.setText(AppUtils.getStrFromRes(R.string.price_unit) + mReferralUsersResponse.getData().getResponse().getFristLevelTotalWinningAmount());

            level2.setText("Level 2\n" + mReferralUsersResponse.getData().getResponse().getSecondPercentage() + "%");
            level2_referred.setText(mReferralUsersResponse.getData().getResponse().getSecondLevel());
            level2_amt.setText(AppUtils.getStrFromRes(R.string.price_unit) + mReferralUsersResponse.getData().getResponse().getSecondLevelTotalWinningAmount());

            level3.setText("Level 3\n" + mReferralUsersResponse.getData().getResponse().getThirdPercentage() + "%");
            level3_referred.setText(mReferralUsersResponse.getData().getResponse().getThirdLevel());
            level3_amt.setText(AppUtils.getStrFromRes(R.string.price_unit) + mReferralUsersResponse.getData().getResponse().getThirdLevelTotalWinningAmount());

            tv_reference_code.setText("Your invite code " + mReferralUsersResponse.getData().getResponse().getReferralCode());


        }

    }

    @Override
    public void onLoadingError(String value) {
        AppUtils.showToast(mContext, value);
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void onReferEarnSuccess(DefaultRespose mDefaultRespose) {

        if (mDefaultRespose.getCaptchaEnable()!=null&&mDefaultRespose.getCaptchaEnable().equalsIgnoreCase("Yes")){
            captcha();
        }else {
            Toast.makeText(this, mDefaultRespose.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void captcha(){
        SafetyNet.getClient(this).verifyWithRecaptcha(AppConfiguration.SAFETY_NET_API_SITE_KEY)
                .addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                    @Override
                    public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                        Log.d(TAG, "onSuccess");

                        if (!response.getTokenResult().isEmpty()) {

                            // Received captcha token
                            // This token still needs to be validated on the server
                            // using the SECRET key
                            verifyTokenOnServer(response.getTokenResult());
                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof ApiException) {
                            ApiException apiException = (ApiException) e;
                            Log.d(TAG, "Error message: " +
                                    CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));
                        } else {
                            Log.d(TAG, "Unknown type of error: " + e.getMessage());
                        }
                    }
                });
    }

    private void verifyTokenOnServer(String tokenResult) {
        invites(tokenResult);
    }


    @Override
    public void onReferEarnError(String value) {
        AppUtils.showToast(mContext, value);
    }
}
