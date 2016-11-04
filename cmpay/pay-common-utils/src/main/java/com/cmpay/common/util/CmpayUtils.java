package com.cmpay.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 * 
 * 2016年9月8日 下午3:30:17
 * 
 * 常用工具类
 *
 */
public class CmpayUtils {
	
    /**
     * 获取Ip地址
     * @param request
     * @return
     */
	public static String getIpAddr(HttpServletRequest request){
		
		String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
	}
}
