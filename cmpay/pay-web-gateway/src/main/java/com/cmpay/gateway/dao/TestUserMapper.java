package com.cmpay.gateway.dao;

import com.cmpay.gateway.model.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}