package org.pay.service.jytpay.model;

import java.io.Serializable;

public class CpSinCutRespDef implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7193480377529728970L;
	private String responseCode; // 应答信息
	private String transStat; // 代扣状态
	private String message; // 描述
	private Integer cutOrderNo;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getTransStat() {
		return transStat;
	}

	public void setTransStat(String transStat) {
		this.transStat = transStat;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCutOrderNo() {
		return cutOrderNo;
	}

	public void setCutOrderNo(Integer cutOrderNo) {
		this.cutOrderNo = cutOrderNo;
	}

}
