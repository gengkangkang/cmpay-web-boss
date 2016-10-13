package com.cmpay.boss.service;


import java.util.Map;

import com.cmpay.boss.domain.RoleBO;
import com.cmpay.boss.util.Pagination;

/**
 * Created by fireWorks on 2016/2/2.
 */
public interface RoleService {

    public Pagination<RoleBO> getRoleList(String uid);

    RoleBO getById(String roleId);

    Map addNewRole(RoleBO roleBO);

    Pagination<RoleBO> getAllRole(RoleBO roleBO);

    Pagination<RoleBO> getTheRole(RoleBO roleBO);

    Map setRoleDisable(String roleId) throws Exception;

    Map setRoleEnable(String roleId) throws Exception;

    Map cancelRoleResouce(String sid,String rid) throws Exception;

    Map addRoleResouce(String sid,String rid) throws Exception;

}
