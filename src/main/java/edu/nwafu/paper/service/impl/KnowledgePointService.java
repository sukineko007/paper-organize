package edu.nwafu.paper.service.impl;

import edu.nwafu.paper.beans.KnowledgePoint;
import edu.nwafu.paper.mapper.KnowledgePointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author TinChiWay
 * @data 2018/5/24
 */

@Service
public class KnowledgePointService {

    @Autowired
    KnowledgePointMapper knowledgePointMapper;

    public KnowledgePoint getKonwledgeById(int id){
        return knowledgePointMapper.selectByPrimaryKey(id);
    }

}
