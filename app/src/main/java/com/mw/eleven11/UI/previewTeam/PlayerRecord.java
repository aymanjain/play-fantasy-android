package com.mw.eleven11.UI.previewTeam;

import com.google.gson.annotations.SerializedName;
import com.mw.eleven11.beanOutput.DreamTeamOutput;
import com.mw.eleven11.beanOutput.PlayersOutput;
import com.mw.eleven11.utility.Constant;

import java.util.List;

public class PlayerRecord {

    /**
     * PlayerGUID : 4b3fc234-b3cd-f450-ab43-d38adaaab499
     * PlayerName : Aaron Summers
     * PlayerRole : Bowler
     * PlayerPic : http://mwdemoserver.com/515-/api/uploads/PlayerPic/player.png
     * PlayerCountry :
     * PlayerBattingStyle : Right-Hand Bat
     * PlayerBowlingStyle :
     * TeamGUID : afda58d7-c522-110d-64c9-b89353082a7d
     * PlayerBattingStats : {}
     * PlayerBowlingStats : {}
     * IsPlaying : No
     * PointsData : []
     * PlayerSalary : {"T20Credits":0,"T20iCredits":0,"ODICredits":0,"TestCredits":0}
     * TeamNameShort : HBH
     */


    @SerializedName("PointCredits")
    private String PointCredits;

    @SerializedName("localTeamName")
    private String localTeamName;

    @SerializedName("TopPlayer")
    private String TopPlayer;

    public String getLocalTeamName() {
        return localTeamName;
    }

    public void setLocalTeamName(String localTeamName) {
        this.localTeamName = localTeamName;
    }

    @SerializedName("PlayerGUID")
    private String PlayerGUID;
    @SerializedName("PlayerName")
    private String PlayerName;
    @SerializedName("PlayerRole")
    private String PlayerRole;
    @SerializedName("PlayerPic")
    private String PlayerPic;
    @SerializedName("PlayerCountry")
    private String PlayerCountry;
    @SerializedName("PlayerBattingStyle")
    private String PlayerBattingStyle;
    @SerializedName("PlayerBowlingStyle")
    private String PlayerBowlingStyle;
    @SerializedName("TeamGUID")
    private String TeamGUID;
    @SerializedName("PlayerBattingStats")
    private PlayersOutput.DataBean.RecordsBean.PlayerBattingStatsBean PlayerBattingStats;
    @SerializedName("PlayerBowlingStats")
    private PlayersOutput.DataBean.RecordsBean.PlayerBowlingStatsBean PlayerBowlingStats;
    @SerializedName("IsPlaying")
    private String IsPlaying;

    public String getTotalPoints() {
        return TotalPoints;
    }

    public void setTotalPoints(String totalPoints) {
        TotalPoints = totalPoints;
    }

    @SerializedName("TotalPoints")
    private String TotalPoints;

    @SerializedName("Points")
    private String Points;

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        Points = points;
    }

    @SerializedName("PlayerSalary")
    private String PlayerSalary;

    @SerializedName("TeamNameShort")
    private String TeamNameShort;
    @SerializedName("PointsData")
    private List<DreamTeamOutput.DataBean.RecordsBean.PointsDataBean> PointsData;

    public String getSeriesGUID() {
        return SeriesGUID;
    }

    public void setSeriesGUID(String seriesGUID) {
        SeriesGUID = seriesGUID;
    }

    public String getTotalPointCredits() {
        return TotalPointCredits;
    }

    public void setTotalPointCredits(String totalPointCredits) {
        TotalPointCredits = totalPointCredits;
    }

    @SerializedName("SeriesGUID")
    private String SeriesGUID;

    @SerializedName("TotalPointCredits")
    private String TotalPointCredits;

    @SerializedName("is_captain")
    private int isCaptain;
    @SerializedName("is_vice_captain")
    private int isViceCaptain;

    @SerializedName("view_type")
    private int viewType = 0;


    @SerializedName("is_selected")
    private boolean isSelected = false;
    @SerializedName("position")




    private String position = Constant.POSITION_PLAYER;

    @SerializedName("MyPlayer")
    private String MyPlayer;

    public String getMyPlayer() {
        return MyPlayer;
    }

    public void setMyPlayer(String myPlayer) {
        MyPlayer = myPlayer;
    }


    public String getPointCredits() {
        return PointCredits;
    }
    @SerializedName("PlayerSelectedPercent")
    private String  PlayerSelectedPercent;

    public String getPlayerSelectedPercent() {
        return PlayerSelectedPercent;
    }

    public void setPlayerSelectedPercent(String playerSelectedPercent) {
        PlayerSelectedPercent = playerSelectedPercent;
    }


    public void setPointCredits(String pointCredits) {
        PointCredits = pointCredits;
    }

    public int getIsCaptain() {
        return isCaptain;
    }

    public void setIsCaptain(int isCaptain) {
        this.isCaptain = isCaptain;
    }

    public int getIsViceCaptain() {
        return isViceCaptain;
    }

    public void setIsViceCaptain(int isViceCaptain) {
        this.isViceCaptain = isViceCaptain;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPlayerGUID() {
        return PlayerGUID;
    }

    public void setPlayerGUID(String PlayerGUID) {
        this.PlayerGUID = PlayerGUID;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String PlayerName) {
        this.PlayerName = PlayerName;
    }

    public String getPlayerRole() {
        return PlayerRole;
    }

    public void setPlayerRole(String PlayerRole) {
        this.PlayerRole = PlayerRole;
    }

    public String getTopPlayer() {
        return TopPlayer;
    }

    public void setTopPlayer(String TopPlayer) {
        this.TopPlayer = TopPlayer;
    }


    public String getPlayerPic() {
        return PlayerPic;
    }

    public void setPlayerPic(String PlayerPic) {
        this.PlayerPic = PlayerPic;
    }

    public String getPlayerCountry() {
        return PlayerCountry;
    }

    public void setPlayerCountry(String PlayerCountry) {
        this.PlayerCountry = PlayerCountry;
    }

    public String getPlayerBattingStyle() {
        return PlayerBattingStyle;
    }

    public void setPlayerBattingStyle(String PlayerBattingStyle) {
        this.PlayerBattingStyle = PlayerBattingStyle;
    }

    public String getPlayerBowlingStyle() {
        return PlayerBowlingStyle;
    }

    public void setPlayerBowlingStyle(String PlayerBowlingStyle) {
        this.PlayerBowlingStyle = PlayerBowlingStyle;
    }

    public String getTeamGUID() {
        return TeamGUID;
    }

    public void setTeamGUID(String TeamGUID) {
        this.TeamGUID = TeamGUID;
    }

    public PlayersOutput.DataBean.RecordsBean.PlayerBattingStatsBean getPlayerBattingStats() {
        return PlayerBattingStats;
    }

    public void setPlayerBattingStats(PlayersOutput.DataBean.RecordsBean.PlayerBattingStatsBean PlayerBattingStats) {
        this.PlayerBattingStats = PlayerBattingStats;
    }

    public PlayersOutput.DataBean.RecordsBean.PlayerBowlingStatsBean getPlayerBowlingStats() {
        return PlayerBowlingStats;
    }

    public void setPlayerBowlingStats(PlayersOutput.DataBean.RecordsBean.PlayerBowlingStatsBean PlayerBowlingStats) {
        this.PlayerBowlingStats = PlayerBowlingStats;
    }

    public String getIsPlaying() {
        return IsPlaying;
    }

    public void setIsPlaying(String IsPlaying) {
        this.IsPlaying = IsPlaying;
    }

    public String getPlayerSalary() {
        return PlayerSalary;
    }

    public void setPlayerSalary(String PlayerSalary) {
        this.PlayerSalary = PlayerSalary;
    }

    public String getTeamNameShort() {
        return TeamNameShort;
    }

    public void setTeamNameShort(String TeamNameShort) {
        this.TeamNameShort = TeamNameShort;
    }

    public List<DreamTeamOutput.DataBean.RecordsBean.PointsDataBean> getPointsData() {
        return PointsData;
    }

    public void setPointsData(List<DreamTeamOutput.DataBean.RecordsBean.PointsDataBean> PointsData) {
        this.PointsData = PointsData;
    }

    public static class PlayerBattingStatsBean {
    }

    public static class PlayerBowlingStatsBean {
    }

    public static class PlayerSalaryBean {
        /**
         * T20Credits : 0
         * T20iCredits : 0
         * ODICredits : 0
         * TestCredits : 0
         */

        @SerializedName("T20Credits")
        private int T20Credits;
        @SerializedName("T20iCredits")
        private int T20iCredits;
        @SerializedName("ODICredits")
        private int ODICredits;
        @SerializedName("TestCredits")
        private int TestCredits;

        public int getT20Credits() {
            return T20Credits;
        }

        public void setT20Credits(int T20Credits) {
            this.T20Credits = T20Credits;
        }

        public int getT20iCredits() {
            return T20iCredits;
        }

        public void setT20iCredits(int T20iCredits) {
            this.T20iCredits = T20iCredits;
        }

        public int getODICredits() {
            return ODICredits;
        }

        public void setODICredits(int ODICredits) {
            this.ODICredits = ODICredits;
        }

        public int getTestCredits() {
            return TestCredits;
        }

        public void setTestCredits(int TestCredits) {
            this.TestCredits = TestCredits;
        }
    }
}

