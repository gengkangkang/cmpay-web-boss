package com.cmpay.boss.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.boss.domain.FuncBO;
import com.cmpay.boss.domain.RoleBO;
import com.cmpay.boss.entity.SYSFUNCDO;
import com.cmpay.boss.entity.SYSFUNCDOExample;
import com.cmpay.boss.entity.SYSROLEFUNCDO;
import com.cmpay.boss.entity.SYSROLEFUNCDOKey;
import com.cmpay.boss.mapper.SYSFUNCDOMapper;
import com.cmpay.boss.mapper.SYSROLEFUNCDOMapper;
import com.cmpay.boss.service.FuncService;
import com.cmpay.boss.util.Pagination;
import com.github.pagehelper.PageHelper;

/**
 *
 *
 * @author xiaoxiang
 * @version $Id: FuncServiceImpl.java, v 0.1 2016年9月7日 下午1:22:54 Administrator Exp $
 */
@Service("funcService")
public class FuncServiceImpl implements FuncService {

    private static final Logger logger = LoggerFactory.getLogger(FuncServiceImpl.class);

    @Autowired
    SYSFUNCDOMapper             _SYSFUNCDOMapper;

    @Autowired
    SYSROLEFUNCDOMapper         _SYSROLEFUNCDOMapper;

    @Override
    public Pagination<FuncBO> getFuncList(String rid) {
        List<RoleBO> roleList = new ArrayList<>();

        SYSFUNCDOExample _SYSFUNCDOExample = new SYSFUNCDOExample();
        _SYSFUNCDOExample.createCriteria().andFuncDisableTagEqualTo("1");

        int count = _SYSFUNCDOMapper.countByExample(_SYSFUNCDOExample);
        Pagination pagination = new Pagination(count, 1, 100);

        List<SYSFUNCDO> _SYSFUNCDOLIST = _SYSFUNCDOMapper.selectByExample(_SYSFUNCDOExample);

        List<FuncBO> funcBOList = new ArrayList<FuncBO>();
        for (SYSFUNCDO _SYSFUNCDO : _SYSFUNCDOLIST) {
            FuncBO funcBO = new FuncBO();
            funcBO.setFuncId(_SYSFUNCDO.getFuncId());
            funcBO.setFuncName(_SYSFUNCDO.getFuncName());
            funcBO.setFuncDesc(_SYSFUNCDO.getFuncDesc());
            funcBO.setFuncRemark(_SYSFUNCDO.getFuncRemark());
            funcBO.setFuncDisableTag(_SYSFUNCDO.getFuncDisableTag());
            SYSROLEFUNCDOKey _SYSROLEFUNCDOKey = new SYSROLEFUNCDOKey();
            _SYSROLEFUNCDOKey.setFuncId(funcBO.getFuncId());
            _SYSROLEFUNCDOKey.setRoleId(rid);
            SYSROLEFUNCDO _SYSROLEFUNCDO = _SYSROLEFUNCDOMapper
                .selectByPrimaryKey(_SYSROLEFUNCDOKey);
            if (_SYSROLEFUNCDO == null) {
                funcBO.setChecked("未授权");
            } else {
                funcBO.setChecked("已授权");
            }
            funcBOList.add(funcBO);
        }
        pagination.addResult(funcBOList);
        return pagination;
    }

    @Override
    public Map setFuncEnable(String funcId) throws Exception {
        Map resultMap = new HashMap();
        SYSFUNCDOExample functionDOExample = new SYSFUNCDOExample();
        functionDOExample.createCriteria().andFuncIdEqualTo(funcId);
        SYSFUNCDO functionDO = new SYSFUNCDO();
        functionDO.setFuncDisableTag("1");
        _SYSFUNCDOMapper.updateByExampleSelective(functionDO, functionDOExample);
        resultMap.put("statusCode", 200);
        resultMap.put("message", "操作成功!");
        resultMap.put("closeCurrent", true);

        return resultMap;

    }

    @Override
    public Map setFuncDisable(String funcId) throws Exception {
        Map resultMap = new HashMap();
        SYSFUNCDOExample functionDOExample = new SYSFUNCDOExample();
        functionDOExample.createCriteria().andFuncIdEqualTo(funcId);
        SYSFUNCDO functionDO = new SYSFUNCDO();
        functionDO.setFuncDisableTag("0");
        _SYSFUNCDOMapper.updateByExampleSelective(functionDO, functionDOExample);
        resultMap.put("statusCode", 200);
        resultMap.put("message", "操作成功!");
        resultMap.put("closeCurrent", true);


        return resultMap;

    }

    @Override
    public Pagination<FuncBO> getTheFunc(FuncBO funcBO) {
        List<RoleBO> userList = new ArrayList<>();

        SYSFUNCDOExample SYSFUNCDOExample = new SYSFUNCDOExample();
        SYSFUNCDOExample.Criteria cri = SYSFUNCDOExample.createCriteria();
        if (!(funcBO.getFuncName() == null || funcBO.getFuncName().trim().equals(""))) {
            cri.andFuncNameEqualTo(funcBO.getFuncName());
        }

        int count = _SYSFUNCDOMapper.countByExample(SYSFUNCDOExample);
        Pagination pagination = new Pagination(count, funcBO.getPageCurrent(),
            funcBO.getPageSize());
        PageHelper.startPage(funcBO.getPageCurrent(), funcBO.getPageSize());
        List<SYSFUNCDO> functionDOList = _SYSFUNCDOMapper.selectByExample(SYSFUNCDOExample);

        List<FuncBO> funcBOList = new ArrayList<>();
        for (SYSFUNCDO functionDO : functionDOList) {
            FuncBO funcBO1 = new FuncBO();
            funcBO1.setFuncId(functionDO.getFuncId());
            funcBO1.setFuncName(functionDO.getFuncName());
            funcBO1.setFuncFatherId(functionDO.getFuncFatherId());
            funcBO1.setFuncDesc(functionDO.getFuncDesc());
            funcBO1.setFuncRemark(functionDO.getFuncRemark());
            if (functionDO.getFuncDisableTag().trim().equals("1")) {
                funcBO1.setFuncDisableTag("启用");
            } else {
                funcBO1.setFuncDisableTag("禁用");
            }
            funcBO1.setFuncTag(functionDO.getFuncTag());
            funcBO1.setFuncLevel(functionDO.getFuncLevel());
            funcBO1.setFuncUrl(functionDO.getFuncUrl());
            funcBO1.setFuncIcon(functionDO.getFuncIcon());
            funcBO1.setFuncPriority(functionDO.getFuncPriority());
            funcBOList.add(funcBO1);
        }
        pagination.addResult(funcBOList);

        return pagination;

    }

    @Override
    public Pagination<FuncBO> getAllFunc(FuncBO funcBO) {
        List<RoleBO> userList = new ArrayList<>();

        SYSFUNCDOExample SYSFUNCDOExample = new SYSFUNCDOExample();
        SYSFUNCDOExample.Criteria cri = SYSFUNCDOExample.createCriteria();

        int count = _SYSFUNCDOMapper.countByExample(SYSFUNCDOExample);
        Pagination pagination = new Pagination(count, funcBO.getPageCurrent(),
            funcBO.getPageSize());
        PageHelper.startPage(funcBO.getPageCurrent(), funcBO.getPageSize());
        List<SYSFUNCDO> functionDOList = _SYSFUNCDOMapper.selectByExample(SYSFUNCDOExample);

        List<FuncBO> funcBOList = new ArrayList<>();
        for (SYSFUNCDO functionDO : functionDOList) {
            FuncBO funcBO1 = new FuncBO();
            funcBO1.setFuncId(functionDO.getFuncId());
            funcBO1.setFuncName(functionDO.getFuncName());
            funcBO1.setFuncFatherId(functionDO.getFuncFatherId());
            funcBO1.setFuncDesc(functionDO.getFuncDesc());
            funcBO1.setFuncRemark(functionDO.getFuncRemark());
            //            funcBO1.setFuncDisableTag(functionDO.getFuncDisableTag());
            if (functionDO.getFuncDisableTag().trim().equals("1")) {
                funcBO1.setFuncDisableTag("启用");
            } else {
                funcBO1.setFuncDisableTag("禁用");
            }
            funcBO1.setFuncTag(functionDO.getFuncTag());
            funcBO1.setFuncLevel(functionDO.getFuncLevel());
            funcBO1.setFuncUrl(functionDO.getFuncUrl());
            funcBO1.setFuncIcon(functionDO.getFuncIcon());
            funcBO1.setFuncPriority(functionDO.getFuncPriority());
            funcBOList.add(funcBO1);
        }
        pagination.addResult(funcBOList);

        return pagination;

    }

    @Override
    public Map addNewFunc(FuncBO funcBO) {
        Map resultMap = new HashMap();

        SYSFUNCDO _SYSFUNCDO = new SYSFUNCDO();
        _SYSFUNCDO.setFuncId(funcBO.getFuncId());
        _SYSFUNCDO.setFuncName(funcBO.getFuncName());
        _SYSFUNCDO.setFuncFatherId(funcBO.getFuncFatherId());
        _SYSFUNCDO.setFuncDesc(funcBO.getFuncDesc());
        _SYSFUNCDO.setFuncDisableTag(funcBO.getFuncDisableTag());
        _SYSFUNCDO.setFuncTag(funcBO.getFuncTag());
        _SYSFUNCDO.setFuncLevel(funcBO.getFuncLevel());
        _SYSFUNCDO.setFuncUrl(funcBO.getFuncUrl());
        _SYSFUNCDO.setFuncIcon(funcBO.getFuncIcon());
        _SYSFUNCDO.setFuncPriority(funcBO.getFuncPriority());
        int rt = _SYSFUNCDOMapper.insertSelective(_SYSFUNCDO);
        if (rt != 0) {
            resultMap.put("statusCode", 200);
            resultMap.put("message", "操作成功!");
            resultMap.put("closeCurrent", true);
            resultMap.put("tabid", "table, table-fixed");
//            resultMap.put("forward", "/funcManagement/query_all_func");
        } else {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");
            resultMap.put("closeCurrent", false);
            resultMap.put("tabid", "table, table-fixed");
//            resultMap.put("forward", "/funcManagement/query_all_func");


        }
        return resultMap;

    }

    @Override
    public FuncBO getById(String funcId) {
        SYSFUNCDOExample _SYSFUNCDOExample = new SYSFUNCDOExample();
        _SYSFUNCDOExample.createCriteria().andFuncIdEqualTo(funcId);
        List<SYSFUNCDO> SYSFUNCDOList = _SYSFUNCDOMapper.selectByExample(_SYSFUNCDOExample);
        return convertFuncDOToFuncBO(SYSFUNCDOList.get(0));
    }

    private FuncBO convertFuncDOToFuncBO(SYSFUNCDO SYSFUNCDO) {
        FuncBO funcBO = new FuncBO();
        funcBO.setFuncId(SYSFUNCDO.getFuncId());
        funcBO.setFuncName(SYSFUNCDO.getFuncName());
        funcBO.setFuncFatherId(SYSFUNCDO.getFuncFatherId());
        funcBO.setFuncDesc(SYSFUNCDO.getFuncDesc());
        funcBO.setFuncRemark(SYSFUNCDO.getFuncRemark());
        funcBO.setFuncDisableTag(SYSFUNCDO.getFuncDisableTag());
        funcBO.setFuncTag(SYSFUNCDO.getFuncTag());
        funcBO.setFuncLevel(SYSFUNCDO.getFuncLevel());
        funcBO.setFuncUrl(SYSFUNCDO.getFuncUrl());
        funcBO.setFuncIcon(SYSFUNCDO.getFuncIcon());
        funcBO.setFuncPriority(SYSFUNCDO.getFuncPriority());
        return funcBO;
    }

    @Override
	public Map updateFuncInfo(FuncBO funcBO) {
        Map resultMap = new HashMap();

        SYSFUNCDOExample functionDOExample = new SYSFUNCDOExample();
        functionDOExample.createCriteria().andFuncIdEqualTo(funcBO.getFuncId());
        SYSFUNCDO functionDO = new SYSFUNCDO();
        functionDO.setFuncFatherId(funcBO.getFuncFatherId());
        functionDO.setFuncDesc(funcBO.getFuncDesc());
        functionDO.setFuncRemark(funcBO.getFuncRemark());
        functionDO.setFuncDisableTag(funcBO.getFuncDisableTag());
        functionDO.setFuncTag(funcBO.getFuncTag());
        functionDO.setFuncLevel(funcBO.getFuncLevel());
        functionDO.setFuncUrl(funcBO.getFuncUrl());
        functionDO.setFuncIcon(funcBO.getFuncIcon());
        functionDO.setFuncPriority(funcBO.getFuncPriority());
        try {
            _SYSFUNCDOMapper.updateByExampleSelective(functionDO, functionDOExample);
            resultMap.put("statusCode", 200);
            resultMap.put("message", "操作成功!");
            resultMap.put("closeCurrent", true);

        } catch (Exception ex) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");
            resultMap.put("closeCurrent", true);

        }

        return resultMap;
    }

}
