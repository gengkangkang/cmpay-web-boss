package com.cmpay.boss.mapper;

import java.util.List;

import com.cmpay.boss.domain.IpBO;
import com.cmpay.boss.entity.CMPAYIPBINDING;

public interface CMPAYIPBINDINGMapper {
    int deleteByPrimaryKey(String ip);

    int insert(CMPAYIPBINDING record);

    int insertSelective(CMPAYIPBINDING record);

    CMPAYIPBINDING selectByPrimaryKey(String ip);

    int updateByPrimaryKeySelective(CMPAYIPBINDING record);

    int updateByPrimaryKey(CMPAYIPBINDING record);

    List<CMPAYIPBINDING> getAllIp();
    int getIpCounts();
    List<CMPAYIPBINDING> getIpByPara(IpBO ipBO);
}