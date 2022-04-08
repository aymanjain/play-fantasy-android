package com.mw.eleven11.UI.myTeams;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.MyTeamInput;
import com.mw.eleven11.beanInput.SwitchTeamInput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.MyTeamOutput;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;


import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class MyTeamsPresenterImpl implements IMyTeamsPresenter {

    MyTeamsView view;
    IUserInteractor mInteractor;
    Call<MyTeamOutput> responseMatchesCall;

    public MyTeamsPresenterImpl(MyTeamsView view, IUserInteractor mInteractor) {
        this.view = view;
        this.mInteractor = mInteractor;
    }

    public void actionListingCancel() {
        if (responseMatchesCall != null && !responseMatchesCall.isExecuted())
            responseMatchesCall.cancel();
    }

    @Override
    public void actionTeamList(MyTeamInput myTeamInput) {
        actionListingCancel();
        if (!NetworkUtils.isNetworkConnected(view.getContext())) {
            if (view.isLayoutAdded()) {
                view.onHideLoading();
                view.onLoadingError(AppUtils.getStrFromRes(R.string.network_error));
            }
        } else {
            view.onShowLoading();
            responseMatchesCall = mInteractor.teamList(myTeamInput, new IUserInteractor.OnResponseTeamsListener() {
                @Override
                public void onSuccess(MyTeamOutput response) {
                    if (view.isLayoutAdded()) {
                        view.onHideLoading();
                        view.onLoadingSuccess(response);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    if (view.isLayoutAdded()) {
                        view.onHideLoading();
                        view.onLoadingError(errorMsg);
                    }
                }

                @Override
                public void onNotFound(String error) {
                    if (view.isLayoutAdded()) {
                        view.onHideLoading();
                        view.onLoadingNotFound(error);
                    }
                }
            });
        }
    }

    @Override
    public void actionSwitchBtn(SwitchTeamInput switchTeamInput) {
        if (!NetworkUtils.isNetworkConnected(view.getContext())) {
            view.hideLoading();
            view.onSwitchError(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            view.showLoading();
            mInteractor.switchTeam(switchTeamInput, new IUserInteractor.OnResponseListener() {
                @Override
                public void onSuccess(LoginResponseOut responseLogin) {
                    if (responseLogin != null) {
                        view.hideLoading();
                        view.onSwitchSuccess(responseLogin);
                    } else {
                        view.hideLoading();
                        view.onSwitchError(Constant.NULL_DATA_MESSAGE);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    view.hideLoading();
                    view.onSwitchError(errorMsg);
                }

            });
        }
    }

}
