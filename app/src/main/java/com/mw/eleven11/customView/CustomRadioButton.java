package com.mw.eleven11.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.R;

/**
 * Created by mobiweb on 31/7/17.
 */

public class CustomRadioButton extends android.support.v7.widget.AppCompatRadioButton {

    private Typeface tf = null;
    private String customFont;

    public CustomRadioButton(Context context) {
        super(context);
    }

    public CustomRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFontTextView(context, attrs);
    }

    public CustomRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFontTextView(context, attrs);
    }


    public boolean setCustomFontTextView(Context ctx, String asset) {
        if(asset!=null) {
            try {
                if (asset.equals("r")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_REGULAR);
                }else if (asset.equals("b")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_BOLD);
                }else if (asset.equals("sb")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_MEDIUM);
                }else if (asset.equals("bold")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_BOLD);
                } else if (asset.equals("semibold")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_SEMIBOLD);
                } else if (asset.equals("thin")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_THIN);
                }  else if (asset.equals("regular")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_REGULAR);
                }else if (asset.equals("light")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.MONTSERRAT_REGULAR);
                } else if (asset.equals("ASAP")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.ASAP_FONT_REGULAR);
                } else if (asset.equals("OSWALD")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.OSWALD);
                } else if (asset.equals("OSWALD_BOLD")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.OSWALD_BOLD);
                } else if (asset.equals("MONTSERRAT_REGULAR")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.MONTSERRAT_REGULAR);
                } else if (asset.equals("MONTSERRAT_BOLD")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.MONTSERRAT_BOLD);
                }
                else if (asset.equals("GEO_BOLD")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.GEOMANIST_BOLD);
                }
                else if (asset.equals("GEO_REG")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.GEOMANIST_REGUALAR);
                }else {
                    tf = Typeface.createFromAsset(ctx.getAssets(), asset);
                }
            } catch (Exception e) {
                return false;
            }
        }else {
            // tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_LIGHT);
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
