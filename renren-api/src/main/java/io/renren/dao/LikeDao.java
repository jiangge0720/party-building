package io.renren.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.entity.Like;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Jiang-gege
 * 2018/9/1114:14
 */
@Mapper
public interface LikeDao extends BaseMapper<Like> {

    void cancleLike(@Param("topicId") int topicId);
}
