package com.cmpay.boss.domain;

import java.util.Date;

public class ChannelConfigBO extends BaseBO{
	   
	    private String id;

	    private String merNo;

	    private String paychannelNo;

	    private String paychannelName;

	    private String appid;

	    private String appsectet;

	    private String apptype;

	    private String partnerkey;

	    private String rsaprikey;

	    private String rsapubkey;

	    private String deskey;

	    private String thirdMerid;

	    private String returnUrl;

	    private String notifyUrl;

	    private Date createTime;

	    private String creator;

	    private Date modifyTime;

	    private String modifier;

	    private Integer version;

	    private String remark;

	    private String field1;

	    private String field2;

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id == null ? null : id.trim();
	    }

	    public String getMerNo() {
	        return merNo;
	    }

	    public void setMerNo(String merNo) {
	        this.merNo = merNo == null ? null : merNo.trim();
	    }

	    public String getPaychannelNo() {
	        return paychannelNo;
	    }

	    public void setPaychannelNo(String paychannelNo) {
	        this.paychannelNo = paychannelNo == null ? null : paychannelNo.trim();
	    }

	    public String getPaychannelName() {
	        return paychannelName;
	    }

	    public void setPaychannelName(String paychannelName) {
	        this.paychannelName = paychannelName == null ? null : paychannelName.trim();
	    }

	    public String getAppid() {
	        return appid;
	    }

	    public void setAppid(String appid) {
	        this.appid = appid == null ? null : appid.trim();
	    }

	    public String getAppsectet() {
	        return appsectet;
	    }

	    public void setAppsectet(String appsectet) {
	        this.appsectet = appsectet == null ? null : appsectet.trim();
	    }

	    public String getApptype() {
	        return apptype;
	    }

	    public void setApptype(String apptype) {
	        this.apptype = apptype == null ? null : apptype.trim();
	    }

	    public String getPartnerkey() {
	        return partnerkey;
	    }

	    public void setPartnerkey(String partnerkey) {
	        this.partnerkey = partnerkey == null ? null : partnerkey.trim();
	    }

	    public String getRsaprikey() {
	        return rsaprikey;
	    }

	    public void setRsaprikey(String rsaprikey) {
	        this.rsaprikey = rsaprikey == null ? null : rsaprikey.trim();
	    }

	    public String getRsapubkey() {
	        return rsapubkey;
	    }

	    public void setRsapubkey(String rsapubkey) {
	        this.rsapubkey = rsapubkey == null ? null : rsapubkey.trim();
	    }

	    public String getDeskey() {
	        return deskey;
	    }

	    public void setDeskey(String deskey) {
	        this.deskey = deskey == null ? null : deskey.trim();
	    }

	    public String getThirdMerid() {
	        return thirdMerid;
	    }

	    public void setThirdMerid(String thirdMerid) {
	        this.thirdMerid = thirdMerid == null ? null : thirdMerid.trim();
	    }

	    public String getReturnUrl() {
	        return returnUrl;
	    }

	    public void setReturnUrl(String returnUrl) {
	        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
	    }

	    public String getNotifyUrl() {
	        return notifyUrl;
	    }

	    public void setNotifyUrl(String notifyUrl) {
	        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
	    }

	    public Date getCreateTime() {
	        return createTime;
	    }

	    public void setCreateTime(Date createTime) {
	        this.createTime = createTime;
	    }

	    public String getCreator() {
	        return creator;
	    }

	    public void setCreator(String creator) {
	        this.creator = creator == null ? null : creator.trim();
	    }

	    public Date getModifyTime() {
	        return modifyTime;
	    }

	    public void setModifyTime(Date modifyTime) {
	        this.modifyTime = modifyTime;
	    }

	    public String getModifier() {
	        return modifier;
	    }

	    public void setModifier(String modifier) {
	        this.modifier = modifier == null ? null : modifier.trim();
	    }

	    public Integer getVersion() {
	        return version;
	    }

	    public void setVersion(Integer version) {
	        this.version = version;
	    }

	    public String getRemark() {
	        return remark;
	    }

	    public void setRemark(String remark) {
	        this.remark = remark == null ? null : remark.trim();
	    }

	    public String getField1() {
	        return field1;
	    }

	    public void setField1(String field1) {
	        this.field1 = field1 == null ? null : field1.trim();
	    }

	    public String getField2() {
	        return field2;
	    }

	    public void setField2(String field2) {
	        this.field2 = field2 == null ? null : field2.trim();
	    }

		@Override
		public String toString() {
			return "ChannelConfigBO [id=" + id + ", merNo=" + merNo + ", paychannelNo=" + paychannelNo
					+ ", paychannelName=" + paychannelName + ", appid=" + appid + ", appsectet=" + appsectet
					+ ", apptype=" + apptype + ", partnerkey=" + partnerkey + ", rsaprikey=" + rsaprikey
					+ ", rsapubkey=" + rsapubkey + ", deskey=" + deskey + ", thirdMerid=" + thirdMerid + ", returnUrl="
					+ returnUrl + ", notifyUrl=" + notifyUrl + ", createTime=" + createTime + ", creator=" + creator
					+ ", modifyTime=" + modifyTime + ", modifier=" + modifier + ", version=" + version + ", remark="
					+ remark + ", field1=" + field1 + ", field2=" + field2 + "]";
		}

}
