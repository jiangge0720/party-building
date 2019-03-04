package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.R;
import io.renren.entity.Like;
import io.renren.entity.Topic;
import io.renren.entity.UserEntity;
import io.renren.service.LikeService;
import io.renren.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jiang-gege
 * 2018/9/1213:20
 */
@RestController
@RequestMapping("/api/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private TopicService topicService;

    @Login
    @RequestMapping("/likeone")
    public R likeone(@RequestParam("topicId") int topicId, @LoginUser UserEntity user){
        Like like = new Like();
        Topic topic = topicService.selectById(topicId);
        Integer likeCount = topic.getLikeCount();
        like.setTopicId(topicId);
        like.setUserId(user.getId());
        Integer likeCount2 = likeCount+1;
        topic.setLikeCount(likeCount2);

        likeService.insert(like);
        topicService.updateById(topic);

        return R.ok().put("likeCount2",likeCount2);
    }

    @Login
    @RequestMapping("/cancle")
    public R cancle(@RequestParam("topicId") int topicId, @LoginUser UserEntity user){
        Topic topic = topicService.selectById(topicId);
        Integer likeCount = topic.getLikeCount()-1;
        topic.setLikeCount(likeCount);
       // Like like = likeService.selectById(topicId);
        topicService.updateById(topic);
        likeService.cancleLike(topicId);
        return R.ok().put("likeCount",likeCount);

    }
}