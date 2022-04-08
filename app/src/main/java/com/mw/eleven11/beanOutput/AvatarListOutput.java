package com.mw.eleven11.beanOutput;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AvatarListOutput {


    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"Records":[{"AvatarId":"1","AvatarImg":"1.png","AvatarURL":"http://mwdemoserver.com/515-MyMatch11/api/uploads/profile/picture/1.png"},{"AvatarId":"2","AvatarImg":"2.png","AvatarURL":"http://mwdemoserver.com/515-MyMatch11/api/uploads/profile/picture/2.png"},{"AvatarId":"3","AvatarImg":"3.png","AvatarURL":"http://mwdemoserver.com/515-MyMatch11/api/uploads/profile/picture/3.png"},{"AvatarId":"4","AvatarImg":"4.png","AvatarURL":"http://mwdemoserver.com/515-MyMatch11/api/uploads/profile/picture/4.png"},{"AvatarId":"5","AvatarImg":"5.png","AvatarURL":"http://mwdemoserver.com/515-MyMatch11/api/uploads/profile/picture/5.png"},{"AvatarId":"6","AvatarImg":"6.png","AvatarURL":"http://mwdemoserver.com/515-MyMatch11/api/uploads/profile/picture/6.png"},{"AvatarId":"7","AvatarImg":"7.png","AvatarURL":"http://mwdemoserver.com/515-MyMatch11/api/uploads/profile/picture/7.png"}]}
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
        @SerializedName("Records")
        private List<RecordsBean> Records;

        public List<RecordsBean> getRecords() {
            return Records;
        }

        public void setRecords(List<RecordsBean> Records) {
            this.Records = Records;
        }

        public static class RecordsBean implements Serializable {
            /**
             * AvatarId : 1
             * AvatarImg : 1.png
             * AvatarURL : http://mwdemoserver.com/515-MyMatch11/api/uploads/profile/picture/1.png
             */

            @SerializedName("AvatarId")
            private String AvatarId;
            @SerializedName("AvatarImg")
            private String AvatarImg;
            @SerializedName("AvatarURL")
            private String AvatarURL;

            public String getAvatarId() {
                return AvatarId;
            }

            public void setAvatarId(String AvatarId) {
                this.AvatarId = AvatarId;
            }

            public String getAvatarImg() {
                return AvatarImg;
            }

            public void setAvatarImg(String AvatarImg) {
                this.AvatarImg = AvatarImg;
            }

            public String getAvatarURL() {
                return AvatarURL;
            }

            public void setAvatarURL(String AvatarURL) {
                this.AvatarURL = AvatarURL;
            }
        }
    }
}
