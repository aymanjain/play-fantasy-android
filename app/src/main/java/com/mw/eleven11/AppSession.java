package com.mw.eleven11;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.beanOutput.ResponseFilter;
import com.mw.eleven11.beanOutput.ResponseMatchPlayers;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


public class AppSession {
    private static String PREFERENCE_NAME = "Preference";
    private static String RememberPREFERENCE_NAME = "Remember_Preference";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static SharedPreferences.Editor rememberme_editor;
    private static SharedPreferences sharedPreferences_rememberme;
    private static AppSession mAppSession;

    public String UserInviteCode = "";
    public String MatchTeamVS = "";
    public PlayersOutput.DataBean.RecordsBean playerPoints;

    //create singleton instances of app session
    public static AppSession getInstance() {
        if (mAppSession == null)
            mAppSession = new AppSession(AppController.getContext());
        return mAppSession;

    }

    //get sharedPreferences as singleton
    private AppSession(Context mContext) {
        if (sharedPreferences == null)
            sharedPreferences = getSharedPreferences(mContext);
        sharedPreferences_rememberme = getSharedPreferencesRememberme(mContext);

        if (editor == null)
            editor = sharedPreferences.edit();
        if (rememberme_editor == null)
            rememberme_editor = sharedPreferences_rememberme.edit();
    }

    public String getSessionContestCode() {
        return sharedPreferences.getString("sessionContestCode", "");
    }

    public void setSessionContestCode(String value) {
        editor.putString("sessionContestCode", value);
        editor.commit();
    }

    //create singleton instances of sharedPreferences
    private SharedPreferences getSharedPreferences(Context mContext) {
        return mContext.getSharedPreferences(PREFERENCE_NAME + mContext.getPackageName(), Context.MODE_PRIVATE);
    }

    private SharedPreferences getSharedPreferencesRememberme(Context mContext) {
        return mContext.getSharedPreferences(RememberPREFERENCE_NAME + mContext.getPackageName(), Context.MODE_PRIVATE);
    }

    //clear session during logout
    public void clearSession() {
        editor.clear();
        editor.commit();
        removeFile();
    }


    //set login session
    public void setLoginSession(LoginResponseOut responseLogin) {
//        editor.putString(Constant.RESPONSE_LOGIN, new Gson().toJson(responseLogin).toString());
//        editor.commit();

        saveData(responseLogin);
    }


    //set team response
    public void setTeamSession(ResponseMatchPlayers mResponseMatchPlayers) {
        editor.putString(Constant.RESPONSE_TEAM, new Gson().toJson(mResponseMatchPlayers).toString());
        editor.commit();
    }

    public void setRememberMeSession(String username, String password, boolean isremember) {
        rememberme_editor.putString("username", username);
        rememberme_editor.putString("password", password);
        rememberme_editor.putBoolean("isremember", isremember);
        rememberme_editor.commit();
    }

    //get language and default language would be english
    public String getusername() {
        return sharedPreferences_rememberme.getString("username", "");
    }

    public String getpassword() {
        return sharedPreferences_rememberme.getString("password", "");
    }

    public boolean isremember() {
        return sharedPreferences_rememberme.getBoolean("isremember", false);
    }

    public boolean isLoginAgain() {
        return sharedPreferences.getBoolean("isLoginAgain", true);
    }

    public void setIsLoginAgain(boolean bool) {
        editor.putBoolean("isLoginAgain", bool);
        editor.commit();
    }

    //get login session
    public LoginResponseOut getLoginSession() {
        try {

//            LoginResponseOut responseLogin = new Gson().fromJson(sharedPreferences.
//                    getString(Constant.RESPONSE_LOGIN,
//                            ""), LoginResponseOut.class);

            return loadData(AppController.getContext());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //get team session
    public ResponseMatchPlayers getTeamSession() {
        try {
            ResponseMatchPlayers responseTeam = new Gson().fromJson(sharedPreferences.
                    getString(Constant.RESPONSE_TEAM, ""), ResponseMatchPlayers.class);

            return responseTeam;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clearTeamSession() {
        try {

            editor.remove(Constant.RESPONSE_TEAM);
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //clear filter session
    public void clearFilterSession() {
        editor.putString(Constant.RESPONSE_FILTER, "");
        editor.commit();
    }

    //set filter session
    public void setFilterSession(ResponseFilter session) {
        editor.putString(Constant.RESPONSE_FILTER, new Gson().toJson(session));
        editor.commit();
    }

    //get login session
    public ResponseFilter getFilterSession() {
        try {
            if (TextUtils.isEmpty(sharedPreferences.getString(Constant.RESPONSE_FILTER, ""))) {
                return new Gson().fromJson(AppUtils.getRawToJson(R.raw.filter), ResponseFilter.class);
            } else {
                return new Gson().fromJson(sharedPreferences.getString(Constant.RESPONSE_FILTER, ""), ResponseFilter.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Gson().fromJson(AppUtils.getRawToJson(R.raw.filter), ResponseFilter.class);
        }
    }


    /*public void updateUserImage(String url) {
        ResponseLogin responseLogin = getLoginSession();
        responseLogin.getResponse().setUserImage(url);
        setLoginSession(responseLogin);
    }

    public void updateMobile(String mobile) {
        ResponseLogin responseLogin = getLoginSession();
        responseLogin.getResponse().setMobile(mobile);
        responseLogin.getResponse().setMobileVerify("1");
        setLoginSession(responseLogin);
    }

    public void setIsFirstLogin(String status) {
        ResponseLogin responseLogin = getLoginSession();
        responseLogin.getResponse().setIsFirstLogin("2");
        setLoginSession(responseLogin);
    }*/

    //get language and default language would be english
    public String getLanguage() {
        return sharedPreferences.getString("Language", "en");
    }


    //set language code
    public void setLanguage(String value) {
        editor.putString("Language", value);
        editor.commit();
    }

    public int getGameType() {
        return sharedPreferences.getInt("gametype", 1);
    }

    public void setGameType(int value) {
        editor.putInt("gametype", value);
        editor.commit();
    }


    public int getPlayMode() {
        return sharedPreferences.getInt(Constant.PLAY_MODE, 0);
    }

    public void setPlayMode(int value) {
        editor.putInt(Constant.PLAY_MODE, value);
        editor.commit();
    }


    public boolean isWalkThroughShown() {
        return sharedPreferences.getBoolean(Constant.WALK_THROUGH_STATUS, false);
    }

    public void setWalkThroughShown(boolean val) {
        editor.putBoolean(Constant.WALK_THROUGH_STATUS, val);
        editor.commit();
    }

    public void setBadges(String value) {
        editor.putString("setBadges", value);
        editor.commit();
    }

    public String getBadges() {
        return sharedPreferences.getString("setBadges", "0");
    }

    public void setString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getSelectedPayFilter() {
        String filter = "";
        if (getFilterSession() != null) {
            for (int i = 0; i < getFilterSession().getPay().size(); i++) {
                if (getFilterSession().getPay().get(i).isSelected()) {
                    if (TextUtils.isEmpty(filter)) {
                        filter = getFilterSession().getPay().get(i).getValue();
                    } else {
                        filter = filter + "," + getFilterSession().getPay().get(i).getValue();
                    }
                }
            }
        }
        if (TextUtils.isEmpty(filter)) return "all";
        return filter;
    }

    public String getSelectedWinFilter() {
        String filter = "";
        if (getFilterSession() != null) {
            for (int i = 0; i < getFilterSession().getWin().size(); i++) {
                if (getFilterSession().getWin().get(i).isSelected()) {
                    if (TextUtils.isEmpty(filter)) {
                        filter = getFilterSession().getWin().get(i).getValue();
                    } else {
                        filter = filter + "," + getFilterSession().getWin().get(i).getValue();
                    }
                }

            }
        }
        if (TextUtils.isEmpty(filter)) return "all";
        return filter;
    }


    public String getSelectedSizeFilter() {
        String filter = "";
        if (getFilterSession() != null) {
            for (int i = 0; i < getFilterSession().getSize().size(); i++) {
                if (getFilterSession().getSize().get(i).isSelected()) {
                    if (TextUtils.isEmpty(filter)) {
                        filter = getFilterSession().getSize().get(i).getValue();
                    } else {
                        filter = filter + "," + getFilterSession().getSize().get(i).getValue();
                    }
                }
            }
        }
        if (TextUtils.isEmpty(filter)) return "all";
        return filter;
    }

    public String getSelectedContainTypeFilter() {
        String filter = "";
        if (getFilterSession() != null) {
            for (int i = 0; i < getFilterSession().getContets_type().size(); i++) {
                if (getFilterSession().getContets_type().get(i).isSelected()) {
                    if (TextUtils.isEmpty(filter)) {
                        filter = getFilterSession().getContets_type().get(i).getValue();
                    } else {
                        filter = filter + "," + getFilterSession().getContets_type().get(i).getValue();
                    }
                }

            }
        }
        if (TextUtils.isEmpty(filter)) return "all";
        return filter;
    }


    private static File mFolder;

    public void saveData(LoginResponseOut pContext) {
        //this could be initialized once onstart up
        if (mFolder == null) {
            mFolder = AppController.getContext().getExternalFilesDir(null);
        }
        ObjectOutput out;
        try {
            File outFile = new File(mFolder,
                    "user.data");
            out = new ObjectOutputStream(new FileOutputStream(outFile));
            out.writeObject(pContext);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LoginResponseOut loadData(Context pContext) {
        if (mFolder == null) {
            mFolder = pContext.getExternalFilesDir(null);
        }
        ObjectInput in;
        LoginResponseOut lUser = null;
        File file = new File(mFolder.getPath() + File.separator + "user.data");

        if (file.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream(mFolder.getPath() + File.separator + "user.data");
                in = new ObjectInputStream(fileIn);
                lUser = (LoginResponseOut) in.readObject();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (lUser != null) {
            Log.d("current User: ", lUser.getData().getFullName());
        } else {
            Log.d("current User: ", "null");
        }
        return lUser;
    }

    public void removeFile() {
        if (mFolder == null) {
            mFolder = AppController.getContext().getExternalFilesDir(null);
        }
        File file = new File(mFolder.getPath() + File.separator + "user.data");
        if (file.exists()) {
            file.delete();
        }

    }
}
