package com.cmpay.gateway.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月21日 下午1:46:01
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println(System.currentTimeMillis());

         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

         String sd = sdf.format(new Date(Long.parseLong("1474436801887")));

         System.out.println(sd);
	}

}
