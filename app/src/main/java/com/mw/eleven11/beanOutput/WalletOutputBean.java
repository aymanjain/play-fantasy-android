package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

public class WalletOutputBean {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"WalletAmount":"0.00","CashBonus":"40.00","WinningAmount":"0.00","TotalCash":"40.00","TotalRecords":0}
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
         * WalletAmount : 0.00
         * CashBonus : 40.00
         * WinningAmount : 0.00
         * TotalCash : 40.00
         * TotalRecords : 0
         */


        @SerializedName("MediaBANK")
        private MediaBANK mediaBANK;

        @SerializedName("PhoneStatus")
        private String PhoneStatus;

        @SerializedName("EmailStatus")
        private String EmailStatus;

        @SerializedName("AadharStatus")
        private String AadharStatus;

        @SerializedName("Status")
        private String Status;

        @SerializedName("PanStatus")
        private String PanStatus;

        @SerializedName("BankStatus")
        private String BankStatus;

        @SerializedName("WalletAmount")
        private String WalletAmount;
        @SerializedName("CashBonus")
        private String CashBonus;
        @SerializedName("WinningAmount")
        private String WinningAmount;
        @SerializedName("TotalCash")
        private String TotalCash;
        @SerializedName("TotalRecords")
        private int TotalRecords;

        @SerializedName("ProfilePic")
        private String ProfilePic;
        @SerializedName("Username")
        private String Username;

        public String getAadharStatus() {
            return AadharStatus;
        }

        public void setAadharStatus(String aadharStatus) {
            AadharStatus = aadharStatus;
        }

        public String getPhoneStatus() {
            return PhoneStatus;
        }


        public String getEmailStatus() {
            return EmailStatus;
        }

        public void setEmailStatus(String emailStatus) {
            EmailStatus = emailStatus;
        }

        public void setPhoneStatus(String phoneStatus) {
            PhoneStatus = phoneStatus;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            Status = status;
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

        public String getWalletAmount() {
            return WalletAmount;
        }

        public void setWalletAmount(String WalletAmount) {
            this.WalletAmount = WalletAmount;
        }

        public String getCashBonus() {
            return CashBonus;
        }

        public void setCashBonus(String CashBonus) {
            this.CashBonus = CashBonus;
        }

        public String getWinningAmount() {
            return WinningAmount;
        }

        public void setWinningAmount(String WinningAmount) {
            this.WinningAmount = WinningAmount;
        }

        public String getTotalCash() {
            return TotalCash;
        }

        public void setTotalCash(String TotalCash) {
            this.TotalCash = TotalCash;
        }

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int TotalRecords) {
            this.TotalRecords = TotalRecords;
        }

        public MediaBANK getMediaBANK() {
            return mediaBANK;
        }

        public void setMediaBANK(MediaBANK mediaBANK) {
            this.mediaBANK = mediaBANK;
        }

        public String getProfilePic() { return ProfilePic; }

        public void setProfilePic(String profilePic) { ProfilePic = profilePic; }

        public String getUsername() { return Username; }

        public void setUsername(String username) { Username = username; }
    }

    public class MediaBANK {

        @SerializedName("EntryDate")

        private String entryDate;
        @SerializedName("MediaGUID")
        private String mediaGUID;
        @SerializedName("MediaURL")
        private String mediaURL;
        @SerializedName("MediaThumbURL")
        private String mediaThumbURL;
        @SerializedName("MediaCaption")
        private MediaCaption mediaCaption;
        @SerializedName("Message")
        private String message;

        public String getEntryDate() {
            return entryDate;
        }

        public void setEntryDate(String entryDate) {
            this.entryDate = entryDate;
        }

        public String getMediaGUID() {
            return mediaGUID;
        }

        public void setMediaGUID(String mediaGUID) {
            this.mediaGUID = mediaGUID;
        }

        public String getMediaURL() {
            return mediaURL;
        }

        public void setMediaURL(String mediaURL) {
            this.mediaURL = mediaURL;
        }

        public String getMediaThumbURL() {
            return mediaThumbURL;
        }

        public void setMediaThumbURL(String mediaThumbURL) {
            this.mediaThumbURL = mediaThumbURL;
        }

        public MediaCaption getMediaCaption() {
            return mediaCaption;
        }

        public void setMediaCaption(MediaCaption mediaCaption) {
            this.mediaCaption = mediaCaption;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

    public class MediaCaption {

        @SerializedName("FullName")
        private String fullName;
        @SerializedName("Bank")
        private String bank;
        @SerializedName("AccountNumber")
        private String accountNumber;
        @SerializedName("BirthDate")
        private String birthDate;
        @SerializedName("IFSCCode")
        private String iFSCCode;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getIFSCCode() {
            return iFSCCode;
        }

        public void setIFSCCode(String iFSCCode) {
            this.iFSCCode = iFSCCode;
        }
    }
}
