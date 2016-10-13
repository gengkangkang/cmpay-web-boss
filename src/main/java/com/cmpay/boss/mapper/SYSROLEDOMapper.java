package com.cmpay.boss.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmpay.boss.entity.SYSROLEDO;
import com.cmpay.boss.entity.SYSROLEDOExample;

public interface SYSROLEDOMapper {
    int countByExample(SYSROLEDOExample example);

    int deleteByExample(SYSROLEDOExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(SYSROLEDO record);

    int insertSelective(SYSROLEDO record);

    List<SYSROLEDO> selectByExample(SYSROLEDOExample example);

    SYSROLEDO selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") SYSROLEDO record, @Param("example") SYSROLEDOExample example);

    int updateByExample(@Param("record") SYSROLEDO record, @Param("example") SYSROLEDOExample example);

    int updateByPrimaryKeySelective(SYSROLEDO record);

    int updateByPrimaryKey(SYSROLEDO record);
}