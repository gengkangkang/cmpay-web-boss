package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpayBankBase;
import com.cmpay.boss.entity.CmpayBankBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpayBankBaseMapper {
    int countByExample(CmpayBankBaseExample example);

    int deleteByExample(CmpayBankBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmpayBankBase record);

    int insertSelective(CmpayBankBase record);

    List<CmpayBankBase> selectByExample(CmpayBankBaseExample example);

    CmpayBankBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmpayBankBase record, @Param("example") CmpayBankBaseExample example);

    int updateByExample(@Param("record") CmpayBankBase record, @Param("example") CmpayBankBaseExample example);

    int updateByPrimaryKeySelective(CmpayBankBase record);

    int updateByPrimaryKey(CmpayBankBase record);
}