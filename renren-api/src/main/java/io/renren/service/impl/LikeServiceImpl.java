package io.renren.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.LikeDao;
import io.renren.dao.TopicDao;
import io.renren.entity.Like;
import io.renren.service.LikeService;
import io.renren.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jiang-gege
 * 2018/9/1213:17
 */
@Service
public class LikeServiceImpl extends ServiceImpl<LikeDao,Like> implements LikeService{

    @Autowired
    private LikeDao likeDao;

    @Override
    public void cancleLike(int topicId) {

        likeDao.cancleLike(topicId);
    }
}