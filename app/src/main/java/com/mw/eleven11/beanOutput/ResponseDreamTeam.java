package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiweb on 8/3/18.
 */

public class ResponseDreamTeam {


    /**
     * code : 200
     * response : {"players":[{"position":"CAPTAIN","series_id":"111251","team_id":"13","team":"PAK","team_name":"Pakistan","player_id":"43370","name":"Fakhar Zaman","play_role":"BATSMAN","points":"159.00","player_pic":"http://159.65.147.114/fantasy11/backend_asset/player_icon/batsmen2.png"},{"position":"VICE_CAPTAIN","series_id":"111251","team_id":"5","team":"AUS","team_name":"Australia","player_id":"84301","name":"D'Arcy Short","play_role":"BATSMAN","points":"121.00","player_pic":"http://159.65.147.114/fantasy11/backend_asset/player_icon/batsmen2.png"},{"position":"PLAYER","series_id":"111251","team_id":"13","team":"PAK","team_name":"Pakistan","player_id":"1758","name":"Mohammad Amir","play_role":"BOWLER","points":"100.00","player_pic":"http://159.65.147.114/fantasy11/backend_asset/player_icon/bowler2.png"},{"position":"PLAYER","series_id":"111251","team_id":"5","team":"AUS","team_name":"Australia","player_id":"73","name":"Aaron Finch","play_role":"BATSMAN","points":"75.00","player_pic":"http://159.65.147.114/fantasy11/backend_asset/player_icon/batsmen2.png"},{"position":"PLAYER","series_id":"111251","team_id":"13","team":"PAK","team_name":"Pakistan","player_id":"1167","name":"Shadab Khan","play_role":"ALLROUNDER","points":"70.00","player_pic":"http://159.65.147.114/fantasy11/backend_asset/player_icon/all_rounder2.png"},{"position":"PLAYER","series_id":"111251","team_id":"13","team":"PAK","team_name":"Pakistan","player_id":"1754","name":"Shoaib Malik","play_role":"BATSMAN","points":"68.00","player_pic":"http://159.65.147.114/fantasy11/backend_asset/player_icon/batsmen2.png"},{"position":"PLAYER","series_id":"111251","team_id":"5","team":"AUS","team_name":"Australia","player_id":"43631","name":"Jhye Richardson","play_role":"BATSMAN","points":"52.00","player_pic":"http://159.65.147.114/fantasy11/backend_asset/player_icon/batsmen2.png"},{"position":"PLAYER","series_id":"111251","team_id":"13","team":"PAK","team_name":"Pakistan","player_id":"44099","name":"Hasan Ali","play_role":"BOWLER","points":"35.00","player_pic":"http://159.65.147.114/fantasy11/backend_asset/player_icon/bowler2.png"},{"position":"PLAYER","series_id":"111251","team_id":"5","team":"AUS","team_name":"Australia","player_id":"81","name":"Glenn Maxwell","play_role":"ALLROUNDER","points":"35.00","player_pic":"http://159.65.147.114/fantasy11/backend_asset/player_icon/all_rounder2.png"},{"position":"PLAYER","series_id":"111251","team_id":"13","team":"PAK","team_name":"Pakistan","player_id":"442","name":"Sarfraz Ahmed","play_role":"WICKETKEEPER","points":"34.00","player_pic":"http://159.65.147.114/fantasy11/backend_asset/player_icon/keeper2.png"},{"position":"PLAYER","series_id":"111251","team_id":"13","team":"PAK","team_name":"Pakistan","player_id":"92991","name":"Shaheen Afridi","play_role":"BOWLER","points":"25.00","player_pic":"http://159.65.147.114/fantasy11/backend_asset/player_icon/bowler2.png"}]}
     * status : 1
     * message : Best players listed
     */

    @SerializedName("code")
    private int code;
    @SerializedName("response")
    private ResponseBean response;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public static List<ResponseDreamTeam> arrayResponseDreamTeamFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ResponseDreamTeam>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

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
        @SerializedName("players")
        private List<PlayersBean> players;

        public static List<ResponseBean> arrayResponseBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ResponseBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public List<PlayersBean> getPlayers() {
            return players;
        }

        public void setPlayers(List<PlayersBean> players) {
            this.players = players;
        }

        public static class PlayersBean {
            /**
             * position : CAPTAIN
             * series_id : 111251
             * team_id : 13
             * team : PAK
             * team_name : Pakistan
             * player_id : 43370
             * name : Fakhar Zaman
             * play_role : BATSMAN
             * points : 159.00
             * player_pic : http://159.65.147.114/fantasy11/backend_asset/player_icon/batsmen2.png
             */

            @SerializedName("position")
            private String position;
            @SerializedName("series_id")
            private String seriesId;
            @SerializedName("team_id")
            private String teamId;
            @SerializedName("team")
            private String team;
            @SerializedName("team_name")
            private String teamName;
            @SerializedName("player_id")
            private String playerId;
            @SerializedName("name")
            private String name;
            @SerializedName("play_role")
            private String playRole;
            @SerializedName("points")
            private String points;
            @SerializedName("player_pic")
            private String playerPic;

            public static List<PlayersBean> arrayPlayersBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<PlayersBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getSeriesId() {
                return seriesId;
            }

            public void setSeriesId(String seriesId) {
                this.seriesId = seriesId;
            }

            public String getTeamId() {
                return teamId;
            }

            public void setTeamId(String teamId) {
                this.teamId = teamId;
            }

            public String getTeam() {
                return team;
            }

            public void setTeam(String team) {
                this.team = team;
            }

            public String getTeamName() {
                return teamName;
            }

            public void setTeamName(String teamName) {
                this.teamName = teamName;
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

            public String getPlayRole() {
                return playRole;
            }

            public void setPlayRole(String playRole) {
                this.playRole = playRole;
            }

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }

            public String getPlayerPic() {
                return playerPic;
            }

            public void setPlayerPic(String playerPic) {
                this.playerPic = playerPic;
            }
        }
    }
}
