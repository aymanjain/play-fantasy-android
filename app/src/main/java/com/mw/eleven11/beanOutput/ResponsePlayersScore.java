package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobiweb on 15/3/18.
 */

public class ResponsePlayersScore {


    /**
     * code : 200
     * response : {"name":"Team 1","team_id":"161","series_id":"3150","players":[{"player_id":"28235","position":"CAPTAIN","team_id":"2403","series_id":"3150","team":"IND","team_name":"India","name":"Shikhar Dhawan","play_role":"BATSMAN","points":"45.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/28235.jpg"},{"player_id":"300619","position":"PLAYER","team_id":"2404","series_id":"3150","team":"BAN","team_name":"Bangladesh","name":"Rubel Hossain","play_role":"BOWLER","points":"25.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/300619.jpg"},{"player_id":"330902","position":"PLAYER","team_id":"2404","series_id":"3150","team":"BAN","team_name":"Bangladesh","name":"Mustafizur Rahman","play_role":"BOWLER","points":"-1.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/330902.jpg"},{"player_id":"33335","position":"VICE_CAPTAIN","team_id":"2403","series_id":"3150","team":"IND","team_name":"India","name":"Suresh Raina","play_role":"BATSMAN","points":"65.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/33335.jpg"},{"player_id":"430246","position":"PLAYER","team_id":"2403","series_id":"3150","team":"IND","team_name":"India","name":"Yuzvendra Chahal","play_role":"BOWLER","points":"13.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/430246.jpg"},{"player_id":"477021","position":"PLAYER","team_id":"2403","series_id":"3150","team":"IND","team_name":"India","name":"Vijay Shankar","play_role":"ALLROUNDER","points":"1.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/477021.jpg"},{"player_id":"56194","position":"PLAYER","team_id":"2404","series_id":"3150","team":"BAN","team_name":"Bangladesh","name":"Tamim Iqbal","play_role":"BATSMAN","points":"36.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/56194.jpg"},{"player_id":"629063","position":"PLAYER","team_id":"2404","series_id":"3150","team":"BAN","team_name":"Bangladesh","name":"Mehidy Hasan","play_role":"ALLROUNDER","points":"5.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/629063.jpg"},{"player_id":"300619","position":"PLAYER","team_id":"2404","series_id":"3150","team":"BAN","team_name":"Bangladesh","name":"Rubel Hossain","play_role":"BOWLER","points":"3.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/300619.jpg"},{"player_id":"330902","position":"PLAYER","team_id":"2404","series_id":"3150","team":"BAN","team_name":"Bangladesh","name":"Mustafizur Rahman","play_role":"BOWLER","points":"31.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/330902.jpg"},{"player_id":"56194","position":"PLAYER","team_id":"2404","series_id":"3150","team":"BAN","team_name":"Bangladesh","name":"Tamim Iqbal","play_role":"BATSMAN","points":"73.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/56194.jpg"},{"player_id":"629063","position":"PLAYER","team_id":"2404","series_id":"3150","team":"BAN","team_name":"Bangladesh","name":"Mehidy Hasan","play_role":"ALLROUNDER","points":"11.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/629063.jpg"},{"player_id":"931581","position":"PLAYER","team_id":"2403","series_id":"3150","team":"IND","team_name":"India","name":"Rishabh Pant","play_role":"WICKETKEEPER","points":0,"player_pic":"http://avishkar.fantasy96.com/uploads/players/931581.jpg"},{"player_id":"497121","position":"PLAYER","team_id":"2403","series_id":"3150","team":"IND","team_name":"India","name":"Deepak Hooda","play_role":"ALLROUNDER","points":0,"player_pic":"http://avishkar.fantasy96.com/uploads/players/497121.jpg"},{"player_id":"410763","position":"PLAYER","team_id":"2404","series_id":"3150","team":"BAN","team_name":"Bangladesh","name":"Abu Jayed","play_role":"BOWLER","points":0,"player_pic":"http://avishkar.fantasy96.com/uploads/players/410763.jpg"}]}
     * status : 1
     * message : Team successfully found
     */

    @SerializedName("code")
    private int code;
    @SerializedName("response")
    private ResponseTeams.ResponseBean response;
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

    public ResponseTeams.ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseTeams.ResponseBean response) {
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

}
