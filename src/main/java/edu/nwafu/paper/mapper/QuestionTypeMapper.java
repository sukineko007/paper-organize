package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.QuestionType;

public interface QuestionTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionType record);

    int insertSelective(QuestionType record);

    QuestionType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionType record);

    int updateByPrimaryKey(QuestionType record);
}