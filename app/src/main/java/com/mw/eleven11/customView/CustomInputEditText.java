package com.mw.eleven11.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;

import com.rey.material.widget.EditText;

import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.R;


public class CustomInputEditText extends EditText {

    public CustomInputEditText(Context mContext) {
        super(mContext);
        setCustomFontEdittext(mContext, "");
        setCustomFontEdittextHint(mContext, "");
    }

    @Override
    public void setError(CharSequence error) {
        super.setError(error);
    }

    public CustomInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFontEdittext(context, attrs);
        setDrawable(context, attrs);

    }

    public CustomInputEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFontEdittext(context, attrs);
        setDrawable(context, attrs);
    }

    private void setCustomFontEdittext(Context mContext, AttributeSet attrs) {
        final TypedArray mTypedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CustomEditText);
        setCustomFontEdittext(mContext, mTypedArray.getString(R.styleable.CustomEditText_text_font));
        setCustomFontEdittextHint(mContext, mTypedArray.getString(R.styleable.CustomEditText_hint_font));
        mTypedArray.recycle();
    }

    public boolean setCustomFontEdittext(Context ctx, String asset) {
        try {
            if (asset == null || asset.equals("r")){
                setTypeface(Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_REGULAR));
            }else if (asset.trim().equalsIgnoreCase("b")){
                setTypeface(Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_BOLD));
            }else {
                setTypeface(Typeface.createFromAsset(ctx.getAssets(), asset.trim()));
            }
        } catch (Exception e) {
            setTypeface(Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_REGULAR));
        } finally {
            return true;
        }
    }

    public boolean setCustomFontEdittextHint(Context ctx, String asset) {
        try {
            if (asset == null || asset.equals("r")){
                setTypeface(Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_REGULAR));
            }else if (asset.trim().equalsIgnoreCase("b")){
                setTypeface(Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_BOLD));
            }else {
                setTypeface(Typeface.createFromAsset(ctx.getAssets(), asset.trim()));
            }
        } catch (Exception e) {
            setTypeface(Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_REGULAR));
        } finally {
            return true;
        }
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
