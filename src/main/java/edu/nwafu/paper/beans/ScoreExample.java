package edu.nwafu.paper.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScoreExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStuidIsNull() {
            addCriterion("stuid is null");
            return (Criteria) this;
        }

        public Criteria andStuidIsNotNull() {
            addCriterion("stuid is not null");
            return (Criteria) this;
        }

        public Criteria andStuidEqualTo(Integer value) {
            addCriterion("stuid =", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotEqualTo(Integer value) {
            addCriterion("stuid <>", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidGreaterThan(Integer value) {
            addCriterion("stuid >", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stuid >=", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidLessThan(Integer value) {
            addCriterion("stuid <", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidLessThanOrEqualTo(Integer value) {
            addCriterion("stuid <=", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidIn(List<Integer> values) {
            addCriterion("stuid in", values, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotIn(List<Integer> values) {
            addCriterion("stuid not in", values, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidBetween(Integer value1, Integer value2) {
            addCriterion("stuid between", value1, value2, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotBetween(Integer value1, Integer value2) {
            addCriterion("stuid not between", value1, value2, "stuid");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNull() {
            addCriterion("classname is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("classname is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("classname =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("classname <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("classname >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("classname >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("classname <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("classname <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("classname like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("classname not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("classname in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("classname not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("classname between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("classname not between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNull() {
            addCriterion("teacher is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNotNull() {
            addCriterion("teacher is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEqualTo(String value) {
            addCriterion("teacher =", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotEqualTo(String value) {
            addCriterion("teacher <>", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThan(String value) {
            addCriterion("teacher >", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("teacher >=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThan(String value) {
            addCriterion("teacher <", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThanOrEqualTo(String value) {
            addCriterion("teacher <=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLike(String value) {
            addCriterion("teacher like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotLike(String value) {
            addCriterion("teacher not like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherIn(List<String> values) {
            addCriterion("teacher in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotIn(List<String> values) {
            addCriterion("teacher not in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherBetween(String value1, String value2) {
            addCriterion("teacher between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotBetween(String value1, String value2) {
            addCriterion("teacher not between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPtypeIsNull() {
            addCriterion("ptype is null");
            return (Criteria) this;
        }

        public Criteria andPtypeIsNotNull() {
            addCriterion("ptype is not null");
            return (Criteria) this;
        }

        public Criteria andPtypeEqualTo(String value) {
            addCriterion("ptype =", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeNotEqualTo(String value) {
            addCriterion("ptype <>", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeGreaterThan(String value) {
            addCriterion("ptype >", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeGreaterThanOrEqualTo(String value) {
            addCriterion("ptype >=", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeLessThan(String value) {
            addCriterion("ptype <", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeLessThanOrEqualTo(String value) {
            addCriterion("ptype <=", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeLike(String value) {
            addCriterion("ptype like", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeNotLike(String value) {
            addCriterion("ptype not like", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeIn(List<String> values) {
            addCriterion("ptype in", values, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeNotIn(List<String> values) {
            addCriterion("ptype not in", values, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeBetween(String value1, String value2) {
            addCriterion("ptype between", value1, value2, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeNotBetween(String value1, String value2) {
            addCriterion("ptype not between", value1, value2, "ptype");
            return (Criteria) this;
        }

        public Criteria andTestNumberIsNull() {
            addCriterion("test_number is null");
            return (Criteria) this;
        }

        public Criteria andTestNumberIsNotNull() {
            addCriterion("test_number is not null");
            return (Criteria) this;
        }

        public Criteria andTestNumberEqualTo(Integer value) {
            addCriterion("test_number =", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberNotEqualTo(Integer value) {
            addCriterion("test_number <>", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberGreaterThan(Integer value) {
            addCriterion("test_number >", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_number >=", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberLessThan(Integer value) {
            addCriterion("test_number <", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberLessThanOrEqualTo(Integer value) {
            addCriterion("test_number <=", value, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberIn(List<Integer> values) {
            addCriterion("test_number in", values, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberNotIn(List<Integer> values) {
            addCriterion("test_number not in", values, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberBetween(Integer value1, Integer value2) {
            addCriterion("test_number between", value1, value2, "testNumber");
            return (Criteria) this;
        }

        public Criteria andTestNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("test_number not between", value1, value2, "testNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Integer value) {
            addCriterion("question_id =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Integer value) {
            addCriterion("question_id <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(Integer value) {
            addCriterion("question_id >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_id >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Integer value) {
            addCriterion("question_id <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Integer value) {
            addCriterion("question_id <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Integer> values) {
            addCriterion("question_id in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Integer> values) {
            addCriterion("question_id not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Integer value1, Integer value2) {
            addCriterion("question_id between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("question_id not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreIsNull() {
            addCriterion("question_score is null");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreIsNotNull() {
            addCriterion("question_score is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreEqualTo(Float value) {
            addCriterion("question_score =", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreNotEqualTo(Float value) {
            addCriterion("question_score <>", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreGreaterThan(Float value) {
            addCriterion("question_score >", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("question_score >=", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreLessThan(Float value) {
            addCriterion("question_score <", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreLessThanOrEqualTo(Float value) {
            addCriterion("question_score <=", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreIn(List<Float> values) {
            addCriterion("question_score in", values, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreNotIn(List<Float> values) {
            addCriterion("question_score not in", values, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreBetween(Float value1, Float value2) {
            addCriterion("question_score between", value1, value2, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreNotBetween(Float value1, Float value2) {
            addCriterion("question_score not between", value1, value2, "questionScore");
            return (Criteria) this;
        }

        public Criteria andHadScoreIsNull() {
            addCriterion("had_score is null");
            return (Criteria) this;
        }

        public Criteria andHadScoreIsNotNull() {
            addCriterion("had_score is not null");
            return (Criteria) this;
        }

        public Criteria andHadScoreEqualTo(Float value) {
            addCriterion("had_score =", value, "hadScore");
            return (Criteria) this;
        }

        public Criteria andHadScoreNotEqualTo(Float value) {
            addCriterion("had_score <>", value, "hadScore");
            return (Criteria) this;
        }

        public Criteria andHadScoreGreaterThan(Float value) {
            addCriterion("had_score >", value, "hadScore");
            return (Criteria) this;
        }

        public Criteria andHadScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("had_score >=", value, "hadScore");
            return (Criteria) this;
        }

        public Criteria andHadScoreLessThan(Float value) {
            addCriterion("had_score <", value, "hadScore");
            return (Criteria) this;
        }

        public Criteria andHadScoreLessThanOrEqualTo(Float value) {
            addCriterion("had_score <=", value, "hadScore");
            return (Criteria) this;
        }

        public Criteria andHadScoreIn(List<Float> values) {
            addCriterion("had_score in", values, "hadScore");
            return (Criteria) this;
        }

        public Criteria andHadScoreNotIn(List<Float> values) {
            addCriterion("had_score not in", values, "hadScore");
            return (Criteria) this;
        }

        public Criteria andHadScoreBetween(Float value1, Float value2) {
            addCriterion("had_score between", value1, value2, "hadScore");
            return (Criteria) this;
        }

        public Criteria andHadScoreNotBetween(Float value1, Float value2) {
            addCriterion("had_score not between", value1, value2, "hadScore");
            return (Criteria) this;
        }

        public Criteria andTestTimesIsNull() {
            addCriterion("test_times is null");
            return (Criteria) this;
        }

        public Criteria andTestTimesIsNotNull() {
            addCriterion("test_times is not null");
            return (Criteria) this;
        }

        public Criteria andTestTimesEqualTo(Integer value) {
            addCriterion("test_times =", value, "testTimes");
            return (Criteria) this;
        }

        public Criteria andTestTimesNotEqualTo(Integer value) {
            addCriterion("test_times <>", value, "testTimes");
            return (Criteria) this;
        }

        public Criteria andTestTimesGreaterThan(Integer value) {
            addCriterion("test_times >", value, "testTimes");
            return (Criteria) this;
        }

        public Criteria andTestTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_times >=", value, "testTimes");
            return (Criteria) this;
        }

        public Criteria andTestTimesLessThan(Integer value) {
            addCriterion("test_times <", value, "testTimes");
            return (Criteria) this;
        }

        public Criteria andTestTimesLessThanOrEqualTo(Integer value) {
            addCriterion("test_times <=", value, "testTimes");
            return (Criteria) this;
        }

        public Criteria andTestTimesIn(List<Integer> values) {
            addCriterion("test_times in", values, "testTimes");
            return (Criteria) this;
        }

        public Criteria andTestTimesNotIn(List<Integer> values) {
            addCriterion("test_times not in", values, "testTimes");
            return (Criteria) this;
        }

        public Criteria andTestTimesBetween(Integer value1, Integer value2) {
            addCriterion("test_times between", value1, value2, "testTimes");
            return (Criteria) this;
        }

        public Criteria andTestTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("test_times not between", value1, value2, "testTimes");
            return (Criteria) this;
        }

        public Criteria andTestTimeIsNull() {
            addCriterion("test_time is null");
            return (Criteria) this;
        }

        public Criteria andTestTimeIsNotNull() {
            addCriterion("test_time is not null");
            return (Criteria) this;
        }

        public Criteria andTestTimeEqualTo(Integer value) {
            addCriterion("test_time =", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeNotEqualTo(Integer value) {
            addCriterion("test_time <>", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeGreaterThan(Integer value) {
            addCriterion("test_time >", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_time >=", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeLessThan(Integer value) {
            addCriterion("test_time <", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeLessThanOrEqualTo(Integer value) {
            addCriterion("test_time <=", value, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeIn(List<Integer> values) {
            addCriterion("test_time in", values, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeNotIn(List<Integer> values) {
            addCriterion("test_time not in", values, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeBetween(Integer value1, Integer value2) {
            addCriterion("test_time between", value1, value2, "testTime");
            return (Criteria) this;
        }

        public Criteria andTestTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("test_time not between", value1, value2, "testTime");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidIsNull() {
            addCriterion("knowledge_pointid is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidIsNotNull() {
            addCriterion("knowledge_pointid is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidEqualTo(Integer value) {
            addCriterion("knowledge_pointid =", value, "knowledgePointid");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidNotEqualTo(Integer value) {
            addCriterion("knowledge_pointid <>", value, "knowledgePointid");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidGreaterThan(Integer value) {
            addCriterion("knowledge_pointid >", value, "knowledgePointid");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidGreaterThanOrEqualTo(Integer value) {
            addCriterion("knowledge_pointid >=", value, "knowledgePointid");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidLessThan(Integer value) {
            addCriterion("knowledge_pointid <", value, "knowledgePointid");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidLessThanOrEqualTo(Integer value) {
            addCriterion("knowledge_pointid <=", value, "knowledgePointid");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidIn(List<Integer> values) {
            addCriterion("knowledge_pointid in", values, "knowledgePointid");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidNotIn(List<Integer> values) {
            addCriterion("knowledge_pointid not in", values, "knowledgePointid");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidBetween(Integer value1, Integer value2) {
            addCriterion("knowledge_pointid between", value1, value2, "knowledgePointid");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointidNotBetween(Integer value1, Integer value2) {
            addCriterion("knowledge_pointid not between", value1, value2, "knowledgePointid");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameIsNull() {
            addCriterion("knowledge_pointname is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameIsNotNull() {
            addCriterion("knowledge_pointname is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameEqualTo(String value) {
            addCriterion("knowledge_pointname =", value, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameNotEqualTo(String value) {
            addCriterion("knowledge_pointname <>", value, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameGreaterThan(String value) {
            addCriterion("knowledge_pointname >", value, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameGreaterThanOrEqualTo(String value) {
            addCriterion("knowledge_pointname >=", value, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameLessThan(String value) {
            addCriterion("knowledge_pointname <", value, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameLessThanOrEqualTo(String value) {
            addCriterion("knowledge_pointname <=", value, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameLike(String value) {
            addCriterion("knowledge_pointname like", value, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameNotLike(String value) {
            addCriterion("knowledge_pointname not like", value, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameIn(List<String> values) {
            addCriterion("knowledge_pointname in", values, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameNotIn(List<String> values) {
            addCriterion("knowledge_pointname not in", values, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameBetween(String value1, String value2) {
            addCriterion("knowledge_pointname between", value1, value2, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andKnowledgePointnameNotBetween(String value1, String value2) {
            addCriterion("knowledge_pointname not between", value1, value2, "knowledgePointname");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(Date value) {
            addCriterionForJDBCDate("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(Date value) {
            addCriterionForJDBCDate("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(Date value) {
            addCriterionForJDBCDate("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(Date value) {
            addCriterionForJDBCDate("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<Date> values) {
            addCriterionForJDBCDate("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<Date> values) {
            addCriterionForJDBCDate("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rate not between", value1, value2, "rate");
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