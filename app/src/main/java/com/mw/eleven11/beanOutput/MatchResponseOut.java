package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchResponseOut {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"TotalRecords":39,"Records":[{"MatchGUID":"0ea2c8d3-89ae-38d4-9300-81183092ce29","TeamNameLocal":"Australia","TeamNameVisitor":"India","TeamNameShortLocal":"AUS","TeamNameShortVisitor":"IND","SeriesName":"Australia vs India 2018","MatchType":"Test","MatchNo":"1st Test Match","MatchStartDateTime":"2018-12-06 05:30:00 05:30 AM","MatchDate":"2018-12-06","MatchTime":"05:30:00","CurrentDateTime":"2019-01-10 20:07:27 ","TeamFlagLocal":"http://mwdemoserver.com/515-/api/uploads/TeamFlag/c3924ae9-9537-3f81-adf4-664c66519e48.png","TeamFlagVisitor":"http://mwdemoserver.com/515-/api/uploads/TeamFlag/6f568eaf-b7de-0a26-ae56-e66190083082.png","MatchLocation":"Adelaide Oval, Adelaide, Australia","Status":"Running","StatusID":"2","MatchScoreDetails":{"StatusLive":"Live","StatusNote":"","TeamScoreLocal":{"Name":"Australia","ShortName":"AUS","LogoURL":"","Scores":"0/0","Overs":"0.0"},"TeamScoreVisitor":{"Name":"India","ShortName":"IND","LogoURL":"","Scores":"250/9","Overs":"87.5"},"MatchVenue":"Adelaide Oval, Adelaide, Australia","Result":"","Toss":"India won the toss and chose to bat first","ManOfTheMatchPlayer":"","Innings":[{"Name":"India inning","ShortName":"IND inn.","Scores":"250/9","Status":"","ScoresFull":"250/9 (87.5 ov)","BatsmanData":[{"Name":"Lokesh Rahul","PlayerIDLive":"l_rahul","Role":"Batsman","Runs":2,"BallsFaced":8,"Fours":0,"Sixes":0,"HowOut":"c Aaron Finch b JR Hazlewood","IsPlaying":"No","StrikeRate":25},{"Name":"M Vijay","PlayerIDLive":"m_vijay","Role":"Batsman","Runs":11,"BallsFaced":22,"Fours":1,"Sixes":0,"HowOut":"c Tim Paine b Mitchell Starc","IsPlaying":"No","StrikeRate":50},{"Name":"Cheteshwar Pujara","PlayerIDLive":"c_pujara","Role":"Batsman","Runs":123,"BallsFaced":246,"Fours":7,"Sixes":2,"HowOut":"runout Pat Cummins","IsPlaying":"No","StrikeRate":50},{"Name":"V Kohli","PlayerIDLive":"v_kohli","Role":"Batsman","Runs":3,"BallsFaced":16,"Fours":0,"Sixes":0,"HowOut":"c Usman Khawaja b Pat Cummins","IsPlaying":"No","StrikeRate":18.75},{"Name":"Ajinkya Rahane","PlayerIDLive":"a_rahane","Role":"Batsman","Runs":13,"BallsFaced":31,"Fours":0,"Sixes":1,"HowOut":"c Peter Handscomb b JR Hazlewood","IsPlaying":"No","StrikeRate":41.94},{"Name":"Rohit Sharma","PlayerIDLive":"rg_sharma","Role":"Batsman","Runs":37,"BallsFaced":61,"Fours":2,"Sixes":3,"HowOut":"c Marcus Harris b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":60.66},{"Name":"RR Pant","PlayerIDLive":"r_pant","Role":"WicketKeeper","Runs":25,"BallsFaced":38,"Fours":2,"Sixes":1,"HowOut":"c Tim Paine b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":65.79},{"Name":"Ravichandran Ashwin","PlayerIDLive":"r_ashwin","Role":"AllRounder","Runs":25,"BallsFaced":76,"Fours":1,"Sixes":0,"HowOut":"c Peter Handscomb b Pat Cummins","IsPlaying":"No","StrikeRate":32.89},{"Name":"I Sharma","PlayerIDLive":"i_sharma","Role":"Bowler","Runs":4,"BallsFaced":20,"Fours":1,"Sixes":0,"HowOut":"bowled b Mitchell Starc","IsPlaying":"No","StrikeRate":20},{"Name":"Mohammed Shami","PlayerIDLive":"s_ahmed","Role":"Bowler","Runs":6,"BallsFaced":9,"Fours":1,"Sixes":0,"HowOut":"","IsPlaying":"Yes","StrikeRate":66.67},{"Name":"Lokesh Rahul","PlayerIDLive":"l_rahul","Role":"Batsman","Runs":2,"BallsFaced":8,"Fours":0,"Sixes":0,"HowOut":"c Aaron Finch b JR Hazlewood","IsPlaying":"No","StrikeRate":25},{"Name":"M Vijay","PlayerIDLive":"m_vijay","Role":"Batsman","Runs":11,"BallsFaced":22,"Fours":1,"Sixes":0,"HowOut":"c Tim Paine b Mitchell Starc","IsPlaying":"No","StrikeRate":50},{"Name":"V Kohli","PlayerIDLive":"v_kohli","Role":"Batsman","Runs":3,"BallsFaced":16,"Fours":0,"Sixes":0,"HowOut":"c Usman Khawaja b Pat Cummins","IsPlaying":"No","StrikeRate":18.75},{"Name":"Ajinkya Rahane","PlayerIDLive":"a_rahane","Role":"Batsman","Runs":13,"BallsFaced":31,"Fours":0,"Sixes":1,"HowOut":"c Peter Handscomb b JR Hazlewood","IsPlaying":"No","StrikeRate":41.94},{"Name":"Rohit Sharma","PlayerIDLive":"rg_sharma","Role":"Batsman","Runs":37,"BallsFaced":61,"Fours":2,"Sixes":3,"HowOut":"c Marcus Harris b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":60.66},{"Name":"RR Pant","PlayerIDLive":"r_pant","Role":"WicketKeeper","Runs":25,"BallsFaced":38,"Fours":2,"Sixes":1,"HowOut":"c Tim Paine b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":65.79},{"Name":"Ravichandran Ashwin","PlayerIDLive":"r_ashwin","Role":"AllRounder","Runs":25,"BallsFaced":76,"Fours":1,"Sixes":0,"HowOut":"c Peter Handscomb b Pat Cummins","IsPlaying":"No","StrikeRate":32.89},{"Name":"I Sharma","PlayerIDLive":"i_sharma","Role":"Bowler","Runs":4,"BallsFaced":20,"Fours":1,"Sixes":0,"HowOut":"bowled b Mitchell Starc","IsPlaying":"No","StrikeRate":20},{"Name":"Cheteshwar Pujara","PlayerIDLive":"c_pujara","Role":"Batsman","Runs":123,"BallsFaced":246,"Fours":7,"Sixes":2,"HowOut":"runout Pat Cummins","IsPlaying":"No","StrikeRate":50}],"BowlersData":[],"FielderData":[],"ExtraRuns":{"Byes":1,"LegByes":1,"Wides":0,"NoBalls":0}},{"Name":"Australia inning","ShortName":"AUS inn.","Scores":"0/0","Status":"","ScoresFull":"0/0 (0.0 ov)","BatsmanData":[{"Name":"Mitchell Starc","PlayerIDLive":"m_starc","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"JR Hazlewood","PlayerIDLive":"j_hazlewood","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"Nathan Michael Lyon","PlayerIDLive":"n_lyon","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"TM Head","PlayerIDLive":"t_head","Role":"Batsman","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""}],"BowlersData":[{"Name":"Mitchell Starc","PlayerIDLive":"m_starc","Overs":"19.0","Maidens":4,"RunsConceded":63,"Wickets":2,"NoBalls":"","Wides":"","Economy":3.32},{"Name":"JR Hazlewood","PlayerIDLive":"j_hazlewood","Overs":"19.5","Maidens":3,"RunsConceded":52,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.62},{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Overs":"19.0","Maidens":3,"RunsConceded":49,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.58},{"Name":"Nathan Michael Lyon","PlayerIDLive":"n_lyon","Overs":"28.0","Maidens":2,"RunsConceded":83,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.96},{"Name":"TM Head","PlayerIDLive":"t_head","Overs":"2.0","Maidens":1,"RunsConceded":2,"Wickets":0,"NoBalls":"","Wides":"","Economy":1}],"FielderData":[{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Catches":0,"RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":0}],"ExtraRuns":{"Byes":0,"LegByes":0,"Wides":0,"NoBalls":0}}]},"JoinedContests":"3"}]}
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
         * TotalRecords : 39
         * Records : [{"MatchGUID":"0ea2c8d3-89ae-38d4-9300-81183092ce29","TeamNameLocal":"Australia","TeamNameVisitor":"India","TeamNameShortLocal":"AUS","TeamNameShortVisitor":"IND","SeriesName":"Australia vs India 2018","MatchType":"Test","MatchNo":"1st Test Match","MatchStartDateTime":"2018-12-06 05:30:00 05:30 AM","MatchDate":"2018-12-06","MatchTime":"05:30:00","CurrentDateTime":"2019-01-10 20:07:27 ","TeamFlagLocal":"http://mwdemoserver.com/515-/api/uploads/TeamFlag/c3924ae9-9537-3f81-adf4-664c66519e48.png","TeamFlagVisitor":"http://mwdemoserver.com/515-/api/uploads/TeamFlag/6f568eaf-b7de-0a26-ae56-e66190083082.png","MatchLocation":"Adelaide Oval, Adelaide, Australia","Status":"Running","StatusID":"2","MatchScoreDetails":{"StatusLive":"Live","StatusNote":"","TeamScoreLocal":{"Name":"Australia","ShortName":"AUS","LogoURL":"","Scores":"0/0","Overs":"0.0"},"TeamScoreVisitor":{"Name":"India","ShortName":"IND","LogoURL":"","Scores":"250/9","Overs":"87.5"},"MatchVenue":"Adelaide Oval, Adelaide, Australia","Result":"","Toss":"India won the toss and chose to bat first","ManOfTheMatchPlayer":"","Innings":[{"Name":"India inning","ShortName":"IND inn.","Scores":"250/9","Status":"","ScoresFull":"250/9 (87.5 ov)","BatsmanData":[{"Name":"Lokesh Rahul","PlayerIDLive":"l_rahul","Role":"Batsman","Runs":2,"BallsFaced":8,"Fours":0,"Sixes":0,"HowOut":"c Aaron Finch b JR Hazlewood","IsPlaying":"No","StrikeRate":25},{"Name":"M Vijay","PlayerIDLive":"m_vijay","Role":"Batsman","Runs":11,"BallsFaced":22,"Fours":1,"Sixes":0,"HowOut":"c Tim Paine b Mitchell Starc","IsPlaying":"No","StrikeRate":50},{"Name":"Cheteshwar Pujara","PlayerIDLive":"c_pujara","Role":"Batsman","Runs":123,"BallsFaced":246,"Fours":7,"Sixes":2,"HowOut":"runout Pat Cummins","IsPlaying":"No","StrikeRate":50},{"Name":"V Kohli","PlayerIDLive":"v_kohli","Role":"Batsman","Runs":3,"BallsFaced":16,"Fours":0,"Sixes":0,"HowOut":"c Usman Khawaja b Pat Cummins","IsPlaying":"No","StrikeRate":18.75},{"Name":"Ajinkya Rahane","PlayerIDLive":"a_rahane","Role":"Batsman","Runs":13,"BallsFaced":31,"Fours":0,"Sixes":1,"HowOut":"c Peter Handscomb b JR Hazlewood","IsPlaying":"No","StrikeRate":41.94},{"Name":"Rohit Sharma","PlayerIDLive":"rg_sharma","Role":"Batsman","Runs":37,"BallsFaced":61,"Fours":2,"Sixes":3,"HowOut":"c Marcus Harris b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":60.66},{"Name":"RR Pant","PlayerIDLive":"r_pant","Role":"WicketKeeper","Runs":25,"BallsFaced":38,"Fours":2,"Sixes":1,"HowOut":"c Tim Paine b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":65.79},{"Name":"Ravichandran Ashwin","PlayerIDLive":"r_ashwin","Role":"AllRounder","Runs":25,"BallsFaced":76,"Fours":1,"Sixes":0,"HowOut":"c Peter Handscomb b Pat Cummins","IsPlaying":"No","StrikeRate":32.89},{"Name":"I Sharma","PlayerIDLive":"i_sharma","Role":"Bowler","Runs":4,"BallsFaced":20,"Fours":1,"Sixes":0,"HowOut":"bowled b Mitchell Starc","IsPlaying":"No","StrikeRate":20},{"Name":"Mohammed Shami","PlayerIDLive":"s_ahmed","Role":"Bowler","Runs":6,"BallsFaced":9,"Fours":1,"Sixes":0,"HowOut":"","IsPlaying":"Yes","StrikeRate":66.67},{"Name":"Lokesh Rahul","PlayerIDLive":"l_rahul","Role":"Batsman","Runs":2,"BallsFaced":8,"Fours":0,"Sixes":0,"HowOut":"c Aaron Finch b JR Hazlewood","IsPlaying":"No","StrikeRate":25},{"Name":"M Vijay","PlayerIDLive":"m_vijay","Role":"Batsman","Runs":11,"BallsFaced":22,"Fours":1,"Sixes":0,"HowOut":"c Tim Paine b Mitchell Starc","IsPlaying":"No","StrikeRate":50},{"Name":"V Kohli","PlayerIDLive":"v_kohli","Role":"Batsman","Runs":3,"BallsFaced":16,"Fours":0,"Sixes":0,"HowOut":"c Usman Khawaja b Pat Cummins","IsPlaying":"No","StrikeRate":18.75},{"Name":"Ajinkya Rahane","PlayerIDLive":"a_rahane","Role":"Batsman","Runs":13,"BallsFaced":31,"Fours":0,"Sixes":1,"HowOut":"c Peter Handscomb b JR Hazlewood","IsPlaying":"No","StrikeRate":41.94},{"Name":"Rohit Sharma","PlayerIDLive":"rg_sharma","Role":"Batsman","Runs":37,"BallsFaced":61,"Fours":2,"Sixes":3,"HowOut":"c Marcus Harris b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":60.66},{"Name":"RR Pant","PlayerIDLive":"r_pant","Role":"WicketKeeper","Runs":25,"BallsFaced":38,"Fours":2,"Sixes":1,"HowOut":"c Tim Paine b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":65.79},{"Name":"Ravichandran Ashwin","PlayerIDLive":"r_ashwin","Role":"AllRounder","Runs":25,"BallsFaced":76,"Fours":1,"Sixes":0,"HowOut":"c Peter Handscomb b Pat Cummins","IsPlaying":"No","StrikeRate":32.89},{"Name":"I Sharma","PlayerIDLive":"i_sharma","Role":"Bowler","Runs":4,"BallsFaced":20,"Fours":1,"Sixes":0,"HowOut":"bowled b Mitchell Starc","IsPlaying":"No","StrikeRate":20},{"Name":"Cheteshwar Pujara","PlayerIDLive":"c_pujara","Role":"Batsman","Runs":123,"BallsFaced":246,"Fours":7,"Sixes":2,"HowOut":"runout Pat Cummins","IsPlaying":"No","StrikeRate":50}],"BowlersData":[],"FielderData":[],"ExtraRuns":{"Byes":1,"LegByes":1,"Wides":0,"NoBalls":0}},{"Name":"Australia inning","ShortName":"AUS inn.","Scores":"0/0","Status":"","ScoresFull":"0/0 (0.0 ov)","BatsmanData":[{"Name":"Mitchell Starc","PlayerIDLive":"m_starc","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"JR Hazlewood","PlayerIDLive":"j_hazlewood","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"Nathan Michael Lyon","PlayerIDLive":"n_lyon","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"TM Head","PlayerIDLive":"t_head","Role":"Batsman","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""}],"BowlersData":[{"Name":"Mitchell Starc","PlayerIDLive":"m_starc","Overs":"19.0","Maidens":4,"RunsConceded":63,"Wickets":2,"NoBalls":"","Wides":"","Economy":3.32},{"Name":"JR Hazlewood","PlayerIDLive":"j_hazlewood","Overs":"19.5","Maidens":3,"RunsConceded":52,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.62},{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Overs":"19.0","Maidens":3,"RunsConceded":49,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.58},{"Name":"Nathan Michael Lyon","PlayerIDLive":"n_lyon","Overs":"28.0","Maidens":2,"RunsConceded":83,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.96},{"Name":"TM Head","PlayerIDLive":"t_head","Overs":"2.0","Maidens":1,"RunsConceded":2,"Wickets":0,"NoBalls":"","Wides":"","Economy":1}],"FielderData":[{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Catches":0,"RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":0}],"ExtraRuns":{"Byes":0,"LegByes":0,"Wides":0,"NoBalls":0}}]},"JoinedContests":"3"}]
         */

        @SerializedName("UpcomingMatchesTime")
        private String UpcomingMatchesTime;
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

        public String getUpcomingMatchesTime() {
            return UpcomingMatchesTime;
        }

        public void setUpcomingMatchesTime(String upcomingMatchesTime) {
            UpcomingMatchesTime = upcomingMatchesTime;
        }

        public static class RecordsBean {
            /**
             * MatchGUID : 0ea2c8d3-89ae-38d4-9300-81183092ce29
             * TeamNameLocal : Australia
             * TeamNameVisitor : India
             * TeamNameShortLocal : AUS
             * TeamNameShortVisitor : IND
             * SeriesName : Australia vs India 2018
             * MatchType : Test
             * MatchNo : 1st Test Match
             * MatchStartDateTime : 2018-12-06 05:30:00 05:30 AM
             * MatchDate : 2018-12-06
             * MatchTime : 05:30:00
             * CurrentDateTime : 2019-01-10 20:07:27
             * TeamFlagLocal : http://mwdemoserver.com/515-/api/uploads/TeamFlag/c3924ae9-9537-3f81-adf4-664c66519e48.png
             * TeamFlagVisitor : http://mwdemoserver.com/515-/api/uploads/TeamFlag/6f568eaf-b7de-0a26-ae56-e66190083082.png
             * MatchLocation : Adelaide Oval, Adelaide, Australia
             * Status : Running
             * StatusID : 2
             * MatchScoreDetails : {"StatusLive":"Live","StatusNote":"","TeamScoreLocal":{"Name":"Australia","ShortName":"AUS","LogoURL":"","Scores":"0/0","Overs":"0.0"},"TeamScoreVisitor":{"Name":"India","ShortName":"IND","LogoURL":"","Scores":"250/9","Overs":"87.5"},"MatchVenue":"Adelaide Oval, Adelaide, Australia","Result":"","Toss":"India won the toss and chose to bat first","ManOfTheMatchPlayer":"","Innings":[{"Name":"India inning","ShortName":"IND inn.","Scores":"250/9","Status":"","ScoresFull":"250/9 (87.5 ov)","BatsmanData":[{"Name":"Lokesh Rahul","PlayerIDLive":"l_rahul","Role":"Batsman","Runs":2,"BallsFaced":8,"Fours":0,"Sixes":0,"HowOut":"c Aaron Finch b JR Hazlewood","IsPlaying":"No","StrikeRate":25},{"Name":"M Vijay","PlayerIDLive":"m_vijay","Role":"Batsman","Runs":11,"BallsFaced":22,"Fours":1,"Sixes":0,"HowOut":"c Tim Paine b Mitchell Starc","IsPlaying":"No","StrikeRate":50},{"Name":"Cheteshwar Pujara","PlayerIDLive":"c_pujara","Role":"Batsman","Runs":123,"BallsFaced":246,"Fours":7,"Sixes":2,"HowOut":"runout Pat Cummins","IsPlaying":"No","StrikeRate":50},{"Name":"V Kohli","PlayerIDLive":"v_kohli","Role":"Batsman","Runs":3,"BallsFaced":16,"Fours":0,"Sixes":0,"HowOut":"c Usman Khawaja b Pat Cummins","IsPlaying":"No","StrikeRate":18.75},{"Name":"Ajinkya Rahane","PlayerIDLive":"a_rahane","Role":"Batsman","Runs":13,"BallsFaced":31,"Fours":0,"Sixes":1,"HowOut":"c Peter Handscomb b JR Hazlewood","IsPlaying":"No","StrikeRate":41.94},{"Name":"Rohit Sharma","PlayerIDLive":"rg_sharma","Role":"Batsman","Runs":37,"BallsFaced":61,"Fours":2,"Sixes":3,"HowOut":"c Marcus Harris b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":60.66},{"Name":"RR Pant","PlayerIDLive":"r_pant","Role":"WicketKeeper","Runs":25,"BallsFaced":38,"Fours":2,"Sixes":1,"HowOut":"c Tim Paine b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":65.79},{"Name":"Ravichandran Ashwin","PlayerIDLive":"r_ashwin","Role":"AllRounder","Runs":25,"BallsFaced":76,"Fours":1,"Sixes":0,"HowOut":"c Peter Handscomb b Pat Cummins","IsPlaying":"No","StrikeRate":32.89},{"Name":"I Sharma","PlayerIDLive":"i_sharma","Role":"Bowler","Runs":4,"BallsFaced":20,"Fours":1,"Sixes":0,"HowOut":"bowled b Mitchell Starc","IsPlaying":"No","StrikeRate":20},{"Name":"Mohammed Shami","PlayerIDLive":"s_ahmed","Role":"Bowler","Runs":6,"BallsFaced":9,"Fours":1,"Sixes":0,"HowOut":"","IsPlaying":"Yes","StrikeRate":66.67},{"Name":"Lokesh Rahul","PlayerIDLive":"l_rahul","Role":"Batsman","Runs":2,"BallsFaced":8,"Fours":0,"Sixes":0,"HowOut":"c Aaron Finch b JR Hazlewood","IsPlaying":"No","StrikeRate":25},{"Name":"M Vijay","PlayerIDLive":"m_vijay","Role":"Batsman","Runs":11,"BallsFaced":22,"Fours":1,"Sixes":0,"HowOut":"c Tim Paine b Mitchell Starc","IsPlaying":"No","StrikeRate":50},{"Name":"V Kohli","PlayerIDLive":"v_kohli","Role":"Batsman","Runs":3,"BallsFaced":16,"Fours":0,"Sixes":0,"HowOut":"c Usman Khawaja b Pat Cummins","IsPlaying":"No","StrikeRate":18.75},{"Name":"Ajinkya Rahane","PlayerIDLive":"a_rahane","Role":"Batsman","Runs":13,"BallsFaced":31,"Fours":0,"Sixes":1,"HowOut":"c Peter Handscomb b JR Hazlewood","IsPlaying":"No","StrikeRate":41.94},{"Name":"Rohit Sharma","PlayerIDLive":"rg_sharma","Role":"Batsman","Runs":37,"BallsFaced":61,"Fours":2,"Sixes":3,"HowOut":"c Marcus Harris b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":60.66},{"Name":"RR Pant","PlayerIDLive":"r_pant","Role":"WicketKeeper","Runs":25,"BallsFaced":38,"Fours":2,"Sixes":1,"HowOut":"c Tim Paine b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":65.79},{"Name":"Ravichandran Ashwin","PlayerIDLive":"r_ashwin","Role":"AllRounder","Runs":25,"BallsFaced":76,"Fours":1,"Sixes":0,"HowOut":"c Peter Handscomb b Pat Cummins","IsPlaying":"No","StrikeRate":32.89},{"Name":"I Sharma","PlayerIDLive":"i_sharma","Role":"Bowler","Runs":4,"BallsFaced":20,"Fours":1,"Sixes":0,"HowOut":"bowled b Mitchell Starc","IsPlaying":"No","StrikeRate":20},{"Name":"Cheteshwar Pujara","PlayerIDLive":"c_pujara","Role":"Batsman","Runs":123,"BallsFaced":246,"Fours":7,"Sixes":2,"HowOut":"runout Pat Cummins","IsPlaying":"No","StrikeRate":50}],"BowlersData":[],"FielderData":[],"ExtraRuns":{"Byes":1,"LegByes":1,"Wides":0,"NoBalls":0}},{"Name":"Australia inning","ShortName":"AUS inn.","Scores":"0/0","Status":"","ScoresFull":"0/0 (0.0 ov)","BatsmanData":[{"Name":"Mitchell Starc","PlayerIDLive":"m_starc","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"JR Hazlewood","PlayerIDLive":"j_hazlewood","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"Nathan Michael Lyon","PlayerIDLive":"n_lyon","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"TM Head","PlayerIDLive":"t_head","Role":"Batsman","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""}],"BowlersData":[{"Name":"Mitchell Starc","PlayerIDLive":"m_starc","Overs":"19.0","Maidens":4,"RunsConceded":63,"Wickets":2,"NoBalls":"","Wides":"","Economy":3.32},{"Name":"JR Hazlewood","PlayerIDLive":"j_hazlewood","Overs":"19.5","Maidens":3,"RunsConceded":52,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.62},{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Overs":"19.0","Maidens":3,"RunsConceded":49,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.58},{"Name":"Nathan Michael Lyon","PlayerIDLive":"n_lyon","Overs":"28.0","Maidens":2,"RunsConceded":83,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.96},{"Name":"TM Head","PlayerIDLive":"t_head","Overs":"2.0","Maidens":1,"RunsConceded":2,"Wickets":0,"NoBalls":"","Wides":"","Economy":1}],"FielderData":[{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Catches":0,"RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":0}],"ExtraRuns":{"Byes":0,"LegByes":0,"Wides":0,"NoBalls":0}}]}
             * JoinedContests : 3
             */

            @SerializedName("IsMegaContest")
            private String IsMegaContest;

            @SerializedName("SeriesID")
            private String SeriesID;
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
            @SerializedName("TeamPlayersAvailable")
            private String TeamPlayersAvailable;
            @SerializedName("SeriesName")
            private String SeriesName;
            @SerializedName("MatchType")
            private String MatchType;
            @SerializedName("MatchNo")
            private String MatchNo;
            @SerializedName("MatchStartDateTime")
            private String MatchStartDateTime;
            @SerializedName("MatchStartDateTimeUTC")
            private String MatchStartDateTimeUTC;
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
            @SerializedName("IsPlayingXINotificationSent")
            private String IsPlayingXINotificationSent;
            @SerializedName("Status")
            private String Status;
            @SerializedName("StatusID")
            private String StatusID;
            @SerializedName("MatchScoreDetails")
            private MatchScoreDetailsBean MatchScoreDetails;
            @SerializedName("JoinedContests")
            private String JoinedContests;
            @SerializedName("ContestsAvailable")
            private String ContestsAvailable;

            @SerializedName("ContestAvailable")
            private String ContestAvailable;
            @SerializedName("MatchDisplay")
            private String MatchDisplay;
            @SerializedName("BannerActive")
            private String BannerActive;
            @SerializedName("MatchTypeByApi")
            private String MatchTypeByApi;


            public String getIsMegaContest() {
                return IsMegaContest;
            }

            public void setIsMegaContest(String isMegaContest) {
                IsMegaContest = isMegaContest;
            }

            public String getSeriesID() {
                return SeriesID;
            }

            public void setSeriesID(String seriesID) {
                SeriesID = seriesID;
            }

            public String getMatchStartDateTimeUTC() {
                return MatchStartDateTimeUTC;
            }

            public void setMatchStartDateTimeUTC(String matchStartDateTimeUTC) {
                MatchStartDateTimeUTC = matchStartDateTimeUTC;
            }

            public String getContestsAvailable() {
                return ContestsAvailable;
            }

            public void setContestsAvailable(String contestsAvailable) {
                ContestsAvailable = contestsAvailable;
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

            public String getTeamPlayersAvailable() {
                return TeamPlayersAvailable;
            }

            public void setTeamPlayersAvailable(String teamPlayersAvailable) {
                TeamPlayersAvailable = teamPlayersAvailable;
            }

            public String getContestAvailable() {
                return ContestAvailable;
            }

            public void setContestAvailable(String contestAvailable) {
                ContestAvailable = contestAvailable;
            }

            public String getIsPlayingXINotificationSent() {
                return IsPlayingXINotificationSent;
            }

            public void setIsPlayingXINotificationSent(String isPlayingXINotificationSent) {
                IsPlayingXINotificationSent = isPlayingXINotificationSent;
            }

            public String getBannerActive() {
                return BannerActive;
            }

            public void setBannerActive(String bannerActive) {
                BannerActive = bannerActive;
            }

            public String getMatchTypeByApi() {
                return MatchTypeByApi;
            }

            public void setMatchTypeByApi(String matchTypeByApi) {
                MatchTypeByApi = matchTypeByApi;
            }

            public String getMatchDisplay() {
                return MatchDisplay;
            }

            public void setMatchDisplay(String matchDisplay) {
                MatchDisplay = matchDisplay;
            }

            public static class MatchScoreDetailsBean {
                /**
                 * StatusLive : Live
                 * StatusNote :
                 * TeamScoreLocal : {"Name":"Australia","ShortName":"AUS","LogoURL":"","Scores":"0/0","Overs":"0.0"}
                 * TeamScoreVisitor : {"Name":"India","ShortName":"IND","LogoURL":"","Scores":"250/9","Overs":"87.5"}
                 * MatchVenue : Adelaide Oval, Adelaide, Australia
                 * Result :
                 * Toss : India won the toss and chose to bat first
                 * ManOfTheMatchPlayer :
                 * Innings : [{"Name":"India inning","ShortName":"IND inn.","Scores":"250/9","Status":"","ScoresFull":"250/9 (87.5 ov)","BatsmanData":[{"Name":"Lokesh Rahul","PlayerIDLive":"l_rahul","Role":"Batsman","Runs":2,"BallsFaced":8,"Fours":0,"Sixes":0,"HowOut":"c Aaron Finch b JR Hazlewood","IsPlaying":"No","StrikeRate":25},{"Name":"M Vijay","PlayerIDLive":"m_vijay","Role":"Batsman","Runs":11,"BallsFaced":22,"Fours":1,"Sixes":0,"HowOut":"c Tim Paine b Mitchell Starc","IsPlaying":"No","StrikeRate":50},{"Name":"Cheteshwar Pujara","PlayerIDLive":"c_pujara","Role":"Batsman","Runs":123,"BallsFaced":246,"Fours":7,"Sixes":2,"HowOut":"runout Pat Cummins","IsPlaying":"No","StrikeRate":50},{"Name":"V Kohli","PlayerIDLive":"v_kohli","Role":"Batsman","Runs":3,"BallsFaced":16,"Fours":0,"Sixes":0,"HowOut":"c Usman Khawaja b Pat Cummins","IsPlaying":"No","StrikeRate":18.75},{"Name":"Ajinkya Rahane","PlayerIDLive":"a_rahane","Role":"Batsman","Runs":13,"BallsFaced":31,"Fours":0,"Sixes":1,"HowOut":"c Peter Handscomb b JR Hazlewood","IsPlaying":"No","StrikeRate":41.94},{"Name":"Rohit Sharma","PlayerIDLive":"rg_sharma","Role":"Batsman","Runs":37,"BallsFaced":61,"Fours":2,"Sixes":3,"HowOut":"c Marcus Harris b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":60.66},{"Name":"RR Pant","PlayerIDLive":"r_pant","Role":"WicketKeeper","Runs":25,"BallsFaced":38,"Fours":2,"Sixes":1,"HowOut":"c Tim Paine b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":65.79},{"Name":"Ravichandran Ashwin","PlayerIDLive":"r_ashwin","Role":"AllRounder","Runs":25,"BallsFaced":76,"Fours":1,"Sixes":0,"HowOut":"c Peter Handscomb b Pat Cummins","IsPlaying":"No","StrikeRate":32.89},{"Name":"I Sharma","PlayerIDLive":"i_sharma","Role":"Bowler","Runs":4,"BallsFaced":20,"Fours":1,"Sixes":0,"HowOut":"bowled b Mitchell Starc","IsPlaying":"No","StrikeRate":20},{"Name":"Mohammed Shami","PlayerIDLive":"s_ahmed","Role":"Bowler","Runs":6,"BallsFaced":9,"Fours":1,"Sixes":0,"HowOut":"","IsPlaying":"Yes","StrikeRate":66.67},{"Name":"Lokesh Rahul","PlayerIDLive":"l_rahul","Role":"Batsman","Runs":2,"BallsFaced":8,"Fours":0,"Sixes":0,"HowOut":"c Aaron Finch b JR Hazlewood","IsPlaying":"No","StrikeRate":25},{"Name":"M Vijay","PlayerIDLive":"m_vijay","Role":"Batsman","Runs":11,"BallsFaced":22,"Fours":1,"Sixes":0,"HowOut":"c Tim Paine b Mitchell Starc","IsPlaying":"No","StrikeRate":50},{"Name":"V Kohli","PlayerIDLive":"v_kohli","Role":"Batsman","Runs":3,"BallsFaced":16,"Fours":0,"Sixes":0,"HowOut":"c Usman Khawaja b Pat Cummins","IsPlaying":"No","StrikeRate":18.75},{"Name":"Ajinkya Rahane","PlayerIDLive":"a_rahane","Role":"Batsman","Runs":13,"BallsFaced":31,"Fours":0,"Sixes":1,"HowOut":"c Peter Handscomb b JR Hazlewood","IsPlaying":"No","StrikeRate":41.94},{"Name":"Rohit Sharma","PlayerIDLive":"rg_sharma","Role":"Batsman","Runs":37,"BallsFaced":61,"Fours":2,"Sixes":3,"HowOut":"c Marcus Harris b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":60.66},{"Name":"RR Pant","PlayerIDLive":"r_pant","Role":"WicketKeeper","Runs":25,"BallsFaced":38,"Fours":2,"Sixes":1,"HowOut":"c Tim Paine b Nathan Michael Lyon","IsPlaying":"No","StrikeRate":65.79},{"Name":"Ravichandran Ashwin","PlayerIDLive":"r_ashwin","Role":"AllRounder","Runs":25,"BallsFaced":76,"Fours":1,"Sixes":0,"HowOut":"c Peter Handscomb b Pat Cummins","IsPlaying":"No","StrikeRate":32.89},{"Name":"I Sharma","PlayerIDLive":"i_sharma","Role":"Bowler","Runs":4,"BallsFaced":20,"Fours":1,"Sixes":0,"HowOut":"bowled b Mitchell Starc","IsPlaying":"No","StrikeRate":20},{"Name":"Cheteshwar Pujara","PlayerIDLive":"c_pujara","Role":"Batsman","Runs":123,"BallsFaced":246,"Fours":7,"Sixes":2,"HowOut":"runout Pat Cummins","IsPlaying":"No","StrikeRate":50}],"BowlersData":[],"FielderData":[],"ExtraRuns":{"Byes":1,"LegByes":1,"Wides":0,"NoBalls":0}},{"Name":"Australia inning","ShortName":"AUS inn.","Scores":"0/0","Status":"","ScoresFull":"0/0 (0.0 ov)","BatsmanData":[{"Name":"Mitchell Starc","PlayerIDLive":"m_starc","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"JR Hazlewood","PlayerIDLive":"j_hazlewood","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"Nathan Michael Lyon","PlayerIDLive":"n_lyon","Role":"Bowler","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},{"Name":"TM Head","PlayerIDLive":"t_head","Role":"Batsman","Runs":"","BallsFaced":"","Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""}],"BowlersData":[{"Name":"Mitchell Starc","PlayerIDLive":"m_starc","Overs":"19.0","Maidens":4,"RunsConceded":63,"Wickets":2,"NoBalls":"","Wides":"","Economy":3.32},{"Name":"JR Hazlewood","PlayerIDLive":"j_hazlewood","Overs":"19.5","Maidens":3,"RunsConceded":52,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.62},{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Overs":"19.0","Maidens":3,"RunsConceded":49,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.58},{"Name":"Nathan Michael Lyon","PlayerIDLive":"n_lyon","Overs":"28.0","Maidens":2,"RunsConceded":83,"Wickets":2,"NoBalls":"","Wides":"","Economy":2.96},{"Name":"TM Head","PlayerIDLive":"t_head","Overs":"2.0","Maidens":1,"RunsConceded":2,"Wickets":0,"NoBalls":"","Wides":"","Economy":1}],"FielderData":[{"Name":"Pat Cummins","PlayerIDLive":"p_cummins","Catches":0,"RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":0}],"ExtraRuns":{"Byes":0,"LegByes":0,"Wides":0,"NoBalls":0}}]
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



                public static class TeamScoreLocalBean {
                    /**
                     * Name : Australia
                     * ShortName : AUS
                     * LogoURL :
                     * Scores : 0/0
                     * Overs : 0.0
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
                     * Name : India
                     * ShortName : IND
                     * LogoURL :
                     * Scores : 250/9
                     * Overs : 87.5
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
}