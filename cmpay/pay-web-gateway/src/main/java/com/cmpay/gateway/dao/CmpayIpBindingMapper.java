package com.cmpay.gateway.dao;

import java.util.List;

import com.cmpay.gateway.model.CmpayIpBinding;
/**
 * 绑定IP相关操作
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月22日 下午3:28:58
 *
 */

public interface CmpayIpBindingMapper {

	List<CmpayIpBinding> getIpList();


    int deleteByPrimaryKey(String ip);

    int insert(CmpayIpBinding record);

    int insertSelective(CmpayIpBinding record);

    CmpayIpBinding selectByPrimaryKey(String ip);

    int updateByPrimaryKeySelective(CmpayIpBinding record);

    int updateByPrimaryKey(CmpayIpBinding record);
}