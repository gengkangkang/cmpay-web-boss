package com.cmpay.web.boss.gateway.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmpay.facade.trade.TestService;
import com.cmpay.web.boss.gateway.model.TestUser;
import com.cmpay.web.boss.gateway.service.UserService;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年8月19日 下午5:26:40
 *
 */
@RestController
@RequestMapping("/user")
public class UserAction {
	private Logger logger=Logger.getLogger(UserAction.class);
    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    @RequestMapping("/add/test.do")
    @ResponseBody
    public String showUserInfo(){
    	logger.info("test add================");
    	TestUser user=new TestUser();
    	user.setId("2");
    	user.setName(String.valueOf(System.currentTimeMillis()));
    	user.setSex("男");
        int userInfo = userService.insertUser(user);
        return "hello";
    }


    @RequestMapping("/say.do")
    public String sayHello(){
    	logger.info("say hello================");
        String str=testService.sayHello("gkk");
        logger.info("str== "+str);
        return str;
    }

    @RequestMapping("/sayjson.do")
    @ResponseBody
    public Map<String,String> sayjson(@RequestBody TestUser str){
    	logger.info("say json================"+str);
        Map<String,String> map=new HashMap<String,String>();
        map.put("name", "test");
        map.put("sex", "男");
        return map;
    }


    @RequestMapping(value="/saystr.do",method=RequestMethod.POST)
    public Map<String,String> sayjson(@RequestBody String str){
    	logger.info("say json================"+str);
        Map<String,String> map=new HashMap<String,String>();
        map.put("name", "test");
        map.put("sex", "男");
        return map;
    }

}
