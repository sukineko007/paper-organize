package edu.nwafu.paper.service.impl;

import com.github.pagehelper.PageHelper;
import edu.nwafu.paper.beans.FillBlank;
import edu.nwafu.paper.mapper.FillBlankMapper;
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
public class FillBlankService implements ItemService {

    @Autowired
    private FillBlankMapper fillBlankMapper;

    @Autowired
    private KnowledgePointService knowledgePointService;
    @Autowired
    private ChapterService chapterService;

    @Override
    public List getItems(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<FillBlank> items = fillBlankMapper.selectAll();
        if (null != items) {
            return items;
        }
        return null;
    }

    @Override
    public void insert(BaseRequest request) {
        FillBlank fillBlank = new FillBlank();
        fillBlank.setDifficult(request.getDifficult());
        fillBlank.setCourseId(request.getCourseId());
        fillBlank.setPointId(request.getPointId());
        fillBlank.setQuestion(request.getQuestion());
        fillBlank.setAnswer(request.getAnswer());
        fillBlank.setFaq(request.getFaq());
        fillBlank.setScore(request.getScore());
        fillBlankMapper.insertSelective(fillBlank);
    }

    @Override
    public void delete(Integer id) {
        fillBlankMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(String str) {
        String[] ids = str.split(",");
        for (int i = 0; i < ids.length; i++) {
            fillBlankMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    @Override
    public void update(UpdateRequest request) {
        FillBlank fillBlank = fillBlankMapper.selectByPrimaryKey(request.getId());
        fillBlank.setDifficult(request.getDifficult());
        fillBlank.setCourseId(request.getCourseId());
        fillBlank.setPointId(request.getPointId());
        fillBlank.setQuestion(request.getQuestion());
        fillBlank.setAnswer(request.getAnswer());
        fillBlank.setFaq(request.getFaq());
        fillBlank.setScore(request.getScore());
        fillBlankMapper.updateByPrimaryKeySelective(fillBlank);
    }

    public List getFillBlankQuestion(){
        List<FillBlank> list = fillBlankMapper.selectAll();
        List<Map> mapList = new ArrayList<>();
        for (FillBlank fill: list) {
            Map map = new HashMap();
            map.put("id",fill.getId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(fill.getPointId()).getName());
            map.put("courseId",chapterService.getChapter(fill.getCourseId()).getName());
           map.put("question",fill.getQuestion());
           map.put("answer",fill.getAnswer());
           map.put("faq",fill.getFaq());
            map.put("score",fill.getScore());
            map.put("usageCount",fill.getUsageCount());
            map.put("difficult",fill.getDifficult());
           mapList.add(map);
        }
        return mapList;
    }

    public List getFillBlankQuestionByChapter(Integer chapter){
        List<FillBlank> list = fillBlankMapper.selectByChapter(chapter);
        List<Map> mapList = new ArrayList<>();
        for (FillBlank fill: list) {
            Map map = new HashMap();
            map.put("id",fill.getId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(fill.getPointId()).getName());
            map.put("courseId",chapterService.getChapter(fill.getCourseId()).getName());
            map.put("question",fill.getQuestion());
            map.put("answer",fill.getAnswer());
            map.put("faq",fill.getFaq());
            map.put("score",fill.getScore());
            map.put("usageCount",fill.getUsageCount());
            map.put("difficult",fill.getDifficult());
            mapList.add(map);
        }
        return mapList;
    }

    public List getFillBlankQuestionByPoint(Integer point){
        List<FillBlank> list = fillBlankMapper.selectByPoint(point);
        List<Map> mapList = new ArrayList<>();
        for (FillBlank fill: list) {
            Map map = new HashMap();
            map.put("id",fill.getId());
            map.put("knowledge",knowledgePointService.getKonwledgeById(fill.getPointId()).getName());
            map.put("courseId",chapterService.getChapter(fill.getCourseId()).getName());
            map.put("question",fill.getQuestion());
            map.put("answer",fill.getAnswer());
            map.put("faq",fill.getFaq());
            map.put("score",fill.getScore());
            map.put("usageCount",fill.getUsageCount());
            map.put("difficult",fill.getDifficult());
            mapList.add(map);
        }
        return mapList;
    }

    public FillBlank getFillBlankById(int id) {
        return fillBlankMapper.selectByPrimaryKey(id);
    }

    public int increaseUseCount(int id) {
        return fillBlankMapper.increaseUseCount(id);
    }
}
