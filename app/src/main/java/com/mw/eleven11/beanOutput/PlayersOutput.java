package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;
import com.mw.eleven11.utility.Constant;

import java.io.Serializable;
import java.util.List;

public class PlayersOutput implements Serializable {




    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("Message")
    private String Message;
    @SerializedName("Data")
    private DataBean Data;

    public int getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(int ResponseCode) {
        this.ResponseCode = ResponseCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean implements Serializable{


        @SerializedName("TotalRecords")
        private int TotalRecords;
        @SerializedName("Playing11Announce")
        private String Playing11Announce;
        @SerializedName("Records")
        private List<RecordsBean> Records;

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int TotalRecords) {
            this.TotalRecords = TotalRecords;
        }

        public List<RecordsBean> getRecords() {
            return Records;
        }

        public void setRecords(List<RecordsBean> Records) {
            this.Records = Records;
        }

        public String getPlaying11Announce() {
            return Playing11Announce;
        }

        public void setPlaying11Announce(String playing11Announce) {
            Playing11Announce = playing11Announce;
        }

        public static class RecordsBean implements Comparable<RecordsBean>, Serializable {




            @SerializedName("PlayerSelectedPercent")
            private String  PlayerSelectedPercent;

            public String getPlayerSelectedPercent() {
                return PlayerSelectedPercent;
            }

            public void setPlayerSelectedPercent(String playerSelectedPercent) {
                PlayerSelectedPercent = playerSelectedPercent;
            }

            @SerializedName("TotalPoints")
            private String TotalPoints;

            public String getTotalPoints() {
                return TotalPoints;
            }

            public void setTotalPoints(String totalPoints) {
                TotalPoints = totalPoints;
            }

            @SerializedName("PointCredits")
            private double PointCredits;

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
            private PlayerBattingStatsBean PlayerBattingStats;
            @SerializedName("PlayerBowlingStats")
            private PlayerBowlingStatsBean PlayerBowlingStats;
            @SerializedName("IsPlaying")
            private String IsPlaying;
            @SerializedName("PlayerSalary")
            private String PlayerSalary;
            @SerializedName("TeamNameShort")
            private String TeamNameShort;

            @SerializedName("SeriesGUID")
            private String SeriesGUID;


            @SerializedName("IsPlayedLastMatch")
            private String IsPlayedLastMatch;



            @SerializedName("PlayerID")
            private String PlayerID;

            public String getPlayerID() {
                return PlayerID;
            }

            public void setPlayerID(String playerID) {
                PlayerID = playerID;
            }

            public String getSeriesGUID() {
                return SeriesGUID;
            }

            public void setSeriesGUID(String seriesGUID) {
                SeriesGUID = seriesGUID;
            }

            @SerializedName("TotalPointCredits")
            private String TotalPointCredits;


            @SerializedName("PlayerSelectedCaptain")
            private String PlayerSelectedCaptain;

            @SerializedName("PlayerSelectedViceCaptain")
            private String PlayerSelectedViceCaptain;


            public String getPlayerSelectedCaptain() {
                return PlayerSelectedCaptain;
            }

            public void setPlayerSelectedCaptain(String playerSelectedCaptain) {
                PlayerSelectedCaptain = playerSelectedCaptain;
            }

            public String getPlayerSelectedViceCaptain() {
                return PlayerSelectedViceCaptain;
            }

            public void setPlayerSelectedViceCaptain(String playerSelectedViceCaptain) {
                PlayerSelectedViceCaptain = playerSelectedViceCaptain;
            }

            public String getTotalPointCredits() {
                return TotalPointCredits;
            }

            public void setTotalPointCredits(String totalPointCredits) {
                TotalPointCredits = totalPointCredits;
            }

            public String getIsPlayedLastMatch() {
                return IsPlayedLastMatch;
            }

            public void setIsPlayedLastMatch(String isPlayedLastMatch) {
                IsPlayedLastMatch = isPlayedLastMatch;
            }

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

            @SerializedName("TopPlayer")
            private String TopPlayer;

            @SerializedName("PointsData")
            private List<PointsDataBean> PointsData;

            public String getPlayerSalary() {
                return PlayerSalary;
            }

            public void setPlayerSalary(String playerSalary) {
                PlayerSalary = playerSalary;
            }

            public List<PointsDataBean> getPointsData() {
                return PointsData;
            }

            public void setPointsData(List<PointsDataBean> pointsData) {
                PointsData = pointsData;
            }

            public String getMyPlayer() {
                return MyPlayer;
            }

            public void setMyPlayer(String myPlayer) {
                MyPlayer = myPlayer;
            }

            public String getTopPlayer() {
                return TopPlayer;
            }

            public void setTopPlayer(String topPlayer) {
                TopPlayer = topPlayer;
            }

            public double getPointCredits() {
                return PointCredits;
            }

            public void setPointCredits(double pointCredits) {
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

            public PlayerBattingStatsBean getPlayerBattingStats() {
                return PlayerBattingStats;
            }

            public void setPlayerBattingStats(PlayerBattingStatsBean PlayerBattingStats) {
                this.PlayerBattingStats = PlayerBattingStats;
            }

            public PlayerBowlingStatsBean getPlayerBowlingStats() {
                return PlayerBowlingStats;
            }

            public void setPlayerBowlingStats(PlayerBowlingStatsBean PlayerBowlingStats) {
                this.PlayerBowlingStats = PlayerBowlingStats;
            }

            public String getIsPlaying() {
                return IsPlaying;
            }

            public void setIsPlaying(String IsPlaying) {
                this.IsPlaying = IsPlaying;
            }

           /* public PlayerSalaryBean getPlayerSalary() {
                return PlayerSalary;
            }

            public void setPlayerSalary(PlayerSalaryBean PlayerSalary) {
                this.PlayerSalary = PlayerSalary;
            }*/

            public String getTeamNameShort() {
                return TeamNameShort;
            }

            public void setTeamNameShort(String TeamNameShort) {
                this.TeamNameShort = TeamNameShort;
            }


            @Override
            public int compareTo(RecordsBean o) {
                return 0;
            }

            public int compareByName(RecordsBean o1, RecordsBean o2)
            {
                return o1.getPlayerName().compareTo(o2.getPlayerName());
            }

            public double compareByPoints(RecordsBean o1, RecordsBean o2)
            {
                return o1.getPointCredits()- o2.getPointCredits();
            }


            public static class PlayerBattingStatsBean implements Serializable {
            }

            public static class PlayerBowlingStatsBean implements Serializable{
            }

            public static class PlayerSalaryBean implements Serializable{
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

            public static class PointsDataBean implements Serializable{
                /**
                 * PointsTypeGUID : StatringXI
                 * DefinedPoints : 2.0
                 * ScoreValue : 1
                 * CalculatedPoints : 2.0
                 */

                @SerializedName("PointsTypeGUID")
                private String PointsTypeGUID;
                @SerializedName("DefinedPoints")
                private String DefinedPoints;
                @SerializedName("ScoreValue")
                private Double ScoreValue;
                @SerializedName("CalculatedPoints")
                private String CalculatedPoints;

                public String getPointsTypeGUID() {
                    return PointsTypeGUID;
                }

                public void setPointsTypeGUID(String PointsTypeGUID) {
                    this.PointsTypeGUID = PointsTypeGUID;
                }

                public String getDefinedPoints() {
                    return DefinedPoints;
                }

                public void setDefinedPoints(String DefinedPoints) {
                    this.DefinedPoints = DefinedPoints;
                }

                public Double getScoreValue() {
                    return ScoreValue;
                }

                public void setScoreValue(Double ScoreValue) {
                    this.ScoreValue = ScoreValue;
                }

                public String getCalculatedPoints() {
                    return CalculatedPoints;
                }

                public void setCalculatedPoints(String CalculatedPoints) {
                    this.CalculatedPoints = CalculatedPoints;
                }

            }


        }
    }
}