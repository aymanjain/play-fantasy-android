package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class CreateContestInput {


    /**
     * ContestName : Test
     * ContestFormat : League
     * ContestType : Normal
     * Privacy : Yes
     * IsPaid : Yes
     * ShowJoinedContest : Yes
     * WinningAmount : 0
     * ContestSize : 10
     * EntryFee : 0
     * NoOfWinners : 5
     * EntryType : Single
     * MatchGUID : 43c7ca3d-81d1-760b-f006-1fcfbba689bf
     * SeriesGUID : 27dce562-df79-00c2-4a00-7d1db4eecafa
     * CustomizeWinning :
     * SessionKey : 3487b4c0-891c-bd04-2369-ee4a8990436a
     * UserGUID : 03105c00-9d88-e3e1-0689-09aa73de769a
     * CashBonusContribution : 0
     */

    @SerializedName("ContestName")
    private String ContestName;
    @SerializedName("ContestFormat")
    private String ContestFormat;
    @SerializedName("ContestType")
    private String ContestType;
    @SerializedName("Privacy")
    private String Privacy;
    @SerializedName("IsPaid")
    private String IsPaid;
    @SerializedName("MinimumUserJoined")
    private String MinimumUserJoined;
    @SerializedName("IsConfirm")
    private String IsConfirm;
    @SerializedName("ShowJoinedContest")
    private String ShowJoinedContest;

    @SerializedName("LeagueJoinDateTime")
    private String LeagueJoinDateTime;
    @SerializedName("WinningAmount")
    private String WinningAmount;
    @SerializedName("ContestSize")
    private String ContestSize;
    @SerializedName("EntryFee")
    private String EntryFee;
    @SerializedName("NoOfWinners")
    private String NoOfWinners;
    @SerializedName("EntryType")
    private String EntryType;
    @SerializedName("LeagueType")
    private String LeagueType;
    @SerializedName("MatchGUID")
    private String MatchGUID;

    @SerializedName("MatchStartDate")
    private String MatchStartDate;

    @SerializedName("RoundID")
    private String RoundID;
    @SerializedName("SeriesGUID")
    private String SeriesGUID;

    @SerializedName("SeriesID")
    private String SeriesID;
    @SerializedName("UserJoinLimit")
    private String UserJoinLimit;
    @SerializedName("CustomizeWinning")
    private String CustomizeWinning;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("UserGUID")
    private String UserGUID;

    @SerializedName("IsPrivacyNameDisplay")
    private String IsPrivacyNameDisplay;

    @SerializedName("DraftTeamPlayerLimit")
    private String DraftTeamPlayerLimit;

    @SerializedName("DraftPlayerSelectionCriteria")
    private String draftPlayerSelectionCriteria;

    public String getAdminPercent() {
        return AdminPercent;
    }

    public void setAdminPercent(String adminPercent) {
        AdminPercent = adminPercent;
    }

    @SerializedName("AdminPercent")
    private String AdminPercent;

    public String getIsPrivacyNameDisplay() {
        return IsPrivacyNameDisplay;
    }

    public void setIsPrivacyNameDisplay(String isPrivacyNameDisplay) {
        IsPrivacyNameDisplay = isPrivacyNameDisplay;
    }

    @SerializedName("CashBonusContribution")
    private int CashBonusContribution;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    @SerializedName("app")
    private String app;


    public String getMatchStartDate() {
        return MatchStartDate;
    }

    public void setMatchStartDate(String matchStartDate) {
        MatchStartDate = matchStartDate;
    }

    public String getContestName() {
        return ContestName;
    }

    public void setContestName(String ContestName) {
        this.ContestName = ContestName;
    }

    public String getContestFormat() {
        return ContestFormat;
    }

    public void setContestFormat(String ContestFormat) {
        this.ContestFormat = ContestFormat;
    }

    public String getContestType() {
        return ContestType;
    }

    public void setContestType(String ContestType) {
        this.ContestType = ContestType;
    }

    public String getPrivacy() {
        return Privacy;
    }

    public void setPrivacy(String Privacy) {
        this.Privacy = Privacy;
    }

    public String getIsPaid() {
        return IsPaid;
    }

    public void setIsPaid(String IsPaid) {
        this.IsPaid = IsPaid;
    }

    public String getShowJoinedContest() {
        return ShowJoinedContest;
    }

    public void setShowJoinedContest(String ShowJoinedContest) {
        this.ShowJoinedContest = ShowJoinedContest;
    }

    public String getWinningAmount() {
        return WinningAmount;
    }

    public void setWinningAmount(String WinningAmount) {
        this.WinningAmount = WinningAmount;
    }

    public String getContestSize() {
        return ContestSize;
    }

    public void setContestSize(String ContestSize) {
        this.ContestSize = ContestSize;
    }

    public String getEntryFee() {
        return EntryFee;
    }

    public void setEntryFee(String EntryFee) {
        this.EntryFee = EntryFee;
    }

    public String getNoOfWinners() {
        return NoOfWinners;
    }

    public void setNoOfWinners(String NoOfWinners) {
        this.NoOfWinners = NoOfWinners;
    }

    public String getEntryType() {
        return EntryType;
    }

    public void setEntryType(String EntryType) {
        this.EntryType = EntryType;
    }

    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String MatchGUID) {
        this.MatchGUID = MatchGUID;
    }

    public String getSeriesGUID() {
        return SeriesGUID;
    }

    public void setSeriesGUID(String SeriesGUID) {
        this.SeriesGUID = SeriesGUID;
    }

    public String getCustomizeWinning() {
        return CustomizeWinning;
    }

    public void setCustomizeWinning(String CustomizeWinning) {
        this.CustomizeWinning = CustomizeWinning;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getUserGUID() {
        return UserGUID;
    }

    public void setUserGUID(String UserGUID) {
        this.UserGUID = UserGUID;
    }

    public int getCashBonusContribution() {
        return CashBonusContribution;
    }

    public void setCashBonusContribution(int CashBonusContribution) {
        this.CashBonusContribution = CashBonusContribution;
    }

    public String getUserJoinLimit() {
        return UserJoinLimit;
    }

    public void setUserJoinLimit(String userJoinLimit) {
        UserJoinLimit = userJoinLimit;
    }

    public String getIsConfirm() {
        return IsConfirm;
    }

    public void setIsConfirm(String isConfirm) {
        IsConfirm = isConfirm;
    }

    public String getSeriesID() {
        return SeriesID;
    }

    public void setSeriesID(String seriesID) {
        SeriesID = seriesID;
    }

    public String getMinimumUserJoined() {
        return MinimumUserJoined;
    }

    public void setMinimumUserJoined(String minimumUserJoined) {
        MinimumUserJoined = minimumUserJoined;
    }

    public String getLeagueType() {
        return LeagueType;
    }

    public void setLeagueType(String leagueType) {
        LeagueType = leagueType;
    }

    public String getRoundID() {
        return RoundID;
    }

    public void setRoundID(String roundID) {
        RoundID = roundID;
    }

    public String getLeagueJoinDateTime() {
        return LeagueJoinDateTime;
    }

    public void setLeagueJoinDateTime(String leagueJoinDateTime) {
        LeagueJoinDateTime = leagueJoinDateTime;
    }

    public String getDraftTeamPlayerLimit() {
        return DraftTeamPlayerLimit;
    }

    public void setDraftTeamPlayerLimit(String draftTeamPlayerLimit) {
        DraftTeamPlayerLimit = draftTeamPlayerLimit;
    }

    public String getDraftPlayerSelectionCriteria() {
        return draftPlayerSelectionCriteria;
    }

    public void setDraftPlayerSelectionCriteria(String draftPlayerSelectionCriteria) {
        this.draftPlayerSelectionCriteria = draftPlayerSelectionCriteria;
    }

    public static class DraftPlayerSelectionCriteria {
        @SerializedName("WicketKeeper")
        private String WicketKeeper;
        @SerializedName("Batsman")
        private String Batsman;
        @SerializedName("Bowler")
        private String Bowler;
        @SerializedName("AllRounder")
        private String AllRounder;

        public String getWicketKeeper() {
            return WicketKeeper;
        }

        public void setWicketKeeper(String wicketKeeper) {
            WicketKeeper = wicketKeeper;
        }

        public String getBatsman() {
            return Batsman;
        }

        public void setBatsman(String batsman) {
            Batsman = batsman;
        }

        public String getBowler() {
            return Bowler;
        }

        public void setBowler(String bowler) {
            Bowler = bowler;
        }

        public String getAllRounder() {
            return AllRounder;
        }

        public void setAllRounder(String allRounder) {
            AllRounder = allRounder;
        }
    }
}