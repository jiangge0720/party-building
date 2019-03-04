package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.R;
import io.renren.common.xss.XssHttpServletRequestWrapper;
import io.renren.entity.*;
import io.renren.service.ExamPaperService;
import io.renren.service.ExamQuestionsService;
import io.renren.service.ExamUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/1416:01
 */
@RestController
@RequestMapping("/api/paper")
public class ExamPaperController {
    @Autowired
    private ExamPaperService examPaperService;

    @Autowired
    private ExamQuestionsService examQuestionsService;

    @Autowired
    private ExamUserService examUserService;

    /**
     * 获取试卷并储存信息
     */
    @Login
    @RequestMapping("/list")
    public R list(HttpServletRequest request, @LoginUser UserEntity user){
        HttpServletRequest orgRequest = XssHttpServletRequestWrapper.getOrgRequest(request);
        Integer paperId = Integer.parseInt(orgRequest.getParameter("paperId"));
//        Integer current = Integer.parseInt(orgRequest.getParameter("current"));
//        Integer next = Integer.parseInt(orgRequest.getParameter("next"));
//        String answer = orgRequest.getParameter("answer");
        ExamPaper examPaper = examPaperService.selectById(paperId);
        String PaperContent = examPaper.getPaperContent();
        String[] arr = PaperContent.split(",");           //字符串转数组 用,分割
        //ExamQuestions curExamQuestions = examQuestionsService.selectById(arr[current]);
//        ExamQuestions nextExamQuestions = examQuestionsService.selectById(arr[next-1]);
//
//        Long userId = user.getId();
//        ExamUser examUser = examUserService.SelectExamWithUser(userId);
//        String arr2[] = new String[20];
//        arr2[current-1] = answer;
//        String answer2 = StringUtils.join(arr2, ","); // 数组转字符串
        //System.out.println(answer2); // 0,1,2,3,4,5
//        examUser.setUserPaperContent(answer2);
//        examUserService.updateById(examUser);
//
//        return R.ok().put("nextExamQuestions",nextExamQuestions);

        List<ExamQuestions> list = new ArrayList<ExamQuestions>();
        for(int i=0;i<arr.length;i++){
            ExamQuestions questionsContent = examQuestionsService.selectById(arr[i]);
            list.add(questionsContent);
        }
        return R.ok().put("list",list);
    }

    /**
     * 提交试卷并且批改
     */
    @Login
    @RequestMapping("/submit")
    @ResponseBody
    public R submit(@RequestBody AnswerVo answer, @LoginUser UserEntity user) {

        Integer num = 0;
        Long userId = user.getId();
        ExamUser examUser = examUserService.SelectExamWithUser(userId);
        ExamPaper examPaper = examPaperService.selectById(examUser.getExamId());
        Answer[]answers = answer.getAnswer();
       // List转字符串，用逗号隔开

        List<String> list = new ArrayList<String>();

        for(Answer answer1:answers){
            String answer2 = answer1.getAnswer();
            list.add(answer2);
        }                                                  //answer数组转list

        String str=String.join(",", list);         //list转字符串；

        //批改试卷
        String PaperContent = examPaper.getPaperContent();
        String[] arr = PaperContent.split(",");       //字符串转数组

        String[] string2 = str.split(",");            //字符串转数组

        for(int i=0;i<list.size();i++){        //对比答案

            if(string2[i].equals(examQuestionsService.selectById(arr[i]).getQuestionsAnswer())==true)
                num++;
        }
        //System.out.println(num);

        Integer passScore = examPaper.getPaperPass();
        Integer score = num*10;

        examUser.setUserEndtime(new Date());
        examUser.setUserPaperContent(str);
        examUser.setUserScore(score);
        examUserService.updateById(examUser);

        return R.ok().put("examUser",examUser);

    }
}