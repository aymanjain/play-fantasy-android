package com.mw.eleven11.UI.panVerify;


import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.UploadImageInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface IVerifyPanPresenter {

    void actionViewProfile(LoginInput loginInput);

    void uploadImage(UploadImageInput uploadImageInput);

    void actionCountriesBtn(String userLoginSessionKey);

    void actionStatesBtn(String userLoginSessionKey, String countryId);
}
