package com.cmpay.service.rule.dao;

import com.cmpay.service.rule.model.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}