package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;
import com.mw.eleven11.utility.Constant;

import java.util.List;

public class ContestUserOutput {



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

    public static class DataBean {


        @SerializedName("TotalRecords")
        private int TotalRecords;
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

        public static class RecordsBean {


            @SerializedName("UserGUID")
            private String UserGUID;
            @SerializedName("UserTeamGUID")
            private String UserTeamGUID;
            @SerializedName("UserTeamName")
            private String UserTeamName;
            @SerializedName("TotalPoints")
            private String TotalPoints;
            @SerializedName("UserWinningAmount")
            private String UserWinningAmount;
            @SerializedName("FirstName")
            private String FirstName;
            @SerializedName("Username")
            private String Username;
            @SerializedName("UserTeamID")
            private String UserTeamID;
            @SerializedName("UserRank")
            private String UserRank;
            @SerializedName("SmartPoolWinning")
            private String SmartPoolWinning;
            @SerializedName("SmartPool")
            private String SmartPool;
            @SerializedName("ProfilePic")
            private String ProfilePic;
            @SerializedName("UserTeamPlayers")
            private List<UserTeamPlayersBean> UserTeamPlayers;

            public String getUserGUID() {
                return UserGUID;
            }

            public void setUserGUID(String UserGUID) {
                this.UserGUID = UserGUID;
            }

            public String getUserTeamGUID() {
                return UserTeamGUID;
            }

            public void setUserTeamGUID(String UserTeamGUID) {
                this.UserTeamGUID = UserTeamGUID;
            }

            public String getUserTeamName() {
                return UserTeamName;
            }

            public void setUserTeamName(String UserTeamName) {
                this.UserTeamName = UserTeamName;
            }

            public String getTotalPoints() {
                return TotalPoints;
            }

            public void setTotalPoints(String TotalPoints) {
                this.TotalPoints = TotalPoints;
            }

            public String getUserWinningAmount() {
                return UserWinningAmount;
            }

            public void setUserWinningAmount(String UserWinningAmount) {
                this.UserWinningAmount = UserWinningAmount;
            }

            public String getFirstName() {
                return FirstName;
            }

            public void setFirstName(String FirstName) {
                this.FirstName = FirstName;
            }

            public String getUsername() {
                return Username;
            }

            public void setUsername(String Username) {
                this.Username = Username;
            }

            public String getUserTeamID() {
                return UserTeamID;
            }

            public void setUserTeamID(String UserTeamID) {
                this.UserTeamID = UserTeamID;
            }

            public String getUserRank() {
                return UserRank;
            }

            public void setUserRank(String UserRank) {
                this.UserRank = UserRank;
            }

            public String getProfilePic() {
                return ProfilePic;
            }

            public void setProfilePic(String ProfilePic) {
                this.ProfilePic = ProfilePic;
            }

            public List<UserTeamPlayersBean> getUserTeamPlayers() {
                return UserTeamPlayers;
            }

            public void setUserTeamPlayers(List<UserTeamPlayersBean> UserTeamPlayers) {
                this.UserTeamPlayers = UserTeamPlayers;
            }

            public String getSmartPoolWinning() {
                return SmartPoolWinning;
            }

            public void setSmartPoolWinning(String smartPoolWinning) {
                SmartPoolWinning = smartPoolWinning;
            }

            public String getSmartPool() {
                return SmartPool;
            }

            public void setSmartPool(String smartPool) {
                SmartPool = smartPool;
            }

            public static class UserTeamPlayersBean {
                /**
                 * PlayerGUID : 0a837f6e-26eb-1e6a-5570-0e0dfdec7d78
                 * PlayerPosition : Player
                 * PlayerName : Alyssa Healy
                 * PlayerRole : WicketKeeper
                 * PlayerPic : http://mwdemoserver.com/515-/api/uploads/PlayerPic/860a6b49-e887-c502-af78-11c99f9bfc78.png
                 * TeamGUID : 8bb2967c-c4da-8582-e493-34804b95e5ae
                 * PlayerSalary : {"T20Credits":10}
                 * MatchType : T20
                 * PointCredits : 9.5
                 */

                @SerializedName("PlayerGUID")
                private String PlayerGUID;
                @SerializedName("PlayerPosition")
                private String PlayerPosition;
                @SerializedName("PlayerName")
                private String PlayerName;
                @SerializedName("PlayerRole")
                private String PlayerRole;
                @SerializedName("PlayerPic")
                private String PlayerPic;
                @SerializedName("TeamGUID")
                private String TeamGUID;
               /* @SerializedName("PlayerSalary")
                private PlayerSalaryBean PlayerSalary;*/
                @SerializedName("MatchType")
                private String MatchType;
                @SerializedName("PointCredits")
                private String PointCredits;
                @SerializedName("Points")
                private String Points;
                @SerializedName("SeriesGUID")
                private String SeriesGUID;

                public String getSeriesGUID() {
                    return SeriesGUID;
                }

                public void setSeriesGUID(String seriesGUID) {
                    SeriesGUID = seriesGUID;
                }

                public String getTotalPointCredits() {
                    return TotalPointCredits;
                }

                public String getPoints() {
                    return Points;
                }

                public void setPoints(String points) {
                    Points = points;
                }

                public void setTotalPointCredits(String totalPointCredits) {
                    TotalPointCredits = totalPointCredits;
                }

                @SerializedName("TotalPointCredits")
                private String TotalPointCredits;

                @SerializedName("PlayerBattingStyle")
                private String PlayerBattingStyle;

                @SerializedName("PlayerBowlingStyle")
                private String PlayerBowlingStyle;

                public String getPlayerCountry() {
                    return PlayerCountry;
                }

                public void setPlayerCountry(String playerCountry) {
                    PlayerCountry = playerCountry;
                }

                @SerializedName("PlayerSalary")
                private String PlayerSalary;

                @SerializedName("PlayerCountry")
                private String PlayerCountry;

                public String getPlayerSalary() {
                    return PlayerSalary;
                }

                public void setPlayerSalary(String playerSalary) {
                    PlayerSalary = playerSalary;
                }

                public String getPlayerBattingStyle() {
                    return PlayerBattingStyle;
                }

                public void setPlayerBattingStyle(String playerBattingStyle) {
                    PlayerBattingStyle = playerBattingStyle;
                }

                public String getPlayerBowlingStyle() {
                    return PlayerBowlingStyle;
                }

                public void setPlayerBowlingStyle(String playerBowlingStyle) {
                    PlayerBowlingStyle = playerBowlingStyle;
                }

                public String getPointCredits() {
                    return PointCredits;
                }

                public void setPointCredits(String pointCredits) {
                    PointCredits = pointCredits;
                }

                public String getPlayerGUID() {
                    return PlayerGUID;
                }

                public void setPlayerGUID(String PlayerGUID) {
                    this.PlayerGUID = PlayerGUID;
                }

                public String getPlayerPosition() {
                    return PlayerPosition;
                }

                public void setPlayerPosition(String PlayerPosition) {
                    this.PlayerPosition = PlayerPosition;
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

                public String getTeamGUID() {
                    return TeamGUID;
                }

                public void setTeamGUID(String TeamGUID) {
                    this.TeamGUID = TeamGUID;
                }

               /* public PlayerSalaryBean getPlayerSalary() {
                    return PlayerSalary;
                }

                public void setPlayerSalary(PlayerSalaryBean PlayerSalary) {
                    this.PlayerSalary = PlayerSalary;
                }*/

                public String getMatchType() {
                    return MatchType;
                }

                public void setMatchType(String MatchType) {
                    this.MatchType = MatchType;
                }

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


                @SerializedName("PlayerBattingStats")
                private PlayersOutput.DataBean.RecordsBean.PlayerBattingStatsBean PlayerBattingStats;
                @SerializedName("PlayerBowlingStats")
                private PlayersOutput.DataBean.RecordsBean.PlayerBowlingStatsBean PlayerBowlingStats;
                @SerializedName("IsPlaying")
                private String IsPlaying;

                @SerializedName("TeamNameShort")
                private String TeamNameShort;


                @SerializedName("PlayerID")
                private String PlayerID;

                public String getPlayerID() {
                    return PlayerID;
                }

                public void setPlayerID(String playerID) {
                    PlayerID = playerID;
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
                private List<UserPointsDataBean> PointsData;


                public List<UserPointsDataBean> getPointsData() {
                    return PointsData;
                }

                public void setPointsData(List<UserPointsDataBean> pointsData) {
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

                public static class PlayerSalaryBean {
                    /**
                     * T20Credits : 10
                     */




                }

                public static class UserPointsDataBean {
                    @SerializedName("PointsTypeGUID")
                    private String PointsTypeGUID;
                    @SerializedName("DefinedPoints")
                    private String DefinedPoints;
                    @SerializedName("ScoreValue")
                    private String ScoreValue;
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

                    public String getScoreValue() {
                        return ScoreValue;
                    }

                    public void setScoreValue(String ScoreValue) {
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
}