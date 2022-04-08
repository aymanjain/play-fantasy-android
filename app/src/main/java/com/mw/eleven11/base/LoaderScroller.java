package com.mw.eleven11.base;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.mw.eleven11.R;

/**
 * Created by mobiweb on 24/11/16.
 */
public class LoaderScroller {

    @BindView(R.id.ll_lode_more)
    @Nullable
    LinearLayout ll_lode_more;
    @BindView(R.id.tv_footer)
    @Nullable
    TextView tv_footer;
    @BindView(R.id.pb_footer)
    @Nullable
    ProgressBar pb_footer;

    public LoaderScroller(View view) {
        if (view == null) return;

        ButterKnife.bind(this, view);
    }

    public LoaderScroller(Activity activity) {
        if (activity == null) return;
        ButterKnife.bind(this, activity);
    }


    public void show() {
        ll_lode_more.setVisibility(View.VISIBLE);
        pb_footer.setVisibility(View.VISIBLE);
        tv_footer.setVisibility(View.VISIBLE);
        tv_footer.setText(pb_footer.getContext().getResources().getString(R.string.loading));
    }

    public void hide() {
        ll_lode_more.setVisibility(View.GONE);
    }

    public void error(String error) {
        if (ll_lode_more == null) return;
        ll_lode_more.setVisibility(View.VISIBLE);
        pb_footer.setVisibility(View.GONE);
        tv_footer.setVisibility(View.VISIBLE);
        tv_footer.setText(error);
    }
}
