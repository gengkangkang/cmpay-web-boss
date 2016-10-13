package com.cmpay.boss.service;
import java.util.Map;

import com.cmpay.boss.domain.FuncBO;
import com.cmpay.boss.util.Pagination;

/**
 * Created by fireWorks on 2016/2/3.
 */
public interface FuncService {

    Pagination<FuncBO> getFuncList(String rid);

    Map setFuncEnable(String funcId) throws Exception;

    Map setFuncDisable(String funcId) throws Exception;

    Pagination<FuncBO> getTheFunc(FuncBO funcBO);

    Pagination<FuncBO> getAllFunc(FuncBO funcBO);

    Map addNewFunc(FuncBO funcBO);

    FuncBO getById(String funcId);

    Map updateFuncInfo(FuncBO funcBO);

}
