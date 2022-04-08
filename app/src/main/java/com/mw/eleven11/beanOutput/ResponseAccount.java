package com.mw.eleven11.beanOutput;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiweb on 1/3/18.
 */

public class ResponseAccount {


    /**
     * code : 200
     * status : 1
     * response : {"cash":{"deposited_amount":"0.00","winning_amount":"5.00","cash_bonus_amount":"90.00","total_balance":"80.00","amount_to_expire":"0","bonus_to_expire":"0"},"chip":{"bonus_chip":"0","winning_chip":"0","total_chip":"0"},"verify_account":"PENDING","use_cash_bonus_limit":"10%","withdrawal_amount_limit":"200","withdrawal_req":0,"playing_history":{"total_contest":2,"total_matches":2,"series":1,"total_wins":3},"invited_friends_list":[{"user_id":"348","team_code":"NISHA26565","user_image":"http://localhost/fantasy11/backend_asset/images/default-148.png"},{"user_id":"349","team_code":"GOA5251269","user_image":"http://localhost/fantasy11/backend_asset/images/default-148.png"}],"transactions":[],"cards":[]}
     * message : success
     */

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private int status;
    @SerializedName("response")
    private ResponseBean response;
    @SerializedName("message")
    private String message;

    public static List<ResponseAccount> arrayResponseAccountFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ResponseAccount>>() {
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
         * cash : {"deposited_amount":"0.00","winning_amount":"5.00","cash_bonus_amount":"90.00","total_balance":"80.00","amount_to_expire":"0","bonus_to_expire":"0"}
         * chip : {"bonus_chip":"0","winning_chip":"0","total_chip":"0"}
         * verify_account : PENDING
         * use_cash_bonus_limit : 10%
         * withdrawal_amount_limit : 200
         * withdrawal_req : 0
         * playing_history : {"total_contest":2,"total_matches":2,"series":1,"total_wins":3}
         * invited_friends_list : [{"user_id":"348","team_code":"NISHA26565","user_image":"http://localhost/fantasy11/backend_asset/images/default-148.png"},{"user_id":"349","team_code":"GOA5251269","user_image":"http://localhost/fantasy11/backend_asset/images/default-148.png"}]
         * transactions : []
         * cards : []
         */

        @SerializedName("cash")
        private CashBean cash;
        @SerializedName("chip")
        private ChipBean chip;
        @SerializedName("verify_account")
        private String verifyAccount;
        @SerializedName("use_cash_bonus_limit")
        private String useCashBonusLimit;
        @SerializedName("withdrawal_amount_limit")
        private String withdrawalAmountLimit;
        @SerializedName("withdrawal_req")
        private int withdrawalReq;
        @SerializedName("playing_history")
        private PlayingHistoryBean playingHistory;
        @SerializedName("invited_friends_list")
        private List<InvitedFriendsListBean> invitedFriendsList;
        @SerializedName("transactions")
        private List<?> transactions;
        @SerializedName("cards")
        private List<?> cards;

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

        public CashBean getCash() {
            return cash;
        }

        public void setCash(CashBean cash) {
            this.cash = cash;
        }

        public ChipBean getChip() {
            return chip;
        }

        public void setChip(ChipBean chip) {
            this.chip = chip;
        }

        public String getVerifyAccount() {
            return verifyAccount;
        }

        public void setVerifyAccount(String verifyAccount) {
            this.verifyAccount = verifyAccount;
        }

        public String getUseCashBonusLimit() {
            return useCashBonusLimit;
        }

        public void setUseCashBonusLimit(String useCashBonusLimit) {
            this.useCashBonusLimit = useCashBonusLimit;
        }

        public String getWithdrawalAmountLimit() {
            return withdrawalAmountLimit;
        }

        public void setWithdrawalAmountLimit(String withdrawalAmountLimit) {
            this.withdrawalAmountLimit = withdrawalAmountLimit;
        }

        public int getWithdrawalReq() {
            return withdrawalReq;
        }

        public void setWithdrawalReq(int withdrawalReq) {
            this.withdrawalReq = withdrawalReq;
        }

        public PlayingHistoryBean getPlayingHistory() {
            return playingHistory;
        }

        public void setPlayingHistory(PlayingHistoryBean playingHistory) {
            this.playingHistory = playingHistory;
        }

        public List<InvitedFriendsListBean> getInvitedFriendsList() {
            return invitedFriendsList;
        }

        public void setInvitedFriendsList(List<InvitedFriendsListBean> invitedFriendsList) {
            this.invitedFriendsList = invitedFriendsList;
        }

        public List<?> getTransactions() {
            return transactions;
        }

        public void setTransactions(List<?> transactions) {
            this.transactions = transactions;
        }

        public List<?> getCards() {
            return cards;
        }

        public void setCards(List<?> cards) {
            this.cards = cards;
        }

        public static class CashBean {
            /**
             * deposited_amount : 0.00
             * winning_amount : 5.00
             * cash_bonus_amount : 90.00
             * total_balance : 80.00
             * amount_to_expire : 0
             * bonus_to_expire : 0
             */

            @SerializedName("deposited_amount")
            private String depositedAmount;
            @SerializedName("winning_amount")
            private String winningAmount;
            @SerializedName("cash_bonus_amount")
            private String cashBonusAmount;
            @SerializedName("total_balance")
            private String totalBalance;
            @SerializedName("amount_to_expire")
            private String amountToExpire;
            @SerializedName("bonus_to_expire")
            private String bonusToExpire;

            public static List<CashBean> arrayCashBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<CashBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getDepositedAmount() {
                return depositedAmount;
            }

            public void setDepositedAmount(String depositedAmount) {
                this.depositedAmount = depositedAmount;
            }

            public String getWinningAmount() {
                return winningAmount;
            }

            public void setWinningAmount(String winningAmount) {
                this.winningAmount = winningAmount;
            }

            public String getCashBonusAmount() {
                return cashBonusAmount;
            }

            public void setCashBonusAmount(String cashBonusAmount) {
                this.cashBonusAmount = cashBonusAmount;
            }

            public String getTotalBalance() {
                return totalBalance;
            }

            public void setTotalBalance(String totalBalance) {
                this.totalBalance = totalBalance;
            }

            public String getAmountToExpire() {
                return amountToExpire;
            }

            public void setAmountToExpire(String amountToExpire) {
                this.amountToExpire = amountToExpire;
            }

            public String getBonusToExpire() {
                return bonusToExpire;
            }

            public void setBonusToExpire(String bonusToExpire) {
                this.bonusToExpire = bonusToExpire;
            }
        }

        public static class ChipBean {
            /**
             * bonus_chip : 0
             * winning_chip : 0
             * total_chip : 0
             */

            @SerializedName("bonus_chip")
            private String bonusChip;
            @SerializedName("winning_chip")
            private String winningChip;
            @SerializedName("total_chip")
            private String totalChip;

            public static List<ChipBean> arrayChipBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ChipBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getBonusChip() {
                return bonusChip;
            }

            public void setBonusChip(String bonusChip) {
                this.bonusChip = bonusChip;
            }

            public String getWinningChip() {
                return winningChip;
            }

            public void setWinningChip(String winningChip) {
                this.winningChip = winningChip;
            }

            public String getTotalChip() {
                return totalChip;
            }

            public void setTotalChip(String totalChip) {
                this.totalChip = totalChip;
            }
        }

        public static class PlayingHistoryBean {
            /**
             * total_contest : 2
             * total_matches : 2
             * series : 1
             * total_wins : 3
             */

            @SerializedName("total_contest")
            private int totalContest;
            @SerializedName("total_matches")
            private int totalMatches;
            @SerializedName("series")
            private int series;
            @SerializedName("total_wins")
            private int totalWins;

            public static List<PlayingHistoryBean> arrayPlayingHistoryBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<PlayingHistoryBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public int getTotalContest() {
                return totalContest;
            }

            public void setTotalContest(int totalContest) {
                this.totalContest = totalContest;
            }

            public int getTotalMatches() {
                return totalMatches;
            }

            public void setTotalMatches(int totalMatches) {
                this.totalMatches = totalMatches;
            }

            public int getSeries() {
                return series;
            }

            public void setSeries(int series) {
                this.series = series;
            }

            public int getTotalWins() {
                return totalWins;
            }

            public void setTotalWins(int totalWins) {
                this.totalWins = totalWins;
            }
        }

        public static class InvitedFriendsListBean {
            /**
             * user_id : 348
             * team_code : NISHA26565
             * user_image : http://localhost/fantasy11/backend_asset/images/default-148.png
             */

            @SerializedName("user_id")
            private String userId;
            @SerializedName("team_code")
            private String teamCode;
            @SerializedName("user_image")
            private String userImage;

            public static List<InvitedFriendsListBean> arrayInvitedFriendsListBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<InvitedFriendsListBean>>() {
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

            public String getUserImage() {
                return userImage;
            }

            public void setUserImage(String userImage) {
                this.userImage = userImage;
            }
        }
    }
}
