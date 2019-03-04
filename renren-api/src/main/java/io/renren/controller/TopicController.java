package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.common.xss.XssHttpServletRequestWrapper;
import io.renren.entity.Article;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/209:11
 */
@RestController
@RequestMapping("/api/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @Autowired
    private CommentService commentService;


    /**
     * 列表
     */
    @RequestMapping("/list")
    public JiangPage list(@RequestParam Map<String, Object> params){
        JiangPage page =topicService.queryPage(params);

        return page;
    }


    /**
     * 话题详细内容
     *
     */

    @RequestMapping("/showtopic")
    public R topic(@RequestParam("topicId") int topicId){
        Topic topic = topicService.selectById(topicId);
        Integer cmtcount = commentService.getCommentCount(topicId);
        List cmtcontent = commentService.getCommentContent(topicId);
        return R.ok().put("topic",topic).put("cmtcount",cmtcount).put("cmtcontent",cmtcontent);
    }

    /**
     * 发布話題
     */
    @Login
    @RequestMapping("/add")
    public R add (HttpServletRequest request, @LoginUser UserEntity user){
        HttpServletRequest orgRequest = XssHttpServletRequestWrapper.getOrgRequest(request);
        String title = orgRequest.getParameter("title");
        String content = orgRequest.getParameter("content");
//        String image = orgRequest.getParameter("image");
        Integer groupId = Integer.parseInt(orgRequest.getParameter("groupId"));


        Assert.isBlank(title, "标题不能为空");
        Assert.isBlank(content, "内容不能为空");

        Topic entity = new Topic();
        entity.setTitle(title);
        entity.setContent(content);
        entity.setGroupId(groupId);
        entity.setCommentCount(0);
//        entity.setImage(image);
        entity.setUserName(user.getName());
        entity.setUserId(user.getId());
        entity.setLikeCount(0);
        entity.setCreatedDate(new Date());
        entity.setState("A");

        topicService.insertTopic(entity);

        return R.ok();
    }

    /**
     * 查询話題
     */
    @RequestMapping("/findOne")
    public R findOne(@RequestParam("id") String id){
        Topic topic = topicService.selectById(id);
        return R.ok().put("topic",topic);
    }

    /**
     * 删除
     */
    @Login
    @RequestMapping("/delete")
    public R delete(@RequestParam("id")String id, @LoginUser UserEntity user){
        Topic topic = topicService.selectById(id);
        topicService.deleteTopic(topic);
        return R.ok();
    }


}