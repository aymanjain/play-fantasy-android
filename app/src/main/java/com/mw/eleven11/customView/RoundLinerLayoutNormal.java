package com.mw.eleven11.customView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.mw.eleven11.R;
import com.mw.eleven11.utility.ViewUtils;

/**
 * Created by mobiweb on 25/9/18.
 */

public class RoundLinerLayoutNormal extends LinearLayout {
    public RoundLinerLayoutNormal(Context context) {
        super(context);
        initBackground();
    }

    public RoundLinerLayoutNormal(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initBackground();
    }

    public RoundLinerLayoutNormal(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initBackground();
    }

    private void initBackground() {
        setBackground(ViewUtils.generateBackgroundWithShadow(this, R.color.white, R.dimen.radius_corner, R.color.card_shadow, R.dimen.elevation, Gravity.BOTTOM));
    }

}
