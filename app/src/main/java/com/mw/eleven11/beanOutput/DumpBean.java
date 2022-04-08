package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

public class DumpBean {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"UserGUID":"590763b4-df54-68a3-16e0-f8a460a52c62","UserID":"343167","FullName":"","Rating":"0","UserTypeID":"2","UserTypeName":"User","FirstName":"","MiddleName":"","LastName":"","About":"","About1":"","About2":"","Email":"suhail.mobiwebtech1@gmail.com","Username":"suhailkhan","Gender":"","BirthDate":"","Address":"","Address1":"","Postal":"","CountryCode":"","CountryName":"","CityName":"","StateName":"","PhoneNumber":"","Website":"","FacebookURL":"","TwitterURL":"","GoogleURL":"","InstagramURL":"","LinkedInURL":"","WhatsApp":"","ReferralCode":"ezVuGg","ProfilePic":"http://mwdemoserver.com/515-/api/uploads/profile/picture/default.jpg","WalletAmount":"0.00","WinningAmount":"0.00","CashBonus":"40.00","TotalCash":"40.00","PanStatus":"Not Submitted","BankStatus":"Not Submitted","PhoneStatus":"Pending","EmailStatus":"Verified","MediaPAN":{},"MediaBANK":{},"PlayingHistory":{"TotalJoinedMatches":"7","TotalJoinedSeries":"6","TotalJoinedContest":"9","TotalJoinedContestWinning":"0"}}
     */

    @SerializedName("ResponseCode")
    private int ResponseCode;
    @SerializedName("Message")
    private String Message;
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

    public static class DataBean {
        /**
         * UserGUID : 590763b4-df54-68a3-16e0-f8a460a52c62
         * UserID : 343167
         * FullName :
         * Rating : 0
         * UserTypeID : 2
         * UserTypeName : User
         * FirstName :
         * MiddleName :
         * LastName :
         * About :
         * About1 :
         * About2 :
         * Email : suhail.mobiwebtech1@gmail.com
         * Username : suhailkhan
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
         * ReferralCode : ezVuGg
         * ProfilePic : http://mwdemoserver.com/515-/api/uploads/profile/picture/default.jpg
         * WalletAmount : 0.00
         * WinningAmount : 0.00
         * CashBonus : 40.00
         * TotalCash : 40.00
         * PanStatus : Not Submitted
         * BankStatus : Not Submitted
         * PhoneStatus : Pending
         * EmailStatus : Verified
         * MediaPAN : {}
         * MediaBANK : {}
         * PlayingHistory : {"TotalJoinedMatches":"7","TotalJoinedSeries":"6","TotalJoinedContest":"9","TotalJoinedContestWinning":"0"}
         */

        @SerializedName("UserGUID")
        private String UserGUID;
        @SerializedName("UserID")
        private String UserID;
        @SerializedName("FullName")
        private String FullName;
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
        @SerializedName("PhoneStatus")
        private String PhoneStatus;
        @SerializedName("EmailStatus")
        private String EmailStatus;
        @SerializedName("MediaPAN")
        private MediaPANBean MediaPAN;
        @SerializedName("MediaBANK")
        private MediaBANKBean MediaBANK;
        @SerializedName("PlayingHistory")
        private PlayingHistoryBean PlayingHistory;

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

        public String getWalletAmount() {
            return WalletAmount;
        }

        public void setWalletAmount(String WalletAmount) {
            this.WalletAmount = WalletAmount;
        }

        public String getWinningAmount() {
            return WinningAmount;
        }

        public void setWinningAmount(String WinningAmount) {
            this.WinningAmount = WinningAmount;
        }

        public String getCashBonus() {
            return CashBonus;
        }

        public void setCashBonus(String CashBonus) {
            this.CashBonus = CashBonus;
        }

        public String getTotalCash() {
            return TotalCash;
        }

        public void setTotalCash(String TotalCash) {
            this.TotalCash = TotalCash;
        }

        public String getPanStatus() {
            return PanStatus;
        }

        public void setPanStatus(String PanStatus) {
            this.PanStatus = PanStatus;
        }

        public String getBankStatus() {
            return BankStatus;
        }

        public void setBankStatus(String BankStatus) {
            this.BankStatus = BankStatus;
        }

        public String getPhoneStatus() {
            return PhoneStatus;
        }

        public void setPhoneStatus(String PhoneStatus) {
            this.PhoneStatus = PhoneStatus;
        }

        public String getEmailStatus() {
            return EmailStatus;
        }

        public void setEmailStatus(String EmailStatus) {
            this.EmailStatus = EmailStatus;
        }

        public MediaPANBean getMediaPAN() {
            return MediaPAN;
        }

        public void setMediaPAN(MediaPANBean MediaPAN) {
            this.MediaPAN = MediaPAN;
        }

        public MediaBANKBean getMediaBANK() {
            return MediaBANK;
        }

        public void setMediaBANK(MediaBANKBean MediaBANK) {
            this.MediaBANK = MediaBANK;
        }

        public PlayingHistoryBean getPlayingHistory() {
            return PlayingHistory;
        }

        public void setPlayingHistory(PlayingHistoryBean PlayingHistory) {
            this.PlayingHistory = PlayingHistory;
        }

        public static class MediaPANBean {
        }

        public static class MediaBANKBean {
        }

        public static class PlayingHistoryBean {
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
