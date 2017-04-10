package com.cmpay.boss.service;

import java.util.Map;

import com.cmpay.boss.domain.AuthBO;
import com.cmpay.boss.domain.CutOrderBO;
import com.cmpay.boss.util.Pagination;

/**
 * @author gengkangkang  wangling
 * @E-mail gengkangkang@cm-inv.com   wangling@cm-inv.com
 *  
 * 2016年12月27日 下午5:15:20
 *
 */

public interface OrderService {
    Pagination<CutOrderBO> getAllCutOrder(CutOrderBO cutOrderBO);
    Pagination<CutOrderBO> getCutOrderByPara(CutOrderBO cutOrderBO);
    Map updatePreAuditInfo(String id);
    Map reAuditInfo(String id,String status);
    
    Pagination<AuthBO> getAllAuthList(AuthBO authBO);
    Pagination<AuthBO> getAuthListByPara(AuthBO authBO);


}
