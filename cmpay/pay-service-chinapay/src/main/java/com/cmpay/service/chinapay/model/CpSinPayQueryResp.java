package com.cmpay.service.chinapay.model;

public class CpSinPayQueryResp {
	
	private String code;
	
	private String merId;
	
	private String merDate;
	
	private String merSeqId;
	
	private String cpDate;
	
	private String cpSeqId;
	
	private String bankName;
	
	private String cardNo;
	
	private String usrName;
	
	private String transAmt;
	
	private String feeAmt;
	
	private String prov;
	
	private String city;
	
	private String purpose;
	
	private String stat;
	
	private String backDate;
	
	private String chkValue;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(String feeAmt) {
		this.feeAmt = feeAmt;
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

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getBackDate() {
		return backDate;
	}

	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}

	public String getChkValue() {
		return chkValue;
	}

	public void setChkValue(String chkValue) {
		this.chkValue = chkValue;
	}

	@Override
	public String toString() {
		return "CpSinPayQueryResp [code=" + code + ", merId=" + merId
				+ ", merDate=" + merDate + ", merSeqId=" + merSeqId
				+ ", cpDate=" + cpDate + ", cpSeqId=" + cpSeqId + ", bankName="
				+ bankName + ", cardNo=" + cardNo + ", usrName=" + usrName
				+ ", transAmt=" + transAmt + ", feeAmt=" + feeAmt + ", prov="
				+ prov + ", city=" + city + ", purpose=" + purpose + ", stat="
				+ stat + ", backDate=" + backDate + ", chkValue=" + chkValue
				+ "]";
	}
	
	

}
