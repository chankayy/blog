package top.franxx.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShareExample() {
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

        public Criteria andShareIdIsNull() {
            addCriterion("share_id is null");
            return (Criteria) this;
        }

        public Criteria andShareIdIsNotNull() {
            addCriterion("share_id is not null");
            return (Criteria) this;
        }

        public Criteria andShareIdEqualTo(Long value) {
            addCriterion("share_id =", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotEqualTo(Long value) {
            addCriterion("share_id <>", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThan(Long value) {
            addCriterion("share_id >", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThanOrEqualTo(Long value) {
            addCriterion("share_id >=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThan(Long value) {
            addCriterion("share_id <", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThanOrEqualTo(Long value) {
            addCriterion("share_id <=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdIn(List<Long> values) {
            addCriterion("share_id in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotIn(List<Long> values) {
            addCriterion("share_id not in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdBetween(Long value1, Long value2) {
            addCriterion("share_id between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotBetween(Long value1, Long value2) {
            addCriterion("share_id not between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareNameIsNull() {
            addCriterion("share_name is null");
            return (Criteria) this;
        }

        public Criteria andShareNameIsNotNull() {
            addCriterion("share_name is not null");
            return (Criteria) this;
        }

        public Criteria andShareNameEqualTo(String value) {
            addCriterion("share_name =", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotEqualTo(String value) {
            addCriterion("share_name <>", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameGreaterThan(String value) {
            addCriterion("share_name >", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameGreaterThanOrEqualTo(String value) {
            addCriterion("share_name >=", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameLessThan(String value) {
            addCriterion("share_name <", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameLessThanOrEqualTo(String value) {
            addCriterion("share_name <=", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameLike(String value) {
            addCriterion("share_name like", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotLike(String value) {
            addCriterion("share_name not like", value, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameIn(List<String> values) {
            addCriterion("share_name in", values, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotIn(List<String> values) {
            addCriterion("share_name not in", values, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameBetween(String value1, String value2) {
            addCriterion("share_name between", value1, value2, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareNameNotBetween(String value1, String value2) {
            addCriterion("share_name not between", value1, value2, "shareName");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNull() {
            addCriterion("share_url is null");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNotNull() {
            addCriterion("share_url is not null");
            return (Criteria) this;
        }

        public Criteria andShareUrlEqualTo(String value) {
            addCriterion("share_url =", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotEqualTo(String value) {
            addCriterion("share_url <>", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThan(String value) {
            addCriterion("share_url >", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThanOrEqualTo(String value) {
            addCriterion("share_url >=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThan(String value) {
            addCriterion("share_url <", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThanOrEqualTo(String value) {
            addCriterion("share_url <=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLike(String value) {
            addCriterion("share_url like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotLike(String value) {
            addCriterion("share_url not like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlIn(List<String> values) {
            addCriterion("share_url in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotIn(List<String> values) {
            addCriterion("share_url not in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlBetween(String value1, String value2) {
            addCriterion("share_url between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotBetween(String value1, String value2) {
            addCriterion("share_url not between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareIntroIsNull() {
            addCriterion("share_intro is null");
            return (Criteria) this;
        }

        public Criteria andShareIntroIsNotNull() {
            addCriterion("share_intro is not null");
            return (Criteria) this;
        }

        public Criteria andShareIntroEqualTo(String value) {
            addCriterion("share_intro =", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroNotEqualTo(String value) {
            addCriterion("share_intro <>", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroGreaterThan(String value) {
            addCriterion("share_intro >", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroGreaterThanOrEqualTo(String value) {
            addCriterion("share_intro >=", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroLessThan(String value) {
            addCriterion("share_intro <", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroLessThanOrEqualTo(String value) {
            addCriterion("share_intro <=", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroLike(String value) {
            addCriterion("share_intro like", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroNotLike(String value) {
            addCriterion("share_intro not like", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroIn(List<String> values) {
            addCriterion("share_intro in", values, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroNotIn(List<String> values) {
            addCriterion("share_intro not in", values, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroBetween(String value1, String value2) {
            addCriterion("share_intro between", value1, value2, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroNotBetween(String value1, String value2) {
            addCriterion("share_intro not between", value1, value2, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareStatusIsNull() {
            addCriterion("share_status is null");
            return (Criteria) this;
        }

        public Criteria andShareStatusIsNotNull() {
            addCriterion("share_status is not null");
            return (Criteria) this;
        }

        public Criteria andShareStatusEqualTo(String value) {
            addCriterion("share_status =", value, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareStatusNotEqualTo(String value) {
            addCriterion("share_status <>", value, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareStatusGreaterThan(String value) {
            addCriterion("share_status >", value, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareStatusGreaterThanOrEqualTo(String value) {
            addCriterion("share_status >=", value, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareStatusLessThan(String value) {
            addCriterion("share_status <", value, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareStatusLessThanOrEqualTo(String value) {
            addCriterion("share_status <=", value, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareStatusLike(String value) {
            addCriterion("share_status like", value, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareStatusNotLike(String value) {
            addCriterion("share_status not like", value, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareStatusIn(List<String> values) {
            addCriterion("share_status in", values, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareStatusNotIn(List<String> values) {
            addCriterion("share_status not in", values, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareStatusBetween(String value1, String value2) {
            addCriterion("share_status between", value1, value2, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareStatusNotBetween(String value1, String value2) {
            addCriterion("share_status not between", value1, value2, "shareStatus");
            return (Criteria) this;
        }

        public Criteria andShareClassifyIsNull() {
            addCriterion("share_classify is null");
            return (Criteria) this;
        }

        public Criteria andShareClassifyIsNotNull() {
            addCriterion("share_classify is not null");
            return (Criteria) this;
        }

        public Criteria andShareClassifyEqualTo(String value) {
            addCriterion("share_classify =", value, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareClassifyNotEqualTo(String value) {
            addCriterion("share_classify <>", value, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareClassifyGreaterThan(String value) {
            addCriterion("share_classify >", value, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareClassifyGreaterThanOrEqualTo(String value) {
            addCriterion("share_classify >=", value, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareClassifyLessThan(String value) {
            addCriterion("share_classify <", value, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareClassifyLessThanOrEqualTo(String value) {
            addCriterion("share_classify <=", value, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareClassifyLike(String value) {
            addCriterion("share_classify like", value, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareClassifyNotLike(String value) {
            addCriterion("share_classify not like", value, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareClassifyIn(List<String> values) {
            addCriterion("share_classify in", values, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareClassifyNotIn(List<String> values) {
            addCriterion("share_classify not in", values, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareClassifyBetween(String value1, String value2) {
            addCriterion("share_classify between", value1, value2, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareClassifyNotBetween(String value1, String value2) {
            addCriterion("share_classify not between", value1, value2, "shareClassify");
            return (Criteria) this;
        }

        public Criteria andShareDownloadIsNull() {
            addCriterion("share_download is null");
            return (Criteria) this;
        }

        public Criteria andShareDownloadIsNotNull() {
            addCriterion("share_download is not null");
            return (Criteria) this;
        }

        public Criteria andShareDownloadEqualTo(String value) {
            addCriterion("share_download =", value, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareDownloadNotEqualTo(String value) {
            addCriterion("share_download <>", value, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareDownloadGreaterThan(String value) {
            addCriterion("share_download >", value, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareDownloadGreaterThanOrEqualTo(String value) {
            addCriterion("share_download >=", value, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareDownloadLessThan(String value) {
            addCriterion("share_download <", value, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareDownloadLessThanOrEqualTo(String value) {
            addCriterion("share_download <=", value, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareDownloadLike(String value) {
            addCriterion("share_download like", value, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareDownloadNotLike(String value) {
            addCriterion("share_download not like", value, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareDownloadIn(List<String> values) {
            addCriterion("share_download in", values, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareDownloadNotIn(List<String> values) {
            addCriterion("share_download not in", values, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareDownloadBetween(String value1, String value2) {
            addCriterion("share_download between", value1, value2, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareDownloadNotBetween(String value1, String value2) {
            addCriterion("share_download not between", value1, value2, "shareDownload");
            return (Criteria) this;
        }

        public Criteria andShareImgIsNull() {
            addCriterion("share_img is null");
            return (Criteria) this;
        }

        public Criteria andShareImgIsNotNull() {
            addCriterion("share_img is not null");
            return (Criteria) this;
        }

        public Criteria andShareImgEqualTo(String value) {
            addCriterion("share_img =", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotEqualTo(String value) {
            addCriterion("share_img <>", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgGreaterThan(String value) {
            addCriterion("share_img >", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgGreaterThanOrEqualTo(String value) {
            addCriterion("share_img >=", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLessThan(String value) {
            addCriterion("share_img <", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLessThanOrEqualTo(String value) {
            addCriterion("share_img <=", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLike(String value) {
            addCriterion("share_img like", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotLike(String value) {
            addCriterion("share_img not like", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgIn(List<String> values) {
            addCriterion("share_img in", values, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotIn(List<String> values) {
            addCriterion("share_img not in", values, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgBetween(String value1, String value2) {
            addCriterion("share_img between", value1, value2, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotBetween(String value1, String value2) {
            addCriterion("share_img not between", value1, value2, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareAuthorIsNull() {
            addCriterion("share_author is null");
            return (Criteria) this;
        }

        public Criteria andShareAuthorIsNotNull() {
            addCriterion("share_author is not null");
            return (Criteria) this;
        }

        public Criteria andShareAuthorEqualTo(String value) {
            addCriterion("share_author =", value, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareAuthorNotEqualTo(String value) {
            addCriterion("share_author <>", value, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareAuthorGreaterThan(String value) {
            addCriterion("share_author >", value, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("share_author >=", value, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareAuthorLessThan(String value) {
            addCriterion("share_author <", value, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareAuthorLessThanOrEqualTo(String value) {
            addCriterion("share_author <=", value, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareAuthorLike(String value) {
            addCriterion("share_author like", value, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareAuthorNotLike(String value) {
            addCriterion("share_author not like", value, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareAuthorIn(List<String> values) {
            addCriterion("share_author in", values, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareAuthorNotIn(List<String> values) {
            addCriterion("share_author not in", values, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareAuthorBetween(String value1, String value2) {
            addCriterion("share_author between", value1, value2, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareAuthorNotBetween(String value1, String value2) {
            addCriterion("share_author not between", value1, value2, "shareAuthor");
            return (Criteria) this;
        }

        public Criteria andShareTimeIsNull() {
            addCriterion("share_time is null");
            return (Criteria) this;
        }

        public Criteria andShareTimeIsNotNull() {
            addCriterion("share_time is not null");
            return (Criteria) this;
        }

        public Criteria andShareTimeEqualTo(Date value) {
            addCriterion("share_time =", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotEqualTo(Date value) {
            addCriterion("share_time <>", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeGreaterThan(Date value) {
            addCriterion("share_time >", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("share_time >=", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeLessThan(Date value) {
            addCriterion("share_time <", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeLessThanOrEqualTo(Date value) {
            addCriterion("share_time <=", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeIn(List<Date> values) {
            addCriterion("share_time in", values, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotIn(List<Date> values) {
            addCriterion("share_time not in", values, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeBetween(Date value1, Date value2) {
            addCriterion("share_time between", value1, value2, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotBetween(Date value1, Date value2) {
            addCriterion("share_time not between", value1, value2, "shareTime");
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