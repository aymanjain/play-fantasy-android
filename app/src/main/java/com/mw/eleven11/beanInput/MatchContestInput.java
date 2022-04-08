package com.mw.eleven11.beanInput;

import com.google.gson.annotations.SerializedName;

public class MatchContestInput {


    /**
     * MatchGUID : 2598e74f-2bfd-bc1d-3c72-308cd54aea04
     * SessionKey : 43780264-f7f2-dea4-b232-cb3d1ccfa426
     * Params : Privacy,IsPaid,WinningAmount,ContestSize,EntryFee,NoOfWinners,EntryType,IsJoined,Status,ContestFormat,ContestType,CustomizeWinning,TotalJoined,UserInvitationCode,TeamNameLocal,TeamNameVisitor,IsConfirm,CashBonusContribution
     * StatusID : 1
     * Privacy : No
     */

    @SerializedName("EntryStartFrom")
    private String EntryStartFrom;

    @SerializedName("EntryEndTo")
    private String EntryEndTo;

    @SerializedName("WinningStartFrom")
    private String WinningStartFrom;

    @SerializedName("WinningEndTo")
    private String WinningEndTo;

    @SerializedName("ContestType")
    private String ContestType;

    @SerializedName("ContestSizeStartFrom")
    private String ContestSizeStartFrom;

    @SerializedName("ContestSizeEndTo")
    private String ContestSizeEndTo;

    @SerializedName("MatchGUID")
    private String MatchGUID;
    @SerializedName("SessionKey")
    private String SessionKey;
    @SerializedName("Params")
    private String Params;
    @SerializedName("Status")
    private String Status;
    @SerializedName("Privacy")
    private String Privacy;
    @SerializedName("ContestList")
    private String ContestList;

    @SerializedName("PageNo")
    private int PageNo;
    @SerializedName("PageSize")
    private int PageSize;

    @SerializedName("ContainTypeFilter")
    private String ContainTypeFilter;

    public String getEntryType() {
        return EntryType;
    }

    public void setEntryType(String entryType) {
        EntryType = entryType;
    }

    @SerializedName("EntryType")
    private String EntryType;

    @SerializedName("Filter")
    private String Filter;

    @SerializedName("OrderBy")
    private String OrderBy;

    @SerializedName("Sequence")
    private String Sequence;

    public String getOrderBy() {
        return OrderBy;
    }

    public void setOrderBy(String orderBy) {
        OrderBy = orderBy;
    }

    public String getSequence() {
        return Sequence;
    }

    public void setSequence(String sequence) {
        Sequence = sequence;
    }

    public String getContestFull() {
        return ContestFull;
    }

    public void setContestFull(String contestFull) {
        ContestFull = contestFull;
    }

    @SerializedName("ContestFull")
    private String ContestFull;

    public String getFilter() {
        return Filter;
    }

    public void setFilter(String filter) {
        Filter = filter;
    }

    public String getEntryStartFrom() {
        return EntryStartFrom;
    }

    public void setEntryStartFrom(String entryStartFrom) {
        EntryStartFrom = entryStartFrom;
    }

    public String getEntryEndTo() {
        return EntryEndTo;
    }

    public void setEntryEndTo(String entryEndTo) {
        EntryEndTo = entryEndTo;
    }

    public String getWinningStartFrom() {
        return WinningStartFrom;
    }

    public void setWinningStartFrom(String winningStartFrom) {
        WinningStartFrom = winningStartFrom;
    }

    public String getWinningEndTo() {
        return WinningEndTo;
    }

    public void setWinningEndTo(String winningEndTo) {
        WinningEndTo = winningEndTo;
    }

    public String getContestType() {
        return ContestType;
    }

    public void setContestType(String contestType) {
        ContestType = contestType;
    }

    public String getContestSizeStartFrom() {
        return ContestSizeStartFrom;
    }

    public void setContestSizeStartFrom(String contestSizeStartFrom) {
        ContestSizeStartFrom = contestSizeStartFrom;
    }

    public String getContestSizeEndTo() {
        return ContestSizeEndTo;
    }

    public void setContestSizeEndTo(String contestSizeEndTo) {
        ContestSizeEndTo = contestSizeEndTo;
    }

    public String getContainTypeFilter() {
        return ContainTypeFilter;
    }

    public void setContainTypeFilter(String containTypeFilter) {
        ContainTypeFilter = containTypeFilter;
    }

    public int getPageNo() {
        return PageNo;
    }

    public void setPageNo(int pageNo) {
        PageNo = pageNo;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public String getMatchGUID() {
        return MatchGUID;
    }

    public void setMatchGUID(String MatchGUID) {
        this.MatchGUID = MatchGUID;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String SessionKey) {
        this.SessionKey = SessionKey;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String Params) {
        this.Params = Params;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getPrivacy() {
        return Privacy;
    }

    public void setPrivacy(String Privacy) {
        this.Privacy = Privacy;
    }

    public String getContestList() {
        return ContestList;
    }

    public void setContestList(String contestList) {
        ContestList = contestList;
    }
}
