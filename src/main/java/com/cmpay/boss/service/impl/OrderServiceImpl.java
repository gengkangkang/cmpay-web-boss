package com.cmpay.boss.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.cmpay.boss.domain.AuthBO;
import com.cmpay.boss.domain.CutOrderBO;
import com.cmpay.boss.domain.OrderRecordBO;
import com.cmpay.boss.entity.CmpayAuthRecord;
import com.cmpay.boss.entity.CmpayAuthRecordExample;
import com.cmpay.boss.entity.CmpayCutOrder;
import com.cmpay.boss.entity.CmpayCutOrderExample;
import com.cmpay.boss.entity.CmpayRecord;
import com.cmpay.boss.entity.CmpayRecordExample;
import com.cmpay.boss.mapper.CmpayAuthRecordMapper;
import com.cmpay.boss.mapper.CmpayCutOrderMapper;
import com.cmpay.boss.service.MonitorRealm;
import com.cmpay.boss.service.OrderService;
import com.cmpay.boss.util.Pagination;
import com.cmpay.common.enums.PayWayEnum;
import com.github.pagehelper.PageHelper;

/**
 * 代扣订单管理
 * @author gengkangkang 
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年12月27日 下午5:15:39
 *
 */


@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    CmpayCutOrderMapper cmpayCutOrderMapper;
    @Autowired
    CmpayAuthRecordMapper cmpayAuthRecordMapper;

	@Override
	public Pagination<CutOrderBO> getAllCutOrder(CutOrderBO cutOrderBO) {
		CmpayCutOrderExample cmpayCutOrderExample=new CmpayCutOrderExample();
        int count=cmpayCutOrderMapper.countByExample(cmpayCutOrderExample);

        Pagination pagination = new Pagination(count, cutOrderBO.getPageCurrent(),cutOrderBO.getPageSize());
        PageHelper.startPage(cutOrderBO.getPageCurrent(), cutOrderBO.getPageSize());
        cmpayCutOrderExample.setOrderByClause("CREATE_TIME DESC");
        List<CmpayCutOrder> ccos=cmpayCutOrderMapper.selectByExample(cmpayCutOrderExample);
        List<CutOrderBO> cutOrderBOList=new ArrayList<CutOrderBO>();
        for(CmpayCutOrder cmpayCutOrder:ccos){
        	CutOrderBO merBO=new CutOrderBO();
        	try {
				BeanUtils.copyProperties(merBO, cmpayCutOrder);
				if(StringUtils.isNotBlank(cmpayCutOrder.getPayChannel())){
					PayWayEnum payWayEnum=PayWayEnum.getByCode(cmpayCutOrder.getPayChannel());
					if(payWayEnum!=null){
						merBO.setPayChannel(payWayEnum.getValue());
					}
				}
			} catch (Exception e) {
				logger.error("cope cmpayMerchant异常！！！！！！");
				e.printStackTrace();
			}
        	cutOrderBOList.add(merBO);

        }
        pagination.addResult(cutOrderBOList);

		return pagination;
	}

	@Override
	public Pagination<CutOrderBO> getCutOrderByPara(CutOrderBO cutOrderBO) {
		CmpayCutOrderExample cmpayCutOrderExample=new CmpayCutOrderExample();
		if(StringUtils.isNotBlank(cutOrderBO.getOrderId())){
			cmpayCutOrderExample.or().andOrderIdEqualTo(cutOrderBO.getOrderId());
		}
		if(StringUtils.isNotBlank(cutOrderBO.getCardNo())){
			cmpayCutOrderExample.or().andCardNoEqualTo(cutOrderBO.getCardNo());
		}
		if(StringUtils.isNotBlank(cutOrderBO.getInAcct())){
			cmpayCutOrderExample.or().andInAcctEqualTo(cutOrderBO.getInAcct());
		}
		if(cutOrderBO.getStartTime() !=null && cutOrderBO.getEndTime() ==null){
			cmpayCutOrderExample.or().andCreateTimeGreaterThan(cutOrderBO.getStartTime());
		}
		if(cutOrderBO.getEndTime() !=null && cutOrderBO.getStartTime() ==null){
			cmpayCutOrderExample.or().andCreateTimeLessThan(cutOrderBO.getEndTime());
		}
		if(cutOrderBO.getStartTime() !=null && cutOrderBO.getEndTime() !=null){
			cmpayCutOrderExample.or().andCreateTimeBetween(cutOrderBO.getStartTime(), cutOrderBO.getEndTime());
		}

        int count=cmpayCutOrderMapper.countByExample(cmpayCutOrderExample);
        
        System.out.println(count);

        Pagination pagination = new Pagination(count, cutOrderBO.getPageCurrent(),cutOrderBO.getPageSize());
        PageHelper.startPage(cutOrderBO.getPageCurrent(), cutOrderBO.getPageSize());
        cmpayCutOrderExample.setOrderByClause("CREATE_TIME DESC");
        List<CmpayCutOrder> ccos=cmpayCutOrderMapper.selectByExample(cmpayCutOrderExample);
        List<CutOrderBO> cutOrderBOList=new ArrayList<CutOrderBO>();
        for(CmpayCutOrder cmpayCutOrder:ccos){
        	CutOrderBO coBO=new CutOrderBO();
        	try {
        		BeanUtils.copyProperties(coBO, cmpayCutOrder);
				if(StringUtils.isNotBlank(cmpayCutOrder.getPayChannel())){
					PayWayEnum payWayEnum=PayWayEnum.getByCode(cmpayCutOrder.getPayChannel());
					if(payWayEnum!=null){
						coBO.setPayChannel(payWayEnum.getValue());
					}
				}
			} catch (Exception e) {
				logger.error("cope cmpayMerchant异常！！！！！！");
				e.printStackTrace();
			}
        	cutOrderBOList.add(coBO);

        }
        pagination.addResult(cutOrderBOList);

		return pagination;
	}

	@Override
	public Map updatePreAuditInfo(String id) {
		 Map resultMap = new HashMap();
		try{
			 CmpayCutOrder cmpayCutOrder=new CmpayCutOrder();
			 MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
		                .getPrincipal();
		        String loginName=shiroUser.getLoginName();
		        cmpayCutOrder.setPreAuditor(loginName);
		        cmpayCutOrder.setPreAuditTime(new Date());
		        cmpayCutOrder.setInAcct("4");
		        cmpayCutOrder.setId(id);
		        logger.info("申请补账初审信息参数为："+cmpayCutOrder.toString());
		        int r=cmpayCutOrderMapper.updateByPrimaryKeySelective(cmpayCutOrder);
		        if (r != 0) {
		            resultMap.put("statusCode", 200);
		            resultMap.put("message", "申请成功!");
		            resultMap.put("closeCurrent", false);
		        } else {
		            resultMap.put("statusCode", 300);
		            resultMap.put("message", "申请失败!");
		            resultMap.put("closeCurrent", false);
		        }

		}catch(Exception e){
			logger.error("申请补账信息异常！！！");
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Pagination<AuthBO> getAllAuthList(AuthBO authBO) {
		CmpayAuthRecordExample authRecordExample=new CmpayAuthRecordExample();
        int count =cmpayAuthRecordMapper.countByExample(authRecordExample);
        Pagination pagination = new Pagination(count, authBO.getPageCurrent(),authBO.getPageSize());
        PageHelper.startPage(authBO.getPageCurrent(), authBO.getPageSize());
        authRecordExample.setOrderByClause("CREATE_TIME DESC");
        List<CmpayAuthRecord> recds=cmpayAuthRecordMapper.selectByExample(authRecordExample);
        List<AuthBO> authBOList=new ArrayList<AuthBO>();
        for(CmpayAuthRecord cmpayAuthRecord:recds){
        	AuthBO authRecBO=new AuthBO();
            try {
                BeanUtils.copyProperties(authRecBO, cmpayAuthRecord);
            } catch (Exception e) {
                logger.error("cope cmpayRecord异常！！！！！！");
                e.printStackTrace();
            }
            authBOList.add(authRecBO);

        }
        pagination.addResult(authBOList);

        return pagination;
	}

	@Override
	public Pagination<AuthBO> getAuthListByPara(AuthBO authBO) {
		CmpayAuthRecordExample authRecordExample=new CmpayAuthRecordExample();
	       
		if(StringUtils.isNotBlank(authBO.getCardno())){
			authRecordExample.or().andCardnoEqualTo(authBO.getCardno());
		}
		if(StringUtils.isNotBlank(authBO.getIdno())){
			authRecordExample.or().andIdnoEqualTo(authBO.getIdno());
		}
		if(authBO.getStartTime() !=null && authBO.getEndTime() ==null){
			authRecordExample.or().andCreateTimeGreaterThan(authBO.getStartTime());
		}
		if(authBO.getEndTime() !=null && authBO.getStartTime() ==null){
			authRecordExample.or().andCreateTimeLessThan(authBO.getEndTime());
		}
		if(authBO.getStartTime() !=null && authBO.getEndTime() !=null){
			authRecordExample.or().andCreateTimeBetween(authBO.getStartTime(), authBO.getEndTime());
		}

	    int count =cmpayAuthRecordMapper.countByExample(authRecordExample);
        Pagination pagination = new Pagination(count, authBO.getPageCurrent(),authBO.getPageSize());
        PageHelper.startPage(authBO.getPageCurrent(), authBO.getPageSize());
        
        authRecordExample.setOrderByClause("CREATE_TIME DESC");
        List<CmpayAuthRecord> recds=cmpayAuthRecordMapper.selectByExample(authRecordExample);
        List<AuthBO> authrecBOList=new ArrayList<AuthBO>();
        for(CmpayAuthRecord authRecord:recds){
        	AuthBO authrecBO=new AuthBO();
            try {
                BeanUtils.copyProperties(authrecBO, authRecord);
            } catch (Exception e) {
                logger.error("cope cmpayRecord异常！！！！！！");
                e.printStackTrace();
            }
            authrecBOList.add(authrecBO);

        }
        pagination.addResult(authrecBOList);

        return pagination;
	}

	@Override
	public Map reAuditInfo(String id, String status) {
		 Map resultMap = new HashMap();
			try{
				 CmpayCutOrder cmpayCutOrder=new CmpayCutOrder();
				 MonitorRealm.ShiroUser shiroUser = (MonitorRealm.ShiroUser) SecurityUtils.getSubject()
			                .getPrincipal();
			        String loginName=shiroUser.getLoginName();
			        cmpayCutOrder.setRecheckAuditor(loginName);
			        cmpayCutOrder.setRecheckAuditTime(new Date());
			        if(StringUtils.equals(status, "0")){
			        	cmpayCutOrder.setInAcct("5");
				        cmpayCutOrder.setId(id);
			        }else{
			        	cmpayCutOrder.setInAcct("0");
				        cmpayCutOrder.setId(id);
			        }
			        
			        logger.info("复审信息参数为："+cmpayCutOrder.toString());
			        int r=cmpayCutOrderMapper.updateByPrimaryKeySelective(cmpayCutOrder);
			        if (r != 0) {
			            resultMap.put("statusCode", 200);
			            resultMap.put("message", "申请成功!");
			            resultMap.put("closeCurrent", false);
			        } else {
			            resultMap.put("statusCode", 300);
			            resultMap.put("message", "申请失败!");
			            resultMap.put("closeCurrent", false);
			        }

			}catch(Exception e){
				logger.error("复审信息异常！！！");
				e.printStackTrace();
			}
			return resultMap;
	}

}
