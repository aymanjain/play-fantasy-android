package com.mw.eleven11.appApi.interactors;

import android.text.TextUtils;

import com.mw.eleven11.R;
import com.mw.eleven11.beanInput.ChangePasswordInput;
import com.mw.eleven11.beanInput.ContestUserInput;
import com.mw.eleven11.beanInput.CreateContestInput;
import com.mw.eleven11.beanInput.CreateTeamInput;
import com.mw.eleven11.beanInput.JoinContestInput;
import com.mw.eleven11.beanInput.JoinedContestInput;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanInput.MatchContestInput;
import com.mw.eleven11.beanInput.MatchDetailInput;
import com.mw.eleven11.beanInput.MatchListInput;
import com.mw.eleven11.beanInput.MyTeamInput;
import com.mw.eleven11.beanInput.PaytmInput;
import com.mw.eleven11.beanInput.PlayersInput;
import com.mw.eleven11.beanInput.SingupInput;
import com.mw.eleven11.beanInput.UploadImageInput;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.DataValidationUtils;

import java.io.File;


public class APIValidate {


    //valid signup data
    public static boolean isSignUpValid(SingupInput mSingupInput, IUserInteractor.OnSignUpResponseListener onResponseListener) {
         mSingupInput.setDeviceToken("DemoToken");
        if (TextUtils.isEmpty(mSingupInput.getEmail())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_email));
            return false;
        } else if (!DataValidationUtils.isValidEmail(mSingupInput.getEmail())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.invalid_email));
            return false;
        } else if (TextUtils.isEmpty(mSingupInput.getPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_password));
            return false;
        } else if (DataValidationUtils.isValidPassword(mSingupInput.getPassword().trim())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.short_password));
            return false;
        } else if (mSingupInput.getSource().equals(Constant.Direct) && TextUtils.isEmpty(mSingupInput.getPhoneNumber())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_phone_number));
            return false;
        } else if (mSingupInput.getSource().equals(Constant.Direct) && !DataValidationUtils.checkMobile(mSingupInput.getPhoneNumber())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.invalid_phone_number));
            return false;
        } else if (TextUtils.isEmpty(mSingupInput.getDeviceGUID())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_device_id));
            return false;
        } else if (TextUtils.isEmpty(mSingupInput.getDeviceToken())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_device_token));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isOTPValid(String otp, IUserInteractor.OnResponseListener onResponseListener) {
        if (TextUtils.isEmpty(otp)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_code));
            return false;
        } else if (otp.length() != 6) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.enter_your_code));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isSessionValid(LoginInput loginInput, IUserInteractor.OnAvatarResponseListener onResponseListener) {
        if (TextUtils.isEmpty(loginInput.getSessionKey())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isWithdrawAmountDataValid(String userLoginSessionKey, int withdrawAmount, IUserInteractor.OnResponseListener onResponseListener) {
        if (TextUtils.isEmpty(userLoginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (withdrawAmount == 0) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.please_enter_amount));
            return false;
        } /*else if (withdrawAmount < Constant.LIMIT_MIN_WITHDRAWAL) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.minimum_amount_validation));
            return false;
        } */ else {
            return true;
        }
    }

    //valid login data
    public static boolean isLoginValid(LoginInput mLoginInput, IUserInteractor.OnLoginResponseListener onResponseListener) {

          /* if (TextUtils.isEmpty(mLoginInput.getKeyword())) {
                onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_email));
                return false;
            }else if (TextUtils.isEmpty(mLoginInput.getPassword())) {
                onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_password));
                return false;
            }else {
                    return true;

            }*/

        return true;

    }

   /* //valid login data
    public static boolean isSocialValid(LoginInput mLoginInput, final IUserInteractor.OnLoginResponseListener onResponseListener) {

        if (TextUtils.isEmpty(mLoginInput.getSocial_id())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_social_id));
            return false;
        } else if (TextUtils.isEmpty(mLoginInput.getSocial_signup_type())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_social_type));
            return false;
        } else if (TextUtils.isEmpty(mLoginInput.getDevice_type())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_device_type));
            return false;
        } else if (TextUtils.isEmpty(mLoginInput.getDevice_id())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.network_error));
            return false;
        } else if (TextUtils.isEmpty(mLoginInput.getDevice_token())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_device_token));
            return false;
        } else {
            return true;
        }
    }*/

    public static boolean isForgotPasswordDataValid(LoginInput mLoginInput, IUserInteractor.OnForgetPasswordListener onResponseListener) {
        if (TextUtils.isEmpty(mLoginInput.getKeyword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_email));
            return false;
        } else if (!DataValidationUtils.isValidEmail(mLoginInput.getKeyword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.invalid_email));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isResetPasswordDataValid(LoginInput mLoginInput, IUserInteractor.OnForgetPasswordListener onResponseListener) {
        if (TextUtils.isEmpty(mLoginInput.getOTP())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.enterTheOTPYouRecived));
            return false;
        } else if (TextUtils.isEmpty(mLoginInput.getPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_password));
            return false;
        } else if (!mLoginInput.getPassword().equals(mLoginInput.getConfirmPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.password_notMatch));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isTeamNameValid(String teamName, IUserInteractor.OnResponseListener onResponseListener) {
        if (TextUtils.isEmpty(teamName)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.emptyTeamName));
            return false;
        }/* else if (!DataValidationUtils.isTeamName(teamName)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.invalid_team_name));
            return false;
        }*/ else {
            return true;
        }
    }

   /* public static boolean isResetPasswordValid(LoginInput mLoginInput, IUserInteractor.OnResponseListener onResponseListener) {
        if (TextUtils.isEmpty(mLoginInput.getEmail())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_email));
            return false;
        } else if (!DataValidationUtils.isValidEmail(mLoginInput.getEmail())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.invalid_email));
            return false;
        } else if (TextUtils.isEmpty(mLoginInput.getvCode())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_verification_code));
            return false;
        } else if (mLoginInput.getvCode().length() != 6) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.invalid_verification_code));
            return false;
        } else if (TextUtils.isEmpty(mLoginInput.getPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_new_password));
            return false;
        } else if (DataValidationUtils.isValidPassword(mLoginInput.getPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.short_password));
            return false;
        } else if (TextUtils.isEmpty(mLoginInput.getConfirmPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_confirm_password));
            return false;
        } else if (!mLoginInput.getPassword().equals(mLoginInput.getConfirmPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.password_does_not_match));
            return false;
        } else {
            return true;
        }
    }*/

    public static boolean isMatchesListValid(MatchListInput mMatchListInput, IUserInteractor.OnResponseMatchesListener onResponseListener) {
       /* if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        }else*/
        if (TextUtils.isEmpty(mMatchListInput.getStatus())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_page));
            return false;
        } else {
            return true;
        }
    }


    public static boolean isMyMatchesListValid(JoinedContestInput mMatchListInput, IUserInteractor.OnResponseMyMatchesListener onResponseListener) {
       /* if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        }else*/
        if (TextUtils.isEmpty(mMatchListInput.getSessionKey())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_page));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isMyMatchesListValid(String loginSessionKey, String type, int limit, final int offset, IUserInteractor.OnResponseMatchesListener onResponseListener) {
        if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(type)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_page));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isCheck_contestValid(String loginSessionKey, String user_invite_code, IUserInteractor.OnResponseMatchesListener onResponseListener) {
        if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(user_invite_code)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_page));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isContestListValid(MatchContestInput mMatchContestInput, IUserInteractor.OnResponseContestListener onResponseListener) {
        /*if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(userId)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_user_id));
            return false;
        } else  */

        if (TextUtils.isEmpty(mMatchContestInput.getMatchGUID())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_match_id));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isAllContestListValid(MatchContestInput mMatchContestInput, IUserInteractor.OnResponseAllContestsListener onResponseListener) {
        /*if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else  if (TextUtils.isEmpty(userId)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_user_id));
            return false;
        } else*/

        if (TextUtils.isEmpty(mMatchContestInput.getMatchGUID())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_match_id));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isJoinedContestListValid(String loginSessionKey, String userId, String matchId, IUserInteractor.OnResponseJoinedContesListener onResponseListener) {
        if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(matchId)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_match_id));
            return false;
        } else if (TextUtils.isEmpty(userId)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_user_id));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isViewProfileDataValid(LoginInput mLoginInput, IUserInteractor.OnResponseListener onResponseListener) {
        if (TextUtils.isEmpty(mLoginInput.getSessionKey())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isAvatarIsValid(String userLoginSessionKey, IUserInteractor.OnAvatarUpdateListener onResponseListener) {
        if (TextUtils.isEmpty(userLoginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else {
            return true;
        }
    }


    public static boolean isImageDataValid(String userLoginSessionKey, String filePath, IUserInteractor.OnResponseListener onResponseListener) {
        if (TextUtils.isEmpty(userLoginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(filePath)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_file));
            return false;
        } else if (!new File(filePath).exists()) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.invalid_file));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isSessionValid(String userLoginSessionKey, IUserInteractor.OnResponseAccountListener onResponseListener) {
        if (TextUtils.isEmpty(userLoginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else {
            return true;
        }
    }

    //valid login data
    public static boolean isMobileValid(String mobile, IUserInteractor.OnResponseListener onResponseListener) {

        if (TextUtils.isEmpty(mobile)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_phone_number));
            return false;
        } else if (!DataValidationUtils.checkMobile(mobile)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.invalid_phone_number));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isCodeValid(String code, String email, IUserInteractor.OnResponseListener onResponseListener) {

        if (TextUtils.isEmpty(code)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_code));
            return false;
        } else if (TextUtils.isEmpty(email)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_email));
            return false;
        } else if (!DataValidationUtils.isValidEmail(email)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.invalid_email));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPanDataValid(UploadImageInput uploadImageInput, IUserInteractor.OnResponseListener onResponseListener) {
        if (TextUtils.isEmpty(uploadImageInput.getSessionKey())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (uploadImageInput.getSection().equalsIgnoreCase("BankDetail")) {
            if (TextUtils.isEmpty(uploadImageInput.getFilePath())) {
                onResponseListener.onError(AppUtils.getStrFromRes(R.string.please_select_bank_file));
                return false;
            }else {
                return true;
            }
        } else if (uploadImageInput.getSection().equalsIgnoreCase("PAN")) {
            if (TextUtils.isEmpty(uploadImageInput.getFilePath())) {
                onResponseListener.onError(AppUtils.getStrFromRes(R.string.please_select_pan_picture));
                return false;
            }else {
                return true;
            }
        }  else if (uploadImageInput.getSection().equalsIgnoreCase("Aadhar")) {
            if (TextUtils.isEmpty(uploadImageInput.getFilePath())) {
                onResponseListener.onError(AppUtils.getStrFromRes(R.string.please_select_adhare));
                return false;
            }else {
                return true;
            }
        } else {
            return true;
        }
    }

    public static boolean isSessionValid(String userLoginSessionKey, IUserInteractor.OnCountryResponseListener onResponseListener) {
        if (TextUtils.isEmpty(userLoginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isBankDataValid(String loginSessionKey, String name, String accountNumber, String ifscCode, String state, String country, String accountFile, String bankName, String branchName, IUserInteractor.OnResponseListener onResponseListener) {
        if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(name)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_name));
            return false;
        } else if (TextUtils.isEmpty(accountNumber)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_account));
            return false;
        } else if (TextUtils.isEmpty(ifscCode)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_ifsc));
            return false;
        } else if (TextUtils.isEmpty(bankName)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_bank));
            return false;
        } else if (TextUtils.isEmpty(branchName)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_branch));
            return false;
        }/* else if(TextUtils.isEmpty(country)){
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_country));
            return false;
        }  else if(TextUtils.isEmpty(state)){
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_state));
            return false;
        }*/ else if (TextUtils.isEmpty(accountFile)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.please_select_bank_document));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isChangePasswordDataValid(ChangePasswordInput changePasswordInput, IUserInteractor.OnResponseListener onResponseListener) {
        if (TextUtils.isEmpty(changePasswordInput.getSessionKey())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(changePasswordInput.getCurrentPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_old_password));
            return false;
        } else if (TextUtils.isEmpty(changePasswordInput.getPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_new_password));
            return false;
        } else if (DataValidationUtils.isValidPassword(changePasswordInput.getPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.short_password));
            return false;
        } else if (TextUtils.isEmpty(changePasswordInput.getConfirmPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_confirm_password));
            return false;
        } else if (!changePasswordInput.getConfirmPassword().equals(changePasswordInput.getPassword())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.password_does_not_match));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPayUMoneyValid(String response, IUserInteractor.OnResponseListener onResponseListener) {

        if (TextUtils.isEmpty(response)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_payumoney));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isMatchPlayersValid(PlayersInput mPlayersInput, IUserInteractor.OnResponseMatchPlayersListener onResponseListener) {
       /* if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else*/

        if (TextUtils.isEmpty(mPlayersInput.getMatchGUID())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_page));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isMatchesDetailsValid(MatchDetailInput mmMatchDetailInput, IUserInteractor.OnResponseMatchDetailsListener onResponseListener) {
        /*if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else*/
        if (TextUtils.isEmpty(mmMatchDetailInput.getMatchGUID())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_page));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isTeamListValid(MyTeamInput mMyTeamInput, IUserInteractor.OnResponseTeamsListener onResponseListener) {
        if (TextUtils.isEmpty(mMyTeamInput.getSessionKey())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(mMyTeamInput.getMatchGUID())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_page));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isSingleTeamListValid(MyTeamInput mMyTeamInput, IUserInteractor.OnResponseSingleTeamsListener onResponseListener) {
        if (TextUtils.isEmpty(mMyTeamInput.getSessionKey())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(mMyTeamInput.getMatchGUID())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_page));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isDreamTeamListValid(String loginSessionKey, String userId, String matchId, IUserInteractor.OnResponseDreamTeamsListener onResponseListener) {
        if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(matchId)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_page));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isCreateTeamDataValid(CreateTeamInput mCreateTeamInput, IUserInteractor.OnResponseListener onResponseListener) {
        boolean isCaption = false, isViceCaption = false;
        if (mCreateTeamInput.getUserTeamPlayers() != null)
            for (int i = 0; i < mCreateTeamInput.getUserTeamPlayers().size(); i++) {
                if (mCreateTeamInput.getUserTeamPlayers().get(i).getPlayerPosition().equals(Constant.POSITION_CAPTAIN)) {
                    isCaption = true;
                } else if (mCreateTeamInput.getUserTeamPlayers().get(i).getPlayerPosition().equals(Constant.POSITION_VICE_CAPTAIN)) {
                    isViceCaption = true;
                }
            }

        if (TextUtils.isEmpty(mCreateTeamInput.getSessionKey())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } /*else if (TextUtils.isEmpty(userId)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        }*/ else if (!isCaption) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.create_c_vc));
            return false;
        } else if (!isViceCaption) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.create_c_vc));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isJoinContestValid(JoinContestInput mJoinContestInput, IUserInteractor.OnResponseJoinListener onResponseListener) {

        if (TextUtils.isEmpty(mJoinContestInput.getSessionKey())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isTransferInfoValid(String userLoginSessionKey,
                                              String amount, String account_number, String txn_id, String filePath
            , IUserInteractor.OnResponseListener onResponseListener) {
        if (TextUtils.isEmpty(userLoginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(account_number)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.pleaseEnterAccountNo));
            return false;
        } else if (TextUtils.isEmpty(txn_id)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.pleaseEnterTransectionId));
            return false;
        } else if (TextUtils.isEmpty(amount)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.pleaseEnterAmount));
            return false;
        } /*else if (TextUtils.isEmpty(filePath)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.pleaseSelectImage));
            return false;
        }*/
        {
            return true;
        }
    }

    public static boolean payUMoney(String loginSessionKey, String userId, String amount, String firstname, String email, String phone, IUserInteractor.OnPayUMoneyResponseListener onResponseListener) {
        if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(userId)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(amount)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.err_amount_empty));
            return false;
        } else if (TextUtils.isEmpty(firstname)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_name));
            return false;
        } else if (TextUtils.isEmpty(email)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_email));
            return false;
        } else if (!DataValidationUtils.isValidEmail(email)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.email_not_valid));
            return false;
        }/*else if (TextUtils.isEmpty(phone)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_phone_number));
            return false;
        } else if (!DataValidationUtils.isValidPhoneNumber(phone)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.invalid_phone_number));
            return false;
        }*/ else {
            return true;
        }
    }

    public static boolean isRankListValid(ContestUserInput mContestUserInput, IUserInteractor.OnResponseRanksListener onResponseListener) {
        /*if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else*/
        if (TextUtils.isEmpty(mContestUserInput.getMatchGUID())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_page));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isCreateContestDataValid(CreateContestInput mCreateContestInput, IUserInteractor.OnResponseCreateContestListener onResponseListener) {
        if (TextUtils.isEmpty(mCreateContestInput.getSessionKey())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(mCreateContestInput.getUserGUID())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(mCreateContestInput.getWinningAmount() + "")) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_total_winning_amount));
            return false;
        } else
            /*if (Double.parseDouble(totalWinningAmount.trim().replace(" ",""))<1) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_total_winning_amount_invalid));
            return false;
        }else*/

            if (TextUtils.isEmpty(mCreateContestInput.getContestSize() + "")) {
                onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_contest_sizes));
                return false;
            } else if (Integer.parseInt(mCreateContestInput.getContestSize()) < 2) {
                onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_contest_sizes_invalid));
                return false;
            } else {
                return true;
            }
    }




    public static boolean isPlayerDetailsValid(String loginSessionKey, String matchId, IUserInteractor.OnResponsePlayerDetailsListener onResponseListener) {
        if (TextUtils.isEmpty(loginSessionKey)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        } else if (TextUtils.isEmpty(matchId)) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_page));
            return false;
        } else {
            return true;
        }
    }

    public static boolean payTm(PaytmInput paytmInput, IUserInteractor.OnPayTmResponseListener onResponseListener) {
        if (TextUtils.isEmpty(paytmInput.getSessionKey())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        }/*else  if (TextUtils.isEmpty(paytmInput.getFirstName())) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.empty_session));
            return false;
        }*/ else if (Integer.valueOf(paytmInput.getAmount()) == 0) {
            onResponseListener.onError(AppUtils.getStrFromRes(R.string.err_amount_empty));
            return false;
        } else {
            return true;
        }
    }
}
