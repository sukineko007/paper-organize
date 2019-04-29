package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.MultipleChoice;

import java.util.List;

public interface MultipleChoiceMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MultipleChoice record);

    int insertSelective(MultipleChoice record);

    MultipleChoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MultipleChoice record);

    int updateByPrimaryKey(MultipleChoice record);

    List<MultipleChoice> selectAll();

    List<MultipleChoice> selectByChapter(Integer chapter);

    List<MultipleChoice> selectByPoint(Integer point);

    int increaseUseCount(int id);
}