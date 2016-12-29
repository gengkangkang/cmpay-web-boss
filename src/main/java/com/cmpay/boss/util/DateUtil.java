package com.cmpay.boss.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年10月12日 下午4:48:38
 *
 */

public class DateUtil {

    public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";


    public static String getCurrTime(){
    	SimpleDateFormat df = new SimpleDateFormat(PATTERN_STANDARD);
    	return df.format(new Date());
    }

    public static String getFormatTime(Date date){
    	SimpleDateFormat df = new SimpleDateFormat(PATTERN_STANDARD);
    	return df.format(date);
    }

    public static Date parseTime(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

         Date d = null;
		try {
			d = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return d;
    }

    public static Date parseEndTime(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

         Date d = null;
		try {
			d = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return d;
    }


    public static void main(String[] args){
    	 System.out.println(getCurrTime());
    }


}
