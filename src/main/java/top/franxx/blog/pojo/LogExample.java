package top.franxx.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Long value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Long value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Long value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Long value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Long value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Long> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Long> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Long value1, Long value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Long value1, Long value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogUrlIsNull() {
            addCriterion("log_url is null");
            return (Criteria) this;
        }

        public Criteria andLogUrlIsNotNull() {
            addCriterion("log_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogUrlEqualTo(String value) {
            addCriterion("log_url =", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlNotEqualTo(String value) {
            addCriterion("log_url <>", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlGreaterThan(String value) {
            addCriterion("log_url >", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlGreaterThanOrEqualTo(String value) {
            addCriterion("log_url >=", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlLessThan(String value) {
            addCriterion("log_url <", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlLessThanOrEqualTo(String value) {
            addCriterion("log_url <=", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlLike(String value) {
            addCriterion("log_url like", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlNotLike(String value) {
            addCriterion("log_url not like", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlIn(List<String> values) {
            addCriterion("log_url in", values, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlNotIn(List<String> values) {
            addCriterion("log_url not in", values, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlBetween(String value1, String value2) {
            addCriterion("log_url between", value1, value2, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlNotBetween(String value1, String value2) {
            addCriterion("log_url not between", value1, value2, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogReqIsNull() {
            addCriterion("log_req is null");
            return (Criteria) this;
        }

        public Criteria andLogReqIsNotNull() {
            addCriterion("log_req is not null");
            return (Criteria) this;
        }

        public Criteria andLogReqEqualTo(String value) {
            addCriterion("log_req =", value, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogReqNotEqualTo(String value) {
            addCriterion("log_req <>", value, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogReqGreaterThan(String value) {
            addCriterion("log_req >", value, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogReqGreaterThanOrEqualTo(String value) {
            addCriterion("log_req >=", value, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogReqLessThan(String value) {
            addCriterion("log_req <", value, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogReqLessThanOrEqualTo(String value) {
            addCriterion("log_req <=", value, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogReqLike(String value) {
            addCriterion("log_req like", value, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogReqNotLike(String value) {
            addCriterion("log_req not like", value, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogReqIn(List<String> values) {
            addCriterion("log_req in", values, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogReqNotIn(List<String> values) {
            addCriterion("log_req not in", values, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogReqBetween(String value1, String value2) {
            addCriterion("log_req between", value1, value2, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogReqNotBetween(String value1, String value2) {
            addCriterion("log_req not between", value1, value2, "logReq");
            return (Criteria) this;
        }

        public Criteria andLogIpIsNull() {
            addCriterion("log_ip is null");
            return (Criteria) this;
        }

        public Criteria andLogIpIsNotNull() {
            addCriterion("log_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLogIpEqualTo(String value) {
            addCriterion("log_ip =", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotEqualTo(String value) {
            addCriterion("log_ip <>", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpGreaterThan(String value) {
            addCriterion("log_ip >", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpGreaterThanOrEqualTo(String value) {
            addCriterion("log_ip >=", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpLessThan(String value) {
            addCriterion("log_ip <", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpLessThanOrEqualTo(String value) {
            addCriterion("log_ip <=", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpLike(String value) {
            addCriterion("log_ip like", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotLike(String value) {
            addCriterion("log_ip not like", value, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpIn(List<String> values) {
            addCriterion("log_ip in", values, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotIn(List<String> values) {
            addCriterion("log_ip not in", values, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpBetween(String value1, String value2) {
            addCriterion("log_ip between", value1, value2, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogIpNotBetween(String value1, String value2) {
            addCriterion("log_ip not between", value1, value2, "logIp");
            return (Criteria) this;
        }

        public Criteria andLogTakingIsNull() {
            addCriterion("log_taking is null");
            return (Criteria) this;
        }

        public Criteria andLogTakingIsNotNull() {
            addCriterion("log_taking is not null");
            return (Criteria) this;
        }

        public Criteria andLogTakingEqualTo(String value) {
            addCriterion("log_taking =", value, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogTakingNotEqualTo(String value) {
            addCriterion("log_taking <>", value, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogTakingGreaterThan(String value) {
            addCriterion("log_taking >", value, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogTakingGreaterThanOrEqualTo(String value) {
            addCriterion("log_taking >=", value, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogTakingLessThan(String value) {
            addCriterion("log_taking <", value, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogTakingLessThanOrEqualTo(String value) {
            addCriterion("log_taking <=", value, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogTakingLike(String value) {
            addCriterion("log_taking like", value, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogTakingNotLike(String value) {
            addCriterion("log_taking not like", value, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogTakingIn(List<String> values) {
            addCriterion("log_taking in", values, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogTakingNotIn(List<String> values) {
            addCriterion("log_taking not in", values, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogTakingBetween(String value1, String value2) {
            addCriterion("log_taking between", value1, value2, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogTakingNotBetween(String value1, String value2) {
            addCriterion("log_taking not between", value1, value2, "logTaking");
            return (Criteria) this;
        }

        public Criteria andLogStatusIsNull() {
            addCriterion("log_status is null");
            return (Criteria) this;
        }

        public Criteria andLogStatusIsNotNull() {
            addCriterion("log_status is not null");
            return (Criteria) this;
        }

        public Criteria andLogStatusEqualTo(Integer value) {
            addCriterion("log_status =", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotEqualTo(Integer value) {
            addCriterion("log_status <>", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusGreaterThan(Integer value) {
            addCriterion("log_status >", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_status >=", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusLessThan(Integer value) {
            addCriterion("log_status <", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusLessThanOrEqualTo(Integer value) {
            addCriterion("log_status <=", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusIn(List<Integer> values) {
            addCriterion("log_status in", values, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotIn(List<Integer> values) {
            addCriterion("log_status not in", values, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusBetween(Integer value1, Integer value2) {
            addCriterion("log_status between", value1, value2, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("log_status not between", value1, value2, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogUserIdIsNull() {
            addCriterion("log_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLogUserIdIsNotNull() {
            addCriterion("log_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogUserIdEqualTo(Long value) {
            addCriterion("log_user_id =", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdNotEqualTo(Long value) {
            addCriterion("log_user_id <>", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdGreaterThan(Long value) {
            addCriterion("log_user_id >", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_user_id >=", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdLessThan(Long value) {
            addCriterion("log_user_id <", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdLessThanOrEqualTo(Long value) {
            addCriterion("log_user_id <=", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdIn(List<Long> values) {
            addCriterion("log_user_id in", values, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdNotIn(List<Long> values) {
            addCriterion("log_user_id not in", values, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdBetween(Long value1, Long value2) {
            addCriterion("log_user_id between", value1, value2, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdNotBetween(Long value1, Long value2) {
            addCriterion("log_user_id not between", value1, value2, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(Date value) {
            addCriterion("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterion("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterion("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterion("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Date> values) {
            addCriterion("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Date> values) {
            addCriterion("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterion("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_time not between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogContentIsNull() {
            addCriterion("log_content is null");
            return (Criteria) this;
        }

        public Criteria andLogContentIsNotNull() {
            addCriterion("log_content is not null");
            return (Criteria) this;
        }

        public Criteria andLogContentEqualTo(String value) {
            addCriterion("log_content =", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotEqualTo(String value) {
            addCriterion("log_content <>", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentGreaterThan(String value) {
            addCriterion("log_content >", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentGreaterThanOrEqualTo(String value) {
            addCriterion("log_content >=", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentLessThan(String value) {
            addCriterion("log_content <", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentLessThanOrEqualTo(String value) {
            addCriterion("log_content <=", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentLike(String value) {
            addCriterion("log_content like", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotLike(String value) {
            addCriterion("log_content not like", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentIn(List<String> values) {
            addCriterion("log_content in", values, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotIn(List<String> values) {
            addCriterion("log_content not in", values, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentBetween(String value1, String value2) {
            addCriterion("log_content between", value1, value2, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotBetween(String value1, String value2) {
            addCriterion("log_content not between", value1, value2, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogControllerIsNull() {
            addCriterion("log_controller is null");
            return (Criteria) this;
        }

        public Criteria andLogControllerIsNotNull() {
            addCriterion("log_controller is not null");
            return (Criteria) this;
        }

        public Criteria andLogControllerEqualTo(String value) {
            addCriterion("log_controller =", value, "logController");
            return (Criteria) this;
        }

        public Criteria andLogControllerNotEqualTo(String value) {
            addCriterion("log_controller <>", value, "logController");
            return (Criteria) this;
        }

        public Criteria andLogControllerGreaterThan(String value) {
            addCriterion("log_controller >", value, "logController");
            return (Criteria) this;
        }

        public Criteria andLogControllerGreaterThanOrEqualTo(String value) {
            addCriterion("log_controller >=", value, "logController");
            return (Criteria) this;
        }

        public Criteria andLogControllerLessThan(String value) {
            addCriterion("log_controller <", value, "logController");
            return (Criteria) this;
        }

        public Criteria andLogControllerLessThanOrEqualTo(String value) {
            addCriterion("log_controller <=", value, "logController");
            return (Criteria) this;
        }

        public Criteria andLogControllerLike(String value) {
            addCriterion("log_controller like", value, "logController");
            return (Criteria) this;
        }

        public Criteria andLogControllerNotLike(String value) {
            addCriterion("log_controller not like", value, "logController");
            return (Criteria) this;
        }

        public Criteria andLogControllerIn(List<String> values) {
            addCriterion("log_controller in", values, "logController");
            return (Criteria) this;
        }

        public Criteria andLogControllerNotIn(List<String> values) {
            addCriterion("log_controller not in", values, "logController");
            return (Criteria) this;
        }

        public Criteria andLogControllerBetween(String value1, String value2) {
            addCriterion("log_controller between", value1, value2, "logController");
            return (Criteria) this;
        }

        public Criteria andLogControllerNotBetween(String value1, String value2) {
            addCriterion("log_controller not between", value1, value2, "logController");
            return (Criteria) this;
        }

        public Criteria andLogMethodIsNull() {
            addCriterion("log_method is null");
            return (Criteria) this;
        }

        public Criteria andLogMethodIsNotNull() {
            addCriterion("log_method is not null");
            return (Criteria) this;
        }

        public Criteria andLogMethodEqualTo(String value) {
            addCriterion("log_method =", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodNotEqualTo(String value) {
            addCriterion("log_method <>", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodGreaterThan(String value) {
            addCriterion("log_method >", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodGreaterThanOrEqualTo(String value) {
            addCriterion("log_method >=", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodLessThan(String value) {
            addCriterion("log_method <", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodLessThanOrEqualTo(String value) {
            addCriterion("log_method <=", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodLike(String value) {
            addCriterion("log_method like", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodNotLike(String value) {
            addCriterion("log_method not like", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodIn(List<String> values) {
            addCriterion("log_method in", values, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodNotIn(List<String> values) {
            addCriterion("log_method not in", values, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodBetween(String value1, String value2) {
            addCriterion("log_method between", value1, value2, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodNotBetween(String value1, String value2) {
            addCriterion("log_method not between", value1, value2, "logMethod");
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