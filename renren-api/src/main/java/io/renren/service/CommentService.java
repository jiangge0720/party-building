package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.Comment;
import io.renren.utils.JiangPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/208:37
 */
public interface CommentService extends IService<Comment> {
    JiangPage queryPage(Map<String, Object> params);

    void insertComment(Comment comment);

    int getCommentCount(int topicId);

    List getCommentContent(@Param("topicId") int topicId);

    void deleteComment(Comment comment);
}
