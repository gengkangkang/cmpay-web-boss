package com.cmpay.service.chinapay.model;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * @author shenxw
 *
 */
public class TransactionInf {
	private String merId; // 商户号
	private String cardNo; // 收款账号
	private String usrName; // 收款人姓名
	private String openBankId;
	private String openBankName; // 开户银行
	private String subBank; // 支行
	private String prov; // 省份
	private String city; // 城市
	private BigDecimal transAmt; // 金额
	private String purpose; // 用途
	private Date transDate; // 商户日期、交易日期
	private String orderNo; // 商户流水号、订单号
	private String transType;
	private String cardType;
	private String idType;
	private String idNo;
	private String currencyCd;
	private Integer txnNo;
	public Integer getTxnNo() {
		return txnNo;
	}
	public void setTxnNo(Integer txnNo) {
		this.txnNo = txnNo;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getOpenBankId() {
		return openBankId;
	}
	public void setOpenBankId(String openBankId) {
		this.openBankId = openBankId;
	}
	public String getOpenBankName() {
		return openBankName;
	}
	public void setOpenBankName(String openBankName) {
		this.openBankName = openBankName;
	}
	public String getSubBank() {
		return subBank;
	}
	public void setSubBank(String subBank) {
		this.subBank = subBank;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public BigDecimal getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(BigDecimal transAmt) {
		this.transAmt = transAmt;
	}
	

	
}
