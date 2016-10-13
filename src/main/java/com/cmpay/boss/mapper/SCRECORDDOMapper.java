package com.cmpay.boss.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.cmpay.boss.entity.SCRECORDDO;
import com.cmpay.boss.entity.SCRECORDDOExample;

public interface SCRECORDDOMapper {
    int countByExample(SCRECORDDOExample example);

    int deleteByExample(SCRECORDDOExample example);

    int deleteByPrimaryKey(String schedulerId);

    int insert(SCRECORDDO record);

    int insertSelective(SCRECORDDO record);

    List<SCRECORDDO> selectByExample(SCRECORDDOExample example);

    SCRECORDDO selectByPrimaryKey(String schedulerId);

    int updateByExampleSelective(@Param("record") SCRECORDDO record, @Param("example") SCRECORDDOExample example);

    int updateByExample(@Param("record") SCRECORDDO record, @Param("example") SCRECORDDOExample example);

    int updateByPrimaryKeySelective(SCRECORDDO record);

    int updateByPrimaryKey(SCRECORDDO record);
}