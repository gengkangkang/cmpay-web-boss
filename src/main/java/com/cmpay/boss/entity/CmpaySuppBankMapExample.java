package com.cmpay.boss.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmpaySuppBankMapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmpaySuppBankMapExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeIsNull() {
            addCriterion("PC_BANK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeIsNotNull() {
            addCriterion("PC_BANK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeEqualTo(String value) {
            addCriterion("PC_BANK_CODE =", value, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeNotEqualTo(String value) {
            addCriterion("PC_BANK_CODE <>", value, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeGreaterThan(String value) {
            addCriterion("PC_BANK_CODE >", value, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PC_BANK_CODE >=", value, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeLessThan(String value) {
            addCriterion("PC_BANK_CODE <", value, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeLessThanOrEqualTo(String value) {
            addCriterion("PC_BANK_CODE <=", value, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeLike(String value) {
            addCriterion("PC_BANK_CODE like", value, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeNotLike(String value) {
            addCriterion("PC_BANK_CODE not like", value, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeIn(List<String> values) {
            addCriterion("PC_BANK_CODE in", values, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeNotIn(List<String> values) {
            addCriterion("PC_BANK_CODE not in", values, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeBetween(String value1, String value2) {
            addCriterion("PC_BANK_CODE between", value1, value2, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankCodeNotBetween(String value1, String value2) {
            addCriterion("PC_BANK_CODE not between", value1, value2, "pcBankCode");
            return (Criteria) this;
        }

        public Criteria andPcBankNameIsNull() {
            addCriterion("PC_BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPcBankNameIsNotNull() {
            addCriterion("PC_BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPcBankNameEqualTo(String value) {
            addCriterion("PC_BANK_NAME =", value, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPcBankNameNotEqualTo(String value) {
            addCriterion("PC_BANK_NAME <>", value, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPcBankNameGreaterThan(String value) {
            addCriterion("PC_BANK_NAME >", value, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPcBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("PC_BANK_NAME >=", value, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPcBankNameLessThan(String value) {
            addCriterion("PC_BANK_NAME <", value, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPcBankNameLessThanOrEqualTo(String value) {
            addCriterion("PC_BANK_NAME <=", value, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPcBankNameLike(String value) {
            addCriterion("PC_BANK_NAME like", value, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPcBankNameNotLike(String value) {
            addCriterion("PC_BANK_NAME not like", value, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPcBankNameIn(List<String> values) {
            addCriterion("PC_BANK_NAME in", values, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPcBankNameNotIn(List<String> values) {
            addCriterion("PC_BANK_NAME not in", values, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPcBankNameBetween(String value1, String value2) {
            addCriterion("PC_BANK_NAME between", value1, value2, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPcBankNameNotBetween(String value1, String value2) {
            addCriterion("PC_BANK_NAME not between", value1, value2, "pcBankName");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeIsNull() {
            addCriterion("PAY_CHANNEL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeIsNotNull() {
            addCriterion("PAY_CHANNEL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeEqualTo(String value) {
            addCriterion("PAY_CHANNEL_CODE =", value, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeNotEqualTo(String value) {
            addCriterion("PAY_CHANNEL_CODE <>", value, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeGreaterThan(String value) {
            addCriterion("PAY_CHANNEL_CODE >", value, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_CHANNEL_CODE >=", value, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeLessThan(String value) {
            addCriterion("PAY_CHANNEL_CODE <", value, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeLessThanOrEqualTo(String value) {
            addCriterion("PAY_CHANNEL_CODE <=", value, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeLike(String value) {
            addCriterion("PAY_CHANNEL_CODE like", value, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeNotLike(String value) {
            addCriterion("PAY_CHANNEL_CODE not like", value, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeIn(List<String> values) {
            addCriterion("PAY_CHANNEL_CODE in", values, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeNotIn(List<String> values) {
            addCriterion("PAY_CHANNEL_CODE not in", values, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeBetween(String value1, String value2) {
            addCriterion("PAY_CHANNEL_CODE between", value1, value2, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayChannelCodeNotBetween(String value1, String value2) {
            addCriterion("PAY_CHANNEL_CODE not between", value1, value2, "payChannelCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeIsNull() {
            addCriterion("PAY_BANK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeIsNotNull() {
            addCriterion("PAY_BANK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeEqualTo(String value) {
            addCriterion("PAY_BANK_CODE =", value, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeNotEqualTo(String value) {
            addCriterion("PAY_BANK_CODE <>", value, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeGreaterThan(String value) {
            addCriterion("PAY_BANK_CODE >", value, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_BANK_CODE >=", value, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeLessThan(String value) {
            addCriterion("PAY_BANK_CODE <", value, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeLessThanOrEqualTo(String value) {
            addCriterion("PAY_BANK_CODE <=", value, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeLike(String value) {
            addCriterion("PAY_BANK_CODE like", value, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeNotLike(String value) {
            addCriterion("PAY_BANK_CODE not like", value, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeIn(List<String> values) {
            addCriterion("PAY_BANK_CODE in", values, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeNotIn(List<String> values) {
            addCriterion("PAY_BANK_CODE not in", values, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeBetween(String value1, String value2) {
            addCriterion("PAY_BANK_CODE between", value1, value2, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andPayBankCodeNotBetween(String value1, String value2) {
            addCriterion("PAY_BANK_CODE not between", value1, value2, "payBankCode");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountIsNull() {
            addCriterion("SINGLE_MAX_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountIsNotNull() {
            addCriterion("SINGLE_MAX_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountEqualTo(BigDecimal value) {
            addCriterion("SINGLE_MAX_AMOUNT =", value, "singleMaxAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("SINGLE_MAX_AMOUNT <>", value, "singleMaxAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountGreaterThan(BigDecimal value) {
            addCriterion("SINGLE_MAX_AMOUNT >", value, "singleMaxAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SINGLE_MAX_AMOUNT >=", value, "singleMaxAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountLessThan(BigDecimal value) {
            addCriterion("SINGLE_MAX_AMOUNT <", value, "singleMaxAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SINGLE_MAX_AMOUNT <=", value, "singleMaxAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountIn(List<BigDecimal> values) {
            addCriterion("SINGLE_MAX_AMOUNT in", values, "singleMaxAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("SINGLE_MAX_AMOUNT not in", values, "singleMaxAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SINGLE_MAX_AMOUNT between", value1, value2, "singleMaxAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SINGLE_MAX_AMOUNT not between", value1, value2, "singleMaxAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountIsNull() {
            addCriterion("SINGLE_MIN_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountIsNotNull() {
            addCriterion("SINGLE_MIN_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountEqualTo(BigDecimal value) {
            addCriterion("SINGLE_MIN_AMOUNT =", value, "singleMinAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountNotEqualTo(BigDecimal value) {
            addCriterion("SINGLE_MIN_AMOUNT <>", value, "singleMinAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountGreaterThan(BigDecimal value) {
            addCriterion("SINGLE_MIN_AMOUNT >", value, "singleMinAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SINGLE_MIN_AMOUNT >=", value, "singleMinAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountLessThan(BigDecimal value) {
            addCriterion("SINGLE_MIN_AMOUNT <", value, "singleMinAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SINGLE_MIN_AMOUNT <=", value, "singleMinAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountIn(List<BigDecimal> values) {
            addCriterion("SINGLE_MIN_AMOUNT in", values, "singleMinAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountNotIn(List<BigDecimal> values) {
            addCriterion("SINGLE_MIN_AMOUNT not in", values, "singleMinAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SINGLE_MIN_AMOUNT between", value1, value2, "singleMinAmount");
            return (Criteria) this;
        }

        public Criteria andSingleMinAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SINGLE_MIN_AMOUNT not between", value1, value2, "singleMinAmount");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountIsNull() {
            addCriterion("DAY_MAX_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountIsNotNull() {
            addCriterion("DAY_MAX_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountEqualTo(BigDecimal value) {
            addCriterion("DAY_MAX_AMOUNT =", value, "dayMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("DAY_MAX_AMOUNT <>", value, "dayMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountGreaterThan(BigDecimal value) {
            addCriterion("DAY_MAX_AMOUNT >", value, "dayMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_MAX_AMOUNT >=", value, "dayMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountLessThan(BigDecimal value) {
            addCriterion("DAY_MAX_AMOUNT <", value, "dayMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_MAX_AMOUNT <=", value, "dayMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountIn(List<BigDecimal> values) {
            addCriterion("DAY_MAX_AMOUNT in", values, "dayMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("DAY_MAX_AMOUNT not in", values, "dayMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_MAX_AMOUNT between", value1, value2, "dayMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDayMaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_MAX_AMOUNT not between", value1, value2, "dayMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesIsNull() {
            addCriterion("DAY_MAX_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesIsNotNull() {
            addCriterion("DAY_MAX_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesEqualTo(Integer value) {
            addCriterion("DAY_MAX_TIMES =", value, "dayMaxTimes");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesNotEqualTo(Integer value) {
            addCriterion("DAY_MAX_TIMES <>", value, "dayMaxTimes");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesGreaterThan(Integer value) {
            addCriterion("DAY_MAX_TIMES >", value, "dayMaxTimes");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("DAY_MAX_TIMES >=", value, "dayMaxTimes");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesLessThan(Integer value) {
            addCriterion("DAY_MAX_TIMES <", value, "dayMaxTimes");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesLessThanOrEqualTo(Integer value) {
            addCriterion("DAY_MAX_TIMES <=", value, "dayMaxTimes");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesIn(List<Integer> values) {
            addCriterion("DAY_MAX_TIMES in", values, "dayMaxTimes");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesNotIn(List<Integer> values) {
            addCriterion("DAY_MAX_TIMES not in", values, "dayMaxTimes");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesBetween(Integer value1, Integer value2) {
            addCriterion("DAY_MAX_TIMES between", value1, value2, "dayMaxTimes");
            return (Criteria) this;
        }

        public Criteria andDayMaxTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("DAY_MAX_TIMES not between", value1, value2, "dayMaxTimes");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountIsNull() {
            addCriterion("MONTH_MAX_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountIsNotNull() {
            addCriterion("MONTH_MAX_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountEqualTo(BigDecimal value) {
            addCriterion("MONTH_MAX_AMOUNT =", value, "monthMaxAmount");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("MONTH_MAX_AMOUNT <>", value, "monthMaxAmount");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountGreaterThan(BigDecimal value) {
            addCriterion("MONTH_MAX_AMOUNT >", value, "monthMaxAmount");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONTH_MAX_AMOUNT >=", value, "monthMaxAmount");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountLessThan(BigDecimal value) {
            addCriterion("MONTH_MAX_AMOUNT <", value, "monthMaxAmount");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONTH_MAX_AMOUNT <=", value, "monthMaxAmount");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountIn(List<BigDecimal> values) {
            addCriterion("MONTH_MAX_AMOUNT in", values, "monthMaxAmount");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("MONTH_MAX_AMOUNT not in", values, "monthMaxAmount");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONTH_MAX_AMOUNT between", value1, value2, "monthMaxAmount");
            return (Criteria) this;
        }

        public Criteria andMonthMaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONTH_MAX_AMOUNT not between", value1, value2, "monthMaxAmount");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesIsNull() {
            addCriterion("MONTH_MAX_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesIsNotNull() {
            addCriterion("MONTH_MAX_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesEqualTo(Integer value) {
            addCriterion("MONTH_MAX_TIMES =", value, "monthMaxTimes");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesNotEqualTo(Integer value) {
            addCriterion("MONTH_MAX_TIMES <>", value, "monthMaxTimes");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesGreaterThan(Integer value) {
            addCriterion("MONTH_MAX_TIMES >", value, "monthMaxTimes");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("MONTH_MAX_TIMES >=", value, "monthMaxTimes");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesLessThan(Integer value) {
            addCriterion("MONTH_MAX_TIMES <", value, "monthMaxTimes");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesLessThanOrEqualTo(Integer value) {
            addCriterion("MONTH_MAX_TIMES <=", value, "monthMaxTimes");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesIn(List<Integer> values) {
            addCriterion("MONTH_MAX_TIMES in", values, "monthMaxTimes");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesNotIn(List<Integer> values) {
            addCriterion("MONTH_MAX_TIMES not in", values, "monthMaxTimes");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesBetween(Integer value1, Integer value2) {
            addCriterion("MONTH_MAX_TIMES between", value1, value2, "monthMaxTimes");
            return (Criteria) this;
        }

        public Criteria andMonthMaxTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("MONTH_MAX_TIMES not between", value1, value2, "monthMaxTimes");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("CREATOR =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("CREATOR <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("CREATOR >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("CREATOR <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("CREATOR <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("CREATOR like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("CREATOR not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("CREATOR in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("CREATOR not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
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
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("MODIFIER is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("MODIFIER is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("MODIFIER =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("MODIFIER <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("MODIFIER >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIER >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("MODIFIER <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("MODIFIER <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("MODIFIER like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("MODIFIER not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("MODIFIER in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("MODIFIER not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("MODIFIER between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("MODIFIER not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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