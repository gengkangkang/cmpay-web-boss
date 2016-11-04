package com.cmpay.boss.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SuppBankBO extends BaseBO {
    private String id;

    private String pcBankCode;

    private String pcBankName;

    private String payChannelCode;

    private String payBankCode;

    private BigDecimal singleMaxAmount;

    private BigDecimal singleMinAmount;

    private BigDecimal dayMaxAmount;

    private Integer dayMaxTimes;

    private BigDecimal monthMaxAmount;

    private Integer monthMaxTimes;

    private String status;

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

    public String getPcBankCode() {
        return pcBankCode;
    }

    public void setPcBankCode(String pcBankCode) {
        this.pcBankCode = pcBankCode == null ? null : pcBankCode.trim();
    }

    public String getPcBankName() {
        return pcBankName;
    }

    public void setPcBankName(String pcBankName) {
        this.pcBankName = pcBankName == null ? null : pcBankName.trim();
    }

    public String getPayChannelCode() {
        return payChannelCode;
    }

    public void setPayChannelCode(String payChannelCode) {
        this.payChannelCode = payChannelCode == null ? null : payChannelCode.trim();
    }

    public String getPayBankCode() {
        return payBankCode;
    }

    public void setPayBankCode(String payBankCode) {
        this.payBankCode = payBankCode == null ? null : payBankCode.trim();
    }

    public BigDecimal getSingleMaxAmount() {
        return singleMaxAmount;
    }

    public void setSingleMaxAmount(BigDecimal singleMaxAmount) {
        this.singleMaxAmount = singleMaxAmount;
    }

    public BigDecimal getSingleMinAmount() {
        return singleMinAmount;
    }

    public void setSingleMinAmount(BigDecimal singleMinAmount) {
        this.singleMinAmount = singleMinAmount;
    }

    public BigDecimal getDayMaxAmount() {
        return dayMaxAmount;
    }

    public void setDayMaxAmount(BigDecimal dayMaxAmount) {
        this.dayMaxAmount = dayMaxAmount;
    }

    public Integer getDayMaxTimes() {
        return dayMaxTimes;
    }

    public void setDayMaxTimes(Integer dayMaxTimes) {
        this.dayMaxTimes = dayMaxTimes;
    }

    public BigDecimal getMonthMaxAmount() {
        return monthMaxAmount;
    }

    public void setMonthMaxAmount(BigDecimal monthMaxAmount) {
        this.monthMaxAmount = monthMaxAmount;
    }

    public Integer getMonthMaxTimes() {
        return monthMaxTimes;
    }

    public void setMonthMaxTimes(Integer monthMaxTimes) {
        this.monthMaxTimes = monthMaxTimes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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