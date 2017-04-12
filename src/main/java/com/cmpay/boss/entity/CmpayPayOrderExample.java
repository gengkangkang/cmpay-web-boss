package com.cmpay.boss.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmpayPayOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmpayPayOrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("ORDER_ID like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("ORDER_ID not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andInchannelIsNull() {
            addCriterion("INCHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andInchannelIsNotNull() {
            addCriterion("INCHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andInchannelEqualTo(String value) {
            addCriterion("INCHANNEL =", value, "inchannel");
            return (Criteria) this;
        }

        public Criteria andInchannelNotEqualTo(String value) {
            addCriterion("INCHANNEL <>", value, "inchannel");
            return (Criteria) this;
        }

        public Criteria andInchannelGreaterThan(String value) {
            addCriterion("INCHANNEL >", value, "inchannel");
            return (Criteria) this;
        }

        public Criteria andInchannelGreaterThanOrEqualTo(String value) {
            addCriterion("INCHANNEL >=", value, "inchannel");
            return (Criteria) this;
        }

        public Criteria andInchannelLessThan(String value) {
            addCriterion("INCHANNEL <", value, "inchannel");
            return (Criteria) this;
        }

        public Criteria andInchannelLessThanOrEqualTo(String value) {
            addCriterion("INCHANNEL <=", value, "inchannel");
            return (Criteria) this;
        }

        public Criteria andInchannelLike(String value) {
            addCriterion("INCHANNEL like", value, "inchannel");
            return (Criteria) this;
        }

        public Criteria andInchannelNotLike(String value) {
            addCriterion("INCHANNEL not like", value, "inchannel");
            return (Criteria) this;
        }

        public Criteria andInchannelIn(List<String> values) {
            addCriterion("INCHANNEL in", values, "inchannel");
            return (Criteria) this;
        }

        public Criteria andInchannelNotIn(List<String> values) {
            addCriterion("INCHANNEL not in", values, "inchannel");
            return (Criteria) this;
        }

        public Criteria andInchannelBetween(String value1, String value2) {
            addCriterion("INCHANNEL between", value1, value2, "inchannel");
            return (Criteria) this;
        }

        public Criteria andInchannelNotBetween(String value1, String value2) {
            addCriterion("INCHANNEL not between", value1, value2, "inchannel");
            return (Criteria) this;
        }

        public Criteria andMerNoIsNull() {
            addCriterion("MER_NO is null");
            return (Criteria) this;
        }

        public Criteria andMerNoIsNotNull() {
            addCriterion("MER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMerNoEqualTo(String value) {
            addCriterion("MER_NO =", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoNotEqualTo(String value) {
            addCriterion("MER_NO <>", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoGreaterThan(String value) {
            addCriterion("MER_NO >", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoGreaterThanOrEqualTo(String value) {
            addCriterion("MER_NO >=", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoLessThan(String value) {
            addCriterion("MER_NO <", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoLessThanOrEqualTo(String value) {
            addCriterion("MER_NO <=", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoLike(String value) {
            addCriterion("MER_NO like", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoNotLike(String value) {
            addCriterion("MER_NO not like", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoIn(List<String> values) {
            addCriterion("MER_NO in", values, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoNotIn(List<String> values) {
            addCriterion("MER_NO not in", values, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoBetween(String value1, String value2) {
            addCriterion("MER_NO between", value1, value2, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoNotBetween(String value1, String value2) {
            addCriterion("MER_NO not between", value1, value2, "merNo");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoIsNull() {
            addCriterion("ORIG_ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoIsNotNull() {
            addCriterion("ORIG_ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoEqualTo(String value) {
            addCriterion("ORIG_ORDER_NO =", value, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoNotEqualTo(String value) {
            addCriterion("ORIG_ORDER_NO <>", value, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoGreaterThan(String value) {
            addCriterion("ORIG_ORDER_NO >", value, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORIG_ORDER_NO >=", value, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoLessThan(String value) {
            addCriterion("ORIG_ORDER_NO <", value, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORIG_ORDER_NO <=", value, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoLike(String value) {
            addCriterion("ORIG_ORDER_NO like", value, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoNotLike(String value) {
            addCriterion("ORIG_ORDER_NO not like", value, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoIn(List<String> values) {
            addCriterion("ORIG_ORDER_NO in", values, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoNotIn(List<String> values) {
            addCriterion("ORIG_ORDER_NO not in", values, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoBetween(String value1, String value2) {
            addCriterion("ORIG_ORDER_NO between", value1, value2, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andOrigOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORIG_ORDER_NO not between", value1, value2, "origOrderNo");
            return (Criteria) this;
        }

        public Criteria andBackUrlIsNull() {
            addCriterion("BACK_URL is null");
            return (Criteria) this;
        }

        public Criteria andBackUrlIsNotNull() {
            addCriterion("BACK_URL is not null");
            return (Criteria) this;
        }

        public Criteria andBackUrlEqualTo(String value) {
            addCriterion("BACK_URL =", value, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBackUrlNotEqualTo(String value) {
            addCriterion("BACK_URL <>", value, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBackUrlGreaterThan(String value) {
            addCriterion("BACK_URL >", value, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("BACK_URL >=", value, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBackUrlLessThan(String value) {
            addCriterion("BACK_URL <", value, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBackUrlLessThanOrEqualTo(String value) {
            addCriterion("BACK_URL <=", value, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBackUrlLike(String value) {
            addCriterion("BACK_URL like", value, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBackUrlNotLike(String value) {
            addCriterion("BACK_URL not like", value, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBackUrlIn(List<String> values) {
            addCriterion("BACK_URL in", values, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBackUrlNotIn(List<String> values) {
            addCriterion("BACK_URL not in", values, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBackUrlBetween(String value1, String value2) {
            addCriterion("BACK_URL between", value1, value2, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBackUrlNotBetween(String value1, String value2) {
            addCriterion("BACK_URL not between", value1, value2, "backUrl");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNull() {
            addCriterion("BANK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("BANK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("BANK_CODE =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("BANK_CODE <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("BANK_CODE >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_CODE >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("BANK_CODE <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("BANK_CODE <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("BANK_CODE like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("BANK_CODE not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("BANK_CODE in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("BANK_CODE not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("BANK_CODE between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("BANK_CODE not between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("CARD_NO is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("CARD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("CARD_NO =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("CARD_NO <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("CARD_NO >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_NO >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("CARD_NO <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("CARD_NO <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("CARD_NO like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("CARD_NO not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("CARD_NO in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("CARD_NO not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("CARD_NO between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("CARD_NO not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("CITY is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("CITY =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("CITY <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("CITY >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("CITY >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("CITY <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("CITY <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("CITY like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("CITY not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("CITY in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("CITY not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("CITY between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("CITY not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoIsNull() {
            addCriterion("CUST_ACCTNO is null");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoIsNotNull() {
            addCriterion("CUST_ACCTNO is not null");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoEqualTo(String value) {
            addCriterion("CUST_ACCTNO =", value, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoNotEqualTo(String value) {
            addCriterion("CUST_ACCTNO <>", value, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoGreaterThan(String value) {
            addCriterion("CUST_ACCTNO >", value, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ACCTNO >=", value, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoLessThan(String value) {
            addCriterion("CUST_ACCTNO <", value, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoLessThanOrEqualTo(String value) {
            addCriterion("CUST_ACCTNO <=", value, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoLike(String value) {
            addCriterion("CUST_ACCTNO like", value, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoNotLike(String value) {
            addCriterion("CUST_ACCTNO not like", value, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoIn(List<String> values) {
            addCriterion("CUST_ACCTNO in", values, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoNotIn(List<String> values) {
            addCriterion("CUST_ACCTNO not in", values, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoBetween(String value1, String value2) {
            addCriterion("CUST_ACCTNO between", value1, value2, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustAcctnoNotBetween(String value1, String value2) {
            addCriterion("CUST_ACCTNO not between", value1, value2, "custAcctno");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("CUST_ID like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("CUST_ID not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("CUST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("CUST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("CUST_NAME =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("CUST_NAME <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("CUST_NAME >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NAME >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("CUST_NAME <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("CUST_NAME <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("CUST_NAME like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("CUST_NAME not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("CUST_NAME in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("CUST_NAME not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("CUST_NAME between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("CUST_NAME not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andHasnotifyIsNull() {
            addCriterion("HASNOTIFY is null");
            return (Criteria) this;
        }

        public Criteria andHasnotifyIsNotNull() {
            addCriterion("HASNOTIFY is not null");
            return (Criteria) this;
        }

        public Criteria andHasnotifyEqualTo(Short value) {
            addCriterion("HASNOTIFY =", value, "hasnotify");
            return (Criteria) this;
        }

        public Criteria andHasnotifyNotEqualTo(Short value) {
            addCriterion("HASNOTIFY <>", value, "hasnotify");
            return (Criteria) this;
        }

        public Criteria andHasnotifyGreaterThan(Short value) {
            addCriterion("HASNOTIFY >", value, "hasnotify");
            return (Criteria) this;
        }

        public Criteria andHasnotifyGreaterThanOrEqualTo(Short value) {
            addCriterion("HASNOTIFY >=", value, "hasnotify");
            return (Criteria) this;
        }

        public Criteria andHasnotifyLessThan(Short value) {
            addCriterion("HASNOTIFY <", value, "hasnotify");
            return (Criteria) this;
        }

        public Criteria andHasnotifyLessThanOrEqualTo(Short value) {
            addCriterion("HASNOTIFY <=", value, "hasnotify");
            return (Criteria) this;
        }

        public Criteria andHasnotifyIn(List<Short> values) {
            addCriterion("HASNOTIFY in", values, "hasnotify");
            return (Criteria) this;
        }

        public Criteria andHasnotifyNotIn(List<Short> values) {
            addCriterion("HASNOTIFY not in", values, "hasnotify");
            return (Criteria) this;
        }

        public Criteria andHasnotifyBetween(Short value1, Short value2) {
            addCriterion("HASNOTIFY between", value1, value2, "hasnotify");
            return (Criteria) this;
        }

        public Criteria andHasnotifyNotBetween(Short value1, Short value2) {
            addCriterion("HASNOTIFY not between", value1, value2, "hasnotify");
            return (Criteria) this;
        }

        public Criteria andInAcctIsNull() {
            addCriterion("IN_ACCT is null");
            return (Criteria) this;
        }

        public Criteria andInAcctIsNotNull() {
            addCriterion("IN_ACCT is not null");
            return (Criteria) this;
        }

        public Criteria andInAcctEqualTo(Short value) {
            addCriterion("IN_ACCT =", value, "inAcct");
            return (Criteria) this;
        }

        public Criteria andInAcctNotEqualTo(Short value) {
            addCriterion("IN_ACCT <>", value, "inAcct");
            return (Criteria) this;
        }

        public Criteria andInAcctGreaterThan(Short value) {
            addCriterion("IN_ACCT >", value, "inAcct");
            return (Criteria) this;
        }

        public Criteria andInAcctGreaterThanOrEqualTo(Short value) {
            addCriterion("IN_ACCT >=", value, "inAcct");
            return (Criteria) this;
        }

        public Criteria andInAcctLessThan(Short value) {
            addCriterion("IN_ACCT <", value, "inAcct");
            return (Criteria) this;
        }

        public Criteria andInAcctLessThanOrEqualTo(Short value) {
            addCriterion("IN_ACCT <=", value, "inAcct");
            return (Criteria) this;
        }

        public Criteria andInAcctIn(List<Short> values) {
            addCriterion("IN_ACCT in", values, "inAcct");
            return (Criteria) this;
        }

        public Criteria andInAcctNotIn(List<Short> values) {
            addCriterion("IN_ACCT not in", values, "inAcct");
            return (Criteria) this;
        }

        public Criteria andInAcctBetween(Short value1, Short value2) {
            addCriterion("IN_ACCT between", value1, value2, "inAcct");
            return (Criteria) this;
        }

        public Criteria andInAcctNotBetween(Short value1, Short value2) {
            addCriterion("IN_ACCT not between", value1, value2, "inAcct");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoIsNull() {
            addCriterion("THIRD_MERCHANT_NO is null");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoIsNotNull() {
            addCriterion("THIRD_MERCHANT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoEqualTo(String value) {
            addCriterion("THIRD_MERCHANT_NO =", value, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoNotEqualTo(String value) {
            addCriterion("THIRD_MERCHANT_NO <>", value, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoGreaterThan(String value) {
            addCriterion("THIRD_MERCHANT_NO >", value, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("THIRD_MERCHANT_NO >=", value, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoLessThan(String value) {
            addCriterion("THIRD_MERCHANT_NO <", value, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("THIRD_MERCHANT_NO <=", value, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoLike(String value) {
            addCriterion("THIRD_MERCHANT_NO like", value, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoNotLike(String value) {
            addCriterion("THIRD_MERCHANT_NO not like", value, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoIn(List<String> values) {
            addCriterion("THIRD_MERCHANT_NO in", values, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoNotIn(List<String> values) {
            addCriterion("THIRD_MERCHANT_NO not in", values, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoBetween(String value1, String value2) {
            addCriterion("THIRD_MERCHANT_NO between", value1, value2, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andThirdMerchantNoNotBetween(String value1, String value2) {
            addCriterion("THIRD_MERCHANT_NO not between", value1, value2, "thirdMerchantNo");
            return (Criteria) this;
        }

        public Criteria andNotifyCountIsNull() {
            addCriterion("NOTIFY_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andNotifyCountIsNotNull() {
            addCriterion("NOTIFY_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyCountEqualTo(Long value) {
            addCriterion("NOTIFY_COUNT =", value, "notifyCount");
            return (Criteria) this;
        }

        public Criteria andNotifyCountNotEqualTo(Long value) {
            addCriterion("NOTIFY_COUNT <>", value, "notifyCount");
            return (Criteria) this;
        }

        public Criteria andNotifyCountGreaterThan(Long value) {
            addCriterion("NOTIFY_COUNT >", value, "notifyCount");
            return (Criteria) this;
        }

        public Criteria andNotifyCountGreaterThanOrEqualTo(Long value) {
            addCriterion("NOTIFY_COUNT >=", value, "notifyCount");
            return (Criteria) this;
        }

        public Criteria andNotifyCountLessThan(Long value) {
            addCriterion("NOTIFY_COUNT <", value, "notifyCount");
            return (Criteria) this;
        }

        public Criteria andNotifyCountLessThanOrEqualTo(Long value) {
            addCriterion("NOTIFY_COUNT <=", value, "notifyCount");
            return (Criteria) this;
        }

        public Criteria andNotifyCountIn(List<Long> values) {
            addCriterion("NOTIFY_COUNT in", values, "notifyCount");
            return (Criteria) this;
        }

        public Criteria andNotifyCountNotIn(List<Long> values) {
            addCriterion("NOTIFY_COUNT not in", values, "notifyCount");
            return (Criteria) this;
        }

        public Criteria andNotifyCountBetween(Long value1, Long value2) {
            addCriterion("NOTIFY_COUNT between", value1, value2, "notifyCount");
            return (Criteria) this;
        }

        public Criteria andNotifyCountNotBetween(Long value1, Long value2) {
            addCriterion("NOTIFY_COUNT not between", value1, value2, "notifyCount");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("NOTIFY_URL is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("NOTIFY_URL is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("NOTIFY_URL =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("NOTIFY_URL <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("NOTIFY_URL >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("NOTIFY_URL >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("NOTIFY_URL <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("NOTIFY_URL <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("NOTIFY_URL like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("NOTIFY_URL not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("NOTIFY_URL in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("NOTIFY_URL not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("NOTIFY_URL between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("NOTIFY_URL not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDescIsNull() {
            addCriterion("ORDER_DESC is null");
            return (Criteria) this;
        }

        public Criteria andOrderDescIsNotNull() {
            addCriterion("ORDER_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDescEqualTo(String value) {
            addCriterion("ORDER_DESC =", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotEqualTo(String value) {
            addCriterion("ORDER_DESC <>", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescGreaterThan(String value) {
            addCriterion("ORDER_DESC >", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_DESC >=", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescLessThan(String value) {
            addCriterion("ORDER_DESC <", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescLessThanOrEqualTo(String value) {
            addCriterion("ORDER_DESC <=", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescLike(String value) {
            addCriterion("ORDER_DESC like", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotLike(String value) {
            addCriterion("ORDER_DESC not like", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescIn(List<String> values) {
            addCriterion("ORDER_DESC in", values, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotIn(List<String> values) {
            addCriterion("ORDER_DESC not in", values, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescBetween(String value1, String value2) {
            addCriterion("ORDER_DESC between", value1, value2, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotBetween(String value1, String value2) {
            addCriterion("ORDER_DESC not between", value1, value2, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDtIsNull() {
            addCriterion("ORDER_DT is null");
            return (Criteria) this;
        }

        public Criteria andOrderDtIsNotNull() {
            addCriterion("ORDER_DT is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDtEqualTo(String value) {
            addCriterion("ORDER_DT =", value, "orderDt");
            return (Criteria) this;
        }

        public Criteria andOrderDtNotEqualTo(String value) {
            addCriterion("ORDER_DT <>", value, "orderDt");
            return (Criteria) this;
        }

        public Criteria andOrderDtGreaterThan(String value) {
            addCriterion("ORDER_DT >", value, "orderDt");
            return (Criteria) this;
        }

        public Criteria andOrderDtGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_DT >=", value, "orderDt");
            return (Criteria) this;
        }

        public Criteria andOrderDtLessThan(String value) {
            addCriterion("ORDER_DT <", value, "orderDt");
            return (Criteria) this;
        }

        public Criteria andOrderDtLessThanOrEqualTo(String value) {
            addCriterion("ORDER_DT <=", value, "orderDt");
            return (Criteria) this;
        }

        public Criteria andOrderDtLike(String value) {
            addCriterion("ORDER_DT like", value, "orderDt");
            return (Criteria) this;
        }

        public Criteria andOrderDtNotLike(String value) {
            addCriterion("ORDER_DT not like", value, "orderDt");
            return (Criteria) this;
        }

        public Criteria andOrderDtIn(List<String> values) {
            addCriterion("ORDER_DT in", values, "orderDt");
            return (Criteria) this;
        }

        public Criteria andOrderDtNotIn(List<String> values) {
            addCriterion("ORDER_DT not in", values, "orderDt");
            return (Criteria) this;
        }

        public Criteria andOrderDtBetween(String value1, String value2) {
            addCriterion("ORDER_DT between", value1, value2, "orderDt");
            return (Criteria) this;
        }

        public Criteria andOrderDtNotBetween(String value1, String value2) {
            addCriterion("ORDER_DT not between", value1, value2, "orderDt");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoIsNull() {
            addCriterion("PAY_CHANEL_INTERACCTNO is null");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoIsNotNull() {
            addCriterion("PAY_CHANEL_INTERACCTNO is not null");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoEqualTo(String value) {
            addCriterion("PAY_CHANEL_INTERACCTNO =", value, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoNotEqualTo(String value) {
            addCriterion("PAY_CHANEL_INTERACCTNO <>", value, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoGreaterThan(String value) {
            addCriterion("PAY_CHANEL_INTERACCTNO >", value, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_CHANEL_INTERACCTNO >=", value, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoLessThan(String value) {
            addCriterion("PAY_CHANEL_INTERACCTNO <", value, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoLessThanOrEqualTo(String value) {
            addCriterion("PAY_CHANEL_INTERACCTNO <=", value, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoLike(String value) {
            addCriterion("PAY_CHANEL_INTERACCTNO like", value, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoNotLike(String value) {
            addCriterion("PAY_CHANEL_INTERACCTNO not like", value, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoIn(List<String> values) {
            addCriterion("PAY_CHANEL_INTERACCTNO in", values, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoNotIn(List<String> values) {
            addCriterion("PAY_CHANEL_INTERACCTNO not in", values, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoBetween(String value1, String value2) {
            addCriterion("PAY_CHANEL_INTERACCTNO between", value1, value2, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayChanelInteracctnoNotBetween(String value1, String value2) {
            addCriterion("PAY_CHANEL_INTERACCTNO not between", value1, value2, "payChanelInteracctno");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("PAY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("PAY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("PAY_STATUS =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("PAY_STATUS <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("PAY_STATUS >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_STATUS >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("PAY_STATUS <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("PAY_STATUS <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("PAY_STATUS like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("PAY_STATUS not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("PAY_STATUS in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("PAY_STATUS not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("PAY_STATUS between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("PAY_STATUS not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("PAY_TYPE =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("PAY_TYPE <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("PAY_TYPE >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("PAY_TYPE <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("PAY_TYPE like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("PAY_TYPE not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("PAY_TYPE in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("PAY_TYPE not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("PAY_TYPE between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("PAY_TYPE not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayChannelIsNull() {
            addCriterion("PAY_CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andPayChannelIsNotNull() {
            addCriterion("PAY_CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andPayChannelEqualTo(String value) {
            addCriterion("PAY_CHANNEL =", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotEqualTo(String value) {
            addCriterion("PAY_CHANNEL <>", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThan(String value) {
            addCriterion("PAY_CHANNEL >", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_CHANNEL >=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThan(String value) {
            addCriterion("PAY_CHANNEL <", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThanOrEqualTo(String value) {
            addCriterion("PAY_CHANNEL <=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLike(String value) {
            addCriterion("PAY_CHANNEL like", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotLike(String value) {
            addCriterion("PAY_CHANNEL not like", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelIn(List<String> values) {
            addCriterion("PAY_CHANNEL in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotIn(List<String> values) {
            addCriterion("PAY_CHANNEL not in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelBetween(String value1, String value2) {
            addCriterion("PAY_CHANNEL between", value1, value2, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotBetween(String value1, String value2) {
            addCriterion("PAY_CHANNEL not between", value1, value2, "payChannel");
            return (Criteria) this;
        }

        public Criteria andProvIsNull() {
            addCriterion("PROV is null");
            return (Criteria) this;
        }

        public Criteria andProvIsNotNull() {
            addCriterion("PROV is not null");
            return (Criteria) this;
        }

        public Criteria andProvEqualTo(String value) {
            addCriterion("PROV =", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotEqualTo(String value) {
            addCriterion("PROV <>", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvGreaterThan(String value) {
            addCriterion("PROV >", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvGreaterThanOrEqualTo(String value) {
            addCriterion("PROV >=", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvLessThan(String value) {
            addCriterion("PROV <", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvLessThanOrEqualTo(String value) {
            addCriterion("PROV <=", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvLike(String value) {
            addCriterion("PROV like", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotLike(String value) {
            addCriterion("PROV not like", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvIn(List<String> values) {
            addCriterion("PROV in", values, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotIn(List<String> values) {
            addCriterion("PROV not in", values, "prov");
            return (Criteria) this;
        }

        public Criteria andProvBetween(String value1, String value2) {
            addCriterion("PROV between", value1, value2, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotBetween(String value1, String value2) {
            addCriterion("PROV not between", value1, value2, "prov");
            return (Criteria) this;
        }

        public Criteria andReAcctIsNull() {
            addCriterion("RE_ACCT is null");
            return (Criteria) this;
        }

        public Criteria andReAcctIsNotNull() {
            addCriterion("RE_ACCT is not null");
            return (Criteria) this;
        }

        public Criteria andReAcctEqualTo(Short value) {
            addCriterion("RE_ACCT =", value, "reAcct");
            return (Criteria) this;
        }

        public Criteria andReAcctNotEqualTo(Short value) {
            addCriterion("RE_ACCT <>", value, "reAcct");
            return (Criteria) this;
        }

        public Criteria andReAcctGreaterThan(Short value) {
            addCriterion("RE_ACCT >", value, "reAcct");
            return (Criteria) this;
        }

        public Criteria andReAcctGreaterThanOrEqualTo(Short value) {
            addCriterion("RE_ACCT >=", value, "reAcct");
            return (Criteria) this;
        }

        public Criteria andReAcctLessThan(Short value) {
            addCriterion("RE_ACCT <", value, "reAcct");
            return (Criteria) this;
        }

        public Criteria andReAcctLessThanOrEqualTo(Short value) {
            addCriterion("RE_ACCT <=", value, "reAcct");
            return (Criteria) this;
        }

        public Criteria andReAcctIn(List<Short> values) {
            addCriterion("RE_ACCT in", values, "reAcct");
            return (Criteria) this;
        }

        public Criteria andReAcctNotIn(List<Short> values) {
            addCriterion("RE_ACCT not in", values, "reAcct");
            return (Criteria) this;
        }

        public Criteria andReAcctBetween(Short value1, Short value2) {
            addCriterion("RE_ACCT between", value1, value2, "reAcct");
            return (Criteria) this;
        }

        public Criteria andReAcctNotBetween(Short value1, Short value2) {
            addCriterion("RE_ACCT not between", value1, value2, "reAcct");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeIsNull() {
            addCriterion("SINPAY_CHANNEL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeIsNotNull() {
            addCriterion("SINPAY_CHANNEL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeEqualTo(String value) {
            addCriterion("SINPAY_CHANNEL_CODE =", value, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeNotEqualTo(String value) {
            addCriterion("SINPAY_CHANNEL_CODE <>", value, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeGreaterThan(String value) {
            addCriterion("SINPAY_CHANNEL_CODE >", value, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SINPAY_CHANNEL_CODE >=", value, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeLessThan(String value) {
            addCriterion("SINPAY_CHANNEL_CODE <", value, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeLessThanOrEqualTo(String value) {
            addCriterion("SINPAY_CHANNEL_CODE <=", value, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeLike(String value) {
            addCriterion("SINPAY_CHANNEL_CODE like", value, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeNotLike(String value) {
            addCriterion("SINPAY_CHANNEL_CODE not like", value, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeIn(List<String> values) {
            addCriterion("SINPAY_CHANNEL_CODE in", values, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeNotIn(List<String> values) {
            addCriterion("SINPAY_CHANNEL_CODE not in", values, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeBetween(String value1, String value2) {
            addCriterion("SINPAY_CHANNEL_CODE between", value1, value2, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSinpayChannelCodeNotBetween(String value1, String value2) {
            addCriterion("SINPAY_CHANNEL_CODE not between", value1, value2, "sinpayChannelCode");
            return (Criteria) this;
        }

        public Criteria andSubBankIsNull() {
            addCriterion("SUB_BANK is null");
            return (Criteria) this;
        }

        public Criteria andSubBankIsNotNull() {
            addCriterion("SUB_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andSubBankEqualTo(String value) {
            addCriterion("SUB_BANK =", value, "subBank");
            return (Criteria) this;
        }

        public Criteria andSubBankNotEqualTo(String value) {
            addCriterion("SUB_BANK <>", value, "subBank");
            return (Criteria) this;
        }

        public Criteria andSubBankGreaterThan(String value) {
            addCriterion("SUB_BANK >", value, "subBank");
            return (Criteria) this;
        }

        public Criteria andSubBankGreaterThanOrEqualTo(String value) {
            addCriterion("SUB_BANK >=", value, "subBank");
            return (Criteria) this;
        }

        public Criteria andSubBankLessThan(String value) {
            addCriterion("SUB_BANK <", value, "subBank");
            return (Criteria) this;
        }

        public Criteria andSubBankLessThanOrEqualTo(String value) {
            addCriterion("SUB_BANK <=", value, "subBank");
            return (Criteria) this;
        }

        public Criteria andSubBankLike(String value) {
            addCriterion("SUB_BANK like", value, "subBank");
            return (Criteria) this;
        }

        public Criteria andSubBankNotLike(String value) {
            addCriterion("SUB_BANK not like", value, "subBank");
            return (Criteria) this;
        }

        public Criteria andSubBankIn(List<String> values) {
            addCriterion("SUB_BANK in", values, "subBank");
            return (Criteria) this;
        }

        public Criteria andSubBankNotIn(List<String> values) {
            addCriterion("SUB_BANK not in", values, "subBank");
            return (Criteria) this;
        }

        public Criteria andSubBankBetween(String value1, String value2) {
            addCriterion("SUB_BANK between", value1, value2, "subBank");
            return (Criteria) this;
        }

        public Criteria andSubBankNotBetween(String value1, String value2) {
            addCriterion("SUB_BANK not between", value1, value2, "subBank");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoIsNull() {
            addCriterion("THIRD_ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoIsNotNull() {
            addCriterion("THIRD_ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoEqualTo(String value) {
            addCriterion("THIRD_ORDER_NO =", value, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoNotEqualTo(String value) {
            addCriterion("THIRD_ORDER_NO <>", value, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoGreaterThan(String value) {
            addCriterion("THIRD_ORDER_NO >", value, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("THIRD_ORDER_NO >=", value, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoLessThan(String value) {
            addCriterion("THIRD_ORDER_NO <", value, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoLessThanOrEqualTo(String value) {
            addCriterion("THIRD_ORDER_NO <=", value, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoLike(String value) {
            addCriterion("THIRD_ORDER_NO like", value, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoNotLike(String value) {
            addCriterion("THIRD_ORDER_NO not like", value, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoIn(List<String> values) {
            addCriterion("THIRD_ORDER_NO in", values, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoNotIn(List<String> values) {
            addCriterion("THIRD_ORDER_NO not in", values, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoBetween(String value1, String value2) {
            addCriterion("THIRD_ORDER_NO between", value1, value2, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andThirdOrderNoNotBetween(String value1, String value2) {
            addCriterion("THIRD_ORDER_NO not between", value1, value2, "thirdOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransAmtIsNull() {
            addCriterion("TRANS_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTransAmtIsNotNull() {
            addCriterion("TRANS_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTransAmtEqualTo(BigDecimal value) {
            addCriterion("TRANS_AMT =", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtNotEqualTo(BigDecimal value) {
            addCriterion("TRANS_AMT <>", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtGreaterThan(BigDecimal value) {
            addCriterion("TRANS_AMT >", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRANS_AMT >=", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtLessThan(BigDecimal value) {
            addCriterion("TRANS_AMT <", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRANS_AMT <=", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtIn(List<BigDecimal> values) {
            addCriterion("TRANS_AMT in", values, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtNotIn(List<BigDecimal> values) {
            addCriterion("TRANS_AMT not in", values, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRANS_AMT between", value1, value2, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRANS_AMT not between", value1, value2, "transAmt");
            return (Criteria) this;
        }

        public Criteria andRespCodeIsNull() {
            addCriterion("RESP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRespCodeIsNotNull() {
            addCriterion("RESP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRespCodeEqualTo(String value) {
            addCriterion("RESP_CODE =", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeNotEqualTo(String value) {
            addCriterion("RESP_CODE <>", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeGreaterThan(String value) {
            addCriterion("RESP_CODE >", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RESP_CODE >=", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeLessThan(String value) {
            addCriterion("RESP_CODE <", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeLessThanOrEqualTo(String value) {
            addCriterion("RESP_CODE <=", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeLike(String value) {
            addCriterion("RESP_CODE like", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeNotLike(String value) {
            addCriterion("RESP_CODE not like", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeIn(List<String> values) {
            addCriterion("RESP_CODE in", values, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeNotIn(List<String> values) {
            addCriterion("RESP_CODE not in", values, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeBetween(String value1, String value2) {
            addCriterion("RESP_CODE between", value1, value2, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeNotBetween(String value1, String value2) {
            addCriterion("RESP_CODE not between", value1, value2, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespMsgIsNull() {
            addCriterion("RESP_MSG is null");
            return (Criteria) this;
        }

        public Criteria andRespMsgIsNotNull() {
            addCriterion("RESP_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andRespMsgEqualTo(String value) {
            addCriterion("RESP_MSG =", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgNotEqualTo(String value) {
            addCriterion("RESP_MSG <>", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgGreaterThan(String value) {
            addCriterion("RESP_MSG >", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgGreaterThanOrEqualTo(String value) {
            addCriterion("RESP_MSG >=", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgLessThan(String value) {
            addCriterion("RESP_MSG <", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgLessThanOrEqualTo(String value) {
            addCriterion("RESP_MSG <=", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgLike(String value) {
            addCriterion("RESP_MSG like", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgNotLike(String value) {
            addCriterion("RESP_MSG not like", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgIn(List<String> values) {
            addCriterion("RESP_MSG in", values, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgNotIn(List<String> values) {
            addCriterion("RESP_MSG not in", values, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgBetween(String value1, String value2) {
            addCriterion("RESP_MSG between", value1, value2, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgNotBetween(String value1, String value2) {
            addCriterion("RESP_MSG not between", value1, value2, "respMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeIsNull() {
            addCriterion("THIRD_RESP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeIsNotNull() {
            addCriterion("THIRD_RESP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeEqualTo(String value) {
            addCriterion("THIRD_RESP_CODE =", value, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeNotEqualTo(String value) {
            addCriterion("THIRD_RESP_CODE <>", value, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeGreaterThan(String value) {
            addCriterion("THIRD_RESP_CODE >", value, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeGreaterThanOrEqualTo(String value) {
            addCriterion("THIRD_RESP_CODE >=", value, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeLessThan(String value) {
            addCriterion("THIRD_RESP_CODE <", value, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeLessThanOrEqualTo(String value) {
            addCriterion("THIRD_RESP_CODE <=", value, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeLike(String value) {
            addCriterion("THIRD_RESP_CODE like", value, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeNotLike(String value) {
            addCriterion("THIRD_RESP_CODE not like", value, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeIn(List<String> values) {
            addCriterion("THIRD_RESP_CODE in", values, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeNotIn(List<String> values) {
            addCriterion("THIRD_RESP_CODE not in", values, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeBetween(String value1, String value2) {
            addCriterion("THIRD_RESP_CODE between", value1, value2, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespCodeNotBetween(String value1, String value2) {
            addCriterion("THIRD_RESP_CODE not between", value1, value2, "thirdRespCode");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgIsNull() {
            addCriterion("THIRD_RESP_MSG is null");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgIsNotNull() {
            addCriterion("THIRD_RESP_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgEqualTo(String value) {
            addCriterion("THIRD_RESP_MSG =", value, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgNotEqualTo(String value) {
            addCriterion("THIRD_RESP_MSG <>", value, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgGreaterThan(String value) {
            addCriterion("THIRD_RESP_MSG >", value, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgGreaterThanOrEqualTo(String value) {
            addCriterion("THIRD_RESP_MSG >=", value, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgLessThan(String value) {
            addCriterion("THIRD_RESP_MSG <", value, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgLessThanOrEqualTo(String value) {
            addCriterion("THIRD_RESP_MSG <=", value, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgLike(String value) {
            addCriterion("THIRD_RESP_MSG like", value, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgNotLike(String value) {
            addCriterion("THIRD_RESP_MSG not like", value, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgIn(List<String> values) {
            addCriterion("THIRD_RESP_MSG in", values, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgNotIn(List<String> values) {
            addCriterion("THIRD_RESP_MSG not in", values, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgBetween(String value1, String value2) {
            addCriterion("THIRD_RESP_MSG between", value1, value2, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andThirdRespMsgNotBetween(String value1, String value2) {
            addCriterion("THIRD_RESP_MSG not between", value1, value2, "thirdRespMsg");
            return (Criteria) this;
        }

        public Criteria andOrderipIsNull() {
            addCriterion("ORDERIP is null");
            return (Criteria) this;
        }

        public Criteria andOrderipIsNotNull() {
            addCriterion("ORDERIP is not null");
            return (Criteria) this;
        }

        public Criteria andOrderipEqualTo(String value) {
            addCriterion("ORDERIP =", value, "orderip");
            return (Criteria) this;
        }

        public Criteria andOrderipNotEqualTo(String value) {
            addCriterion("ORDERIP <>", value, "orderip");
            return (Criteria) this;
        }

        public Criteria andOrderipGreaterThan(String value) {
            addCriterion("ORDERIP >", value, "orderip");
            return (Criteria) this;
        }

        public Criteria andOrderipGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERIP >=", value, "orderip");
            return (Criteria) this;
        }

        public Criteria andOrderipLessThan(String value) {
            addCriterion("ORDERIP <", value, "orderip");
            return (Criteria) this;
        }

        public Criteria andOrderipLessThanOrEqualTo(String value) {
            addCriterion("ORDERIP <=", value, "orderip");
            return (Criteria) this;
        }

        public Criteria andOrderipLike(String value) {
            addCriterion("ORDERIP like", value, "orderip");
            return (Criteria) this;
        }

        public Criteria andOrderipNotLike(String value) {
            addCriterion("ORDERIP not like", value, "orderip");
            return (Criteria) this;
        }

        public Criteria andOrderipIn(List<String> values) {
            addCriterion("ORDERIP in", values, "orderip");
            return (Criteria) this;
        }

        public Criteria andOrderipNotIn(List<String> values) {
            addCriterion("ORDERIP not in", values, "orderip");
            return (Criteria) this;
        }

        public Criteria andOrderipBetween(String value1, String value2) {
            addCriterion("ORDERIP between", value1, value2, "orderip");
            return (Criteria) this;
        }

        public Criteria andOrderipNotBetween(String value1, String value2) {
            addCriterion("ORDERIP not between", value1, value2, "orderip");
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

        public Criteria andField1IsNull() {
            addCriterion("FIELD1 is null");
            return (Criteria) this;
        }

        public Criteria andField1IsNotNull() {
            addCriterion("FIELD1 is not null");
            return (Criteria) this;
        }

        public Criteria andField1EqualTo(String value) {
            addCriterion("FIELD1 =", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotEqualTo(String value) {
            addCriterion("FIELD1 <>", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1GreaterThan(String value) {
            addCriterion("FIELD1 >", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1GreaterThanOrEqualTo(String value) {
            addCriterion("FIELD1 >=", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1LessThan(String value) {
            addCriterion("FIELD1 <", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1LessThanOrEqualTo(String value) {
            addCriterion("FIELD1 <=", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1Like(String value) {
            addCriterion("FIELD1 like", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotLike(String value) {
            addCriterion("FIELD1 not like", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1In(List<String> values) {
            addCriterion("FIELD1 in", values, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotIn(List<String> values) {
            addCriterion("FIELD1 not in", values, "field1");
            return (Criteria) this;
        }

        public Criteria andField1Between(String value1, String value2) {
            addCriterion("FIELD1 between", value1, value2, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotBetween(String value1, String value2) {
            addCriterion("FIELD1 not between", value1, value2, "field1");
            return (Criteria) this;
        }

        public Criteria andField2IsNull() {
            addCriterion("FIELD2 is null");
            return (Criteria) this;
        }

        public Criteria andField2IsNotNull() {
            addCriterion("FIELD2 is not null");
            return (Criteria) this;
        }

        public Criteria andField2EqualTo(String value) {
            addCriterion("FIELD2 =", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotEqualTo(String value) {
            addCriterion("FIELD2 <>", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2GreaterThan(String value) {
            addCriterion("FIELD2 >", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2GreaterThanOrEqualTo(String value) {
            addCriterion("FIELD2 >=", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2LessThan(String value) {
            addCriterion("FIELD2 <", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2LessThanOrEqualTo(String value) {
            addCriterion("FIELD2 <=", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2Like(String value) {
            addCriterion("FIELD2 like", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotLike(String value) {
            addCriterion("FIELD2 not like", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2In(List<String> values) {
            addCriterion("FIELD2 in", values, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotIn(List<String> values) {
            addCriterion("FIELD2 not in", values, "field2");
            return (Criteria) this;
        }

        public Criteria andField2Between(String value1, String value2) {
            addCriterion("FIELD2 between", value1, value2, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotBetween(String value1, String value2) {
            addCriterion("FIELD2 not between", value1, value2, "field2");
            return (Criteria) this;
        }

        public Criteria andField3IsNull() {
            addCriterion("FIELD3 is null");
            return (Criteria) this;
        }

        public Criteria andField3IsNotNull() {
            addCriterion("FIELD3 is not null");
            return (Criteria) this;
        }

        public Criteria andField3EqualTo(String value) {
            addCriterion("FIELD3 =", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotEqualTo(String value) {
            addCriterion("FIELD3 <>", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3GreaterThan(String value) {
            addCriterion("FIELD3 >", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3GreaterThanOrEqualTo(String value) {
            addCriterion("FIELD3 >=", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3LessThan(String value) {
            addCriterion("FIELD3 <", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3LessThanOrEqualTo(String value) {
            addCriterion("FIELD3 <=", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3Like(String value) {
            addCriterion("FIELD3 like", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotLike(String value) {
            addCriterion("FIELD3 not like", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3In(List<String> values) {
            addCriterion("FIELD3 in", values, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotIn(List<String> values) {
            addCriterion("FIELD3 not in", values, "field3");
            return (Criteria) this;
        }

        public Criteria andField3Between(String value1, String value2) {
            addCriterion("FIELD3 between", value1, value2, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotBetween(String value1, String value2) {
            addCriterion("FIELD3 not between", value1, value2, "field3");
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