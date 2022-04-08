package com.mw.eleven11.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.widget.DatePicker;

import com.mw.eleven11.R;
import com.mw.eleven11.utility.TimeUtils;
import com.mw.eleven11.utility.ViewUtils;

import java.util.Calendar;

public class DatePickerDialog {
    private Context context;
    private android.app.DatePickerDialog alertDialog;
    private Calendar mCalendar;
    private OnClickListener onClickListener;

    public void show() {
        alertDialog.show();
        ViewUtils.hideKeyboard(context);
    }

    public void hide() {
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
            ViewUtils.hideKeyboard(context);
        }
    }

    public void setMinDate(Calendar calendar) {
        if (alertDialog != null) {
            alertDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        }
    }

    public void setMaxDate(Calendar calendar) {
        if (alertDialog != null) {
            alertDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
        }
    }

    public String getStandardDate() {
        if (mCalendar != null) {
            return TimeUtils.getStandardUTCDateFormat(mCalendar.getTime());
        }
        return "";
    }

    public String getStandardDateOnly() {
        if (mCalendar != null) {
            return TimeUtils.getStandardUTCDateOnlyFormat(mCalendar.getTime());
        }
        return "";
    }

    public Calendar getCalendar() {
        return mCalendar;
    }

    public void setCalendar(Calendar calendar) {
        this.mCalendar = calendar;
    }

    public String getShowDate() {
        if (mCalendar != null) {
            return TimeUtils.getShowDateFormat(mCalendar.getTime());
        }
        return "";
    }

    public interface OnClickListener {
        void onDateSet(String date);

        void onStandardDateFormat(String date);
    }

    public DatePickerDialog(final Context context, Calendar calendar, String mTitle, final OnClickListener onClickListener) {

        this.context = context;
        this.mCalendar = calendar;
        this.onClickListener = onClickListener;

        alertDialog = new android.app.DatePickerDialog(this.context, R.style.datepicker, onDateSetListener,
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH));
        alertDialog.setTitle(mTitle);
        if (Build.VERSION.SDK_INT < 21)
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


    }

    final android.app.DatePickerDialog.OnDateSetListener onDateSetListener = new android.app.DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, monthOfYear);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            hide();
            if (onClickListener != null) {
                onClickListener.onDateSet(TimeUtils.getShowDateFormat(mCalendar.getTime()));
                onClickListener.onStandardDateFormat(TimeUtils.getStandardUTCDateFormat(mCalendar.getTime()));
            }
        }
    };

}