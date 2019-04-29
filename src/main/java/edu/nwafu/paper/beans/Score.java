package edu.nwafu.paper.beans;

import java.util.Date;

public class Score {
    private Integer id;

    private Integer stuid;

    private String classname;

    private String teacher;

    private String pname;

    private String ptype;

    private Integer testNumber;

    private Integer questionId;

    private Float questionScore;

    private Float hadScore;

    private Integer testTimes;

    private Integer testTime;

    private Integer knowledgePointid;

    private String knowledgePointname;

    private Date rate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype == null ? null : ptype.trim();
    }

    public Integer getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(Integer testNumber) {
        this.testNumber = testNumber;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Float getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(Float questionScore) {
        this.questionScore = questionScore;
    }

    public Float getHadScore() {
        return hadScore;
    }

    public void setHadScore(Float hadScore) {
        this.hadScore = hadScore;
    }

    public Integer getTestTimes() {
        return testTimes;
    }

    public void setTestTimes(Integer testTimes) {
        this.testTimes = testTimes;
    }

    public Integer getTestTime() {
        return testTime;
    }

    public void setTestTime(Integer testTime) {
        this.testTime = testTime;
    }

    public Integer getKnowledgePointid() {
        return knowledgePointid;
    }

    public void setKnowledgePointid(Integer knowledgePointid) {
        this.knowledgePointid = knowledgePointid;
    }

    public String getKnowledgePointname() {
        return knowledgePointname;
    }

    public void setKnowledgePointname(String knowledgePointname) {
        this.knowledgePointname = knowledgePointname == null ? null : knowledgePointname.trim();
    }

    public Date getRate() {
        return rate;
    }

    public void setRate(Date rate) {
        this.rate = rate;
    }
}