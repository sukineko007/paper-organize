package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.SingleChoic;

import java.util.List;

public interface SingleChoicMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SingleChoic record);

    int insertSelective(SingleChoic record);

    SingleChoic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SingleChoic record);

    int updateByPrimaryKey(SingleChoic record);

    List<SingleChoic> selectAll();

    List<SingleChoic> selectByChapter(Integer chapter);

    List<SingleChoic> selectByPoint(Integer point);

    int increaseUseCount(int id);
}