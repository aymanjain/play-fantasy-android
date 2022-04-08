package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;
import com.mw.eleven11.utility.Constant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiweb on 5/3/18.
 */

public class ResponseMatchPlayers implements Serializable {


    /**
     * code : 200
     * response : [{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"23508","name":"Riki Wessels","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/23508.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"40618","name":"Imran Tahir","play_role":"BOWLER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/40618.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"41028","name":"Kamran Akmal","play_role":"WICKETKEEPER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/41028.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"41244","name":"Kashif Bhatti","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/41244.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"41434","name":"Mohammad Hafeez","play_role":"ALLROUNDER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/41434.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"42657","name":"Shoaib Malik","play_role":"BATSMAN","points":"10.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/42657.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"43265","name":"Sohail Tanvir","play_role":"BOWLER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/43265.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"43266","name":"Sohaib Maqsood","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/43266.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"43524","name":"Umar Gul","play_role":"BOWLER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/43524.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"43590","name":"Wahab Riaz","play_role":"BOWLER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/43590.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"50710","name":"Kumar Sangakkara","play_role":"WICKETKEEPER","points":"8.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/50710.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"51439","name":"Dwayne Bravo","play_role":"ALLROUNDER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/51439.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"51862","name":"Andre Fletcher","play_role":"WICKETKEEPER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/51862.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"53115","name":"Darren Sammy","play_role":"ALLROUNDER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/53115.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"53118","name":"Dwayne Smith","play_role":"ALLROUNDER","points":"7.50","player_pic":"http://avishkar.fantasy96.com/uploads/players/53118.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"56143","name":"Shakib Al Hasan","play_role":"ALLROUNDER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/56143.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"56194","name":"Tamim Iqbal","play_role":"BATSMAN","points":"8.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/56194.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"211855","name":"Liam Dawson","play_role":"BOWLER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/211855.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"230559","name":"Kieron Pollard","play_role":"ALLROUNDER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/230559.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"233514","name":"Thisara Perera","play_role":"ALLROUNDER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/233514.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"233901","name":"Shan Masood","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/233901.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"259410","name":"Ahmed Shehzad","play_role":"BATSMAN","points":"8.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/259410.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"259551","name":"Junaid Khan","play_role":"BOWLER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/259551.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"277472","name":"Darren Bravo","play_role":"BATSMAN","points":"9.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/277472.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"288617","name":"Ross Whiteley","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/288617.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"288992","name":"Chris Jordan","play_role":"BOWLER","points":"7.50","player_pic":"http://avishkar.fantasy96.com/uploads/players/288992.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"316318","name":"Khalid Usman","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"317248","name":"Saad Nasim","play_role":"ALLROUNDER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/317248.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"318788","name":"Haris Sohail","play_role":"BATSMAN","points":"9.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/318788.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"373538","name":"Sabbir Rahman","play_role":"BATSMAN","points":"8.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/373538.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"375126","name":"Hardus Viljoen","play_role":"BOWLER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/375126.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"384518","name":"Hammad Azam","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/384518.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"387141","name":"Zhang Yufei","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"387142","name":"Li Jian","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"389666","name":"Mohammad Abbas","play_role":"BOWLER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/389666.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"429122","name":"Umaid Asif","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"429981","name":"Mohammad Irfan","play_role":"BOWLER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/429981.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"448598","name":"Irfan Khan","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"598896","name":"Umar Siddiq","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/598896.jpg"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"604302","name":"Nicholas Pooran","play_role":"WICKETKEEPER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/604302.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"654261","name":"Mohammad Asghar","play_role":"BOWLER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/654261.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"681305","name":"Hasan Ali","play_role":"BOWLER","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/681305.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"716733","name":"Khushdil Shah","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"716779","name":"Mohammad Irfan","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"734315","name":"Mohammad Arif","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"922941","name":"Abdullah Shafique","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"922947","name":"Sameen Gul","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"},{"series_id":"3079","team_id":"4112","team":"Multan Sultans","player_id":"922967","name":"Saif Badar","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/uploads/players/922967.jpg"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"943241","name":"Taimoor Sultan","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"},{"series_id":"3079","team_id":"3876","team":"Peshawar Zalmi","player_id":"1123377","name":"Ibtisam Sheikh","play_role":"BATSMAN","points":"7.00","player_pic":"http://avishkar.fantasy96.com/backend_asset/player_icon/batsmen2.png"}]
     * status : 1
     * message : Players found successfully
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

    public static class ResponseBean implements Serializable {
        /**
         * series_id : 3079
         * team_id : 3876
         * team : Peshawar Zalmi
         * player_id : 23508
         * name : Riki Wessels
         * play_role : BATSMAN
         * points : 7.00
         * player_pic : http://avishkar.fantasy96.com/uploads/players/23508.jpg
         */

        @SerializedName("series_id")
        private String seriesId;
        @SerializedName("team_id")
        private String teamId;
        @SerializedName("team")
        private String team;
        @SerializedName("player_id")
        private String playerId;
        @SerializedName("name")
        private String name;
        @SerializedName("play_role")
        private String playRole;
        @SerializedName("points")
        private String points;

        @SerializedName("total_points")
        private String total_points;

        @SerializedName("player_pic")
        private String playerPic;
        @SerializedName("is_captain")
        private int isCaptain;
        @SerializedName("is_vice_captain")
        private int isViceCaptain;

        @SerializedName("view_type")
        private int viewType = 0;


        @SerializedName("is_selected")
        private boolean isSelected = false;

        public String getTotal_points() {
            return total_points;
        }

        public void setTotal_points(String total_points) {
            this.total_points = total_points;
        }

        @SerializedName("position")

        private String position = Constant.POSITION_PLAYER;


        public boolean isSelected() {
            return isSelected;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public int getViewType() {
            return viewType;
        }

        public void setViewType(int viewType) {
            this.viewType = viewType;
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

        public int getIsCaptain() {
            return isCaptain;
        }

        public void setIsCaptain(int isCaptain) {
            this.isCaptain = isCaptain;
        }

        public int getIsViceCaptain() {
            return isViceCaptain;
        }

        public void setIsViceCaptain(int isViceCaptain) {
            this.isViceCaptain = isViceCaptain;
        }
    }
}
