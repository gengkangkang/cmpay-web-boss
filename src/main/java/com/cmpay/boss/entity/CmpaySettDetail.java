package com.cmpay.boss.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CmpaySettDetail {
    private String orderId;

    private String inchannel;

    private String merNo;

    private String userId;

    private BigDecimal transAmt;

    private String transType;

    private Date transDate;

    private String payChannel;

    private String payStatus;

    private String settStatus;

    private String batchId;

    private Date createTime;

    private Date modifyTime;

    private Integer version;

    private String remark;

    private String field1;

    private String field2;

    private String field3;

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

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getSettStatus() {
        return settStatus;
    }

    public void setSettStatus(String settStatus) {
        this.settStatus = settStatus == null ? null : settStatus.trim();
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
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
    
    @Override
	public String toString() {
		return "CmpaySettDetail [orderId=" + orderId + ", inchannel=" + inchannel + ", merNo=" + merNo +
				", userId=" + userId + ", transAmt=" + transAmt + ", transType=" + transType + 
				", transDate=" + transDate + ", payChannel=" + payChannel + ", payStatus=" + payStatus
				+ ",settStatus=" + settStatus + ", batchId=" + batchId + ", createTime=" + createTime 
				+ ",modifyTime=" + modifyTime + ", version=" + version + ", remark=" + remark +
				", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
    }
}