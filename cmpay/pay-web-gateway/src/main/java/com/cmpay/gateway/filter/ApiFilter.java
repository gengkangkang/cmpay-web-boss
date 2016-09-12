package com.cmpay.gateway.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;


/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 * 
 * 2016年8月30日 下午5:36:18
 *
 */
public class ApiFilter implements Filter {
	
	private Logger logger= Logger.getLogger(ApiFilter.class.getName());


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		
		    HttpServletRequest request = (HttpServletRequest) arg0;
	        HttpServletResponse response = (HttpServletResponse) arg1;
	        String ip=this.getIpAddr(request);
	        logger.info("请求IP地址为[{"+ip+"}]:");
	        List<String> allowList=new ArrayList<String>();
	        allowList.add("127.0.0.1");
	        allowList.add("10.17.1.121");
	        allowList.add("10.17.30.1");

	        
	        if(!allowList.contains(ip)){
	        	response.getOutputStream()
                .write(("request forbidden.").getBytes());
                response.getOutputStream().flush();
                 return;
	        }
	        
	       chain.doFilter(arg0, arg1); 		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	private String getIpAddr(HttpServletRequest request){
		
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
