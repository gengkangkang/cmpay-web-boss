package com.cmpay.service.quartz.dao;

import com.cmpay.service.quartz.model.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}