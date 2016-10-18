package com.cmpay.service.chinapay.model;


public class CpSinPayResp  {
	
	private String responseCode; //	4位	是	请求应答码，具体请见附录6.1.1
	private String merId; //	15位	否	同请求报文参数中的商户号
	private String merDate; //	8位	否	同请求报文参数中的商户日期
	private String merSeqId; //	16位	否	同请求报文参数中的商户流水号
	private String cpDate; //	8位	否	ChinaPay接收到交易的日期
	private String cpSeqId; //	6位	否	ChinaPay系统内部流水
	private String transAmt; //	12位	否	同请求报文参数中的金额
	private String stat; //	1位	否	交易状态码，具体请参看附录6.1.2
	private String cardNo; //	32位	否	同请求报文参数中的收款账号
	private String chkValue; //	256位	是	对返回字串的签名。返回应答报文中最后一个“&”符号以前的都是作为签名的明文。明文需进行BASE64编码
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
	public String getMerDate() {
		return merDate;
	}
	public void setMerDate(String merDate) {
		this.merDate = merDate;
	}
	public String getMerSeqId() {
		return merSeqId;
	}
	public void setMerSeqId(String merSeqId) {
		this.merSeqId = merSeqId;
	}
	public String getCpDate() {
		return cpDate;
	}
	public void setCpDate(String cpDate) {
		this.cpDate = cpDate;
	}
	public String getCpSeqId() {
		return cpSeqId;
	}
	public void setCpSeqId(String cpSeqId) {
		this.cpSeqId = cpSeqId;
	}
	public String getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getChkValue() {
		return chkValue;
	}
	public void setChkValue(String chkValue) {
		this.chkValue = chkValue;
	}

}
