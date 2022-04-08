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

public class BankListBean implements Serializable {


    /**
     * code : 200
     * response : [{"bank_name":"sbi","branch_name":"lakashmi nagar","account_number":"52451263524125","ifsc_code":"sbi42512353","icon_image":"https://www.funtush11.com/funtush/backend_asset/images/default-148.png"},{"bank_name":"icici","branch_name":"lakashmi nagar","account_number":"52451263524125","ifsc_code":"icici4251235","icon_image":"https://www.funtush11.com/funtush/backend_asset/images/default-148.png"}]
     * status : 1
     * message : Bank account details found successfully
     */

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("response")
    private List<ResponseBean> response;

    public static List<BankListBean> arrayBankListBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<BankListBean>>() {
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
         * bank_name : sbi
         * branch_name : lakashmi nagar
         * account_number : 52451263524125
         * ifsc_code : sbi42512353
         * icon_image : https://www.funtush11.com/funtush/backend_asset/images/default-148.png
         */

        @SerializedName("bank_name")
        private String bankName;
        @SerializedName("branch_name")
        private String branchName;
        @SerializedName("account_number")
        private String accountNumber;
        @SerializedName("ifsc_code")
        private String ifscCode;
        @SerializedName("icon_image")
        private String iconImage;

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

        public String getIconImage() {
            return iconImage;
        }

        public void setIconImage(String iconImage) {
            this.iconImage = iconImage;
        }
    }
}
