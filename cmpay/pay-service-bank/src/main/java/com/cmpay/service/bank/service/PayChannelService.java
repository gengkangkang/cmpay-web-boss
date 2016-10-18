package com.cmpay.service.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.service.bank.base.BaseService;
import com.cmpay.service.bank.dao.PayChannelDAO;

@Service(value="payChannelService")
public class PayChannelService extends BaseService<PayChannelDAO>{

	@Autowired
	private PayChannelDAO payChannelDAO;
	
	@Override
	public PayChannelDAO getDAO() {
		return payChannelDAO;
	}


}
