package edu.nwafu.paper.service.impl;

import com.github.pagehelper.PageHelper;
import edu.nwafu.paper.beans.QuesAndAns;
import edu.nwafu.paper.mapper.QuesAndAnsMapper;
import edu.nwafu.paper.module.BaseRequest;
import edu.nwafu.paper.module.UpdateRequest;
import edu.nwafu.paper.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuesAndAnsService implements ItemService {

    @Autowired
    private QuesAndAnsMapper quesAndAnsMapper;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private KnowledgePointService knowledgePointService;

    @Override
    public List getItems(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<QuesAndAns> items = quesAndAnsMapper.selectAll();
        if (null != items) {
            return items;
        }
        return null;
    }

    @Override
    public void insert(BaseRequest request) {
        QuesAndAns quesAndAns = new QuesAndAns();
        quesAndAns.setDifficult(request.getDifficult());
        quesAndAns.setCourseId(request.getCourseId());
        quesAndAns.setPointId(request.getPointId());
        quesAndAns.setQuestion(request.getQuestion());
        quesAndAns.setAnswer(request.getAnswer());
        quesAndAns.setFaq(request.getFaq());
        quesAndAns.setScore(request.getScore());
        quesAndAnsMapper.insertSelective(quesAndAns);
    }

    @Override
    public void delete(Integer id) {
        quesAndAnsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(String str) {
        String[] ids = str.split(",");
        for (int i = 0; i < ids.length; i++) {
            quesAndAnsMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    @Override
    public void update(UpdateRequest request) {
        QuesAndAns quesAndAns = quesAndAnsMapper.selectByPrimaryKey(request.getId());
        quesAndAns.setDifficult(request.getDifficult());
        quesAndAns.setCourseId(request.getCourseId());
        quesAndAns.setPointId(request.getPointId());
        quesAndAns.setQuestion(request.getQuestion());
        quesAndAns.setAnswer(request.getAnswer());
        quesAndAns.setFaq(request.getFaq());
        quesAndAnsMapper.updateByPrimaryKeySelective(quesAndAns);
    }

    public List getQuesAndAnsQuestions(){
        List<QuesAndAns> list = quesAndAnsMapper.selectAll();
        List<Map> mapList = new ArrayList<>();
        for (QuesAndAns quesAndAns : list){
            Map map = new HashMap();
            map.put("id",quesAndAns.getId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(quesAndAns.getPointId()).getName());
            map.put("courseId",chapterService.getChapter(quesAndAns.getCourseId()).getName());
            map.put("question",quesAndAns.getQuestion());
            map.put("answer",quesAndAns.getAnswer());
            map.put("faq",quesAndAns.getFaq());
            map.put("score",quesAndAns.getScore());
            map.put("usageCount",quesAndAns.getUsageCount());
            map.put("difficult",quesAndAns.getDifficult());
            mapList.add(map);
        }
        return mapList;
    }

    public List getQuesAndAnsQuestionsByChapter(Integer chapter){
        List<QuesAndAns> list = quesAndAnsMapper.selectByChapter(chapter);
        List<Map> mapList = new ArrayList<>();
        for (QuesAndAns quesAndAns : list){
            Map map = new HashMap();
            map.put("id",quesAndAns.getId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(quesAndAns.getPointId()).getName());
            map.put("courseId",chapterService.getChapter(quesAndAns.getCourseId()).getName());
            map.put("question",quesAndAns.getQuestion());
            map.put("answer",quesAndAns.getAnswer());
            map.put("faq",quesAndAns.getFaq());
            map.put("score",quesAndAns.getScore());
            map.put("usageCount",quesAndAns.getUsageCount());
            map.put("difficult",quesAndAns.getDifficult());
            mapList.add(map);
        }
        return mapList;
    }

    public List getQuesAndAnsQuestionsByPoint(Integer point){
        List<QuesAndAns> list = quesAndAnsMapper.selectByPoint(point);
        List<Map> mapList = new ArrayList<>();
        for (QuesAndAns quesAndAns : list){
            Map map = new HashMap();
            map.put("id",quesAndAns.getId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(quesAndAns.getPointId()).getName());
            map.put("courseId",chapterService.getChapter(quesAndAns.getCourseId()).getName());
            map.put("question",quesAndAns.getQuestion());
            map.put("answer",quesAndAns.getAnswer());
            map.put("faq",quesAndAns.getFaq());
            map.put("score",quesAndAns.getScore());
            map.put("usageCount",quesAndAns.getUsageCount());
            map.put("difficult",quesAndAns.getDifficult());
            mapList.add(map);
        }
        return mapList;
    }

    public QuesAndAns getQuesAndAnsById(int id) {
        return quesAndAnsMapper.selectByPrimaryKey(id);
    }

    public int increaseUseCount(int id) {
        return quesAndAnsMapper.increaseUseCount(id);
    }
}
