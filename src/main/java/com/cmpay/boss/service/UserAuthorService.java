package com.cmpay.boss.service;

import com.cmpay.boss.domain.UserBO;

/**
 * 
 * 
 * @author xiaoxiang
 * @version $Id: UserAuthorService.java, v 0.1 2016年9月7日 上午9:54:17 Administrator Exp $
 */
public interface UserAuthorService {
    UserBO getAuthorByUserId(String userId);
}
