package io.renren.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/7/208:35
 */
@Mapper
public interface CommentDao extends BaseMapper<Comment> {
    void insertComment(Comment comment);

    // List<Comment> getCommentCount(@Param("topicId") int topicId);
    int getCommentCount(@Param("topicId") int topicId);

    List getCommentContent(@Param("topicId") int topicId);

    void deleteComment(Comment comment);
}