package com.cmpay.boss.form;

import java.math.BigDecimal;
import java.util.Date;

public class PayOrderForm extends BaseForm {
	
    private String orderId;

    private String inchannel;

    private String merNo;

    private String userId;

    private String origOrderNo;

    private String backUrl;

    private String bankCode;

    private String cardNo;

    private String city;

    private String custAcctno;

    private String custId;

    private String custName;

    private Short hasnotify;

    private Short inAcct;

    private String thirdMerchantNo;

    private Long notifyCount;

    private String notifyUrl;

    private String orderDesc;

    private String orderDt;

    private String payChanelInteracctno;

    private String payStatus;

    private String payType;

    private String payChannel;

    private String prov;

    private Short reAcct;

    private String sinpayChannelCode;

    private String subBank;

    private String thirdOrderNo;

    private BigDecimal transAmt;

    private String respCode;

    private String respMsg;

    private String thirdRespCode;

    private String thirdRespMsg;

    private String orderip;

    private Date createTime;

    private Date modifyTime;

    private Integer version;

    private String remark;

    private String field1;

    private String field2;

    private String field3;
    
    private String startTime;
    
    private String endTime;

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

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl == null ? null : backUrl.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCustAcctno() {
        return custAcctno;
    }

    public void setCustAcctno(String custAcctno) {
        this.custAcctno = custAcctno == null ? null : custAcctno.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public Short getHasnotify() {
        return hasnotify;
    }

    public void setHasnotify(Short hasnotify) {
        this.hasnotify = hasnotify;
    }

    public Short getInAcct() {
        return inAcct;
    }

    public void setInAcct(Short inAcct) {
        this.inAcct = inAcct;
    }

    public String getThirdMerchantNo() {
        return thirdMerchantNo;
    }

    public void setThirdMerchantNo(String thirdMerchantNo) {
        this.thirdMerchantNo = thirdMerchantNo == null ? null : thirdMerchantNo.trim();
    }

    public Long getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(Long notifyCount) {
        this.notifyCount = notifyCount;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
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

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov == null ? null : prov.trim();
    }

    public Short getReAcct() {
        return reAcct;
    }

    public void setReAcct(Short reAcct) {
        this.reAcct = reAcct;
    }

    public String getSinpayChannelCode() {
        return sinpayChannelCode;
    }

    public void setSinpayChannelCode(String sinpayChannelCode) {
        this.sinpayChannelCode = sinpayChannelCode == null ? null : sinpayChannelCode.trim();
    }

    public String getSubBank() {
        return subBank;
    }

    public void setSubBank(String subBank) {
        this.subBank = subBank == null ? null : subBank.trim();
    }

    public String getThirdOrderNo() {
        return thirdOrderNo;
    }

    public void setThirdOrderNo(String thirdOrderNo) {
        this.thirdOrderNo = thirdOrderNo == null ? null : thirdOrderNo.trim();
    }

    public BigDecimal getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(BigDecimal transAmt) {
        this.transAmt = transAmt;
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

	@Override
	public String toString() {
		return "PayOrderForm [orderId=" + orderId + ", inchannel=" + inchannel + ", merNo=" + merNo + ", userId="
				+ userId + ", origOrderNo=" + origOrderNo + ", backUrl=" + backUrl + ", bankCode=" + bankCode
				+ ", cardNo=" + cardNo + ", city=" + city + ", custAcctno=" + custAcctno + ", custId=" + custId
				+ ", custName=" + custName + ", hasnotify=" + hasnotify + ", inAcct=" + inAcct + ", thirdMerchantNo="
				+ thirdMerchantNo + ", notifyCount=" + notifyCount + ", notifyUrl=" + notifyUrl + ", orderDesc="
				+ orderDesc + ", orderDt=" + orderDt + ", payChanelInteracctno=" + payChanelInteracctno + ", payStatus="
				+ payStatus + ", payType=" + payType + ", payChannel=" + payChannel + ", prov=" + prov + ", reAcct="
				+ reAcct + ", sinpayChannelCode=" + sinpayChannelCode + ", subBank=" + subBank + ", thirdOrderNo="
				+ thirdOrderNo + ", transAmt=" + transAmt + ", respCode=" + respCode + ", respMsg=" + respMsg
				+ ", thirdRespCode=" + thirdRespCode + ", thirdRespMsg=" + thirdRespMsg + ", orderip=" + orderip
				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", version=" + version + ", remark="
				+ remark + ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
    
    
}
