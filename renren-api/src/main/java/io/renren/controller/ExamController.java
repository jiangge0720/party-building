package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.R;
import io.renren.common.xss.XssHttpServletRequestWrapper;
import io.renren.entity.Exam;
import io.renren.entity.ExamUser;
import io.renren.entity.UserEntity;
import io.renren.service.ExamService;
import io.renren.service.ExamUserService;
import io.renren.utils.JiangPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/9/712:45
 */
@RestController
@RequestMapping("/api/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamUserService examUserService;

    /**
     * 列表
     */
    @Login
    @RequestMapping("/list")
    public JiangPage list(@RequestParam Map<String, Object> params){
        JiangPage page =examService.queryPage(params);
        return page;
    }

    /**
     * 考场详情
     */
    @Login
    @RequestMapping("/xiangqing")
    public R xiangqing(@RequestParam("examId") Integer examId){
        Exam exam = examService.selectById(examId);
        return R.ok().put("exam",exam);
    }

    /**
     * 添加
     */
    @Login
    @RequestMapping("/addexam")
    public R addexam(HttpServletRequest request, @LoginUser UserEntity user){

        HttpServletRequest orgRequest = XssHttpServletRequestWrapper.getOrgRequest(request);
        Integer examId = Integer.parseInt(orgRequest.getParameter("examId"));
        ExamUser examUser = new ExamUser();
        examUser.setExamId(examId);
        examUser.setUserId(user.getId());
        examUserService.insertExamUser(examUser);
        return R.ok();
    }


}