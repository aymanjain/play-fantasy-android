package com.mw.eleven11.beanInput;

import java.util.List;

public class MakeFavoriteTeamInput {


    /**
     * SessionKey : 87acf8de-0703-8b2d-148a-abd697217109
     * CountryTeamName : ["New Zealand","England"]
     */

    private String SessionKey;
    private List<String> CountryTeamName;

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public List<String> getCountryTeamName() {
        return CountryTeamName;
    }

    public void setCountryTeamName(List<String> CountryTeamName) {
        this.CountryTeamName = CountryTeamName;
    }
}
