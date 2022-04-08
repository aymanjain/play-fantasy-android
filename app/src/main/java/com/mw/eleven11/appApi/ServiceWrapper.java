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

/**
 * <p/>
 * This Wrapper class will be mediator of service interface and calling class.
 * Whatever the features of retrofit and okhttp api will implement, need to be put into this class.
 * We can put common webservice security features to this class so that we can increase the reusability of code.
 */

public class ServiceWrapper {
    private static AppServices service = ServiceGenerator.createService(AppServices.class);
    private static ServiceWrapper serviceWrapper = new ServiceWrapper();

    private ServiceWrapper() {

    }

    public static ServiceWrapper getInstance() {
        if (service == null) service = ServiceGenerator.createService(AppServices.class);
        return serviceWrapper;
    }

    public Call<VersonBean> appVersion(VersionInput version) {
        return service.appVersion(version);
    }

    public Call<LoginResponseOut> loginCall(LoginInput mLoginInput) {
        return service.login(mLoginInput);
    }


    public Call<ForgetPasswordOut> resetPassword(LoginInput mLoginInput) {
        return service.resetPassword(mLoginInput);
    }

    public Call<LoginResponseOut> verifyEmail(LoginInput mLoginInput) {
        return service.verifyEmail(mLoginInput);

    }

    public Call<MatchContestOutPut> getjoinedContestsByType(String url,JoinedContestInput mMatchContestInput){
        return service.getjoinedContestsByType(url,mMatchContestInput);
    }

    public Call<LoginResponseOut> verifyEmailAddress(VerifyMobileInput mobileInput) {
        return service.verifyEmail(mobileInput);
    }

    public Call<ResponsePlayerFantasyStats> playerFantasyStats(String url,PlayerFantasyStatsInput mPlayerFantasyStatsInput){
        return service.playerFantasyStats(url,mPlayerFantasyStatsInput);
    }

    public Call<ResponseDownloadTeam> downloadTeam( String url,DownloadTeamInput mDownloadTeamInput){
        return service.downloadTeam(url,mDownloadTeamInput);
    }



    public Call<DefaultRespose> deleteNotification(String url,NotificationDeleteInput mDeleteInput){
        return service.deleteNotification(url,mDeleteInput);
    }

    public Call<MatchResponseOut> matchesListingCall(String url,MatchListInput mMatchListInput) {
        return service.matchesListing(url,mMatchListInput);
    }


    public Call<SingleTeamOutput> getSingleUserTeams(String url, MyTeamInput mMyTeamListInput) {
        return service.getUsersingleTeams(url,mMyTeamListInput);
    }


    public Call<LoginResponseOut> viewProfileCall(LoginInput mLoginInput) {
        return service.viewProfile(mLoginInput);
    }

    public Call<LoginResponseOut> notificationCount(String url,LoginInput mLoginInput){
        return service.notificationCount(url,mLoginInput);
    }

    public Call<DefaultRespose> notificationMarkRead(String url,NotificationMarkReadInput mNotificationMarkReadInput){
        return service.notificationMarkRead(url,mNotificationMarkReadInput);
    }

    public Call<ResponseBanner> bannersList(String url,LoginInput mLoginInput) {
        return service.bannersList(url,mLoginInput);

    }

    public Call<MatchDetailOutPut> matchDetail(String url,MatchDetailInput mLoginInput) {
        return service.matchDetail(url,mLoginInput);
    }

    public Call<WalletOutputBean> getWallet(WalletInput mWalletInput) {
        return service.getWallet(mWalletInput);
    }

    public Call<ResponseFavoriteTeam> getFavoriteTeam(String url,FavoriteTeamInput mFavoriteTeamInput){
        return service.getFavoriteTeam(url,mFavoriteTeamInput);
    }

    public Call<DefaultRespose> updateProfileCall(UpdateProfileInput mUpdateProfileInput) {
        return service.updateProfileCall(mUpdateProfileInput);
    }

    public Call<DefaultRespose> makeFavoriteTeams(String url,MakeFavoriteTeamInput makeFavoriteTeamInput){
        return service.makeFavoriteTeams(url,makeFavoriteTeamInput);
    }

    public Call<MatchContestOutPut> getContestsByType(String url,MatchContestInput mMatchContestInput) {
        return service.getContestsByType(url,mMatchContestInput);
    }

    public Call<AllContestOutPut> getAllContests(String url,MatchContestInput mMatchContestInput) {
        return service.getAllContests(url,mMatchContestInput);
    }



    public Call<MyContestMatchesOutput> myContestMatchesList(String url,MyContestMatchesInput myContestMatchesInput){
        return service.myContestMatchesList(url,myContestMatchesInput);
    }


    public Call<ContestDetailOutput> getContest(String url,ContestDetailInput mContestDetailInput) {
        return service.getContest(url,mContestDetailInput);
    }

    public Call<ContestUserOutput> getJoinedContestsUsers(String url,ContestUserInput mContestUserInput) {
        return service.getJoinedContestsUsers(url,mContestUserInput);
    }

    public Call<PlayersOutput> getPlayers(String url,PlayersInput mPlayersInput) {
        return service.getPlayers(url,mPlayersInput);
    }

    public Call<LoginResponseOut> addUserTeam(String url,CreateTeamInput mPlayersInput) {
        return service.addUserTeam(url,mPlayersInput);
    }

    public Call<LoginResponseOut> editUserTeam(String url,CreateTeamInput mPlayersInput) {
        return service.editUserTeam(url,mPlayersInput);
    }

    public Call<PromoCodeResponse> promoCode(String url,PromoCodeInput mPromoCodeInput){
        return service.promoCode(url,mPromoCodeInput);
    }

    public Call<MyTeamOutput> getUserTeams(String url,MyTeamInput mMyTeamListInput) {
        return service.getUserTeams(url,mMyTeamListInput);
    }

    public Call<JoinContestOutput> joinContest(String url,JoinContestInput mJoinContestOutput) {
        return service.joinContest(url, mJoinContestOutput);
    }



    public Call<JoinedContestOutput> getJoinedContests(String url,JoinedContestInput mJoinedContestInput) {
        return service.getJoinedContests(url,mJoinedContestInput);
    }

    public Call<DreamTeamOutput> dreamTeam(String url,DreamTeamInput mDreamTeamInput) {
        return service.bestPlayer(url,mDreamTeamInput);
    }


    public Call<LoginResponseOut> sendMobileOtp(VerifyMobileInput mobileInput) {
        return service.sendMobileOtp(mobileInput);
    }



    public Call<LoginResponseOut> sendMobileUserOtp(VerifyMobileInput mobileInput) {
        return service.sendMobileUserOtp(mobileInput);
    }

    public Call<ResponseReferralDetails> getReferralDetail(){
        return service.getReferralDetail();
    }

    public Call<LoginResponseOut> verifyPhoneNumber(VerifyMobileInput mobileInput) {
        return service.verifyPhoneNumber(mobileInput);
    }

    public Call<LoginResponseOut> resendverify(VerifyMobileInput mobileInput) {
        return service.resendverify(mobileInput);
    }

    public Call<LoginResponseOut> uploadImage(
            RequestBody SessionKeyRequestBody
            , RequestBody sectionRequestBody
            , RequestBody mediaCaptionRequestBody
            , MultipartBody.Part file) {
        return service.uploadImage(SessionKeyRequestBody
                , sectionRequestBody
                , mediaCaptionRequestBody
                , file);
    }


    public Call<CreateContestOutput> createContest(String url,CreateContestInput mobileInput) {
        return service.createContest(url,mobileInput);
    }


    public Call<LoginResponseOut> switchTeam(String url,SwitchTeamInput switchTeamInput) {
        return service.switchTeam(url,switchTeamInput);
    }

    public Call<ResponsePayTmDetails> payTm(PaytmInput paytmInput) {
        return service.payTm(paytmInput);
    }

    public Call<LoginResponseOut> payTmResponse(PaytmInput paytmInput) {


        return service.payTmResponse(paytmInput);
    }


    public Call<ResponseBody> downloadFileByUrlCall(@NonNull String fileUrl) {
        return service.downloadFileByUrl(fileUrl);
    }


    public Call<TransactionsBean> transactionsApp(TransactionInput transactionInput) {
        return service.transactionsApp(transactionInput);
    }


    public Call<ResponceSignup> signUpCall(SingupInput mSingupInput) {
        return service.signUp(mSingupInput);


    }

    public Call<ForgetPasswordOut> forgotPasswordCall(LoginInput mLoginInput) {
        return service.forgotPassword(mLoginInput);
    }



    public Call<WinBreakupOutPut> winning_breakup(String url,WinnerBreakupInput mWinnerBreakupInput) {
        return service.winning_breakup(url,mWinnerBreakupInput);
    }


    public Call<LoginResponseOut> changePassword(ChangePasswordInput mChangePasswordInput) {
        return service.changePassword(mChangePasswordInput);
    }

    public Call<AvatarListOutput> getAvtars(LoginInput mLoginInput) {
        return service.getAvtars(mLoginInput);
    }
    public Call<RankingOutput> getRankings(String url,RankingInput mRankingInput) {
        return service.getRankings(url,mRankingInput);
    }

    public Call<SeriesOutput> matchSeries(String url,SeriesInput seriesInput) {
        return service.getSeries(url,seriesInput);
    }
    public Call<NotificationsResponse> notificationList(String url,NotificationInput notificationInput) {
        return service.notification(url,notificationInput);
    }
    public Call<WithDrawoutput> withdrawal_add(WithdrawInput mWithdrawInput) {
        return service.withdrawal_add(mWithdrawInput);
    }




    public Call<RequestOtpForSigninOutput> requestOtpForSignin(RequestOtpForSigninInput requestOtpForSigninInput) {
        return service.requestOtpForSignin(requestOtpForSigninInput);
    }

    public Call<PointsList> getList(String url,PointsSystem system) {
        return service.getPoints(url,system);
    }

    public Call<PromoCodeListOutput> promocodeList (String url,PromoCodeListInput mPromoCodeListOutput){
        return service.promocodeList(url,mPromoCodeListOutput);
    }
    public Call<PaytmWithdrawOutput> withdrawal_confirm(WithdrawInput mWithdrawInput) {
        return service.withdrawal(mWithdrawInput);
    }


    public Call<ReferralUsersResponse> getReferralUsers(LoginInput mLoginInput){
        return service.getReferralUsers(mLoginInput);
    }

    public  Call<DefaultRespose> getReferEarn(ReferEarnInput mReferEarnInput) {
        return service.getReferEarn(mReferEarnInput);
    }


    public Call<GetDraftPlayerPointOutput> getDraftPlayersPoint(String url, GetDraftPlayerPointInput getDraftPlayerPointInput) {
        return service.getDraftPlayersPoint(url,getDraftPlayerPointInput);
    }


    public Call<SubjectOutput> getSubject(){
        return service.getSubject();
    }




}