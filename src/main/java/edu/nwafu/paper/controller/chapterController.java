package edu.nwafu.paper.controller;

import edu.nwafu.paper.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/chapter")
public class chapterController {
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

    @GetMapping("/getChapterItems")
    public Object getChapterItems(Integer type,Integer chapter){
        Map<String,Object> map = new HashMap<>();
        if (type == 10001) {
            map.put("stat", "ok");
            map.put("data", singleChoiceService.getSingleQuestionsByChapter(chapter));
            return map;
        } else if (type == 10002) {
            map.put("data", multipleChoiceService.getMultipleQuestionsByChapter(chapter));
            map.put("stat", "ok");
            return map;
        } else if (type == 10003) {
            map.put("data", fillBlankService.getFillBlankQuestionByChapter(chapter));
            map.put("stat", "ok");
            return map;
        } else if (type == 10004) {
            map.put("data", trueOrFalseServicel.getTrueOrFalseQuestionByChapter(chapter));
            map.put("stat", "ok");
            return map;
        } else if (type == 10005) {
            map.put("data", quesAndAnsService.getQuesAndAnsQuestionsByChapter(chapter));
            map.put("stat", "ok");
            return map;
        } else {
            return map.put("stat", "no");
        }
    }

    @GetMapping("/getPointItems")
    public Object getPointItems(Integer type,Integer point){
        Map<String,Object> map = new HashMap<>();
        if (type == 10001) {
            map.put("stat", "ok");
            map.put("data", singleChoiceService.getSingleQuestionsByPoint(point));
            return map;
        } else if (type == 10002) {
            map.put("data", multipleChoiceService.getMultipleQuestionsByPoint(point));
            map.put("stat", "ok");
            return map;
        } else if (type == 10003) {
            map.put("data", fillBlankService.getFillBlankQuestionByPoint(point));
            map.put("stat", "ok");
            return map;
        } else if (type == 10004) {
            map.put("data", trueOrFalseServicel.getTrueOrFalseQuestionByPoint(point));
            map.put("stat", "ok");
            return map;
        } else if (type == 10005) {
            map.put("data", quesAndAnsService.getQuesAndAnsQuestionsByPoint(point));
            map.put("stat", "ok");
            return map;
        } else {
            return map.put("stat", "no");
        }
    }
}
