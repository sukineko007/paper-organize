package edu.nwafu.paper.service;

import edu.nwafu.paper.beans.KnowledgePoint;
import edu.nwafu.paper.mapper.KnowledgePointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PointService {

    @Autowired
    private KnowledgePointMapper knowledgePointMapper;

    public List getPoint(String chapterId){
        List<KnowledgePoint> list = knowledgePointMapper.getPoint(chapterId);
        List<Map> mapList = new ArrayList<>();
        for(KnowledgePoint knowledgePoint : list){
            Map map = new HashMap();
            map.put("id",knowledgePoint.getId());
            map.put("value",knowledgePoint.getName());
            mapList.add(map);
        }
        return mapList;
    }
}
