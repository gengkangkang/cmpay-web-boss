package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpayRecordDetail;
import com.cmpay.boss.entity.CmpayRecordDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpayRecordDetailMapper {
    int countByExample(CmpayRecordDetailExample example);

    int deleteByExample(CmpayRecordDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmpayRecordDetail record);

    int insertSelective(CmpayRecordDetail record);

    List<CmpayRecordDetail> selectByExample(CmpayRecordDetailExample example);

    CmpayRecordDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmpayRecordDetail record, @Param("example") CmpayRecordDetailExample example);

    int updateByExample(@Param("record") CmpayRecordDetail record, @Param("example") CmpayRecordDetailExample example);

    int updateByPrimaryKeySelective(CmpayRecordDetail record);

    int updateByPrimaryKey(CmpayRecordDetail record);
}