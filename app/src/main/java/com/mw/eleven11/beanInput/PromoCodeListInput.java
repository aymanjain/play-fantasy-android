package com.mw.eleven11.beanInput;

public class PromoCodeListInput {

    /**
     * PageNo : 10
     * PageSize : 0
     * Status : Active
     */

    private int PageNo;
    private int PageSize;
    private String Status;

    public int getPageNo() {
        return PageNo;
    }

    public void setPageNo(int PageNo) {
        this.PageNo = PageNo;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int PageSize) {
        this.PageSize = PageSize;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
