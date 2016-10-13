package com.cmpay.boss.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.boss.domain.MenuBO;
import com.cmpay.boss.entity.SYSFUNCDO;
import com.cmpay.boss.entity.SYSFUNCDOExample;
import com.cmpay.boss.entity.vo.SYSFUNCVO;
import com.cmpay.boss.entity.vo.SYSROLEVO;
import com.cmpay.boss.entity.vo.SYSUSRVO;
import com.cmpay.boss.mapper.SYSFUNCDOMapper;
import com.cmpay.boss.mapper.UserAuthorMapper;
import com.cmpay.boss.service.MenuService;

/**
 * Created by APPLE on 16/1/12.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    UserAuthorMapper    userAuthorMapper;

    @Autowired
    SYSFUNCDOMapper _SYSFUNCDOMapper;

    @Override
    public List<MenuBO> getAllEnabledMenu() {
        SYSFUNCDOExample _SYSFUNCDOExample = new SYSFUNCDOExample();
        _SYSFUNCDOExample.createCriteria().andFuncDisableTagEqualTo("1").andFuncTagEqualTo("0");
        List<SYSFUNCDO> SYSFUNCDOList = _SYSFUNCDOMapper
            .selectByExample(_SYSFUNCDOExample);
        List<MenuBO> menuBOList = new ArrayList<>();
        for (SYSFUNCDO SYSFUNCDO : SYSFUNCDOList) {
            if (SYSFUNCDO.getFuncLevel().equals("1")) {
                MenuBO fMenuBO = new MenuBO();
                fMenuBO.setFuncId(SYSFUNCDO.getFuncId());
                fMenuBO.setFuncDesc(SYSFUNCDO.getFuncDesc());
                fMenuBO.setFuncFatherId(SYSFUNCDO.getFuncFatherId());
                fMenuBO.setFuncIcon(SYSFUNCDO.getFuncIcon());
                fMenuBO.setFuncLevel(SYSFUNCDO.getFuncLevel());
                fMenuBO.setFuncName(SYSFUNCDO.getFuncName());
                fMenuBO.setFuncUrl(SYSFUNCDO.getFuncUrl());
                fMenuBO.setFuncPriority(SYSFUNCDO.getFuncPriority());
                List<MenuBO> sMenuBOList = new ArrayList<>();
                for (SYSFUNCDO SYSFUNCDO2 : SYSFUNCDOList) {
                    if (SYSFUNCDO2.getFuncLevel().equals("2")
                        && SYSFUNCDO2.getFuncFatherId().equals(SYSFUNCDO.getFuncId())) {
                        MenuBO sMenuBO = new MenuBO();
                        sMenuBO.setFuncId(SYSFUNCDO2.getFuncId());
                        sMenuBO.setFuncDesc(SYSFUNCDO2.getFuncDesc());
                        sMenuBO.setFuncFatherId(SYSFUNCDO2.getFuncFatherId());
                        sMenuBO.setFuncIcon(SYSFUNCDO2.getFuncIcon());
                        sMenuBO.setFuncLevel(SYSFUNCDO2.getFuncLevel());
                        sMenuBO.setFuncName(SYSFUNCDO2.getFuncName());
                        sMenuBO.setFuncUrl(SYSFUNCDO2.getFuncUrl());
                        sMenuBO.setFuncPriority(SYSFUNCDO2.getFuncPriority());
                        List<MenuBO> tMenuBOList = new ArrayList<>();
                        for (SYSFUNCDO SYSFUNCDO3 : SYSFUNCDOList) {
                            if (SYSFUNCDO3.getFuncLevel().equals("3") && SYSFUNCDO3
                                .getFuncFatherId().equals(SYSFUNCDO2.getFuncId())) {
                                MenuBO tMenuBO = new MenuBO();
                                tMenuBO.setFuncId(SYSFUNCDO3.getFuncId());
                                tMenuBO.setFuncDesc(SYSFUNCDO3.getFuncDesc());
                                tMenuBO.setFuncFatherId(SYSFUNCDO3.getFuncFatherId());
                                tMenuBO.setFuncIcon(SYSFUNCDO3.getFuncIcon());
                                tMenuBO.setFuncLevel(SYSFUNCDO3.getFuncLevel());
                                tMenuBO.setFuncName(SYSFUNCDO3.getFuncName());
                                tMenuBO.setFuncUrl(SYSFUNCDO3.getFuncUrl());
                                tMenuBO.setFuncPriority(SYSFUNCDO3.getFuncPriority());
                                tMenuBOList.add(tMenuBO);
                                Collections.sort(tMenuBOList);
                            }
                        }
                        sMenuBO.setChildMenuBOList(tMenuBOList);
                        sMenuBOList.add(sMenuBO);
                        Collections.sort(sMenuBOList);
                    }
                }
                fMenuBO.setChildMenuBOList(sMenuBOList);
                menuBOList.add(fMenuBO);
            }
        }
        return menuBOList;
    }

    @Override
    public List<MenuBO> getAllEnabledMenuByUserId(String userid) {
        List<MenuBO> menuBOList = new ArrayList<>();
        SYSUSRVO _SYSUSRVO = userAuthorMapper.getAuthorByUserId(userid);
        if (_SYSUSRVO == null) {
            return menuBOList;
        }
        List<SYSROLEVO> SYSROLEVOList = _SYSUSRVO.getSYSROLEVOList();
        Set<SYSFUNCVO> SYSFUNCVOSet = new HashSet<>();
        for (SYSROLEVO SYSROLEVO : SYSROLEVOList) {
            List<SYSFUNCVO> SYSFUNCVOList = SYSROLEVO.getSYSFUNCVOList();
            for (SYSFUNCVO SYSFUNCVO : SYSFUNCVOList) {
                SYSFUNCVOSet.add(SYSFUNCVO);
            }
        }

        SYSFUNCDOExample _SYSFUNCDOExample = new SYSFUNCDOExample();
        _SYSFUNCDOExample.createCriteria().andFuncDisableTagEqualTo("1").andFuncTagEqualTo("0");
        List<SYSFUNCDO> _SYSFUNCDOList = _SYSFUNCDOMapper
            .selectByExample(_SYSFUNCDOExample);
        for (SYSFUNCVO SYSFUNCVO : SYSFUNCVOSet) {
            if (!SYSFUNCVO.getFuncDisableTag().equals("1") || !SYSFUNCVO.getFuncTag().equals("0")) {
                continue;
            }
            if (SYSFUNCVO.getFuncLevel().equals("1")) {
                MenuBO fMenuBO = new MenuBO();
                fMenuBO.setFuncId(SYSFUNCVO.getFuncId());
                fMenuBO.setFuncDesc(SYSFUNCVO.getFuncDesc());
                fMenuBO.setFuncFatherId(SYSFUNCVO.getFuncFatherId());
                fMenuBO.setFuncIcon(SYSFUNCVO.getFuncIcon());
                fMenuBO.setFuncLevel(SYSFUNCVO.getFuncLevel());
                fMenuBO.setFuncName(SYSFUNCVO.getFuncName());
                fMenuBO.setFuncUrl(SYSFUNCVO.getFuncUrl());
                fMenuBO.setFuncPriority(SYSFUNCVO.getFuncPriority());
                List<MenuBO> sMenuBOList = new ArrayList<>();
                for (SYSFUNCVO SYSFUNCVO2 : SYSFUNCVOSet) {
                    if (!SYSFUNCVO2.getFuncDisableTag().equals("1")
                        || !SYSFUNCVO2.getFuncTag().equals("0")) {
                        continue;
                    }
                    if (SYSFUNCVO2.getFuncLevel().equals("2")
                        && SYSFUNCVO2.getFuncFatherId().equals(SYSFUNCVO.getFuncId())) {
                        MenuBO sMenuBO = new MenuBO();
                        sMenuBO.setFuncId(SYSFUNCVO2.getFuncId());
                        sMenuBO.setFuncDesc(SYSFUNCVO2.getFuncDesc());
                        sMenuBO.setFuncFatherId(SYSFUNCVO2.getFuncFatherId());
                        sMenuBO.setFuncIcon(SYSFUNCVO2.getFuncIcon());
                        sMenuBO.setFuncLevel(SYSFUNCVO2.getFuncLevel());
                        sMenuBO.setFuncName(SYSFUNCVO2.getFuncName());
                        sMenuBO.setFuncUrl(SYSFUNCVO2.getFuncUrl());
                        sMenuBO.setFuncPriority(SYSFUNCVO2.getFuncPriority());
                        List<MenuBO> tMenuBOList = new ArrayList<>();
                        for (SYSFUNCVO SYSFUNCVO3 : SYSFUNCVOSet) {
                            if (!SYSFUNCVO3.getFuncDisableTag().equals("1")
                                || !SYSFUNCVO3.getFuncTag().equals("0")) {
                                continue;
                            }
                            if (SYSFUNCVO3.getFuncLevel().equals("3")
                                && SYSFUNCVO3.getFuncFatherId().equals(SYSFUNCVO2.getFuncId())) {
                                MenuBO tMenuBO = new MenuBO();
                                tMenuBO.setFuncId(SYSFUNCVO3.getFuncId());
                                tMenuBO.setFuncDesc(SYSFUNCVO3.getFuncDesc());
                                tMenuBO.setFuncFatherId(SYSFUNCVO3.getFuncFatherId());
                                tMenuBO.setFuncIcon(SYSFUNCVO3.getFuncIcon());
                                tMenuBO.setFuncLevel(SYSFUNCVO3.getFuncLevel());
                                tMenuBO.setFuncName(SYSFUNCVO3.getFuncName());
                                tMenuBO.setFuncUrl(SYSFUNCVO3.getFuncUrl());
                                tMenuBO.setFuncPriority(SYSFUNCVO3.getFuncPriority());
                                tMenuBOList.add(tMenuBO);
                                Collections.sort(tMenuBOList);
                            }
                        }
                        sMenuBO.setChildMenuBOList(tMenuBOList);
                        sMenuBOList.add(sMenuBO);
                        Collections.sort(sMenuBOList);
                    }
                }
                fMenuBO.setChildMenuBOList(sMenuBOList);
                menuBOList.add(fMenuBO);
            }
        }
        return menuBOList;
    }
}
