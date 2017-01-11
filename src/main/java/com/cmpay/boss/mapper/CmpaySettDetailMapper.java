package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpaySettDetail;
import com.cmpay.boss.entity.CmpaySettDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpaySettDetailMapper {
    int countByExample(CmpaySettDetailExample example);

    int deleteByExample(CmpaySettDetailExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(CmpaySettDetail record);

    int insertSelective(CmpaySettDetail record);

    List<CmpaySettDetail> selectByExample(CmpaySettDetailExample example);

    CmpaySettDetail selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") CmpaySettDetail record, @Param("example") CmpaySettDetailExample example);

    int updateByExample(@Param("record") CmpaySettDetail record, @Param("example") CmpaySettDetailExample example);

    int updateByPrimaryKeySelective(CmpaySettDetail record);

    int updateByPrimaryKey(CmpaySettDetail record);
}