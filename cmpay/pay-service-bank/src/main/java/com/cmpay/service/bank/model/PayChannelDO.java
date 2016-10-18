package com.cmpay.service.bank.model;

import com.cmpay.service.bank.base.BaseDO;

public class PayChannelDO extends BaseDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1282905011565807098L;

	private String code;

	private String name;

	private String openStatus;

	private String inOutSupport;

	private String cardTypeSupport;

	private String cardAuthOpenStatus;

	private String inMethod;

	private String merchNo;

	private Integer priority;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	public String getInOutSupport() {
		return inOutSupport;
	}

	public void setInOutSupport(String inOutSupport) {
		this.inOutSupport = inOutSupport;
	}

	public String getCardTypeSupport() {
		return cardTypeSupport;
	}

	public void setCardTypeSupport(String cardTypeSupport) {
		this.cardTypeSupport = cardTypeSupport;
	}

	public String getCardAuthOpenStatus() {
		return cardAuthOpenStatus;
	}

	public void setCardAuthOpenStatus(String cardAuthOpenStatus) {
		this.cardAuthOpenStatus = cardAuthOpenStatus;
	}

	public String getInMethod() {
		return inMethod;
	}

	public void setInMethod(String inMethod) {
		this.inMethod = inMethod;
	}

	public String getMerchNo() {
		return merchNo;
	}

	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}