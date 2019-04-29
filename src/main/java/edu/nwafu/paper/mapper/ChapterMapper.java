package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.Chapter;

public interface ChapterMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
}