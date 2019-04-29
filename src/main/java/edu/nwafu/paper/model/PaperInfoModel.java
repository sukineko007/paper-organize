package edu.nwafu.paper.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TinChiWay
 * @data 2018/5/4
 */
public class PaperInfoModel {

    List<SingleChoicViewModel> singleChoicList = new ArrayList<>();
    List<MultipleChoiceViewModel> multipleChoicList = new ArrayList<>();
    List<FillBlankViewModel> fillBlankList = new ArrayList<>();
    List<TrueOrFalseViewModel>trueOrFalseList = new ArrayList<>();
    List<QuesAndAnsViewModel>quesAndAnsList = new ArrayList<>();
    int singleChoicScore = 0;
    int multipleChoicScore = 0;
    int fillBlankScore = 0;
    int trueOrFalseScore = 0;
    int quesAndAnsScore = 0;
    int sumScore = 0;

    int knowlageNum = 0;

    int hardNum = 0;
    int normalNum = 0;
    int easynum = 0;

    public void addSingChioice(SingleChoicViewModel model) {
        this.singleChoicList.add(model);
        this.singleChoicScore += model.getScore();
        this.sumScore += model.getScore();
        int difficult = Integer.valueOf(model.getDifficult());
        addDifficultParam(difficult);
    }

    private void addDifficultParam(int difficult) {
        if (difficult < 3){
            easynum ++;
        }else if (difficult >4){
            hardNum++;
        }else {
            normalNum++;
        }
    }

    public void addMultipleChoice(MultipleChoiceViewModel model) {
        this.multipleChoicList.add(model);
        this.multipleChoicScore += model.getScore();
        this.sumScore += model.getScore();

        int difficult = model.getDifficult();
        addDifficultParam(difficult);
    }

    public void addFillBlank(FillBlankViewModel model) {
        this.fillBlankList.add(model);
        this.fillBlankScore += model.getScore();
        this.sumScore += model.getScore();

        int difficult = model.getDifficult();
        addDifficultParam(difficult);
    }

    public void addTrueOrFalse(TrueOrFalseViewModel model) {
        this.trueOrFalseList.add(model);
        this.trueOrFalseScore += model.getScore();
        this.sumScore += model.getScore();

        int difficult = model.getDifficult();
        addDifficultParam(difficult);
    }

    public void addQuesAndAns(QuesAndAnsViewModel model) {
        this.quesAndAnsList.add(model);
        this.quesAndAnsScore += model.getScore();
        this.sumScore += model.getScore();

        int difficult = model.getDifficult();
        addDifficultParam(difficult);
    }

    public int getSumScore() {
        return sumScore;
    }

    public void setSumScore(int sumScore) {
        this.sumScore = sumScore;
    }

    public List<SingleChoicViewModel> getSingleChoicList() {
        return singleChoicList;
    }

    public void setSingleChoicList(List<SingleChoicViewModel> singleChoicList) {
        this.singleChoicList = singleChoicList;
    }

    public List<MultipleChoiceViewModel> getMultipleChoicList() {
        return multipleChoicList;
    }

    public void setMultipleChoicList(List<MultipleChoiceViewModel> multipleChoicList) {
        this.multipleChoicList = multipleChoicList;
    }

    public List<FillBlankViewModel> getFillBlankList() {
        return fillBlankList;
    }

    public void setFillBlankList(List<FillBlankViewModel> fillBlankList) {
        this.fillBlankList = fillBlankList;
    }

    public List<TrueOrFalseViewModel> getTrueOrFalseList() {
        return trueOrFalseList;
    }

    public void setTrueOrFalseList(List<TrueOrFalseViewModel> trueOrFalseList) {
        this.trueOrFalseList = trueOrFalseList;
    }

    public List<QuesAndAnsViewModel> getQuesAndAnsList() {
        return quesAndAnsList;
    }

    public void setQuesAndAnsList(List<QuesAndAnsViewModel> quesAndAnsList) {
        this.quesAndAnsList = quesAndAnsList;
    }

    public int getSingleChoicScore() {
        return singleChoicScore;
    }

    public void setSingleChoicScore(int singleChoicScore) {
        this.singleChoicScore = singleChoicScore;
    }

    public int getMultipleChoicScore() {
        return multipleChoicScore;
    }

    public void setMultipleChoicScore(int multipleChoicScore) {
        this.multipleChoicScore = multipleChoicScore;
    }

    public int getFillBlankScore() {
        return fillBlankScore;
    }

    public void setFillBlankScore(int fillBlankScore) {
        this.fillBlankScore = fillBlankScore;
    }

    public int getTrueOrFalseScore() {
        return trueOrFalseScore;
    }

    public void setTrueOrFalseScore(int trueOrFalseScore) {
        this.trueOrFalseScore = trueOrFalseScore;
    }

    public int getQuesAndAnsScore() {
        return quesAndAnsScore;
    }

    public void setQuesAndAnsScore(int quesAndAnsScore) {
        this.quesAndAnsScore = quesAndAnsScore;
    }

    public int getKnowlageNum() {
        return knowlageNum;
    }

    public void setKnowlageNum(int knowlageNum) {
        this.knowlageNum = knowlageNum;
    }

    public int getHardNum() {
        return hardNum;
    }

    public void setHardNum(int hardNum) {
        this.hardNum = hardNum;
    }

    public int getNormalNum() {
        return normalNum;
    }

    public void setNormalNum(int normalNum) {
        this.normalNum = normalNum;
    }

    public int getEasynum() {
        return easynum;
    }

    public void setEasynum(int easynum) {
        this.easynum = easynum;
    }
    //    @Override
//    public String toString() {
//        return "PaperInfoModel{" +
//                "singleChoicList=" + singleChoicList +
//                ", multipleChoicList=" + multipleChoicList +
//                ", fillBlankList=" + fillBlankList +
//                ", trueOrFalseList=" + trueOrFalseList +
//                ", quesAndAnsList=" + quesAndAnsList +
//                ", singleChoicScore=" + singleChoicScore +
//                ", multipleChoicScore=" + multipleChoicScore +
//                ", fillBlankScore=" + fillBlankScore +
//                ", trueOrFalseScore=" + trueOrFalseScore +
//                ", quesAndAnsScore=" + quesAndAnsScore +
//                ", sumScore=" + sumScore +
//                '}';
//    }
}
