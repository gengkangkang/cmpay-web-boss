package com.cmpay.gateway.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月27日 下午5:05:25
 *
 */
@RestController
@RequestMapping("/test")
public class TestAction extends BaseAction {

	private Logger logger=Logger.getLogger(this.getClass());


    @RequestMapping(value="/test.do",method=RequestMethod.POST)
    public String test(@RequestBody String str) throws IOException{
    	logger.info("接受到的字符串================"+str);
        Map<String,String> map=new HashMap<String,String>();
        String code=null;
        String msg=null;

    	 String decjson=new String(Base64.decodeBase64(str),"UTF-8");
         System.out.println("decjson="+decjson);
         JSONObject json=JSONObject.parseObject(decjson);
         String decsign=json.getString("sign");
         String decmsg=json.getString("encMsg");
         String deckey=json.getString("encKey");
         //验证签名
         boolean signFlag=this.verifySign(decsign, decmsg);
         if(signFlag){
        	 logger.info("验签通过");
        	 code="0000";
        	 msg="hello";
         }else{
        	 logger.info("签名校验失败");
        	 code="8888";
        	 msg="签名失败";
         }

        map.put("code", code);
        map.put("msg", msg);
        return this.encMsg(map);
    }

}
