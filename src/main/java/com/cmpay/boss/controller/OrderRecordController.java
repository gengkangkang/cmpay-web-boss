package com.cmpay.boss.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmpay.boss.domain.OrderRecordBO;
import com.cmpay.boss.form.OrderRecordForm;
import com.cmpay.boss.service.OrderRecordService;
import com.cmpay.boss.util.DateUtil;
import com.cmpay.boss.util.Pagination;
/**
 * 交易订单管理
 * @author wangling
 * @E-mail wangling@cm-inv.com
 *
 *
 */

@Controller
public class OrderRecordController {
    private static final Logger logger = LoggerFactory.getLogger(OrderRecordController.class);

    @Autowired
    OrderRecordService    orderRecordService;

    @RequestMapping(value = "/orderManagement/query_all_order", method = RequestMethod.GET)
    public String getAllOrderRecord(@ModelAttribute("orderRecordForm") OrderRecordForm orderRecordForm){
        OrderRecordBO orderRecordBo = new OrderRecordBO();
        String pageCurrent = orderRecordForm.getPageCurrent();
        String pageSize = orderRecordForm.getPageSize();

        orderRecordBo.setPageCurrent(Integer.valueOf(pageCurrent));
        orderRecordBo.setPageSize(Integer.valueOf(pageSize));

        Pagination<OrderRecordBO> orderRecordBOPagination = orderRecordService.getAllOrderRecord(orderRecordBo);

        orderRecordForm.setPagination(orderRecordBOPagination);

        return "order/orderrecordlist";

    }

    @RequestMapping(value = "/orderManagement/getOrderRecordByPara", method = RequestMethod.POST)
    public String getOrderRecordByPara(@ModelAttribute("orderRecordForm") OrderRecordForm orderRecordForm){
    	OrderRecordBO orderRecordBO = new OrderRecordBO();
        String pageCurrent = orderRecordForm.getPageCurrent();
        String pageSize = orderRecordForm.getPageSize();
        String orderId = orderRecordForm.getOrderId();
        String payStatus = orderRecordForm.getPayStatus();
        String startTime = orderRecordForm.getStartTime();
        String endTime = orderRecordForm.getEndTime();
        String merNo=orderRecordForm.getMerNo();

        orderRecordBO.setPageCurrent(Integer.valueOf(pageCurrent));
        orderRecordBO.setPageSize(Integer.valueOf(pageSize));


        if(StringUtils.isNotBlank(orderId)){
        	orderRecordBO.setOrderId(orderId);
        }
        if(StringUtils.isNotBlank(payStatus)){
        	orderRecordBO.setPayStatus(payStatus);
        }
        if(StringUtils.isNotBlank(startTime)){
        	orderRecordBO.setStartTime(DateUtil.parseTime(startTime));
        }
        if(StringUtils.isNotBlank(endTime)){
        	orderRecordBO.setEndTime(DateUtil.parseEndTime(endTime+" 24:00:00"));
        }
        if(StringUtils.isNotBlank(merNo)){
        	orderRecordBO.setMerNo(merNo);
        }

        Pagination<OrderRecordBO> orderRecordBOPagination = orderRecordService.getOrderRecordByPara(orderRecordBO);

        orderRecordForm.setPagination(orderRecordBOPagination);

        return "order/orderrecordlist";

    }

    @RequestMapping(value = "/orderManagement/edit", method = RequestMethod.GET)
    public String modifyOrderDetails(HttpServletRequest request,
    		@ModelAttribute("orderRecordForm") OrderRecordForm orderRecordForm) {

        String sid = request.getParameter("sid");
        OrderRecordBO orderRecordBO=orderRecordService.getOrderRecordById(sid);
        try {
			BeanUtils.copyProperties(orderRecordForm, orderRecordBO);
		} catch (Exception e) {
			logger.error("cope properties 异常！！！！");
			e.printStackTrace();
		}

        return "order/updorder";
    }

    @ResponseBody
    @RequestMapping(value = "/orderManagement/updateOrder", method = RequestMethod.POST)
    public Map updateOrderRecordInfo(@ModelAttribute("orderRecordForm") OrderRecordForm orderRecordForm) {
        Map resultMap = new HashMap();
        String id=orderRecordForm.getId();
        OrderRecordBO orderRecordBO=orderRecordService.getOrderRecordById(id);

        String payStatus=orderRecordBO.getPayStatus();

        logger.info("修改信息 id=[{}],payStatus=[{}]",id,payStatus);

        if(StringUtils.equals(payStatus, "DEALING")){
        	 try {
             	BeanUtils.copyProperties(orderRecordBO, orderRecordForm);
                 resultMap = orderRecordService.updateOrderRecordInfo(orderRecordBO);
             } catch (Exception ex) {
                 logger.error(ex.getMessage());
                 resultMap.put("statusCode", 300);
                 resultMap.put("message", "更新交易订单状态信息操作失败!");

             }

        }else{
        	resultMap.put("statusCode", 300);
    		resultMap.put("message", "此状态订单不在修改范围内！");

        }

        return resultMap;

    }

}
