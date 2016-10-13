package com.cmpay.boss.mapper;

import com.cmpay.boss.entity.vo.SYSUSRVO;

/**
 * 
 * 
 * @author xiaoxiang
 * @version $Id: UserAuthorMapper.java, v 0.1 2016年9月7日 下午2:05:16 Administrator Exp $
 */
public interface UserAuthorMapper {
    SYSUSRVO getAuthorByUserId(String userId);
}
