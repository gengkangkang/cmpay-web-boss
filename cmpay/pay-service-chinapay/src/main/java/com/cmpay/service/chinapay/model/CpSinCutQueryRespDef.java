package com.cmpay.service.chinapay.model;

import java.io.Serializable;

public class CpSinCutQueryRespDef implements Serializable{
	
	
	private static final long serialVersionUID = 7294052708921149455L;

	private String responseCode;
	
	private String message;
	
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
