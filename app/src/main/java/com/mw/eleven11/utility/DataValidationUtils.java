package com.mw.eleven11.utility;

import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataValidationUtils {

    public static final String PERSON_FULL_NAME_PATTERN = "^[\\p{L} .'-]+$";
    public static final String PERSON_FIRST_NAME_OR_LAST_NAME_PATTERN = "^[\\\\p{L} .'-]+$";

    public static boolean isValidEmail(String emailAddress) {
        return Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches();
    }

    public static boolean isValidEmailMobile(String emailMobile) {

        boolean mBool = false;
        mBool = Patterns.EMAIL_ADDRESS.matcher(emailMobile).matches();
        if (!mBool) {
            if (emailMobile.contains("[a-zA-Z]+") == false && emailMobile.length() == 10) {

                mBool = true;
            }
        }


        return mBool;
    }

    public static boolean isTeamName(String teamName) {
        return Pattern.compile(PERSON_FULL_NAME_PATTERN).matcher(teamName).matches();
    }

    public static boolean isValidPassword(String password) {

        return password.length()<6;
    }
    public static boolean isPasswordValid( String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);



        return matcher.matches();

    }

    /* method for checking valid email-id */
    public static boolean isValidUrl(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.WEB_URL.matcher(target).matches();
        }
    }

    public static boolean isValidPersonFirstOrLastName(String personFirstorLastName) {
        return Pattern.compile(PERSON_FIRST_NAME_OR_LAST_NAME_PATTERN).matcher(personFirstorLastName).matches();
    }

    public static boolean isValidPersonFullName(String personFirstorLastName) {
        return Pattern.compile(PERSON_FULL_NAME_PATTERN).matcher(personFirstorLastName).matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Patterns.PHONE.matcher(phoneNumber).matches();
    }

    /* method for mobile number validation */
    public final static Pattern MOBILE_NUMBER_PATTERN = Pattern
            .compile("^[0-9]{10}$");

    public static boolean checkMobile(String mobile) {
        try {
            mobile = mobile.replaceAll("[^0-9]", "");
            return MOBILE_NUMBER_PATTERN.matcher(mobile).matches();
        } catch (Exception exception) {
            return false;
        }
    }

    public static boolean isValidAddress(String address) {
        return true;
    }

    public static boolean isTextEmoticonsFree(String text) {
        return true;
    }

    /*
     * support all language
     * should not contain any special character
     *
     */
    public static boolean isSpecialCharacterFree(String text) {
        return true;
    }

    /*
     *
     *
     */
    public static boolean isValidAmount(String amount) {
        try {
            double am = Double.parseDouble(amount);
            return am > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
