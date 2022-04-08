package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mobiweb on 13/3/18.
 */

public class ResponsePlayerDetails {

    /**
     * code : 200
     * response : {"id":"288","player_id":"44932","name":"Jean-Paul Duminy","country":"South Africa","born":"April 14, 1984, Strandfontein, Cape Town, Cape Province","teams":"South Africa","playing_role":"Batting allrounder","batting_style":"Left-hand bat","bowling_style":"Right-arm offbreak","batting_fielding_data":[{"name":"Tests","matches":"46","innings":"74","not_outs":"10","runs":"2103","highest_inning_score":"166","batting_average":"32.85","balls_faces":"4544","sr":"46.28","hundreds_scored":"6","fifties_scored":"8","boundary_fours":"250","boundary_sixiers":"13","catches_taken":"38","stumpings_made":"0"},{"name":"ODIs","matches":"184","innings":"166","not_outs":"37","runs":"4767","highest_inning_score":"150*","batting_average":"36.95","balls_faces":"5732","sr":"83.16","hundreds_scored":"4","fifties_scored":"25","boundary_fours":"316","boundary_sixiers":"65","catches_taken":"76","stumpings_made":"0"},{"name":"T20Is","matches":"76","innings":"70","not_outs":"22","runs":"1822","highest_inning_score":"96*","batting_average":"37.95","balls_faces":"1460","sr":"124.79","hundreds_scored":"0","fifties_scored":"11","boundary_fours":"130","boundary_sixiers":"65","catches_taken":"34","stumpings_made":"0"},{"name":"First-class","matches":"108","innings":"174","not_outs":"27","runs":"6774","highest_inning_score":"260*","batting_average":"46.08","balls_faces":"13601","sr":"49.80","hundreds_scored":"20","fifties_scored":"30","boundary_fours":"","boundary_sixiers":"","catches_taken":"79","stumpings_made":"0"},{"name":"List A","matches":"255","innings":"227","not_outs":"45","runs":"6979","highest_inning_score":"150*","batting_average":"38.34","balls_faces":"8434","sr":"82.74","hundreds_scored":"5","fifties_scored":"46","boundary_fours":"","boundary_sixiers":"","catches_taken":"98","stumpings_made":"0"},{"name":"T20s","matches":"232","innings":"219","not_outs":"66","runs":"5789","highest_inning_score":"99*","batting_average":"37.83","balls_faces":"4726","sr":"122.49","hundreds_scored":"0","fifties_scored":"39","boundary_fours":"420","boundary_sixiers":"193","catches_taken":"91","stumpings_made":"0"}],"bowling_data":[{"name":"Tests","matches":"46","innings":"57","balls":"2703","runs":"1601","wickets":"42","best_inning_bowling":"4/47","best_match_bowling":"4/51","average":"38.11","economy_rate":"3.55","sr":"64.3","four_wickets_in_inn":"2","five_wickets_in_inn":"0","ten_wickets_in_match":"0"},{"name":"ODIs","matches":"184","innings":"123","balls":"3237","runs":"2891","wickets":"65","best_inning_bowling":"4/16","best_match_bowling":"4/16","average":"44.47","economy_rate":"5.35","sr":"49.8","four_wickets_in_inn":"1","five_wickets_in_inn":"0","ten_wickets_in_match":"0"},{"name":"T20Is","matches":"76","innings":"39","balls":"451","runs":"579","wickets":"20","best_inning_bowling":"3/18","best_match_bowling":"3/18","average":"28.95","economy_rate":"7.70","sr":"22.5","four_wickets_in_inn":"0","five_wickets_in_inn":"0","ten_wickets_in_match":"0"},{"name":"First-class","matches":"108","innings":"","balls":"5434","runs":"3162","wickets":"77","best_inning_bowling":"5/108","best_match_bowling":"","average":"41.06","economy_rate":"3.49","sr":"70.5","four_wickets_in_inn":"3","five_wickets_in_inn":"1","ten_wickets_in_match":"0"},{"name":"List A","matches":"255","innings":"","balls":"4313","runs":"3725","wickets":"88","best_inning_bowling":"4/16","best_match_bowling":"4/16","average":"42.32","economy_rate":"5.18","sr":"49.0","four_wickets_in_inn":"1","five_wickets_in_inn":"0","ten_wickets_in_match":"0"},{"name":"T20s","matches":"232","innings":"129","balls":"1700","runs":"2154","wickets":"72","best_inning_bowling":"4/17","best_match_bowling":"4/17","average":"29.91","economy_rate":"7.60","sr":"23.6","four_wickets_in_inn":"3","five_wickets_in_inn":"0","ten_wickets_in_match":"0"}],"player_pic":"http://avishkar.fantasy96.com/uploads/players/44932.jpg","updated":"1520588152","points":"10.00"}
     * status : 1
     * message : Player details found successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("response")
    private ResponseBean response;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class ResponseBean {
        /**
         * id : 288
         * player_id : 44932
         * name : Jean-Paul Duminy
         * country : South Africa
         * born : April 14, 1984, Strandfontein, Cape Town, Cape Province
         * teams : South Africa
         * playing_role : Batting allrounder
         * batting_style : Left-hand bat
         * bowling_style : Right-arm offbreak
         * batting_fielding_data : [{"name":"Tests","matches":"46","innings":"74","not_outs":"10","runs":"2103","highest_inning_score":"166","batting_average":"32.85","balls_faces":"4544","sr":"46.28","hundreds_scored":"6","fifties_scored":"8","boundary_fours":"250","boundary_sixiers":"13","catches_taken":"38","stumpings_made":"0"},{"name":"ODIs","matches":"184","innings":"166","not_outs":"37","runs":"4767","highest_inning_score":"150*","batting_average":"36.95","balls_faces":"5732","sr":"83.16","hundreds_scored":"4","fifties_scored":"25","boundary_fours":"316","boundary_sixiers":"65","catches_taken":"76","stumpings_made":"0"},{"name":"T20Is","matches":"76","innings":"70","not_outs":"22","runs":"1822","highest_inning_score":"96*","batting_average":"37.95","balls_faces":"1460","sr":"124.79","hundreds_scored":"0","fifties_scored":"11","boundary_fours":"130","boundary_sixiers":"65","catches_taken":"34","stumpings_made":"0"},{"name":"First-class","matches":"108","innings":"174","not_outs":"27","runs":"6774","highest_inning_score":"260*","batting_average":"46.08","balls_faces":"13601","sr":"49.80","hundreds_scored":"20","fifties_scored":"30","boundary_fours":"","boundary_sixiers":"","catches_taken":"79","stumpings_made":"0"},{"name":"List A","matches":"255","innings":"227","not_outs":"45","runs":"6979","highest_inning_score":"150*","batting_average":"38.34","balls_faces":"8434","sr":"82.74","hundreds_scored":"5","fifties_scored":"46","boundary_fours":"","boundary_sixiers":"","catches_taken":"98","stumpings_made":"0"},{"name":"T20s","matches":"232","innings":"219","not_outs":"66","runs":"5789","highest_inning_score":"99*","batting_average":"37.83","balls_faces":"4726","sr":"122.49","hundreds_scored":"0","fifties_scored":"39","boundary_fours":"420","boundary_sixiers":"193","catches_taken":"91","stumpings_made":"0"}]
         * bowling_data : [{"name":"Tests","matches":"46","innings":"57","balls":"2703","runs":"1601","wickets":"42","best_inning_bowling":"4/47","best_match_bowling":"4/51","average":"38.11","economy_rate":"3.55","sr":"64.3","four_wickets_in_inn":"2","five_wickets_in_inn":"0","ten_wickets_in_match":"0"},{"name":"ODIs","matches":"184","innings":"123","balls":"3237","runs":"2891","wickets":"65","best_inning_bowling":"4/16","best_match_bowling":"4/16","average":"44.47","economy_rate":"5.35","sr":"49.8","four_wickets_in_inn":"1","five_wickets_in_inn":"0","ten_wickets_in_match":"0"},{"name":"T20Is","matches":"76","innings":"39","balls":"451","runs":"579","wickets":"20","best_inning_bowling":"3/18","best_match_bowling":"3/18","average":"28.95","economy_rate":"7.70","sr":"22.5","four_wickets_in_inn":"0","five_wickets_in_inn":"0","ten_wickets_in_match":"0"},{"name":"First-class","matches":"108","innings":"","balls":"5434","runs":"3162","wickets":"77","best_inning_bowling":"5/108","best_match_bowling":"","average":"41.06","economy_rate":"3.49","sr":"70.5","four_wickets_in_inn":"3","five_wickets_in_inn":"1","ten_wickets_in_match":"0"},{"name":"List A","matches":"255","innings":"","balls":"4313","runs":"3725","wickets":"88","best_inning_bowling":"4/16","best_match_bowling":"4/16","average":"42.32","economy_rate":"5.18","sr":"49.0","four_wickets_in_inn":"1","five_wickets_in_inn":"0","ten_wickets_in_match":"0"},{"name":"T20s","matches":"232","innings":"129","balls":"1700","runs":"2154","wickets":"72","best_inning_bowling":"4/17","best_match_bowling":"4/17","average":"29.91","economy_rate":"7.60","sr":"23.6","four_wickets_in_inn":"3","five_wickets_in_inn":"0","ten_wickets_in_match":"0"}]
         * player_pic : http://avishkar.fantasy96.com/uploads/players/44932.jpg
         * updated : 1520588152
         * points : 10.00
         */

        @SerializedName("id")
        private String id;
        @SerializedName("player_id")
        private String playerId;
        @SerializedName("name")
        private String name;
        @SerializedName("country")
        private String country;
        @SerializedName("born")
        private String born;
        @SerializedName("teams")
        private String teams;
        @SerializedName("playing_role")
        private String playingRole;
        @SerializedName("batting_style")
        private String battingStyle;
        @SerializedName("bowling_style")
        private String bowlingStyle;
        @SerializedName("player_pic")
        private String playerPic;
        @SerializedName("updated")
        private String updated;
        @SerializedName("points")
        private String points;
        @SerializedName("batting_fielding_data")
        private List<BattingFieldingDataBean> battingFieldingData;
        @SerializedName("bowling_data")
        private List<BowlingDataBean> bowlingData;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPlayerId() {
            return playerId;
        }

        public void setPlayerId(String playerId) {
            this.playerId = playerId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getBorn() {
            return born;
        }

        public void setBorn(String born) {
            this.born = born;
        }

        public String getTeams() {
            return teams;
        }

        public void setTeams(String teams) {
            this.teams = teams;
        }

        public String getPlayingRole() {
            return playingRole;
        }

        public void setPlayingRole(String playingRole) {
            this.playingRole = playingRole;
        }

        public String getBattingStyle() {
            return battingStyle;
        }

        public void setBattingStyle(String battingStyle) {
            this.battingStyle = battingStyle;
        }

        public String getBowlingStyle() {
            return bowlingStyle;
        }

        public void setBowlingStyle(String bowlingStyle) {
            this.bowlingStyle = bowlingStyle;
        }

        public String getPlayerPic() {
            return playerPic;
        }

        public void setPlayerPic(String playerPic) {
            this.playerPic = playerPic;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }

        public List<BattingFieldingDataBean> getBattingFieldingData() {
            return battingFieldingData;
        }

        public void setBattingFieldingData(List<BattingFieldingDataBean> battingFieldingData) {
            this.battingFieldingData = battingFieldingData;
        }

        public List<BowlingDataBean> getBowlingData() {
            return bowlingData;
        }

        public void setBowlingData(List<BowlingDataBean> bowlingData) {
            this.bowlingData = bowlingData;
        }

        public static class BattingFieldingDataBean {
            /**
             * name : Tests
             * matches : 46
             * innings : 74
             * not_outs : 10
             * runs : 2103
             * highest_inning_score : 166
             * batting_average : 32.85
             * balls_faces : 4544
             * sr : 46.28
             * hundreds_scored : 6
             * fifties_scored : 8
             * boundary_fours : 250
             * boundary_sixiers : 13
             * catches_taken : 38
             * stumpings_made : 0
             */

            @SerializedName("name")
            private String name;
            @SerializedName("matches")
            private String matches;
            @SerializedName("innings")
            private String innings;
            @SerializedName("not_outs")
            private String notOuts;
            @SerializedName("runs")
            private String runs;
            @SerializedName("highest_inning_score")
            private String highestInningScore;
            @SerializedName("batting_average")
            private String battingAverage;
            @SerializedName("balls_faces")
            private String ballsFaces;
            @SerializedName("sr")
            private String sr;
            @SerializedName("hundreds_scored")
            private String hundredsScored;
            @SerializedName("fifties_scored")
            private String fiftiesScored;
            @SerializedName("boundary_fours")
            private String boundaryFours;
            @SerializedName("boundary_sixiers")
            private String boundarySixiers;
            @SerializedName("catches_taken")
            private String catchesTaken;
            @SerializedName("stumpings_made")
            private String stumpingsMade;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMatches() {
                return matches;
            }

            public void setMatches(String matches) {
                this.matches = matches;
            }

            public String getInnings() {
                return innings;
            }

            public void setInnings(String innings) {
                this.innings = innings;
            }

            public String getNotOuts() {
                return notOuts;
            }

            public void setNotOuts(String notOuts) {
                this.notOuts = notOuts;
            }

            public String getRuns() {
                return runs;
            }

            public void setRuns(String runs) {
                this.runs = runs;
            }

            public String getHighestInningScore() {
                return highestInningScore;
            }

            public void setHighestInningScore(String highestInningScore) {
                this.highestInningScore = highestInningScore;
            }

            public String getBattingAverage() {
                return battingAverage;
            }

            public void setBattingAverage(String battingAverage) {
                this.battingAverage = battingAverage;
            }

            public String getBallsFaces() {
                return ballsFaces;
            }

            public void setBallsFaces(String ballsFaces) {
                this.ballsFaces = ballsFaces;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getHundredsScored() {
                return hundredsScored;
            }

            public void setHundredsScored(String hundredsScored) {
                this.hundredsScored = hundredsScored;
            }

            public String getFiftiesScored() {
                return fiftiesScored;
            }

            public void setFiftiesScored(String fiftiesScored) {
                this.fiftiesScored = fiftiesScored;
            }

            public String getBoundaryFours() {
                return boundaryFours;
            }

            public void setBoundaryFours(String boundaryFours) {
                this.boundaryFours = boundaryFours;
            }

            public String getBoundarySixiers() {
                return boundarySixiers;
            }

            public void setBoundarySixiers(String boundarySixiers) {
                this.boundarySixiers = boundarySixiers;
            }

            public String getCatchesTaken() {
                return catchesTaken;
            }

            public void setCatchesTaken(String catchesTaken) {
                this.catchesTaken = catchesTaken;
            }

            public String getStumpingsMade() {
                return stumpingsMade;
            }

            public void setStumpingsMade(String stumpingsMade) {
                this.stumpingsMade = stumpingsMade;
            }
        }

        public static class BowlingDataBean {
            /**
             * name : Tests
             * matches : 46
             * innings : 57
             * balls : 2703
             * runs : 1601
             * wickets : 42
             * best_inning_bowling : 4/47
             * best_match_bowling : 4/51
             * average : 38.11
             * economy_rate : 3.55
             * sr : 64.3
             * four_wickets_in_inn : 2
             * five_wickets_in_inn : 0
             * ten_wickets_in_match : 0
             */

            @SerializedName("name")
            private String name;
            @SerializedName("matches")
            private String matches;
            @SerializedName("innings")
            private String innings;
            @SerializedName("balls")
            private String balls;
            @SerializedName("runs")
            private String runs;
            @SerializedName("wickets")
            private String wickets;
            @SerializedName("best_inning_bowling")
            private String bestInningBowling;
            @SerializedName("best_match_bowling")
            private String bestMatchBowling;
            @SerializedName("average")
            private String average;
            @SerializedName("economy_rate")
            private String economyRate;
            @SerializedName("sr")
            private String sr;
            @SerializedName("four_wickets_in_inn")
            private String fourWicketsInInn;
            @SerializedName("five_wickets_in_inn")
            private String fiveWicketsInInn;
            @SerializedName("ten_wickets_in_match")
            private String tenWicketsInMatch;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMatches() {
                return matches;
            }

            public void setMatches(String matches) {
                this.matches = matches;
            }

            public String getInnings() {
                return innings;
            }

            public void setInnings(String innings) {
                this.innings = innings;
            }

            public String getBalls() {
                return balls;
            }

            public void setBalls(String balls) {
                this.balls = balls;
            }

            public String getRuns() {
                return runs;
            }

            public void setRuns(String runs) {
                this.runs = runs;
            }

            public String getWickets() {
                return wickets;
            }

            public void setWickets(String wickets) {
                this.wickets = wickets;
            }

            public String getBestInningBowling() {
                return bestInningBowling;
            }

            public void setBestInningBowling(String bestInningBowling) {
                this.bestInningBowling = bestInningBowling;
            }

            public String getBestMatchBowling() {
                return bestMatchBowling;
            }

            public void setBestMatchBowling(String bestMatchBowling) {
                this.bestMatchBowling = bestMatchBowling;
            }

            public String getAverage() {
                return average;
            }

            public void setAverage(String average) {
                this.average = average;
            }

            public String getEconomyRate() {
                return economyRate;
            }

            public void setEconomyRate(String economyRate) {
                this.economyRate = economyRate;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getFourWicketsInInn() {
                return fourWicketsInInn;
            }

            public void setFourWicketsInInn(String fourWicketsInInn) {
                this.fourWicketsInInn = fourWicketsInInn;
            }

            public String getFiveWicketsInInn() {
                return fiveWicketsInInn;
            }

            public void setFiveWicketsInInn(String fiveWicketsInInn) {
                this.fiveWicketsInInn = fiveWicketsInInn;
            }

            public String getTenWicketsInMatch() {
                return tenWicketsInMatch;
            }

            public void setTenWicketsInMatch(String tenWicketsInMatch) {
                this.tenWicketsInMatch = tenWicketsInMatch;
            }
        }
    }
}
