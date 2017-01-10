package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpaySettTotal;
import com.cmpay.boss.entity.CmpaySettTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpaySettTotalMapper {
    int countByExample(CmpaySettTotalExample example);

    int deleteByExample(CmpaySettTotalExample example);

    int deleteByPrimaryKey(String batchId);

    int insert(CmpaySettTotal record);

    int insertSelective(CmpaySettTotal record);

    List<CmpaySettTotal> selectByExample(CmpaySettTotalExample example);

    CmpaySettTotal selectByPrimaryKey(String batchId);

    int updateByExampleSelective(@Param("record") CmpaySettTotal record, @Param("example") CmpaySettTotalExample example);

    int updateByExample(@Param("record") CmpaySettTotal record, @Param("example") CmpaySettTotalExample example);

    int updateByPrimaryKeySelective(CmpaySettTotal record);

    int updateByPrimaryKey(CmpaySettTotal record);
}