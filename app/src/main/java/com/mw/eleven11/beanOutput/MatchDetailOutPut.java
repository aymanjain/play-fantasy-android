package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchDetailOutPut {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"MatchGUID":"f9338fa5-b0a6-3fdb-0991-c2d27f1088ab","TeamNameLocal":"New Zealand","TeamNameVisitor":"Sri Lanka","TeamNameShortLocal":"NZ","TeamNameShortVisitor":"SL","SeriesName":"New Zealand vs Sri Lanka 2018","MatchType":"T20","MatchNo":"Only T20 Match","MatchStartDateTime":"2019-01-11 11:30:00 11:30 AM","MatchDate":"2019-01-11","MatchTime":"11:30:00","CurrentDateTime":"2019-01-10 22:28:04 ","TeamFlagLocal":"http://mwdemoserver.com/515-/api/uploads/TeamFlag/64f3426a-63da-b205-e2de-f7cd33e536b7.png","TeamFlagVisitor":"http://mwdemoserver.com/515-/api/uploads/TeamFlag/ed061447-e03d-6d16-a119-549140248b08.png","MatchLocation":"Eden Park, Auckland, New Zealand","Status":"Pending","StatusID":"1","MatchScoreDetails":{"StatusLive":"Not Started","StatusNote":"","TeamScoreLocal":{"Name":"New Zealand","ShortName":"NZ","LogoURL":"","Scores":"/","Overs":""},"TeamScoreVisitor":{"Name":"Sri Lanka","ShortName":"SL","LogoURL":"","Scores":"/","Overs":""},"MatchVenue":"Eden Park, Auckland, New Zealand","Result":"","Toss":"","ManOfTheMatchPlayer":"","Innings":[]},"JoinedContests":"0"}
     */

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
        /**
         * MatchGUID : f9338fa5-b0a6-3fdb-0991-c2d27f1088ab
         * TeamNameLocal : New Zealand
         * TeamNameVisitor : Sri Lanka
         * TeamNameShortLocal : NZ
         * TeamNameShortVisitor : SL
         * SeriesName : New Zealand vs Sri Lanka 2018
         * MatchType : T20
         * MatchNo : Only T20 Match
         * MatchStartDateTime : 2019-01-11 11:30:00 11:30 AM
         * MatchDate : 2019-01-11
         * MatchTime : 11:30:00
         * CurrentDateTime : 2019-01-10 22:28:04
         * TeamFlagLocal : http://mwdemoserver.com/515-/api/uploads/TeamFlag/64f3426a-63da-b205-e2de-f7cd33e536b7.png
         * TeamFlagVisitor : http://mwdemoserver.com/515-/api/uploads/TeamFlag/ed061447-e03d-6d16-a119-549140248b08.png
         * MatchLocation : Eden Park, Auckland, New Zealand
         * Status : Pending
         * StatusID : 1
         * MatchScoreDetails : {"StatusLive":"Not Started","StatusNote":"","TeamScoreLocal":{"Name":"New Zealand","ShortName":"NZ","LogoURL":"","Scores":"/","Overs":""},"TeamScoreVisitor":{"Name":"Sri Lanka","ShortName":"SL","LogoURL":"","Scores":"/","Overs":""},"MatchVenue":"Eden Park, Auckland, New Zealand","Result":"","Toss":"","ManOfTheMatchPlayer":"","Innings":[]}
         * JoinedContests : 0
         */

        @SerializedName("MatchGUID")
        private String MatchGUID;
        @SerializedName("TeamNameLocal")
        private String TeamNameLocal;
        @SerializedName("TeamNameVisitor")
        private String TeamNameVisitor;
        @SerializedName("TeamNameShortLocal")
        private String TeamNameShortLocal;
        @SerializedName("TeamNameShortVisitor")
        private String TeamNameShortVisitor;
        @SerializedName("SeriesName")
        private String SeriesName;
        @SerializedName("MatchType")
        private String MatchType;
        @SerializedName("MatchNo")
        private String MatchNo;
        @SerializedName("MatchStartDateTime")
        private String MatchStartDateTime;
        @SerializedName("MatchDate")
        private String MatchDate;
        @SerializedName("MatchTime")
        private String MatchTime;
        @SerializedName("CurrentDateTime")
        private String CurrentDateTime;
        @SerializedName("TeamFlagLocal")
        private String TeamFlagLocal;
        @SerializedName("TeamFlagVisitor")
        private String TeamFlagVisitor;
        @SerializedName("MatchLocation")
        private String MatchLocation;
        @SerializedName("Status")
        private String Status;
        @SerializedName("StatusID")
        private String StatusID;
        @SerializedName("MatchScoreDetails")
        private MatchScoreDetailsBean MatchScoreDetails;
        @SerializedName("JoinedContests")
        private String JoinedContests;

        @SerializedName("SeriesGUID")
        private String SeriesGUID;

        public String getSeriesGUID() {
            return SeriesGUID;
        }

        public void setSeriesGUID(String seriesGUID) {
            SeriesGUID = seriesGUID;
        }

        public String getMatchGUID() {
            return MatchGUID;
        }

        public void setMatchGUID(String MatchGUID) {
            this.MatchGUID = MatchGUID;
        }

        public String getTeamNameLocal() {
            return TeamNameLocal;
        }

        public void setTeamNameLocal(String TeamNameLocal) {
            this.TeamNameLocal = TeamNameLocal;
        }

        public String getTeamNameVisitor() {
            return TeamNameVisitor;
        }

        public void setTeamNameVisitor(String TeamNameVisitor) {
            this.TeamNameVisitor = TeamNameVisitor;
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

        public String getSeriesName() {
            return SeriesName;
        }

        public void setSeriesName(String SeriesName) {
            this.SeriesName = SeriesName;
        }

        public String getMatchType() {
            return MatchType;
        }

        public void setMatchType(String MatchType) {
            this.MatchType = MatchType;
        }

        public String getMatchNo() {
            return MatchNo;
        }

        public void setMatchNo(String MatchNo) {
            this.MatchNo = MatchNo;
        }

        public String getMatchStartDateTime() {
            return MatchStartDateTime;
        }

        public void setMatchStartDateTime(String MatchStartDateTime) {
            this.MatchStartDateTime = MatchStartDateTime;
        }

        public String getMatchDate() {
            return MatchDate;
        }

        public void setMatchDate(String MatchDate) {
            this.MatchDate = MatchDate;
        }

        public String getMatchTime() {
            return MatchTime;
        }

        public void setMatchTime(String MatchTime) {
            this.MatchTime = MatchTime;
        }

        public String getCurrentDateTime() {
            return CurrentDateTime;
        }

        public void setCurrentDateTime(String CurrentDateTime) {
            this.CurrentDateTime = CurrentDateTime;
        }

        public String getTeamFlagLocal() {
            return TeamFlagLocal;
        }

        public void setTeamFlagLocal(String TeamFlagLocal) {
            this.TeamFlagLocal = TeamFlagLocal;
        }

        public String getTeamFlagVisitor() {
            return TeamFlagVisitor;
        }

        public void setTeamFlagVisitor(String TeamFlagVisitor) {
            this.TeamFlagVisitor = TeamFlagVisitor;
        }

        public String getMatchLocation() {
            return MatchLocation;
        }

        public void setMatchLocation(String MatchLocation) {
            this.MatchLocation = MatchLocation;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getStatusID() {
            return StatusID;
        }

        public void setStatusID(String StatusID) {
            this.StatusID = StatusID;
        }

        public MatchScoreDetailsBean getMatchScoreDetails() {
            return MatchScoreDetails;
        }

        public void setMatchScoreDetails(MatchScoreDetailsBean MatchScoreDetails) {
            this.MatchScoreDetails = MatchScoreDetails;
        }

        public String getJoinedContests() {
            return JoinedContests;
        }

        public void setJoinedContests(String JoinedContests) {
            this.JoinedContests = JoinedContests;
        }

        public static class MatchScoreDetailsBean {
            /**
             * StatusLive : Not Started
             * StatusNote :
             * TeamScoreLocal : {"Name":"New Zealand","ShortName":"NZ","LogoURL":"","Scores":"/","Overs":""}
             * TeamScoreVisitor : {"Name":"Sri Lanka","ShortName":"SL","LogoURL":"","Scores":"/","Overs":""}
             * MatchVenue : Eden Park, Auckland, New Zealand
             * Result :
             * Toss :
             * ManOfTheMatchPlayer :
             * Innings : []
             */

            @SerializedName("StatusLive")
            private String StatusLive;
            @SerializedName("StatusNote")
            private String StatusNote;
            @SerializedName("TeamScoreLocal")
            private TeamScoreLocalBean TeamScoreLocal;
            @SerializedName("TeamScoreVisitor")
            private TeamScoreVisitorBean TeamScoreVisitor;
            @SerializedName("MatchVenue")
            private String MatchVenue;
            @SerializedName("Result")
            private String Result;
            @SerializedName("Toss")
            private String Toss;
            @SerializedName("ManOfTheMatchPlayer")
            private String ManOfTheMatchPlayer;
            @SerializedName("Innings")
            private List<?> Innings;

            public String getStatusLive() {
                return StatusLive;
            }

            public void setStatusLive(String StatusLive) {
                this.StatusLive = StatusLive;
            }

            public String getStatusNote() {
                return StatusNote==null?"":StatusNote;
            }

            public void setStatusNote(String StatusNote) {
                this.StatusNote = StatusNote;
            }

            public TeamScoreLocalBean getTeamScoreLocal() {
                return TeamScoreLocal;
            }

            public void setTeamScoreLocal(TeamScoreLocalBean TeamScoreLocal) {
                this.TeamScoreLocal = TeamScoreLocal;
            }

            public TeamScoreVisitorBean getTeamScoreVisitor() {
                return TeamScoreVisitor;
            }

            public void setTeamScoreVisitor(TeamScoreVisitorBean TeamScoreVisitor) {
                this.TeamScoreVisitor = TeamScoreVisitor;
            }

            public String getMatchVenue() {
                return MatchVenue==null?"":MatchVenue;
            }

            public void setMatchVenue(String MatchVenue) {
                this.MatchVenue = MatchVenue;
            }

            public String getResult() {
                return Result;
            }

            public void setResult(String Result) {
                this.Result = Result;
            }

            public String getToss() {
                return Toss==null?"":Toss;
            }

            public void setToss(String Toss) {
                this.Toss = Toss;
            }

            public String getManOfTheMatchPlayer() {
                return ManOfTheMatchPlayer;
            }

            public void setManOfTheMatchPlayer(String ManOfTheMatchPlayer) {
                this.ManOfTheMatchPlayer = ManOfTheMatchPlayer;
            }

            public List<?> getInnings() {
                return Innings;
            }

            public void setInnings(List<?> Innings) {
                this.Innings = Innings;
            }

            public static class TeamScoreLocalBean {
                /**
                 * Name : New Zealand
                 * ShortName : NZ
                 * LogoURL :
                 * Scores : /
                 * Overs :
                 */

                @SerializedName("Name")
                private String Name;
                @SerializedName("ShortName")
                private String ShortName;
                @SerializedName("LogoURL")
                private String LogoURL;
                @SerializedName("Scores")
                private String Scores;
                @SerializedName("Overs")
                private String Overs;

                public String getName() {
                    return Name;
                }

                public void setName(String Name) {
                    this.Name = Name;
                }

                public String getShortName() {
                    return ShortName;
                }

                public void setShortName(String ShortName) {
                    this.ShortName = ShortName;
                }

                public String getLogoURL() {
                    return LogoURL;
                }

                public void setLogoURL(String LogoURL) {
                    this.LogoURL = LogoURL;
                }

                public String getScores() {
                    return Scores;
                }

                public void setScores(String Scores) {
                    this.Scores = Scores;
                }

                public String getOvers() {
                    return Overs;
                }

                public void setOvers(String Overs) {
                    this.Overs = Overs;
                }
            }

            public static class TeamScoreVisitorBean {
                /**
                 * Name : Sri Lanka
                 * ShortName : SL
                 * LogoURL :
                 * Scores : /
                 * Overs :
                 */

                @SerializedName("Name")
                private String Name;
                @SerializedName("ShortName")
                private String ShortName;
                @SerializedName("LogoURL")
                private String LogoURL;
                @SerializedName("Scores")
                private String Scores;
                @SerializedName("Overs")
                private String Overs;

                public String getName() {
                    return Name;
                }

                public void setName(String Name) {
                    this.Name = Name;
                }

                public String getShortName() {
                    return ShortName;
                }

                public void setShortName(String ShortName) {
                    this.ShortName = ShortName;
                }

                public String getLogoURL() {
                    return LogoURL;
                }

                public void setLogoURL(String LogoURL) {
                    this.LogoURL = LogoURL;
                }

                public String getScores() {
                    return Scores;
                }

                public void setScores(String Scores) {
                    this.Scores = Scores;
                }

                public String getOvers() {
                    return Overs;
                }

                public void setOvers(String Overs) {
                    this.Overs = Overs;
                }
            }
        }
    }
}