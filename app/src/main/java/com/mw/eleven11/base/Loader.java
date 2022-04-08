package com.mw.eleven11.base;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.mw.eleven11.R;
import com.mw.eleven11.customView.CustomTextView;


/**
 * Created by mobiweb on 24/11/16.
 */
public class Loader {

    @BindView(R.id.ll_error)
    @Nullable
    LinearLayout ll_error;
    @BindView(R.id.ll_loading)
    @Nullable
    LinearLayout ll_loading;
    @BindView(R.id.iv_error)
    @Nullable
    ImageView iv_error;
    @BindView(R.id.iv_error_not_found)
    @Nullable
    ImageView iv_error_not_found;


    @BindView(R.id.tv_tryAgn)
    @Nullable
    CustomTextView tv_tryAgn;
    @BindView(R.id.tv_error)
    @Nullable
    CustomTextView tv_error;
    @BindView(R.id.rl_error)
    RelativeLayout rl_error;

    public Loader(View view) {
        if (view == null) return;
        ButterKnife.bind(this, view);
    }

    public Loader(Activity activity) {
        ButterKnife.bind(this, activity);
    }


    public void start() {
        rl_error.setVisibility(View.VISIBLE);
        ll_loading.setVisibility(View.VISIBLE);
        ll_error.setVisibility(View.GONE);
    }

    public void hide() {
        rl_error.setVisibility(View.GONE);
    }

    public void error(String msg) {
        if (ll_loading == null) return;
        if (ll_error == null) return;
        if (rl_error == null) return;
        if (iv_error == null) return;
        if (tv_error == null) return;
        if (tv_tryAgn == null) return;
        rl_error.setVisibility(View.VISIBLE);
        ll_loading.setVisibility(View.GONE);
        ll_error.setVisibility(View.VISIBLE);
        iv_error.setVisibility(View.VISIBLE);
        tv_error.setVisibility(View.VISIBLE);
        tv_tryAgn.setVisibility(View.VISIBLE);
        tv_error.setText(msg);
    }

    public void dataNotFound(String msg) {
        if (ll_loading == null) return;
        if (ll_error == null) return;
        if (rl_error == null) return;
        if (iv_error == null) return;
        if (tv_error == null) return;
        if (tv_tryAgn == null) return;

        rl_error.setVisibility(View.VISIBLE);
        ll_loading.setVisibility(View.GONE);
        ll_error.setVisibility(View.VISIBLE);
        iv_error.setVisibility(View.VISIBLE);
        tv_error.setVisibility(View.VISIBLE);
        tv_tryAgn.setVisibility(View.GONE);
        tv_error.setText(msg);
    }

    public void setNotFoundImage(Drawable drawable) {
        iv_error.setImageDrawable(drawable);
    }




    public TextView getTryAgainView() {
        return tv_tryAgn;
    }
}
