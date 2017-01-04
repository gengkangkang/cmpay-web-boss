package com.cmpay.boss.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.boss.domain.CutOrderBO;
import com.cmpay.boss.domain.MerchantBO;
import com.cmpay.boss.domain.OrderRecordBO;
import com.cmpay.boss.entity.CmpayCutOrder;
import com.cmpay.boss.entity.CmpayCutOrderExample;
import com.cmpay.boss.entity.CmpayMerchant;
import com.cmpay.boss.entity.CmpayRecord;
import com.cmpay.boss.entity.CmpayRecordExample;
import com.cmpay.boss.mapper.CmpayRecordMapper;
import com.cmpay.boss.service.OrderRecordService;
import com.cmpay.boss.util.Pagination;
import com.cmpay.common.enums.PayWayEnum;
import com.github.pagehelper.PageHelper;

@Service
public class OrderRecordServiceImpl implements OrderRecordService {
    private static final Logger logger = LoggerFactory.getLogger(OrderRecordServiceImpl.class);

  
    @Autowired
    CmpayRecordMapper cmpayRecordMapper;

    @Override
    public Pagination<OrderRecordBO> getAllOrderRecord(OrderRecordBO orderRecordBO) {
    	CmpayRecordExample cmpayRecordExample=new CmpayRecordExample();
        int count =cmpayRecordMapper.countByExample(cmpayRecordExample);
        Pagination pagination = new Pagination(count, orderRecordBO.getPageCurrent(),orderRecordBO.getPageSize());
        PageHelper.startPage(orderRecordBO.getPageCurrent(), orderRecordBO.getPageSize());
        cmpayRecordExample.setOrderByClause("CREATE_TIME DESC");
        List<CmpayRecord> recds=cmpayRecordMapper.selectByExample(cmpayRecordExample);
        List<OrderRecordBO> orderRecordBOList=new ArrayList<OrderRecordBO>();
        for(CmpayRecord cmpayRecord:recds){
            OrderRecordBO orderRecBO=new OrderRecordBO();
            try {
                BeanUtils.copyProperties(orderRecBO, cmpayRecord);
            } catch (Exception e) {
                logger.error("cope cmpayRecord异常！！！！！！");
                e.printStackTrace();
            }
            orderRecordBOList.add(orderRecBO);

        }
        pagination.addResult(orderRecordBOList);

        return pagination;
    }

	@Override
	public Pagination<OrderRecordBO> getOrderRecordByPara(OrderRecordBO orderRecordBO) {
		CmpayRecordExample cmpayRecordExample=new CmpayRecordExample();
       
		if(StringUtils.isNotBlank(orderRecordBO.getOrderId())){
			cmpayRecordExample.or().andOrderIdEqualTo(orderRecordBO.getOrderId());
		}
		if(StringUtils.isNotBlank(orderRecordBO.getPayStatus())){
			cmpayRecordExample.or().andPayStatusEqualTo(orderRecordBO.getPayStatus());
		}
		if(orderRecordBO.getStartTime() !=null && orderRecordBO.getEndTime() ==null){
			cmpayRecordExample.or().andCreateTimeGreaterThan(orderRecordBO.getStartTime());
		}
		if(orderRecordBO.getEndTime() !=null && orderRecordBO.getStartTime() ==null){
			cmpayRecordExample.or().andCreateTimeLessThan(orderRecordBO.getEndTime());
		}
		if(orderRecordBO.getStartTime() !=null && orderRecordBO.getEndTime() !=null){
			cmpayRecordExample.or().andCreateTimeBetween(orderRecordBO.getStartTime(), orderRecordBO.getEndTime());
		}

	    int count =cmpayRecordMapper.countByExample(cmpayRecordExample);
        Pagination pagination = new Pagination(count, orderRecordBO.getPageCurrent(),orderRecordBO.getPageSize());
        PageHelper.startPage(orderRecordBO.getPageCurrent(), orderRecordBO.getPageSize());
        
        cmpayRecordExample.setOrderByClause("CREATE_TIME DESC");
        List<CmpayRecord> recds=cmpayRecordMapper.selectByExample(cmpayRecordExample);
        List<OrderRecordBO> orderRecordBOList=new ArrayList<OrderRecordBO>();
        for(CmpayRecord cmpayRecord:recds){
            OrderRecordBO orderRecBO=new OrderRecordBO();
            try {
                BeanUtils.copyProperties(orderRecBO, cmpayRecord);
            } catch (Exception e) {
                logger.error("cope cmpayRecord异常！！！！！！");
                e.printStackTrace();
            }
            orderRecordBOList.add(orderRecBO);

        }
        pagination.addResult(orderRecordBOList);

        return pagination;
	}
    
    


	}
   



