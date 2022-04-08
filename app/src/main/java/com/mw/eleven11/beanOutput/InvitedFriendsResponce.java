package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InvitedFriendsResponce {

    /**
     * code : 200
     * status : 1
     * response : {"invited_friends":[{"user_id":"405","team_code":"SUHAI69481","bonus_amount":100,"received_amount":0,"user_image":"http://funtush11.com/funtush/backend_asset/images/default-148.png"},{"user_id":"406","team_code":"SUHAI57707","bonus_amount":100,"received_amount":0,"user_image":"http://funtush11.com/funtush/backend_asset/images/default-148.png"},{"user_id":"407","team_code":"SUHAI18957","bonus_amount":100,"received_amount":0,"user_image":"http://funtush11.com/funtush/backend_asset/images/default-148.png"}],"total_friends_joined":3,"total_bonus_amount":300,"total_received_amount":0,"earning_through_friends":0,"to_be_earned":300}
     * message : Data Found Successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("response")
    private ResponseBean response;
    @SerializedName("message")
    private String message;

    public static List<InvitedFriendsResponce> arrayInvitedFriendsResponceFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<InvitedFriendsResponce>>() {
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

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class ResponseBean {
        /**
         * invited_friends : [{"user_id":"405","team_code":"SUHAI69481","bonus_amount":100,"received_amount":0,"user_image":"http://funtush11.com/funtush/backend_asset/images/default-148.png"},{"user_id":"406","team_code":"SUHAI57707","bonus_amount":100,"received_amount":0,"user_image":"http://funtush11.com/funtush/backend_asset/images/default-148.png"},{"user_id":"407","team_code":"SUHAI18957","bonus_amount":100,"received_amount":0,"user_image":"http://funtush11.com/funtush/backend_asset/images/default-148.png"}]
         * total_friends_joined : 3
         * total_bonus_amount : 300
         * total_received_amount : 0
         * earning_through_friends : 0
         * to_be_earned : 300
         */

        @SerializedName("total_friends_joined")
        private int totalFriendsJoined;
        @SerializedName("total_bonus_amount")
        private int totalBonusAmount;
        @SerializedName("total_received_amount")
        private int totalReceivedAmount;
        @SerializedName("earning_through_friends")
        private int earningThroughFriends;
        @SerializedName("to_be_earned")
        private int toBeEarned;
        @SerializedName("invited_friends")
        private List<InvitedFriendsBean> invitedFriends;

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

        public int getTotalFriendsJoined() {
            return totalFriendsJoined;
        }

        public void setTotalFriendsJoined(int totalFriendsJoined) {
            this.totalFriendsJoined = totalFriendsJoined;
        }

        public int getTotalBonusAmount() {
            return totalBonusAmount;
        }

        public void setTotalBonusAmount(int totalBonusAmount) {
            this.totalBonusAmount = totalBonusAmount;
        }

        public int getTotalReceivedAmount() {
            return totalReceivedAmount;
        }

        public void setTotalReceivedAmount(int totalReceivedAmount) {
            this.totalReceivedAmount = totalReceivedAmount;
        }

        public int getEarningThroughFriends() {
            return earningThroughFriends;
        }

        public void setEarningThroughFriends(int earningThroughFriends) {
            this.earningThroughFriends = earningThroughFriends;
        }

        public int getToBeEarned() {
            return toBeEarned;
        }

        public void setToBeEarned(int toBeEarned) {
            this.toBeEarned = toBeEarned;
        }

        public List<InvitedFriendsBean> getInvitedFriends() {
            return invitedFriends;
        }

        public void setInvitedFriends(List<InvitedFriendsBean> invitedFriends) {
            this.invitedFriends = invitedFriends;
        }

        public static class InvitedFriendsBean {
            /**
             * user_id : 405
             * team_code : SUHAI69481
             * bonus_amount : 100
             * received_amount : 0
             * user_image : http://funtush11.com/funtush/backend_asset/images/default-148.png
             */

            @SerializedName("user_id")
            private String userId;
            @SerializedName("team_code")
            private String teamCode;
            @SerializedName("bonus_amount")
            private int bonusAmount;
            @SerializedName("received_amount")
            private int receivedAmount;
            @SerializedName("user_image")
            private String userImage;

            public static List<InvitedFriendsBean> arrayInvitedFriendsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<InvitedFriendsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getTeamCode() {
                return teamCode;
            }

            public void setTeamCode(String teamCode) {
                this.teamCode = teamCode;
            }

            public int getBonusAmount() {
                return bonusAmount;
            }

            public void setBonusAmount(int bonusAmount) {
                this.bonusAmount = bonusAmount;
            }

            public int getReceivedAmount() {
                return receivedAmount;
            }

            public void setReceivedAmount(int receivedAmount) {
                this.receivedAmount = receivedAmount;
            }

            public String getUserImage() {
                return userImage;
            }

            public void setUserImage(String userImage) {
                this.userImage = userImage;
            }
        }
    }
}
