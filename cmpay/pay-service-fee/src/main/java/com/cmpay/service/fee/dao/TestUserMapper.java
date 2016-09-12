package com.cmpay.service.fee.dao;

import com.cmpay.service.fee.model.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}