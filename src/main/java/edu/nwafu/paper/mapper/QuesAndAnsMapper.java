package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.QuesAndAns;

import java.util.List;

public interface QuesAndAnsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(QuesAndAns record);

    int insertSelective(QuesAndAns record);

    QuesAndAns selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuesAndAns record);

    int updateByPrimaryKey(QuesAndAns record);

    List<QuesAndAns> selectAll();

    List<QuesAndAns> selectByChapter(Integer chapter);

    List<QuesAndAns> selectByPoint(Integer point);

    int increaseUseCount(int id);
}