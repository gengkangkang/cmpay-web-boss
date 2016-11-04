package com.cmpay.service.bank.base;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmpay.service.bank.exception.DAOException;

public abstract class BaseDAO<T extends BaseDO, Q extends BaseQueryCond> extends SqlSessionDaoSupport {
	
	@Override
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	public Long insert(T t) throws DAOException {
		int i = getSqlSession().insert(getMapper()+".insert", t);
		if (i > 0) {
			return Long.valueOf(t.getId());
		}
		return 0L;
	}

	public Integer updateById(T t) throws DAOException {
		return getSqlSession().update(getMapper()+".updateById", t);
	}

	public Integer deleteById(Long id) throws DAOException {
		return getSqlSession().delete(getMapper()+".deleteById", id);
	}

	public Integer updateDynamic(T t) throws DAOException {
		return getSqlSession().update(getMapper()+".updateDynamic", t);
	}

	public T selectById(Long id) throws DAOException {
		return getSqlSession().selectOne(getMapper()+".selectById", id);
	}

	public Long selectCountDynamic(Q q) throws DAOException {
		if(q.getIsFuzzy()){
			return getSqlSession().selectOne(getMapper()+".selectCountDynamicFuzzy", q);
		}else{
			return getSqlSession().selectOne(getMapper()+".selectCountDynamic", q);
		}

	}

	public List<T> selectDynamic(Q q) throws DAOException {
		if(q.getIsFuzzy()){
			return getSqlSession().selectList(getMapper()+".selectDynamicFuzzy", q);
		}else{
			return getSqlSession().selectList(getMapper()+".selectDynamic", q);
		}
	}

	public List<T> selectDynamicPageQuery(Q q) throws DAOException {
		if(q.getIsFuzzy()){
			return getSqlSession().selectList(getMapper()+".selectDynamicFuzzyPageQuery", q);
		}else{
			return getSqlSession().selectList(getMapper()+".selectDynamicPageQuery", q);
		}
	}
	
	public abstract String getMapper();
}