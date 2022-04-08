package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResponseAvatarIcon {


    /**
     * code : 200
     * response : [{"id":"9","user_icon":"https://www.funtush11.com/funtush/uploads/users/1537529265_1473343763_builder.png","icon_key":"uploads/users/1537529265_1473343763_builder.png"},{"id":"8","user_icon":"https://www.funtush11.com/funtush/uploads/users/1537529160_1473073846_sheriff_thumb.png","icon_key":"uploads/users/1537529160_1473073846_sheriff_thumb.png"},{"id":"7","user_icon":"https://www.funtush11.com/funtush/uploads/users/1537529142_1473078418_captain.png","icon_key":"uploads/users/1537529142_1473078418_captain.png"},{"id":"6","user_icon":"https://www.funtush11.com/funtush/uploads/users/1537529123_file41_thumb.png","icon_key":"uploads/users/1537529123_file41_thumb.png"}]
     * status : 1
     * message : Records listed
     */

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("response")
    private List<ResponseBean> response;

    public static List<ResponseAvatarIcon> arrayResponseAvatarIconFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ResponseAvatarIcon>>() {
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
         * id : 9
         * user_icon : https://www.funtush11.com/funtush/uploads/users/1537529265_1473343763_builder.png
         * icon_key : uploads/users/1537529265_1473343763_builder.png
         */

        @SerializedName("id")
        private String id;
        @SerializedName("user_icon")
        private String userIcon;
        @SerializedName("icon_key")
        private String iconKey;

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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserIcon() {
            return userIcon;
        }

        public void setUserIcon(String userIcon) {
            this.userIcon = userIcon;
        }

        public String getIconKey() {
            return iconKey;
        }

        public void setIconKey(String iconKey) {
            this.iconKey = iconKey;
        }
    }
}
