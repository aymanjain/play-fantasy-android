package com.mw.eleven11.UI.userProfile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.addMoney.AddMoneyActivity;
import com.mw.eleven11.UI.changePassword.ChangePasswordActivity;
import com.mw.eleven11.UI.changeTeamName.ChangeTeamName;
import com.mw.eleven11.UI.changeUserAvatar.UserAvatarActivity;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.inviteFriends.InviteFriendsActivity;
import com.mw.eleven11.UI.leaderboardRanking.LeaderboardRankingActivity;
import com.mw.eleven11.UI.loginRagisterModule.LoginScreen;
import com.mw.eleven11.UI.myAccount.MyAccountActivity;
import com.mw.eleven11.UI.myAccount.MyAccountParentPresenterImpl;
import com.mw.eleven11.UI.outsideEvents.OutSideEvent;
import com.mw.eleven11.UI.personalDetails.PersonalDetailsActivity;
import com.mw.eleven11.UI.transections.TransactionsActivity;
import com.mw.eleven11.UI.verifyAccount.VerifyAccountActivity;
import com.mw.eleven11.UI.withdrawAmount.WithdrawAmountDialogActivity;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.base.Loader;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanOutput.AvatarListOutput;
import com.mw.eleven11.beanOutput.LoginResponseOut;
import com.mw.eleven11.customView.CustomImageView;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.customView.RobotoRegularTextView;
import com.mw.eleven11.dialog.AlertDialog;
import com.mw.eleven11.dialog.ProgressDialog;
import com.mw.eleven11.textdrawable.TextDrawable;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.OnItemClickListener;
import com.mw.eleven11.utility.ViewUtils;

import butterknife.BindView;
import butterknife.OnClick;


public class UserProfileFragment extends BaseFragment implements MyProfileParentView {
    @BindView(R.id.ctvTeamName)
    RobotoRegularTextView ctvTeamName;

    @BindView(R.id.civPic)
    CustomImageView avatar;

    @BindView(R.id.ctv_deposited)
    RobotoRegularTextView mCtvDeposited;

    @BindView(R.id.ctv_winnings)
    RobotoRegularTextView mCtvWinnings;

    @BindView(R.id.ctv_bonus)
    RobotoRegularTextView mCtvBonus;

    @OnClick(R.id.ctvBtnEdit)
    void onUserNameChange() {
        Intent in = new Intent(mContext, ChangeTeamName.class);
        if (responseLogin.getData().getUsername().length() == 0) {
            in.putExtra("teamName", "");
        } else {
            in.putExtra("teamName", ctvTeamName.getText().toString());
        }
        startActivityForResult(in, REQUEST_TEAM_NAME);
    }


    @OnClick(R.id.rlPicRoot)
    void onProfilePictureClick() {
        Intent in = new Intent(mContext, UserAvatarActivity.class);
        startActivityForResult(in, REQUEST_CODE_AVATAR);

    }


    @OnClick(R.id.cv_add_cash)
    void onClickAddCash() {
        Intent starter = new Intent(getActivity(), AddMoneyActivity.class);
        startActivityForResult(starter, 112);
        ((Activity) getActivity()).overridePendingTransition(R.anim.dialog_open, R.anim.dialog_close);
    }

    @OnClick(R.id.cv_withdraw_cash)
    void onClickWithdrawal() {
        if (responseLogin != null) {

            if ((responseLogin.getData().getEmailStatus().equals("Verified")
                    && responseLogin.getData().getPhoneStatus().equals("Verified")
                    && responseLogin.getData().getPanStatus().equals("Verified"))
            ) {
                if (winningamt == 0) {
                    AppUtils.showToast(mContext, AppUtils.getStrFromRes(R.string.Sorry_Insufficient_winning_amount));
                    return;
                } else {
                    WithdrawAmountDialogActivity.start(mContext);
                }
            } else {
                VerifyAccountActivity.start(mContext);
            }
        }
    }


    @OnClick(R.id.cv_recent_transaction)
    void onRecentTransactioneClick() {
        TransactionsActivity.start(mContext);
    }

    @OnClick(R.id.cv_personal_details)
    public void onClickFullProfile() {
        startActivityForResult(PersonalDetailsActivity.startForResult(mContext), 111);
    }

    @OnClick(R.id.cv_change_password)
    public void onClickChangePassword() {
        ChangePasswordActivity.start(getActivity());
    }

    @OnClick(R.id.cv_logout)
    void onClickLogout() {
        if (alertLogoutDialog == null) {
            alertLogoutDialog = new AlertDialog(getActivity(),
                    AppUtils.getStrFromRes(R.string.logout_app), AppUtils.getStrFromRes(R.string.okay),
                    AppUtils.getStrFromRes(R.string.cancel), new AlertDialog.OnBtnClickListener() {
                @Override
                public void onYesClick() {
                    AppSession.getInstance().clearSession();
                    LoginScreen.start(mContext, "");
                }
                @Override
                public void onNoClick() {
                }
            });
        }
        alertLogoutDialog.show();
    }

    public static final int REQUEST_CODE_AVATAR = 402;
    public static final int REQUEST_TEAM_NAME = 403;
    private Context mContext;
    private Loader loader;
    private MyProfileParentPresenterImpl mMyProfileParentPresenterImpl;
    private LoginResponseOut responseLogin;
    private AlertDialog alertLogoutDialog;
    Double winningamt = 0.0;


    @Override
    public int getLayout() {
        return R.layout.user_profile;
    }

    @Override
    public void init() {
        if (isAttached()) {
            mContext = getActivity();
            mMyProfileParentPresenterImpl = new MyProfileParentPresenterImpl(this, new UserInteractor());
            loader = new Loader(getCurrentView());
            loader.getTryAgainView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callViewProfile();
                }
            });
            callViewProfile();
        }
    }

    void callViewProfile() {
        LoginInput mLoginInput = new LoginInput();
        mLoginInput.setSessionKey(AppSession.getInstance().getLoginSession().getData().getSessionKey());
        mLoginInput.setUserGUID(AppSession.getInstance().getLoginSession().getData().getUserGUID());
        mLoginInput.setParams(Constant.GET_PROFILE_PARAMS);
        mLoginInput.setCashbonusExpiry("Yes");
        mMyProfileParentPresenterImpl.actionViewProfile(mLoginInput);
    }


    @Override
    public boolean isAttached() {
        return isAdded() && getActivity() != null;
    }


    @Override
    public void hideLoading() {
        if (isAdded() && getActivity() != null) {
            loader.hide();
        }
    }


    @Override
    public void onProfileSuccess(LoginResponseOut responseLogin) {
        hideLoading();
        if (isAdded() && getActivity() != null) {
            winningamt = Double.valueOf(responseLogin.getData().getWinningAmount());
            this.responseLogin = responseLogin;
            onSetProfilePicture(responseLogin.getData().getProfilePic());
            ctvTeamName.setText(responseLogin.getData().getUsername());
            mCtvDeposited.setText("₹" + responseLogin.getData().getWalletAmount());
            mCtvWinnings.setText("₹" + responseLogin.getData().getWinningAmount());
            mCtvBonus.setText("₹" + responseLogin.getData().getCashBonus());
        }
    }


    @Override
    public void showLoading() {
        if (isAdded() && getActivity() != null) {
            loader.start();
        }
    }


    @Override
    public void onProfileFailure(String error) {
        if (isAdded() && getActivity() != null) {
            hideLoading();
            loader.error(error);
        }
    }


    @Override
    public void onSetProfilePicture(@NonNull String value) {
        if (isAdded() && getActivity() != null) {
            if (!TextUtils.isEmpty(value))
                ViewUtils.setImageUrl(avatar, value);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 112) {
            callViewProfile();
        }
        if (requestCode == 111) {
            if (data != null) {
                if (data.hasExtra("updateProfile")) {
                    callViewProfile();
                }
            }

        }
        if (requestCode == REQUEST_CODE_AVATAR && resultCode == getActivity().RESULT_OK && data != null) {

            AvatarListOutput.DataBean.RecordsBean selectedIcon = new AvatarListOutput.DataBean.RecordsBean();
            if (data.hasExtra("selectedIcon")) {
                selectedIcon = (AvatarListOutput.DataBean.RecordsBean) data.getSerializableExtra("selectedIcon");
            }
        }
        if (requestCode == REQUEST_TEAM_NAME && resultCode == getActivity().RESULT_OK && data != null) {


            if (data.hasExtra("changeName")) {

//                userName.setText(data.getStringExtra("changeName"));

                Log.d("changeName", data.getStringExtra("changeName"));


            }

        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        ((HomeNavigation) getActivity()).changeNavigationSelction(2);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMyProfileParentPresenterImpl != null)
            mMyProfileParentPresenterImpl.actionLoginCancel();
    }

    @Override
    public void onResume() {
        callViewProfile();
        super.onResume();
    }
}

