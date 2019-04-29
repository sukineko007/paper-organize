package edu.nwafu.paper.controller;

import edu.nwafu.paper.beans.Paper;
import edu.nwafu.paper.service.impl.PaperService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    PaperService paperService;

    @PostMapping("/deletepaper")
    public Object deletePaperById(int id) {
        JSONObject jsonObject = new JSONObject();

        int res = paperService.deleteByPrimaryKey(id);
        if (res == 1){
            jsonObject.element("msg", "删除成功");
        }else {
            jsonObject.element("msg", "删除失败");
        }
        return jsonObject;
    }

    @PostMapping("/getpaperwithuserid")
    public Object getpapersWithUserId(int userId) {
        JSONObject jsonObject = new JSONObject();

        List<Paper> paperList = paperService.getPaperWithUserId(userId);

        jsonObject.element("stat", "ok");
        jsonObject.element("data", paperList);
        return jsonObject;
    }

    @PostMapping("/getalltestpaper")
    public Object getAllTestPaper() {
        JSONObject jsonObject = new JSONObject();

        List<Paper> paperList = paperService.getAllPaper();
        jsonObject.element("stat", "ok");
        jsonObject.element("data", paperList);

        return jsonObject;
    }

    @PostMapping("/gettestpaperwithstat")
    public Object getSubmitTestPaper(int stat) {
        JSONObject jsonObject = new JSONObject();

        List<Paper> paperList = paperService.getPaperWithStat(stat);
        jsonObject.element("stat", "ok");
        jsonObject.element("data", paperList);

        return jsonObject;
    }

    @PostMapping("/approve")
    public Object approvePaper(int paperId, int userId) {
        JSONObject jsonObject = new JSONObject();
        if (paperService.approvePaper(paperId, userId) == 1) {
            jsonObject.element("stat", "ok");
            jsonObject.element("msg", "审核通过");
            return jsonObject;
        }
        jsonObject.element("stat", "no");
        return jsonObject;
    }

    @PostMapping("/auditnotpassed")
    public Object auditNotPassed(int paperId, int userId) {
        JSONObject jsonObject = new JSONObject();
        if (paperService.auditNotPassed(paperId, userId) == 1) {
            jsonObject.element("stat", "ok");
            jsonObject.element("msg", "审核不通过");
            return jsonObject;

        }
        jsonObject.element("stat", "no");
        return jsonObject;

    }

    @GetMapping("/getPapers")
    public Object getPaper(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",paperService.getPaperWith(1));
        return map;
    }

}
