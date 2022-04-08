package com.mw.eleven11.UI.more;

import android.support.v7.widget.CardView;
import android.view.View;

import com.mw.eleven11.AppSession;
import com.mw.eleven11.R;
import com.mw.eleven11.UI.contestInviteCode.InviteCodes;
import com.mw.eleven11.UI.home.HomeNavigation;
import com.mw.eleven11.UI.inviteFriends.InviteFriendsActivity;
import com.mw.eleven11.UI.mlb.ReferralUsersActivity;
import com.mw.eleven11.UI.outsideEvents.ContactUsActivity;
import com.mw.eleven11.UI.outsideEvents.OutSideEvent;
import com.mw.eleven11.UI.pointSystem.FootballPointSystemActivity;
import com.mw.eleven11.UI.pointSystem.PointSystemActivity;
import com.mw.eleven11.UI.verifyAccount.VerifyAccountActivity;
import com.mw.eleven11.appApi.interactors.IUserInteractor;
import com.mw.eleven11.appApi.interactors.UserInteractor;
import com.mw.eleven11.base.BaseFragment;
import com.mw.eleven11.beanInput.LoginInput;
import com.mw.eleven11.beanOutput.SpinWheelOutput;
import com.mw.eleven11.customView.CustomTextView;
import com.mw.eleven11.customView.RobotoRegularTextView;
import com.mw.eleven11.utility.AppUtils;
import com.mw.eleven11.utility.Constant;
import com.mw.eleven11.utility.NetworkUtils;

import butterknife.BindView;
import butterknife.OnClick;


public class MoreFragment extends BaseFragment {

    @BindView(R.id.inviteFriends)
    RobotoRegularTextView inviteFriends;

    @BindView(R.id.contestInviteCode)
    RobotoRegularTextView contestInviteCode;

    @BindView(R.id.fantasyPointSystem)
    RobotoRegularTextView fantasyPointSystem;


    @BindView(R.id.help_desk)
    RobotoRegularTextView help_desk;

    @BindView(R.id.workWithUs)
    RobotoRegularTextView workWithUs;

    @BindView(R.id.about_us)
    RobotoRegularTextView about_us;

    @BindView(R.id.legality)
    RobotoRegularTextView legality;

    @BindView(R.id.version)
    RobotoRegularTextView version;

    @BindView(R.id.spin)
    CardView spin;

    @BindView(R.id.verify_your_account)
    RobotoRegularTextView verify_your_account;
    private UserInteractor mInteractor;

    @OnClick(R.id.verifyYourAccountLin)
    void onVerifyAccountClick() {
        VerifyAccountActivity.start(getActivity());
    }

    @OnClick(R.id.offerLin)
    void onOfferLinClick() {
        // OffersActivity.start(getActivity());
    }

    @OnClick(R.id.inviteFriendsLin)
    void onInviteFriendsClick() {
        InviteFriendsActivity.start(getActivity());
    }

    @OnClick(R.id.myReferrals)
    void onReferAndEarnClick() {
        ReferralUsersActivity.start(getActivity());
    }

    @OnClick(R.id.contestInviteCodeLin)
    void onContestinviteClick() {
        InviteCodes.start(getActivity(), "0");
    }

    @OnClick(R.id.fantasyFootballPointSystemLin)
    void onFantasyFootballPointClick() {
        OutSideEvent.start(getActivity(), AppUtils.getStrFromRes(R.string.how_to_play), Constant.POINT_SYSTEM_CRICKET_URL);

//        FootballPointSystemActivity.start(getActivity());
    }

    @OnClick(R.id.fantasyKabaddiPointSystemLin)
    void onFantasyKabaddiPointClick() {
        OutSideEvent.start(getActivity(), "POINT_SYSTEM", Constant.POINT_SYSTEM_KABADDI_URL);
    }

    @OnClick(R.id.fantasyPointSystemLin)
    void onFantasyPointClick() {
        OutSideEvent.start(getActivity(), AppUtils.getStrFromRes(R.string.how_to_play), Constant.POINT_SYSTEM_CRICKET_URL);
        //PointSystemActivity.start(getActivity());
    }

    @OnClick(R.id.how_to_playLin)
    void onHowToPlayClick() {
        OutSideEvent.start(getActivity(), AppUtils.getStrFromRes(R.string.how_to_play), Constant.HOW_TO_PLAY_URL);
    }


    @OnClick(R.id.how_to_playLinFootball)
    void onHowToPlayFootbalClick() {
        OutSideEvent.start(getActivity(), AppUtils.getStrFromRes(R.string.how_to_play_football), Constant.HOW_TO_PLAY_URL_FOOTBALL);
    }

    @OnClick(R.id.how_to_playLin_auction)
    void onHowToPlayAuctionClick() {
        OutSideEvent.start(getActivity(), AppUtils.getStrFromRes(R.string.how_to_play_auction), Constant.HOW_TO_PLAY_AUCTION_URL);
    }


    @OnClick(R.id.how_to_playLin_gully)
    void onHowToPlayDraftClick() {
        OutSideEvent.start(getActivity(), AppUtils.getStrFromRes(R.string.how_to_play_gc), Constant.HOW_TO_PLAY_GC_URL);
    }


    @OnClick(R.id.blog)
    void onBlogClick() {
        OutSideEvent.start(getActivity(), AppUtils.getStrFromRes(R.string.blog), Constant.BLOG);
    }

    @OnClick(R.id.how_to_playLin_football)
    void onHowToPlayFootballClick() {
        // OutSideEvent.start(getActivity(), AppUtils.getStrFromRes(R.string.how_to_play), Constant.HOW_TO_PLAY_FOOTBALL_URL);
    }

    @OnClick(R.id.how_to_playLin_kabaddi)
    void onHowToPlayKabaddiClick() {
        // OutSideEvent.start(getActivity(), AppUtils.getStrFromRes(R.string.how_to_play), Constant.HOW_TO_PLAY_KABADDI_URL);
    }

    @OnClick(R.id.help_deskLin)
    void onHelopdeskClick() {
        OutSideEvent.start(getActivity(), "HELP_DESK", Constant.HELP_DESK_URL);
    }

    @OnClick(R.id.workWithUsLin)
    void onworkWithUsClick() {
        OutSideEvent.start(getActivity(), "WORK_WITH_US", Constant.WORK_WITH_US);
        //ContactUsActivity.start(getActivity());
    }

    @OnClick(R.id.about_usLin)
    void onAboutUsClick() {
        OutSideEvent.start(getActivity(), "ABOUT_US", Constant.ABOUT_URL);
    }


    @OnClick(R.id.legalityLin)
    void onLegalClick() {
        OutSideEvent.start(getActivity(), "LEGALITY", Constant.LEGALITY_URL);
    }

    @OnClick(R.id.fantasy_cricket)
    void onFantasyCricketClick() {
        OutSideEvent.start(getActivity(), "LEGALITY", Constant.FANTASY_CRICKET);
    }

    @OnClick(R.id.spin)
    void onspinClick() {
        //SpinWheelActivity.start(getActivity(),false);
    }


    @Override
    public int getLayout() {
        return R.layout.activity_more_fragment;
    }

    @Override
    public void init() {

        mInteractor = new UserInteractor();
        version.setText(AppUtils.getVersionInfo());
        // apiCallGetSpinData();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        ((HomeNavigation) getActivity()).changeNavigationSelction(3);
    }
}
