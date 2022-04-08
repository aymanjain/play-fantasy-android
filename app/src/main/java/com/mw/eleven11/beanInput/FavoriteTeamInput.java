package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class FavoriteTeamInput {


    /**
     * SessionKey : 87acf8de-0703-8b2d-148a-abd697217109
     * Params : CountryTeamName,CountryFlag,IsUserFavourite
     * IsDefaultFavourite : Yes
     */

    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("Params")
    private String Params;
    @SerializedName("IsDefaultFavourite")
    private String IsDefaultFavourite;

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }

    public String getIsDefaultFavourite() {
        return IsDefaultFavourite;
    }

    public void setIsDefaultFavourite(String IsDefaultFavourite) {
        this.IsDefaultFavourite = IsDefaultFavourite;
    }
}
