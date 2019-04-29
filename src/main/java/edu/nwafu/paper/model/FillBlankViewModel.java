package edu.nwafu.paper.model;

import edu.nwafu.paper.beans.FillBlank;

/**
 * @author TinChiWay
 * @data 2018/5/4
 */
public class FillBlankViewModel {
    private int difficult;
    private int  serialNumber;
    private int id;
    private String question;
    private String answer;
    private int score;

    public FillBlankViewModel(FillBlank fillBlank) {
        this.id = fillBlank.getId();
        this.question = fillBlank.getQuestion();
        this.answer = fillBlank.getAnswer();
        this.score = fillBlank.getScore();
        this.difficult = Integer.valueOf(fillBlank.getDifficult());
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
