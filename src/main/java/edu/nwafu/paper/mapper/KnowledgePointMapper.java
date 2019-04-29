package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.KnowledgePoint;

import java.util.List;

public interface KnowledgePointMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(KnowledgePoint record);

    int insertSelective(KnowledgePoint record);

    KnowledgePoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KnowledgePoint record);

    int updateByPrimaryKeyWithBLOBs(KnowledgePoint record);

    int updateByPrimaryKey(KnowledgePoint record);

    List<KnowledgePoint> getPoint(String chapterId);
}