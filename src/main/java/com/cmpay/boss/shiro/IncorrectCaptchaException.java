package com.cmpay.boss.shiro;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 
 * 
 * @author xiaoxiang
 * @version $Id: IncorrectCaptchaException.java, v 0.1 2016年9月7日 上午9:49:16 Administrator Exp $
 */
public class IncorrectCaptchaException extends AuthenticationException {
    /** 描述  */
    private static final long serialVersionUID = 6146451562810994591L;

    public IncorrectCaptchaException() {
        super();
    }

    public IncorrectCaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectCaptchaException(String message) {
        super(message);
    }

    public IncorrectCaptchaException(Throwable cause) {
        super(cause);
    }
}
