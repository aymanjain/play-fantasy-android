package com.mw.eleven11.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.content.res.AppCompatResources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.mw.eleven11.AppConfiguration;
import com.mw.eleven11.R;


public class CustomEditText extends EditText implements TextWatcher {
    private Typeface tf = null, tfhint = null;
    private String customhintfont, customFont;
    boolean inputtypepassword, isemoji = true;
    private CharSequence chartype;
    private DrawableClickListener clickListener;

    public CustomEditText(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        // initViews();
    }

    @Override
    public void setError(CharSequence error) {
        super.setError(error);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        // initViews();
        setCustomFontEdittext(context, attrs);
        //setDrawable(context, attrs);

    }

    public void setDrawableClickListener(DrawableClickListener listener) {
        this.clickListener = listener;
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        // initViews();
        setCustomFontEdittext(context, attrs);
        // setDrawable(context, attrs);
    }

    private void setCustomFontEdittext(Context ctx, AttributeSet attrs) {
        final TypedArray a = ctx.obtainStyledAttributes(attrs,
                R.styleable.CustomEditText);
        customFont = a.getString(R.styleable.CustomEditText_textfont);
        customhintfont = a.getString(R.styleable.CustomEditText_hintfont);
        inputtypepassword = a.getBoolean(R.styleable.CustomEditText_edittextpwd, false);
        isemoji = a.getBoolean(R.styleable.CustomEditText_isemoji, true);
        setCustomFontEdittext(ctx, customFont);
        setCustomFontEdittextHint(ctx, customhintfont);
        chartype = (CharSequence) a.getText(R.styleable.CustomEditText_editcharpwd);
        setCustompwd(inputtypepassword);
        setEmojiFilter(isemoji);
        a.recycle();
    }

    public boolean setCustompwd(boolean pwd) {
        if (pwd) {
            this.setTransformationMethod(new PasswordCharacterChange());
        }
        return pwd;
    }

    public boolean setEmojiFilter(boolean isemoji) {
        if (!isemoji) {
            this.setFilters(new InputFilter[]{EMOJI_FILTER});
        }
        return isemoji;
    }

    public boolean setCustomFontEdittext(Context ctx, String asset) {
        try {
            if (asset.equals("b")) {
                tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_BOLD);
            } else if (asset.equals("r")) {
                tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_REGULAR);
            } else if (asset.equals("sb")) {
                tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_SEMIBOLD);
            } else {
                tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_REGULAR);
            }
        } catch (Exception e) {
            return false;
        }
        setTypeface(tf);
        return true;
    }

    public boolean setCustomFontEdittextHint(Context ctx, String asset) {
        try {
            if (asset.equals("b")) {
                tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_BOLD);
            } else if (asset.equals("r")) {
                tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_REGULAR);
            } else if (asset.equals("sb")) {
                tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_SEMIBOLD);
            } else {
                tf = Typeface.createFromAsset(ctx.getAssets(), AppConfiguration.APP_FONT_REGULAR);
            }
        } catch (Exception e) {
            return false;
        }
        setTypeface(tfhint);
        return true;
    }

    @Override
    public void afterTextChanged(Editable s) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore,
                              int lengthAfter) {
        if (text.length() < 0) {
            setCustomFontEdittextHint(getContext(), customhintfont);
        } else {
            setCustomFontEdittextHint(getContext(), customFont);
        }
        if (TextUtils.isEmpty(text)) {
            setCustomFontEdittextHint(getContext(), customhintfont);
        }
    }

    public class PasswordCharacterChange extends PasswordTransformationMethod {

        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            // TODO Auto-generated method stub
            return new PasswordCharSequence(source);
        }

        private class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;

            public PasswordCharSequence(CharSequence source) {
                mSource = source; // Store char sequence
            }

            public char charAt(int index) {
                return chartype.charAt(0); // This is the important part
            }

            public int length() {
                return mSource.length(); // Return default
            }

            public CharSequence subSequence(int start, int end) {
                return mSource.subSequence(start, end); // Return default
            }
        }
    }

    public InputFilter EMOJI_FILTER = new InputFilter() {

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            for (int index = start; index < end; index++) {

                int type = Character.getType(source.charAt(index));

                if (type == Character.SURROGATE) {
                    return "";
                }
            }
            return null;
        }
    };

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

    public interface DrawableClickListener {

        public void onClick(DrawablePosition target);

        ;

        public static enum DrawablePosition {TOP, BOTTOM, LEFT, RIGHT}
    }
}
