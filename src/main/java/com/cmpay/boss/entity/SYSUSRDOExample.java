package com.cmpay.boss.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SYSUSRDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SYSUSRDOExample() {
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

        public Criteria andUsrIdIsNull() {
            addCriterion("USR_ID is null");
            return (Criteria) this;
        }

        public Criteria andUsrIdIsNotNull() {
            addCriterion("USR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUsrIdEqualTo(String value) {
            addCriterion("USR_ID =", value, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrIdNotEqualTo(String value) {
            addCriterion("USR_ID <>", value, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrIdGreaterThan(String value) {
            addCriterion("USR_ID >", value, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrIdGreaterThanOrEqualTo(String value) {
            addCriterion("USR_ID >=", value, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrIdLessThan(String value) {
            addCriterion("USR_ID <", value, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrIdLessThanOrEqualTo(String value) {
            addCriterion("USR_ID <=", value, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrIdLike(String value) {
            addCriterion("USR_ID like", value, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrIdNotLike(String value) {
            addCriterion("USR_ID not like", value, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrIdIn(List<String> values) {
            addCriterion("USR_ID in", values, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrIdNotIn(List<String> values) {
            addCriterion("USR_ID not in", values, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrIdBetween(String value1, String value2) {
            addCriterion("USR_ID between", value1, value2, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrIdNotBetween(String value1, String value2) {
            addCriterion("USR_ID not between", value1, value2, "usrId");
            return (Criteria) this;
        }

        public Criteria andUsrNameIsNull() {
            addCriterion("USR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUsrNameIsNotNull() {
            addCriterion("USR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsrNameEqualTo(String value) {
            addCriterion("USR_NAME =", value, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrNameNotEqualTo(String value) {
            addCriterion("USR_NAME <>", value, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrNameGreaterThan(String value) {
            addCriterion("USR_NAME >", value, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrNameGreaterThanOrEqualTo(String value) {
            addCriterion("USR_NAME >=", value, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrNameLessThan(String value) {
            addCriterion("USR_NAME <", value, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrNameLessThanOrEqualTo(String value) {
            addCriterion("USR_NAME <=", value, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrNameLike(String value) {
            addCriterion("USR_NAME like", value, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrNameNotLike(String value) {
            addCriterion("USR_NAME not like", value, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrNameIn(List<String> values) {
            addCriterion("USR_NAME in", values, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrNameNotIn(List<String> values) {
            addCriterion("USR_NAME not in", values, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrNameBetween(String value1, String value2) {
            addCriterion("USR_NAME between", value1, value2, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrNameNotBetween(String value1, String value2) {
            addCriterion("USR_NAME not between", value1, value2, "usrName");
            return (Criteria) this;
        }

        public Criteria andUsrPwdIsNull() {
            addCriterion("USR_PWD is null");
            return (Criteria) this;
        }

        public Criteria andUsrPwdIsNotNull() {
            addCriterion("USR_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andUsrPwdEqualTo(String value) {
            addCriterion("USR_PWD =", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdNotEqualTo(String value) {
            addCriterion("USR_PWD <>", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdGreaterThan(String value) {
            addCriterion("USR_PWD >", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdGreaterThanOrEqualTo(String value) {
            addCriterion("USR_PWD >=", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdLessThan(String value) {
            addCriterion("USR_PWD <", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdLessThanOrEqualTo(String value) {
            addCriterion("USR_PWD <=", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdLike(String value) {
            addCriterion("USR_PWD like", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdNotLike(String value) {
            addCriterion("USR_PWD not like", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdIn(List<String> values) {
            addCriterion("USR_PWD in", values, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdNotIn(List<String> values) {
            addCriterion("USR_PWD not in", values, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdBetween(String value1, String value2) {
            addCriterion("USR_PWD between", value1, value2, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdNotBetween(String value1, String value2) {
            addCriterion("USR_PWD not between", value1, value2, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkIsNull() {
            addCriterion("USR_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkIsNotNull() {
            addCriterion("USR_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkEqualTo(String value) {
            addCriterion("USR_REMARK =", value, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkNotEqualTo(String value) {
            addCriterion("USR_REMARK <>", value, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkGreaterThan(String value) {
            addCriterion("USR_REMARK >", value, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("USR_REMARK >=", value, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkLessThan(String value) {
            addCriterion("USR_REMARK <", value, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkLessThanOrEqualTo(String value) {
            addCriterion("USR_REMARK <=", value, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkLike(String value) {
            addCriterion("USR_REMARK like", value, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkNotLike(String value) {
            addCriterion("USR_REMARK not like", value, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkIn(List<String> values) {
            addCriterion("USR_REMARK in", values, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkNotIn(List<String> values) {
            addCriterion("USR_REMARK not in", values, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkBetween(String value1, String value2) {
            addCriterion("USR_REMARK between", value1, value2, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRemarkNotBetween(String value1, String value2) {
            addCriterion("USR_REMARK not between", value1, value2, "usrRemark");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagIsNull() {
            addCriterion("USR_DISABLE_TAG is null");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagIsNotNull() {
            addCriterion("USR_DISABLE_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagEqualTo(String value) {
            addCriterion("USR_DISABLE_TAG =", value, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagNotEqualTo(String value) {
            addCriterion("USR_DISABLE_TAG <>", value, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagGreaterThan(String value) {
            addCriterion("USR_DISABLE_TAG >", value, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagGreaterThanOrEqualTo(String value) {
            addCriterion("USR_DISABLE_TAG >=", value, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagLessThan(String value) {
            addCriterion("USR_DISABLE_TAG <", value, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagLessThanOrEqualTo(String value) {
            addCriterion("USR_DISABLE_TAG <=", value, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagLike(String value) {
            addCriterion("USR_DISABLE_TAG like", value, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagNotLike(String value) {
            addCriterion("USR_DISABLE_TAG not like", value, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagIn(List<String> values) {
            addCriterion("USR_DISABLE_TAG in", values, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagNotIn(List<String> values) {
            addCriterion("USR_DISABLE_TAG not in", values, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagBetween(String value1, String value2) {
            addCriterion("USR_DISABLE_TAG between", value1, value2, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrDisableTagNotBetween(String value1, String value2) {
            addCriterion("USR_DISABLE_TAG not between", value1, value2, "usrDisableTag");
            return (Criteria) this;
        }

        public Criteria andUsrEmailIsNull() {
            addCriterion("USR_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andUsrEmailIsNotNull() {
            addCriterion("USR_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andUsrEmailEqualTo(String value) {
            addCriterion("USR_EMAIL =", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailNotEqualTo(String value) {
            addCriterion("USR_EMAIL <>", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailGreaterThan(String value) {
            addCriterion("USR_EMAIL >", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailGreaterThanOrEqualTo(String value) {
            addCriterion("USR_EMAIL >=", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailLessThan(String value) {
            addCriterion("USR_EMAIL <", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailLessThanOrEqualTo(String value) {
            addCriterion("USR_EMAIL <=", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailLike(String value) {
            addCriterion("USR_EMAIL like", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailNotLike(String value) {
            addCriterion("USR_EMAIL not like", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailIn(List<String> values) {
            addCriterion("USR_EMAIL in", values, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailNotIn(List<String> values) {
            addCriterion("USR_EMAIL not in", values, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailBetween(String value1, String value2) {
            addCriterion("USR_EMAIL between", value1, value2, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailNotBetween(String value1, String value2) {
            addCriterion("USR_EMAIL not between", value1, value2, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrTypeIsNull() {
            addCriterion("USR_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUsrTypeIsNotNull() {
            addCriterion("USR_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUsrTypeEqualTo(String value) {
            addCriterion("USR_TYPE =", value, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrTypeNotEqualTo(String value) {
            addCriterion("USR_TYPE <>", value, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrTypeGreaterThan(String value) {
            addCriterion("USR_TYPE >", value, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrTypeGreaterThanOrEqualTo(String value) {
            addCriterion("USR_TYPE >=", value, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrTypeLessThan(String value) {
            addCriterion("USR_TYPE <", value, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrTypeLessThanOrEqualTo(String value) {
            addCriterion("USR_TYPE <=", value, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrTypeLike(String value) {
            addCriterion("USR_TYPE like", value, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrTypeNotLike(String value) {
            addCriterion("USR_TYPE not like", value, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrTypeIn(List<String> values) {
            addCriterion("USR_TYPE in", values, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrTypeNotIn(List<String> values) {
            addCriterion("USR_TYPE not in", values, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrTypeBetween(String value1, String value2) {
            addCriterion("USR_TYPE between", value1, value2, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrTypeNotBetween(String value1, String value2) {
            addCriterion("USR_TYPE not between", value1, value2, "usrType");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByIsNull() {
            addCriterion("USR_CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByIsNotNull() {
            addCriterion("USR_CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByEqualTo(String value) {
            addCriterion("USR_CREATE_BY =", value, "usrCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByNotEqualTo(String value) {
            addCriterion("USR_CREATE_BY <>", value, "usrCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByGreaterThan(String value) {
            addCriterion("USR_CREATE_BY >", value, "usrCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("USR_CREATE_BY >=", value, "usrCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByLessThan(String value) {
            addCriterion("USR_CREATE_BY <", value, "usrCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByLessThanOrEqualTo(String value) {
            addCriterion("USR_CREATE_BY <=", value, "usrCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByLike(String value) {
            addCriterion("USR_CREATE_BY like", value, "usrCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByNotLike(String value) {
            addCriterion("USR_CREATE_BY not like", value, "usrCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByIn(List<String> values) {
            addCriterion("USR_CREATE_BY in", values, "usrCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByNotIn(List<String> values) {
            addCriterion("USR_CREATE_BY not in", values, "usrCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByBetween(String value1, String value2) {
            addCriterion("USR_CREATE_BY between", value1, value2, "usrCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrCreateByNotBetween(String value1, String value2) {
            addCriterion("USR_CREATE_BY not between", value1, value2, "usrCreateBy");
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

        public Criteria andUsrUpdateByIsNull() {
            addCriterion("USR_UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByIsNotNull() {
            addCriterion("USR_UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByEqualTo(String value) {
            addCriterion("USR_UPDATE_BY =", value, "usrUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByNotEqualTo(String value) {
            addCriterion("USR_UPDATE_BY <>", value, "usrUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByGreaterThan(String value) {
            addCriterion("USR_UPDATE_BY >", value, "usrUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("USR_UPDATE_BY >=", value, "usrUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByLessThan(String value) {
            addCriterion("USR_UPDATE_BY <", value, "usrUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByLessThanOrEqualTo(String value) {
            addCriterion("USR_UPDATE_BY <=", value, "usrUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByLike(String value) {
            addCriterion("USR_UPDATE_BY like", value, "usrUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByNotLike(String value) {
            addCriterion("USR_UPDATE_BY not like", value, "usrUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByIn(List<String> values) {
            addCriterion("USR_UPDATE_BY in", values, "usrUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByNotIn(List<String> values) {
            addCriterion("USR_UPDATE_BY not in", values, "usrUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByBetween(String value1, String value2) {
            addCriterion("USR_UPDATE_BY between", value1, value2, "usrUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrUpdateByNotBetween(String value1, String value2) {
            addCriterion("USR_UPDATE_BY not between", value1, value2, "usrUpdateBy");
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