package com.cmpay.service.llpay.service.impl;

/**
 * 连连支付参数构造类
 * @author zy
 *
 */
public class LlPaySincutParamFactory {
	
	private String payUrl;
	
	private String queryUserBankcardUrl;

	private String queryBankcardUrl;
	
	private String yTPubKey;
	
	private String traderPriKey;
	
	private String md5Key;
	
	private String notifyUrl;
	
	private String oidPartner;
	
	private String signType;
	
	private String version;
	
	private String busiPartner;
	
	private String orderValid;
	
	private String orderQueryUrl;

	public String getPayUrl() {
		return payUrl;
	}

	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}

	public String getQueryUserBankcardUrl() {
		return queryUserBankcardUrl;
	}

	public void setQueryUserBankcardUrl(String queryUserBankcardUrl) {
		this.queryUserBankcardUrl = queryUserBankcardUrl;
	}

	public String getQueryBankcardUrl() {
		return queryBankcardUrl;
	}

	public void setQueryBankcardUrl(String queryBankcardUrl) {
		this.queryBankcardUrl = queryBankcardUrl;
	}

	public String getyTPubKey() {
		return yTPubKey;
	}

	public void setyTPubKey(String yTPubKey) {
		this.yTPubKey = yTPubKey;
	}

	public String getTraderPriKey() {
		return traderPriKey;
	}

	public void setTraderPriKey(String traderPriKey) {
		this.traderPriKey = traderPriKey;
	}

	public String getMd5Key() {
		return md5Key;
	}

	public void setMd5Key(String md5Key) {
		this.md5Key = md5Key;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getOidPartner() {
		return oidPartner;
	}

	public void setOidPartner(String oidPartner) {
		this.oidPartner = oidPartner;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBusiPartner() {
		return busiPartner;
	}

	public void setBusiPartner(String busiPartner) {
		this.busiPartner = busiPartner;
	}

	public String getOrderValid() {
		return orderValid;
	}

	public void setOrderValid(String orderValid) {
		this.orderValid = orderValid;
	}

	public String getOrderQueryUrl() {
		return orderQueryUrl;
	}

	public void setOrderQueryUrl(String orderQueryUrl) {
		this.orderQueryUrl = orderQueryUrl;
	}
	
	

}
