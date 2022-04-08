package com.mw.eleven11.UI.matchContest;


import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.MatchContestInput;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanOutput.MatchContestOutPut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;


import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class MatchContestPresenterImpl implements IMatchContestPresenter {

    MatchDetailView mMyAccountParentView;
    IUserInteractor mImyAccountParentInteractor;

    public MatchContestPresenterImpl(MatchDetailView mView, IUserInteractor mInteractor) {
        this.mMyAccountParentView = mView;
        this.mImyAccountParentInteractor = mInteractor;
    }

    Call<MatchDetailOutPut> matchDetailCall;

    Call<MatchContestOutPut> matchContest;


    @Override
    public void actionMatchdetail(MatchDetailInput mMatchDetailInput) {
        actionLoginCancel();
        if (!NetworkUtils.isNetworkConnected(mMyAccountParentView.getContext())) {
            mMyAccountParentView.hideLoading();
            mMyAccountParentView.onMatchFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mMyAccountParentView.showLoading();
            matchDetailCall = mImyAccountParentInteractor.matchDetail(mMatchDetailInput, new IUserInteractor.OnResponseMatchDetailsListener() {
                @Override
                public void onSuccess(MatchDetailOutPut mMatchDetailOutPut) {
                    if (mMyAccountParentView.isAttached()) {
                        mMyAccountParentView.onMatchSuccess(mMatchDetailOutPut);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    if (mMyAccountParentView.isAttached()) {
                        mMyAccountParentView.onMatchFailure(errorMsg);
                    }
                }

            });
        }
    }

    @Override
    public void matchContestList(MatchContestInput mMatchContestInput) {

        if (!NetworkUtils.isNetworkConnected(mMyAccountParentView.getContext())) {
            mMyAccountParentView.hideLoading();
            mMyAccountParentView.onMatchFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mMyAccountParentView.showLoading();
            matchContest = mImyAccountParentInteractor.getContestsByType(mMatchContestInput, new IUserInteractor.OnResponseContestListener() {
                @Override
                public void onSuccess(MatchContestOutPut mResponseContest) {

                    mMyAccountParentView.hideLoading();
                    if (mMyAccountParentView.isAttached()) {
                        mMyAccountParentView.onMatchContestSuccess(mResponseContest);
                    }
                }

                @Override
                public void onNotFound(String error) {
                    mMyAccountParentView.hideLoading();
                    if (mMyAccountParentView.isAttached()) {
                        mMyAccountParentView.onMatchContestFailure(error);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    mMyAccountParentView.hideLoading();
                    if (mMyAccountParentView.isAttached()) {
                        mMyAccountParentView.onMatchContestFailure(errorMsg);
                    }
                }

                @Override
                public void OnSessionExpire() {

                }
            });
        }
    }

    public void actionLoginCancel() {
        if (matchDetailCall != null && !matchDetailCall.isExecuted())
            matchDetailCall.cancel();
    }

}