package com.cmpay.web.cashier.gateway.dao;

import com.cmpay.web.cashier.gateway.model.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}