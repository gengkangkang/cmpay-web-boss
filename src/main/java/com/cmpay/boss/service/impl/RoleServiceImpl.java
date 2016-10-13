package com.cmpay.boss.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.boss.domain.RoleBO;
import com.cmpay.boss.entity.SYSFUNCDO;
import com.cmpay.boss.entity.SYSFUNCDOExample;
import com.cmpay.boss.entity.SYSROLEDO;
import com.cmpay.boss.entity.SYSROLEDOExample;
import com.cmpay.boss.entity.SYSROLEFUNCDO;
import com.cmpay.boss.entity.SYSROLEFUNCDOKey;
import com.cmpay.boss.entity.SYSUSRROLEDO;
import com.cmpay.boss.entity.SYSUSRROLEDOKey;
import com.cmpay.boss.mapper.SYSFUNCDOMapper;
import com.cmpay.boss.mapper.SYSROLEDOMapper;
import com.cmpay.boss.mapper.SYSROLEFUNCDOMapper;
import com.cmpay.boss.mapper.SYSUSRROLEDOMapper;
import com.cmpay.boss.service.RoleService;
import com.cmpay.boss.util.Pagination;
import com.github.pagehelper.PageHelper;

/**
 *
 *
 * @author xiaoxiang
 * @version $Id: RoleServiceImpl.java, v 0.1 2016年9月7日 上午11:41:37 Administrator Exp $
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    SYSROLEDOMapper     _SYSROLEDOMapper;

    @Autowired
    SYSUSRROLEDOMapper  _SYSUSRROLEDOMapper;

    @Autowired
    SYSFUNCDOMapper     _SYSFUNCDOMapper;

    @Autowired
    SYSROLEFUNCDOMapper _SYSROLEFUNCDOMapper;

    @Override
    public Pagination<RoleBO> getRoleList(String uid) {
        List<RoleBO> roleList = new ArrayList<>();

        SYSROLEDOExample _SYSROLEDOExample = new SYSROLEDOExample();
        _SYSROLEDOExample.createCriteria().andRoleDisableTagEqualTo("1");

        int count = _SYSROLEDOMapper.countByExample(_SYSROLEDOExample);
        Pagination pagination = new Pagination(count, 1, 100);

        List<SYSROLEDO> _SYSROLEDOLIST = _SYSROLEDOMapper.selectByExample(_SYSROLEDOExample);

        List<RoleBO> roleBOList = new ArrayList<RoleBO>();
        for (SYSROLEDO _SYSROLEDO : _SYSROLEDOLIST) {
            RoleBO roleBO = new RoleBO();
            roleBO.setRoleId(_SYSROLEDO.getRoleId());
            roleBO.setRoleName(_SYSROLEDO.getRoleName());
            roleBO.setRoleRemark(_SYSROLEDO.getRoleRemark());
            roleBO.setRoleDisableTag(_SYSROLEDO.getRoleDisableTag());
            SYSUSRROLEDOKey _SYSUSRROLEDOKey = new SYSUSRROLEDOKey();
            _SYSUSRROLEDOKey.setUsrId(uid);
            _SYSUSRROLEDOKey.setRoleId(roleBO.getRoleId());
            SYSUSRROLEDO usrRoleDO = _SYSUSRROLEDOMapper.selectByPrimaryKey(_SYSUSRROLEDOKey);
            if (usrRoleDO == null) {
                roleBO.setChecked("未授权");
            } else {
                roleBO.setChecked("已授权");
            }
            roleBOList.add(roleBO);
        }
        pagination.addResult(roleBOList);

        return pagination;
    }

    @Override
    public Map addRoleResouce(String sid, String rid) throws Exception {
        Map resultMap = new HashMap();

        SYSFUNCDOExample _SYSFUNCDOExample = new SYSFUNCDOExample();
        SYSFUNCDO _SYSFUNCDO = _SYSFUNCDOMapper.selectByPrimaryKey(sid);

        SYSROLEFUNCDO _SYSROLEFUNCDO = new SYSROLEFUNCDO();
        _SYSROLEFUNCDO.setRoleId(rid);
        _SYSROLEFUNCDO.setFuncId(sid);
        _SYSROLEFUNCDO.setRoleFuncRemark(_SYSFUNCDO.getFuncDesc());
        _SYSROLEFUNCDOMapper.insertSelective(_SYSROLEFUNCDO);
        resultMap.put("statusCode", 200);
        resultMap.put("message", "操作成功!");
        resultMap.put("closeCurrent", true);

        return resultMap;
    }

    @Override
    public Map cancelRoleResouce(String sid, String rid) throws Exception {

        Map resultMap = new HashMap();
        SYSROLEFUNCDOKey _SYSROLEFUNCDOKey = new SYSROLEFUNCDOKey();
        _SYSROLEFUNCDOKey.setFuncId(sid);
        _SYSROLEFUNCDOKey.setRoleId(rid);
        _SYSROLEFUNCDOMapper.deleteByPrimaryKey(_SYSROLEFUNCDOKey);
        resultMap.put("statusCode", 200);
        resultMap.put("message", "操作成功!");
        resultMap.put("closeCurrent", true);

        return resultMap;
    }

    @Override
    public Map setRoleEnable(String roleId) throws Exception {
        Map resultMap = new HashMap();
        SYSROLEDOExample _SYSROLEDOExample = new SYSROLEDOExample();
        _SYSROLEDOExample.createCriteria().andRoleIdEqualTo(roleId);
        SYSROLEDO roleDO = new SYSROLEDO();
        roleDO.setRoleDisableTag("1");
        _SYSROLEDOMapper.updateByExampleSelective(roleDO, _SYSROLEDOExample);
        resultMap.put("statusCode", 200);
        resultMap.put("message", "操作成功!");
        resultMap.put("closeCurrent", true);

        return resultMap;
    }

    @Override
    public Map setRoleDisable(String roleId) throws Exception {
        Map resultMap = new HashMap();
        SYSROLEDOExample _SYSROLEDOExample = new SYSROLEDOExample();
        _SYSROLEDOExample.createCriteria().andRoleIdEqualTo(roleId);
        SYSROLEDO roleDO = new SYSROLEDO();
        roleDO.setRoleDisableTag("0");
        _SYSROLEDOMapper.updateByExampleSelective(roleDO, _SYSROLEDOExample);
        resultMap.put("statusCode", 200);
        resultMap.put("message", "操作成功!");
        resultMap.put("closeCurrent", true);

        return resultMap;
    }

    @Override
    public Pagination<RoleBO> getTheRole(RoleBO roleBO) {

        SYSROLEDOExample _SYSROLEDOExample = new SYSROLEDOExample();
        SYSROLEDOExample.Criteria cri = _SYSROLEDOExample.createCriteria();
        if (!(roleBO.getRoleName() == null || roleBO.getRoleName().trim().equals(""))) {
            cri.andRoleNameEqualTo(roleBO.getRoleName());
        }

        int count = _SYSROLEDOMapper.countByExample(_SYSROLEDOExample);
        Pagination pagination = new Pagination(count, roleBO.getPageCurrent(),
            roleBO.getPageSize());
        PageHelper.startPage(roleBO.getPageCurrent(), roleBO.getPageSize());
        List<SYSROLEDO> roleDOList = _SYSROLEDOMapper.selectByExample(_SYSROLEDOExample);

        List<RoleBO> roleBOList = new ArrayList<>();
        for (SYSROLEDO roleDO : roleDOList) {
            RoleBO roleBO1 = new RoleBO();
            roleBO1.setRoleId(roleDO.getRoleId());
            roleBO1.setRoleName(roleDO.getRoleName());
            if (roleDO.getRoleDisableTag().trim().equals("1")) {
                roleBO1.setRoleDisableTag("启用");
            } else {
                roleBO1.setRoleDisableTag("禁用");
            }
            roleBO1.setRoleRemark(roleDO.getRoleRemark());
            roleBOList.add(roleBO1);
        }
        pagination.addResult(roleBOList);

        return pagination;

    }

    @Override
    public Pagination<RoleBO> getAllRole(RoleBO roleBO) {
        List<RoleBO> userList = new ArrayList<>();

        SYSROLEDOExample _SYSROLEDOExample = new SYSROLEDOExample();
        SYSROLEDOExample.Criteria cri = _SYSROLEDOExample.createCriteria();
        int count = _SYSROLEDOMapper.countByExample(_SYSROLEDOExample);
        Pagination pagination = new Pagination(count, roleBO.getPageCurrent(),
            roleBO.getPageSize());
        PageHelper.startPage(roleBO.getPageCurrent(), roleBO.getPageSize());
        List<SYSROLEDO> roleDOList = _SYSROLEDOMapper.selectByExample(_SYSROLEDOExample);

        List<RoleBO> roleBOList = new ArrayList<>();
        for (SYSROLEDO roleDO : roleDOList) {
            RoleBO roleBO1 = new RoleBO();
            roleBO1.setRoleId(roleDO.getRoleId());
            roleBO1.setRoleName(roleDO.getRoleName());
            if (roleDO.getRoleDisableTag().trim().equals("1")) {
                roleBO1.setRoleDisableTag("启用");
            } else {
                roleBO1.setRoleDisableTag("禁用");
            }
            roleBO1.setRoleRemark(roleDO.getRoleRemark());
            roleBOList.add(roleBO1);
        }
        pagination.addResult(roleBOList);

        return pagination;

    }

    @Override
    public Map addNewRole(RoleBO roleBO) {
        Map resultMap = new HashMap();

        SYSROLEDO _SYSROLEDO = new SYSROLEDO();
        _SYSROLEDO.setRoleName(roleBO.getRoleName());
        _SYSROLEDO.setRoleRemark(roleBO.getRoleRemark());
        _SYSROLEDO.setRoleId(roleBO.getRoleId());
        _SYSROLEDO.setRoleDisableTag(roleBO.getRoleDisableTag());
        int rt = _SYSROLEDOMapper.insertSelective(_SYSROLEDO);
        if (rt != 0) {
            resultMap.put("statusCode", 200);
            resultMap.put("message", "操作成功!");
            resultMap.put("closeCurrent", true);

        } else {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");
            resultMap.put("closeCurrent", true);

        }
        return resultMap;
    }

    @Override
    public RoleBO getById(String roleId) {
        SYSROLEDOExample _SYSROLEDOExample = new SYSROLEDOExample();
        _SYSROLEDOExample.createCriteria().andRoleIdEqualTo(roleId);
        List<SYSROLEDO> SYSROLEDOList = _SYSROLEDOMapper.selectByExample(_SYSROLEDOExample);
        return convertRoleDOToRoleBO(SYSROLEDOList.get(0));
    }

    private RoleBO convertRoleDOToRoleBO(SYSROLEDO SYSROLEDO) {
        RoleBO roleBO = new RoleBO();
        roleBO.setRoleId(SYSROLEDO.getRoleId());
        roleBO.setRoleName(SYSROLEDO.getRoleName());
        roleBO.setRoleRemark(SYSROLEDO.getRoleRemark());
        roleBO.setRoleDisableTag(SYSROLEDO.getRoleDisableTag());
        return roleBO;
    }
}
