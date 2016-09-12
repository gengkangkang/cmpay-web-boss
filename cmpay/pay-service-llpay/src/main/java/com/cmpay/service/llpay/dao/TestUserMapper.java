package com.cmpay.service.llpay.dao;

import com.cmpay.service.llpay.model.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}