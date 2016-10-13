package com.cmpay.boss.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.cmpay.boss.entity.SYSROLEFUNCDO;
import com.cmpay.boss.entity.SYSROLEFUNCDOExample;
import com.cmpay.boss.entity.SYSROLEFUNCDOKey;

public interface SYSROLEFUNCDOMapper {
    int countByExample(SYSROLEFUNCDOExample example);

    int deleteByExample(SYSROLEFUNCDOExample example);

    int deleteByPrimaryKey(SYSROLEFUNCDOKey key);

    int insert(SYSROLEFUNCDO record);

    int insertSelective(SYSROLEFUNCDO record);

    List<SYSROLEFUNCDO> selectByExample(SYSROLEFUNCDOExample example);

    SYSROLEFUNCDO selectByPrimaryKey(SYSROLEFUNCDOKey key);

    int updateByExampleSelective(@Param("record") SYSROLEFUNCDO record, @Param("example") SYSROLEFUNCDOExample example);

    int updateByExample(@Param("record") SYSROLEFUNCDO record, @Param("example") SYSROLEFUNCDOExample example);

    int updateByPrimaryKeySelective(SYSROLEFUNCDO record);

    int updateByPrimaryKey(SYSROLEFUNCDO record);
}