package com.cmpay.service.chinapay.model;

import java.util.HashMap;
import java.util.Map;

public class CpSinCutQueryReq implements ChinapaySfjReq{
	
	private String merId;
	
	private String transType;
	
	private String orderNo;
	
	private String transDate;
	
	private String version;
	
	private String priv1;
	
	private String chkValue;

	@Override
	public String getString4Chk() {
		return new StringBuffer(merId).append(transType)
				.append(orderNo).append(transDate).append(version).toString();
	}

	@Override
	public Map<String, String> convertToMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("merId", merId);
		map.put("transType", transType);
		map.put("orderNo", orderNo);
		map.put("transDate", transDate);
		map.put("version", version);
		map.put("priv1", priv1);
		map.put("chkValue", chkValue);
		return map;
	}

	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPriv1() {
		return priv1;
	}

	public void setPriv1(String priv1) {
		this.priv1 = priv1;
	}

	public String getChkValue() {
		return chkValue;
	}

	public void setChkValue(String chkValue) {
		this.chkValue = chkValue;
	}
	
	

}
