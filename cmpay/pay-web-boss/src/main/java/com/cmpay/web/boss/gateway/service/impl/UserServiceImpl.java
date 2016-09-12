package com.cmpay.web.boss.gateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.web.boss.gateway.dao.TestUserMapper;
import com.cmpay.web.boss.gateway.model.TestUser;
import com.cmpay.web.boss.gateway.service.UserService;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 * 
 * 2016年8月18日 下午2:50:35
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TestUserMapper testUserMapper;
	
	
	@Override
	public int insertUser(TestUser user) {
		// TODO Auto-generated method stub
		return testUserMapper.insert(user);
	}

}
