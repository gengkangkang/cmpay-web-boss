package com.cmpay.boss.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmpay.boss.domain.MenuBO;
import com.cmpay.boss.domain.UserBO;
import com.cmpay.boss.entity.vo.UserVo;
import com.cmpay.boss.form.LoginForm;
import com.cmpay.boss.service.MenuService;
import com.cmpay.boss.service.MonitorRealm;
import com.cmpay.boss.service.UserService;
import com.cmpay.boss.service.MonitorRealm.ShiroUser;
import com.cmpay.boss.shiro.CaptchaUsernamePasswordToken;
import com.cmpay.boss.shiro.CustomCredentialsMatcher;
import com.cmpay.boss.util.SystemConstant;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MenuService                 menuService;
    @Autowired
    UserService                 userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") LoginForm loginForm, HttpSession session,
                        HttpServletRequest request) {

        Map resultMap = new HashMap<>();
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        String captcha = loginForm.getCaptcha();
        String remember = loginForm.getRemember();
        String host = request.getRemoteHost();
        loginForm.setHost(host);

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            resultMap = login(currentUser, loginForm);
        } else {//重复登录
            ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipal();
            currentUser.logout();
            resultMap = login(currentUser, loginForm);
        }

        if ((int) resultMap.get("statusCode") == 200) {
            UserBO userBO = userService.getByName(username);
            session.setAttribute(SystemConstant.USER_SESSION_KEY, userBO);
            return "redirect:/main";
        } else {
            return "redirect:/login";
        }

    }

    private Map login(Subject currentUser, LoginForm loginForm) {
        Map resultMap = new HashMap<>();
        CustomCredentialsMatcher customCredentialsMatcher = new CustomCredentialsMatcher();

        CaptchaUsernamePasswordToken captchaUsernamePasswordToken = new CaptchaUsernamePasswordToken(
            loginForm.getUsername(), loginForm.getPassword(), true, loginForm.getHost(),
            loginForm.getCaptcha());
        try {
            currentUser.login(captchaUsernamePasswordToken);
            resultMap.put("statusCode", 200);
            resultMap.put("message", "登录成功!");
        } catch (UnknownAccountException uae) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "用户账户不存在!");
        } catch (IncorrectCredentialsException ice) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "用户密码错误!");
        } catch (LockedAccountException lae) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "账户已被锁定!");
        } catch (AuthenticationException ae) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "认证异常!");
        }
        return resultMap;
    }

    @RequiresAuthentication
    @RequestMapping(value = "/logout")
    public String logOut(HttpSession session, HttpServletRequest request) {
        UserVo user = (UserVo) session.getAttribute(SystemConstant.USER_SESSION_KEY);
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            logger.debug("用户" + user.getName() + "退出登录");
        }
        return "forward:/login";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String goMain(HttpSession session, HttpServletRequest request,
                         HttpServletResponse response, Map<String, Object> model) {
        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
            .getPrincipal();
        if (shiroUser == null) {
            return "redirect:/login";
        }
        String userid = shiroUser.getId();
        List<MenuBO> menuBOList = new ArrayList<>();
        if (shiroUser.getLoginName().equals("admin")) {
            menuBOList = menuService.getAllEnabledMenu();
        } else {
            menuBOList = menuService.getAllEnabledMenuByUserId(userid);
        }
        model.put("menuBOList", menuBOList);
        return "main";
    }
}
