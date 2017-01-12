package com.cmpay.boss.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cmpay.boss.domain.SettDetailBO;
import com.cmpay.boss.domain.SettTotalBO;
import com.cmpay.boss.form.SettDetailForm;
import com.cmpay.boss.form.SettTotalForm;
import com.cmpay.boss.service.SettTotalService;
import com.cmpay.boss.util.DateUtil;
import com.cmpay.boss.util.EncodeUtil;
import com.cmpay.boss.util.Pagination;

/**
 * 交易订单管理
 * @author wangling
 * @E-mail wangling@cm-inv.com
 *
 *
 */
@Controller
@RequestMapping(value = "/merSett")
public class SettTotalController {
	private static final Logger logger = LoggerFactory.getLogger(SettTotalController.class);

    @Autowired
    SettTotalService    settTotalService;

    @RequestMapping(value = "/query_all_settOrders", method = RequestMethod.GET)
    public String getAllSettOrder(@ModelAttribute("settTotalForm") SettTotalForm settTotalForm){
    	SettTotalBO settTotalBO = new SettTotalBO();
        String pageCurrent = settTotalForm.getPageCurrent();
        String pageSize = settTotalForm.getPageSize();

        settTotalBO.setPageCurrent(Integer.valueOf(pageCurrent));
        settTotalBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<SettTotalBO> settOrderBOPagination = settTotalService.getAllSettOrder(settTotalBO);
        settTotalForm.setPagination(settOrderBOPagination);

        return "mersett/mersettlist";

    }

    @RequestMapping(value = "/getSettOrderByPara", method = RequestMethod.POST)
    public String getSettOrderByPara(@ModelAttribute("settTotalForm") SettTotalForm settTotalForm){
    	SettTotalBO settTotalBO = new SettTotalBO();
        String pageCurrent = settTotalForm.getPageCurrent();
        String pageSize = settTotalForm.getPageSize();
        String orderId = settTotalForm.getBatchId();
        String payStatus = settTotalForm.getMerNo();
        String startTime = settTotalForm.getStartTime();
        String endTime = settTotalForm.getEndTime();

        settTotalBO.setPageCurrent(Integer.valueOf(pageCurrent));
        settTotalBO.setPageSize(Integer.valueOf(pageSize));


        if(StringUtils.isNotBlank(orderId)){
        	settTotalBO.setBatchId(orderId);
        }
        if(StringUtils.isNotBlank(payStatus)){
        	settTotalBO.setMerNo(payStatus);
        }
        if(StringUtils.isNotBlank(startTime)){
        	settTotalBO.setStartTime(DateUtil.parseTime(startTime));
        }
        if(StringUtils.isNotBlank(endTime)){
        	settTotalBO.setEndTime(DateUtil.parseEndTime(endTime+" 24:00:00"));
        }

        Pagination<SettTotalBO> settTotalBOPagination = settTotalService.getSettOrderByPara(settTotalBO);

        settTotalForm.setPagination(settTotalBOPagination);

        return "mersett/mersettlist";

    }
    
    @RequestMapping(value = "/querySettDetailByBatchId", method = RequestMethod.GET)
    public String getSettDetailByBatchId(HttpServletRequest request,@ModelAttribute("settDetailForm") SettDetailForm settDetailForm,ModelMap settTotalModel){
    	SettDetailBO settDetailBO = new SettDetailBO();
        String pageCurrent = settDetailForm.getPageCurrent();
        String pageSize = settDetailForm.getPageSize();

        settDetailBO.setPageCurrent(Integer.valueOf(pageCurrent));
        settDetailBO.setPageSize(Integer.valueOf(pageSize));

        String batchId=request.getParameter("batchId");
       
        logger.info("需要查询结算详情的批次号为："+batchId);
        settDetailBO.setBatchId(batchId);

        settTotalModel.addAttribute("batchId", batchId);

        Pagination<SettDetailBO> settDetailBOPagination = settTotalService.getSettDetailByPara(settDetailBO);

        settDetailForm.setPagination(settDetailBOPagination);

        return "mersett/settdetaillist";

    }

}
