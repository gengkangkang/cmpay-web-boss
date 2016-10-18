package com.cmpay.service.bank.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cmpay.service.bank.exception.DAOException;
import com.cmpay.service.bank.exception.ServiceException;

public abstract class BaseService<DAO extends BaseDAO>{

	private	static Logger logger = LoggerFactory.getLogger(BaseService.class);

	
	public abstract DAO getDAO();

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public Long insert(BaseDO baseDO) throws ServiceException {
		logger.info("param :{} ",baseDO);
		try {
			return getDAO().insert(baseDO);
		}catch(DAOException e){
			logger.error(e.getMessage()+e.getStackTrace().toString());
            throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public int update(BaseDO baseDO,boolean isAllField) throws ServiceException {
		logger.info("param :{} ,{}",baseDO,isAllField);
		try {
			if(isAllField){
				return (Integer) getDAO().updateById(baseDO);
			}else{
				return (Integer) getDAO().updateDynamic(baseDO);
			}
		}catch(DAOException e){
			logger.error(e.getMessage()+e.getStackTrace().toString());
            throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public int deleteById(Long id) throws ServiceException {
		logger.info("param :{}",id);
		try {
			return (Integer) getDAO().deleteById(id);
		}catch(DAOException e){
			logger.error(e.getMessage()+e.getStackTrace().toString());
            throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public BaseDO selectById(Long id) throws ServiceException {
		logger.info("param :{}",id);
		try {
			return getDAO().selectById(id);
		}catch(DAOException e){
			logger.error(e.getMessage()+e.getStackTrace().toString());
            throw new ServiceException(e);
		}
	}

	public Long selectCountDynamic(BaseQueryCond baseQueryCond)
			throws ServiceException {
		logger.info("param :{}",baseQueryCond);
		try {
			return getDAO().selectCountDynamic(baseQueryCond);
		}catch(DAOException e){
			logger.error(e.getMessage()+e.getStackTrace().toString());
            throw new ServiceException(e);
		}
	}

	public List<BaseDO> queryAll(BaseQueryCond baseQueryCond)
			throws ServiceException {
		logger.info("param :{}",baseQueryCond);
		try {
			return getDAO().selectDynamic(baseQueryCond);
		} catch (DAOException e) {
			logger.error(e.getMessage()+e.getStackTrace().toString());
            throw new ServiceException(e);
		}
	}

	public BasePage<BaseDO> queryPageList(BaseQueryCond baseQueryCond,Integer pageNo,Integer pageSize) {
		//logger.info("param :{},{},{}",userQueryCond,pageNo,pageSize);
		if (baseQueryCond != null) {
			BasePage<BaseDO> page = new BasePage<BaseDO>();
			if(baseQueryCond.getCountTotal()){
				Long totalCount = this.selectCountDynamic(baseQueryCond);
				page.setTotalCount(totalCount);
			}
			if(pageNo==null||pageNo<1){
				pageNo=1;
			}
			if(pageSize==null||pageSize<1){
				pageSize=20;
			}
			baseQueryCond.setStartRow((pageNo-1)*pageSize);
			baseQueryCond.setEndRow(pageSize);
			List<BaseDO> resultList;
			try {
				resultList = getDAO().selectDynamicPageQuery(baseQueryCond);
			} catch (DAOException e) {
				logger.error(e.getMessage()+e.getStackTrace().toString());
	            throw new ServiceException(e);
			}
			
			page.setPageNo(pageNo);
			page.setPageSize(pageSize);
			page.setList(resultList);
			return page;
		}
		return new BasePage<BaseDO>();
	}

}
