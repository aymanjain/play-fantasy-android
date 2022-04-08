package com.mw.eleven11.beanOutput;

public class CreateContestInput {
    String userLoginSessionKey;
    String userId;
    String contestName;
    String totalWinningAmount;
    String contestSizes;
    String teamEntryFee;
    String isMultientry;
    String teamId;
    String matchId;
    int selectedPerson;

    public String getUserLoginSessionKey() {
        return userLoginSessionKey;
    }

    public void setUserLoginSessionKey(String userLoginSessionKey) {
        this.userLoginSessionKey = userLoginSessionKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getTotalWinningAmount() {
        return totalWinningAmount;
    }

    public void setTotalWinningAmount(String totalWinningAmount) {
        this.totalWinningAmount = totalWinningAmount;
    }

    public String getContestSizes() {
        return contestSizes;
    }

    public void setContestSizes(String contestSizes) {
        this.contestSizes = contestSizes;
    }

    public String getTeamEntryFee() {
        return teamEntryFee;
    }

    public void setTeamEntryFee(String teamEntryFee) {
        this.teamEntryFee = teamEntryFee;
    }

    public String getIsMultientry() {
        return isMultientry;
    }

    public void setIsMultientry(String isMultientry) {
        this.isMultientry = isMultientry;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public int getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(int selectedPerson) {
        this.selectedPerson = selectedPerson;
    }
}
