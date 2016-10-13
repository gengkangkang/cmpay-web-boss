package com.cmpay.boss.entity;

import java.util.Date;

public class SYSROLEFUNCDO extends SYSROLEFUNCDOKey {
    private String roleFuncRemark;

    private String roleFuncCreateBy;

    private Date createTime;

    private String roleFuncUpdateBy;

    private Date updateTime;

    private Date endTime;

    private String deleteStatus;

    public String getRoleFuncRemark() {
        return roleFuncRemark;
    }

    public void setRoleFuncRemark(String roleFuncRemark) {
        this.roleFuncRemark = roleFuncRemark == null ? null : roleFuncRemark.trim();
    }

    public String getRoleFuncCreateBy() {
        return roleFuncCreateBy;
    }

    public void setRoleFuncCreateBy(String roleFuncCreateBy) {
        this.roleFuncCreateBy = roleFuncCreateBy == null ? null : roleFuncCreateBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRoleFuncUpdateBy() {
        return roleFuncUpdateBy;
    }

    public void setRoleFuncUpdateBy(String roleFuncUpdateBy) {
        this.roleFuncUpdateBy = roleFuncUpdateBy == null ? null : roleFuncUpdateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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