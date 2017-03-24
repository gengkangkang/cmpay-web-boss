package com.cmpay.boss.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cmpay.boss.domain.CardBinBO;
import com.cmpay.boss.domain.MerchantBO;
import com.cmpay.boss.entity.CmpayCardbin;
import com.cmpay.boss.entity.CmpayCardbinExample;
import com.cmpay.boss.entity.CmpayCardbinKey;
import com.cmpay.boss.entity.CmpayMerchant;
import com.cmpay.boss.entity.CmpayMerchantExample;
import com.cmpay.boss.mapper.CmpayCardbinMapper;
import com.cmpay.boss.service.CardBinService;
import com.cmpay.boss.service.MonitorRealm;
import com.cmpay.boss.util.DateUtil;
import com.cmpay.boss.util.Pagination;
import com.cmpay.boss.util.UUIDGenerator;
import com.cmpay.common.util.RedisConstants;
import com.cmpay.common.util.RedisUtil;
import com.github.pagehelper.PageHelper;


@Service
public class CardBinServiceImpl implements CardBinService{
	
	private static final Logger logger = LoggerFactory.getLogger(CardBinServiceImpl.class);
	
	@Autowired
    CmpayCardbinMapper    cmpayCardbinMapper;
	
    @Autowired
	private RedisUtil redisUtil;

	@Override
	public Pagination<CardBinBO> getAllCardbin(CardBinBO cardBinBO) {
		CmpayCardbinExample cmpayCardbinExample=new CmpayCardbinExample();
        int count=cmpayCardbinMapper.countByExample(cmpayCardbinExample);

        Pagination pagination = new Pagination(count, cardBinBO.getPageCurrent(),cardBinBO.getPageSize());
        PageHelper.startPage(cardBinBO.getPageCurrent(), cardBinBO.getPageSize());
        List<CmpayCardbin> mers=cmpayCardbinMapper.selectByExample(cmpayCardbinExample);
        List<CardBinBO> cardBinBOList=new ArrayList<CardBinBO>();
        for(CmpayCardbin cmpayCardbin:mers){
        	CardBinBO cardBO=new CardBinBO();
        	try {
				BeanUtils.copyProperties(cardBO, cmpayCardbin);
			} catch (Exception e) {
				logger.error("cope cmpayCardbin异常！！！！！！");
				e.printStackTrace();
			}
        	cardBinBOList.add(cardBO);

        }
        pagination.addResult(cardBinBOList);

		return pagination;
	}

	@Override
	public Pagination<CardBinBO> getCardbinByPara(CardBinBO cardBinBO) {
	
		System.out.println("cardBinBO="+cardBinBO.toString());
		CmpayCardbinExample cmpayCardbinExample=new CmpayCardbinExample();
		
		
		if(StringUtils.isNotBlank(cardBinBO.getCardBin())){
			cmpayCardbinExample.createCriteria().andCardBinEqualTo(cardBinBO.getCardBin());
		}
		
        int count=cmpayCardbinMapper.countByExample(cmpayCardbinExample);
        System.out.println("count="+count);

        Pagination pagination = new Pagination(count, cardBinBO.getPageCurrent(),cardBinBO.getPageSize());
        PageHelper.startPage(cardBinBO.getPageCurrent(), cardBinBO.getPageSize());
        
        List<CmpayCardbin> cards=cmpayCardbinMapper.selectByExample(cmpayCardbinExample);
        List<CardBinBO> cardBinBOList=new ArrayList<CardBinBO>();
        for(CmpayCardbin cmpayCardbin:cards){
        	CardBinBO cardBO=new CardBinBO();
        	try {
        		BeanUtils.copyProperties(cardBO, cmpayCardbin);
			} catch (Exception e) {
				logger.error("cope cmpayCardbin异常！！！！！！");
				e.printStackTrace();
			}
        	cardBinBOList.add(cardBO);
        	
        }
        pagination.addResult(cardBinBOList);
        System.out.println("pagination="+pagination.getList());
        
		return pagination;
	
	}
	

	@Override
	public Map addNewCardbin(CardBinBO cardBinBO) {
		
        Map resultMap = new HashMap();
		try{
			CmpayCardbin cmpayCardbin=new CmpayCardbin();
			BeanUtils.copyProperties(cmpayCardbin, cardBinBO);
			cmpayCardbin.setModifyTime((DateUtil.parseEndTime(DateUtil.getCurrTime())));
			System.out.println(" getModifyTime="+ cmpayCardbin.getModifyTime());
	        System.out.println("DateUtil="+DateUtil.getCurrTime());
	        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
	        String loginName=shiroUser.getLoginName();
	        cmpayCardbin.setModifier(loginName);
	        cmpayCardbin.setJpaVersion(new BigDecimal("0"));
	        logger.info("新增卡参数："+cmpayCardbin.toString());

	        int r=cmpayCardbinMapper.insert(cmpayCardbin);

	        if (r != 0) {
	            resultMap.put("statusCode", 200);
	            resultMap.put("message", "操作成功!");
	            resultMap.put("closeCurrent", true);
	          
                try{
            		logger.info("===============更新cardbin到缓存====================");
            		Map<String,String> cardbinMap=new HashMap<String,String>();
            		cardbinMap.put(RedisConstants.bankCode, cmpayCardbin.getCmpayCode());
            		cardbinMap.put(RedisConstants.bankName, cmpayCardbin.getCmpayName());
            		cardbinMap.put(RedisConstants.cardType, cmpayCardbin.getCardType());
            		redisUtil.set(RedisConstants.CMPAY_CARDBIN_+cmpayCardbin.getCardBin()+"_"+cmpayCardbin.getCardLength(), cardbinMap);
                   }catch(Exception e){
                	logger.info("更新cardbin到缓存失败",e);
                   }

	         

	        } else {
	            resultMap.put("statusCode", 300);
	            resultMap.put("message", "操作失败!");
	            resultMap.put("closeCurrent", false);
	        }

		}catch(Exception e){
			logger.error("新增CardBin出现异常！！！");
			e.printStackTrace();
		}
		return resultMap;
	}

	
	
	
	@Override
	public Map updateCardbinInfo(CardBinBO cardBinBO) {
		Map resultMap = new HashMap();
		try{ 
	        CmpayCardbin cmpayCardbin=new CmpayCardbin();
	        BeanUtils.copyProperties(cmpayCardbin, cardBinBO);
	        cmpayCardbin.setModifyTime((DateUtil.parseEndTime(DateUtil.getCurrTime())));
	        MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
	                .getPrincipal();
	        String loginName=shiroUser.getLoginName();
	        cmpayCardbin.setModifier(loginName);
	        System.out.println(" getModifyTime="+ cmpayCardbin.getModifyTime());
        	System.out.println("DateUtil="+DateUtil.getCurrTime());
	        logger.info("更新卡信息参数为："+cmpayCardbin.toString());
	        int r=cmpayCardbinMapper.updateByPrimaryKeySelective(cmpayCardbin);
	        if (r != 0) {
	            resultMap.put("statusCode", 200);
	            resultMap.put("message", "操作成功!");
	            resultMap.put("closeCurrent", true);   
	            
	            try{
            		logger.info("===============更新cardbin到缓存====================");
            		Map<String,String> cardbinMap=new HashMap<String,String>();
            		cardbinMap.put(RedisConstants.bankCode, cmpayCardbin.getCmpayCode());
            		cardbinMap.put(RedisConstants.bankName, cmpayCardbin.getCmpayName());
            		cardbinMap.put(RedisConstants.cardType, cmpayCardbin.getCardType());
            		redisUtil.set(RedisConstants.CMPAY_CARDBIN_+cmpayCardbin.getCardBin()+"_"+cmpayCardbin.getCardLength(), cardbinMap);
                }catch(Exception e){
                	logger.info("更新cardbin到缓存失败",e);
                }

	   	        } 
	        else {
	            resultMap.put("statusCode", 300);
	            resultMap.put("message", "操作失败!");
	            resultMap.put("closeCurrent", false);
	             }

			}catch(Exception e){
				logger.error("更新卡信息异常！！！");
				e.printStackTrace();
			}
			return resultMap;
	
	}

	@Override
	public CardBinBO getCardByKey(String cardBin, String cardLength) {
		
		BigDecimal cardLgt=new BigDecimal(cardLength);
		CmpayCardbinKey cmpayCardbinKey=new CmpayCardbinKey();
		cmpayCardbinKey.setCardBin(cardBin);
		cmpayCardbinKey.setCardLength(cardLgt);
		CmpayCardbin cmpayCardbin=cmpayCardbinMapper.selectByPrimaryKey(cmpayCardbinKey);
		CardBinBO cardBinBO=new CardBinBO();
		try {
			BeanUtils.copyProperties(cardBinBO, cmpayCardbin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cardBinBO;
	}
	
}