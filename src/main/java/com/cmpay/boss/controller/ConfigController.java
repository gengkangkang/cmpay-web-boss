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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmpay.boss.domain.BankBaseBO;
import com.cmpay.boss.domain.ChannelBaseBO;
import com.cmpay.boss.domain.IpBO;
import com.cmpay.boss.domain.MerchantBO;
import com.cmpay.boss.domain.PayChannelBO;
import com.cmpay.boss.domain.SuppBankBO;
import com.cmpay.boss.form.BankBaseForm;
import com.cmpay.boss.form.ChannelBaseForm;
import com.cmpay.boss.form.IpManageForm;
import com.cmpay.boss.form.MerchantForm;
import com.cmpay.boss.form.PayChannelForm;
import com.cmpay.boss.form.SuppBankForm;
import com.cmpay.boss.service.ConfigService;
import com.cmpay.boss.util.EncodeUtil;
import com.cmpay.boss.util.Pagination;

/**
 * 配置相关功能
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年10月11日 下午2:44:27
 *
 */
@Controller
public class ConfigController {
    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @Autowired
    ConfigService    configService;

    @RequestMapping(value = "/ipManagement/query_all_ip", method = RequestMethod.GET)
    public String getAllIp(@ModelAttribute("ipManageForm") IpManageForm ipManageForm){
        IpBO ipBO = new IpBO();
        String pageCurrent = ipManageForm.getPageCurrent();
        String pageSize = ipManageForm.getPageSize();

        ipBO.setPageCurrent(Integer.valueOf(pageCurrent));
        ipBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<IpBO> ipBOPagination = configService.getAllIp(ipBO);

        ipManageForm.setPagination(ipBOPagination);
        
        return "ipmanagelist";

    }

    @RequestMapping(value = "/merchantManagement/query_all_merchant", method = RequestMethod.GET)
    public String getAllMer(@ModelAttribute("merForm") MerchantForm merForm){
    	MerchantBO merchantBO = new MerchantBO();
        String pageCurrent = merForm.getPageCurrent();
        String pageSize = merForm.getPageSize();

        merchantBO.setPageCurrent(Integer.valueOf(pageCurrent));
        merchantBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<MerchantBO> merBOPagination = configService.getAllMer(merchantBO);
        
        merForm.setPagination(merBOPagination);
        
        return "merchant/mermanagelist";

    }
    
    @RequestMapping(value = "/channelManagement/query_all_channelBase", method = RequestMethod.GET)
    public String getAllChannelBase(@ModelAttribute("channelBaseForm") ChannelBaseForm channelBaseForm){
    	ChannelBaseBO channelBaseBO = new ChannelBaseBO();
        String pageCurrent = channelBaseForm.getPageCurrent();
        String pageSize = channelBaseForm.getPageSize();

        channelBaseBO.setPageCurrent(Integer.valueOf(pageCurrent));
        channelBaseBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<ChannelBaseBO> channelBOPagination = configService.getAllChannelBase(channelBaseBO);

        channelBaseForm.setPagination(channelBOPagination);

        return "merchant/channelBaselist";

    }

    @RequestMapping(value = "/bankManagement/query_all_bankBase", method = RequestMethod.GET)
    public String getAllBankBase(@ModelAttribute("bankBaseForm") BankBaseForm bankBaseForm){
    	BankBaseBO bankBaseBO = new BankBaseBO();
        String pageCurrent = bankBaseForm.getPageCurrent();
        String pageSize = bankBaseForm.getPageSize();

        bankBaseBO.setPageCurrent(Integer.valueOf(pageCurrent));
        bankBaseBO.setPageSize(Integer.valueOf(pageSize));

        Pagination<BankBaseBO> bankBOPagination = configService.getAllBankBase(bankBaseBO);

        bankBaseForm.setPagination(bankBOPagination);

        return "merchant/bankBaselist";

    }

    @RequestMapping(value = "/channelManagement/queryChannelByMerchantId", method = RequestMethod.GET)
    public String getChannelByMerchantId(HttpServletRequest request,@ModelAttribute("payChannelForm") PayChannelForm payChannelForm,ModelMap paychannelModel){
    	PayChannelBO payChannelBO = new PayChannelBO();
        String pageCurrent = payChannelForm.getPageCurrent();
        String pageSize = payChannelForm.getPageSize();

        payChannelBO.setPageCurrent(Integer.valueOf(pageCurrent));
        payChannelBO.setPageSize(Integer.valueOf(pageSize));

        String merchantId=request.getParameter("merchantId");
        String merchantName=EncodeUtil.getUTF8String(request.getParameter("merchantName"));

        logger.info("需要查询支付渠道的商户号为："+merchantId+",商户名称为："+merchantName);
        payChannelBO.setMerchNo(merchantId);

        paychannelModel.addAttribute("merchantId", merchantId);
        paychannelModel.addAttribute("merchantName", merchantName);


        Pagination<PayChannelBO> payChannelBOPagination = configService.getPayChannelByPara(payChannelBO);

        payChannelForm.setPagination(payChannelBOPagination);

        return "merchant/paychannellist";

    }

    @RequestMapping(value = "/channelManagement/queryBankByChannelId", method = RequestMethod.GET)
    public String queryBankByChannelId(HttpServletRequest request,@ModelAttribute("suppBankForm") SuppBankForm suppBankForm,ModelMap suppBankModel){
    	SuppBankBO suppBankBO = new SuppBankBO();
        String pageCurrent = suppBankForm.getPageCurrent();
        String pageSize = suppBankForm.getPageSize();

        suppBankBO.setPageCurrent(Integer.valueOf(pageCurrent));
        suppBankBO.setPageSize(Integer.valueOf(pageSize));

        String payChannelId=request.getParameter("payChannelId");
        String payChannelName=EncodeUtil.getUTF8String(request.getParameter("payChannelName"));

        logger.info("需要查询支持银行的支付渠道为："+payChannelId+",支付渠道名称为："+payChannelName);
        suppBankBO.setPayChannelCode(payChannelId);

        suppBankModel.addAttribute("payChannelId", payChannelId);
        suppBankModel.addAttribute("payChannelName", payChannelName);


        Pagination<SuppBankBO> suppBankBOPagination = configService.getSuppBankByPara(suppBankBO);

        suppBankForm.setPagination(suppBankBOPagination);

        return "merchant/suppbanklist";

    }

    @RequestMapping(value = "/merchantManagement/getMerByPara", method = RequestMethod.POST)
    public String getMerByPara(@ModelAttribute("merForm") MerchantForm merForm){
    	MerchantBO merchantBO = new MerchantBO();
        String pageCurrent = merForm.getPageCurrent();
        String pageSize = merForm.getPageSize();

        merchantBO.setPageCurrent(Integer.valueOf(pageCurrent));
        merchantBO.setPageSize(Integer.valueOf(pageSize));

        if(StringUtils.isNotBlank(merForm.getMerchantid())){
        	merchantBO.setMerchantid(merForm.getMerchantid());
        }
        if(StringUtils.isNotBlank(merForm.getMerchantName())){
        	merchantBO.setMerchantName(merForm.getMerchantName());
        }

        Pagination<MerchantBO> merBOPagination = configService.getMerByPara(merchantBO);

        merForm.setPagination(merBOPagination);

        return "merchant/mermanagelist";

    }
    
    @RequestMapping(value = "/bankManagement/getbankByPara", method = RequestMethod.POST)
    public String getbankByPara(@ModelAttribute("bankBaseForm") BankBaseForm bankBaseForm){
    	BankBaseBO bankBO=new BankBaseBO();
        String pageCurrent = bankBaseForm.getPageCurrent();
        String pageSize = bankBaseForm.getPageSize();

        bankBO.setPageCurrent(Integer.valueOf(pageCurrent));
        bankBO.setPageSize(Integer.valueOf(pageSize));

        if(StringUtils.isNotBlank(bankBaseForm.getCode())){
        	bankBO.setCode(bankBaseForm.getCode());
        }
        if(StringUtils.isNotBlank(bankBaseForm.getName())){
        	bankBO.setName(bankBaseForm.getName());
        }

        Pagination<BankBaseBO> bankBOPagination = configService.getBankByPara(bankBO);

        bankBaseForm.setPagination(bankBOPagination);

        return "merchant/bankBaselist";

    }
    
    @RequestMapping(value = "/channelManagement/getChannelByPara", method = RequestMethod.POST)
    public String getChannelByPara(@ModelAttribute("channelBaseForm") ChannelBaseForm channelBaseForm){
    	ChannelBaseBO channelBaseBO = new ChannelBaseBO();
        String pageCurrent = channelBaseForm.getPageCurrent();
        String pageSize = channelBaseForm.getPageSize();

        channelBaseBO.setPageCurrent(Integer.valueOf(pageCurrent));
        channelBaseBO.setPageSize(Integer.valueOf(pageSize));

        if(StringUtils.isNotBlank(channelBaseForm.getCode())){
        	channelBaseBO.setCode(channelBaseForm.getCode());
        }
        if(StringUtils.isNotBlank(channelBaseForm.getName())){
        	channelBaseBO.setName(channelBaseForm.getName());
        }

        Pagination<ChannelBaseBO> chaBOPagination = configService.getChannelByPara(channelBaseBO);

        channelBaseForm.setPagination(chaBOPagination);

        return "merchant/channelBaselist";

    }
    
    @RequestMapping(value = "/ipManagement/query_a_ip", method = RequestMethod.POST)
    public String getIpByPara(@ModelAttribute("ipManageForm") IpManageForm ipManageForm){
        IpBO ipBO = new IpBO();
        String pageCurrent = ipManageForm.getPageCurrent();
        String pageSize = ipManageForm.getPageSize();

        ipBO.setPageCurrent(Integer.valueOf(pageCurrent));
        ipBO.setPageSize(Integer.valueOf(pageSize));

        if(StringUtils.isNotBlank(ipManageForm.getIp())){
        	ipBO.setIp(ipManageForm.getIp());
        }

        Pagination<IpBO> ipBOPagination = configService.getIpByPara(ipBO);

        ipManageForm.setPagination(ipBOPagination);

        return "ipmanagelist";

    } 
    
    @RequestMapping(value = "/ipManagement/addIp", method = RequestMethod.GET)
    public String goAddNewPage(@ModelAttribute("ipManageForm") IpManageForm ipManageForm) {

        return "addip";
    }

    @ResponseBody
    @RequestMapping(value = "/ipManagement/addNewIp", method = RequestMethod.POST)
    public Map addNewRole(@ModelAttribute("ipManageForm") IpManageForm ipManageForm) {
        Map resultMap = new HashMap();
        String ip = ipManageForm.getIp();
        String inchannel=ipManageForm.getInchannel();
        String remark=ipManageForm.getRemark();

        if(StringUtils.isBlank(ip)){
        	resultMap.put("statusCode", 300);
            resultMap.put("message", "ip地址不能为空");
            return resultMap;
        }
        
        resultMap = configService.addNewIp(ip, inchannel, remark);

        return resultMap;
    }
  
    @RequestMapping(value = "/merchantManagement/addMer", method = RequestMethod.GET)
    public String goAddNewMerPage(@ModelAttribute("merForm") MerchantForm merForm) {

        return "merchant/addmer";
    }

	@ResponseBody
    @RequestMapping(value = "/merchantManagement/addNewMer", method = RequestMethod.POST)
    public Map addNewMer(@ModelAttribute("merForm") MerchantForm merForm) {
        Map resultMap = new HashMap();
        String merchantid=merForm.getMerchantid();
        String merchantName=merForm.getMerchantName();
        String ecode=merForm.getEcode();
        String linkman=merForm.getLinkman();
        String mobile=merForm.getMobile();
        String partnerKey=merForm.getPartnerKey();

        if(StringUtils.isBlank(merchantid)||StringUtils.isBlank(merchantName)||StringUtils.isBlank(ecode)||StringUtils.isBlank(linkman)||StringUtils.isBlank(mobile)||StringUtils.isBlank(partnerKey)){
        	resultMap.put("statusCode", 300);
            resultMap.put("message", "必填参数不能为空");
            return resultMap;
        }
        MerchantBO merchantBO = new MerchantBO();
        try {
			BeanUtils.copyProperties(merchantBO, merForm);
		} catch (Exception e) {
			logger.error("cope properties出现异常！！！！");
			e.printStackTrace();
		}

        resultMap = configService.addNewMer(merchantBO);

        return resultMap;
    }
	  
    @RequestMapping(value = "/channelManagement/addChannel", method = RequestMethod.GET)
    public String goAddNewChannelPage(HttpServletRequest request,@ModelAttribute("payChannelForm") PayChannelForm payChannelForm) {

    	String merchantId=request.getParameter("merchantId");
    	logger.info("商户号【{}】增加支付渠道"+merchantId);
    	payChannelForm.setMerchNo(merchantId);
        return "merchant/addChannel";
    }
	
    @ResponseBody
    @RequestMapping(value = "/channelManagement/addNewChannel", method = RequestMethod.POST)
    public Map addNewChannel(@ModelAttribute("payChannelForm") PayChannelForm payChannelForm) {
    	Map resultMap = new HashMap();
    	String merchantid=payChannelForm.getMerchNo();

    	if(StringUtils.isBlank(merchantid)){
    		resultMap.put("statusCode", 300);
    		resultMap.put("message", "必须传商户号！");
    		return resultMap;
    	}
    	PayChannelBO payChannelBO = new PayChannelBO();
        try {
			BeanUtils.copyProperties(payChannelBO, payChannelForm);
	    	payChannelBO.setMerchNo(merchantid);
		} catch (Exception e) {
			logger.error("cope properties出现异常！！！！");
			e.printStackTrace();
		}

    	resultMap = configService.addNewChannel(payChannelBO);

    	return resultMap;
    }

    @RequestMapping(value = "/channelManagement/addChannelBankMap", method = RequestMethod.GET)
    public String goAddNewChannelBankMapPage(HttpServletRequest request,@ModelAttribute("suppBankForm") SuppBankForm suppBankForm) {

    	String payChannelId=request.getParameter("payChannelId");
    	logger.info("支付渠道【{}】增加支持银行",payChannelId);
    	suppBankForm.setPayChannelCode(payChannelId);
        return "merchant/addSuppBank";
    }
    
    @ResponseBody
    @RequestMapping(value = "/channelManagement/addNewSuppBank", method = RequestMethod.POST)
    public Map addNewSuppBank(@ModelAttribute("suppBankForm") SuppBankForm suppBankForm) {
    	Map resultMap = new HashMap();
    	String channelId=suppBankForm.getPayChannelCode();

    	if(StringUtils.isBlank(channelId)){
    		resultMap.put("statusCode", 300);
    		resultMap.put("message", "必须传支付渠道号！");
    		return resultMap;
    	}
    	SuppBankBO suppBankBO = new SuppBankBO();
        try {
			BeanUtils.copyProperties(suppBankBO, suppBankForm);
		} catch (Exception e) {
			logger.error("cope properties出现异常！！！！");
			e.printStackTrace();
		}

    	resultMap = configService.addNewSuppBank(suppBankBO);

    	return resultMap;
    }

	
    @RequestMapping(value = "/channelManagement/addChannelBase", method = RequestMethod.GET)
    public String goAddNewChannelBasePage(@ModelAttribute("channelBaseForm") ChannelBaseForm channelBaseForm) {

        return "merchant/addCB";
    }
    
    @ResponseBody
    @RequestMapping(value = "/channelManagement/addNewCB", method = RequestMethod.POST)
    public Map addNewCB(@ModelAttribute("channelBaseForm") ChannelBaseForm channelBaseForm) {
    	Map resultMap = new HashMap();

    	ChannelBaseBO channelBaseBO = new ChannelBaseBO();
        try {
			BeanUtils.copyProperties(channelBaseBO, channelBaseForm);
		} catch (Exception e) {
			logger.error("cope properties出现异常！！！！");
			e.printStackTrace();
		}

    	resultMap = configService.addNewCB(channelBaseBO);

    	return resultMap;
    }

    
    @RequestMapping(value = "/bankManagement/addBankBase", method = RequestMethod.GET)
    public String goAddNewBankBasePage(@ModelAttribute("bankBaseForm") BankBaseForm bankBaseForm) {

        return "merchant/addBB";
    }
    
    @ResponseBody
    @RequestMapping(value = "/bankManagement/addNewBB", method = RequestMethod.POST)
    public Map addNewBB(@ModelAttribute("bankBaseForm") BankBaseForm bankBaseForm) {
    	Map resultMap = new HashMap();

    	BankBaseBO bankBaseBO = new BankBaseBO();
        try {
			BeanUtils.copyProperties(bankBaseBO, bankBaseForm);
		} catch (Exception e) {
			logger.error("cope properties出现异常！！！！");
			e.printStackTrace();
		}

    	resultMap = configService.addNewBB(bankBaseBO);

    	return resultMap;
    }


    @RequestMapping(value = "/channelManagement/edit", method = RequestMethod.GET)
    public String modifyChannelDetails(HttpServletRequest request,
    		@ModelAttribute("payChannelForm") PayChannelForm payChannelForm) {

        String sid = request.getParameter("sid");
        PayChannelBO payChannelBO = configService.getChannelById(sid);
        try {
			BeanUtils.copyProperties(payChannelForm, payChannelBO);
		} catch (Exception e) {
			logger.error("cope properties 异常！！！！");
			e.printStackTrace();
		}

        return "merchant/updchannel";
    }

    @RequestMapping(value = "/channelManagement/editSuppBank", method = RequestMethod.GET)
    public String modifySuppBankDetails(HttpServletRequest request,
    		@ModelAttribute("suppBankForm") SuppBankForm suppBankForm) {

        String sid = request.getParameter("sid");
        SuppBankBO suppBankBO = configService.getSuppBankById(sid);
        try {
			BeanUtils.copyProperties(suppBankForm, suppBankBO);
		} catch (Exception e) {
			logger.error("cope properties 异常！！！！");
			e.printStackTrace();
		}

        return "merchant/updsuppbank";
    }

    @RequestMapping(value = "/channelManagement/editCB", method = RequestMethod.GET)
    public String modifyChannelBaseDetails(HttpServletRequest request,
    		@ModelAttribute("channelBaseForm") ChannelBaseForm channelBaseForm) {

        String sid = request.getParameter("sid");
        ChannelBaseBO channelBaseBO = configService.getChannelBaseById(sid);
        try {
			BeanUtils.copyProperties(channelBaseForm, channelBaseBO);
		} catch (Exception e) {
			logger.error("cope properties 异常！！！！");
			e.printStackTrace();
		}

        return "merchant/updchannelCB";
    }

    @RequestMapping(value = "/bankManagement/editBB", method = RequestMethod.GET)
    public String modifyBankBaseDetails(HttpServletRequest request,
    		@ModelAttribute("bankBaseForm") BankBaseForm bankBaseForm) {

        String sid = request.getParameter("sid");
        BankBaseBO bankBaseBO = configService.getBankBaseById(sid);
        try {
			BeanUtils.copyProperties(bankBaseForm, bankBaseBO);
		} catch (Exception e) {
			logger.error("cope properties 异常！！！！");
			e.printStackTrace();
		}

        return "merchant/updchannelBB";
    }

    @RequestMapping(value = "/ipManagement/edit", method = RequestMethod.GET)
    public String modifyFuncDetails(HttpServletRequest request,
    		@ModelAttribute("ipManageForm") IpManageForm ipManageForm) {

        String sid = request.getParameter("sid");
        IpBO ipBO = configService.getById(sid);
        ipManageForm.setIp(ipBO.getIp());
        ipManageForm.setInchannel(ipBO.getInchannel());
        ipManageForm.setStatus(ipBO.getStatus());
        ipManageForm.setCreatetime(ipBO.getCreatetime());
        ipManageForm.setOperator(ipBO.getOperator());

        return "modifyipdetails";
    }
    
    @ResponseBody
    @RequestMapping(value = "/ipManagement/updateIp", method = RequestMethod.POST)
    public Map updateFuncDetails(@ModelAttribute("ipManageForm") IpManageForm ipManageForm) {
        Map resultMap = new HashMap();
        IpBO ipBO = new IpBO();
        String ip=ipManageForm.getIp();
        String inchannel=ipManageForm.getInchannel();
        String status=ipManageForm.getStatus();
        if (StringUtils.isBlank(ip)||StringUtils.isBlank(inchannel)||StringUtils.isBlank(status)) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "请检查更改参数是否完整");
            return resultMap;
        }
        try {
        	ipBO.setIp(ip);
        	ipBO.setInchannel(inchannel);
        	ipBO.setStatus(status);
        	ipBO.setRemark(ipManageForm.getRemark());
            resultMap = configService.updateIpInfo(ipBO);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "操作失败!");

        }
        return resultMap;

    }

    @RequestMapping(value = "/merchantManagement/edit", method = RequestMethod.GET)
    public String modifyMerDetails(HttpServletRequest request,
    		@ModelAttribute("merForm") MerchantForm merForm) {

        String sid = request.getParameter("sid");
        MerchantBO MerchantBO = configService.getMerById(sid);
        try {
			BeanUtils.copyProperties(merForm, MerchantBO);
		} catch (Exception e) {
			logger.error("cope properties 异常！！！！");
			e.printStackTrace();
		}

        return "merchant/updmer";
    }
    
    @ResponseBody
    @RequestMapping(value = "/merchantManagement/updateMer", method = RequestMethod.POST)
    public Map updateMer(@ModelAttribute("merForm") MerchantForm merForm) {
        Map resultMap = new HashMap();
        MerchantBO merchantBO = new MerchantBO();
        String id=merForm.getId();

        if (StringUtils.isBlank(id)) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "请检查更改参数ID是否完整");
            return resultMap;
        }
        try {
        	BeanUtils.copyProperties(merchantBO, merForm);
            resultMap = configService.updateMerInfo(merchantBO);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "更新商户操作失败!");

        }
        return resultMap;

    }

    @ResponseBody
    @RequestMapping(value = "/channelManagement/updateChannel", method = RequestMethod.POST)
    public Map updateChannel(@ModelAttribute("payChannelForm") PayChannelForm payChannelForm) {
        Map resultMap = new HashMap();
        PayChannelBO payChannelBO = new PayChannelBO();
        String id=payChannelForm.getId();

        if (StringUtils.isBlank(id)) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "请检查更改参数ID是否完整");
            return resultMap;
        }
        try {
        	BeanUtils.copyProperties(payChannelBO, payChannelForm);
            resultMap = configService.updateChannelInfo(payChannelBO);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "更新渠道操作失败!");

        }
        return resultMap;

    }

    @ResponseBody
    @RequestMapping(value = "/channelManagement/updateSuppBank", method = RequestMethod.POST)
    public Map updateSuppBank(@ModelAttribute("suppBankForm") SuppBankForm suppBankForm) {
        Map resultMap = new HashMap();
        SuppBankBO SuppBankBO = new SuppBankBO();
        String id=suppBankForm.getId();

        if (StringUtils.isBlank(id)) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "请检查更改参数ID是否完整");
            return resultMap;
        }
        try {
        	BeanUtils.copyProperties(SuppBankBO, suppBankForm);
            resultMap = configService.updateSuppBankInfo(SuppBankBO);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "更新支持银行操作失败!");

        }
        return resultMap;

    }

    @ResponseBody
    @RequestMapping(value = "/channelManagement/updateCB", method = RequestMethod.POST)
    public Map updateCB(@ModelAttribute("channelBaseForm") ChannelBaseForm channelBaseForm) {
        Map resultMap = new HashMap();
        ChannelBaseBO channelBaseBO = new ChannelBaseBO();
        String id=channelBaseForm.getId();

        if (StringUtils.isBlank(id)) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "请检查更改参数ID是否完整");
            return resultMap;
        }
        try {
        	BeanUtils.copyProperties(channelBaseBO, channelBaseForm);
            resultMap = configService.updateCBInfo(channelBaseBO);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "更新基础渠道信息操作失败!");

        }
        return resultMap;

    }

    @ResponseBody
    @RequestMapping(value = "/bankManagement/updateBB", method = RequestMethod.POST)
    public Map updateBB(@ModelAttribute("bankBaseForm") BankBaseForm bankBaseForm) {
        Map resultMap = new HashMap();
        BankBaseBO bankBaseBO = new BankBaseBO();
        String id=bankBaseForm.getId();

        if (StringUtils.isBlank(id)) {
            resultMap.put("statusCode", 300);
            resultMap.put("message", "请检查更改参数ID是否完整");
            return resultMap;
        }
        try {
        	BeanUtils.copyProperties(bankBaseBO, bankBaseForm);
            resultMap = configService.updateBBInfo(bankBaseBO);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            resultMap.put("statusCode", 300);
            resultMap.put("message", "更新基础银行信息操作失败!");

        }
        return resultMap;

    }

}
