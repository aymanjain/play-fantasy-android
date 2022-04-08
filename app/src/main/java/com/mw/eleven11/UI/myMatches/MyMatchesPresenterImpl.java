package com.mw.eleven11.UI.myMatches;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.JoinedContestInput;
import com.mw.eleven11.beanInput.MyContestMatchesInput;
import com.mw.eleven11.beanOutput.CheckContestBean;
import com.mw.eleven11.beanOutput.JoinedContestOutput;
import com.mw.eleven11.beanOutput.MatchContestOutPut;
import com.mw.eleven11.beanOutput.MyContestMatchesOutput;
import com.mw.eleven11.beanOutput.ResponseLogin;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;

import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class MyMatchesPresenterImpl implements IMyMatchesPresenter {

    private MyMatchesView mView;
    private IUserInteractor mInteractor;

    public MyMatchesPresenterImpl(MyMatchesView mView, IUserInteractor mInteractor) {
        this.mView = mView;
        this.mInteractor = mInteractor;
    }

    private Call<JoinedContestOutput> responseMatchesCall;
    private Call<MyContestMatchesOutput> responseMyContestMatchesCall;
    Call<ResponseLogin> responseLoginCall;
    Call<MatchContestOutPut> matchContest;


    private Call<CheckContestBean> responseJoinedContestsCall;

    public void actionListingCancel() {
        if (responseMatchesCall != null && !responseMatchesCall.isExecuted())
            responseMatchesCall.cancel();
    }


    @Override
    public void actionListing(final JoinedContestInput mJoinedContestInput) {
        actionListingCancel();
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            if (mView.isLayoutAdded()) {
                if (mJoinedContestInput.getPageNo() == 1) {
                    mView.onHideLoading();
                    mView.onLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                } else {
                    mView.onHideScrollLoading();
                    mView.onScrollLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                }
            }
        } else {
            if (mJoinedContestInput.getPageNo() == 1) {
                mView.onHideScrollLoading();
                mView.onShowLoading();
            } else {
                mView.onShowScrollLoading();
            }
            responseMatchesCall = mInteractor.getJoinedContests(mJoinedContestInput,
                    new IUserInteractor.OnResponseMyMatchesListener() {
                        @Override
                        public void onSuccess(JoinedContestOutput mJoinedContestOutput) {
                            if (mView.isLayoutAdded()) {
                                if (mJoinedContestInput.getPageNo() == 1) {
                                    mView.onHideLoading();
                                    if(mJoinedContestOutput.getData().getRecords().size()==0){
                                        mView.onHideLoading();
                                        mView.onLoadingNotFound(AppUtils.getStrFromRes(R.string.pageNotFound));
                                    }else {

                                        mView.onLoadingSuccess(mJoinedContestOutput);
                                    }



                                } else {
                                    mView.onHideScrollLoading();
                                    mView.onScrollLoadingSuccess(mJoinedContestOutput);
                                }
                            }
                        }


                        @Override
                        public void onError(String errorMsg) {
                            if (mView.isLayoutAdded()) {
                                if (mJoinedContestInput.getPageNo() == 1) {
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
                                if (mJoinedContestInput.getPageNo() == 1) {
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
    public void myContestactionListing(final MyContestMatchesInput mJoinedContestInput) {

        actionListingCancel();
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            if (mView.isLayoutAdded()) {
                if (mJoinedContestInput.getPageNo() == 1) {
                    mView.onHideLoading();
                    mView.onMyContestLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                } else {
                    mView.onHideScrollLoading();
                    mView.onMyContestScrollLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                }
            }
        } else {
            if (mJoinedContestInput.getPageNo() == 1) {
                mView.onHideScrollLoading();
                mView.onShowLoading();
            } else {
                mView.onShowScrollLoading();
            }

            responseMyContestMatchesCall = mInteractor.myContestMatchesList(mJoinedContestInput,
                    new IUserInteractor.OnResponseMyContestListener() {
                        @Override
                        public void onSuccess(MyContestMatchesOutput mAllContestOutPut) {

                            if (mView.isLayoutAdded()) {
                                if (mJoinedContestInput.getPageNo() == 1) {
                                    mView.onHideLoading();
                                    if(mAllContestOutPut.getData().getRecords().size()==0){
                                        mView.onHideLoading();
                                        mView.onMyContestLoadingNotFound(AppUtils.getStrFromRes(R.string.pageNotFound));
                                    }else {

                                        mView.onMyContestLoadingSuccess(mAllContestOutPut);
                                    }

                                } else {
                                    mView.onHideScrollLoading();
                                    mView.onMyContestScrollLoadingSuccess(mAllContestOutPut);
                                }
                            }
                        }

                        @Override
                        public void onNotFound(String error) {

                            if (mView.isLayoutAdded()) {
                                if (mJoinedContestInput.getPageNo() == 1) {
                                    mView.onHideLoading();
                                    mView.onMyContestLoadingNotFound(error);
                                } else {
                                    mView.onHideScrollLoading();
                                    mView.onMyContestScrollLoadingNotFound(error);
                                }
                            }

                        }

                        @Override
                        public void onError(String errorMsg) {

                            if (mView.isLayoutAdded()) {
                                if (mJoinedContestInput.getPageNo() == 1) {
                                    mView.onHideLoading();
                                    mView.onMyContestLoadingError(errorMsg);
                                } else {
                                    mView.onHideScrollLoading();
                                    mView.onMyContestScrollLoadingError(errorMsg);
                                }
                            }
                        }
                    });

        }
    }

    @Override
    public void matchContestList(JoinedContestInput mJoinedContestInput) {

        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            mView.onHideLoading();
            mView.onMatchContestFailure(AppUtils.getStrFromRes(R.string.network_error));
        } else {
            mView.onShowLoading();

            matchContest = mInteractor.getJoinedContestsByType(mJoinedContestInput, new IUserInteractor.OnResponseContestListener() {
                @Override
                public void onSuccess(MatchContestOutPut mResponseContest) {

                    mView.onHideLoading();
                    if (mView.isLayoutAdded()) {
                        mView.onMatchContestSuccess(mResponseContest);
                    }
                }

                @Override
                public void onNotFound(String error) {
                    mView.onHideLoading();
                    if (mView.isLayoutAdded()) {
                        mView.onMatchContestFailure(error);
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    mView.onHideLoading();
                    if (mView.isLayoutAdded()) {
                        mView.onMatchContestFailure(errorMsg);
                    }
                }

                @Override
                public void OnSessionExpire() {

                }
            });
        }


    }


}