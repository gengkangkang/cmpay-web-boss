package com.cmpay.gateway.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.common.util.RedisConstants;
import com.cmpay.common.util.RedisUtil;
import com.cmpay.gateway.dao.CmpayIpBindingMapper;
import com.cmpay.gateway.model.CmpayIpBinding;

/**
 * 公共基础服务
 *
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月23日 下午4:24:21
 *
 */
@Service
public class BaseService {

	private Logger logger=Logger.getLogger(this.getClass());

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private CmpayIpBindingMapper cmpayIpBindingMapper;

    public boolean checkIP(String ip){
        List<CmpayIpBinding> list=(List<CmpayIpBinding>) redisUtil.get(RedisConstants.CMPAY_IP_BINDING_LIST);
        if(null==list){
        	logger.info("从缓存中获取IP列表失败，从数据库中读取并加载到缓存");
            List<CmpayIpBinding> ipList=cmpayIpBindingMapper.getIpList();
            logger.info("--------------------:"+ipList.size());
            boolean flag = redisUtil.set(RedisConstants.CMPAY_IP_BINDING_LIST, ipList);
            logger.info("从数据库中读取并加载到缓存："+flag);
            list=(List<CmpayIpBinding>) redisUtil.get(RedisConstants.CMPAY_IP_BINDING_LIST);
        }

        for(CmpayIpBinding cib:list){
            if(StringUtils.equals(cib.getStatus(), "ON") && StringUtils.equals(ip, cib.getIp())){
            	logger.info("ip地址校验通过："+ip);
            	return true;
            }
        }

    	return false;
    }


}
