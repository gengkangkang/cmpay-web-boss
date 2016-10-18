package com.cmpay.service.chinapay.model;

public class CpAuthBgResp {
	String	appSysId; //应用系统编号
	String	signMethod; //签名方法
	String	signature; //签名信息
	String	usrSysId; //客户号
	String	email; //邮箱
	String	mobile; //手机号
	String	cardNo; //卡号
	String	certType; //证件类型
	String	certNo; //证件号
	String	usrName; //证件姓名
	String	cardCvn2; //CVN2
	String	cardExpire; //卡有效期
	String	cardPhone; //卡关联手机号
	String	respcode; //响应码
	String	respmsg; //响应信息
	
	public String getAppSysId() {
		return appSysId;
	}
	public void setAppSysId(String appSysId) {
		this.appSysId = appSysId;
	}
	public String getSignMethod() {
		return signMethod;
	}
	public void setSignMethod(String signMethod) {
		this.signMethod = signMethod;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getUsrSysId() {
		return usrSysId;
	}
	public void setUsrSysId(String usrSysId) {
		this.usrSysId = usrSysId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getCardCvn2() {
		return cardCvn2;
	}
	public void setCardCvn2(String cardCvn2) {
		this.cardCvn2 = cardCvn2;
	}
	public String getCardExpire() {
		return cardExpire;
	}
	public void setCardExpire(String cardExpire) {
		this.cardExpire = cardExpire;
	}
	public String getCardPhone() {
		return cardPhone;
	}
	public void setCardPhone(String cardPhone) {
		this.cardPhone = cardPhone;
	}
	public String getRespcode() {
		return respcode;
	}
	public void setRespcode(String respcode) {
		this.respcode = respcode;
	}
	public String getRespmsg() {
		return respmsg;
	}
	public void setRespmsg(String respmsg) {
		this.respmsg = respmsg;
	}
	
	
}
