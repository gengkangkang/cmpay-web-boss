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

import com.cmpay.boss.domain.CutOrderBO;
import com.cmpay.boss.form.CutOrderForm;
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
@RequestMapping(value = "/orderManagement")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

    @RequestMapping(value = "/query_all_cutorder", method = RequestMethod.GET)
    public String getAllMer(@ModelAttribute("cutOrderForm") CutOrderForm cutOrderForm){
    	CutOrderBO cutOrderBO = new CutOrderBO();
        String pageCurrent = cutOrderForm.getPageCurrent();
        String pageSize = cutOrderForm.getPageSize();

        cutOrderBO.setPageCurrent(Integer.valueOf(pageCurrent));
        cutOrderBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<CutOrderBO> cutOrderBOPagination = orderService.getAllCutOrder(cutOrderBO);

        cutOrderForm.setPagination(cutOrderBOPagination);

        return "order/cutordermanagelist";

    }

    @RequestMapping(value = "/getCutOrderByPara", method = RequestMethod.POST)
    public String getMerByPara(@ModelAttribute("cutOrderForm") CutOrderForm cutOrderForm){
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
    @ResponseBody
    @RequestMapping(value = "/preAudit", method = RequestMethod.POST)
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



}
