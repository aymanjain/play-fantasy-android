package com.mw.eleven11.appApi.interactors;

import com.mw.eleven11.beanInput.ChangePasswordInput;
import com.mw.eleven11.beanInput.ContestDetailInput;
import com.mw.eleven11.beanInput.ContestUserInput;
import com.mw.eleven11.beanInput.CreateContestInput;
import com.mw.eleven11.beanInput.CreateTeamInput;
import com.mw.eleven11.beanInput.DownloadTeamInput;
import com.mw.eleven11.beanInput.DreamTeamInput;
import com.mw.eleven11.beanInput.FavoriteTeamInput;
import com.mw.eleven11.beanInput.GetDraftPlayerPointInput;
import com.mw.eleven11.beanInput.JoinContestInput;
import com.mw.eleven11.beanInput.JoinedContestInput;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.MakeFavoriteTeamInput;
import com.mw.eleven11.beanInput.MatchContestInput;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanInput.MatchListInput;
import com.mw.eleven11.beanInput.MyContestMatchesInput;
import com.mw.eleven11.beanInput.MyTeamInput;
import com.mw.eleven11.beanInput.NotificationDeleteInput;
import com.mw.eleven11.beanInput.NotificationInput;
import com.mw.eleven11.beanInput.NotificationMarkReadInput;
import com.mw.eleven11.beanInput.PaytmInput;
import com.mw.eleven11.beanInput.PlayerFantasyStatsInput;
import com.mw.eleven11.beanInput.PlayersInput;
import com.mw.eleven11.beanInput.PointsSystem;
import com.mw.eleven11.beanInput.PromoCodeInput;
import com.mw.eleven11.beanInput.PromoCodeListInput;
import com.mw.eleven11.beanInput.RankingInput;
import com.mw.eleven11.beanInput.ReferEarnInput;
import com.mw.eleven11.beanInput.RequestOtpForSigninInput;
import com.mw.eleven11.beanInput.SeriesInput;
import com.mw.eleven11.beanInput.SingupInput;
import com.mw.eleven11.beanInput.SwitchTeamInput;
import com.mw.eleven11.beanInput.TransactionInput;
import com.mw.eleven11.beanInput.UpdateProfileInput;
import com.mw.eleven11.beanInput.UploadImageInput;
import com.mw.eleven11.beanInput.VerifyMobileInput;
import com.mw.eleven11.beanInput.VersionInput;
import com.mw.eleven11.beanInput.WalletInput;
import com.mw.eleven11.beanInput.WinnerBreakupInput;
import com.mw.eleven11.beanInput.WithdrawInput;
import com.mw.eleven11.beanOutput.AllContestOutPut;
import com.mw.eleven11.beanOutput.AvatarListOutput;
import com.mw.eleven11.beanOutput.CheckContestBean;
import com.mw.eleven11.beanOutput.ContestDetailOutput;
import com.mw.eleven11.beanOutput.ContestUserOutput;
import com.mw.eleven11.beanOutput.CreateContestOutput;
import com.mw.eleven11.beanOutput.DefaultRespose;
import com.mw.eleven11.beanOutput.DreamTeamOutput;
import com.mw.eleven11.beanOutput.ForgetPasswordOut;
import com.mw.eleven11.beanOutput.GetContestBidHistoryOutput;
import com.mw.eleven11.beanOutput.GetDraftPlayerPointOutput;
import com.mw.eleven11.beanOutput.GetPrivateContestOutput;
import com.mw.eleven11.beanOutput.JoinContestOutput;
import com.mw.eleven11.beanOutput.JoinedContestBean;
import com.mw.eleven11.beanOutput.JoinedContestOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.MatchContestOutPut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.MatchResponseOut;
import com.mw.eleven11.beanOutput.MyContestMatchesOutput;
import com.mw.eleven11.beanOutput.MyTeamOutput;
import com.mw.eleven11.beanOutput.NotificationsResponse;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.beanOutput.PointsList;
import com.mw.eleven11.beanOutput.PromoCodeListOutput;
import com.mw.eleven11.beanOutput.PromoCodeResponse;
import com.mw.eleven11.beanOutput.RankingOutput;
import com.mw.eleven11.beanOutput.ReferralUsersResponse;
import com.mw.eleven11.beanOutput.RequestOtpForSigninOutput;
import com.mw.eleven11.beanOutput.ResponceSignup;
import com.mw.eleven11.beanOutput.ResponseBanner;
import com.mw.eleven11.beanOutput.ResponseCountries;
import com.mw.eleven11.beanOutput.ResponseDownloadTeam;
import com.mw.eleven11.beanOutput.ResponseFavoriteTeam;
import com.mw.eleven11.beanOutput.ResponseLogin;
import com.mw.eleven11.beanOutput.ResponsePayTmDetails;
import com.mw.eleven11.beanOutput.ResponsePayUMoneyDetails;
import com.mw.eleven11.beanOutput.ResponsePlayerDetails;
import com.mw.eleven11.beanOutput.ResponsePlayerFantasyStats;
import com.mw.eleven11.beanOutput.ResponseReferralDetails;
import com.mw.eleven11.beanOutput.ResponseUpdateProfile;
import com.mw.eleven11.beanOutput.SeriesOutput;
import com.mw.eleven11.beanOutput.SimpleOutput;
import com.mw.eleven11.beanOutput.SingleTeamOutput;
import com.mw.eleven11.beanOutput.TransactionsBean;
import com.mw.eleven11.beanOutput.VersonBean;
import com.mw.eleven11.beanOutput.WalletOutputBean;
import com.mw.eleven11.beanOutput.WinBreakupOutPut;
import com.mw.eleven11.beanOutput.WithDrawoutput;

import retrofit2.Call;


public interface IUserInteractor {

    //  SignUp API
    Call<ResponceSignup> signUp(SingupInput mSingupInput, OnSignUpResponseListener onResponseListener);

    //signin api
    Call<LoginResponseOut> login(LoginInput mLoginInput, OnLoginResponseListener onResponseListener);

    Call<LoginResponseOut> verifyEmailAddress(VerifyMobileInput mobileInput, OnResponseListener onResponseListener);

    Call<DefaultRespose> deleteNotification(NotificationDeleteInput mDeleteInput, OnMakeFavoriteTeamListener onResponseListener);

    Call<ResponseFavoriteTeam> getFavoriteTeam(FavoriteTeamInput mFavoriteTeamInput, OnGetFavoriteTeamListener mOnGetFavoriteTeamListener);

    Call<DefaultRespose> makeFavoriteTeams(MakeFavoriteTeamInput mMakeFavoriteTeamInput, OnMakeFavoriteTeamListener mOnMakeFavoriteTeamListener);

    Call<ResponseDownloadTeam> downloadTeam(DownloadTeamInput mDownloadTeamInput, OnDownloadTeamListener mOnDownloadTeamListener);


    Call<LoginResponseOut> viewProfile(LoginInput mLoginInput, OnResponseListener onResponseListener);

    Call<ForgetPasswordOut> forgotPassword(LoginInput mLoginInput, OnForgetPasswordListener onResponseListener);

    Call<ForgetPasswordOut> resetPassword(LoginInput mLoginInput, OnForgetPasswordListener onResponseListener);

    Call<LoginResponseOut> verifyEmail(LoginInput mLoginInput, OnLoginResponseListener onResponseListener);

    Call<MatchResponseOut> matchesListing(MatchListInput mMatchListInput, OnResponseMatchesListener onResponseListener);

    Call<JoinedContestOutput> getJoinedContests(JoinedContestInput mJoinedContestInput, OnResponseMyMatchesListener onResponseMyMatchesListener);

    Call<MatchDetailOutPut> matchDetail(MatchDetailInput matchDetailInput, OnResponseMatchDetailsListener onResponseListener);

    Call<WalletOutputBean> viewAccount(WalletInput mWalletInput, OnResponseAccountListener onResponseListener);

    Call<DefaultRespose> updateProfile(UpdateProfileInput mUpdateProfileInput,
                                       OnResponseUpdateProfileListener mOnResponseUpdateProfileListener);

    Call<ResponseBanner> bannersList(LoginInput mLoginInput, OnResponseBannerListener onResponseListener);

    Call<MatchContestOutPut> getContestsByType(MatchContestInput mMatchContestInput, OnResponseContestListener onResponseListener);

    Call<MatchContestOutPut> getJoinedContestsByType(JoinedContestInput mMatchContestInput, OnResponseContestListener onResponseListener);

    Call<AllContestOutPut> allContestListing(MatchContestInput mMatchContestInput, OnResponseAllContestsListener onResponseListener);

    Call<MyContestMatchesOutput> myContestMatchesList(MyContestMatchesInput myContestMatchesInput, OnResponseMyContestListener onResponseMyContestListener);


    Call<ContestDetailOutput> getContest(ContestDetailInput mMatchContestInput, OnResponseContestDetailsListener onResponseListener);

    Call<ContestUserOutput> getJoinedContestsUsers(ContestUserInput mContestUserInput, OnResponseRanksListener onResponseRanksListener);

    Call<PlayersOutput> getPlayers(PlayersInput mPlayersInput, OnResponseMatchPlayersListener onResponseListener);

    Call<LoginResponseOut> addUserTeam(CreateTeamInput mCreateTeamInput, OnResponseListener onResponseListener);

    Call<LoginResponseOut> editUserTeam(CreateTeamInput mCreateTeamInput, OnResponseListener onResponseListener);

    Call<MyTeamOutput> teamList(MyTeamInput mMyTeamInput, OnResponseTeamsListener onResponseListener);


    Call<JoinContestOutput> joinContest(JoinContestInput mJoinContestInput, OnResponseJoinListener onResponseListener);

    Call<LoginResponseOut> sendMobileOtp(VerifyMobileInput mobileInput, OnResponseListener onResponseListener);

    Call<LoginResponseOut> verifyPhoneNumber(VerifyMobileInput mobileInput, OnResponseListener onResponseListener);

    Call<LoginResponseOut> resendverify(VerifyMobileInput mobileInput, OnResponseListener onResponseListener);

    Call<LoginResponseOut> uploadImage(UploadImageInput imageUploadBean, OnResponseListener onResponseListener);

    Call<DreamTeamOutput> allPlayersScore(DreamTeamInput dreamTeamInput, OnResponseDreamTeamsListener onResponseListener);


    Call<CreateContestOutput> createContest(CreateContestInput createContestInput, OnResponseCreateContestListener onResponseListener);




    Call<ResponsePlayerFantasyStats> playerFantasyStats(PlayerFantasyStatsInput mPlayerFantasyStatsInput, OnPlayerFantasyStatsListener onPlayerFantasyStatsListener);


    Call<LoginResponseOut> changePassword(ChangePasswordInput mChangePasswordInput, OnResponseListener onResponseListener);

    Call<AvatarListOutput> users_icon_list(LoginInput loginInput, OnAvatarResponseListener onResponseListener);

    Call<RankingOutput> getRankings(RankingInput rankingInput, OnRankingListener mResponseOverallLeaderboardListener);

    Call<LoginResponseOut> switchTeam(SwitchTeamInput switchTeamInput, OnResponseListener onResponseListener);

    Call<ResponsePayTmDetails> payTm(PaytmInput paytmInput, OnPayTmResponseListener onResponseListener);

    Call<LoginResponseOut> payTmResponse(PaytmInput paytmInput, OnResponseListener onResponseListener);

    Call<LoginResponseOut> notificationCount(LoginInput mLoginInput, OnResponseListener onResponseListener);

    Call<DefaultRespose> notificationMarkRead(NotificationMarkReadInput mNotificationMarkReadInput, OnMakeFavoriteTeamListener onResponseListener);

    Call<VersonBean> appVersion(VersionInput versionInput, OnVersonResponseListener onResponseListener);

    Call<TransactionsBean> transactionsApp(TransactionInput transactionInput, OnResponseTransactionListener onResponseListener);

    Call<WinBreakupOutPut> winning_breakup(WinnerBreakupInput mWinnerBreakupInput, OnResponseWinBreakUpListener onResponseListener);

    Call<SeriesOutput> matchSeriesCall(SeriesInput seriesInput, OnResponseMatchSeriesListener mOnResponseMatchSeriesListener);

    Call<NotificationsResponse> notificationList(NotificationInput notificationInput, OnNotificationResponseListener onResponseListener);

    Call<WithDrawoutput> withdrawal_add(WithdrawInput notificationInput, OnwithdrawalResponseListener onResponseListener);

    Call<ResponseReferralDetails> getReferralDetail(OnReferralDetailListener mOnReferralDetailListener);


    Call<PromoCodeResponse> promoCode(PromoCodeInput mPromoCodeInput, OnPromoCodeResponseListener promoCodeResponseListener);


    Call<RequestOtpForSigninOutput> requestOtpForSigninCall(RequestOtpForSigninInput requestOtpForSigninInput, OnRequestOtpForSigninListener onRequestOtpForSigninListener);


    Call<PointsList> getPointList(String type, PointsSystem system, OnPointsResponseListener mOnReferralDetailListener);

    Call<PromoCodeListOutput> promocodeList(PromoCodeListInput mPromoCodeListInput, OnRequestPromoCodeListListener onRequestPromoCodeListListener);

    Call<DefaultRespose> getReferEarn(ReferEarnInput mReferEarnInput, OnMakeFavoriteTeamListener mOnMakeFavoriteTeamListener);

    Call<ReferralUsersResponse> getReferralUsers(LoginInput mLoginInput, OnReferralUsersListener mOnReferralUsersListener);

    Call<SingleTeamOutput> getSingleUserTeams(MyTeamInput mMyTeamInput, OnResponseSingleTeamsListener onResponseListener);


























    Call<GetDraftPlayerPointOutput> getDraftPlayersPoint(GetDraftPlayerPointInput getDraftPlayerPointInput,
                                                         OnGetDraftPlayersPointListener onGetDraftPlayersPointListener);




    interface OnGetDraftPlayersPointListener {

        void onSuccess(GetDraftPlayerPointOutput getDraftPlayerPointOutput);

        void onError(String errorMsg);

    }










    interface OnGetPrivateContestListener {

        void onSuccess(GetPrivateContestOutput getPrivateContestOutput);

        void onError(String errorMsg);

    }




    interface OnSimpleResponseListener {

        void onSuccess(SimpleOutput simpleOutput);

        void onError(String errorMsg);

    }











    interface OnGetContestBidHistoryListener {

        void onSuccess(GetContestBidHistoryOutput getContestBidHistoryOutput);

        void onError(String errorMsg);

    }













    interface OnResponseSingleTeamsListener {
        void onSuccess(SingleTeamOutput responseTeams);

        void onNotFound(String error);

        void onError(String errorMsg);
    }





    interface OnRequestOtpForSigninListener {

        void onSuccess(RequestOtpForSigninOutput requestOtpForSigninOutput);

        void onError(String errorMsg);

    }

    interface OnRequestPromoCodeListListener {

        void onSuccess(PromoCodeListOutput mPromoCodeListOutput);

        void onError(String errorMsg);

    }


    interface OnPointsResponseListener {

        void onSuccess(PointsList mNotificationBean);


        void onError(String errorMsg);

        void onNotFound(String error);


    }


    interface OnPromoCodeResponseListener {

        void onSuccess(PromoCodeResponse mPromoCodeResponse);

        void onError(String errorMsg);

    }


    interface OnwithdrawalResponseListener {

        void onSuccess(WithDrawoutput mNotificationBean);


        void onError(String errorMsg);

        void onNotFound(String error);


    }

    interface OnNotificationResponseListener {

        void onSuccess(NotificationsResponse mNotificationBean);

        void onError(String errorMsg);

        void onNotFound(String error);


    }

    interface OnSignUpResponseListener {
        void onNotVerify(ResponceSignup user);

        void onSuccess(ResponceSignup user);

        void onError(String errorMsg);
    }

    interface OnLoginResponseListener {
        void onSuccess(LoginResponseOut user);//in case of response success (status 1)

        void onAccountNotVerify(LoginResponseOut user);//in case of account not verify (status 5)

        void onOTPRecevied(LoginResponseOut user);

        void onAccountAvailableForSignUp(String errorMsg);//in case of account available for sign up (status 6)

        void onError(String errorMsg);//in case of error (status 0)
    }

    interface OnForgetPasswordListener {
        void onSuccess(ForgetPasswordOut user);

        void onError(String errorMsg);
    }

    interface OnReferralDetailListener {
        void onSuccess(ResponseReferralDetails user);

        void onError(String errorMsg);
    }

    interface OnReferralUsersListener {
        void onSuccess(ReferralUsersResponse user);

        void onError(String errorMsg);
    }

    interface OnPlayerFantasyStatsListener {
        void onSuccess(ResponsePlayerFantasyStats user);

        void onError(String errorMsg);
    }


    interface OnDownloadTeamListener {
        void onSuccess(ResponseDownloadTeam user);

        void onError(String errorMsg);
    }

    interface OnGetFavoriteTeamListener {
        void onSuccess(ResponseFavoriteTeam user);

        void onError(String errorMsg);
    }

    interface OnMakeFavoriteTeamListener {
        void onSuccess(DefaultRespose user);

        void onError(String errorMsg);
    }

    interface OnResponseMatchesListener {
        void onSuccess(MatchResponseOut responseMatches);

        void onCheckContest(CheckContestBean mJoinedContestBean);

        void onNotFound(String error);

        void onError(String errorMsg);

        void OnSessionExpire();
    }

    interface OnResponseMyMatchesListener {
        void onSuccess(JoinedContestOutput responseMatches);

        void onNotFound(String error);

        void onError(String errorMsg);

        void OnSessionExpire();
    }

    interface OnResponseMatchDetailsListener {
        void onSuccess(MatchDetailOutPut user);

        void onError(String errorMsg);
    }

    interface OnResponseAccountListener {
        void onSuccess(WalletOutputBean user);

        void onError(String errorMsg);
    }

    interface OnResponseContestListener {

        void onSuccess(MatchContestOutPut mResponseContest);

        void onNotFound(String error);

        void onError(String errorMsg);

        void OnSessionExpire();
    }

    interface OnResponseContestDetailsListener {
        void onSuccess(ContestDetailOutput mContestDetailOutput);

        void onError(String errorMsg);
    }

    interface OnResponseRanksListener {
        void onSuccess(ContestUserOutput mContestUserOutput);

        void onNotFound(String error);

        void onError(String errorMsg);
    }

    interface OnResponseMatchPlayersListener {
        void onSuccess(PlayersOutput mPlayersOutput);

        void onNotFound(String error);

        void onError(String errorMsg);
    }

    interface OnResponseListener {
        void onSuccess(LoginResponseOut user);

        void onError(String errorMsg);
    }

    interface OnResponseTeamsListener {
        void onSuccess(MyTeamOutput responseTeams);

        void onNotFound(String error);

        void onError(String errorMsg);
    }




    interface OnResponseJoinListener {
        void onSuccess(JoinContestOutput mJoinContestOutput);

        void onNotFound(String error);

        void onError(String errorMsg);
    }

    interface OnResponseCreateContestListener {
        void onSuccess(CreateContestOutput mCreateContestOutput);

        void onError(String errorMsg);
    }






    interface OnAvatarResponseListener {
        void onSuccess(AvatarListOutput user);//in case of response success (status 1)

        void onNotFound(String error);

        void onError(String errorMsg);//in case of error (status 0)
    }

    interface OnRankingListener {
        void onSuccess(RankingOutput mRankingOutput);

        void onError(String errorMsg);
    }


    interface OnPayTmResponseListener {
        void onSuccess(ResponsePayTmDetails user);

        void onError(String errorMsg);
    }


    interface OnResponseTransactionListener {
        void onSuccess(TransactionsBean responseMatches);

        void onNotFound(String error);

        void onError(String errorMsg);
    }

    interface OnResponseMatchSeriesListener {
        void onSuccess(SeriesOutput responseSeries);

        void onError(String errorMsg);
    }


    interface OnResponseWinBreakUpListener {
        void onSuccess(WinBreakupOutPut user);

        void onError(String errorMsg);
    }


    interface OnAvatarUpdateListener {
        void onSuccess(ResponseLogin user);

        void onFailed(String errorMsg);

        void onError(String errorMsg);
    }


    interface OnResponseDreamTeamsListener {
        void onSuccess(DreamTeamOutput responseTeams);

        void onNotFound(String error);

        void onError(String errorMsg);
    }

    interface OnVersonResponseListener {
        void onSuccess(VersonBean user);//in case of response success (status 1)


        void onFailed(String errorMsg);


        void onError(String errorMsg);//in case of error (status 0)
    }


    interface OnResponseBannerListener {
        void onSuccess(ResponseBanner responseBanner);

        void onNotFound(String error);

        void onError(String errorMsg);
    }

    interface OnResponseAllContestsListener {
        void onSuccess(AllContestOutPut mAllContestOutPut);

        void onNotFound(String error);

        void onError(String errorMsg);

        void OnSessionExpire();
    }










    interface OnResponseMyContestListener {
        void onSuccess(MyContestMatchesOutput mAllContestOutPut);

        void onNotFound(String error);

        void onError(String errorMsg);

    }


    interface OnResponseJoinedContesListener {
        void onSuccess(JoinedContestBean responseMatches);

        void onNotFound(String error);

        void onError(String errorMsg);

        void OnSessionExpire();
    }


    interface OnCountryResponseListener {
        void onSuccess(ResponseCountries user);

        void onError(String errorMsg);
    }

    interface OnPayUMoneyResponseListener {
        void onSuccess(ResponsePayUMoneyDetails user);

        void onError(String errorMsg);
    }


    interface OnResponseUpdateProfileListener {
        void onSuccess(ResponseUpdateProfile responseUpdate);

        void onError(String errorMsg);
    }

    interface OnResponsePlayerDetailsListener {
        void onSuccess(ResponsePlayerDetails user);

        void onError(String errorMsg);
    }



}
