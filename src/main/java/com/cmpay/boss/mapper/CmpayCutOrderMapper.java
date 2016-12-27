package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpayCutOrder;
import com.cmpay.boss.entity.CmpayCutOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpayCutOrderMapper {
    int countByExample(CmpayCutOrderExample example);

    int deleteByExample(CmpayCutOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmpayCutOrder record);

    int insertSelective(CmpayCutOrder record);

    List<CmpayCutOrder> selectByExample(CmpayCutOrderExample example);

    CmpayCutOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmpayCutOrder record, @Param("example") CmpayCutOrderExample example);

    int updateByExample(@Param("record") CmpayCutOrder record, @Param("example") CmpayCutOrderExample example);

    int updateByPrimaryKeySelective(CmpayCutOrder record);

    int updateByPrimaryKey(CmpayCutOrder record);
}