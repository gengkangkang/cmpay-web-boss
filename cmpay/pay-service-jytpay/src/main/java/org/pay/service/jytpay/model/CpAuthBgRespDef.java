package org.pay.service.jytpay.model;

import java.io.Serializable;

public class CpAuthBgRespDef implements Serializable{
	
	private static final long serialVersionUID = 966666236636901357L;
	
	/**
	 * 验证应答码
	 */
	private String respCode;
	
	/**
	 * 应答信息
	 */
	private String respMsg;
	
	/**
	 * 签名验证通过结果
	 */
	private Boolean signVerified;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public Boolean getSignVerified() {
		return signVerified;
	}

	public void setSignVerified(Boolean signVerified) {
		this.signVerified = signVerified;
	}
}
