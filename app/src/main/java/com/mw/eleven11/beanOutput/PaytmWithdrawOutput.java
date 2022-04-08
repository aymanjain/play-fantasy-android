package com.mw.eleven11.beanOutput;

public class PaytmWithdrawOutput {


    /**
     * ResponseCode : 200
     * Message : Success.
     * Data : {"WalletAmount":"326.00","WinningAmount":"1373.00","CashBonus":"20.00","TotalCash":"1719.00","paytmResponse":{"type":"","requestGuid":"","orderId":"Order6f6b94a1df","status":"FAILURE","statusCode":"WM_1006","statusMessage":"Your wallet balance is insufficient for this transaction. Please add money in your wallet and retry","response":{"walletSysTransactionId":""},"metadata":"Withdraw Money"}}
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
         * WalletAmount : 326.00
         * WinningAmount : 1373.00
         * CashBonus : 20.00
         * TotalCash : 1719.00
         * paytmResponse : {"type":"","requestGuid":"","orderId":"Order6f6b94a1df","status":"FAILURE","statusCode":"WM_1006","statusMessage":"Your wallet balance is insufficient for this transaction. Please add money in your wallet and retry","response":{"walletSysTransactionId":""},"metadata":"Withdraw Money"}
         */

        private String WalletAmount;
        private String WinningAmount;
        private String CashBonus;
        private String TotalCash;
        private PaytmResponseBean paytmResponse;

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

        public PaytmResponseBean getPaytmResponse() {
            return paytmResponse;
        }

        public void setPaytmResponse(PaytmResponseBean paytmResponse) {
            this.paytmResponse = paytmResponse;
        }

        public static class PaytmResponseBean {
            /**
             * type :
             * requestGuid :
             * orderId : Order6f6b94a1df
             * status : FAILURE
             * statusCode : WM_1006
             * statusMessage : Your wallet balance is insufficient for this transaction. Please add money in your wallet and retry
             * response : {"walletSysTransactionId":""}
             * metadata : Withdraw Money
             */

            private String type;
            private String requestGuid;
            private String orderId;
            private String status;
            private String statusCode;
            private String statusMessage;
            private ResponseBean response;
            private String metadata;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getRequestGuid() {
                return requestGuid;
            }

            public void setRequestGuid(String requestGuid) {
                this.requestGuid = requestGuid;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStatusCode() {
                return statusCode;
            }

            public void setStatusCode(String statusCode) {
                this.statusCode = statusCode;
            }

            public String getStatusMessage() {
                return statusMessage;
            }

            public void setStatusMessage(String statusMessage) {
                this.statusMessage = statusMessage;
            }

            public ResponseBean getResponse() {
                return response;
            }

            public void setResponse(ResponseBean response) {
                this.response = response;
            }

            public String getMetadata() {
                return metadata;
            }

            public void setMetadata(String metadata) {
                this.metadata = metadata;
            }

            public static class ResponseBean {
                /**
                 * walletSysTransactionId :
                 */

                private String walletSysTransactionId;

                public String getWalletSysTransactionId() {
                    return walletSysTransactionId;
                }

                public void setWalletSysTransactionId(String walletSysTransactionId) {
                    this.walletSysTransactionId = walletSysTransactionId;
                }
            }
        }
    }
}
