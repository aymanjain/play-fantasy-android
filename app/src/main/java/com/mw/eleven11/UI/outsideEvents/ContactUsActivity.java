package com.mw.eleven11.UI.outsideEvents;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseActivity;
import com.mw.eleven11.beanOutput.DefaultRespose;
import com.mw.eleven11.beanOutput.SubjectOutput;
import com.mw.eleven11.customView.CustomEditText;
import com.mw.eleven11.customView.CustomSpinner;
import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;
import com.rey.material.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ContactUsActivity extends BaseActivity {


    private ContactUsActivity mContext;
    private UserInteractor mInteractor;
    private ProgressDialog mProgressDialog;
    private AlertDialog mAlertDialog;
    private List<String> strings = new ArrayList<>();

    public static void start(Context context) {
        Intent starter = new Intent(context, ContactUsActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }


    @BindView(R.id.ctv_subject)
    CustomSpinner mCustomSpinnerRole;

    @BindView(R.id.cet_email)
    CustomEditText cet_email;

    @BindView(R.id.cet_mobile)
    CustomEditText cet_mobile;

    @BindView(R.id.cet_message)
    CustomEditText cet_message;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



    @OnClick(R.id.send_message)
    void sendMessage(){
       if (cet_email.getText().toString().isEmpty()){
           Toast.makeText(mContext, "Please enter email address.", Toast.LENGTH_SHORT).show();
       }else if (!cet_email.getText().toString().trim().matches(emailPattern)){
           Toast.makeText(mContext, "Please enter valid email address.", Toast.LENGTH_SHORT).show();
       }else  if (cet_mobile.getText().toString().isEmpty()){
           Toast.makeText(mContext, "Please enter mobile number.", Toast.LENGTH_SHORT).show();
       }else  if (cet_message.getText().toString().isEmpty()){
           Toast.makeText(mContext, "Please enter message.", Toast.LENGTH_SHORT).show();
       }else if (mCustomSpinnerRole.getSelectedTitle().equalsIgnoreCase("Subject")){
           Toast.makeText(mContext, "Please select subject.", Toast.LENGTH_SHORT).show();
       }else {

       }
    }



    @OnClick(R.id.back)
    void back(){
        finish();
    }


    @OnClick(R.id.btn_fb)
    void btnFb(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/FSLEleven/"));
        startActivity(browserIntent);
    }

    @OnClick(R.id.btn_inta)
    void btnInsta(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/Eleven11/"));
        startActivity(browserIntent);

    }

    @OnClick(R.id.btn_telegram)
    void btnTeleGram(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/joinchat/AAAAAEwiBJcPZ_0iPHivWg"));
        startActivity(browserIntent);
    }

    @OnClick(R.id.btn_twitter)
    void btnTwitter(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/FSL_Eleven"));
        startActivity(browserIntent);
    }

    @OnClick(R.id.btn_whatsapp)
    void btnWhatsapp(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/919301148160/?text=Please+enable+Eleven11+Whatsapp+support+on+my+number+%21"));
        startActivity(browserIntent);
    }


    @Override
    public int getLayout() {
        return R.layout.activity_contact_us;
    }

    @Override
    public void init() {
        mContext = this;
        mInteractor = new UserInteractor();
        mProgressDialog = new ProgressDialog(this);


        ArrayAdapter<CharSequence> roleAdapter = ArrayAdapter.createFromResource(this,
                R.array.player_role, R.layout.subject_spinner_item);

    }






}
