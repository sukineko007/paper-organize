package edu.nwafu.paper.model;

import edu.nwafu.paper.beans.QuesAndAns;

/**
 * @author TinChiWay
 * @data 2018/5/4
 */
public class QuesAndAnsViewModel {
    private int difficult;
    private int id;
    private int  serialNumber;
    private String question;
    private String answer;
    private int score;

    public QuesAndAnsViewModel(QuesAndAns quesAndAns) {
        this.id = quesAndAns.getId();
        this.question = quesAndAns.getQuestion();
        this.answer = quesAndAns.getAnswer();
        this.score = quesAndAns.getScore();
        this.difficult = Integer.valueOf(quesAndAns.getDifficult());

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
