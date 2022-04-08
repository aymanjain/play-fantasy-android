package com.mw.eleven11.UI.allContest;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.MatchContestInput;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanOutput.AllContestOutPut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;

import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;

import retrofit2.Call;

public class AllContestPresenterImpl implements IAllContestPresenter {

    AllContestView mView;
    IUserInteractor mInteractor;

    Call<MatchDetailOutPut> matchDetailCall;

    Call<AllContestOutPut> mAllContestCall;

    public AllContestPresenterImpl(AllContestView mView, IUserInteractor mInteractor) {
        this.mView = mView;
        this.mInteractor = mInteractor;
    }

    public void actionLoginCancel() {
        if (matchDetailCall != null && !matchDetailCall.isExecuted())
            matchDetailCall.cancel();
    }

    @Override
    public void matchContestList(final MatchContestInput mMatchContestInput) {

        actionLoginCancel();
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            if (mView.isLayoutAdded()) {
                if (mMatchContestInput.getPageNo() == 1) {
                    mView.onHideLoading();
                    mView.onLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                } else {
                    mView.onHideScrollLoading();
                    mView.onScrollLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                }
            }
        } else {
            if (mMatchContestInput.getPageNo() == 1) {
                mView.onShowLoading();
            }
            mAllContestCall = mInteractor.allContestListing(mMatchContestInput, new IUserInteractor.OnResponseAllContestsListener() {
                @Override
                public void onSuccess(AllContestOutPut responseMatches) {
                    if (mMatchContestInput.getPageNo() == 1) {
                        mView.onHideLoading();
                        mView.onLoadingSuccess(responseMatches);
                    } else {
                        mView.onHideScrollLoading();
                        mView.onScrollLoadingSuccess(responseMatches);
                    }
                }

                @Override
                public void onNotFound(String error) {
                    if (mMatchContestInput.getPageNo() == 1) {
                        mView.onHideLoading();
                        mView.onLoadingNotFound(error);
                    } else {
                        mView.onHideScrollLoading();
                        mView.onScrollLoadingNotFound(error);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    if (mMatchContestInput.getPageNo() == 1) {
                        mView.onHideLoading();
                        mView.onLoadingError(errorMsg);
                    } else {
                        mView.onHideScrollLoading();
                        mView.onScrollLoadingError(errorMsg);
                    }
                }

                @Override
                public void OnSessionExpire() {
                    mView.onHideLoading();
                    mView.onClearLogout();

                }
            });
        }
    }

    @Override
    public void actionMatchdetail(MatchDetailInput mMatchDetailInput) {
        actionLoginCancel();
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            mView.hideLoading();
            mView.onMatchFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mView.showLoading();
            matchDetailCall = mInteractor.matchDetail(mMatchDetailInput, new IUserInteractor.OnResponseMatchDetailsListener() {
                @Override
                public void onSuccess(MatchDetailOutPut mMatchDetailOutPut) {

                        mView.onMatchSuccess(mMatchDetailOutPut);

                }

                @Override
                public void onError(String errorMsg) {

                        mView.onMatchFailure(errorMsg);

                }

            });
        }
    }


}
