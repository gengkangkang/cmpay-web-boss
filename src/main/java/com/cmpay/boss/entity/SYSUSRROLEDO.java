package com.cmpay.boss.entity;

import java.util.Date;

public class SYSUSRROLEDO extends SYSUSRROLEDOKey {
    private String usrRoleRemark;

    private String usrRoleCreateBy;

    private Date createTime;

    private String usrRoleUpdateBy;

    private Date updateTime;

    private Date endTime;

    private String deleteStatus;

    public String getUsrRoleRemark() {
        return usrRoleRemark;
    }

    public void setUsrRoleRemark(String usrRoleRemark) {
        this.usrRoleRemark = usrRoleRemark == null ? null : usrRoleRemark.trim();
    }

    public String getUsrRoleCreateBy() {
        return usrRoleCreateBy;
    }

    public void setUsrRoleCreateBy(String usrRoleCreateBy) {
        this.usrRoleCreateBy = usrRoleCreateBy == null ? null : usrRoleCreateBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUsrRoleUpdateBy() {
        return usrRoleUpdateBy;
    }

    public void setUsrRoleUpdateBy(String usrRoleUpdateBy) {
        this.usrRoleUpdateBy = usrRoleUpdateBy == null ? null : usrRoleUpdateBy.trim();
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