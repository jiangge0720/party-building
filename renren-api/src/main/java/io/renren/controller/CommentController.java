package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.common.xss.XssHttpServletRequestWrapper;
import io.renren.entity.Comment;
import io.renren.entity.Topic;
import io.renren.entity.UserEntity;
import io.renren.service.CommentService;
import io.renren.service.TopicService;
import io.renren.utils.IdUtils;
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
 * 2018/7/2010:45
 */
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private TopicService topicService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public JiangPage list(@RequestParam Map<String, Object> params){
        JiangPage page = commentService.queryPage(params);

        return page;
    }

    /**
     * 发布評論
     */
    @Login
    @RequestMapping("/add")
    public R add (HttpServletRequest request, @LoginUser UserEntity user){
        HttpServletRequest orgRequest = XssHttpServletRequestWrapper.getOrgRequest(request);
        String content = orgRequest.getParameter("content");
        Integer topicId = Integer.parseInt(orgRequest.getParameter("topicId"));
        String xuehao = user.getXuehao();

        Assert.isBlank(content, "内容不能为空");

        Comment entity = new Comment();
        Topic topic = topicService.selectById(topicId);
        Integer topiccount = topic.getCommentCount();
        entity.setContent(content);
        entity.setUserId(xuehao);
        entity.setTopicId(topicId);
        topic.setCommentCount(topiccount+1);

        commentService.insertComment(entity);
        topicService.updateById(topic);

        return R.ok();
    }

    /**
     * 查询话题评论数量
     */
    @RequestMapping("/cmtcount")
    public R findOne(@RequestParam("topicId") int topicId){
        Integer cmtcount = commentService.getCommentCount(topicId);
        List cmtcontent = commentService.getCommentContent(topicId);
        return R.ok().put("cmtcount",cmtcount).put("cmtcontent",cmtcontent);
    }



    /**
     * 删除
     */
    @Login
    @RequestMapping("/delete")
    public R delete(@RequestParam("id")String id,@LoginUser UserEntity user){
        String xuehao = commentService.selectById(id).getUserId();
        Comment comment = commentService.selectById(id);
        if(user.getXuehao().equals(xuehao))
        {
            commentService.deleteComment(comment);
            return R.ok();
        }


        else {
            String msg = "无法删除";
            return R.error(msg);
        }
    }
}