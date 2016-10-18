package com.cmpay.service.chinapay.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author shenxw
 *
 */
public class CpSinPayReq implements ChinapaySfjReq{
	private String merId; // 商户号
	private String merDate; // 商户日期
	private String merSeqId; // 商户流水号
	private String cardNo; // 收款账号
	private String usrName; // 收款人姓名
	private String openBank; // 开户银行
	private String prov; // 省份
	private String city; // 城市
	private String transAmt; // 金额
	private String purpose; // 用途
	private String subBank; // 支行
	private String flag; // 付款标志
	private String version; // 版本号
	private String signFlag; // 签名标志
	private String chkValue; // 签名值

	public String getString4Chk() {
		return new StringBuffer(merId).append(merDate)
		.append(merSeqId).append(cardNo)
		.append(usrName).append(openBank)
		.append(prov).append(city)
		.append(transAmt).append(purpose)
		.append(subBank)
		.append(flag)
		.append(version).toString();
	}
	
    public Map<String, String> convertToMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("merId",merId);
        map.put("merDate",merDate);
        map.put("merSeqId",merSeqId);
        map.put("cardNo",cardNo);
        map.put("usrName",usrName);
        map.put("openBank",openBank);
        map.put("prov",prov);
        map.put("city",city);
        map.put("transAmt",transAmt);
        map.put("purpose",purpose);
        map.put("subBank",subBank);
        map.put("flag",flag);
        map.put("version",version);
        map.put("signFlag",signFlag);
        map.put("chkValue",chkValue);
        return map;
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

	public String getOpenBank() {
		return openBank;
	}

	public void setOpenBank(String openBank) {
		this.openBank = openBank;
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

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getSubBank() {
		return subBank;
	}

	public void setSubBank(String subBank) {
		this.subBank = subBank;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSignFlag() {
		return signFlag;
	}

	public void setSignFlag(String signFlag) {
		this.signFlag = signFlag;
	}

	public String getChkValue() {
		return chkValue;
	}

	public void setChkValue(String chkValue) {
		this.chkValue = chkValue;
	}

	@Override
	public String toString() {
		return "CpSinPayReq [merId=" + merId + ", merDate=" + merDate + ", merSeqId=" + merSeqId + ", cardNo=" + cardNo + ", usrName=" + usrName + ", openBank=" + openBank + ", prov=" + prov
				+ ", city=" + city + ", transAmt=" + transAmt + ", purpose=" + purpose + ", subBank=" + subBank + ", flag=" + flag + ", version=" + version + ", signFlag=" + signFlag + ", chkValue="
				+ chkValue + "]";
	}


	

	
}
