package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpayTradeOrder;
import com.cmpay.boss.entity.CmpayTradeOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpayTradeOrderMapper {
    int countByExample(CmpayTradeOrderExample example);

    int deleteByExample(CmpayTradeOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmpayTradeOrder record);

    int insertSelective(CmpayTradeOrder record);

    List<CmpayTradeOrder> selectByExample(CmpayTradeOrderExample example);

    CmpayTradeOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmpayTradeOrder record, @Param("example") CmpayTradeOrderExample example);

    int updateByExample(@Param("record") CmpayTradeOrder record, @Param("example") CmpayTradeOrderExample example);

    int updateByPrimaryKeySelective(CmpayTradeOrder record);

    int updateByPrimaryKey(CmpayTradeOrder record);
}