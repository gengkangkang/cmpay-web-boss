package com.cmpay.web.cashier.gateway.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cmpay.facade.trade.TestService;


/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月1日 上午11:19:14
 *
 */
public class ConsumerTest {

	public static void main(String[] args) {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"conf/spring-consumer.xml"});
	        context.start();

	        TestService demoService = (TestService)context.getBean("testService"); // 获取远程服务代理
	        String hello = demoService.sayHello("world"); // 执行远程方法
	        System.out.println( hello ); // 显示调用结果

	}

}
