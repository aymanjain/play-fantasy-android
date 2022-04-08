package com.mw.eleven11.utility;

import com.mw.eleven11.AppConfiguration;

/**
 * Created by cstudioo on 11/01/17.
 */

public interface Constant {

    //Client source
    String Direct = "Direct";
    String Facebook = "Facebook";
    String Twitter = "Twitter";
    String Google = "Google";
    String LinkedIN = "LinkedIN";

    String MOBILE="Mobile";
    String PAYTM="Paytm";
    String RAZORPAY="Razorpay";

    String Success="Success";
    String Failed="Failed";


    String BANK="Bank";


    String AUCTION="Auction";
    String DRAFT="Draft";


    //2=User, 3=Another type of user
    int UserTypeID = 2;

    String ANDROID_PHONE="AndroidPhone";

    /*SharePreference Key*/
    String WALK_THROUGH_STATUS="WALK_THROUGH_STATUS"; // Daily fantasy=0, Auction=1, Snack Draft=3
    String PLAY_MODE="PLAY_MODE"; // Daily fantasy=0, Auction=1, Snack Draft=3
    String RESPONSE_LOGIN = "ResponseLogin";
    String RESPONSE_FILTER = "ResponseFilter";
    String RESPONSE_BANNER = "ResponseBanner";

    String RESPONSE_TEAM = "ResponseMatchPlayers";
    String NULL_DATA_MESSAGE = "Null response";

    String EXCEPTION_MESSAGE = "Something went wrong, please try again later.";
    String NOT_GETTING_RESPONSE = "Response not received";

    String WS_URL = AppConfiguration.MAIN_URL + AppConfiguration.SUB_URL;  //server




    String PRIVACY_POLICY_URL = AppConfiguration.WEB_URL + "privacy.php?type=mobile";
    String TERMS_CONDITIONS_URL = AppConfiguration.WEB_URL + "TermConditions?type=mobile";
    String ABOUT_URL = AppConfiguration.WEB_URL + "AboutUs?type=mobile";
    String HELP_DESK_URL = AppConfiguration.WEB_URL + "Faq?type=mobile";
    String LEGALITY_URL = AppConfiguration.WEB_URL + "Legalities?type=mobile";
    String FANTASY_CRICKET = AppConfiguration.WEB_URL + "fantasy-cricket?type=mobile";
    String POINT_SYSTEM_CRICKET_URL = AppConfiguration.WEB_URL + "PointSystem?type=mobile";
    String HOW_TO_PLAY_URL = AppConfiguration.WEB_URL + "Howtoplay?type=mobile";
    String HOW_TO_PLAY_URL_FOOTBALL = AppConfiguration.WEB_URL + "how-to-play-fantasy-football?type=mobile";
    String HOW_TO_PLAY_AUCTION_URL = AppConfiguration.WEB_URL + "AuctionHowtoPlay?type=mobile";
    String HOW_TO_PLAY_GC_URL = AppConfiguration.WEB_URL + "GullyHowtoPlay?type=mobile";
    String BLOG = AppConfiguration.WEB_URL + "blog?type=mobile";
    String POINT_SYSTEM_URL = AppConfiguration.WEB_URL + "help?type=mobile";
    String CONTACT_US_URL = AppConfiguration.WEB_URL + "help?type=mobile";
    String CONTACT_LEGALITY_URL = AppConfiguration.WEB_URL + "help?type=mobile";
    String WORK_WITH_US = AppConfiguration.WEB_URL + "contactUs?type=mobile";
    String HOW_TO_PLAY_FOOTBALL_URL = AppConfiguration.WEB_URL + "help?type=mobile";
    String HOW_TO_PLAY_KABADDI_URL = AppConfiguration.WEB_URL + "help?type=mobile";
    String POINT_SYSTEM_FOOTBALL_URL = AppConfiguration.WEB_URL + "help?type=mobile";
    String POINT_SYSTEM_KABADDI_URL = AppConfiguration.WEB_URL + "help?type=mobile";
    String LEVEL_URL = AppConfiguration.WEB_URL + "help?type=mobile";
    String HOW_IT_WORKS_URL = AppConfiguration.WEB_URL + "HowItWork?type=mobile";
    String FAIR_PLAY_URL = AppConfiguration.WEB_URL + "fair_play.php?type=mobile";

    /*LEGALITY_URL
     * POINT_SYSTEM_CRICKET_URL
     * HOW_TO_PLAY_URL
     * POINT_SYSTEM_URL
     * CONTACT_US_URL
     * POINT_SYSTEM_CRICKET_URL*/

    String KEY_DATA = "data";
    /*BASIC*/
    String DEVICE_TYPE = "AndroidPhone";
    int PAGE_LIMIT = 10;
    int PAGE_LIMIT15 = 15;
    int PAGE_LIMIT_20 = 20;

    long SPLASH_MILLISECOND_TIME = 3000;

    int SHOW_TIME_LIMIT_HRS = 24;
    /*NOTIFICATIONS*/

/*'AllRounder','Batsman','Bowler','WicketKeeper','Other'*/

    String ROLE_ALLROUNDER = "AllRounder";
    String ROLE_BATSMAN = "Batsman";
    String ROLE_BOWLER = "Bowler";
    String ROLE_WICKETKEEPER = "WicketKeeper";
    String ROLE_OTHERS="Other";

//    String ROLE_DEFENDER = "DEFENDER";
    String ROLE_DEFENDER = "Defender";
//    String ROLE_MIDFIELDER = "MIDFIELDER";
    String ROLE_MIDFIELDER = "Midfielder";
//    String ROLE_FORWARD = "FORWARD";
    String ROLE_FORWARD = "Striker";
//    String ROLE_GOALKEEPER = "GOALKEEPER";
    String ROLE_GOALKEEPER = "Goalkeeper";
    String POSITION_PLAYER = "Player";
    String POSITION_VICE_CAPTAIN = "ViceCaptain";
    String POSITION_CAPTAIN = "Captain";

    String PAN_VERIFICATION = "VERIFICATION";
    String JOINCONTEST = "JOINCONTEST";
    String JOIN_CONTEST = "JOIN_CONTEST";
    String USER_CASH_REFUND = "USER_CASH_REFUND";
    String USER_DEPOSITE_AMOUNT = "USER_DEPOSITE_AMOUNT";
    String USER_CASH_BONUS = "USER_CASH_BONUS";
    String ADMIN_NOTIFICATION = "ADMIN";
    String ADMIN_OFFERS = "Offers";
    String USER_CASH_WINNING = "USER_CASH_WINNING";

    //Match listing Params
    String SeriesName = "SeriesName";
    String MatchType = "MatchType";
    String MatchNo = "MatchNo";
    String MatchStartDateTime = "MatchStartDateTime";
    String TeamNameLocal = "TeamNameLocal";
    String TeamNameVisitor = "TeamNameVisitor";
    String TeamNameShortLocal = "TeamNameShortLocal";
    String TeamNameShortVisitor = "TeamNameShortVisitor";
    String TeamFlagLocal = "TeamFlagLocal";
    String TeamFlagVisitor = "TeamFlagVisitor";
    String MatchLocation = "MatchLocation";
    String Status = "Status";
    String StatusID = "StatusID";
    String CurrentDateTime = "CurrentDateTime";

    //Wallet mode
    String All="All";
    String WalletAmount="WalletAmount";
    String WinningAmount="WinningAmount";
    String CashBonus="CashBonus";

    //orderBy
    String UserRank="UserRank";


    String TRANSACTION_PARAMS ="TransactionType,Narration, Amount,TransactionID,WalletAmount,WinningAmount,CashBonus,EntryDate,Status";

    String MATCH_PARAMS = "IsPlayingXINotificationSent,ContestAvailable,SeriesName,TeamPlayersAvailable,MatchType,MatchNo,MatchStartDateTime,MatchDate,MatchTime,CurrentDateTime,TeamNameLocal," +
            "TeamNameVisitor,TeamNameShortLocal,TeamNameShortVisitor,TeamFlagLocal,TeamFlagVisitor," +
            "MatchLocation,Status,StatusID,MatchScoreDetails,isJoinedContest,SeriesGUID,ContestsAvailable,MatchTypeByApi";

    String GET_PROFILE_PARAMS = "ProfileCreationDate,Rating,UserTypeID,UserTypeName,FirstName,MiddleName,LastName," +
            " About,About1,About2,Email,Username,Gender, BirthDate, MyFavouriteTeams," +
            " Address, Address1, Postal, CountryCode, CountryName, CityName," +
            "StateName,PhoneNumber,Website,FacebookURL,TwitterURL," +
            " GoogleURL, InstagramURL,LinkedInURL,WhatsApp,ReferralCode,ProfilePic,WalletAmount,WinningAmount,WalletID," +
            "CashBonus,TotalCash,Postal,PanStatus,BankStatus,PhoneStatus,EmailStatus,MediaPAN,MediaBANK,PlayingHistory,SessionKey,IsPrivacyNameDisplay,AadharStatus,MediaAadhar";

    String WALLET_PARAMS="Amount,CurrencyPaymentGateway,TransactionType,TransactionID,Status," +
            "Narration,OpeningBalance,ClosingBalance,EntryDate,WalletDetails,VerificationDetails";


    String WALLET_PARAMS_M="Amount,MediaBANK,CurrencyPaymentGateway,TransactionType,TransactionID,Status," +
            "Narration,OpeningBalance,ClosingBalance,EntryDate,WalletDetails,VerificationDetails";

    String CONTEST_PARAM="MatchTypeByApi,WinningType,WinUpTo,WinningRatio,UnfilledWinningPercent,SmartPool,Privacy,TotalJoined,IsPaid,StatusID,WinningAmount,ContestSize,EntryFee," +
            "NoOfWinners,EntryType,IsJoined,Status,ContestFormat,ContestType," +
            "CustomizeWinning,TotalJoined,UserInvitationCode,TeamNameLocal," +
            "TeamNameVisitor,IsConfirm,CashBonusContribution,TeamNameShortLocal,TeamNameShortVisitor,MatchGUID,CashBonusContribution,IsPrivacyNameDisplay,FirstRankPrize,GuaranteeSeat";

    String LARBOARD_PARAM = "WinningType,SmartPool,SmartPoolWinning,UserTeamName,TotalPoints,UserWinningAmount,FirstName,Username,UserGUID," +
            "UserTeamPlayers,UserTeamID,UserRank,ProfilePic,PlayerCountry";

    String PLAYERS_PARAM="MatchType,PlayerRole,PlayerPic,PlayerCountry,PlayerBornPlace,PlayerBattingStyle," +
            "PlayerBowlingStyle,MatchType,MatchNo,MatchDateTime,SeriesName,TeamGUID,PlayerBattingStats," +
            "PlayerBowlingStats,IsPlaying,PointsData,PlayerSalary,TeamNameShort,TotalPointCredits,SeriesGUID,PlayerID,TotalPoints";

    String USER_TEAM_PARAM = "UserTeamGUID,UserTeamName,PointsData,UserTeamPlayers,UserTeamID,PointCredits,PlayerBattingStyle,PlayerBowlingStyle";

    String USER_TEAM_JOINED_PARAM = "UserTeamGUID,PointsData,UserTeamName,UserTeamPlayers,UserTeamID,PointCredits,IsTeamJoined,PlayerBattingStyle,PlayerBowlingStyle";

    String PLAYER_FANTASY_STATS = "PlayerBattingStats,PlayerRole,PlayerFieldingStats,PlayerBowlingStats,MatchNo,MatchLocation,MatchStartDateTime,TeamNameShortLocal,TeamNameShortVisitor,TotalPoints,TotalTeams,PlayerSelectedPercent";

   /* String JOINEDCONTEST_PARAM = "TotalJoined,ContestType,TotalPoints,UserRank,CustomizeWinning,UserInvitationCode," +
            "Privacy,IsPaid,WinningAmount,ContestSize,EntryFee,NoOfWinners,EntryType,SeriesName,MatchNo," +
            "MatchStartDateTime,TeamNameLocal,TeamNameVisitor,TeamFlagLocal," +
            "TeamFlagVisitor,MatchLocation,MatchGUID,JoinedCount,UserTotalJoinedInMatch," +
            "TeamNameShortVisitor,UserWinningAmount,TeamNameShortLocal,MatchStartDateTime," +
            "CurrentDateTime,MatchDate,MatchTime,Status,ContestType,UserTeamName,CashBonusContribution,MyTotalJoinedContest";*/

    String JOINEDCONTEST_PARAM ="WinningType,MatchTypeByApi,IsPlayingXINotificationSent,SmartPoolWinning,MatchType,UnfilledWinningPercent,SmartPool,TotalJoined,CustomizeWinning,UserInvitationCode,Privacy,IsPaid,WinningAmount,ContestSize,EntryFee,NoOfWinners,EntryType,SeriesName,MatchNo,MatchStartDateTime,TeamNameLocal,TeamNameVisitor,TeamNameShortLocal,TeamNameShortVisitor,TeamFlagLocal,TeamFlagVisitor,MatchLocation,MatchGUID,JoinedCount,UserTotalJoinedInMatch,CurrentDateTime,MatchDate,MatchTime,Status,ContestType,CashBonusContribution,MyTotalJoinedContest,UserWinningAmount,ContestID";

    String JOINEDCONTESTS_PARAM ="WinningType,WinUpTo,WinningRatio,UnfilledWinningPercent,SmartPool,TotalJoined,IsJoined,CustomizeWinning,UserInvitationCode,Privacy,IsPaid,WinningAmount,ContestSize,EntryFee,NoOfWinners,EntryType,SeriesName,MatchNo,MatchStartDateTime,TeamNameLocal,TeamNameVisitor,TeamNameShortLocal,TeamNameShortVisitor,TeamFlagLocal,TeamFlagVisitor,MatchLocation,MatchGUID,JoinedCount,UserTotalJoinedInMatch,CurrentDateTime,MatchDate,MatchTime,Status,ContestType,CashBonusContribution,MyTotalJoinedContest,UserWinningAmount,ContestID";

    String PLAYER_STATE_PARAMS="TopPlayer,PlayerRole,PlayerPic,PlayerCountry,PlayerBornPlace,PlayerBattingStyle," +
            "PlayerBowlingStyle,MatchType,MatchNo,MatchDateTime,SeriesName,TeamGUID,PlayerBattingStats," +
            "PlayerBowlingStats,IsPlaying,PointsData,PlayerSalary,TeamNameShort,PlayerID,MyTeamPlayer," +
            "PlayerSelectedPercent,TotalPoints";

    String RANKING_PARAMS="TotalPoints,Username,ProfilePic";

    String GET_FAVORITE_TEAM = "CountryTeamName,CountryFlag,IsUserFavourite";

    String Male="Male";
    String Female="Female";
    String Other="Other";

    String Pending = "Pending";
    String Running = "Running";
    String Cancelled = "Cancelled";
    String Completed = "Completed";
    String Abandoned = "Abandoned";
    String Result = "Result";

    //Mobile email status
    String Verified = "Verified";
    String NotSubmited = "Not Submitted";
    String Rejected = "Rejected";


    String ContestFormat="League";
    String ContestType="Normal";

    String DESC="DESC";
    String ASC="ASC";




    public static final int LETS_PLAY = 401;


    /*NC*/

}
