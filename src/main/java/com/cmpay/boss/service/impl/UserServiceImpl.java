package com.cmpay.boss.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cmpay.boss.domain.UserBO;
import com.cmpay.boss.entity.SYSROLEDO;
import com.cmpay.boss.entity.SYSROLEDOExample;
import com.cmpay.boss.entity.SYSUSRDO;
import com.cmpay.boss.entity.SYSUSRDOExample;
import com.cmpay.boss.entity.SYSUSRROLEDO;
import com.cmpay.boss.entity.SYSUSRROLEDOKey;
import com.cmpay.boss.mapper.SYSROLEDOMapper;
import com.cmpay.boss.mapper.SYSUSRDOMapper;
import com.cmpay.boss.mapper.SYSUSRROLEDOMapper;
import com.cmpay.boss.service.UserService;
import com.cmpay.boss.util.Pagination;
import com.github.pagehelper.PageHelper;

/**
 * Created by APPLE on 15/12/27.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    SYSUSRDOMapper              _SYSUSRDOMapper;

    @Autowired
    SYSUSRROLEDOMapper          _SYSUSRROLEDOMapper;

    @Autowired
    SYSROLEDOMapper             _SYSROLEDOMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserBO getByName(String username) {
        SYSUSRDOExample _SYSUSRDOExample = new SYSUSRDOExample();
        _SYSUSRDOExample.createCriteria().andUsrNameEqualTo(username);
        List<SYSUSRDO> _SYSUSRDOLIST = new ArrayList<>();
        try {
            _SYSUSRDOLIST = _SYSUSRDOMapper.selectByExample(_SYSUSRDOExample);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return convertUsrDOToUserBO(_SYSUSRDOLIST.get(0));
    }

    @Override
    public UserBO getById(String usrId) {
        SYSUSRDOExample _SYSUSRDOExample = new SYSUSRDOExample();
        _SYSUSRDOExample.createCriteria().andUsrIdEqualTo(usrId);
        List<SYSUSRDO> _SYSUSRDOLIST = _SYSUSRDOMapper.selectByExample(_SYSUSRDOExample);
        return convertUsrDOToUserBO(_SYSUSRDOLIST.get(0));
    }

    @Override
    public Map updatePwd(UserBO userBO) {
        SYSUSRDOExample _SYSUSRDOExample = new SYSUSRDOExample();
        _SYSUSRDOExample.createCriteria().andUsrIdEqualTo(userBO.getUsrId())
            .andUsrNameEqualTo(userBO.getUsrName()).andUsrPwdEqualTo(userBO.getUsrPwd());
        List<SYSUSRDO> _SYSUSRDOLIST = _SYSUSRDOMapper.selectByExample(_SYSUSRDOExample);
        Map resultMap = new HashMap();
        if (_SYSUSRDOLIST == null || _SYSUSRDOLIST.size() == 0) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "旧密码错误!");
            resultMap.put("closeCurrent", true);
            return resultMap;
        }
        SYSUSRDO _SYSUSRDO = new SYSUSRDO();
        _SYSUSRDO.setUsrId(userBO.getUsrId());
        _SYSUSRDO.setUsrPwd(userBO.getPass());
        _SYSUSRDO.setUpdateTime(new Date());
        _SYSUSRDO.setUsrUpdateBy(userBO.getUsrUpdateBy());
        _SYSUSRDOMapper.updateByPrimaryKeySelective(_SYSUSRDO);

        resultMap.put("statusCode", 200);
        resultMap.put("message", "操作成功!");
        resultMap.put("closeCurrent", true);

        return resultMap;
    }

    @Override
    public Map addNewUsr(UserBO userBO) {
        Map resultMap = new HashMap();
        Date date = new Date();

        SYSUSRDO _SYSUSRDO = new SYSUSRDO();
        _SYSUSRDO.setUsrPwd(userBO.getUsrPwd());
        _SYSUSRDO.setUsrName(userBO.getUsrName());
        _SYSUSRDO.setUsrId(userBO.getUsrId());
        _SYSUSRDO.setUsrDisableTag(userBO.getUsrDisableTag());
        if (userBO.getUsrType() != null && !userBO.getUsrType().trim().equals("")) {
            _SYSUSRDO.setUsrType(userBO.getUsrType());
            SYSROLEDOExample _SYSROLEDOExample = new SYSROLEDOExample();
            _SYSROLEDOExample.createCriteria().andRoleNameEqualTo(userBO.getUsrType());
            List<SYSROLEDO> _SYSROLEDOLIST = _SYSROLEDOMapper.selectByExample(_SYSROLEDOExample);
            if (_SYSROLEDOLIST != null && _SYSROLEDOLIST.size() != 0) {
                try {
                    addAcctAuthority(_SYSROLEDOLIST.get(0).getRoleId(), userBO.getUsrId());
                } catch (DataIntegrityViolationException ex) {
                    logger.info("角色已分配:" + ex.getMessage());
                    resultMap.put("statusCode", 300);
                    resultMap.put("message", "角色已分配!");
                    resultMap.put("closeCurrent", true);

                } catch (Exception ex) {
                    resultMap.put("statusCode", 300);
                    resultMap.put("message", "账号类型失败!");
                    resultMap.put("closeCurrent", true);

                    return resultMap;
                }
            }
        }

        _SYSUSRDO.setUsrRemark(userBO.getUsrRemark());
        _SYSUSRDO.setCreateTime(date);
        _SYSUSRDO.setUpdateTime(date);
        _SYSUSRDO.setUsrCreateBy(userBO.getUsrCreateBy());
        _SYSUSRDO.setUsrUpdateBy(userBO.getUsrUpdateBy());
        _SYSUSRDO.setDeleteStatus("0");

        int rt = _SYSUSRDOMapper.insertSelective(_SYSUSRDO);
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
    public Pagination<UserBO> getAllUsr(UserBO userBO) {
        SYSUSRDOExample _SYSUSRDOExample = new SYSUSRDOExample();
        _SYSUSRDOExample.createCriteria();
        int count = _SYSUSRDOMapper.countByExample(_SYSUSRDOExample);
        Pagination pagination = new Pagination(count, userBO.getPageCurrent(),
            userBO.getPageSize());
        PageHelper.startPage(userBO.getPageCurrent(), userBO.getPageSize());
        List<UserBO> userList = new ArrayList<UserBO>();
        List<SYSUSRDO> _SYSUSRDOLIST = _SYSUSRDOMapper.selectByExample(_SYSUSRDOExample);
        for (SYSUSRDO _SYSUSRDO : _SYSUSRDOLIST) {
            UserBO user = new UserBO();
            user.setUsrId(_SYSUSRDO.getUsrId());
            user.setUsrName(_SYSUSRDO.getUsrName());
            user.setUsrPwd(_SYSUSRDO.getUsrPwd());
            user.setUsrRemark(_SYSUSRDO.getUsrRemark());
            if (_SYSUSRDO.getUsrDisableTag().trim().equals("1")) {
                user.setUsrDisableTag("启用");
            } else {
                user.setUsrDisableTag("禁用");
            }
            user.setUsrEmail(_SYSUSRDO.getUsrEmail());
            userList.add(user);
        }
        pagination.addResult(userList);
        return pagination;
    }

    @Override
    public Pagination<UserBO> getTheUsr(UserBO userBO) {
        SYSUSRDOExample _SYSUSRDOExample = new SYSUSRDOExample();
        SYSUSRDOExample.Criteria cri = _SYSUSRDOExample.createCriteria();
        if (!(StringUtils.isEmpty(userBO.getUsrName()))) {
            cri.andUsrNameEqualTo(userBO.getUsrName());
        }

        int count = _SYSUSRDOMapper.countByExample(_SYSUSRDOExample);
        Pagination pagination = new Pagination(count, userBO.getPageCurrent(),
            userBO.getPageSize());
        PageHelper.startPage(userBO.getPageCurrent(), userBO.getPageSize());
        List<UserBO> userBOList = new ArrayList<UserBO>();
        List<SYSUSRDO> usrDOList = _SYSUSRDOMapper.selectByExample(_SYSUSRDOExample);
        for (SYSUSRDO _SYSUSRDO : usrDOList) {
            UserBO user = new UserBO();
            user.setUsrId(_SYSUSRDO.getUsrId());
            user.setUsrName(_SYSUSRDO.getUsrName());
            user.setUsrPwd(_SYSUSRDO.getUsrPwd());
            user.setUsrRemark(_SYSUSRDO.getUsrRemark());
            if (_SYSUSRDO.getUsrDisableTag().trim().equals("1")) {
                user.setUsrDisableTag("启用");
            } else {
                user.setUsrDisableTag("禁用");
            }
            user.setUsrEmail(_SYSUSRDO.getUsrEmail());
            userBOList.add(user);
        }
        pagination.addResult(userBOList);
        return pagination;
    }

    private UserBO convertUsrDOToUserBO(SYSUSRDO _SYSUSRDO) {
        UserBO userBO = new UserBO();
        userBO.setUsrId(_SYSUSRDO.getUsrId());
        userBO.setUsrName(_SYSUSRDO.getUsrName());
        userBO.setUsrPwd(_SYSUSRDO.getUsrPwd());
        userBO.setUsrDisableTag(_SYSUSRDO.getUsrDisableTag());
        return userBO;
    }

    @Override
    public Map setAcctEnable(String usrId) throws Exception {
        Map resultMap = new HashMap();
        SYSUSRDOExample _SYSUSRDOExample = new SYSUSRDOExample();
        _SYSUSRDOExample.createCriteria().andUsrIdEqualTo(usrId);
        SYSUSRDO _SYSUSRDO = new SYSUSRDO();
        _SYSUSRDO.setUsrDisableTag("1");
        _SYSUSRDOMapper.updateByExampleSelective(_SYSUSRDO, _SYSUSRDOExample);
        resultMap.put("statusCode", 200);
        resultMap.put("message", "操作成功!");
        resultMap.put("closeCurrent", true);

        return resultMap;
    }

    @Override
    public Map setAcctDisable(String usrId) throws Exception {
        Map resultMap = new HashMap();
        SYSUSRDOExample _SYSUSRDOExample = new SYSUSRDOExample();
        _SYSUSRDOExample.createCriteria().andUsrIdEqualTo(usrId);
        SYSUSRDO _SYSUSRDO = new SYSUSRDO();
        _SYSUSRDO.setUsrDisableTag("0");
        _SYSUSRDOMapper.updateByExampleSelective(_SYSUSRDO, _SYSUSRDOExample);
        resultMap.put("statusCode", 200);
        resultMap.put("message", "操作成功!");
        resultMap.put("closeCurrent", true);

        return resultMap;
    }

    @Override
    public Map cancelAcctAuthority(String id, String uid) throws Exception {

        Map resultMap = new HashMap();
        SYSUSRROLEDOKey _SYSUSRROLEDOKey = new SYSUSRROLEDOKey();
        _SYSUSRROLEDOKey.setUsrId(uid);
        _SYSUSRROLEDOKey.setRoleId(id);
        _SYSUSRROLEDOMapper.deleteByPrimaryKey(_SYSUSRROLEDOKey);
        resultMap.put("statusCode", 200);
        resultMap.put("message", "操作成功!");
        resultMap.put("closeCurrent", true);

        return resultMap;
    }

    @Override
    public Map addAcctAuthority(String id, String uid) {
        Map resultMap = new HashMap();
        Date date = new Date();

        SYSROLEDOExample _SYSROLEDOExample = new SYSROLEDOExample();
        SYSROLEDO _SYSROLEDO = _SYSROLEDOMapper.selectByPrimaryKey(id);

        SYSUSRROLEDO _SYSUSRROLEDO = new SYSUSRROLEDO();
        _SYSUSRROLEDO.setUsrId(uid);
        _SYSUSRROLEDO.setRoleId(id);
        _SYSUSRROLEDO.setUsrRoleRemark(_SYSROLEDO.getRoleName());
        _SYSUSRROLEDO.setCreateTime(date);
        _SYSUSRROLEDO.setUpdateTime(date);
        _SYSUSRROLEDOMapper.insertSelective(_SYSUSRROLEDO);
        resultMap.put("statusCode", 200);
        resultMap.put("message", "操作成功!");
        resultMap.put("closeCurrent", true);

        return resultMap;
    }

}
