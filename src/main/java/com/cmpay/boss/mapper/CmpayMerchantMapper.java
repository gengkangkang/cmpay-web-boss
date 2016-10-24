package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpayMerchant;
import com.cmpay.boss.entity.CmpayMerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpayMerchantMapper {
    int countByExample(CmpayMerchantExample example);

    int deleteByExample(CmpayMerchantExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmpayMerchant record);

    int insertSelective(CmpayMerchant record);

    List<CmpayMerchant> selectByExample(CmpayMerchantExample example);

    CmpayMerchant selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmpayMerchant record, @Param("example") CmpayMerchantExample example);

    int updateByExample(@Param("record") CmpayMerchant record, @Param("example") CmpayMerchantExample example);

    int updateByPrimaryKeySelective(CmpayMerchant record);

    int updateByPrimaryKey(CmpayMerchant record);
}