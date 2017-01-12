package com.cmpay.boss.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpay.boss.domain.SettDetailBO;
import com.cmpay.boss.domain.SettTotalBO;
import com.cmpay.boss.entity.CmpaySettDetail;
import com.cmpay.boss.entity.CmpaySettDetailExample;
import com.cmpay.boss.entity.CmpaySettTotal;
import com.cmpay.boss.entity.CmpaySettTotalExample;
import com.cmpay.boss.mapper.CmpaySettDetailMapper;
import com.cmpay.boss.mapper.CmpaySettTotalMapper;
import com.cmpay.boss.service.SettTotalService;
import com.cmpay.boss.util.Pagination;
import com.github.pagehelper.PageHelper;

@Service
public class SettTotalServiceImpl implements SettTotalService {
	private static final Logger logger = LoggerFactory.getLogger(SettTotalServiceImpl.class);
 
	
	@Autowired
	CmpaySettTotalMapper cmpaySettTotalMapper;
	@Autowired
	CmpaySettDetailMapper cmpaySettDetailMapper;
	  
	@Override
	public Pagination<SettTotalBO> getAllSettOrder(SettTotalBO settTotalBO) {
	
		CmpaySettTotalExample cmpaySettTotalExample=new CmpaySettTotalExample();
        int count =cmpaySettTotalMapper.countByExample(cmpaySettTotalExample);
        Pagination pagination = new Pagination(count, settTotalBO.getPageCurrent(),settTotalBO.getPageSize());
        PageHelper.startPage(settTotalBO.getPageCurrent(), settTotalBO.getPageSize());
        cmpaySettTotalExample.setOrderByClause("CREATE_TIME DESC");
        List<CmpaySettTotal> recds=cmpaySettTotalMapper.selectByExample(cmpaySettTotalExample);
        List<SettTotalBO> settTotalBOList=new ArrayList<SettTotalBO>();
        for(CmpaySettTotal cmpaySettTotal:recds){
        	SettTotalBO sTotalBO=new SettTotalBO();
            try {
                BeanUtils.copyProperties(sTotalBO, cmpaySettTotal);
            } catch (Exception e) {
                logger.error("cope cmpaySettTotal异常！！！！！！");
                e.printStackTrace();
            }
            settTotalBOList.add(sTotalBO);
	    }

         pagination.addResult(settTotalBOList);

         return pagination;
	}

	@Override
	public Pagination<SettTotalBO> getSettOrderByPara(SettTotalBO settTotalBO) {
		CmpaySettTotalExample cmpaySettTotalExample=new CmpaySettTotalExample();
	       
		if(StringUtils.isNotBlank(settTotalBO.getBatchId())){
			cmpaySettTotalExample.or().andBatchIdEqualTo(settTotalBO.getBatchId());
		}
		if(StringUtils.isNotBlank(settTotalBO.getMerNo())){
			cmpaySettTotalExample.or().andMerNoEqualTo(settTotalBO.getMerNo());
		}
		if(settTotalBO.getStartTime() !=null && settTotalBO.getEndTime() ==null){
			cmpaySettTotalExample.or().andCreateTimeGreaterThan(settTotalBO.getStartTime());
		}
		if(settTotalBO.getEndTime() !=null && settTotalBO.getStartTime() ==null){
			cmpaySettTotalExample.or().andCreateTimeLessThan(settTotalBO.getEndTime());
		}
		if(settTotalBO.getStartTime() !=null && settTotalBO.getEndTime() !=null){
			cmpaySettTotalExample.or().andCreateTimeBetween(settTotalBO.getStartTime(), settTotalBO.getEndTime());
		}

	    int count =cmpaySettTotalMapper.countByExample(cmpaySettTotalExample);
        Pagination pagination = new Pagination(count, settTotalBO.getPageCurrent(),settTotalBO.getPageSize());
        PageHelper.startPage(settTotalBO.getPageCurrent(), settTotalBO.getPageSize());
        
        cmpaySettTotalExample.setOrderByClause("CREATE_TIME DESC");
        List<CmpaySettTotal> recds=cmpaySettTotalMapper.selectByExample(cmpaySettTotalExample);
        List<SettTotalBO> settTotalBOList=new ArrayList<SettTotalBO>();
        for(CmpaySettTotal cmpaySettTotal:recds){
        	SettTotalBO settTotalRecBO=new SettTotalBO();
            try {
                BeanUtils.copyProperties(settTotalRecBO, cmpaySettTotal);
            } catch (Exception e) {
                logger.error("cope cmpayRecord异常！！！！！！");
                e.printStackTrace();
            }
            settTotalBOList.add(settTotalRecBO);

        }
        pagination.addResult(settTotalBOList);

        return pagination;
	}

	@Override
	public Pagination<SettDetailBO> getSettDetailByPara(SettDetailBO settToDetailBO) {
		CmpaySettDetailExample cmpaySettDetailExample=new CmpaySettDetailExample();
	       
		if(StringUtils.isNotBlank(settToDetailBO.getBatchId())){
			cmpaySettDetailExample.or().andBatchIdEqualTo(settToDetailBO.getBatchId());
		}
		int count =cmpaySettDetailMapper.countByExample(cmpaySettDetailExample);
        Pagination pagination = new Pagination(count, settToDetailBO.getPageCurrent(),settToDetailBO.getPageSize());
        PageHelper.startPage(settToDetailBO.getPageCurrent(), settToDetailBO.getPageSize());
        
        cmpaySettDetailExample.setOrderByClause("CREATE_TIME DESC");
        List<CmpaySettDetail> recds=cmpaySettDetailMapper.selectByExample(cmpaySettDetailExample);
        List<SettDetailBO> settToDetaillist=new ArrayList<SettDetailBO>();
        for(CmpaySettDetail cmpaySettTotal:recds){
        	SettDetailBO settTotalRecBO=new SettDetailBO();
            try {
                BeanUtils.copyProperties(settTotalRecBO, cmpaySettTotal);
            } catch (Exception e) {
                logger.error("cope cmpayRecord异常！！！！！！");
                e.printStackTrace();
            }
            settToDetaillist.add(settTotalRecBO);

        }
        pagination.addResult(settToDetaillist);

        return pagination;
	}
	

}
