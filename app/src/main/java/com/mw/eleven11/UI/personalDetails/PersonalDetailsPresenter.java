package com.mw.eleven11.UI.personalDetails;

import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.UpdateProfileInput;



public interface PersonalDetailsPresenter {

    void actionStatesBtn(String userLoginSessionKey, String countryId);

    void actionViewProfile(LoginInput mLoginInput);

    void actionUpdateProfile(UpdateProfileInput mUpdateProfileInput);
}
