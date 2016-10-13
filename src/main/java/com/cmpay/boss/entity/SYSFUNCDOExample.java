package com.cmpay.boss.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SYSFUNCDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SYSFUNCDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andFuncIdIsNull() {
            addCriterion("FUNC_ID is null");
            return (Criteria) this;
        }

        public Criteria andFuncIdIsNotNull() {
            addCriterion("FUNC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFuncIdEqualTo(String value) {
            addCriterion("FUNC_ID =", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotEqualTo(String value) {
            addCriterion("FUNC_ID <>", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdGreaterThan(String value) {
            addCriterion("FUNC_ID >", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_ID >=", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLessThan(String value) {
            addCriterion("FUNC_ID <", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLessThanOrEqualTo(String value) {
            addCriterion("FUNC_ID <=", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLike(String value) {
            addCriterion("FUNC_ID like", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotLike(String value) {
            addCriterion("FUNC_ID not like", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdIn(List<String> values) {
            addCriterion("FUNC_ID in", values, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotIn(List<String> values) {
            addCriterion("FUNC_ID not in", values, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdBetween(String value1, String value2) {
            addCriterion("FUNC_ID between", value1, value2, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotBetween(String value1, String value2) {
            addCriterion("FUNC_ID not between", value1, value2, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNull() {
            addCriterion("FUNC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNotNull() {
            addCriterion("FUNC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFuncNameEqualTo(String value) {
            addCriterion("FUNC_NAME =", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotEqualTo(String value) {
            addCriterion("FUNC_NAME <>", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThan(String value) {
            addCriterion("FUNC_NAME >", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_NAME >=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThan(String value) {
            addCriterion("FUNC_NAME <", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThanOrEqualTo(String value) {
            addCriterion("FUNC_NAME <=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLike(String value) {
            addCriterion("FUNC_NAME like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotLike(String value) {
            addCriterion("FUNC_NAME not like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameIn(List<String> values) {
            addCriterion("FUNC_NAME in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotIn(List<String> values) {
            addCriterion("FUNC_NAME not in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameBetween(String value1, String value2) {
            addCriterion("FUNC_NAME between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotBetween(String value1, String value2) {
            addCriterion("FUNC_NAME not between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdIsNull() {
            addCriterion("FUNC_FATHER_ID is null");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdIsNotNull() {
            addCriterion("FUNC_FATHER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdEqualTo(String value) {
            addCriterion("FUNC_FATHER_ID =", value, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdNotEqualTo(String value) {
            addCriterion("FUNC_FATHER_ID <>", value, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdGreaterThan(String value) {
            addCriterion("FUNC_FATHER_ID >", value, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_FATHER_ID >=", value, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdLessThan(String value) {
            addCriterion("FUNC_FATHER_ID <", value, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdLessThanOrEqualTo(String value) {
            addCriterion("FUNC_FATHER_ID <=", value, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdLike(String value) {
            addCriterion("FUNC_FATHER_ID like", value, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdNotLike(String value) {
            addCriterion("FUNC_FATHER_ID not like", value, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdIn(List<String> values) {
            addCriterion("FUNC_FATHER_ID in", values, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdNotIn(List<String> values) {
            addCriterion("FUNC_FATHER_ID not in", values, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdBetween(String value1, String value2) {
            addCriterion("FUNC_FATHER_ID between", value1, value2, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncFatherIdNotBetween(String value1, String value2) {
            addCriterion("FUNC_FATHER_ID not between", value1, value2, "funcFatherId");
            return (Criteria) this;
        }

        public Criteria andFuncDescIsNull() {
            addCriterion("FUNC_DESC is null");
            return (Criteria) this;
        }

        public Criteria andFuncDescIsNotNull() {
            addCriterion("FUNC_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andFuncDescEqualTo(String value) {
            addCriterion("FUNC_DESC =", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotEqualTo(String value) {
            addCriterion("FUNC_DESC <>", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescGreaterThan(String value) {
            addCriterion("FUNC_DESC >", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_DESC >=", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescLessThan(String value) {
            addCriterion("FUNC_DESC <", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescLessThanOrEqualTo(String value) {
            addCriterion("FUNC_DESC <=", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescLike(String value) {
            addCriterion("FUNC_DESC like", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotLike(String value) {
            addCriterion("FUNC_DESC not like", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescIn(List<String> values) {
            addCriterion("FUNC_DESC in", values, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotIn(List<String> values) {
            addCriterion("FUNC_DESC not in", values, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescBetween(String value1, String value2) {
            addCriterion("FUNC_DESC between", value1, value2, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotBetween(String value1, String value2) {
            addCriterion("FUNC_DESC not between", value1, value2, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkIsNull() {
            addCriterion("FUNC_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkIsNotNull() {
            addCriterion("FUNC_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkEqualTo(String value) {
            addCriterion("FUNC_REMARK =", value, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkNotEqualTo(String value) {
            addCriterion("FUNC_REMARK <>", value, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkGreaterThan(String value) {
            addCriterion("FUNC_REMARK >", value, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_REMARK >=", value, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkLessThan(String value) {
            addCriterion("FUNC_REMARK <", value, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkLessThanOrEqualTo(String value) {
            addCriterion("FUNC_REMARK <=", value, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkLike(String value) {
            addCriterion("FUNC_REMARK like", value, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkNotLike(String value) {
            addCriterion("FUNC_REMARK not like", value, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkIn(List<String> values) {
            addCriterion("FUNC_REMARK in", values, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkNotIn(List<String> values) {
            addCriterion("FUNC_REMARK not in", values, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkBetween(String value1, String value2) {
            addCriterion("FUNC_REMARK between", value1, value2, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncRemarkNotBetween(String value1, String value2) {
            addCriterion("FUNC_REMARK not between", value1, value2, "funcRemark");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagIsNull() {
            addCriterion("FUNC_DISABLE_TAG is null");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagIsNotNull() {
            addCriterion("FUNC_DISABLE_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagEqualTo(String value) {
            addCriterion("FUNC_DISABLE_TAG =", value, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagNotEqualTo(String value) {
            addCriterion("FUNC_DISABLE_TAG <>", value, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagGreaterThan(String value) {
            addCriterion("FUNC_DISABLE_TAG >", value, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_DISABLE_TAG >=", value, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagLessThan(String value) {
            addCriterion("FUNC_DISABLE_TAG <", value, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagLessThanOrEqualTo(String value) {
            addCriterion("FUNC_DISABLE_TAG <=", value, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagLike(String value) {
            addCriterion("FUNC_DISABLE_TAG like", value, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagNotLike(String value) {
            addCriterion("FUNC_DISABLE_TAG not like", value, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagIn(List<String> values) {
            addCriterion("FUNC_DISABLE_TAG in", values, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagNotIn(List<String> values) {
            addCriterion("FUNC_DISABLE_TAG not in", values, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagBetween(String value1, String value2) {
            addCriterion("FUNC_DISABLE_TAG between", value1, value2, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncDisableTagNotBetween(String value1, String value2) {
            addCriterion("FUNC_DISABLE_TAG not between", value1, value2, "funcDisableTag");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByIsNull() {
            addCriterion("FUNC_CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByIsNotNull() {
            addCriterion("FUNC_CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByEqualTo(String value) {
            addCriterion("FUNC_CREATE_BY =", value, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByNotEqualTo(String value) {
            addCriterion("FUNC_CREATE_BY <>", value, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByGreaterThan(String value) {
            addCriterion("FUNC_CREATE_BY >", value, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_CREATE_BY >=", value, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByLessThan(String value) {
            addCriterion("FUNC_CREATE_BY <", value, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByLessThanOrEqualTo(String value) {
            addCriterion("FUNC_CREATE_BY <=", value, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByLike(String value) {
            addCriterion("FUNC_CREATE_BY like", value, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByNotLike(String value) {
            addCriterion("FUNC_CREATE_BY not like", value, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByIn(List<String> values) {
            addCriterion("FUNC_CREATE_BY in", values, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByNotIn(List<String> values) {
            addCriterion("FUNC_CREATE_BY not in", values, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByBetween(String value1, String value2) {
            addCriterion("FUNC_CREATE_BY between", value1, value2, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andFuncCreateByNotBetween(String value1, String value2) {
            addCriterion("FUNC_CREATE_BY not between", value1, value2, "funcCreateBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByIsNull() {
            addCriterion("FUNC_UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByIsNotNull() {
            addCriterion("FUNC_UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByEqualTo(String value) {
            addCriterion("FUNC_UPDATE_BY =", value, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByNotEqualTo(String value) {
            addCriterion("FUNC_UPDATE_BY <>", value, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByGreaterThan(String value) {
            addCriterion("FUNC_UPDATE_BY >", value, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_UPDATE_BY >=", value, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByLessThan(String value) {
            addCriterion("FUNC_UPDATE_BY <", value, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByLessThanOrEqualTo(String value) {
            addCriterion("FUNC_UPDATE_BY <=", value, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByLike(String value) {
            addCriterion("FUNC_UPDATE_BY like", value, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByNotLike(String value) {
            addCriterion("FUNC_UPDATE_BY not like", value, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByIn(List<String> values) {
            addCriterion("FUNC_UPDATE_BY in", values, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByNotIn(List<String> values) {
            addCriterion("FUNC_UPDATE_BY not in", values, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByBetween(String value1, String value2) {
            addCriterion("FUNC_UPDATE_BY between", value1, value2, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andFuncUpdateByNotBetween(String value1, String value2) {
            addCriterion("FUNC_UPDATE_BY not between", value1, value2, "funcUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andFuncTagIsNull() {
            addCriterion("FUNC_TAG is null");
            return (Criteria) this;
        }

        public Criteria andFuncTagIsNotNull() {
            addCriterion("FUNC_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andFuncTagEqualTo(String value) {
            addCriterion("FUNC_TAG =", value, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncTagNotEqualTo(String value) {
            addCriterion("FUNC_TAG <>", value, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncTagGreaterThan(String value) {
            addCriterion("FUNC_TAG >", value, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncTagGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_TAG >=", value, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncTagLessThan(String value) {
            addCriterion("FUNC_TAG <", value, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncTagLessThanOrEqualTo(String value) {
            addCriterion("FUNC_TAG <=", value, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncTagLike(String value) {
            addCriterion("FUNC_TAG like", value, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncTagNotLike(String value) {
            addCriterion("FUNC_TAG not like", value, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncTagIn(List<String> values) {
            addCriterion("FUNC_TAG in", values, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncTagNotIn(List<String> values) {
            addCriterion("FUNC_TAG not in", values, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncTagBetween(String value1, String value2) {
            addCriterion("FUNC_TAG between", value1, value2, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncTagNotBetween(String value1, String value2) {
            addCriterion("FUNC_TAG not between", value1, value2, "funcTag");
            return (Criteria) this;
        }

        public Criteria andFuncLevelIsNull() {
            addCriterion("FUNC_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andFuncLevelIsNotNull() {
            addCriterion("FUNC_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andFuncLevelEqualTo(String value) {
            addCriterion("FUNC_LEVEL =", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelNotEqualTo(String value) {
            addCriterion("FUNC_LEVEL <>", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelGreaterThan(String value) {
            addCriterion("FUNC_LEVEL >", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_LEVEL >=", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelLessThan(String value) {
            addCriterion("FUNC_LEVEL <", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelLessThanOrEqualTo(String value) {
            addCriterion("FUNC_LEVEL <=", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelLike(String value) {
            addCriterion("FUNC_LEVEL like", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelNotLike(String value) {
            addCriterion("FUNC_LEVEL not like", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelIn(List<String> values) {
            addCriterion("FUNC_LEVEL in", values, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelNotIn(List<String> values) {
            addCriterion("FUNC_LEVEL not in", values, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelBetween(String value1, String value2) {
            addCriterion("FUNC_LEVEL between", value1, value2, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelNotBetween(String value1, String value2) {
            addCriterion("FUNC_LEVEL not between", value1, value2, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIsNull() {
            addCriterion("FUNC_URL is null");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIsNotNull() {
            addCriterion("FUNC_URL is not null");
            return (Criteria) this;
        }

        public Criteria andFuncUrlEqualTo(String value) {
            addCriterion("FUNC_URL =", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotEqualTo(String value) {
            addCriterion("FUNC_URL <>", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlGreaterThan(String value) {
            addCriterion("FUNC_URL >", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_URL >=", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLessThan(String value) {
            addCriterion("FUNC_URL <", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLessThanOrEqualTo(String value) {
            addCriterion("FUNC_URL <=", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLike(String value) {
            addCriterion("FUNC_URL like", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotLike(String value) {
            addCriterion("FUNC_URL not like", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIn(List<String> values) {
            addCriterion("FUNC_URL in", values, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotIn(List<String> values) {
            addCriterion("FUNC_URL not in", values, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlBetween(String value1, String value2) {
            addCriterion("FUNC_URL between", value1, value2, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotBetween(String value1, String value2) {
            addCriterion("FUNC_URL not between", value1, value2, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncIconIsNull() {
            addCriterion("FUNC_ICON is null");
            return (Criteria) this;
        }

        public Criteria andFuncIconIsNotNull() {
            addCriterion("FUNC_ICON is not null");
            return (Criteria) this;
        }

        public Criteria andFuncIconEqualTo(String value) {
            addCriterion("FUNC_ICON =", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconNotEqualTo(String value) {
            addCriterion("FUNC_ICON <>", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconGreaterThan(String value) {
            addCriterion("FUNC_ICON >", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_ICON >=", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconLessThan(String value) {
            addCriterion("FUNC_ICON <", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconLessThanOrEqualTo(String value) {
            addCriterion("FUNC_ICON <=", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconLike(String value) {
            addCriterion("FUNC_ICON like", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconNotLike(String value) {
            addCriterion("FUNC_ICON not like", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconIn(List<String> values) {
            addCriterion("FUNC_ICON in", values, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconNotIn(List<String> values) {
            addCriterion("FUNC_ICON not in", values, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconBetween(String value1, String value2) {
            addCriterion("FUNC_ICON between", value1, value2, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconNotBetween(String value1, String value2) {
            addCriterion("FUNC_ICON not between", value1, value2, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityIsNull() {
            addCriterion("FUNC_PRIORITY is null");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityIsNotNull() {
            addCriterion("FUNC_PRIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityEqualTo(BigDecimal value) {
            addCriterion("FUNC_PRIORITY =", value, "funcPriority");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityNotEqualTo(BigDecimal value) {
            addCriterion("FUNC_PRIORITY <>", value, "funcPriority");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityGreaterThan(BigDecimal value) {
            addCriterion("FUNC_PRIORITY >", value, "funcPriority");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FUNC_PRIORITY >=", value, "funcPriority");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityLessThan(BigDecimal value) {
            addCriterion("FUNC_PRIORITY <", value, "funcPriority");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FUNC_PRIORITY <=", value, "funcPriority");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityIn(List<BigDecimal> values) {
            addCriterion("FUNC_PRIORITY in", values, "funcPriority");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityNotIn(List<BigDecimal> values) {
            addCriterion("FUNC_PRIORITY not in", values, "funcPriority");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUNC_PRIORITY between", value1, value2, "funcPriority");
            return (Criteria) this;
        }

        public Criteria andFuncPriorityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUNC_PRIORITY not between", value1, value2, "funcPriority");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNull() {
            addCriterion("DELETE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("DELETE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualTo(String value) {
            addCriterion("DELETE_STATUS =", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualTo(String value) {
            addCriterion("DELETE_STATUS <>", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThan(String value) {
            addCriterion("DELETE_STATUS >", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DELETE_STATUS >=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThan(String value) {
            addCriterion("DELETE_STATUS <", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualTo(String value) {
            addCriterion("DELETE_STATUS <=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLike(String value) {
            addCriterion("DELETE_STATUS like", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotLike(String value) {
            addCriterion("DELETE_STATUS not like", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIn(List<String> values) {
            addCriterion("DELETE_STATUS in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotIn(List<String> values) {
            addCriterion("DELETE_STATUS not in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusBetween(String value1, String value2) {
            addCriterion("DELETE_STATUS between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotBetween(String value1, String value2) {
            addCriterion("DELETE_STATUS not between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}