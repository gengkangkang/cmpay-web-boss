package com.cmpay.boss.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CutOrderBO extends BaseBO {
    private String id;

    private String orderId;

    private String inchannel;

    private String merNo;

    private String userId;

    private String origOrderNo;

    private BigDecimal transAmt;

    private String transType;

    private String payChannel;

    private String payStatus;

    private String custName;

    private String idNo;

    private String idType;

    private String cardNo;

    private String bankCode;

    private String inAcct;

    private String isAcct;

    private String notifyUrl;

    private Integer notifyCount;

    private String hasnotify;

    private String returnUrl;

    private String nameGoods;

    private String orderDesc;

    private String orderDt;

    private String payChanelInteracctno;

    private String thirdOrderNo;

    private String toAcctNo;

    private String userregDt;

    private String respCode;

    private String respMsg;

    private String thirdRespCode;

    private String thirdRespMsg;

    private Long period;

    private Date expireTime;

    private String orderip;

    private Date createTime;

    private Date modifyTime;

    private Integer version;

    private String remark;

    private String field1;

    private String field2;

    private String field3;

    private String preAuditor;

    private Date preAuditTime;

    private String recheckAuditor;

    private Date recheckAuditTime;

    //参数时间
    private Date startTime;
    private Date endTime;

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

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getInAcct() {
        return inAcct;
    }

    public void setInAcct(String inAcct) {
        this.inAcct = inAcct == null ? null : inAcct.trim();
    }

    public String getIsAcct() {
        return isAcct;
    }

    public void setIsAcct(String isAcct) {
        this.isAcct = isAcct == null ? null : isAcct.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public Integer getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(Integer notifyCount) {
        this.notifyCount = notifyCount;
    }

    public String getHasnotify() {
        return hasnotify;
    }

    public void setHasnotify(String hasnotify) {
        this.hasnotify = hasnotify == null ? null : hasnotify.trim();
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
    }

    public String getNameGoods() {
        return nameGoods;
    }

    public void setNameGoods(String nameGoods) {
        this.nameGoods = nameGoods == null ? null : nameGoods.trim();
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc == null ? null : orderDesc.trim();
    }

    public String getOrderDt() {
        return orderDt;
    }

    public void setOrderDt(String orderDt) {
        this.orderDt = orderDt == null ? null : orderDt.trim();
    }

    public String getPayChanelInteracctno() {
        return payChanelInteracctno;
    }

    public void setPayChanelInteracctno(String payChanelInteracctno) {
        this.payChanelInteracctno = payChanelInteracctno == null ? null : payChanelInteracctno.trim();
    }

    public String getThirdOrderNo() {
        return thirdOrderNo;
    }

    public void setThirdOrderNo(String thirdOrderNo) {
        this.thirdOrderNo = thirdOrderNo == null ? null : thirdOrderNo.trim();
    }

    public String getToAcctNo() {
        return toAcctNo;
    }

    public void setToAcctNo(String toAcctNo) {
        this.toAcctNo = toAcctNo == null ? null : toAcctNo.trim();
    }

    public String getUserregDt() {
        return userregDt;
    }

    public void setUserregDt(String userregDt) {
        this.userregDt = userregDt == null ? null : userregDt.trim();
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

    public String getThirdRespMsg() {
        return thirdRespMsg;
    }

    public void setThirdRespMsg(String thirdRespMsg) {
        this.thirdRespMsg = thirdRespMsg == null ? null : thirdRespMsg.trim();
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

    public String getPreAuditor() {
        return preAuditor;
    }

    public void setPreAuditor(String preAuditor) {
        this.preAuditor = preAuditor == null ? null : preAuditor.trim();
    }

    public Date getPreAuditTime() {
        return preAuditTime;
    }

    public void setPreAuditTime(Date preAuditTime) {
        this.preAuditTime = preAuditTime;
    }

    public String getRecheckAuditor() {
        return recheckAuditor;
    }

    public void setRecheckAuditor(String recheckAuditor) {
        this.recheckAuditor = recheckAuditor == null ? null : recheckAuditor.trim();
    }

    public Date getRecheckAuditTime() {
        return recheckAuditTime;
    }

    public void setRecheckAuditTime(Date recheckAuditTime) {
        this.recheckAuditTime = recheckAuditTime;
    }

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "CutOrderBO [id=" + id + ", orderId=" + orderId + ", inchannel=" + inchannel + ", merNo=" + merNo
				+ ", userId=" + userId + ", origOrderNo=" + origOrderNo + ", transAmt=" + transAmt + ", transType="
				+ transType + ", payChannel=" + payChannel + ", payStatus=" + payStatus + ", custName=" + custName
				+ ", idNo=" + idNo + ", idType=" + idType + ", cardNo=" + cardNo + ", bankCode=" + bankCode
				+ ", inAcct=" + inAcct + ", isAcct=" + isAcct + ", notifyUrl=" + notifyUrl + ", notifyCount="
				+ notifyCount + ", hasnotify=" + hasnotify + ", returnUrl=" + returnUrl + ", nameGoods=" + nameGoods
				+ ", orderDesc=" + orderDesc + ", orderDt=" + orderDt + ", payChanelInteracctno=" + payChanelInteracctno
				+ ", thirdOrderNo=" + thirdOrderNo + ", toAcctNo=" + toAcctNo + ", userregDt=" + userregDt
				+ ", respCode=" + respCode + ", respMsg=" + respMsg + ", thirdRespCode=" + thirdRespCode
				+ ", thirdRespMsg=" + thirdRespMsg + ", period=" + period + ", expireTime=" + expireTime + ", orderip="
				+ orderip + ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", version=" + version
				+ ", remark=" + remark + ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3
				+ ", preAuditor=" + preAuditor + ", preAuditTime=" + preAuditTime + ", recheckAuditor=" + recheckAuditor
				+ ", recheckAuditTime=" + recheckAuditTime + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}