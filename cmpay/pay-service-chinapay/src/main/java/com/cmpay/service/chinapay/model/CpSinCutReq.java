package com.cmpay.service.chinapay.model;

import java.util.HashMap;
import java.util.Map;

public class CpSinCutReq implements ChinapaySfjReq{
	
	private String merId;
	
	private String transDate;
	
	private String orderNo;
	
	private String transType;
	
	private String openBankId;
	
	private String cardType;
	
	private String cardNo;
	
	private String usrName;
	
	private String certType;
	
	private String certId;
	
	private String curyId;
	
	private String transAmt;
	
	private String purpose;
	
	private String priv1;
	
	private String version;
	
	private String gateId;
	
	private String chkValue;

	public String getString4Chk() {
		return merId + transDate + orderNo + transType + openBankId + cardType 
				+ cardNo + usrName + certType + certId + curyId + transAmt
				+ purpose + priv1 + version + gateId;
	}
	
    public Map<String, String> convertToMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("merId", merId);
        map.put("transDate", transDate);
        map.put("orderNo", orderNo);
        map.put("transType", transType);
        map.put("openBankId", openBankId);
        map.put("cardType", cardType);
        map.put("cardNo", cardNo);
        map.put("usrName", usrName);
        map.put("certType", certType);
        map.put("certId", certId);
        map.put("curyId", curyId);
        map.put("transAmt", transAmt);
        
        map.put("purpose", purpose);
        map.put("priv1", priv1);

        map.put("version", version);
        map.put("gateId", gateId);
        map.put("chkValue", chkValue);
        return map;
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

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getOpenBankId() {
		return openBankId;
	}

	public void setOpenBankId(String openBankId) {
		this.openBankId = openBankId;
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

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
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

	public String getCuryId() {
		return curyId;
	}

	public void setCuryId(String curyId) {
		this.curyId = curyId;
	}

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getGateId() {
		return gateId;
	}

	public void setGateId(String gateId) {
		this.gateId = gateId;
	}

	public String getChkValue() {
		return chkValue;
	}

	public void setChkValue(String chkValue) {
		this.chkValue = chkValue;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getPriv1() {
		return priv1;
	}

	public void setPriv1(String priv1) {
		this.priv1 = priv1;
	}


	
}
