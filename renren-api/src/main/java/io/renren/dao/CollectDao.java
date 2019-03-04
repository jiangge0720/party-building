package io.renren.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.entity.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/7/2315:57
 */
@Mapper
public interface CollectDao extends BaseMapper<Collect> {
    void insertCollect(Collect collect);

    int getCollectCount(@Param("articleId") int articleId);

    List selectMyCollect(@Param("userId") String userId);

    void cancleCollect(@Param("articleId") int articleId);





}
