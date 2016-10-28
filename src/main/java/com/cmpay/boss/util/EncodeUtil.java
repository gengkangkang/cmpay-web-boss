package com.cmpay.boss.util;

import java.io.UnsupportedEncodingException;

/**
 * url传值乱码处理
 *
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年10月25日 下午2:19:30
 *
 */
public class EncodeUtil {

	public static String getUTF8String(String str) {
		String result=null;
		try {
			result=new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("转换URL中文编码异常！！！！！");
			e.printStackTrace();
		}
		return result;
	}
}
