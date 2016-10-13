package com.cmpay.boss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmpay.boss.domain.RoleBO;
import com.cmpay.boss.entity.SYSROLEDO;
import com.cmpay.boss.entity.SYSUSRROLEDO;
import com.cmpay.boss.entity.SYSUSRROLEDOExample;
import com.cmpay.boss.mapper.SYSROLEDOMapper;
import com.cmpay.boss.mapper.SYSUSRROLEDOMapper;
import com.cmpay.boss.service.UserRoleService;

/**
 * Created by APPLE on 16/1/13.
 */
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    SYSUSRROLEDOMapper _SYSUSRROLEDOMapper;

    @Autowired
    SYSROLEDOMapper    _SYSROLEDOMapper;

    @Override
    public List<RoleBO> getRolesByUserId(String userId) {
        SYSUSRROLEDOExample _SYSUSRROLEDOExample = new SYSUSRROLEDOExample();
        _SYSUSRROLEDOExample.createCriteria().andUsrIdEqualTo(userId);

        List<SYSUSRROLEDO> _SYSUSRROLEDOLIST = _SYSUSRROLEDOMapper
            .selectByExample(_SYSUSRROLEDOExample);
        List<RoleBO> roleBOList = new ArrayList<>();
        for (SYSUSRROLEDO _SYSUSRROLEDO : _SYSUSRROLEDOLIST) {
            SYSROLEDO _SYSROLEDO = _SYSROLEDOMapper.selectByPrimaryKey(_SYSUSRROLEDO.getRoleId());
            RoleBO roleBO = new RoleBO();
            BeanUtils.copyProperties(_SYSROLEDO, roleBO);
            roleBOList.add(roleBO);
        }
        return roleBOList;
    }
}
