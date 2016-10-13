package com.cmpay.boss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * 
 * @author xiaoxiang
 * @version $Id: HomeController.java, v 0.1 2016年9月7日 上午11:15:00 Administrator Exp $
 */
@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String goToHomePage() {
        return "home";
    }
}
