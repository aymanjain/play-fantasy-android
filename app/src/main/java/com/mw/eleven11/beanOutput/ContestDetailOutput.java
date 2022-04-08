package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ContestDetailOutput {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"ContestGUID":"0b609e29-f146-a5be-e6d0-040e9a1613c7","ContestName":"Z3","Privacy":"No","IsPaid":"Yes","WinningAmount":"5","ContestSize":"3","EntryFee":"2","NoOfWinners":"1","EntryType":"Single","IsJoined":"No","Status":"Completed","ContestFormat":"League","ContestType":"Normal","CustomizeWinning":[{"From":1,"To":1,"Percent":"100","WinningAmount":"5"}],"TotalJoined":"3","UserInvitationCode":"9Y2kNx","SeriesName":"BIG BASH LEAGUE 2018-19","MatchType":"T20","MatchNo":"9th Match","MatchStartDateTime":"2018-12-26 13:45:00","TeamNameLocal":"Perth Scorchers","TeamNameVisitor":"Adelaide Strikers","TeamNameShortLocal":"PER","TeamNameShortVisitor":"ADS","TeamFlagLocal":"http://mwdemoserver.com/515-/api/uploads/TeamFlag/bf6f5821-27dc-dfb3-8bf0-53ca3bea7f3b.jpg","TeamFlagVisitor":"http://mwdemoserver.com/515-/api/uploads/TeamFlag/109ed846-5daf-da36-7523-f3fddcc5d7b8.png","MatchLocation":"Perth Stadium, Perth, Australia","StatusID":"5","MatchScoreDetails":{"StatusLive":"Live","StatusNote":"","TeamScoreLocal":{"Name":"Perth Scorchers","ShortName":"PER","LogoURL":"","Scores":"92/3","Overs":"18.0"},"TeamScoreVisitor":{"Name":"Adelaide Strikers","ShortName":"ADS","LogoURL":"","Scores":"88/10","Overs":"17.2"},"MatchVenue":"Perth Stadium, Perth, Australia","Result":"","Toss":"Perth Scorchers won the toss and chose to bowl first","ManOfTheMatchPlayer":"","Innings":[{"Name":"Adelaide Strikers inning","ShortName":"ADS inn.","Scores":"88/10","Status":"","ScoresFull":"88/10 (17.2 ov)","BatsmanData":[{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Role":"WicketKeeper","Runs":11,"BallsFaced":26,"Fours":"","Sixes":"","HowOut":"runout Josh Inglis","IsPlaying":"No","StrikeRate":42.31},{"Name":"Jake Weatherald","PlayerIDLive":"jak_weatherald","Role":"Batsman","Runs":22,"BallsFaced":17,"Fours":3,"Sixes":1,"HowOut":"c AJ Tye b Jason Behrendorff","IsPlaying":"No","StrikeRate":129.41},{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c AJ Turner b Jason Behrendorff","IsPlaying":"No","StrikeRate":33.33},{"Name":"Matthew Short","PlayerIDLive":"m_short","Role":"AllRounder","Runs":1,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"bowled b Jhye Richardson","IsPlaying":"No","StrikeRate":16.67},{"Name":"JW Wells","PlayerIDLive":"j_wells","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c Josh Inglis b Nathan Coulter-Nile","IsPlaying":"No","StrikeRate":33.33},{"Name":"Jake Lehmann","PlayerIDLive":"j_lehmann","Role":"Batsman","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"c Jason Behrendorff b Jhye Richardson","IsPlaying":"No","StrikeRate":""},{"Name":"Michael Neser","PlayerIDLive":"m_neser","Role":"AllRounder","Runs":1,"BallsFaced":3,"Fours":"","Sixes":"","HowOut":"lbw b Jhye Richardson","IsPlaying":"No","StrikeRate":33.33},{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Role":"AllRounder","Runs":21,"BallsFaced":18,"Fours":3,"Sixes":"","HowOut":"c Nathan Coulter-Nile b AJ Tye","IsPlaying":"No","StrikeRate":116.67},{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Role":"Bowler","Runs":21,"BallsFaced":12,"Fours":2,"Sixes":2,"HowOut":"c Nathan Coulter-Nile b David Willey","IsPlaying":"No","StrikeRate":175},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Role":"Bowler","Runs":2,"BallsFaced":8,"Fours":"","Sixes":"","HowOut":"c M Klinger b AJ Tye","IsPlaying":"No","StrikeRate":25},{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Role":"Bowler","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""}],"BowlersData":[{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Overs":"1.0","Maidens":"","RunsConceded":7,"Wickets":"","NoBalls":"","Wides":"","Economy":7},{"Name":"Michael Neser","PlayerIDLive":"m_neser","Overs":"4.0","Maidens":"","RunsConceded":23,"Wickets":"","NoBalls":"","Wides":"","Economy":5.75},{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Overs":"2.0","Maidens":"","RunsConceded":16,"Wickets":1,"NoBalls":"","Wides":"","Economy":8},{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Overs":"4.0","Maidens":1,"RunsConceded":9,"Wickets":"","NoBalls":"","Wides":"","Economy":2.25},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Overs":"3.0","Maidens":"","RunsConceded":17,"Wickets":"","NoBalls":"","Wides":"","Economy":5.67},{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Overs":"4.0","Maidens":"","RunsConceded":18,"Wickets":1,"NoBalls":"","Wides":"","Economy":4.5}],"FielderData":[{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Catches":"","RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}],"AllPlayingData":{"ale_carey":{"batting":{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Role":"WicketKeeper","Runs":11,"BallsFaced":26,"Fours":"","Sixes":"","HowOut":"runout Josh Inglis","IsPlaying":"No","StrikeRate":42.31},"fielding":{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"jak_weatherald":{"batting":{"Name":"Jake Weatherald","PlayerIDLive":"jak_weatherald","Role":"Batsman","Runs":22,"BallsFaced":17,"Fours":3,"Sixes":1,"HowOut":"c AJ Tye b Jason Behrendorff","IsPlaying":"No","StrikeRate":129.41}},"c_ingram":{"batting":{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c AJ Turner b Jason Behrendorff","IsPlaying":"No","StrikeRate":33.33},"bowling":{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Overs":"1.0","Maidens":"","RunsConceded":7,"Wickets":"","NoBalls":"","Wides":"","Economy":7}},"m_short":{"batting":{"Name":"Matthew Short","PlayerIDLive":"m_short","Role":"AllRounder","Runs":1,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"bowled b Jhye Richardson","IsPlaying":"No","StrikeRate":16.67}},"j_wells":{"batting":{"Name":"JW Wells","PlayerIDLive":"j_wells","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c Josh Inglis b Nathan Coulter-Nile","IsPlaying":"No","StrikeRate":33.33}},"j_lehmann":{"batting":{"Name":"Jake Lehmann","PlayerIDLive":"j_lehmann","Role":"Batsman","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"c Jason Behrendorff b Jhye Richardson","IsPlaying":"No","StrikeRate":""}},"m_neser":{"batting":{"Name":"Michael Neser","PlayerIDLive":"m_neser","Role":"AllRounder","Runs":1,"BallsFaced":3,"Fours":"","Sixes":"","HowOut":"lbw b Jhye Richardson","IsPlaying":"No","StrikeRate":33.33},"bowling":{"Name":"Michael Neser","PlayerIDLive":"m_neser","Overs":"4.0","Maidens":"","RunsConceded":23,"Wickets":"","NoBalls":"","Wides":"","Economy":5.75}},"cam_valente":{"batting":{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Role":"AllRounder","Runs":21,"BallsFaced":18,"Fours":3,"Sixes":"","HowOut":"c Nathan Coulter-Nile b AJ Tye","IsPlaying":"No","StrikeRate":116.67},"bowling":{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Overs":"2.0","Maidens":"","RunsConceded":16,"Wickets":1,"NoBalls":"","Wides":"","Economy":8}},"ra_khan":{"batting":{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Role":"Bowler","Runs":21,"BallsFaced":12,"Fours":2,"Sixes":2,"HowOut":"c Nathan Coulter-Nile b David Willey","IsPlaying":"No","StrikeRate":175},"bowling":{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Overs":"4.0","Maidens":1,"RunsConceded":9,"Wickets":"","NoBalls":"","Wides":"","Economy":2.25}},"b_laughlin":{"batting":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Role":"Bowler","Runs":2,"BallsFaced":8,"Fours":"","Sixes":"","HowOut":"c M Klinger b AJ Tye","IsPlaying":"No","StrikeRate":25},"bowling":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Overs":"3.0","Maidens":"","RunsConceded":17,"Wickets":"","NoBalls":"","Wides":"","Economy":5.67},"fielding":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Catches":"","RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}},"b_stanlake":{"batting":{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Role":"Bowler","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},"bowling":{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Overs":"4.0","Maidens":"","RunsConceded":18,"Wickets":1,"NoBalls":"","Wides":"","Economy":4.5}}},"ExtraRuns":{"Byes":5,"LegByes":5,"Wides":3,"NoBalls":0}},{"Name":"Perth Scorchers inning","ShortName":"PER inn.","Scores":"92/3","Status":"","ScoresFull":"92/3 (18.0 ov)","BatsmanData":[{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Role":"WicketKeeper","Runs":22,"BallsFaced":21,"Fours":4,"Sixes":"","HowOut":"c Alex Carey b Billy Stanlake","IsPlaying":"No","StrikeRate":104.76},{"Name":"M Klinger","PlayerIDLive":"m_klinger","Role":"Batsman","Runs":2,"BallsFaced":7,"Fours":"","Sixes":"","HowOut":"runout Ben Laughlin","IsPlaying":"No","StrikeRate":28.57},{"Name":"William Bosisto","PlayerIDLive":"w_bosisto","Role":"Batsman","Runs":36,"BallsFaced":34,"Fours":3,"Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":105.88},{"Name":"AJ Turner","PlayerIDLive":"a_turner","Role":"Batsman","Runs":24,"BallsFaced":46,"Fours":2,"Sixes":"","HowOut":"bowled b Cameron Valente","IsPlaying":"No","StrikeRate":52.17},{"Name":"Hilton Cartwright","PlayerIDLive":"h_cartwright","Role":"AllRounder","Runs":1,"BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":100}],"BowlersData":[{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Overs":"4.0","Maidens":"","RunsConceded":16,"Wickets":2,"NoBalls":"","Wides":"","Economy":4},{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Overs":"4.0","Maidens":"","RunsConceded":33,"Wickets":1,"NoBalls":"","Wides":"","Economy":8.25},{"Name":"David Willey","PlayerIDLive":"d_willey","Overs":"4.0","Maidens":"","RunsConceded":21,"Wickets":1,"NoBalls":"","Wides":"","Economy":5.25},{"Name":"Jhye Richardson","PlayerIDLive":"j_richardson","Overs":"3.0","Maidens":1,"RunsConceded":7,"Wickets":3,"NoBalls":"","Wides":"","Economy":2.33},{"Name":"AJ Tye","PlayerIDLive":"a_tye","Overs":"2.2","Maidens":1,"RunsConceded":9,"Wickets":2,"NoBalls":"","Wides":"","Economy":3.86}],"FielderData":[{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Catches":1,"RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""},{"Name":"M Klinger","PlayerIDLive":"m_klinger","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"AJ Turner","PlayerIDLive":"a_turner","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Catches":2,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"AJ Tye","PlayerIDLive":"a_tye","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}],"AllPlayingData":{"jo_inglis":{"batting":{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Role":"WicketKeeper","Runs":22,"BallsFaced":21,"Fours":4,"Sixes":"","HowOut":"c Alex Carey b Billy Stanlake","IsPlaying":"No","StrikeRate":104.76},"fielding":{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Catches":1,"RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}},"m_klinger":{"batting":{"Name":"M Klinger","PlayerIDLive":"m_klinger","Role":"Batsman","Runs":2,"BallsFaced":7,"Fours":"","Sixes":"","HowOut":"runout Ben Laughlin","IsPlaying":"No","StrikeRate":28.57},"fielding":{"Name":"M Klinger","PlayerIDLive":"m_klinger","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"w_bosisto":{"batting":{"Name":"William Bosisto","PlayerIDLive":"w_bosisto","Role":"Batsman","Runs":36,"BallsFaced":34,"Fours":3,"Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":105.88}},"a_turner":{"batting":{"Name":"AJ Turner","PlayerIDLive":"a_turner","Role":"Batsman","Runs":24,"BallsFaced":46,"Fours":2,"Sixes":"","HowOut":"bowled b Cameron Valente","IsPlaying":"No","StrikeRate":52.17},"fielding":{"Name":"AJ Turner","PlayerIDLive":"a_turner","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"h_cartwright":{"batting":{"Name":"Hilton Cartwright","PlayerIDLive":"h_cartwright","Role":"AllRounder","Runs":1,"BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":100}},"j_behrendorff":{"bowling":{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Overs":"4.0","Maidens":"","RunsConceded":16,"Wickets":2,"NoBalls":"","Wides":"","Economy":4},"fielding":{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"c_nile":{"bowling":{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Overs":"4.0","Maidens":"","RunsConceded":33,"Wickets":1,"NoBalls":"","Wides":"","Economy":8.25},"fielding":{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Catches":2,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"d_willey":{"bowling":{"Name":"David Willey","PlayerIDLive":"d_willey","Overs":"4.0","Maidens":"","RunsConceded":21,"Wickets":1,"NoBalls":"","Wides":"","Economy":5.25}},"j_richardson":{"bowling":{"Name":"Jhye Richardson","PlayerIDLive":"j_richardson","Overs":"3.0","Maidens":1,"RunsConceded":7,"Wickets":3,"NoBalls":"","Wides":"","Economy":2.33}},"a_tye":{"bowling":{"Name":"AJ Tye","PlayerIDLive":"a_tye","Overs":"2.2","Maidens":1,"RunsConceded":9,"Wickets":2,"NoBalls":"","Wides":"","Economy":3.86},"fielding":{"Name":"AJ Tye","PlayerIDLive":"a_tye","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}}},"ExtraRuns":{"Byes":7,"LegByes":7,"Wides":4,"NoBalls":1}}]},"ShowJoinedContest":"Yes","IsConfirm":"No","TotalAmountReceived":"6","TotalWinningAmount":"5.00"}
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

    public static class DataBean implements Serializable {
        /**
         * ContestGUID : 0b609e29-f146-a5be-e6d0-040e9a1613c7
         * ContestName : Z3
         * Privacy : No
         * IsPaid : Yes
         * WinningAmount : 5
         * ContestSize : 3
         * EntryFee : 2
         * NoOfWinners : 1
         * EntryType : Single
         * IsJoined : No
         * Status : Completed
         * ContestFormat : League
         * ContestType : Normal
         * CustomizeWinning : [{"From":1,"To":1,"Percent":"100","WinningAmount":"5"}]
         * TotalJoined : 3
         * UserInvitationCode : 9Y2kNx
         * SeriesName : BIG BASH LEAGUE 2018-19
         * MatchType : T20
         * MatchNo : 9th Match
         * MatchStartDateTime : 2018-12-26 13:45:00
         * TeamNameLocal : Perth Scorchers
         * TeamNameVisitor : Adelaide Strikers
         * TeamNameShortLocal : PER
         * TeamNameShortVisitor : ADS
         * TeamFlagLocal : http://mwdemoserver.com/515-/api/uploads/TeamFlag/bf6f5821-27dc-dfb3-8bf0-53ca3bea7f3b.jpg
         * TeamFlagVisitor : http://mwdemoserver.com/515-/api/uploads/TeamFlag/109ed846-5daf-da36-7523-f3fddcc5d7b8.png
         * MatchLocation : Perth Stadium, Perth, Australia
         * StatusID : 5
         * MatchScoreDetails : {"StatusLive":"Live","StatusNote":"","TeamScoreLocal":{"Name":"Perth Scorchers","ShortName":"PER","LogoURL":"","Scores":"92/3","Overs":"18.0"},"TeamScoreVisitor":{"Name":"Adelaide Strikers","ShortName":"ADS","LogoURL":"","Scores":"88/10","Overs":"17.2"},"MatchVenue":"Perth Stadium, Perth, Australia","Result":"","Toss":"Perth Scorchers won the toss and chose to bowl first","ManOfTheMatchPlayer":"","Innings":[{"Name":"Adelaide Strikers inning","ShortName":"ADS inn.","Scores":"88/10","Status":"","ScoresFull":"88/10 (17.2 ov)","BatsmanData":[{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Role":"WicketKeeper","Runs":11,"BallsFaced":26,"Fours":"","Sixes":"","HowOut":"runout Josh Inglis","IsPlaying":"No","StrikeRate":42.31},{"Name":"Jake Weatherald","PlayerIDLive":"jak_weatherald","Role":"Batsman","Runs":22,"BallsFaced":17,"Fours":3,"Sixes":1,"HowOut":"c AJ Tye b Jason Behrendorff","IsPlaying":"No","StrikeRate":129.41},{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c AJ Turner b Jason Behrendorff","IsPlaying":"No","StrikeRate":33.33},{"Name":"Matthew Short","PlayerIDLive":"m_short","Role":"AllRounder","Runs":1,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"bowled b Jhye Richardson","IsPlaying":"No","StrikeRate":16.67},{"Name":"JW Wells","PlayerIDLive":"j_wells","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c Josh Inglis b Nathan Coulter-Nile","IsPlaying":"No","StrikeRate":33.33},{"Name":"Jake Lehmann","PlayerIDLive":"j_lehmann","Role":"Batsman","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"c Jason Behrendorff b Jhye Richardson","IsPlaying":"No","StrikeRate":""},{"Name":"Michael Neser","PlayerIDLive":"m_neser","Role":"AllRounder","Runs":1,"BallsFaced":3,"Fours":"","Sixes":"","HowOut":"lbw b Jhye Richardson","IsPlaying":"No","StrikeRate":33.33},{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Role":"AllRounder","Runs":21,"BallsFaced":18,"Fours":3,"Sixes":"","HowOut":"c Nathan Coulter-Nile b AJ Tye","IsPlaying":"No","StrikeRate":116.67},{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Role":"Bowler","Runs":21,"BallsFaced":12,"Fours":2,"Sixes":2,"HowOut":"c Nathan Coulter-Nile b David Willey","IsPlaying":"No","StrikeRate":175},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Role":"Bowler","Runs":2,"BallsFaced":8,"Fours":"","Sixes":"","HowOut":"c M Klinger b AJ Tye","IsPlaying":"No","StrikeRate":25},{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Role":"Bowler","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""}],"BowlersData":[{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Overs":"1.0","Maidens":"","RunsConceded":7,"Wickets":"","NoBalls":"","Wides":"","Economy":7},{"Name":"Michael Neser","PlayerIDLive":"m_neser","Overs":"4.0","Maidens":"","RunsConceded":23,"Wickets":"","NoBalls":"","Wides":"","Economy":5.75},{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Overs":"2.0","Maidens":"","RunsConceded":16,"Wickets":1,"NoBalls":"","Wides":"","Economy":8},{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Overs":"4.0","Maidens":1,"RunsConceded":9,"Wickets":"","NoBalls":"","Wides":"","Economy":2.25},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Overs":"3.0","Maidens":"","RunsConceded":17,"Wickets":"","NoBalls":"","Wides":"","Economy":5.67},{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Overs":"4.0","Maidens":"","RunsConceded":18,"Wickets":1,"NoBalls":"","Wides":"","Economy":4.5}],"FielderData":[{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Catches":"","RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}],"AllPlayingData":{"ale_carey":{"batting":{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Role":"WicketKeeper","Runs":11,"BallsFaced":26,"Fours":"","Sixes":"","HowOut":"runout Josh Inglis","IsPlaying":"No","StrikeRate":42.31},"fielding":{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"jak_weatherald":{"batting":{"Name":"Jake Weatherald","PlayerIDLive":"jak_weatherald","Role":"Batsman","Runs":22,"BallsFaced":17,"Fours":3,"Sixes":1,"HowOut":"c AJ Tye b Jason Behrendorff","IsPlaying":"No","StrikeRate":129.41}},"c_ingram":{"batting":{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c AJ Turner b Jason Behrendorff","IsPlaying":"No","StrikeRate":33.33},"bowling":{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Overs":"1.0","Maidens":"","RunsConceded":7,"Wickets":"","NoBalls":"","Wides":"","Economy":7}},"m_short":{"batting":{"Name":"Matthew Short","PlayerIDLive":"m_short","Role":"AllRounder","Runs":1,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"bowled b Jhye Richardson","IsPlaying":"No","StrikeRate":16.67}},"j_wells":{"batting":{"Name":"JW Wells","PlayerIDLive":"j_wells","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c Josh Inglis b Nathan Coulter-Nile","IsPlaying":"No","StrikeRate":33.33}},"j_lehmann":{"batting":{"Name":"Jake Lehmann","PlayerIDLive":"j_lehmann","Role":"Batsman","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"c Jason Behrendorff b Jhye Richardson","IsPlaying":"No","StrikeRate":""}},"m_neser":{"batting":{"Name":"Michael Neser","PlayerIDLive":"m_neser","Role":"AllRounder","Runs":1,"BallsFaced":3,"Fours":"","Sixes":"","HowOut":"lbw b Jhye Richardson","IsPlaying":"No","StrikeRate":33.33},"bowling":{"Name":"Michael Neser","PlayerIDLive":"m_neser","Overs":"4.0","Maidens":"","RunsConceded":23,"Wickets":"","NoBalls":"","Wides":"","Economy":5.75}},"cam_valente":{"batting":{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Role":"AllRounder","Runs":21,"BallsFaced":18,"Fours":3,"Sixes":"","HowOut":"c Nathan Coulter-Nile b AJ Tye","IsPlaying":"No","StrikeRate":116.67},"bowling":{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Overs":"2.0","Maidens":"","RunsConceded":16,"Wickets":1,"NoBalls":"","Wides":"","Economy":8}},"ra_khan":{"batting":{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Role":"Bowler","Runs":21,"BallsFaced":12,"Fours":2,"Sixes":2,"HowOut":"c Nathan Coulter-Nile b David Willey","IsPlaying":"No","StrikeRate":175},"bowling":{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Overs":"4.0","Maidens":1,"RunsConceded":9,"Wickets":"","NoBalls":"","Wides":"","Economy":2.25}},"b_laughlin":{"batting":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Role":"Bowler","Runs":2,"BallsFaced":8,"Fours":"","Sixes":"","HowOut":"c M Klinger b AJ Tye","IsPlaying":"No","StrikeRate":25},"bowling":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Overs":"3.0","Maidens":"","RunsConceded":17,"Wickets":"","NoBalls":"","Wides":"","Economy":5.67},"fielding":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Catches":"","RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}},"b_stanlake":{"batting":{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Role":"Bowler","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},"bowling":{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Overs":"4.0","Maidens":"","RunsConceded":18,"Wickets":1,"NoBalls":"","Wides":"","Economy":4.5}}},"ExtraRuns":{"Byes":5,"LegByes":5,"Wides":3,"NoBalls":0}},{"Name":"Perth Scorchers inning","ShortName":"PER inn.","Scores":"92/3","Status":"","ScoresFull":"92/3 (18.0 ov)","BatsmanData":[{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Role":"WicketKeeper","Runs":22,"BallsFaced":21,"Fours":4,"Sixes":"","HowOut":"c Alex Carey b Billy Stanlake","IsPlaying":"No","StrikeRate":104.76},{"Name":"M Klinger","PlayerIDLive":"m_klinger","Role":"Batsman","Runs":2,"BallsFaced":7,"Fours":"","Sixes":"","HowOut":"runout Ben Laughlin","IsPlaying":"No","StrikeRate":28.57},{"Name":"William Bosisto","PlayerIDLive":"w_bosisto","Role":"Batsman","Runs":36,"BallsFaced":34,"Fours":3,"Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":105.88},{"Name":"AJ Turner","PlayerIDLive":"a_turner","Role":"Batsman","Runs":24,"BallsFaced":46,"Fours":2,"Sixes":"","HowOut":"bowled b Cameron Valente","IsPlaying":"No","StrikeRate":52.17},{"Name":"Hilton Cartwright","PlayerIDLive":"h_cartwright","Role":"AllRounder","Runs":1,"BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":100}],"BowlersData":[{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Overs":"4.0","Maidens":"","RunsConceded":16,"Wickets":2,"NoBalls":"","Wides":"","Economy":4},{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Overs":"4.0","Maidens":"","RunsConceded":33,"Wickets":1,"NoBalls":"","Wides":"","Economy":8.25},{"Name":"David Willey","PlayerIDLive":"d_willey","Overs":"4.0","Maidens":"","RunsConceded":21,"Wickets":1,"NoBalls":"","Wides":"","Economy":5.25},{"Name":"Jhye Richardson","PlayerIDLive":"j_richardson","Overs":"3.0","Maidens":1,"RunsConceded":7,"Wickets":3,"NoBalls":"","Wides":"","Economy":2.33},{"Name":"AJ Tye","PlayerIDLive":"a_tye","Overs":"2.2","Maidens":1,"RunsConceded":9,"Wickets":2,"NoBalls":"","Wides":"","Economy":3.86}],"FielderData":[{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Catches":1,"RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""},{"Name":"M Klinger","PlayerIDLive":"m_klinger","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"AJ Turner","PlayerIDLive":"a_turner","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Catches":2,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"AJ Tye","PlayerIDLive":"a_tye","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}],"AllPlayingData":{"jo_inglis":{"batting":{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Role":"WicketKeeper","Runs":22,"BallsFaced":21,"Fours":4,"Sixes":"","HowOut":"c Alex Carey b Billy Stanlake","IsPlaying":"No","StrikeRate":104.76},"fielding":{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Catches":1,"RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}},"m_klinger":{"batting":{"Name":"M Klinger","PlayerIDLive":"m_klinger","Role":"Batsman","Runs":2,"BallsFaced":7,"Fours":"","Sixes":"","HowOut":"runout Ben Laughlin","IsPlaying":"No","StrikeRate":28.57},"fielding":{"Name":"M Klinger","PlayerIDLive":"m_klinger","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"w_bosisto":{"batting":{"Name":"William Bosisto","PlayerIDLive":"w_bosisto","Role":"Batsman","Runs":36,"BallsFaced":34,"Fours":3,"Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":105.88}},"a_turner":{"batting":{"Name":"AJ Turner","PlayerIDLive":"a_turner","Role":"Batsman","Runs":24,"BallsFaced":46,"Fours":2,"Sixes":"","HowOut":"bowled b Cameron Valente","IsPlaying":"No","StrikeRate":52.17},"fielding":{"Name":"AJ Turner","PlayerIDLive":"a_turner","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"h_cartwright":{"batting":{"Name":"Hilton Cartwright","PlayerIDLive":"h_cartwright","Role":"AllRounder","Runs":1,"BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":100}},"j_behrendorff":{"bowling":{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Overs":"4.0","Maidens":"","RunsConceded":16,"Wickets":2,"NoBalls":"","Wides":"","Economy":4},"fielding":{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"c_nile":{"bowling":{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Overs":"4.0","Maidens":"","RunsConceded":33,"Wickets":1,"NoBalls":"","Wides":"","Economy":8.25},"fielding":{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Catches":2,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"d_willey":{"bowling":{"Name":"David Willey","PlayerIDLive":"d_willey","Overs":"4.0","Maidens":"","RunsConceded":21,"Wickets":1,"NoBalls":"","Wides":"","Economy":5.25}},"j_richardson":{"bowling":{"Name":"Jhye Richardson","PlayerIDLive":"j_richardson","Overs":"3.0","Maidens":1,"RunsConceded":7,"Wickets":3,"NoBalls":"","Wides":"","Economy":2.33}},"a_tye":{"bowling":{"Name":"AJ Tye","PlayerIDLive":"a_tye","Overs":"2.2","Maidens":1,"RunsConceded":9,"Wickets":2,"NoBalls":"","Wides":"","Economy":3.86},"fielding":{"Name":"AJ Tye","PlayerIDLive":"a_tye","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}}},"ExtraRuns":{"Byes":7,"LegByes":7,"Wides":4,"NoBalls":1}}]}
         * ShowJoinedContest : Yes
         * IsConfirm : No
         * TotalAmountReceived : 6
         * TotalWinningAmount : 5.00
         */

        @SerializedName("MatchGUID")
        private String MatchGUID;

        @SerializedName("ContestGUID")
        private String ContestGUID;
        @SerializedName("ContestName")
        private String ContestName;
        @SerializedName("Privacy")
        private String Privacy;
        @SerializedName("CashBonusContribution")
        private String CashBonusContribution;




        @SerializedName("IsPrivacyNameDisplay")
        private String IsPrivacyNameDisplay;
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
        @SerializedName("IsJoined")
        private String IsJoined;
        @SerializedName("Status")
        private String Status;
        @SerializedName("ContestFormat")
        private String ContestFormat;
        @SerializedName("ContestType")
        private String ContestType;
        @SerializedName("TotalJoined")
        private String TotalJoined;
        @SerializedName("UserInvitationCode")
        private String UserInvitationCode;
        @SerializedName("SeriesName")
        private String SeriesName;
        @SerializedName("MatchType")
        private String MatchType;
        @SerializedName("MatchNo")
        private String MatchNo;
        @SerializedName("MatchStartDateTime")
        private String MatchStartDateTime;
        @SerializedName("TeamNameLocal")
        private String TeamNameLocal;
        @SerializedName("TeamNameVisitor")
        private String TeamNameVisitor;
        @SerializedName("TeamNameShortLocal")
        private String TeamNameShortLocal;
        @SerializedName("TeamNameShortVisitor")
        private String TeamNameShortVisitor;
        @SerializedName("TeamFlagLocal")
        private String TeamFlagLocal;
        @SerializedName("TeamFlagVisitor")
        private String TeamFlagVisitor;
        @SerializedName("MatchLocation")
        private String MatchLocation;
        @SerializedName("StatusID")
        private String StatusID;
        @SerializedName("MatchScoreDetails")
        private MatchScoreDetailsBean MatchScoreDetails;
        @SerializedName("ShowJoinedContest")
        private String ShowJoinedContest;
        @SerializedName("IsConfirm")
        private String IsConfirm;
        @SerializedName("TotalAmountReceived")
        private String TotalAmountReceived;
        @SerializedName("TotalWinningAmount")
        private String TotalWinningAmount;
        @SerializedName("UnfilledWinningPercent")
        private String UnfilledWinningPercent;
        @SerializedName("SmartPool")
        private String SmartPool;

        @SerializedName("CustomizeWinning")
        private List<CustomizeWinningBean> CustomizeWinning;

        @SerializedName("Statics")
        private StaticsBean Statics;

        @SerializedName("UserTeamDetails")
        private List<UserTeamDetailsBean> UserTeamDetails;
        @SerializedName("WinUpTo")

        private String winUpTo;
        @SerializedName("WinningRatio")

        private String WinningRatio;
        @SerializedName("WinningType")

        private String WinningType;

        public List<UserTeamDetailsBean> getUserTeamDetails() {
            return UserTeamDetails;
        }

        public void setUserTeamDetails(List<UserTeamDetailsBean> userTeamDetails) {
            UserTeamDetails = userTeamDetails;
        }

        public String getMatchGUID() {
            return MatchGUID;
        }

        public void setMatchGUID(String matchGUID) {
            this.MatchGUID = matchGUID;
        }

        public StaticsBean getStatics() {
            return Statics;
        }

        public void setStatics(StaticsBean statics) {
            Statics = statics;
        }

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

        public String getIsJoined() {
            return IsJoined;
        }

        public void setIsJoined(String IsJoined) {
            this.IsJoined = IsJoined;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
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

        public String getTotalJoined() {
            return TotalJoined;
        }

        public void setTotalJoined(String TotalJoined) {
            this.TotalJoined = TotalJoined;
        }

        public String getUserInvitationCode() {
            return UserInvitationCode;
        }

        public void setUserInvitationCode(String UserInvitationCode) {
            this.UserInvitationCode = UserInvitationCode;
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

        public String getShowJoinedContest() {
            return ShowJoinedContest;
        }

        public void setShowJoinedContest(String ShowJoinedContest) {
            this.ShowJoinedContest = ShowJoinedContest;
        }

        public String getIsConfirm() {
            return IsConfirm;
        }

        public void setIsConfirm(String IsConfirm) {
            this.IsConfirm = IsConfirm;
        }

        public String getTotalAmountReceived() {
            return TotalAmountReceived;
        }

        public void setTotalAmountReceived(String TotalAmountReceived) {
            this.TotalAmountReceived = TotalAmountReceived;
        }

        public String getTotalWinningAmount() {
            return TotalWinningAmount;
        }

        public void setTotalWinningAmount(String TotalWinningAmount) {
            this.TotalWinningAmount = TotalWinningAmount;
        }
        public String getIsPrivacyNameDisplay() {
            return IsPrivacyNameDisplay;
        }

        public void setIsPrivacyNameDisplay(String isPrivacyNameDisplay) {
            IsPrivacyNameDisplay = isPrivacyNameDisplay;
        }

        public List<CustomizeWinningBean> getCustomizeWinning() {
            return CustomizeWinning;
        }

        public void setCustomizeWinning(List<CustomizeWinningBean> CustomizeWinning) {
            this.CustomizeWinning = CustomizeWinning;
        }

        public String getCashBonusContribution() {
            return CashBonusContribution;
        }

        public void setCashBonusContribution(String cashBonusContribution) {
            CashBonusContribution = cashBonusContribution;
        }

        public String getSmartPool() {
            return SmartPool;
        }

        public void setSmartPool(String smartPool) {
            SmartPool = smartPool;
        }

        public String getUnfilledWinningPercent() {
            return UnfilledWinningPercent;
        }

        public void setUnfilledWinningPercent(String unfilledWinningPercent) {
            UnfilledWinningPercent = unfilledWinningPercent;
        }

        public String getWinUpTo() {
            return winUpTo;
        }

        public void setWinUpTo(String winUpTo) {
            this.winUpTo = winUpTo;
        }

        public String getWinningRatio() {
            return WinningRatio;
        }

        public void setWinningRatio(String winningRatio) {
            WinningRatio = winningRatio;
        }

        public String getWinningType() {
            return WinningType;
        }

        public void setWinningType(String winningType) {
            WinningType = winningType;
        }

        public static class MatchScoreDetailsBean implements Serializable{
            /**
             * StatusLive : Live
             * StatusNote :
             * TeamScoreLocal : {"Name":"Perth Scorchers","ShortName":"PER","LogoURL":"","Scores":"92/3","Overs":"18.0"}
             * TeamScoreVisitor : {"Name":"Adelaide Strikers","ShortName":"ADS","LogoURL":"","Scores":"88/10","Overs":"17.2"}
             * MatchVenue : Perth Stadium, Perth, Australia
             * Result :
             * Toss : Perth Scorchers won the toss and chose to bowl first
             * ManOfTheMatchPlayer :
             * Innings : [{"Name":"Adelaide Strikers inning","ShortName":"ADS inn.","Scores":"88/10","Status":"","ScoresFull":"88/10 (17.2 ov)","BatsmanData":[{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Role":"WicketKeeper","Runs":11,"BallsFaced":26,"Fours":"","Sixes":"","HowOut":"runout Josh Inglis","IsPlaying":"No","StrikeRate":42.31},{"Name":"Jake Weatherald","PlayerIDLive":"jak_weatherald","Role":"Batsman","Runs":22,"BallsFaced":17,"Fours":3,"Sixes":1,"HowOut":"c AJ Tye b Jason Behrendorff","IsPlaying":"No","StrikeRate":129.41},{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c AJ Turner b Jason Behrendorff","IsPlaying":"No","StrikeRate":33.33},{"Name":"Matthew Short","PlayerIDLive":"m_short","Role":"AllRounder","Runs":1,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"bowled b Jhye Richardson","IsPlaying":"No","StrikeRate":16.67},{"Name":"JW Wells","PlayerIDLive":"j_wells","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c Josh Inglis b Nathan Coulter-Nile","IsPlaying":"No","StrikeRate":33.33},{"Name":"Jake Lehmann","PlayerIDLive":"j_lehmann","Role":"Batsman","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"c Jason Behrendorff b Jhye Richardson","IsPlaying":"No","StrikeRate":""},{"Name":"Michael Neser","PlayerIDLive":"m_neser","Role":"AllRounder","Runs":1,"BallsFaced":3,"Fours":"","Sixes":"","HowOut":"lbw b Jhye Richardson","IsPlaying":"No","StrikeRate":33.33},{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Role":"AllRounder","Runs":21,"BallsFaced":18,"Fours":3,"Sixes":"","HowOut":"c Nathan Coulter-Nile b AJ Tye","IsPlaying":"No","StrikeRate":116.67},{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Role":"Bowler","Runs":21,"BallsFaced":12,"Fours":2,"Sixes":2,"HowOut":"c Nathan Coulter-Nile b David Willey","IsPlaying":"No","StrikeRate":175},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Role":"Bowler","Runs":2,"BallsFaced":8,"Fours":"","Sixes":"","HowOut":"c M Klinger b AJ Tye","IsPlaying":"No","StrikeRate":25},{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Role":"Bowler","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""}],"BowlersData":[{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Overs":"1.0","Maidens":"","RunsConceded":7,"Wickets":"","NoBalls":"","Wides":"","Economy":7},{"Name":"Michael Neser","PlayerIDLive":"m_neser","Overs":"4.0","Maidens":"","RunsConceded":23,"Wickets":"","NoBalls":"","Wides":"","Economy":5.75},{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Overs":"2.0","Maidens":"","RunsConceded":16,"Wickets":1,"NoBalls":"","Wides":"","Economy":8},{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Overs":"4.0","Maidens":1,"RunsConceded":9,"Wickets":"","NoBalls":"","Wides":"","Economy":2.25},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Overs":"3.0","Maidens":"","RunsConceded":17,"Wickets":"","NoBalls":"","Wides":"","Economy":5.67},{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Overs":"4.0","Maidens":"","RunsConceded":18,"Wickets":1,"NoBalls":"","Wides":"","Economy":4.5}],"FielderData":[{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Catches":"","RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}],"AllPlayingData":{"ale_carey":{"batting":{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Role":"WicketKeeper","Runs":11,"BallsFaced":26,"Fours":"","Sixes":"","HowOut":"runout Josh Inglis","IsPlaying":"No","StrikeRate":42.31},"fielding":{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"jak_weatherald":{"batting":{"Name":"Jake Weatherald","PlayerIDLive":"jak_weatherald","Role":"Batsman","Runs":22,"BallsFaced":17,"Fours":3,"Sixes":1,"HowOut":"c AJ Tye b Jason Behrendorff","IsPlaying":"No","StrikeRate":129.41}},"c_ingram":{"batting":{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c AJ Turner b Jason Behrendorff","IsPlaying":"No","StrikeRate":33.33},"bowling":{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Overs":"1.0","Maidens":"","RunsConceded":7,"Wickets":"","NoBalls":"","Wides":"","Economy":7}},"m_short":{"batting":{"Name":"Matthew Short","PlayerIDLive":"m_short","Role":"AllRounder","Runs":1,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"bowled b Jhye Richardson","IsPlaying":"No","StrikeRate":16.67}},"j_wells":{"batting":{"Name":"JW Wells","PlayerIDLive":"j_wells","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c Josh Inglis b Nathan Coulter-Nile","IsPlaying":"No","StrikeRate":33.33}},"j_lehmann":{"batting":{"Name":"Jake Lehmann","PlayerIDLive":"j_lehmann","Role":"Batsman","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"c Jason Behrendorff b Jhye Richardson","IsPlaying":"No","StrikeRate":""}},"m_neser":{"batting":{"Name":"Michael Neser","PlayerIDLive":"m_neser","Role":"AllRounder","Runs":1,"BallsFaced":3,"Fours":"","Sixes":"","HowOut":"lbw b Jhye Richardson","IsPlaying":"No","StrikeRate":33.33},"bowling":{"Name":"Michael Neser","PlayerIDLive":"m_neser","Overs":"4.0","Maidens":"","RunsConceded":23,"Wickets":"","NoBalls":"","Wides":"","Economy":5.75}},"cam_valente":{"batting":{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Role":"AllRounder","Runs":21,"BallsFaced":18,"Fours":3,"Sixes":"","HowOut":"c Nathan Coulter-Nile b AJ Tye","IsPlaying":"No","StrikeRate":116.67},"bowling":{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Overs":"2.0","Maidens":"","RunsConceded":16,"Wickets":1,"NoBalls":"","Wides":"","Economy":8}},"ra_khan":{"batting":{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Role":"Bowler","Runs":21,"BallsFaced":12,"Fours":2,"Sixes":2,"HowOut":"c Nathan Coulter-Nile b David Willey","IsPlaying":"No","StrikeRate":175},"bowling":{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Overs":"4.0","Maidens":1,"RunsConceded":9,"Wickets":"","NoBalls":"","Wides":"","Economy":2.25}},"b_laughlin":{"batting":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Role":"Bowler","Runs":2,"BallsFaced":8,"Fours":"","Sixes":"","HowOut":"c M Klinger b AJ Tye","IsPlaying":"No","StrikeRate":25},"bowling":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Overs":"3.0","Maidens":"","RunsConceded":17,"Wickets":"","NoBalls":"","Wides":"","Economy":5.67},"fielding":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Catches":"","RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}},"b_stanlake":{"batting":{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Role":"Bowler","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},"bowling":{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Overs":"4.0","Maidens":"","RunsConceded":18,"Wickets":1,"NoBalls":"","Wides":"","Economy":4.5}}},"ExtraRuns":{"Byes":5,"LegByes":5,"Wides":3,"NoBalls":0}},{"Name":"Perth Scorchers inning","ShortName":"PER inn.","Scores":"92/3","Status":"","ScoresFull":"92/3 (18.0 ov)","BatsmanData":[{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Role":"WicketKeeper","Runs":22,"BallsFaced":21,"Fours":4,"Sixes":"","HowOut":"c Alex Carey b Billy Stanlake","IsPlaying":"No","StrikeRate":104.76},{"Name":"M Klinger","PlayerIDLive":"m_klinger","Role":"Batsman","Runs":2,"BallsFaced":7,"Fours":"","Sixes":"","HowOut":"runout Ben Laughlin","IsPlaying":"No","StrikeRate":28.57},{"Name":"William Bosisto","PlayerIDLive":"w_bosisto","Role":"Batsman","Runs":36,"BallsFaced":34,"Fours":3,"Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":105.88},{"Name":"AJ Turner","PlayerIDLive":"a_turner","Role":"Batsman","Runs":24,"BallsFaced":46,"Fours":2,"Sixes":"","HowOut":"bowled b Cameron Valente","IsPlaying":"No","StrikeRate":52.17},{"Name":"Hilton Cartwright","PlayerIDLive":"h_cartwright","Role":"AllRounder","Runs":1,"BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":100}],"BowlersData":[{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Overs":"4.0","Maidens":"","RunsConceded":16,"Wickets":2,"NoBalls":"","Wides":"","Economy":4},{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Overs":"4.0","Maidens":"","RunsConceded":33,"Wickets":1,"NoBalls":"","Wides":"","Economy":8.25},{"Name":"David Willey","PlayerIDLive":"d_willey","Overs":"4.0","Maidens":"","RunsConceded":21,"Wickets":1,"NoBalls":"","Wides":"","Economy":5.25},{"Name":"Jhye Richardson","PlayerIDLive":"j_richardson","Overs":"3.0","Maidens":1,"RunsConceded":7,"Wickets":3,"NoBalls":"","Wides":"","Economy":2.33},{"Name":"AJ Tye","PlayerIDLive":"a_tye","Overs":"2.2","Maidens":1,"RunsConceded":9,"Wickets":2,"NoBalls":"","Wides":"","Economy":3.86}],"FielderData":[{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Catches":1,"RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""},{"Name":"M Klinger","PlayerIDLive":"m_klinger","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"AJ Turner","PlayerIDLive":"a_turner","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Catches":2,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"AJ Tye","PlayerIDLive":"a_tye","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}],"AllPlayingData":{"jo_inglis":{"batting":{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Role":"WicketKeeper","Runs":22,"BallsFaced":21,"Fours":4,"Sixes":"","HowOut":"c Alex Carey b Billy Stanlake","IsPlaying":"No","StrikeRate":104.76},"fielding":{"Name":"Josh Inglis","PlayerIDLive":"jo_inglis","Catches":1,"RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}},"m_klinger":{"batting":{"Name":"M Klinger","PlayerIDLive":"m_klinger","Role":"Batsman","Runs":2,"BallsFaced":7,"Fours":"","Sixes":"","HowOut":"runout Ben Laughlin","IsPlaying":"No","StrikeRate":28.57},"fielding":{"Name":"M Klinger","PlayerIDLive":"m_klinger","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"w_bosisto":{"batting":{"Name":"William Bosisto","PlayerIDLive":"w_bosisto","Role":"Batsman","Runs":36,"BallsFaced":34,"Fours":3,"Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":105.88}},"a_turner":{"batting":{"Name":"AJ Turner","PlayerIDLive":"a_turner","Role":"Batsman","Runs":24,"BallsFaced":46,"Fours":2,"Sixes":"","HowOut":"bowled b Cameron Valente","IsPlaying":"No","StrikeRate":52.17},"fielding":{"Name":"AJ Turner","PlayerIDLive":"a_turner","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"h_cartwright":{"batting":{"Name":"Hilton Cartwright","PlayerIDLive":"h_cartwright","Role":"AllRounder","Runs":1,"BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":100}},"j_behrendorff":{"bowling":{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Overs":"4.0","Maidens":"","RunsConceded":16,"Wickets":2,"NoBalls":"","Wides":"","Economy":4},"fielding":{"Name":"Jason Behrendorff","PlayerIDLive":"j_behrendorff","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"c_nile":{"bowling":{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Overs":"4.0","Maidens":"","RunsConceded":33,"Wickets":1,"NoBalls":"","Wides":"","Economy":8.25},"fielding":{"Name":"Nathan Coulter-Nile","PlayerIDLive":"c_nile","Catches":2,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"d_willey":{"bowling":{"Name":"David Willey","PlayerIDLive":"d_willey","Overs":"4.0","Maidens":"","RunsConceded":21,"Wickets":1,"NoBalls":"","Wides":"","Economy":5.25}},"j_richardson":{"bowling":{"Name":"Jhye Richardson","PlayerIDLive":"j_richardson","Overs":"3.0","Maidens":1,"RunsConceded":7,"Wickets":3,"NoBalls":"","Wides":"","Economy":2.33}},"a_tye":{"bowling":{"Name":"AJ Tye","PlayerIDLive":"a_tye","Overs":"2.2","Maidens":1,"RunsConceded":9,"Wickets":2,"NoBalls":"","Wides":"","Economy":3.86},"fielding":{"Name":"AJ Tye","PlayerIDLive":"a_tye","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}}},"ExtraRuns":{"Byes":7,"LegByes":7,"Wides":4,"NoBalls":1}}]
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
            private List<InningsBean> Innings;

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

            public List<InningsBean> getInnings() {
                return Innings;
            }

            public void setInnings(List<InningsBean> Innings) {
                this.Innings = Innings;
            }

            public static class TeamScoreLocalBean {
                /**
                 * Name : Perth Scorchers
                 * ShortName : PER
                 * LogoURL :
                 * Scores : 92/3
                 * Overs : 18.0
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
                 * Name : Adelaide Strikers
                 * ShortName : ADS
                 * LogoURL :
                 * Scores : 88/10
                 * Overs : 17.2
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

            public static class InningsBean {
                /**
                 * Name : Adelaide Strikers inning
                 * ShortName : ADS inn.
                 * Scores : 88/10
                 * Status :
                 * ScoresFull : 88/10 (17.2 ov)
                 * BatsmanData : [{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Role":"WicketKeeper","Runs":11,"BallsFaced":26,"Fours":"","Sixes":"","HowOut":"runout Josh Inglis","IsPlaying":"No","StrikeRate":42.31},{"Name":"Jake Weatherald","PlayerIDLive":"jak_weatherald","Role":"Batsman","Runs":22,"BallsFaced":17,"Fours":3,"Sixes":1,"HowOut":"c AJ Tye b Jason Behrendorff","IsPlaying":"No","StrikeRate":129.41},{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c AJ Turner b Jason Behrendorff","IsPlaying":"No","StrikeRate":33.33},{"Name":"Matthew Short","PlayerIDLive":"m_short","Role":"AllRounder","Runs":1,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"bowled b Jhye Richardson","IsPlaying":"No","StrikeRate":16.67},{"Name":"JW Wells","PlayerIDLive":"j_wells","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c Josh Inglis b Nathan Coulter-Nile","IsPlaying":"No","StrikeRate":33.33},{"Name":"Jake Lehmann","PlayerIDLive":"j_lehmann","Role":"Batsman","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"c Jason Behrendorff b Jhye Richardson","IsPlaying":"No","StrikeRate":""},{"Name":"Michael Neser","PlayerIDLive":"m_neser","Role":"AllRounder","Runs":1,"BallsFaced":3,"Fours":"","Sixes":"","HowOut":"lbw b Jhye Richardson","IsPlaying":"No","StrikeRate":33.33},{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Role":"AllRounder","Runs":21,"BallsFaced":18,"Fours":3,"Sixes":"","HowOut":"c Nathan Coulter-Nile b AJ Tye","IsPlaying":"No","StrikeRate":116.67},{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Role":"Bowler","Runs":21,"BallsFaced":12,"Fours":2,"Sixes":2,"HowOut":"c Nathan Coulter-Nile b David Willey","IsPlaying":"No","StrikeRate":175},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Role":"Bowler","Runs":2,"BallsFaced":8,"Fours":"","Sixes":"","HowOut":"c M Klinger b AJ Tye","IsPlaying":"No","StrikeRate":25},{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Role":"Bowler","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""}]
                 * BowlersData : [{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Overs":"1.0","Maidens":"","RunsConceded":7,"Wickets":"","NoBalls":"","Wides":"","Economy":7},{"Name":"Michael Neser","PlayerIDLive":"m_neser","Overs":"4.0","Maidens":"","RunsConceded":23,"Wickets":"","NoBalls":"","Wides":"","Economy":5.75},{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Overs":"2.0","Maidens":"","RunsConceded":16,"Wickets":1,"NoBalls":"","Wides":"","Economy":8},{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Overs":"4.0","Maidens":1,"RunsConceded":9,"Wickets":"","NoBalls":"","Wides":"","Economy":2.25},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Overs":"3.0","Maidens":"","RunsConceded":17,"Wickets":"","NoBalls":"","Wides":"","Economy":5.67},{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Overs":"4.0","Maidens":"","RunsConceded":18,"Wickets":1,"NoBalls":"","Wides":"","Economy":4.5}]
                 * FielderData : [{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""},{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Catches":"","RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}]
                 * AllPlayingData : {"ale_carey":{"batting":{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Role":"WicketKeeper","Runs":11,"BallsFaced":26,"Fours":"","Sixes":"","HowOut":"runout Josh Inglis","IsPlaying":"No","StrikeRate":42.31},"fielding":{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}},"jak_weatherald":{"batting":{"Name":"Jake Weatherald","PlayerIDLive":"jak_weatherald","Role":"Batsman","Runs":22,"BallsFaced":17,"Fours":3,"Sixes":1,"HowOut":"c AJ Tye b Jason Behrendorff","IsPlaying":"No","StrikeRate":129.41}},"c_ingram":{"batting":{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c AJ Turner b Jason Behrendorff","IsPlaying":"No","StrikeRate":33.33},"bowling":{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Overs":"1.0","Maidens":"","RunsConceded":7,"Wickets":"","NoBalls":"","Wides":"","Economy":7}},"m_short":{"batting":{"Name":"Matthew Short","PlayerIDLive":"m_short","Role":"AllRounder","Runs":1,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"bowled b Jhye Richardson","IsPlaying":"No","StrikeRate":16.67}},"j_wells":{"batting":{"Name":"JW Wells","PlayerIDLive":"j_wells","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c Josh Inglis b Nathan Coulter-Nile","IsPlaying":"No","StrikeRate":33.33}},"j_lehmann":{"batting":{"Name":"Jake Lehmann","PlayerIDLive":"j_lehmann","Role":"Batsman","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"c Jason Behrendorff b Jhye Richardson","IsPlaying":"No","StrikeRate":""}},"m_neser":{"batting":{"Name":"Michael Neser","PlayerIDLive":"m_neser","Role":"AllRounder","Runs":1,"BallsFaced":3,"Fours":"","Sixes":"","HowOut":"lbw b Jhye Richardson","IsPlaying":"No","StrikeRate":33.33},"bowling":{"Name":"Michael Neser","PlayerIDLive":"m_neser","Overs":"4.0","Maidens":"","RunsConceded":23,"Wickets":"","NoBalls":"","Wides":"","Economy":5.75}},"cam_valente":{"batting":{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Role":"AllRounder","Runs":21,"BallsFaced":18,"Fours":3,"Sixes":"","HowOut":"c Nathan Coulter-Nile b AJ Tye","IsPlaying":"No","StrikeRate":116.67},"bowling":{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Overs":"2.0","Maidens":"","RunsConceded":16,"Wickets":1,"NoBalls":"","Wides":"","Economy":8}},"ra_khan":{"batting":{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Role":"Bowler","Runs":21,"BallsFaced":12,"Fours":2,"Sixes":2,"HowOut":"c Nathan Coulter-Nile b David Willey","IsPlaying":"No","StrikeRate":175},"bowling":{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Overs":"4.0","Maidens":1,"RunsConceded":9,"Wickets":"","NoBalls":"","Wides":"","Economy":2.25}},"b_laughlin":{"batting":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Role":"Bowler","Runs":2,"BallsFaced":8,"Fours":"","Sixes":"","HowOut":"c M Klinger b AJ Tye","IsPlaying":"No","StrikeRate":25},"bowling":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Overs":"3.0","Maidens":"","RunsConceded":17,"Wickets":"","NoBalls":"","Wides":"","Economy":5.67},"fielding":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Catches":"","RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}},"b_stanlake":{"batting":{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Role":"Bowler","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},"bowling":{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Overs":"4.0","Maidens":"","RunsConceded":18,"Wickets":1,"NoBalls":"","Wides":"","Economy":4.5}}}
                 * ExtraRuns : {"Byes":5,"LegByes":5,"Wides":3,"NoBalls":0}
                 */

                @SerializedName("Name")
                private String Name;
                @SerializedName("ShortName")
                private String ShortName;
                @SerializedName("Scores")
                private String Scores;
                @SerializedName("Status")
                private String Status;
                @SerializedName("ScoresFull")
                private String ScoresFull;
                @SerializedName("AllPlayingData")
                private AllPlayingDataBean AllPlayingData;
                @SerializedName("ExtraRuns")
                private ExtraRunsBean ExtraRuns;
                @SerializedName("BatsmanData")
                private List<BatsmanDataBean> BatsmanData;
                @SerializedName("BowlersData")
                private List<BowlersDataBean> BowlersData;
                @SerializedName("FielderData")
                private List<FielderDataBean> FielderData;

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

                public String getScores() {
                    return Scores;
                }

                public void setScores(String Scores) {
                    this.Scores = Scores;
                }

                public String getStatus() {
                    return Status;
                }

                public void setStatus(String Status) {
                    this.Status = Status;
                }

                public String getScoresFull() {
                    return ScoresFull;
                }

                public void setScoresFull(String ScoresFull) {
                    this.ScoresFull = ScoresFull;
                }

                public AllPlayingDataBean getAllPlayingData() {
                    return AllPlayingData;
                }

                public void setAllPlayingData(AllPlayingDataBean AllPlayingData) {
                    this.AllPlayingData = AllPlayingData;
                }

                public ExtraRunsBean getExtraRuns() {
                    return ExtraRuns;
                }

                public void setExtraRuns(ExtraRunsBean ExtraRuns) {
                    this.ExtraRuns = ExtraRuns;
                }

                public List<BatsmanDataBean> getBatsmanData() {
                    return BatsmanData;
                }

                public void setBatsmanData(List<BatsmanDataBean> BatsmanData) {
                    this.BatsmanData = BatsmanData;
                }

                public List<BowlersDataBean> getBowlersData() {
                    return BowlersData;
                }

                public void setBowlersData(List<BowlersDataBean> BowlersData) {
                    this.BowlersData = BowlersData;
                }

                public List<FielderDataBean> getFielderData() {
                    return FielderData;
                }

                public void setFielderData(List<FielderDataBean> FielderData) {
                    this.FielderData = FielderData;
                }

                public static class AllPlayingDataBean {
                    /**
                     * ale_carey : {"batting":{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Role":"WicketKeeper","Runs":11,"BallsFaced":26,"Fours":"","Sixes":"","HowOut":"runout Josh Inglis","IsPlaying":"No","StrikeRate":42.31},"fielding":{"Name":"Alex Carey","PlayerIDLive":"ale_carey","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}}
                     * jak_weatherald : {"batting":{"Name":"Jake Weatherald","PlayerIDLive":"jak_weatherald","Role":"Batsman","Runs":22,"BallsFaced":17,"Fours":3,"Sixes":1,"HowOut":"c AJ Tye b Jason Behrendorff","IsPlaying":"No","StrikeRate":129.41}}
                     * c_ingram : {"batting":{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c AJ Turner b Jason Behrendorff","IsPlaying":"No","StrikeRate":33.33},"bowling":{"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Overs":"1.0","Maidens":"","RunsConceded":7,"Wickets":"","NoBalls":"","Wides":"","Economy":7}}
                     * m_short : {"batting":{"Name":"Matthew Short","PlayerIDLive":"m_short","Role":"AllRounder","Runs":1,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"bowled b Jhye Richardson","IsPlaying":"No","StrikeRate":16.67}}
                     * j_wells : {"batting":{"Name":"JW Wells","PlayerIDLive":"j_wells","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c Josh Inglis b Nathan Coulter-Nile","IsPlaying":"No","StrikeRate":33.33}}
                     * j_lehmann : {"batting":{"Name":"Jake Lehmann","PlayerIDLive":"j_lehmann","Role":"Batsman","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"c Jason Behrendorff b Jhye Richardson","IsPlaying":"No","StrikeRate":""}}
                     * m_neser : {"batting":{"Name":"Michael Neser","PlayerIDLive":"m_neser","Role":"AllRounder","Runs":1,"BallsFaced":3,"Fours":"","Sixes":"","HowOut":"lbw b Jhye Richardson","IsPlaying":"No","StrikeRate":33.33},"bowling":{"Name":"Michael Neser","PlayerIDLive":"m_neser","Overs":"4.0","Maidens":"","RunsConceded":23,"Wickets":"","NoBalls":"","Wides":"","Economy":5.75}}
                     * cam_valente : {"batting":{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Role":"AllRounder","Runs":21,"BallsFaced":18,"Fours":3,"Sixes":"","HowOut":"c Nathan Coulter-Nile b AJ Tye","IsPlaying":"No","StrikeRate":116.67},"bowling":{"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Overs":"2.0","Maidens":"","RunsConceded":16,"Wickets":1,"NoBalls":"","Wides":"","Economy":8}}
                     * ra_khan : {"batting":{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Role":"Bowler","Runs":21,"BallsFaced":12,"Fours":2,"Sixes":2,"HowOut":"c Nathan Coulter-Nile b David Willey","IsPlaying":"No","StrikeRate":175},"bowling":{"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Overs":"4.0","Maidens":1,"RunsConceded":9,"Wickets":"","NoBalls":"","Wides":"","Economy":2.25}}
                     * b_laughlin : {"batting":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Role":"Bowler","Runs":2,"BallsFaced":8,"Fours":"","Sixes":"","HowOut":"c M Klinger b AJ Tye","IsPlaying":"No","StrikeRate":25},"bowling":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Overs":"3.0","Maidens":"","RunsConceded":17,"Wickets":"","NoBalls":"","Wides":"","Economy":5.67},"fielding":{"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Catches":"","RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}}
                     * b_stanlake : {"batting":{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Role":"Bowler","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""},"bowling":{"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Overs":"4.0","Maidens":"","RunsConceded":18,"Wickets":1,"NoBalls":"","Wides":"","Economy":4.5}}
                     */

                    @SerializedName("ale_carey")
                    private AleCareyBean aleCarey;
                    @SerializedName("jak_weatherald")
                    private JakWeatheraldBean jakWeatherald;
                    @SerializedName("c_ingram")
                    private CIngramBean cIngram;
                    @SerializedName("m_short")
                    private MShortBean mShort;
                    @SerializedName("j_wells")
                    private JWellsBean jWells;
                    @SerializedName("j_lehmann")
                    private JLehmannBean jLehmann;
                    @SerializedName("m_neser")
                    private MNeserBean mNeser;
                    @SerializedName("cam_valente")
                    private CamValenteBean camValente;
                    @SerializedName("ra_khan")
                    private RaKhanBean raKhan;
                    @SerializedName("b_laughlin")
                    private BLaughlinBean bLaughlin;
                    @SerializedName("b_stanlake")
                    private BStanlakeBean bStanlake;

                    public AleCareyBean getAleCarey() {
                        return aleCarey;
                    }

                    public void setAleCarey(AleCareyBean aleCarey) {
                        this.aleCarey = aleCarey;
                    }

                    public JakWeatheraldBean getJakWeatherald() {
                        return jakWeatherald;
                    }

                    public void setJakWeatherald(JakWeatheraldBean jakWeatherald) {
                        this.jakWeatherald = jakWeatherald;
                    }

                    public CIngramBean getCIngram() {
                        return cIngram;
                    }

                    public void setCIngram(CIngramBean cIngram) {
                        this.cIngram = cIngram;
                    }

                    public MShortBean getMShort() {
                        return mShort;
                    }

                    public void setMShort(MShortBean mShort) {
                        this.mShort = mShort;
                    }

                    public JWellsBean getJWells() {
                        return jWells;
                    }

                    public void setJWells(JWellsBean jWells) {
                        this.jWells = jWells;
                    }

                    public JLehmannBean getJLehmann() {
                        return jLehmann;
                    }

                    public void setJLehmann(JLehmannBean jLehmann) {
                        this.jLehmann = jLehmann;
                    }

                    public MNeserBean getMNeser() {
                        return mNeser;
                    }

                    public void setMNeser(MNeserBean mNeser) {
                        this.mNeser = mNeser;
                    }

                    public CamValenteBean getCamValente() {
                        return camValente;
                    }

                    public void setCamValente(CamValenteBean camValente) {
                        this.camValente = camValente;
                    }

                    public RaKhanBean getRaKhan() {
                        return raKhan;
                    }

                    public void setRaKhan(RaKhanBean raKhan) {
                        this.raKhan = raKhan;
                    }

                    public BLaughlinBean getBLaughlin() {
                        return bLaughlin;
                    }

                    public void setBLaughlin(BLaughlinBean bLaughlin) {
                        this.bLaughlin = bLaughlin;
                    }

                    public BStanlakeBean getBStanlake() {
                        return bStanlake;
                    }

                    public void setBStanlake(BStanlakeBean bStanlake) {
                        this.bStanlake = bStanlake;
                    }

                    public static class AleCareyBean {
                        /**
                         * batting : {"Name":"Alex Carey","PlayerIDLive":"ale_carey","Role":"WicketKeeper","Runs":11,"BallsFaced":26,"Fours":"","Sixes":"","HowOut":"runout Josh Inglis","IsPlaying":"No","StrikeRate":42.31}
                         * fielding : {"Name":"Alex Carey","PlayerIDLive":"ale_carey","Catches":1,"RunOutThrower":"","RunOutCatcher":"","RunOutDirectHit":"","Stumping":""}
                         */

                        @SerializedName("batting")
                        private BattingBean batting;
                        @SerializedName("fielding")
                        private FieldingBean fielding;

                        public BattingBean getBatting() {
                            return batting;
                        }

                        public void setBatting(BattingBean batting) {
                            this.batting = batting;
                        }

                        public FieldingBean getFielding() {
                            return fielding;
                        }

                        public void setFielding(FieldingBean fielding) {
                            this.fielding = fielding;
                        }

                        public static class BattingBean {
                            /**
                             * Name : Alex Carey
                             * PlayerIDLive : ale_carey
                             * Role : WicketKeeper
                             * Runs : 11
                             * BallsFaced : 26
                             * Fours :
                             * Sixes :
                             * HowOut : runout Josh Inglis
                             * IsPlaying : No
                             * StrikeRate : 42.31
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Role")
                            private String Role;
                            @SerializedName("Runs")
                            private int Runs;
                            @SerializedName("BallsFaced")
                            private int BallsFaced;
                            @SerializedName("Fours")
                            private String Fours;
                            @SerializedName("Sixes")
                            private String Sixes;
                            @SerializedName("HowOut")
                            private String HowOut;
                            @SerializedName("IsPlaying")
                            private String IsPlaying;
                            @SerializedName("StrikeRate")
                            private double StrikeRate;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getRole() {
                                return Role;
                            }

                            public void setRole(String Role) {
                                this.Role = Role;
                            }

                            public int getRuns() {
                                return Runs;
                            }

                            public void setRuns(int Runs) {
                                this.Runs = Runs;
                            }

                            public int getBallsFaced() {
                                return BallsFaced;
                            }

                            public void setBallsFaced(int BallsFaced) {
                                this.BallsFaced = BallsFaced;
                            }

                            public String getFours() {
                                return Fours;
                            }

                            public void setFours(String Fours) {
                                this.Fours = Fours;
                            }

                            public String getSixes() {
                                return Sixes;
                            }

                            public void setSixes(String Sixes) {
                                this.Sixes = Sixes;
                            }

                            public String getHowOut() {
                                return HowOut;
                            }

                            public void setHowOut(String HowOut) {
                                this.HowOut = HowOut;
                            }

                            public String getIsPlaying() {
                                return IsPlaying;
                            }

                            public void setIsPlaying(String IsPlaying) {
                                this.IsPlaying = IsPlaying;
                            }

                            public double getStrikeRate() {
                                return StrikeRate;
                            }

                            public void setStrikeRate(double StrikeRate) {
                                this.StrikeRate = StrikeRate;
                            }
                        }

                        public static class FieldingBean {
                            /**
                             * Name : Alex Carey
                             * PlayerIDLive : ale_carey
                             * Catches : 1
                             * RunOutThrower :
                             * RunOutCatcher :
                             * RunOutDirectHit :
                             * Stumping :
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Catches")
                            private int Catches;
                            @SerializedName("RunOutThrower")
                            private String RunOutThrower;
                            @SerializedName("RunOutCatcher")
                            private String RunOutCatcher;
                            @SerializedName("RunOutDirectHit")
                            private String RunOutDirectHit;
                            @SerializedName("Stumping")
                            private String Stumping;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public int getCatches() {
                                return Catches;
                            }

                            public void setCatches(int Catches) {
                                this.Catches = Catches;
                            }

                            public String getRunOutThrower() {
                                return RunOutThrower;
                            }

                            public void setRunOutThrower(String RunOutThrower) {
                                this.RunOutThrower = RunOutThrower;
                            }

                            public String getRunOutCatcher() {
                                return RunOutCatcher;
                            }

                            public void setRunOutCatcher(String RunOutCatcher) {
                                this.RunOutCatcher = RunOutCatcher;
                            }

                            public String getRunOutDirectHit() {
                                return RunOutDirectHit;
                            }

                            public void setRunOutDirectHit(String RunOutDirectHit) {
                                this.RunOutDirectHit = RunOutDirectHit;
                            }

                            public String getStumping() {
                                return Stumping;
                            }

                            public void setStumping(String Stumping) {
                                this.Stumping = Stumping;
                            }
                        }
                    }

                    public static class JakWeatheraldBean {
                        /**
                         * batting : {"Name":"Jake Weatherald","PlayerIDLive":"jak_weatherald","Role":"Batsman","Runs":22,"BallsFaced":17,"Fours":3,"Sixes":1,"HowOut":"c AJ Tye b Jason Behrendorff","IsPlaying":"No","StrikeRate":129.41}
                         */

                        @SerializedName("batting")
                        private BattingBeanX batting;

                        public BattingBeanX getBatting() {
                            return batting;
                        }

                        public void setBatting(BattingBeanX batting) {
                            this.batting = batting;
                        }

                        public static class BattingBeanX {
                            /**
                             * Name : Jake Weatherald
                             * PlayerIDLive : jak_weatherald
                             * Role : Batsman
                             * Runs : 22
                             * BallsFaced : 17
                             * Fours : 3
                             * Sixes : 1
                             * HowOut : c AJ Tye b Jason Behrendorff
                             * IsPlaying : No
                             * StrikeRate : 129.41
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Role")
                            private String Role;
                            @SerializedName("Runs")
                            private int Runs;
                            @SerializedName("BallsFaced")
                            private int BallsFaced;
                            @SerializedName("Fours")
                            private int Fours;
                            @SerializedName("Sixes")
                            private int Sixes;
                            @SerializedName("HowOut")
                            private String HowOut;
                            @SerializedName("IsPlaying")
                            private String IsPlaying;
                            @SerializedName("StrikeRate")
                            private double StrikeRate;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getRole() {
                                return Role;
                            }

                            public void setRole(String Role) {
                                this.Role = Role;
                            }

                            public int getRuns() {
                                return Runs;
                            }

                            public void setRuns(int Runs) {
                                this.Runs = Runs;
                            }

                            public int getBallsFaced() {
                                return BallsFaced;
                            }

                            public void setBallsFaced(int BallsFaced) {
                                this.BallsFaced = BallsFaced;
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

                            public String getHowOut() {
                                return HowOut;
                            }

                            public void setHowOut(String HowOut) {
                                this.HowOut = HowOut;
                            }

                            public String getIsPlaying() {
                                return IsPlaying;
                            }

                            public void setIsPlaying(String IsPlaying) {
                                this.IsPlaying = IsPlaying;
                            }

                            public double getStrikeRate() {
                                return StrikeRate;
                            }

                            public void setStrikeRate(double StrikeRate) {
                                this.StrikeRate = StrikeRate;
                            }
                        }
                    }

                    public static class CIngramBean {
                        /**
                         * batting : {"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c AJ Turner b Jason Behrendorff","IsPlaying":"No","StrikeRate":33.33}
                         * bowling : {"Name":"Colin Ingram","PlayerIDLive":"c_ingram","Overs":"1.0","Maidens":"","RunsConceded":7,"Wickets":"","NoBalls":"","Wides":"","Economy":7}
                         */

                        @SerializedName("batting")
                        private BattingBeanXX batting;
                        @SerializedName("bowling")
                        private BowlingBean bowling;

                        public BattingBeanXX getBatting() {
                            return batting;
                        }

                        public void setBatting(BattingBeanXX batting) {
                            this.batting = batting;
                        }

                        public BowlingBean getBowling() {
                            return bowling;
                        }

                        public void setBowling(BowlingBean bowling) {
                            this.bowling = bowling;
                        }

                        public static class BattingBeanXX {
                            /**
                             * Name : Colin Ingram
                             * PlayerIDLive : c_ingram
                             * Role : Batsman
                             * Runs : 2
                             * BallsFaced : 6
                             * Fours :
                             * Sixes :
                             * HowOut : c AJ Turner b Jason Behrendorff
                             * IsPlaying : No
                             * StrikeRate : 33.33
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Role")
                            private String Role;
                            @SerializedName("Runs")
                            private int Runs;
                            @SerializedName("BallsFaced")
                            private int BallsFaced;
                            @SerializedName("Fours")
                            private String Fours;
                            @SerializedName("Sixes")
                            private String Sixes;
                            @SerializedName("HowOut")
                            private String HowOut;
                            @SerializedName("IsPlaying")
                            private String IsPlaying;
                            @SerializedName("StrikeRate")
                            private double StrikeRate;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getRole() {
                                return Role;
                            }

                            public void setRole(String Role) {
                                this.Role = Role;
                            }

                            public int getRuns() {
                                return Runs;
                            }

                            public void setRuns(int Runs) {
                                this.Runs = Runs;
                            }

                            public int getBallsFaced() {
                                return BallsFaced;
                            }

                            public void setBallsFaced(int BallsFaced) {
                                this.BallsFaced = BallsFaced;
                            }

                            public String getFours() {
                                return Fours;
                            }

                            public void setFours(String Fours) {
                                this.Fours = Fours;
                            }

                            public String getSixes() {
                                return Sixes;
                            }

                            public void setSixes(String Sixes) {
                                this.Sixes = Sixes;
                            }

                            public String getHowOut() {
                                return HowOut;
                            }

                            public void setHowOut(String HowOut) {
                                this.HowOut = HowOut;
                            }

                            public String getIsPlaying() {
                                return IsPlaying;
                            }

                            public void setIsPlaying(String IsPlaying) {
                                this.IsPlaying = IsPlaying;
                            }

                            public double getStrikeRate() {
                                return StrikeRate;
                            }

                            public void setStrikeRate(double StrikeRate) {
                                this.StrikeRate = StrikeRate;
                            }
                        }

                        public static class BowlingBean {
                            /**
                             * Name : Colin Ingram
                             * PlayerIDLive : c_ingram
                             * Overs : 1.0
                             * Maidens :
                             * RunsConceded : 7
                             * Wickets :
                             * NoBalls :
                             * Wides :
                             * Economy : 7
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Overs")
                            private String Overs;
                            @SerializedName("Maidens")
                            private String Maidens;
                            @SerializedName("RunsConceded")
                            private int RunsConceded;
                            @SerializedName("Wickets")
                            private String Wickets;
                            @SerializedName("NoBalls")
                            private String NoBalls;
                            @SerializedName("Wides")
                            private String Wides;
                            @SerializedName("Economy")
                            private int Economy;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getOvers() {
                                return Overs;
                            }

                            public void setOvers(String Overs) {
                                this.Overs = Overs;
                            }

                            public String getMaidens() {
                                return Maidens;
                            }

                            public void setMaidens(String Maidens) {
                                this.Maidens = Maidens;
                            }

                            public int getRunsConceded() {
                                return RunsConceded;
                            }

                            public void setRunsConceded(int RunsConceded) {
                                this.RunsConceded = RunsConceded;
                            }

                            public String getWickets() {
                                return Wickets;
                            }

                            public void setWickets(String Wickets) {
                                this.Wickets = Wickets;
                            }

                            public String getNoBalls() {
                                return NoBalls;
                            }

                            public void setNoBalls(String NoBalls) {
                                this.NoBalls = NoBalls;
                            }

                            public String getWides() {
                                return Wides;
                            }

                            public void setWides(String Wides) {
                                this.Wides = Wides;
                            }

                            public int getEconomy() {
                                return Economy;
                            }

                            public void setEconomy(int Economy) {
                                this.Economy = Economy;
                            }
                        }
                    }

                    public static class MShortBean {
                        /**
                         * batting : {"Name":"Matthew Short","PlayerIDLive":"m_short","Role":"AllRounder","Runs":1,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"bowled b Jhye Richardson","IsPlaying":"No","StrikeRate":16.67}
                         */

                        @SerializedName("batting")
                        private BattingBeanXXX batting;

                        public BattingBeanXXX getBatting() {
                            return batting;
                        }

                        public void setBatting(BattingBeanXXX batting) {
                            this.batting = batting;
                        }

                        public static class BattingBeanXXX {
                            /**
                             * Name : Matthew Short
                             * PlayerIDLive : m_short
                             * Role : AllRounder
                             * Runs : 1
                             * BallsFaced : 6
                             * Fours :
                             * Sixes :
                             * HowOut : bowled b Jhye Richardson
                             * IsPlaying : No
                             * StrikeRate : 16.67
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Role")
                            private String Role;
                            @SerializedName("Runs")
                            private int Runs;
                            @SerializedName("BallsFaced")
                            private int BallsFaced;
                            @SerializedName("Fours")
                            private String Fours;
                            @SerializedName("Sixes")
                            private String Sixes;
                            @SerializedName("HowOut")
                            private String HowOut;
                            @SerializedName("IsPlaying")
                            private String IsPlaying;
                            @SerializedName("StrikeRate")
                            private double StrikeRate;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getRole() {
                                return Role;
                            }

                            public void setRole(String Role) {
                                this.Role = Role;
                            }

                            public int getRuns() {
                                return Runs;
                            }

                            public void setRuns(int Runs) {
                                this.Runs = Runs;
                            }

                            public int getBallsFaced() {
                                return BallsFaced;
                            }

                            public void setBallsFaced(int BallsFaced) {
                                this.BallsFaced = BallsFaced;
                            }

                            public String getFours() {
                                return Fours;
                            }

                            public void setFours(String Fours) {
                                this.Fours = Fours;
                            }

                            public String getSixes() {
                                return Sixes;
                            }

                            public void setSixes(String Sixes) {
                                this.Sixes = Sixes;
                            }

                            public String getHowOut() {
                                return HowOut;
                            }

                            public void setHowOut(String HowOut) {
                                this.HowOut = HowOut;
                            }

                            public String getIsPlaying() {
                                return IsPlaying;
                            }

                            public void setIsPlaying(String IsPlaying) {
                                this.IsPlaying = IsPlaying;
                            }

                            public double getStrikeRate() {
                                return StrikeRate;
                            }

                            public void setStrikeRate(double StrikeRate) {
                                this.StrikeRate = StrikeRate;
                            }
                        }
                    }

                    public static class JWellsBean {
                        /**
                         * batting : {"Name":"JW Wells","PlayerIDLive":"j_wells","Role":"Batsman","Runs":2,"BallsFaced":6,"Fours":"","Sixes":"","HowOut":"c Josh Inglis b Nathan Coulter-Nile","IsPlaying":"No","StrikeRate":33.33}
                         */

                        @SerializedName("batting")
                        private BattingBeanXXXX batting;

                        public BattingBeanXXXX getBatting() {
                            return batting;
                        }

                        public void setBatting(BattingBeanXXXX batting) {
                            this.batting = batting;
                        }

                        public static class BattingBeanXXXX {
                            /**
                             * Name : JW Wells
                             * PlayerIDLive : j_wells
                             * Role : Batsman
                             * Runs : 2
                             * BallsFaced : 6
                             * Fours :
                             * Sixes :
                             * HowOut : c Josh Inglis b Nathan Coulter-Nile
                             * IsPlaying : No
                             * StrikeRate : 33.33
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Role")
                            private String Role;
                            @SerializedName("Runs")
                            private int Runs;
                            @SerializedName("BallsFaced")
                            private int BallsFaced;
                            @SerializedName("Fours")
                            private String Fours;
                            @SerializedName("Sixes")
                            private String Sixes;
                            @SerializedName("HowOut")
                            private String HowOut;
                            @SerializedName("IsPlaying")
                            private String IsPlaying;
                            @SerializedName("StrikeRate")
                            private double StrikeRate;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getRole() {
                                return Role;
                            }

                            public void setRole(String Role) {
                                this.Role = Role;
                            }

                            public int getRuns() {
                                return Runs;
                            }

                            public void setRuns(int Runs) {
                                this.Runs = Runs;
                            }

                            public int getBallsFaced() {
                                return BallsFaced;
                            }

                            public void setBallsFaced(int BallsFaced) {
                                this.BallsFaced = BallsFaced;
                            }

                            public String getFours() {
                                return Fours;
                            }

                            public void setFours(String Fours) {
                                this.Fours = Fours;
                            }

                            public String getSixes() {
                                return Sixes;
                            }

                            public void setSixes(String Sixes) {
                                this.Sixes = Sixes;
                            }

                            public String getHowOut() {
                                return HowOut;
                            }

                            public void setHowOut(String HowOut) {
                                this.HowOut = HowOut;
                            }

                            public String getIsPlaying() {
                                return IsPlaying;
                            }

                            public void setIsPlaying(String IsPlaying) {
                                this.IsPlaying = IsPlaying;
                            }

                            public double getStrikeRate() {
                                return StrikeRate;
                            }

                            public void setStrikeRate(double StrikeRate) {
                                this.StrikeRate = StrikeRate;
                            }
                        }
                    }

                    public static class JLehmannBean {
                        /**
                         * batting : {"Name":"Jake Lehmann","PlayerIDLive":"j_lehmann","Role":"Batsman","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"c Jason Behrendorff b Jhye Richardson","IsPlaying":"No","StrikeRate":""}
                         */

                        @SerializedName("batting")
                        private BattingBeanXXXXX batting;

                        public BattingBeanXXXXX getBatting() {
                            return batting;
                        }

                        public void setBatting(BattingBeanXXXXX batting) {
                            this.batting = batting;
                        }

                        public static class BattingBeanXXXXX {
                            /**
                             * Name : Jake Lehmann
                             * PlayerIDLive : j_lehmann
                             * Role : Batsman
                             * Runs :
                             * BallsFaced : 1
                             * Fours :
                             * Sixes :
                             * HowOut : c Jason Behrendorff b Jhye Richardson
                             * IsPlaying : No
                             * StrikeRate :
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Role")
                            private String Role;
                            @SerializedName("Runs")
                            private String Runs;
                            @SerializedName("BallsFaced")
                            private int BallsFaced;
                            @SerializedName("Fours")
                            private String Fours;
                            @SerializedName("Sixes")
                            private String Sixes;
                            @SerializedName("HowOut")
                            private String HowOut;
                            @SerializedName("IsPlaying")
                            private String IsPlaying;
                            @SerializedName("StrikeRate")
                            private String StrikeRate;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getRole() {
                                return Role;
                            }

                            public void setRole(String Role) {
                                this.Role = Role;
                            }

                            public String getRuns() {
                                return Runs;
                            }

                            public void setRuns(String Runs) {
                                this.Runs = Runs;
                            }

                            public int getBallsFaced() {
                                return BallsFaced;
                            }

                            public void setBallsFaced(int BallsFaced) {
                                this.BallsFaced = BallsFaced;
                            }

                            public String getFours() {
                                return Fours;
                            }

                            public void setFours(String Fours) {
                                this.Fours = Fours;
                            }

                            public String getSixes() {
                                return Sixes;
                            }

                            public void setSixes(String Sixes) {
                                this.Sixes = Sixes;
                            }

                            public String getHowOut() {
                                return HowOut;
                            }

                            public void setHowOut(String HowOut) {
                                this.HowOut = HowOut;
                            }

                            public String getIsPlaying() {
                                return IsPlaying;
                            }

                            public void setIsPlaying(String IsPlaying) {
                                this.IsPlaying = IsPlaying;
                            }

                            public String getStrikeRate() {
                                return StrikeRate;
                            }

                            public void setStrikeRate(String StrikeRate) {
                                this.StrikeRate = StrikeRate;
                            }
                        }
                    }

                    public static class MNeserBean {
                        /**
                         * batting : {"Name":"Michael Neser","PlayerIDLive":"m_neser","Role":"AllRounder","Runs":1,"BallsFaced":3,"Fours":"","Sixes":"","HowOut":"lbw b Jhye Richardson","IsPlaying":"No","StrikeRate":33.33}
                         * bowling : {"Name":"Michael Neser","PlayerIDLive":"m_neser","Overs":"4.0","Maidens":"","RunsConceded":23,"Wickets":"","NoBalls":"","Wides":"","Economy":5.75}
                         */

                        @SerializedName("batting")
                        private BattingBeanXXXXXX batting;
                        @SerializedName("bowling")
                        private BowlingBeanX bowling;

                        public BattingBeanXXXXXX getBatting() {
                            return batting;
                        }

                        public void setBatting(BattingBeanXXXXXX batting) {
                            this.batting = batting;
                        }

                        public BowlingBeanX getBowling() {
                            return bowling;
                        }

                        public void setBowling(BowlingBeanX bowling) {
                            this.bowling = bowling;
                        }

                        public static class BattingBeanXXXXXX {
                            /**
                             * Name : Michael Neser
                             * PlayerIDLive : m_neser
                             * Role : AllRounder
                             * Runs : 1
                             * BallsFaced : 3
                             * Fours :
                             * Sixes :
                             * HowOut : lbw b Jhye Richardson
                             * IsPlaying : No
                             * StrikeRate : 33.33
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Role")
                            private String Role;
                            @SerializedName("Runs")
                            private int Runs;
                            @SerializedName("BallsFaced")
                            private int BallsFaced;
                            @SerializedName("Fours")
                            private String Fours;
                            @SerializedName("Sixes")
                            private String Sixes;
                            @SerializedName("HowOut")
                            private String HowOut;
                            @SerializedName("IsPlaying")
                            private String IsPlaying;
                            @SerializedName("StrikeRate")
                            private double StrikeRate;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getRole() {
                                return Role;
                            }

                            public void setRole(String Role) {
                                this.Role = Role;
                            }

                            public int getRuns() {
                                return Runs;
                            }

                            public void setRuns(int Runs) {
                                this.Runs = Runs;
                            }

                            public int getBallsFaced() {
                                return BallsFaced;
                            }

                            public void setBallsFaced(int BallsFaced) {
                                this.BallsFaced = BallsFaced;
                            }

                            public String getFours() {
                                return Fours;
                            }

                            public void setFours(String Fours) {
                                this.Fours = Fours;
                            }

                            public String getSixes() {
                                return Sixes;
                            }

                            public void setSixes(String Sixes) {
                                this.Sixes = Sixes;
                            }

                            public String getHowOut() {
                                return HowOut;
                            }

                            public void setHowOut(String HowOut) {
                                this.HowOut = HowOut;
                            }

                            public String getIsPlaying() {
                                return IsPlaying;
                            }

                            public void setIsPlaying(String IsPlaying) {
                                this.IsPlaying = IsPlaying;
                            }

                            public double getStrikeRate() {
                                return StrikeRate;
                            }

                            public void setStrikeRate(double StrikeRate) {
                                this.StrikeRate = StrikeRate;
                            }
                        }

                        public static class BowlingBeanX {
                            /**
                             * Name : Michael Neser
                             * PlayerIDLive : m_neser
                             * Overs : 4.0
                             * Maidens :
                             * RunsConceded : 23
                             * Wickets :
                             * NoBalls :
                             * Wides :
                             * Economy : 5.75
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Overs")
                            private String Overs;
                            @SerializedName("Maidens")
                            private String Maidens;
                            @SerializedName("RunsConceded")
                            private int RunsConceded;
                            @SerializedName("Wickets")
                            private String Wickets;
                            @SerializedName("NoBalls")
                            private String NoBalls;
                            @SerializedName("Wides")
                            private String Wides;
                            @SerializedName("Economy")
                            private double Economy;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getOvers() {
                                return Overs;
                            }

                            public void setOvers(String Overs) {
                                this.Overs = Overs;
                            }

                            public String getMaidens() {
                                return Maidens;
                            }

                            public void setMaidens(String Maidens) {
                                this.Maidens = Maidens;
                            }

                            public int getRunsConceded() {
                                return RunsConceded;
                            }

                            public void setRunsConceded(int RunsConceded) {
                                this.RunsConceded = RunsConceded;
                            }

                            public String getWickets() {
                                return Wickets;
                            }

                            public void setWickets(String Wickets) {
                                this.Wickets = Wickets;
                            }

                            public String getNoBalls() {
                                return NoBalls;
                            }

                            public void setNoBalls(String NoBalls) {
                                this.NoBalls = NoBalls;
                            }

                            public String getWides() {
                                return Wides;
                            }

                            public void setWides(String Wides) {
                                this.Wides = Wides;
                            }

                            public double getEconomy() {
                                return Economy;
                            }

                            public void setEconomy(double Economy) {
                                this.Economy = Economy;
                            }
                        }
                    }

                    public static class CamValenteBean {
                        /**
                         * batting : {"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Role":"AllRounder","Runs":21,"BallsFaced":18,"Fours":3,"Sixes":"","HowOut":"c Nathan Coulter-Nile b AJ Tye","IsPlaying":"No","StrikeRate":116.67}
                         * bowling : {"Name":"Cameron Valente","PlayerIDLive":"cam_valente","Overs":"2.0","Maidens":"","RunsConceded":16,"Wickets":1,"NoBalls":"","Wides":"","Economy":8}
                         */

                        @SerializedName("batting")
                        private BattingBeanXXXXXXX batting;
                        @SerializedName("bowling")
                        private BowlingBeanXX bowling;

                        public BattingBeanXXXXXXX getBatting() {
                            return batting;
                        }

                        public void setBatting(BattingBeanXXXXXXX batting) {
                            this.batting = batting;
                        }

                        public BowlingBeanXX getBowling() {
                            return bowling;
                        }

                        public void setBowling(BowlingBeanXX bowling) {
                            this.bowling = bowling;
                        }

                        public static class BattingBeanXXXXXXX {
                            /**
                             * Name : Cameron Valente
                             * PlayerIDLive : cam_valente
                             * Role : AllRounder
                             * Runs : 21
                             * BallsFaced : 18
                             * Fours : 3
                             * Sixes :
                             * HowOut : c Nathan Coulter-Nile b AJ Tye
                             * IsPlaying : No
                             * StrikeRate : 116.67
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Role")
                            private String Role;
                            @SerializedName("Runs")
                            private int Runs;
                            @SerializedName("BallsFaced")
                            private int BallsFaced;
                            @SerializedName("Fours")
                            private int Fours;
                            @SerializedName("Sixes")
                            private String Sixes;
                            @SerializedName("HowOut")
                            private String HowOut;
                            @SerializedName("IsPlaying")
                            private String IsPlaying;
                            @SerializedName("StrikeRate")
                            private double StrikeRate;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getRole() {
                                return Role;
                            }

                            public void setRole(String Role) {
                                this.Role = Role;
                            }

                            public int getRuns() {
                                return Runs;
                            }

                            public void setRuns(int Runs) {
                                this.Runs = Runs;
                            }

                            public int getBallsFaced() {
                                return BallsFaced;
                            }

                            public void setBallsFaced(int BallsFaced) {
                                this.BallsFaced = BallsFaced;
                            }

                            public int getFours() {
                                return Fours;
                            }

                            public void setFours(int Fours) {
                                this.Fours = Fours;
                            }

                            public String getSixes() {
                                return Sixes;
                            }

                            public void setSixes(String Sixes) {
                                this.Sixes = Sixes;
                            }

                            public String getHowOut() {
                                return HowOut;
                            }

                            public void setHowOut(String HowOut) {
                                this.HowOut = HowOut;
                            }

                            public String getIsPlaying() {
                                return IsPlaying;
                            }

                            public void setIsPlaying(String IsPlaying) {
                                this.IsPlaying = IsPlaying;
                            }

                            public double getStrikeRate() {
                                return StrikeRate;
                            }

                            public void setStrikeRate(double StrikeRate) {
                                this.StrikeRate = StrikeRate;
                            }
                        }

                        public static class BowlingBeanXX {
                            /**
                             * Name : Cameron Valente
                             * PlayerIDLive : cam_valente
                             * Overs : 2.0
                             * Maidens :
                             * RunsConceded : 16
                             * Wickets : 1
                             * NoBalls :
                             * Wides :
                             * Economy : 8
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Overs")
                            private String Overs;
                            @SerializedName("Maidens")
                            private String Maidens;
                            @SerializedName("RunsConceded")
                            private int RunsConceded;
                            @SerializedName("Wickets")
                            private int Wickets;
                            @SerializedName("NoBalls")
                            private String NoBalls;
                            @SerializedName("Wides")
                            private String Wides;
                            @SerializedName("Economy")
                            private int Economy;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getOvers() {
                                return Overs;
                            }

                            public void setOvers(String Overs) {
                                this.Overs = Overs;
                            }

                            public String getMaidens() {
                                return Maidens;
                            }

                            public void setMaidens(String Maidens) {
                                this.Maidens = Maidens;
                            }

                            public int getRunsConceded() {
                                return RunsConceded;
                            }

                            public void setRunsConceded(int RunsConceded) {
                                this.RunsConceded = RunsConceded;
                            }

                            public int getWickets() {
                                return Wickets;
                            }

                            public void setWickets(int Wickets) {
                                this.Wickets = Wickets;
                            }

                            public String getNoBalls() {
                                return NoBalls;
                            }

                            public void setNoBalls(String NoBalls) {
                                this.NoBalls = NoBalls;
                            }

                            public String getWides() {
                                return Wides;
                            }

                            public void setWides(String Wides) {
                                this.Wides = Wides;
                            }

                            public int getEconomy() {
                                return Economy;
                            }

                            public void setEconomy(int Economy) {
                                this.Economy = Economy;
                            }
                        }
                    }

                    public static class RaKhanBean {
                        /**
                         * batting : {"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Role":"Bowler","Runs":21,"BallsFaced":12,"Fours":2,"Sixes":2,"HowOut":"c Nathan Coulter-Nile b David Willey","IsPlaying":"No","StrikeRate":175}
                         * bowling : {"Name":"Rashid Khan","PlayerIDLive":"ra_khan","Overs":"4.0","Maidens":1,"RunsConceded":9,"Wickets":"","NoBalls":"","Wides":"","Economy":2.25}
                         */

                        @SerializedName("batting")
                        private BattingBeanXXXXXXXX batting;
                        @SerializedName("bowling")
                        private BowlingBeanXXX bowling;

                        public BattingBeanXXXXXXXX getBatting() {
                            return batting;
                        }

                        public void setBatting(BattingBeanXXXXXXXX batting) {
                            this.batting = batting;
                        }

                        public BowlingBeanXXX getBowling() {
                            return bowling;
                        }

                        public void setBowling(BowlingBeanXXX bowling) {
                            this.bowling = bowling;
                        }

                        public static class BattingBeanXXXXXXXX {
                            /**
                             * Name : Rashid Khan
                             * PlayerIDLive : ra_khan
                             * Role : Bowler
                             * Runs : 21
                             * BallsFaced : 12
                             * Fours : 2
                             * Sixes : 2
                             * HowOut : c Nathan Coulter-Nile b David Willey
                             * IsPlaying : No
                             * StrikeRate : 175
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Role")
                            private String Role;
                            @SerializedName("Runs")
                            private int Runs;
                            @SerializedName("BallsFaced")
                            private int BallsFaced;
                            @SerializedName("Fours")
                            private int Fours;
                            @SerializedName("Sixes")
                            private int Sixes;
                            @SerializedName("HowOut")
                            private String HowOut;
                            @SerializedName("IsPlaying")
                            private String IsPlaying;
                            @SerializedName("StrikeRate")
                            private int StrikeRate;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getRole() {
                                return Role;
                            }

                            public void setRole(String Role) {
                                this.Role = Role;
                            }

                            public int getRuns() {
                                return Runs;
                            }

                            public void setRuns(int Runs) {
                                this.Runs = Runs;
                            }

                            public int getBallsFaced() {
                                return BallsFaced;
                            }

                            public void setBallsFaced(int BallsFaced) {
                                this.BallsFaced = BallsFaced;
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

                            public String getHowOut() {
                                return HowOut;
                            }

                            public void setHowOut(String HowOut) {
                                this.HowOut = HowOut;
                            }

                            public String getIsPlaying() {
                                return IsPlaying;
                            }

                            public void setIsPlaying(String IsPlaying) {
                                this.IsPlaying = IsPlaying;
                            }

                            public int getStrikeRate() {
                                return StrikeRate;
                            }

                            public void setStrikeRate(int StrikeRate) {
                                this.StrikeRate = StrikeRate;
                            }
                        }

                        public static class BowlingBeanXXX {
                            /**
                             * Name : Rashid Khan
                             * PlayerIDLive : ra_khan
                             * Overs : 4.0
                             * Maidens : 1
                             * RunsConceded : 9
                             * Wickets :
                             * NoBalls :
                             * Wides :
                             * Economy : 2.25
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Overs")
                            private String Overs;
                            @SerializedName("Maidens")
                            private int Maidens;
                            @SerializedName("RunsConceded")
                            private int RunsConceded;
                            @SerializedName("Wickets")
                            private String Wickets;
                            @SerializedName("NoBalls")
                            private String NoBalls;
                            @SerializedName("Wides")
                            private String Wides;
                            @SerializedName("Economy")
                            private double Economy;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getOvers() {
                                return Overs;
                            }

                            public void setOvers(String Overs) {
                                this.Overs = Overs;
                            }

                            public int getMaidens() {
                                return Maidens;
                            }

                            public void setMaidens(int Maidens) {
                                this.Maidens = Maidens;
                            }

                            public int getRunsConceded() {
                                return RunsConceded;
                            }

                            public void setRunsConceded(int RunsConceded) {
                                this.RunsConceded = RunsConceded;
                            }

                            public String getWickets() {
                                return Wickets;
                            }

                            public void setWickets(String Wickets) {
                                this.Wickets = Wickets;
                            }

                            public String getNoBalls() {
                                return NoBalls;
                            }

                            public void setNoBalls(String NoBalls) {
                                this.NoBalls = NoBalls;
                            }

                            public String getWides() {
                                return Wides;
                            }

                            public void setWides(String Wides) {
                                this.Wides = Wides;
                            }

                            public double getEconomy() {
                                return Economy;
                            }

                            public void setEconomy(double Economy) {
                                this.Economy = Economy;
                            }
                        }
                    }

                    public static class BLaughlinBean {
                        /**
                         * batting : {"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Role":"Bowler","Runs":2,"BallsFaced":8,"Fours":"","Sixes":"","HowOut":"c M Klinger b AJ Tye","IsPlaying":"No","StrikeRate":25}
                         * bowling : {"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Overs":"3.0","Maidens":"","RunsConceded":17,"Wickets":"","NoBalls":"","Wides":"","Economy":5.67}
                         * fielding : {"Name":"Ben Laughlin","PlayerIDLive":"b_laughlin","Catches":"","RunOutThrower":1,"RunOutCatcher":1,"RunOutDirectHit":1,"Stumping":""}
                         */

                        @SerializedName("batting")
                        private BattingBeanXXXXXXXXX batting;
                        @SerializedName("bowling")
                        private BowlingBeanXXXX bowling;
                        @SerializedName("fielding")
                        private FieldingBeanX fielding;

                        public BattingBeanXXXXXXXXX getBatting() {
                            return batting;
                        }

                        public void setBatting(BattingBeanXXXXXXXXX batting) {
                            this.batting = batting;
                        }

                        public BowlingBeanXXXX getBowling() {
                            return bowling;
                        }

                        public void setBowling(BowlingBeanXXXX bowling) {
                            this.bowling = bowling;
                        }

                        public FieldingBeanX getFielding() {
                            return fielding;
                        }

                        public void setFielding(FieldingBeanX fielding) {
                            this.fielding = fielding;
                        }

                        public static class BattingBeanXXXXXXXXX {
                            /**
                             * Name : Ben Laughlin
                             * PlayerIDLive : b_laughlin
                             * Role : Bowler
                             * Runs : 2
                             * BallsFaced : 8
                             * Fours :
                             * Sixes :
                             * HowOut : c M Klinger b AJ Tye
                             * IsPlaying : No
                             * StrikeRate : 25
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Role")
                            private String Role;
                            @SerializedName("Runs")
                            private int Runs;
                            @SerializedName("BallsFaced")
                            private int BallsFaced;
                            @SerializedName("Fours")
                            private String Fours;
                            @SerializedName("Sixes")
                            private String Sixes;
                            @SerializedName("HowOut")
                            private String HowOut;
                            @SerializedName("IsPlaying")
                            private String IsPlaying;
                            @SerializedName("StrikeRate")
                            private int StrikeRate;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getRole() {
                                return Role;
                            }

                            public void setRole(String Role) {
                                this.Role = Role;
                            }

                            public int getRuns() {
                                return Runs;
                            }

                            public void setRuns(int Runs) {
                                this.Runs = Runs;
                            }

                            public int getBallsFaced() {
                                return BallsFaced;
                            }

                            public void setBallsFaced(int BallsFaced) {
                                this.BallsFaced = BallsFaced;
                            }

                            public String getFours() {
                                return Fours;
                            }

                            public void setFours(String Fours) {
                                this.Fours = Fours;
                            }

                            public String getSixes() {
                                return Sixes;
                            }

                            public void setSixes(String Sixes) {
                                this.Sixes = Sixes;
                            }

                            public String getHowOut() {
                                return HowOut;
                            }

                            public void setHowOut(String HowOut) {
                                this.HowOut = HowOut;
                            }

                            public String getIsPlaying() {
                                return IsPlaying;
                            }

                            public void setIsPlaying(String IsPlaying) {
                                this.IsPlaying = IsPlaying;
                            }

                            public int getStrikeRate() {
                                return StrikeRate;
                            }

                            public void setStrikeRate(int StrikeRate) {
                                this.StrikeRate = StrikeRate;
                            }
                        }

                        public static class BowlingBeanXXXX {
                            /**
                             * Name : Ben Laughlin
                             * PlayerIDLive : b_laughlin
                             * Overs : 3.0
                             * Maidens :
                             * RunsConceded : 17
                             * Wickets :
                             * NoBalls :
                             * Wides :
                             * Economy : 5.67
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Overs")
                            private String Overs;
                            @SerializedName("Maidens")
                            private String Maidens;
                            @SerializedName("RunsConceded")
                            private int RunsConceded;
                            @SerializedName("Wickets")
                            private String Wickets;
                            @SerializedName("NoBalls")
                            private String NoBalls;
                            @SerializedName("Wides")
                            private String Wides;
                            @SerializedName("Economy")
                            private double Economy;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getOvers() {
                                return Overs;
                            }

                            public void setOvers(String Overs) {
                                this.Overs = Overs;
                            }

                            public String getMaidens() {
                                return Maidens;
                            }

                            public void setMaidens(String Maidens) {
                                this.Maidens = Maidens;
                            }

                            public int getRunsConceded() {
                                return RunsConceded;
                            }

                            public void setRunsConceded(int RunsConceded) {
                                this.RunsConceded = RunsConceded;
                            }

                            public String getWickets() {
                                return Wickets;
                            }

                            public void setWickets(String Wickets) {
                                this.Wickets = Wickets;
                            }

                            public String getNoBalls() {
                                return NoBalls;
                            }

                            public void setNoBalls(String NoBalls) {
                                this.NoBalls = NoBalls;
                            }

                            public String getWides() {
                                return Wides;
                            }

                            public void setWides(String Wides) {
                                this.Wides = Wides;
                            }

                            public double getEconomy() {
                                return Economy;
                            }

                            public void setEconomy(double Economy) {
                                this.Economy = Economy;
                            }
                        }

                        public static class FieldingBeanX {
                            /**
                             * Name : Ben Laughlin
                             * PlayerIDLive : b_laughlin
                             * Catches :
                             * RunOutThrower : 1
                             * RunOutCatcher : 1
                             * RunOutDirectHit : 1
                             * Stumping :
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Catches")
                            private String Catches;
                            @SerializedName("RunOutThrower")
                            private int RunOutThrower;
                            @SerializedName("RunOutCatcher")
                            private int RunOutCatcher;
                            @SerializedName("RunOutDirectHit")
                            private int RunOutDirectHit;
                            @SerializedName("Stumping")
                            private String Stumping;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getCatches() {
                                return Catches;
                            }

                            public void setCatches(String Catches) {
                                this.Catches = Catches;
                            }

                            public int getRunOutThrower() {
                                return RunOutThrower;
                            }

                            public void setRunOutThrower(int RunOutThrower) {
                                this.RunOutThrower = RunOutThrower;
                            }

                            public int getRunOutCatcher() {
                                return RunOutCatcher;
                            }

                            public void setRunOutCatcher(int RunOutCatcher) {
                                this.RunOutCatcher = RunOutCatcher;
                            }

                            public int getRunOutDirectHit() {
                                return RunOutDirectHit;
                            }

                            public void setRunOutDirectHit(int RunOutDirectHit) {
                                this.RunOutDirectHit = RunOutDirectHit;
                            }

                            public String getStumping() {
                                return Stumping;
                            }

                            public void setStumping(String Stumping) {
                                this.Stumping = Stumping;
                            }
                        }
                    }

                    public static class BStanlakeBean {
                        /**
                         * batting : {"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Role":"Bowler","Runs":"","BallsFaced":1,"Fours":"","Sixes":"","HowOut":"","IsPlaying":"Yes","StrikeRate":""}
                         * bowling : {"Name":"Billy Stanlake","PlayerIDLive":"b_stanlake","Overs":"4.0","Maidens":"","RunsConceded":18,"Wickets":1,"NoBalls":"","Wides":"","Economy":4.5}
                         */

                        @SerializedName("batting")
                        private BattingBeanXXXXXXXXXX batting;
                        @SerializedName("bowling")
                        private BowlingBeanXXXXX bowling;

                        public BattingBeanXXXXXXXXXX getBatting() {
                            return batting;
                        }

                        public void setBatting(BattingBeanXXXXXXXXXX batting) {
                            this.batting = batting;
                        }

                        public BowlingBeanXXXXX getBowling() {
                            return bowling;
                        }

                        public void setBowling(BowlingBeanXXXXX bowling) {
                            this.bowling = bowling;
                        }

                        public static class BattingBeanXXXXXXXXXX {
                            /**
                             * Name : Billy Stanlake
                             * PlayerIDLive : b_stanlake
                             * Role : Bowler
                             * Runs :
                             * BallsFaced : 1
                             * Fours :
                             * Sixes :
                             * HowOut :
                             * IsPlaying : Yes
                             * StrikeRate :
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Role")
                            private String Role;
                            @SerializedName("Runs")
                            private String Runs;
                            @SerializedName("BallsFaced")
                            private int BallsFaced;
                            @SerializedName("Fours")
                            private String Fours;
                            @SerializedName("Sixes")
                            private String Sixes;
                            @SerializedName("HowOut")
                            private String HowOut;
                            @SerializedName("IsPlaying")
                            private String IsPlaying;
                            @SerializedName("StrikeRate")
                            private String StrikeRate;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getRole() {
                                return Role;
                            }

                            public void setRole(String Role) {
                                this.Role = Role;
                            }

                            public String getRuns() {
                                return Runs;
                            }

                            public void setRuns(String Runs) {
                                this.Runs = Runs;
                            }

                            public int getBallsFaced() {
                                return BallsFaced;
                            }

                            public void setBallsFaced(int BallsFaced) {
                                this.BallsFaced = BallsFaced;
                            }

                            public String getFours() {
                                return Fours;
                            }

                            public void setFours(String Fours) {
                                this.Fours = Fours;
                            }

                            public String getSixes() {
                                return Sixes;
                            }

                            public void setSixes(String Sixes) {
                                this.Sixes = Sixes;
                            }

                            public String getHowOut() {
                                return HowOut;
                            }

                            public void setHowOut(String HowOut) {
                                this.HowOut = HowOut;
                            }

                            public String getIsPlaying() {
                                return IsPlaying;
                            }

                            public void setIsPlaying(String IsPlaying) {
                                this.IsPlaying = IsPlaying;
                            }

                            public String getStrikeRate() {
                                return StrikeRate;
                            }

                            public void setStrikeRate(String StrikeRate) {
                                this.StrikeRate = StrikeRate;
                            }
                        }

                        public static class BowlingBeanXXXXX {
                            /**
                             * Name : Billy Stanlake
                             * PlayerIDLive : b_stanlake
                             * Overs : 4.0
                             * Maidens :
                             * RunsConceded : 18
                             * Wickets : 1
                             * NoBalls :
                             * Wides :
                             * Economy : 4.5
                             */

                            @SerializedName("Name")
                            private String Name;
                            @SerializedName("PlayerIDLive")
                            private String PlayerIDLive;
                            @SerializedName("Overs")
                            private String Overs;
                            @SerializedName("Maidens")
                            private String Maidens;
                            @SerializedName("RunsConceded")
                            private int RunsConceded;
                            @SerializedName("Wickets")
                            private int Wickets;
                            @SerializedName("NoBalls")
                            private String NoBalls;
                            @SerializedName("Wides")
                            private String Wides;
                            @SerializedName("Economy")
                            private double Economy;

                            public String getName() {
                                return Name;
                            }

                            public void setName(String Name) {
                                this.Name = Name;
                            }

                            public String getPlayerIDLive() {
                                return PlayerIDLive;
                            }

                            public void setPlayerIDLive(String PlayerIDLive) {
                                this.PlayerIDLive = PlayerIDLive;
                            }

                            public String getOvers() {
                                return Overs;
                            }

                            public void setOvers(String Overs) {
                                this.Overs = Overs;
                            }

                            public String getMaidens() {
                                return Maidens;
                            }

                            public void setMaidens(String Maidens) {
                                this.Maidens = Maidens;
                            }

                            public int getRunsConceded() {
                                return RunsConceded;
                            }

                            public void setRunsConceded(int RunsConceded) {
                                this.RunsConceded = RunsConceded;
                            }

                            public int getWickets() {
                                return Wickets;
                            }

                            public void setWickets(int Wickets) {
                                this.Wickets = Wickets;
                            }

                            public String getNoBalls() {
                                return NoBalls;
                            }

                            public void setNoBalls(String NoBalls) {
                                this.NoBalls = NoBalls;
                            }

                            public String getWides() {
                                return Wides;
                            }

                            public void setWides(String Wides) {
                                this.Wides = Wides;
                            }

                            public double getEconomy() {
                                return Economy;
                            }

                            public void setEconomy(double Economy) {
                                this.Economy = Economy;
                            }
                        }
                    }
                }

                public static class ExtraRunsBean {
                    /**
                     * Byes : 5
                     * LegByes : 5
                     * Wides : 3
                     * NoBalls : 0
                     */

                    @SerializedName("Byes")
                    private int Byes;
                    @SerializedName("LegByes")
                    private int LegByes;
                    @SerializedName("Wides")
                    private int Wides;
                    @SerializedName("NoBalls")
                    private int NoBalls;

                    public int getByes() {
                        return Byes;
                    }

                    public void setByes(int Byes) {
                        this.Byes = Byes;
                    }

                    public int getLegByes() {
                        return LegByes;
                    }

                    public void setLegByes(int LegByes) {
                        this.LegByes = LegByes;
                    }

                    public int getWides() {
                        return Wides;
                    }

                    public void setWides(int Wides) {
                        this.Wides = Wides;
                    }

                    public int getNoBalls() {
                        return NoBalls;
                    }

                    public void setNoBalls(int NoBalls) {
                        this.NoBalls = NoBalls;
                    }
                }

                public static class BatsmanDataBean {
                    /**
                     * Name : Alex Carey
                     * PlayerIDLive : ale_carey
                     * Role : WicketKeeper
                     * Runs : 11
                     * BallsFaced : 26
                     * Fours :
                     * Sixes :
                     * HowOut : runout Josh Inglis
                     * IsPlaying : No
                     * StrikeRate : 42.31
                     */

                    @SerializedName("Name")
                    private String Name;
                    @SerializedName("PlayerIDLive")
                    private String PlayerIDLive;
                    @SerializedName("Role")
                    private String Role;
                    @SerializedName("Runs")
                    private int Runs;
                    @SerializedName("BallsFaced")
                    private int BallsFaced;
                    @SerializedName("Fours")
                    private String Fours;
                    @SerializedName("Sixes")
                    private String Sixes;
                    @SerializedName("HowOut")
                    private String HowOut;
                    @SerializedName("IsPlaying")
                    private String IsPlaying;
                    @SerializedName("StrikeRate")
                    private double StrikeRate;

                    public String getName() {
                        return Name;
                    }

                    public void setName(String Name) {
                        this.Name = Name;
                    }

                    public String getPlayerIDLive() {
                        return PlayerIDLive;
                    }

                    public void setPlayerIDLive(String PlayerIDLive) {
                        this.PlayerIDLive = PlayerIDLive;
                    }

                    public String getRole() {
                        return Role;
                    }

                    public void setRole(String Role) {
                        this.Role = Role;
                    }

                    public int getRuns() {
                        return Runs;
                    }

                    public void setRuns(int Runs) {
                        this.Runs = Runs;
                    }

                    public int getBallsFaced() {
                        return BallsFaced;
                    }

                    public void setBallsFaced(int BallsFaced) {
                        this.BallsFaced = BallsFaced;
                    }

                    public String getFours() {
                        return Fours;
                    }

                    public void setFours(String Fours) {
                        this.Fours = Fours;
                    }

                    public String getSixes() {
                        return Sixes;
                    }

                    public void setSixes(String Sixes) {
                        this.Sixes = Sixes;
                    }

                    public String getHowOut() {
                        return HowOut;
                    }

                    public void setHowOut(String HowOut) {
                        this.HowOut = HowOut;
                    }

                    public String getIsPlaying() {
                        return IsPlaying;
                    }

                    public void setIsPlaying(String IsPlaying) {
                        this.IsPlaying = IsPlaying;
                    }

                    public double getStrikeRate() {
                        return StrikeRate;
                    }

                    public void setStrikeRate(double StrikeRate) {
                        this.StrikeRate = StrikeRate;
                    }
                }

                public static class BowlersDataBean {
                    /**
                     * Name : Colin Ingram
                     * PlayerIDLive : c_ingram
                     * Overs : 1.0
                     * Maidens :
                     * RunsConceded : 7
                     * Wickets :
                     * NoBalls :
                     * Wides :
                     * Economy : 7
                     */

                    @SerializedName("Name")
                    private String Name;
                    @SerializedName("PlayerIDLive")
                    private String PlayerIDLive;
                    @SerializedName("Overs")
                    private String Overs;
                    @SerializedName("Maidens")
                    private String Maidens;
                    @SerializedName("RunsConceded")
                    private int RunsConceded;
                    @SerializedName("Wickets")
                    private String Wickets;
                    @SerializedName("NoBalls")
                    private String NoBalls;
                    @SerializedName("Wides")
                    private String Wides;
                    @SerializedName("Economy")
                    private int Economy;

                    public String getName() {
                        return Name;
                    }

                    public void setName(String Name) {
                        this.Name = Name;
                    }

                    public String getPlayerIDLive() {
                        return PlayerIDLive;
                    }

                    public void setPlayerIDLive(String PlayerIDLive) {
                        this.PlayerIDLive = PlayerIDLive;
                    }

                    public String getOvers() {
                        return Overs;
                    }

                    public void setOvers(String Overs) {
                        this.Overs = Overs;
                    }

                    public String getMaidens() {
                        return Maidens;
                    }

                    public void setMaidens(String Maidens) {
                        this.Maidens = Maidens;
                    }

                    public int getRunsConceded() {
                        return RunsConceded;
                    }

                    public void setRunsConceded(int RunsConceded) {
                        this.RunsConceded = RunsConceded;
                    }

                    public String getWickets() {
                        return Wickets;
                    }

                    public void setWickets(String Wickets) {
                        this.Wickets = Wickets;
                    }

                    public String getNoBalls() {
                        return NoBalls;
                    }

                    public void setNoBalls(String NoBalls) {
                        this.NoBalls = NoBalls;
                    }

                    public String getWides() {
                        return Wides;
                    }

                    public void setWides(String Wides) {
                        this.Wides = Wides;
                    }

                    public int getEconomy() {
                        return Economy;
                    }

                    public void setEconomy(int Economy) {
                        this.Economy = Economy;
                    }
                }

                public static class FielderDataBean {
                    /**
                     * Name : Alex Carey
                     * PlayerIDLive : ale_carey
                     * Catches : 1
                     * RunOutThrower :
                     * RunOutCatcher :
                     * RunOutDirectHit :
                     * Stumping :
                     */

                    @SerializedName("Name")
                    private String Name;
                    @SerializedName("PlayerIDLive")
                    private String PlayerIDLive;
                    @SerializedName("Catches")
                    private int Catches;
                    @SerializedName("RunOutThrower")
                    private String RunOutThrower;
                    @SerializedName("RunOutCatcher")
                    private String RunOutCatcher;
                    @SerializedName("RunOutDirectHit")
                    private String RunOutDirectHit;
                    @SerializedName("Stumping")
                    private String Stumping;

                    public String getName() {
                        return Name;
                    }

                    public void setName(String Name) {
                        this.Name = Name;
                    }

                    public String getPlayerIDLive() {
                        return PlayerIDLive;
                    }

                    public void setPlayerIDLive(String PlayerIDLive) {
                        this.PlayerIDLive = PlayerIDLive;
                    }

                    public int getCatches() {
                        return Catches;
                    }

                    public void setCatches(int Catches) {
                        this.Catches = Catches;
                    }

                    public String getRunOutThrower() {
                        return RunOutThrower;
                    }

                    public void setRunOutThrower(String RunOutThrower) {
                        this.RunOutThrower = RunOutThrower;
                    }

                    public String getRunOutCatcher() {
                        return RunOutCatcher;
                    }

                    public void setRunOutCatcher(String RunOutCatcher) {
                        this.RunOutCatcher = RunOutCatcher;
                    }

                    public String getRunOutDirectHit() {
                        return RunOutDirectHit;
                    }

                    public void setRunOutDirectHit(String RunOutDirectHit) {
                        this.RunOutDirectHit = RunOutDirectHit;
                    }

                    public String getStumping() {
                        return Stumping;
                    }

                    public void setStumping(String Stumping) {
                        this.Stumping = Stumping;
                    }
                }
            }
        }

        public static class CustomizeWinningBean implements Serializable {
            /**
             * From : 1
             * To : 1
             * Percent : 100
             * WinningAmount : 5
             */

            @SerializedName("From")
            private int From;
            @SerializedName("To")
            private int To;
            @SerializedName("Percent")
            private String Percent;
            @SerializedName("WinningAmount")
            private String WinningAmount;

            @SerializedName("ProductUrl")
            private String ProductUrl;


            @SerializedName("ProductName")
            private String ProductName;

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

            public String getProductName() {
                return ProductName;
            }

            public void setProductName(String productName) {
                ProductName = productName;
            }

            public String getProductUrl() {
                return ProductUrl;
            }

            public void setProductUrl(String productUrl) {
                ProductUrl = productUrl;
            }
        }
        public static class StaticsBean  implements Serializable{
            /**
             * NormalContest : 0
             * ReverseContest : 0
             * JoinedContest : 0
             * TotalTeams : 0
             * H2HContests : 0
             */

            @SerializedName("NormalContest")
            private String NormalContest;
            @SerializedName("ReverseContest")
            private String ReverseContest;
            @SerializedName("JoinedContest")
            private String JoinedContest;
            @SerializedName("TotalTeams")
            private String TotalTeams;
            @SerializedName("H2HContests")
            private String H2HContests;

            public String getNormalContest() {
                return NormalContest;
            }

            public void setNormalContest(String NormalContest) {
                this.NormalContest = NormalContest;
            }

            public String getReverseContest() {
                return ReverseContest;
            }

            public void setReverseContest(String ReverseContest) {
                this.ReverseContest = ReverseContest;
            }

            public String getJoinedContest() {
                return JoinedContest;
            }

            public void setJoinedContest(String JoinedContest) {
                this.JoinedContest = JoinedContest;
            }

            public String getTotalTeams() {
                return TotalTeams;
            }

            public void setTotalTeams(String TotalTeams) {
                this.TotalTeams = TotalTeams;
            }

            public String getH2HContests() {
                return H2HContests;
            }

            public void setH2HContests(String H2HContests) {
                this.H2HContests = H2HContests;
            }
        }
        public static class UserTeamDetailsBean  implements Serializable{
            /**
             * UserTeamGUID : efc8556a-ac4a-6d7a-d7bf-ce04dceb4ee2
             * UserTeamName :  Team 1
             * UserTeamType : Normal
             * UserTeamID : 344413
             * TotalPoints : 0.00
             */

            @SerializedName("UserTeamGUID")
            private String UserTeamGUID;
            @SerializedName("UserTeamName")
            private String UserTeamName;
            @SerializedName("UserTeamType")
            private String UserTeamType;
            @SerializedName("UserTeamID")
            private String UserTeamID;
            @SerializedName("TotalPoints")
            private String TotalPoints;

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

            public String getUserTeamType() {
                return UserTeamType;
            }

            public void setUserTeamType(String UserTeamType) {
                this.UserTeamType = UserTeamType;
            }

            public String getUserTeamID() {
                return UserTeamID;
            }

            public void setUserTeamID(String UserTeamID) {
                this.UserTeamID = UserTeamID;
            }

            public String getTotalPoints() {
                return TotalPoints;
            }

            public void setTotalPoints(String TotalPoints) {
                this.TotalPoints = TotalPoints;
            }
        }
    }
}