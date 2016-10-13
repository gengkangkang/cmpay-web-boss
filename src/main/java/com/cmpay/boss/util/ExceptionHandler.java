package com.cmpay.boss.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 
 * @author xiaoxiang
 * @version $Id: ExceptionHandler.java, v 0.1 2016年9月7日 上午9:45:38 Administrator Exp $
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        logger.error("出错了", ex);
        String error = "";
        if (ex instanceof ArithmeticException) {
            request.setAttribute("exStackTrace", getExceptionStackTraceMessage(ex));
            return new ModelAndView("error");
        } else if (ex instanceof UnauthenticatedException || ex instanceof UnauthorizedException) {
            return null;
        } else if (ex instanceof DuplicateKeyException) {
            error = BjuiAjaxReturnStatusUtil.error("数据已存在");
        } else if (ex instanceof SchedulerException) {
            error = BjuiAjaxReturnStatusUtil.error(ex.getMessage());
        } else {
            error = BjuiAjaxReturnStatusUtil.error("未知异常");
        }
        getJSONFromList(response, error);
        return null;
    }

    private String getExceptionStackTraceMessage(Exception ex) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        ex.printStackTrace(printWriter);
        return result.toString();
    }

    private void getJSONFromList(HttpServletResponse response, String jo) {
        response.setContentType("text/plain" + ";charset=UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            response.getWriter().write(jo);
            response.getWriter().flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}