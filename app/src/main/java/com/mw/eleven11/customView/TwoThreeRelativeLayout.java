package com.mw.eleven11.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by mobiweb on 7/3/17.
 */
public class TwoThreeRelativeLayout extends RelativeLayout {


    public TwoThreeRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        // We have to manually resize the child views to match the parent.
        for (int i = 0; i < getChildCount(); i++) {
            final View child = getChildAt(i);
            final LayoutParams params = (LayoutParams) child.getLayoutParams();

            if (params.height == LayoutParams.MATCH_PARENT) {
                params.height = bottom - top;
            }
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, (int) width * 2 / 3);
    }
}
