package com.mw.eleven11.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.rey.material.widget.CheckBox;

import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.R;


public class CustomCheckBox extends CheckBox {

    private Typeface tf = null;
    private String customFont;

    public CustomCheckBox(Context context) {
        super(context);
    }

    public CustomCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFontTextView(context, attrs);
    }

    public CustomCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFontTextView(context, attrs);
    }


    public boolean setCustomFontTextView(Context ctx, String asset) {
        try {
            if (asset.equals("bold")) {
                tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_BOLD);
            } else {
                tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_REGULAR);
            }
        } catch (Exception e) {
            return false;
        }
        setTypeface(tf);
        return true;
    }

    private void setCustomFontTextView(Context ctx, AttributeSet attrs) {
        final TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.CustomEditText);
        customFont = a.getString(R.styleable.CustomEditText_textfont);
        setCustomFontTextView(ctx, customFont);
        a.recycle();
    }

}
