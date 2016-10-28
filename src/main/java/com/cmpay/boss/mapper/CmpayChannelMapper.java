package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpayChannel;
import com.cmpay.boss.entity.CmpayChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpayChannelMapper {
    int countByExample(CmpayChannelExample example);

    int deleteByExample(CmpayChannelExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmpayChannel record);

    int insertSelective(CmpayChannel record);

    List<CmpayChannel> selectByExample(CmpayChannelExample example);

    CmpayChannel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmpayChannel record, @Param("example") CmpayChannelExample example);

    int updateByExample(@Param("record") CmpayChannel record, @Param("example") CmpayChannelExample example);

    int updateByPrimaryKeySelective(CmpayChannel record);

    int updateByPrimaryKey(CmpayChannel record);
}