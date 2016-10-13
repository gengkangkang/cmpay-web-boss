package com.cmpay.boss.domain;

import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author xiaoxiang
 * @version $Id: RoleBO.java, v 0.1 2016年9月7日 上午9:38:50 Administrator Exp $
 */
public class RoleBO extends BaseBO {

    private String roleId;

    private String roleName;

    private String roleDisableTag;

    private String roleRemark;

    private String roleCreateBy;

    private Date   roleCreateDatetime;

    private String roleUpdatetimeBy;

    private Date   roleUpdatetimeDatetime;

    List<FuncBO>   funcBOList;

    private String checked;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDisableTag() {
        return roleDisableTag;
    }

    public void setRoleDisableTag(String roleDisableTag) {
        this.roleDisableTag = roleDisableTag;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    public String getRoleCreateBy() {
        return roleCreateBy;
    }

    public void setRoleCreateBy(String roleCreateBy) {
        this.roleCreateBy = roleCreateBy;
    }

    public Date getRoleCreateDatetime() {
        return roleCreateDatetime;
    }

    public void setRoleCreateDatetime(Date roleCreateDatetime) {
        this.roleCreateDatetime = roleCreateDatetime;
    }

    public String getRoleUpdatetimeBy() {
        return roleUpdatetimeBy;
    }

    public void setRoleUpdatetimeBy(String roleUpdatetimeBy) {
        this.roleUpdatetimeBy = roleUpdatetimeBy;
    }

    public Date getRoleUpdatetimeDatetime() {
        return roleUpdatetimeDatetime;
    }

    public void setRoleUpdatetimeDatetime(Date roleUpdatetimeDatetime) {
        this.roleUpdatetimeDatetime = roleUpdatetimeDatetime;
    }

    public List<FuncBO> getFuncBOList() {
        return funcBOList;
    }

    public void setFuncBOList(List<FuncBO> funcBOList) {
        this.funcBOList = funcBOList;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked == null ? null : checked.trim();
    }
}
