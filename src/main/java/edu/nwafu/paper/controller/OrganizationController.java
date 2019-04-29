package edu.nwafu.paper.controller;

import edu.nwafu.paper.beans.Paper;
import edu.nwafu.paper.beans.PaperInfo;
import edu.nwafu.paper.model.AddPaperListModel;
import edu.nwafu.paper.service.impl.*;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TinChiWay
 * @data 2018/5/4
 */
@RestController
@RequestMapping("/paperorganize")
public class OrganizationController {

    @Autowired
    private SingleChoiceService singleChoiceService;

    @Autowired
    private MultipleChoiceService multipleChoiceService;

    @Autowired
    private FillBlankService fillBlankService;

    @Autowired
    private TrueOrFalseService trueOrFalseServicel;

    @Autowired
    private QuesAndAnsService quesAndAnsService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperInfoService paperInfoService;
    @GetMapping("/baidu")
    public Object baidu(@RequestBody AddPaperListModel questlist){
        int map = questlist.getUserid();
        return map;

    }

    @GetMapping("/getQuestions")
    public Object getQuestions(Integer type) {
        Map<String, Object> map = new HashMap<>();
        if (type == 10001) {
            map.put("stat", "ok");
            map.put("data", singleChoiceService.getSingleQuestions());
            return map;
        } else if (type == 10002) {
            map.put("data", multipleChoiceService.getMultipleQuestions());
            map.put("stat", "ok");
            return map;
        } else if (type == 10003) {
            map.put("data", fillBlankService.getFillBlankQuestion());
            map.put("stat", "ok");
            return map;
        } else if (type == 10004) {
            map.put("data", trueOrFalseServicel.getTrueOrFalseQuestion());
            map.put("stat", "ok");
            return map;
        } else if (type == 10005) {
            map.put("data", quesAndAnsService.getQuesAndAnsQuestions());
            map.put("stat", "ok");
            return map;
        } else {
            return map.put("stat", "no");
        }

    }


    @PostMapping("/addpaper")
    public Object addPaper(@RequestBody AddPaperListModel questlist) {

        int userId = 1001;
        String papername = questlist.getName();
        List<Integer> singleIds = questlist.getSingleSelect();
        List<Integer> multipleIds = questlist.getMultipleSelect();
        List<Integer> fillBlankIds = questlist.getFillblank();
        List<Integer> trueOrFalseIds = questlist.getTureorfalse();
        List<Integer> quesAndAnsIds = questlist.getQuesAndAns();

        List<PaperInfo> paperInfoList = new ArrayList<>();

        //试卷总分
       int source = addQuestionsToList(paperInfoList, singleIds, multipleIds, fillBlankIds, trueOrFalseIds, quesAndAnsIds);

        if (source != 100){
            return new JSONObject().element("stat","no").element("msg","满分不为100，请重新选题");
        }

        int paperId = addPaper(userId, papername);
        addPaperAndSerialnumIntoPaperInfoList(paperId, paperInfoList);

        int res = paperInfoService.insertList(paperInfoList);

        if (res > 0) {
            return new JSONObject().element("stat", "ok").element("msg","试卷" + papername + "生成成功");
        } else {
            return new JSONObject().element("stat","no").element("msg","创建试卷失败");
        }
    }

    private void addPaperAndSerialnumIntoPaperInfoList(int paperId, List<PaperInfo> paperInfoList) {
        int serialnum = 1;

        for (PaperInfo paperInfo : paperInfoList){
            paperInfo.setPaperId(paperId);
            paperInfo.setSerialNumber(serialnum);
            serialnum++;
        }
    }

    private int addPaper(int userId, String papername) {
        //插入paper
        System.out.println(userId);
        Paper paper = new Paper();
        paper.setCreatorId(userId);
        paper.setName(papername);
        paperService.insertSelective(paper);
        return paper.getId();
    }


    /**
     *
     * @param paperInfoList
     * @param singleIds
     * @param multipleIds
     * @param fillBlankIds
     * @param trueOrFalseIds
     * @param quesAndAnsIds
     * @return 试题的总分
     */
    private int addQuestionsToList(List<PaperInfo> paperInfoList, List<Integer> singleIds, List<Integer> multipleIds, List<Integer> fillBlankIds, List<Integer> trueOrFalseIds, List<Integer> quesAndAnsIds) {
        int source = 0;
        //组织单选题
        for (int questionId : singleIds) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.setTypeId(10001);
            paperInfo.setQuestionId(questionId);
            paperInfoList.add(paperInfo);

            singleChoiceService.increaseUseCount(questionId);

            //获取分数
            source += singleChoiceService.getSingleById(questionId).getScore();
        }

        //组织多选题
        for (int questionId : multipleIds) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.setTypeId(10002);
            paperInfo.setQuestionId(questionId);
            paperInfoList.add(paperInfo);

            multipleChoiceService.increaseUseCount(questionId);

            source += multipleChoiceService.getMultipleById(questionId).getScore();
        }

        //组织填空题
        for (int questionId : fillBlankIds) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.setTypeId(10003);
            paperInfo.setQuestionId(questionId);
            paperInfoList.add(paperInfo);

            fillBlankService.increaseUseCount(questionId);

            source += fillBlankService.getFillBlankById(questionId).getScore();
        }

        //组织判断题

        for (int questionId : trueOrFalseIds) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.setTypeId(10004);
            paperInfo.setQuestionId(questionId);
            paperInfoList.add(paperInfo);

            trueOrFalseServicel.increaseUseCount(questionId);

            source += trueOrFalseServicel.getTrueOrFalseById(questionId).getScore();
        }

        //组织问答题
        for (int questionId : quesAndAnsIds) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.setTypeId(10005);
            paperInfo.setQuestionId(questionId);
            paperInfoList.add(paperInfo);

            quesAndAnsService.increaseUseCount(questionId);

            source += quesAndAnsService.getQuesAndAnsById(questionId).getScore();
        }

        return source;
    }

    @PostMapping("/submitreview")
    public Object submitReview(int paperId){
        JSONObject jsonObject = new JSONObject();

        if (paperService.submitreview(paperId) != 1){
            jsonObject.element("stat","no");
            return jsonObject;
        }

        jsonObject.element("stat","yes");
        jsonObject.element("msg","提交审核成功");

        return jsonObject;

    }

    @PostMapping("/cancelreview")
    public Object cancelReview(int paperId){
        JSONObject jsonObject = new JSONObject();

        if (paperService.cancelreview(paperId) != 1){
            jsonObject.element("stat","no");
            return jsonObject;
        }

        jsonObject.element("stat","yes");
        jsonObject.element("msg","取消提交审核成功");

        return jsonObject;
    }
}
