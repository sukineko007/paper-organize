package edu.nwafu.paper.service.impl;

import edu.nwafu.paper.beans.*;
import edu.nwafu.paper.mapper.*;
import edu.nwafu.paper.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author TinChiWay
 * @data 2018/5/3
 */
@Service
public class PaperInfoService {
    protected static final Logger logger = LoggerFactory.getLogger(PaperInfoService.class);

    @Autowired
    private PaperInfoMapper paperInfoMapper;

    @Autowired
    private SingleChoicMapper singleChoicMapper;//10001

    @Autowired
    private MultipleChoiceMapper multipleChoiceMapper;//10002

    @Autowired
    private FillBlankMapper fillBlankMapper;//10003

    @Autowired
    private TrueOrFalseMapper trueOrFalseMapper;//10004

    @Autowired
    private QuesAndAnsMapper quesAndAnsMapper;//10005

    public List getPaperInfo(Integer paperId){
        return paperInfoMapper.getPaperInfo(paperId);
    }

    //获取paper详细信息
    public PaperInfoModel getPapercompleteInfo(Integer paperId){

        List<PaperInfo> infoList = paperInfoMapper.getPaperInfo(paperId);
        Set<Integer> knowlageSet = new HashSet<>();

        PaperInfoModel paperInfoModel = new PaperInfoModel();

        for (PaperInfo info : infoList){
            if (info.getTypeId() == 10001){
                SingleChoic singleChoic = singleChoicMapper.selectByPrimaryKey(info.getQuestionId());
                SingleChoicViewModel model = new SingleChoicViewModel(singleChoic);
                model.setSerialNumber(info.getSerialNumber());
                paperInfoModel.addSingChioice(model);

                knowlageSet.add(singleChoic.getPointId());

            }
            if (info.getTypeId() == 10002){
                MultipleChoice multipleChoice = multipleChoiceMapper.selectByPrimaryKey(info.getQuestionId());
                MultipleChoiceViewModel model = new MultipleChoiceViewModel(multipleChoice);
                model.setSerialNumber(info.getSerialNumber());
                paperInfoModel.addMultipleChoice(model);

                knowlageSet.add(multipleChoice.getPointId());
            }
            if (info.getTypeId() == 10003){
                FillBlank fillBlank = fillBlankMapper.selectByPrimaryKey(info.getQuestionId());
                FillBlankViewModel model = new FillBlankViewModel(fillBlank);
                model.setSerialNumber(info.getSerialNumber());
                paperInfoModel.addFillBlank(model);

                knowlageSet.add(fillBlank.getPointId());
            }
            if (info.getTypeId() == 10004){
                TrueOrFalse trueOrFalse = trueOrFalseMapper.selectByPrimaryKey(info.getQuestionId());
                TrueOrFalseViewModel model = new TrueOrFalseViewModel(trueOrFalse);
                model.setSerialNumber(info.getSerialNumber());
                paperInfoModel.addTrueOrFalse(model);

                knowlageSet.add(trueOrFalse.getPointId());
            }
            if (info.getTypeId() == 10005){
                QuesAndAns quesAndAns = quesAndAnsMapper.selectByPrimaryKey(info.getQuestionId());
                QuesAndAnsViewModel model = new QuesAndAnsViewModel(quesAndAns);
                model.setSerialNumber(info.getSerialNumber());
                paperInfoModel.addQuesAndAns(model);

                knowlageSet.add(quesAndAns.getPointId());
            }
        }

        paperInfoModel.setKnowlageNum(knowlageSet.size());
        return paperInfoModel;

    }

    public int insertList(List<PaperInfo> paperInfoList) {
        return paperInfoMapper.insertList(paperInfoList);
    }

    public boolean output(int id, String name) throws FileNotFoundException {
        String paperPath = "E:\\paper\\" + id + ".txt";
        PrintWriter outputStream = null;
        
        PaperInfoModel model = getPapercompleteInfo(id);
        
        try {
            outputStream = new PrintWriter(new FileOutputStream(paperPath));
        }catch (Exception e ){
            logger.error("创建" + paperPath + "失败！");
            throw e;
        }

        outputStream.println(name);
        
        outputSingle(outputStream, model.getSingleChoicList(), model.getSingleChoicScore());
        outputMultiple(outputStream, model.getMultipleChoicList(), model.getMultipleChoicScore());
        outputFill(outputStream, model.getFillBlankList(), model.getFillBlankScore());
        outputTOrF(outputStream, model.getTrueOrFalseList(), model.getTrueOrFalseScore());
        outputQuesAndAns(outputStream, model.getQuesAndAnsList(), model.getQuesAndAnsScore());

        outputStream.close();
        return true;
    }

    private void outputQuesAndAns(PrintWriter outputStream, List<QuesAndAnsViewModel> quesAndAnsList, int score) {
        outputStream.println("五 问答题(总分：" + score + ")");
        for (QuesAndAnsViewModel model : quesAndAnsList){
            outputStream.println(model.getSerialNumber() + "分值：" + model.getScore());
            outputStream.println(model.getQuestion());
            outputStream.println("答案:" + model.getAnswer());
        }
        outputStream.println();
    }

    private void outputTOrF(PrintWriter outputStream, List<TrueOrFalseViewModel> trueOrFalseList, int score) {
        outputStream.println("四 判断题(总分：" + score + ")");
        for (TrueOrFalseViewModel model : trueOrFalseList){
            outputStream.println(model.getSerialNumber() + "分值：" + model.getScore());
            outputStream.println(model.getQuestion());
            outputStream.println("答案:" + model.getAnswer());
        }
        outputStream.println();

    }

    private void outputFill(PrintWriter outputStream, List<FillBlankViewModel> fillBlankList, int score) {
        outputStream.println("三 多选题(总分：" + score + ")");
        for (FillBlankViewModel model : fillBlankList){
            outputStream.println(model.getSerialNumber() + "分值：" + model.getScore());
            outputStream.println(model.getQuestion());
            outputStream.println("答案:" + model.getAnswer());
        }
        outputStream.println();
    }

    private void outputMultiple(PrintWriter outputStream, List<MultipleChoiceViewModel> multipleChoicList, int score) {
        outputStream.println("二 多选题(总分：" + score + ")");
        for (MultipleChoiceViewModel model : multipleChoicList){
            outputStream.println(model.getSerialNumber() + "分值：" + model.getScore());
            outputStream.println(model.getQuestion());
            outputStream.println(model.getA());
            outputStream.println(model.getB());
            outputStream.println(model.getC());
            outputStream.println(model.getD());
            outputStream.println(model.getE());
            outputStream.println("答案:" + model.getAnswer());
        }
        outputStream.println();
    }

    private void outputSingle(PrintWriter outputStream, List<SingleChoicViewModel> singleChoicList, int score) {
        outputStream.println("一 单选题 (总分：" + score + ")");
        for (SingleChoicViewModel model : singleChoicList){
            outputStream.println(model.getSerialNumber());
            outputStream.println(model.getQuestion());
            outputStream.println("分值：" + model.getScore());
            outputStream.println(model.getA());
            outputStream.println(model.getB());
            outputStream.println(model.getC());
            outputStream.println(model.getD());
            outputStream.println("答案:" + model.getAnswer());
        }
        outputStream.println();
    }
}
