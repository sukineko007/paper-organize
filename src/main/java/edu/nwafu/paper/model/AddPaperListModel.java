package edu.nwafu.paper.model;

import java.util.ArrayList;

/**
 * @author TinChiWay
 * @data 2018/5/5
 */
public class AddPaperListModel {
    Integer userid;
    String name;
    ArrayList<Integer> fillblank;
    ArrayList<Integer> multipleSelect;
    ArrayList<Integer> quesAndAns;
    ArrayList<Integer> singleSelect;
    ArrayList<Integer> tureorfalse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public ArrayList<Integer> getFillblank() {
        return fillblank;
    }

    public void setFillblank(ArrayList<Integer> fillblank) {
        this.fillblank = fillblank;
    }

    public ArrayList<Integer> getMultipleSelect() {
        return multipleSelect;
    }

    public void setMultipleSelect(ArrayList<Integer> multipleSelect) {
        this.multipleSelect = multipleSelect;
    }

    public ArrayList<Integer> getQuesAndAns() {
        return quesAndAns;
    }

    public void setQuesAndAns(ArrayList<Integer> quesAndAns) {
        this.quesAndAns = quesAndAns;
    }

    public ArrayList<Integer> getSingleSelect() {
        return singleSelect;
    }

    public void setSingleSelect(ArrayList<Integer> singleSelect) {
        this.singleSelect = singleSelect;
    }

    public ArrayList<Integer> getTureorfalse() {
        return tureorfalse;
    }

    public void setTureorfalse(ArrayList<Integer> tureorfalse) {
        this.tureorfalse = tureorfalse;
    }
}
