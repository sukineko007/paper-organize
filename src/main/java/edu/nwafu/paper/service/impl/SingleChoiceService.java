package edu.nwafu.paper.service.impl;

import edu.nwafu.paper.beans.SingleChoic;
import edu.nwafu.paper.mapper.SingleChoicMapper;
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
public class SingleChoiceService {
    @Autowired
    private SingleChoicMapper singleChoicMapper;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private KnowledgePointService knowledgePointService;

    public List getSingleQuestions(){
        List<SingleChoic> list = singleChoicMapper.selectAll();
        List<Map> listMap = new ArrayList<>();
        for (SingleChoic singleChoic : list){
            Map map = new HashMap();
            map.put("id", singleChoic.getId());
            map.put("question", singleChoic.getQuestion());
            map.put("A",singleChoic.getA());
            map.put("B",singleChoic.getB());
            map.put("C",singleChoic.getC());
            map.put("D",singleChoic.getD());
            map.put("courseId",chapterService.getChapter(singleChoic.getCourseId()).getName());
            map.put("answer", singleChoic.getAnswer());
            map.put("score",singleChoic.getScore());
            map.put("usageCount",singleChoic.getUsageCount());
            map.put("faq",singleChoic.getFaq());
            map.put("difficult",singleChoic.getDifficult());
            //map.put("knowledge","冯诺依曼");
            map.put("knowledge",knowledgePointService.getKonwledgeById(singleChoic.getPointId()).getName());
            map.put("optioncontent","A."+singleChoic.getA()+";B."+singleChoic.getB()+";C."+ singleChoic.getC()+";D."+singleChoic.getD());
            map.put("create_time",singleChoic.getCreateTime());
            map.put("point_id",singleChoic.getPointId());
            map.put("chapter",singleChoic.getCourseId());
            listMap.add(map);
        }
        return listMap;
    }

    public List getSingleQuestionsByChapter(Integer chapter){
        List<SingleChoic> list = singleChoicMapper.selectByChapter(chapter);
        List<Map> listMap = new ArrayList<>();
        for (SingleChoic singleChoic : list){
            Map map = new HashMap();
            map.put("id", singleChoic.getId());
            map.put("question", singleChoic.getQuestion());
            map.put("A",singleChoic.getA());
            map.put("B",singleChoic.getB());
            map.put("C",singleChoic.getC());
            map.put("D",singleChoic.getD());
            map.put("courseId",chapterService.getChapter(singleChoic.getCourseId()).getName());
            map.put("answer", singleChoic.getAnswer());
            map.put("score",singleChoic.getScore());
            map.put("usageCount",singleChoic.getUsageCount());
            map.put("faq",singleChoic.getFaq());
            map.put("difficult",singleChoic.getDifficult());
            //map.put("knowledge","冯诺依曼");
            map.put("knowledge",knowledgePointService.getKonwledgeById(singleChoic.getPointId()).getName());
            map.put("optioncontent","A."+singleChoic.getA()+";B."+singleChoic.getB()+";C."+ singleChoic.getC()+";D."+singleChoic.getD());
            map.put("create_time",singleChoic.getCreateTime());
            map.put("point_id",singleChoic.getPointId());
            map.put("chapter",singleChoic.getCourseId());
            listMap.add(map);
        }
        return listMap;
    }

    public List getSingleQuestionsByPoint(Integer point){
        List<SingleChoic> list = singleChoicMapper.selectByPoint(point);
        List<Map> listMap = new ArrayList<>();
        for (SingleChoic singleChoic : list){
            Map map = new HashMap();
            map.put("id", singleChoic.getId());
            map.put("question", singleChoic.getQuestion());
            map.put("A",singleChoic.getA());
            map.put("B",singleChoic.getB());
            map.put("C",singleChoic.getC());
            map.put("D",singleChoic.getD());
            map.put("courseId",chapterService.getChapter(singleChoic.getCourseId()).getName());
            map.put("answer", singleChoic.getAnswer());
            map.put("score",singleChoic.getScore());
            map.put("usageCount",singleChoic.getUsageCount());
            map.put("faq",singleChoic.getFaq());
            map.put("difficult",singleChoic.getDifficult());
            //map.put("knowledge","冯诺依曼");
            map.put("knowledge",knowledgePointService.getKonwledgeById(singleChoic.getPointId()).getName());
            map.put("optioncontent","A."+singleChoic.getA()+";B."+singleChoic.getB()+";C."+ singleChoic.getC()+";D."+singleChoic.getD());
            map.put("create_time",singleChoic.getCreateTime());
            map.put("point_id",singleChoic.getPointId());
            map.put("chapter",singleChoic.getCourseId());
            listMap.add(map);
        }
        return listMap;
    }

    public SingleChoic getSingleById(int id) {
        return singleChoicMapper.selectByPrimaryKey(id);
    }

    public int increaseUseCount(int id) {
        return singleChoicMapper.increaseUseCount(id);
    }
}
