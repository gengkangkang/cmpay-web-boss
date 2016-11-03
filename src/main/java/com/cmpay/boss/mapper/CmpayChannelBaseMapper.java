package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpayChannelBase;
import com.cmpay.boss.entity.CmpayChannelBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpayChannelBaseMapper {
    int countByExample(CmpayChannelBaseExample example);

    int deleteByExample(CmpayChannelBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmpayChannelBase record);

    int insertSelective(CmpayChannelBase record);

    List<CmpayChannelBase> selectByExample(CmpayChannelBaseExample example);

    CmpayChannelBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmpayChannelBase record, @Param("example") CmpayChannelBaseExample example);

    int updateByExample(@Param("record") CmpayChannelBase record, @Param("example") CmpayChannelBaseExample example);

    int updateByPrimaryKeySelective(CmpayChannelBase record);

    int updateByPrimaryKey(CmpayChannelBase record);
}