package top.franxx.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andComIdIsNull() {
            addCriterion("com_id is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("com_id is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(Long value) {
            addCriterion("com_id =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(Long value) {
            addCriterion("com_id <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(Long value) {
            addCriterion("com_id >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(Long value) {
            addCriterion("com_id >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(Long value) {
            addCriterion("com_id <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(Long value) {
            addCriterion("com_id <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<Long> values) {
            addCriterion("com_id in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<Long> values) {
            addCriterion("com_id not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(Long value1, Long value2) {
            addCriterion("com_id between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(Long value1, Long value2) {
            addCriterion("com_id not between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComNewsIdIsNull() {
            addCriterion("com_news_id is null");
            return (Criteria) this;
        }

        public Criteria andComNewsIdIsNotNull() {
            addCriterion("com_news_id is not null");
            return (Criteria) this;
        }

        public Criteria andComNewsIdEqualTo(Long value) {
            addCriterion("com_news_id =", value, "comNewsId");
            return (Criteria) this;
        }

        public Criteria andComNewsIdNotEqualTo(Long value) {
            addCriterion("com_news_id <>", value, "comNewsId");
            return (Criteria) this;
        }

        public Criteria andComNewsIdGreaterThan(Long value) {
            addCriterion("com_news_id >", value, "comNewsId");
            return (Criteria) this;
        }

        public Criteria andComNewsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("com_news_id >=", value, "comNewsId");
            return (Criteria) this;
        }

        public Criteria andComNewsIdLessThan(Long value) {
            addCriterion("com_news_id <", value, "comNewsId");
            return (Criteria) this;
        }

        public Criteria andComNewsIdLessThanOrEqualTo(Long value) {
            addCriterion("com_news_id <=", value, "comNewsId");
            return (Criteria) this;
        }

        public Criteria andComNewsIdIn(List<Long> values) {
            addCriterion("com_news_id in", values, "comNewsId");
            return (Criteria) this;
        }

        public Criteria andComNewsIdNotIn(List<Long> values) {
            addCriterion("com_news_id not in", values, "comNewsId");
            return (Criteria) this;
        }

        public Criteria andComNewsIdBetween(Long value1, Long value2) {
            addCriterion("com_news_id between", value1, value2, "comNewsId");
            return (Criteria) this;
        }

        public Criteria andComNewsIdNotBetween(Long value1, Long value2) {
            addCriterion("com_news_id not between", value1, value2, "comNewsId");
            return (Criteria) this;
        }

        public Criteria andComNameIsNull() {
            addCriterion("com_name is null");
            return (Criteria) this;
        }

        public Criteria andComNameIsNotNull() {
            addCriterion("com_name is not null");
            return (Criteria) this;
        }

        public Criteria andComNameEqualTo(String value) {
            addCriterion("com_name =", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotEqualTo(String value) {
            addCriterion("com_name <>", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThan(String value) {
            addCriterion("com_name >", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThanOrEqualTo(String value) {
            addCriterion("com_name >=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThan(String value) {
            addCriterion("com_name <", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThanOrEqualTo(String value) {
            addCriterion("com_name <=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLike(String value) {
            addCriterion("com_name like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotLike(String value) {
            addCriterion("com_name not like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameIn(List<String> values) {
            addCriterion("com_name in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotIn(List<String> values) {
            addCriterion("com_name not in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameBetween(String value1, String value2) {
            addCriterion("com_name between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotBetween(String value1, String value2) {
            addCriterion("com_name not between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComImgIsNull() {
            addCriterion("com_img is null");
            return (Criteria) this;
        }

        public Criteria andComImgIsNotNull() {
            addCriterion("com_img is not null");
            return (Criteria) this;
        }

        public Criteria andComImgEqualTo(String value) {
            addCriterion("com_img =", value, "comImg");
            return (Criteria) this;
        }

        public Criteria andComImgNotEqualTo(String value) {
            addCriterion("com_img <>", value, "comImg");
            return (Criteria) this;
        }

        public Criteria andComImgGreaterThan(String value) {
            addCriterion("com_img >", value, "comImg");
            return (Criteria) this;
        }

        public Criteria andComImgGreaterThanOrEqualTo(String value) {
            addCriterion("com_img >=", value, "comImg");
            return (Criteria) this;
        }

        public Criteria andComImgLessThan(String value) {
            addCriterion("com_img <", value, "comImg");
            return (Criteria) this;
        }

        public Criteria andComImgLessThanOrEqualTo(String value) {
            addCriterion("com_img <=", value, "comImg");
            return (Criteria) this;
        }

        public Criteria andComImgLike(String value) {
            addCriterion("com_img like", value, "comImg");
            return (Criteria) this;
        }

        public Criteria andComImgNotLike(String value) {
            addCriterion("com_img not like", value, "comImg");
            return (Criteria) this;
        }

        public Criteria andComImgIn(List<String> values) {
            addCriterion("com_img in", values, "comImg");
            return (Criteria) this;
        }

        public Criteria andComImgNotIn(List<String> values) {
            addCriterion("com_img not in", values, "comImg");
            return (Criteria) this;
        }

        public Criteria andComImgBetween(String value1, String value2) {
            addCriterion("com_img between", value1, value2, "comImg");
            return (Criteria) this;
        }

        public Criteria andComImgNotBetween(String value1, String value2) {
            addCriterion("com_img not between", value1, value2, "comImg");
            return (Criteria) this;
        }

        public Criteria andComTimeIsNull() {
            addCriterion("com_time is null");
            return (Criteria) this;
        }

        public Criteria andComTimeIsNotNull() {
            addCriterion("com_time is not null");
            return (Criteria) this;
        }

        public Criteria andComTimeEqualTo(Date value) {
            addCriterion("com_time =", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeNotEqualTo(Date value) {
            addCriterion("com_time <>", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeGreaterThan(Date value) {
            addCriterion("com_time >", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("com_time >=", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeLessThan(Date value) {
            addCriterion("com_time <", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeLessThanOrEqualTo(Date value) {
            addCriterion("com_time <=", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeIn(List<Date> values) {
            addCriterion("com_time in", values, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeNotIn(List<Date> values) {
            addCriterion("com_time not in", values, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeBetween(Date value1, Date value2) {
            addCriterion("com_time between", value1, value2, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeNotBetween(Date value1, Date value2) {
            addCriterion("com_time not between", value1, value2, "comTime");
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