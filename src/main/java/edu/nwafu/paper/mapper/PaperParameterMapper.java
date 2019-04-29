package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.PaperParameter;

public interface PaperParameterMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PaperParameter record);

    int insertSelective(PaperParameter record);

    PaperParameter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaperParameter record);

    int updateByPrimaryKey(PaperParameter record);
}