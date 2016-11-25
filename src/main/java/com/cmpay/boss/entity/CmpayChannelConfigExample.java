package com.cmpay.boss.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmpayChannelConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmpayChannelConfigExample() {
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

        public Criteria andPaychannelNoIsNull() {
            addCriterion("PAYCHANNEL_NO is null");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoIsNotNull() {
            addCriterion("PAYCHANNEL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoEqualTo(String value) {
            addCriterion("PAYCHANNEL_NO =", value, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoNotEqualTo(String value) {
            addCriterion("PAYCHANNEL_NO <>", value, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoGreaterThan(String value) {
            addCriterion("PAYCHANNEL_NO >", value, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYCHANNEL_NO >=", value, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoLessThan(String value) {
            addCriterion("PAYCHANNEL_NO <", value, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoLessThanOrEqualTo(String value) {
            addCriterion("PAYCHANNEL_NO <=", value, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoLike(String value) {
            addCriterion("PAYCHANNEL_NO like", value, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoNotLike(String value) {
            addCriterion("PAYCHANNEL_NO not like", value, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoIn(List<String> values) {
            addCriterion("PAYCHANNEL_NO in", values, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoNotIn(List<String> values) {
            addCriterion("PAYCHANNEL_NO not in", values, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoBetween(String value1, String value2) {
            addCriterion("PAYCHANNEL_NO between", value1, value2, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNoNotBetween(String value1, String value2) {
            addCriterion("PAYCHANNEL_NO not between", value1, value2, "paychannelNo");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameIsNull() {
            addCriterion("PAYCHANNEL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameIsNotNull() {
            addCriterion("PAYCHANNEL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameEqualTo(String value) {
            addCriterion("PAYCHANNEL_NAME =", value, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameNotEqualTo(String value) {
            addCriterion("PAYCHANNEL_NAME <>", value, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameGreaterThan(String value) {
            addCriterion("PAYCHANNEL_NAME >", value, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("PAYCHANNEL_NAME >=", value, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameLessThan(String value) {
            addCriterion("PAYCHANNEL_NAME <", value, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameLessThanOrEqualTo(String value) {
            addCriterion("PAYCHANNEL_NAME <=", value, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameLike(String value) {
            addCriterion("PAYCHANNEL_NAME like", value, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameNotLike(String value) {
            addCriterion("PAYCHANNEL_NAME not like", value, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameIn(List<String> values) {
            addCriterion("PAYCHANNEL_NAME in", values, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameNotIn(List<String> values) {
            addCriterion("PAYCHANNEL_NAME not in", values, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameBetween(String value1, String value2) {
            addCriterion("PAYCHANNEL_NAME between", value1, value2, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andPaychannelNameNotBetween(String value1, String value2) {
            addCriterion("PAYCHANNEL_NAME not between", value1, value2, "paychannelName");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("APPID is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("APPID is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("APPID =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("APPID <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("APPID >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("APPID >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("APPID <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("APPID <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("APPID like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("APPID not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("APPID in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("APPID not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("APPID between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("APPID not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppsectetIsNull() {
            addCriterion("APPSECTET is null");
            return (Criteria) this;
        }

        public Criteria andAppsectetIsNotNull() {
            addCriterion("APPSECTET is not null");
            return (Criteria) this;
        }

        public Criteria andAppsectetEqualTo(String value) {
            addCriterion("APPSECTET =", value, "appsectet");
            return (Criteria) this;
        }

        public Criteria andAppsectetNotEqualTo(String value) {
            addCriterion("APPSECTET <>", value, "appsectet");
            return (Criteria) this;
        }

        public Criteria andAppsectetGreaterThan(String value) {
            addCriterion("APPSECTET >", value, "appsectet");
            return (Criteria) this;
        }

        public Criteria andAppsectetGreaterThanOrEqualTo(String value) {
            addCriterion("APPSECTET >=", value, "appsectet");
            return (Criteria) this;
        }

        public Criteria andAppsectetLessThan(String value) {
            addCriterion("APPSECTET <", value, "appsectet");
            return (Criteria) this;
        }

        public Criteria andAppsectetLessThanOrEqualTo(String value) {
            addCriterion("APPSECTET <=", value, "appsectet");
            return (Criteria) this;
        }

        public Criteria andAppsectetLike(String value) {
            addCriterion("APPSECTET like", value, "appsectet");
            return (Criteria) this;
        }

        public Criteria andAppsectetNotLike(String value) {
            addCriterion("APPSECTET not like", value, "appsectet");
            return (Criteria) this;
        }

        public Criteria andAppsectetIn(List<String> values) {
            addCriterion("APPSECTET in", values, "appsectet");
            return (Criteria) this;
        }

        public Criteria andAppsectetNotIn(List<String> values) {
            addCriterion("APPSECTET not in", values, "appsectet");
            return (Criteria) this;
        }

        public Criteria andAppsectetBetween(String value1, String value2) {
            addCriterion("APPSECTET between", value1, value2, "appsectet");
            return (Criteria) this;
        }

        public Criteria andAppsectetNotBetween(String value1, String value2) {
            addCriterion("APPSECTET not between", value1, value2, "appsectet");
            return (Criteria) this;
        }

        public Criteria andApptypeIsNull() {
            addCriterion("APPTYPE is null");
            return (Criteria) this;
        }

        public Criteria andApptypeIsNotNull() {
            addCriterion("APPTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApptypeEqualTo(String value) {
            addCriterion("APPTYPE =", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotEqualTo(String value) {
            addCriterion("APPTYPE <>", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThan(String value) {
            addCriterion("APPTYPE >", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPTYPE >=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThan(String value) {
            addCriterion("APPTYPE <", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThanOrEqualTo(String value) {
            addCriterion("APPTYPE <=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLike(String value) {
            addCriterion("APPTYPE like", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotLike(String value) {
            addCriterion("APPTYPE not like", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeIn(List<String> values) {
            addCriterion("APPTYPE in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotIn(List<String> values) {
            addCriterion("APPTYPE not in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeBetween(String value1, String value2) {
            addCriterion("APPTYPE between", value1, value2, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotBetween(String value1, String value2) {
            addCriterion("APPTYPE not between", value1, value2, "apptype");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyIsNull() {
            addCriterion("PARTNERKEY is null");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyIsNotNull() {
            addCriterion("PARTNERKEY is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyEqualTo(String value) {
            addCriterion("PARTNERKEY =", value, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyNotEqualTo(String value) {
            addCriterion("PARTNERKEY <>", value, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyGreaterThan(String value) {
            addCriterion("PARTNERKEY >", value, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyGreaterThanOrEqualTo(String value) {
            addCriterion("PARTNERKEY >=", value, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyLessThan(String value) {
            addCriterion("PARTNERKEY <", value, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyLessThanOrEqualTo(String value) {
            addCriterion("PARTNERKEY <=", value, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyLike(String value) {
            addCriterion("PARTNERKEY like", value, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyNotLike(String value) {
            addCriterion("PARTNERKEY not like", value, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyIn(List<String> values) {
            addCriterion("PARTNERKEY in", values, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyNotIn(List<String> values) {
            addCriterion("PARTNERKEY not in", values, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyBetween(String value1, String value2) {
            addCriterion("PARTNERKEY between", value1, value2, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andPartnerkeyNotBetween(String value1, String value2) {
            addCriterion("PARTNERKEY not between", value1, value2, "partnerkey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyIsNull() {
            addCriterion("RSAPRIKEY is null");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyIsNotNull() {
            addCriterion("RSAPRIKEY is not null");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyEqualTo(String value) {
            addCriterion("RSAPRIKEY =", value, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyNotEqualTo(String value) {
            addCriterion("RSAPRIKEY <>", value, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyGreaterThan(String value) {
            addCriterion("RSAPRIKEY >", value, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyGreaterThanOrEqualTo(String value) {
            addCriterion("RSAPRIKEY >=", value, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyLessThan(String value) {
            addCriterion("RSAPRIKEY <", value, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyLessThanOrEqualTo(String value) {
            addCriterion("RSAPRIKEY <=", value, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyLike(String value) {
            addCriterion("RSAPRIKEY like", value, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyNotLike(String value) {
            addCriterion("RSAPRIKEY not like", value, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyIn(List<String> values) {
            addCriterion("RSAPRIKEY in", values, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyNotIn(List<String> values) {
            addCriterion("RSAPRIKEY not in", values, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyBetween(String value1, String value2) {
            addCriterion("RSAPRIKEY between", value1, value2, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsaprikeyNotBetween(String value1, String value2) {
            addCriterion("RSAPRIKEY not between", value1, value2, "rsaprikey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyIsNull() {
            addCriterion("RSAPUBKEY is null");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyIsNotNull() {
            addCriterion("RSAPUBKEY is not null");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyEqualTo(String value) {
            addCriterion("RSAPUBKEY =", value, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyNotEqualTo(String value) {
            addCriterion("RSAPUBKEY <>", value, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyGreaterThan(String value) {
            addCriterion("RSAPUBKEY >", value, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyGreaterThanOrEqualTo(String value) {
            addCriterion("RSAPUBKEY >=", value, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyLessThan(String value) {
            addCriterion("RSAPUBKEY <", value, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyLessThanOrEqualTo(String value) {
            addCriterion("RSAPUBKEY <=", value, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyLike(String value) {
            addCriterion("RSAPUBKEY like", value, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyNotLike(String value) {
            addCriterion("RSAPUBKEY not like", value, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyIn(List<String> values) {
            addCriterion("RSAPUBKEY in", values, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyNotIn(List<String> values) {
            addCriterion("RSAPUBKEY not in", values, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyBetween(String value1, String value2) {
            addCriterion("RSAPUBKEY between", value1, value2, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andRsapubkeyNotBetween(String value1, String value2) {
            addCriterion("RSAPUBKEY not between", value1, value2, "rsapubkey");
            return (Criteria) this;
        }

        public Criteria andDeskeyIsNull() {
            addCriterion("DESKEY is null");
            return (Criteria) this;
        }

        public Criteria andDeskeyIsNotNull() {
            addCriterion("DESKEY is not null");
            return (Criteria) this;
        }

        public Criteria andDeskeyEqualTo(String value) {
            addCriterion("DESKEY =", value, "deskey");
            return (Criteria) this;
        }

        public Criteria andDeskeyNotEqualTo(String value) {
            addCriterion("DESKEY <>", value, "deskey");
            return (Criteria) this;
        }

        public Criteria andDeskeyGreaterThan(String value) {
            addCriterion("DESKEY >", value, "deskey");
            return (Criteria) this;
        }

        public Criteria andDeskeyGreaterThanOrEqualTo(String value) {
            addCriterion("DESKEY >=", value, "deskey");
            return (Criteria) this;
        }

        public Criteria andDeskeyLessThan(String value) {
            addCriterion("DESKEY <", value, "deskey");
            return (Criteria) this;
        }

        public Criteria andDeskeyLessThanOrEqualTo(String value) {
            addCriterion("DESKEY <=", value, "deskey");
            return (Criteria) this;
        }

        public Criteria andDeskeyLike(String value) {
            addCriterion("DESKEY like", value, "deskey");
            return (Criteria) this;
        }

        public Criteria andDeskeyNotLike(String value) {
            addCriterion("DESKEY not like", value, "deskey");
            return (Criteria) this;
        }

        public Criteria andDeskeyIn(List<String> values) {
            addCriterion("DESKEY in", values, "deskey");
            return (Criteria) this;
        }

        public Criteria andDeskeyNotIn(List<String> values) {
            addCriterion("DESKEY not in", values, "deskey");
            return (Criteria) this;
        }

        public Criteria andDeskeyBetween(String value1, String value2) {
            addCriterion("DESKEY between", value1, value2, "deskey");
            return (Criteria) this;
        }

        public Criteria andDeskeyNotBetween(String value1, String value2) {
            addCriterion("DESKEY not between", value1, value2, "deskey");
            return (Criteria) this;
        }

        public Criteria andThirdMeridIsNull() {
            addCriterion("THIRD_MERID is null");
            return (Criteria) this;
        }

        public Criteria andThirdMeridIsNotNull() {
            addCriterion("THIRD_MERID is not null");
            return (Criteria) this;
        }

        public Criteria andThirdMeridEqualTo(String value) {
            addCriterion("THIRD_MERID =", value, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andThirdMeridNotEqualTo(String value) {
            addCriterion("THIRD_MERID <>", value, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andThirdMeridGreaterThan(String value) {
            addCriterion("THIRD_MERID >", value, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andThirdMeridGreaterThanOrEqualTo(String value) {
            addCriterion("THIRD_MERID >=", value, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andThirdMeridLessThan(String value) {
            addCriterion("THIRD_MERID <", value, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andThirdMeridLessThanOrEqualTo(String value) {
            addCriterion("THIRD_MERID <=", value, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andThirdMeridLike(String value) {
            addCriterion("THIRD_MERID like", value, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andThirdMeridNotLike(String value) {
            addCriterion("THIRD_MERID not like", value, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andThirdMeridIn(List<String> values) {
            addCriterion("THIRD_MERID in", values, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andThirdMeridNotIn(List<String> values) {
            addCriterion("THIRD_MERID not in", values, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andThirdMeridBetween(String value1, String value2) {
            addCriterion("THIRD_MERID between", value1, value2, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andThirdMeridNotBetween(String value1, String value2) {
            addCriterion("THIRD_MERID not between", value1, value2, "thirdMerid");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNull() {
            addCriterion("RETURN_URL is null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNotNull() {
            addCriterion("RETURN_URL is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlEqualTo(String value) {
            addCriterion("RETURN_URL =", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotEqualTo(String value) {
            addCriterion("RETURN_URL <>", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThan(String value) {
            addCriterion("RETURN_URL >", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_URL >=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThan(String value) {
            addCriterion("RETURN_URL <", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThanOrEqualTo(String value) {
            addCriterion("RETURN_URL <=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLike(String value) {
            addCriterion("RETURN_URL like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotLike(String value) {
            addCriterion("RETURN_URL not like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIn(List<String> values) {
            addCriterion("RETURN_URL in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotIn(List<String> values) {
            addCriterion("RETURN_URL not in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlBetween(String value1, String value2) {
            addCriterion("RETURN_URL between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotBetween(String value1, String value2) {
            addCriterion("RETURN_URL not between", value1, value2, "returnUrl");
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