package com.cmpay.service.chinapay.dao;

import com.cmpay.service.chinapay.model.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}