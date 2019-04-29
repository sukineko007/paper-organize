package edu.nwafu.paper.service.impl;

import com.github.pagehelper.PageHelper;
import edu.nwafu.paper.beans.TrueOrFalse;
import edu.nwafu.paper.mapper.TrueOrFalseMapper;
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
public class TrueOrFalseService implements ItemService {

    @Autowired
    private TrueOrFalseMapper trueOrFalseMapper;

    @Autowired
    private KnowledgePointService knowledgePointService;
    @Autowired
    private ChapterService chapterService;
    @Override
    public List getItems(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TrueOrFalse> items = trueOrFalseMapper.selectAll();
        if (null != items) {
            return items;
        }
        return null;
    }

    @Override
    public void insert(BaseRequest request) {
        TrueOrFalse trueOrFalse = new TrueOrFalse();
        trueOrFalse.setDifficult(request.getDifficult());
        trueOrFalse.setCourseId(request.getCourseId());
        trueOrFalse.setPointId(request.getPointId());
        trueOrFalse.setQuestion(request.getQuestion());
        trueOrFalse.setAnswer(request.getAnswer());
        trueOrFalse.setFaq(request.getFaq());
        trueOrFalse.setScore(request.getScore());
        trueOrFalseMapper.insertSelective(trueOrFalse);
    }

    @Override
    public void delete(Integer id) {
        trueOrFalseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(String str) {
        String[] ids = str.split(",");
        for (int i = 0; i < ids.length; i++) {
            trueOrFalseMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    @Override
    public void update(UpdateRequest request) {
        TrueOrFalse trueOrFalse = trueOrFalseMapper.selectByPrimaryKey(request.getId());
        trueOrFalse.setDifficult(request.getDifficult());
        trueOrFalse.setCourseId(request.getCourseId());
        trueOrFalse.setPointId(request.getPointId());
        trueOrFalse.setQuestion(request.getQuestion());
        trueOrFalse.setAnswer(request.getAnswer());
        trueOrFalse.setFaq(request.getFaq());
        trueOrFalseMapper.updateByPrimaryKeySelective(trueOrFalse);
    }

    public List getTrueOrFalseQuestion(){
        List<TrueOrFalse> list = trueOrFalseMapper.selectAll();
        List<Map> mapList = new ArrayList<>();
        for (TrueOrFalse trueOrFalse: list) {
            Map map = new HashMap();
            map.put("id",trueOrFalse.getId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(trueOrFalse.getPointId()).getName());
            map.put("courseId",chapterService.getChapter(trueOrFalse.getCourseId()).getName());
            map.put("question",trueOrFalse.getQuestion());
            map.put("answer",trueOrFalse.getAnswer());
            map.put("faq",trueOrFalse.getFaq());
            map.put("score",trueOrFalse.getScore());
            map.put("usageCount",trueOrFalse.getUsageCount());
            map.put("difficult",trueOrFalse.getDifficult());
            mapList.add(map);
        }
        return mapList;
    }

    public List getTrueOrFalseQuestionByChapter(Integer chapter){
        List<TrueOrFalse> list = trueOrFalseMapper.selectByChapter(chapter);
        List<Map> mapList = new ArrayList<>();
        for (TrueOrFalse trueOrFalse: list) {
            Map map = new HashMap();
            map.put("id",trueOrFalse.getId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(trueOrFalse.getPointId()).getName());
            map.put("courseId",chapterService.getChapter(trueOrFalse.getCourseId()).getName());
            map.put("question",trueOrFalse.getQuestion());
            map.put("answer",trueOrFalse.getAnswer());
            map.put("faq",trueOrFalse.getFaq());
            map.put("score",trueOrFalse.getScore());
            map.put("usageCount",trueOrFalse.getUsageCount());
            map.put("difficult",trueOrFalse.getDifficult());
            mapList.add(map);
        }
        return mapList;
    }

    public List getTrueOrFalseQuestionByPoint(Integer point){
        List<TrueOrFalse> list = trueOrFalseMapper.selectByPoint(point);
        List<Map> mapList = new ArrayList<>();
        for (TrueOrFalse trueOrFalse: list) {
            Map map = new HashMap();
            map.put("id",trueOrFalse.getId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(trueOrFalse.getPointId()).getName());
            map.put("courseId",chapterService.getChapter(trueOrFalse.getCourseId()).getName());
            map.put("question",trueOrFalse.getQuestion());
            map.put("answer",trueOrFalse.getAnswer());
            map.put("faq",trueOrFalse.getFaq());
            map.put("score",trueOrFalse.getScore());
            map.put("usageCount",trueOrFalse.getUsageCount());
            map.put("difficult",trueOrFalse.getDifficult());
            mapList.add(map);
        }
        return mapList;
    }

    public TrueOrFalse getTrueOrFalseById(int id) {
        return trueOrFalseMapper.selectByPrimaryKey(id);
    }

    public int increaseUseCount(int id) {
        return trueOrFalseMapper.increaseUseCount(id);
    }
}
