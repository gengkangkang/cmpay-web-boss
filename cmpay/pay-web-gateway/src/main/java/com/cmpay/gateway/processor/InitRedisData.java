package com.cmpay.gateway.processor;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmpay.common.util.RedisConstants;
import com.cmpay.common.util.RedisUtil;
import com.cmpay.gateway.dao.CmpayIpBindingMapper;
import com.cmpay.gateway.model.CmpayIpBinding;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月22日 下午3:17:25
 *
 */
public class InitRedisData {

	private Logger logger=Logger.getLogger(this.getClass());

    @Autowired
    private CmpayIpBindingMapper cmpayIpBindingMapper;
    @Autowired
    private RedisUtil redisUtil;

	 @PostConstruct
     public void initIp(){
        logger.info("===================初始化绑定IP数据 start======================");
        List<CmpayIpBinding> ipList=cmpayIpBindingMapper.getIpList();
         System.out.println("--------------------:"+ipList.size());
         boolean flag = redisUtil.set(RedisConstants.CMPAY_IP_BINDING_LIST, ipList);
         logger.info("初始化iplist状态："+flag);
//         System.out.println("======测试取数据=====");
//         List<CmpayIpBinding> res=(List<CmpayIpBinding>) redisUtil.get(RedisConstants.CMPAY_IP_BINDING_LIST);
//          System.out.println("list=="+res.toString());
//          for(CmpayIpBinding cip:res){
//        	  System.out.println(cip.getIp());
//        	  System.out.println(cip.getCreatetime());
//
//          }
//          System.out.println("测试删除数据=========");
//          boolean delflag=redisUtil.del(RedisConstants.CMPAY_IP_BINDING_LIST);
//          System.out.println("删除状态："+delflag);
        logger.info("===================初始化绑定IP数据 end======================");
     }

}
