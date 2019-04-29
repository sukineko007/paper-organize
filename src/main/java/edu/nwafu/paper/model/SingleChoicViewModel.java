package edu.nwafu.paper.model;

import edu.nwafu.paper.beans.SingleChoic;


public class SingleChoicViewModel {

    private int  serialNumber;
    private int id;
    private String question;
    private String answer;
    private int score;
    private String a;
    private String b;
    private String c;
    private String d;
    private int difficult;


    public SingleChoicViewModel(SingleChoic singleChoic) {
        this.question = singleChoic.getQuestion();
        this.answer = singleChoic.getAnswer();
        this.score = singleChoic.getScore();
        this.id = singleChoic.getId();
        this.a = singleChoic.getA();
        this.b = singleChoic.getB();
        this.c = singleChoic.getC();
        this.d = singleChoic.getD();
        this.difficult = Integer.valueOf(singleChoic.getDifficult());
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }
}