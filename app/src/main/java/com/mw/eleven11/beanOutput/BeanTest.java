package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BeanTest {


    /**
     * code : 200
     * message : User registered successfully
     * response : {"aadhar_verify":0,"account_verify":0,"address":"LIG nagar","city":"indore","contest_played":0,"contest_won":0,"country":"101","date_of_birth":"1990-05-08","email":"abc@gmail.com","email_verify":"1","favorite_teams":[{"team_name":"India"},{"team_name":"Pakistan"}],"football_favorite_teams":[{"team_name":"Russia"},{"team_name":"Saudi Arabia"}],"gender":"MALE","is_team_name_changed":"1","login_session_key":"73180b0f-804a-7424-78a5-c8570ef9ff16","mobile":"","mobile_verify":"0","name":"abc","pancard_verify":"0","pin_code":"452002","state":"14","team_code":"Suhail","user_id":"356","user_image":"https://www.funtush11.com/funtush/backend_asset/images/default-148.png","user_invite_code":"Suhail"}
     * status : 1
     * team_id : 0
     */

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("response")
    private ResponseBean response;
    @SerializedName("status")
    private int status;
    @SerializedName("team_id")
    private int teamId;

    public static List<BeanTest> arrayBeanTestFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<BeanTest>>() {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public static class ResponseBean {
        /**
         * aadhar_verify : 0
         * account_verify : 0
         * address : LIG nagar
         * city : indore
         * contest_played : 0
         * contest_won : 0
         * country : 101
         * date_of_birth : 1990-05-08
         * email : abc@gmail.com
         * email_verify : 1
         * favorite_teams : [{"team_name":"India"},{"team_name":"Pakistan"}]
         * football_favorite_teams : [{"team_name":"Russia"},{"team_name":"Saudi Arabia"}]
         * gender : MALE
         * is_team_name_changed : 1
         * login_session_key : 73180b0f-804a-7424-78a5-c8570ef9ff16
         * mobile :
         * mobile_verify : 0
         * name : abc
         * pancard_verify : 0
         * pin_code : 452002
         * state : 14
         * team_code : ssss
         * user_id : 356
         * user_image : https://www.funtush11.com/funtush/backend_asset/images/default-148.png
         * user_invite_code : abc
         */

        @SerializedName("aadhar_verify")
        private int aadharVerify;
        @SerializedName("account_verify")
        private int accountVerify;
        @SerializedName("address")
        private String address;
        @SerializedName("city")
        private String city;
        @SerializedName("contest_played")
        private int contestPlayed;
        @SerializedName("contest_won")
        private int contestWon;
        @SerializedName("country")
        private String country;
        @SerializedName("date_of_birth")
        private String dateOfBirth;
        @SerializedName("email")
        private String email;
        @SerializedName("email_verify")
        private String emailVerify;
        @SerializedName("gender")
        private String gender;
        @SerializedName("is_team_name_changed")
        private String isTeamNameChanged;
        @SerializedName("login_session_key")
        private String loginSessionKey;
        @SerializedName("mobile")
        private String mobile;
        @SerializedName("mobile_verify")
        private String mobileVerify;
        @SerializedName("name")
        private String name;
        @SerializedName("pancard_verify")
        private String pancardVerify;
        @SerializedName("pin_code")
        private String pinCode;
        @SerializedName("state")
        private String state;
        @SerializedName("team_code")
        private String teamCode;
        @SerializedName("user_id")
        private String userId;
        @SerializedName("user_image")
        private String userImage;
        @SerializedName("user_invite_code")
        private String userInviteCode;
        @SerializedName("favorite_teams")
        private List<FavoriteTeamsBean> favoriteTeams;
        @SerializedName("football_favorite_teams")
        private List<FootballFavoriteTeamsBean> footballFavoriteTeams;

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

        public int getAadharVerify() {
            return aadharVerify;
        }

        public void setAadharVerify(int aadharVerify) {
            this.aadharVerify = aadharVerify;
        }

        public int getAccountVerify() {
            return accountVerify;
        }

        public void setAccountVerify(int accountVerify) {
            this.accountVerify = accountVerify;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getContestPlayed() {
            return contestPlayed;
        }

        public void setContestPlayed(int contestPlayed) {
            this.contestPlayed = contestPlayed;
        }

        public int getContestWon() {
            return contestWon;
        }

        public void setContestWon(int contestWon) {
            this.contestWon = contestWon;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmailVerify() {
            return emailVerify;
        }

        public void setEmailVerify(String emailVerify) {
            this.emailVerify = emailVerify;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getIsTeamNameChanged() {
            return isTeamNameChanged;
        }

        public void setIsTeamNameChanged(String isTeamNameChanged) {
            this.isTeamNameChanged = isTeamNameChanged;
        }

        public String getLoginSessionKey() {
            return loginSessionKey;
        }

        public void setLoginSessionKey(String loginSessionKey) {
            this.loginSessionKey = loginSessionKey;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getMobileVerify() {
            return mobileVerify;
        }

        public void setMobileVerify(String mobileVerify) {
            this.mobileVerify = mobileVerify;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPancardVerify() {
            return pancardVerify;
        }

        public void setPancardVerify(String pancardVerify) {
            this.pancardVerify = pancardVerify;
        }

        public String getPinCode() {
            return pinCode;
        }

        public void setPinCode(String pinCode) {
            this.pinCode = pinCode;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTeamCode() {
            return teamCode;
        }

        public void setTeamCode(String teamCode) {
            this.teamCode = teamCode;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getUserInviteCode() {
            return userInviteCode;
        }

        public void setUserInviteCode(String userInviteCode) {
            this.userInviteCode = userInviteCode;
        }

        public List<FavoriteTeamsBean> getFavoriteTeams() {
            return favoriteTeams;
        }

        public void setFavoriteTeams(List<FavoriteTeamsBean> favoriteTeams) {
            this.favoriteTeams = favoriteTeams;
        }

        public List<FootballFavoriteTeamsBean> getFootballFavoriteTeams() {
            return footballFavoriteTeams;
        }

        public void setFootballFavoriteTeams(List<FootballFavoriteTeamsBean> footballFavoriteTeams) {
            this.footballFavoriteTeams = footballFavoriteTeams;
        }

        public static class FavoriteTeamsBean {
            /**
             * team_name : India
             */

            @SerializedName("team_name")
            private String teamName;

            public static List<FavoriteTeamsBean> arrayFavoriteTeamsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<FavoriteTeamsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getTeamName() {
                return teamName;
            }

            public void setTeamName(String teamName) {
                this.teamName = teamName;
            }
        }

        public static class FootballFavoriteTeamsBean {
            /**
             * team_name : Russia
             */

            @SerializedName("team_name")
            private String teamName;

            public static List<FootballFavoriteTeamsBean> arrayFootballFavoriteTeamsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<FootballFavoriteTeamsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getTeamName() {
                return teamName;
            }

            public void setTeamName(String teamName) {
                this.teamName = teamName;
            }
        }
    }
}