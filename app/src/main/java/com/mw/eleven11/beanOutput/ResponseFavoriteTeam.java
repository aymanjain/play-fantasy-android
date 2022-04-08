package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseFavoriteTeam implements Serializable {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"TotalRecords":12,"Records":[{"CountryCode":"AF","CountryName":"Afghanistan","CountryTeamName":"Afghanistan","CountryFlag":"http://localhost/515-/api/asset/countries/AF.png","IsUserFavourite":"No"},{"CountryCode":"AU","CountryName":"Australia","CountryTeamName":"Australia","CountryFlag":"http://localhost/515-/api/asset/countries/AU.png","IsUserFavourite":"No"},{"CountryCode":"BD","CountryName":"Bangladesh","CountryTeamName":"Bangladesh","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/BD.png","IsUserFavourite":"No"},{"CountryCode":"IN","CountryName":"India","CountryTeamName":"India","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/IN.png","IsUserFavourite":"No"},{"CountryCode":"IE","CountryName":"Ireland","CountryTeamName":"Ireland","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/IE.png","IsUserFavourite":"No"},{"CountryCode":"NZ","CountryName":"New Zealand","CountryTeamName":"New Zealand","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/NZ.png","IsUserFavourite":"No"},{"CountryCode":"PK","CountryName":"Pakistan","CountryTeamName":"Pakistan","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/PK.png","IsUserFavourite":"No"},{"CountryCode":"ZA","CountryName":"South Africa","CountryTeamName":"South Africa","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/ZA.png","IsUserFavourite":"No"},{"CountryCode":"LK","CountryName":"Sri Lanka","CountryTeamName":"Sri Lanka","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/LK.png","IsUserFavourite":"No"},{"CountryCode":"GB","CountryName":"United Kingdom","CountryTeamName":"England","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/GB.png","IsUserFavourite":"No"},{"CountryCode":"WI","CountryName":"West Indies","CountryTeamName":"West Indies","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/WI.png","IsUserFavourite":"No"},{"CountryCode":"ZW","CountryName":"Zimbabwe","CountryTeamName":"Zimbabwe","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/ZW.png","IsUserFavourite":"No"}]}
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
         * TotalRecords : 12
         * Records : [{"CountryCode":"AF","CountryName":"Afghanistan","CountryTeamName":"Afghanistan","CountryFlag":"http://localhost/515-/api/asset/countries/AF.png","IsUserFavourite":"No"},{"CountryCode":"AU","CountryName":"Australia","CountryTeamName":"Australia","CountryFlag":"http://localhost/515-/api/asset/countries/AU.png","IsUserFavourite":"No"},{"CountryCode":"BD","CountryName":"Bangladesh","CountryTeamName":"Bangladesh","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/BD.png","IsUserFavourite":"No"},{"CountryCode":"IN","CountryName":"India","CountryTeamName":"India","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/IN.png","IsUserFavourite":"No"},{"CountryCode":"IE","CountryName":"Ireland","CountryTeamName":"Ireland","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/IE.png","IsUserFavourite":"No"},{"CountryCode":"NZ","CountryName":"New Zealand","CountryTeamName":"New Zealand","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/NZ.png","IsUserFavourite":"No"},{"CountryCode":"PK","CountryName":"Pakistan","CountryTeamName":"Pakistan","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/PK.png","IsUserFavourite":"No"},{"CountryCode":"ZA","CountryName":"South Africa","CountryTeamName":"South Africa","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/ZA.png","IsUserFavourite":"No"},{"CountryCode":"LK","CountryName":"Sri Lanka","CountryTeamName":"Sri Lanka","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/LK.png","IsUserFavourite":"No"},{"CountryCode":"GB","CountryName":"United Kingdom","CountryTeamName":"England","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/GB.png","IsUserFavourite":"No"},{"CountryCode":"WI","CountryName":"West Indies","CountryTeamName":"West Indies","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/WI.png","IsUserFavourite":"No"},{"CountryCode":"ZW","CountryName":"Zimbabwe","CountryTeamName":"Zimbabwe","CountryFlag":"http://localhost/515-MyMatch11/api/asset/countries/ZW.png","IsUserFavourite":"No"}]
         */
        @SerializedName("TotalRecords")
        private int TotalRecords;
        @SerializedName("Records")
        private List<RecordsBean> Records;

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int TotalRecords) {
            this.TotalRecords = TotalRecords;
        }

        public List<RecordsBean> getRecords() {
            return Records;
        }

        public void setRecords(List<RecordsBean> Records) {
            this.Records = Records;
        }

        public static class RecordsBean {
            /**
             * CountryCode : AF
             * CountryName : Afghanistan
             * CountryTeamName : Afghanistan
             * CountryFlag : http://localhost/515-/api/asset/countries/AF.png
             * IsUserFavourite : No
             */
            @SerializedName("CountryCode")
            private String CountryCode;
            @SerializedName("CountryName")
            private String CountryName;
            @SerializedName("CountryTeamName")
            private String CountryTeamName;
            @SerializedName("CountryFlag")
            private String CountryFlag;
            @SerializedName("IsUserFavourite")
            private String IsUserFavourite;


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

            public String getCountryTeamName() {
                return CountryTeamName;
            }

            public void setCountryTeamName(String CountryTeamName) {
                this.CountryTeamName = CountryTeamName;
            }

            public String getCountryFlag() {
                return CountryFlag;
            }

            public void setCountryFlag(String CountryFlag) {
                this.CountryFlag = CountryFlag;
            }

            public String getIsUserFavourite() {
                return IsUserFavourite;
            }

            public void setIsUserFavourite(String IsUserFavourite) {
                this.IsUserFavourite = IsUserFavourite;
            }
        }
    }
}
