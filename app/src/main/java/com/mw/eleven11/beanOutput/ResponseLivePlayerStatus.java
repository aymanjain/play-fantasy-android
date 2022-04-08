package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResponseLivePlayerStatus implements Serializable {


    /**
     * code : 200
     * response : [{"selected_by":"0.00","is_my_player":0,"player_name":"Praveen Dubey","player_id":"56322","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/bowler2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Nitin Bhille","player_id":"53775","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Abrar Kazi","player_id":"54543","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/bowler2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Rohan Kadam","player_id":"56338","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Dega Nischal","player_id":"56353","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Rithesh Bhatkal","player_id":"56360","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Sunil Kumar Jain","player_id":"56388","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":1,"player_name":"Rajat Hedge","player_id":"90960","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"IG Anil","player_id":"56401","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/bowler2.png"},{"selected_by":"66.67","is_my_player":0,"player_name":"Abhishek Sakuja","player_id":"53846","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/bowler2.png"},{"selected_by":"66.67","is_my_player":0,"player_name":"Devdutt Padikkal","player_id":"90968","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"66.67","is_my_player":0,"player_name":"Vinay Kumar","player_id":"606","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/bowler2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Abhinav Manohar","player_id":"56418","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"AM Kiran","player_id":"90213","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Mayank Agarwal","player_id":"617","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Chidhambaram Gautam","player_id":"618","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Sathish Bharadwaj","player_id":"90218","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"T Pradeep","player_id":"90221","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Swapnil Yelave","player_id":"90223","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"100","is_my_player":1,"player_name":"Codanda Ajit Karthik","player_id":"56433","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/play     er_icon/all_rounder2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Abhishek Reddy","player_id":"55156","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"66.67","is_my_player":0,"player_name":"GS Chiranjeevi","player_id":"90230","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"33.33","is_my_player":1,"player_name":"Rahul Naik","player_id":"48527","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"33.33","is_my_player":1,"player_name":"Ram Sarikh Yadav","player_id":"90259","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/bowler2.png"},{"selected_by":"33.33","is_my_player":1,"player_name":"Kranthi Kumar","player_id":"55717","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/bowler2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Rohit Sabharwal","player_id":"93899","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"MB Darshan","player_id":"93902","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Sujith Gowda","player_id":"93903","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Suraj Seshadri","player_id":"93905","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"S Shivaraj","player_id":"93906","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Mahesh Patel","player_id":"93909","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":1,"player_name":"Adithya Reddy","player_id":"93912","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Majid Makandar","player_id":"93913","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"0.00","is_my_player":0,"player_name":"Muttanna Nayak","player_id":"93914","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"66.67","is_my_player":0,"player_name":"SL Akshay","player_id":"56303","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/batsmen2.png"},{"selected_by":"66.67","is_my_player":0,"player_name":"Mohammed Taha","player_id":"56317","total_point":"2.00","player_pic":"http://funtush11.com/funtush/backend_asset/player_icon/bowler2.png"}]
     * status : 1
     * message : Match Players found successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("response")
    private List<ResponseBean> response;

    public static List<ResponseLivePlayerStatus> arrayResponseLivePlayerStatusFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ResponseLivePlayerStatus>>() {
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
         * selected_by : 0.00
         * is_my_player : 0
         * player_name : Praveen Dubey
         * player_id : 56322
         * total_point : 2.00
         * player_pic : http://funtush11.com/funtush/backend_asset/player_icon/bowler2.png
         */

        @SerializedName("selected_by")
        private String selectedBy;
        @SerializedName("is_my_player")
        private int isMyPlayer;

        @SerializedName("is_top_player")
        private int isTopPlayer;

        public int getIsTopPlayer() {
            return isTopPlayer;
        }

        public void setIsTopPlayer(int isTopPlayer) {
            this.isTopPlayer = isTopPlayer;
        }

        @SerializedName("player_name")
        private String playerName;
        @SerializedName("player_id")
        private String playerId;
        @SerializedName("total_point")
        private String totalPoint;
        @SerializedName("player_pic")
        private String playerPic;

        public static Comparator<ResponseBean> selectedByComparator = new Comparator<ResponseBean>() {
            @Override
            public int compare(ResponseBean jc1, ResponseBean jc2) {
                return (Float.valueOf(jc2.getSelectedBy()) < Float.valueOf(jc1.getSelectedBy()) ? -1 :
                        (Float.valueOf(jc2.getSelectedBy()) > Float.valueOf(jc1.getSelectedBy()) ? 1 : 0));
            }
        };
        public static Comparator<ResponseBean> totalPointComparator = new Comparator<ResponseBean>() {
            @Override
            public int compare(ResponseBean jc1, ResponseBean jc2) {
                return (Float.valueOf(jc2.getTotalPoint()) < Float.valueOf(jc1.getTotalPoint()) ? -1 :
                        (Float.valueOf(jc2.getTotalPoint()) > Float.valueOf(jc1.getTotalPoint()) ? 1 : 0));
            }
        };

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

        public String getSelectedBy() {
            return selectedBy;
        }

        public void setSelectedBy(String selectedBy) {
            this.selectedBy = selectedBy;
        }

        public int getIsMyPlayer() {
            return isMyPlayer;
        }

        public void setIsMyPlayer(int isMyPlayer) {
            this.isMyPlayer = isMyPlayer;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public String getPlayerId() {
            return playerId;
        }

        public void setPlayerId(String playerId) {
            this.playerId = playerId;
        }

        public String getTotalPoint() {
            return totalPoint;
        }

        public void setTotalPoint(String totalPoint) {
            this.totalPoint = totalPoint;
        }

        public String getPlayerPic() {
            return playerPic;
        }

        public void setPlayerPic(String playerPic) {
            this.playerPic = playerPic;
        }
    }
}
