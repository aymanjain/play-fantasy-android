package com.mw.eleven11.UI.homeFragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mw.eleven11.R;
import com.mw.eleven11.beanOutput.ResponseBanner;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.utility.DataValidationUtils;
import com.mw.eleven11.utility.ViewUtils;

import java.util.List;


/**
 * Created by mobiweb on 18/7/16.
 */
public class MultipleImageAdapter extends PagerAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;
    List<ResponseBanner.DataBean.RecordsBean> imageList;

    public MultipleImageAdapter(Context context, List<ResponseBanner.DataBean.RecordsBean> imageList) {
        mContext = context;
        this.imageList = imageList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return imageList==null?0:imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View child = null;
        child = mLayoutInflater.inflate(R.layout.multiple_image_item, container, false);

        CustomImageView imageView = (CustomImageView) child.findViewById(R.id.civ_gallery);

        ViewUtils.setImageUrl(imageView, imageList.get(position).getMediaURL());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DataValidationUtils.isValidUrl(imageList.get(position).getMediaURL())) {
                    // OutSideEvent.start(mContext,"BANNER",imageList.get(position).getUrl());
                }
            }
        });

        container.addView(child);
        return child;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //   return title[position];
        return null;
    }
}
