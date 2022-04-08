package com.mw.eleven11.customView;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mw.eleven11.R;
import com.mw.eleven11.utility.AppUtils;

import java.util.ArrayList;

public class StepperView extends LinearLayout {

    private CustomTextView current_bid,current_bid_x;
    private ArrayList<String> mList = new ArrayList<>();
    private long eventTime=0;
    private int current = 0;
    private long delay=200;
    private View overlay;
    Handler mHandler = new Handler();

    public StepperView(Context context) {
        super(context);
    }


    public StepperView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  view  /= inflater.inflate(R.layout.stepper_view, this, true);
        View view = inflater.inflate(R.layout.stepper_view, this, true);

        ImageView minus = view.findViewById(R.id.minus);
        ImageView plus = view.findViewById(R.id.plus);
        overlay= view.findViewById(R.id.ll_overlay);
        current_bid = view.findViewById(R.id.current_bid);
        current_bid_x = view.findViewById(R.id.current_bid_x);


       /* minus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current > 0) {
                    --current;
                    current_bid.setText(mList.get(current));

                }
            }
        });*/

        minus.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("setOnTouchListener", "onTouch: "+event.getAction());

                if (event.getAction()== MotionEvent.ACTION_DOWN) {
                    mHandler.post(mRunnableDecrees);
                }else if (event.getAction()== MotionEvent.ACTION_UP){
                    mHandler.removeCallbacks(mRunnableDecrees);
                }
                /*if (current > 0) {
                    --current;
                    current_bid.setText(mList.get(current));

                }*/
                return true;
            }
        });

        plus.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()== MotionEvent.ACTION_DOWN) {
                    mHandler.post(mRunnableIncrees);
                }else if (event.getAction()== MotionEvent.ACTION_UP){
                    mHandler.removeCallbacks(mRunnableIncrees);
                }
                return true;
            }
        });

        /*plus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mList.size() - 1 > current) {
                    ++current;
                    current_bid.setText(mList.get(current));

                }
            }
        });*/

        if (isEnabled()) {
            overlay.setVisibility(GONE);
        }else {
            overlay.setVisibility(VISIBLE);
        }

    }

    public void setCurrent(int index){
        if (index>-1&&index<mList.size()) {
            current=index;
            current_bid.setText(mList.get(current));
            current_bid_x.setText(mList.get(current));
        }
    }

    public void addList(ArrayList<String> list) {
        mList.addAll(list);
        if (mList.size() > 0) {
            current_bid.setText(mList.get(current));
            current_bid_x.setText(mList.get(current));
        }

    }

    public String getCurrent() {
        return mList.get(current);
    }

    public StepperView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    Runnable mRunnableIncrees = new Runnable() {
        @Override
        public void run() {
            if (mList.size() - 1 > current) {
                AppUtils.clickVibrate(getContext());
                ++current;
                current_bid.post(new Runnable() {
                    @Override
                    public void run() {
                        current_bid.setText(mList.get(current));
                        current_bid_x.setText(mList.get(current));
                    }
                });
            }
            mHandler.postDelayed(mRunnableIncrees,delay);
        }
    };

    Runnable mRunnableDecrees = new Runnable() {
        @Override
        public void run() {

            if (current > 0) {
                AppUtils.clickVibrate(getContext());
                --current;
                current_bid.post(new Runnable() {
                    @Override
                    public void run() {
                        current_bid.setText(mList.get(current));
                        current_bid_x.setText(mList.get(current));
                    }
                });
            }

            mHandler.postDelayed(mRunnableDecrees,delay);
        }
    };


    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            overlay.setVisibility(GONE);
        }else {
            overlay.setVisibility(VISIBLE);
        }
    }

}
