package com.cmpay.gateway.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cmpay.common.util.CmpayUtils;
import com.cmpay.gateway.service.impl.BaseService;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月8日 下午3:25:43
 * 过滤请求Ip
 */
public class IpFilter extends HandlerInterceptorAdapter  {

	private Logger logger=Logger.getLogger(IpFilter.class);

	@Autowired
	BaseService baseService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    	 String ip=CmpayUtils.getIpAddr(request);
    	logger.info("请求IP地址为["+ip+"]");

    	if(!baseService.checkIP(ip)){
    		logger.info("IP地址校验不通过！");
    		  response.setCharacterEncoding("UTF-8");
    		  response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
              response.getOutputStream().write("request forbidden".getBytes());
              response.getOutputStream().flush();
              return false;
    	}

        return true;
    }

}
