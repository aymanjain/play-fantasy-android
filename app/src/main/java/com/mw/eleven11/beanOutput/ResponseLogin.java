package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResponseLogin implements Serializable {

    /**
     * code : 200
     * status : 1
     * response : {"login_session_key":"e948fe62-fa5a-17fd-614b-a76da05fc863","username":"administrator","user_id":"1","name":"The","team_code":"ADMIN00777","email":"cricket@fantasy.com","mobile":"8962740611","gender":"MALE","date_of_birth":"1998-10-26","city":"Indore","state":"21","country":"101","address":"496 Dwarkapuri, Opp 60Feet Road","pin_code":"452010","sms_notification_status":"1","user_image":"http://159.65.147.114/fantasy11/uploads/users/1524058514_49091.png","contest_played":0,"contest_won":0,"mobile_verify":"0","email_verify":"0","pancard_verify":"1","account_verify":0,"aadhar_verify":0,"pan_card":{"id":"47","name":"abc","pan_number":"BMJPQ1245T","date_of_birth":"2002-06-10","pan_card_file":"http://159.65.147.114/fantasy11/uploads/users/1530872030_JPEG_20180706_1542286750218932791033635.jpg","status":"1","country_id":"101","state_id":"21","country_name":"India","state_name":"Madhya Pradesh"}}
     * message : success
     */

    private int code;
    private int status;
    private ResponseBean response;
    private String message;
    @SerializedName("team_id")
    private int teamId;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @SerializedName("file_url")

    private String fileUrl;

    public String getFileUrl() {
        return fileUrl;
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
         * name : Suhail
         * pancard_verify : 0
         * pin_code : 452002
         * state : 14
         * team_code : abc
         * user_id : 356
         * user_image : https://www.funtush11.com/funtush/backend_asset/images/default-148.png
         * user_invite_code : abc
         */

        @SerializedName("bank_account")
        @Expose
        private BankAccount bankAccount;

        public BankAccount getBankAccount() {
            return bankAccount;
        }

        public void setBankAccount(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
        }

        @SerializedName("pan_card")
        @Expose
        private PanCard panCard;

        public PanCard getPanCard() {
            return panCard;
        }

        public void setPanCard(PanCard panCard) {
            this.panCard = panCard;
        }

        @SerializedName("aadhar_verify")
        private int aadharVerify;
        @SerializedName("account_verify")
        private String accountVerify;
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
        private List<BeanTest.ResponseBean.FavoriteTeamsBean> favoriteTeams;
        @SerializedName("football_favorite_teams")
        private List<BeanTest.ResponseBean.FootballFavoriteTeamsBean> footballFavoriteTeams;

        public static List<BeanTest.ResponseBean> arrayResponseBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<BeanTest.ResponseBean>>() {
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

        public String getAccountVerify() {
            return accountVerify;
        }

        public void setAccountVerify(String accountVerify) {
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

        public List<BeanTest.ResponseBean.FavoriteTeamsBean> getFavoriteTeams() {
            return favoriteTeams;
        }

        public void setFavoriteTeams(List<BeanTest.ResponseBean.FavoriteTeamsBean> favoriteTeams) {
            this.favoriteTeams = favoriteTeams;
        }

        public List<BeanTest.ResponseBean.FootballFavoriteTeamsBean> getFootballFavoriteTeams() {
            return footballFavoriteTeams;
        }

        public void setFootballFavoriteTeams(List<BeanTest.ResponseBean.FootballFavoriteTeamsBean> footballFavoriteTeams) {
            this.footballFavoriteTeams = footballFavoriteTeams;
        }

        public static class FavoriteTeamsBean {
            /**
             * team_name : India
             */

            @SerializedName("team_name")
            private String teamName;

            public static List<BeanTest.ResponseBean.FavoriteTeamsBean> arrayFavoriteTeamsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<BeanTest.ResponseBean.FavoriteTeamsBean>>() {
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

            public static List<BeanTest.ResponseBean.FootballFavoriteTeamsBean> arrayFootballFavoriteTeamsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<BeanTest.ResponseBean.FootballFavoriteTeamsBean>>() {
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

    public class PanCard {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("pan_number")
        @Expose
        private String panNumber;
        @SerializedName("date_of_birth")
        @Expose
        private String dateOfBirth;
        @SerializedName("pan_card_file")
        @Expose
        private String panCardFile;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("country_id")
        @Expose
        private String countryId;
        @SerializedName("state_id")
        @Expose
        private String stateId;
        @SerializedName("country_name")
        @Expose
        private String countryName;
        @SerializedName("state_name")
        @Expose
        private String stateName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPanNumber() {
            return panNumber;
        }

        public void setPanNumber(String panNumber) {
            this.panNumber = panNumber;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getPanCardFile() {
            return panCardFile;
        }

        public void setPanCardFile(String panCardFile) {
            this.panCardFile = panCardFile;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public String getStateId() {
            return stateId;
        }

        public void setStateId(String stateId) {
            this.stateId = stateId;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }

    }

    public class BankAccount {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("account_number")
        @Expose
        private String accountNumber;
        @SerializedName("ifsc_code")
        @Expose
        private String ifscCode;
        @SerializedName("account_file")
        @Expose
        private String accountFile;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("bank_name")
        @Expose
        private String bankName;
        @SerializedName("branch_name")
        @Expose
        private String branchName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getIfscCode() {
            return ifscCode;
        }

        public void setIfscCode(String ifscCode) {
            this.ifscCode = ifscCode;
        }

        public String getAccountFile() {
            return accountFile;
        }

        public void setAccountFile(String accountFile) {
            this.accountFile = accountFile;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getBranchName() {
            return branchName;
        }

        public void setBranchName(String branchName) {
            this.branchName = branchName;
        }

    }


    public class Example {

        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("status")
        @Expose
        private Integer status;

        @SerializedName("message")
        @Expose
        private String message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }


        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
}
