package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpaySuppBankMap;
import com.cmpay.boss.entity.CmpaySuppBankMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpaySuppBankMapMapper {
    int countByExample(CmpaySuppBankMapExample example);

    int deleteByExample(CmpaySuppBankMapExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmpaySuppBankMap record);

    int insertSelective(CmpaySuppBankMap record);

    List<CmpaySuppBankMap> selectByExample(CmpaySuppBankMapExample example);

    CmpaySuppBankMap selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmpaySuppBankMap record, @Param("example") CmpaySuppBankMapExample example);

    int updateByExample(@Param("record") CmpaySuppBankMap record, @Param("example") CmpaySuppBankMapExample example);

    int updateByPrimaryKeySelective(CmpaySuppBankMap record);

    int updateByPrimaryKey(CmpaySuppBankMap record);
}