package com.cmpay.boss.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CmpayRecordDetail {
    private String id;

    private String orderId;

    private String inchannel;

    private String merNo;

    private String userId;

    private String cardNo;

    private String origOrderNo;

    private BigDecimal transAmt;

    private String transType;

    private String payChannel;

    private String infoOrder;

    private Long period;

    private Date expireTime;

    private String orderip;

    private String codeUrl;

    private String returnUrl;

    private String notifyUrl;

    private String cancelOrderNo;

    private String thirdOrderNo;

    private String payStatus;

    private String isAcct;

    private String acctStatus;

    private String payOrderTime;

    private String respCode;

    private String respMsg;

    private String thirdRespCode;

    private String thirdMsg;

    private Date createTime;

    private Date modifyTime;

    private Integer version;

    private String remark;

    private String field1;

    private String field2;

    private String field3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getInchannel() {
        return inchannel;
    }

    public void setInchannel(String inchannel) {
        this.inchannel = inchannel == null ? null : inchannel.trim();
    }

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo == null ? null : merNo.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getOrigOrderNo() {
        return origOrderNo;
    }

    public void setOrigOrderNo(String origOrderNo) {
        this.origOrderNo = origOrderNo == null ? null : origOrderNo.trim();
    }

    public BigDecimal getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(BigDecimal transAmt) {
        this.transAmt = transAmt;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    public String getInfoOrder() {
        return infoOrder;
    }

    public void setInfoOrder(String infoOrder) {
        this.infoOrder = infoOrder == null ? null : infoOrder.trim();
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getOrderip() {
        return orderip;
    }

    public void setOrderip(String orderip) {
        this.orderip = orderip == null ? null : orderip.trim();
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl == null ? null : codeUrl.trim();
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getCancelOrderNo() {
        return cancelOrderNo;
    }

    public void setCancelOrderNo(String cancelOrderNo) {
        this.cancelOrderNo = cancelOrderNo == null ? null : cancelOrderNo.trim();
    }

    public String getThirdOrderNo() {
        return thirdOrderNo;
    }

    public void setThirdOrderNo(String thirdOrderNo) {
        this.thirdOrderNo = thirdOrderNo == null ? null : thirdOrderNo.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getIsAcct() {
        return isAcct;
    }

    public void setIsAcct(String isAcct) {
        this.isAcct = isAcct == null ? null : isAcct.trim();
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus == null ? null : acctStatus.trim();
    }

    public String getPayOrderTime() {
        return payOrderTime;
    }

    public void setPayOrderTime(String payOrderTime) {
        this.payOrderTime = payOrderTime == null ? null : payOrderTime.trim();
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode == null ? null : respCode.trim();
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg == null ? null : respMsg.trim();
    }

    public String getThirdRespCode() {
        return thirdRespCode;
    }

    public void setThirdRespCode(String thirdRespCode) {
        this.thirdRespCode = thirdRespCode == null ? null : thirdRespCode.trim();
    }

    public String getThirdMsg() {
        return thirdMsg;
    }

    public void setThirdMsg(String thirdMsg) {
        this.thirdMsg = thirdMsg == null ? null : thirdMsg.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}