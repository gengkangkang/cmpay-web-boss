package com.cmpay.service.llpay.model;

import java.io.Serializable;

public class PayQueryReqBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3936878743726042032L;
	
	private String oid_partner;//商户号
	
	private String dt_order;//商户订单时间
	
	private String sign_type;//签名方式
	
	private String no_order;//商户订单号
	
	private String sign;//签名值

	public String getOid_partner() {
		return oid_partner;
	}

	public void setOid_partner(String oid_partner) {
		this.oid_partner = oid_partner;
	}

	public String getDt_order() {
		return dt_order;
	}

	public void setDt_order(String dt_order) {
		this.dt_order = dt_order;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getNo_order() {
		return no_order;
	}

	public void setNo_order(String no_order) {
		this.no_order = no_order;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	

}
