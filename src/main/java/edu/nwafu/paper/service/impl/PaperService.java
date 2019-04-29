package edu.nwafu.paper.service.impl;

import edu.nwafu.paper.beans.Paper;
import edu.nwafu.paper.beans.User;
import edu.nwafu.paper.mapper.PaperMapper;
import edu.nwafu.paper.mapper.UserMapper;
import edu.nwafu.paper.model.PaperStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TinChiWay
 * @data 2018/5/2
 */
@Service
public class PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private UserMapper userMapper;

    public int deleteByPrimaryKey(Integer id){
        return paperMapper.deleteByPrimaryKey(id);
    }

    public int insertSelective(Paper paper){
        return paperMapper.insertSelective(paper);
    }


    public List<Paper> getPaperWithUserId(Integer id) {
        List<Paper> list = paperMapper.selectWithUserId(id);

        formatPaperList(list);

        return list;
    }

    private void formatPaperList(List<Paper> list) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Paper paper : list){

            String data = dateFormat.format(paper.getCreateTime());
            paper.setCreateTimeFormat(data);

            User creator = userMapper.selectByPrimaryKey(paper.getCreatorId());
            paper.setCreator(creator.getName());

            if (paper.getReviewerId() != null) {
                User reviewerId = userMapper.selectByPrimaryKey(paper.getReviewerId());
                paper.setReviewer(reviewerId.getName());
            } else {
                paper.setReviewer("未审核");
            }

            String status = PaperStatus.getName(paper.getState());
            paper.setStatus(status);


        }
    }

    public List<Paper> getAllPaper() {
        List<Paper> list = paperMapper.selectAll();

        formatPaperList(list);

        return list;
    }

    public int approvePaper(int paperId, int userId) {
        Paper paper = paperMapper.selectByPrimaryKey(paperId);
        if (paper == null){
            return 0;
        }

        paper.setState(PaperStatus.APPROVED.ordinal());
        paper.setReviewerId(userId);

        return paperMapper.updateByPrimaryKeySelective(paper);
    }

    public int auditNotPassed(int paperId, int userId) {
        Paper paper = paperMapper.selectByPrimaryKey(paperId);
        if (paper == null){
            return 0;
        }

        paper.setState(PaperStatus.AUDITNOTPASSED.ordinal());
        paper.setReviewerId(userId);

        return paperMapper.updateByPrimaryKeySelective(paper);
    }

    public Paper getPaper(int paperId) {
        return paperMapper.selectByPrimaryKey(paperId);
    }

    public int submitreview(int paperId) {

        Paper paper = paperMapper.selectByPrimaryKey(paperId);
        paper.setState(PaperStatus.SUBMITFORREVIEW.ordinal());

        return paperMapper.updateByPrimaryKeySelective(paper);
    }

    public int cancelreview(int paperId) {
        Paper paper = paperMapper.selectByPrimaryKey(paperId);
        paper.setState(PaperStatus.UNSUBMIT.ordinal());

        return paperMapper.updateByPrimaryKeySelective(paper);
    }

    public List<Paper> getPaperWithStat(int stat) {
        List<Paper> paperList = paperMapper.selectWithStat(stat);
        formatPaperList(paperList);
        return paperList;
    }

    public List getPaperWith(int stat){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Paper> paperList = paperMapper.selectWithStat(stat);
        List<Map> mapList = new ArrayList<>();
        for(Paper paper : paperList){
            Map map = new HashMap();
            map.put("id",paper.getId());
            map.put("name",paper.getName());
            map.put("time",dateFormat.format(paper.getCreateTime()));
            mapList.add(map);
        }
        return mapList;
    }
}
