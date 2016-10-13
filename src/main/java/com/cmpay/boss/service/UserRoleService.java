package com.cmpay.boss.service;

import java.util.List;

import com.cmpay.boss.domain.RoleBO;

/**
 * 
 * 
 * @author Administrator
 * @version $Id: UserRoleService.java, v 0.1 2016年9月7日 上午9:55:13 Administrator Exp $
 */
public interface UserRoleService {
    List<RoleBO> getRolesByUserId(String userId);
}
