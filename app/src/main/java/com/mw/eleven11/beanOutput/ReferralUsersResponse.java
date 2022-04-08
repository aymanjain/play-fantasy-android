package com.mw.eleven11.beanOutput;

public class ReferralUsersResponse {

    /**
     * ResponseCode : 200
     * Message : Success
     * Data : {"Response":{"FirstPercentage":"3","SecondPercentage":"2","ThirdPercentage":"1.5","TotalReferralsDeposit":"0","ReferralsDeposit":"0","FirstLevel":"","SecondLevel":"0","ThirdLevel":"0","FristLevelTotalWinningAmount":"0","SecondLevelTotalWinningAmount":"0","ThirdLevelTotalWinningAmount":"0","TotalAmount":"1349","DepositAmount":"420.25","WinningAmount":"443.60","CashBonusAmount":"485.15"}}
     */

    private String ResponseCode;
    private String Message;
    private DataBean Data;

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String ResponseCode) {
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
         * Response : {"FirstPercentage":"3","SecondPercentage":"2","ThirdPercentage":"1.5","TotalReferralsDeposit":"0","ReferralsDeposit":"0","FirstLevel":"","SecondLevel":"0","ThirdLevel":"0","FristLevelTotalWinningAmount":"0","SecondLevelTotalWinningAmount":"0","ThirdLevelTotalWinningAmount":"0","TotalAmount":"1349","DepositAmount":"420.25","WinningAmount":"443.60","CashBonusAmount":"485.15"}
         */

        private ResponseBean Response;

        public ResponseBean getResponse() {
            return Response;
        }

        public void setResponse(ResponseBean Response) {
            this.Response = Response;
        }

        public static class ResponseBean {
            /**
             * FirstPercentage : 3
             * SecondPercentage : 2
             * ThirdPercentage : 1.5
             * TotalReferralsDeposit : 0
             * ReferralsDeposit : 0
             * FirstLevel :
             * SecondLevel : 0
             * ThirdLevel : 0
             * FristLevelTotalWinningAmount : 0
             * SecondLevelTotalWinningAmount : 0
             * ThirdLevelTotalWinningAmount : 0
             * TotalAmount : 1349
             * DepositAmount : 420.25
             * WinningAmount : 443.60
             * CashBonusAmount : 485.15
             */

            private String FirstPercentage;
            private String SecondPercentage;
            private String ThirdPercentage;
            private String TotalReferralsDeposit;
            private String ReferralsDeposit;
            private String FirstLevel;
            private String SecondLevel;
            private String ThirdLevel;
            private String FristLevelTotalWinningAmount;
            private String SecondLevelTotalWinningAmount;
            private String ThirdLevelTotalWinningAmount;
            private String TotalAmount;
            private String DepositAmount;
            private String WinningAmount;
            private String CashBonusAmount;
            private String  ReferralCode;

            public String getFirstPercentage() {
                return FirstPercentage;
            }

            public void setFirstPercentage(String FirstPercentage) {
                this.FirstPercentage = FirstPercentage;
            }

            public String getSecondPercentage() {
                return SecondPercentage;
            }

            public void setSecondPercentage(String SecondPercentage) {
                this.SecondPercentage = SecondPercentage;
            }

            public String getThirdPercentage() {
                return ThirdPercentage;
            }

            public void setThirdPercentage(String ThirdPercentage) {
                this.ThirdPercentage = ThirdPercentage;
            }

            public String getTotalReferralsDeposit() {
                return TotalReferralsDeposit;
            }

            public void setTotalReferralsDeposit(String TotalReferralsDeposit) {
                this.TotalReferralsDeposit = TotalReferralsDeposit;
            }

            public String getReferralsDeposit() {
                return ReferralsDeposit;
            }

            public void setReferralsDeposit(String ReferralsDeposit) {
                this.ReferralsDeposit = ReferralsDeposit;
            }

            public String getFirstLevel() {
                return FirstLevel;
            }

            public void setFirstLevel(String FirstLevel) {
                this.FirstLevel = FirstLevel;
            }

            public String getSecondLevel() {
                return SecondLevel;
            }

            public void setSecondLevel(String SecondLevel) {
                this.SecondLevel = SecondLevel;
            }

            public String getThirdLevel() {
                return ThirdLevel;
            }

            public void setThirdLevel(String ThirdLevel) {
                this.ThirdLevel = ThirdLevel;
            }

            public String getFristLevelTotalWinningAmount() {
                return FristLevelTotalWinningAmount;
            }

            public void setFristLevelTotalWinningAmount(String FristLevelTotalWinningAmount) {
                this.FristLevelTotalWinningAmount = FristLevelTotalWinningAmount;
            }

            public String getSecondLevelTotalWinningAmount() {
                return SecondLevelTotalWinningAmount;
            }

            public void setSecondLevelTotalWinningAmount(String SecondLevelTotalWinningAmount) {
                this.SecondLevelTotalWinningAmount = SecondLevelTotalWinningAmount;
            }

            public String getThirdLevelTotalWinningAmount() {
                return ThirdLevelTotalWinningAmount;
            }

            public void setThirdLevelTotalWinningAmount(String ThirdLevelTotalWinningAmount) {
                this.ThirdLevelTotalWinningAmount = ThirdLevelTotalWinningAmount;
            }

            public String getTotalAmount() {
                return TotalAmount;
            }

            public void setTotalAmount(String TotalAmount) {
                this.TotalAmount = TotalAmount;
            }

            public String getDepositAmount() {
                return DepositAmount;
            }

            public void setDepositAmount(String DepositAmount) {
                this.DepositAmount = DepositAmount;
            }

            public String getWinningAmount() {
                return WinningAmount;
            }

            public void setWinningAmount(String WinningAmount) {
                this.WinningAmount = WinningAmount;
            }

            public String getCashBonusAmount() {
                return CashBonusAmount;
            }

            public void setCashBonusAmount(String CashBonusAmount) {
                this.CashBonusAmount = CashBonusAmount;
            }

            public String getReferralCode() {
                return ReferralCode;
            }

            public void setReferralCode(String referralCode) {
                ReferralCode = referralCode;
            }
        }
    }
}
