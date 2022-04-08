package com.mw.eleven11.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.facebook.drawee.view.SimpleDraweeView;

import com.mw.eleven11.R;


/**
 * Created by Rahul on 5/17/2016.
 */
public class CustomImageView extends SimpleDraweeView {

    Context context;
    String imageType;
    int normalWidth, normalHeight;

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomImageView);
        imageType = a.getString(R.styleable.CustomImageView_image_type);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        normalWidth = widthMeasureSpec;
        normalHeight = heightMeasureSpec;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (TextUtils.isEmpty(imageType))
            imageType = "1";
        if (imageType.equals("0")) {
            setMeasuredDimension(normalWidth, normalHeight);
        } else if (imageType.equals("1")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, width);
        } else if (imageType.equals("2")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, (int) width / 2);
        } else if (imageType.equals("3")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, (int) width * 2 / 3);
        } else if (imageType.equals("4")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, (int) width * 3 / 2);
        } else if (imageType.equals("5")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, (int) width * 5 / 4);
        } else if (imageType.equals("6")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, (int) width * 2);
        } else if (imageType.equals("7")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, (int) width /4);
        }
    }

    public void setImageType(String tem) {
        imageType = tem;
        if (imageType.equals("0")) {
            setMeasuredDimension(normalWidth, normalHeight);
        } else if (imageType.equals("1")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, width);
        } else if (imageType.equals("2")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, (int) width / 2);
        } else if (imageType.equals("3")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, (int) width * 2 / 3);
        } else if (imageType.equals("4")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, (int) width * 3 / 2);
        } else if (imageType.equals("5")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, (int) width * 5 / 4);
        } else if (imageType.equals("6")) {
            int width = getMeasuredWidth();
            setMeasuredDimension(width, (int) width * 2);
        }
    }

}
