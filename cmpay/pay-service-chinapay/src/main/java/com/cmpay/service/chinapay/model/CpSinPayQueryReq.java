package com.cmpay.service.chinapay.model;

import java.util.HashMap;
import java.util.Map;

public class CpSinPayQueryReq implements ChinapaySfjReq{
	
	private String merId;
	
	private String merDate;
	
	private String merSeqId;
	
	private String version;
	
	private String signFlag;
	
	private String chkValue;

	@Override
	public String getString4Chk() {
		return new StringBuffer(merId).append(merDate)
				.append(merSeqId).append(version).toString();
	}

	@Override
	public Map<String, String> convertToMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("merId", merId);
		map.put("merDate", merDate);
		map.put("merSeqId", merSeqId);
		map.put("version", version);
		map.put("signFlag", signFlag);
		map.put("chkValue", chkValue);
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
		return "CpSinPayQueryReq [merId=" + merId + ", merDate=" + merDate + ", merSeqId=" + merSeqId + ", version=" + version + ", signFlag=" + signFlag + ", chkValue=" + chkValue + "]";
	}
	
	

}
