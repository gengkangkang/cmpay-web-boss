package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpayPayOrder;
import com.cmpay.boss.entity.CmpayPayOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpayPayOrderMapper {
    int countByExample(CmpayPayOrderExample example);

    int deleteByExample(CmpayPayOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(CmpayPayOrder record);

    int insertSelective(CmpayPayOrder record);

    List<CmpayPayOrder> selectByExample(CmpayPayOrderExample example);

    CmpayPayOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") CmpayPayOrder record, @Param("example") CmpayPayOrderExample example);

    int updateByExample(@Param("record") CmpayPayOrder record, @Param("example") CmpayPayOrderExample example);

    int updateByPrimaryKeySelective(CmpayPayOrder record);

    int updateByPrimaryKey(CmpayPayOrder record);
}