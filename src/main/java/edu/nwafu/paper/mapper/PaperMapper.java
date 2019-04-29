package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.Paper;

import java.util.List;


public interface PaperMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    List<Paper> selectWithUserId(int userId);

    List<Paper> selectAll();

    List<Paper> selectWithStat(int stat);
}