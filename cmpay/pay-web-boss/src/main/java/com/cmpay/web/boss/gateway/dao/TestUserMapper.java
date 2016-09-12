package com.cmpay.web.boss.gateway.dao;

import com.cmpay.web.boss.gateway.model.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}