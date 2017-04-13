package com.cmpay.boss.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmpay.boss.domain.AuthBO;
import com.cmpay.boss.domain.CutOrderBO;
import com.cmpay.boss.domain.PayOrderBO;
import com.cmpay.boss.form.AuthForm;
import com.cmpay.boss.form.CutOrderForm;
import com.cmpay.boss.form.PayOrderForm;
import com.cmpay.boss.service.OrderService;
import com.cmpay.boss.util.DateUtil;
import com.cmpay.boss.util.Pagination;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年12月27日 下午5:12:42
 *
 */
@Controller
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

    @RequestMapping(value = "/orderManagement/query_all_cutorder", method = RequestMethod.GET)
    public String getCutOrder(@ModelAttribute("cutOrderForm") CutOrderForm cutOrderForm){
    	CutOrderBO cutOrderBO = new CutOrderBO();
        String pageCurrent = cutOrderForm.getPageCurrent();
        String pageSize = cutOrderForm.getPageSize();

        cutOrderBO.setPageCurrent(Integer.valueOf(pageCurrent));
        cutOrderBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<CutOrderBO> cutOrderBOPagination = orderService.getAllCutOrder(cutOrderBO);
      
        cutOrderForm.setPagination(cutOrderBOPagination);

        return "order/cutordermanagelist";

    }
    
        
    @RequestMapping(value = "/orderManagement/query_all_authOrder", method = RequestMethod.GET)
    public String getAllAuthList(@ModelAttribute("authForm") AuthForm authForm){
    	AuthBO authBO = new AuthBO();
        String pageCurrent = authForm.getPageCurrent();
        String pageSize = authForm.getPageSize();

        authBO.setPageCurrent(Integer.valueOf(pageCurrent));
        authBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<AuthBO> authBOPagination = orderService.getAllAuthList(authBO);

        authForm.setPagination(authBOPagination);

        return "order/authmanagelist";

    }


    @RequestMapping(value = "/orderManagement/getCutOrderByPara", method = RequestMethod.POST)
    public String getCutOrderByPara(@ModelAttribute("cutOrderForm") CutOrderForm cutOrderForm){
    	CutOrderBO cutOrderBO = new CutOrderBO();
        String pageCurrent = cutOrderForm.getPageCurrent();
        String pageSize = cutOrderForm.getPageSize();
        String orderId = cutOrderForm.getOrderId();
        String cardNo = cutOrderForm.getCardNo();
        String startTime = cutOrderForm.getStartTime();
        String endTime = cutOrderForm.getEndTime();

        cutOrderBO.setPageCurrent(Integer.valueOf(pageCurrent));
        cutOrderBO.setPageSize(Integer.valueOf(pageSize));


        if(StringUtils.isNotBlank(orderId)){
        	cutOrderBO.setOrderId(orderId);
        }
        if(StringUtils.isNotBlank(cardNo)){
        	cutOrderBO.setCardNo(cardNo);;
        }
        if(StringUtils.isNotBlank(startTime)){
        	cutOrderBO.setStartTime(DateUtil.parseTime(startTime));
        }
        if(StringUtils.isNotBlank(endTime)){
        	cutOrderBO.setEndTime(DateUtil.parseEndTime(endTime+" 24:00:00"));
        }

        Pagination<CutOrderBO> cutOrderBOPagination = orderService.getCutOrderByPara(cutOrderBO);

        cutOrderForm.setPagination(cutOrderBOPagination);

        return "order/cutordermanagelist";

    }
    
    @RequestMapping(value = "/orderManagement/getAuthListByPara", method = RequestMethod.POST)
    public String getAuthListByPara(@ModelAttribute("authForm") AuthForm authForm){
    	AuthBO authBO = new AuthBO();
        String pageCurrent = authForm.getPageCurrent();
        String pageSize = authForm.getPageSize();
        String cardno = authForm.getCardno();
        String idno = authForm.getIdno();
        String startTime = authForm.getStartTime();
        String endTime = authForm.getEndTime();

        authBO.setPageCurrent(Integer.valueOf(pageCurrent));
        authBO.setPageSize(Integer.valueOf(pageSize));


        if(StringUtils.isNotBlank(cardno)){
        	authBO.setCardno(cardno);
        }
        if(StringUtils.isNotBlank(idno)){
        	authBO.setIdno(idno);
        }
        if(StringUtils.isNotBlank(startTime)){
        	authBO.setStartTime(DateUtil.parseTime(startTime));
        }
        if(StringUtils.isNotBlank(endTime)){
        	authBO.setEndTime(DateUtil.parseEndTime(endTime+" 24:00:00"));
        }

        Pagination<AuthBO> authBOPagination = orderService.getAuthListByPara(authBO);

        authForm.setPagination(authBOPagination);

        return "order/authmanagelist";

    }
    
    @ResponseBody
    @RequestMapping(value = "/orderManagement/preAudit", method = RequestMethod.POST)
    public Map preAudit(HttpServletRequest request,
    		@ModelAttribute("cutOrderForm") CutOrderForm cutOrderForm) {
    	Map resultMap = new HashMap();
        String id = request.getParameter("id");
        String isAcct = request.getParameter("isAcct");
        String inAcct = request.getParameter("inAcct");
        logger.info("补账信息 id=[{}],isAcct=[{}],inAcct=[{}]",id,isAcct,inAcct);
        if(StringUtils.equals(isAcct, "0")){
            resultMap.put("statusCode", 300);
    		resultMap.put("message", "该笔交易不需要入账！");
    		return resultMap;
        }
        if(StringUtils.equals(inAcct, "0")){
            resultMap.put("statusCode", 300);
    		resultMap.put("message", "未入账状态不需要补账！");
    		return resultMap;
        }
        if(StringUtils.equals(inAcct, "1")){
            resultMap.put("statusCode", 300);
    		resultMap.put("message", "已入账交易不能补账！");
    		return resultMap;
        }
        if(StringUtils.equals(inAcct, "4")){
            resultMap.put("statusCode", 300);
    		resultMap.put("message", "已经在申请补账，无需重复申请！");
    		return resultMap;
        }
        resultMap=orderService.updatePreAuditInfo(id);
        //更新补账状态

          return resultMap;
    }
    
        	
    @RequestMapping(value = "/recheckOrderManagement/query_all_recheckCutOrder", method = RequestMethod.GET)
    public String getRecheckCutOrder(@ModelAttribute("cutOrderForm") CutOrderForm cutOrderForm){
    	CutOrderBO cutOrderBO = new CutOrderBO();
        String pageCurrent = cutOrderForm.getPageCurrent();
        String pageSize = cutOrderForm.getPageSize();
        String inAcct=cutOrderForm.getInAcct();
        System.out.println(inAcct);
        System.out.println(pageCurrent);
       
        System.out.println(pageSize);
        cutOrderBO.setPageCurrent(Integer.valueOf(pageCurrent));
        cutOrderBO.setPageSize(Integer.valueOf(pageSize));
        cutOrderBO.setInAcct("4");
        System.out.println(pageSize);
        System.out.println(cutOrderBO.toString());
        
        Pagination<CutOrderBO> cutOrderBOPagination = orderService.getCutOrderByPara(cutOrderBO);
       
        cutOrderForm.setPagination(cutOrderBOPagination);

        return "order/recheckcutorders";

    }
    
    @ResponseBody
    @RequestMapping(value = "/recheckOrderManagement/recheckAudit", method = RequestMethod.POST)
    public Map recheckAudit(HttpServletRequest request) {
    	Map resultMap = new HashMap();
        String id = request.getParameter("id");
        String status = request.getParameter("status");
        String inAcct = request.getParameter("inAcct");
        logger.info("复核信息 id=[{}],status=[{}],inAcct=[{}]",id,status,inAcct);
        if(StringUtils.equals(inAcct, "4")){
           resultMap=orderService.reAuditInfo(id,status);
           
        }else
        {
            resultMap.put("statusCode", 300);
    		resultMap.put("message", "该笔交易不需要复审");
    		
        }
        
        System.out.println("result="+resultMap);
   
        return resultMap;
    
    }
    
    @RequestMapping(value = "/orderManagement/query_all_payorder", method = RequestMethod.GET)
    public String getAllPayOrder(@ModelAttribute("payOrderForm") PayOrderForm payOrderForm){
    	PayOrderBO payOrderBO = new PayOrderBO();
        String pageCurrent = payOrderForm.getPageCurrent();
        String pageSize = payOrderForm.getPageSize();

        payOrderBO.setPageCurrent(Integer.valueOf(pageCurrent));
        payOrderBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<PayOrderBO> payOrderBOPagination = orderService.getAllPayOrder(payOrderBO);
      
        payOrderForm.setPagination(payOrderBOPagination);

        return "order/payorderlist";

    }
    
    @RequestMapping(value = "/orderManagement/getPayOrderByPara", method = RequestMethod.POST)
    public String getPayOrderByPara(@ModelAttribute("payOrderForm") PayOrderForm payOrderForm){
    	PayOrderBO payOrderBO = new PayOrderBO();
        String pageCurrent = payOrderForm.getPageCurrent();
        String pageSize = payOrderForm.getPageSize();
        String orderId = payOrderForm.getOrderId();
        String cardNo = payOrderForm.getCardNo();
        String startTime = payOrderForm.getStartTime();
        String endTime = payOrderForm.getEndTime();     
        payOrderBO.setPageCurrent(Integer.valueOf(pageCurrent));
        payOrderBO.setPageSize(Integer.valueOf(pageSize));
        
        if(StringUtils.isNotBlank(orderId)){
        	payOrderBO.setOrderId(orderId);
        }
        if(StringUtils.isNotBlank(cardNo)){
        	payOrderBO.setCardNo(cardNo);
        }
        if(StringUtils.isNotBlank(startTime)){
        	payOrderBO.setStartTime(DateUtil.parseTime(startTime));
        }
        if(StringUtils.isNotBlank(endTime)){
        	payOrderBO.setEndTime(DateUtil.parseEndTime(endTime+" 24:00:00"));
        }

        Pagination<PayOrderBO> payOrderBOPagination = orderService.getPayOrderByPara(payOrderBO);
        
        payOrderForm.setPagination(payOrderBOPagination);

        return "order/payorderlist";

    }

}
