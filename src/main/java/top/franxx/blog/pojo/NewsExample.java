package top.franxx.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsExample() {
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

        public Criteria andNewsIdIsNull() {
            addCriterion("news_id is null");
            return (Criteria) this;
        }

        public Criteria andNewsIdIsNotNull() {
            addCriterion("news_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewsIdEqualTo(Long value) {
            addCriterion("news_id =", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotEqualTo(Long value) {
            addCriterion("news_id <>", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThan(Long value) {
            addCriterion("news_id >", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("news_id >=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThan(Long value) {
            addCriterion("news_id <", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThanOrEqualTo(Long value) {
            addCriterion("news_id <=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdIn(List<Long> values) {
            addCriterion("news_id in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotIn(List<Long> values) {
            addCriterion("news_id not in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdBetween(Long value1, Long value2) {
            addCriterion("news_id between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotBetween(Long value1, Long value2) {
            addCriterion("news_id not between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsNameIsNull() {
            addCriterion("news_name is null");
            return (Criteria) this;
        }

        public Criteria andNewsNameIsNotNull() {
            addCriterion("news_name is not null");
            return (Criteria) this;
        }

        public Criteria andNewsNameEqualTo(String value) {
            addCriterion("news_name =", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotEqualTo(String value) {
            addCriterion("news_name <>", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameGreaterThan(String value) {
            addCriterion("news_name >", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameGreaterThanOrEqualTo(String value) {
            addCriterion("news_name >=", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameLessThan(String value) {
            addCriterion("news_name <", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameLessThanOrEqualTo(String value) {
            addCriterion("news_name <=", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameLike(String value) {
            addCriterion("news_name like", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotLike(String value) {
            addCriterion("news_name not like", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameIn(List<String> values) {
            addCriterion("news_name in", values, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotIn(List<String> values) {
            addCriterion("news_name not in", values, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameBetween(String value1, String value2) {
            addCriterion("news_name between", value1, value2, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotBetween(String value1, String value2) {
            addCriterion("news_name not between", value1, value2, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIsNull() {
            addCriterion("news_author is null");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIsNotNull() {
            addCriterion("news_author is not null");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorEqualTo(String value) {
            addCriterion("news_author =", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotEqualTo(String value) {
            addCriterion("news_author <>", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorGreaterThan(String value) {
            addCriterion("news_author >", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("news_author >=", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLessThan(String value) {
            addCriterion("news_author <", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLessThanOrEqualTo(String value) {
            addCriterion("news_author <=", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLike(String value) {
            addCriterion("news_author like", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotLike(String value) {
            addCriterion("news_author not like", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIn(List<String> values) {
            addCriterion("news_author in", values, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotIn(List<String> values) {
            addCriterion("news_author not in", values, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorBetween(String value1, String value2) {
            addCriterion("news_author between", value1, value2, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotBetween(String value1, String value2) {
            addCriterion("news_author not between", value1, value2, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractIsNull() {
            addCriterion("news_abstract is null");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractIsNotNull() {
            addCriterion("news_abstract is not null");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractEqualTo(String value) {
            addCriterion("news_abstract =", value, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractNotEqualTo(String value) {
            addCriterion("news_abstract <>", value, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractGreaterThan(String value) {
            addCriterion("news_abstract >", value, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractGreaterThanOrEqualTo(String value) {
            addCriterion("news_abstract >=", value, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractLessThan(String value) {
            addCriterion("news_abstract <", value, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractLessThanOrEqualTo(String value) {
            addCriterion("news_abstract <=", value, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractLike(String value) {
            addCriterion("news_abstract like", value, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractNotLike(String value) {
            addCriterion("news_abstract not like", value, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractIn(List<String> values) {
            addCriterion("news_abstract in", values, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractNotIn(List<String> values) {
            addCriterion("news_abstract not in", values, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractBetween(String value1, String value2) {
            addCriterion("news_abstract between", value1, value2, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsAbstractNotBetween(String value1, String value2) {
            addCriterion("news_abstract not between", value1, value2, "newsAbstract");
            return (Criteria) this;
        }

        public Criteria andNewsStatusIsNull() {
            addCriterion("news_status is null");
            return (Criteria) this;
        }

        public Criteria andNewsStatusIsNotNull() {
            addCriterion("news_status is not null");
            return (Criteria) this;
        }

        public Criteria andNewsStatusEqualTo(Integer value) {
            addCriterion("news_status =", value, "newsStatus");
            return (Criteria) this;
        }

        public Criteria andNewsStatusNotEqualTo(Integer value) {
            addCriterion("news_status <>", value, "newsStatus");
            return (Criteria) this;
        }

        public Criteria andNewsStatusGreaterThan(Integer value) {
            addCriterion("news_status >", value, "newsStatus");
            return (Criteria) this;
        }

        public Criteria andNewsStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("news_status >=", value, "newsStatus");
            return (Criteria) this;
        }

        public Criteria andNewsStatusLessThan(Integer value) {
            addCriterion("news_status <", value, "newsStatus");
            return (Criteria) this;
        }

        public Criteria andNewsStatusLessThanOrEqualTo(Integer value) {
            addCriterion("news_status <=", value, "newsStatus");
            return (Criteria) this;
        }

        public Criteria andNewsStatusIn(List<Integer> values) {
            addCriterion("news_status in", values, "newsStatus");
            return (Criteria) this;
        }

        public Criteria andNewsStatusNotIn(List<Integer> values) {
            addCriterion("news_status not in", values, "newsStatus");
            return (Criteria) this;
        }

        public Criteria andNewsStatusBetween(Integer value1, Integer value2) {
            addCriterion("news_status between", value1, value2, "newsStatus");
            return (Criteria) this;
        }

        public Criteria andNewsStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("news_status not between", value1, value2, "newsStatus");
            return (Criteria) this;
        }

        public Criteria andNewsImgIsNull() {
            addCriterion("news_img is null");
            return (Criteria) this;
        }

        public Criteria andNewsImgIsNotNull() {
            addCriterion("news_img is not null");
            return (Criteria) this;
        }

        public Criteria andNewsImgEqualTo(String value) {
            addCriterion("news_img =", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgNotEqualTo(String value) {
            addCriterion("news_img <>", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgGreaterThan(String value) {
            addCriterion("news_img >", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgGreaterThanOrEqualTo(String value) {
            addCriterion("news_img >=", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgLessThan(String value) {
            addCriterion("news_img <", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgLessThanOrEqualTo(String value) {
            addCriterion("news_img <=", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgLike(String value) {
            addCriterion("news_img like", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgNotLike(String value) {
            addCriterion("news_img not like", value, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgIn(List<String> values) {
            addCriterion("news_img in", values, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgNotIn(List<String> values) {
            addCriterion("news_img not in", values, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgBetween(String value1, String value2) {
            addCriterion("news_img between", value1, value2, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsImgNotBetween(String value1, String value2) {
            addCriterion("news_img not between", value1, value2, "newsImg");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyIsNull() {
            addCriterion("news_classify is null");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyIsNotNull() {
            addCriterion("news_classify is not null");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyEqualTo(Integer value) {
            addCriterion("news_classify =", value, "newsClassify");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyNotEqualTo(Integer value) {
            addCriterion("news_classify <>", value, "newsClassify");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyGreaterThan(Integer value) {
            addCriterion("news_classify >", value, "newsClassify");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("news_classify >=", value, "newsClassify");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyLessThan(Integer value) {
            addCriterion("news_classify <", value, "newsClassify");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyLessThanOrEqualTo(Integer value) {
            addCriterion("news_classify <=", value, "newsClassify");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyIn(List<Integer> values) {
            addCriterion("news_classify in", values, "newsClassify");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyNotIn(List<Integer> values) {
            addCriterion("news_classify not in", values, "newsClassify");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyBetween(Integer value1, Integer value2) {
            addCriterion("news_classify between", value1, value2, "newsClassify");
            return (Criteria) this;
        }

        public Criteria andNewsClassifyNotBetween(Integer value1, Integer value2) {
            addCriterion("news_classify not between", value1, value2, "newsClassify");
            return (Criteria) this;
        }

        public Criteria andNewsLookIsNull() {
            addCriterion("news_look is null");
            return (Criteria) this;
        }

        public Criteria andNewsLookIsNotNull() {
            addCriterion("news_look is not null");
            return (Criteria) this;
        }

        public Criteria andNewsLookEqualTo(String value) {
            addCriterion("news_look =", value, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsLookNotEqualTo(String value) {
            addCriterion("news_look <>", value, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsLookGreaterThan(String value) {
            addCriterion("news_look >", value, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsLookGreaterThanOrEqualTo(String value) {
            addCriterion("news_look >=", value, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsLookLessThan(String value) {
            addCriterion("news_look <", value, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsLookLessThanOrEqualTo(String value) {
            addCriterion("news_look <=", value, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsLookLike(String value) {
            addCriterion("news_look like", value, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsLookNotLike(String value) {
            addCriterion("news_look not like", value, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsLookIn(List<String> values) {
            addCriterion("news_look in", values, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsLookNotIn(List<String> values) {
            addCriterion("news_look not in", values, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsLookBetween(String value1, String value2) {
            addCriterion("news_look between", value1, value2, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsLookNotBetween(String value1, String value2) {
            addCriterion("news_look not between", value1, value2, "newsLook");
            return (Criteria) this;
        }

        public Criteria andNewsTopIsNull() {
            addCriterion("news_top is null");
            return (Criteria) this;
        }

        public Criteria andNewsTopIsNotNull() {
            addCriterion("news_top is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTopEqualTo(String value) {
            addCriterion("news_top =", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopNotEqualTo(String value) {
            addCriterion("news_top <>", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopGreaterThan(String value) {
            addCriterion("news_top >", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopGreaterThanOrEqualTo(String value) {
            addCriterion("news_top >=", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopLessThan(String value) {
            addCriterion("news_top <", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopLessThanOrEqualTo(String value) {
            addCriterion("news_top <=", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopLike(String value) {
            addCriterion("news_top like", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopNotLike(String value) {
            addCriterion("news_top not like", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopIn(List<String> values) {
            addCriterion("news_top in", values, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopNotIn(List<String> values) {
            addCriterion("news_top not in", values, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopBetween(String value1, String value2) {
            addCriterion("news_top between", value1, value2, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopNotBetween(String value1, String value2) {
            addCriterion("news_top not between", value1, value2, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTimeIsNull() {
            addCriterion("news_time is null");
            return (Criteria) this;
        }

        public Criteria andNewsTimeIsNotNull() {
            addCriterion("news_time is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTimeEqualTo(Date value) {
            addCriterion("news_time =", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeNotEqualTo(Date value) {
            addCriterion("news_time <>", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeGreaterThan(Date value) {
            addCriterion("news_time >", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("news_time >=", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeLessThan(Date value) {
            addCriterion("news_time <", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeLessThanOrEqualTo(Date value) {
            addCriterion("news_time <=", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeIn(List<Date> values) {
            addCriterion("news_time in", values, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeNotIn(List<Date> values) {
            addCriterion("news_time not in", values, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeBetween(Date value1, Date value2) {
            addCriterion("news_time between", value1, value2, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeNotBetween(Date value1, Date value2) {
            addCriterion("news_time not between", value1, value2, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsLikeIsNull() {
            addCriterion("news_like is null");
            return (Criteria) this;
        }

        public Criteria andNewsLikeIsNotNull() {
            addCriterion("news_like is not null");
            return (Criteria) this;
        }

        public Criteria andNewsLikeEqualTo(Long value) {
            addCriterion("news_like =", value, "newsLike");
            return (Criteria) this;
        }

        public Criteria andNewsLikeNotEqualTo(Long value) {
            addCriterion("news_like <>", value, "newsLike");
            return (Criteria) this;
        }

        public Criteria andNewsLikeGreaterThan(Long value) {
            addCriterion("news_like >", value, "newsLike");
            return (Criteria) this;
        }

        public Criteria andNewsLikeGreaterThanOrEqualTo(Long value) {
            addCriterion("news_like >=", value, "newsLike");
            return (Criteria) this;
        }

        public Criteria andNewsLikeLessThan(Long value) {
            addCriterion("news_like <", value, "newsLike");
            return (Criteria) this;
        }

        public Criteria andNewsLikeLessThanOrEqualTo(Long value) {
            addCriterion("news_like <=", value, "newsLike");
            return (Criteria) this;
        }

        public Criteria andNewsLikeIn(List<Long> values) {
            addCriterion("news_like in", values, "newsLike");
            return (Criteria) this;
        }

        public Criteria andNewsLikeNotIn(List<Long> values) {
            addCriterion("news_like not in", values, "newsLike");
            return (Criteria) this;
        }

        public Criteria andNewsLikeBetween(Long value1, Long value2) {
            addCriterion("news_like between", value1, value2, "newsLike");
            return (Criteria) this;
        }

        public Criteria andNewsLikeNotBetween(Long value1, Long value2) {
            addCriterion("news_like not between", value1, value2, "newsLike");
            return (Criteria) this;
        }

        public Criteria andNewsViewIsNull() {
            addCriterion("news_view is null");
            return (Criteria) this;
        }

        public Criteria andNewsViewIsNotNull() {
            addCriterion("news_view is not null");
            return (Criteria) this;
        }

        public Criteria andNewsViewEqualTo(Long value) {
            addCriterion("news_view =", value, "newsView");
            return (Criteria) this;
        }

        public Criteria andNewsViewNotEqualTo(Long value) {
            addCriterion("news_view <>", value, "newsView");
            return (Criteria) this;
        }

        public Criteria andNewsViewGreaterThan(Long value) {
            addCriterion("news_view >", value, "newsView");
            return (Criteria) this;
        }

        public Criteria andNewsViewGreaterThanOrEqualTo(Long value) {
            addCriterion("news_view >=", value, "newsView");
            return (Criteria) this;
        }

        public Criteria andNewsViewLessThan(Long value) {
            addCriterion("news_view <", value, "newsView");
            return (Criteria) this;
        }

        public Criteria andNewsViewLessThanOrEqualTo(Long value) {
            addCriterion("news_view <=", value, "newsView");
            return (Criteria) this;
        }

        public Criteria andNewsViewIn(List<Long> values) {
            addCriterion("news_view in", values, "newsView");
            return (Criteria) this;
        }

        public Criteria andNewsViewNotIn(List<Long> values) {
            addCriterion("news_view not in", values, "newsView");
            return (Criteria) this;
        }

        public Criteria andNewsViewBetween(Long value1, Long value2) {
            addCriterion("news_view between", value1, value2, "newsView");
            return (Criteria) this;
        }

        public Criteria andNewsViewNotBetween(Long value1, Long value2) {
            addCriterion("news_view not between", value1, value2, "newsView");
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