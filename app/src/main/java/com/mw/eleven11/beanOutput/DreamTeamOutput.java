package com.mw.eleven11.beanOutput;

import java.util.List;

public class DreamTeamOutput {



    private int ResponseCode;
    private String Message;
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


        private String TotalPoints;
        private int TotalRecords;
        private List<RecordsBean> Records;

        public String getTotalPoints() {
            return TotalPoints;
        }

        public void setTotalPoints(String  TotalPoints) {
            this.TotalPoints = TotalPoints;
        }

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
            /**
             * PlayerGUID : c2779d46-e65e-25ab-709c-35283c217f2e
             * PlayerName : Ahsan Ali
             * PlayerRole : Batsman
             * PlayerPic : http://MyMatch11.com/api/uploads/PlayerPic/player.png
             * PlayerBattingStyle : Right-hand bat
             * PlayerBowlingStyle : Legbreak
             * MatchType : T20
             * TeamGUID : cd1d3a40-8721-4453-3fdf-90deaa776751
             * PlayerBattingStats : {"T20":{"MatchID":0,"InningID":0,"Matches":35,"Innings":35,"NotOut":1,"Runs":793,"Balls":627,"HighestScore":"85","Hundreds":0,"Fifties":4,"Fours":90,"Sixes":20,"Average":"23.32","StrikeRate":"126.47","Catches":14,"Stumpings":0},"ListA":{"MatchID":0,"InningID":0,"Matches":34,"Innings":34,"NotOut":1,"Runs":868,"Balls":937,"HighestScore":"73","Hundreds":0,"Fifties":4,"Fours":122,"Sixes":9,"Average":"26.30","StrikeRate":"92.63","Catches":6,"Stumpings":0},"FirstClass":{"MatchID":0,"InningID":0,"Matches":23,"Innings":40,"NotOut":0,"Runs":1114,"Balls":1424,"HighestScore":"224","Hundreds":3,"Fifties":1,"Fours":182,"Sixes":2,"Average":"27.85","StrikeRate":"78.23","Catches":13,"Stumpings":0}}
             * PlayerBowlingStats : {"T20":{"MatchID":0,"InningID":0,"Matches":35,"Innings":1,"Balls":6,"Overs":1,"Runs":9,"Wickets":1,"BestInning":"1/9","BestMatch":"1/9","Economy":"9.00","Average":"9.00","StrikeRate":"6.0","FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0},"ListA":{"MatchID":0,"InningID":0,"Matches":34,"Innings":2,"Balls":13,"Overs":2.1,"Runs":15,"Wickets":0,"BestInning":"","BestMatch":"","Economy":"6.92","Average":"","StrikeRate":"","FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0},"FirstClass":{"MatchID":0,"InningID":0,"Matches":23,"Innings":12,"Balls":222,"Overs":37,"Runs":199,"Wickets":1,"BestInning":"1/33","BestMatch":"1/33","Economy":"5.37","Average":"199.00","StrikeRate":"222.0","FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0}}
             * IsPlaying : Yes
             * PointsData : [{"PointsTypeGUID":"StatringXI","DefinedPoints":"2.0","ScoreValue":1,"CalculatedPoints":"2.0"},{"PointsTypeGUID":"EveryRunScored","DefinedPoints":"1.0","ScoreValue":"46","CalculatedPoints":"46"},{"PointsTypeGUID":"Four","DefinedPoints":"1.0","ScoreValue":"4","CalculatedPoints":"4"},{"PointsTypeGUID":"Six","DefinedPoints":"2.0","ScoreValue":"2","CalculatedPoints":"4"},{"PointsTypeGUID":"StrikeRate100N149.99","DefinedPoints":"5.0","ScoreValue":"143.75","CalculatedPoints":"5.0"},{"PointsTypeGUID":"For30runs","DefinedPoints":"10.0","ScoreValue":"46","CalculatedPoints":"10.0"},{"PointsTypeGUID":"Duck","DefinedPoints":"-5.0","ScoreValue":"46","CalculatedPoints":"0"},{"PointsTypeGUID":"Wicket","DefinedPoints":"20.0","ScoreValue":"0","CalculatedPoints":"0"},{"PointsTypeGUID":"Maiden","DefinedPoints":"20.0","ScoreValue":"0","CalculatedPoints":"0"},{"PointsTypeGUID":"EconomyRate0N5Balls","DefinedPoints":"15.0","ScoreValue":"0","CalculatedPoints":"0"},{"PointsTypeGUID":"ThreeWickets","DefinedPoints":"10.0","ScoreValue":"0","CalculatedPoints":"0"},{"PointsTypeGUID":"RunOUT","DefinedPoints":"10.0","ScoreValue":"0","CalculatedPoints":"0"},{"PointsTypeGUID":"Stumping","DefinedPoints":"15.0","ScoreValue":"0","CalculatedPoints":"0"},{"PointsTypeGUID":"Catch","DefinedPoints":"10.0","ScoreValue":"0","CalculatedPoints":"0"}]
             * PlayerSalary : 0.00
             * TeamNameShort : QG
             * TotalPoints : 71.00
             * Points : 71.00
             * PointCredits : 71.00
             * TopPlayer : No
             * PlayerPosition : Captain
             */

            private String PlayerGUID;
            private String PlayerName;
            private String PlayerRole;
            private String PlayerPic;
            private String PlayerBattingStyle;
            private String PlayerBowlingStyle;
            private String MatchType;
            private String TeamGUID;
            private PlayerBattingStatsBean PlayerBattingStats;
            private PlayerBowlingStatsBean PlayerBowlingStats;
            private String IsPlaying;
            private String PlayerSalary;
            private String TeamNameShort;
            private String TotalPoints;
            private String Points;
            private String PointCredits;
            private String TotalPointCredits;

            private String  PlayerSelectedPercent;

            public String getPlayerSelectedPercent() {
                return PlayerSelectedPercent;
            }

            public void setPlayerSelectedPercent(String playerSelectedPercent) {
                PlayerSelectedPercent = playerSelectedPercent;
            }

            private String MyPlayer;

            public String getMyPlayer() {
                return MyPlayer;
            }

            public void setMyPlayer(String myPlayer) {
                MyPlayer = myPlayer;
            }



            public String getTotalPointCredits() {
                return TotalPointCredits;
            }

            public void setTotalPointCredits(String totalPointCredits) {
                TotalPointCredits = totalPointCredits;
            }

            public String getPlayerCountry() {
                return PlayerCountry;
            }

            public void setPlayerCountry(String playerCountry) {
                PlayerCountry = playerCountry;
            }

            private String TopPlayer;
            private String PlayerPosition;
            private String PlayerCountry;
            private List<PointsDataBean> PointsData;

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

            public String getMatchType() {
                return MatchType;
            }

            public void setMatchType(String MatchType) {
                this.MatchType = MatchType;
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

            public String getTotalPoints() {
                return TotalPoints;
            }

            public void setTotalPoints(String TotalPoints) {
                this.TotalPoints = TotalPoints;
            }

            public String getPoints() {
                return Points;
            }

            public void setPoints(String Points) {
                this.Points = Points;
            }

            public String getPointCredits() {
                return PointCredits;
            }

            public void setPointCredits(String PointCredits) {
                this.PointCredits = PointCredits;
            }

            public String getTopPlayer() {
                return TopPlayer;
            }

            public void setTopPlayer(String TopPlayer) {
                this.TopPlayer = TopPlayer;
            }

            public String getPlayerPosition() {
                return PlayerPosition;
            }

            public void setPlayerPosition(String PlayerPosition) {
                this.PlayerPosition = PlayerPosition;
            }

            public List<PointsDataBean> getPointsData() {
                return PointsData;
            }

            public void setPointsData(List<PointsDataBean> PointsData) {
                this.PointsData = PointsData;
            }

            public static class PlayerBattingStatsBean {
                /**
                 * T20 : {"MatchID":0,"InningID":0,"Matches":35,"Innings":35,"NotOut":1,"Runs":793,"Balls":627,"HighestScore":"85","Hundreds":0,"Fifties":4,"Fours":90,"Sixes":20,"Average":"23.32","StrikeRate":"126.47","Catches":14,"Stumpings":0}
                 * ListA : {"MatchID":0,"InningID":0,"Matches":34,"Innings":34,"NotOut":1,"Runs":868,"Balls":937,"HighestScore":"73","Hundreds":0,"Fifties":4,"Fours":122,"Sixes":9,"Average":"26.30","StrikeRate":"92.63","Catches":6,"Stumpings":0}
                 * FirstClass : {"MatchID":0,"InningID":0,"Matches":23,"Innings":40,"NotOut":0,"Runs":1114,"Balls":1424,"HighestScore":"224","Hundreds":3,"Fifties":1,"Fours":182,"Sixes":2,"Average":"27.85","StrikeRate":"78.23","Catches":13,"Stumpings":0}
                 */

                private T20Bean T20;
                private ListABean ListA;
                private FirstClassBean FirstClass;

                public T20Bean getT20() {
                    return T20;
                }

                public void setT20(T20Bean T20) {
                    this.T20 = T20;
                }

                public ListABean getListA() {
                    return ListA;
                }

                public void setListA(ListABean ListA) {
                    this.ListA = ListA;
                }

                public FirstClassBean getFirstClass() {
                    return FirstClass;
                }

                public void setFirstClass(FirstClassBean FirstClass) {
                    this.FirstClass = FirstClass;
                }

                public static class T20Bean {
                    /**
                     * MatchID : 0
                     * InningID : 0
                     * Matches : 35
                     * Innings : 35
                     * NotOut : 1
                     * Runs : 793
                     * Balls : 627
                     * HighestScore : 85
                     * Hundreds : 0
                     * Fifties : 4
                     * Fours : 90
                     * Sixes : 20
                     * Average : 23.32
                     * StrikeRate : 126.47
                     * Catches : 14
                     * Stumpings : 0
                     */

                    private int MatchID;
                    private int InningID;
                    private int Matches;
                    private int Innings;
                    private int NotOut;
                    private int Runs;
                    private int Balls;
                    private String HighestScore;
                    private int Hundreds;
                    private int Fifties;
                    private int Fours;
                    private int Sixes;
                    private String Average;
                    private String StrikeRate;
                    private int Catches;
                    private int Stumpings;

                    public int getMatchID() {
                        return MatchID;
                    }

                    public void setMatchID(int MatchID) {
                        this.MatchID = MatchID;
                    }

                    public int getInningID() {
                        return InningID;
                    }

                    public void setInningID(int InningID) {
                        this.InningID = InningID;
                    }

                    public int getMatches() {
                        return Matches;
                    }

                    public void setMatches(int Matches) {
                        this.Matches = Matches;
                    }

                    public int getInnings() {
                        return Innings;
                    }

                    public void setInnings(int Innings) {
                        this.Innings = Innings;
                    }

                    public int getNotOut() {
                        return NotOut;
                    }

                    public void setNotOut(int NotOut) {
                        this.NotOut = NotOut;
                    }

                    public int getRuns() {
                        return Runs;
                    }

                    public void setRuns(int Runs) {
                        this.Runs = Runs;
                    }

                    public int getBalls() {
                        return Balls;
                    }

                    public void setBalls(int Balls) {
                        this.Balls = Balls;
                    }

                    public String getHighestScore() {
                        return HighestScore;
                    }

                    public void setHighestScore(String HighestScore) {
                        this.HighestScore = HighestScore;
                    }

                    public int getHundreds() {
                        return Hundreds;
                    }

                    public void setHundreds(int Hundreds) {
                        this.Hundreds = Hundreds;
                    }

                    public int getFifties() {
                        return Fifties;
                    }

                    public void setFifties(int Fifties) {
                        this.Fifties = Fifties;
                    }

                    public int getFours() {
                        return Fours;
                    }

                    public void setFours(int Fours) {
                        this.Fours = Fours;
                    }

                    public int getSixes() {
                        return Sixes;
                    }

                    public void setSixes(int Sixes) {
                        this.Sixes = Sixes;
                    }

                    public String getAverage() {
                        return Average;
                    }

                    public void setAverage(String Average) {
                        this.Average = Average;
                    }

                    public String getStrikeRate() {
                        return StrikeRate;
                    }

                    public void setStrikeRate(String StrikeRate) {
                        this.StrikeRate = StrikeRate;
                    }

                    public int getCatches() {
                        return Catches;
                    }

                    public void setCatches(int Catches) {
                        this.Catches = Catches;
                    }

                    public int getStumpings() {
                        return Stumpings;
                    }

                    public void setStumpings(int Stumpings) {
                        this.Stumpings = Stumpings;
                    }
                }

                public static class ListABean {
                    /**
                     * MatchID : 0
                     * InningID : 0
                     * Matches : 34
                     * Innings : 34
                     * NotOut : 1
                     * Runs : 868
                     * Balls : 937
                     * HighestScore : 73
                     * Hundreds : 0
                     * Fifties : 4
                     * Fours : 122
                     * Sixes : 9
                     * Average : 26.30
                     * StrikeRate : 92.63
                     * Catches : 6
                     * Stumpings : 0
                     */

                    private int MatchID;
                    private int InningID;
                    private int Matches;
                    private int Innings;
                    private int NotOut;
                    private int Runs;
                    private int Balls;
                    private String HighestScore;
                    private int Hundreds;
                    private int Fifties;
                    private int Fours;
                    private int Sixes;
                    private String Average;
                    private String StrikeRate;
                    private int Catches;
                    private int Stumpings;

                    public int getMatchID() {
                        return MatchID;
                    }

                    public void setMatchID(int MatchID) {
                        this.MatchID = MatchID;
                    }

                    public int getInningID() {
                        return InningID;
                    }

                    public void setInningID(int InningID) {
                        this.InningID = InningID;
                    }

                    public int getMatches() {
                        return Matches;
                    }

                    public void setMatches(int Matches) {
                        this.Matches = Matches;
                    }

                    public int getInnings() {
                        return Innings;
                    }

                    public void setInnings(int Innings) {
                        this.Innings = Innings;
                    }

                    public int getNotOut() {
                        return NotOut;
                    }

                    public void setNotOut(int NotOut) {
                        this.NotOut = NotOut;
                    }

                    public int getRuns() {
                        return Runs;
                    }

                    public void setRuns(int Runs) {
                        this.Runs = Runs;
                    }

                    public int getBalls() {
                        return Balls;
                    }

                    public void setBalls(int Balls) {
                        this.Balls = Balls;
                    }

                    public String getHighestScore() {
                        return HighestScore;
                    }

                    public void setHighestScore(String HighestScore) {
                        this.HighestScore = HighestScore;
                    }

                    public int getHundreds() {
                        return Hundreds;
                    }

                    public void setHundreds(int Hundreds) {
                        this.Hundreds = Hundreds;
                    }

                    public int getFifties() {
                        return Fifties;
                    }

                    public void setFifties(int Fifties) {
                        this.Fifties = Fifties;
                    }

                    public int getFours() {
                        return Fours;
                    }

                    public void setFours(int Fours) {
                        this.Fours = Fours;
                    }

                    public int getSixes() {
                        return Sixes;
                    }

                    public void setSixes(int Sixes) {
                        this.Sixes = Sixes;
                    }

                    public String getAverage() {
                        return Average;
                    }

                    public void setAverage(String Average) {
                        this.Average = Average;
                    }

                    public String getStrikeRate() {
                        return StrikeRate;
                    }

                    public void setStrikeRate(String StrikeRate) {
                        this.StrikeRate = StrikeRate;
                    }

                    public int getCatches() {
                        return Catches;
                    }

                    public void setCatches(int Catches) {
                        this.Catches = Catches;
                    }

                    public int getStumpings() {
                        return Stumpings;
                    }

                    public void setStumpings(int Stumpings) {
                        this.Stumpings = Stumpings;
                    }
                }

                public static class FirstClassBean {
                    /**
                     * MatchID : 0
                     * InningID : 0
                     * Matches : 23
                     * Innings : 40
                     * NotOut : 0
                     * Runs : 1114
                     * Balls : 1424
                     * HighestScore : 224
                     * Hundreds : 3
                     * Fifties : 1
                     * Fours : 182
                     * Sixes : 2
                     * Average : 27.85
                     * StrikeRate : 78.23
                     * Catches : 13
                     * Stumpings : 0
                     */

                    private int MatchID;
                    private int InningID;
                    private int Matches;
                    private int Innings;
                    private int NotOut;
                    private int Runs;
                    private int Balls;
                    private String HighestScore;
                    private int Hundreds;
                    private int Fifties;
                    private int Fours;
                    private int Sixes;
                    private String Average;
                    private String StrikeRate;
                    private int Catches;
                    private int Stumpings;

                    public int getMatchID() {
                        return MatchID;
                    }

                    public void setMatchID(int MatchID) {
                        this.MatchID = MatchID;
                    }

                    public int getInningID() {
                        return InningID;
                    }

                    public void setInningID(int InningID) {
                        this.InningID = InningID;
                    }

                    public int getMatches() {
                        return Matches;
                    }

                    public void setMatches(int Matches) {
                        this.Matches = Matches;
                    }

                    public int getInnings() {
                        return Innings;
                    }

                    public void setInnings(int Innings) {
                        this.Innings = Innings;
                    }

                    public int getNotOut() {
                        return NotOut;
                    }

                    public void setNotOut(int NotOut) {
                        this.NotOut = NotOut;
                    }

                    public int getRuns() {
                        return Runs;
                    }

                    public void setRuns(int Runs) {
                        this.Runs = Runs;
                    }

                    public int getBalls() {
                        return Balls;
                    }

                    public void setBalls(int Balls) {
                        this.Balls = Balls;
                    }

                    public String getHighestScore() {
                        return HighestScore;
                    }

                    public void setHighestScore(String HighestScore) {
                        this.HighestScore = HighestScore;
                    }

                    public int getHundreds() {
                        return Hundreds;
                    }

                    public void setHundreds(int Hundreds) {
                        this.Hundreds = Hundreds;
                    }

                    public int getFifties() {
                        return Fifties;
                    }

                    public void setFifties(int Fifties) {
                        this.Fifties = Fifties;
                    }

                    public int getFours() {
                        return Fours;
                    }

                    public void setFours(int Fours) {
                        this.Fours = Fours;
                    }

                    public int getSixes() {
                        return Sixes;
                    }

                    public void setSixes(int Sixes) {
                        this.Sixes = Sixes;
                    }

                    public String getAverage() {
                        return Average;
                    }

                    public void setAverage(String Average) {
                        this.Average = Average;
                    }

                    public String getStrikeRate() {
                        return StrikeRate;
                    }

                    public void setStrikeRate(String StrikeRate) {
                        this.StrikeRate = StrikeRate;
                    }

                    public int getCatches() {
                        return Catches;
                    }

                    public void setCatches(int Catches) {
                        this.Catches = Catches;
                    }

                    public int getStumpings() {
                        return Stumpings;
                    }

                    public void setStumpings(int Stumpings) {
                        this.Stumpings = Stumpings;
                    }
                }
            }

            public static class PlayerBowlingStatsBean {
                /**
                 * T20 : {"MatchID":0,"InningID":0,"Matches":35,"Innings":1,"Balls":6,"Overs":1,"Runs":9,"Wickets":1,"BestInning":"1/9","BestMatch":"1/9","Economy":"9.00","Average":"9.00","StrikeRate":"6.0","FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0}
                 * ListA : {"MatchID":0,"InningID":0,"Matches":34,"Innings":2,"Balls":13,"Overs":2.1,"Runs":15,"Wickets":0,"BestInning":"","BestMatch":"","Economy":"6.92","Average":"","StrikeRate":"","FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0}
                 * FirstClass : {"MatchID":0,"InningID":0,"Matches":23,"Innings":12,"Balls":222,"Overs":37,"Runs":199,"Wickets":1,"BestInning":"1/33","BestMatch":"1/33","Economy":"5.37","Average":"199.00","StrikeRate":"222.0","FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0}
                 */

                private T20BeanX T20;
                private ListABeanX ListA;
                private FirstClassBeanX FirstClass;

                public T20BeanX getT20() {
                    return T20;
                }

                public void setT20(T20BeanX T20) {
                    this.T20 = T20;
                }

                public ListABeanX getListA() {
                    return ListA;
                }

                public void setListA(ListABeanX ListA) {
                    this.ListA = ListA;
                }

                public FirstClassBeanX getFirstClass() {
                    return FirstClass;
                }

                public void setFirstClass(FirstClassBeanX FirstClass) {
                    this.FirstClass = FirstClass;
                }

                public static class T20BeanX {
                    /**
                     * MatchID : 0
                     * InningID : 0
                     * Matches : 35
                     * Innings : 1
                     * Balls : 6
                     * Overs : 1
                     * Runs : 9
                     * Wickets : 1
                     * BestInning : 1/9
                     * BestMatch : 1/9
                     * Economy : 9.00
                     * Average : 9.00
                     * StrikeRate : 6.0
                     * FourPlusWicketsInSingleInning : 0
                     * FivePlusWicketsInSingleInning : 0
                     * TenPlusWicketsInSingleInning : 0
                     */

                    private int MatchID;
                    private int InningID;
                    private int Matches;
                    private int Innings;
                    private int Balls;
                    private int Overs;
                    private int Runs;
                    private int Wickets;
                    private String BestInning;
                    private String BestMatch;
                    private String Economy;
                    private String Average;
                    private String StrikeRate;
                    private int FourPlusWicketsInSingleInning;
                    private int FivePlusWicketsInSingleInning;
                    private int TenPlusWicketsInSingleInning;

                    public int getMatchID() {
                        return MatchID;
                    }

                    public void setMatchID(int MatchID) {
                        this.MatchID = MatchID;
                    }

                    public int getInningID() {
                        return InningID;
                    }

                    public void setInningID(int InningID) {
                        this.InningID = InningID;
                    }

                    public int getMatches() {
                        return Matches;
                    }

                    public void setMatches(int Matches) {
                        this.Matches = Matches;
                    }

                    public int getInnings() {
                        return Innings;
                    }

                    public void setInnings(int Innings) {
                        this.Innings = Innings;
                    }

                    public int getBalls() {
                        return Balls;
                    }

                    public void setBalls(int Balls) {
                        this.Balls = Balls;
                    }

                    public int getOvers() {
                        return Overs;
                    }

                    public void setOvers(int Overs) {
                        this.Overs = Overs;
                    }

                    public int getRuns() {
                        return Runs;
                    }

                    public void setRuns(int Runs) {
                        this.Runs = Runs;
                    }

                    public int getWickets() {
                        return Wickets;
                    }

                    public void setWickets(int Wickets) {
                        this.Wickets = Wickets;
                    }

                    public String getBestInning() {
                        return BestInning;
                    }

                    public void setBestInning(String BestInning) {
                        this.BestInning = BestInning;
                    }

                    public String getBestMatch() {
                        return BestMatch;
                    }

                    public void setBestMatch(String BestMatch) {
                        this.BestMatch = BestMatch;
                    }

                    public String getEconomy() {
                        return Economy;
                    }

                    public void setEconomy(String Economy) {
                        this.Economy = Economy;
                    }

                    public String getAverage() {
                        return Average;
                    }

                    public void setAverage(String Average) {
                        this.Average = Average;
                    }

                    public String getStrikeRate() {
                        return StrikeRate;
                    }

                    public void setStrikeRate(String StrikeRate) {
                        this.StrikeRate = StrikeRate;
                    }

                    public int getFourPlusWicketsInSingleInning() {
                        return FourPlusWicketsInSingleInning;
                    }

                    public void setFourPlusWicketsInSingleInning(int FourPlusWicketsInSingleInning) {
                        this.FourPlusWicketsInSingleInning = FourPlusWicketsInSingleInning;
                    }

                    public int getFivePlusWicketsInSingleInning() {
                        return FivePlusWicketsInSingleInning;
                    }

                    public void setFivePlusWicketsInSingleInning(int FivePlusWicketsInSingleInning) {
                        this.FivePlusWicketsInSingleInning = FivePlusWicketsInSingleInning;
                    }

                    public int getTenPlusWicketsInSingleInning() {
                        return TenPlusWicketsInSingleInning;
                    }

                    public void setTenPlusWicketsInSingleInning(int TenPlusWicketsInSingleInning) {
                        this.TenPlusWicketsInSingleInning = TenPlusWicketsInSingleInning;
                    }
                }

                public static class ListABeanX {
                    /**
                     * MatchID : 0
                     * InningID : 0
                     * Matches : 34
                     * Innings : 2
                     * Balls : 13
                     * Overs : 2.1
                     * Runs : 15
                     * Wickets : 0
                     * BestInning :
                     * BestMatch :
                     * Economy : 6.92
                     * Average :
                     * StrikeRate :
                     * FourPlusWicketsInSingleInning : 0
                     * FivePlusWicketsInSingleInning : 0
                     * TenPlusWicketsInSingleInning : 0
                     */

                    private int MatchID;
                    private int InningID;
                    private int Matches;
                    private int Innings;
                    private int Balls;
                    private double Overs;
                    private int Runs;
                    private int Wickets;
                    private String BestInning;
                    private String BestMatch;
                    private String Economy;
                    private String Average;
                    private String StrikeRate;
                    private int FourPlusWicketsInSingleInning;
                    private int FivePlusWicketsInSingleInning;
                    private int TenPlusWicketsInSingleInning;

                    public int getMatchID() {
                        return MatchID;
                    }

                    public void setMatchID(int MatchID) {
                        this.MatchID = MatchID;
                    }

                    public int getInningID() {
                        return InningID;
                    }

                    public void setInningID(int InningID) {
                        this.InningID = InningID;
                    }

                    public int getMatches() {
                        return Matches;
                    }

                    public void setMatches(int Matches) {
                        this.Matches = Matches;
                    }

                    public int getInnings() {
                        return Innings;
                    }

                    public void setInnings(int Innings) {
                        this.Innings = Innings;
                    }

                    public int getBalls() {
                        return Balls;
                    }

                    public void setBalls(int Balls) {
                        this.Balls = Balls;
                    }

                    public double getOvers() {
                        return Overs;
                    }

                    public void setOvers(double Overs) {
                        this.Overs = Overs;
                    }

                    public int getRuns() {
                        return Runs;
                    }

                    public void setRuns(int Runs) {
                        this.Runs = Runs;
                    }

                    public int getWickets() {
                        return Wickets;
                    }

                    public void setWickets(int Wickets) {
                        this.Wickets = Wickets;
                    }

                    public String getBestInning() {
                        return BestInning;
                    }

                    public void setBestInning(String BestInning) {
                        this.BestInning = BestInning;
                    }

                    public String getBestMatch() {
                        return BestMatch;
                    }

                    public void setBestMatch(String BestMatch) {
                        this.BestMatch = BestMatch;
                    }

                    public String getEconomy() {
                        return Economy;
                    }

                    public void setEconomy(String Economy) {
                        this.Economy = Economy;
                    }

                    public String getAverage() {
                        return Average;
                    }

                    public void setAverage(String Average) {
                        this.Average = Average;
                    }

                    public String getStrikeRate() {
                        return StrikeRate;
                    }

                    public void setStrikeRate(String StrikeRate) {
                        this.StrikeRate = StrikeRate;
                    }

                    public int getFourPlusWicketsInSingleInning() {
                        return FourPlusWicketsInSingleInning;
                    }

                    public void setFourPlusWicketsInSingleInning(int FourPlusWicketsInSingleInning) {
                        this.FourPlusWicketsInSingleInning = FourPlusWicketsInSingleInning;
                    }

                    public int getFivePlusWicketsInSingleInning() {
                        return FivePlusWicketsInSingleInning;
                    }

                    public void setFivePlusWicketsInSingleInning(int FivePlusWicketsInSingleInning) {
                        this.FivePlusWicketsInSingleInning = FivePlusWicketsInSingleInning;
                    }

                    public int getTenPlusWicketsInSingleInning() {
                        return TenPlusWicketsInSingleInning;
                    }

                    public void setTenPlusWicketsInSingleInning(int TenPlusWicketsInSingleInning) {
                        this.TenPlusWicketsInSingleInning = TenPlusWicketsInSingleInning;
                    }
                }

                public static class FirstClassBeanX {
                    /**
                     * MatchID : 0
                     * InningID : 0
                     * Matches : 23
                     * Innings : 12
                     * Balls : 222
                     * Overs : 37
                     * Runs : 199
                     * Wickets : 1
                     * BestInning : 1/33
                     * BestMatch : 1/33
                     * Economy : 5.37
                     * Average : 199.00
                     * StrikeRate : 222.0
                     * FourPlusWicketsInSingleInning : 0
                     * FivePlusWicketsInSingleInning : 0
                     * TenPlusWicketsInSingleInning : 0
                     */

                    private int MatchID;
                    private int InningID;
                    private int Matches;
                    private int Innings;
                    private int Balls;
                    private int Overs;
                    private int Runs;
                    private int Wickets;
                    private String BestInning;
                    private String BestMatch;
                    private String Economy;
                    private String Average;
                    private String StrikeRate;
                    private int FourPlusWicketsInSingleInning;
                    private int FivePlusWicketsInSingleInning;
                    private int TenPlusWicketsInSingleInning;

                    public int getMatchID() {
                        return MatchID;
                    }

                    public void setMatchID(int MatchID) {
                        this.MatchID = MatchID;
                    }

                    public int getInningID() {
                        return InningID;
                    }

                    public void setInningID(int InningID) {
                        this.InningID = InningID;
                    }

                    public int getMatches() {
                        return Matches;
                    }

                    public void setMatches(int Matches) {
                        this.Matches = Matches;
                    }

                    public int getInnings() {
                        return Innings;
                    }

                    public void setInnings(int Innings) {
                        this.Innings = Innings;
                    }

                    public int getBalls() {
                        return Balls;
                    }

                    public void setBalls(int Balls) {
                        this.Balls = Balls;
                    }

                    public int getOvers() {
                        return Overs;
                    }

                    public void setOvers(int Overs) {
                        this.Overs = Overs;
                    }

                    public int getRuns() {
                        return Runs;
                    }

                    public void setRuns(int Runs) {
                        this.Runs = Runs;
                    }

                    public int getWickets() {
                        return Wickets;
                    }

                    public void setWickets(int Wickets) {
                        this.Wickets = Wickets;
                    }

                    public String getBestInning() {
                        return BestInning;
                    }

                    public void setBestInning(String BestInning) {
                        this.BestInning = BestInning;
                    }

                    public String getBestMatch() {
                        return BestMatch;
                    }

                    public void setBestMatch(String BestMatch) {
                        this.BestMatch = BestMatch;
                    }

                    public String getEconomy() {
                        return Economy;
                    }

                    public void setEconomy(String Economy) {
                        this.Economy = Economy;
                    }

                    public String getAverage() {
                        return Average;
                    }

                    public void setAverage(String Average) {
                        this.Average = Average;
                    }

                    public String getStrikeRate() {
                        return StrikeRate;
                    }

                    public void setStrikeRate(String StrikeRate) {
                        this.StrikeRate = StrikeRate;
                    }

                    public int getFourPlusWicketsInSingleInning() {
                        return FourPlusWicketsInSingleInning;
                    }

                    public void setFourPlusWicketsInSingleInning(int FourPlusWicketsInSingleInning) {
                        this.FourPlusWicketsInSingleInning = FourPlusWicketsInSingleInning;
                    }

                    public int getFivePlusWicketsInSingleInning() {
                        return FivePlusWicketsInSingleInning;
                    }

                    public void setFivePlusWicketsInSingleInning(int FivePlusWicketsInSingleInning) {
                        this.FivePlusWicketsInSingleInning = FivePlusWicketsInSingleInning;
                    }

                    public int getTenPlusWicketsInSingleInning() {
                        return TenPlusWicketsInSingleInning;
                    }

                    public void setTenPlusWicketsInSingleInning(int TenPlusWicketsInSingleInning) {
                        this.TenPlusWicketsInSingleInning = TenPlusWicketsInSingleInning;
                    }
                }
            }

            public static class PointsDataBean  {
                /**
                 * PointsTypeGUID : StatringXI
                 * DefinedPoints : 2.0
                 * ScoreValue : 1
                 * CalculatedPoints : 2.0
                 */

                private String PointsTypeGUID;
                private String DefinedPoints;
                private Double ScoreValue;
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