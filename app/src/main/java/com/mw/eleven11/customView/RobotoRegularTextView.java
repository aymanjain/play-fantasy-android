package com.mw.eleven11.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;

import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.R;

public class RobotoRegularTextView extends android.support.v7.widget.AppCompatTextView {

    private Typeface tf = null;
    private String customFont;

    public RobotoRegularTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFontTextView(context, attrs);
        setDrawable(context, attrs);
    }

    public RobotoRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFontTextView(context, attrs);
        setDrawable(context, attrs);
    }

    public RobotoRegularTextView(Context context) {
        super(context);

    }

    public boolean setCustomFontTextView(Context ctx, String asset) {
        if(asset!=null) {
            try {
                if (asset.equals("r")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_ROBOTO_REGULAR);
                }else if (asset.equals("b")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_ROBOTO_BOLD);
                }else if (asset.equals("sb")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_MEDIUM);
                }else if (asset.equals("bold")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_ROBOTO_BOLD);
                } else if (asset.equals("semibold")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_SEMIBOLD);
                } else if (asset.equals("thin")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_ROBOTO_REGULAR);
                }  else if (asset.equals("regular")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_ROBOTO_REGULAR);
                }else if (asset.equals("light")) {
                    tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_ROBOTO_REGULAR);
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

    private void setDrawable(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray attributeArray = context.obtainStyledAttributes(
                    attrs,
                    R.styleable.CustomEditText);

            Drawable drawableLeft = null;
            Drawable drawableRight = null;
            Drawable drawableBottom = null;
            Drawable drawableTop = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                drawableLeft = attributeArray.getDrawable(R.styleable.CustomEditText_drawableLeftCompat);
                drawableRight = attributeArray.getDrawable(R.styleable.CustomEditText_drawableRightCompat);
                drawableBottom = attributeArray.getDrawable(R.styleable.CustomEditText_drawableBottomCompat);
                drawableTop = attributeArray.getDrawable(R.styleable.CustomEditText_drawableTopCompat);
            } else {
                final int drawableLeftId = attributeArray.getResourceId(R.styleable.CustomEditText_drawableLeftCompat, -1);
                final int drawableRightId = attributeArray.getResourceId(R.styleable.CustomEditText_drawableRightCompat, -1);
                final int drawableBottomId = attributeArray.getResourceId(R.styleable.CustomEditText_drawableBottomCompat, -1);
                final int drawableTopId = attributeArray.getResourceId(R.styleable.CustomEditText_drawableTopCompat, -1);

                if (drawableLeftId != -1)
                    drawableLeft = AppCompatResources.getDrawable(context, drawableLeftId);
                if (drawableRightId != -1)
                    drawableRight = AppCompatResources.getDrawable(context, drawableRightId);
                if (drawableBottomId != -1)
                    drawableBottom = AppCompatResources.getDrawable(context, drawableBottomId);
                if (drawableTopId != -1)
                    drawableTop = AppCompatResources.getDrawable(context, drawableTopId);
            }
            setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);
            attributeArray.recycle();
        }
    }
}
