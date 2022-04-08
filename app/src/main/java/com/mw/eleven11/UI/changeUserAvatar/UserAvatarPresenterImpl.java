package com.mw.eleven11.UI.changeUserAvatar;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.UpdateProfileInput;
import com.mw.eleven11.beanOutput.AvatarListOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.ResponseUpdateProfile;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;


import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class UserAvatarPresenterImpl implements IUserAvatarPresenter {

    UserAvatarView mMyAccountParentView;
    IUserInteractor mImyAccountParentInteractor;
    Call<AvatarListOutput> responseAvatar;
    Call<LoginResponseOut> responseLoginCall;

    public UserAvatarPresenterImpl(UserAvatarView mMyAccountParentView, IUserInteractor mImyAccountParentInteractor) {
        this.mMyAccountParentView = mMyAccountParentView;
        this.mImyAccountParentInteractor = mImyAccountParentInteractor;
    }

    public void actionListingCancel() {
        if (responseAvatar != null && !responseAvatar.isExecuted())
            responseAvatar.cancel();
    }

    public void actionupdateAvatarCancel() {
        if (responseLoginCall != null && !responseLoginCall.isExecuted())
            responseLoginCall.cancel();
    }

    @Override
    public void users_avatar_list(LoginInput loginInput) {
        {
            actionListingCancel();
            if (!NetworkUtils.isNetworkConnected(mMyAccountParentView.getContext())) {
                mMyAccountParentView.hideLoading();
                mMyAccountParentView.onShowSnackBar(AppUtils.getStrFromRes(R.string.network_error));
            } else {
                mMyAccountParentView.showLoading();
                responseAvatar = mImyAccountParentInteractor.users_icon_list(loginInput, new IUserInteractor.OnAvatarResponseListener() {
                    @Override
                    public void onSuccess(AvatarListOutput mResponseAvatarIcon) {
                        mMyAccountParentView.hideLoading();
                        mMyAccountParentView.onSuccess(mResponseAvatarIcon);
                    }

                    @Override
                    public void onNotFound(String error) {
                        mMyAccountParentView.hideLoading();
                        mMyAccountParentView.onError(error);
                    }

                    @Override
                    public void onError(String errorMsg) {
                        mMyAccountParentView.hideLoading();
                        mMyAccountParentView.onError(errorMsg);
                    }
                });

            }
        }
    }

    @Override
    public void actionUpdateProfile(UpdateProfileInput mUpdateProfileInput) {
        if (!NetworkUtils.isNetworkConnected(mMyAccountParentView.getContext())) {
            mMyAccountParentView.hideLoading();
            mMyAccountParentView.onError(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mMyAccountParentView.showLoading();
            mImyAccountParentInteractor.updateProfile(mUpdateProfileInput, new IUserInteractor.OnResponseUpdateProfileListener() {
                @Override
                public void onSuccess(ResponseUpdateProfile responseUpdate) {
                    if (responseUpdate != null) {
                        mMyAccountParentView.showLoading();
                        mMyAccountParentView.onUpdateSuccess(responseUpdate);
                    } else {
                        mMyAccountParentView.hideLoading();
                        mMyAccountParentView.onError(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    mMyAccountParentView.hideLoading();
                    mMyAccountParentView.onError(errorMsg);
                }
            });
        }
    }


}
