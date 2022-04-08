package com.mw.eleven11.UI.notifications;


import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.NotificationDeleteInput;
import com.mw.eleven11.beanInput.NotificationInput;
import com.mw.eleven11.beanInput.NotificationMarkReadInput;
import com.mw.eleven11.beanOutput.DefaultRespose;
import com.mw.eleven11.beanOutput.NotificationsResponse;
import com.mw.eleven11.beanOutput.ResponseLogin;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;

import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class NotificationsPresenterImpl implements INotificationsPresenter {

    NotificationsView mView;
    IUserInteractor mInteractor;
    Call<NotificationsResponse> responseMatchesCall;
    Call<ResponseLogin> mResponceReadNotification;

    public NotificationsPresenterImpl(NotificationsView mView, IUserInteractor mInteractor) {
        this.mView = mView;
        this.mInteractor = mInteractor;
    }

    public void actionListingCancel() {
        if (responseMatchesCall != null && !responseMatchesCall.isExecuted())
            responseMatchesCall.cancel();
    }

    public void actionReadCancel() {
        if (mResponceReadNotification != null && !mResponceReadNotification.isExecuted())
            mResponceReadNotification.cancel();
    }

    @Override
    public void actionNotificationsList(final NotificationInput notificationInput) {
        actionListingCancel();
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            if (mView.isLayoutAdded()) {
                if (notificationInput.getPageNo() == 1) {
                    mView.onHideLoading();
                    mView.onLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                } else {
                    mView.onHideScrollLoading();
                    mView.onScrollLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                }
            }
        } else {
            if (notificationInput.getPageNo() == 1) {
                mView.onShowLoading();
            } else {
                mView.onShowScrollLoading();
            }
            responseMatchesCall = mInteractor.notificationList(notificationInput, new IUserInteractor.OnNotificationResponseListener() {
                @Override
                public void onSuccess(NotificationsResponse response) {
                    if (mView.isLayoutAdded()) {
                        if (notificationInput.getPageNo() == 1) {
                            mView.onHideLoading();
                            mView.onLoadingSuccess(response);
                        } else {
                            mView.onHideScrollLoading();
                            mView.onScrollLoadingSuccess(response);
                        }
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    if (mView.isLayoutAdded()) {
                        if (notificationInput.getPageNo() == 1) {
                            mView.onHideLoading();
                            mView.onLoadingError(errorMsg);
                        } else {
                            mView.onHideScrollLoading();
                            mView.onScrollLoadingError(errorMsg);
                        }
                    }
                }

                @Override
                public void onNotFound(String error) {
                    if (mView.isLayoutAdded()) {
                        if (notificationInput.getPageNo() == 1) {
                            mView.onHideLoading();
                            mView.onLoadingNotFound(error);
                        } else {
                            mView.onHideScrollLoading();
                            mView.onScrollLoadingNotFound(error);
                        }
                    }
                }
            });
        }
    }

    @Override
    public void notificationRead(NotificationMarkReadInput markReadInput) {
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            mView.onHideLoading();
            mView.onNotificationMarkReadFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mView.onShowLoading();
            mInteractor.notificationMarkRead(markReadInput, new IUserInteractor.OnMakeFavoriteTeamListener() {
                @Override
                public void onSuccess(DefaultRespose responseLogin) {
                    if (responseLogin != null) {
                        mView.onHideLoading();
                        mView.onNotificationMarkReadSuccess(responseLogin);
                    } else {
                        mView.onHideLoading();
                        mView.onNotificationMarkReadFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    mView.onHideLoading();
                    mView.onNotificationMarkReadFailure(errorMsg);
                }

            });
        }
    }


    @Override
    public void clear_badges(String loginSessionKey) {

    }

    @Override
    public void deleteNotification(NotificationDeleteInput mDeleteInput) {
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            mView.onHideLoading();
            mView.onDeleteNotificationFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mView.onShowLoading();
            mInteractor.deleteNotification(mDeleteInput, new IUserInteractor.OnMakeFavoriteTeamListener() {
                @Override
                public void onSuccess(DefaultRespose responseLogin) {
                    if (responseLogin != null) {
                        mView.onHideLoading();
                        mView.onDeleteNotificationSuccess(responseLogin);
                    } else {
                        mView.onHideLoading();
                        mView.onDeleteNotificationFailure(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    mView.onHideLoading();
                    mView.onDeleteNotificationFailure(errorMsg);
                }

            });
        }
    }

   /* @Override
    public void notification_read(String loginSessionKey, String notification_id) {
        actionReadCancel();
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            mView.hideLoading();
            mView.onShowSnackBar(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mView.showLoading();
            mResponceReadNotification = mInteractor.notification_read(loginSessionKey, notification_id, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(ResponseLogin mResponseLogin) {
                    mView.hideLoading();
                    mView.onReadSuccess(mResponseLogin);

                }


                @Override
                public void onError(String errorMsg) {

                    mView.onHideLoading();
                    mView.onReadError(errorMsg);
                }
            });
        }
    }

    @Override
    public void clear_badges(String loginSessionKey) {
        actionReadCancel();
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            mView.hideLoading();
            mView.onShowSnackBar(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mView.showLoading();
            mResponceReadNotification = mInteractor.clear_badges(loginSessionKey, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(ResponseLogin mResponseLogin) {
                    mView.hideLoading();
                    mView.onReadSuccess(mResponseLogin);

                }


                @Override
                public void onError(String errorMsg) {

                    mView.onHideLoading();
                    mView.onReadError(errorMsg);
                }
            });
        }
    }*/
}

