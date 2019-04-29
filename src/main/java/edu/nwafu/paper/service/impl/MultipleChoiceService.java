package edu.nwafu.paper.service.impl;

import edu.nwafu.paper.beans.MultipleChoice;
import edu.nwafu.paper.mapper.MultipleChoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TinChiWay
 * @data 2018/5/4
 */
@Service
public class MultipleChoiceService {

    @Autowired
    private MultipleChoiceMapper multipleChoiceMapper;

    @Autowired
    private KnowledgePointService knowledgePointService;

    @Autowired
    private ChapterService chapterService;

    public List getMultipleQuestions() {
        List<MultipleChoice> list = multipleChoiceMapper.selectAll();
        List<Map> listMap = new ArrayList<>();
        for (MultipleChoice multipleChoice : list){
            Map map = new HashMap();
            map.put("id", multipleChoice.getId());
            map.put("courseId",chapterService.getChapter(multipleChoice.getCourseId()).getName());
            map.put("question", multipleChoice.getQuestion());
            map.put("answer", multipleChoice.getAnswer());
            map.put("score",multipleChoice.getScore());
            map.put("usageCount",multipleChoice.getUsageCount());
            map.put("faq",multipleChoice.getFaq());
            map.put("difficult",multipleChoice.getDifficult());
            map.put("chapter",multipleChoice.getCourseId());
            //map.put("knowledge",multipleChoice.getPointId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(multipleChoice.getPointId()).getName());
            map.put("optioncontent",multipleChoice.getA()+";"+multipleChoice.getB()+";"+ multipleChoice.getC()+";"+multipleChoice.getD()+";"+multipleChoice.getE());
            listMap.add(map);
        }
        return listMap;

    }

    public List getMultipleQuestionsByChapter(Integer chapter) {
        List<MultipleChoice> list = multipleChoiceMapper.selectByChapter(chapter);
        List<Map> listMap = new ArrayList<>();
        for (MultipleChoice multipleChoice : list){
            Map map = new HashMap();
            map.put("id", multipleChoice.getId());
            map.put("courseId",chapterService.getChapter(multipleChoice.getCourseId()).getName());
            map.put("question", multipleChoice.getQuestion());
            map.put("answer", multipleChoice.getAnswer());
            map.put("score",multipleChoice.getScore());
            map.put("usageCount",multipleChoice.getUsageCount());
            map.put("faq",multipleChoice.getFaq());
            map.put("difficult",multipleChoice.getDifficult());
            map.put("chapter",multipleChoice.getCourseId());
            //map.put("knowledge",multipleChoice.getPointId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(multipleChoice.getPointId()).getName());
            map.put("optioncontent",multipleChoice.getA()+";"+multipleChoice.getB()+";"+ multipleChoice.getC()+";"+multipleChoice.getD()+";"+multipleChoice.getE());
            listMap.add(map);
        }
        return listMap;

    }

    public List getMultipleQuestionsByPoint(Integer point) {
        List<MultipleChoice> list = multipleChoiceMapper.selectByPoint(point);
        List<Map> listMap = new ArrayList<>();
        for (MultipleChoice multipleChoice : list){
            Map map = new HashMap();
            map.put("id", multipleChoice.getId());
            map.put("courseId",chapterService.getChapter(multipleChoice.getCourseId()).getName());
            map.put("question", multipleChoice.getQuestion());
            map.put("answer", multipleChoice.getAnswer());
            map.put("score",multipleChoice.getScore());
            map.put("usageCount",multipleChoice.getUsageCount());
            map.put("faq",multipleChoice.getFaq());
            map.put("difficult",multipleChoice.getDifficult());
            map.put("chapter",multipleChoice.getCourseId());
            //map.put("knowledge",multipleChoice.getPointId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(multipleChoice.getPointId()).getName());
            map.put("optioncontent",multipleChoice.getA()+";"+multipleChoice.getB()+";"+ multipleChoice.getC()+";"+multipleChoice.getD()+";"+multipleChoice.getE());
            listMap.add(map);
        }
        return listMap;

    }

    public MultipleChoice getMultipleById(int id) {
        return multipleChoiceMapper.selectByPrimaryKey(id);
    }

    public int increaseUseCount(int id) {
        return multipleChoiceMapper.increaseUseCount(id);
    }
}
