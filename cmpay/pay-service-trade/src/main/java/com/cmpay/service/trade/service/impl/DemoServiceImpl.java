package com.cmpay.service.trade.service.impl;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cmpay.facade.trade.TestService;


/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 * 
 * 2016年9月1日 上午10:33:26
 *
 */
@Service
public class DemoServiceImpl implements TestService {

	private Logger logger=Logger.getLogger(this.getClass());
	
	@Override
	public String sayHello(String name) {
		logger.info("进入provider方法=======");
		return "Hello "+name;
	}


}
