package com.cmpay.boss.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.cmpay.boss.entity.SYSUSRROLEDO;
import com.cmpay.boss.entity.SYSUSRROLEDOExample;
import com.cmpay.boss.entity.SYSUSRROLEDOKey;

public interface SYSUSRROLEDOMapper {
    int countByExample(SYSUSRROLEDOExample example);

    int deleteByExample(SYSUSRROLEDOExample example);

    int deleteByPrimaryKey(SYSUSRROLEDOKey key);

    int insert(SYSUSRROLEDO record);

    int insertSelective(SYSUSRROLEDO record);

    List<SYSUSRROLEDO> selectByExample(SYSUSRROLEDOExample example);

    SYSUSRROLEDO selectByPrimaryKey(SYSUSRROLEDOKey key);

    int updateByExampleSelective(@Param("record") SYSUSRROLEDO record, @Param("example") SYSUSRROLEDOExample example);

    int updateByExample(@Param("record") SYSUSRROLEDO record, @Param("example") SYSUSRROLEDOExample example);

    int updateByPrimaryKeySelective(SYSUSRROLEDO record);

    int updateByPrimaryKey(SYSUSRROLEDO record);
}