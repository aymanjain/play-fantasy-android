package com.mw.eleven11.UI.matches;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.MatchListInput;
import com.mw.eleven11.beanOutput.CheckContestBean;
import com.mw.eleven11.beanOutput.MatchResponseOut;
import com.mw.eleven11.beanOutput.ResponseLogin;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;

import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class MatchesPresenterImpl implements IMatchesPresenter {

    private MatchesView mView;
    private IUserInteractor mInteractor;

    public MatchesPresenterImpl(MatchesView mView, IUserInteractor mInteractor) {
        this.mView = mView;
        this.mInteractor = mInteractor;
    }

    private Call<MatchResponseOut> responseMatchesCall;
    Call<ResponseLogin> responseLoginCall;

    private Call<CheckContestBean> responseJoinedContestsCall;

    public void actionListingCancel() {
        if (responseMatchesCall != null && !responseMatchesCall.isExecuted())
            responseMatchesCall.cancel();
    }

    private void actionJoinedContestsCancel() {
        if (responseJoinedContestsCall != null && !responseJoinedContestsCall.isExecuted())
            responseJoinedContestsCall.cancel();
    }

    @Override
    public void actionListing(final MatchListInput mMatchListInput) {
        actionListingCancel();
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            if (mView.isLayoutAdded()) {
                if (mMatchListInput.getPageNo() == 1) {
                    mView.onHideLoading();
                    mView.onLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                } else {
                    mView.onHideScrollLoading();
                    mView.onScrollLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                }
            }
        } else {
            if (mMatchListInput.getPageNo() == 1) {
                mView.onHideScrollLoading();
                mView.onShowLoading();
            } else {
                mView.onShowScrollLoading();
            }
            responseMatchesCall = mInteractor.matchesListing(mMatchListInput, new IUserInteractor.OnResponseMatchesListener() {
                @Override
                public void onSuccess(MatchResponseOut mMatchResponseOut) {
                    if (mView.isLayoutAdded()) {
                        if (mMatchListInput.getPageNo() == 1) {
                            mView.onHideLoading();
                            mView.onLoadingSuccess(mMatchResponseOut);
                        } else {
                            mView.onHideScrollLoading();
                            mView.onScrollLoadingSuccess(mMatchResponseOut);
                        }
                    }
                }

                @Override
                public void onCheckContest(CheckContestBean mJoinedContestBean) {

                }

                @Override
                public void onError(String errorMsg) {
                    if (mView.isLayoutAdded()) {
                        if (mMatchListInput.getPageNo() == 1) {
                            mView.onHideLoading();
                            mView.onLoadingError(errorMsg);
                        } else {
                            mView.onHideScrollLoading();
                            mView.onScrollLoadingError(errorMsg);
                        }
                    }
                }

                @Override
                public void OnSessionExpire() {
                    mView.onClearLogout();
                }


                @Override
                public void onNotFound(String error) {
                    if (mView.isLayoutAdded()) {
                        if (mMatchListInput.getPageNo() == 1) {
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
    public void to_check_contest(String loginSessionKey, String user_invite_code) {
        actionJoinedContestsCancel();
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            if (mView.isLayoutAdded()) {

                mView.onHideLoading();
                mView.onLoadingError(AppUtils.getStrFromRes(R.string.network_error));

            }
        } else {

            mView.onHideScrollLoading();
            mView.onShowLoading();

           /* responseJoinedContestsCall=  mInteractor.to_check_contest(loginSessionKey, user_invite_code, new IUserInteractor.OnResponseMatchesListener() {
                @Override
                public void onSuccess(ResponseMatches responseMatches) {
                    mView.onHideLoading();
                    mView.onLoadingSuccess(responseMatches);
                }

                @Override
                public void onCheckContest(CheckContestBean mJoinedContestBean) {
                   // mView.onLoadingNotFound(mJoinedContestBean.getMessage());
                    mView.onHideLoading();
                    mView.onCheckContest(mJoinedContestBean);
                }

                @Override

                public void onNotFound(String error) {
                    mView.onHideLoading();
                    mView.onShowSnackBar(error);
                  //  mView.onLoadingNotFound(error);

                   // mView.onLoadingNotFound(error);
                }

                @Override
                public void onError(String errorMsg) {
                    mView.onHideLoading();
                    mView.onShowSnackBar(errorMsg);
                   // mView.onLoadingError(errorMsg);
                }

                @Override
                public void OnSessionExpire() {
                    mView.onClearLogout();
                }
            });*/

        }
    }

    @Override
    public void actionMatchSeries(String loginSessionKey) {
        /*mInteractor.matchSeriesCall(loginSessionKey, new IUserInteractor.OnResponseMatchSeriesListener() {
            @Override
            public void onSuccess(SeriesOutput responseSeries) {
                if (responseSeries != null) {
                    mView.hideLoading();
                    mView.onMatchSeriesSuccess(responseSeries);
                } else {
                    mView.hideLoading();
                    mView.onMatchSeriesFailure(responseSeries.getMessage());
                }

            }

            @Override
            public void onError(String errorMsg) {

                mView.hideLoading();
                mView.onMatchSeriesFailure(errorMsg);
            }
        });*/
    }

    @Override
    public void myContestListing(String loginSessionKey, String type, int limit, final int offset) {
        actionListingCancel();
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            if (mView.isLayoutAdded()) {
                if (offset == 0) {
                    mView.onHideLoading();
                    mView.onLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                } else {
                    mView.onHideScrollLoading();
                    mView.onScrollLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                }
            }
        } else {
            if (offset == 0) {
                mView.onHideScrollLoading();
                mView.onShowLoading();
            } else {
                mView.onShowScrollLoading();
            }
            /*responseMatchesCall =  mInteractor.contests_matches_list( loginSessionKey, type,
                    limit, offset, new IUserInteractor.OnResponseMatchesListener() {
                @Override
                public void onSuccess(ResponseMatches response) {
                    if (mView.isLayoutAdded()){
                        if (offset==0){
                            mView.onHideLoading();
                            mView.onLoadingSuccess(response);
                        }else {
                            mView.onHideScrollLoading();
                            mView.onScrollLoadingSuccess(response);
                        }
                    }
                }

                        @Override
                        public void onCheckContest(CheckContestBean mJoinedContestBean) {

                        }

                        @Override
                public void onError(String errorMsg) {
                    if (mView.isLayoutAdded()){
                        if (offset==0){
                            mView.onHideLoading();
                            mView.onLoadingError(errorMsg);
                        }else {
                            mView.onHideScrollLoading();
                            mView.onScrollLoadingError(errorMsg);
                        }
                    }
                }

                @Override
                public void OnSessionExpire() {
                    mView.onClearLogout();
                }


                @Override
                public void onNotFound(String error) {
                    if (mView.isLayoutAdded()){
                        if (offset==0){
                            mView.onHideLoading();
                            mView.onLoadingNotFound(error);
                        }else {
                            mView.onHideScrollLoading();
                            mView.onScrollLoadingNotFound(error);
                        }
                    }
                }
            });*/
        }
    }

}