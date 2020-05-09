package com.wegame.model;

import java.util.ArrayList;
import java.util.List;

public class GamblingDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GamblingDetailsExample() {
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

        public Criteria andCreatedateIsNull() {
            addCriterion("CREATEDATE is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("CREATEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(String value) {
            addCriterion("CREATEDATE =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(String value) {
            addCriterion("CREATEDATE <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(String value) {
            addCriterion("CREATEDATE >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEDATE >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(String value) {
            addCriterion("CREATEDATE <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(String value) {
            addCriterion("CREATEDATE <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLike(String value) {
            addCriterion("CREATEDATE like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotLike(String value) {
            addCriterion("CREATEDATE not like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<String> values) {
            addCriterion("CREATEDATE in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<String> values) {
            addCriterion("CREATEDATE not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(String value1, String value2) {
            addCriterion("CREATEDATE between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(String value1, String value2) {
            addCriterion("CREATEDATE not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeIsNull() {
            addCriterion("LASTMODIFIEDTIME is null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeIsNotNull() {
            addCriterion("LASTMODIFIEDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeEqualTo(String value) {
            addCriterion("LASTMODIFIEDTIME =", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeNotEqualTo(String value) {
            addCriterion("LASTMODIFIEDTIME <>", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeGreaterThan(String value) {
            addCriterion("LASTMODIFIEDTIME >", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeGreaterThanOrEqualTo(String value) {
            addCriterion("LASTMODIFIEDTIME >=", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeLessThan(String value) {
            addCriterion("LASTMODIFIEDTIME <", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeLessThanOrEqualTo(String value) {
            addCriterion("LASTMODIFIEDTIME <=", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeLike(String value) {
            addCriterion("LASTMODIFIEDTIME like", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeNotLike(String value) {
            addCriterion("LASTMODIFIEDTIME not like", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeIn(List<String> values) {
            addCriterion("LASTMODIFIEDTIME in", values, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeNotIn(List<String> values) {
            addCriterion("LASTMODIFIEDTIME not in", values, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeBetween(String value1, String value2) {
            addCriterion("LASTMODIFIEDTIME between", value1, value2, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeNotBetween(String value1, String value2) {
            addCriterion("LASTMODIFIEDTIME not between", value1, value2, "lastmodifiedtime");
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

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andCompareuserIsNull() {
            addCriterion("COMPAREUSER is null");
            return (Criteria) this;
        }

        public Criteria andCompareuserIsNotNull() {
            addCriterion("COMPAREUSER is not null");
            return (Criteria) this;
        }

        public Criteria andCompareuserEqualTo(String value) {
            addCriterion("COMPAREUSER =", value, "compareuser");
            return (Criteria) this;
        }

        public Criteria andCompareuserNotEqualTo(String value) {
            addCriterion("COMPAREUSER <>", value, "compareuser");
            return (Criteria) this;
        }

        public Criteria andCompareuserGreaterThan(String value) {
            addCriterion("COMPAREUSER >", value, "compareuser");
            return (Criteria) this;
        }

        public Criteria andCompareuserGreaterThanOrEqualTo(String value) {
            addCriterion("COMPAREUSER >=", value, "compareuser");
            return (Criteria) this;
        }

        public Criteria andCompareuserLessThan(String value) {
            addCriterion("COMPAREUSER <", value, "compareuser");
            return (Criteria) this;
        }

        public Criteria andCompareuserLessThanOrEqualTo(String value) {
            addCriterion("COMPAREUSER <=", value, "compareuser");
            return (Criteria) this;
        }

        public Criteria andCompareuserLike(String value) {
            addCriterion("COMPAREUSER like", value, "compareuser");
            return (Criteria) this;
        }

        public Criteria andCompareuserNotLike(String value) {
            addCriterion("COMPAREUSER not like", value, "compareuser");
            return (Criteria) this;
        }

        public Criteria andCompareuserIn(List<String> values) {
            addCriterion("COMPAREUSER in", values, "compareuser");
            return (Criteria) this;
        }

        public Criteria andCompareuserNotIn(List<String> values) {
            addCriterion("COMPAREUSER not in", values, "compareuser");
            return (Criteria) this;
        }

        public Criteria andCompareuserBetween(String value1, String value2) {
            addCriterion("COMPAREUSER between", value1, value2, "compareuser");
            return (Criteria) this;
        }

        public Criteria andCompareuserNotBetween(String value1, String value2) {
            addCriterion("COMPAREUSER not between", value1, value2, "compareuser");
            return (Criteria) this;
        }

        public Criteria andDotypeIsNull() {
            addCriterion("DOTYPE is null");
            return (Criteria) this;
        }

        public Criteria andDotypeIsNotNull() {
            addCriterion("DOTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDotypeEqualTo(Integer value) {
            addCriterion("DOTYPE =", value, "dotype");
            return (Criteria) this;
        }

        public Criteria andDotypeNotEqualTo(Integer value) {
            addCriterion("DOTYPE <>", value, "dotype");
            return (Criteria) this;
        }

        public Criteria andDotypeGreaterThan(Integer value) {
            addCriterion("DOTYPE >", value, "dotype");
            return (Criteria) this;
        }

        public Criteria andDotypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DOTYPE >=", value, "dotype");
            return (Criteria) this;
        }

        public Criteria andDotypeLessThan(Integer value) {
            addCriterion("DOTYPE <", value, "dotype");
            return (Criteria) this;
        }

        public Criteria andDotypeLessThanOrEqualTo(Integer value) {
            addCriterion("DOTYPE <=", value, "dotype");
            return (Criteria) this;
        }

        public Criteria andDotypeIn(List<Integer> values) {
            addCriterion("DOTYPE in", values, "dotype");
            return (Criteria) this;
        }

        public Criteria andDotypeNotIn(List<Integer> values) {
            addCriterion("DOTYPE not in", values, "dotype");
            return (Criteria) this;
        }

        public Criteria andDotypeBetween(Integer value1, Integer value2) {
            addCriterion("DOTYPE between", value1, value2, "dotype");
            return (Criteria) this;
        }

        public Criteria andDotypeNotBetween(Integer value1, Integer value2) {
            addCriterion("DOTYPE not between", value1, value2, "dotype");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageIsNull() {
            addCriterion("OPERATINGLEVERAGE is null");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageIsNotNull() {
            addCriterion("OPERATINGLEVERAGE is not null");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageEqualTo(Integer value) {
            addCriterion("OPERATINGLEVERAGE =", value, "operatingleverage");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageNotEqualTo(Integer value) {
            addCriterion("OPERATINGLEVERAGE <>", value, "operatingleverage");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageGreaterThan(Integer value) {
            addCriterion("OPERATINGLEVERAGE >", value, "operatingleverage");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPERATINGLEVERAGE >=", value, "operatingleverage");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageLessThan(Integer value) {
            addCriterion("OPERATINGLEVERAGE <", value, "operatingleverage");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageLessThanOrEqualTo(Integer value) {
            addCriterion("OPERATINGLEVERAGE <=", value, "operatingleverage");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageIn(List<Integer> values) {
            addCriterion("OPERATINGLEVERAGE in", values, "operatingleverage");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageNotIn(List<Integer> values) {
            addCriterion("OPERATINGLEVERAGE not in", values, "operatingleverage");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageBetween(Integer value1, Integer value2) {
            addCriterion("OPERATINGLEVERAGE between", value1, value2, "operatingleverage");
            return (Criteria) this;
        }

        public Criteria andOperatingleverageNotBetween(Integer value1, Integer value2) {
            addCriterion("OPERATINGLEVERAGE not between", value1, value2, "operatingleverage");
            return (Criteria) this;
        }

        public Criteria andRoundIsNull() {
            addCriterion("ROUND is null");
            return (Criteria) this;
        }

        public Criteria andRoundIsNotNull() {
            addCriterion("ROUND is not null");
            return (Criteria) this;
        }

        public Criteria andRoundEqualTo(Integer value) {
            addCriterion("ROUND =", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotEqualTo(Integer value) {
            addCriterion("ROUND <>", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThan(Integer value) {
            addCriterion("ROUND >", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROUND >=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThan(Integer value) {
            addCriterion("ROUND <", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThanOrEqualTo(Integer value) {
            addCriterion("ROUND <=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundIn(List<Integer> values) {
            addCriterion("ROUND in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotIn(List<Integer> values) {
            addCriterion("ROUND not in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundBetween(Integer value1, Integer value2) {
            addCriterion("ROUND between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotBetween(Integer value1, Integer value2) {
            addCriterion("ROUND not between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andSeatserialIsNull() {
            addCriterion("SEATSERIAL is null");
            return (Criteria) this;
        }

        public Criteria andSeatserialIsNotNull() {
            addCriterion("SEATSERIAL is not null");
            return (Criteria) this;
        }

        public Criteria andSeatserialEqualTo(Integer value) {
            addCriterion("SEATSERIAL =", value, "seatserial");
            return (Criteria) this;
        }

        public Criteria andSeatserialNotEqualTo(Integer value) {
            addCriterion("SEATSERIAL <>", value, "seatserial");
            return (Criteria) this;
        }

        public Criteria andSeatserialGreaterThan(Integer value) {
            addCriterion("SEATSERIAL >", value, "seatserial");
            return (Criteria) this;
        }

        public Criteria andSeatserialGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEATSERIAL >=", value, "seatserial");
            return (Criteria) this;
        }

        public Criteria andSeatserialLessThan(Integer value) {
            addCriterion("SEATSERIAL <", value, "seatserial");
            return (Criteria) this;
        }

        public Criteria andSeatserialLessThanOrEqualTo(Integer value) {
            addCriterion("SEATSERIAL <=", value, "seatserial");
            return (Criteria) this;
        }

        public Criteria andSeatserialIn(List<Integer> values) {
            addCriterion("SEATSERIAL in", values, "seatserial");
            return (Criteria) this;
        }

        public Criteria andSeatserialNotIn(List<Integer> values) {
            addCriterion("SEATSERIAL not in", values, "seatserial");
            return (Criteria) this;
        }

        public Criteria andSeatserialBetween(Integer value1, Integer value2) {
            addCriterion("SEATSERIAL between", value1, value2, "seatserial");
            return (Criteria) this;
        }

        public Criteria andSeatserialNotBetween(Integer value1, Integer value2) {
            addCriterion("SEATSERIAL not between", value1, value2, "seatserial");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNull() {
            addCriterion("USERCODE is null");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNotNull() {
            addCriterion("USERCODE is not null");
            return (Criteria) this;
        }

        public Criteria andUsercodeEqualTo(Integer value) {
            addCriterion("USERCODE =", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotEqualTo(Integer value) {
            addCriterion("USERCODE <>", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThan(Integer value) {
            addCriterion("USERCODE >", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("USERCODE >=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThan(Integer value) {
            addCriterion("USERCODE <", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThanOrEqualTo(Integer value) {
            addCriterion("USERCODE <=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeIn(List<Integer> values) {
            addCriterion("USERCODE in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotIn(List<Integer> values) {
            addCriterion("USERCODE not in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeBetween(Integer value1, Integer value2) {
            addCriterion("USERCODE between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotBetween(Integer value1, Integer value2) {
            addCriterion("USERCODE not between", value1, value2, "usercode");
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