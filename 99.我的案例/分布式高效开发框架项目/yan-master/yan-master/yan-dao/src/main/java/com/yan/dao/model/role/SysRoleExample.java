package com.yan.dao.model.role;

import java.util.ArrayList;
import java.util.List;

public class SysRoleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    public SysRoleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
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

        public Criteria andRolePidIsNull() {
            addCriterion("ROLE_PID is null");
            return (Criteria) this;
        }

        public Criteria andRolePidIsNotNull() {
            addCriterion("ROLE_PID is not null");
            return (Criteria) this;
        }

        public Criteria andRolePidEqualTo(String value) {
            addCriterion("ROLE_PID =", value, "rolePid");
            return (Criteria) this;
        }

        public Criteria andRolePidNotEqualTo(String value) {
            addCriterion("ROLE_PID <>", value, "rolePid");
            return (Criteria) this;
        }

        public Criteria andRolePidGreaterThan(String value) {
            addCriterion("ROLE_PID >", value, "rolePid");
            return (Criteria) this;
        }

        public Criteria andRolePidGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_PID >=", value, "rolePid");
            return (Criteria) this;
        }

        public Criteria andRolePidLessThan(String value) {
            addCriterion("ROLE_PID <", value, "rolePid");
            return (Criteria) this;
        }

        public Criteria andRolePidLessThanOrEqualTo(String value) {
            addCriterion("ROLE_PID <=", value, "rolePid");
            return (Criteria) this;
        }

        public Criteria andRolePidLike(String value) {
            addCriterion("ROLE_PID like", value, "rolePid");
            return (Criteria) this;
        }

        public Criteria andRolePidNotLike(String value) {
            addCriterion("ROLE_PID not like", value, "rolePid");
            return (Criteria) this;
        }

        public Criteria andRolePidIn(List<String> values) {
            addCriterion("ROLE_PID in", values, "rolePid");
            return (Criteria) this;
        }

        public Criteria andRolePidNotIn(List<String> values) {
            addCriterion("ROLE_PID not in", values, "rolePid");
            return (Criteria) this;
        }

        public Criteria andRolePidBetween(String value1, String value2) {
            addCriterion("ROLE_PID between", value1, value2, "rolePid");
            return (Criteria) this;
        }

        public Criteria andRolePidNotBetween(String value1, String value2) {
            addCriterion("ROLE_PID not between", value1, value2, "rolePid");
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

        public Criteria andRoleIndexIsNull() {
            addCriterion("ROLE_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andRoleIndexIsNotNull() {
            addCriterion("ROLE_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIndexEqualTo(Integer value) {
            addCriterion("ROLE_INDEX =", value, "roleIndex");
            return (Criteria) this;
        }

        public Criteria andRoleIndexNotEqualTo(Integer value) {
            addCriterion("ROLE_INDEX <>", value, "roleIndex");
            return (Criteria) this;
        }

        public Criteria andRoleIndexGreaterThan(Integer value) {
            addCriterion("ROLE_INDEX >", value, "roleIndex");
            return (Criteria) this;
        }

        public Criteria andRoleIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_INDEX >=", value, "roleIndex");
            return (Criteria) this;
        }

        public Criteria andRoleIndexLessThan(Integer value) {
            addCriterion("ROLE_INDEX <", value, "roleIndex");
            return (Criteria) this;
        }

        public Criteria andRoleIndexLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_INDEX <=", value, "roleIndex");
            return (Criteria) this;
        }

        public Criteria andRoleIndexIn(List<Integer> values) {
            addCriterion("ROLE_INDEX in", values, "roleIndex");
            return (Criteria) this;
        }

        public Criteria andRoleIndexNotIn(List<Integer> values) {
            addCriterion("ROLE_INDEX not in", values, "roleIndex");
            return (Criteria) this;
        }

        public Criteria andRoleIndexBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_INDEX between", value1, value2, "roleIndex");
            return (Criteria) this;
        }

        public Criteria andRoleIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_INDEX not between", value1, value2, "roleIndex");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNull() {
            addCriterion("ROLE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNotNull() {
            addCriterion("ROLE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeEqualTo(String value) {
            addCriterion("ROLE_TYPE =", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotEqualTo(String value) {
            addCriterion("ROLE_TYPE <>", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThan(String value) {
            addCriterion("ROLE_TYPE >", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_TYPE >=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThan(String value) {
            addCriterion("ROLE_TYPE <", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThanOrEqualTo(String value) {
            addCriterion("ROLE_TYPE <=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLike(String value) {
            addCriterion("ROLE_TYPE like", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotLike(String value) {
            addCriterion("ROLE_TYPE not like", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIn(List<String> values) {
            addCriterion("ROLE_TYPE in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotIn(List<String> values) {
            addCriterion("ROLE_TYPE not in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeBetween(String value1, String value2) {
            addCriterion("ROLE_TYPE between", value1, value2, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotBetween(String value1, String value2) {
            addCriterion("ROLE_TYPE not between", value1, value2, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleLevelIsNull() {
            addCriterion("ROLE_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andRoleLevelIsNotNull() {
            addCriterion("ROLE_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andRoleLevelEqualTo(Integer value) {
            addCriterion("ROLE_LEVEL =", value, "roleLevel");
            return (Criteria) this;
        }

        public Criteria andRoleLevelNotEqualTo(Integer value) {
            addCriterion("ROLE_LEVEL <>", value, "roleLevel");
            return (Criteria) this;
        }

        public Criteria andRoleLevelGreaterThan(Integer value) {
            addCriterion("ROLE_LEVEL >", value, "roleLevel");
            return (Criteria) this;
        }

        public Criteria andRoleLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_LEVEL >=", value, "roleLevel");
            return (Criteria) this;
        }

        public Criteria andRoleLevelLessThan(Integer value) {
            addCriterion("ROLE_LEVEL <", value, "roleLevel");
            return (Criteria) this;
        }

        public Criteria andRoleLevelLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_LEVEL <=", value, "roleLevel");
            return (Criteria) this;
        }

        public Criteria andRoleLevelIn(List<Integer> values) {
            addCriterion("ROLE_LEVEL in", values, "roleLevel");
            return (Criteria) this;
        }

        public Criteria andRoleLevelNotIn(List<Integer> values) {
            addCriterion("ROLE_LEVEL not in", values, "roleLevel");
            return (Criteria) this;
        }

        public Criteria andRoleLevelBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_LEVEL between", value1, value2, "roleLevel");
            return (Criteria) this;
        }

        public Criteria andRoleLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_LEVEL not between", value1, value2, "roleLevel");
            return (Criteria) this;
        }

        public Criteria andRoleValidIsNull() {
            addCriterion("ROLE_VALID is null");
            return (Criteria) this;
        }

        public Criteria andRoleValidIsNotNull() {
            addCriterion("ROLE_VALID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleValidEqualTo(Boolean value) {
            addCriterion("ROLE_VALID =", value, "roleValid");
            return (Criteria) this;
        }

        public Criteria andRoleValidNotEqualTo(Boolean value) {
            addCriterion("ROLE_VALID <>", value, "roleValid");
            return (Criteria) this;
        }

        public Criteria andRoleValidGreaterThan(Boolean value) {
            addCriterion("ROLE_VALID >", value, "roleValid");
            return (Criteria) this;
        }

        public Criteria andRoleValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ROLE_VALID >=", value, "roleValid");
            return (Criteria) this;
        }

        public Criteria andRoleValidLessThan(Boolean value) {
            addCriterion("ROLE_VALID <", value, "roleValid");
            return (Criteria) this;
        }

        public Criteria andRoleValidLessThanOrEqualTo(Boolean value) {
            addCriterion("ROLE_VALID <=", value, "roleValid");
            return (Criteria) this;
        }

        public Criteria andRoleValidIn(List<Boolean> values) {
            addCriterion("ROLE_VALID in", values, "roleValid");
            return (Criteria) this;
        }

        public Criteria andRoleValidNotIn(List<Boolean> values) {
            addCriterion("ROLE_VALID not in", values, "roleValid");
            return (Criteria) this;
        }

        public Criteria andRoleValidBetween(Boolean value1, Boolean value2) {
            addCriterion("ROLE_VALID between", value1, value2, "roleValid");
            return (Criteria) this;
        }

        public Criteria andRoleValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ROLE_VALID not between", value1, value2, "roleValid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SYS_ROLE
     *
     * @mbg.generated do_not_delete_during_merge Tue Sep 19 11:14:34 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
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