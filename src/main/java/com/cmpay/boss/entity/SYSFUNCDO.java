package com.cmpay.boss.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SYSFUNCDO {
    private String funcId;

    private String funcName;

    private String funcFatherId;

    private String funcDesc;

    private String funcRemark;

    private String funcDisableTag;

    private String funcCreateBy;

    private Date createTime;

    private String funcUpdateBy;

    private Date updateTime;

    private String funcTag;

    private String funcLevel;

    private String funcUrl;

    private String funcIcon;

    private BigDecimal funcPriority;

    private Date endTime;

    private String deleteStatus;

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId == null ? null : funcId.trim();
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }

    public String getFuncFatherId() {
        return funcFatherId;
    }

    public void setFuncFatherId(String funcFatherId) {
        this.funcFatherId = funcFatherId == null ? null : funcFatherId.trim();
    }

    public String getFuncDesc() {
        return funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc == null ? null : funcDesc.trim();
    }

    public String getFuncRemark() {
        return funcRemark;
    }

    public void setFuncRemark(String funcRemark) {
        this.funcRemark = funcRemark == null ? null : funcRemark.trim();
    }

    public String getFuncDisableTag() {
        return funcDisableTag;
    }

    public void setFuncDisableTag(String funcDisableTag) {
        this.funcDisableTag = funcDisableTag == null ? null : funcDisableTag.trim();
    }

    public String getFuncCreateBy() {
        return funcCreateBy;
    }

    public void setFuncCreateBy(String funcCreateBy) {
        this.funcCreateBy = funcCreateBy == null ? null : funcCreateBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFuncUpdateBy() {
        return funcUpdateBy;
    }

    public void setFuncUpdateBy(String funcUpdateBy) {
        this.funcUpdateBy = funcUpdateBy == null ? null : funcUpdateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFuncTag() {
        return funcTag;
    }

    public void setFuncTag(String funcTag) {
        this.funcTag = funcTag == null ? null : funcTag.trim();
    }

    public String getFuncLevel() {
        return funcLevel;
    }

    public void setFuncLevel(String funcLevel) {
        this.funcLevel = funcLevel == null ? null : funcLevel.trim();
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl == null ? null : funcUrl.trim();
    }

    public String getFuncIcon() {
        return funcIcon;
    }

    public void setFuncIcon(String funcIcon) {
        this.funcIcon = funcIcon == null ? null : funcIcon.trim();
    }

    public BigDecimal getFuncPriority() {
        return funcPriority;
    }

    public void setFuncPriority(BigDecimal funcPriority) {
        this.funcPriority = funcPriority;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }
}