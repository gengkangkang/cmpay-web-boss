package com.cmpay.service.chinapay.model;

import java.io.Serializable;

public class CpSinPayRespDef implements Serializable{
	
	private static final long serialVersionUID = 199799610866671745L;
	
	private String responseCode; //	4位	是	请求应答码，具体请见附录6.1.1
	private String stat; //	1位	否	交易状态码，具体请参看附录6.1.2
	private String respMsg;
	private String transStat;
	private Integer payOrderNo;
	private String cpDate;//ChinaPay接收到交易的日期
	private String cpSeqId;//ChinaPay系统内部流水
	private String thirdPartOrderNo;//第三方支付订单号
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public Integer getPayOrderNo() {
		return payOrderNo;
	}
	public void setPayOrderNo(Integer payOrderNo) {
		this.payOrderNo = payOrderNo;
	}
	public String getTransStat() {
		return transStat;
	}
	public void setTransStat(String transStat) {
		this.transStat = transStat;
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
	public String getThirdPartOrderNo() {
		return thirdPartOrderNo;
	}
	public void setThirdPartOrderNo(String thirdPartOrderNo) {
		this.thirdPartOrderNo = thirdPartOrderNo;
	}
	
	
	
}
