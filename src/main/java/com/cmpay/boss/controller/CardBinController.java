package com.cmpay.boss.controller;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cmpay.boss.domain.CardBinBO;
import com.cmpay.boss.domain.MerchantBO;
import com.cmpay.boss.domain.PayChannelBO;
import com.cmpay.boss.form.CardBinForm;
import com.cmpay.boss.form.MerchantForm;
import com.cmpay.boss.form.PayChannelForm;
import com.cmpay.boss.service.CardBinService;
import com.cmpay.boss.util.Pagination;




@Controller
public class CardBinController {

	private static final Logger logger = LoggerFactory.getLogger(CardBinController.class);
	
	 @Autowired
	 CardBinService    cardBinService;
	 
	 @RequestMapping(value = "/cardManagement/query_all_cardbin", method = RequestMethod.GET)
     public String getAllMer(@ModelAttribute("cardbinForm") CardBinForm cardbinForm){
    	CardBinBO cardBinBO = new CardBinBO();
        String pageCurrent = cardbinForm.getPageCurrent();
        String pageSize = cardbinForm.getPageSize();

        cardBinBO.setPageCurrent(Integer.valueOf(pageCurrent));
        cardBinBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<CardBinBO> cardBOPagination = cardBinService.getAllCardbin(cardBinBO);
        
        cardbinForm.setPagination(cardBOPagination);
        
        return "cardbin/cardbinlist";

     }
	 
	 @RequestMapping(value = "/cardManagement/getCardbinByPara", method = RequestMethod.POST)	
	  public String getCardbinByPara(@ModelAttribute("cardbinForm") CardBinForm cardbinForm){  
		 // public String getCardbinByPara(@RequestParam("cardBin") String cardBin){需要再验证怎么传参数
//	    System.out.println("进入controller="+cardBin);
//		CardBinForm cardbinForm=new CardBinForm();
//		cardbinForm.setCardBin(cardBin);
	 
	    CardBinBO cardBinBO = new CardBinBO();
        String pageCurrent = cardbinForm.getPageCurrent();
        String pageSize = cardbinForm.getPageSize();

        cardBinBO.setPageCurrent(Integer.valueOf(pageCurrent));
        cardBinBO.setPageSize(Integer.valueOf(pageSize));

        if(StringUtils.isNotBlank(cardbinForm.getCardBin())){
        	cardBinBO.setCardBin(cardbinForm.getCardBin());
        }
	       
        Pagination<CardBinBO> cardBOPagination = cardBinService.getCardbinByPara(cardBinBO);

        cardbinForm.setPagination(cardBOPagination);
        System.out.println("cardbinForm.pagination="+cardbinForm.getPagination().getList());
        System.out.println("cardbinForm="+cardbinForm);
        return "cardbin/cardbinlist";

	    }

		@ResponseBody
	    @RequestMapping(value = "/cardManagement/addNewCardbin", method = RequestMethod.POST)
	    public Map addNewCardbin(@ModelAttribute("cardaddForm") CardBinForm cardaddForm) {
        Map resultMap = new HashMap();
        CardBinBO cardBinBO = new CardBinBO();
	        try {
				BeanUtils.copyProperties(cardBinBO, cardaddForm);
			} catch (Exception e) {
				logger.error("cope properties出现异常！！！！");
				e.printStackTrace();
			}
	
	        resultMap = cardBinService.addNewCardbin(cardBinBO);
	
	        return resultMap;
	    }
		
		@RequestMapping(value = "/cardManagement/edit", method = RequestMethod.GET)
	    public String modifycard(HttpServletRequest request,@ModelAttribute("cardupdForm") CardBinForm cardupdForm) {

	        String cardBin = request.getParameter("cardBin");
	        String cardLength = request.getParameter("cardLength");
	        CardBinBO cardBinBO  = cardBinService.getCardByKey(cardBin,cardLength);
	        try {
				BeanUtils.copyProperties(cardupdForm, cardBinBO);
			} catch (Exception e) {
				logger.error("cope properties 异常！！！！");
				e.printStackTrace();
			}

	        return "cardbin/updcard";
	    }
		 
		@ResponseBody
	    @RequestMapping(value = "/cardManagement/updatecard", method = RequestMethod.POST)
	    public Map updateCard(@ModelAttribute("cardupForm") CardBinForm cardupForm) {
			
	        Map resultMap = new HashMap();
	        CardBinBO cardBinBO = new CardBinBO();
	        try {
	        	BeanUtils.copyProperties(cardBinBO, cardupForm);
	            resultMap = cardBinService.updateCardbinInfo(cardBinBO);
	        } catch (Exception ex) {
	            logger.error(ex.getMessage());
	            resultMap.put("statusCode", 300);
	            resultMap.put("message", "更新卡操作失败!");

	        }
	        return resultMap;

	    }

	    
	 
	}
