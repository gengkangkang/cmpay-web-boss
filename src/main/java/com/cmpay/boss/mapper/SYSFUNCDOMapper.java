package com.cmpay.boss.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.cmpay.boss.entity.SYSFUNCDO;
import com.cmpay.boss.entity.SYSFUNCDOExample;

public interface SYSFUNCDOMapper {
    int countByExample(SYSFUNCDOExample example);

    int deleteByExample(SYSFUNCDOExample example);

    int deleteByPrimaryKey(String funcId);

    int insert(SYSFUNCDO record);

    int insertSelective(SYSFUNCDO record);

    List<SYSFUNCDO> selectByExample(SYSFUNCDOExample example);

    SYSFUNCDO selectByPrimaryKey(String funcId);

    int updateByExampleSelective(@Param("record") SYSFUNCDO record, @Param("example") SYSFUNCDOExample example);

    int updateByExample(@Param("record") SYSFUNCDO record, @Param("example") SYSFUNCDOExample example);

    int updateByPrimaryKeySelective(SYSFUNCDO record);

    int updateByPrimaryKey(SYSFUNCDO record);
}