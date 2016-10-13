package com.cmpay.boss.entity;

import java.util.Date;

public class SYSUSRDO {
    private String usrId;

    private String usrName;

    private String usrPwd;

    private String usrRemark;

    private String usrDisableTag;

    private String usrEmail;

    private String usrType;

    private String usrCreateBy;

    private Date createTime;

    private String usrUpdateBy;

    private Date updateTime;

    private Date endTime;

    private String deleteStatus;

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId == null ? null : usrId.trim();
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName == null ? null : usrName.trim();
    }

    public String getUsrPwd() {
        return usrPwd;
    }

    public void setUsrPwd(String usrPwd) {
        this.usrPwd = usrPwd == null ? null : usrPwd.trim();
    }

    public String getUsrRemark() {
        return usrRemark;
    }

    public void setUsrRemark(String usrRemark) {
        this.usrRemark = usrRemark == null ? null : usrRemark.trim();
    }

    public String getUsrDisableTag() {
        return usrDisableTag;
    }

    public void setUsrDisableTag(String usrDisableTag) {
        this.usrDisableTag = usrDisableTag == null ? null : usrDisableTag.trim();
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail == null ? null : usrEmail.trim();
    }

    public String getUsrType() {
        return usrType;
    }

    public void setUsrType(String usrType) {
        this.usrType = usrType == null ? null : usrType.trim();
    }

    public String getUsrCreateBy() {
        return usrCreateBy;
    }

    public void setUsrCreateBy(String usrCreateBy) {
        this.usrCreateBy = usrCreateBy == null ? null : usrCreateBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUsrUpdateBy() {
        return usrUpdateBy;
    }

    public void setUsrUpdateBy(String usrUpdateBy) {
        this.usrUpdateBy = usrUpdateBy == null ? null : usrUpdateBy.trim();
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