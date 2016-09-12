package com.cmpay.service.trade.dao;

import com.cmpay.service.trade.model.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}