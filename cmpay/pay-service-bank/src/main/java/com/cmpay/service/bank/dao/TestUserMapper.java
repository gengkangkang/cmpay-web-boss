package com.cmpay.service.bank.dao;

import com.cmpay.service.bank.model.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}