package com.cmpay.service.chinapay.model;


public class CpSinCutResp implements ChinapayResp{
	
	
	private String responseCode; //应答信息
	private String merId; //商户号
	private String transDate; //商户日期
	private String orderNo; //订单号
	private String transAmt; //金额
	private String curyId; //币种
	private String transType; //交易类型
	private String priv1; //私有域
	private String transStat; //代扣状态
	private String gateId; //网关号
	private String cardType; //卡折标志
	private String cardNo; //卡号/折号
	private String userNme; //持卡人姓名
	private String certType; //证件类型
	private String certId; //证件号
	private String message; //描述
	private String chkValue; //签名值
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}
	public String getCuryId() {
		return curyId;
	}
	public void setCuryId(String curyId) {
		this.curyId = curyId;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getPriv1() {
		return priv1;
	}
	public void setPriv1(String priv1) {
		this.priv1 = priv1;
	}
	public String getTransStat() {
		return transStat;
	}
	public void setTransStat(String transStat) {
		this.transStat = transStat;
	}
	public String getGateId() {
		return gateId;
	}
	public void setGateId(String gateId) {
		this.gateId = gateId;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getUserNme() {
		return userNme;
	}
	public void setUserNme(String userNme) {
		this.userNme = userNme;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getChkValue() {
		return chkValue;
	}
	public void setChkValue(String chkValue) {
		this.chkValue = chkValue;
	}
	
	@Override
	public String getOrderedDataStr() {
		String responseData = responseCode + merId + transDate + orderNo
				+ transAmt + curyId + transType + priv1 + transStat
				+ gateId + cardType + cardNo + userNme + certType + certId;
		return responseData;
	}



	
	
}
