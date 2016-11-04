package com.cmpay.service.trade.service.impl;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 * 
 * 2016年9月1日 上午10:54:28
 *
 */
public class ProviderTest {

	public static void main(String[] args) throws Exception {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/spring.xml"});  
	        context.start();  
	   
	        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟  

	}

}
