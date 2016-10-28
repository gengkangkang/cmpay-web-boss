package com.cmpay.boss.domain;

import java.util.Date;

public class PayChannelBO extends BaseBO {
    private String id;

    private String code;

    private String name;

    private String flag;

    private String priority;

    private String openStatus;

    private String inOutSupport;

    private String cardTypeSupport;

    private String cardAuthOpenStatus;

    private String inMethod;

    private String merchNo;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifyTime;

    private Integer version;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public String getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus == null ? null : openStatus.trim();
    }

    public String getInOutSupport() {
        return inOutSupport;
    }

    public void setInOutSupport(String inOutSupport) {
        this.inOutSupport = inOutSupport == null ? null : inOutSupport.trim();
    }

    public String getCardTypeSupport() {
        return cardTypeSupport;
    }

    public void setCardTypeSupport(String cardTypeSupport) {
        this.cardTypeSupport = cardTypeSupport == null ? null : cardTypeSupport.trim();
    }

    public String getCardAuthOpenStatus() {
        return cardAuthOpenStatus;
    }

    public void setCardAuthOpenStatus(String cardAuthOpenStatus) {
        this.cardAuthOpenStatus = cardAuthOpenStatus == null ? null : cardAuthOpenStatus.trim();
    }

    public String getInMethod() {
        return inMethod;
    }

    public void setInMethod(String inMethod) {
        this.inMethod = inMethod == null ? null : inMethod.trim();
    }

    public String getMerchNo() {
        return merchNo;
    }

    public void setMerchNo(String merchNo) {
        this.merchNo = merchNo == null ? null : merchNo.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
}