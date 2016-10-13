package com.cmpay.boss.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmpay.boss.domain.RoleBO;
import com.cmpay.boss.domain.UserBO;
import com.cmpay.boss.form.AccountOauthForm;
import com.cmpay.boss.form.UserForm;
import com.cmpay.boss.form.UserManageForm;
import com.cmpay.boss.service.MonitorRealm;
import com.cmpay.boss.service.RoleService;
import com.cmpay.boss.service.UserService;
import com.cmpay.boss.shiro.CustomCredentialsMatcher;
import com.cmpay.boss.util.Pagination;
import com.cmpay.boss.util.UUIDGenerator;

/**
 * Created by fireWorks on 2016/2/26.
 */
@Controller
public class UserManagementController {
    @Autowired
    UserService                 userService;

    @Autowired
    RoleService                 roleService;

    private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);

    @RequestMapping(value = "/userManagement/goToChangepwdPage", method = RequestMethod.GET)
    public String goToChangepwdPage(@ModelAttribute("userForm") UserForm userForm) {
        Subject currentUser = SecurityUtils.getSubject();
        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) currentUser.getPrincipal();
        userForm.setUserid(shiroUser.getId());
        userForm.setUsername(shiroUser.getLoginName());
        return "/changepwd";
    }

    @ResponseBody
    @RequestMapping(value = "/userManagement/changepwd", method = RequestMethod.POST)
    public Map changepwd(@ModelAttribute("userForm") UserForm userForm) {
        String userid = userForm.getUserid();
        String username = userForm.getUsername();
        String oldpassword = userForm.getOldpassword();
        String newpassword = userForm.getPass();
        CustomCredentialsMatcher customCredentialsMatcher = new CustomCredentialsMatcher();
        oldpassword = customCredentialsMatcher.encrypt(oldpassword);
        newpassword = customCredentialsMatcher.encrypt(newpassword);

        UserBO userBO = new UserBO();
        userBO.setPass(newpassword);
        userBO.setUsrPwd(oldpassword);
        userBO.setUsrId(userid);
        userBO.setUsrName(username);
        return userService.updatePwd(userBO);

    }

    @RequestMapping(value = "/userManagement/addnewpage", method = RequestMethod.GET)
    public String goAddNewPage(@ModelAttribute("userForm") UserForm userForm) {

        return "addnewuser";
    }

    @ResponseBody
    @RequestMapping(value = "/userManagement/addnew", method = RequestMethod.POST)
    public Map addNewUser(@ModelAttribute("userManageForm") UserManageForm userManageForm) {
        Map resultMap = new HashMap();
        String userName = userManageForm.getUsername();
        String userPass = userManageForm.getPass();

        UserBO userBO = new UserBO();
        userBO.setUsrId(String.valueOf(UUIDGenerator.getUUID()));
        userBO.setUsrName(userName);
        CustomCredentialsMatcher customCredentialsMatcher = new CustomCredentialsMatcher();
        userPass = customCredentialsMatcher.encrypt(userPass);
        userBO.setUsrPwd(userPass);
        userBO.setUsrDisableTag("1");
        Subject currentUser = SecurityUtils.getSubject();
        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) currentUser.getPrincipal();
        userBO.setUsrCreateBy(shiroUser.getLoginName());
        userBO.setUsrUpdateBy(shiroUser.getLoginName());

        resultMap = userService.addNewUsr(userBO);

        return resultMap;

    }

    @RequestMapping(value = "/userManagement/query_all_user", method = RequestMethod.GET)
    public String queryAllUser(@ModelAttribute("userManageForm") UserManageForm userManageForm) {

        UserBO userBO = new UserBO();
        String pageCurrent = userManageForm.getPageCurrent();
        String pageSize = userManageForm.getPageSize();

        userBO.setPageCurrent(Integer.valueOf(pageCurrent));
        userBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<UserBO> userBOPagination = userService.getAllUsr(userBO);

        userManageForm.setPagination(userBOPagination);

        return "usermanalist";

    }

    @RequestMapping(value = "/userManagement/query_a_user", method = RequestMethod.POST)
    public String queryTheUser(@ModelAttribute("userManageForm") UserManageForm userManageForm) {

        UserBO userBO = new UserBO();
        if (!(userManageForm.getUsername() == null
              || userManageForm.getUsername().trim().equals(""))) {
            userBO.setUsrName(userManageForm.getUsername());
        }
        String pageCurrent = userManageForm.getPageCurrent();
        String pageSize = userManageForm.getPageSize();

        userBO.setPageCurrent(Integer.valueOf(pageCurrent));
        userBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<UserBO> userBOPagination = userService.getTheUsr(userBO);

        userManageForm.setPagination(userBOPagination);

        return "usermanalist";

    }

    @RequestMapping(value = "/userManagement/edit", method = RequestMethod.GET)
    public String modifyAcctDetails(HttpServletRequest request,
                                    @ModelAttribute("accountOauthForm") AccountOauthForm accountOauthForm) {

        String id = request.getParameter("id");
        UserBO userBO = userService.getById(id);
        accountOauthForm.setUsrId(id);
        accountOauthForm.setUsrName(userBO.getUsrName());
        if (userBO.getUsrDisableTag().trim().equals("1")) {
            accountOauthForm.setUsrDisableTag("启用");

        } else {
            accountOauthForm.setUsrDisableTag("禁用");
        }

        Pagination<RoleBO> roleBOPagination = roleService.getRoleList(id);
        accountOauthForm.setPagination(roleBOPagination);

        return "modifyacctoauth";
    }

    @ResponseBody
    @RequestMapping(value = "/userManagement/acctenable", method = RequestMethod.POST)
    public Map acctEnable(@ModelAttribute("accountOauthForm") AccountOauthForm accountOauthForm,
                          HttpServletRequest request) {
        String id = request.getParameter("id");

        Map resultMap = new HashMap();
        try {
            resultMap = userService.setAcctEnable(id);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");

        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/userManagement/acctdisable", method = RequestMethod.POST)
    public Map acctDisable(@ModelAttribute("accountOauthForm") AccountOauthForm accountOauthForm,
                           HttpServletRequest request) {
        String id = request.getParameter("id");
        Map resultMap = new HashMap();
        try {
            resultMap = userService.setAcctDisable(id);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");

        }
        return resultMap;

    }

    @ResponseBody
    @RequestMapping(value = "/userManagement/addauthority", method = RequestMethod.POST)
    public Map addAuthorityForUsr(@ModelAttribute("accountOauthForm") AccountOauthForm accountOauthForm,
                                  HttpServletRequest request) {
        String roleId = request.getParameter("id");
        String userId = request.getParameter("uid");
        Map resultMap = new HashMap();
        try {
            resultMap = userService.addAcctAuthority(roleId, userId);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");

        }
        return resultMap;

    }

    @ResponseBody
    @RequestMapping(value = "/userManagement/cancelauthority", method = RequestMethod.POST)
    public Map cancelAuthorityForUsr(@ModelAttribute("accountOauthForm") AccountOauthForm accountOauthForm,
                                     HttpServletRequest request) {
        String roleId = request.getParameter("id");
        String userId = request.getParameter("uid");
        Map resultMap = new HashMap();
        try {
            resultMap = userService.cancelAcctAuthority(roleId, userId);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");

        }
        return resultMap;

    }

}
