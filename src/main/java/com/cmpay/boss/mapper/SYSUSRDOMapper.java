package com.cmpay.boss.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.cmpay.boss.entity.SYSUSRDO;
import com.cmpay.boss.entity.SYSUSRDOExample;

public interface SYSUSRDOMapper {
    int countByExample(SYSUSRDOExample example);

    int deleteByExample(SYSUSRDOExample example);

    int deleteByPrimaryKey(String usrId);

    int insert(SYSUSRDO record);

    int insertSelective(SYSUSRDO record);

    List<SYSUSRDO> selectByExample(SYSUSRDOExample example);

    SYSUSRDO selectByPrimaryKey(String usrId);

    int updateByExampleSelective(@Param("record") SYSUSRDO record, @Param("example") SYSUSRDOExample example);

    int updateByExample(@Param("record") SYSUSRDO record, @Param("example") SYSUSRDOExample example);

    int updateByPrimaryKeySelective(SYSUSRDO record);

    int updateByPrimaryKey(SYSUSRDO record);
}