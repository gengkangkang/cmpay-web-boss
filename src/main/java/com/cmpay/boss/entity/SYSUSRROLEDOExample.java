package com.cmpay.boss.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SYSUSRROLEDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SYSUSRROLEDOExample() {
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

        public Criteria andUsrRoleRemarkIsNull() {
            addCriterion("USR_ROLE_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkIsNotNull() {
            addCriterion("USR_ROLE_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkEqualTo(String value) {
            addCriterion("USR_ROLE_REMARK =", value, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkNotEqualTo(String value) {
            addCriterion("USR_ROLE_REMARK <>", value, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkGreaterThan(String value) {
            addCriterion("USR_ROLE_REMARK >", value, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("USR_ROLE_REMARK >=", value, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkLessThan(String value) {
            addCriterion("USR_ROLE_REMARK <", value, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkLessThanOrEqualTo(String value) {
            addCriterion("USR_ROLE_REMARK <=", value, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkLike(String value) {
            addCriterion("USR_ROLE_REMARK like", value, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkNotLike(String value) {
            addCriterion("USR_ROLE_REMARK not like", value, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkIn(List<String> values) {
            addCriterion("USR_ROLE_REMARK in", values, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkNotIn(List<String> values) {
            addCriterion("USR_ROLE_REMARK not in", values, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkBetween(String value1, String value2) {
            addCriterion("USR_ROLE_REMARK between", value1, value2, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleRemarkNotBetween(String value1, String value2) {
            addCriterion("USR_ROLE_REMARK not between", value1, value2, "usrRoleRemark");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByIsNull() {
            addCriterion("USR_ROLE_CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByIsNotNull() {
            addCriterion("USR_ROLE_CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByEqualTo(String value) {
            addCriterion("USR_ROLE_CREATE_BY =", value, "usrRoleCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByNotEqualTo(String value) {
            addCriterion("USR_ROLE_CREATE_BY <>", value, "usrRoleCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByGreaterThan(String value) {
            addCriterion("USR_ROLE_CREATE_BY >", value, "usrRoleCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("USR_ROLE_CREATE_BY >=", value, "usrRoleCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByLessThan(String value) {
            addCriterion("USR_ROLE_CREATE_BY <", value, "usrRoleCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByLessThanOrEqualTo(String value) {
            addCriterion("USR_ROLE_CREATE_BY <=", value, "usrRoleCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByLike(String value) {
            addCriterion("USR_ROLE_CREATE_BY like", value, "usrRoleCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByNotLike(String value) {
            addCriterion("USR_ROLE_CREATE_BY not like", value, "usrRoleCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByIn(List<String> values) {
            addCriterion("USR_ROLE_CREATE_BY in", values, "usrRoleCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByNotIn(List<String> values) {
            addCriterion("USR_ROLE_CREATE_BY not in", values, "usrRoleCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByBetween(String value1, String value2) {
            addCriterion("USR_ROLE_CREATE_BY between", value1, value2, "usrRoleCreateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleCreateByNotBetween(String value1, String value2) {
            addCriterion("USR_ROLE_CREATE_BY not between", value1, value2, "usrRoleCreateBy");
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

        public Criteria andUsrRoleUpdateByIsNull() {
            addCriterion("USR_ROLE_UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByIsNotNull() {
            addCriterion("USR_ROLE_UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByEqualTo(String value) {
            addCriterion("USR_ROLE_UPDATE_BY =", value, "usrRoleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByNotEqualTo(String value) {
            addCriterion("USR_ROLE_UPDATE_BY <>", value, "usrRoleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByGreaterThan(String value) {
            addCriterion("USR_ROLE_UPDATE_BY >", value, "usrRoleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("USR_ROLE_UPDATE_BY >=", value, "usrRoleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByLessThan(String value) {
            addCriterion("USR_ROLE_UPDATE_BY <", value, "usrRoleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByLessThanOrEqualTo(String value) {
            addCriterion("USR_ROLE_UPDATE_BY <=", value, "usrRoleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByLike(String value) {
            addCriterion("USR_ROLE_UPDATE_BY like", value, "usrRoleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByNotLike(String value) {
            addCriterion("USR_ROLE_UPDATE_BY not like", value, "usrRoleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByIn(List<String> values) {
            addCriterion("USR_ROLE_UPDATE_BY in", values, "usrRoleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByNotIn(List<String> values) {
            addCriterion("USR_ROLE_UPDATE_BY not in", values, "usrRoleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByBetween(String value1, String value2) {
            addCriterion("USR_ROLE_UPDATE_BY between", value1, value2, "usrRoleUpdateBy");
            return (Criteria) this;
        }

        public Criteria andUsrRoleUpdateByNotBetween(String value1, String value2) {
            addCriterion("USR_ROLE_UPDATE_BY not between", value1, value2, "usrRoleUpdateBy");
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