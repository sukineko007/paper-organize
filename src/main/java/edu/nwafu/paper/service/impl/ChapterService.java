package edu.nwafu.paper.service.impl;

import edu.nwafu.paper.beans.Chapter;
import edu.nwafu.paper.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    public Chapter getChapter(Integer id){
        return chapterMapper.selectByPrimaryKey(id);
    }

}
