package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.CmpayCardbin;
import com.cmpay.boss.entity.CmpayCardbinExample;
import com.cmpay.boss.entity.CmpayCardbinKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpayCardbinMapper {
	
    int countByExample(CmpayCardbinExample example);

    int deleteByExample(CmpayCardbinExample example);

    int deleteByPrimaryKey(CmpayCardbinKey key);

    int insert(CmpayCardbin record);

    int insertSelective(CmpayCardbin record);

    List<CmpayCardbin> selectByExample(CmpayCardbinExample example);

    CmpayCardbin selectByPrimaryKey(CmpayCardbinKey key);

    int updateByExampleSelective(@Param("record") CmpayCardbin record, @Param("example") CmpayCardbinExample example);

    int updateByExample(@Param("record") CmpayCardbin record, @Param("example") CmpayCardbinExample example);

    int updateByPrimaryKeySelective(CmpayCardbin record);

    int updateByPrimaryKey(CmpayCardbin record);
}