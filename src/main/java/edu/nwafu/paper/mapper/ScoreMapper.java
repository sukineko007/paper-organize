package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.Score;

public interface ScoreMapper {

    int insert(Score record);

    int insertSelective(Score record);

}