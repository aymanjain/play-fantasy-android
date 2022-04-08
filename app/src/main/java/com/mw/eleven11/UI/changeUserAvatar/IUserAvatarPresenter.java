package com.mw.eleven11.UI.changeUserAvatar;


import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.UpdateProfileInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface IUserAvatarPresenter {
    //cricket
    void users_avatar_list(LoginInput loginInput);

    void actionUpdateProfile(UpdateProfileInput mUpdateProfileInput);


}
