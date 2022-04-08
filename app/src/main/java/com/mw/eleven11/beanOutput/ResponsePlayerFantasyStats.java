package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePlayerFantasyStats {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"TotalRecords":"10","Records":[{"MatchGUID":"6b6013d5-7ebb-9bc8-1a2e-b0c910087888","MatchNo":"28th Match","MatchLocation":"Stanley Park, Blackpool, England","MatchStartDateTime":"2019-08-28 19:00:00 ","TeamNameShortLocal":"LT","TeamNameShortVisitor":"SS","TotalPoints":"0.00","TotalTeams":"41","PlayerSelectedPercent":"14.63"},{"MatchGUID":"4047235d-872a-04e9-e417-e2d97a8d0893","MatchNo":"25th Match","MatchLocation":"Trent Bridge, Nottingham, England","MatchStartDateTime":"2019-08-25 16:00:00 ","TeamNameShortLocal":"LL","TeamNameShortVisitor":"LT","TotalPoints":"8.00","TotalTeams":"12","PlayerSelectedPercent":"25"},{"MatchGUID":"f044ac7d-e918-2051-0086-f903506d67a5","MatchNo":"23th Match","MatchLocation":"North Marine Road Ground, Scarborough, England","MatchStartDateTime":"2019-08-23 19:00:00 ","TeamNameShortLocal":"YD","TeamNameShortVisitor":"LT","TotalPoints":"84.00","TotalTeams":"37","PlayerSelectedPercent":"8.11"},{"MatchGUID":"64583c68-3e28-c792-a362-58c3122ff0a7","MatchNo":"20th Match","MatchLocation":"Emirates Old Trafford, Manchester, England","MatchStartDateTime":"2019-08-20 23:00:00 ","TeamNameShortLocal":"LT","TeamNameShortVisitor":"LL","TotalPoints":"2.00","TotalTeams":"22","PlayerSelectedPercent":"4.55"},{"MatchGUID":"74a5e885-e498-86d5-06ce-58dc592051c0","MatchNo":"15th Match","MatchLocation":"Chester Boughton Hall CC, Chester, England","MatchStartDateTime":"2019-08-18 19:00:00 ","TeamNameShortLocal":"LT","TeamNameShortVisitor":"WS","TotalPoints":"8.00","TotalTeams":"9","PlayerSelectedPercent":"0"},{"MatchGUID":"993408b1-d189-4cf9-714c-ecf347b4ff75","MatchNo":"14th Match","MatchLocation":"The 1st Central County Ground, Hove, England","MatchStartDateTime":"2019-08-15 23:30:00 ","TeamNameShortLocal":"SV","TeamNameShortVisitor":"LT","TotalPoints":"7.00","TotalTeams":"3","PlayerSelectedPercent":"33.33"},{"MatchGUID":"d523e9b8-83b8-1f7c-8883-b8a0a787c2ba","MatchNo":"10th Match","MatchLocation":"Aigburth, Liverpool, England","MatchStartDateTime":"2019-08-13 19:00:00 ","TeamNameShortLocal":"LT","TeamNameShortVisitor":"YD","TotalPoints":"11.00","TotalTeams":"41","PlayerSelectedPercent":"0"},{"MatchGUID":"fd64ef6e-1032-7c3d-a310-583bc1885d3a","MatchNo":"6th Match","MatchLocation":"The Cooper Associates County Ground, Taunton, England","MatchStartDateTime":"2019-08-10 19:30:00 ","TeamNameShortLocal":"WS","TeamNameShortVisitor":"LT","TotalPoints":"2.00","TotalTeams":"37","PlayerSelectedPercent":"13.51"},{"MatchGUID":"d744a5ca-2caf-f78c-f001-f14a25533bb2","MatchNo":"5th Match","MatchLocation":"Woodbridge Road, Guildford, England","MatchStartDateTime":"2019-08-08 19:00:00 ","TeamNameShortLocal":"SS","TeamNameShortVisitor":"LT","TotalPoints":"-3.00","TotalTeams":"13","PlayerSelectedPercent":"7.69"},{"MatchGUID":"0dbcb85a-ba36-5f82-d684-587a7b45cfc5","MatchNo":"1st Match","MatchLocation":"Aigburth, Liverpool, England","MatchStartDateTime":"2019-08-06 19:00:00 ","TeamNameShortLocal":"LT","TeamNameShortVisitor":"SV","TotalPoints":"23.00","TotalTeams":"9","PlayerSelectedPercent":"11.11"}],"PlayerBattingStats":{"Test":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"NotOut":0,"Runs":0,"Balls":0,"HighestScore":"","Hundreds":0,"Fifties":0,"Fours":0,"Sixes":0,"Average":0,"StrikeRate":0,"Catches":0,"Stumpings":0},"ODI":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"NotOut":0,"Runs":0,"Balls":0,"HighestScore":"","Hundreds":0,"Fifties":0,"Fours":0,"Sixes":0,"Average":0,"StrikeRate":0,"Catches":0,"Stumpings":0},"T20":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"NotOut":0,"Runs":0,"Balls":0,"HighestScore":"","Hundreds":0,"Fifties":0,"Fours":0,"Sixes":0,"Average":0,"StrikeRate":0,"Catches":0,"Stumpings":0}},"PlayerBowlingStats":{"Test":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"Balls":0,"Overs":0,"Runs":0,"Wickets":0,"BestInning":"/","BestMatch":0,"Economy":0,"Average":0,"StrikeRate":0,"FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0},"ODI":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"Balls":0,"Overs":0,"Runs":0,"Wickets":0,"BestInning":"/","BestMatch":0,"Economy":0,"Average":0,"StrikeRate":0,"FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0},"T20":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"Balls":0,"Overs":0,"Runs":0,"Wickets":0,"BestInning":"/","BestMatch":0,"Economy":0,"Average":0,"StrikeRate":0,"FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0}},"PlayerFieldingStats":{"Test":{"catches":0,"stumpings":0},"ODI":{"catches":0,"stumpings":0},"T20":{"catches":0,"stumpings":0}}}
     */

    @SerializedName("ResponseCode")
    private String ResponseCode;
    @SerializedName("Message")
    private String Message;
    @SerializedName("Data")
    private DataBean Data;

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String ResponseCode) {
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
        /**
         * TotalRecords : 10
         * Records : [{"MatchGUID":"6b6013d5-7ebb-9bc8-1a2e-b0c910087888","MatchNo":"28th Match","MatchLocation":"Stanley Park, Blackpool, England","MatchStartDateTime":"2019-08-28 19:00:00 ","TeamNameShortLocal":"LT","TeamNameShortVisitor":"SS","TotalPoints":"0.00","TotalTeams":"41","PlayerSelectedPercent":"14.63"},{"MatchGUID":"4047235d-872a-04e9-e417-e2d97a8d0893","MatchNo":"25th Match","MatchLocation":"Trent Bridge, Nottingham, England","MatchStartDateTime":"2019-08-25 16:00:00 ","TeamNameShortLocal":"LL","TeamNameShortVisitor":"LT","TotalPoints":"8.00","TotalTeams":"12","PlayerSelectedPercent":"25"},{"MatchGUID":"f044ac7d-e918-2051-0086-f903506d67a5","MatchNo":"23th Match","MatchLocation":"North Marine Road Ground, Scarborough, England","MatchStartDateTime":"2019-08-23 19:00:00 ","TeamNameShortLocal":"YD","TeamNameShortVisitor":"LT","TotalPoints":"84.00","TotalTeams":"37","PlayerSelectedPercent":"8.11"},{"MatchGUID":"64583c68-3e28-c792-a362-58c3122ff0a7","MatchNo":"20th Match","MatchLocation":"Emirates Old Trafford, Manchester, England","MatchStartDateTime":"2019-08-20 23:00:00 ","TeamNameShortLocal":"LT","TeamNameShortVisitor":"LL","TotalPoints":"2.00","TotalTeams":"22","PlayerSelectedPercent":"4.55"},{"MatchGUID":"74a5e885-e498-86d5-06ce-58dc592051c0","MatchNo":"15th Match","MatchLocation":"Chester Boughton Hall CC, Chester, England","MatchStartDateTime":"2019-08-18 19:00:00 ","TeamNameShortLocal":"LT","TeamNameShortVisitor":"WS","TotalPoints":"8.00","TotalTeams":"9","PlayerSelectedPercent":"0"},{"MatchGUID":"993408b1-d189-4cf9-714c-ecf347b4ff75","MatchNo":"14th Match","MatchLocation":"The 1st Central County Ground, Hove, England","MatchStartDateTime":"2019-08-15 23:30:00 ","TeamNameShortLocal":"SV","TeamNameShortVisitor":"LT","TotalPoints":"7.00","TotalTeams":"3","PlayerSelectedPercent":"33.33"},{"MatchGUID":"d523e9b8-83b8-1f7c-8883-b8a0a787c2ba","MatchNo":"10th Match","MatchLocation":"Aigburth, Liverpool, England","MatchStartDateTime":"2019-08-13 19:00:00 ","TeamNameShortLocal":"LT","TeamNameShortVisitor":"YD","TotalPoints":"11.00","TotalTeams":"41","PlayerSelectedPercent":"0"},{"MatchGUID":"fd64ef6e-1032-7c3d-a310-583bc1885d3a","MatchNo":"6th Match","MatchLocation":"The Cooper Associates County Ground, Taunton, England","MatchStartDateTime":"2019-08-10 19:30:00 ","TeamNameShortLocal":"WS","TeamNameShortVisitor":"LT","TotalPoints":"2.00","TotalTeams":"37","PlayerSelectedPercent":"13.51"},{"MatchGUID":"d744a5ca-2caf-f78c-f001-f14a25533bb2","MatchNo":"5th Match","MatchLocation":"Woodbridge Road, Guildford, England","MatchStartDateTime":"2019-08-08 19:00:00 ","TeamNameShortLocal":"SS","TeamNameShortVisitor":"LT","TotalPoints":"-3.00","TotalTeams":"13","PlayerSelectedPercent":"7.69"},{"MatchGUID":"0dbcb85a-ba36-5f82-d684-587a7b45cfc5","MatchNo":"1st Match","MatchLocation":"Aigburth, Liverpool, England","MatchStartDateTime":"2019-08-06 19:00:00 ","TeamNameShortLocal":"LT","TeamNameShortVisitor":"SV","TotalPoints":"23.00","TotalTeams":"9","PlayerSelectedPercent":"11.11"}]
         * PlayerBattingStats : {"Test":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"NotOut":0,"Runs":0,"Balls":0,"HighestScore":"","Hundreds":0,"Fifties":0,"Fours":0,"Sixes":0,"Average":0,"StrikeRate":0,"Catches":0,"Stumpings":0},"ODI":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"NotOut":0,"Runs":0,"Balls":0,"HighestScore":"","Hundreds":0,"Fifties":0,"Fours":0,"Sixes":0,"Average":0,"StrikeRate":0,"Catches":0,"Stumpings":0},"T20":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"NotOut":0,"Runs":0,"Balls":0,"HighestScore":"","Hundreds":0,"Fifties":0,"Fours":0,"Sixes":0,"Average":0,"StrikeRate":0,"Catches":0,"Stumpings":0}}
         * PlayerBowlingStats : {"Test":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"Balls":0,"Overs":0,"Runs":0,"Wickets":0,"BestInning":"/","BestMatch":0,"Economy":0,"Average":0,"StrikeRate":0,"FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0},"ODI":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"Balls":0,"Overs":0,"Runs":0,"Wickets":0,"BestInning":"/","BestMatch":0,"Economy":0,"Average":0,"StrikeRate":0,"FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0},"T20":{"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"Balls":0,"Overs":0,"Runs":0,"Wickets":0,"BestInning":"/","BestMatch":0,"Economy":0,"Average":0,"StrikeRate":0,"FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0}}
         * PlayerFieldingStats : {"Test":{"catches":0,"stumpings":0},"ODI":{"catches":0,"stumpings":0},"T20":{"catches":0,"stumpings":0}}
         */
        @SerializedName("TotalRecords")
        private String TotalRecords;
        @SerializedName("PlayerRole")
        private String PlayerRole;
        @SerializedName("PlayerRoleCompleted")
        private String PlayerRoleCompleted;
        @SerializedName("PlayerBattingStats")
        private PlayerBattingStatsBean PlayerBattingStats;
        @SerializedName("PlayerBowlingStats")
        private PlayerBowlingStatsBean PlayerBowlingStats;
        @SerializedName("PlayerFieldingStats")
        private PlayerFieldingStatsBean PlayerFieldingStats;
        @SerializedName("Records")
        private List<RecordsBean> Records;

        public String getPlayerRoleCompleted() {
            return PlayerRoleCompleted;
        }

        public void setPlayerRoleCompleted(String playerRoleCompleted) {
            PlayerRoleCompleted = playerRoleCompleted;
        }

        public String getPlayerRole() {
            return PlayerRole;
        }

        public void setPlayerRole(String playerRole) {
            PlayerRole = playerRole;
        }

        public String getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(String TotalRecords) {
            this.TotalRecords = TotalRecords;
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

        public PlayerFieldingStatsBean getPlayerFieldingStats() {
            return PlayerFieldingStats;
        }

        public void setPlayerFieldingStats(PlayerFieldingStatsBean PlayerFieldingStats) {
            this.PlayerFieldingStats = PlayerFieldingStats;
        }

        public List<RecordsBean> getRecords() {
            return Records;
        }

        public void setRecords(List<RecordsBean> Records) {
            this.Records = Records;
        }

        public static class PlayerBattingStatsBean {
            /**
             * Test : {"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"NotOut":0,"Runs":0,"Balls":0,"HighestScore":"","Hundreds":0,"Fifties":0,"Fours":0,"Sixes":0,"Average":0,"StrikeRate":0,"Catches":0,"Stumpings":0}
             * ODI : {"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"NotOut":0,"Runs":0,"Balls":0,"HighestScore":"","Hundreds":0,"Fifties":0,"Fours":0,"Sixes":0,"Average":0,"StrikeRate":0,"Catches":0,"Stumpings":0}
             * T20 : {"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"NotOut":0,"Runs":0,"Balls":0,"HighestScore":"","Hundreds":0,"Fifties":0,"Fours":0,"Sixes":0,"Average":0,"StrikeRate":0,"Catches":0,"Stumpings":0}
             */
            @SerializedName("Test")
            private TestBean Test;
            @SerializedName("ODI")
            private ODIBean ODI;
            @SerializedName("T20")
            private T20Bean T20;

            @SerializedName("T10")
            private T20Bean T10;

            public T20Bean getT10() {
                return T10;
            }

            public void setT10(T20Bean t10) {
                T10 = t10;
            }

            public TestBean getTest() {
                return Test;
            }

            public void setTest(TestBean Test) {
                this.Test = Test;
            }

            public ODIBean getODI() {
                return ODI;
            }

            public void setODI(ODIBean ODI) {
                this.ODI = ODI;
            }

            public T20Bean getT20() {
                return T20;
            }

            public void setT20(T20Bean T20) {
                this.T20 = T20;
            }

            public static class TestBean {
                /**
                 * MatchID : 0
                 * InningID : 0
                 * Matches : 0
                 * Innings : 0
                 * NotOut : 0
                 * Runs : 0
                 * Balls : 0
                 * HighestScore :
                 * Hundreds : 0
                 * Fifties : 0
                 * Fours : 0
                 * Sixes : 0
                 * Average : 0
                 * StrikeRate : 0
                 * Catches : 0
                 * Stumpings : 0
                 */

                private double MatchID;
                private double InningID;
                private double Matches;
                private double Innings;
                private double NotOut;
                private double Runs;
                private double Balls;
                private String HighestScore;
                private double Hundreds;
                private double Fifties;
                private double Fours;
                private double Sixes;
                private double Average;
                private double StrikeRate;
                private double Catches;
                private double Stumpings;

                public double getMatchID() {
                    return MatchID;
                }

                public void setMatchID(double matchID) {
                    MatchID = matchID;
                }

                public double getInningID() {
                    return InningID;
                }

                public void setInningID(double inningID) {
                    InningID = inningID;
                }

                public double getMatches() {
                    return Matches;
                }

                public void setMatches(double matches) {
                    Matches = matches;
                }

                public double getInnings() {
                    return Innings;
                }

                public void setInnings(double innings) {
                    Innings = innings;
                }

                public double getNotOut() {
                    return NotOut;
                }

                public void setNotOut(double notOut) {
                    NotOut = notOut;
                }

                public double getRuns() {
                    return Runs;
                }

                public void setRuns(double runs) {
                    Runs = runs;
                }

                public double getBalls() {
                    return Balls;
                }

                public void setBalls(double balls) {
                    Balls = balls;
                }

                public String getHighestScore() {
                    return HighestScore;
                }

                public void setHighestScore(String highestScore) {
                    HighestScore = highestScore;
                }

                public double getHundreds() {
                    return Hundreds;
                }

                public void setHundreds(double hundreds) {
                    Hundreds = hundreds;
                }

                public double getFifties() {
                    return Fifties;
                }

                public void setFifties(double fifties) {
                    Fifties = fifties;
                }

                public double getFours() {
                    return Fours;
                }

                public void setFours(double fours) {
                    Fours = fours;
                }

                public double getSixes() {
                    return Sixes;
                }

                public void setSixes(double sixes) {
                    Sixes = sixes;
                }

                public double getAverage() {
                    return Average;
                }

                public void setAverage(double average) {
                    Average = average;
                }

                public double getStrikeRate() {
                    return StrikeRate;
                }

                public void setStrikeRate(double strikeRate) {
                    StrikeRate = strikeRate;
                }

                public double getCatches() {
                    return Catches;
                }

                public void setCatches(double catches) {
                    Catches = catches;
                }

                public double getStumpings() {
                    return Stumpings;
                }

                public void setStumpings(double stumpings) {
                    Stumpings = stumpings;
                }
            }

            public static class ODIBean {
                /**
                 * MatchID : 0
                 * InningID : 0
                 * Matches : 0
                 * Innings : 0
                 * NotOut : 0
                 * Runs : 0
                 * Balls : 0
                 * HighestScore :
                 * Hundreds : 0
                 * Fifties : 0
                 * Fours : 0
                 * Sixes : 0
                 * Average : 0
                 * StrikeRate : 0
                 * Catches : 0
                 * Stumpings : 0
                 */

                private double MatchID;
                private double InningID;
                private double Matches;
                private double Innings;
                private double NotOut;
                private double Runs;
                private double Balls;
                private String HighestScore;
                private double Hundreds;
                private double Fifties;
                private double Fours;
                private double Sixes;
                private double Average;
                private double StrikeRate;
                private double Catches;
                private double Stumpings;

                public double getMatchID() {
                    return MatchID;
                }

                public void setMatchID(double matchID) {
                    MatchID = matchID;
                }

                public double getInningID() {
                    return InningID;
                }

                public void setInningID(double inningID) {
                    InningID = inningID;
                }

                public double getMatches() {
                    return Matches;
                }

                public void setMatches(double matches) {
                    Matches = matches;
                }

                public double getInnings() {
                    return Innings;
                }

                public void setInnings(double innings) {
                    Innings = innings;
                }

                public double getNotOut() {
                    return NotOut;
                }

                public void setNotOut(double notOut) {
                    NotOut = notOut;
                }

                public double getRuns() {
                    return Runs;
                }

                public void setRuns(double runs) {
                    Runs = runs;
                }

                public double getBalls() {
                    return Balls;
                }

                public void setBalls(double balls) {
                    Balls = balls;
                }

                public String getHighestScore() {
                    return HighestScore;
                }

                public void setHighestScore(String highestScore) {
                    HighestScore = highestScore;
                }

                public double getHundreds() {
                    return Hundreds;
                }

                public void setHundreds(double hundreds) {
                    Hundreds = hundreds;
                }

                public double getFifties() {
                    return Fifties;
                }

                public void setFifties(double fifties) {
                    Fifties = fifties;
                }

                public double getFours() {
                    return Fours;
                }

                public void setFours(double fours) {
                    Fours = fours;
                }

                public double getSixes() {
                    return Sixes;
                }

                public void setSixes(double sixes) {
                    Sixes = sixes;
                }

                public double getAverage() {
                    return Average;
                }

                public void setAverage(double average) {
                    Average = average;
                }

                public double getStrikeRate() {
                    return StrikeRate;
                }

                public void setStrikeRate(double strikeRate) {
                    StrikeRate = strikeRate;
                }

                public double getCatches() {
                    return Catches;
                }

                public void setCatches(double catches) {
                    Catches = catches;
                }

                public double getStumpings() {
                    return Stumpings;
                }

                public void setStumpings(double stumpings) {
                    Stumpings = stumpings;
                }
            }

            public static class T20Bean {
                /**
                 * MatchID : 0
                 * InningID : 0
                 * Matches : 0
                 * Innings : 0
                 * NotOut : 0
                 * Runs : 0
                 * Balls : 0
                 * HighestScore :
                 * Hundreds : 0
                 * Fifties : 0
                 * Fours : 0
                 * Sixes : 0
                 * Average : 0
                 * StrikeRate : 0
                 * Catches : 0
                 * Stumpings : 0
                 */

                private double MatchID;
                private double InningID;
                private double Matches;
                private double Innings;
                private double NotOut;
                private double Runs;
                private double Balls;
                private String HighestScore;
                private double Hundreds;
                private double Fifties;
                private double Fours;
                private double Sixes;
                private double Average;
                private double StrikeRate;
                private double Catches;
                private double Stumpings;

                public double getMatchID() {
                    return MatchID;
                }

                public void setMatchID(double matchID) {
                    MatchID = matchID;
                }

                public double getInningID() {
                    return InningID;
                }

                public void setInningID(double inningID) {
                    InningID = inningID;
                }

                public double getMatches() {
                    return Matches;
                }

                public void setMatches(double matches) {
                    Matches = matches;
                }

                public double getInnings() {
                    return Innings;
                }

                public void setInnings(double innings) {
                    Innings = innings;
                }

                public double getNotOut() {
                    return NotOut;
                }

                public void setNotOut(double notOut) {
                    NotOut = notOut;
                }

                public double getRuns() {
                    return Runs;
                }

                public void setRuns(double runs) {
                    Runs = runs;
                }

                public double getBalls() {
                    return Balls;
                }

                public void setBalls(double balls) {
                    Balls = balls;
                }

                public String getHighestScore() {
                    return HighestScore;
                }

                public void setHighestScore(String highestScore) {
                    HighestScore = highestScore;
                }

                public double getHundreds() {
                    return Hundreds;
                }

                public void setHundreds(double hundreds) {
                    Hundreds = hundreds;
                }

                public double getFifties() {
                    return Fifties;
                }

                public void setFifties(double fifties) {
                    Fifties = fifties;
                }

                public double getFours() {
                    return Fours;
                }

                public void setFours(double fours) {
                    Fours = fours;
                }

                public double getSixes() {
                    return Sixes;
                }

                public void setSixes(double sixes) {
                    Sixes = sixes;
                }

                public double getAverage() {
                    return Average;
                }

                public void setAverage(double average) {
                    Average = average;
                }

                public double getStrikeRate() {
                    return StrikeRate;
                }

                public void setStrikeRate(double strikeRate) {
                    StrikeRate = strikeRate;
                }

                public double getCatches() {
                    return Catches;
                }

                public void setCatches(double catches) {
                    Catches = catches;
                }

                public double getStumpings() {
                    return Stumpings;
                }

                public void setStumpings(double stumpings) {
                    Stumpings = stumpings;
                }
            }
        }

        public static class PlayerBowlingStatsBean {
            /**
             * Test : {"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"Balls":0,"Overs":0,"Runs":0,"Wickets":0,"BestInning":"/","BestMatch":0,"Economy":0,"Average":0,"StrikeRate":0,"FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0}
             * ODI : {"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"Balls":0,"Overs":0,"Runs":0,"Wickets":0,"BestInning":"/","BestMatch":0,"Economy":0,"Average":0,"StrikeRate":0,"FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0}
             * T20 : {"MatchID":0,"InningID":0,"Matches":0,"Innings":0,"Balls":0,"Overs":0,"Runs":0,"Wickets":0,"BestInning":"/","BestMatch":0,"Economy":0,"Average":0,"StrikeRate":0,"FourPlusWicketsInSingleInning":0,"FivePlusWicketsInSingleInning":0,"TenPlusWicketsInSingleInning":0}
             */

            private TestBeanX Test;
            private ODIBeanX ODI;
            private T20BeanX T20;
            private T20BeanX T10;


            public T20BeanX getT10() {
                return T10;
            }

            public void setT10(T20BeanX t10) {
                T10 = t10;
            }

            public TestBeanX getTest() {
                return Test;
            }

            public void setTest(TestBeanX Test) {
                this.Test = Test;
            }

            public ODIBeanX getODI() {
                return ODI;
            }

            public void setODI(ODIBeanX ODI) {
                this.ODI = ODI;
            }

            public T20BeanX getT20() {
                return T20;
            }

            public void setT20(T20BeanX T20) {
                this.T20 = T20;
            }

            public static class TestBeanX {
                /**
                 * MatchID : 0
                 * InningID : 0
                 * Matches : 0
                 * Innings : 0
                 * Balls : 0
                 * Overs : 0
                 * Runs : 0
                 * Wickets : 0
                 * BestInning : /
                 * BestMatch : 0
                 * Economy : 0
                 * Average : 0
                 * StrikeRate : 0
                 * FourPlusWicketsInSingleInning : 0
                 * FivePlusWicketsInSingleInning : 0
                 * TenPlusWicketsInSingleInning : 0
                 */

                private double MatchID;
                private double InningID;
                private double Matches;
                private double Innings;
                private double Balls;
                private double Overs;
                private double Runs;
                private double Wickets;
                private String BestInning;
                private double BestMatch;
                private double Economy;
                private double Average;
                private double StrikeRate;
                private double FourPlusWicketsInSingleInning;
                private double FivePlusWicketsInSingleInning;
                private double TenPlusWicketsInSingleInning;

                public double getMatchID() {
                    return MatchID;
                }

                public void setMatchID(double matchID) {
                    MatchID = matchID;
                }

                public double getInningID() {
                    return InningID;
                }

                public void setInningID(double inningID) {
                    InningID = inningID;
                }

                public double getMatches() {
                    return Matches;
                }

                public void setMatches(double matches) {
                    Matches = matches;
                }

                public double getInnings() {
                    return Innings;
                }

                public void setInnings(double innings) {
                    Innings = innings;
                }

                public double getBalls() {
                    return Balls;
                }

                public void setBalls(double balls) {
                    Balls = balls;
                }

                public double getOvers() {
                    return Overs;
                }

                public void setOvers(double overs) {
                    Overs = overs;
                }

                public double getRuns() {
                    return Runs;
                }

                public void setRuns(double runs) {
                    Runs = runs;
                }

                public double getWickets() {
                    return Wickets;
                }

                public void setWickets(double wickets) {
                    Wickets = wickets;
                }

                public String getBestInning() {
                    return BestInning;
                }

                public void setBestInning(String bestInning) {
                    BestInning = bestInning;
                }

                public double getBestMatch() {
                    return BestMatch;
                }

                public void setBestMatch(double bestMatch) {
                    BestMatch = bestMatch;
                }

                public double getEconomy() {
                    return Economy;
                }

                public void setEconomy(double economy) {
                    Economy = economy;
                }

                public double getAverage() {
                    return Average;
                }

                public void setAverage(double average) {
                    Average = average;
                }

                public double getStrikeRate() {
                    return StrikeRate;
                }

                public void setStrikeRate(double strikeRate) {
                    StrikeRate = strikeRate;
                }

                public double getFourPlusWicketsInSingleInning() {
                    return FourPlusWicketsInSingleInning;
                }

                public void setFourPlusWicketsInSingleInning(double fourPlusWicketsInSingleInning) {
                    FourPlusWicketsInSingleInning = fourPlusWicketsInSingleInning;
                }

                public double getFivePlusWicketsInSingleInning() {
                    return FivePlusWicketsInSingleInning;
                }

                public void setFivePlusWicketsInSingleInning(double fivePlusWicketsInSingleInning) {
                    FivePlusWicketsInSingleInning = fivePlusWicketsInSingleInning;
                }

                public double getTenPlusWicketsInSingleInning() {
                    return TenPlusWicketsInSingleInning;
                }

                public void setTenPlusWicketsInSingleInning(double tenPlusWicketsInSingleInning) {
                    TenPlusWicketsInSingleInning = tenPlusWicketsInSingleInning;
                }
            }

            public static class ODIBeanX {
                /**
                 * MatchID : 0
                 * InningID : 0
                 * Matches : 0
                 * Innings : 0
                 * Balls : 0
                 * Overs : 0
                 * Runs : 0
                 * Wickets : 0
                 * BestInning : /
                 * BestMatch : 0
                 * Economy : 0
                 * Average : 0
                 * StrikeRate : 0
                 * FourPlusWicketsInSingleInning : 0
                 * FivePlusWicketsInSingleInning : 0
                 * TenPlusWicketsInSingleInning : 0
                 */

                private double MatchID;
                private double InningID;
                private double Matches;
                private double Innings;
                private double Balls;
                private double Overs;
                private double Runs;
                private double Wickets;
                private String BestInning;
                private double BestMatch;
                private double Economy;
                private double Average;
                private double StrikeRate;
                private double FourPlusWicketsInSingleInning;
                private double FivePlusWicketsInSingleInning;
                private double TenPlusWicketsInSingleInning;

                public double getMatchID() {
                    return MatchID;
                }

                public void setMatchID(double matchID) {
                    MatchID = matchID;
                }

                public double getInningID() {
                    return InningID;
                }

                public void setInningID(double inningID) {
                    InningID = inningID;
                }

                public double getMatches() {
                    return Matches;
                }

                public void setMatches(double matches) {
                    Matches = matches;
                }

                public double getInnings() {
                    return Innings;
                }

                public void setInnings(double innings) {
                    Innings = innings;
                }

                public double getBalls() {
                    return Balls;
                }

                public void setBalls(double balls) {
                    Balls = balls;
                }

                public double getOvers() {
                    return Overs;
                }

                public void setOvers(double overs) {
                    Overs = overs;
                }

                public double getRuns() {
                    return Runs;
                }

                public void setRuns(double runs) {
                    Runs = runs;
                }

                public double getWickets() {
                    return Wickets;
                }

                public void setWickets(double wickets) {
                    Wickets = wickets;
                }

                public String getBestInning() {
                    return BestInning;
                }

                public void setBestInning(String bestInning) {
                    BestInning = bestInning;
                }

                public double getBestMatch() {
                    return BestMatch;
                }

                public void setBestMatch(double bestMatch) {
                    BestMatch = bestMatch;
                }

                public double getEconomy() {
                    return Economy;
                }

                public void setEconomy(double economy) {
                    Economy = economy;
                }

                public double getAverage() {
                    return Average;
                }

                public void setAverage(double average) {
                    Average = average;
                }

                public double getStrikeRate() {
                    return StrikeRate;
                }

                public void setStrikeRate(double strikeRate) {
                    StrikeRate = strikeRate;
                }

                public double getFourPlusWicketsInSingleInning() {
                    return FourPlusWicketsInSingleInning;
                }

                public void setFourPlusWicketsInSingleInning(double fourPlusWicketsInSingleInning) {
                    FourPlusWicketsInSingleInning = fourPlusWicketsInSingleInning;
                }

                public double getFivePlusWicketsInSingleInning() {
                    return FivePlusWicketsInSingleInning;
                }

                public void setFivePlusWicketsInSingleInning(double fivePlusWicketsInSingleInning) {
                    FivePlusWicketsInSingleInning = fivePlusWicketsInSingleInning;
                }

                public double getTenPlusWicketsInSingleInning() {
                    return TenPlusWicketsInSingleInning;
                }

                public void setTenPlusWicketsInSingleInning(double tenPlusWicketsInSingleInning) {
                    TenPlusWicketsInSingleInning = tenPlusWicketsInSingleInning;
                }
            }

            public static class T20BeanX {
                /**
                 * MatchID : 0
                 * InningID : 0
                 * Matches : 0
                 * Innings : 0
                 * Balls : 0
                 * Overs : 0
                 * Runs : 0
                 * Wickets : 0
                 * BestInning : /
                 * BestMatch : 0
                 * Economy : 0
                 * Average : 0
                 * StrikeRate : 0
                 * FourPlusWicketsInSingleInning : 0
                 * FivePlusWicketsInSingleInning : 0
                 * TenPlusWicketsInSingleInning : 0
                 */

                private double MatchID;
                private double InningID;
                private double Matches;
                private double Innings;
                private double Balls;
                private double Overs;
                private double Runs;
                private double Wickets;
                private String BestInning;
                private double BestMatch;
                private double Economy;
                private double Average;
                private double StrikeRate;
                private double FourPlusWicketsInSingleInning;
                private double FivePlusWicketsInSingleInning;
                private double TenPlusWicketsInSingleInning;

                public double getMatchID() {
                    return MatchID;
                }

                public void setMatchID(double matchID) {
                    MatchID = matchID;
                }

                public double getInningID() {
                    return InningID;
                }

                public void setInningID(double inningID) {
                    InningID = inningID;
                }

                public double getMatches() {
                    return Matches;
                }

                public void setMatches(double matches) {
                    Matches = matches;
                }

                public double getInnings() {
                    return Innings;
                }

                public void setInnings(double innings) {
                    Innings = innings;
                }

                public double getBalls() {
                    return Balls;
                }

                public void setBalls(double balls) {
                    Balls = balls;
                }

                public double getOvers() {
                    return Overs;
                }

                public void setOvers(double overs) {
                    Overs = overs;
                }

                public double getRuns() {
                    return Runs;
                }

                public void setRuns(double runs) {
                    Runs = runs;
                }

                public double getWickets() {
                    return Wickets;
                }

                public void setWickets(double wickets) {
                    Wickets = wickets;
                }

                public String getBestInning() {
                    return BestInning;
                }

                public void setBestInning(String bestInning) {
                    BestInning = bestInning;
                }

                public double getBestMatch() {
                    return BestMatch;
                }

                public void setBestMatch(double bestMatch) {
                    BestMatch = bestMatch;
                }

                public double getEconomy() {
                    return Economy;
                }

                public void setEconomy(double economy) {
                    Economy = economy;
                }

                public double getAverage() {
                    return Average;
                }

                public void setAverage(double average) {
                    Average = average;
                }

                public double getStrikeRate() {
                    return StrikeRate;
                }

                public void setStrikeRate(double strikeRate) {
                    StrikeRate = strikeRate;
                }

                public double getFourPlusWicketsInSingleInning() {
                    return FourPlusWicketsInSingleInning;
                }

                public void setFourPlusWicketsInSingleInning(double fourPlusWicketsInSingleInning) {
                    FourPlusWicketsInSingleInning = fourPlusWicketsInSingleInning;
                }

                public double getFivePlusWicketsInSingleInning() {
                    return FivePlusWicketsInSingleInning;
                }

                public void setFivePlusWicketsInSingleInning(double fivePlusWicketsInSingleInning) {
                    FivePlusWicketsInSingleInning = fivePlusWicketsInSingleInning;
                }

                public double getTenPlusWicketsInSingleInning() {
                    return TenPlusWicketsInSingleInning;
                }

                public void setTenPlusWicketsInSingleInning(double tenPlusWicketsInSingleInning) {
                    TenPlusWicketsInSingleInning = tenPlusWicketsInSingleInning;
                }
            }
        }

        public static class PlayerFieldingStatsBean {
            /**
             * Test : {"catches":0,"stumpings":0}
             * ODI : {"catches":0,"stumpings":0}
             * T20 : {"catches":0,"stumpings":0}
             */

            private TestBeanXX Test;
            private ODIBeanXX ODI;
            private T20BeanXX T20;
            private T20BeanXX T10;

            public T20BeanXX getT10() {
                return T10;
            }

            public void setT10(T20BeanXX t10) {
                T10 = t10;
            }

            public TestBeanXX getTest() {
                return Test;
            }

            public void setTest(TestBeanXX Test) {
                this.Test = Test;
            }

            public ODIBeanXX getODI() {
                return ODI;
            }

            public void setODI(ODIBeanXX ODI) {
                this.ODI = ODI;
            }

            public T20BeanXX getT20() {
                return T20;
            }

            public void setT20(T20BeanXX T20) {
                this.T20 = T20;
            }

            public static class TestBeanXX {
                /**
                 * catches : 0
                 * stumpings : 0
                 */

                private double catches;
                private double stumpings;

                public double getCatches() {
                    return catches;
                }

                public void setCatches(double catches) {
                    this.catches = catches;
                }

                public double getStumpings() {
                    return stumpings;
                }

                public void setStumpings(double stumpings) {
                    this.stumpings = stumpings;
                }
            }

            public static class ODIBeanXX {
                /**
                 * catches : 0
                 * stumpings : 0
                 */

                private double catches;
                private double stumpings;

                public double getCatches() {
                    return catches;
                }

                public void setCatches(double catches) {
                    this.catches = catches;
                }

                public double getStumpings() {
                    return stumpings;
                }

                public void setStumpings(double stumpings) {
                    this.stumpings = stumpings;
                }
            }

            public static class T20BeanXX {
                /**
                 * catches : 0
                 * stumpings : 0
                 */

                private double catches;
                private double stumpings;

                public double getCatches() {
                    return catches;
                }

                public void setCatches(double catches) {
                    this.catches = catches;
                }

                public double getStumpings() {
                    return stumpings;
                }

                public void setStumpings(double stumpings) {
                    this.stumpings = stumpings;
                }
            }
        }

        public static class RecordsBean {
            /**
             * MatchGUID : 6b6013d5-7ebb-9bc8-1a2e-b0c910087888
             * MatchNo : 28th Match
             * MatchLocation : Stanley Park, Blackpool, England
             * MatchStartDateTime : 2019-08-28 19:00:00
             * TeamNameShortLocal : LT
             * TeamNameShortVisitor : SS
             * TotalPoints : 0.00
             * TotalTeams : 41
             * PlayerSelectedPercent : 14.63
             */

            private String MatchGUID;
            private String MatchNo;
            private String MatchLocation;
            private String MatchStartDateTime;
            private String TeamNameShortLocal;
            private String TeamNameShortVisitor;
            private String TotalPoints;
            private String TotalTeams;
            private String PlayerSelectedPercent;

            public String getMatchGUID() {
                return MatchGUID;
            }

            public void setMatchGUID(String MatchGUID) {
                this.MatchGUID = MatchGUID;
            }

            public String getMatchNo() {
                return MatchNo;
            }

            public void setMatchNo(String MatchNo) {
                this.MatchNo = MatchNo;
            }

            public String getMatchLocation() {
                return MatchLocation;
            }

            public void setMatchLocation(String MatchLocation) {
                this.MatchLocation = MatchLocation;
            }

            public String getMatchStartDateTime() {
                return MatchStartDateTime;
            }

            public void setMatchStartDateTime(String MatchStartDateTime) {
                this.MatchStartDateTime = MatchStartDateTime;
            }

            public String getTeamNameShortLocal() {
                return TeamNameShortLocal;
            }

            public void setTeamNameShortLocal(String TeamNameShortLocal) {
                this.TeamNameShortLocal = TeamNameShortLocal;
            }

            public String getTeamNameShortVisitor() {
                return TeamNameShortVisitor;
            }

            public void setTeamNameShortVisitor(String TeamNameShortVisitor) {
                this.TeamNameShortVisitor = TeamNameShortVisitor;
            }

            public String getTotalPoints() {
                return TotalPoints;
            }

            public void setTotalPoints(String TotalPoints) {
                this.TotalPoints = TotalPoints;
            }

            public String getTotalTeams() {
                return TotalTeams;
            }

            public void setTotalTeams(String TotalTeams) {
                this.TotalTeams = TotalTeams;
            }

            public String getPlayerSelectedPercent() {
                return PlayerSelectedPercent;
            }

            public void setPlayerSelectedPercent(String PlayerSelectedPercent) {
                this.PlayerSelectedPercent = PlayerSelectedPercent;
            }
        }
    }
}
