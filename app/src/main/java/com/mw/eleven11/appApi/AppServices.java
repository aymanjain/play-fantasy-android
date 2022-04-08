package com.mw.eleven11.appApi;


import android.support.annotation.NonNull;

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
import com.mw.eleven11.beanInput.VerifyMobileInput;
import com.mw.eleven11.beanInput.VersionInput;
import com.mw.eleven11.beanInput.WalletInput;
import com.mw.eleven11.beanInput.WinnerBreakupInput;
import com.mw.eleven11.beanInput.WithdrawInput;
import com.mw.eleven11.beanOutput.AllContestOutPut;
import com.mw.eleven11.beanOutput.AvatarListOutput;
import com.mw.eleven11.beanOutput.ContestDetailOutput;
import com.mw.eleven11.beanOutput.ContestUserOutput;
import com.mw.eleven11.beanOutput.CreateContestOutput;
import com.mw.eleven11.beanOutput.DefaultRespose;
import com.mw.eleven11.beanOutput.DreamTeamOutput;
import com.mw.eleven11.beanOutput.ForgetPasswordOut;
import com.mw.eleven11.beanOutput.GetDraftPlayerPointOutput;
import com.mw.eleven11.beanOutput.JoinContestOutput;
import com.mw.eleven11.beanOutput.JoinedContestOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.beanOutput.MatchContestOutPut;
import com.mw.eleven11.beanOutput.MatchDetailOutPut;
import com.mw.eleven11.beanOutput.MatchResponseOut;
import com.mw.eleven11.beanOutput.MyContestMatchesOutput;
import com.mw.eleven11.beanOutput.MyTeamOutput;
import com.mw.eleven11.beanOutput.NotificationsResponse;
import com.mw.eleven11.beanOutput.PaytmWithdrawOutput;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.beanOutput.PointsList;
import com.mw.eleven11.beanOutput.PromoCodeListOutput;
import com.mw.eleven11.beanOutput.PromoCodeResponse;
import com.mw.eleven11.beanOutput.RankingOutput;
import com.mw.eleven11.beanOutput.ReferralUsersResponse;
import com.mw.eleven11.beanOutput.RequestOtpForSigninOutput;
import com.mw.eleven11.beanOutput.ResponceSignup;
import com.mw.eleven11.beanOutput.ResponseBanner;
import com.mw.eleven11.beanOutput.ResponseDownloadTeam;
import com.mw.eleven11.beanOutput.ResponseFavoriteTeam;
import com.mw.eleven11.beanOutput.ResponsePayTmDetails;
import com.mw.eleven11.beanOutput.ResponsePlayerFantasyStats;
import com.mw.eleven11.beanOutput.ResponseReferralDetails;
import com.mw.eleven11.beanOutput.SeriesOutput;
import com.mw.eleven11.beanOutput.SingleTeamOutput;
import com.mw.eleven11.beanOutput.SubjectOutput;
import com.mw.eleven11.beanOutput.TransactionsBean;
import com.mw.eleven11.beanOutput.VersonBean;
import com.mw.eleven11.beanOutput.WalletOutputBean;
import com.mw.eleven11.beanOutput.WinBreakupOutPut;
import com.mw.eleven11.beanOutput.WithDrawoutput;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * This interface will describe service methods.
 */

public interface AppServices {


    @Headers("Content-Type: application/json")
    @POST("utilities/getAppVersionDetails")
    Call<VersonBean> appVersion(@Body VersionInput mVersionInput);

    @Headers("Content-Type: application/json")
    @POST("signup")
    Call<ResponceSignup> signUp(@Body SingupInput mSingupInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<ResponsePlayerFantasyStats> playerFantasyStats(@Url String url, @Body PlayerFantasyStatsInput mPlayerFantasyStatsInput);

    @Headers("Content-Type: application/json")
    @POST("signin")
    Call<LoginResponseOut> login(@Body LoginInput mLoginInput);

    @Headers("Content-Type: application/json")
    @POST("recovery")
    Call<ForgetPasswordOut> forgotPassword(@Body LoginInput mLoginInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<DefaultRespose> deleteNotification(@Url String url, @Body NotificationDeleteInput mDeleteInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<ResponseDownloadTeam> downloadTeam(@Url String url, @Body DownloadTeamInput mDownloadTeamInput);


    @Headers("Content-Type: application/json")
    @POST("recovery/setPassword")
    Call<ForgetPasswordOut> resetPassword(@Body LoginInput mLoginInput);

    @Headers("Content-Type: application/json")
    @POST("signup/verifyEmail")
    Call<LoginResponseOut> verifyEmail(@Body LoginInput mLoginInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<MatchResponseOut> matchesListing(@Url String url, @Body MatchListInput mMatchListInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<MyContestMatchesOutput> myContestMatchesList(@Url String url, @Body MyContestMatchesInput myContestMatchesInput);


    @Headers("Content-Type: application/json")
    @POST
    Call<SingleTeamOutput> getUsersingleTeams(@Url String url, @Body MyTeamInput mMyTeamOutput);

    @Headers("Content-Type: application/json")
    @POST("users/getProfile")
    Call<LoginResponseOut> viewProfile(@Body LoginInput mLoginInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<LoginResponseOut> notificationCount(@Url String url, @Body LoginInput mLoginInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<DefaultRespose> notificationMarkRead(@Url String url, @Body NotificationMarkReadInput mLoginInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<ResponseBanner> bannersList(@Url String url, @Body LoginInput mLoginInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<MatchDetailOutPut> matchDetail(@Url String url, @Body MatchDetailInput mLoginInput);

    @Headers("Content-Type: application/json")
    @POST("wallet/getWallet")
    Call<WalletOutputBean> getWallet(@Body WalletInput mWalletInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<ResponseFavoriteTeam> getFavoriteTeam(@Url String url, @Body FavoriteTeamInput mFavoriteTeamInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<DefaultRespose> makeFavoriteTeams(@Url String url, @Body MakeFavoriteTeamInput mFavoriteTeamInput);

    @Headers("Content-Type: application/json")
    @POST("users/updateUserInfo")
    Call<DefaultRespose> updateProfileCall(@Body UpdateProfileInput mUpdateProfileInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<MatchContestOutPut> getContestsByType(@Url String url, @Body MatchContestInput mMatchContestInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<MatchContestOutPut> getjoinedContestsByType(@Url String url, @Body JoinedContestInput mMatchContestInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<AllContestOutPut> getAllContests(@Url String url, @Body MatchContestInput mMatchContestInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<ContestDetailOutput> getContest(@Url String url, @Body ContestDetailInput mContestDetailInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<ContestUserOutput> getJoinedContestsUsers(@Url String url, @Body ContestUserInput mContestDetailInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<PlayersOutput> getPlayers(@Url String url, @Body PlayersInput mPlayersInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<LoginResponseOut> addUserTeam(@Url String url, @Body CreateTeamInput mCreateTeamInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<LoginResponseOut> editUserTeam(@Url String url, @Body CreateTeamInput mCreateTeamInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<MyTeamOutput> getUserTeams(@Url String url, @Body MyTeamInput mMyTeamOutput);


    @Headers("Content-Type: application/json")
    @POST
    Call<JoinContestOutput> joinContest(@Url String url, @Body JoinContestInput mJoinContestInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<PromoCodeResponse> promoCode(@Url String url, @Body PromoCodeInput mPromoCodeInput);

    @Headers("Content-Type: application/json")
    @POST("users/getRefferalUsers")
    Call<ReferralUsersResponse> getReferralUsers(@Body LoginInput mLoginInput);

    @Headers("Content-Type: application/json")
    @POST("users/referEarn")
    Call<DefaultRespose> getReferEarn(@Body ReferEarnInput mReferEarnInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<GetDraftPlayerPointOutput> getDraftPlayersPoint(@Url String url, @Body GetDraftPlayerPointInput getDraftPlayerPointInput);



/*

    @Headers("Content-Type: application/json")
    @POST("contest/getContests")
    Call<JoinedContestOutput> getJoinedContests(@Body JoinedContestInput mJoinedContestInput);
*/


    @Headers("Content-Type: application/json")
    @POST
    Call<JoinedContestOutput> getJoinedContests(@Url String url, @Body JoinedContestInput mJoinedContestInput);

    @Headers("Content-Type: application/json")
    @POST("users/updateUserInfoPhone")
    Call<LoginResponseOut> sendMobileUserOtp(@Body VerifyMobileInput mobileInput);


    @Headers("Content-Type: application/json")
    @POST("users/updateUserInfo")
    Call<LoginResponseOut> sendMobileOtp(@Body VerifyMobileInput mobileInput);

    @Headers("Content-Type: application/json")
    @POST("signup/verifyEmail")
    Call<LoginResponseOut> verifyEmail(@Body VerifyMobileInput mobileInput);

//
//    @Headers("Content-Type: application/json")
//    @POST("signup/verifyPhoneNumber")
//    Call<LoginResponseOut> verifyPhoneNumber(@Body VerifyMobileInput mobileInput);


    @Headers("Content-Type: application/json")
    @POST("signup/verifyPhoneNumberOTP")
    Call<LoginResponseOut> verifyPhoneNumber(@Body VerifyMobileInput mobileInput);

    @Headers("Content-Type: application/json")
    @POST("signup/resendverify")
    Call<LoginResponseOut> resendverify(@Body VerifyMobileInput mobileInput);

    @Multipart
    @POST("upload/image")
    Call<LoginResponseOut> uploadImage(
            @Part("SessionKey") RequestBody userLoginSessionKey,
            @Part("Section") RequestBody nameRequestBody,
            @Part("MediaCaption") RequestBody aadharNumberRequestBody,
            @NonNull @Part MultipartBody.Part file);


    @Headers("Content-Type: application/json")
    @POST
    Call<DreamTeamOutput> bestPlayer(@Url String url, @Body DreamTeamInput mDreamTeamInput);


    @Headers("Content-Type: application/json")
    @POST("signin/signout")
    Call<LoginResponseOut> signout(@Body LoginInput mLoginInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<CreateContestOutput> createContest(@Url String url, @Body CreateContestInput mCreateContestInput);

    @Headers("Content-Type: application/json")
    @POST("utilities/getReferralDetails")
    Call<ResponseReferralDetails> getReferralDetail();

    @Headers("Content-Type: application/json")
    @POST
    Call<WinBreakupOutPut> winning_breakup(@Url String url, @Body WinnerBreakupInput winnerBreakupInput);

    @Headers("Content-Type: application/json")
    @POST("users/changePassword")
    Call<LoginResponseOut> changePassword(@Body ChangePasswordInput mChnagePasswordInput);

    @Headers("Content-Type: application/json")
    @POST("users/getAvtars")
    Call<AvatarListOutput> getAvtars(@Body LoginInput loginInput);


    @Headers("Content-Type: application/json")
    @POST
    Call<SeriesOutput> getSeries(@Url String url, @Body SeriesInput mSeriesInput);


    @Headers("Content-Type: application/json")
    @POST
    Call<RankingOutput> getRankings(@Url String url, @Body RankingInput mRankingInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<LoginResponseOut> switchTeam(@Url String url, @Body SwitchTeamInput switchTeamInput);

    @Headers("Content-Type: application/json")
    @POST("wallet/add")
    Call<ResponsePayTmDetails> payTm(@Body PaytmInput paytmInput);

    @Headers("Content-Type: application/json")
    @POST("wallet/confirmApp")
    Call<LoginResponseOut> payTmResponse(@Body PaytmInput paytmInput);

    @Headers("Content-Type: application/json")
    @POST("Wallet/getWallet")
    Call<TransactionsBean> transactionsApp(@Body TransactionInput transactionInput);

    @Headers("Content-Type: application/json")
    @POST
    Call<NotificationsResponse> notification(@Url String url, @Body NotificationInput notificationInput);

    @Headers("Content-Type: application/json")
    @POST("wallet/withdrawal")
    Call<WithDrawoutput> withdrawal_add(@Body WithdrawInput mWithdrawInput);

    @Streaming
    @GET
    Call<ResponseBody> downloadFileByUrl(@Url String fileUrl);

    @Headers("Content-Type: application/json")
    @POST
    Call<PointsList> getPoints(@Url String url, @Body PointsSystem system);

    @Headers("Content-Type: application/json")
    @POST
    Call<PromoCodeListOutput> promocodeList(@Url String url, @Body PromoCodeListInput system);

    @Headers("Content-Type: application/json")
    @POST("signin/OtpSignIn")
    Call<RequestOtpForSigninOutput> requestOtpForSignin(@Body RequestOtpForSigninInput requestOtpForSigninInput);


    @Headers("Content-Type: application/json")
    @POST("wallet/withdrawal_confirm")
    Call<PaytmWithdrawOutput> withdrawal(@Body WithdrawInput mWithdrawInput);


    @Headers("Content-Type: application/json")
    @GET("utilities/supportMessage")
    Call<SubjectOutput> getSubject();


}