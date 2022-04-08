package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class LoginResponseOut implements Serializable {

     /*ResponseCode : 200
     Message : Success
     Data : {"UserGUID":"9dba4890-c9a5-154a-9e60-e33fb7cfde09","UserID":"18093","FullName":"Suhail kham","StatusID":"2","Rating":"0","UserTypeID":"2","UserTypeName":"User","FirstName":"Suhail kham","MiddleName":"","LastName":"","About":"","About1":"","About2":"","Email":"khan@yopmail.com","Username":"","Gender":"","BirthDate":"","Address":"","Address1":"","Postal":"","CountryCode":"","CountryName":"","CityName":"","StateName":"","PhoneNumber":"","Website":"","FacebookURL":"","TwitterURL":"","GoogleURL":"","InstagramURL":"","LinkedInURL":"","WhatsApp":"","ReferralCode":"EX3ulp","ProfilePic":"http://192.168.1.211/515-/api/uploads/profile/picture/default.jpg"}
     "WalletAmount": "0.00",
    "WinningAmount": "0.00",
    "CashBonus": "40.00",
    "TotalCash": "40.00"
     */

    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("Message")
    private String Message;
    @SerializedName("CaptchaEnable")
    private String CaptchaEnable;
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

    public String getCaptchaEnable() {
        return CaptchaEnable;
    }

    public void setCaptchaEnable(String captchaEnable) {
        CaptchaEnable = captchaEnable;
    }

    public static class DataBean implements Serializable {
        /**
         * UserGUID : 9dba4890-c9a5-154a-9e60-e33fb7cfde09
         * UserID : 18093
         * FullName : Suhail kham
         * StatusID : 2
         * Rating : 0
         * UserTypeID : 2
         * UserTypeName : User
         * FirstName : Suhail kham
         * MiddleName :
         * LastName :
         * About :
         * About1 :
         * About2 :
         * Email : khan@yopmail.com
         * Username :
         * Gender :
         * BirthDate :
         * Address :
         * Address1 :
         * Postal :
         * CountryCode :
         * CountryName :
         * CityName :
         * StateName :
         * PhoneNumber :
         * Website :
         * FacebookURL :
         * TwitterURL :
         * GoogleURL :
         * InstagramURL :
         * LinkedInURL :
         * WhatsApp :
         * ReferralCode : EX3ulp
         * ProfilePic : http://192.168.1.211/515-/api/uploads/profile/picture/default.jpg
         */

        @SerializedName("TotalUnread")
        private String TotalUnread;

        @SerializedName("IsPrivacyNameDisplay")
        private String IsPrivacyNameDisplay;

        public String getIsPrivacyNameDisplay() {
            return IsPrivacyNameDisplay;
        }

        public void setIsPrivacyNameDisplay(String isPrivacyNameDisplay) {
            IsPrivacyNameDisplay = isPrivacyNameDisplay;
        }

        @SerializedName("UserTeamGUID")
        private String UserTeamGUID;


        @SerializedName("CashbonusMessage")
        private String CashbonusMessage;
        @SerializedName("UserGUID")
        private String UserGUID;
        @SerializedName("UserID")
        private String UserID;
        @SerializedName("FullName")
        private String FullName;
        @SerializedName("StatusID")
        private String StatusID;
        @SerializedName("Rating")
        private String Rating;
        @SerializedName("UserTypeID")
        private String UserTypeID;
        @SerializedName("UserTypeName")
        private String UserTypeName;
        @SerializedName("FirstName")
        private String FirstName;
        @SerializedName("MiddleName")
        private String MiddleName;
        @SerializedName("LastName")
        private String LastName;
        @SerializedName("About")
        private String About;
        @SerializedName("About1")
        private String About1;
        @SerializedName("About2")
        private String About2;
        @SerializedName("Email")
        private String Email;
        @SerializedName("Username")
        private String Username;
        @SerializedName("Gender")
        private String Gender;
        @SerializedName("BirthDate")
        private String BirthDate;
        @SerializedName("Address")
        private String Address;
        @SerializedName("Address1")
        private String Address1;
        @SerializedName("Postal")
        private String Postal;
        @SerializedName("CountryCode")
        private String CountryCode;
        @SerializedName("CountryName")
        private String CountryName;
        @SerializedName("CityName")
        private String CityName;
        @SerializedName("StateName")
        private String StateName;
        @SerializedName("PhoneNumber")
        private String PhoneNumber;
        @SerializedName("Website")
        private String Website;
        @SerializedName("FacebookURL")
        private String FacebookURL;
        @SerializedName("TwitterURL")
        private String TwitterURL;
        @SerializedName("GoogleURL")
        private String GoogleURL;
        @SerializedName("InstagramURL")
        private String InstagramURL;
        @SerializedName("LinkedInURL")
        private String LinkedInURL;
        @SerializedName("WhatsApp")
        private String WhatsApp;
        @SerializedName("ReferralCode")
        private String ReferralCode;
        @SerializedName("ProfilePic")
        private String ProfilePic;
        @SerializedName("SessionKey")
        private String SessionKey;

        @SerializedName("WalletAmount")
        private String WalletAmount;

        @SerializedName("WinningAmount")
        private String WinningAmount;

        @SerializedName("CashBonus")
        private String CashBonus;

        @SerializedName("TotalCash")
        private String TotalCash;

        @SerializedName("PanStatus")
        private String PanStatus;
        @SerializedName("BankStatus")
        private String BankStatus;

        @SerializedName("AadharStatus")
        private String AadharStatus;

        @SerializedName("PhoneStatus")
        private String PhoneStatus;
        @SerializedName("EmailStatus")
        private String EmailStatus;
        @SerializedName("MediaPAN")
        private MediaPANBean MediaPAN;
        @SerializedName("MediaBANK")
        private MediaBANKBean MediaBANK;


        @SerializedName("MediaAadhar")
        private MediaAadharBean MediaAadhar;

        @SerializedName("PlayingHistory")
        private PlayingHistoryBean PlayingHistory;

        @SerializedName("MyFavouriteTeams")
        private List<String> MyFavouriteTeams;

        public MediaAadharBean getMediaAadhar() {
            return MediaAadhar;
        }

        public void setMediaAadhar(MediaAadharBean mediaAadhar) {
            MediaAadhar = mediaAadhar;
        }

        public String getAadharStatus() {
            return AadharStatus;
        }

        public void setAadharStatus(String aadharStatus) {
            AadharStatus = aadharStatus;
        }

        public String getTotalUnread() {
            return TotalUnread;
        }

        public void setTotalUnread(String totalUnread) {
            TotalUnread = totalUnread;
        }

        public PlayingHistoryBean getPlayingHistory() {
            return PlayingHistory;
        }

        public void setPlayingHistory(PlayingHistoryBean playingHistory) {
            PlayingHistory = playingHistory;
        }

        public List<String> getMyFavouriteTeams() {
            return MyFavouriteTeams;
        }

        public void setMyFavouriteTeams(List<String> myFavouriteTeams) {
            MyFavouriteTeams = myFavouriteTeams;
        }

        public MediaPANBean getMediaPAN() {
            return MediaPAN;
        }

        public void setMediaPAN(MediaPANBean mediaPAN) {
            MediaPAN = mediaPAN;
        }

        public MediaBANKBean getMediaBANK() {
            return MediaBANK;
        }

        public void setMediaBANK(MediaBANKBean mediaBANK) {
            MediaBANK = mediaBANK;
        }

        public String getPanStatus() {
            return PanStatus;
        }

        public void setPanStatus(String panStatus) {
            PanStatus = panStatus;
        }

        public String getBankStatus() {
            return BankStatus;
        }

        public void setBankStatus(String bankStatus) {
            BankStatus = bankStatus;
        }

        public String getPhoneStatus() {
            return PhoneStatus;
        }

        public void setPhoneStatus(String phoneStatus) {
            PhoneStatus = phoneStatus;
        }

        public String getEmailStatus() {
            return EmailStatus;
        }

        public void setEmailStatus(String emailStatus) {
            EmailStatus = emailStatus;
        }

        public String getUserTeamGUID() {
            return UserTeamGUID;
        }

        public void setUserTeamGUID(String userTeamGUID) {
            UserTeamGUID = userTeamGUID;
        }

        public String getWalletAmount() {
            return WalletAmount;
        }

        public void setWalletAmount(String walletAmount) {
            WalletAmount = walletAmount;
        }

        public String getWinningAmount() {
            return WinningAmount;
        }

        public void setWinningAmount(String winningAmount) {
            WinningAmount = winningAmount;
        }

        public String getCashBonus() {
            return CashBonus;
        }

        public void setCashBonus(String cashBonus) {
            CashBonus = cashBonus;
        }

        public String getTotalCash() {
            return TotalCash;
        }

        public void setTotalCash(String totalCash) {
            TotalCash = totalCash;
        }

        public String getSessionKey() {
            return SessionKey;
        }

        public void setSessionKey(String sessionKey) {
            SessionKey = sessionKey;
        }

        public String getUserGUID() {
            return UserGUID;
        }

        public void setUserGUID(String UserGUID) {
            this.UserGUID = UserGUID;
        }

        public String getUserID() {
            return UserID;
        }

        public void setUserID(String UserID) {
            this.UserID = UserID;
        }

        public String getFullName() {
            return FullName;
        }

        public void setFullName(String FullName) {
            this.FullName = FullName;
        }

        public String getStatusID() {
            return StatusID;
        }

        public void setStatusID(String StatusID) {
            this.StatusID = StatusID;
        }

        public String getRating() {
            return Rating;
        }

        public void setRating(String Rating) {
            this.Rating = Rating;
        }

        public String getUserTypeID() {
            return UserTypeID;
        }

        public void setUserTypeID(String UserTypeID) {
            this.UserTypeID = UserTypeID;
        }

        public String getUserTypeName() {
            return UserTypeName;
        }

        public void setUserTypeName(String UserTypeName) {
            this.UserTypeName = UserTypeName;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String FirstName) {
            this.FirstName = FirstName;
        }

        public String getMiddleName() {
            return MiddleName;
        }

        public void setMiddleName(String MiddleName) {
            this.MiddleName = MiddleName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String LastName) {
            this.LastName = LastName;
        }

        public String getAbout() {
            return About;
        }

        public void setAbout(String About) {
            this.About = About;
        }

        public String getAbout1() {
            return About1;
        }

        public void setAbout1(String About1) {
            this.About1 = About1;
        }

        public String getAbout2() {
            return About2;
        }

        public void setAbout2(String About2) {
            this.About2 = About2;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getUsername() {
            return Username;
        }

        public void setUsername(String Username) {
            this.Username = Username;
        }

        public String getGender() {
            return Gender;
        }

        public void setGender(String Gender) {
            this.Gender = Gender;
        }

        public String getBirthDate() {
            return BirthDate;
        }

        public void setBirthDate(String BirthDate) {
            this.BirthDate = BirthDate;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getAddress1() {
            return Address1;
        }

        public void setAddress1(String Address1) {
            this.Address1 = Address1;
        }

        public String getPostal() {
            return Postal;
        }

        public void setPostal(String Postal) {
            this.Postal = Postal;
        }

        public String getCountryCode() {
            return CountryCode;
        }

        public void setCountryCode(String CountryCode) {
            this.CountryCode = CountryCode;
        }

        public String getCountryName() {
            return CountryName;
        }

        public void setCountryName(String CountryName) {
            this.CountryName = CountryName;
        }

        public String getCityName() {
            return CityName;
        }

        public void setCityName(String CityName) {
            this.CityName = CityName;
        }

        public String getStateName() {
            return StateName;
        }

        public void setStateName(String StateName) {
            this.StateName = StateName;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String PhoneNumber) {
            this.PhoneNumber = PhoneNumber;
        }

        public String getWebsite() {
            return Website;
        }

        public void setWebsite(String Website) {
            this.Website = Website;
        }

        public String getFacebookURL() {
            return FacebookURL;
        }

        public void setFacebookURL(String FacebookURL) {
            this.FacebookURL = FacebookURL;
        }

        public String getTwitterURL() {
            return TwitterURL;
        }

        public void setTwitterURL(String TwitterURL) {
            this.TwitterURL = TwitterURL;
        }

        public String getGoogleURL() {
            return GoogleURL;
        }

        public void setGoogleURL(String GoogleURL) {
            this.GoogleURL = GoogleURL;
        }

        public String getInstagramURL() {
            return InstagramURL;
        }

        public void setInstagramURL(String InstagramURL) {
            this.InstagramURL = InstagramURL;
        }

        public String getLinkedInURL() {
            return LinkedInURL;
        }

        public void setLinkedInURL(String LinkedInURL) {
            this.LinkedInURL = LinkedInURL;
        }

        public String getWhatsApp() {
            return WhatsApp;
        }

        public void setWhatsApp(String WhatsApp) {
            this.WhatsApp = WhatsApp;
        }

        public String getReferralCode() {
            return ReferralCode;
        }

        public void setReferralCode(String ReferralCode) {
            this.ReferralCode = ReferralCode;
        }

        public String getProfilePic() {
            return ProfilePic;
        }

        public void setProfilePic(String ProfilePic) {
            this.ProfilePic = ProfilePic;
        }



        public String getCashbonusMessage() {
            return CashbonusMessage;
        }

        public void setCashbonusMessage(String cashbonusMessage) {
            CashbonusMessage = cashbonusMessage;
        }

        public static class MediaPANBean implements Serializable {
            /**
             * MediaGUID : caeac1b8-34d1-c242-bb0b-b5cb32033b7c
             * MediaThumbURL : http://mwdemoserver.com/515-/api/uploads/PAN/110_caeac1b8-34d1-c242-bb0b-b5cb32033b7c.png
             * MediaURL : http://mwdemoserver.com/515-/api/uploads/PAN/caeac1b8-34d1-c242-bb0b-b5cb32033b7c.png
             * MediaCaption : {"FullName":"Kuldeep Patel","CountryCode":"IN","PanCardNumber":"ASXDS1234Q"}
             */

            @SerializedName("MediaGUID")
            private String MediaGUID;
            @SerializedName("MediaThumbURL")
            private String MediaThumbURL;
            @SerializedName("MediaURL")
            private String MediaURL;
            @SerializedName("MediaCaption")
            private String MediaCaption;

            public String getMediaGUID() {
                return MediaGUID;
            }

            public void setMediaGUID(String MediaGUID) {
                this.MediaGUID = MediaGUID;
            }

            public String getMediaThumbURL() {
                return MediaThumbURL;
            }

            public void setMediaThumbURL(String MediaThumbURL) {
                this.MediaThumbURL = MediaThumbURL;
            }

            public String getMediaURL() {
                return MediaURL;
            }

            public void setMediaURL(String MediaURL) {
                this.MediaURL = MediaURL;
            }

            public String getMediaCaption() {
                return MediaCaption;
            }

            public void setMediaCaption(String MediaCaption) {
                this.MediaCaption = MediaCaption;
            }
        }


        public static class MediaAadharBean implements Serializable{

            @SerializedName("MediaGUID")
            private String MediaGUID;

            @SerializedName("EntryDate")
            private String EntryDate;

            @SerializedName("MediaThumbURL")
            private String MediaThumbURL;

            @SerializedName("MediaURL")
            private String MediaURL;

            @SerializedName("MediaCaption")
            private String MediaCaption;

            public String getMediaGUID() {
                return MediaGUID;
            }

            public void setMediaGUID(String mediaGUID) {
                MediaGUID = mediaGUID;
            }

            public String getEntryDate() {
                return EntryDate;
            }

            public void setEntryDate(String entryDate) {
                EntryDate = entryDate;
            }

            public String getMediaThumbURL() {
                return MediaThumbURL;
            }

            public void setMediaThumbURL(String mediaThumbURL) {
                MediaThumbURL = mediaThumbURL;
            }

            public String getMediaURL() {
                return MediaURL;
            }

            public void setMediaURL(String mediaURL) {
                MediaURL = mediaURL;
            }

            public String getMediaCaption() {
                return MediaCaption;
            }

            public void setMediaCaption(String mediaCaption) {
                MediaCaption = mediaCaption;
            }
        }


        public static class MediaBANKBean implements Serializable {
            /**
             * MediaGUID : a1e72036-f325-945d-9848-99e5b43f0078
             * MediaThumbURL : http://mwdemoserver.com/515-/api/uploads/BankDetail/110_a1e72036-f325-945d-9848-99e5b43f0078.png
             * MediaURL : http://mwdemoserver.com/515-/api/uploads/BankDetail/a1e72036-f325-945d-9848-99e5b43f0078.png
             * MediaCaption : {"FullName":"Suhail Khan","Bank":"HDFC","AccountNumber":"65656456456","BirthDate":"2018-10-21","IFSCCode":"HFF689798"}
             */

            @SerializedName("MediaGUID")
            private String MediaGUID;
            @SerializedName("MediaThumbURL")
            private String MediaThumbURL;
            @SerializedName("MediaURL")
            private String MediaURL;
            @SerializedName("MediaCaption")
            private String MediaCaption;

            public String getMediaGUID() {
                return MediaGUID;
            }

            public void setMediaGUID(String MediaGUID) {
                this.MediaGUID = MediaGUID;
            }

            public String getMediaThumbURL() {
                return MediaThumbURL;
            }

            public void setMediaThumbURL(String MediaThumbURL) {
                this.MediaThumbURL = MediaThumbURL;
            }

            public String getMediaURL() {
                return MediaURL;
            }

            public void setMediaURL(String MediaURL) {
                this.MediaURL = MediaURL;
            }

            public String getMediaCaption() {
                return MediaCaption;
            }

            public void setMediaCaption(String MediaCaption) {
                this.MediaCaption = MediaCaption;
            }
        }
        public static class PlayingHistoryBean implements Serializable {
            /**
             * TotalJoinedMatches : 7
             * TotalJoinedSeries : 6
             * TotalJoinedContest : 9
             * TotalJoinedContestWinning : 0
             */

            @SerializedName("TotalJoinedMatches")
            private String TotalJoinedMatches;
            @SerializedName("TotalJoinedSeries")
            private String TotalJoinedSeries;
            @SerializedName("TotalJoinedContest")
            private String TotalJoinedContest;
            @SerializedName("TotalJoinedContestWinning")
            private String TotalJoinedContestWinning;

            public String getTotalJoinedMatches() {
                return TotalJoinedMatches;
            }

            public void setTotalJoinedMatches(String TotalJoinedMatches) {
                this.TotalJoinedMatches = TotalJoinedMatches;
            }

            public String getTotalJoinedSeries() {
                return TotalJoinedSeries;
            }

            public void setTotalJoinedSeries(String TotalJoinedSeries) {
                this.TotalJoinedSeries = TotalJoinedSeries;
            }

            public String getTotalJoinedContest() {
                return TotalJoinedContest;
            }

            public void setTotalJoinedContest(String TotalJoinedContest) {
                this.TotalJoinedContest = TotalJoinedContest;
            }

            public String getTotalJoinedContestWinning() {
                return TotalJoinedContestWinning;
            }

            public void setTotalJoinedContestWinning(String TotalJoinedContestWinning) {
                this.TotalJoinedContestWinning = TotalJoinedContestWinning;
            }
        }
    }


}
