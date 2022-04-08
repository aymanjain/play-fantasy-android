package com.mw.eleven11.utility;

import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;

import com.mw.eleven11.R;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by mobiweb on 12/9/17.
 */

public class TimeUtils {
    public static String getDefaultTimeZone() {
        return TimeZone.getDefault().getID();
        // "Asia/Seoul"
    }

    public static String getUTCTimeFormat(Date date) {
        try {
            SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            YYYY_MM_DD_HH_MM_SS.setTimeZone(TimeZone.getTimeZone("UTC"));
            return YYYY_MM_DD_HH_MM_SS.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }

    public static String getStandardUTCDateFormat(Date date) {
        try {
            SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            YYYY_MM_DD_HH_MM_SS.setTimeZone(TimeZone.getTimeZone("UTC"));
            return YYYY_MM_DD_HH_MM_SS.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }

    public static String getStandardUTCDateOnlyFormat(Date date) {
        try {
            SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            return YYYY_MM_DD_HH_MM_SS.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }

    public static String getStandardUTCTimeFormat(Date date) {
        try {
            SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("HH:mm", Locale.getDefault());
            YYYY_MM_DD_HH_MM_SS.setTimeZone(TimeZone.getTimeZone("UTC"));
            Log.i("StandardUTCTimeFormat", "StandardUTCTimeFormat:" + YYYY_MM_DD_HH_MM_SS.format(date));
            return YYYY_MM_DD_HH_MM_SS.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }

    public static String getShowTimeFormat(Date date) {
        try {
            return new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }

    public static String getShowDateFormat(Date date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }

    public static Date getDateByFormat(String date) {
        try {
            if (TextUtils.isEmpty(date)) return new Date();
            if (date.equalsIgnoreCase("N/A")) return new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(date);
        } catch (Exception e1) {
            e1.printStackTrace();
            return null;
        }
    }

    public static Calendar getCalByFormat(String updateTime) {
        try {

            Calendar myCalendar = Calendar.getInstance();
            if (TextUtils.isEmpty(updateTime)) return null;
            if (updateTime.equalsIgnoreCase("N/A")) return null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            myCalendar.setTime(dateFormat.parse(updateTime));
            return myCalendar;
        } catch (Exception e1) {
            e1.printStackTrace();
            return null;
        }
    }

    public static long getTimeDifference(String callingTime, String updateTime) {
        try {
            Calendar callingCalendar = Calendar.getInstance();
            callingCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(callingTime));

            Calendar updateCalendar = Calendar.getInstance();
            updateCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(updateTime));


            return callingCalendar.getTimeInMillis() - updateCalendar.getTimeInMillis();
        } catch (Exception e1) {
            e1.printStackTrace();
            return 0;
        }
    }

    public static int getAgeDifference(Date ageDob) {
        if (ageDob == null) return 0;
        Calendar dob = getCalendar(ageDob);
        Calendar today = Calendar.getInstance(Locale.getDefault());
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTime(date);
        return cal;
    }


    public static String getRemainingMatchTime(long timeInMilliSeconds) {
        long seconds = timeInMilliSeconds / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours/24;
        if (days>1){
            return days+" days left";
        }else if (hours>=12){
            return String.format("%dh left", hours);
        }else if (hours>=1){
            return String.format("%dh %dm left", hours, minutes % 60);
        }else if (minutes>=1){
            return String.format("%dm %ds", minutes % 60, seconds % 60);
        }else if (seconds>=1){
            return String.format("%ds", seconds % 60);
        }else {
            return AppUtils.getStrFromRes(R.string.Running);
        }
    }

    public static String getRemainsTime(long timeInMilliSeconds) {
        long seconds = timeInMilliSeconds / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        if (hours <= 0) {
            return String.format("%dm %ds", minutes % 60, seconds % 60);
        } else if (minutes <= 0) {
            return String.format("%ds", seconds % 60);
        } else {
            return String.format("%dh %dm left", hours, minutes % 60);
        }
    }

    public static String getRemainsT(long timeInMilliSeconds) {
        long seconds = timeInMilliSeconds / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        if (hours <= 0) {
            return String.format("%dm %ds", minutes % 60, seconds % 60);
        } else if (minutes <= 0) {
            return String.format("%ds", seconds % 60);
        } else {
            return String.format("%dh %dm %ds", hours, minutes % 60, seconds % 60);
        }
    }


    public static String getRemainsTimeOld(long timeInMilliSeconds) {
        long seconds = timeInMilliSeconds / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        if (hours % 24 <= 0) {
            return String.format("%dm %ds", minutes % 60, seconds % 60);
        } else if (minutes % 60 <= 0) {
            return String.format("%ds", seconds % 60);
        } else {
            return String.format("%dh %dm %ds", hours % 24, minutes % 60, seconds % 60);
        }
    }

    public static String getTimeString(long millis) {
        int minutes = (int) (millis / (60 * 1000));
        int seconds = (int) ((millis / 1000) % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }

    public static String getTimeDuration(long millis) {
        int minutes = (int) (millis / (60 * 1000));
        int seconds = (int) ((millis / 1000) % 60);
        return String.format("%02dm %02ds", minutes, seconds);
    }

    public static String getPlayingTime(long millis) {
        int minutes = (int) (millis / (60 * 1000));
        int seconds = (int) ((millis / 1000) % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }

    public static String convertMilisecToMmSs(long millisUntilFinished) {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
    }

    public static String getDisplayDate(String updateTime) {
        try {
            if (TextUtils.isEmpty(updateTime)) return "N/A";
            if (updateTime.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("HH:mm:ss dd/MM/yyyy", Locale.getDefault()).format(dateFormat.parse(updateTime));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    public static String getDisplayDateOnly(String updateTime) {
        try {
            if (TextUtils.isEmpty(updateTime)) return "N/A";
            if (updateTime.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(dateFormat.parse(updateTime));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    public static boolean isThisDateValid(String dateToValidate, String dateFromat) {

        if (dateToValidate == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
        try {
            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String getPast10DayDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -10);
        Date newDate = calendar.getTime();
        SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        return YYYY_MM_DD_HH_MM_SS.format(newDate);
    }


    public static String getCurrentUTCTimeFormat() {
        try {
            Date date = Calendar.getInstance().getTime();
            SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            YYYY_MM_DD_HH_MM_SS.setTimeZone(TimeZone.getTimeZone("UTC"));
            Log.i("StandardUTCTimeFormat", "StandardUTCTimeFormat:" + YYYY_MM_DD_HH_MM_SS.format(date));
            return YYYY_MM_DD_HH_MM_SS.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }

    public static String getMatchDateOnly(String updateDate) {
        try {
            if (TextUtils.isEmpty(updateDate)) return "N/A";
            if (updateDate.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(dateFormat.parse(updateDate));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    public static String getMatchdaysOnly(String updateDate) {
        try {
            if (TextUtils.isEmpty(updateDate)) return "N/A";
            if (updateDate.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));


            return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(dateFormat.parse(updateDate));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    public static String getRemainingTime(Long duration) {
        try {


            long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
            long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
            String currentTime;
            if (diffInDays >= 2) {
                currentTime = String.valueOf(diffInDays) + " days left";
            } else {
                currentTime = String.valueOf(diffInHours) + "h left";
            }


//            return TimeUnit.MILLISECONDS.toMinutes(updateDate.getTime() - currentDate.getTime());
            return currentTime;
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    // Time Format for Series Time
    public static String getSeriesDate(String updateDate) {
        try {
            if (TextUtils.isEmpty(updateDate)) return "N/A";
            if (updateDate.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(dateFormat.parse(updateDate));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    //time format for 12 hours
    public static String getDisplayFullDate(String updateTime) {
        try {
            if (TextUtils.isEmpty(updateTime)) return "N/A";
            if (updateTime.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("dd MMMM, hh:mm a",
                    Locale.getDefault()).format(dateFormat.parse(updateTime));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    //time format for 12 hours
    public static String getOnlyDate(String updateTime) {
        try {
            if (TextUtils.isEmpty(updateTime)) return "N/A";
            if (updateTime.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("dd MMMM, yyyy",
                    Locale.getDefault()).format(dateFormat.parse(updateTime));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    public static String getDisplayFullDate1(String updateTime) {
        try {
            if (TextUtils.isEmpty(updateTime)) return "N/A";
            if (updateTime.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            //dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("hh:mm a dd/MM/yyyy",
                    Locale.getDefault()).format(dateFormat.parse(updateTime));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }


    public static String getDisplayFullDate1(String updateDate, String updateTime) {
        try {

            if (!TextUtils.isEmpty(updateDate) && !TextUtils.isEmpty(updateTime))
                return getDisplayFullDate1(updateDate + " " + updateTime);

            if (TextUtils.isEmpty(updateDate)) return "N/A";

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            // dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("hh:mm a dd/MM/yyyy",
                    Locale.getDefault()).format(dateFormat.parse(updateTime));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    public static String getDisplayFullDateHalf(String updateTime) {
        try {
            if (TextUtils.isEmpty(updateTime)) return "N/A";
            if (updateTime.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return new SimpleDateFormat("dd/MM/yyyy",
                    Locale.getDefault()).format(dateFormat.parse(updateTime));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    public static String getDisplayTime(String updateTime) {
        try {
            if (TextUtils.isEmpty(updateTime)) return "N/A";
            if (updateTime.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("hh:mm a",
                    Locale.getDefault()).format(dateFormat.parse(updateTime));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    public static long getTimeDiffrance(String callStartedDateTime, String currentTime) {
        try {
            Log.i("callStartedDateTime", "callStartedDateTime:" + callStartedDateTime);
            Log.i("currentTime", "currentTime:" + currentTime);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date startDate = dateFormat.parse(callStartedDateTime);
            Date currentDate = dateFormat.parse(currentTime);
            return currentDate.getTime() - startDate.getTime();
        } catch (Exception e1) {
            e1.printStackTrace();
            return 0;
        }
    }

    public static String getCurrentDate() {
        String dateInString = "";
        try {
            String pattern = "yyyy-MM-dd HH:mm:ss";
            dateInString = new SimpleDateFormat(pattern).format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
        return dateInString;

    }


    public static boolean isToday(String updateDate) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(updateDate));
            return DateUtils.isToday(instance.getTimeInMillis());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getNotificationDateOnly(String updateDate) {
        try {
            if (TextUtils.isEmpty(updateDate)) return "N/A";
            if (updateDate.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
// dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(dateFormat.parse(updateDate));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    //time format for 12 hours
    public static String getNotificationTimeOnly(String updateTime) {
        try {
            if (TextUtils.isEmpty(updateTime)) return "N/A";
            if (updateTime.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
// dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(dateFormat.parse(updateTime));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    public static String getDateByFormatInput(String updateDate, String inputFormat, String disiredFormat) {
        try {
            if (TextUtils.isEmpty(updateDate)) return "N/A";
            if (updateDate.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat(inputFormat, Locale.getDefault());
// dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat(disiredFormat, Locale.getDefault()).format(dateFormat.parse(updateDate));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }


    public static String getTransactionDateOnly(String updateTime) {
        try {
            if (TextUtils.isEmpty(updateTime)) return "N/A";
            if (updateTime.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("dd MMMM, yyyy",
                    Locale.getDefault()).format(dateFormat.parse(updateTime));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }

    public static String getTransactionFormat(String updateTime) {
        try {
            if (TextUtils.isEmpty(updateTime)) return "N/A";
            if (updateTime.equalsIgnoreCase("N/A")) return "N/A";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return new SimpleDateFormat("dd MMMM, hh:mm:ss a",
                    Locale.getDefault()).format(dateFormat.parse(updateTime));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "N/A";
        }
    }


}
