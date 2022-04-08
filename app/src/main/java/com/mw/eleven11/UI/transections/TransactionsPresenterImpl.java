package com.mw.eleven11.UI.transections;

import com.mw.eleven11.R;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.beanInput.TransactionInput;
import com.mw.eleven11.beanOutput.TransactionsBean;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.NetworkUtils;

import retrofit2.Call;

/**
 * Created by hp on 06-07-2017.
 */

public class TransactionsPresenterImpl implements ITransactionsPresenter {

    TransactionsView mView;
    IUserInteractor mInteractor;

    public TransactionsPresenterImpl(TransactionsView mView, IUserInteractor mInteractor) {
        this.mView = mView;
        this.mInteractor = mInteractor;
    }
    Call<TransactionsBean> responseMatchesCall;

    public void actionListingCancel() {
        if (responseMatchesCall != null && !responseMatchesCall.isExecuted())
            responseMatchesCall.cancel();
    }
    @Override
    public void actionListing(final TransactionInput transactionInput) {
        actionListingCancel();
        if (!NetworkUtils.isNetworkConnected(mView.getContext())) {
            if (mView.isLayoutAdded()){
                if (transactionInput.getPageNo() == 1) {
                    mView.onHideLoading();
                    mView.onLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                }else {
                    mView.onHideScrollLoading();
                    mView.onScrollLoadingError(AppUtils.getStrFromRes(R.string.network_error));
                }
            }
        } else {
            if (transactionInput.getPageNo() == 1) {
                mView.onShowLoading();
            }else {
                mView.onShowScrollLoading();
            }
            responseMatchesCall=  mInteractor.transactionsApp( transactionInput, new IUserInteractor.OnResponseTransactionListener() {
                @Override
                public void onSuccess(TransactionsBean response) {
                    if (mView.isLayoutAdded()){
                        if (transactionInput.getPageNo() == 1) {
                            mView.onHideLoading();
                            mView.onLoadingSuccess(response);
                        }else {
                            mView.onHideScrollLoading();
                            mView.onScrollLoadingSuccess(response);
                        }
                    }
                }

                @Override
                public void onError(String errorMsg) {
                    if (mView.isLayoutAdded()){
                        if (transactionInput.getPageNo() == 1) {
                            mView.onHideLoading();
                            mView.onLoadingError(errorMsg);
                        }else {
                            mView.onHideScrollLoading();
                            mView.onScrollLoadingError(errorMsg);
                        }
                    }
                }

                @Override
                public void onNotFound(String error) {
                    if (mView.isLayoutAdded()){
                        if (transactionInput.getPageNo() == 1) {
                            mView.onHideLoading();
                            mView.onLoadingNotFound(error);
                        }else {
                            mView.onHideScrollLoading();
                            mView.onScrollLoadingNotFound(error);
                        }
                    }
                }
            });
        }
    }
}
