package org.pay.service.jytpay.dao;

import org.pay.service.jytpay.model.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}