package edu.nwafu.paper.controller;

import edu.nwafu.paper.model.PaperInfoModel;
import edu.nwafu.paper.service.impl.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/download")
public class downloadController {
    @Autowired
    private SingleChoiceService singleChoiceService;

    @Autowired
    private MultipleChoiceService multipleChoiceService;

    @Autowired
    private FillBlankService fillBlankService;

    @Autowired
    private TrueOrFalseService trueOrFalseServicel;

    @Autowired
    private QuesAndAnsService quesAndAnsService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperInfoService paperInfoService;

    @GetMapping("/answer/{id}")
    public ResponseEntity<byte[]> download(@PathVariable int id) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String suffix = df.format(new Date());
        String paperName = paperService.getPaper(id).getName();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        PaperInfoModel model = paperInfoService.getPapercompleteInfo(id);
        dataMap.put("paperName", paperService.getPaper(id).getName()+"(参考答案)");
        dataMap.put("singleList", model.getSingleChoicList());
        dataMap.put("muiltList", model.getMultipleChoicList());
        dataMap.put("fillList", model.getFillBlankList());
        dataMap.put("judgeList", model.getTrueOrFalseList());
        dataMap.put("questionList", model.getQuesAndAnsList());
        MDoc mdoc = new MDoc();
        mdoc.createDoc(dataMap, "D:/template/" + suffix + "_" + paperName+ "_答案.doc");
        System.out.println("模板生成成功");
        String filePath = "D:/template/" + suffix + "_" + paperName+ "_答案.doc";
        File file = new File(filePath);
        String fileName = new String(file.getName().getBytes("utf-8"), "ISO-8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    @GetMapping("/paper/{id}")
    public ResponseEntity<byte[]> Paper(@PathVariable int id) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String suffix = df.format(new Date());
        String paperName = paperService.getPaper(id).getName();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        PaperInfoModel model = paperInfoService.getPapercompleteInfo(id);
        dataMap.put("paperName", paperService.getPaper(id).getName());
        dataMap.put("singleList", model.getSingleChoicList());
        dataMap.put("muiltList", model.getMultipleChoicList());
        dataMap.put("fillList", model.getFillBlankList());
        dataMap.put("judgeList", model.getTrueOrFalseList());
        dataMap.put("questionList", model.getQuesAndAnsList());
        MDoc mdoc = new MDoc();
        mdoc.createDoc2(dataMap, "D:/template/" +suffix + "_" +paperName+"_试卷.doc");
        System.out.println("模板生成成功");
        String filePath = "D:/template/" +suffix + "_" + paperName+"_试卷.doc";
        File file = new File(filePath);
        String fileName = new String(file.getName().getBytes("utf-8"), "ISO-8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
