package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.PaperSnapshot;

public interface PaperSnapshotMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PaperSnapshot record);

    int insertSelective(PaperSnapshot record);

    PaperSnapshot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaperSnapshot record);

    int updateByPrimaryKey(PaperSnapshot record);
}