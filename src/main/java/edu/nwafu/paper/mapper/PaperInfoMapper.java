package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.PaperInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PaperInfo record);

    int insertSelective(PaperInfo record);

    PaperInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaperInfo record);

    int updateByPrimaryKey(PaperInfo record);

    List getPaperInfo(Integer paperId);

    int insertList(@Param("paperInfoList") List<PaperInfo> paperInfoList);
}