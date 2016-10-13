package com.cmpay.boss.domain;

/**
 * 
 * 
 * @author xiaoxiang
 * @version $Id: BaseBO.java, v 0.1 2016年9月7日 上午9:37:51 Administrator Exp $
 */
public class BaseBO {
    private Integer pageCurrent;

    private Integer pageNo   = 1;

    private Integer pageSize = 20;

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
