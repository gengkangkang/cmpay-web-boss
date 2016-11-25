package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpayRecord;
import com.cmpay.boss.entity.CmpayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpayRecordMapper {
    int countByExample(CmpayRecordExample example);

    int deleteByExample(CmpayRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmpayRecord record);

    int insertSelective(CmpayRecord record);

    List<CmpayRecord> selectByExample(CmpayRecordExample example);

    CmpayRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmpayRecord record, @Param("example") CmpayRecordExample example);

    int updateByExample(@Param("record") CmpayRecord record, @Param("example") CmpayRecordExample example);

    int updateByPrimaryKeySelective(CmpayRecord record);

    int updateByPrimaryKey(CmpayRecord record);
}