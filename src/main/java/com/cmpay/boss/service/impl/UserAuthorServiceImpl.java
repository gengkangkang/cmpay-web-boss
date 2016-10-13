package com.cmpay.boss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.boss.domain.FuncBO;
import com.cmpay.boss.domain.RoleBO;
import com.cmpay.boss.domain.UserBO;
import com.cmpay.boss.entity.vo.SYSFUNCVO;
import com.cmpay.boss.entity.vo.SYSROLEVO;
import com.cmpay.boss.entity.vo.SYSUSRVO;
import com.cmpay.boss.mapper.UserAuthorMapper;
import com.cmpay.boss.service.UserAuthorService;

/**
 * 
 * 
 * @author xiaoxiang
 * @version $Id: UserAuthorServiceImpl.java, v 0.1 2016年9月7日 下午2:28:11 Administrator Exp $
 */
@Service("userAuthorService")
public class UserAuthorServiceImpl implements UserAuthorService {

    @Autowired
    UserAuthorMapper userAuthorMapper;

    @Override
    public UserBO getAuthorByUserId(String userId) {
        SYSUSRVO _SYSUSRVO = userAuthorMapper.getAuthorByUserId(userId);
        UserBO userBO = new UserBO();
        userBO.setUsrId(_SYSUSRVO.getUsrId());
        List<SYSROLEVO> SYSROLEVOList = _SYSUSRVO.getSYSROLEVOList();
        List<RoleBO> roleBOList = new ArrayList<>();
        for (SYSROLEVO _SYSROLEVO : SYSROLEVOList) {
            RoleBO roleBO = new RoleBO();
            roleBO.setRoleId(_SYSROLEVO.getRoleId());
            roleBO.setRoleName(_SYSROLEVO.getRoleName());
            List<SYSFUNCVO> SYSFUNCVOList = _SYSROLEVO.getSYSFUNCVOList();
            List<FuncBO> funcBOList = new ArrayList<>();
            for (SYSFUNCVO SYSFUNCVO : SYSFUNCVOList) {
                FuncBO funcBO = new FuncBO();
                funcBO.setFuncId(SYSFUNCVO.getFuncId());
                funcBO.setFuncUrl(SYSFUNCVO.getFuncUrl());
                funcBOList.add(funcBO);
            }
            roleBO.setFuncBOList(funcBOList);
            roleBOList.add(roleBO);
        }
        userBO.setRoleBOList(roleBOList);
        return userBO;
    }
}
