package com.cmpay.web.boss.gateway.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cmpay.common.util.CmpayUtils;


/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月8日 下午3:25:43
 * 过滤请求Ip
 */
public class IpFilter extends HandlerInterceptorAdapter  {

	private Logger logger=Logger.getLogger(IpFilter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    	 String ip=CmpayUtils.getIpAddr(request);
    	logger.info("请求IP地址为["+ip+"]");

    	List<String> allowList=new ArrayList<String>();
        allowList.add("127.0.0.1");
        allowList.add("10.17.1.121");
        allowList.add("10.17.30.1");


        if(!allowList.contains(ip)){
        	response.getOutputStream()
            .write(("request forbidden.").getBytes());
            response.getOutputStream().flush();
             return false;
        }

        return true;
    }

}
