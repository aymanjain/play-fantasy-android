package com.mw.eleven11.beanOutput;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiweb on 8/3/18.
 */

public class ResponseTeams {

    /**
     * code : 200
     * response : [{"name":"Team 1","user_team_id":"45","players":[{"player_id":"18632","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Samit Patel","play_role":"ALLROUNDER","player_pic":"http://avishkar.fantasy96.com/uploads/players/18632.jpg"},{"player_id":"37737","position":"PLAYER","team_id":"3875","series_id":"3079","team":"LQ","team_name":"Lahore Qalandars","name":"Brendon McCullum","play_role":"WICKETKEEPER","player_pic":"http://avishkar.fantasy96.com/uploads/players/37737.jpg"},{"player_id":"41378","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Misbah-ul-Haq","play_role":"BATSMAN","player_pic":"http://avishkar.fantasy96.com/uploads/players/41378.jpg"},{"player_id":"43685","position":"VICE_CAPTAIN","team_id":"3875","series_id":"3079","team":"LQ","team_name":"Lahore Qalandars","name":"Yasir Shah","play_role":"BOWLER","player_pic":"http://avishkar.fantasy96.com/uploads/players/43685.jpg"},{"player_id":"44932","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Jean-Paul Duminy","play_role":"ALLROUNDER","player_pic":"http://avishkar.fantasy96.com/uploads/players/44932.jpg"},{"player_id":"210283","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Steven Finn","play_role":"BOWLER","player_pic":"http://avishkar.fantasy96.com/uploads/players/210283.jpg"},{"player_id":"249866","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Alex Hales","play_role":"BATSMAN","player_pic":"http://avishkar.fantasy96.com/uploads/players/249866.jpg"},{"player_id":"317273","position":"PLAYER","team_id":"3875","series_id":"3079","team":"LQ","team_name":"Lahore Qalandars","name":"Umar Akmal","play_role":"BATSMAN","player_pic":"http://avishkar.fantasy96.com/uploads/players/317273.jpg"},{"player_id":"434429","position":"CAPTAIN","team_id":"3875","series_id":"3079","team":"LQ","team_name":"Lahore Qalandars","name":"Aamer Yamin","play_role":"ALLROUNDER","player_pic":"http://avishkar.fantasy96.com/uploads/players/434429.jpg"},{"player_id":"480603","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Iftikhar Ahmed","play_role":"BATSMAN","player_pic":"http://avishkar.fantasy96.com/uploads/players/480603.jpg"},{"player_id":"783423","position":"PLAYER","team_id":"3875","series_id":"3079","team":"LQ","team_name":"Lahore Qalandars","name":"Imran Khan","play_role":"BOWLER","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/bowler2.png"}]}]
     * status : 1
     * message : Team successfully found
     */

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("response")
    private List<ResponseBean> response = new ArrayList<>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public List<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseBean> response) {
        this.response = response;
    }

    public static class ResponseBean implements Cloneable {
        /**
         * name : Team 1
         * user_team_id : 45
         * players : [{"player_id":"18632","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Samit Patel","play_role":"ALLROUNDER","player_pic":"http://avishkar.fantasy96.com/uploads/players/18632.jpg"},{"player_id":"37737","position":"PLAYER","team_id":"3875","series_id":"3079","team":"LQ","team_name":"Lahore Qalandars","name":"Brendon McCullum","play_role":"WICKETKEEPER","player_pic":"http://avishkar.fantasy96.com/uploads/players/37737.jpg"},{"player_id":"41378","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Misbah-ul-Haq","play_role":"BATSMAN","player_pic":"http://avishkar.fantasy96.com/uploads/players/41378.jpg"},{"player_id":"43685","position":"VICE_CAPTAIN","team_id":"3875","series_id":"3079","team":"LQ","team_name":"Lahore Qalandars","name":"Yasir Shah","play_role":"BOWLER","player_pic":"http://avishkar.fantasy96.com/uploads/players/43685.jpg"},{"player_id":"44932","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Jean-Paul Duminy","play_role":"ALLROUNDER","player_pic":"http://avishkar.fantasy96.com/uploads/players/44932.jpg"},{"player_id":"210283","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Steven Finn","play_role":"BOWLER","player_pic":"http://avishkar.fantasy96.com/uploads/players/210283.jpg"},{"player_id":"249866","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Alex Hales","play_role":"BATSMAN","player_pic":"http://avishkar.fantasy96.com/uploads/players/249866.jpg"},{"player_id":"317273","position":"PLAYER","team_id":"3875","series_id":"3079","team":"LQ","team_name":"Lahore Qalandars","name":"Umar Akmal","play_role":"BATSMAN","player_pic":"http://avishkar.fantasy96.com/uploads/players/317273.jpg"},{"player_id":"434429","position":"CAPTAIN","team_id":"3875","series_id":"3079","team":"LQ","team_name":"Lahore Qalandars","name":"Aamer Yamin","play_role":"ALLROUNDER","player_pic":"http://avishkar.fantasy96.com/uploads/players/434429.jpg"},{"player_id":"480603","position":"PLAYER","team_id":"3872","series_id":"3079","team":"IU","team_name":"Islamabad United","name":"Iftikhar Ahmed","play_role":"BATSMAN","player_pic":"http://avishkar.fantasy96.com/uploads/players/480603.jpg"},{"player_id":"783423","position":"PLAYER","team_id":"3875","series_id":"3079","team":"LQ","team_name":"Lahore Qalandars","name":"Imran Khan","play_role":"BOWLER","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/bowler2.png"}]
         */
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @SerializedName("name")
        private String name;
        @SerializedName("is_user_joined_team")
        private int is_user_joined_team;

        @SerializedName("user_team_id")
        private String userTeamId = "";
        @SerializedName("series_id")
        private String seriesId;
        @SerializedName("team_id")
        private String teamId = "";
        @SerializedName("is_select")
        private boolean isSelect;

        public int getIs_user_joined_team() {
            return is_user_joined_team;
        }

        public void setIs_user_joined_team(int is_user_joined_team) {
            this.is_user_joined_team = is_user_joined_team;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        @SerializedName("players")
        private List<ResponseMatchPlayers.ResponseBean> players = new ArrayList<>();


        public int getIsUserJoinedTeam() {
            return is_user_joined_team;
        }

        public void setIsUserJoinedTeam(int is_user_joined_team) {
            this.is_user_joined_team = is_user_joined_team;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserTeamId() {
            if (TextUtils.isEmpty(userTeamId))
                return teamId;
            return userTeamId;
        }

        public void setUserTeamId(String userTeamId) {
            this.userTeamId = userTeamId;
        }

        public String getSeriesId() {
            return seriesId;
        }

        public void setSeriesId(String seriesId) {
            this.seriesId = seriesId;
        }

        public String getTeamId() {
            if (TextUtils.isEmpty(teamId))
                return userTeamId;
            return teamId;
        }

        public void setTeamId(String teamId) {
            this.teamId = teamId;
        }

        public List<ResponseMatchPlayers.ResponseBean> getPlayers() {
            return players;
        }

        public void setPlayers(List<ResponseMatchPlayers.ResponseBean> players) {
            this.players = players;
        }
    }
}
