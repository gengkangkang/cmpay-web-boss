package com.cmpay.service.bank.dao;
import org.springframework.stereotype.Service;

import com.cmpay.service.bank.base.BaseDAO;
import com.cmpay.service.bank.condition.PayChannelQCond;
import com.cmpay.service.bank.model.PayChannelDO;

@Service(value="payChannelDAO")
public class PayChannelDAO extends BaseDAO<PayChannelDO, PayChannelQCond>{

	@Override
	public String getMapper() {
		return "com.cmpay.service.bank.mapping.PayChannelDOMapper";
	}

}
