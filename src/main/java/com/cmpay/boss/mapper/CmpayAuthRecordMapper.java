package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpayAuthRecord;
import com.cmpay.boss.entity.CmpayAuthRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpayAuthRecordMapper {
    int countByExample(CmpayAuthRecordExample example);

    int deleteByExample(CmpayAuthRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmpayAuthRecord record);

    int insertSelective(CmpayAuthRecord record);

    List<CmpayAuthRecord> selectByExample(CmpayAuthRecordExample example);

    CmpayAuthRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmpayAuthRecord record, @Param("example") CmpayAuthRecordExample example);

    int updateByExample(@Param("record") CmpayAuthRecord record, @Param("example") CmpayAuthRecordExample example);

    int updateByPrimaryKeySelective(CmpayAuthRecord record);

    int updateByPrimaryKey(CmpayAuthRecord record);
}