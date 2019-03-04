package io.renren.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.entity.Article;
import io.renren.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jiang-gege
 * 2018/7/1916:45
 */
@Mapper
public interface TopicDao extends BaseMapper<Topic>{
    //添加话题
    void insertTopic(Topic topic);

    void deleteTopic(Topic topic);

}