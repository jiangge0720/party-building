package io.renren.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.CommentDao;
import io.renren.entity.Comment;
import io.renren.entity.Topic;
import io.renren.service.CommentService;
import io.renren.utils.JiangPage;
import io.renren.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/208:38
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentDao,Comment> implements CommentService{

    @Autowired
    private CommentDao commentDao;

    @Override
    public JiangPage queryPage(Map<String, Object> params) {
        Page<Comment> page = this.selectPage(
                new Query<Comment>(params).getPage(),
                new EntityWrapper<Comment>()
        );

        return new JiangPage(page.getRecords(), page.getTotal());
    }

    @Override
    public void insertComment(Comment comment) {
        commentDao.insertComment(comment);
    }

    @Override
    public int getCommentCount(int topicId) {
        return commentDao.getCommentCount(topicId);
    }

    @Override
    public List getCommentContent(int topicId) {
        return commentDao.getCommentContent(topicId);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentDao.deleteComment(comment);
    }
}