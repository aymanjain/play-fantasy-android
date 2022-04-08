package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateContestOutput {


    /**
     * ResponseCode : 200
     * Message : Contest created successfully.
     * Data : {"ContestGUID":{"ContestGUID":"dfaa6eed-4150-7078-483a-08de2af01183","ContestName":"Hot Contest 1","CustomizeWinning":[{"From":1,"To":3,"Percent":"70","WinningAmount":"233.3"},{"From":4,"To":5,"Percent":"30","WinningAmount":"150.0"}],"MatchScoreDetails":{"StatusLive":"Not Started","StatusNote":"","TeamScoreLocal":{"Name":"Sydney Sixers\t","ShortName":"SYD","LogoURL":"","Scores":"/","Overs":""},"TeamScoreVisitor":{"Name":"Brisbane Heat","ShortName":"BH","LogoURL":"","Scores":"/","Overs":""},"MatchVenue":"Sydney Cricket Ground, Sydney, Australia","Result":"","Toss":"","ManOfTheMatchPlayer":"","Innings":[]},"ContestFormat":"League","ContestType":"Hot","Privacy":"No","IsPaid":"Yes","WinningAmount":"1000","ContestSize":"10","EntryFee":"110","NoOfWinners":"5","EntryType":"Single","SeriesID":"341909","MatchID":"342030","UserInvitationCode":"H15JuL","TotalAmountReceived":0,"TotalWinningAmount":0}}
     */

    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("Message")
    private String Message;
    @SerializedName("Data")
    private DataBean Data;

    @SerializedName("TotalTeams")
    private String TotalTeams;

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

    public String getTotalTeams() {
        return TotalTeams;
    }

    public void setTotalTeams(String totalTeams) {
        TotalTeams = totalTeams;
    }

    public static class DataBean {
        /**
         * ContestGUID : {"ContestGUID":"dfaa6eed-4150-7078-483a-08de2af01183","ContestName":"Hot Contest 1","CustomizeWinning":[{"From":1,"To":3,"Percent":"70","WinningAmount":"233.3"},{"From":4,"To":5,"Percent":"30","WinningAmount":"150.0"}],"MatchScoreDetails":{"StatusLive":"Not Started","StatusNote":"","TeamScoreLocal":{"Name":"Sydney Sixers\t","ShortName":"SYD","LogoURL":"","Scores":"/","Overs":""},"TeamScoreVisitor":{"Name":"Brisbane Heat","ShortName":"BH","LogoURL":"","Scores":"/","Overs":""},"MatchVenue":"Sydney Cricket Ground, Sydney, Australia","Result":"","Toss":"","ManOfTheMatchPlayer":"","Innings":[]},"ContestFormat":"League","ContestType":"Hot","Privacy":"No","IsPaid":"Yes","WinningAmount":"1000","ContestSize":"10","EntryFee":"110","NoOfWinners":"5","EntryType":"Single","SeriesID":"341909","MatchID":"342030","UserInvitationCode":"H15JuL","TotalAmountReceived":0,"TotalWinningAmount":0}
         */

        @SerializedName("ContestGUID")
        private ContestGUIDBean ContestGUID;

        public ContestGUIDBean getContestGUID() {
            return ContestGUID;
        }

        public void setContestGUID(ContestGUIDBean ContestGUID) {
            this.ContestGUID = ContestGUID;
        }

        public static class ContestGUIDBean {
            /**
             * ContestGUID : dfaa6eed-4150-7078-483a-08de2af01183
             * ContestName : Hot Contest 1
             * CustomizeWinning : [{"From":1,"To":3,"Percent":"70","WinningAmount":"233.3"},{"From":4,"To":5,"Percent":"30","WinningAmount":"150.0"}]
             * MatchScoreDetails : {"StatusLive":"Not Started","StatusNote":"","TeamScoreLocal":{"Name":"Sydney Sixers\t","ShortName":"SYD","LogoURL":"","Scores":"/","Overs":""},"TeamScoreVisitor":{"Name":"Brisbane Heat","ShortName":"BH","LogoURL":"","Scores":"/","Overs":""},"MatchVenue":"Sydney Cricket Ground, Sydney, Australia","Result":"","Toss":"","ManOfTheMatchPlayer":"","Innings":[]}
             * ContestFormat : League
             * ContestType : Hot
             * Privacy : No
             * IsPaid : Yes
             * WinningAmount : 1000
             * ContestSize : 10
             * EntryFee : 110
             * NoOfWinners : 5
             * EntryType : Single
             * SeriesID : 341909
             * MatchID : 342030
             * UserInvitationCode : H15JuL
             * TotalAmountReceived : 0
             * TotalWinningAmount : 0
             */

            @SerializedName("ContestGUID")
            private String ContestGUID;
            @SerializedName("ContestName")
            private String ContestName;
            @SerializedName("MatchScoreDetails")
            private MatchScoreDetailsBean MatchScoreDetails;
            @SerializedName("ContestFormat")
            private String ContestFormat;
            @SerializedName("ContestType")
            private String ContestType;
            @SerializedName("Privacy")
            private String Privacy;
            @SerializedName("IsPaid")
            private String IsPaid;
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
            @SerializedName("SeriesID")
            private String SeriesID;
            @SerializedName("MatchID")
            private String MatchID;
            @SerializedName("UserInvitationCode")
            private String UserInvitationCode;
            @SerializedName("TotalAmountReceived")
            private int TotalAmountReceived;
            @SerializedName("TotalWinningAmount")
            private int TotalWinningAmount;
            @SerializedName("CustomizeWinning")
            private List<CustomizeWinningBean> CustomizeWinning;

            public String getContestGUID() {
                return ContestGUID;
            }

            public void setContestGUID(String ContestGUID) {
                this.ContestGUID = ContestGUID;
            }

            public String getContestName() {
                return ContestName;
            }

            public void setContestName(String ContestName) {
                this.ContestName = ContestName;
            }

            public MatchScoreDetailsBean getMatchScoreDetails() {
                return MatchScoreDetails;
            }

            public void setMatchScoreDetails(MatchScoreDetailsBean MatchScoreDetails) {
                this.MatchScoreDetails = MatchScoreDetails;
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

            public String getSeriesID() {
                return SeriesID;
            }

            public void setSeriesID(String SeriesID) {
                this.SeriesID = SeriesID;
            }

            public String getMatchID() {
                return MatchID;
            }

            public void setMatchID(String MatchID) {
                this.MatchID = MatchID;
            }

            public String getUserInvitationCode() {
                return UserInvitationCode;
            }

            public void setUserInvitationCode(String UserInvitationCode) {
                this.UserInvitationCode = UserInvitationCode;
            }

            public int getTotalAmountReceived() {
                return TotalAmountReceived;
            }

            public void setTotalAmountReceived(int TotalAmountReceived) {
                this.TotalAmountReceived = TotalAmountReceived;
            }

            public int getTotalWinningAmount() {
                return TotalWinningAmount;
            }

            public void setTotalWinningAmount(int TotalWinningAmount) {
                this.TotalWinningAmount = TotalWinningAmount;
            }

            public List<CustomizeWinningBean> getCustomizeWinning() {
                return CustomizeWinning;
            }

            public void setCustomizeWinning(List<CustomizeWinningBean> CustomizeWinning) {
                this.CustomizeWinning = CustomizeWinning;
            }

            public static class MatchScoreDetailsBean {
                /**
                 * StatusLive : Not Started
                 * StatusNote :
                 * TeamScoreLocal : {"Name":"Sydney Sixers\t","ShortName":"SYD","LogoURL":"","Scores":"/","Overs":""}
                 * TeamScoreVisitor : {"Name":"Brisbane Heat","ShortName":"BH","LogoURL":"","Scores":"/","Overs":""}
                 * MatchVenue : Sydney Cricket Ground, Sydney, Australia
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
                    return StatusNote;
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
                    return MatchVenue;
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
                    return Toss;
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
                     * Name : Sydney Sixers
                     * ShortName : SYD
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
                     * Name : Brisbane Heat
                     * ShortName : BH
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

            public static class CustomizeWinningBean {
                /**
                 * From : 1
                 * To : 3
                 * Percent : 70
                 * WinningAmount : 233.3
                 */

                @SerializedName("From")
                private int From;
                @SerializedName("To")
                private int To;
                @SerializedName("Percent")
                private String Percent;
                @SerializedName("WinningAmount")
                private String WinningAmount;

                public int getFrom() {
                    return From;
                }

                public void setFrom(int From) {
                    this.From = From;
                }

                public int getTo() {
                    return To;
                }

                public void setTo(int To) {
                    this.To = To;
                }

                public String getPercent() {
                    return Percent;
                }

                public void setPercent(String Percent) {
                    this.Percent = Percent;
                }

                public String getWinningAmount() {
                    return WinningAmount;
                }

                public void setWinningAmount(String WinningAmount) {
                    this.WinningAmount = WinningAmount;
                }
            }
        }
    }
}