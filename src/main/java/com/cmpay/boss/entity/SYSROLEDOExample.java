package com.cmpay.boss.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SYSROLEDOExample {
    protected String         orderByClause;

    protected boolean        distinct;

    protected List<Criteria> oredCriteria;

    public SYSROLEDOExample() {
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

        protected void addCriterion(String condition, Object value1, Object value2,
                                    String property) {
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

        protected void addCriterionForJDBCDate(String condition, List<Date> values,
                                               String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException(
                    "Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2,
                                               String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()),
                new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("ROLE_ID like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("ROLE_ID not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("ROLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("ROLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("ROLE_NAME =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("ROLE_NAME <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("ROLE_NAME >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("ROLE_NAME <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("ROLE_NAME like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("ROLE_NAME not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("ROLE_NAME in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("ROLE_NAME not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("ROLE_NAME between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("ROLE_NAME not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagIsNull() {
            addCriterion("ROLE_DISABLE_TAG is null");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagIsNotNull() {
            addCriterion("ROLE_DISABLE_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagEqualTo(String value) {
            addCriterion("ROLE_DISABLE_TAG =", value, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagNotEqualTo(String value) {
            addCriterion("ROLE_DISABLE_TAG <>", value, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagGreaterThan(String value) {
            addCriterion("ROLE_DISABLE_TAG >", value, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_DISABLE_TAG >=", value, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagLessThan(String value) {
            addCriterion("ROLE_DISABLE_TAG <", value, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagLessThanOrEqualTo(String value) {
            addCriterion("ROLE_DISABLE_TAG <=", value, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagLike(String value) {
            addCriterion("ROLE_DISABLE_TAG like", value, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagNotLike(String value) {
            addCriterion("ROLE_DISABLE_TAG not like", value, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagIn(List<String> values) {
            addCriterion("ROLE_DISABLE_TAG in", values, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagNotIn(List<String> values) {
            addCriterion("ROLE_DISABLE_TAG not in", values, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagBetween(String value1, String value2) {
            addCriterion("ROLE_DISABLE_TAG between", value1, value2, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleDisableTagNotBetween(String value1, String value2) {
            addCriterion("ROLE_DISABLE_TAG not between", value1, value2, "roleDisableTag");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkIsNull() {
            addCriterion("ROLE_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkIsNotNull() {
            addCriterion("ROLE_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkEqualTo(String value) {
            addCriterion("ROLE_REMARK =", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkNotEqualTo(String value) {
            addCriterion("ROLE_REMARK <>", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkGreaterThan(String value) {
            addCriterion("ROLE_REMARK >", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_REMARK >=", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkLessThan(String value) {
            addCriterion("ROLE_REMARK <", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkLessThanOrEqualTo(String value) {
            addCriterion("ROLE_REMARK <=", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkLike(String value) {
            addCriterion("ROLE_REMARK like", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkNotLike(String value) {
            addCriterion("ROLE_REMARK not like", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkIn(List<String> values) {
            addCriterion("ROLE_REMARK in", values, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkNotIn(List<String> values) {
            addCriterion("ROLE_REMARK not in", values, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkBetween(String value1, String value2) {
            addCriterion("ROLE_REMARK between", value1, value2, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkNotBetween(String value1, String value2) {
            addCriterion("ROLE_REMARK not between", value1, value2, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByIsNull() {
            addCriterion("ROLE_CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByIsNotNull() {
            addCriterion("ROLE_CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByEqualTo(String value) {
            addCriterion("ROLE_CREATE_BY =", value, "roleCreateBy");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByNotEqualTo(String value) {
            addCriterion("ROLE_CREATE_BY <>", value, "roleCreateBy");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByGreaterThan(String value) {
            addCriterion("ROLE_CREATE_BY >", value, "roleCreateBy");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_CREATE_BY >=", value, "roleCreateBy");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByLessThan(String value) {
            addCriterion("ROLE_CREATE_BY <", value, "roleCreateBy");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByLessThanOrEqualTo(String value) {
            addCriterion("ROLE_CREATE_BY <=", value, "roleCreateBy");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByLike(String value) {
            addCriterion("ROLE_CREATE_BY like", value, "roleCreateBy");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByNotLike(String value) {
            addCriterion("ROLE_CREATE_BY not like", value, "roleCreateBy");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByIn(List<String> values) {
            addCriterion("ROLE_CREATE_BY in", values, "roleCreateBy");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByNotIn(List<String> values) {
            addCriterion("ROLE_CREATE_BY not in", values, "roleCreateBy");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByBetween(String value1, String value2) {
            addCriterion("ROLE_CREATE_BY between", value1, value2, "roleCreateBy");
            return (Criteria) this;
        }

        public Criteria andRoleCreateByNotBetween(String value1, String value2) {
            addCriterion("ROLE_CREATE_BY not between", value1, value2, "roleCreateBy");
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

        public Criteria andRoleUpdateByIsNull() {
            addCriterion("ROLE_UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByIsNotNull() {
            addCriterion("ROLE_UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByEqualTo(String value) {
            addCriterion("ROLE_UPDATE_BY =", value, "roleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByNotEqualTo(String value) {
            addCriterion("ROLE_UPDATE_BY <>", value, "roleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByGreaterThan(String value) {
            addCriterion("ROLE_UPDATE_BY >", value, "roleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_UPDATE_BY >=", value, "roleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByLessThan(String value) {
            addCriterion("ROLE_UPDATE_BY <", value, "roleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByLessThanOrEqualTo(String value) {
            addCriterion("ROLE_UPDATE_BY <=", value, "roleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByLike(String value) {
            addCriterion("ROLE_UPDATE_BY like", value, "roleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByNotLike(String value) {
            addCriterion("ROLE_UPDATE_BY not like", value, "roleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByIn(List<String> values) {
            addCriterion("ROLE_UPDATE_BY in", values, "roleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByNotIn(List<String> values) {
            addCriterion("ROLE_UPDATE_BY not in", values, "roleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByBetween(String value1, String value2) {
            addCriterion("ROLE_UPDATE_BY between", value1, value2, "roleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateByNotBetween(String value1, String value2) {
            addCriterion("ROLE_UPDATE_BY not between", value1, value2, "roleUpdateBy");
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
        private String  condition;

        private Object  value;

        private Object  secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String  typeHandler;

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

        protected Criterion(String condition, Object value, Object secondValue,
                            String typeHandler) {
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