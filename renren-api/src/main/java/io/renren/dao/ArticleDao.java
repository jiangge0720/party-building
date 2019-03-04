package io.renren.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/7/1710:49
 */
@Mapper
public interface ArticleDao extends BaseMapper<Article> {

    void insertArticle(Article article);

    int getArticleCount();

    List selectArticle(@Param("id") Integer id);


}
