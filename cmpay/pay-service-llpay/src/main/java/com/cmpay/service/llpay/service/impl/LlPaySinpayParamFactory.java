package com.cmpay.service.llpay.service.impl;

/**
 * 连连代付参数构造类
 * @author zy
 *
 */
public class LlPaySinpayParamFactory {
	
	private String serverPay;
	
	private String traderMd5key;
	
	private String traderRsaPrikey;
	
	private String payApiVersion;
	
	private String payOidPartner;
	
	private String paySignType;
	
	private String payFlagCard;
	
	private String payNotifyUrl;
	
	private String payQueryUrl;
	
	private String payYtPubKey;

	public String getServerPay() {
		return serverPay;
	}

	public void setServerPay(String serverPay) {
		this.serverPay = serverPay;
	}

	public String getTraderMd5key() {
		return traderMd5key;
	}

	public void setTraderMd5key(String traderMd5key) {
		this.traderMd5key = traderMd5key;
	}

	public String getTraderRsaPrikey() {
		return traderRsaPrikey;
	}

	public void setTraderRsaPrikey(String traderRsaPrikey) {
		this.traderRsaPrikey = traderRsaPrikey;
	}

	public String getPayApiVersion() {
		return payApiVersion;
	}

	public void setPayApiVersion(String payApiVersion) {
		this.payApiVersion = payApiVersion;
	}

	public String getPayOidPartner() {
		return payOidPartner;
	}

	public void setPayOidPartner(String payOidPartner) {
		this.payOidPartner = payOidPartner;
	}

	public String getPaySignType() {
		return paySignType;
	}

	public void setPaySignType(String paySignType) {
		this.paySignType = paySignType;
	}

	public String getPayFlagCard() {
		return payFlagCard;
	}

	public void setPayFlagCard(String payFlagCard) {
		this.payFlagCard = payFlagCard;
	}

	public String getPayNotifyUrl() {
		return payNotifyUrl;
	}

	public void setPayNotifyUrl(String payNotifyUrl) {
		this.payNotifyUrl = payNotifyUrl;
	}

	public String getPayQueryUrl() {
		return payQueryUrl;
	}

	public void setPayQueryUrl(String payQueryUrl) {
		this.payQueryUrl = payQueryUrl;
	}

	public String getPayYtPubKey() {
		return payYtPubKey;
	}

	public void setPayYtPubKey(String payYtPubKey) {
		this.payYtPubKey = payYtPubKey;
	}
	
	

}
