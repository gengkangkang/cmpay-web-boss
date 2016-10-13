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

import com.cmpay.boss.domain.FuncBO;
import com.cmpay.boss.domain.RoleBO;
import com.cmpay.boss.form.RoleFuncForm;
import com.cmpay.boss.form.RoleManagementForm;
import com.cmpay.boss.service.FuncService;
import com.cmpay.boss.service.MonitorRealm;
import com.cmpay.boss.service.RoleService;
import com.cmpay.boss.util.Pagination;
import com.cmpay.boss.util.UUIDGenerator;

/**
 * Created by fireWorks on 2016/2/2.
 */
@Controller
public class RoleManagementController {

    @Autowired
    RoleService                 roleService;

    @Autowired
    FuncService                 funcService;

    private static final Logger logger = LoggerFactory.getLogger(RoleManagementController.class);

    @RequestMapping(value = "/roleManagement/addnewpage", method = RequestMethod.GET)
    public String goAddNewPage(@ModelAttribute("roleManagementForm") RoleManagementForm roleManagementForm) {

        return "addnewrole";
    }

    @ResponseBody
    @RequestMapping(value = "/roleManagement/addnew", method = RequestMethod.POST)
    public Map addNewRole(@ModelAttribute("roleManagementForm") RoleManagementForm roleManagementForm) {
        Map resultMap = new HashMap();
        String roleName = roleManagementForm.getRoleName();

        RoleBO roleBO = new RoleBO();
        roleBO.setRoleId(String.valueOf(UUIDGenerator.getUUID()));
        roleBO.setRoleName(roleName);
        roleBO.setRoleDisableTag("1");
        roleBO.setRoleRemark(roleManagementForm.getRoleRemark());
        resultMap = roleService.addNewRole(roleBO);

        return resultMap;
    }

    @RequestMapping(value = "/roleManagement/query_all_role", method = RequestMethod.GET)
    public String queryAllRole(@ModelAttribute("roleManagementForm") RoleManagementForm roleManagementForm) {

        RoleBO roleBO = new RoleBO();
        String pageCurrent = roleManagementForm.getPageCurrent();
        String pageSize = roleManagementForm.getPageSize();

        roleBO.setPageCurrent(Integer.valueOf(pageCurrent));
        roleBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<RoleBO> roleBOPagination = roleService.getAllRole(roleBO);

        roleManagementForm.setPagination(roleBOPagination);

        return "rolemanalist";

    }

    @RequestMapping(value = "/roleManagement/query_a_role", method = RequestMethod.POST)
    public String queryTheRole(@ModelAttribute("roleManagementForm") RoleManagementForm roleManagementForm) {

        RoleBO roleBO = new RoleBO();
        if (!(roleManagementForm.getRoleName() == null
              || roleManagementForm.getRoleName().trim().equals(""))) {
            roleBO.setRoleName(roleManagementForm.getRoleName());
        }
        String pageCurrent = roleManagementForm.getPageCurrent();
        String pageSize = roleManagementForm.getPageSize();

        roleBO.setPageCurrent(Integer.valueOf(pageCurrent));
        roleBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<RoleBO> roleBOPagination = roleService.getTheRole(roleBO);

        roleManagementForm.setPagination(roleBOPagination);

        return "rolemanalist";

    }

    @RequestMapping(value = "/roleManagement/edit", method = RequestMethod.GET)
    public String modifyRoleDetails(HttpServletRequest request,
                                    @ModelAttribute("roleFuncForm") RoleFuncForm roleFuncForm) {

        String rid = request.getParameter("rid");
        RoleBO roleBO = roleService.getById(rid);
        roleFuncForm.setRoleId(rid);
        roleFuncForm.setRoleName(roleBO.getRoleName());
        if (roleBO.getRoleDisableTag().trim().equals("1")) {
            roleFuncForm.setRoleDisableTag("启用");

        } else {
            roleFuncForm.setRoleDisableTag("禁用");
        }

        Pagination<FuncBO> funcBOPagination = funcService.getFuncList(rid);
        roleFuncForm.setPagination(funcBOPagination);

        return "modifyroleresource";
    }

    @ResponseBody
    @RequestMapping(value = "/roleManagement/roleenable", method = RequestMethod.POST)
    public Map roleEnable(@ModelAttribute("roleManagementForm") RoleManagementForm roleManagementForm,
                          HttpServletRequest request) {
        String id = request.getParameter("id");

        Map resultMap = new HashMap();
        try {
            resultMap = roleService.setRoleEnable(id);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");

        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/roleManagement/roledisable", method = RequestMethod.POST)
    public Map roleDisable(@ModelAttribute("roleManagementForm") RoleManagementForm roleManagementForm,
                           HttpServletRequest request) {
        String id = request.getParameter("id");
        Map resultMap = new HashMap();
        try {
            resultMap = roleService.setRoleDisable(id);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");

        }
        return resultMap;

    }

    @ResponseBody
    @RequestMapping(value = "/roleManagement/addauthority", method = RequestMethod.POST)
    public Map addAuthorityForRole(@ModelAttribute("roleManagementForm") RoleManagementForm roleManagementForm,
                                   HttpServletRequest request) {
        String sourceId = request.getParameter("sid");
        String roleId = request.getParameter("rid");
        Map resultMap = new HashMap();
        try {
            resultMap = roleService.addRoleResouce(sourceId, roleId);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");

        }
        return resultMap;

    }

    @ResponseBody
    @RequestMapping(value = "/roleManagement/cancelauthority", method = RequestMethod.POST)
    public Map cancelAuthorityForRole(@ModelAttribute("roleManagementForm") RoleManagementForm roleManagementForm,
                                      HttpServletRequest request) {
        String sourceId = request.getParameter("sid");
        String roleId = request.getParameter("rid");
        Map resultMap = new HashMap();
        try {
            resultMap = roleService.cancelRoleResouce(sourceId, roleId);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");

        }
        return resultMap;
    }
}
